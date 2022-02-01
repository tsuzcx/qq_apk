package dov.com.qq.im.ae.biz.qcircle;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;

class AECirclePhotoListLogic$10
  implements MovieExporter.VideoCompressListener
{
  AECirclePhotoListLogic$10(AECirclePhotoListLogic paramAECirclePhotoListLogic, MovieExporter.VideoCompressListener paramVideoCompressListener, String paramString) {}
  
  public void onCompressCanceled()
  {
    FileUtils.e(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressCanceled();
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    FileUtils.e(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressError(paramAssetExportSession);
  }
  
  public void onCompressFinish(String paramString)
  {
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressFinish(paramString);
  }
  
  public void onCompressStart()
  {
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressStart();
  }
  
  public void onCompressing(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressing(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic.10
 * JD-Core Version:    0.7.0.1
 */