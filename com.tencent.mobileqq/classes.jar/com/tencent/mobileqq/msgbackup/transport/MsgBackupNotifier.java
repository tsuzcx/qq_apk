package com.tencent.mobileqq.msgbackup.transport;

import android.os.Looper;
import android.util.Log;
import awqk;
import awql;
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
      paramString = awql.a().a(paramString);
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
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onHttpRequest ip = " + paramString1 + ", port = " + paramInt + ", url = " + paramString2);
    }
    awqk.a().a(new MsgBackupNotifier.12(this, paramLong, paramString1, paramInt, paramString2));
  }
  
  public void onRecvComplete(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onRecvComplete fid = " + paramLong1 + ", url = " + paramString1 + ", errCode = " + paramInt1 + ", path = " + paramString2 + ", speedByteIn = " + paramInt2 + ", speedByteOut = " + paramInt3);
    }
    awqk.a().a(new MsgBackupNotifier.11(this, paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2));
  }
  
  public void onRecvMessage(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onRecvMessage ip = " + paramString1 + ", port = " + paramInt1 + ", cmd = " + paramInt2 + ", data = " + paramString2 + ", cookie = " + paramLong);
    }
    awqk.a().a(new MsgBackupNotifier.8(this, paramString1, paramInt1, paramInt2, paramString2, paramLong));
  }
  
  public void onRecvProgress(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onRecvProgress fid = " + paramLong1 + ", url = " + paramString + ", uPos = " + paramLong2 + ", totalLen = " + paramLong3 + ", speed = " + paramInt1 + ", incrementLen = " + paramLong4 + ", speedByteIn = " + paramInt2 + ", speedByteOut = " + paramInt3);
    }
    awqk.a().a(new MsgBackupNotifier.10(this, paramLong1, paramLong3, paramLong4));
  }
  
  public void onRecvStart(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onRecvStart fid = " + paramLong1 + ", url = " + paramString + ", dwResume = " + paramLong2 + ", totalLen = " + paramLong3 + ", context = " + paramLong4);
    }
    awqk.a().a(new MsgBackupNotifier.9(this, paramLong1, paramString, paramLong2, paramLong3, paramLong4));
  }
  
  public void onSendComplete(long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onSendComplete fid = " + paramLong1 + ", success = " + paramBoolean + ", errCode = " + paramInt1 + ", speedByteIn = " + paramInt2 + ", speedByteOut = " + paramInt3 + ", context = " + paramLong2);
    }
    awqk.a().a(new MsgBackupNotifier.14(this, paramLong1, paramBoolean, paramInt1, paramString, paramInt2, paramInt3, paramLong2));
  }
  
  public void onSendMessage(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onSendMessage success = " + paramBoolean + ". cookie = " + paramLong1 + ", context = " + paramLong2);
    }
    awqk.a().a(new MsgBackupNotifier.7(this, paramBoolean, paramLong1, paramLong2));
  }
  
  public void onSendProgress(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onSendProgress fid = " + paramLong1 + ", path = " + paramString + ", uPos = " + paramLong2 + ", totalLen = " + paramLong3 + ", speed = " + paramInt1 + ", incrementLen = " + paramLong4 + ", speedByteIn = " + paramInt2 + ", speedByteOut = " + paramInt3);
    }
    awqk.a().a(new MsgBackupNotifier.13(this, paramLong1, paramString, paramLong2, paramLong3, paramInt1, paramLong4, paramInt2, paramInt3, paramLong5));
  }
  
  public void onServoPortChanged(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onServoPortChanged ip = " + paramString + ", port = " + paramInt);
    }
    awqk.a().a(new MsgBackupNotifier.5(this, paramString, paramInt));
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
      awqk.a().a(new MsgBackupNotifier.6(this, paramInt));
      return;
    }
  }
  
  public void onUdpDetected(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onUdpDetected success = " + paramBoolean);
    }
    awqk.a().a(new MsgBackupNotifier.1(this, paramBoolean));
  }
  
  public void onUdpPortChanged(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onUdpPortChanged ip = " + paramString + ", port = " + paramInt);
    }
    awqk.a().a(new MsgBackupNotifier.2(this, paramString, paramInt));
  }
  
  public void onVersoBind(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onVersoBind ip = " + paramString + ", port = " + paramInt);
    }
    awqk.a().a(new MsgBackupNotifier.3(this, paramString, paramInt));
  }
  
  public void onVersoPortChanged(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      Log.d("MsgBackup-Notifier", "onVersoPortChanged ip = " + paramString + ", port = " + paramInt);
    }
    awqk.a().a(new MsgBackupNotifier.4(this, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier
 * JD-Core Version:    0.7.0.1
 */