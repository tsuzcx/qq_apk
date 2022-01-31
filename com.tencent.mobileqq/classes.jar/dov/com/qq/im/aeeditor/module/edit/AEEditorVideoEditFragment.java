package dov.com.qq.im.aeeditor.module.edit;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import ajpx;
import alud;
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
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bdgm;
import bdjz;
import bkyt;
import bliu;
import bliy;
import bljn;
import bljy;
import blkd;
import blke;
import blkf;
import blkl;
import blkn;
import blld;
import blle;
import bllj;
import bllp;
import bllq;
import blnc;
import blnd;
import blne;
import blnf;
import blng;
import blnh;
import blni;
import blnj;
import blnk;
import blnl;
import blnn;
import blnr;
import blnt;
import blnz;
import bloh;
import bloo;
import blor;
import blov;
import blow;
import blox;
import blpi;
import blpm;
import blpp;
import blpt;
import blpw;
import blpz;
import bnhb;
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
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
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
import com.tencent.weseevideo.model.effect.StickerModel;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorControlPanelContainer;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable;
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
import zac;
import zao;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements blkn, blnr, bloo, blor, blpt, zac<CLIENT.StSmartMatchMusicRsp>, zao
{
  private static final String jdField_b_of_type_JavaLangString = AEEditorVideoEditFragment.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private blld jdField_a_of_type_Blld = new blld();
  private bloh jdField_a_of_type_Bloh;
  private blox jdField_a_of_type_Blox = blov.a();
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private Size jdField_a_of_type_ComTencentTavcutBeanSize;
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private TAVCutVideoView jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView;
  private MusicData jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
  private VideoControlPanel jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, Float> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bloh jdField_b_of_type_Bloh;
  private Size jdField_b_of_type_ComTencentTavcutBeanSize;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    File localFile = new File(blkd.jdField_b_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
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
  
  private Size a()
  {
    this.jdField_b_of_type_ComTencentTavcutBeanSize = VideoUtil.getVideoSize(this.jdField_c_of_type_JavaLangString);
    return this.jdField_a_of_type_Blox.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
  }
  
  private Long a()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("starttime"))) {
      return Long.valueOf(localBundle.getLong("starttime"));
    }
    bljn.d(jdField_b_of_type_JavaLangString, "no video clip start time");
    return null;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel = ((VideoControlPanel)this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.setMusicOperationCallback(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131379879));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377472));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new blng(this));
    d(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377473));
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131377471));
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnClickListener(new blnh(this));
  }
  
  private void a(@Nullable bloh parambloh, boolean paramBoolean)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    if ((parambloh == null) || (!this.jdField_d_of_type_Boolean))
    {
      parambloh = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
      if (this.jdField_c_of_type_Boolean) {}
      for (;;)
      {
        parambloh.setMainVolume(f1);
        if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
        return;
        f1 = 0.0F;
      }
    }
    Object localObject = AEEditorMusicHelper.a(parambloh);
    boolean bool = AEEditorMusicHelper.a((String)localObject);
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null) && (!paramBoolean)) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
    }
    if (bool)
    {
      parambloh.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a((String)localObject, parambloh.a(), parambloh.b());
      if (paramBoolean)
      {
        parambloh = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
        if (this.jdField_c_of_type_Boolean) {}
        for (;;)
        {
          parambloh.setMainVolume(f1);
          return;
          f1 = 0.0F;
        }
      }
      parambloh = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
      localObject = this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
      f1 = f2;
      if (this.jdField_c_of_type_Boolean) {
        f1 = 1.0F;
      }
      if (!this.jdField_a_of_type_Boolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        parambloh.setBgmMusic((MusicData)localObject, f1, 1.0F, paramBoolean);
        if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
          break;
        }
        d(true);
        return;
      }
    }
    if ((getActivity() == null) || (getActivity().getAppInterface() == null))
    {
      bljn.b(jdField_b_of_type_JavaLangString, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    if (parambloh.jdField_a_of_type_Int == 1)
    {
      bljn.b(jdField_b_of_type_JavaLangString, "[updateSoundAndMusicConfig], editorMusicInfo=" + parambloh + ", downloadStatus=STATUS_DOWNLOADING");
      return;
    }
    parambloh.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(getActivity().getAppInterface(), parambloh, parambloh.b(), (String)localObject, this), 128, null, true);
  }
  
  private void a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramVsMusicItemInfo.mSongMid);
    AEEditorMusicHelper.a(localArrayList, new blnd(this, paramVsMusicItemInfo));
  }
  
  private void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AEEditorMusicHelper.a(paramString, paramInt1, paramInt2, paramLong, 0L, this);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (getActivity() == null)
    {
      bljn.d(jdField_b_of_type_JavaLangString, "activity is null.");
      return;
    }
    Intent localIntent = new Intent();
    Size localSize = a();
    localIntent.putExtra("ae_editor_video_flag", true);
    localIntent.putExtra("ae_editor_video_path", paramString1);
    localIntent.putExtra("ae_editor_video_thumb_path", paramString2);
    localIntent.putExtra("ae_editor_video_session_id", paramString3);
    localIntent.putExtra("ae_editor_video_export_size_height", localSize.getHeight());
    localIntent.putExtra("ae_editor_video_export_size_width", localSize.getWidth());
    localIntent.putStringArrayListExtra("ae_editor_video_text_cache", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("ae_editor_video_from", this.jdField_a_of_type_Int);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying()))
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
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private Long b()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("endtime"))) {
      return Long.valueOf(localBundle.getLong("endtime"));
    }
    bljn.d(jdField_b_of_type_JavaLangString, "no video clip start time");
    return null;
  }
  
  private void b(@NonNull bloh parambloh, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambloh.a())) {}
    label129:
    for (;;)
    {
      return;
      List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
      Iterator localIterator = localList.iterator();
      bloh localbloh;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localbloh = (bloh)localIterator.next();
          if ((localbloh != null) && (!localbloh.a()) && (!localbloh.jdField_b_of_type_Boolean) && (parambloh.a().equals(localbloh.a()))) {
            if (paramBoolean) {
              localbloh.jdField_a_of_type_Int = 2;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label129;
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
        return;
        localbloh.jdField_a_of_type_Int = 0;
        break;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    }
  }
  
  private String f()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("select_path"))) {
      return localBundle.getString("select_path");
    }
    bljn.d(jdField_b_of_type_JavaLangString, "no video paths");
    return null;
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new blnc(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165230));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new blni(this));
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Blox.a());
    StickerEditViewIconConfig localStickerEditViewIconConfig = new StickerEditViewIconConfig();
    localStickerEditViewIconConfig.setDeleteIconResId(2130837658);
    localStickerEditViewIconConfig.setEditIconResId(2130837659);
    localStickerEditViewIconConfig.setZoomIconResId(2130837660);
    localSessionConfig.setStickerEditViewIconConfig(localStickerEditViewIconConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(new blnj(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(getActivity());
    w();
    this.jdField_d_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
  }
  
  private void w()
  {
    Long localLong1 = a();
    Long localLong2 = b();
    if ((localLong1 != null) && (localLong1 != null))
    {
      this.jdField_b_of_type_Long = (Long.valueOf(localLong2.longValue() - localLong1.longValue()).longValue() / 1000L);
      this.jdField_a_of_type_Long = (localLong1.longValue() / 1000L);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(localLong1.longValue() / 1000L), Long.valueOf(this.jdField_b_of_type_Long));
      a("视频裁剪Range", blpz.a(this.jdField_a_of_type_Long) + "~" + blpz.a(localLong2.longValue() / 1000L));
    }
  }
  
  private void x()
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
  
  private void y()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      l = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L;
    }
    bliy.a().a().jdField_a_of_type_Long = l;
    if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().size() > 0) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0) != null) && (((StickerModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0)).getTextItems() != null)) {
      bliy.a().a().jdField_b_of_type_Int = ((StickerModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0)).getTextItems().size();
    }
    bliu.a().i();
  }
  
  public int a()
  {
    return 2131558540;
  }
  
  protected blnr a()
  {
    return this;
  }
  
  protected blnz a()
  {
    return new blnk(this);
  }
  
  protected blpm a()
  {
    return new blnl(this);
  }
  
  protected blpp a()
  {
    return this;
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
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutAlpha(paramFloat);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
    bliy.a().a().jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt, bllj parambllj)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.13(this, parambllj));
    }
    if (paramInt == 0)
    {
      bljn.b(jdField_b_of_type_JavaLangString, "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.15(this));
      if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (parambllj != null)) {
        break label107;
      }
    }
    label107:
    bllq localbllq;
    do
    {
      return;
      bljn.b(jdField_b_of_type_JavaLangString, "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.14(this));
      break;
      this.jdField_a_of_type_Blld.a(this.jdField_c_of_type_JavaLangString, parambllj);
      this.jdField_a_of_type_JavaUtilArrayList = a(parambllj);
      localbllq = (bllq)parambllj;
    } while (localbllq == null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setAEKitAIFilter(localbllq.jdField_b_of_type_JavaLangString, 0.8F, localbllq.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
    a(new String[] { "智能滤镜label", localbllq.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    parambllj = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localbllq.jdField_a_of_type_JavaLangString)) {
        break label301;
      }
      parambllj = localNewEnhanceCategories.filterType;
    }
    label301:
    for (;;)
    {
      break;
      bliy.a().a().jdField_b_of_type_JavaLangString = ("lut_aieffect_" + parambllj);
      bliy.a().a().jdField_a_of_type_Float = -1.0F;
      return;
    }
  }
  
  public void a(int paramInt, String paramString, float paramFloat, AEEditorFilterBean paramAEEditorFilterBean)
  {
    j();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(true);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.cancelAIFilter();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {}
    for (float f = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).floatValue();; f = paramFloat)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(paramString);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutAlpha(f);
      bliy.a().a().jdField_b_of_type_JavaLangString = paramAEEditorFilterBean.getSid();
      bliy.a().a().jdField_a_of_type_Float = paramFloat;
      return;
    }
  }
  
  public void a(@Nullable bloh parambloh, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambloh == null) || (parambloh.a())) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_Bloh = this.jdField_a_of_type_Bloh;
    this.jdField_a_of_type_Bloh = parambloh;
    bliy.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    bliy.a().a().jdField_c_of_type_JavaLangString = parambloh.a();
    bliu.a().n();
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      bloh localbloh = (bloh)localIterator.next();
      if ((localbloh != null) && (!localbloh.a()) && (!localbloh.jdField_b_of_type_Boolean))
      {
        if (parambloh.a().equals(localbloh.a()))
        {
          localbloh.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Bloh = localbloh;
          parambloh = localbloh;
          i = 1;
        }
        for (;;)
        {
          break;
          localbloh.jdField_a_of_type_Boolean = false;
        }
      }
    }
    int j = paramInt;
    if (i == 0)
    {
      parambloh.jdField_a_of_type_Boolean = true;
      i = localList.size() - 1;
      if (paramInt <= i) {
        break label278;
      }
      j = i + 1;
      localList.add(parambloh);
    }
    for (;;)
    {
      a(parambloh, false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(j);
      if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
        break;
      }
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(true);
      return;
      label278:
      localList.add(paramInt, parambloh);
      j = paramInt;
    }
  }
  
  public void a(@NonNull bloh parambloh, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.12(this, parambloh, paramBoolean, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {}
    List localList;
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean;
      bliy.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
      localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    } while (CollectionUtils.isEmpty(localList));
    Object localObject;
    int j;
    int i;
    if (paramBoolean)
    {
      if ((this.jdField_b_of_type_Bloh == null) || (this.jdField_b_of_type_Bloh.a())) {
        break label405;
      }
      int k = 0;
      localObject = null;
      j = 0;
      i = 0;
      if (k < localList.size())
      {
        bloh localbloh = (bloh)localList.get(k);
        int m;
        if ((localbloh != null) && (!localbloh.a())) {
          if (localbloh.jdField_b_of_type_Boolean)
          {
            m = j;
            j = i;
            i = m;
          }
        }
        for (;;)
        {
          m = k + 1;
          k = j;
          j = i;
          i = k;
          k = m;
          break;
          if (this.jdField_b_of_type_Bloh.a().equals(localbloh.a()))
          {
            localbloh.jdField_a_of_type_Boolean = true;
            i = 1;
            j = k;
            localObject = localbloh;
          }
          else
          {
            localbloh.jdField_a_of_type_Boolean = false;
            m = i;
            i = j;
            j = m;
          }
        }
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        this.jdField_b_of_type_Bloh = ((bloh)localObject);
        this.jdField_a_of_type_Bloh = ((bloh)localObject);
        label227:
        this.jdField_a_of_type_Bloh.jdField_a_of_type_Boolean = true;
        bliy.a().a().jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bloh.a();
        bliu.a().n();
      }
      for (;;)
      {
        a(this.jdField_a_of_type_Bloh, false);
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
        if (paramBoolean) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(i);
        }
        if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
          break;
        }
        ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(paramBoolean);
        return;
        this.jdField_b_of_type_Bloh = null;
        this.jdField_a_of_type_Bloh = ((bloh)localList.get(0));
        break label227;
        this.jdField_b_of_type_Bloh = this.jdField_a_of_type_Bloh;
        this.jdField_a_of_type_Bloh = null;
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bloh)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
        }
        bliy.a().a().jdField_c_of_type_JavaLangString = "none";
        i = 0;
      }
      label405:
      localObject = null;
      j = 0;
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    int k = 0;
    if ((!paramBoolean) || (paramStSmartMatchMusicRsp == null) || (CollectionUtils.isEmpty(paramStSmartMatchMusicRsp.vecMusic.get()))) {
      bljn.d(jdField_b_of_type_JavaLangString, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
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
            bliy.a().a().jdField_d_of_type_JavaLangString = ((COMM.Entry)localObject).value.get();
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
    bliy.a().a().e = paramString;
    int i = 0;
    int j = k;
    if (i < localList.size())
    {
      paramString = (bloh)localList.get(i);
      if ((paramString == null) || (paramString.a()) || (paramString.jdField_b_of_type_Boolean)) {}
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject).add(paramString);
        localHashMap.put(paramString.a(), paramString);
      }
    }
    if (j < paramStSmartMatchMusicRsp.size())
    {
      paramString = (bloh)paramStSmartMatchMusicRsp.get(j);
      if ((paramString == null) || (paramString.a())) {}
      for (;;)
      {
        j += 1;
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
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.10(this));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)
    {
      paramBoolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) && (ajpx.jdField_a_of_type_Int != 2)) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = 1)
    {
      AEEditorMusicHelper.a(paramArrayList, bkyt.a().a(), paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, i, this);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_d_of_type_JavaLangString.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString()))) {
      return false;
    }
    Object localObject = getActivity();
    getActivity().getIntent().putExtra("startTimeEdit", a());
    getActivity().getIntent().putExtra("endTimeEdit", b());
    localObject = bdgm.a((Context)localObject, 230).setTitle(alud.a(2131689807)).setMessage(((Context)localObject).getString(2131689808)).setPositiveButton(((Context)localObject).getString(2131689807), new blnf(this)).setNegativeButton(((Context)localObject).getString(2131689792), new blne(this));
    if (localObject != null) {}
    try
    {
      if (!((bdjz)localObject).isShowing()) {
        ((bdjz)localObject).show();
      }
      label144:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label144;
    }
  }
  
  public void aU_()
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
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    bliy.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    a(this.jdField_a_of_type_Bloh, true);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return alud.a(2131689799);
  }
  
  protected void c()
  {
    this.jdField_c_of_type_JavaLangString = f();
  }
  
  protected void d()
  {
    blkl.a().a();
  }
  
  protected void e() {}
  
  public boolean e()
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_Blld.a(this.jdField_c_of_type_JavaLangString);
    boolean bool1;
    if ((localObject != null) && ((localObject instanceof bllq)))
    {
      bljn.b(jdField_b_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool1 = ((bllq)localObject).jdField_a_of_type_Boolean;
      if (!bool1) {
        break label98;
      }
      h();
      localObject = new bllp(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((bllp)localObject).a(this);
      blkl.a().a(getActivity().getAppInterface(), getActivity(), (blle)localObject);
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
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setAEKitAIFilter(((bllj)localObject).b(), 0.8F, ((bllj)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((bllj)localObject).a(), "智能滤镜errCode", "0" });
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
    }
  }
  
  public boolean f()
  {
    return true;
  }
  
  public void g()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "exportVideo");
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.8(this));
    String str1 = blke.jdField_d_of_type_JavaLangString;
    Object localObject = new File(str1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File localFile = new File(this.jdField_c_of_type_JavaLangString);
    localObject = String.valueOf(System.currentTimeMillis());
    String str2 = str1 + File.separator + "output_" + (String)localObject + "_" + bnhb.a(localFile.getName()) + ".jpg";
    str1 = str1 + File.separator + "output_" + (String)localObject + "_" + bnhb.a(localFile.getName()) + ".mp4";
    y();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getEffectVideoFrame(0L, 1080, new blnn(this, str2, (String)localObject, str1));
      return;
    }
    blkf.a().a((String)localObject, this.jdField_c_of_type_JavaLangString, str1, str2, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
    if (getActivity() == null)
    {
      blpw.a(BaseApplicationImpl.getContext(), str1, str2, (String)localObject, a(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
      return;
    }
    a(str1, str2, (String)localObject);
  }
  
  public void l()
  {
    getActivity().getIntent().putExtra("startTimeEdit", a());
    getActivity().getIntent().putExtra("endTimeEdit", b());
    bliu.a().l();
    a().b(a(), getArguments());
  }
  
  public void m()
  {
    j();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(false);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.cancelAIFilter();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
  }
  
  public void n() {}
  
  public void o() {}
  
  public void onCreate(Bundle paramBundle)
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    AEEditorMusicHelper.a(getActivity());
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("editorFrom", -1);
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
  }
  
  public void onDestroyView()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onDestroyView");
    super.onDestroyView();
    if (getArguments() != null) {
      getArguments().clear();
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer.b();
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
    this.jdField_a_of_type_Bloh = null;
    this.jdField_b_of_type_Bloh = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.e = paramBoolean;
    if (!paramBoolean)
    {
      w();
      a(true, true);
      return;
    }
    c(false);
  }
  
  public void onPause()
  {
    super.onPause();
    bljn.b(jdField_b_of_type_JavaLangString, "onPause");
    if (!this.e) {
      c(false);
    }
  }
  
  public void onResume()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onResume");
    super.onResume();
    if (!this.e) {
      c(true);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    v();
    u();
    bliy.a().a().jdField_c_of_type_JavaLangString = "none";
    bliy.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    paramView = VideoUtil.getVideoSize(this.jdField_c_of_type_JavaLangString);
    a(this.jdField_c_of_type_JavaLangString, paramView.getWidth(), paramView.getHeight(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    a(new String[] { "设备级别", blow.a(), "视频最大预览尺寸", String.valueOf(this.jdField_a_of_type_Blox.a()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出码率", String.valueOf(this.jdField_a_of_type_Blox.b()), "视频导出帧率", String.valueOf(this.jdField_a_of_type_Blox.c()) });
    if (d())
    {
      if (blnt.a().b())
      {
        bljn.b(jdField_b_of_type_JavaLangString, "single image + first time : aifilter auto request");
        e();
        k();
      }
    }
    else {
      return;
    }
    bljn.d(jdField_b_of_type_JavaLangString, "single image + first time : aifilter res not ready, do not request");
  }
  
  public void p() {}
  
  public void q()
  {
    this.jdField_a_of_type_Blpi.a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, 0);
    c(false);
  }
  
  public void r()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(alud.a(2131689788));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.c();
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).e();
    }
    for (;;)
    {
      bliu.a().k();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
    }
  }
  
  public void s()
  {
    AEEditorMusicHelper.b(getActivity());
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).d();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(alud.a(2131689799));
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.a();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */