package com.tencent.mobileqq.msgbackup.transport;

import android.os.Looper;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class MsgBackupNotifier
{
  private static final String TAG = "MsgBackup-Notifier";
  
  public String getFilePathFromURL(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("java getFilePathFromURL is called! url = ");
      localStringBuilder.append(paramString);
      QLog.d("MsgBackup-Notifier", 2, localStringBuilder.toString());
    }
    try
    {
      paramString = MsgBackupTransportProcessor.a().e(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("MsgBackup-Notifier", 1, "getFilePathFromURL is error!", paramString);
    }
    return "";
  }
  
  public void onHttpRequest(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHttpRequest ip = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", port = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", url = ");
      localStringBuilder.append(paramString2);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.12(this, paramLong, paramString1, paramInt, paramString2));
  }
  
  public void onLog(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new String(paramArrayOfByte1, "UTF-8");
      paramArrayOfByte2 = new String(paramArrayOfByte2, "UTF-8");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MsgBackup-native-");
        localStringBuilder.append(paramArrayOfByte1);
        Log.d(localStringBuilder.toString(), paramArrayOfByte2);
      }
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1)
    {
      Log.e("MsgBackup-native", "native log encoding utf8 failed", paramArrayOfByte1);
    }
  }
  
  public void onRecvComplete(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvComplete fid = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", errCode = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", path = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", speedByteIn = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", speedByteOut = ");
      localStringBuilder.append(paramInt3);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.11(this, paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2));
  }
  
  public void onRecvMessage(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvMessage ip = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", port = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", cmd = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", data = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", cookie = ");
      localStringBuilder.append(paramLong);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.8(this, paramString1, paramInt1, paramInt2, paramString2, paramLong));
  }
  
  public void onRecvProgress(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvProgress fid = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", url = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", uPos = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", totalLen = ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(", speed = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", incrementLen = ");
      localStringBuilder.append(paramLong4);
      localStringBuilder.append(", speedByteIn = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", speedByteOut = ");
      localStringBuilder.append(paramInt3);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.10(this, paramLong1, paramLong3, paramLong4));
  }
  
  public void onRecvStart(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvStart fid = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", url = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", dwResume = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", totalLen = ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(", context = ");
      localStringBuilder.append(paramLong4);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.9(this, paramLong1, paramString, paramLong2, paramLong3, paramLong4));
  }
  
  public void onSendComplete(long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendComplete fid = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", success = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", errCode = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", speedByteIn = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", speedByteOut = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", context = ");
      localStringBuilder.append(paramLong2);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.14(this, paramLong1, paramBoolean, paramInt1, paramString, paramInt2, paramInt3, paramLong2));
  }
  
  public void onSendMessage(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendMessage success = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(". cookie = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", context = ");
      localStringBuilder.append(paramLong2);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.7(this, paramBoolean, paramLong1, paramLong2));
  }
  
  public void onSendProgress(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendProgress fid = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", path = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", uPos = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", totalLen = ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(", speed = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", incrementLen = ");
      localStringBuilder.append(paramLong4);
      localStringBuilder.append(", speedByteIn = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", speedByteOut = ");
      localStringBuilder.append(paramInt3);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.13(this, paramLong1, paramString, paramLong2, paramLong3, paramInt1, paramLong4, paramInt2, paramInt3, paramLong5));
  }
  
  public void onServoPortChanged(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServoPortChanged ip = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", port = ");
      localStringBuilder.append(paramInt);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.5(this, paramString, paramInt));
  }
  
  public void onTcpConnStateChanged(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTcpConnStateChanged state = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isMain = ");
      boolean bool;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.6(this, paramInt));
  }
  
  public void onUdpDetected(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUdpDetected success = ");
      localStringBuilder.append(paramBoolean);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.1(this, paramBoolean));
  }
  
  public void onUdpPortChanged(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUdpPortChanged ip = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", port = ");
      localStringBuilder.append(paramInt);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.2(this, paramString, paramInt));
  }
  
  public void onVersoBind(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVersoBind ip = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", port = ");
      localStringBuilder.append(paramInt);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.3(this, paramString, paramInt));
  }
  
  public void onVersoPortChanged(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVersoPortChanged ip = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", port = ");
      localStringBuilder.append(paramInt);
      Log.d("MsgBackup-Notifier", localStringBuilder.toString());
    }
    MsgBackupTransportExecutor.a().a(new MsgBackupNotifier.4(this, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier
 * JD-Core Version:    0.7.0.1
 */