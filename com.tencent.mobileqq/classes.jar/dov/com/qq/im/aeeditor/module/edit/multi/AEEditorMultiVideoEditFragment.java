package dov.com.qq.im.aeeditor.module.edit.multi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.data.MusicData;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightMediaTemplateModel;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.data.AEAlbumMediaBaseModel;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterDataCache;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterProxyBase;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.MultiVideoAIFilterProxy;
import dov.com.qq.im.aeeditor.module.aifilter.SilentMultiVideoAIFilterProxy;
import dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterResult;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateBean;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.edit.multi.data.DataProcessor;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;
import dov.com.qq.im.aeeditor.module.params.VideoParamStrategy;
import dov.com.qq.im.aeeditor.util.AELocalMediaInfoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.light.LightAsset;

public class AEEditorMultiVideoEditFragment
  extends AEEditorVideoEditFragment
{
  private MediaResourceModel a;
  private MediaResourceModel jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel;
  private ArrayList<AEAlbumMediaBaseModel> jdField_b_of_type_JavaUtilArrayList;
  private String e;
  
  private void Q()
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = ((MediaResourceModel)getArguments().getSerializable("resource_model"));
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)getArguments().getSerializable("ae_album_selected_media_models"));
    try
    {
      if (this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel == null)
      {
        this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = new MediaResourceModel();
        this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.setVideos(DataProcessor.a(this.jdField_b_of_type_JavaUtilArrayList));
      }
      this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.deepCopy();
      if (this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.getVideos().size() > 0) {
        this.e = ((MediaClipModel)this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.getVideos().get(0)).getResource().getPath();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
  
  public static void a(Context paramContext, TAVCutVideoSession paramTAVCutVideoSession, VideoParamStrategy paramVideoParamStrategy, MediaModel paramMediaModel, MoviePlayer paramMoviePlayer, TAVCutVideoView paramTAVCutVideoView)
  {
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(paramVideoParamStrategy.a());
    paramVideoParamStrategy = new StickerEditViewIconConfig();
    paramVideoParamStrategy.setDeleteIconResId(2130837919);
    paramVideoParamStrategy.setEditIconResId(2130837918);
    paramVideoParamStrategy.setZoomIconResId(2130837920);
    localSessionConfig.setStickerEditViewIconConfig(paramVideoParamStrategy);
    paramTAVCutVideoSession.setSessionConfig(localSessionConfig);
    paramVideoParamStrategy = paramMediaModel;
    if (paramMediaModel == null) {
      paramVideoParamStrategy = new MediaModel();
    }
    paramTAVCutVideoSession.setMediaModel(paramVideoParamStrategy);
    if (paramMoviePlayer != null) {
      paramTAVCutVideoSession.addPlayer(paramMoviePlayer);
    }
    if (paramTAVCutVideoView != null) {
      paramTAVCutVideoSession.setTAVCutVideoView(paramTAVCutVideoView);
    }
    paramTAVCutVideoSession.init(paramContext);
    h = paramTAVCutVideoSession.correctMediaResource(60000L);
    if (ModelExtKt.isLightTemplate(paramVideoParamStrategy))
    {
      paramTAVCutVideoSession.setTemplate(4, new File(paramVideoParamStrategy.getMediaTemplateModel().getLightMediaTemplateModel().getFilePath()).getParent(), true, new String[] { "template.json" });
      return;
    }
    paramTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("AEEditorMultiCutFragment"));
  }
  
  public void E()
  {
    SilentMultiVideoAIFilterProxy localSilentMultiVideoAIFilterProxy = new SilentMultiVideoAIFilterProxy(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    localSilentMultiVideoAIFilterProxy.a(new AEEditorMultiVideoEditFragment.2(this));
    AEEditorAIFilterManager.a().a(getActivity().getAppInterface(), getActivity(), localSilentMultiVideoAIFilterProxy);
  }
  
  public LocalMediaInfo a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((AEAlbumMediaBaseModel)this.jdField_b_of_type_JavaUtilArrayList.get(i)).getOriginPath());
      i += 1;
    }
    AEQLog.b("AEEditorMultiVideoEditFragment", "createLocalMediaInfo... originPathList:" + localArrayList);
    return AELocalMediaInfoUtil.a(localArrayList, "", a().getHeight(), a().getWidth(), paramString1, paramString2, paramString3);
  }
  
  public Size a()
  {
    LightAsset localLightAsset;
    if (ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel())) {
      localLightAsset = LightAsset.Load(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaTemplateModel().getLightMediaTemplateModel().getFilePath(), 100);
    }
    for (this.jdField_b_of_type_ComTencentTavcutBeanSize = new Size(localLightAsset.width(), localLightAsset.height());; this.jdField_b_of_type_ComTencentTavcutBeanSize = a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession)) {
      return this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
    }
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
  
  public void a(@NonNull MusicData paramMusicData, float paramFloat1, float paramFloat2, boolean paramBoolean)
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
  
  public void a(@NonNull VideoAIFilterResult paramVideoAIFilterResult)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
    {
      AEQLog.d("AEEditorMultiVideoEditFragment", "tavVideoSession is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForMultiAI(paramVideoAIFilterResult.b, 0.8F, paramVideoAIFilterResult.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
  }
  
  public void a(AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean, String paramString)
  {
    super.a(paramAEEditorAutoTemplateBean, paramString);
    if (ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()))
    {
      paramAEEditorAutoTemplateBean = a(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
      getArguments().putSerializable("resource_model", paramAEEditorAutoTemplateBean);
      return;
    }
    getArguments().putSerializable("resource_model", this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, this);
  }
  
  public boolean a()
  {
    AEBaseDataReporter.a().q();
    if (this.d.equals(f()))
    {
      getArguments().putSerializable("resource_model", this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
      return false;
    }
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2131689760)).setMessage(((Context)localObject).getString(2131689761)).setPositiveButton(((Context)localObject).getString(2131689715), new AEEditorMultiVideoEditFragment.4(this)).setNegativeButton(((Context)localObject).getString(2131689713), new AEEditorMultiVideoEditFragment.3(this));
    if (localObject != null) {}
    try
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        ((QQCustomDialog)localObject).show();
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return "multi_video_" + super.e();
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache.a(this.e);
    boolean bool1;
    if ((localObject instanceof VideoAIFilterResult))
    {
      AEQLog.b("AEEditorMultiVideoEditFragment", "onAIFilterRequest: has cache");
      bool1 = ((VideoAIFilterResult)localObject).jdField_a_of_type_Boolean;
      if (!bool1) {
        break label94;
      }
      l();
      localObject = new MultiVideoAIFilterProxy(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((MultiVideoAIFilterProxy)localObject).a(this);
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
      label94:
      e(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForMultiAI(((AIFilterResult)localObject).b(), 0.8F, ((AIFilterResult)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((AIFilterResult)localObject).a(), "智能滤镜errCode", "0" });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Q();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.g = paramBoolean;
    if (!paramBoolean)
    {
      AEBaseDataReporter.a().r();
      a(true, true);
      this.f = true;
      if ((g()) && (getArguments() != null)) {}
      try
      {
        if ((MediaResourceModel)getArguments().getSerializable("resource_model") != null) {
          this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = ((MediaResourceModel)getArguments().getSerializable("resource_model")).deepCopy();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().setMediaResourceModel(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.correctMediaResource(60000L);
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.updateTemplateComposition(true);
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.restoreStickersWithLyric(new ArrayList(a()));
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(this.jdField_b_of_type_Float);
            this.jdField_a_of_type_Long = (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeSeconds() * 1000L);
            AEReportUtils.u();
            return;
            localException1 = localException1;
            localException1.printStackTrace();
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
    g(false);
  }
  
  public void u()
  {
    t();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    MediaModel localMediaModel = new MediaModel();
    localMediaModel.setMediaResourceModel(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
    a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy, localMediaModel, this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer, this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerLyricCallback(this);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(a());
    ThreadManager.excute(new AEEditorMultiVideoEditFragment.1(this), 16, null, true);
    this.d = f();
    this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */