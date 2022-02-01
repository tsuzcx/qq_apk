package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lld;

public class TxLibSoLoader
{
  public static final String LOG_TAG = "TxLibSoLoader";
  
  public static boolean loadSo(String paramString)
  {
    try
    {
      if (lld.f() > 2) {}
      for (paramString = "/txlib/lib" + paramString + "-v7a.so";; paramString = "/txlib/lib" + paramString + "-armeabi.so")
      {
        paramString = BaseApplicationImpl.getContext().getFilesDir().getParent() + paramString;
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
        QLog.i("TxLibSoLoader", 1, "[MiniEng]loadLibrary " + paramString + " failed, file not exists!");
        return false;
      }
      try
      {
        System.load(paramString);
        QLog.i("TxLibSoLoader", 1, "[MiniEng]loadLibrary " + paramString + " success ");
        return true;
      }
      catch (Throwable localThrowable)
      {
        QLog.w("TxLibSoLoader", 1, "[MiniEng]loadTxLibSo error " + paramString + DebugUtil.getPrintableStackTrace(localThrowable));
        return false;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.w("TxLibSoLoader", 1, "[MiniEng]loadTxLibSo exception " + DebugUtil.getPrintableStackTrace(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.TxLibSoLoader
 * JD-Core Version:    0.7.0.1
 */