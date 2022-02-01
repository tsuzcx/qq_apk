import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rob
  extends ooa
{
  @Nullable
  private rnk jdField_a_of_type_Rnk;
  @NotNull
  private rnl jdField_a_of_type_Rnl;
  @NotNull
  private rno jdField_a_of_type_Rno;
  @NotNull
  private rra jdField_a_of_type_Rra;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public rob(QQAppInterface paramQQAppInterface, @NotNull rnl paramrnl, @Nullable rnk paramrnk, @NotNull rra paramrra)
  {
    super(paramrnl, true, "UploadVideoTaskStep");
    this.jdField_a_of_type_Rno = ((rno)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Rnl = paramrnl;
    this.jdField_a_of_type_Rnk = paramrnk;
    this.jdField_a_of_type_Rra = paramrra;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rnl.a();
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "pauseUpload, ugcVideo.status=" + localUgcVideo.status);
    if ((localUgcVideo.status == UgcVideo.STATUS_UPLOADING) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE))
    {
      if (!TextUtils.isEmpty(localUgcVideo.videoUploadKey)) {
        this.jdField_a_of_type_Rra.a();
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
    this.jdField_a_of_type_Rnl.a().lastUploadSizeUpdateTime = 0L;
    b();
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rnl.a();
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
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rnl.a();
    String str1 = localUgcVideo.compressPath;
    String str2;
    if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(str1)))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Rnl.a().status = UgcVideo.STATUS_UPLOADING;
      QLog.i("RIJUGC.UploadVideoTaskStep", 1, "onStep begin upload video, filePath=" + str1);
      localUgcVideo.startUploadingTime = System.currentTimeMillis();
      if (localUgcVideo.startUserWaitingTime > 0L) {
        localUgcVideo.startUserWaitingTime = System.currentTimeMillis();
      }
      this.jdField_a_of_type_Rno.d(localUgcVideo);
      str2 = localUgcVideo.videoUploadKey;
      localUgcVideo.lastUploadSizeUpdateTime = System.currentTimeMillis();
      roc localroc = new roc(this, localUgcVideo);
      this.jdField_a_of_type_Rra.a(localroc);
      if (!TextUtils.isEmpty(str2)) {
        break label161;
      }
      this.jdField_a_of_type_Rra.a(str1);
    }
    for (;;)
    {
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_UPLOADING_VIDEO;
      return false;
      label161:
      this.jdField_a_of_type_Rra.b(str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rob
 * JD-Core Version:    0.7.0.1
 */