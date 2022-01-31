import android.content.res.Resources;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.ui.MultiVideoEnterPageMembersControlUI;
import com.tencent.qphone.base.util.QLog;

public class mgq
  extends lgl
{
  public mgq(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null))
    {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onKickOutResult, empty");
      return;
    }
    if (paramLong != this.a.jdField_a_of_type_Long)
    {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onKickOutResult, ignore");
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin(), paramLong, this.a.b);
      this.a.b(paramInt2);
      return;
    }
    if (paramInt3 == -5)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 1) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] != null)) {
          this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].b.setVisibility(8);
        }
      }
      for (;;)
      {
        bcpw.a(this.a, 2131693238, 1).b(MultiVideoEnterPageActivity.b(this.a).getDimensionPixelSize(2131298865));
        return;
        this.a.jdField_a_of_type_Mgp.b.setVisibility(8);
      }
    }
    bcpw.a(this.a, 2131693237, 1).b(MultiVideoEnterPageActivity.c(this.a).getDimensionPixelSize(2131298865));
  }
  
  protected void c(long paramLong)
  {
    super.c(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin:" + paramLong + ", mRelationId = " + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong != 0L) && (paramLong == this.a.jdField_a_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin matched");
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgq
 * JD-Core Version:    0.7.0.1
 */