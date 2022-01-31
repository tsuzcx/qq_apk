package dov.com.qq.im.aeeditor.module.export;

import bljn;
import blkk;
import blno;
import blov;
import blox;
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
  private blkk jdField_a_of_type_Blkk;
  private VideoExporter jdField_a_of_type_ComTencentTavcutExporterVideoExporter;
  private MediaModel jdField_a_of_type_ComTencentWeseevideoModelMediaModel;
  private final String jdField_a_of_type_JavaLangString = "AEEditorGenerateRunnable";
  private String b;
  private String c;
  private String d;
  
  public AEEditorGenerateRunnable(String paramString1, String paramString2, String paramString3, MediaModel paramMediaModel, blkk paramblkk)
  {
    bljn.b("AEEditorGenerateRunnable", "[AEEditorGenerateRunnable] new :" + paramString1);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel = paramMediaModel;
    this.jdField_a_of_type_Blkk = paramblkk;
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
      blox localblox = blov.a();
      Size localSize = localblox.a(VideoUtil.getVideoSize(this.c));
      localTAVCutVideoSession.setMediaModel(this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
      localTAVCutVideoSession.init(BaseApplicationImpl.getContext());
      VideoExportConfig localVideoExportConfig = new VideoExportConfig();
      localVideoExportConfig.setOutputPath(this.d);
      localVideoExportConfig.setSize(localSize.getWidth(), localSize.getHeight());
      localVideoExportConfig.setBitRate(localblox.b());
      localVideoExportConfig.setFrameRate(localblox.c());
      localTAVCutVideoSession.applyCurrentSticker();
      this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter = localTAVCutVideoSession.getExporter(localVideoExportConfig);
      this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter.export(new blno(this, localTAVCutVideoSession));
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bljn.d("AEEditorGenerateRunnable", "[ERROR!!!!] generate error" + localException.getMessage());
      } while (this.jdField_a_of_type_Blkk == null);
      this.jdField_a_of_type_Blkk.a(this.b, -3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable
 * JD-Core Version:    0.7.0.1
 */