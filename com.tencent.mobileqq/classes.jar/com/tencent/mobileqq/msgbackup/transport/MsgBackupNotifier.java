package com.tencent.mobileqq.msgbackup.transport;

import android.os.Looper;
import android.util.Log;
import asnw;
import asnx;
import asog;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class MsgBackupNotifier
{
  private static final String TAG = "MsgBackup-Notifier";
  
  public void OnLog(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new String(paramArrayOfByte1, "UTF-8");
      paramArrayOfByte2 = new String(paramArrayOfByte2, "UTF-8");
      if (QLog.isColorLevel()) {
        Log.d("MsgBackup-native-" + paramArrayOfByte1, paramArrayOfByte2);
      }
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1)
    {
      Log.e("MsgBackup-native", "native log encoding utf8 failed", paramArrayOfByte1);
    }
  }
  
  public String getFilePathFromURL(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Notifier", 2, "java getFilePathFromURL is called! url = " + paramString);
    }
    try
    {
      paramString = asnx.a().a(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("MsgBackup-Notifier", 1, "getFilePathFromURL is error!", paramString);
    }
    return "";
  }
  
  public void onHttpRequest(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onHttpRequest ipFrom = " + asog.a(paramInt1) + ", port = " + paramInt2 + ", url = " + paramString);
    }
    asnw.a().a(new MsgBackupNotifier.12(this, paramLong, paramInt1, paramInt2, paramString));
  }
  
  public void onRecvComplete(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onRecvComplete fid = " + paramLong1 + ", url = " + paramString1 + ", errCode = " + paramInt1 + ", path = " + paramString2 + ", speedByteIn = " + paramInt2 + ", speedByteOut = " + paramInt3);
    }
    asnw.a().a(new MsgBackupNotifier.11(this, paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2));
  }
  
  public void onRecvMessage(int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onRecvMessage ipFrom = " + paramInt1 + ", port = " + paramInt2 + ", cmd = " + paramInt3 + ", data = " + paramString + ", cookie = " + paramLong);
    }
    asnw.a().a(new MsgBackupNotifier.8(this, paramInt1, paramInt2, paramInt3, paramString, paramLong));
  }
  
  public void onRecvProgress(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onRecvProgress fid = " + paramLong1 + ", url = " + paramString + ", uPos = " + paramLong2 + ", totalLen = " + paramLong3 + ", speed = " + paramInt1 + ", incrementLen = " + paramLong4 + ", speedByteIn = " + paramInt2 + ", speedByteOut = " + paramInt3);
    }
    asnw.a().a(new MsgBackupNotifier.10(this, paramLong1, paramLong3, paramLong4));
  }
  
  public void onRecvStart(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onRecvStart fid = " + paramLong1 + ", url = " + paramString + ", dwResume = " + paramLong2 + ", totalLen = " + paramLong3 + ", context = " + paramLong4);
    }
    asnw.a().a(new MsgBackupNotifier.9(this, paramLong1, paramString, paramLong2, paramLong3, paramLong4));
  }
  
  public void onSendComplete(long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onSendComplete fid = " + paramLong1 + ", success = " + paramBoolean + ", errCode = " + paramInt1 + ", speedByteIn = " + paramInt2 + ", speedByteOut = " + paramInt3 + ", context = " + paramLong2);
    }
    asnw.a().a(new MsgBackupNotifier.14(this, paramLong1, paramBoolean, paramInt1, paramString, paramInt2, paramInt3, paramLong2));
  }
  
  public void onSendMessage(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onSendMessage success = " + paramBoolean + ". cookie = " + paramLong1 + ", context = " + paramLong2);
    }
    asnw.a().a(new MsgBackupNotifier.7(this, paramBoolean, paramLong1, paramLong2));
  }
  
  public void onSendProgress(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onSendProgress fid = " + paramLong1 + ", path = " + paramString + ", uPos = " + paramLong2 + ", totalLen = " + paramLong3 + ", speed = " + paramInt1 + ", incrementLen = " + paramLong4 + ", speedByteIn = " + paramInt2 + ", speedByteOut = " + paramInt3);
    }
    asnw.a().a(new MsgBackupNotifier.13(this, paramLong1, paramString, paramLong2, paramLong3, paramInt1, paramLong4, paramInt2, paramInt3, paramLong5));
  }
  
  public void onServoPortChanged(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onServoPortChanged ipV4 = " + asog.a(paramInt1) + ", port = " + paramInt2);
    }
    asnw.a().a(new MsgBackupNotifier.5(this, paramInt1, paramInt2));
  }
  
  public void onTcpConnStateChanged(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onTcpConnStateChanged state = ").append(paramInt).append(", isMain = ");
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MsgBackup-Notifier", bool);
      asnw.a().a(new MsgBackupNotifier.6(this, paramInt));
      return;
    }
  }
  
  public void onUdpDetected(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onUdpDetected success = " + paramBoolean);
    }
    asnw.a().a(new MsgBackupNotifier.1(this, paramBoolean));
  }
  
  public void onUdpPortChanged(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onUdpPortChanged ipV4 = " + asog.a(paramInt1) + ", port = " + paramInt2);
    }
    asnw.a().a(new MsgBackupNotifier.2(this, paramInt1, paramInt2));
  }
  
  public void onVersoBind(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onVersoBind ipV4 = " + asog.a(paramInt1) + ", port = " + paramInt2);
    }
    asnw.a().a(new MsgBackupNotifier.3(this, paramInt1, paramInt2));
  }
  
  public void onVersoPortChanged(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onVersoPortChanged ipV4 = " + asog.a(paramInt1) + ", port = " + paramInt2);
    }
    asnw.a().a(new MsgBackupNotifier.4(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier
 * JD-Core Version:    0.7.0.1
 */