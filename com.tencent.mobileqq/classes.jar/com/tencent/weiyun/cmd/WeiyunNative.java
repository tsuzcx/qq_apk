package com.tencent.weiyun.cmd;

import android.text.TextUtils;
import com.tencent.weiyun.data.DirItem;
import com.tencent.weiyun.data.FileItem;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.WyLog;

class WeiyunNative
{
  private static final String TAG = "WeiyunNative";
  protected static boolean sIsLoaded = false;
  
  static
  {
    loadLibrary(null);
  }
  
  protected static boolean loadLibrary(String paramString)
  {
    if (sIsLoaded) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        System.loadLibrary("wlc_data_cmd_qq_v1.0.1");
      } else {
        System.load(paramString);
      }
      try
      {
        WyLog.v("WeiyunNative", "System.loadLibrary wlc_data_cmd_qq_v1.0.1 finish.");
        bool1 = true;
      }
      catch (Exception localException1)
      {
        bool1 = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        bool1 = true;
      }
      WyLog.e("WeiyunNative", "System.loadLibrary failed..", localUnsatisfiedLinkError2);
    }
    catch (Exception localException2)
    {
      WyLog.e("WeiyunNative", "System.loadLibrary failed..", localException2);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      bool1 = bool2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadLibrary libwlc_data_cmd_qq_v1.0.1.so result ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", path=");
    localStringBuilder.append(paramString);
    WyLog.i("WeiyunNative", localStringBuilder.toString());
    sIsLoaded = bool1;
    return bool1;
  }
  
  protected native void nativeCheckShareFile(DirItem[] paramArrayOfDirItem, FileItem[] paramArrayOfFileItem, String[] paramArrayOfString, long paramLong);
  
  protected native void nativeDeleteDirFile(DirItem[] paramArrayOfDirItem, FileItem[] paramArrayOfFileItem, long paramLong);
  
  protected native void nativeFetchFileList(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
  
  protected native void nativeFetchFileListRecursively(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
  
  protected native void nativeFetchPOI(PoiItem[] paramArrayOfPoiItem, long paramLong);
  
  protected native void nativeFetchPicVideoInfo(long paramLong);
  
  protected native void nativeFetchUserInfo(long paramLong);
  
  protected native void nativeModifyFile(FileItem paramFileItem1, FileItem paramFileItem2, long paramLong);
  
  protected native void nativeRegisterContext(WeiyunSDKContext paramWeiyunSDKContext);
  
  protected native void nativeReset();
  
  protected native String nativeVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.cmd.WeiyunNative
 * JD-Core Version:    0.7.0.1
 */