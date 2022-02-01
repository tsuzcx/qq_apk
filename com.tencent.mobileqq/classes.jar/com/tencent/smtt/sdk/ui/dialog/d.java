package com.tencent.smtt.sdk.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class d
  extends ReportDialog
{
  static WeakReference<ValueCallback<String>> a;
  protected List<b> b;
  protected final String c = "extraMenu";
  protected final String d = "name";
  protected final String e = "resource_id";
  protected final String f = "value";
  private ListView g;
  private Button h;
  private Button i;
  private final String j = "TBSActivityPicker";
  private String k;
  private a l;
  private String m = "*/*";
  private String n;
  private Intent o;
  private SharedPreferences p = null;
  private int q = 0;
  private int r = 0;
  private FrameLayout s;
  private LinearLayout t;
  
  public d(Context paramContext, String paramString1, Intent paramIntent, Bundle paramBundle, ValueCallback<String> paramValueCallback, String paramString2, String paramString3)
  {
    super(paramContext, 16973835);
    this.n = paramString3;
    paramString3 = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    TbsLog.i("TBSActivityPicker", "acts.size(): " + paramString3.size());
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getBundle("extraMenu"); paramBundle != null; paramBundle = null)
    {
      this.b = new ArrayList();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = paramBundle.getBundle((String)localIterator.next());
        if (localObject != null)
        {
          String str = ((Bundle)localObject).getString("name", null);
          int i1 = ((Bundle)localObject).getInt("resource_id", -1);
          localObject = ((Bundle)localObject).getString("value", null);
          if ((str != null) && (i1 != -1) && (localObject != null))
          {
            Context localContext = getContext();
            this.b.add(new b(localContext, i1, str, (String)localObject));
          }
        }
      }
    }
    TbsLog.i("TBSActivityPicker", "no extra menu info in bundle");
    if (((paramString3 == null) || (paramString3.size() == 0)) && ((this.b == null) || (this.b.isEmpty())) && (MttLoader.isBrowserInstalled(paramContext)))
    {
      TbsLog.i("TBSActivityPicker", "no action has been found with Intent:" + paramIntent.toString());
      com.tencent.smtt.sdk.QbSdk.isDefaultDialog = true;
    }
    if (("com.tencent.rtxlite".equalsIgnoreCase(paramContext.getApplicationContext().getPackageName())) && ((paramString3 == null) || (paramString3.size() == 0)) && ((this.b == null) || (this.b.isEmpty())))
    {
      TbsLog.i("TBSActivityPicker", "package name equal to `com.tencent.rtxlite` but no action has been found with Intent:" + paramIntent.toString());
      com.tencent.smtt.sdk.QbSdk.isDefaultDialog = true;
    }
    this.k = paramString1;
    this.o = paramIntent;
    a = new WeakReference(paramValueCallback);
    this.p = paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0);
    if (!TextUtils.isEmpty(paramString2)) {
      this.m = paramString2;
    }
    TbsLog.i("TBSActivityPicker", "Intent:" + this.m + " MineType:" + this.m);
  }
  
  private View a(Context paramContext)
  {
    this.s = new FrameLayout(paramContext);
    this.t = new LinearLayout(paramContext);
    Object localObject = new FrameLayout.LayoutParams(-1, Double.valueOf(0.5F * c.a(paramContext)).intValue());
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.t.setOrientation(1);
    this.r = c.a(paramContext, 72.0F);
    localObject = new com.tencent.smtt.sdk.ui.dialog.widget.a(paramContext, c.a(paramContext, 12.0F), c.b(paramContext, 35.0F), c.b(paramContext, 15.0F));
    ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, this.r));
    ((View)localObject).setOnClickListener(new d.3(this));
    this.t.addView((View)localObject);
    this.g = new ListView(paramContext);
    this.g.setOverScrollMode(2);
    this.g.setVerticalScrollBarEnabled(false);
    this.g.setBackgroundColor(-1);
    localObject = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.g.setDividerHeight(0);
    this.t.addView(this.g);
    localObject = new LinearLayout(paramContext);
    this.q = c.a(paramContext, 150.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.q);
    localLayoutParams.weight = 0.0F;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    ((LinearLayout)localObject).setOrientation(0);
    ((LinearLayout)localObject).setBackgroundColor(-1);
    ((LinearLayout)localObject).setContentDescription("x5_tbs_activity_picker_btn_container");
    this.h = new com.tencent.smtt.sdk.ui.dialog.widget.b(paramContext, c.a(paramContext, 12.0F), Color.parseColor("#EBEDF5"));
    localLayoutParams = new LinearLayout.LayoutParams(-1, c.a(paramContext, 90.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.topMargin = c.a(paramContext, 30.0F);
    localLayoutParams.bottomMargin = c.a(paramContext, 30.0F);
    localLayoutParams.leftMargin = c.a(paramContext, 32.0F);
    localLayoutParams.rightMargin = c.a(paramContext, 8.0F);
    this.h.setLayoutParams(localLayoutParams);
    this.h.setText(e.b("x5_tbs_wechat_activity_picker_label_always"));
    this.h.setTextColor(Color.rgb(29, 29, 29));
    this.h.setTextSize(0, c.a(paramContext, 34.0F));
    ((LinearLayout)localObject).addView(this.h);
    this.i = new com.tencent.smtt.sdk.ui.dialog.widget.b(paramContext, c.a(paramContext, 12.0F), Color.parseColor("#00CAFC"));
    localLayoutParams = new LinearLayout.LayoutParams(-1, c.a(paramContext, 90.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.topMargin = c.a(paramContext, 30.0F);
    localLayoutParams.bottomMargin = c.a(paramContext, 30.0F);
    localLayoutParams.leftMargin = c.a(paramContext, 8.0F);
    localLayoutParams.rightMargin = c.a(paramContext, 32.0F);
    this.i.setLayoutParams(localLayoutParams);
    this.i.setText(e.b("x5_tbs_wechat_activity_picker_label_once"));
    this.i.setTextColor(Color.rgb(255, 255, 255));
    this.i.setTextSize(0, c.a(paramContext, 34.0F));
    ((LinearLayout)localObject).addView(this.i);
    this.t.addView((View)localObject);
    this.s.addView(this.t);
    return this.s;
  }
  
  private void a(b paramb)
  {
    if (paramb.f())
    {
      if ((c()) && (a.get() != null)) {
        ((ValueCallback)a.get()).onReceiveValue("https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047");
      }
    }
    else {
      return;
    }
    paramb = new Intent("android.intent.action.VIEW", Uri.parse("https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041"));
    paramb.addFlags(268435456);
    getContext().startActivity(paramb);
  }
  
  private void b(String paramString)
  {
    if ((this.l == null) || (!c())) {}
    b localb;
    do
    {
      ResolveInfo localResolveInfo;
      do
      {
        return;
        localb = this.l.a();
        localResolveInfo = this.l.a(localb);
      } while (a.get() == null);
      if ((localb != null) && (localResolveInfo != null) && (localResolveInfo.activityInfo != null) && (localResolveInfo.activityInfo.packageName != null))
      {
        ((ValueCallback)a.get()).onReceiveValue(paramString + localResolveInfo.activityInfo.packageName);
        return;
      }
      if (localb == null) {
        break;
      }
      if (localb.e())
      {
        ((ValueCallback)a.get()).onReceiveValue(paramString + localb.g());
        return;
      }
    } while (!localb.f());
    ((ValueCallback)a.get()).onReceiveValue(paramString + localb.d());
    return;
    ((ValueCallback)a.get()).onReceiveValue(paramString + "other");
  }
  
  private Drawable c(String paramString)
  {
    Context localContext = getContext();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new File(localContext.getFilesDir(), paramString);
    } while (!FileUtil.c(paramString));
    try
    {
      TbsLog.i("TBSActivityPicker", "load icon from: " + paramString.getAbsolutePath());
      paramString = new BitmapDrawable(BitmapFactory.decodeFile(paramString.getAbsolutePath()));
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private boolean c()
  {
    return "com.tencent.mobileqq".equals(getContext().getApplicationContext().getPackageName());
  }
  
  private void d()
  {
    if (this.l != null) {}
    for (b localb = this.l.a();; localb = null)
    {
      Object localObject3;
      Object localObject1;
      Object localObject4;
      Object localObject2;
      if (this.p != null)
      {
        localObject3 = c(this.p.getString("key_tbs_recommend_icon_url", null));
        localObject1 = this.p.getString("key_tbs_recommend_label", null);
        localObject4 = this.p.getString("key_tbs_recommend_description", null);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject2 = localObject1;
            localObject1 = localObject4;
          }
        }
      }
      for (;;)
      {
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = e.a("application_icon");
        }
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = "QQ浏览器";
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = e.b("x5_tbs_wechat_activity_picker_label_recommend");
        }
        localObject1 = new b(getContext(), (Drawable)localObject4, (String)localObject3, "com.tencent.mtt", (String)localObject2);
        this.l = new a(getContext(), this.o, (b)localObject1, this.b, localb, this, this.g);
        this.g.setAdapter(this.l);
        e();
        return;
        localObject4 = null;
        localObject2 = localObject1;
        localObject1 = localObject4;
        continue;
        localObject1 = null;
        break;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.g.getAdapter();
    if (localObject == null) {
      return;
    }
    int i1 = 0;
    int i2 = 0;
    while (i1 < ((ListAdapter)localObject).getCount())
    {
      View localView = ((ListAdapter)localObject).getView(i1, null, this.g);
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      i2 += localView.getMeasuredHeight();
      i1 += 1;
    }
    double d1 = this.r + i2 + this.q;
    localObject = this.t.getLayoutParams();
    i1 = c.a(getContext());
    ((ViewGroup.LayoutParams)localObject).height = Double.valueOf(Math.max(Math.min(d1, 0.9F * i1), i1 * 0.5F)).intValue();
    this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public String a()
  {
    String str = null;
    if (this.p != null)
    {
      TbsLog.i("TBSActivityPicker", "getTBSPickedDefaultBrowser: " + this.p.getString(new StringBuilder().append("key_tbs_picked_default_browser_").append(this.m).toString(), null));
      str = this.p.getString("key_tbs_picked_default_browser_" + this.m, null);
    }
    return str;
  }
  
  public void a(String paramString)
  {
    TbsLog.i("TBSActivityPicker", "setTBSPickedDefaultBrowser:" + paramString);
    if (this.p != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        TbsLog.i("TBSActivityPicker", "paramString empty, remove: key_tbs_picked_default_browser_" + this.m);
        this.p.edit().remove("key_tbs_picked_default_browser_" + this.m).commit();
      }
    }
    else {
      return;
    }
    TbsLog.i("TBSActivityPicker", "paramString not empty, set: key_tbs_picked_default_browser_" + this.m + "=" + paramString);
    this.p.edit().putString("key_tbs_picked_default_browser_" + this.m, paramString).commit();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.setEnabled(paramBoolean);
    }
    if (this.h != null) {
      this.h.setEnabled(paramBoolean);
    }
    b("userMenuClickEvent:");
  }
  
  public void b()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.setBackgroundDrawable(new ColorDrawable(0));
      localWindow.setGravity(80);
      localWindow.setLayout(-1, -2);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.horizontalMargin = 0.0F;
      localLayoutParams.dimAmount = 0.5F;
      localWindow.setAttributes(localLayoutParams);
    }
    setContentView(a(getContext()));
    d();
    this.h.setOnClickListener(new d.1(this));
    this.i.setOnClickListener(new d.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.d
 * JD-Core Version:    0.7.0.1
 */