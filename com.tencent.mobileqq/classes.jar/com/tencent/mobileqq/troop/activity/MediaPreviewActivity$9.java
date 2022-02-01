package com.tencent.mobileqq.troop.activity;

import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MediaPreviewActivity$9
  extends AsyncTask<Void, Void, String>
{
  MediaPreviewActivity$9(MediaPreviewActivity paramMediaPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.a.saveTo(this.b);
    }
    catch (Exception paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, QLog.getStackTraceString(paramVarArgs));
      }
      paramVarArgs = null;
    }
    if (paramVarArgs != null)
    {
      ImageUtil.b(this.c, paramVarArgs);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.getString(2131892639));
      localStringBuilder.append(" ");
      localStringBuilder.append(paramVarArgs);
      return localStringBuilder.toString();
    }
    return this.c.getString(2131892637);
  }
  
  protected void a(String paramString)
  {
    QQToast.makeText(this.c, paramString, 0).show(this.c.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.9
 * JD-Core Version:    0.7.0.1
 */