import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class saq
  extends ovx
{
  @Nullable
  private rzz jdField_a_of_type_Rzz;
  @NotNull
  private saa jdField_a_of_type_Saa;
  @NotNull
  private sad jdField_a_of_type_Sad;
  @NotNull
  private sdp jdField_a_of_type_Sdp;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public saq(QQAppInterface paramQQAppInterface, @NotNull saa paramsaa, @Nullable rzz paramrzz, @NotNull sdp paramsdp)
  {
    super(paramsaa, true, "UploadVideoTaskStep");
    this.jdField_a_of_type_Sad = ((sad)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.jdField_a_of_type_Saa = paramsaa;
    this.jdField_a_of_type_Rzz = paramrzz;
    this.jdField_a_of_type_Sdp = paramsdp;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "pauseUpload, ugcVideo.status=" + localUgcVideo.status);
    if ((localUgcVideo.status == UgcVideo.STATUS_UPLOADING) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE))
    {
      if (!TextUtils.isEmpty(localUgcVideo.videoUploadKey)) {
        this.jdField_a_of_type_Sdp.a();
      }
    }
    else {
      return;
    }
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "videoUploadKey is Empty");
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Saa.a().lastUploadSizeUpdateTime = 0L;
    b();
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
    String str2 = localUgcVideo.compressPath;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if ((localUgcVideo.url.length() == 0) && (new File(str1).exists()) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {}
    for (int i = 1; (super.a()) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
    String str1 = localUgcVideo.compressPath;
    String str2;
    if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(str1)))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Saa.a().status = UgcVideo.STATUS_UPLOADING;
      QLog.i("RIJUGC.UploadVideoTaskStep", 1, "onStep begin upload video, filePath=" + str1);
      localUgcVideo.startUploadingTime = System.currentTimeMillis();
      if (localUgcVideo.startUserWaitingTime > 0L) {
        localUgcVideo.startUserWaitingTime = System.currentTimeMillis();
      }
      this.jdField_a_of_type_Sad.d(localUgcVideo);
      str2 = localUgcVideo.videoUploadKey;
      localUgcVideo.lastUploadSizeUpdateTime = System.currentTimeMillis();
      sar localsar = new sar(this, localUgcVideo);
      this.jdField_a_of_type_Sdp.a(localsar);
      if (!TextUtils.isEmpty(str2)) {
        break label161;
      }
      this.jdField_a_of_type_Sdp.a(str1);
    }
    for (;;)
    {
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_UPLOADING_VIDEO;
      return false;
      label161:
      this.jdField_a_of_type_Sdp.b(str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     saq
 * JD-Core Version:    0.7.0.1
 */