import com.tencent.qphone.base.util.QLog;

public class suj
  extends alzr
{
  sue jdField_a_of_type_Sue = null;
  
  public suj(sud paramsud, sue paramsue)
  {
    this.jdField_a_of_type_Sue = paramsue;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Sue);
    }
    if (this.jdField_a_of_type_Sue != null)
    {
      paramString = this.jdField_a_of_type_Sue;
      if (!paramBoolean) {
        break label76;
      }
    }
    label76:
    for (int i = 1;; i = 0)
    {
      paramString.a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     suj
 * JD-Core Version:    0.7.0.1
 */