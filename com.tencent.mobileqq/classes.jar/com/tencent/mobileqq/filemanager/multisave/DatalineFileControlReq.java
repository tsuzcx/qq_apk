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
    if (paramDataLineMsgRecord != null) {}
    for (this.jdField_a_of_type_Long = paramDataLineMsgRecord.sessionid;; this.jdField_a_of_type_Long = 0L)
    {
      this.jdField_a_of_type_Int = 6000;
      this.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
      return;
      QLog.i("DatalineFileControlReq", 1, "init: dataline file data is null");
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      QLog.e("DatalineFileControlReq", 1, "key params is null");
      return "";
    }
    return a(this.jdField_a_of_type_Int + "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.DatalineFileControlReq
 * JD-Core Version:    0.7.0.1
 */