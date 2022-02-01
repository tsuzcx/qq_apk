import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rpm
  extends ouc
{
  @Nullable
  private rpo jdField_a_of_type_Rpo;
  @NotNull
  private rpp jdField_a_of_type_Rpp;
  @NotNull
  private rps jdField_a_of_type_Rps;
  @Nullable
  private slf jdField_a_of_type_Slf;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public rpm(@NotNull QQAppInterface paramQQAppInterface, @NotNull rpp paramrpp, @Nullable rpo paramrpo)
  {
    super(paramrpp, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_Rps = ((rps)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Rpp = paramrpp;
    this.jdField_a_of_type_Rpo = paramrpo;
  }
  
  public void a()
  {
    super.a();
    this.b = true;
    if (this.jdField_a_of_type_Slf != null) {
      this.jdField_a_of_type_Slf.a();
    }
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rpp.a();
    localUgcVideo.status = UgcVideo.STATUS_PAUSE;
    this.jdField_a_of_type_Rps.d(localUgcVideo);
    if (this.jdField_a_of_type_Rpo != null) {
      this.jdField_a_of_type_Rpo.a(1, true, false, null);
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rpp.a();
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
        str = txh.a(localFile);
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
      UgcVideo localUgcVideo = this.jdField_a_of_type_Rpp.a();
      this.jdField_a_of_type_Slf = new slf(BaseApplicationImpl.getContext(), new rpn(this, localUgcVideo));
      this.jdField_a_of_type_Slf.execute(new String[] { localUgcVideo.filePath });
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_COMPRESS_VIDEO;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpm
 * JD-Core Version:    0.7.0.1
 */