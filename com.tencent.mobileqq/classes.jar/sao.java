import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class sao
  extends ovx
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private rzz jdField_a_of_type_Rzz;
  @NotNull
  private saa jdField_a_of_type_Saa;
  @NotNull
  private sad jdField_a_of_type_Sad;
  private sdn jdField_a_of_type_Sdn;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public sao(@NotNull QQAppInterface paramQQAppInterface, @NotNull saa paramsaa, @Nullable rzz paramrzz)
  {
    super(paramsaa, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Sad = ((sad)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.jdField_a_of_type_Saa = paramsaa;
    this.jdField_a_of_type_Rzz = paramrzz;
  }
  
  public void a()
  {
    super.a();
    UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
    if ((this.jdField_a_of_type_Sdn != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.jdField_a_of_type_Sdn.b();
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
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
    Object localObject = this.jdField_a_of_type_Saa.a();
    if (((UgcVideo)localObject).coverPath != null) {}
    for (String str = ((UgcVideo)localObject).coverPath;; str = "")
    {
      if ((!this.jdField_a_of_type_Boolean) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = str;
        QLog.i("RIJUGC.UploadCoverTaskStep", 1, "onStep begin upload cover:" + str);
        localObject = new sap(this, (UgcVideo)localObject);
        if (this.jdField_a_of_type_Sdn != null) {
          this.jdField_a_of_type_Sdn.b();
        }
        this.jdField_a_of_type_Sdn = new sdq(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        this.jdField_a_of_type_Sdn.a((sdm)localObject);
        this.jdField_a_of_type_Sdn.a();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sao
 * JD-Core Version:    0.7.0.1
 */