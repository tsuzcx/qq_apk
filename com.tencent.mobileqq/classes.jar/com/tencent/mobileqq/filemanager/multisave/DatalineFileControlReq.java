package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;

public class DatalineFileControlReq
  extends QFileControlReq
{
  private long a;
  private int b;
  private String c;
  
  public DatalineFileControlReq(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord != null)
    {
      this.a = paramDataLineMsgRecord.sessionid;
    }
    else
    {
      QLog.i("DatalineFileControlReq", 1, "init: dataline file data is null");
      this.a = 0L;
    }
    this.b = 6000;
    this.c = AppConstants.DATALINE_PC_UIN;
  }
  
  public String a()
  {
    if (this.a == 0L)
    {
      QLog.e("DatalineFileControlReq", 1, "key params is null");
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    return a((String)localObject, str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.DatalineFileControlReq
 * JD-Core Version:    0.7.0.1
 */