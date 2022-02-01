import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rnz
  extends ooa
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private rnk jdField_a_of_type_Rnk;
  @NotNull
  private rnl jdField_a_of_type_Rnl;
  @NotNull
  private rno jdField_a_of_type_Rno;
  private rqy jdField_a_of_type_Rqy;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public rnz(@NotNull QQAppInterface paramQQAppInterface, @NotNull rnl paramrnl, @Nullable rnk paramrnk)
  {
    super(paramrnl, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Rno = ((rno)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Rnl = paramrnl;
    this.jdField_a_of_type_Rnk = paramrnk;
  }
  
  public void a()
  {
    super.a();
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rnl.a();
    if ((this.jdField_a_of_type_Rqy != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.jdField_a_of_type_Rqy.b();
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rnl.a();
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
    Object localObject = this.jdField_a_of_type_Rnl.a();
    if (((UgcVideo)localObject).coverPath != null) {}
    for (String str = ((UgcVideo)localObject).coverPath;; str = "")
    {
      if ((!this.jdField_a_of_type_Boolean) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = str;
        QLog.i("RIJUGC.UploadCoverTaskStep", 1, "onStep begin upload cover:" + str);
        localObject = new roa(this, (UgcVideo)localObject);
        if (this.jdField_a_of_type_Rqy != null) {
          this.jdField_a_of_type_Rqy.b();
        }
        this.jdField_a_of_type_Rqy = new rrb(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        this.jdField_a_of_type_Rqy.a((rqx)localObject);
        this.jdField_a_of_type_Rqy.a();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnz
 * JD-Core Version:    0.7.0.1
 */