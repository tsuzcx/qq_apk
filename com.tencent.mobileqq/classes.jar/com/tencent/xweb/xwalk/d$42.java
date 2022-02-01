package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.webkit.ValueCallback;
import android.widget.Button;
import com.tencent.luggage.wxa.ss.i;
import com.tencent.luggage.wxa.su.g;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import org.xwalk.core.Log;

final class d$42
  extends AsyncTask<Void, Void, Boolean>
{
  private ProgressDialog i = null;
  
  d$42(Context paramContext, g paramg, int paramInt, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, ValueCallback paramValueCallback) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    paramVarArgs = null;
    for (;;)
    {
      boolean bool;
      int m;
      try
      {
        Object localObject = this.b;
        bool = true;
        m = ((g)localObject).a(true);
        if (this.c <= 0) {
          break label288;
        }
        int k = this.c;
        j = k;
        if (m > 0)
        {
          localObject = this.b.b(m);
          this.b.b(-1, true);
          j = k;
          if (localObject != null)
          {
            j = k;
            if (!((String)localObject).isEmpty())
            {
              com.tencent.xweb.util.c.b((String)localObject);
              j = k;
            }
          }
        }
        com.tencent.xweb.xwalk.updater.c localc = new com.tencent.xweb.xwalk.updater.c();
        localc.l = j;
        localc.f = false;
        localc.y = this.b.a(j, false);
        localObject = new File(localc.y);
        try
        {
          if (this.d) {
            com.tencent.xweb.util.c.a(this.a.getAssets().open(this.e), (File)localObject);
          } else {
            i.a(this.f, ((File)localObject).getPath());
          }
          localc.d = i.a(((File)localObject).getPath());
          localc.x = true;
          if (this.b.a(localc) != 0) {
            break label306;
          }
          return Boolean.valueOf(bool);
        }
        catch (Exception localException2)
        {
          paramVarArgs = (Void[])localObject;
          localObject = localException2;
        }
        localStringBuilder = new StringBuilder();
      }
      catch (Exception localException1) {}
      StringBuilder localStringBuilder;
      localStringBuilder.append("loadZipFormatPluginFromLocal error: ");
      localStringBuilder.append(localException1.getMessage());
      Log.e("WebDebugPage", localStringBuilder.toString());
      if (paramVarArgs != null) {}
      try
      {
        com.tencent.xweb.util.c.b(paramVarArgs);
        label279:
        return Boolean.valueOf(false);
      }
      catch (Exception paramVarArgs)
      {
        break label279;
      }
      label288:
      int j = 99999;
      if (m >= 99999)
      {
        j = m + 1;
        continue;
        label306:
        bool = false;
      }
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      this.i.setMessage("安装完成");
    }
    else
    {
      if (this.d) {
        localObject = "asset/";
      } else {
        localObject = "sdcard/apkxwebtest/";
      }
      ProgressDialog localProgressDialog = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("安装失败，请确保文件存在: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.e);
      localProgressDialog.setMessage(localStringBuilder.toString());
    }
    this.i.getButton(-1).setVisibility(0);
    if (this.g) {
      this.i.hide();
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((ValueCallback)localObject).onReceiveValue(paramBoolean);
    }
  }
  
  protected void onPreExecute()
  {
    this.i = new ReportProgressDialog(this.a);
    this.i.setProgressStyle(0);
    this.i.setMessage("安装中");
    this.i.setCancelable(false);
    this.i.setCanceledOnTouchOutside(false);
    this.i.setButton(-1, "完成", new d.42.1(this));
    this.i.show();
    this.i.getButton(-1).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.42
 * JD-Core Version:    0.7.0.1
 */