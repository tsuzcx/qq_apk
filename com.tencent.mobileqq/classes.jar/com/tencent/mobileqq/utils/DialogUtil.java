package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.PermissionUtil.SDCardPermissionCallback;
import com.tencent.widget.ListView;
import java.util.HashMap;

public class DialogUtil
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", HardCodeUtil.a(2131703307));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", HardCodeUtil.a(2131703322));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + HardCodeUtil.a(2131703293));
    a.put("android.permission.CAMERA", HardCodeUtil.a(2131703334));
    a.put("android.permission.RECORD_AUDIO", HardCodeUtil.a(2131703305));
    a.put("android.permission.ACCESS_COARSE_LOCATION", HardCodeUtil.a(2131703300));
    a.put("android.permission.ACCESS_FINE_LOCATION", HardCodeUtil.a(2131703306));
    a.put("android.permission.READ_CALENDAR", HardCodeUtil.a(2131703350));
    a.put("android.permission.WRITE_CALENDAR", HardCodeUtil.a(2131703348));
    a.put("android.permission.SEND_SMS", HardCodeUtil.a(2131703336));
    a.put("android.permission.READ_CONTACTS", HardCodeUtil.a(2131703325));
    a.put("android.permission.WRITE_CONTACTS", HardCodeUtil.a(2131703343));
  }
  
  public static Dialog a(Activity paramActivity, int paramInt)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity, 2131755918);
    localReportDialog.setContentView(2131561554);
    ((TextView)localReportDialog.findViewById(2131374767)).setText(paramActivity.getString(paramInt));
    localReportDialog.setCancelable(true);
    localReportDialog.setCanceledOnTouchOutside(false);
    return localReportDialog;
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = CustomDialogFactory.a(paramActivity, 2131698347, 2131698345, 2131698344, 2131698346, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, DialogUtil.IDialogView paramIDialogView, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559091);
    Object localObject2 = (TextView)paramContext.findViewById(2131365811);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365812);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = 0;
      ((TextView)localObject2).setVisibility(8);
      ((TextView)localObject2).requestLayout();
      localObject2 = (ViewGroup.MarginLayoutParams)localFrameLayout.getLayoutParams();
      paramInt1 = (int)((Resources)localObject1).getDisplayMetrics().density;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (paramInt1 * 18);
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (paramInt1 * 18);
      localFrameLayout.requestLayout();
    }
    for (;;)
    {
      localObject1 = (TextView)paramContext.findViewById(2131365796);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365802);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(paramIDialogView.a(localFrameLayout.getContext(), paramObject));
      return paramContext;
      localObject1 = ((Resources)localObject1).getString(paramInt1);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2, false, false);
  }
  
  public static Dialog a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559060);
    Object localObject2 = (TextView)paramContext.findViewById(2131365811);
    TextView localTextView = (TextView)paramContext.findViewById(2131365807);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = 0;
      ((TextView)localObject2).setVisibility(8);
      ((TextView)localObject2).requestLayout();
      localObject2 = (ViewGroup.MarginLayoutParams)localTextView.getLayoutParams();
      paramInt1 = (int)((Resources)localObject1).getDisplayMetrics().density;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (paramInt1 * 18);
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (paramInt1 * 18);
      localTextView.requestLayout();
    }
    for (;;)
    {
      if (localTextView != null)
      {
        localTextView.setText(paramString);
        localTextView.setContentDescription(paramString);
      }
      paramString = (TextView)paramContext.findViewById(2131365796);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365802);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setContentDescription(str1);
        paramString.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      return paramContext;
      localObject1 = ((Resources)localObject1).getString(paramInt1);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
    }
  }
  
  public static Dialog a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559097);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131368603);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131379432);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365294);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131364357);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131365202);
    if (paramBitmap == null)
    {
      localImageView.setVisibility(8);
      if (paramString2 != null) {
        break label140;
      }
      localTextView2.setVisibility(8);
      label94:
      localTextView1.setText(paramString1);
      if (paramOnClickListener1 != null) {
        break label149;
      }
      localTextView3.setVisibility(8);
      label112:
      if (paramOnClickListener2 != null) {
        break label166;
      }
      localTextView4.setVisibility(8);
    }
    for (;;)
    {
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      localImageView.setImageBitmap(paramBitmap);
      break;
      label140:
      localTextView2.setText(paramString2);
      break label94;
      label149:
      localTextView3.setOnClickListener(paramOnClickListener1);
      localTextView3.setText(paramString3);
      break label112;
      label166:
      localTextView4.setOnClickListener(paramOnClickListener2);
      localTextView4.setText(paramString4);
    }
  }
  
  public static Dialog a(Context paramContext, Drawable paramDrawable, String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131755842);
    paramContext.setContentView(2131560957);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380911);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131380912);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380913);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380907);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380908);
    if (paramDrawable == null)
    {
      localImageView.setVisibility(8);
      if (paramString2 != null) {
        break label140;
      }
      localTextView2.setVisibility(8);
      label94:
      localTextView1.setText(paramString1);
      if (paramOnClickListener1 != null) {
        break label149;
      }
      localTextView3.setVisibility(8);
      label112:
      if (paramOnClickListener2 != null) {
        break label166;
      }
      localTextView4.setVisibility(8);
    }
    for (;;)
    {
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      localImageView.setImageDrawable(paramDrawable);
      break;
      label140:
      localTextView2.setText(paramString2);
      break label94;
      label149:
      localTextView3.setOnClickListener(paramOnClickListener1);
      localTextView3.setText(paramString3);
      break label112;
      label166:
      localTextView4.setOnClickListener(paramOnClickListener2);
      localTextView4.setText(paramString4);
    }
  }
  
  public static Dialog a(Context paramContext, Drawable paramDrawable, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559105);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380911);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365811);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380912);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380913);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380907);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131380908);
    if (paramDrawable == null)
    {
      localImageView.setVisibility(8);
      if (paramString1 != null) {
        break label163;
      }
      localTextView1.setVisibility(8);
      label105:
      if (paramString3 != null) {
        break label172;
      }
      localTextView3.setVisibility(8);
      label117:
      localTextView2.setText(paramString2);
      if (paramOnClickListener1 != null) {
        break label182;
      }
      localTextView4.setVisibility(8);
      label135:
      if (paramOnClickListener2 != null) {
        break label199;
      }
      localTextView5.setVisibility(8);
    }
    for (;;)
    {
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      localImageView.setImageDrawable(paramDrawable);
      break;
      label163:
      localTextView1.setText(paramString1);
      break label105;
      label172:
      localTextView3.setText(paramString3);
      break label117;
      label182:
      localTextView4.setOnClickListener(paramOnClickListener1);
      localTextView4.setText(paramString4);
      break label135;
      label199:
      localTextView5.setOnClickListener(paramOnClickListener2);
      localTextView5.setText(paramString5);
    }
  }
  
  public static Dialog a(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131755842);
    paramContext.getWindow().setWindowAnimations(2131755132);
    paramContext.setContentView(2131561170);
    ((TextView)paramContext.findViewById(2131365845)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365832);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365830);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365836);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    if (paramInt1 == 0) {
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      localTextView3.setText(paramInt2);
      localTextView2.setOnClickListener(paramOnClickListener1);
      localTextView3.setOnClickListener(paramOnClickListener2);
      return paramContext;
      localTextView2.setText(paramInt1);
    }
  }
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, ClickableColorSpanTextView.SpanClickListener paramSpanClickListener)
  {
    paramContext = new ReportDialog(paramContext, 2131755842);
    paramContext.setContentView(2131561170);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365845);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365832);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365830);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365836);
    if (paramString == null)
    {
      localTextView3.setVisibility(8);
      localClickableColorSpanTextView.setText(paramCharSequence);
      if (paramInt1 != 0) {
        break label144;
      }
      localTextView1.setVisibility(8);
      label89:
      if (paramInt2 != 0) {
        break label153;
      }
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      paramString = new DialogUtil.5(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(paramSpanClickListener);
      return paramContext;
      localTextView3.setText(paramString);
      break;
      label144:
      localTextView1.setText(paramInt1);
      break label89;
      label153:
      localTextView2.setText(paramInt2);
    }
  }
  
  public static ProgressDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getResources().getDrawable(2130850006), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131755842;
    }
    paramContext = new ReportProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131558435);
      paramContext.setContentView(2131558435);
      ((TextView)paramContext.findViewById(2131365807)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131367330)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static QQCustomContextMenuDialog a(Context paramContext, QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramQQCustomMenu == null) || (paramQQCustomMenu.a() <= 0)) {
      return null;
    }
    paramContext = new QQCustomContextMenuDialog(paramContext, 2131755842);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131559084);
    paramContext.a(paramQQCustomMenu, paramOnClickListener);
    paramContext.a(2131559074);
    ((LinearLayout)paramContext.findViewById(2131363904)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    paramQQCustomMenu = (ListView)paramContext.findViewById(2131370452);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365811);
    paramQQCustomMenu.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static QQCustomDialog a(Activity paramActivity)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2131703295));
    localQQCustomDialog.setMessage(2131693873);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131703326), new DialogUtil.10(localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131714803), new DialogUtil.11(paramActivity));
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690800, 2131694615, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    localQQCustomDialog.setTitle(paramActivity.getString(paramInt2));
    localQQCustomDialog.setMessage(paramInt1);
    localQQCustomDialog.setNegativeButton(paramActivity.getString(2131690800), new DialogUtil.12(localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(paramActivity.getString(2131719114), new DialogUtil.13(paramActivity));
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    paramSDCardPermissionCallback = new DialogUtil.1(paramActivity, paramSDCardPermissionCallback);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(HardCodeUtil.a(2131710178));
    paramActivity.setMessage(HardCodeUtil.a(2131716870));
    paramActivity.setNegativeButton(HardCodeUtil.a(2131716869), paramSDCardPermissionCallback);
    paramActivity.setPositiveButton(HardCodeUtil.a(2131716868), paramSDCardPermissionCallback);
    paramActivity.show();
    return paramActivity;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690800, 2131694615, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365784)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365807)).setMinHeight(DisplayUtil.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2)
  {
    DialogUtil.8 local8 = new DialogUtil.8(paramActivity);
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = HardCodeUtil.a(2131703299);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = HardCodeUtil.a(2131703351);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131703354), local8);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = HardCodeUtil.a(2131703295);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = HardCodeUtil.a(2131703333);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131703326), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131703310), paramOnClickListener2);
    localQQCustomDialog.setOnCancelListener(paramOnCancelListener);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = a(paramActivity, 0, paramString1, paramString2, null, null);
    if (paramActivity.getTitleTextView() != null) {
      paramActivity.getTitleTextView().getPaint().setFakeBoldText(true);
    }
    if (paramActivity.getBtnight() != null) {
      paramActivity.getBtnight().getPaint().setFakeBoldText(true);
    }
    paramActivity.setPositiveButton(paramString3, paramOnClickListener);
    paramActivity.setCancelable(true);
    paramActivity.setCanceledOnTouchOutside(true);
    return paramActivity;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    int i;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      try
      {
        if (paramArrayOfString.length != 1) {
          break label114;
        }
        paramArrayOfString = a(new String[] { paramArrayOfString[0] });
        return b(paramActivity, null, paramArrayOfString);
      }
      catch (Exception paramActivity)
      {
        return null;
      }
      if (i < paramArrayOfInt.length)
      {
        localObject1 = localObject2;
        if (paramArrayOfInt[i] == 0) {
          break;
        }
        if (localObject2 == null) {
          break label133;
        }
        localObject1 = (String)localObject2 + "#" + paramArrayOfString[i];
        break;
      }
      if (localObject2 != null)
      {
        paramArrayOfString = a(((String)localObject2).split("#"));
      }
      else
      {
        paramArrayOfString = null;
        continue;
        label114:
        i = 0;
        localObject2 = null;
      }
    }
    for (;;)
    {
      i += 1;
      localObject2 = localObject1;
      break;
      label133:
      localObject1 = paramArrayOfString[i];
    }
  }
  
  public static QQCustomDialog a(Context paramContext)
  {
    DialogUtil.2 local2 = new DialogUtil.2(paramContext);
    paramContext = a(paramContext, 230);
    paramContext.setTitle(HardCodeUtil.a(2131710178));
    paramContext.setMessage(HardCodeUtil.a(2131716870));
    paramContext.setNegativeButton(HardCodeUtil.a(2131716869), local2);
    paramContext.setPositiveButton(HardCodeUtil.a(2131716868), local2);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690800, 2131694615, null, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131559084, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559084);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131755842);
    localQQCustomDialog.setContentView(2131559090);
    if (paramInt != 0) {
      localQQCustomDialog.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(paramCharSequence);
      localQQCustomDialog.setNegativeButton(paramString2, paramOnClickListener1);
      localQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener2);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localQQCustomDialog.findViewById(2131365786);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = HardCodeUtil.a(2131703330);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new DialogUtil.6(paramOnClickListener3, localQQCustomDialog));
      return localQQCustomDialog;
      localQQCustomDialog.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new DialogUtil.7(localQQCustomDialog));
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559084);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690800, 2131694615, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559084);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559084);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365784);
    paramString1 = (TextView)paramContext.findViewById(2131365807);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559068);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = a(paramContext, paramInt, paramString1, paramString2, paramString4, paramString5, paramOnClickListener2, paramOnClickListener3);
    paramContext.setCheckBox(paramString3, paramBoolean, paramOnClickListener1);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString)
  {
    DialogUtil.3 local3 = new DialogUtil.3(paramContext);
    paramContext = a(paramContext, 230);
    paramContext.setTitle(HardCodeUtil.a(2131710178));
    paramContext.setMessage(paramString);
    paramContext.setNegativeButton(HardCodeUtil.a(2131716869), local3);
    paramContext.setPositiveButton(HardCodeUtil.a(2131716868), local3);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean, int paramInt, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    DialogUtil.4 local4 = new DialogUtil.4(paramContext, 2131755842, paramInt, paramBoolean, paramString2);
    local4.setContentView(2131559084);
    local4.setCanceledOnTouchOutside(false);
    local4.setTitle(paramString1);
    local4.setMessage(paramCharSequence);
    local4.title.setTypeface(Typeface.DEFAULT_BOLD);
    local4.rBtn.setTypeface(Typeface.DEFAULT_BOLD);
    local4.lBtn.setTypeface(Typeface.DEFAULT_BOLD);
    local4.lBtn.setTextColor(paramContext.getResources().getColorStateList(2131165580));
    local4.lBtn.setText(paramString2);
    local4.lBtn.setVisibility(0);
    local4.lBtn.setOnClickListener(paramOnClickListener1);
    local4.rBtn.setVisibility(0);
    local4.rBtn.setText(paramString3);
    local4.rBtn.setOnClickListener(paramOnClickListener2);
    return local4;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559081);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559062);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365811);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365807);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364815);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialogThreeBtns(paramContext, 2131755842);
    paramContext.setContentView(2131559087);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = HardCodeUtil.a(2131703331);
    String str1 = null;
    if (paramVarArgs != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length;
      str1 = null;
      int i = 0;
      if (i < j)
      {
        String str3 = paramVarArgs[i];
        if ("android.permission.CAMERA".equals(str3)) {
          str1 = HardCodeUtil.a(2131703298);
        }
        for (;;)
        {
          if ((str1 != null) && (localStringBuilder.indexOf(str1) < 0))
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append("和");
            }
            localStringBuilder.append(str1);
          }
          i += 1;
          break;
          if ("android.permission.RECORD_AUDIO".equals(str3)) {
            str1 = HardCodeUtil.a(2131703313);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = HardCodeUtil.a(2131703302);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = HardCodeUtil.a(2131703320);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = HardCodeUtil.a(2131703332);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = HardCodeUtil.a(2131703338);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = HardCodeUtil.a(2131703296);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = HardCodeUtil.a(2131703303);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = HardCodeUtil.a(2131703341);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = HardCodeUtil.a(2131707927);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = HardCodeUtil.a(2131707925);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static QQCustomDialog b(Activity paramActivity, String paramString1, String paramString2)
  {
    DialogUtil.9 local9 = new DialogUtil.9(paramActivity);
    return a(paramActivity, paramString1, paramString2, local9, local9, null);
  }
  
  public static QQCustomDialog b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131695437);
    }
    localQQCustomDialog.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131695434);
    }
    localQQCustomDialog.setMessage(paramString1);
    localQQCustomDialog.setNegativeButton(paramActivity.getResources().getString(2131690800), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramActivity.getResources().getString(2131694615), paramOnClickListener2);
    localQQCustomDialog.setOnCancelListener(paramOnCancelListener);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690800, 2131694615, null, null);
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755842);
    paramContext.setContentView(2131559084);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil
 * JD-Core Version:    0.7.0.1
 */