package dov.com.qq.im.aeeditor.module.edit;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import aaxg;
import alin;
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
import anni;
import bglp;
import bgpa;
import bnnx;
import bnyh;
import bnyl;
import bnyo;
import bnzb;
import bnzc;
import bnzp;
import bnzu;
import bnzv;
import bnzw;
import bocc;
import boce;
import bocy;
import bocz;
import bode;
import bodk;
import bodl;
import bofb;
import bofd;
import bofe;
import boff;
import bofg;
import bofh;
import bofi;
import bofj;
import bofk;
import bofl;
import bofm;
import bofn;
import bofo;
import bofu;
import bofw;
import bogc;
import bogs;
import bogt;
import bogx;
import bohe;
import bohj;
import bohn;
import boho;
import bohp;
import boij;
import boip;
import boit;
import boiv;
import bojb;
import bojc;
import bpye;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
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
import zxa;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements aaxg, boce, bofu, bogs, bohe, bohj, boit, StickerLyricCallback, zxa<CLIENT.StSmartMatchMusicRsp>
{
  private static final String jdField_c_of_type_JavaLangString = AEEditorVideoEditFragment.class.getSimpleName();
  private float jdField_a_of_type_Float = 1.0F;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bocy jdField_a_of_type_Bocy = new bocy();
  private bogx jdField_a_of_type_Bogx;
  private bohp jdField_a_of_type_Bohp = bohn.a();
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private Size jdField_a_of_type_ComTencentTavcutBeanSize;
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private TAVCutVideoView jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView;
  private MusicData jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
  private SubtitleModel jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel;
  private VideoControlPanel jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
  private Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, Float> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private float jdField_b_of_type_Float = 0.8F;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bogx jdField_b_of_type_Bogx;
  private Size jdField_b_of_type_ComTencentTavcutBeanSize;
  private Integer jdField_b_of_type_JavaLangInteger;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  static
  {
    File localFile = new File(bnzu.jdField_c_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bofb(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165216));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new bofl(this));
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Bohp.a());
    StickerEditViewIconConfig localStickerEditViewIconConfig = new StickerEditViewIconConfig();
    localStickerEditViewIconConfig.setDeleteIconResId(2130837728);
    localStickerEditViewIconConfig.setEditIconResId(2130837727);
    localStickerEditViewIconConfig.setZoomIconResId(2130837729);
    localSessionConfig.setStickerEditViewIconConfig(localStickerEditViewIconConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerLyricCallback(this);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(new bofm(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(getActivity());
    e(false);
    this.jdField_e_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
  }
  
  private void F()
  {
    if ((!this.j) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.k))
    {
      this.j = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void G()
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
  
  private void H()
  {
    bnyl.a().a().h = 0;
    bnyh.a().j();
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null)
    {
      bnyl.a().a().jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().size();
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList(), 0);
    }
    bnyh.a().i();
  }
  
  private void J()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel == null) && (this.jdField_a_of_type_Bogx != null))
    {
      localObject2 = this.jdField_a_of_type_Bogx.d();
      if (a((String)localObject2)) {}
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = new SubtitleModel();
      ((SubtitleModel)localObject1).setAssetFilePath("ae_editor_lyric_default.pag");
      Size localSize = VideoUtil.getVideoSize(this.jdField_d_of_type_JavaLangString);
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
        ((SubtitleModel)localObject1).setLyricFormatIsQRC(this.jdField_a_of_type_Bogx.e().equals("QRC"));
        ((SubtitleModel)localObject1).setMusicStartTime(a(this.jdField_a_of_type_Bogx.a()));
        localObject2 = bofw.a().a("font_runyuan75w");
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
      if (this.jdField_a_of_type_Bogx == null) {
        break;
      }
      localObject1 = this.jdField_a_of_type_Bogx.d();
    } while (!a((String)localObject1));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric((String)localObject1);
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_Bogx.e().equals("QRC"));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(a(this.jdField_a_of_type_Bogx.a()));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
  }
  
  private void K()
  {
    a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.deleteLyricSticker();
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
    } while (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData == null);
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (this.jdField_e_of_type_Boolean) {}
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
    bnzb.d(jdField_c_of_type_JavaLangString, "no video clip start time");
    return 0L;
  }
  
  private Size a()
  {
    this.jdField_b_of_type_ComTencentTavcutBeanSize = VideoUtil.getVideoSize(this.jdField_d_of_type_JavaLangString);
    return this.jdField_a_of_type_Bohp.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
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
      bnzb.a(jdField_c_of_type_JavaLangString, "speed = " + localObject);
      return localObject;
      localObject = "speed";
      break;
      label69:
      bnzb.d(jdField_c_of_type_JavaLangString, "no speed");
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel = ((VideoControlPanel)this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.setMusicListOperationCallback(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.setMusicLyricOperationCallback(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378309));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bofh(this));
    g(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378310));
    Size localSize = VideoUtil.getVideoSize(this.jdField_d_of_type_JavaLangString);
    if ((localSize != null) && (localSize.getHeight() != 0)) {
      if (localSize.getWidth() / localSize.getHeight() > 1.0F) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378307));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378308));
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnClickListener(new bofi(this));
      paramView = new GestureDetector(paramView.getContext(), new bofj(this));
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnTouchListener(new bofk(this, paramView));
      return;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378306));
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378306));
    }
  }
  
  private void a(@Nullable bogx parambogx)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    if ((parambogx == null) || (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null) {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
      }
      parambogx = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      if (this.jdField_a_of_type_Bogx != null) {}
      for (bool1 = true;; bool1 = false)
      {
        parambogx.setBgmPlayed(false, bool1);
        return;
      }
    }
    String str = AEEditorMusicHelper.a(parambogx);
    boolean bool3 = AEEditorMusicHelper.a(str);
    float f1;
    float f2;
    if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
      VideoControlPanel localVideoControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      if (this.jdField_a_of_type_Bogx != null)
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
      parambogx.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(str, a(parambogx.a()), parambogx.b());
      parambogx = this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
      f1 = this.jdField_a_of_type_Float;
      f2 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Boolean) {
        break label249;
      }
    }
    label249:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(parambogx, f1, f2, bool1);
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        g(true);
      }
      parambogx = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      bool1 = bool2;
      if (this.jdField_a_of_type_Bogx != null) {
        bool1 = true;
      }
      parambogx.setBgmPlayed(true, bool1);
      return;
      bool1 = false;
      break;
    }
    label255:
    if ((getActivity() == null) || (getActivity().getAppInterface() == null))
    {
      bnzb.b(jdField_c_of_type_JavaLangString, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    if (parambogx.jdField_a_of_type_Int == 1)
    {
      bnzb.b(jdField_c_of_type_JavaLangString, "[updateSoundAndMusicConfig], editorMusicInfo=" + parambogx + ", downloadStatus=STATUS_DOWNLOADING");
      return;
    }
    parambogx.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(getActivity().getAppInterface(), parambogx, parambogx.b(), str, this), 128, null, true);
  }
  
  private void a(@NonNull bogx parambogx, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambogx.a())) {}
    label136:
    for (;;)
    {
      return;
      List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
      Iterator localIterator = localList.iterator();
      bogx localbogx;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localbogx = (bogx)localIterator.next();
          if ((localbogx != null) && (!localbogx.a()) && (parambogx.jdField_b_of_type_Int != 1) && (parambogx.jdField_b_of_type_Int != 0) && (parambogx.a().equals(localbogx.a()))) {
            if (paramBoolean) {
              localbogx.jdField_a_of_type_Int = 2;
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
        localbogx.jdField_a_of_type_Int = 0;
        break;
      }
    }
  }
  
  private void a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    bnzb.b(jdField_c_of_type_JavaLangString, "[requestDetailedMusicInfo]");
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramVsMusicItemInfo.mSongMid);
    AEEditorMusicHelper.a(localArrayList, new bofe(this, paramVsMusicItemInfo));
  }
  
  private void a(@NonNull MusicData paramMusicData, float paramFloat1, float paramFloat2, boolean paramBoolean)
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
  
  private void a(SubtitleModel paramSubtitleModel)
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
  
  private void a(@NonNull String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(paramString, paramInt1, paramInt2);
    a(this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData, paramFloat1, paramFloat2, paramBoolean);
  }
  
  private void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AEEditorMusicHelper.a(paramString, paramInt1, paramInt2, paramLong1, paramLong1 + paramLong2, this);
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
      bnzb.d(jdField_c_of_type_JavaLangString, "activity is null.");
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
    localIntent.putStringArrayListExtra("ae_editor_video_text_cache", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("ae_editor_video_from", this.jdField_b_of_type_Int);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying()))
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
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
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
    bnzb.d(jdField_c_of_type_JavaLangString, "no video clip start time");
    return 0L;
  }
  
  private void c(int paramInt)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel != null) && (this.jdField_a_of_type_Bogx != null))
    {
      str = this.jdField_a_of_type_Bogx.d();
      if (a(str)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric(str);
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_Bogx.e().equals("QRC"));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
  }
  
  private void e(boolean paramBoolean)
  {
    long l1 = a(paramBoolean);
    long l2 = b(paramBoolean);
    this.jdField_a_of_type_JavaLangFloat = a(paramBoolean);
    this.jdField_b_of_type_Long = ((l2 - l1) / 1000L);
    this.jdField_a_of_type_Long = (l1 / 1000L);
    if (this.l) {
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
    }
    if (this.jdField_a_of_type_JavaLangFloat != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(((float)this.jdField_a_of_type_Long * this.jdField_a_of_type_JavaLangFloat.floatValue())), Long.valueOf(((float)this.jdField_b_of_type_Long * this.jdField_a_of_type_JavaLangFloat.floatValue())));
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSpeed(this.jdField_a_of_type_JavaLangFloat.floatValue(), true);
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange(CMTime.fromMs(0L), CMTime.fromMs(this.jdField_b_of_type_Long)));
    }
    for (;;)
    {
      a("视频裁剪Range", bojc.a(this.jdField_a_of_type_Long) + "~" + bojc.a(l2 / 1000L));
      if (this.l)
      {
        K();
        J();
      }
      bnyl.a().a().jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      return;
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), true);
    }
  }
  
  private String f()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("select_path"))) {
      return localBundle.getString("select_path");
    }
    bnzb.d(jdField_c_of_type_JavaLangString, "no video paths");
    return null;
  }
  
  private void f(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    }
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_Bogx == null) || (this.jdField_a_of_type_JavaLangInteger == null))
    {
      if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      }
      return;
    }
    bogt.a().b(this.jdField_a_of_type_JavaLangInteger.intValue(), Math.min(this.jdField_a_of_type_JavaLangInteger.intValue() + this.jdField_b_of_type_Long, this.jdField_a_of_type_Bogx.b()));
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bogx);
    int m = this.jdField_a_of_type_JavaLangInteger.intValue();
    int n = this.jdField_a_of_type_Bogx.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, m, n, f1, f2, bool);
      if (!this.l) {
        break;
      }
      K();
      c(this.jdField_a_of_type_JavaLangInteger.intValue());
      return;
    }
  }
  
  public void B()
  {
    if ((this.jdField_a_of_type_Bogx == null) || (this.jdField_a_of_type_JavaLangInteger == null)) {
      return;
    }
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bogx);
    int m = a(this.jdField_a_of_type_Bogx.a());
    int n = this.jdField_a_of_type_Bogx.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, m, n, f1, f2, bool);
      if (this.l)
      {
        K();
        J();
      }
      this.jdField_a_of_type_JavaLangInteger = null;
      this.jdField_b_of_type_JavaLangInteger = null;
      return;
    }
  }
  
  public void C()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Bogx == null) || (this.jdField_a_of_type_JavaLangInteger == null)) {
      return;
    }
    a(this.jdField_a_of_type_Bogx.a(), this.jdField_a_of_type_JavaLangInteger.intValue(), true);
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bogx);
    int m = this.jdField_a_of_type_JavaLangInteger.intValue();
    int n = this.jdField_a_of_type_Bogx.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      a(str, m, n, f1, f2, bool);
      if (this.l)
      {
        K();
        J();
      }
      this.jdField_a_of_type_JavaLangInteger = null;
      this.jdField_b_of_type_JavaLangInteger = null;
      return;
      bool = false;
    }
  }
  
  public int a()
  {
    return 2131558565;
  }
  
  protected bofu a()
  {
    return this;
  }
  
  protected bogc a()
  {
    return new bofn(this);
  }
  
  protected boij a()
  {
    return new bofo(this);
  }
  
  protected boip a()
  {
    return this;
  }
  
  protected TAVCutSession a()
  {
    return this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
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
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {
      return;
    }
    if (paramFloat > 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      this.jdField_a_of_type_Float = paramFloat;
      bnyl.a().a().jdField_a_of_type_Int = a(this.jdField_d_of_type_Boolean, this.jdField_e_of_type_Boolean);
      L();
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
    bnyl.a().a().jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(paramInt1, paramInt2);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.h();
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt1);
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
  }
  
  public void a(int paramInt, bode parambode)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.15(this, parambode));
    }
    if (paramInt == 0)
    {
      bnzb.b(jdField_c_of_type_JavaLangString, "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.17(this));
      if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (parambode != null)) {
        break label107;
      }
    }
    label107:
    bodl localbodl;
    do
    {
      return;
      bnzb.b(jdField_c_of_type_JavaLangString, "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.16(this));
      break;
      this.jdField_a_of_type_Bocy.a(this.jdField_d_of_type_JavaLangString, parambode);
      this.jdField_a_of_type_JavaUtilArrayList = a(parambode);
      localbodl = (bodl)parambode;
    } while (localbodl == null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(localbodl.jdField_b_of_type_JavaLangString, 0.8F, localbodl.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
    a(new String[] { "智能滤镜label", localbodl.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    parambode = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localbodl.jdField_a_of_type_JavaLangString)) {
        break label299;
      }
      parambode = localNewEnhanceCategories.filterType;
    }
    label299:
    for (;;)
    {
      break;
      bnyl.a().a().jdField_b_of_type_JavaLangString = ("effect_aieffect_" + parambode);
      bnyl.a().a().jdField_a_of_type_Float = -1.0F;
      this.jdField_f_of_type_JavaLangString = "effect_aieffect";
      return;
    }
  }
  
  public void a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    n();
    String str1 = bofw.a().a(paramAEEditorFilterBean);
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
      String str2 = bofw.a().c(paramAEEditorFilterBean);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModel(f1, str1, f3, localMap, str2);
      bnyl.a().a().jdField_b_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
      bnyl.a().a().jdField_a_of_type_Float = f2;
      this.jdField_f_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      break;
    }
  }
  
  public void a(@Nullable bogx parambogx, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambogx == null) || (parambogx.a())) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Bogx = this.jdField_a_of_type_Bogx;
    this.jdField_a_of_type_Bogx = parambogx;
    bnyl.a().a().jdField_a_of_type_Int = a(this.jdField_d_of_type_Boolean, this.jdField_e_of_type_Boolean);
    bnyl.a().a().jdField_c_of_type_JavaLangString = parambogx.a();
    bnyl.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Bogx.jdField_b_of_type_Boolean;
    bnyl.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_Bogx.jdField_c_of_type_Int;
    bnyl.a().a().jdField_c_of_type_Int = this.jdField_a_of_type_Bogx.b();
    bnyh.a().n();
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    Iterator localIterator = localList.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      bogx localbogx = (bogx)localIterator.next();
      if ((localbogx != null) && (!localbogx.a()) && (localbogx.jdField_b_of_type_Int != 1) && (localbogx.jdField_b_of_type_Int != 0))
      {
        if (parambogx.a().equals(localbogx.a()))
        {
          localbogx.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Bogx = localbogx;
          parambogx = localbogx;
          m = 1;
        }
        for (;;)
        {
          break;
          localbogx.jdField_a_of_type_Boolean = false;
        }
      }
    }
    int n = paramInt;
    if (m == 0)
    {
      parambogx.jdField_a_of_type_Boolean = true;
      m = localList.size() - 1;
      if (paramInt <= m) {
        break label347;
      }
      n = m + 1;
      localList.add(parambogx);
    }
    for (;;)
    {
      a(parambogx.a(), parambogx.a(), false);
      a(parambogx);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(n);
      if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
        break;
      }
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(true);
      return;
      label347:
      localList.add(paramInt, parambogx);
      n = paramInt;
    }
  }
  
  public void a(@NonNull bogx parambogx, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.14(this, parambogx, paramBoolean, paramString));
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    int i1 = 0;
    if ((!paramBoolean) || (paramStSmartMatchMusicRsp == null) || (CollectionUtils.isEmpty(paramStSmartMatchMusicRsp.vecMusic.get()))) {
      bnzb.d(jdField_c_of_type_JavaLangString, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
    }
    do
    {
      return;
      if ((paramStSmartMatchMusicRsp.extInfo != null) && (paramStSmartMatchMusicRsp.extInfo.mapInfo.size() != 0))
      {
        paramString = paramStSmartMatchMusicRsp.extInfo.mapInfo.get().iterator();
        while (paramString.hasNext())
        {
          localObject = (COMM.Entry)paramString.next();
          if ((localObject != null) && (((COMM.Entry)localObject).key.get().equals("CommonInfo"))) {
            bnyl.a().a().jdField_d_of_type_JavaLangString = ((COMM.Entry)localObject).value.get();
          }
        }
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null);
    paramString = AEEditorMusicHelper.a(paramStSmartMatchMusicRsp.vecMusic.get());
    paramStSmartMatchMusicRsp = AEEditorMusicHelper.b(paramString);
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    Object localObject = new LinkedList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramString.iterator();
    paramString = "";
    if (localIterator.hasNext())
    {
      VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)localIterator.next();
      if (!TextUtils.isEmpty(paramString)) {}
      for (paramString = paramString + "," + localVsMusicItemInfo.mSongMid;; paramString = paramString + localVsMusicItemInfo.mSongMid) {
        break;
      }
    }
    bnyl.a().a().jdField_e_of_type_JavaLangString = paramString;
    int m = 0;
    int n = i1;
    if (m < localList.size())
    {
      paramString = (bogx)localList.get(m);
      if ((paramString == null) || (paramString.a()) || (paramString.jdField_b_of_type_Int == 0)) {}
      for (;;)
      {
        m += 1;
        break;
        ((List)localObject).add(paramString);
        localHashMap.put(paramString.a(), paramString);
      }
    }
    if (n < paramStSmartMatchMusicRsp.size())
    {
      paramString = (bogx)paramStSmartMatchMusicRsp.get(n);
      if ((paramString == null) || (paramString.a())) {}
      for (;;)
      {
        n += 1;
        break;
        if (localHashMap.get(paramString.a()) == null) {
          ((List)localObject).add(paramString);
        }
      }
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a((List)localObject);
  }
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.12(this));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)
    {
      paramBoolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) && (alin.jdField_a_of_type_Int != 2)) {
        break label77;
      }
    }
    label77:
    for (int m = 0;; m = 1)
    {
      AEEditorMusicHelper.a(paramArrayList, bnnx.a().a(), paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, m, this);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean a()
  {
    bnyh.a().r();
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() == 0) {
      j();
    }
    for (;;)
    {
      return true;
      if (this.jdField_e_of_type_JavaLangString.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString())))
      {
        getActivity().getIntent().putExtra("startTimeEdit", a(false));
        getActivity().getIntent().putExtra("endTimeEdit", b(false));
        getActivity().getIntent().putExtra("endSpeedEdit", a(false));
        return false;
      }
      Object localObject = getActivity();
      localObject = bglp.a((Context)localObject, 230).setTitle(anni.a(2131689705)).setMessage(((Context)localObject).getString(2131689706)).setPositiveButton(((Context)localObject).getString(2131689705), new bofg(this)).setNegativeButton(((Context)localObject).getString(2131689684), new boff(this));
      if (localObject != null) {
        try
        {
          if (!((bgpa)localObject).isShowing())
          {
            ((bgpa)localObject).show();
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
    bnyl.a().a().jdField_b_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
    bnyl.a().a().jdField_a_of_type_Float = -1.0F;
    return true;
  }
  
  public void aS_()
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
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    L();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bogx == null) {
      return;
    }
    bogt.a().b(paramInt, Math.min(paramInt + this.jdField_b_of_type_Long, this.jdField_a_of_type_Bogx.b()));
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bogx);
    int m = this.jdField_a_of_type_Bogx.b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, paramInt, m, f1, f2, bool);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.b(paramInt);
      m = (int)(paramInt + this.jdField_b_of_type_Long);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(paramInt, m);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.h();
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(m);
      if (!this.l) {
        break;
      }
      K();
      c(this.jdField_a_of_type_JavaLangInteger.intValue());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {}
    List localList;
    do
    {
      return;
      this.jdField_e_of_type_Boolean = paramBoolean;
      bnyl.a().a().jdField_a_of_type_Int = a(this.jdField_d_of_type_Boolean, this.jdField_e_of_type_Boolean);
      localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    } while (CollectionUtils.isEmpty(localList));
    Object localObject;
    int n;
    int m;
    if (paramBoolean)
    {
      if ((this.jdField_b_of_type_Bogx == null) || (this.jdField_b_of_type_Bogx.a())) {
        break label517;
      }
      int i1 = 0;
      localObject = null;
      n = 0;
      m = 0;
      if (i1 < localList.size())
      {
        bogx localbogx = (bogx)localList.get(i1);
        int i2;
        if ((localbogx != null) && (!localbogx.a()) && (localbogx.jdField_b_of_type_Int != 1)) {
          if (localbogx.jdField_b_of_type_Int == 0)
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
          if (this.jdField_b_of_type_Bogx.a().equals(localbogx.a()))
          {
            localbogx.jdField_a_of_type_Boolean = true;
            m = 1;
            n = i1;
            localObject = localbogx;
          }
          else
          {
            localbogx.jdField_a_of_type_Boolean = false;
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
        this.jdField_b_of_type_Bogx = ((bogx)localObject);
        this.jdField_a_of_type_Bogx = ((bogx)localObject);
        label236:
        this.jdField_a_of_type_Bogx.jdField_a_of_type_Boolean = true;
        bnyl.a().a().jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bogx.a();
        bnyl.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Bogx.jdField_b_of_type_Boolean;
        bnyl.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_Bogx.jdField_c_of_type_Int;
        bnyl.a().a().jdField_c_of_type_Int = this.jdField_a_of_type_Bogx.b();
        bnyh.a().n();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Bogx != null) {
          a(this.jdField_a_of_type_Bogx.a(), this.jdField_a_of_type_Bogx.a(), false);
        }
        a(this.jdField_a_of_type_Bogx);
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
        if (paramBoolean) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(m);
        }
        if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
          break;
        }
        ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(paramBoolean);
        return;
        this.jdField_b_of_type_Bogx = null;
        this.jdField_a_of_type_Bogx = ((bogx)localList.get(1));
        break label236;
        this.jdField_b_of_type_Bogx = this.jdField_a_of_type_Bogx;
        this.jdField_a_of_type_Bogx = null;
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bogx)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
        }
        bnyl.a().a().jdField_c_of_type_JavaLangString = "none";
        bnyl.a().a().jdField_a_of_type_Boolean = false;
        bnyl.a().a().jdField_b_of_type_Int = -1;
        bnyl.a().a().jdField_c_of_type_Int = -1;
        m = 0;
      }
      label517:
      localObject = null;
      n = 0;
      m = 0;
    }
  }
  
  public String c()
  {
    return anni.a(2131689691);
  }
  
  protected void c()
  {
    this.jdField_d_of_type_JavaLangString = f();
    this.i = bnzc.a();
  }
  
  public void c(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_Bogx == null))
    {
      QQToast.a(getActivity(), 2131689701, 0).a();
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(this.jdField_a_of_type_Bogx, Integer.valueOf(a(this.jdField_a_of_type_Bogx.a())), (int)this.jdField_b_of_type_Long, this.g);
    this.g = false;
  }
  
  protected void d()
  {
    bocc.a().a();
  }
  
  public void d(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Bogx != null)
      {
        if (a(this.jdField_a_of_type_Bogx.d())) {
          break label51;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        J();
        return;
        label51:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    K();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected void e() {}
  
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
    Object localObject = this.jdField_a_of_type_Bocy.a(this.jdField_d_of_type_JavaLangString);
    boolean bool1;
    if ((localObject != null) && ((localObject instanceof bodl)))
    {
      bnzb.b(jdField_c_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool1 = ((bodl)localObject).jdField_a_of_type_Boolean;
      if (!bool1) {
        break label98;
      }
      k();
      localObject = new bodk(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((bodk)localObject).a(this);
      bocc.a().a(getActivity().getAppInterface(), getActivity(), (bocz)localObject);
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
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(((bode)localObject).b(), 0.8F, ((bode)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((bode)localObject).a(), "智能滤镜errCode", "0" });
    }
  }
  
  public void g()
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.10(this));
    String str2 = bnzv.jdField_d_of_type_JavaLangString;
    Object localObject1 = new File(str2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = new File(this.jdField_d_of_type_JavaLangString);
    localObject1 = String.valueOf(System.currentTimeMillis());
    String str1 = str2 + File.separator + "output_" + (String)localObject1 + "_" + bpye.a(((File)localObject2).getName()) + ".jpg";
    str2 = str2 + File.separator + "output_" + (String)localObject1 + "_" + bpye.a(((File)localObject2).getName()) + ".mp4";
    I();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getEffectVideoFrame(0L, 1080, new bofd(this, str1, str2, (String)localObject1));
      return;
    }
    localObject2 = bojb.a(bojb.a(a().getHeight(), a().getWidth(), str2, str1, (String)localObject1), getArguments().getString("material_id"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_f_of_type_JavaLangString);
    bnzw.a().a(((LocalMediaInfo)localObject2).materialID, ((LocalMediaInfo)localObject2).materialName, ((LocalMediaInfo)localObject2).filterID, ((LocalMediaInfo)localObject2).scheme, (String)localObject1, this.jdField_d_of_type_JavaLangString, str2, str1, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
    if (getActivity() == null)
    {
      boiv.a(BaseApplicationImpl.getContext(), str2, str1, a(), this.jdField_a_of_type_JavaUtilArrayList, (LocalMediaInfo)localObject2, this.jdField_b_of_type_Int);
      return;
    }
    a(str2, str1, (LocalMediaInfo)localObject2);
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
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(anni.a(2131689691));
  }
  
  protected void m()
  {
    this.k = true;
    F();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bnzb.b(jdField_c_of_type_JavaLangString, "onCreate");
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
    paramBundle = bnyl.a().a();
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
    bnzb.b(jdField_c_of_type_JavaLangString, "onDestroyView");
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
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.8F;
    this.jdField_a_of_type_Bogx = null;
    this.jdField_b_of_type_Bogx = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    this.g = false;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.h = paramBoolean;
    if (!paramBoolean)
    {
      bnyh.a().s();
      e(true);
      a(true, true);
      this.g = true;
      return;
    }
    f(false);
  }
  
  public void onPause()
  {
    super.onPause();
    bnzb.b(jdField_c_of_type_JavaLangString, "onPause");
    if (!this.h) {
      f(false);
    }
  }
  
  public void onResume()
  {
    bnzb.b(jdField_c_of_type_JavaLangString, "onResume");
    super.onResume();
    if (!this.h)
    {
      bnyh.a().s();
      f(true);
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null) {
        a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bnzb.b(jdField_c_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    E();
    F();
    D();
    bnyl.a().a().jdField_c_of_type_JavaLangString = "none";
    bnyl.a().a().jdField_a_of_type_Boolean = false;
    bnyl.a().a().jdField_b_of_type_Int = -1;
    bnyl.a().a().jdField_c_of_type_Int = -1;
    bnyl.a().a().jdField_a_of_type_Int = a(this.jdField_d_of_type_Boolean, this.jdField_e_of_type_Boolean);
    bnyl.a().a().jdField_d_of_type_JavaLangString = "none";
    bnyl.a().a().jdField_e_of_type_JavaLangString = "none";
    paramView = VideoUtil.getVideoSize(this.jdField_d_of_type_JavaLangString);
    a(this.jdField_d_of_type_JavaLangString, paramView.getWidth(), paramView.getHeight(), this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    a(new String[] { "设备级别", boho.a(), "视频最大预览尺寸", String.valueOf(this.jdField_a_of_type_Bohp.a()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出码率", String.valueOf(this.jdField_a_of_type_Bohp.b()), "视频导出帧率", String.valueOf(this.jdField_a_of_type_Bohp.c()) });
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (e()))
    {
      if (bofw.a().b())
      {
        bnzb.b(jdField_c_of_type_JavaLangString, "single image + first time : aifilter auto request");
        f();
        o();
        bnyh.a().x();
      }
    }
    else {
      return;
    }
    bnzb.d(jdField_c_of_type_JavaLangString, "single image + first time : aifilter res not ready, do not request");
  }
  
  public void q()
  {
    getActivity().getIntent().putExtra("startTimeEdit", this.jdField_a_of_type_Long * 1000L);
    getActivity().getIntent().putExtra("endTimeEdit", (this.jdField_a_of_type_Long + this.jdField_b_of_type_Long) * 1000L);
    Intent localIntent = getActivity().getIntent();
    if (this.jdField_a_of_type_JavaLangFloat != null) {}
    for (float f1 = this.jdField_a_of_type_JavaLangFloat.floatValue();; f1 = 1.0F)
    {
      localIntent.putExtra("endSpeedEdit", f1);
      bnyh.a().l();
      a().b(a(), getArguments());
      return;
    }
  }
  
  public void r()
  {
    n();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.clearAEKitModel();
    bnyl.a().a().jdField_b_of_type_JavaLangString = "effect_blank";
    bnyl.a().a().jdField_a_of_type_Float = -1.0F;
  }
  
  public void s() {}
  
  public void t() {}
  
  public void u() {}
  
  public void v()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.b();
    i();
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      if ("sticker_lyric".equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getStickerType()))
      {
        f();
        return;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
    H();
  }
  
  public void w()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(anni.a(2131689679));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.c();
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      L();
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
      bnyh.a().k();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
    }
  }
  
  public void x()
  {
    String str = "";
    if (!TextUtils.isEmpty(bnyl.a().a().jdField_a_of_type_JavaLangString)) {
      str = bnyl.a().a().jdField_a_of_type_JavaLangString;
    }
    AEEditorMusicHelper.a(getActivity(), str);
    bnyh.a().p();
  }
  
  public void y()
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).d();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(anni.a(2131689691));
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
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */