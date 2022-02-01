import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rzx
  extends ovx
{
  @Nullable
  private rzz jdField_a_of_type_Rzz;
  @NotNull
  private saa jdField_a_of_type_Saa;
  @NotNull
  private sad jdField_a_of_type_Sad;
  @Nullable
  private svy jdField_a_of_type_Svy;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public rzx(@NotNull QQAppInterface paramQQAppInterface, @NotNull saa paramsaa, @Nullable rzz paramrzz)
  {
    super(paramsaa, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_Sad = ((sad)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.jdField_a_of_type_Saa = paramsaa;
    this.jdField_a_of_type_Rzz = paramrzz;
  }
  
  public void a()
  {
    super.a();
    this.b = true;
    if (this.jdField_a_of_type_Svy != null) {
      this.jdField_a_of_type_Svy.a();
    }
    UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
    localUgcVideo.status = UgcVideo.STATUS_PAUSE;
    this.jdField_a_of_type_Sad.d(localUgcVideo);
    if (this.jdField_a_of_type_Rzz != null) {
      this.jdField_a_of_type_Rzz.a(1, true, false, null);
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
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
        str = urv.a(localFile);
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
      UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
      this.jdField_a_of_type_Svy = new svy(BaseApplicationImpl.getContext(), new rzy(this, localUgcVideo));
      this.jdField_a_of_type_Svy.execute(new String[] { localUgcVideo.filePath });
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_COMPRESS_VIDEO;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzx
 * JD-Core Version:    0.7.0.1
 */