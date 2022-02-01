import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rgz
  extends omp
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private rgk jdField_a_of_type_Rgk;
  @NotNull
  private rgl jdField_a_of_type_Rgl;
  @NotNull
  private rgo jdField_a_of_type_Rgo;
  private rjy jdField_a_of_type_Rjy;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public rgz(@NotNull QQAppInterface paramQQAppInterface, @NotNull rgl paramrgl, @Nullable rgk paramrgk)
  {
    super(paramrgl, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Rgo = ((rgo)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Rgl = paramrgl;
    this.jdField_a_of_type_Rgk = paramrgk;
  }
  
  public void a()
  {
    super.a();
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rgl.a();
    if ((this.jdField_a_of_type_Rjy != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.jdField_a_of_type_Rjy.b();
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rgl.a();
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
    Object localObject = this.jdField_a_of_type_Rgl.a();
    if (((UgcVideo)localObject).coverPath != null) {}
    for (String str = ((UgcVideo)localObject).coverPath;; str = "")
    {
      if ((!this.jdField_a_of_type_Boolean) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = str;
        QLog.i("RIJUGC.UploadCoverTaskStep", 1, "onStep begin upload cover:" + str);
        localObject = new rha(this, (UgcVideo)localObject);
        if (this.jdField_a_of_type_Rjy != null) {
          this.jdField_a_of_type_Rjy.b();
        }
        this.jdField_a_of_type_Rjy = new rkb(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        this.jdField_a_of_type_Rjy.a((rjx)localObject);
        this.jdField_a_of_type_Rjy.a();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgz
 * JD-Core Version:    0.7.0.1
 */