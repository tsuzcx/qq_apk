package com.tencent.mobileqq.kandian.biz.common.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.base.view.widget.KandianProgressView.ClickCallBack;
import com.tencent.mobileqq.kandian.biz.ugc.KanDianVideoUploadUtils;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyBaseListViewGroup$2
  implements KandianProgressView.ClickCallBack
{
  ReadInJoyBaseListViewGroup$2(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup) {}
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, str);
    KanDianVideoUploadUtils.b(paramBundle);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    paramString = this.a.a();
    if ((paramBundle != null) && (paramString != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      localIntent.setClass(paramString, KandianVideoUploadService.class);
      try
      {
        paramString.startService(localIntent);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.d("KandianVideoUpload", 1, "Kandian retryFail", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup.2
 * JD-Core Version:    0.7.0.1
 */