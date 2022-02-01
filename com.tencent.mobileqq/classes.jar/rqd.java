import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rqd
  extends ouc
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private rpo jdField_a_of_type_Rpo;
  @NotNull
  private rpp jdField_a_of_type_Rpp;
  @NotNull
  private rps jdField_a_of_type_Rps;
  private rtc jdField_a_of_type_Rtc;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public rqd(@NotNull QQAppInterface paramQQAppInterface, @NotNull rpp paramrpp, @Nullable rpo paramrpo)
  {
    super(paramrpp, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Rps = ((rps)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Rpp = paramrpp;
    this.jdField_a_of_type_Rpo = paramrpo;
  }
  
  public void a()
  {
    super.a();
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rpp.a();
    if ((this.jdField_a_of_type_Rtc != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.jdField_a_of_type_Rtc.b();
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rpp.a();
    if (!TextUtils.isEmpty(localUgcVideo.coverUrl))
    {
      i = 1;
      if (i != 0) {
        localUgcVideo.coverProgress = 100;
      }
      if ((i != 0) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((!super.a()) || (i == 0)) {
        break label69;
      }
      return true;
      i = 0;
      break;
    }
    label69:
    return false;
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_Rpp.a();
    if (((UgcVideo)localObject).coverPath != null) {}
    for (String str = ((UgcVideo)localObject).coverPath;; str = "")
    {
      if ((!this.jdField_a_of_type_Boolean) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = str;
        QLog.i("RIJUGC.UploadCoverTaskStep", 1, "onStep begin upload cover:" + str);
        localObject = new rqe(this, (UgcVideo)localObject);
        if (this.jdField_a_of_type_Rtc != null) {
          this.jdField_a_of_type_Rtc.b();
        }
        this.jdField_a_of_type_Rtc = new rtf(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        this.jdField_a_of_type_Rtc.a((rtb)localObject);
        this.jdField_a_of_type_Rtc.a();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqd
 * JD-Core Version:    0.7.0.1
 */