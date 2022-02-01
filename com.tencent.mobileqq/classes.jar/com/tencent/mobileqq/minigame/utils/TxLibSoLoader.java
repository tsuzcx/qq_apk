package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class TxLibSoLoader
{
  public static final String LOG_TAG = "TxLibSoLoader";
  
  public static boolean loadSo(String paramString)
  {
    try
    {
      int i = VcSystemInfo.getCpuArchitecture();
      if (i > 2)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("/txlib/lib");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append("-v7a.so");
        paramString = localStringBuilder1.toString();
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("/txlib/lib");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append("-armeabi.so");
        paramString = localStringBuilder1.toString();
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(BaseApplicationImpl.getContext().getFilesDir().getParent());
      localStringBuilder1.append(paramString);
      paramString = localStringBuilder1.toString();
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[MiniEng]loadLibrary ");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append(" failed, file not exists!");
        QLog.i("TxLibSoLoader", 1, localStringBuilder1.toString());
        return false;
      }
      try
      {
        System.load(paramString);
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[MiniEng]loadLibrary ");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append(" success ");
        QLog.i("TxLibSoLoader", 1, localStringBuilder1.toString());
        return true;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("[MiniEng]loadTxLibSo error ");
        localStringBuilder3.append(paramString);
        localStringBuilder3.append(DebugUtil.getPrintableStackTrace(localThrowable));
        QLog.w("TxLibSoLoader", 1, localStringBuilder3.toString());
        return false;
      }
      StringBuilder localStringBuilder2;
      return false;
    }
    catch (Exception paramString)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[MiniEng]loadTxLibSo exception ");
      localStringBuilder2.append(DebugUtil.getPrintableStackTrace(paramString));
      QLog.w("TxLibSoLoader", 1, localStringBuilder2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.TxLibSoLoader
 * JD-Core Version:    0.7.0.1
 */