package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ReadInJoyDeliverUGCActivity$UploadImage
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInJoyDeliverUGCActivity$UploadImage(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public UploadImage a()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity;
      ((ReadInJoyDeliverUGCActivity)localObject).e = true;
      ((ReadInJoyDeliverUGCActivity)localObject).l();
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity;
      ((ReadInJoyDeliverUGCActivity)localObject).a(1, ((ReadInJoyDeliverUGCActivity)localObject).getString(2131717876));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity.i();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUploadPic file not exist, path=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Long = ((File)localObject).length();
    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).c(this.jdField_a_of_type_Int, NetConnInfoCenter.getServerTimeMillis());
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.UploadImage
 * JD-Core Version:    0.7.0.1
 */