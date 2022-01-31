import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class quy
  extends ohl
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private quj jdField_a_of_type_Quj;
  @NotNull
  private quk jdField_a_of_type_Quk;
  @NotNull
  private qun jdField_a_of_type_Qun;
  private qxd jdField_a_of_type_Qxd;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public quy(@NotNull QQAppInterface paramQQAppInterface, @NotNull quk paramquk, @Nullable quj paramquj)
  {
    super(paramquk, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Qun = ((qun)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Quk = paramquk;
    this.jdField_a_of_type_Quj = paramquj;
  }
  
  public void a()
  {
    super.a();
    UgcVideo localUgcVideo = this.jdField_a_of_type_Quk.a();
    if ((this.jdField_a_of_type_Qxd != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.jdField_a_of_type_Qxd.b();
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Quk.a();
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
    Object localObject = this.jdField_a_of_type_Quk.a();
    if (((UgcVideo)localObject).coverPath != null) {}
    for (String str = ((UgcVideo)localObject).coverPath;; str = "")
    {
      if ((!this.jdField_a_of_type_Boolean) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = str;
        QLog.i("RIJUGC.UploadCoverTaskStep", 1, "onStep begin upload cover:" + str);
        localObject = new quz(this, (UgcVideo)localObject);
        if (this.jdField_a_of_type_Qxd != null) {
          this.jdField_a_of_type_Qxd.b();
        }
        this.jdField_a_of_type_Qxd = new qxg(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        this.jdField_a_of_type_Qxd.a((qxc)localObject);
        this.jdField_a_of_type_Qxd.a();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     quy
 * JD-Core Version:    0.7.0.1
 */