package com.tencent.qcircle.oscar.app;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.ttpic.baseutils.io.FileUtils;

public class PAGSOLoadUtil
{
  public static final String TAG = "PAGSOLoadUtil";
  private static boolean success = false;
  
  public static boolean loadSoSync(@NonNull String paramString)
  {
    boolean bool = success;
    if (!bool)
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
    }
    try
    {
      System.load(paramString);
      success = true;
      String str1 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("load ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
      localStringBuilder.append(success);
      Logger.d(str1, localStringBuilder.toString());
      return success;
    }
    catch (Exception localException)
    {
      success = false;
      Logger.e(TAG, localException.getMessage());
      String str2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("load ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
      localStringBuilder.append(success);
      Logger.d(str2, localStringBuilder.toString());
      return success;
    }
    catch (RuntimeException localRuntimeException)
    {
      success = false;
      Logger.e(TAG, localRuntimeException.getMessage());
      String str3 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("load ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
      localStringBuilder.append(success);
      Logger.d(str3, localStringBuilder.toString());
      return success;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      success = false;
      Logger.e(TAG, localUnsatisfiedLinkError.getMessage());
      String str4 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
      localStringBuilder.append(success);
      Logger.d(str4, localStringBuilder.toString());
      return success;
      label315:
      str4 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("load ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
      localStringBuilder.append(success);
      Logger.d(str4, localStringBuilder.toString());
      return success;
      return bool;
    }
    finally
    {
      break label315;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.oscar.app.PAGSOLoadUtil
 * JD-Core Version:    0.7.0.1
 */