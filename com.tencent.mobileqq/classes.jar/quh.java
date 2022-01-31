import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class quh
  extends ohl
{
  @Nullable
  private quj jdField_a_of_type_Quj;
  @NotNull
  private quk jdField_a_of_type_Quk;
  @NotNull
  private qun jdField_a_of_type_Qun;
  @Nullable
  private roo jdField_a_of_type_Roo;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public quh(@NotNull QQAppInterface paramQQAppInterface, @NotNull quk paramquk, @Nullable quj paramquj)
  {
    super(paramquk, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_Qun = ((qun)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Quk = paramquk;
    this.jdField_a_of_type_Quj = paramquj;
  }
  
  public void a()
  {
    super.a();
    this.b = true;
    if (this.jdField_a_of_type_Roo != null) {
      this.jdField_a_of_type_Roo.a();
    }
    UgcVideo localUgcVideo = this.jdField_a_of_type_Quk.a();
    localUgcVideo.status = UgcVideo.STATUS_PAUSE;
    this.jdField_a_of_type_Qun.d(localUgcVideo);
    if (this.jdField_a_of_type_Quj != null) {
      this.jdField_a_of_type_Quj.a(1, true, false, null);
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Quk.a();
    int j;
    label72:
    String str;
    label113:
    long l;
    if ((localUgcVideo.compressPath != null) && (!localUgcVideo.compressPath.isEmpty()) && (new File(localUgcVideo.compressPath).exists()))
    {
      i = 1;
      if (i != 0) {
        localUgcVideo.compressProgress = 100;
      }
      if (localUgcVideo.retryTime < UgcVideo.RETRY_TIME_LIMIT) {
        break label196;
      }
      j = 1;
      if (j != 0)
      {
        str = localUgcVideo.filePath;
        File localFile = new File(str);
        localUgcVideo.compressPath = str;
        str = svz.a(localFile);
        if (str == null) {
          break label201;
        }
        localUgcVideo.fileMd5 = str;
        if (!localFile.exists()) {
          break label208;
        }
        l = localFile.length();
        label134:
        localUgcVideo.fileSize = l;
      }
      if ((i != 0) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE) || (j != 0)) {
        break label213;
      }
    }
    label196:
    label201:
    label208:
    label213:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.b = false;
        localUgcVideo.startCompressTime = System.currentTimeMillis();
      }
      if ((!super.a()) || (i == 0)) {
        break label218;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label72;
      str = "";
      break label113;
      l = 0L;
      break label134;
    }
    label218:
    return false;
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      UgcVideo localUgcVideo = this.jdField_a_of_type_Quk.a();
      this.jdField_a_of_type_Roo = new roo(BaseApplicationImpl.getContext(), new qui(this, localUgcVideo));
      this.jdField_a_of_type_Roo.execute(new String[] { localUgcVideo.filePath });
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_COMPRESS_VIDEO;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     quh
 * JD-Core Version:    0.7.0.1
 */