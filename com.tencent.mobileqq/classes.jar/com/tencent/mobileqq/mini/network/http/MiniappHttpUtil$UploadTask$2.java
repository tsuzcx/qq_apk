package com.tencent.mobileqq.mini.network.http;

import com.tencent.plato.mqq.network.ProgressListener;

class MiniappHttpUtil$UploadTask$2
  implements ProgressListener
{
  MiniappHttpUtil$UploadTask$2(MiniappHttpUtil.UploadTask paramUploadTask) {}
  
  public void onProgress(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    HttpCallBack localHttpCallBack = this.this$0.callBack;
    double d1 = paramLong1;
    Double.isNaN(d1);
    double d2 = paramLong2;
    Double.isNaN(d2);
    localHttpCallBack.onProgressUpdate((int)(d1 * 100.0D / d2), (int)paramLong1, (int)paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.UploadTask.2
 * JD-Core Version:    0.7.0.1
 */