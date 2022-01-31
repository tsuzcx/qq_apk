import com.tencent.qphone.base.util.QLog;

final class qom
  implements pbx
{
  qom(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsHelper", 2, "followPubAccount() onFollowPublicAccount uin=" + this.jdField_a_of_type_JavaLangString + ", isSuccess=" + paramBoolean + ", isUGC=" + this.jdField_a_of_type_Boolean + ", data=" + paramInt);
    }
    qoi.a(paramBoolean, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qom
 * JD-Core Version:    0.7.0.1
 */