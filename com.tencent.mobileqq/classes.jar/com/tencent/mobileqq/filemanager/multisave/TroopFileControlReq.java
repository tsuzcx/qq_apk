package com.tencent.mobileqq.filemanager.multisave;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;

public class TroopFileControlReq
  extends QFileControlReq
{
  private String a;
  private int b;
  private String c;
  
  public TroopFileControlReq(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.a = paramTroopFileStatusInfo.r;
    this.b = 1;
    this.c = String.valueOf(paramTroopFileStatusInfo.d);
  }
  
  public String a()
  {
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.c)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("");
      return a(localStringBuilder.toString(), this.c, this.a);
    }
    QLog.e("TroopFileControlReq<QFile>", 1, "key params is null");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.TroopFileControlReq
 * JD-Core Version:    0.7.0.1
 */