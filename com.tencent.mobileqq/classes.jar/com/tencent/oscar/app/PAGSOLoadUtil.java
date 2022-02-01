package com.tencent.oscar.app;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.ttpic.baseutils.io.FileUtils;

public class PAGSOLoadUtil
{
  public static final String TAG = PAGSOLoadUtil.class.getSimpleName();
  private static boolean success = false;
  
  public static boolean loadSoSync(@NonNull String paramString)
  {
    if (!success)
    {
      if (TextUtils.isEmpty(paramString))
      {
        success = false;
        Logger.e(TAG, "load so path is empty.");
        return success;
      }
      if (!FileUtils.exists(paramString))
      {
        success = false;
        Logger.e(TAG, "load so file is not existed.");
        return success;
      }
      try
      {
        System.load(paramString);
        success = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        success = false;
        Logger.e(TAG, localUnsatisfiedLinkError.getMessage());
      }
      catch (RuntimeException localRuntimeException)
      {
        success = false;
        Logger.e(TAG, localRuntimeException.getMessage());
      }
      catch (Exception localException)
      {
        success = false;
        Logger.e(TAG, localException.getMessage());
      }
      finally
      {
        Logger.d(TAG, "load " + paramString + ": " + success);
        return success;
      }
    }
    return success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oscar.app.PAGSOLoadUtil
 * JD-Core Version:    0.7.0.1
 */