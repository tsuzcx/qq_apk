package com.tencent.vas.update.entity;

import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import org.json.JSONObject;

public class UpdateUrlInfoPtr
{
  private static final String TAG = "VasUpdate_UpdateUrlInfoPtr";
  public String mAppVersion;
  public long mBid;
  public int mCode;
  public int mCompressMode;
  public int mDeltaMode;
  public String mDstMd5 = "";
  public String mFileContent;
  public long mFileSize;
  public String mItemId = "";
  public String mScid = "";
  public String mSrcMd5 = "";
  public int mStorageMode;
  public String mUrl;
  
  public static UpdateUrlInfoPtr parseUpdateInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      UpdateUrlInfoPtr localUpdateUrlInfoPtr = new UpdateUrlInfoPtr();
      localUpdateUrlInfoPtr.mBid = paramJSONObject.optInt("bid");
      localUpdateUrlInfoPtr.mScid = paramJSONObject.optString("scid");
      localUpdateUrlInfoPtr.mItemId = CommonUtil.sComposeItemId(localUpdateUrlInfoPtr.mBid, localUpdateUrlInfoPtr.mScid);
      localUpdateUrlInfoPtr.mDstMd5 = paramJSONObject.optString("dst_version");
      localUpdateUrlInfoPtr.mSrcMd5 = paramJSONObject.optString("src_version");
      localUpdateUrlInfoPtr.mDeltaMode = paramJSONObject.optInt("delta_mode");
      localUpdateUrlInfoPtr.mStorageMode = paramJSONObject.optInt("storage_mode");
      localUpdateUrlInfoPtr.mCompressMode = paramJSONObject.optInt("compress_mode");
      localUpdateUrlInfoPtr.mUrl = paramJSONObject.optString("url");
      localUpdateUrlInfoPtr.mFileSize = paramJSONObject.optLong("fileSize");
      localUpdateUrlInfoPtr.mCode = paramJSONObject.optInt("code");
      localUpdateUrlInfoPtr.mFileContent = paramJSONObject.optString("filecontent");
      localUpdateUrlInfoPtr.mAppVersion = paramJSONObject.optString("appVersion");
      return localUpdateUrlInfoPtr;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      VasUpdateWrapper.getLog().e("VasUpdate_UpdateUrlInfoPtr", "parseJsonToUpdateUrlInfoPtr error data = " + paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.entity.UpdateUrlInfoPtr
 * JD-Core Version:    0.7.0.1
 */