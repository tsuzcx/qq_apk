package com.tencent.mobileqq.filemanager.util;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class QQFileManagerUtilImpl$14
  implements IForwardCallBack
{
  QQFileManagerUtilImpl$14(BaseQQAppInterface paramBaseQQAppInterface, int paramInt) {}
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramString5, paramLong, paramInt3, 0L, 0);
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong1, int paramInt3, long paramLong2, int paramInt4)
  {
    return QQFileManagerUtilImpl.a(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramString5, paramLong1, paramInt3, this.a, this.b);
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt3)
  {
    return null;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDatalineProcessCallBack->onResult bSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("],nSessionId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("],retCode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("],retMsg[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("],uuid[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("],troopUin[");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("],strNewPath[");
      localStringBuilder.append(paramString4);
      localStringBuilder.append("]");
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (TextUtils.isEmpty(paramString1)) {
        FMToastUtil.c(BaseApplication.getContext().getString(2131889582));
      } else {
        FMToastUtil.c(paramString1);
      }
      paramBoolean = false;
    }
    QQFileManagerUtilImpl.a(paramBoolean, paramLong, paramInt, paramString4, this.a);
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.14
 * JD-Core Version:    0.7.0.1
 */