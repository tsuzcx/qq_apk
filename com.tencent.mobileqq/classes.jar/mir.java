import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.qphone.base.util.QLog;

public class mir
  implements muo
{
  public mir(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  private void b()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().ab) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().ac)) {}
    for (boolean bool = true;; bool = false)
    {
      VideoMsgTools.a(this.a, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g), bool, false);
      return;
    }
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "MultiVideoMembersClickListener , Uin = " + paramLong + " , videoScr = " + paramInt1 + " , isNeedRequest " + paramBoolean + " , positon = " + paramInt2);
    }
    if ((paramInt2 == 7) && (paramBoolean)) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mir
 * JD-Core Version:    0.7.0.1
 */