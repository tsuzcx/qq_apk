package com.tencent.mobileqq.vas.hippy;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class VasHippyFontUtils$FontDownloadListener
  extends DownloadListener
{
  private Promise a;
  private int b;
  private int c = 0;
  private int d = 0;
  
  public VasHippyFontUtils$FontDownloadListener(Promise paramPromise, int paramInt)
  {
    this.a = paramPromise;
    this.b = paramInt;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download done task = ");
      localStringBuilder.append(paramDownloadTask.h);
      localStringBuilder.append(" path = ");
      if (paramDownloadTask.g != null) {
        localObject = paramDownloadTask.g.toString();
      } else {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      QLog.i("VasHippyFontUtils", 2, localStringBuilder.toString());
    }
    int i = paramDownloadTask.e();
    int j = 0;
    if ((i == 3) && (paramDownloadTask.c == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.c += 1;
      if (paramDownloadTask.g != null) {
        paramDownloadTask = (File)paramDownloadTask.g.get(paramDownloadTask.h);
      } else {
        paramDownloadTask = null;
      }
      VasHippyFontUtils.a(paramDownloadTask);
    }
    else
    {
      this.d += 1;
    }
    i = this.c;
    int k = this.d;
    if (i + k == this.b)
    {
      localObject = this.a;
      i = j;
      if (k > 0) {
        i = -1;
      }
      if (this.d > 0) {
        paramDownloadTask = "fail";
      } else {
        paramDownloadTask = "success";
      }
      VasHippyFontUtils.a((Promise)localObject, i, paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasHippyFontUtils.FontDownloadListener
 * JD-Core Version:    0.7.0.1
 */