package com.tencent.mobileqq.qrscan.activity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QRCard;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

class QRCardActivity$3
  implements ActionSheet.OnButtonClickListener
{
  QRCardActivity$3(QRCardActivity paramQRCardActivity, boolean[] paramArrayOfBoolean, String paramString1, Context paramContext, String paramString2) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView, int paramInt)
  {
    if (this.e.C) {
      return;
    }
    paramView = this.e;
    paramView.C = true;
    Object localObject1 = this.a;
    Object localObject2;
    if (localObject1[0] == 1) {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          break label510;
        }
        paramView = (String)paramView.i.f.get(this.e.u);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mailto:");
        ((StringBuilder)localObject1).append(paramView);
        localObject1 = Uri.parse(((StringBuilder)localObject1).toString());
        if (this.e.getPackageManager().queryIntentActivities(new Intent("android.intent.action.SENDTO", (Uri)localObject1), 65536).size() > 0)
        {
          localObject1 = new Intent("android.intent.action.SENDTO");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mailto:");
          ((StringBuilder)localObject2).append(paramView);
          ((Intent)localObject1).setData(Uri.parse(((StringBuilder)localObject2).toString()));
          this.e.startActivity((Intent)localObject1);
          break label510;
        }
        localObject1 = new Intent("android.intent.action.SEND");
        ((Intent)localObject1).putExtra("android.intent.extra.EMAIL", paramView);
        ((Intent)localObject1).putExtra("android.intent.extra.TEXT", "The email body text");
        ((Intent)localObject1).setType("text/plain");
      }
    }
    try
    {
      this.e.startActivity(Intent.createChooser((Intent)localObject1, "Choose Email Client"));
    }
    catch (ActivityNotFoundException paramView)
    {
      label233:
      break label233;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("IQRScanConst_QrcodeScannerCard", 2, "Intent.ACTION_SEND do not exist");
      break label510;
      paramView = QRCardActivity.a(paramView).getAccount();
      localObject1 = (String)this.e.i.f.get(this.e.u);
      if (!TextUtils.isEmpty(paramView))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("https://w.mail.qq.com/cgi-bin/login?target=mobileqqwrite&fwd=mq&fun=from3g&uin=");
        ((StringBuilder)localObject2).append(paramView);
        ((StringBuilder)localObject2).append("&to=");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = ((String)localObject1).toLowerCase();
        if (((String)localObject2).startsWith("www."))
        {
          paramView = new StringBuilder();
          paramView.append("https://");
          paramView.append((String)localObject1);
          paramView = paramView.toString();
        }
        else if (((String)localObject2).startsWith("https:"))
        {
          paramView = new StringBuilder();
          paramView.append("https");
          paramView.append(((String)localObject1).substring(5));
          paramView = paramView.toString();
        }
        else
        {
          paramView = (View)localObject1;
          if (((String)localObject2).startsWith("http:"))
          {
            paramView = new StringBuilder();
            paramView.append("http");
            paramView.append(((String)localObject1).substring(4));
            paramView = paramView.toString();
          }
        }
        localObject1 = new Intent(this.e, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject1).putExtra("injectrecommend", false);
        this.e.startActivity((Intent)localObject1);
      }
    }
    label510:
    this.e.A.dismiss();
    return;
    if (localObject1[1] == 1) {
      if (paramInt == 0)
      {
        if (this.b.contains("-")) {
          this.b.replaceAll("-", "");
        }
        if (this.b.contains(" ")) {
          this.b.replaceAll(" ", "");
        }
        paramView = new StringBuilder();
        paramView.append("tel:");
        paramView.append(this.b);
        paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      }
    }
    try
    {
      this.c.startActivity(paramView);
    }
    catch (ActivityNotFoundException paramView)
    {
      label635:
      break label635;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_QrcodeScannerCard", 2, "Intent.ACTION_DIAL do not exist");
    }
    this.e.A.dismiss();
    return;
    if (localObject1[2] == 1)
    {
      paramView = new HashMap();
      if (!this.e.i.c.isEmpty()) {
        paramView.putAll(this.e.i.c);
      }
      if (!this.e.i.f.isEmpty()) {
        paramView.putAll(this.e.i.f);
      }
      if (this.e.i.e != null) {
        paramView.putAll(this.e.i.e);
      }
      if (!this.e.i.d.isEmpty()) {
        paramView.putAll(this.e.i.d);
      }
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          localObject1 = new Intent("android.intent.action.INSERT_OR_EDIT");
          ((Intent)localObject1).setType("vnd.android.cursor.item/person");
          ((Intent)localObject1).setType("vnd.android.cursor.item/contact");
          ((Intent)localObject1).setType("vnd.android.cursor.item/raw_contact");
          this.e.a((Intent)localObject1, paramView);
        }
      }
      else
      {
        localObject1 = new Intent("android.intent.action.INSERT");
        ((Intent)localObject1).setType("vnd.android.cursor.dir/person");
        ((Intent)localObject1).setType("vnd.android.cursor.dir/contact");
        ((Intent)localObject1).setType("vnd.android.cursor.dir/raw_contact");
        this.e.a((Intent)localObject1, paramView);
      }
      this.e.A.dismiss();
      return;
    }
    if (localObject1[3] == 1) {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3) {
              ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).startActivity(this.c, true, this.d, true);
            }
          }
          else {
            ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).startActivity(this.c, false, this.d, true);
          }
        }
        else if (!TextUtils.isEmpty(this.d)) {
          if (Build.VERSION.SDK_INT < 11)
          {
            ((android.text.ClipboardManager)this.e.getSystemService("clipboard")).setText(this.d);
          }
          else
          {
            paramView = (android.content.ClipboardManager)this.e.getSystemService("clipboard");
            localObject1 = this.d;
            ClipboardMonitor.setText(paramView, (CharSequence)localObject1);
            paramView.setText((CharSequence)localObject1);
          }
        }
      }
      else
      {
        if (this.d.contains("-")) {
          this.d.replaceAll("-", "");
        }
        if (this.d.contains(" ")) {
          this.d.replaceAll(" ", "");
        }
        paramView = new StringBuilder();
        paramView.append("tel:");
        paramView.append(this.d);
        paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      }
    }
    try
    {
      this.c.startActivity(paramView);
    }
    catch (ActivityNotFoundException paramView)
    {
      label1162:
      break label1162;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_QrcodeScannerCard", 2, "Intent.ACTION_DIAL do not exist");
    }
    this.e.A.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity.3
 * JD-Core Version:    0.7.0.1
 */