package com.tencent.weiyun.cmd;

import com.tencent.weiyun.callback.CheckShareFileCallback;
import com.tencent.weiyun.callback.DeleteDirFileCallback;
import com.tencent.weiyun.callback.FetchFileListCallback;
import com.tencent.weiyun.callback.FetchPOICallback;
import com.tencent.weiyun.callback.FetchPicVideoInfoCallback;
import com.tencent.weiyun.callback.FetchUserInfoCallback;
import com.tencent.weiyun.callback.ModifyFileCallback;
import com.tencent.weiyun.callback.WeiyunCallbackCenter;
import com.tencent.weiyun.data.DirItem;
import com.tencent.weiyun.data.FileItem;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.WyLog;
import java.util.List;

final class WeiyunClient
  extends WeiyunNative
{
  private static final String TAG = "WeiyunClient";
  private static WeiyunClient sInstance;
  private final WeiyunCallbackCenter mCallbackCenter = new WeiyunCallbackCenter();
  private boolean mIsInit = false;
  
  private boolean ensureInit()
  {
    if (!this.mIsInit) {
      WyLog.e("WeiyunClient", "WeiyunSdk hasn't be init.");
    }
    return this.mIsInit;
  }
  
  public static WeiyunClient getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new WeiyunClient();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static boolean isLoaded()
  {
    return sIsLoaded;
  }
  
  public boolean checkShareFile(List<DirItem> paramList, List<FileItem> paramList1, List<String> paramList2, CheckShareFileCallback paramCheckShareFileCallback)
  {
    boolean bool = ensureInit();
    if (bool)
    {
      if (paramList == null) {
        paramList = new DirItem[0];
      } else {
        paramList = (DirItem[])paramList.toArray(new DirItem[paramList.size()]);
      }
      if (paramList1 == null) {
        paramList1 = new FileItem[0];
      } else {
        paramList1 = (FileItem[])paramList1.toArray(new FileItem[paramList1.size()]);
      }
      if (paramList2 == null) {
        paramList2 = new String[0];
      } else {
        paramList2 = (String[])paramList2.toArray(new String[paramList2.size()]);
      }
      nativeCheckShareFile(paramList, paramList1, paramList2, this.mCallbackCenter.addCallback(paramCheckShareFileCallback));
    }
    return bool;
  }
  
  public boolean deleteDirFile(List<DirItem> paramList, List<FileItem> paramList1, DeleteDirFileCallback paramDeleteDirFileCallback)
  {
    boolean bool = ensureInit();
    if (bool)
    {
      if (paramList == null) {
        paramList = new DirItem[0];
      } else {
        paramList = (DirItem[])paramList.toArray(new DirItem[paramList.size()]);
      }
      if (paramList1 == null) {
        paramList1 = new FileItem[0];
      } else {
        paramList1 = (FileItem[])paramList1.toArray(new FileItem[paramList1.size()]);
      }
      nativeDeleteDirFile(paramList, paramList1, this.mCallbackCenter.addCallback(paramDeleteDirFileCallback));
    }
    return bool;
  }
  
  public boolean fetchFileList(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, FetchFileListCallback paramFetchFileListCallback)
  {
    boolean bool = ensureInit();
    if (bool)
    {
      nativeFetchFileList(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, this.mCallbackCenter.addCallback(paramFetchFileListCallback));
      return bool;
    }
    return bool;
  }
  
  public boolean fetchFileListRecursively(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FetchFileListCallback paramFetchFileListCallback)
  {
    boolean bool = ensureInit();
    if (bool) {
      nativeFetchFileListRecursively(paramInt1, paramInt2, paramInt3, paramInt4, this.mCallbackCenter.addCallback(paramFetchFileListCallback));
    }
    return bool;
  }
  
  public boolean fetchPOI(List<PoiItem> paramList, FetchPOICallback paramFetchPOICallback)
  {
    boolean bool = ensureInit();
    if (bool)
    {
      if (paramList == null) {
        paramList = new PoiItem[0];
      } else {
        paramList = (PoiItem[])paramList.toArray(new PoiItem[paramList.size()]);
      }
      nativeFetchPOI(paramList, this.mCallbackCenter.addCallback(paramFetchPOICallback));
    }
    return bool;
  }
  
  public boolean fetchPicVideoInfo(FetchPicVideoInfoCallback paramFetchPicVideoInfoCallback)
  {
    boolean bool = ensureInit();
    if (bool) {
      nativeFetchPicVideoInfo(this.mCallbackCenter.addCallback(paramFetchPicVideoInfoCallback));
    }
    return bool;
  }
  
  public boolean fetchUserInfo(FetchUserInfoCallback paramFetchUserInfoCallback)
  {
    boolean bool = ensureInit();
    if (bool) {
      nativeFetchUserInfo(this.mCallbackCenter.addCallback(paramFetchUserInfoCallback));
    }
    return bool;
  }
  
  public boolean init(WeiyunSDKContext paramWeiyunSDKContext)
  {
    if ((paramWeiyunSDKContext != null) && (sIsLoaded))
    {
      if (!this.mIsInit) {
        try
        {
          if (!this.mIsInit)
          {
            nativeRegisterContext(paramWeiyunSDKContext);
            this.mIsInit = true;
          }
          return true;
        }
        finally {}
      }
      return true;
    }
    return false;
  }
  
  public boolean modifyFile(FileItem paramFileItem1, FileItem paramFileItem2, ModifyFileCallback paramModifyFileCallback)
  {
    boolean bool = ensureInit();
    if (bool) {
      nativeModifyFile(paramFileItem1, paramFileItem2, this.mCallbackCenter.addCallback(paramModifyFileCallback));
    }
    return bool;
  }
  
  void onNativeCallback(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString, boolean paramBoolean2)
  {
    this.mCallbackCenter.onCallback(paramLong1, paramLong2, paramInt1, paramBoolean1, paramInt2, paramString, paramBoolean2);
  }
  
  public boolean reset()
  {
    boolean bool = ensureInit();
    if (bool) {
      nativeReset();
    }
    return bool;
  }
  
  public String version()
  {
    if (ensureInit()) {
      return nativeVersion();
    }
    return "unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.cmd.WeiyunClient
 * JD-Core Version:    0.7.0.1
 */