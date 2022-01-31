package dov.com.qq.im.aeeditor.module.edit;

import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import alpo;
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
import bdcd;
import bdfq;
import blen;
import bler;
import blfg;
import blfr;
import blfw;
import blfx;
import blfy;
import blge;
import blgg;
import blgv;
import blgw;
import blhb;
import blhg;
import blhh;
import bliq;
import blir;
import blis;
import blit;
import bliu;
import bliv;
import bliw;
import blix;
import bliy;
import bliz;
import bljb;
import bljf;
import bljn;
import bljv;
import blkc;
import blkf;
import blkj;
import blkk;
import blkl;
import blkw;
import blla;
import blld;
import bllh;
import bllk;
import blln;
import bncp;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
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
import mqq.os.MqqHandler;
import yvn;
import yvz;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements blgg, bljf, blkc, blkf, bllh, yvn<CLIENT.StSmartMatchMusicRsp>, yvz
{
  private static final String jdField_b_of_type_JavaLangString = AEEditorVideoEditFragment.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private blgv jdField_a_of_type_Blgv = new blgv();
  private bljv jdField_a_of_type_Bljv;
  private blkl jdField_a_of_type_Blkl = blkj.a();
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
  private bljv jdField_b_of_type_Bljv;
  private Size jdField_b_of_type_ComTencentTavcutBeanSize;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    File localFile = new File(blfw.jdField_b_of_type_JavaLangString);
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
    return this.jdField_a_of_type_Blkl.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
  }
  
  private Long a()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("starttime"))) {
      return Long.valueOf(localBundle.getLong("starttime"));
    }
    blfg.d(jdField_b_of_type_JavaLangString, "no video clip start time");
    return null;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel = ((VideoControlPanel)this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.setMusicOperationCallback(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131379821));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377418));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bliu(this));
    d(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377419));
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131377417));
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnClickListener(new bliv(this));
  }
  
  private void a(@Nullable bljv parambljv, boolean paramBoolean)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    if ((parambljv == null) || (!this.jdField_d_of_type_Boolean))
    {
      parambljv = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
      if (this.jdField_c_of_type_Boolean) {}
      for (;;)
      {
        parambljv.setMainVolume(f1);
        if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
        return;
        f1 = 0.0F;
      }
    }
    Object localObject = AEEditorMusicHelper.a(parambljv);
    boolean bool = AEEditorMusicHelper.a((String)localObject);
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null) && (!paramBoolean)) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
    }
    if (bool)
    {
      parambljv.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a((String)localObject, parambljv.a());
      if (paramBoolean)
      {
        parambljv = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
        if (this.jdField_c_of_type_Boolean) {}
        for (;;)
        {
          parambljv.setMainVolume(f1);
          return;
          f1 = 0.0F;
        }
      }
      parambljv = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
      localObject = this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
      f1 = f2;
      if (this.jdField_c_of_type_Boolean) {
        f1 = 1.0F;
      }
      if (!this.jdField_a_of_type_Boolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        parambljv.setBgmMusic((MusicData)localObject, f1, 1.0F, paramBoolean);
        if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
          break;
        }
        d(true);
        return;
      }
    }
    if ((getActivity() == null) || (getActivity().getAppInterface() == null))
    {
      blfg.b(jdField_b_of_type_JavaLangString, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    if (parambljv.jdField_a_of_type_Int == 1)
    {
      blfg.b(jdField_b_of_type_JavaLangString, "[updateSoundAndMusicConfig], editorMusicInfo=" + parambljv + ", downloadStatus=STATUS_DOWNLOADING");
      return;
    }
    parambljv.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(getActivity().getAppInterface(), parambljv, parambljv.b(), (String)localObject, this), 128, null, true);
  }
  
  private void a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramVsMusicItemInfo.mSongMid);
    AEEditorMusicHelper.a(localArrayList, new blir(this, paramVsMusicItemInfo));
  }
  
  private void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AEEditorMusicHelper.a(paramString, paramInt1, paramInt2, paramLong, 0L, this);
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
    blfg.d(jdField_b_of_type_JavaLangString, "no video clip start time");
    return null;
  }
  
  private void b(@NonNull bljv parambljv, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambljv.a())) {}
    label129:
    for (;;)
    {
      return;
      List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
      Iterator localIterator = localList.iterator();
      bljv localbljv;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localbljv = (bljv)localIterator.next();
          if ((localbljv != null) && (!localbljv.a()) && (!localbljv.jdField_b_of_type_Boolean) && (parambljv.a().equals(localbljv.a()))) {
            if (paramBoolean) {
              localbljv.jdField_a_of_type_Int = 2;
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
        localbljv.jdField_a_of_type_Int = 0;
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
    blfg.d(jdField_b_of_type_JavaLangString, "no video paths");
    return null;
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bliq(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165230));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new bliw(this));
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Blkl.a());
    StickerEditViewIconConfig localStickerEditViewIconConfig = new StickerEditViewIconConfig();
    localStickerEditViewIconConfig.setDeleteIconResId(2130837657);
    localStickerEditViewIconConfig.setEditIconResId(2130837658);
    localStickerEditViewIconConfig.setZoomIconResId(2130837659);
    localSessionConfig.setStickerEditViewIconConfig(localStickerEditViewIconConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(new blix(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(getActivity());
    t();
    this.jdField_d_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
  }
  
  private void t()
  {
    Long localLong1 = a();
    Long localLong2 = b();
    if ((localLong1 != null) && (localLong1 != null))
    {
      this.jdField_b_of_type_Long = (Long.valueOf(localLong2.longValue() - localLong1.longValue()).longValue() / 1000L);
      this.jdField_a_of_type_Long = (localLong1.longValue() / 1000L);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(localLong1.longValue() / 1000L), Long.valueOf(this.jdField_b_of_type_Long));
      a("视频裁剪Range", blln.a(this.jdField_a_of_type_Long) + "~" + blln.a(localLong2.longValue() / 1000L));
    }
  }
  
  private void u()
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
  
  private void v()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      l = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L;
    }
    bler.a().a().jdField_a_of_type_Long = l;
    if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().size() > 0) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0) != null) && (((StickerModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0)).getTextItems() != null)) {
      bler.a().a().jdField_b_of_type_Int = ((StickerModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0)).getTextItems().size();
    }
    blen.a().i();
  }
  
  public int a()
  {
    return 2131558540;
  }
  
  protected bljf a()
  {
    return this;
  }
  
  protected bljn a()
  {
    return new bliy(this);
  }
  
  protected blla a()
  {
    return new bliz(this);
  }
  
  protected blld a()
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
    bler.a().a().jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt, blhb paramblhb)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.13(this, paramblhb));
    }
    if (paramInt == 0)
    {
      blfg.b(jdField_b_of_type_JavaLangString, "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.15(this));
      if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (paramblhb != null)) {
        break label107;
      }
    }
    label107:
    blhh localblhh;
    do
    {
      return;
      blfg.b(jdField_b_of_type_JavaLangString, "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.14(this));
      break;
      this.jdField_a_of_type_Blgv.a(this.jdField_c_of_type_JavaLangString, paramblhb);
      this.jdField_a_of_type_JavaUtilArrayList = a(paramblhb);
      localblhh = (blhh)paramblhb;
    } while (localblhh == null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setAEKitAIFilter(localblhh.jdField_b_of_type_JavaLangString, 0.8F, localblhh.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
    a(new String[] { "智能滤镜label", localblhh.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    paramblhb = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localblhh.jdField_a_of_type_JavaLangString)) {
        break label301;
      }
      paramblhb = localNewEnhanceCategories.filterType;
    }
    label301:
    for (;;)
    {
      break;
      bler.a().a().jdField_b_of_type_JavaLangString = ("lut_aieffect_" + paramblhb);
      bler.a().a().jdField_a_of_type_Float = -1.0F;
      return;
    }
  }
  
  public void a(int paramInt, String paramString, float paramFloat, AEEditorFilterBean paramAEEditorFilterBean)
  {
    h();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.cancelAIFilter();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {}
    for (float f = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).floatValue();; f = paramFloat)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(paramString);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutAlpha(f);
      bler.a().a().jdField_b_of_type_JavaLangString = paramAEEditorFilterBean.getSid();
      bler.a().a().jdField_a_of_type_Float = paramFloat;
      return;
    }
  }
  
  public void a(@Nullable bljv parambljv, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambljv == null) || (parambljv.a())) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_Bljv = this.jdField_a_of_type_Bljv;
    this.jdField_a_of_type_Bljv = parambljv;
    bler.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    bler.a().a().jdField_c_of_type_JavaLangString = parambljv.a();
    blen.a().n();
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      bljv localbljv = (bljv)localIterator.next();
      if ((localbljv != null) && (!localbljv.a()) && (!localbljv.jdField_b_of_type_Boolean))
      {
        if (parambljv.a().equals(localbljv.a()))
        {
          localbljv.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Bljv = localbljv;
          parambljv = localbljv;
          i = 1;
        }
        for (;;)
        {
          break;
          localbljv.jdField_a_of_type_Boolean = false;
        }
      }
    }
    int j = paramInt;
    if (i == 0)
    {
      parambljv.jdField_a_of_type_Boolean = true;
      i = localList.size() - 1;
      if (paramInt <= i) {
        break label278;
      }
      j = i + 1;
      localList.add(parambljv);
    }
    for (;;)
    {
      a(parambljv, false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(j);
      if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
        break;
      }
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(true);
      return;
      label278:
      localList.add(paramInt, parambljv);
      j = paramInt;
    }
  }
  
  public void a(@NonNull bljv parambljv, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.12(this, parambljv, paramBoolean, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {}
    List localList;
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean;
      bler.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
      localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    } while (CollectionUtils.isEmpty(localList));
    Object localObject;
    int j;
    int i;
    if (paramBoolean)
    {
      if ((this.jdField_b_of_type_Bljv == null) || (this.jdField_b_of_type_Bljv.a())) {
        break label405;
      }
      int k = 0;
      localObject = null;
      j = 0;
      i = 0;
      if (k < localList.size())
      {
        bljv localbljv = (bljv)localList.get(k);
        int m;
        if ((localbljv != null) && (!localbljv.a())) {
          if (localbljv.jdField_b_of_type_Boolean)
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
          if (this.jdField_b_of_type_Bljv.a().equals(localbljv.a()))
          {
            localbljv.jdField_a_of_type_Boolean = true;
            i = 1;
            j = k;
            localObject = localbljv;
          }
          else
          {
            localbljv.jdField_a_of_type_Boolean = false;
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
        this.jdField_b_of_type_Bljv = ((bljv)localObject);
        this.jdField_a_of_type_Bljv = ((bljv)localObject);
        label227:
        this.jdField_a_of_type_Bljv.jdField_a_of_type_Boolean = true;
        bler.a().a().jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bljv.a();
        blen.a().n();
      }
      for (;;)
      {
        a(this.jdField_a_of_type_Bljv, false);
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
        if (paramBoolean) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(i);
        }
        if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
          break;
        }
        ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(paramBoolean);
        return;
        this.jdField_b_of_type_Bljv = null;
        this.jdField_a_of_type_Bljv = ((bljv)localList.get(0));
        break label227;
        this.jdField_b_of_type_Bljv = this.jdField_a_of_type_Bljv;
        this.jdField_a_of_type_Bljv = null;
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bljv)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
        }
        bler.a().a().jdField_c_of_type_JavaLangString = "none";
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
      blfg.d(jdField_b_of_type_JavaLangString, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
    }
    while (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {
      return;
    }
    paramString = AEEditorMusicHelper.b(AEEditorMusicHelper.a(paramStSmartMatchMusicRsp.vecMusic.get()));
    Object localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    paramStSmartMatchMusicRsp = new LinkedList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    int j = k;
    if (i < ((List)localObject).size())
    {
      bljv localbljv = (bljv)((List)localObject).get(i);
      if ((localbljv == null) || (localbljv.a()) || (localbljv.jdField_b_of_type_Boolean)) {}
      for (;;)
      {
        i += 1;
        break;
        paramStSmartMatchMusicRsp.add(localbljv);
        localHashMap.put(localbljv.a(), localbljv);
      }
    }
    if (j < paramString.size())
    {
      localObject = (bljv)paramString.get(j);
      if ((localObject == null) || (((bljv)localObject).a())) {}
      for (;;)
      {
        j += 1;
        break;
        if (localHashMap.get(((bljv)localObject).a()) == null) {
          paramStSmartMatchMusicRsp.add(localObject);
        }
      }
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(paramStSmartMatchMusicRsp);
  }
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.10(this));
      return;
    }
    AEEditorMusicHelper.a(paramArrayList, null, false, null, 2, this);
  }
  
  public boolean a()
  {
    if (this.jdField_d_of_type_JavaLangString.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString()))) {
      return false;
    }
    Object localObject = getActivity();
    getActivity().getIntent().putExtra("startTimeEdit", a());
    getActivity().getIntent().putExtra("endTimeEdit", b());
    localObject = bdcd.a((Context)localObject, 230).setTitle(alpo.a(2131689807)).setMessage(((Context)localObject).getString(2131689808)).setPositiveButton(((Context)localObject).getString(2131689807), new blit(this)).setNegativeButton(((Context)localObject).getString(2131689792), new blis(this));
    if (localObject != null) {}
    try
    {
      if (!((bdfq)localObject).isShowing()) {
        ((bdfq)localObject).show();
      }
      label144:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label144;
    }
  }
  
  public void aX_()
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
    bler.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    a(this.jdField_a_of_type_Bljv, true);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return alpo.a(2131689799);
  }
  
  protected void c()
  {
    this.jdField_c_of_type_JavaLangString = f();
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_Blgv.a(this.jdField_c_of_type_JavaLangString);
    boolean bool1;
    if ((localObject != null) && ((localObject instanceof blhh)))
    {
      blfg.b(jdField_b_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool1 = ((blhh)localObject).jdField_a_of_type_Boolean;
      if (!bool1) {
        break label98;
      }
      g();
      localObject = new blhg(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((blhg)localObject).a(this);
      blge.a().a(getActivity().getAppInterface(), getActivity(), (blgw)localObject);
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
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setAEKitAIFilter(((blhb)localObject).b(), 0.8F, ((blhb)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((blhb)localObject).a(), "智能滤镜errCode", "0" });
    }
  }
  
  protected void d()
  {
    blge.a().a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
    }
  }
  
  public void f()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "exportVideo");
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.8(this));
    String str1 = blfx.jdField_d_of_type_JavaLangString;
    Object localObject = new File(str1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File localFile = new File(this.jdField_c_of_type_JavaLangString);
    localObject = String.valueOf(System.currentTimeMillis());
    String str2 = str1 + File.separator + "output_" + (String)localObject + "_" + bncp.a(localFile.getName()) + ".jpg";
    str1 = str1 + File.separator + "output_" + (String)localObject + "_" + bncp.a(localFile.getName()) + ".mp4";
    v();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getEffectVideoFrame(0L, 1080, new bljb(this, str2, (String)localObject, str1));
      return;
    }
    blfy.a().a((String)localObject, this.jdField_c_of_type_JavaLangString, str1, str2, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
    if (getActivity() == null)
    {
      bllk.a(BaseApplicationImpl.getContext(), str1, str2, (String)localObject, a(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
      return;
    }
    bllk.a(getActivity(), str1, str2, (String)localObject, a(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
    getActivity().finish();
  }
  
  public void i()
  {
    getActivity().getIntent().putExtra("startTimeEdit", a());
    getActivity().getIntent().putExtra("endTimeEdit", b());
    blen.a().l();
    a().b(a(), getArguments());
  }
  
  public void j()
  {
    h();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.cancelAIFilter();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
  }
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n()
  {
    this.jdField_a_of_type_Blkw.a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, 0);
    c(false);
  }
  
  public void o()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(alpo.a(2131689788));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.c();
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).e();
    }
    for (;;)
    {
      blen.a().k();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    AEEditorMusicHelper.a(getActivity());
    if ((getActivity() != null) && (getActivity().getIntent() != null)) {
      this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("editorFrom", -1);
    }
  }
  
  public void onDestroyView()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onDestroyView");
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
    this.jdField_a_of_type_Bljv = null;
    this.jdField_b_of_type_Bljv = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.e = paramBoolean;
    if (!paramBoolean)
    {
      t();
      a(true, true);
      return;
    }
    c(false);
  }
  
  public void onPause()
  {
    super.onPause();
    blfg.b(jdField_b_of_type_JavaLangString, "onPause");
    if (!this.e) {
      c(false);
    }
  }
  
  public void onResume()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onResume");
    super.onResume();
    if (!this.e) {
      c(true);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    s();
    r();
    bler.a().a().jdField_c_of_type_JavaLangString = "none";
    bler.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    paramView = VideoUtil.getVideoSize(this.jdField_c_of_type_JavaLangString);
    a(this.jdField_c_of_type_JavaLangString, paramView.getWidth(), paramView.getHeight(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    a(new String[] { "设备级别", blkk.a(), "视频最大预览尺寸", String.valueOf(this.jdField_a_of_type_Blkl.a()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出码率", String.valueOf(this.jdField_a_of_type_Blkl.b()), "视频导出帧率", String.valueOf(this.jdField_a_of_type_Blkl.c()) });
  }
  
  public void p()
  {
    AEEditorMusicHelper.b(getActivity());
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).d();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(alpo.a(2131689799));
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