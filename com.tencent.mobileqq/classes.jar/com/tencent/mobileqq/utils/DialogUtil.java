package com.tencent.mobileqq.utils;

import ajnv;
import ajnw;
import ajnx;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.FormEditItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.ListView;
import com.tencent.widget.Switch;
import java.util.ArrayList;

public class DialogUtil
{
  public static Dialog a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2, false, false);
  }
  
  public static Dialog a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new Dialog(paramContext, 2131624515);
    paramContext.setContentView(2130968842);
    Object localObject2 = (TextView)paramContext.findViewById(2131364010);
    TextView localTextView = (TextView)paramContext.findViewById(2131362758);
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
      paramString = (TextView)paramContext.findViewById(2131364013);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131364014);
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
    paramContext = new Dialog(paramContext, 2131624515);
    paramContext.setContentView(2130968859);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131362701);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131363360);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131363039);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131363969);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364058);
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
    paramContext = new Dialog(paramContext, 2131624515);
    paramContext.setContentView(2130970024);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364070);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131364072);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131364073);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131364076);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364077);
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
    paramContext = new Dialog(paramContext, 2131624515);
    paramContext.setContentView(2130968866);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364070);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131364010);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131364072);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131364073);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364076);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131364077);
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
    paramContext = new Dialog(paramContext, 2131624515);
    paramContext.getWindow().setWindowAnimations(2131624571);
    paramContext.setContentView(2130970286);
    ((TextView)paramContext.findViewById(2131369910)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131369911);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131369912);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131369913);
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
    paramContext = new Dialog(paramContext, 2131624515);
    paramContext.setContentView(2130970286);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131369910);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131369911);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131369912);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131369913);
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
      paramString = new ajnv(paramOnClickListener1, paramContext, paramOnClickListener2);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130845341), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131624515;
    }
    paramContext = new ProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2130968595);
      paramContext.setContentView(2130968595);
      ((TextView)paramContext.findViewById(2131362758)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131362757)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static NewUpgradeDialog a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new NewUpgradeDialog(paramActivity);
    paramActivity.a(new QQText(a(paramString1), 3)).b(new QQText(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static QQCustomArkDialog a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QQCustomArkDialog localQQCustomArkDialog = new QQCustomArkDialog(paramContext, 2131624515, false);
    localQQCustomArkDialog.a(paramContext, paramBundle);
    localQQCustomArkDialog.setTitle(paramString);
    localQQCustomArkDialog.setCanceledOnTouchOutside(true);
    localQQCustomArkDialog.setCancelable(true);
    return localQQCustomArkDialog;
  }
  
  public static QQCustomContextMenuDialog a(Context paramContext, QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramQQCustomMenu == null) || (paramQQCustomMenu.a() <= 0)) {
      return null;
    }
    paramContext = new QQCustomContextMenuDialog(paramContext, 2131624515);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2130968851);
    paramContext.a(paramQQCustomMenu, paramOnClickListener);
    paramContext.a(2130968848);
    ((LinearLayout)paramContext.findViewById(2131364012)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    paramQQCustomMenu = (ListView)paramContext.findViewById(2131364021);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131364010);
    paramQQCustomMenu.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131432998, 2131432999, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131432998, 2131432999, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = b(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131364027)).setVisibility(8);
      ((TextView)paramString.findViewById(2131362758)).setMinHeight(DisplayUtil.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramActivity, 2131624515);
    localQQCustomDialog.setContentView(2130968851);
    localQQCustomDialog.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2130968789, null);
    paramString1 = (TextView)paramActivity.findViewById(2131363780);
    String str = NewUpgradeDialog.a((float)paramLong, true, 2);
    if (!android.text.TextUtils.isEmpty(str)) {
      paramString1.setText("大小:" + str);
    }
    ((TextView)paramActivity.findViewById(2131362758)).setText(paramString2);
    localQQCustomDialog.addView(paramActivity);
    localQQCustomDialog.setNegativeButton("暂不升级", paramOnClickListener1);
    localQQCustomDialog.setPositiveButton("马上升级", paramOnClickListener2);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131432998, 2131432999, null, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, TextWatcher paramTextWatcher1, String paramString4, String paramString5, String paramString6, TextWatcher paramTextWatcher2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968861);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    FormEditItem localFormEditItem = (FormEditItem)paramContext.findViewById(2131364059);
    if (paramString1 != null)
    {
      localFormEditItem.setLeftText(paramString1);
      localFormEditItem.setRightText(paramString3);
      localFormEditItem.setVisibility(0);
      paramString1 = localFormEditItem.a();
      paramString1.setText(paramString2);
      paramString1.addTextChangedListener(paramTextWatcher1);
      paramString1 = (FormEditItem)paramContext.findViewById(2131364061);
      if (paramString4 == null) {
        break label178;
      }
      paramString1.setLeftText(paramString4);
      paramString1.setRightText(paramString6);
      paramString1.setVisibility(0);
      paramString1 = paramString1.a();
      paramString1.setText(paramString5);
      paramString1.addTextChangedListener(paramTextWatcher2);
    }
    for (;;)
    {
      paramContext.setNegativeButton(2131432275, paramOnClickListener1);
      paramContext.setPositiveButton(2131432316, paramOnClickListener2);
      paramContext.show();
      return paramContext;
      localFormEditItem.setVisibility(8);
      break;
      label178:
      paramString1.setVisibility(8);
    }
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, boolean paramBoolean, String paramString2, String paramString3, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968861);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    FormEditItem localFormEditItem = (FormEditItem)paramContext.findViewById(2131364061);
    localFormEditItem.setLeftText(paramString2);
    paramString2 = localFormEditItem.a();
    paramString2.setText(paramString3);
    paramString2.addTextChangedListener(paramTextWatcher);
    if (paramString1 != null)
    {
      paramString2 = (FormSwitchItem)paramContext.findViewById(2131364060);
      paramString2.setText(paramString1);
      paramString2.setVisibility(0);
      paramString2.a().setChecked(paramBoolean);
    }
    paramContext.setNegativeButton(2131432275, paramOnClickListener1);
    paramContext.setPositiveButton(2131432316, paramOnClickListener2);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2130968851, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131624515);
    localQQCustomDialog.setContentView(2130968855);
    if (paramInt != 0) {
      localQQCustomDialog.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(paramCharSequence);
      localQQCustomDialog.setNegativeButton(paramString2, paramOnClickListener1);
      localQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener2);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      paramCharSequence = (TextView)localQQCustomDialog.findViewById(2131364047);
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "取消";
      }
      paramCharSequence.setText(paramString1);
      paramCharSequence.setText(paramContext.getResources().getString(2131432998));
      if (paramOnClickListener == null) {
        break;
      }
      paramCharSequence.setOnClickListener(paramOnClickListener);
      return localQQCustomDialog;
      localQQCustomDialog.setTitle(paramString1);
    }
    paramCharSequence.setOnClickListener(new ajnx(localQQCustomDialog));
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968851);
    paramContext.setTitle(paramString1);
    paramContext.setTitleMutiLine();
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return b(paramContext, paramInt, paramString1, paramString2, 2131432998, 2131432999, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968851);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968851);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = a(paramContext, paramInt, paramString1, paramString2, paramString4, paramString5, paramOnClickListener2, paramOnClickListener3);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968851);
    ((TextView)paramContext.findViewById(2131364010)).setSingleLine(false);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt1, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968850);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131624515);
    localQQCustomDialog.setContentView(2130969339);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setNegativeButton(paramString3, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramString4, paramOnClickListener2);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)localQQCustomDialog.findViewById(2131364047);
    paramString1.setText(paramContext.getResources().getString(2131432998));
    paramString1.setOnClickListener(new ajnw(localQQCustomDialog));
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968845);
    paramContext.setTitleWithEmo(new QQText(a(paramString1), 3));
    paramContext.setMessage(new QQText(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialogThreeBtns(paramContext, 2131624515);
    paramContext.setContentView(2130968854);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131624515);
    paramContext.setContentView(2130968858);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131432998, paramOnClickListener2);
    paramContext.setPositiveButton(2131433614, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131624515);
    paramContext.a(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2130968858);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.b(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131432998, paramOnClickListener2);
    paramContext.setPositiveButton(2131433614, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131624515);
    paramContext.setContentView(2130968860);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131432998, paramOnClickListener2);
    paramContext.setPositiveButton(2131432999, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131624515);
    paramContext.setContentView(2130968860);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131432998, paramOnClickListener2);
    paramContext.setPositiveButton(2131432999, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInputAndChoose a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihInputAndChoose(paramContext, 2131624515);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2130968862);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.a(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setMessageCount(paramString3);
    paramContext.a(paramArrayList);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString4);
    paramContext.setNegativeButton(2131432998, paramOnClickListener2);
    paramContext.setPositiveButton(2131433614, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomSingleButtonDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomSingleButtonDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968853);
    paramContext.a(paramString1.replace("/得意", com.tencent.mobileqq.text.TextUtils.c(21)).replace("/可爱", com.tencent.mobileqq.text.TextUtils.c(18)).replace("/鼓掌", com.tencent.mobileqq.text.TextUtils.c(86)).replace("/胜利", com.tencent.mobileqq.text.TextUtils.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace("/得意", com.tencent.mobileqq.text.TextUtils.c(21)).replace("/可爱", com.tencent.mobileqq.text.TextUtils.c(18)).replace("/鼓掌", com.tencent.mobileqq.text.TextUtils.c(86)).replace("/胜利", com.tencent.mobileqq.text.TextUtils.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130838734, 2131432998, paramOnClickListener2);
    paramContext.a(paramString3.replace("/得意", com.tencent.mobileqq.text.TextUtils.c(21)).replace("/可爱", com.tencent.mobileqq.text.TextUtils.c(18)).replace("/鼓掌", com.tencent.mobileqq.text.TextUtils.c(86)).replace("/胜利", com.tencent.mobileqq.text.TextUtils.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      return paramString.replace("/得意", com.tencent.mobileqq.text.TextUtils.c(21)).replace("/可爱", com.tencent.mobileqq.text.TextUtils.c(18)).replace("/鼓掌", com.tencent.mobileqq.text.TextUtils.c(86)).replace("/胜利", com.tencent.mobileqq.text.TextUtils.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static QQCustomArkDialog b(Context paramContext, String paramString, Bundle paramBundle)
  {
    QQCustomArkDialog localQQCustomArkDialog = new QQCustomArkDialog(paramContext, 2131624515, true);
    localQQCustomArkDialog.a(paramContext, paramBundle);
    localQQCustomArkDialog.setTitle(paramString);
    localQQCustomArkDialog.setCanceledOnTouchOutside(true);
    localQQCustomArkDialog.setCancelable(true);
    return localQQCustomArkDialog;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt)
  {
    return c(paramContext, paramInt, null, null, 2131432998, 2131432999, null, null);
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968851);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968851);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131364027);
    paramString1 = (TextView)paramContext.findViewById(2131362758);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput b(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131624515);
    paramContext.a(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2130968856);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.b(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131432998, paramOnClickListener2);
    paramContext.setPositiveButton(2131433614, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog c(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624515);
    paramContext.setContentView(2130968851);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil
 * JD-Core Version:    0.7.0.1
 */