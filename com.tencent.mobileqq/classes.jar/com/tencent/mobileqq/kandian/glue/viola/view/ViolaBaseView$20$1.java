package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$20$1
  implements Runnable
{
  ViolaBaseView$20$1(ViolaBaseView.20 param20, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadJSSource process from downJsFromNet url: ");
    localStringBuilder.append(this.b.b.a);
    localStringBuilder.append(" , js source Md5 :");
    String str;
    if (!TextUtils.isEmpty(ViolaBaseView.s(this.b.b))) {
      str = ViolaBaseView.s(this.b.b);
    } else {
      str = "";
    }
    localStringBuilder.append(MD5Utils.toMD5(str));
    localStringBuilder.append(" js down source MD5 ");
    localStringBuilder.append(MD5Utils.toMD5(this.a));
    QLog.d("ViolaBaseView", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.20.1
 * JD-Core Version:    0.7.0.1
 */