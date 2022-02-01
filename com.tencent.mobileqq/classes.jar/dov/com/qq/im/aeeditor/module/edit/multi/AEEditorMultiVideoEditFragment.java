package dov.com.qq.im.aeeditor.module.edit.multi;

import amtj;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import bfur;
import bmbc;
import bmbx;
import bmfh;
import bmgf;
import bmgg;
import bmgl;
import bmgp;
import bmgr;
import bmgw;
import bmjz;
import bmka;
import bmkb;
import bmmg;
import bmns;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.Util;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.data.MusicData;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import java.util.ArrayList;
import java.util.List;

public class AEEditorMultiVideoEditFragment
  extends AEEditorVideoEditFragment
{
  private MediaResourceModel a;
  private MediaResourceModel b;
  private String d;
  
  private void H()
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = ((MediaResourceModel)getArguments().getSerializable("resource_model"));
    try
    {
      if (this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel == null) {
        return;
      }
      this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.clone();
      if ((this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel != null) && (this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.getVideos().size() > 0))
      {
        this.jdField_d_of_type_JavaLangString = ((MediaClipModel)this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.getVideos().get(0)).getResource().getPath();
        return;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
  }
  
  public static Size a(TAVCutVideoSession paramTAVCutVideoSession)
  {
    if (paramTAVCutVideoSession != null) {
      return paramTAVCutVideoSession.getExportMaxMediaSize();
    }
    return new Size(720, 1080);
  }
  
  private List<StickerModel> a()
  {
    MediaModel localMediaModel = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel();
    if (localMediaModel != null) {
      return localMediaModel.getMediaEffectModel().getStickerModelList();
    }
    return new ArrayList();
  }
  
  public static void a(Context paramContext, TAVCutVideoSession paramTAVCutVideoSession, bmmg parambmmg, MediaModel paramMediaModel, MoviePlayer paramMoviePlayer, TAVCutVideoView paramTAVCutVideoView)
  {
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(parambmmg.a());
    parambmmg = new StickerEditViewIconConfig();
    parambmmg.setDeleteIconResId(2130837746);
    parambmmg.setEditIconResId(2130837745);
    parambmmg.setZoomIconResId(2130837747);
    localSessionConfig.setStickerEditViewIconConfig(parambmmg);
    paramTAVCutVideoSession.setSessionConfig(localSessionConfig);
    parambmmg = paramMediaModel;
    if (paramMediaModel == null) {
      parambmmg = new MediaModel();
    }
    paramTAVCutVideoSession.setMediaModel(parambmmg);
    if (paramMoviePlayer != null) {
      paramTAVCutVideoSession.addPlayer(paramMoviePlayer);
    }
    if (paramTAVCutVideoView != null) {
      paramTAVCutVideoSession.setTAVCutVideoView(paramTAVCutVideoView);
    }
    paramTAVCutVideoSession.init(paramContext);
    paramTAVCutVideoSession.correctMediaResource(60000L);
    paramTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("AEEditorMultiCutFragment"));
  }
  
  public void A()
  {
    bmgr localbmgr = new bmgr(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    localbmgr.a(new bmjz(this));
    bmfh.a().a(getActivity().getAppInterface(), getActivity(), localbmgr);
  }
  
  public LocalMediaInfo a(String paramString1, String paramString2, String paramString3)
  {
    return bmns.a("", a().getHeight(), a().getWidth(), paramString1, paramString2, paramString3);
  }
  
  public Size a()
  {
    this.jdField_b_of_type_ComTencentTavcutBeanSize = a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    return this.jdField_a_of_type_Bmmg.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
  }
  
  public String a()
  {
    return "AEEditorMultiVideoEdit";
  }
  
  public void a()
  {
    if (getArguments() != null)
    {
      getArguments().clear();
      getArguments().putSerializable("resource_model", this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
    }
  }
  
  public void a(@NonNull bmgw parambmgw)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
    {
      bmbx.d("AEEditorMultiVideoEditFragment", "tavVideoSession is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForMultiAI(parambmgw.b, 0.8F, parambmgw.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
  }
  
  public void a(@NonNull MusicData paramMusicData, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.saveLyricSticker());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmMusicForMultiCut(paramMusicData, paramFloat1, paramFloat2, paramBoolean);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.restoreStickers(new ArrayList(a()));
    }
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(CMTime.fromMs(0L));
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, this);
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
      if (this.c.equals(g()))
      {
        getArguments().putSerializable("resource_model", this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
        return false;
      }
      Object localObject = getActivity();
      localObject = bfur.a((Context)localObject, 230).setTitle(amtj.a(2131689720)).setMessage(((Context)localObject).getString(2131689721)).setPositiveButton(((Context)localObject).getString(2131689720), new bmkb(this)).setNegativeButton(((Context)localObject).getString(2131689690), new bmka(this));
      if (localObject != null) {
        try
        {
          if (!((QQCustomDialog)localObject).isShowing())
          {
            ((QQCustomDialog)localObject).show();
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    return true;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String e()
  {
    return "multi_video_" + super.e();
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_Bmgf.a(this.jdField_d_of_type_JavaLangString);
    boolean bool1;
    if ((localObject instanceof bmgw))
    {
      bmbx.b("AEEditorMultiVideoEditFragment", "onAIFilterRequest: has cache");
      bool1 = ((bmgw)localObject).jdField_a_of_type_Boolean;
      if (!bool1) {
        break label94;
      }
      k();
      localObject = new bmgp(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((bmgp)localObject).a(this);
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
      label94:
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForMultiAI(((bmgl)localObject).b(), 0.8F, ((bmgl)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((bmgl)localObject).a(), "智能滤镜errCode", "0" });
    }
  }
  
  public String g()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString() != null)) {
      Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    }
    return "";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    H();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.e = paramBoolean;
    if (!paramBoolean)
    {
      bmbc.a().r();
      a(true, true);
      this.jdField_d_of_type_Boolean = true;
      if ((g()) && (getArguments() != null)) {}
      try
      {
        if ((MediaResourceModel)getArguments().getSerializable("resource_model") != null) {
          this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = ((MediaResourceModel)getArguments().getSerializable("resource_model")).clone();
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().setMediaResourceModel(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.correctMediaResource(60000L);
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.updateTemplateComposition(true);
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.restoreStickersWithLyric(new ArrayList(a()));
            this.jdField_a_of_type_Long = (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeSeconds() * 1000L);
            return;
            localCloneNotSupportedException = localCloneNotSupportedException;
            localCloneNotSupportedException.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    b(false);
  }
  
  public void s()
  {
    r();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    MediaModel localMediaModel = new MediaModel();
    localMediaModel.setMediaResourceModel(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
    a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, this.jdField_a_of_type_Bmmg, localMediaModel, this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer, this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerLyricCallback(this);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(a());
    this.c = g();
    this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */