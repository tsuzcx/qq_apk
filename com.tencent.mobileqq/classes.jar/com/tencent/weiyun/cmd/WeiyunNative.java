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
    boolean bool4 = false;
    boolean bool3 = false;
    bool1 = bool3;
    bool2 = bool4;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          continue;
        }
        bool1 = bool3;
        bool2 = bool4;
        System.loadLibrary("WeiyunSDK");
        bool1 = true;
        bool2 = true;
        bool3 = true;
        WyLog.v("WeiyunNative", "System.loadLibrary WeiyunSDK finish.");
        bool1 = bool3;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        WyLog.e("WeiyunNative", "System.loadLibrary failed..", localUnsatisfiedLinkError);
        continue;
      }
      catch (Exception localException)
      {
        WyLog.e("WeiyunNative", "System.loadLibrary failed..", localException);
        bool1 = bool2;
        continue;
      }
      WyLog.i("WeiyunNative", "loadLibrary libWeiyunSDK.so result " + bool1 + ", path=" + paramString);
      sIsLoaded = bool1;
      return bool1;
      bool1 = bool3;
      bool2 = bool4;
      System.load(paramString);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.weiyun.cmd.WeiyunNative
 * JD-Core Version:    0.7.0.1
 */