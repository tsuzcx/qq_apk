import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class tgd
  implements syt<tgi, tgj>
{
  tgd(tgc paramtgc, ssv paramssv, ssw paramssw) {}
  
  public void a(@NonNull tgi paramtgi, @Nullable tgj paramtgj, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtgj == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramtgj.b == 1)
    {
      this.jdField_a_of_type_Tgc.a(true);
      this.jdField_a_of_type_Ssv.b(2);
      this.jdField_a_of_type_Tgc.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramtgj.b);
    }
    this.jdField_a_of_type_Ssw.a(paramtgj.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgd
 * JD-Core Version:    0.7.0.1
 */