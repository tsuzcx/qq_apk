import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.qphone.base.util.QLog;

public final class mca
  implements UserOperationModule.Ox978RespCallBack
{
  public mca(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsHelper", 2, "followPubAccount() onFollowPublicAccount uin=" + this.jdField_a_of_type_JavaLangString + ", isSuccess=" + paramBoolean + ", isUGC=" + this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mca
 * JD-Core Version:    0.7.0.1
 */