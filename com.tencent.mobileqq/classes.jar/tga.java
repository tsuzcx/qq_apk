import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class tga
  implements syq<tgf, tgg>
{
  tga(tfz paramtfz, sss paramsss, sst paramsst) {}
  
  public void a(@NonNull tgf paramtgf, @Nullable tgg paramtgg, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtgg == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramtgg.b == 1)
    {
      this.jdField_a_of_type_Tfz.a(true);
      this.jdField_a_of_type_Sss.b(2);
      this.jdField_a_of_type_Tfz.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramtgg.b);
    }
    this.jdField_a_of_type_Sst.a(paramtgg.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tga
 * JD-Core Version:    0.7.0.1
 */