package dov.com.qq.im.aeeditor.module.export;

import bmbx;
import bmdg;
import bmkg;
import bmme;
import bmmg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.weseevideo.model.MediaModel;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment;

public class AEEditorGenerateRunnable
  implements Runnable
{
  private bmdg jdField_a_of_type_Bmdg;
  private VideoExporter jdField_a_of_type_ComTencentTavcutExporterVideoExporter;
  private MediaModel jdField_a_of_type_ComTencentWeseevideoModelMediaModel;
  private final String jdField_a_of_type_JavaLangString = "AEEditorGenerateRunnable";
  private String b;
  private String c;
  private String d;
  
  public AEEditorGenerateRunnable(String paramString1, String paramString2, String paramString3, MediaModel paramMediaModel, bmdg parambmdg)
  {
    bmbx.b("AEEditorGenerateRunnable", "[AEEditorGenerateRunnable] new :" + paramString1);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel = paramMediaModel;
    this.jdField_a_of_type_Bmdg = parambmdg;
  }
  
  private void a(bmmg parambmmg, Size paramSize)
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
    localStringBuilder.append(parambmmg.b());
    localStringBuilder.append(", exportFrameRate=");
    localStringBuilder.append(parambmmg.c());
    bmbx.d("AEEditorGenerateRunnable", "[run], exportParams: " + localStringBuilder.toString());
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
      bmmg localbmmg = bmme.a();
      Size localSize;
      if (a())
      {
        AEEditorMultiVideoEditFragment.a(BaseApplicationImpl.getContext(), localTAVCutVideoSession, localbmmg, this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel, null, null);
        localSize = AEEditorMultiVideoEditFragment.a(localTAVCutVideoSession);
      }
      for (;;)
      {
        localSize = localbmmg.a(localSize);
        VideoExportConfig localVideoExportConfig = new VideoExportConfig();
        localVideoExportConfig.setOutputPath(this.d);
        localVideoExportConfig.setSize(localSize.getWidth(), localSize.getHeight());
        localVideoExportConfig.setBitRate(localbmmg.b());
        localVideoExportConfig.setFrameRate(localbmmg.c());
        localTAVCutVideoSession.applyCurrentSticker();
        a(localbmmg, localSize);
        this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter = localTAVCutVideoSession.getExporter(localVideoExportConfig);
        this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter.export(new bmkg(this, localTAVCutVideoSession));
        return;
        localSize = VideoUtil.getVideoSize(this.c);
        localTAVCutVideoSession.setMediaModel(this.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
        localTAVCutVideoSession.init(BaseApplicationImpl.getContext());
      }
      return;
    }
    catch (Exception localException)
    {
      bmbx.d("AEEditorGenerateRunnable", "[ERROR!!!!] generate error" + localException.getMessage());
      if (this.jdField_a_of_type_Bmdg != null) {
        this.jdField_a_of_type_Bmdg.a(this.b, -3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable
 * JD-Core Version:    0.7.0.1
 */