package com.tencent.mobileqq.qqlive.data.upload;

public class QQLiveUploadBitmapResult
{
  public String errorMsg;
  public boolean isSuccess;
  public QQLiveUploadBitmapParams reqParams;
  public int retCode;
  public long timeStamp;
  public String url;
  
  public QQLiveUploadBitmapResult() {}
  
  public QQLiveUploadBitmapResult(int paramInt, boolean paramBoolean, String paramString)
  {
    this.retCode = paramInt;
    this.isSuccess = paramBoolean;
    this.errorMsg = paramString;
  }
  
  public QQLiveUploadBitmapResult(QQLiveUploadBitmapResult paramQQLiveUploadBitmapResult)
  {
    if (paramQQLiveUploadBitmapResult == null) {
      return;
    }
    this.retCode = paramQQLiveUploadBitmapResult.retCode;
    this.isSuccess = paramQQLiveUploadBitmapResult.isSuccess;
    this.errorMsg = paramQQLiveUploadBitmapResult.errorMsg;
    this.url = paramQQLiveUploadBitmapResult.url;
    this.timeStamp = paramQQLiveUploadBitmapResult.timeStamp;
    this.reqParams = new QQLiveUploadBitmapParams(paramQQLiveUploadBitmapResult.reqParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult
 * JD-Core Version:    0.7.0.1
 */