import com.tencent.qphone.base.util.QLog;

public class rqb
  extends ajpe
{
  rpw jdField_a_of_type_Rpw = null;
  
  public rqb(rpv paramrpv, rpw paramrpw)
  {
    this.jdField_a_of_type_Rpw = paramrpw;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Rpw);
    }
    if (this.jdField_a_of_type_Rpw != null)
    {
      paramString = this.jdField_a_of_type_Rpw;
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
 * Qualified Name:     rqb
 * JD-Core Version:    0.7.0.1
 */