package com.tencent.mobileqq.qqlive.data.upload;

import android.text.TextUtils;

public class QQLiveUploadBitmapParams
{
  public String flag;
  public String format;
  public String roomId;
  public boolean useTestEnv;
  
  public QQLiveUploadBitmapParams() {}
  
  public QQLiveUploadBitmapParams(QQLiveUploadBitmapParams paramQQLiveUploadBitmapParams)
  {
    if (paramQQLiveUploadBitmapParams == null) {
      return;
    }
    this.format = paramQQLiveUploadBitmapParams.format;
    this.roomId = paramQQLiveUploadBitmapParams.roomId;
    this.flag = paramQQLiveUploadBitmapParams.flag;
    this.useTestEnv = paramQQLiveUploadBitmapParams.useTestEnv;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (QQLiveUploadBitmapParams)paramObject;
      return (TextUtils.equals(this.format, paramObject.format)) && (TextUtils.equals(this.roomId, paramObject.roomId));
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.format;
    int j = 0;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    str = this.roomId;
    if (str != null) {
      j = str.hashCode();
    }
    return (527 + i) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams
 * JD-Core Version:    0.7.0.1
 */