package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class ExcitingTransferNativeCallMe
{
  public static boolean getConfigFromServer()
  {
    return ((IExcitingTransferAdapter)QQFileManagerUtil.a().getRuntimeService(IExcitingTransferAdapter.class, "")).getConfigFromServer();
  }
  
  public static long getFreeSpaceForFile(String paramString)
  {
    long l;
    if (SystemUtil.a()) {
      l = SystemUtil.a();
    } else {
      l = SystemUtil.b();
    }
    return l * 1024L;
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
    return ((IExcitingTransferAdapter)QQFileManagerUtil.a().getRuntimeService(IExcitingTransferAdapter.class, "")).getSelfUin();
  }
  
  public static String getVersion()
  {
    return AppSetting.g();
  }
  
  public static void onLog(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      String str = new String(paramArrayOfByte1, "UTF-8");
      paramArrayOfByte2 = new String(paramArrayOfByte2, "UTF-8");
      paramArrayOfByte1 = str;
      if (TextUtils.isEmpty(str)) {
        paramArrayOfByte1 = "unTag";
      }
      if ((paramInt != 0) && (paramInt != 1))
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (QLog.isColorLevel()) {
                QLog.d(paramArrayOfByte1, 2, paramArrayOfByte2);
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d(paramArrayOfByte1, 2, paramArrayOfByte2);
            }
          }
          else if (QLog.isColorLevel()) {
            QLog.i(paramArrayOfByte1, 2, paramArrayOfByte2);
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.w(paramArrayOfByte1, 2, paramArrayOfByte2);
        }
      }
      else {
        QLog.i(paramArrayOfByte1, 1, paramArrayOfByte2);
      }
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.e("ExcitingT.", 4, "native log encoding utf8 failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferNativeCallMe
 * JD-Core Version:    0.7.0.1
 */