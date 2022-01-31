import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class sth
  implements slx<stm, stn>
{
  sth(stg paramstg, sfz paramsfz, sga paramsga) {}
  
  public void a(@NonNull stm paramstm, @Nullable stn paramstn, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramstn == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramstn.b == 1)
    {
      this.jdField_a_of_type_Stg.a(true);
      this.jdField_a_of_type_Sfz.b(2);
      this.jdField_a_of_type_Stg.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramstn.b);
    }
    this.jdField_a_of_type_Sga.a(paramstn.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sth
 * JD-Core Version:    0.7.0.1
 */