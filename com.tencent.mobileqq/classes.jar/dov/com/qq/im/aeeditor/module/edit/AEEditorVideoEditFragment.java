package dov.com.qq.im.aeeditor.module.edit;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import akrw;
import amtj;
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
import bfur;
import bltp;
import bmbc;
import bmbg;
import bmbj;
import bmbx;
import bmby;
import bmcu;
import bmcz;
import bmda;
import bmdb;
import bmfh;
import bmfk;
import bmgf;
import bmgg;
import bmgl;
import bmgs;
import bmgv;
import bmgw;
import bmin;
import bmio;
import bmiq;
import bmir;
import bmis;
import bmit;
import bmiu;
import bmiv;
import bmiw;
import bmix;
import bmiy;
import bmiz;
import bmja;
import bmjb;
import bmkl;
import bmkn;
import bmkt;
import bmlj;
import bmlk;
import bmlo;
import bmlv;
import bmma;
import bmme;
import bmmf;
import bmmg;
import bmna;
import bmng;
import bmnk;
import bmns;
import bmnt;
import bnub;
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
import zau;
import zxu;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements bmfk, bmkl, bmlj, bmlv, bmma, bmnk, VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp>, StickerLyricCallback, zxu
{
  private static final String d;
  private float jdField_a_of_type_Float = 1.0F;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected bmgf a;
  public bmgw a;
  private bmlo jdField_a_of_type_Bmlo;
  protected bmmg a;
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
  private bmlo jdField_b_of_type_Bmlo;
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
    File localFile = new File(bmcz.jdField_c_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public AEEditorVideoEditFragment()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Bmgf = new bmgf();
    this.jdField_a_of_type_Bmmg = bmme.a();
  }
  
  private void H()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bmin(this);
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
    bmbg.a().a().i = 0;
    bmbc.a().j();
  }
  
  private void M()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null)
    {
      bmbg.a().a().jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().size();
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList(), 0);
    }
    bmbc.a().i();
  }
  
  private void N()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel == null) && (this.jdField_a_of_type_Bmlo != null))
    {
      localObject2 = this.jdField_a_of_type_Bmlo.d();
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
        ((SubtitleModel)localObject1).setLyricFormatIsQRC(this.jdField_a_of_type_Bmlo.e().equals("QRC"));
        ((SubtitleModel)localObject1).setMusicStartTime(a(this.jdField_a_of_type_Bmlo.a()));
        localObject2 = bmkn.a().a("font_runyuan75w", 0);
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
      if (this.jdField_a_of_type_Bmlo == null) {
        break;
      }
      localObject1 = this.jdField_a_of_type_Bmlo.d();
    } while (!a((String)localObject1));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric((String)localObject1);
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_Bmlo.e().equals("QRC"));
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(a(this.jdField_a_of_type_Bmlo.a()));
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
    bmbx.d(jdField_d_of_type_JavaLangString, "no video clip start time");
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
      bmbx.a(jdField_d_of_type_JavaLangString, "speed = " + localObject);
      return localObject;
      localObject = "speed";
      break;
      label69:
      bmbx.d(jdField_d_of_type_JavaLangString, "no speed");
    }
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable bmgw parambmgw)
  {
    if ((parambmgw == null) || (CollectionUtils.isEmpty(parambmgw.jdField_a_of_type_JavaUtilList))) {
      return null;
    }
    Object localObject = new LinkedList(parambmgw.jdField_a_of_type_JavaUtilList);
    if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null)) {}
    for (parambmgw = ((YoutuResultItem)((List)localObject).get(0)).Label;; parambmgw = null)
    {
      if ((((List)localObject).size() > 1) && (((List)localObject).get(1) != null)) {}
      for (localObject = ((YoutuResultItem)((List)localObject).get(1)).Label;; localObject = null)
      {
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(parambmgw)) {
          localArrayList.add(parambmgw);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378234));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bmit(this));
    g(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378235));
    zau.a(this.jdField_b_of_type_AndroidWidgetTextView, false);
    Size localSize = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
    if ((localSize != null) && (localSize.getHeight() != 0)) {
      if (localSize.getWidth() / localSize.getHeight() > 1.0F) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378232));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378233));
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnClickListener(new bmiv(this));
      paramView = new GestureDetector(paramView.getContext(), new bmiw(this));
      this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnTouchListener(new bmix(this, paramView));
      return;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378231));
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378231));
    }
  }
  
  private void a(@Nullable bmlo parambmlo)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    if ((parambmlo == null) || (!this.h))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null) {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
      }
      parambmlo = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      if (this.jdField_a_of_type_Bmlo != null) {}
      for (bool1 = true;; bool1 = false)
      {
        parambmlo.setBgmPlayed(false, bool1);
        return;
      }
    }
    String str = AEEditorMusicHelper.a(parambmlo);
    boolean bool3 = AEEditorMusicHelper.a(str);
    float f1;
    float f2;
    if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
      VideoControlPanel localVideoControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      if (this.jdField_a_of_type_Bmlo != null)
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
      parambmlo.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(str, a(parambmlo.a()), parambmlo.b());
      parambmlo = this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
      f1 = this.jdField_a_of_type_Float;
      f2 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Boolean) {
        break label249;
      }
    }
    label249:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(parambmlo, f1, f2, bool1);
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        g(true);
      }
      parambmlo = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
      bool1 = bool2;
      if (this.jdField_a_of_type_Bmlo != null) {
        bool1 = true;
      }
      parambmlo.setBgmPlayed(true, bool1);
      return;
      bool1 = false;
      break;
    }
    label255:
    if ((getActivity() == null) || (getActivity().getAppInterface() == null))
    {
      bmbx.b(jdField_d_of_type_JavaLangString, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    if (parambmlo.jdField_a_of_type_Int == 1)
    {
      bmbx.b(jdField_d_of_type_JavaLangString, "[updateSoundAndMusicConfig], editorMusicInfo=" + parambmlo + ", downloadStatus=STATUS_DOWNLOADING");
      return;
    }
    parambmlo.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(getActivity().getAppInterface(), parambmlo, parambmlo.b(), str, this), 128, null, true);
  }
  
  private void a(@NonNull bmlo parambmlo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambmlo.a())) {}
    label136:
    for (;;)
    {
      return;
      List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
      Iterator localIterator = localList.iterator();
      bmlo localbmlo;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localbmlo = (bmlo)localIterator.next();
          if ((localbmlo != null) && (!localbmlo.a()) && (parambmlo.jdField_b_of_type_Int != 1) && (parambmlo.jdField_b_of_type_Int != 0) && (parambmlo.a().equals(localbmlo.a()))) {
            if (paramBoolean) {
              localbmlo.jdField_a_of_type_Int = 2;
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
        localbmlo.jdField_a_of_type_Int = 0;
        break;
      }
    }
  }
  
  private void a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    bmbx.b(jdField_d_of_type_JavaLangString, "[requestDetailedMusicInfo]");
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramVsMusicItemInfo.mSongMid);
    AEEditorMusicHelper.a(localArrayList, new bmir(this, paramVsMusicItemInfo));
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
      bmbx.d(jdField_d_of_type_JavaLangString, "activity is null.");
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
    paramString1 = a(this.jdField_a_of_type_Bmgw);
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
    bmbx.d(jdField_d_of_type_JavaLangString, "no video clip start time");
    return 0L;
  }
  
  private void c(int paramInt)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel != null) && (this.jdField_a_of_type_Bmlo != null))
    {
      str = this.jdField_a_of_type_Bmlo.d();
      if (a(str)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric(str);
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_Bmlo.e().equals("QRC"));
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
      a("视频裁剪Range", bmnt.a(this.jdField_b_of_type_Long) + "~" + bmnt.a(l2 / 1000L));
      if (this.l)
      {
        O();
        N();
      }
      bmbg.a().a().jdField_a_of_type_Long = this.jdField_a_of_type_Long;
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
    bmgs localbmgs = new bmgs(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    localbmgs.a(new bmjb(this));
    bmfh.a().a(getActivity().getAppInterface(), getActivity(), localbmgs);
  }
  
  public void B()
  {
    String str = "";
    if (!TextUtils.isEmpty(bmbg.a().a().jdField_a_of_type_JavaLangString)) {
      str = bmbg.a().a().jdField_a_of_type_JavaLangString;
    }
    AEEditorMusicHelper.a(getActivity(), str);
    bmbc.a().o();
  }
  
  public void C()
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).d();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(amtj.a(2131689706));
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
    if ((this.jdField_a_of_type_Bmlo == null) || (this.jdField_a_of_type_JavaLangInteger == null))
    {
      if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      }
      return;
    }
    bmlk.a().b(this.jdField_a_of_type_JavaLangInteger.intValue(), Math.min(this.jdField_a_of_type_JavaLangInteger.intValue() + this.jdField_a_of_type_Long, this.jdField_a_of_type_Bmlo.b()));
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bmlo);
    int m = this.jdField_a_of_type_JavaLangInteger.intValue();
    int n = this.jdField_a_of_type_Bmlo.b();
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
    if ((this.jdField_a_of_type_Bmlo == null) || (this.jdField_a_of_type_JavaLangInteger == null)) {
      return;
    }
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bmlo);
    int m = a(this.jdField_a_of_type_Bmlo.a());
    int n = this.jdField_a_of_type_Bmlo.b();
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
    if ((this.jdField_a_of_type_Bmlo == null) || (this.jdField_a_of_type_JavaLangInteger == null)) {
      return;
    }
    a(this.jdField_a_of_type_Bmlo.a(), this.jdField_a_of_type_JavaLangInteger.intValue(), true);
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bmlo);
    int m = this.jdField_a_of_type_JavaLangInteger.intValue();
    int n = this.jdField_a_of_type_Bmlo.b();
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
    return 2131558569;
  }
  
  protected bmkl a()
  {
    return this;
  }
  
  protected bmkt a()
  {
    return new bmja(this);
  }
  
  protected bmna a()
  {
    return new bmio(this);
  }
  
  protected bmng a()
  {
    return this;
  }
  
  protected LocalMediaInfo a(String paramString1, String paramString2, String paramString3)
  {
    return bmns.a(this.jdField_e_of_type_JavaLangString, a().getHeight(), a().getWidth(), paramString1, paramString2, paramString3);
  }
  
  protected Size a()
  {
    this.jdField_b_of_type_ComTencentTavcutBeanSize = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
    return this.jdField_a_of_type_Bmmg.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
  }
  
  protected TAVCutSession a()
  {
    return this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  }
  
  public StickerOperationCallback a()
  {
    return new bmiz(this);
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
      bmbg.a().a().jdField_a_of_type_Int = a(this.g, this.h);
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
    bmbg.a().a().jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(paramInt1, paramInt2);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.h();
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt1);
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
  }
  
  public void a(int paramInt, bmgl parambmgl)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.16(this, parambmgl));
    }
    if (paramInt == 0)
    {
      bmbx.b(jdField_d_of_type_JavaLangString, "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.18(this));
      if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (parambmgl != null)) {
        break label107;
      }
    }
    label107:
    bmgw localbmgw;
    do
    {
      return;
      bmbx.b(jdField_d_of_type_JavaLangString, "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.17(this));
      break;
      this.jdField_a_of_type_Bmgf.a(this.jdField_e_of_type_JavaLangString, parambmgl);
      this.jdField_a_of_type_JavaUtilArrayList = a(parambmgl);
      localbmgw = (bmgw)parambmgl;
    } while (localbmgw == null);
    a(localbmgw);
    a(new String[] { "智能滤镜label", localbmgw.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    parambmgl = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localbmgw.jdField_a_of_type_JavaLangString)) {
        break label285;
      }
      parambmgl = localNewEnhanceCategories.filterType;
    }
    label285:
    for (;;)
    {
      break;
      bmbg.a().a().jdField_b_of_type_JavaLangString = ("effect_aieffect_" + parambmgl);
      bmbg.a().a().jdField_a_of_type_Float = -1.0F;
      this.jdField_f_of_type_JavaLangString = "effect_aieffect";
      return;
    }
  }
  
  public void a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    n();
    String str1 = bmkn.a().a(paramAEEditorFilterBean);
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
      String str2 = bmkn.a().c(paramAEEditorFilterBean);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModel(f1, str1, f3, localMap, str2);
      bmbg.a().a().jdField_b_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
      bmbg.a().a().jdField_a_of_type_Float = f2;
      this.jdField_f_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      break;
    }
  }
  
  protected void a(@NonNull bmgw parambmgw)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
    {
      bmbx.d(jdField_d_of_type_JavaLangString, "tavVideoSession is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(parambmgw.jdField_b_of_type_JavaLangString, 0.8F, parambmgw.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
  }
  
  public void a(@Nullable bmlo parambmlo, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parambmlo == null) || (parambmlo.a())) {
      return;
    }
    this.h = true;
    this.jdField_b_of_type_Bmlo = this.jdField_a_of_type_Bmlo;
    this.jdField_a_of_type_Bmlo = parambmlo;
    bmbg.a().a().jdField_a_of_type_Int = a(this.g, this.h);
    bmbg.a().a().jdField_c_of_type_JavaLangString = parambmlo.a();
    bmbg.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Bmlo.jdField_b_of_type_Boolean;
    bmbg.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_Bmlo.jdField_c_of_type_Int;
    bmbg.a().a().jdField_c_of_type_Int = this.jdField_a_of_type_Bmlo.b();
    bmbc.a().m();
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    Iterator localIterator = localList.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      bmlo localbmlo = (bmlo)localIterator.next();
      if ((localbmlo != null) && (!localbmlo.a()) && (localbmlo.jdField_b_of_type_Int != 1) && (localbmlo.jdField_b_of_type_Int != 0))
      {
        if (parambmlo.a().equals(localbmlo.a()))
        {
          localbmlo.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Bmlo = localbmlo;
          parambmlo = localbmlo;
          m = 1;
        }
        for (;;)
        {
          break;
          localbmlo.jdField_a_of_type_Boolean = false;
        }
      }
    }
    int n = paramInt;
    if (m == 0)
    {
      parambmlo.jdField_a_of_type_Boolean = true;
      m = localList.size() - 1;
      if (paramInt <= m) {
        break label347;
      }
      n = m + 1;
      localList.add(parambmlo);
    }
    for (;;)
    {
      a(parambmlo.a(), parambmlo.a(), false);
      a(parambmlo);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(n);
      if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
        break;
      }
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(true);
      return;
      label347:
      localList.add(paramInt, parambmlo);
      n = paramInt;
    }
  }
  
  public void a(@NonNull bmlo parambmlo, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.15(this, parambmlo, paramBoolean, paramString));
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    int i1 = 0;
    if ((!paramBoolean) || (paramStSmartMatchMusicRsp == null) || (CollectionUtils.isEmpty(paramStSmartMatchMusicRsp.vecMusic.get()))) {
      bmbx.d(jdField_d_of_type_JavaLangString, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
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
            bmbg.a().a().jdField_d_of_type_JavaLangString = paramString.value.get();
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
    bmbg.a().a().jdField_e_of_type_JavaLangString = paramVSBaseRequest;
    int m = 0;
    int n = i1;
    if (m < localList.size())
    {
      paramVSBaseRequest = (bmlo)localList.get(m);
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
      paramVSBaseRequest = (bmlo)paramString.get(n);
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
    LocalMediaInfo localLocalMediaInfo = bmns.a(a(paramString1, paramString2, paramString3), getArguments().getString("material_id"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_f_of_type_JavaLangString);
    bmdb localbmdb = bmdb.a();
    String str1 = localLocalMediaInfo.materialID;
    String str2 = localLocalMediaInfo.materialName;
    String str3 = localLocalMediaInfo.filterID;
    String str4 = localLocalMediaInfo.scheme;
    int m = localLocalMediaInfo.showCircleTakeSame;
    String str5 = this.jdField_e_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {}
    for (MediaModel localMediaModel = new MediaModel();; localMediaModel = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel())
    {
      localbmdb.a(str1, str2, str3, str4, m, paramString3, str5, paramString1, paramString2, localMediaModel);
      if (getActivity() != null) {
        break;
      }
      bmbx.d(jdField_d_of_type_JavaLangString, "activity is null.");
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) && (akrw.jdField_a_of_type_Int != 2)) {
        break label77;
      }
    }
    label77:
    for (int m = 0;; m = 1)
    {
      AEEditorMusicHelper.a(paramArrayList, bltp.a().a(), paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, m, this);
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
    bmbc.a().q();
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
      localObject = bfur.a((Context)localObject, 230).setTitle(amtj.a(2131689720)).setMessage(((Context)localObject).getString(2131689721)).setPositiveButton(((Context)localObject).getString(2131689720), new bmiu(this)).setNegativeButton(((Context)localObject).getString(2131689690), new bmis(this));
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
    bmbg.a().a().jdField_b_of_type_JavaLangString = paramAEEditorFilterBean.getEffectId();
    bmbg.a().a().jdField_a_of_type_Float = -1.0F;
    return true;
  }
  
  public void aD_()
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
    return amtj.a(2131689706);
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    P();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bmlo == null) {
      return;
    }
    bmlk.a().b(paramInt, Math.min(paramInt + this.jdField_a_of_type_Long, this.jdField_a_of_type_Bmlo.b()));
    String str = AEEditorMusicHelper.a(this.jdField_a_of_type_Bmlo);
    int m = this.jdField_a_of_type_Bmlo.b();
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
    this.i = bmby.a();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {}
    List localList;
    do
    {
      return;
      this.h = paramBoolean;
      bmbg.a().a().jdField_a_of_type_Int = a(this.g, this.h);
      localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a();
    } while (CollectionUtils.isEmpty(localList));
    Object localObject;
    int n;
    int m;
    if (paramBoolean)
    {
      if ((this.jdField_b_of_type_Bmlo == null) || (this.jdField_b_of_type_Bmlo.a())) {
        break label517;
      }
      int i1 = 0;
      localObject = null;
      n = 0;
      m = 0;
      if (i1 < localList.size())
      {
        bmlo localbmlo = (bmlo)localList.get(i1);
        int i2;
        if ((localbmlo != null) && (!localbmlo.a()) && (localbmlo.jdField_b_of_type_Int != 1)) {
          if (localbmlo.jdField_b_of_type_Int == 0)
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
          if (this.jdField_b_of_type_Bmlo.a().equals(localbmlo.a()))
          {
            localbmlo.jdField_a_of_type_Boolean = true;
            m = 1;
            n = i1;
            localObject = localbmlo;
          }
          else
          {
            localbmlo.jdField_a_of_type_Boolean = false;
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
        this.jdField_b_of_type_Bmlo = ((bmlo)localObject);
        this.jdField_a_of_type_Bmlo = ((bmlo)localObject);
        label236:
        this.jdField_a_of_type_Bmlo.jdField_a_of_type_Boolean = true;
        bmbg.a().a().jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bmlo.a();
        bmbg.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Bmlo.jdField_b_of_type_Boolean;
        bmbg.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_Bmlo.jdField_c_of_type_Int;
        bmbg.a().a().jdField_c_of_type_Int = this.jdField_a_of_type_Bmlo.b();
        bmbc.a().m();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Bmlo != null) {
          a(this.jdField_a_of_type_Bmlo.a(), this.jdField_a_of_type_Bmlo.a(), false);
        }
        a(this.jdField_a_of_type_Bmlo);
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(localList);
        if (paramBoolean) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(m);
        }
        if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
          break;
        }
        ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).a(paramBoolean);
        return;
        this.jdField_b_of_type_Bmlo = null;
        this.jdField_a_of_type_Bmlo = ((bmlo)localList.get(1));
        break label236;
        this.jdField_b_of_type_Bmlo = this.jdField_a_of_type_Bmlo;
        this.jdField_a_of_type_Bmlo = null;
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bmlo)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
        }
        bmbg.a().a().jdField_c_of_type_JavaLangString = "none";
        bmbg.a().a().jdField_a_of_type_Boolean = false;
        bmbg.a().a().jdField_b_of_type_Int = -1;
        bmbg.a().a().jdField_c_of_type_Int = -1;
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
    bmbx.d(jdField_d_of_type_JavaLangString, "no video paths");
    return null;
  }
  
  protected void d()
  {
    bmfh.a().a();
  }
  
  public void d(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_Bmlo == null))
    {
      QQToast.a(getActivity(), 2131689716, 0).a();
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.a(this.jdField_a_of_type_Bmlo, Integer.valueOf(a(this.jdField_a_of_type_Bmlo.a())), (int)this.jdField_a_of_type_Long, this.jdField_d_of_type_Boolean);
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
      if (this.jdField_a_of_type_Bmlo != null)
      {
        if (a(this.jdField_a_of_type_Bmlo.d())) {
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
    Object localObject = this.jdField_a_of_type_Bmgf.a(this.jdField_e_of_type_JavaLangString);
    boolean bool1;
    if ((localObject != null) && ((localObject instanceof bmgw)))
    {
      bmbx.b(jdField_d_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool1 = ((bmgw)localObject).jdField_a_of_type_Boolean;
      if (!bool1) {
        break label98;
      }
      k();
      localObject = new bmgv(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((bmgv)localObject).a(this);
      bmfh.a().a(getActivity().getAppInterface(), getActivity(), (bmgg)localObject);
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
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(((bmgl)localObject).b(), 0.8F, ((bmgl)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((bmgl)localObject).a(), "智能滤镜errCode", "0" });
    }
  }
  
  public void g()
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.11(this));
    String str1 = bmda.jdField_d_of_type_JavaLangString;
    Object localObject = new File(str1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File localFile = new File(this.jdField_e_of_type_JavaLangString);
    localObject = e();
    String str2 = str1 + File.separator + "output_" + (String)localObject + "_" + bnub.a(localFile.getName()) + ".jpg";
    str1 = str1 + File.separator + "output_" + (String)localObject + "_" + bnub.a(localFile.getName()) + ".mp4";
    M();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getEffectVideoFrame(0L, 1080, new bmiq(this, str2, str1, (String)localObject));
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
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(amtj.a(2131689706));
  }
  
  protected void m()
  {
    this.k = true;
    I();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bmbx.b(jdField_d_of_type_JavaLangString, "onCreate");
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
    paramBundle = bmbg.a().a();
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
    bmbx.b(jdField_d_of_type_JavaLangString, "onDestroyView");
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
    this.jdField_a_of_type_Bmlo = null;
    this.jdField_b_of_type_Bmlo = null;
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
      bmbc.a().r();
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
    bmbx.b(jdField_d_of_type_JavaLangString, "onPause");
    if (!this.jdField_e_of_type_Boolean) {
      b(false);
    }
  }
  
  public void onResume()
  {
    bmbx.b(jdField_d_of_type_JavaLangString, "onResume");
    super.onResume();
    if (!this.jdField_e_of_type_Boolean)
    {
      bmbc.a().r();
      b(true);
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null) {
        a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bmbx.b(jdField_d_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    s();
    I();
    H();
    bmbg.a().a().jdField_c_of_type_JavaLangString = "none";
    bmbg.a().a().jdField_a_of_type_Boolean = false;
    bmbg.a().a().jdField_b_of_type_Int = -1;
    bmbg.a().a().jdField_c_of_type_Int = -1;
    bmbg.a().a().jdField_a_of_type_Int = a(this.g, this.h);
    bmbg.a().a().jdField_d_of_type_JavaLangString = "none";
    bmbg.a().a().jdField_e_of_type_JavaLangString = "none";
    paramView = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
    a(this.jdField_e_of_type_JavaLangString, paramView.getWidth(), paramView.getHeight(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    a(new String[] { "设备级别", bmmf.a(), "视频最大预览尺寸", String.valueOf(this.jdField_a_of_type_Bmmg.a()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出码率", String.valueOf(this.jdField_a_of_type_Bmmg.b()), "视频导出帧率", String.valueOf(this.jdField_a_of_type_Bmmg.c()) });
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (e())) {
      if (bmkn.a().b())
      {
        bmbx.b(jdField_d_of_type_JavaLangString, "single image + first time : aifilter auto request");
        f();
        o();
        bmbc.a().w();
      }
    }
    for (int m = 1;; m = 0)
    {
      if ((bmkn.a().b()) && (m == 0)) {
        A();
      }
      return;
      bmbx.d(jdField_d_of_type_JavaLangString, "single image + first time : aifilter res not ready, do not request");
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
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new bmiy(this));
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
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Bmmg.a());
    StickerEditViewIconConfig localStickerEditViewIconConfig = new StickerEditViewIconConfig();
    localStickerEditViewIconConfig.setDeleteIconResId(2130837746);
    localStickerEditViewIconConfig.setEditIconResId(2130837745);
    localStickerEditViewIconConfig.setZoomIconResId(2130837747);
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
    bmbg.a().a().jdField_b_of_type_JavaLangString = "effect_blank";
    bmbg.a().a().jdField_a_of_type_Float = -1.0F;
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
      bmbc.a().a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
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
      if ("sticker_lyric".equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getStickerType()))
      {
        f();
        return;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
    for (;;)
    {
      L();
      return;
      f();
    }
  }
  
  public void z()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(amtj.a(2131689683));
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
      bmbc.a().k();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */