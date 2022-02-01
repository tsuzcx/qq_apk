package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.luggage.wxa.su.g;
import com.tencent.luggage.wxa.su.h;
import com.tencent.luggage.wxa.su.j;
import com.tencent.luggage.wxa.su.k;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.xweb.e;
import com.tencent.xweb.f.a;
import com.tencent.xweb.v;

final class d$41
  implements j
{
  boolean a = false;
  private ProgressDialog h = null;
  
  d$41(Context paramContext, String paramString, k paramk, boolean paramBoolean, f.a parama, ValueCallback paramValueCallback) {}
  
  public void a()
  {
    this.h = new ReportProgressDialog(this.b);
    this.h.setProgressStyle(1);
    ProgressDialog localProgressDialog = this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(" 下载更新中");
    localProgressDialog.setMessage(localStringBuilder.toString());
    this.h.setCancelable(false);
    this.h.setCanceledOnTouchOutside(false);
    this.h.setButton(-2, "取消", new d.41.1(this));
    this.h.setButton(-1, "完成", new d.41.2(this));
    this.h.show();
    this.h.getButton(-1).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (!this.a)
    {
      ProgressDialog localProgressDialog = this.h;
      if (localProgressDialog == null) {
        return;
      }
      localProgressDialog.setProgress(paramInt);
    }
  }
  
  public void b(int paramInt)
  {
    this.a = true;
    if (this.h == null) {
      return;
    }
    Object localObject1 = h.a(this.c);
    int i;
    if (localObject1 != null) {
      i = ((g)localObject1).a(true);
    } else {
      i = -1;
    }
    Object localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，未知错误，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      break;
    case 0: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新完成，已安装版本");
      ((StringBuilder)localObject2).append(i);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      this.h.setProgress(100);
      this.h.getButton(-2).setVisibility(8);
      this.h.getButton(-1).setVisibility(0);
      if (this.e) {
        this.h.dismiss();
      }
      break;
    case -1: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新被取消，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      break;
    case -2: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，无网络，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      break;
    case -3: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，未到检查时间，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      break;
    case -4: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，其它任务正在更新插件，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      break;
    case -5: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，配置下载失败，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      break;
    case -6: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，配置解析失败，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      break;
    case -7: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，配置中未包含插件信息，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      break;
    case -8: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，未找到可用更新，当前已安装版本");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
      if (this.e) {
        this.h.dismiss();
      }
      break;
    case -9: 
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" 更新失败，下载安装出错，ErrCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((ProgressDialog)localObject1).setMessage(((StringBuilder)localObject2).toString());
    }
    if ((this.f != null) && (v.a() != null))
    {
      if ("XFilesPPTReader".equals(this.c))
      {
        localObject1 = new String[2];
        localObject1[0] = "ppt";
        localObject1[1] = "pptx";
      }
      else if ("XFilesPDFReader".equals(this.c))
      {
        localObject1 = new String[1];
        localObject1[0] = "pdf";
      }
      else if ("XFilesWordReader".equals(this.c))
      {
        localObject1 = new String[2];
        localObject1[0] = "doc";
        localObject1[1] = "docx";
      }
      else if ("XFilesExcelReader".equals(this.c))
      {
        localObject1 = new String[2];
        localObject1[0] = "xls";
        localObject1[1] = "xlsx";
      }
      else
      {
        if (!"XFilesOfficeReader".equals(this.c)) {
          break label996;
        }
        localObject1 = new String[6];
        localObject1[0] = "doc";
        localObject1[1] = "docx";
        localObject1[2] = "xls";
        localObject1[3] = "xlsx";
        localObject1[4] = "ppt";
        localObject1[5] = "pptx";
      }
      localObject2 = v.a().a((String[])localObject1, this.f);
      e.a((String[])localObject1);
      localObject1 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("格式:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("强制使用");
      localStringBuilder.append(this.f.name());
      localStringBuilder.append("打开");
      Toast.makeText((Context)localObject1, localStringBuilder.toString(), 0).show();
      break label997;
      label996:
      return;
    }
    label997:
    localObject1 = this.g;
    if (localObject1 != null) {
      ((ValueCallback)localObject1).onReceiveValue(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.41
 * JD-Core Version:    0.7.0.1
 */