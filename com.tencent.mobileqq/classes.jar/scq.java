import com.tencent.qphone.base.util.QLog;

public class scq
  extends akdn
{
  scl jdField_a_of_type_Scl = null;
  
  public scq(sck paramsck, scl paramscl)
  {
    this.jdField_a_of_type_Scl = paramscl;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Scl);
    }
    if (this.jdField_a_of_type_Scl != null)
    {
      paramString = this.jdField_a_of_type_Scl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     scq
 * JD-Core Version:    0.7.0.1
 */