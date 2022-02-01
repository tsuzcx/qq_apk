package com.tencent.mobileqq.msgbackup.transport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReportData;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

public class MsgBackupJniProxy
{
  public MsgBackupJniProxy(Context paramContext)
  {
    int i;
    try
    {
      i = Build.VERSION.SDK_INT;
      if (i >= 24) {
        a(paramContext, "c++_shared", "/lib/");
      } else {
        SoLoadUtil.a(paramContext, "c++_shared", 0, false);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      localUnsatisfiedLinkError1.printStackTrace();
    }
    try
    {
      i = Build.VERSION.SDK_INT;
      if (i >= 24) {
        a(paramContext, "xplatform", "/txlib/");
      } else {
        SoLoadUtil.a(paramContext, "xplatform", 0, false);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      localUnsatisfiedLinkError2.printStackTrace();
    }
    try
    {
      SoLoadUtilNew.loadSoByName(paramContext, "msgbackup");
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      QLog.e("MsgBackup-Proxy", 1, paramContext, new Object[0]);
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start load native library. ");
          ((StringBuilder)localObject).append(paramString1);
          QLog.d("MsgBackup-Proxy", 2, ((StringBuilder)localObject).toString());
        }
        long l1 = SystemClock.uptimeMillis();
        String str1 = "";
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lib");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(".so");
        String str2 = ((StringBuilder)localObject).toString();
        if (paramContext == null)
        {
          localObject = BaseApplication.getContext();
          paramContext = new StringBuilder();
          paramContext.append(((Context)localObject).getFilesDir().getParent());
          paramContext.append(paramString2);
          paramString2 = paramContext.toString();
          bool1 = true;
          QLog.i("MsgBackup-Proxy", 1, "try to load lib so");
          paramContext = new StringBuilder();
          paramContext.append(paramString2);
          paramContext.append(str2);
          File localFile = new File(paramContext.toString());
          paramContext = new StringBuilder();
          paramContext.append("key_so_crc");
          paramContext.append(paramString1);
          String str3 = paramContext.toString();
          SharedPreferences localSharedPreferences = ((Context)localObject).getSharedPreferences("so_sp", 0);
          if ((SoLoadUtil.a((Context)localObject, paramString1)) && (localFile.exists())) {
            localFile.delete();
          }
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup-Proxy", 2, "start to decode so, decode with 7z : ");
          }
          paramContext = str1;
          if (!localFile.exists())
          {
            int i = SoLoadUtil.a((Context)localObject, paramString2, "txlib", str2);
            paramContext = new StringBuilder();
            paramContext.append("uncompress so result: ");
            paramContext.append(i);
            QLog.i("MsgBackup-Proxy", 1, paramContext.toString());
            if (i != 0)
            {
              localFile.delete();
              paramContext = new StringBuilder();
              paramContext.append("");
              paramContext.append("copy asset so fail. file size not match");
              paramContext = paramContext.toString();
              QLog.e("MsgBackup-Proxy", 1, paramContext);
            }
            else
            {
              l2 = IOUtil.getCRC32Value(localFile);
              localSharedPreferences.edit().putLong(str3, l2).commit();
              paramContext = str1;
            }
          }
          paramString2 = paramContext;
          QLog.i("MsgBackup-Proxy", 1, "load txlib so");
          boolean bool2 = localFile.exists();
          paramContext = paramString2;
          if (!bool2) {
            break label781;
          }
          try
          {
            System.load(localFile.getAbsolutePath());
            paramContext = paramString2;
          }
          catch (UnsatisfiedLinkError paramContext)
          {
            l2 = IOUtil.getCRC32Value(localFile);
            long l3 = localSharedPreferences.getLong(str3, -1L);
            if ((l2 != -1L) && (l2 != l3))
            {
              localFile.delete();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString2);
              ((StringBuilder)localObject).append("load asset so fail, crc not match.");
              ((StringBuilder)localObject).append(l2);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append(l3);
              ((StringBuilder)localObject).append(" path:");
              ((StringBuilder)localObject).append(localFile);
              ((StringBuilder)localObject).append(", exception info : ");
              ((StringBuilder)localObject).append(QLog.getStackTraceString(paramContext));
              paramContext = ((StringBuilder)localObject).toString();
              QLog.e("MsgBackup-Proxy", 1, paramContext);
              break label781;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString2);
            ((StringBuilder)localObject).append("load asset so fail. path:");
            ((StringBuilder)localObject).append(localFile);
            ((StringBuilder)localObject).append(", exception info : ");
            ((StringBuilder)localObject).append(QLog.getStackTraceString(paramContext));
            paramContext = ((StringBuilder)localObject).toString();
            QLog.e("MsgBackup-Proxy", 1, paramContext);
            break label781;
          }
          bool2 = bool1;
          if (!bool1)
          {
            QLog.i("MsgBackup-Proxy", 1, "finally try to use system way to load so");
            try
            {
              System.loadLibrary(paramString1);
              bool2 = true;
            }
            catch (UnsatisfiedLinkError paramString2)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramContext);
              ((StringBuilder)localObject).append("load system way failed, exception info : ");
              ((StringBuilder)localObject).append(QLog.getStackTraceString(paramString2));
              QLog.e("MsgBackup-Proxy", 1, ((StringBuilder)localObject).toString());
              bool2 = bool1;
            }
          }
          long l2 = SystemClock.uptimeMillis();
          paramContext = new StringBuilder();
          paramContext.append("load so ");
          paramContext.append(paramString1);
          paramContext.append(" cost time: ");
          paramContext.append(l2 - l1);
          QLog.i("MsgBackup-Proxy", 1, paramContext.toString());
          return bool2;
        }
      }
      finally {}
      Object localObject = paramContext;
      continue;
      label781:
      boolean bool1 = false;
    }
  }
  
  public static native byte[] decryptFromByteArray(byte[] paramArrayOfByte, String paramString);
  
  public static native String decryptFromString(String paramString1, String paramString2);
  
  public static native byte[] encryptFromByteArray(byte[] paramArrayOfByte, String paramString);
  
  public static native String encryptFromString(String paramString1, String paramString2);
  
  public void a(long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    sendMessage(paramLong1, paramInt, paramString, paramLong2, 0L);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendFile path = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", fid = ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(", sessionId = ");
      localStringBuilder.append(paramLong2);
      QLog.d("MsgBackup-Proxy", 2, localStringBuilder.toString());
    }
    sendFile(paramLong1, paramLong2, paramLong3, paramString, 0L);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("received from Buffer url = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", fid = ");
      localStringBuilder.append(paramLong2);
      QLog.d("MsgBackup-Proxy", 2, localStringBuilder.toString());
    }
    recvToBuffer(paramLong1, paramLong2, paramString, 0L);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("received File url = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", fid = ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", path = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", trivial = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", isResTask = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("MsgBackup-Proxy", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      MsgBackupReporter.a();
      MsgBackupManager.a().l.add(Long.valueOf(paramLong2));
      localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).o += 1L;
    }
    recvFile(paramLong1, paramLong2, paramString1, paramString2, paramBoolean1, paramLong3, 0L);
  }
  
  public void a(long paramLong, String paramString)
  {
    setEncryptKey(paramLong, paramString, MsgBackupUtil.b);
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendBuffer buffer = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", fid = ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(", sessionId = ");
      localStringBuilder.append(paramLong2);
      QLog.d("MsgBackup-Proxy", 2, localStringBuilder.toString());
    }
    sendBuffer(paramLong1, paramLong2, paramLong3, paramString, 0L);
  }
  
  public native void cancelAllRecvTasks(long paramLong);
  
  public native void cancelAllSendTasks(long paramLong);
  
  public native int cancelRecvFile(long paramLong1, long paramLong2);
  
  public native int cancelSendFile(long paramLong1, long paramLong2, long paramLong3);
  
  public native long createSession(int paramInt1, long paramLong, int paramInt2, MsgBackupNotifier paramMsgBackupNotifier);
  
  public native void destroySession(long paramLong);
  
  public native byte[] getRecvBuffer(long paramLong1, long paramLong2);
  
  public native int getVersoEndpoint(long paramLong, MsgBackupEndPoint6 paramMsgBackupEndPoint6);
  
  public native int queryReachability(long paramLong, MsgBackupNetState paramMsgBackupNetState);
  
  public native void recvFile(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean, long paramLong3, long paramLong4);
  
  public native void recvToBuffer(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  public native void refuseFileRequest(long paramLong1, long paramLong2, long paramLong3, String paramString);
  
  public native void sendBuffer(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4);
  
  public native void sendFile(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4);
  
  public native void sendMessage(long paramLong1, int paramInt, String paramString, long paramLong2, long paramLong3);
  
  public native void setEncryptKey(long paramLong, String paramString, boolean paramBoolean);
  
  public native void setPeerEndpoint(long paramLong, String[] paramArrayOfString, int paramInt1, int paramInt2);
  
  public native int start(long paramLong, String[] paramArrayOfString, Integer paramInteger1, Integer paramInteger2);
  
  public native void stop(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy
 * JD-Core Version:    0.7.0.1
 */