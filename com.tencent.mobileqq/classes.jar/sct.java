import com.tencent.qphone.base.util.QLog;

public class sct
  extends akdo
{
  sco jdField_a_of_type_Sco = null;
  
  public sct(scn paramscn, sco paramsco)
  {
    this.jdField_a_of_type_Sco = paramsco;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Sco);
    }
    if (this.jdField_a_of_type_Sco != null)
    {
      paramString = this.jdField_a_of_type_Sco;
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
 * Qualified Name:     sct
 * JD-Core Version:    0.7.0.1
 */