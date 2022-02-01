package dov.com.qq.im.aeeditor.module.edit;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.callback.StickerLyricCallback;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.Util;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.data.MusicData;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightTemplate;
import com.tencent.weseevideo.model.template.movie.MovieSegmentModel;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.data.AEAlbumVideoModel;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.report.AEEditReportData;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.aeeditor.AEEditorLauncher;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.CACHE;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.FILES;
import dov.com.qq.im.aeeditor.AEEditorProcessManager;
import dov.com.qq.im.aeeditor.manage.AEEditorDataServiceHandler;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroup;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterDataCache;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterProxyBase;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.SilentVideoAIFilterProxy;
import dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterProxy;
import dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterResult;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateBean;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.FilterControlListener;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import dov.com.qq.im.aeeditor.module.filter.AEFilterExtendBean;
import dov.com.qq.im.aeeditor.module.filter.FilterChangedComparator;
import dov.com.qq.im.aeeditor.module.music.AEEditorLyricPanelDialog.OperationCallback;
import dov.com.qq.im.aeeditor.module.music.AEEditorLyricProgressCalculator;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadCallback;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanel.OperationCallback;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicVolumePanelDialog.OperationCallback;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.qq.im.aeeditor.module.params.ParamsUtil;
import dov.com.qq.im.aeeditor.module.params.VideoParamStrategy;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextPart.AEEditorTextDialogListener;
import dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar.VideoToolBarListener;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import dov.com.qq.im.aeeditor.util.AELocalMediaInfoUtil;
import dov.com.qq.im.aeeditor.util.TimeUtils;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.light.LightAsset;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp>, FrameVideoHelper.GetFrameByteArrayListener, StickerLyricCallback, AEEditorAIFilterManager.AIFilterObserver, AEEditorFilterControlPanel.FilterControlListener, AEEditorLyricPanelDialog.OperationCallback, AEEditorMusicHelper.MusicDownloadCallback, AEEditorMusicPanel.OperationCallback, AEEditorMusicVolumePanelDialog.OperationCallback, VideoEditToolBar.VideoToolBarListener
{
  private static final String e;
  public static boolean h = false;
  protected float a;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  protected Size a;
  protected MoviePlayer a;
  protected TAVCutVideoSession a;
  protected TAVCutVideoView a;
  protected MusicData a;
  private SubtitleModel jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel;
  protected AIFilterDataCache a;
  public VideoAIFilterResult a;
  protected AEEditorAutoTemplateBean a;
  protected AEEditorAutoTemplateLoadingView a;
  private AEEditorAutoTemplatePanel jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel;
  private AEEditorMusicControlPanel jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel;
  protected AEEditorMusicAdapter.AEEditorMusicInfo a;
  protected VideoParamStrategy a;
  private AEEditorTextBean jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean = null;
  protected AEEditorQcircleBubbleView a;
  private Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger = null;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AEEditorVideoEditFragment.15(this);
  protected ArrayList<String> a;
  private HashMap<Integer, Float> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private CopyOnWriteArrayList<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  protected float b;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected Size b;
  protected AEEditorMusicAdapter.AEEditorMusicInfo b;
  protected AEEditorQcircleBubbleView b;
  private Integer jdField_b_of_type_JavaLangInteger = null;
  private final Runnable jdField_b_of_type_JavaLangRunnable = new AEEditorVideoEditFragment.16(this);
  private CopyOnWriteArrayList<String> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private CopyOnWriteArrayList<Bitmap> jdField_c_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  protected boolean c;
  protected String d;
  protected boolean d;
  protected boolean e;
  private String f;
  protected boolean f;
  private String g;
  protected boolean g;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  
  static
  {
    jdField_e_of_type_JavaLangString = AEEditorVideoEditFragment.class.getSimpleName();
    File localFile = new File(AEEditorPath.EDITOR.CACHE.jdField_c_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public AEEditorVideoEditFragment()
  {
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = null;
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.8F;
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
    this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache = new AIFilterDataCache();
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy = ParamFactory.a();
    this.jdField_g_of_type_JavaLangString = "";
  }
  
  private void Q()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AEEditorVideoEditFragment.1(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void R()
  {
    if ((!this.k) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.l))
    {
      this.k = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void S()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
  }
  
  private void T()
  {
    Bundle localBundle = getArguments();
    boolean bool = ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
    localBundle.putBoolean("ae_editor_is_light_model", bool);
    if (AEEditorLauncher.b(getArguments()))
    {
      if (bool)
      {
        localObject = ((MediaClipModel)a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel()).getVideos().get(0)).getResource();
        if (localObject != null)
        {
          l1 = ((VideoResourceModel)localObject).getSelectTimeStartUs();
          l2 = ((VideoResourceModel)localObject).getSelectTimeDurationUs();
          getArguments().putLong("starttime", l1);
          getArguments().putLong("endtime", l2 + l1);
          getArguments().putFloat("speed", 1.0F);
        }
      }
      do
      {
        a().a(this, a(), localBundle);
        return;
        localObject = ((MediaClipModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource();
      } while (localObject == null);
      long l4 = ((VideoResourceModel)localObject).getSelectTimeStartUs();
      long l3 = ((VideoResourceModel)localObject).getSelectTimeDurationUs();
      long l2 = l3;
      long l1 = l4;
      if (this.jdField_a_of_type_JavaLangFloat != null)
      {
        l1 = ((float)l4 / this.jdField_a_of_type_JavaLangFloat.floatValue());
        l2 = ((float)l3 / this.jdField_a_of_type_JavaLangFloat.floatValue());
      }
      getArguments().putLong("starttime", l1);
      getArguments().putLong("endtime", l2 + l1);
      Object localObject = getArguments();
      if (this.jdField_a_of_type_JavaLangFloat != null) {}
      for (float f1 = this.jdField_a_of_type_JavaLangFloat.floatValue();; f1 = 1.0F)
      {
        ((Bundle)localObject).putFloat("speed", f1);
        break;
      }
    }
    a().b(this, a(), localBundle);
  }
  
  private void U()
  {
    AEBaseReportParam.a().a().i = 0;
    AEBaseDataReporter.a().j();
  }
  
  private void V()
  {
    boolean bool;
    if ((d()) && (this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.getVisibility() == 0))
    {
      bool = true;
      if (!h) {
        break label36;
      }
      n(bool);
    }
    label36:
    while (!bool)
    {
      return;
      bool = false;
      break;
    }
    W();
  }
  
  private void W()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView == null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView = new AEEditorQcircleBubbleView(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.post(new AEEditorVideoEditFragment.13(this));
  }
  
  private void X()
  {
    int n = 0;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null)
    {
      AEBaseReportParam.a().a().jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().size();
      Object localObject1 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList();
      a((List)localObject1, 0);
      a((List)localObject1);
      String str = "none";
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a() != null) {
        str = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a().getEffectId();
      }
      Object localObject2 = new StringBuilder();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StickerModel)((Iterator)localObject1).next();
        if (!((StringBuilder)localObject2).toString().equals("")) {
          ((StringBuilder)localObject2).append(",");
        }
        ((StringBuilder)localObject2).append(((StickerModel)localObject3).getMaterialId());
      }
      localObject2 = new String((StringBuilder)localObject2);
      localObject1 = localObject2;
      if (((String)localObject2).isEmpty()) {
        localObject1 = "none";
      }
      Object localObject3 = "none";
      localObject2 = localObject3;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null)
      {
        localObject2 = localObject3;
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a() != null) {
          localObject2 = String.valueOf(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a().mItemId);
        }
      }
      localObject3 = "none";
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean != null) {
        localObject3 = this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean.id;
      }
      int i1 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().size();
      if (this.jdField_a_of_type_Float != 0.0F) {
        n = 1;
      }
      AEReportUtils.a(str, (String)localObject1, (String)localObject2, (String)localObject3, String.valueOf(i1), String.valueOf(n));
    }
    AEBaseDataReporter.a().i();
  }
  
  private void Y()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel == null) && (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null))
    {
      localObject2 = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.d();
      if (b((String)localObject2)) {}
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = new SubtitleModel();
      ((SubtitleModel)localObject1).setAssetFilePath("ae_editor_lyric_default.pag");
      Size localSize = VideoUtil.getVideoSize(this.jdField_f_of_type_JavaLangString);
      if ((localSize != null) && (localSize.getHeight() != 0)) {
        if (localSize.getWidth() / localSize.getHeight() > 1.0F)
        {
          ((SubtitleModel)localObject1).setCenterX(0.5F);
          ((SubtitleModel)localObject1).setCenterY(0.83F);
          ((SubtitleModel)localObject1).setScale(0.5F);
        }
      }
      for (;;)
      {
        ((SubtitleModel)localObject1).setMaxScale(2.0F);
        ((SubtitleModel)localObject1).setMinScale(0.5F);
        ((SubtitleModel)localObject1).setLoopStart(0L);
        ((SubtitleModel)localObject1).setLoopEnd(60000L);
        ((SubtitleModel)localObject1).setLoopType(1);
        ((SubtitleModel)localObject1).setLyric((String)localObject2);
        ((SubtitleModel)localObject1).setLyricFormatIsQRC(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.e().equals("QRC"));
        ((SubtitleModel)localObject1).setMusicStartTime(a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()));
        localObject2 = AEEditorResourceManager.a().a("font_runyuan75w", 0);
        if ((!TextUtils.isEmpty((CharSequence)((Pair)localObject2).first)) && (new File((String)((Pair)localObject2).first).exists())) {
          ((SubtitleModel)localObject1).setFontPath((String)((Pair)localObject2).first);
        }
        this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel = ((SubtitleModel)localObject1);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
        return;
        ((SubtitleModel)localObject1).setCenterX(0.5F);
        ((SubtitleModel)localObject1).setCenterY(0.91F);
        ((SubtitleModel)localObject1).setScale(0.8F);
        continue;
        ((SubtitleModel)localObject1).setCenterX(0.5F);
        ((SubtitleModel)localObject1).setCenterY(0.91F);
        ((SubtitleModel)localObject1).setScale(0.8F);
      }
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo == null) {
        break;
      }
      localObject1 = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.d();
    } while (!b((String)localObject1));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric((String)localObject1);
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.e().equals("QRC"));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
  }
  
  private void Z()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.deleteLyricSticker();
  }
  
  private int a(@NonNull String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 3;
      }
      return 2;
    }
    if (paramBoolean2) {
      return 1;
    }
    return 0;
  }
  
  private long a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "video_edit_clip_start_time";; str = "starttime")
    {
      Bundle localBundle = getArguments();
      if ((localBundle == null) || (!localBundle.containsKey(str))) {
        break;
      }
      return localBundle.getLong(str);
    }
    AEQLog.d(jdField_e_of_type_JavaLangString, "no video clip start time");
    return 0L;
  }
  
  @Nullable
  private Float a(boolean paramBoolean)
  {
    Bundle localBundle;
    if (paramBoolean)
    {
      localObject = "video_edit_clip_speed";
      localBundle = getArguments();
      if ((localBundle == null) || (!localBundle.containsKey((String)localObject))) {
        break label69;
      }
    }
    for (Object localObject = Float.valueOf(localBundle.getFloat((String)localObject));; localObject = null)
    {
      AEQLog.a(jdField_e_of_type_JavaLangString, "speed = " + localObject);
      return localObject;
      localObject = "speed";
      break;
      label69:
      AEQLog.d(jdField_e_of_type_JavaLangString, "no speed");
    }
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable VideoAIFilterResult paramVideoAIFilterResult)
  {
    if ((paramVideoAIFilterResult == null) || (CollectionUtils.isEmpty(paramVideoAIFilterResult.jdField_a_of_type_JavaUtilList))) {
      return null;
    }
    Object localObject = new LinkedList(paramVideoAIFilterResult.jdField_a_of_type_JavaUtilList);
    if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null)) {}
    for (paramVideoAIFilterResult = ((YoutuResultItem)((List)localObject).get(0)).Label;; paramVideoAIFilterResult = null)
    {
      if ((((List)localObject).size() > 1) && (((List)localObject).get(1) != null)) {}
      for (localObject = ((YoutuResultItem)((List)localObject).get(1)).Label;; localObject = null)
      {
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(paramVideoAIFilterResult)) {
          localArrayList.add(paramVideoAIFilterResult);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
        if (CollectionUtils.isEmpty(localArrayList)) {
          break;
        }
        return localArrayList;
      }
    }
  }
  
  private ArrayList<byte[]> a(List<Bitmap> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    double d1 = Math.sqrt(17066.666F / paramList.size());
    Iterator localIterator = paramList.iterator();
    ByteArrayOutputStream localByteArrayOutputStream;
    if (localIterator.hasNext())
    {
      paramList = (Bitmap)localIterator.next();
      localByteArrayOutputStream = new ByteArrayOutputStream();
      if ((paramList.getWidth() <= d1) && (paramList.getHeight() <= d1)) {
        break label198;
      }
      Matrix localMatrix = new Matrix();
      double d2 = Math.max(d1 / paramList.getWidth(), d1 / paramList.getHeight());
      localMatrix.postScale((float)d2, (float)d2);
      paramList = Bitmap.createBitmap(paramList, 0, 0, paramList.getWidth(), paramList.getHeight(), localMatrix, true);
    }
    label198:
    for (int n = 1;; n = 0)
    {
      for (;;)
      {
        paramList.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        localArrayList.add(localByteArrayOutputStream.toByteArray());
        try
        {
          localByteArrayOutputStream.close();
          if (n == 0) {
            break;
          }
          BitmapUtils.recycle(paramList);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      return localArrayList;
    }
  }
  
  private void a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    AEQLog.b(jdField_e_of_type_JavaLangString, "[requestDetailedMusicInfo]");
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramVsMusicItemInfo.mSongMid);
    AEEditorMusicHelper.a(localArrayList, new AEEditorVideoEditFragment.22(this, paramVsMusicItemInfo));
  }
  
  private void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    boolean bool1 = false;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {}
    do
    {
      return;
      if ((paramAEEditorMusicInfo == null) || (!this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
        if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null) {
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(false, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
        return;
      }
    } while (paramAEEditorMusicInfo.jdField_b_of_type_Int == 3);
    String str = AEEditorMusicHelper.a(paramAEEditorMusicInfo);
    boolean bool2 = AEEditorMusicHelper.a(str);
    if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(false, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
    }
    if (bool2)
    {
      paramAEEditorMusicInfo.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(str, a(paramAEEditorMusicInfo.a()), paramAEEditorMusicInfo.b());
      paramAEEditorMusicInfo = this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
      float f1 = this.jdField_a_of_type_Float;
      float f2 = this.jdField_b_of_type_Float;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      a(paramAEEditorMusicInfo, f1, f2, bool1);
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        m(true);
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(true, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      return;
    }
    if ((getActivity() == null) || (getActivity().getAppInterface() == null))
    {
      AEQLog.b(jdField_e_of_type_JavaLangString, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    if (paramAEEditorMusicInfo.jdField_a_of_type_Int == 1)
    {
      AEQLog.b(jdField_e_of_type_JavaLangString, "[updateSoundAndMusicConfig], editorMusicInfo=" + paramAEEditorMusicInfo + ", downloadStatus=STATUS_DOWNLOADING");
      return;
    }
    paramAEEditorMusicInfo.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(getActivity().getAppInterface(), paramAEEditorMusicInfo, paramAEEditorMusicInfo.b(), str, this), 128, null, true);
  }
  
  private void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean)
  {
    if (paramAEEditorMusicInfo.a()) {}
    label129:
    for (;;)
    {
      return;
      List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
      Iterator localIterator = localList.iterator();
      AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next();
          if ((localAEEditorMusicInfo != null) && (!localAEEditorMusicInfo.a()) && (paramAEEditorMusicInfo.jdField_b_of_type_Int != 1) && (paramAEEditorMusicInfo.jdField_b_of_type_Int != 0) && (paramAEEditorMusicInfo.a().equals(localAEEditorMusicInfo.a()))) {
            if (paramBoolean) {
              localAEEditorMusicInfo.jdField_a_of_type_Int = 2;
            }
          }
        }
      }
      for (int n = 1;; n = 0)
      {
        if (n == 0) {
          break label129;
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(localList);
        return;
        localAEEditorMusicInfo.jdField_a_of_type_Int = 0;
        break;
      }
    }
  }
  
  private void a(@NonNull String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(paramString, paramInt1, paramInt2);
    a(this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData, paramFloat1, paramFloat2, paramBoolean);
  }
  
  private void a(@NonNull String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
    }
    while (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void a(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo)
  {
    if (getActivity() == null)
    {
      AEQLog.d(jdField_e_of_type_JavaLangString, "activity is null.");
      return;
    }
    Intent localIntent = new Intent();
    Size localSize = a();
    localIntent.putExtra("ae_editor_video_flag", true);
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", paramLocalMediaInfo);
    localIntent.putExtra("ae_editor_video_path", paramString1);
    localIntent.putExtra("ae_editor_video_thumb_path", paramString2);
    localIntent.putExtra("ae_editor_video_export_size_height", localSize.getHeight());
    localIntent.putExtra("ae_editor_video_export_size_width", localSize.getWidth());
    paramString1 = a(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterVideoAIFilterResult);
    if (!CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilArrayList)) {
      localIntent.putStringArrayListExtra("ae_editor_video_text_cache", this.jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      localIntent.putExtra("ae_editor_video_from", this.jdField_b_of_type_Int);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
      return;
      if (!CollectionUtils.isEmpty(paramString1)) {
        localIntent.putStringArrayListExtra("ae_editor_video_text_cache", paramString1);
      }
    }
  }
  
  private void aa()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
    } while (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData == null);
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (this.jdField_d_of_type_Boolean) {}
    for (float f1 = this.jdField_b_of_type_Float;; f1 = 0.0F)
    {
      localTAVCutVideoSession.setBgmVolume(f1);
      return;
    }
  }
  
  private long b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    long l1;
    for (String str = "video_edit_clip_end_time";; str = "endtime")
    {
      Bundle localBundle = getArguments();
      l1 = Math.min(60000000L, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs());
      if ((localBundle == null) || (!localBundle.containsKey(str))) {
        break;
      }
      return localBundle.getLong(str);
    }
    AEQLog.d(jdField_e_of_type_JavaLangString, "no video clip end time");
    return l1;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel = ((AEEditorMusicControlPanel)paramView.findViewById(2131372020));
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setMusicListOperationCallback(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setMusicLyricOperationCallback(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setMusicVolumeOperationCallback(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setAutoTemplateMode(false, false);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setOriginSoundOn(g());
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel = ((AEEditorAutoTemplatePanel)paramView.findViewById(2131363150));
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.a().observe(this, new AEEditorVideoEditFragment.2(this));
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.b().observe(this, new AEEditorVideoEditFragment.3(this));
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378953));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorVideoEditFragment.4(this));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377158);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AEEditorVideoEditFragment.5(this));
    m(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378954));
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_b_of_type_AndroidWidgetTextView, false);
    Size localSize = VideoUtil.getVideoSize(this.jdField_f_of_type_JavaLangString);
    if ((localSize != null) && (localSize.getHeight() != 0)) {
      if (localSize.getWidth() / localSize.getHeight() > 1.0F) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378951));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378952));
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnClickListener(new AEEditorVideoEditFragment.6(this));
      paramView = new GestureDetector(paramView.getContext(), new AEEditorVideoEditFragment.7(this));
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnTouchListener(new AEEditorVideoEditFragment.8(this, paramView));
      return;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378950));
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378950));
    }
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {}
    while ((paramString.equals("[00:00:00]此歌曲为没有填词的纯音乐，请您欣赏")) || (paramString.length() == 0) || (paramString.equals(" ")) || (!paramString.contains("[00:"))) {
      return false;
    }
    return true;
  }
  
  private void d(int paramInt)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel != null) && (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null))
    {
      str = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.d();
      if (b(str)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric(str);
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.e().equals("QRC"));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
  }
  
  private boolean g()
  {
    Object localObject = getArguments();
    if ((localObject != null) && (((Bundle)localObject).containsKey("ae_album_selected_media_models")))
    {
      localObject = ((Bundle)localObject).getSerializable("ae_album_selected_media_models");
      if ((localObject instanceof ArrayList))
      {
        localObject = (ArrayList)localObject;
        if (localObject != null)
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if ((((Iterator)localObject).next() instanceof AEAlbumVideoModel)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private void l(boolean paramBoolean)
  {
    long l1 = a(paramBoolean);
    long l2 = b(paramBoolean);
    this.jdField_a_of_type_JavaLangFloat = a(paramBoolean);
    this.jdField_a_of_type_Long = ((l2 - l1) / 1000L);
    this.jdField_b_of_type_Long = (l1 / 1000L);
    if (this.m) {
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
    }
    if (this.jdField_a_of_type_JavaLangFloat != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(((float)this.jdField_b_of_type_Long * this.jdField_a_of_type_JavaLangFloat.floatValue())), Long.valueOf(((float)this.jdField_a_of_type_Long * this.jdField_a_of_type_JavaLangFloat.floatValue())));
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSpeed(this.jdField_a_of_type_JavaLangFloat.floatValue(), true);
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange(CMTime.fromMs(0L), CMTime.fromMs(this.jdField_a_of_type_Long)));
    }
    for (;;)
    {
      a("视频裁剪Range", TimeUtils.a(this.jdField_b_of_type_Long) + "~" + TimeUtils.a(l2 / 1000L));
      if (this.m)
      {
        Z();
        Y();
      }
      AEBaseReportParam.a().a().jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      return;
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_a_of_type_Long), true);
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange(CMTime.fromMs(0L), CMTime.fromMs(this.jdField_a_of_type_Long)));
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    }
  }
  
  private void n(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView == null) {
      this.jdField_b_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView = new AEEditorQcircleBubbleView(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.post(new AEEditorVideoEditFragment.14(this, paramBoolean));
  }
  
  public void A()
  {
    getActivity().getIntent().putExtra("startTimeEdit", this.jdField_b_of_type_Long * 1000L);
    getActivity().getIntent().putExtra("endTimeEdit", (this.jdField_b_of_type_Long + this.jdField_a_of_type_Long) * 1000L);
    Intent localIntent = getActivity().getIntent();
    if (this.jdField_a_of_type_JavaLangFloat != null) {}
    for (float f1 = this.jdField_a_of_type_JavaLangFloat.floatValue();; f1 = 1.0F)
    {
      localIntent.putExtra("endSpeedEdit", f1);
      AEBaseDataReporter.a().a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
      T();
      return;
    }
  }
  
  public void B()
  {
    i();
    if ((this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) && ("sticker_lyric".equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getStickerType())))
    {
      f();
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    U();
  }
  
  public void C()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.d();
  }
  
  public void D()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      aa();
    }
    AEBaseDataReporter.a().k();
  }
  
  protected void E()
  {
    SilentVideoAIFilterProxy localSilentVideoAIFilterProxy = new SilentVideoAIFilterProxy(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    localSilentVideoAIFilterProxy.a(new AEEditorVideoEditFragment.17(this));
    AEEditorAIFilterManager.a().a(getActivity().getAppInterface(), getActivity(), localSilentVideoAIFilterProxy);
  }
  
  public void F()
  {
    String str = "";
    if (!TextUtils.isEmpty(AEBaseReportParam.a().a().jdField_a_of_type_JavaLangString)) {
      str = AEBaseReportParam.a().a().jdField_a_of_type_JavaLangString;
    }
    AEEditorMusicHelper.a(getActivity(), str);
    AEBaseDataReporter.a().o();
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(HardCodeUtil.a(2131689705));
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.d();
      a(true);
    }
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(b());
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.c();
      a(false);
    }
  }
  
  public void I()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.e();
  }
  
  public void J() {}
  
  public void K()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
  
  public void L()
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo == null) || (this.jdField_a_of_type_JavaLangInteger == null))
    {
      if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      }
      return;
    }
    AEEditorLyricProgressCalculator.a().b(this.jdField_a_of_type_JavaLangInteger.intValue(), Math.min(this.jdField_a_of_type_JavaLangInteger.intValue() + this.jdField_a_of_type_Long, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b()));
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
    int n = this.jdField_a_of_type_JavaLangInteger.intValue();
    int i1 = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, n, i1, f1, f2, bool);
      if (!this.m) {
        break;
      }
      Z();
      d(this.jdField_a_of_type_JavaLangInteger.intValue());
      return;
    }
  }
  
  public void M()
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo == null) || (this.jdField_a_of_type_JavaLangInteger == null)) {
      return;
    }
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
    int n = a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a());
    int i1 = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, n, i1, f1, f2, bool);
      if (this.m)
      {
        Z();
        Y();
      }
      this.jdField_a_of_type_JavaLangInteger = null;
      this.jdField_b_of_type_JavaLangInteger = null;
      return;
    }
  }
  
  public void N()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo == null) || (this.jdField_a_of_type_JavaLangInteger == null)) {
      return;
    }
    a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a(), this.jdField_a_of_type_JavaLangInteger.intValue(), true);
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
    int n = this.jdField_a_of_type_JavaLangInteger.intValue();
    int i1 = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      a(str, n, i1, f1, f2, bool);
      if (this.m)
      {
        Z();
        Y();
      }
      this.jdField_a_of_type_JavaLangInteger = null;
      this.jdField_b_of_type_JavaLangInteger = null;
      return;
      bool = false;
    }
  }
  
  public void O()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.d();
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(HardCodeUtil.a(2131689725));
      a(true);
    }
  }
  
  public void P()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.c();
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(b());
      a(false);
    }
  }
  
  public int a()
  {
    return 2131558603;
  }
  
  protected LocalMediaInfo a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path))) {
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    }
    for (;;)
    {
      return AELocalMediaInfoUtil.a(localArrayList, this.jdField_f_of_type_JavaLangString, a().getHeight(), a().getWidth(), paramString1, paramString2, paramString3);
      localArrayList.add(paramString1);
    }
  }
  
  protected Size a()
  {
    LightAsset localLightAsset;
    if (ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel())) {
      localLightAsset = LightAsset.Load(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaTemplateModel().getLightMediaTemplateModel().getFilePath(), 100);
    }
    for (this.jdField_b_of_type_ComTencentTavcutBeanSize = new Size(localLightAsset.width(), localLightAsset.height());; this.jdField_b_of_type_ComTencentTavcutBeanSize = VideoUtil.getVideoSize(this.jdField_f_of_type_JavaLangString)) {
      return this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
    }
  }
  
  protected TAVCutSession a()
  {
    return this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  }
  
  public StickerOperationCallback a()
  {
    return new AEEditorVideoEditFragment.10(this);
  }
  
  protected MediaResourceModel a(MediaResourceModel paramMediaResourceModel)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaBuilderOutput();
    MediaResourceModel localMediaResourceModel = paramMediaResourceModel;
    if (localObject != null)
    {
      localMediaResourceModel = new MediaResourceModel();
      localObject = ((MediaBuilderOutput)localObject).getLightTemplate().getLightSegments().iterator();
      if (((Iterator)localObject).hasNext())
      {
        Iterator localIterator1 = ((MovieSegmentModel)((Iterator)localObject).next()).getVideoResourceModels().iterator();
        while (localIterator1.hasNext())
        {
          VideoResourceModel localVideoResourceModel = (VideoResourceModel)localIterator1.next();
          Iterator localIterator2 = paramMediaResourceModel.getVideos().iterator();
          while (localIterator2.hasNext())
          {
            MediaClipModel localMediaClipModel = (MediaClipModel)localIterator2.next();
            if ((localMediaClipModel.getResource().getPath() != null) && (localMediaClipModel.getResource().getPath().equals(localVideoResourceModel.getPath())))
            {
              localMediaClipModel = localMediaClipModel.deepCopy();
              localMediaClipModel.setResource(localVideoResourceModel);
              localMediaResourceModel.getVideos().add(localMediaClipModel);
            }
          }
        }
      }
    }
    return localMediaResourceModel;
  }
  
  protected AEEditorFilterControlPanel.FilterControlListener a()
  {
    return this;
  }
  
  protected FilterChangedComparator a()
  {
    return new AEEditorVideoEditFragment.12(this);
  }
  
  protected AEEditorTextPart.AEEditorTextDialogListener a()
  {
    return new AEEditorVideoEditFragment.18(this);
  }
  
  public String a()
  {
    return "AEEditorVideoEdit";
  }
  
  public void a()
  {
    if (getArguments() != null) {
      getArguments().clear();
    }
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(this.jdField_a_of_type_Float);
      AEBaseReportParam.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
      aa();
      return;
    }
  }
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131377155: 
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 0);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, 8);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, 8);
      j();
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel, 8);
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.b();
      }
      AEReportUtils.q();
      return;
    case 2131377163: 
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 8);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, 0);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, 8);
      j();
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel, 8);
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.b();
      }
      AEReportUtils.r();
      return;
    case 2131377173: 
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 8);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, 8);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, 0);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel, 8);
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.b();
      }
      AEReportUtils.s();
      return;
    }
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 8);
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, 8);
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, 8);
    j();
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel, 0);
    AEReportUtils.v();
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setEffectStrength(paramFloat);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
    AEBaseReportParam.a().a().jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramInt1, paramInt2);
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt1);
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
  }
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.24(this, paramAIFilterResult));
    }
    if (paramInt == 0)
    {
      AEQLog.b(jdField_e_of_type_JavaLangString, "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.26(this));
      if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (paramAIFilterResult != null)) {
        break label107;
      }
    }
    label107:
    VideoAIFilterResult localVideoAIFilterResult;
    do
    {
      return;
      AEQLog.b(jdField_e_of_type_JavaLangString, "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.25(this));
      break;
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache.a(this.jdField_f_of_type_JavaLangString, paramAIFilterResult);
      this.jdField_a_of_type_JavaUtilArrayList = a(paramAIFilterResult);
      localVideoAIFilterResult = (VideoAIFilterResult)paramAIFilterResult;
    } while (localVideoAIFilterResult == null);
    a(localVideoAIFilterResult);
    a(new String[] { "智能滤镜label", localVideoAIFilterResult.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    paramAIFilterResult = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localVideoAIFilterResult.jdField_a_of_type_JavaLangString)) {
        break label285;
      }
      paramAIFilterResult = localNewEnhanceCategories.filterType;
    }
    label285:
    for (;;)
    {
      break;
      AEBaseReportParam.a().a().jdField_d_of_type_JavaLangString = ("effect_aieffect_" + paramAIFilterResult);
      AEBaseReportParam.a().a().jdField_a_of_type_Float = -1.0F;
      this.jdField_g_of_type_JavaLangString = "effect_aieffect";
      return;
    }
  }
  
  public void a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    o();
    String str1 = AEEditorResourceManager.a().a(paramAEEditorFilterBean);
    float f2 = paramAEEditorFilterBean.getEffectExtendBean().getDefaultEffectAlpha();
    if (c(paramInt))
    {
      e(true);
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        break label159;
      }
    }
    label159:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).floatValue();; f1 = f2)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f1);
      float f3 = paramAEEditorFilterBean.getEffectExtendBean().getGlowStrength();
      Map localMap = paramAEEditorFilterBean.getEffectExtendBean().getAdjustParams();
      String str2 = AEEditorResourceManager.a().c(paramAEEditorFilterBean);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModel(f1, str1, f3, localMap, str2);
      AEBaseReportParam.a().a().jdField_d_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
      AEBaseReportParam.a().a().jdField_a_of_type_Float = f2;
      this.jdField_g_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
      return;
      e(false);
      break;
    }
  }
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    int i2 = 0;
    if ((!paramBoolean) || (paramStSmartMatchMusicRsp == null) || (CollectionUtils.isEmpty(paramStSmartMatchMusicRsp.vecMusic.get()))) {
      AEQLog.d(jdField_e_of_type_JavaLangString, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
    }
    do
    {
      return;
      if ((paramStSmartMatchMusicRsp.extInfo != null) && (paramStSmartMatchMusicRsp.extInfo.mapInfo.size() != 0))
      {
        paramBaseRequest = paramStSmartMatchMusicRsp.extInfo.mapInfo.get().iterator();
        while (paramBaseRequest.hasNext())
        {
          paramString = (COMM.Entry)paramBaseRequest.next();
          if ((paramString != null) && (paramString.key.get().equals("CommonInfo"))) {
            AEBaseReportParam.a().a().jdField_f_of_type_JavaLangString = paramString.value.get();
          }
        }
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel == null);
    paramBaseRequest = AEEditorMusicHelper.a(paramStSmartMatchMusicRsp.vecMusic.get());
    paramString = AEEditorMusicHelper.b(paramBaseRequest);
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
    paramStSmartMatchMusicRsp = new LinkedList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBaseRequest.iterator();
    paramBaseRequest = "";
    if (localIterator.hasNext())
    {
      VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)localIterator.next();
      if (!TextUtils.isEmpty(paramBaseRequest)) {}
      for (paramBaseRequest = paramBaseRequest + "," + localVsMusicItemInfo.mSongMid;; paramBaseRequest = paramBaseRequest + localVsMusicItemInfo.mSongMid) {
        break;
      }
    }
    AEBaseReportParam.a().a().jdField_g_of_type_JavaLangString = paramBaseRequest;
    int n = 0;
    int i1 = i2;
    if (n < localList.size())
    {
      paramBaseRequest = (AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(n);
      if ((paramBaseRequest == null) || (paramBaseRequest.a()) || (paramBaseRequest.jdField_b_of_type_Int == 0)) {}
      for (;;)
      {
        n += 1;
        break;
        paramStSmartMatchMusicRsp.add(paramBaseRequest);
        localHashMap.put(paramBaseRequest.a(), paramBaseRequest);
      }
    }
    if (i1 < paramString.size())
    {
      paramBaseRequest = (AEEditorMusicAdapter.AEEditorMusicInfo)paramString.get(i1);
      if ((paramBaseRequest == null) || (paramBaseRequest.a())) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (localHashMap.get(paramBaseRequest.a()) == null) {
          paramStSmartMatchMusicRsp.add(paramBaseRequest);
        }
      }
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramStSmartMatchMusicRsp);
  }
  
  protected void a(@NonNull MusicData paramMusicData, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmMusic(paramMusicData, paramFloat1, paramFloat2, paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(CMTime.fromMs(0L));
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  protected void a(SubtitleModel paramSubtitleModel)
  {
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel != null) && (paramSubtitleModel != null))
    {
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setAssetFilePath(paramSubtitleModel.getAssetFilePath());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setCenterX(paramSubtitleModel.getCenterX());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setCenterY(paramSubtitleModel.getCenterY());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setRotate(paramSubtitleModel.getRotate());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setScale(paramSubtitleModel.getScale());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMaxScale(paramSubtitleModel.getMaxScale());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMinScale(paramSubtitleModel.getMinScale());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLoopStart(paramSubtitleModel.getLoopStart());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLoopEnd(paramSubtitleModel.getLoopEnd());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLoopType(paramSubtitleModel.getLoopType());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric(paramSubtitleModel.getLyric());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(paramSubtitleModel.getLyricFormatIsQRC());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(paramSubtitleModel.getMusicStartTime());
    }
  }
  
  protected void a(@NonNull VideoAIFilterResult paramVideoAIFilterResult)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
    {
      AEQLog.d(jdField_e_of_type_JavaLangString, "tavVideoSession is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(paramVideoAIFilterResult.jdField_b_of_type_JavaLangString, 0.8F, paramVideoAIFilterResult.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
  }
  
  public void a(AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean, String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
    {
      AEQLog.d(jdField_e_of_type_JavaLangString, "tavVideoSession is null.");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean = paramAEEditorAutoTemplateBean;
    MusicModel localMusicModel = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getMusicModel();
    if (paramAEEditorAutoTemplateBean == null)
    {
      localMusicModel.setVolume(0.5F);
      localMusicModel.setBgmVolume(0.5F);
      localMusicModel.setMetaDataBean(null);
      localMusicModel.setUserMetaDataBean(null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setAutoTemplateMode(false, false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.setHasTemplate(false);
      return;
    }
    localMusicModel.setVolume(1.0F);
    localMusicModel.setBgmVolume(1.0F);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(4, paramString, true, new String[] { "template.json" });
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getMusicModel().getMetaDataBean() != null) {
      bool = true;
    }
    if (bool)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = new MusicData();
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(true, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.5F);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(0.0F);
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setAutoTemplateMode(true, bool);
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(1.0F);
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.a(paramAEEditorAutoTemplateBean);
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.setHasTemplate(true);
  }
  
  public void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt)
  {
    if ((paramAEEditorMusicInfo == null) || (paramAEEditorMusicInfo.a())) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = paramAEEditorMusicInfo;
    AEBaseReportParam.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    AEBaseReportParam.a().a().jdField_e_of_type_JavaLangString = paramAEEditorMusicInfo.a();
    AEBaseReportParam.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_b_of_type_Boolean;
    AEBaseReportParam.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.c;
    AEBaseReportParam.a().a().c = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b();
    AEBaseDataReporter.a().m();
    Object localObject = new HashMap();
    ((HashMap)localObject).put("ext2", paramAEEditorMusicInfo.a());
    AEReportUtils.d(2, (HashMap)localObject);
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
    Iterator localIterator = localList.iterator();
    int n = 0;
    while (localIterator.hasNext())
    {
      localObject = (AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next();
      if ((localObject != null) && (!((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).a()) && (((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).jdField_b_of_type_Int != 1) && (((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).jdField_b_of_type_Int != 0))
      {
        if (paramAEEditorMusicInfo.a().equals(((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).a()))
        {
          ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject);
          paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject;
          n = 1;
        }
        for (;;)
        {
          break;
          ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).jdField_a_of_type_Boolean = false;
        }
      }
    }
    int i1 = paramInt;
    if (n == 0)
    {
      paramAEEditorMusicInfo.jdField_a_of_type_Boolean = true;
      n = localList.size() - 1;
      if (paramInt > n)
      {
        i1 = n + 1;
        localList.add(paramAEEditorMusicInfo);
      }
    }
    else
    {
      a(paramAEEditorMusicInfo.a(), paramAEEditorMusicInfo.a(), false);
      if (paramAEEditorMusicInfo.jdField_b_of_type_Int != 3) {
        break label414;
      }
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.restoreTemplateMusic(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float))
      {
        this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
        this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = new MusicData();
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(true, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(localList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(i1);
      return;
      localList.add(paramInt, paramAEEditorMusicInfo);
      i1 = paramInt;
      break;
      label414:
      a(paramAEEditorMusicInfo);
    }
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.23(this, paramAEEditorMusicInfo, paramBoolean, paramString));
  }
  
  protected void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AEEditorMusicHelper.a(paramString, paramInt1, paramInt2, paramLong1, paramLong1 + paramLong2, this);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    LocalMediaInfo localLocalMediaInfo = AELocalMediaInfoUtil.a(a(paramString1, paramString2, paramString3), getArguments().getString("material_id"), getArguments().getString("material_topic"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_g_of_type_JavaLangString);
    a(localLocalMediaInfo, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList());
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      a(localLocalMediaInfo, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList(), this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a());
    }
    AEEditorProcessManager localAEEditorProcessManager = AEEditorProcessManager.a();
    String str1 = localLocalMediaInfo.materialID;
    String str2 = localLocalMediaInfo.materialName;
    String str3 = localLocalMediaInfo.filterID;
    String str4 = localLocalMediaInfo.scheme;
    int n = localLocalMediaInfo.showCircleTakeSame;
    String str5 = this.jdField_f_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {}
    for (MediaModel localMediaModel = new MediaModel();; localMediaModel = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel())
    {
      localAEEditorProcessManager.a(str1, str2, str3, str4, n, paramString3, str5, paramString1, paramString2, localMediaModel, localLocalMediaInfo.mKuolieId, localLocalMediaInfo.mKuolieCenterX, localLocalMediaInfo.mKuolieCenterY, localLocalMediaInfo.mKuolieWidthScale, localLocalMediaInfo.mKuolieHeightScale, localLocalMediaInfo.mKuolieRotate);
      if (getActivity() != null) {
        break;
      }
      AEQLog.d(jdField_e_of_type_JavaLangString, "activity is null.");
      return;
    }
    a(paramString1, paramString2, localLocalMediaInfo);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.21(this));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)
    {
      paramBoolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) && (FlowCameraConstant.jdField_a_of_type_Int != 2)) {
        break label77;
      }
    }
    label77:
    for (int n = 0;; n = 1)
    {
      AEEditorMusicHelper.a(paramArrayList, WatermarkDataManager.a().a(), paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, n, this);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.i) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying()))
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(CMTime.fromMs(0L));
        }
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying()))
    {
      this.i = true;
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
      return;
    }
    this.i = false;
  }
  
  public boolean a()
  {
    AEBaseDataReporter.a().q();
    if (this.jdField_d_of_type_JavaLangString.equals(f()))
    {
      getActivity().getIntent().putExtra("startTimeEdit", a(false));
      getActivity().getIntent().putExtra("endTimeEdit", b(false));
      getActivity().getIntent().putExtra("endSpeedEdit", a(false));
      return false;
    }
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2131689760)).setMessage(((Context)localObject).getString(2131689761)).setPositiveButton(((Context)localObject).getString(2131689715), new AEEditorVideoEditFragment.28(this)).setNegativeButton(((Context)localObject).getString(2131689713), new AEEditorVideoEditFragment.27(this));
    if (localObject != null) {}
    try
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        ((QQCustomDialog)localObject).show();
      }
      label162:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label162;
    }
  }
  
  protected boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    AEBaseReportParam.a().a().jdField_d_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
    AEBaseReportParam.a().a().jdField_a_of_type_Float = -1.0F;
    return true;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList();
    int n = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (n < paramString.size())
      {
        if ((((StickerModel)paramString.get(n)).getInteractive() > 0) && (((StickerModel)paramString.get(n)).getMaterialId().startsWith("qiukuolie"))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      n += 1;
    }
  }
  
  public void aJ_()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, "资源下载中，请稍后再试", 0).a();
  }
  
  protected int b()
  {
    return 0;
  }
  
  public String b()
  {
    return HardCodeUtil.a(2131689735);
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.b(this.jdField_b_of_type_Float);
    aa();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(new CMTime(paramInt, 1000));
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  protected void c()
  {
    this.jdField_f_of_type_JavaLangString = d();
    this.j = AEThemeUtil.a();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo == null) {
      return;
    }
    AEEditorLyricProgressCalculator.a().b(paramInt, Math.min(paramInt + this.jdField_a_of_type_Long, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b()));
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
    int n = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, paramInt, n, f1, f2, bool);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.b(paramInt);
      n = (int)(paramInt + this.jdField_a_of_type_Long);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramInt, n);
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(n);
      if (!this.m) {
        break;
      }
      Z();
      d(this.jdField_a_of_type_JavaLangInteger.intValue());
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  protected String d()
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = getArguments();
    if (localBundle.containsKey("PhotoConst.SELECTED_PATHS")) {
      localArrayList = localBundle.getStringArrayList("PhotoConst.SELECTED_PATHS");
    }
    while (localArrayList.size() > 0)
    {
      return (String)localArrayList.get(0);
      AEQLog.d(jdField_e_of_type_JavaLangString, "no video paths");
    }
    return null;
  }
  
  protected void d()
  {
    AEEditorAIFilterManager.a().a();
  }
  
  protected void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    a(paramBoolean);
  }
  
  protected String e()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  protected void e() {}
  
  protected String f()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString() != null)) {
      return Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    }
    return "";
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
    }
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache.a(this.jdField_f_of_type_JavaLangString);
    boolean bool1;
    if ((localObject != null) && ((localObject instanceof VideoAIFilterResult)))
    {
      AEQLog.b(jdField_e_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool1 = ((VideoAIFilterResult)localObject).jdField_a_of_type_Boolean;
      if (!bool1) {
        break label98;
      }
      l();
      localObject = new VideoAIFilterProxy(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((VideoAIFilterProxy)localObject).a(this);
      AEEditorAIFilterManager.a().a(getActivity().getAppInterface(), getActivity(), (AIFilterProxyBase)localObject);
    }
    for (;;)
    {
      if (!bool1) {
        bool2 = true;
      }
      return bool2;
      bool1 = true;
      break;
      label98:
      e(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(((AIFilterResult)localObject).b(), 0.8F, ((AIFilterResult)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((AIFilterResult)localObject).a(), "智能滤镜errCode", "0" });
    }
  }
  
  public void g()
  {
    long l1 = 2000L;
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.19(this));
    String str2 = AEEditorPath.EDITOR.FILES.jdField_d_of_type_JavaLangString;
    Object localObject1 = new File(str2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = new File(this.jdField_f_of_type_JavaLangString);
    localObject1 = e();
    String str1 = str2 + File.separator + "output_" + (String)localObject1 + "_" + VideoFilterTools.a(((File)localObject2).getName()) + ".jpg";
    str2 = str2 + File.separator + "output_" + (String)localObject1 + "_" + VideoFilterTools.a(((File)localObject2).getName()) + ".mp4";
    X();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      localObject2 = new TAVCutVideoSession();
      AEEditorMultiVideoEditFragment.a(BaseApplicationImpl.getContext(), (TAVCutVideoSession)localObject2, this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel(), null, null);
      ((TAVCutVideoSession)localObject2).applyCurrentSticker();
      if (((TAVCutVideoSession)localObject2).getDuration().getValue() <= 2000L) {
        break label272;
      }
    }
    for (;;)
    {
      ((TAVCutVideoSession)localObject2).getEffectVideoFrame(l1, 1080, new AEEditorVideoEditFragment.20(this, (TAVCutVideoSession)localObject2, str1, str2, (String)localObject1));
      return;
      a(str2, str1, (String)localObject1);
      return;
      label272:
      l1 = 1000L;
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.d();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    AEBaseReportParam.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
    if (CollectionUtils.isEmpty(localList)) {
      return;
    }
    Object localObject;
    int i1;
    int n;
    if (paramBoolean)
    {
      if ((this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo == null) || (this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a())) {
        break label482;
      }
      int i2 = 0;
      localObject = null;
      i1 = 0;
      n = 0;
      if (i2 < localList.size())
      {
        AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(i2);
        int i3;
        if ((localAEEditorMusicInfo != null) && (!localAEEditorMusicInfo.a()) && (localAEEditorMusicInfo.jdField_b_of_type_Int != 1)) {
          if (localAEEditorMusicInfo.jdField_b_of_type_Int == 0)
          {
            i3 = i1;
            i1 = n;
            n = i3;
          }
        }
        for (;;)
        {
          i3 = i2 + 1;
          i2 = i1;
          i1 = n;
          n = i2;
          i2 = i3;
          break;
          if (this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a().equals(localAEEditorMusicInfo.a()))
          {
            localAEEditorMusicInfo.jdField_a_of_type_Boolean = true;
            n = 1;
            i1 = i2;
            localObject = localAEEditorMusicInfo;
          }
          else
          {
            localAEEditorMusicInfo.jdField_a_of_type_Boolean = false;
            i3 = n;
            n = i1;
            i1 = i3;
          }
        }
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject);
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject);
        label229:
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_a_of_type_Boolean = true;
        AEBaseReportParam.a().a().jdField_e_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a();
        AEBaseReportParam.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_b_of_type_Boolean;
        AEBaseReportParam.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.c;
        AEBaseReportParam.a().a().c = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b();
        AEBaseDataReporter.a().m();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null) {
          a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a(), this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a(), false);
        }
        a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(localList);
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(n);
        return;
        this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = ((AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(1));
        break label229;
        this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((AEEditorMusicAdapter.AEEditorMusicInfo)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
        }
        AEBaseReportParam.a().a().jdField_e_of_type_JavaLangString = "none";
        AEBaseReportParam.a().a().jdField_a_of_type_Boolean = false;
        AEBaseReportParam.a().a().jdField_b_of_type_Int = -1;
        AEBaseReportParam.a().a().c = -1;
        n = 0;
      }
      label482:
      localObject = null;
      i1 = 0;
      n = 0;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramBoolean);
  }
  
  public void j(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo == null))
    {
      QQToast.a(getActivity(), 2131689756, 0).a();
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, Integer.valueOf(a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a())), (int)this.jdField_a_of_type_Long, this.jdField_f_of_type_Boolean);
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void k(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null)
      {
        if (b(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.d())) {
          break label43;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        Y();
        return;
        label43:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    Z();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected void n()
  {
    this.l = true;
    R();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b(jdField_e_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    AEEditorMusicHelper.a(getActivity());
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.jdField_b_of_type_Int = getActivity().getIntent().getIntExtra("editorFrom", -1);
      paramBundle = (HashMap)getActivity().getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        paramBundle = paramBundle.entrySet().iterator();
        while (paramBundle.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramBundle.next();
          if (localEntry.getValue() != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localEntry.getValue());
          }
        }
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramBundle = AEBaseReportParam.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {}
    for (int n = 0;; n = 1)
    {
      paramBundle.jdField_e_of_type_Int = n;
      return;
    }
  }
  
  public void onDeleteSticker()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.f();
    }
  }
  
  public void onDestroyView()
  {
    AEQLog.b(jdField_e_of_type_JavaLangString, "onDestroyView");
    super.onDestroyView();
    if (getArguments() != null) {
      getArguments().clear();
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorMusicControlPanel.c();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.8F;
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
    this.jdField_b_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (AEEditorLauncher.b(getArguments()))
    {
      this.jdField_g_of_type_Boolean = paramBoolean;
      if (!paramBoolean)
      {
        AEBaseDataReporter.a().r();
        l(true);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(this.jdField_b_of_type_Float);
        a(true, true);
        this.jdField_f_of_type_Boolean = true;
        AEReportUtils.u();
      }
    }
    else
    {
      return;
    }
    g(false);
  }
  
  public void onPause()
  {
    super.onPause();
    AEQLog.b(jdField_e_of_type_JavaLangString, "onPause");
    if (!this.jdField_g_of_type_Boolean) {
      g(false);
    }
  }
  
  public void onResume()
  {
    AEQLog.b(jdField_e_of_type_JavaLangString, "onResume");
    super.onResume();
    if (!this.jdField_g_of_type_Boolean)
    {
      AEBaseDataReporter.a().r();
      g(true);
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null) {
        a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      }
      AEReportUtils.u();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b(jdField_e_of_type_JavaLangString, "onViewCreated");
    b(paramView);
    super.onViewCreated(paramView, paramBundle);
    u();
    R();
    Q();
    AEBaseReportParam.a().a().jdField_e_of_type_JavaLangString = "none";
    AEBaseReportParam.a().a().jdField_a_of_type_Boolean = false;
    AEBaseReportParam.a().a().jdField_b_of_type_Int = -1;
    AEBaseReportParam.a().a().c = -1;
    AEBaseReportParam.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    AEBaseReportParam.a().a().jdField_f_of_type_JavaLangString = "none";
    AEBaseReportParam.a().a().jdField_g_of_type_JavaLangString = "none";
    paramBundle = VideoUtil.getVideoSize(this.jdField_f_of_type_JavaLangString);
    a(this.jdField_f_of_type_JavaLangString, paramBundle.getWidth(), paramBundle.getHeight(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    a(new String[] { "设备级别", ParamsUtil.a(), "视频最大预览尺寸", String.valueOf(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy.a()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出码率", String.valueOf(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy.b()), "视频导出帧率", String.valueOf(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy.c()) });
    if (AEEditorResourceManager.a().b()) {
      E();
    }
    int n;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      paramBundle = AEEditorResourceManager.a().a();
      if ((paramBundle.get(0) == null) || (((AEEditorPagStickerGroup)paramBundle.get(0)).stickerInfoList == null)) {
        return;
      }
      paramBundle = ((AEEditorPagStickerGroup)paramBundle.get(0)).stickerInfoList;
      n = 0;
    }
    for (;;)
    {
      if (n < paramBundle.size())
      {
        if (((AEEditorPagStickerInfo)paramBundle.get(n)).stickerId.equals(this.jdField_c_of_type_JavaLangString))
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean = AEEditorTextBean.createTextBeanByStickerInfo((AEEditorPagStickerInfo)paramBundle.get(n));
          a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
        }
      }
      else
      {
        V();
        a(paramView.findViewById(2131377155));
        return;
      }
      n += 1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void p()
  {
    super.p();
    AEReportUtils.l();
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165216));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new AEEditorVideoEditFragment.9(this));
  }
  
  protected void u()
  {
    t();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy.a());
    StickerEditViewIconConfig localStickerEditViewIconConfig = new StickerEditViewIconConfig();
    localStickerEditViewIconConfig.setDeleteIconResId(2130837919);
    localStickerEditViewIconConfig.setEditIconResId(2130837918);
    localStickerEditViewIconConfig.setZoomIconResId(2130837920);
    localSessionConfig.setStickerEditViewIconConfig(localStickerEditViewIconConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerLyricCallback(this);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(getActivity());
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() > 60000000L) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      l(false);
      ThreadManager.excute(new AEEditorVideoEditFragment.11(this), 16, null, true);
      this.jdField_d_of_type_JavaLangString = f();
      this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
      return;
    }
  }
  
  public void v()
  {
    Object localObject = new ArrayList();
    long l1 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs();
    int n = 1;
    while (n <= 6)
    {
      ((List)localObject).add(Long.valueOf(l1 * 1000L / 7L * n));
      n += 1;
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null)
    {
      localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMultiVideoFrame((List)localObject, 250);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        return;
      }
      this.jdField_c_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList((Collection)localObject);
    }
    localObject = a(this.jdField_c_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    ((AEEditorDataServiceHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.jdField_e_of_type_JavaLangString)).a("MqCircleEditor", (ArrayList)localObject);
  }
  
  public void w()
  {
    o();
    e(false);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.clearAEKitModel();
    AEBaseReportParam.a().a().jdField_d_of_type_JavaLangString = "effect_blank";
    AEBaseReportParam.a().a().jdField_a_of_type_Float = -1.0F;
  }
  
  public void x() {}
  
  public void y() {}
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */