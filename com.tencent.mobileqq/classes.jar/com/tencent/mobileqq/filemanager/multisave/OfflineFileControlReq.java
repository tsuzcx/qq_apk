package com.tencent.mobileqq.filemanager.multisave;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class OfflineFileControlReq
  extends QFileControlReq
{
  private long a;
  private int b;
  private String c;
  
  public OfflineFileControlReq(FileManagerEntity paramFileManagerEntity)
  {
    this.a = paramFileManagerEntity.nSessionId;
    this.b = paramFileManagerEntity.peerType;
    this.c = paramFileManagerEntity.peerUin;
  }
  
  public String a()
  {
    if ((this.a != 0L) && (!TextUtils.isEmpty(this.c)))
    {
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
    QLog.e("OfflineFileControlReq<QFile>", 1, "key params is null");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.OfflineFileControlReq
 * JD-Core Version:    0.7.0.1
 */