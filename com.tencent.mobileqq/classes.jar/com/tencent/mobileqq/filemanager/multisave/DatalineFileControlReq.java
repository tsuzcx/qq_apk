package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;

public class DatalineFileControlReq
  extends QFileControlReq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public DatalineFileControlReq(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord != null)
    {
      this.jdField_a_of_type_Long = paramDataLineMsgRecord.sessionid;
    }
    else
    {
      QLog.i("DatalineFileControlReq", 1, "init: dataline file data is null");
      this.jdField_a_of_type_Long = 0L;
    }
    this.jdField_a_of_type_Int = 6000;
    this.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      QLog.e("DatalineFileControlReq", 1, "key params is null");
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    return a((String)localObject, str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.DatalineFileControlReq
 * JD-Core Version:    0.7.0.1
 */