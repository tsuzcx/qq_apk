package dov.com.qq.im.aeeditor.module.export;

import bpam;
import bpbw;
import bphk;
import bpji;
import bpjk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.weseevideo.model.MediaModel;

public class AEEditorGenerateRunnable
  implements Runnable
{
  private bpbw jdField_a_of_type_Bpbw;
  private VideoExporter jdField_a_of_type_ComTencentTavcutExporterVideoExporter;
  private MediaModel jdField_a_of_type_ComTencentWeseevideoModelMediaModel;
  private final String jdField_a_of_type_JavaLangString = "AEEditorGenerateRunnable";
  private String b;
  private String c;
  private String d;
  
  public AEEditorGenerateRunnable(String paramString1, String paramString2, String paramString3, MediaModel paramMediaModel, bpbw parambpbw)
  {
    bpam.b("AEEditorGenerateRunnable", "[AEEditorGenerateRunnable] new :" + paramString1);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel = paramMediaModel;
    this.jdField_a_of_type_Bpbw = parambpbw;
  }
  
  private void a(bpjk parambpjk, Size paramSize)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoSrc=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", videoDst=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", exportWidth=");
    localStringBuilder.append(paramSize.getWidth());
    localStringBuilder.append(", exportHeight=");
    localStringBuilder.append(paramSize.getHeight());
    localStringBuilder.append(", exportBitRate=");
    localStringBuilder.append(parambpjk.b());
    localStringBuilder.append(", exportFrameRate=");
    localStringBuilder.append(parambpjk.c());
    bpam.d("AEEditorGenerateRunnable", "[run], exportParams: " + localStringBuilder.toString());
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
      bpjk localbpjk = bpji.a();
      Size localSize = localbpjk.a(VideoUtil.getVideoSize(this.c));
      localTAVCutVideoSession.setMediaModel(this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
      localTAVCutVideoSession.init(BaseApplicationImpl.getContext());
      VideoExportConfig localVideoExportConfig = new VideoExportConfig();
      localVideoExportConfig.setOutputPath(this.d);
      localVideoExportConfig.setSize(localSize.getWidth(), localSize.getHeight());
      localVideoExportConfig.setBitRate(localbpjk.b());
      localVideoExportConfig.setFrameRate(localbpjk.c());
      localTAVCutVideoSession.applyCurrentSticker();
      a(localbpjk, localSize);
      this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter = localTAVCutVideoSession.getExporter(localVideoExportConfig);
      this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter.export(new bphk(this, localTAVCutVideoSession));
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bpam.d("AEEditorGenerateRunnable", "[ERROR!!!!] generate error" + localException.getMessage());
      } while (this.jdField_a_of_type_Bpbw == null);
      this.jdField_a_of_type_Bpbw.a(this.b, -3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable
 * JD-Core Version:    0.7.0.1
 */