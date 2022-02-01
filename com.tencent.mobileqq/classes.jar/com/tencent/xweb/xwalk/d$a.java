package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.xweb.p;
import com.tencent.xweb.p.a;
import org.xwalk.core.Log;

class d$a
  implements p.a
{
  Context a;
  boolean b = false;
  private ProgressDialog c;
  
  public d$a(Context paramContext)
  {
    this.a = paramContext;
    p.a(this);
    a("正在监听更新,点空白区域取消");
  }
  
  public void a()
  {
    a("开始更新");
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      a("更新完成，点任意位置重启进程生效");
      this.b = true;
      this.c.setCancelable(true);
      this.c.setCanceledOnTouchOutside(true);
      this.c.setProgress(100);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      Object localObject;
      break label116;
    }
    if (paramInt == -5)
    {
      a("暂无需要立即更新的版本");
      this.c.setCancelable(true);
      this.c.setCanceledOnTouchOutside(true);
      return;
    }
    this.c.setCancelable(true);
    this.c.setCanceledOnTouchOutside(true);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("更新失败, error code = :");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    return;
    label116:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("may run in background failed to load alert:");
    localStringBuilder.append(localObject.getMessage());
    Log.i("WebDebugPage", localStringBuilder.toString());
  }
  
  void a(String paramString)
  {
    if (this.c == null)
    {
      this.c = new ReportProgressDialog(this.a);
      this.c.setProgressStyle(1);
      this.c.setMessage(paramString);
      this.c.setOnCancelListener(new d.a.1(this));
      this.c.setCancelable(true);
      this.c.show();
    }
    this.c.setMessage(paramString);
  }
  
  public void b()
  {
    a("主配置更新完成");
  }
  
  public void b(int paramInt)
  {
    try
    {
      a("正在下载内核");
      if (this.c != null)
      {
        this.c.setCancelable(false);
        this.c.setProgress(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("may run in background failed to load alert:");
      localStringBuilder.append(localException.getMessage());
      Log.i("WebDebugPage", localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    a("插件配置更新完成");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.a
 * JD-Core Version:    0.7.0.1
 */