package com.tencent.tav;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.decoder.logger.Logger;

public class ResourceLoadUtil
{
  public static final String TAG = "ResourceLoadUtil";
  private static boolean success = false;
  
  public static boolean isLoaded()
  {
    return success;
  }
  
  public static boolean loadSoSync(@NonNull String paramString)
  {
    boolean bool = success;
    if (!bool) {
      if (TextUtils.isEmpty(paramString))
      {
        success = false;
        Logger.e(TAG, "load so path is empty.");
        return success;
      }
    }
    try
    {
      System.load(paramString);
      success = true;
      String str1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("load ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(success);
      Logger.d(str1, ((StringBuilder)localObject2).toString());
      return success;
    }
    catch (Exception localException)
    {
      success = false;
      localObject2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSoSync: load soPath = ");
      localStringBuilder.append(paramString);
      Logger.e((String)localObject2, localStringBuilder.toString(), localException);
      String str2 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("load ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(success);
      Logger.d(str2, ((StringBuilder)localObject2).toString());
      return success;
    }
    catch (RuntimeException localRuntimeException)
    {
      success = false;
      localObject2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSoSync: load soPath = ");
      localStringBuilder.append(paramString);
      Logger.e((String)localObject2, localStringBuilder.toString(), localRuntimeException);
      String str3 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("load ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(success);
      Logger.d(str3, ((StringBuilder)localObject2).toString());
      return success;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      success = false;
      Object localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSoSync: load soPath = ");
      localStringBuilder.append(paramString);
      Logger.e((String)localObject2, localStringBuilder.toString(), localUnsatisfiedLinkError);
      String str4 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("load ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(success);
      Logger.d(str4, ((StringBuilder)localObject2).toString());
      return success;
      label376:
      str4 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("load ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(success);
      Logger.d(str4, ((StringBuilder)localObject2).toString());
      return success;
      return bool;
    }
    finally
    {
      break label376;
    }
  }
  
  public static void setLoaded(boolean paramBoolean)
  {
    success = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tav.ResourceLoadUtil
 * JD-Core Version:    0.7.0.1
 */