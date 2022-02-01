package dov.com.qq.im.aeeditor.module.export;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightMediaTemplateModel;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.listener.AETavSessionStatusListener;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.qq.im.aeeditor.module.params.VideoParamStrategy;
import org.light.LightAsset;

public class AEEditorGenerateRunnable
  implements Runnable
{
  private VideoExporter jdField_a_of_type_ComTencentTavcutExporterVideoExporter;
  private MediaModel jdField_a_of_type_ComTencentWeseevideoModelMediaModel;
  private AETavSessionStatusListener jdField_a_of_type_DovComQqImAeeditorListenerAETavSessionStatusListener;
  private final String jdField_a_of_type_JavaLangString = "AEEditorGenerateRunnable";
  private String b;
  private String c;
  private String d;
  
  public AEEditorGenerateRunnable(String paramString1, String paramString2, String paramString3, MediaModel paramMediaModel, AETavSessionStatusListener paramAETavSessionStatusListener)
  {
    AEQLog.b("AEEditorGenerateRunnable", "[AEEditorGenerateRunnable] new :" + paramString1);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel = paramMediaModel;
    this.jdField_a_of_type_DovComQqImAeeditorListenerAETavSessionStatusListener = paramAETavSessionStatusListener;
  }
  
  private void a(VideoParamStrategy paramVideoParamStrategy, Size paramSize)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoSrc=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", videoDst=");
    localStringBuilder.append(this.d);
    if (paramSize != null)
    {
      localStringBuilder.append(", exportWidth=");
      localStringBuilder.append(paramSize.getWidth());
      localStringBuilder.append(", exportHeight=");
      localStringBuilder.append(paramSize.getHeight());
    }
    localStringBuilder.append(", exportBitRate=");
    localStringBuilder.append(paramVideoParamStrategy.b());
    localStringBuilder.append(", exportFrameRate=");
    localStringBuilder.append(paramVideoParamStrategy.c());
    AEQLog.d("AEEditorGenerateRunnable", "[run], exportParams: " + localStringBuilder.toString());
  }
  
  private boolean a()
  {
    return (this.b != null) && (this.b.startsWith("multi_video_"));
  }
  
  public VideoExporter a()
  {
    return this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter;
  }
  
  public void run()
  {
    try
    {
      TAVCutVideoSession localTAVCutVideoSession = new TAVCutVideoSession();
      VideoParamStrategy localVideoParamStrategy = ParamFactory.a();
      Object localObject;
      if (a())
      {
        AEEditorMultiVideoEditFragment.a(BaseApplicationImpl.getContext(), localTAVCutVideoSession, localVideoParamStrategy, this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel, null, null);
        localObject = AEEditorMultiVideoEditFragment.a(localTAVCutVideoSession);
      }
      for (;;)
      {
        if (ModelExtKt.isLightTemplate(localTAVCutVideoSession.getMediaModel()))
        {
          localObject = LightAsset.Load(localTAVCutVideoSession.getMediaModel().getMediaTemplateModel().getLightMediaTemplateModel().getFilePath(), 100);
          localObject = new Size(((LightAsset)localObject).width(), ((LightAsset)localObject).height());
        }
        localObject = localVideoParamStrategy.a((Size)localObject);
        VideoExportConfig localVideoExportConfig = new VideoExportConfig();
        localVideoExportConfig.setOutputPath(this.d);
        localVideoExportConfig.setSize(((Size)localObject).getWidth(), ((Size)localObject).getHeight());
        localVideoExportConfig.setBitRate(localVideoParamStrategy.b());
        localVideoExportConfig.setFrameRate(localVideoParamStrategy.c());
        localTAVCutVideoSession.applyCurrentSticker();
        a(localVideoParamStrategy, (Size)localObject);
        this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter = localTAVCutVideoSession.getExporter(localVideoExportConfig);
        this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter.export(new AEEditorGenerateRunnable.1(this, localTAVCutVideoSession));
        return;
        localObject = VideoUtil.getVideoSize(this.c);
        localTAVCutVideoSession.setMediaModel(this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
        localTAVCutVideoSession.init(BaseApplicationImpl.getContext());
      }
      return;
    }
    catch (Exception localException)
    {
      AEQLog.d("AEEditorGenerateRunnable", "[ERROR!!!!] generate error" + localException.getMessage());
      if (this.jdField_a_of_type_DovComQqImAeeditorListenerAETavSessionStatusListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorListenerAETavSessionStatusListener.a(this.b, -3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable
 * JD-Core Version:    0.7.0.1
 */