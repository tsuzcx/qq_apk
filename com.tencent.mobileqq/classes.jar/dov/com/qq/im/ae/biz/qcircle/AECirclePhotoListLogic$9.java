package dov.com.qq.im.ae.biz.qcircle;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import dov.com.qq.im.ae.album.data.AEAlbumVideoModel;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

class AECirclePhotoListLogic$9
  implements MovieExporter.VideoCompressListener
{
  AECirclePhotoListLogic$9(AECirclePhotoListLogic paramAECirclePhotoListLogic, int paramInt, AEAlbumVideoModel paramAEAlbumVideoModel) {}
  
  public void onCompressCanceled()
  {
    AEQLog.b("AECirclePhotoListLogic", "batchCompress---cancel, index=" + this.jdField_a_of_type_Int);
    if (AECirclePhotoListLogic.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic) != null) {
      AECirclePhotoListLogic.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic).countDown();
    }
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    AEQLog.b("AECirclePhotoListLogic", "batchCompress---error, index=" + this.jdField_a_of_type_Int + ", path=" + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.getPath());
    AECirclePhotoListLogic.b(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic, true);
    ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.9.2(this));
    if (AECirclePhotoListLogic.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic) != null) {
      AECirclePhotoListLogic.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic).countDown();
    }
  }
  
  public void onCompressFinish(String paramString)
  {
    AEQLog.b("AECirclePhotoListLogic", "batchCompress---finish, index=" + this.jdField_a_of_type_Int + ", compressed path=" + paramString);
    AECirclePhotoListLogic.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic).put(this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.getPath(), paramString);
    this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.setPath(paramString);
    if (AECirclePhotoListLogic.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic) != null) {
      AECirclePhotoListLogic.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic).countDown();
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.9.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic.9
 * JD-Core Version:    0.7.0.1
 */