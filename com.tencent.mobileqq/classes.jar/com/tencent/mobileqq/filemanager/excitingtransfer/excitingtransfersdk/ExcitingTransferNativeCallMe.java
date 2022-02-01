package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.text.TextUtils;
import atrv;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class ExcitingTransferNativeCallMe
{
  public static boolean getConfigFromServer()
  {
    return atrv.a().e();
  }
  
  public static long getFreeSpaceForFile(String paramString)
  {
    if (SystemUtil.isExistSDCard()) {
      return SystemUtil.getSDCardAvailableSize() * 1024L;
    }
    return SystemUtil.getSystemAvailableSize() * 1024L;
  }
  
  public static long getLastModifyTime(String paramString)
  {
    return new File(paramString).lastModified();
  }
  
  public static short getProxyType()
  {
    return 0;
  }
  
  public static long getPubNo()
  {
    return AppSetting.a();
  }
  
  public static long getRegulatedMilliTime()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public static long getSelfUin()
  {
    return atrv.a().e();
  }
  
  public static String getVersion()
  {
    return AppSetting.g();
  }
  
  public static void onLog(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    do
    {
      do
      {
        do
        {
          try
          {
            String str = new String(paramArrayOfByte1, "UTF-8");
            paramArrayOfByte2 = new String(paramArrayOfByte2, "UTF-8");
            paramArrayOfByte1 = str;
            if (TextUtils.isEmpty(str)) {
              paramArrayOfByte1 = "unTag";
            }
            switch (paramInt)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.d(paramArrayOfByte1, 2, paramArrayOfByte2);
              }
              return;
            }
          }
          catch (UnsupportedEncodingException paramArrayOfByte1)
          {
            do
            {
              paramArrayOfByte1.printStackTrace();
            } while (!QLog.isDevelopLevel());
            QLog.e("ExcitingT.", 4, "native log encoding utf8 failed");
            return;
          }
          QLog.i(paramArrayOfByte1, 1, paramArrayOfByte2);
          return;
        } while (!QLog.isColorLevel());
        QLog.w(paramArrayOfByte1, 2, paramArrayOfByte2);
        return;
      } while (!QLog.isColorLevel());
      QLog.i(paramArrayOfByte1, 2, paramArrayOfByte2);
      return;
    } while (!QLog.isColorLevel());
    QLog.d(paramArrayOfByte1, 2, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferNativeCallMe
 * JD-Core Version:    0.7.0.1
 */