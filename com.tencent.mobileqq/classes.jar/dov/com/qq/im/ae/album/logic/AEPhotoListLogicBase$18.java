package dov.com.qq.im.ae.album.logic;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import dov.com.qq.im.ae.album.data.AEAlbumVideoModel;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

class AEPhotoListLogicBase$18
  implements MovieExporter.VideoCompressListener
{
  AEPhotoListLogicBase$18(AEPhotoListLogicBase paramAEPhotoListLogicBase, int paramInt, AEAlbumVideoModel paramAEAlbumVideoModel) {}
  
  public void onCompressCanceled()
  {
    AEQLog.b("AEPhotoListLogicBase", "batchCompress---cancel, index=" + this.jdField_a_of_type_Int);
    if (AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase) != null) {
      AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase).countDown();
    }
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    AEQLog.b("AEPhotoListLogicBase", "batchCompress---error, index=" + this.jdField_a_of_type_Int + ", path=" + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.getPath());
    AEPhotoListLogicBase.b(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase, true);
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.2(this));
    if (AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase) != null) {
      AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase).countDown();
    }
  }
  
  public void onCompressFinish(String paramString)
  {
    AEQLog.b("AEPhotoListLogicBase", "batchCompress---finish, index=" + this.jdField_a_of_type_Int + ", compressed path=" + paramString);
    AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase).put(this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.getPath(), paramString);
    this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.setPath(paramString);
    if (AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase) != null) {
      AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase).countDown();
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.18
 * JD-Core Version:    0.7.0.1
 */