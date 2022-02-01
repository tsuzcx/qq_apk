package com.tencent.mobileqq.filemanageraux.app;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.uniformdownload.util.IGetFileInfoCallBack;

class UniformDownload$1
  implements IGetFileInfoCallBack
{
  UniformDownload$1(UniformDownload paramUniformDownload, Bundle paramBundle, String paramString, long paramLong1, long paramLong2) {}
  
  public void a(String paramString, long paramLong)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "nofilename.x";
    }
    this.e.b.runOnUiThread(new UniformDownload.1.1(this, str, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.app.UniformDownload.1
 * JD-Core Version:    0.7.0.1
 */