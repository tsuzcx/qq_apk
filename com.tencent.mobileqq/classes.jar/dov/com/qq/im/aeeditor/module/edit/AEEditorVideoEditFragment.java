package dov.com.qq.im.aeeditor.module.edit;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import aang;
import alps;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
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
import anvx;
import bhdj;
import bnhs;
import bnqm;
import bnqq;
import bnqt;
import bnrh;
import bnri;
import bnsm;
import bnsr;
import bnss;
import bnst;
import bnuz;
import bnvc;
import bnvx;
import bnvy;
import bnwd;
import bnwk;
import bnwn;
import bnwo;
import bnyf;
import bnyg;
import bnyi;
import bnyj;
import bnyk;
import bnyl;
import bnym;
import bnyn;
import bnyo;
import bnyp;
import bnyq;
import bnyr;
import bnys;
import bnyt;
import boad;
import boaf;
import boal;
import bobb;
import bobc;
import bobg;
import bobn;
import bobs;
import bobw;
import bobx;
import boby;
import bocs;
import bocy;
import bodc;
import bodk;
import bodl;
import bpjt;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.data.MusicData;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorControlPanelContainer;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEFilterExtendBean;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;
import dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import zpz;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements aang, bnvc, boad, bobb, bobn, bobs, bodc, VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp>, StickerLyricCallback
{
  private static final String d;
  private float jdField_a_of_type_Float = 1.0F;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected bnvx a;
  public bnwo a;
  private bobg jdField_a_of_type_Bobg;
  protected boby a;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  protected Size a;
  public MoviePlayer a;
  public TAVCutVideoSession a;
  protected TAVCutVideoView a;
  private MusicData jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
  private SubtitleModel jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel;
  private VideoControlPanel jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
  private Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger;
  protected ArrayList<String> a;
  private HashMap<Integer, Float> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private float jdField_b_of_type_Float = 0.8F;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bobg jdField_b_of_type_Bobg;
  protected Size b;
  private Integer jdField_b_of_type_JavaLangInteger;
  private TextView c;
  protected String c;
  protected boolean c;
  protected boolean d;
  private String e;
  protected boolean e;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean;
  private boolean g = true;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  static
  {
    jdField_d_of_type_JavaLangString = AEEditorVideoEditFragment.class.getSimpleName();
    File localFile = new File(bnsr.jdField_c_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public AEEditorVideoEditFragment()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Bnvx = new bnvx();
    this.jdField_a_of_type_Boby = bobw.a();
  }
  
  private void H()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bnyf(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void I()
  {
    if ((!this.j) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.k))
    {
      this.j = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void J()
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
  
  private void K()
  {
    if (this.jdField_a_of_type_JavaLangString.equals("AEEditorVideoClip")) {
      a().b(a(), getArguments());
    }
    while (!this.jdField_a_of_type_JavaLangString.equals("AEEditorMultiCutFragment")) {
      return;
    }
    a().e(a(), getArguments());
  }
  
  private void L()
  {
    bnqq.a().a().i = 0;
    bnqm.a().j();
  }
  
  private void M()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null)
    {
      bnqq.a().a().jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().size();
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList(), 0);
    }
    bnqm.a().i();
  }
  
  private void N()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel == null) && (this.jdField_a_of_type_Bobg != null))
    {
      localObject2 = this.jdField_a_of_type_Bobg.d();
      if (a((String)localObject2)) {}
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = new SubtitleModel();
      ((SubtitleModel)localObject1).setAssetFilePath("ae_editor_lyric_default.pag");
      Size localSize = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
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
        ((SubtitleModel)localObject1).setLyricFormatIsQRC(this.jdField_a_of_type_Bobg.e().equals("QRC"));
        ((SubtitleModel)localObject1).setMusicStartTime(a(this.jdField_a_of_type_Bobg.a()));
        localObject2 = boaf.a().a("font_runyuan75w", 0);
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
      if (this.jdField_a_of_type_Bobg == null) {
        break;
      }
      localObject1 = this.jdField_a_of_type_Bobg.d();
    } while (!a((String)localObject1));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric((String)localObject1);
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_Bobg.e().equals("QRC"));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(a(this.jdField_a_of_type_Bobg.a()));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
  }
  
  private void O()
  {
    a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.deleteLyricSticker();
  }
  
  private void P()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
    } while (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData == null);
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (this.h) {}
    for (float f1 = this.jdField_b_of_type_Float;; f1 = 0.0F)
    {
      localTAVCutVideoSession.setBgmVolume(f1);
      return;
    }
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
    bnrh.d(jdField_d_of_type_JavaLangString, "no video clip start time");
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
      bnrh.a(jdField_d_of_type_JavaLangString, "speed = " + localObject);
      return localObject;
      localObject = "speed";
      break;
      label69:
      bnrh.d(jdField_d_of_type_JavaLangString, "no speed");
    }
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable bnwo parambnwo)
  {
    if ((parambnwo == null) || (CollectionUtils.isEmpty(parambnwo.jdField_a_of_type_JavaUtilList))) {
      return null;
    }
    Object localObject = new LinkedList(parambnwo.jdField_a_of_type_JavaUtilList);
    if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null)) {}
    for (parambnwo = ((YoutuResultItem)((List)localObject).get(0)).Label;; parambnwo = null)
    {
      if ((((List)localObject).size() > 1) && (((List)localObject).get(1) != null)) {}
      for (localObject = ((YoutuResultItem)((List)localObject).get(1)).Label;; localObject = null)
      {
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(parambnwo)) {
          localArrayList.add(parambnwo);
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
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel = ((VideoControlPanel)this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.setMusicListOperationCallback(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.setMusicLyricOperationCallback(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378522));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bnyl(this));
    g(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378523));
    zpz.a(this.jdField_b_of_type_AndroidWidgetTextView, false);
    Size localSize = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
    if ((localSize != null) && (localSize.getHeight() != 0)) {
      if (localSize.getWidth() / localSize.getHeight() > 1.0F) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378520));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378521));
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnClickListener(new bnyn(this));
      paramView = new GestureDetector(paramView.getContext(), new bnyo(this));
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnTouchListener(new bnyp(this, paramView));
      return;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378519));
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378519));
    }
  }
  
  private void a(@Nullable bobg parambobg)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    if ((parambobg == null) || (!this.h))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null) {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
      }
      parambobg = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      if (this.jdField_a_of_type_Bobg != null) {}
      for (bool1 = true;; bool1 = false)
      {
        parambobg.setBgmPlayed(false, bool1);
        return;
      }
    }
    String str = AEEditorMusicHelper.a(parambobg);
    boolean bool3 = AEEditorMusicHelper.a(str);
    float f1;
    float f2;
    if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
      VideoControlPanel localVideoControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      if (this.jdField_a_of_type_Bobg != null)
      {
        bool1 = true;
        localVideoControlPanel.setBgmPlayed(false, bool1);
      }
    }
    else
    {
      if (!bool3) {
        break label255;
      }
      parambobg.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(str, a(parambobg.a()), parambobg.b());
      parambobg = this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
      f1 = this.jdField_a_of_type_Float;
      f2 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Boolean) {
        break label249;
      }
    }
    label249:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(parambobg, f1, f2, bool1);
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        g(true);
      }
      parambobg = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      bool1 = bool2;
      if (this.jdField_a_of_type_Bobg != null) {
        bool1 = true;
      }
      parambobg.setBgmPlayed(true, bool1);
      return;
      bool1 = false;
      break;
    }
    label255:
    if ((getActivity() == null) || (getActivity().getAppInterface() == null))
    {
      bnrh.b(jdField_d_of_type_JavaLangString, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    if (parambobg.jdField_a_of_type_Int == 1)
    {
      bnrh.b(jdField_d_of_type_JavaLangString, "[updateSoundAndMusicConfig], editorMusicInfo=" + parambobg + ", downloadStatus=STATUS_DOWNLOADING");
      return;
    }
    parambobg.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(getActivity().getAppInterface(), parambobg, parambobg.b(), str, this), 128, null, true);
  }
  
  private void a(@NonNull bobg parambobg, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambobg.a())) {}
    label136:
    for (;;)
    {
      return;
      List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
      Iterator localIterator = localList.iterator();
      bobg localbobg;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localbobg = (bobg)localIterator.next();
          if ((localbobg != null) && (!localbobg.a()) && (parambobg.jdField_b_of_type_Int != 1) && (parambobg.jdField_b_of_type_Int != 0) && (parambobg.a().equals(localbobg.a()))) {
            if (paramBoolean) {
              localbobg.jdField_a_of_type_Int = 2;
            }
          }
        }
      }
      for (int m = 1;; m = 0)
      {
        if (m == 0) {
          break label136;
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
        return;
        localbobg.jdField_a_of_type_Int = 0;
        break;
      }
    }
  }
  
  private void a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    bnrh.b(jdField_d_of_type_JavaLangString, "[requestDetailedMusicInfo]");
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramVsMusicItemInfo.mSongMid);
    AEEditorMusicHelper.a(localArrayList, new bnyj(this, paramVsMusicItemInfo));
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
      bnrh.d(jdField_d_of_type_JavaLangString, "activity is null.");
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
    paramString1 = a(this.jdField_a_of_type_Bnwo);
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
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    while ((paramString.equals("[00:00:00]此歌曲为没有填词的纯音乐，请您欣赏")) || (paramString.length() == 0) || (paramString.equals(" ")) || (!paramString.contains("[00:"))) {
      return false;
    }
    return true;
  }
  
  private long b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "video_edit_clip_end_time";; str = "endtime")
    {
      Bundle localBundle = getArguments();
      if ((localBundle == null) || (!localBundle.containsKey(str))) {
        break;
      }
      return localBundle.getLong(str);
    }
    bnrh.d(jdField_d_of_type_JavaLangString, "no video clip start time");
    return 0L;
  }
  
  private void c(int paramInt)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel != null) && (this.jdField_a_of_type_Bobg != null))
    {
      str = this.jdField_a_of_type_Bobg.d();
      if (a(str)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric(str);
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_Bobg.e().equals("QRC"));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
  }
  
  private void f(boolean paramBoolean)
  {
    long l1 = a(paramBoolean);
    long l2 = b(paramBoolean);
    this.jdField_a_of_type_JavaLangFloat = a(paramBoolean);
    this.jdField_a_of_type_Long = ((l2 - l1) / 1000L);
    this.jdField_b_of_type_Long = (l1 / 1000L);
    if (this.l) {
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
      a("视频裁剪Range", bodl.a(this.jdField_b_of_type_Long) + "~" + bodl.a(l2 / 1000L));
      if (this.l)
      {
        O();
        N();
      }
      bnqq.a().a().jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      return;
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_a_of_type_Long), true);
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    }
  }
  
  protected void A()
  {
    bnwk localbnwk = new bnwk(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    localbnwk.a(new bnyt(this));
    bnuz.a().a(getActivity().getAppInterface(), getActivity(), localbnwk);
  }
  
  public void B()
  {
    String str = "";
    if (!TextUtils.isEmpty(bnqq.a().a().jdField_a_of_type_JavaLangString)) {
      str = bnqq.a().a().jdField_a_of_type_JavaLangString;
    }
    AEEditorMusicHelper.a(getActivity(), str);
    bnqm.a().o();
  }
  
  public void C()
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).d();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(anvx.a(2131689714));
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.a();
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
    }
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
  
  public void E()
  {
    if ((this.jdField_a_of_type_Bobg == null) || (this.jdField_a_of_type_JavaLangInteger == null))
    {
      if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      }
      return;
    }
    bobc.a().b(this.jdField_a_of_type_JavaLangInteger.intValue(), Math.min(this.jdField_a_of_type_JavaLangInteger.intValue() + this.jdField_a_of_type_Long, this.jdField_a_of_type_Bobg.b()));
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bobg);
    int m = this.jdField_a_of_type_JavaLangInteger.intValue();
    int n = this.jdField_a_of_type_Bobg.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, m, n, f1, f2, bool);
      if (!this.l) {
        break;
      }
      O();
      c(this.jdField_a_of_type_JavaLangInteger.intValue());
      return;
    }
  }
  
  public void F()
  {
    if ((this.jdField_a_of_type_Bobg == null) || (this.jdField_a_of_type_JavaLangInteger == null)) {
      return;
    }
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bobg);
    int m = a(this.jdField_a_of_type_Bobg.a());
    int n = this.jdField_a_of_type_Bobg.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, m, n, f1, f2, bool);
      if (this.l)
      {
        O();
        N();
      }
      this.jdField_a_of_type_JavaLangInteger = null;
      this.jdField_b_of_type_JavaLangInteger = null;
      return;
    }
  }
  
  public void G()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Bobg == null) || (this.jdField_a_of_type_JavaLangInteger == null)) {
      return;
    }
    a(this.jdField_a_of_type_Bobg.a(), this.jdField_a_of_type_JavaLangInteger.intValue(), true);
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bobg);
    int m = this.jdField_a_of_type_JavaLangInteger.intValue();
    int n = this.jdField_a_of_type_Bobg.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      a(str, m, n, f1, f2, bool);
      if (this.l)
      {
        O();
        N();
      }
      this.jdField_a_of_type_JavaLangInteger = null;
      this.jdField_b_of_type_JavaLangInteger = null;
      return;
      bool = false;
    }
  }
  
  public int a()
  {
    return 2131558580;
  }
  
  protected boad a()
  {
    return this;
  }
  
  protected boal a()
  {
    return new bnys(this);
  }
  
  protected bocs a()
  {
    return new bnyg(this);
  }
  
  protected bocy a()
  {
    return this;
  }
  
  protected LocalMediaInfo a(String paramString1, String paramString2, String paramString3)
  {
    return bodk.a(this.jdField_e_of_type_JavaLangString, a().getHeight(), a().getWidth(), paramString1, paramString2, paramString3);
  }
  
  protected Size a()
  {
    this.jdField_b_of_type_ComTencentTavcutBeanSize = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
    return this.jdField_a_of_type_Boby.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
  }
  
  protected TAVCutSession a()
  {
    return this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  }
  
  public StickerOperationCallback a()
  {
    return new bnyr(this);
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
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {
      return;
    }
    if (paramFloat > 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      this.jdField_a_of_type_Float = paramFloat;
      bnqq.a().a().jdField_a_of_type_Int = a(this.g, this.h);
      P();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(new CMTime(paramInt, 1000));
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setEffectStrength(paramFloat);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
    bnqq.a().a().jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(paramInt1, paramInt2);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.h();
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt1);
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
  }
  
  public void a(int paramInt, bnwd parambnwd)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.16(this, parambnwd));
    }
    if (paramInt == 0)
    {
      bnrh.b(jdField_d_of_type_JavaLangString, "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.18(this));
      if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (parambnwd != null)) {
        break label107;
      }
    }
    label107:
    bnwo localbnwo;
    do
    {
      return;
      bnrh.b(jdField_d_of_type_JavaLangString, "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.17(this));
      break;
      this.jdField_a_of_type_Bnvx.a(this.jdField_e_of_type_JavaLangString, parambnwd);
      this.jdField_a_of_type_JavaUtilArrayList = a(parambnwd);
      localbnwo = (bnwo)parambnwd;
    } while (localbnwo == null);
    a(localbnwo);
    a(new String[] { "智能滤镜label", localbnwo.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    parambnwd = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localbnwo.jdField_a_of_type_JavaLangString)) {
        break label285;
      }
      parambnwd = localNewEnhanceCategories.filterType;
    }
    label285:
    for (;;)
    {
      break;
      bnqq.a().a().jdField_b_of_type_JavaLangString = ("effect_aieffect_" + parambnwd);
      bnqq.a().a().jdField_a_of_type_Float = -1.0F;
      this.jdField_f_of_type_JavaLangString = "effect_aieffect";
      return;
    }
  }
  
  public void a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    n();
    String str1 = boaf.a().a(paramAEEditorFilterBean);
    float f2 = paramAEEditorFilterBean.getEffectExtendBean().getDefaultEffectAlpha();
    if (c(paramInt))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        break label165;
      }
    }
    label165:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).floatValue();; f1 = f2)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f1);
      float f3 = paramAEEditorFilterBean.getEffectExtendBean().getGlowStrength();
      Map localMap = paramAEEditorFilterBean.getEffectExtendBean().getAdjustParams();
      String str2 = boaf.a().c(paramAEEditorFilterBean);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModel(f1, str1, f3, localMap, str2);
      bnqq.a().a().jdField_b_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
      bnqq.a().a().jdField_a_of_type_Float = f2;
      this.jdField_f_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      break;
    }
  }
  
  protected void a(@NonNull bnwo parambnwo)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
    {
      bnrh.d(jdField_d_of_type_JavaLangString, "tavVideoSession is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(parambnwo.jdField_b_of_type_JavaLangString, 0.8F, parambnwo.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
  }
  
  public void a(@Nullable bobg parambobg, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambobg == null) || (parambobg.a())) {
      return;
    }
    this.h = true;
    this.jdField_b_of_type_Bobg = this.jdField_a_of_type_Bobg;
    this.jdField_a_of_type_Bobg = parambobg;
    bnqq.a().a().jdField_a_of_type_Int = a(this.g, this.h);
    bnqq.a().a().jdField_c_of_type_JavaLangString = parambobg.a();
    bnqq.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Bobg.jdField_b_of_type_Boolean;
    bnqq.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_Bobg.jdField_c_of_type_Int;
    bnqq.a().a().jdField_c_of_type_Int = this.jdField_a_of_type_Bobg.b();
    bnqm.a().m();
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    Iterator localIterator = localList.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      bobg localbobg = (bobg)localIterator.next();
      if ((localbobg != null) && (!localbobg.a()) && (localbobg.jdField_b_of_type_Int != 1) && (localbobg.jdField_b_of_type_Int != 0))
      {
        if (parambobg.a().equals(localbobg.a()))
        {
          localbobg.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Bobg = localbobg;
          parambobg = localbobg;
          m = 1;
        }
        for (;;)
        {
          break;
          localbobg.jdField_a_of_type_Boolean = false;
        }
      }
    }
    int n = paramInt;
    if (m == 0)
    {
      parambobg.jdField_a_of_type_Boolean = true;
      m = localList.size() - 1;
      if (paramInt <= m) {
        break label347;
      }
      n = m + 1;
      localList.add(parambobg);
    }
    for (;;)
    {
      a(parambobg.a(), parambobg.a(), false);
      a(parambobg);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(n);
      if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
        break;
      }
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(true);
      return;
      label347:
      localList.add(paramInt, parambobg);
      n = paramInt;
    }
  }
  
  public void a(@NonNull bobg parambobg, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.15(this, parambobg, paramBoolean, paramString));
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    int i1 = 0;
    if ((!paramBoolean) || (paramStSmartMatchMusicRsp == null) || (CollectionUtils.isEmpty(paramStSmartMatchMusicRsp.vecMusic.get()))) {
      bnrh.d(jdField_d_of_type_JavaLangString, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
    }
    do
    {
      return;
      if ((paramStSmartMatchMusicRsp.extInfo != null) && (paramStSmartMatchMusicRsp.extInfo.mapInfo.size() != 0))
      {
        paramVSBaseRequest = paramStSmartMatchMusicRsp.extInfo.mapInfo.get().iterator();
        while (paramVSBaseRequest.hasNext())
        {
          paramString = (COMM.Entry)paramVSBaseRequest.next();
          if ((paramString != null) && (paramString.key.get().equals("CommonInfo"))) {
            bnqq.a().a().jdField_d_of_type_JavaLangString = paramString.value.get();
          }
        }
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null);
    paramVSBaseRequest = AEEditorMusicHelper.a(paramStSmartMatchMusicRsp.vecMusic.get());
    paramString = AEEditorMusicHelper.b(paramVSBaseRequest);
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    paramStSmartMatchMusicRsp = new LinkedList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramVSBaseRequest.iterator();
    paramVSBaseRequest = "";
    if (localIterator.hasNext())
    {
      VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)localIterator.next();
      if (!TextUtils.isEmpty(paramVSBaseRequest)) {}
      for (paramVSBaseRequest = paramVSBaseRequest + "," + localVsMusicItemInfo.mSongMid;; paramVSBaseRequest = paramVSBaseRequest + localVsMusicItemInfo.mSongMid) {
        break;
      }
    }
    bnqq.a().a().jdField_e_of_type_JavaLangString = paramVSBaseRequest;
    int m = 0;
    int n = i1;
    if (m < localList.size())
    {
      paramVSBaseRequest = (bobg)localList.get(m);
      if ((paramVSBaseRequest == null) || (paramVSBaseRequest.a()) || (paramVSBaseRequest.jdField_b_of_type_Int == 0)) {}
      for (;;)
      {
        m += 1;
        break;
        paramStSmartMatchMusicRsp.add(paramVSBaseRequest);
        localHashMap.put(paramVSBaseRequest.a(), paramVSBaseRequest);
      }
    }
    if (n < paramString.size())
    {
      paramVSBaseRequest = (bobg)paramString.get(n);
      if ((paramVSBaseRequest == null) || (paramVSBaseRequest.a())) {}
      for (;;)
      {
        n += 1;
        break;
        if (localHashMap.get(paramVSBaseRequest.a()) == null) {
          paramStSmartMatchMusicRsp.add(paramVSBaseRequest);
        }
      }
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(paramStSmartMatchMusicRsp);
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
  
  protected void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AEEditorMusicHelper.a(paramString, paramInt1, paramInt2, paramLong1, paramLong1 + paramLong2, this);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    LocalMediaInfo localLocalMediaInfo = bodk.a(a(paramString1, paramString2, paramString3), getArguments().getString("material_id"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_f_of_type_JavaLangString);
    bnst localbnst = bnst.a();
    String str1 = localLocalMediaInfo.materialID;
    String str2 = localLocalMediaInfo.materialName;
    String str3 = localLocalMediaInfo.filterID;
    String str4 = localLocalMediaInfo.scheme;
    int m = localLocalMediaInfo.showCircleTakeSame;
    String str5 = this.jdField_e_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {}
    for (MediaModel localMediaModel = new MediaModel();; localMediaModel = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel())
    {
      localbnst.a(str1, str2, str3, str4, m, paramString3, str5, paramString1, paramString2, localMediaModel);
      if (getActivity() != null) {
        break;
      }
      bnrh.d(jdField_d_of_type_JavaLangString, "activity is null.");
      return;
    }
    a(paramString1, paramString2, localLocalMediaInfo);
  }
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.13(this));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)
    {
      paramBoolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) && (alps.jdField_a_of_type_Int != 2)) {
        break label77;
      }
    }
    label77:
    for (int m = 0;; m = 1)
    {
      AEEditorMusicHelper.a(paramArrayList, bnhs.a().a(), paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, m, this);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying()))
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
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
      return;
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    bnqm.a().q();
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() == 0) {
      j();
    }
    for (;;)
    {
      return true;
      if (this.jdField_c_of_type_JavaLangString.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString())))
      {
        getActivity().getIntent().putExtra("startTimeEdit", a(false));
        getActivity().getIntent().putExtra("endTimeEdit", b(false));
        getActivity().getIntent().putExtra("endSpeedEdit", a(false));
        return false;
      }
      Object localObject = getActivity();
      localObject = bhdj.a((Context)localObject, 230).setTitle(anvx.a(2131689728)).setMessage(((Context)localObject).getString(2131689729)).setPositiveButton(((Context)localObject).getString(2131689728), new bnym(this)).setNegativeButton(((Context)localObject).getString(2131689698), new bnyk(this));
      if (localObject != null) {
        try
        {
          if (!((QQCustomDialog)localObject).isShowing())
          {
            ((QQCustomDialog)localObject).show();
            return true;
          }
        }
        catch (Throwable localThrowable) {}
      }
    }
    return true;
  }
  
  protected boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    bnqq.a().a().jdField_b_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
    bnqq.a().a().jdField_a_of_type_Float = -1.0F;
    return true;
  }
  
  public void aF_()
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
    return anvx.a(2131689714);
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    P();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bobg == null) {
      return;
    }
    bobc.a().b(paramInt, Math.min(paramInt + this.jdField_a_of_type_Long, this.jdField_a_of_type_Bobg.b()));
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bobg);
    int m = this.jdField_a_of_type_Bobg.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, paramInt, m, f1, f2, bool);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.b(paramInt);
      m = (int)(paramInt + this.jdField_a_of_type_Long);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(paramInt, m);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.h();
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(m);
      if (!this.l) {
        break;
      }
      O();
      c(this.jdField_a_of_type_JavaLangInteger.intValue());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  protected void c()
  {
    this.jdField_e_of_type_JavaLangString = d();
    this.i = bnri.a();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {}
    List localList;
    do
    {
      return;
      this.h = paramBoolean;
      bnqq.a().a().jdField_a_of_type_Int = a(this.g, this.h);
      localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    } while (CollectionUtils.isEmpty(localList));
    Object localObject;
    int n;
    int m;
    if (paramBoolean)
    {
      if ((this.jdField_b_of_type_Bobg == null) || (this.jdField_b_of_type_Bobg.a())) {
        break label517;
      }
      int i1 = 0;
      localObject = null;
      n = 0;
      m = 0;
      if (i1 < localList.size())
      {
        bobg localbobg = (bobg)localList.get(i1);
        int i2;
        if ((localbobg != null) && (!localbobg.a()) && (localbobg.jdField_b_of_type_Int != 1)) {
          if (localbobg.jdField_b_of_type_Int == 0)
          {
            i2 = n;
            n = m;
            m = i2;
          }
        }
        for (;;)
        {
          i2 = i1 + 1;
          i1 = n;
          n = m;
          m = i1;
          i1 = i2;
          break;
          if (this.jdField_b_of_type_Bobg.a().equals(localbobg.a()))
          {
            localbobg.jdField_a_of_type_Boolean = true;
            m = 1;
            n = i1;
            localObject = localbobg;
          }
          else
          {
            localbobg.jdField_a_of_type_Boolean = false;
            i2 = m;
            m = n;
            n = i2;
          }
        }
      }
    }
    for (;;)
    {
      if (n != 0)
      {
        this.jdField_b_of_type_Bobg = ((bobg)localObject);
        this.jdField_a_of_type_Bobg = ((bobg)localObject);
        label236:
        this.jdField_a_of_type_Bobg.jdField_a_of_type_Boolean = true;
        bnqq.a().a().jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bobg.a();
        bnqq.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Bobg.jdField_b_of_type_Boolean;
        bnqq.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_Bobg.jdField_c_of_type_Int;
        bnqq.a().a().jdField_c_of_type_Int = this.jdField_a_of_type_Bobg.b();
        bnqm.a().m();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Bobg != null) {
          a(this.jdField_a_of_type_Bobg.a(), this.jdField_a_of_type_Bobg.a(), false);
        }
        a(this.jdField_a_of_type_Bobg);
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
        if (paramBoolean) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(m);
        }
        if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
          break;
        }
        ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(paramBoolean);
        return;
        this.jdField_b_of_type_Bobg = null;
        this.jdField_a_of_type_Bobg = ((bobg)localList.get(1));
        break label236;
        this.jdField_b_of_type_Bobg = this.jdField_a_of_type_Bobg;
        this.jdField_a_of_type_Bobg = null;
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bobg)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
        }
        bnqq.a().a().jdField_c_of_type_JavaLangString = "none";
        bnqq.a().a().jdField_a_of_type_Boolean = false;
        bnqq.a().a().jdField_b_of_type_Int = -1;
        bnqq.a().a().jdField_c_of_type_Int = -1;
        m = 0;
      }
      label517:
      localObject = null;
      n = 0;
      m = 0;
    }
  }
  
  protected String d()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("select_path"))) {
      return localBundle.getString("select_path");
    }
    bnrh.d(jdField_d_of_type_JavaLangString, "no video paths");
    return null;
  }
  
  protected void d()
  {
    bnuz.a().a();
  }
  
  public void d(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_Bobg == null))
    {
      QQToast.a(getActivity(), 2131689724, 0).a();
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(this.jdField_a_of_type_Bobg, Integer.valueOf(a(this.jdField_a_of_type_Bobg.a())), (int)this.jdField_a_of_type_Long, this.jdField_d_of_type_Boolean);
    this.jdField_d_of_type_Boolean = false;
  }
  
  protected String e()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  protected void e() {}
  
  public void e(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Bobg != null)
      {
        if (a(this.jdField_a_of_type_Bobg.d())) {
          break label51;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        N();
        return;
        label51:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    O();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
    }
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_Bnvx.a(this.jdField_e_of_type_JavaLangString);
    boolean bool1;
    if ((localObject != null) && ((localObject instanceof bnwo)))
    {
      bnrh.b(jdField_d_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool1 = ((bnwo)localObject).jdField_a_of_type_Boolean;
      if (!bool1) {
        break label98;
      }
      k();
      localObject = new bnwn(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((bnwn)localObject).a(this);
      bnuz.a().a(getActivity().getAppInterface(), getActivity(), (bnvy)localObject);
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
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(((bnwd)localObject).b(), 0.8F, ((bnwd)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((bnwd)localObject).a(), "智能滤镜errCode", "0" });
    }
  }
  
  public void g()
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.11(this));
    String str1 = bnss.jdField_d_of_type_JavaLangString;
    Object localObject = new File(str1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File localFile = new File(this.jdField_e_of_type_JavaLangString);
    localObject = e();
    String str2 = str1 + File.separator + "output_" + (String)localObject + "_" + bpjt.a(localFile.getName()) + ".jpg";
    str1 = str1 + File.separator + "output_" + (String)localObject + "_" + bpjt.a(localFile.getName()) + ".mp4";
    M();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getEffectVideoFrame(0L, 1080, new bnyi(this, str2, str1, (String)localObject));
      return;
    }
    a(str1, str2, (String)localObject);
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.c();
    }
  }
  
  public void j()
  {
    if (!c()) {
      return;
    }
    super.j();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(anvx.a(2131689714));
  }
  
  protected void m()
  {
    this.k = true;
    I();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bnrh.b(jdField_d_of_type_JavaLangString, "onCreate");
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
    paramBundle = bnqq.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {}
    for (int m = 0;; m = 1)
    {
      paramBundle.jdField_e_of_type_Int = m;
      return;
    }
  }
  
  public void onDeleteSticker()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.i();
    }
  }
  
  public void onDestroyView()
  {
    bnrh.b(jdField_d_of_type_JavaLangString, "onDestroyView");
    super.onDestroyView();
    if (getArguments() != null) {
      getArguments().clear();
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer.b();
      if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer instanceof VideoControlPanel)) {
        ((VideoControlPanel)this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer).e();
      }
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.g = true;
    this.h = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.8F;
    this.jdField_a_of_type_Bobg = null;
    this.jdField_b_of_type_Bobg = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (!paramBoolean)
    {
      bnqm.a().r();
      f(true);
      a(true, true);
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    b(false);
  }
  
  public void onPause()
  {
    super.onPause();
    bnrh.b(jdField_d_of_type_JavaLangString, "onPause");
    if (!this.jdField_e_of_type_Boolean) {
      b(false);
    }
  }
  
  public void onResume()
  {
    bnrh.b(jdField_d_of_type_JavaLangString, "onResume");
    super.onResume();
    if (!this.jdField_e_of_type_Boolean)
    {
      bnqm.a().r();
      b(true);
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null) {
        a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bnrh.b(jdField_d_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    s();
    I();
    H();
    bnqq.a().a().jdField_c_of_type_JavaLangString = "none";
    bnqq.a().a().jdField_a_of_type_Boolean = false;
    bnqq.a().a().jdField_b_of_type_Int = -1;
    bnqq.a().a().jdField_c_of_type_Int = -1;
    bnqq.a().a().jdField_a_of_type_Int = a(this.g, this.h);
    bnqq.a().a().jdField_d_of_type_JavaLangString = "none";
    bnqq.a().a().jdField_e_of_type_JavaLangString = "none";
    paramView = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
    a(this.jdField_e_of_type_JavaLangString, paramView.getWidth(), paramView.getHeight(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    a(new String[] { "设备级别", bobx.a(), "视频最大预览尺寸", String.valueOf(this.jdField_a_of_type_Boby.a()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出码率", String.valueOf(this.jdField_a_of_type_Boby.b()), "视频导出帧率", String.valueOf(this.jdField_a_of_type_Boby.c()) });
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (e())) {
      if (boaf.a().b())
      {
        bnrh.b(jdField_d_of_type_JavaLangString, "single image + first time : aifilter auto request");
        f();
        o();
        bnqm.a().w();
      }
    }
    for (int m = 1;; m = 0)
    {
      if ((boaf.a().b()) && (m == 0)) {
        A();
      }
      return;
      bnrh.d(jdField_d_of_type_JavaLangString, "single image + first time : aifilter res not ready, do not request");
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165216));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new bnyq(this));
  }
  
  protected void s()
  {
    r();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Boby.a());
    StickerEditViewIconConfig localStickerEditViewIconConfig = new StickerEditViewIconConfig();
    localStickerEditViewIconConfig.setDeleteIconResId(2130837820);
    localStickerEditViewIconConfig.setEditIconResId(2130837759);
    localStickerEditViewIconConfig.setZoomIconResId(2130837833);
    localSessionConfig.setStickerEditViewIconConfig(localStickerEditViewIconConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerLyricCallback(this);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(getActivity());
    f(false);
    this.jdField_c_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
  }
  
  public void t()
  {
    n();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.clearAEKitModel();
    bnqq.a().a().jdField_b_of_type_JavaLangString = "effect_blank";
    bnqq.a().a().jdField_a_of_type_Float = -1.0F;
  }
  
  public void u() {}
  
  public void v() {}
  
  public void w() {}
  
  public void x()
  {
    getActivity().getIntent().putExtra("startTimeEdit", this.jdField_b_of_type_Long * 1000L);
    getActivity().getIntent().putExtra("endTimeEdit", (this.jdField_b_of_type_Long + this.jdField_a_of_type_Long) * 1000L);
    Intent localIntent = getActivity().getIntent();
    if (this.jdField_a_of_type_JavaLangFloat != null) {}
    for (float f1 = this.jdField_a_of_type_JavaLangFloat.floatValue();; f1 = 1.0F)
    {
      localIntent.putExtra("endSpeedEdit", f1);
      bnqm.a().a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
      K();
      return;
    }
  }
  
  public void y()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.b();
    i();
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      if ("sticker_lyric".equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getStickerType())) {
        f();
      }
    }
    else {
      f();
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    L();
  }
  
  public void z()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(anvx.a(2131689691));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.c();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      P();
    }
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).e();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      bnqm.a().k();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */