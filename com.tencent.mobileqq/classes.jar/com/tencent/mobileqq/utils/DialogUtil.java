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
    a.put("android.permission.READ_EXTERNAL_STORAGE", HardCodeUtil.a(2131901393));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", HardCodeUtil.a(2131901408));
    HashMap localHashMap = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n");
    localStringBuilder.append(HardCodeUtil.a(2131901379));
    localHashMap.put("android.permission.READ_PHONE_STATE", localStringBuilder.toString());
    a.put("android.permission.CAMERA", HardCodeUtil.a(2131901418));
    a.put("android.permission.RECORD_AUDIO", HardCodeUtil.a(2131901391));
    a.put("android.permission.ACCESS_COARSE_LOCATION", HardCodeUtil.a(2131901386));
    a.put("android.permission.ACCESS_FINE_LOCATION", HardCodeUtil.a(2131901392));
    a.put("android.permission.READ_CALENDAR", HardCodeUtil.a(2131901434));
    a.put("android.permission.WRITE_CALENDAR", HardCodeUtil.a(2131901432));
    a.put("android.permission.SEND_SMS", HardCodeUtil.a(2131901420));
    a.put("android.permission.READ_CONTACTS", HardCodeUtil.a(2131901411));
    a.put("android.permission.WRITE_CONTACTS", HardCodeUtil.a(2131901427));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = CustomDialogFactory.a(paramActivity, 2131896336, 2131896334, 2131896333, 2131896335, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, DialogUtil.IDialogView paramIDialogView, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624618);
    Object localObject2 = (TextView)paramContext.findViewById(2131431880);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131431882);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = 0;
      ((TextView)localObject2).setVisibility(8);
      ((TextView)localObject2).requestLayout();
      localObject2 = (ViewGroup.MarginLayoutParams)localFrameLayout.getLayoutParams();
      paramInt1 = (int)((Resources)localObject1).getDisplayMetrics().density * 18;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = paramInt1;
      localFrameLayout.requestLayout();
    }
    else
    {
      localObject1 = ((Resources)localObject1).getString(paramInt1);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
    }
    localObject1 = (TextView)paramContext.findViewById(2131431864);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(str2);
      ((TextView)localObject1).setContentDescription(str2);
      ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
      if (paramBoolean1) {
        ((TextView)localObject1).getPaint().setFakeBoldText(true);
      }
    }
    paramOnClickListener1 = (TextView)paramContext.findViewById(2131431870);
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
    paramContext = new ReportDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624587);
    Object localObject2 = (TextView)paramContext.findViewById(2131431880);
    TextView localTextView = (TextView)paramContext.findViewById(2131431876);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = 0;
      ((TextView)localObject2).setVisibility(8);
      ((TextView)localObject2).requestLayout();
      localObject2 = (ViewGroup.MarginLayoutParams)localTextView.getLayoutParams();
      paramInt1 = (int)((Resources)localObject1).getDisplayMetrics().density * 18;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = paramInt1;
      localTextView.requestLayout();
    }
    else
    {
      localObject1 = ((Resources)localObject1).getString(paramInt1);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
    }
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      localTextView.setContentDescription(paramString);
    }
    paramString = (TextView)paramContext.findViewById(2131431864);
    if (paramString != null)
    {
      paramString.setText(str2);
      paramString.setContentDescription(str2);
      paramString.setOnClickListener(paramOnClickListener1);
      if (paramBoolean1) {
        paramString.getPaint().setFakeBoldText(true);
      }
    }
    paramString = (TextView)paramContext.findViewById(2131431870);
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
  }
  
  public static Dialog a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624624);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131435219);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131447463);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131431322);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131430272);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131431218);
    if (paramBitmap == null) {
      localImageView.setVisibility(8);
    } else {
      localImageView.setImageBitmap(paramBitmap);
    }
    if (paramString2 == null) {
      localTextView2.setVisibility(8);
    } else {
      localTextView2.setText(paramString2);
    }
    localTextView1.setText(paramString1);
    if (paramOnClickListener1 == null)
    {
      localTextView3.setVisibility(8);
    }
    else
    {
      localTextView3.setOnClickListener(paramOnClickListener1);
      localTextView3.setText(paramString3);
    }
    if (paramOnClickListener2 == null)
    {
      localTextView4.setVisibility(8);
    }
    else
    {
      localTextView4.setOnClickListener(paramOnClickListener2);
      localTextView4.setText(paramString4);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, Drawable paramDrawable, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624632);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131449092);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131431880);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131449093);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131449094);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131449088);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131449089);
    if (paramDrawable == null) {
      localImageView.setVisibility(8);
    } else {
      localImageView.setImageDrawable(paramDrawable);
    }
    if (paramString1 == null) {
      localTextView1.setVisibility(8);
    } else {
      localTextView1.setText(paramString1);
    }
    if (paramString3 == null) {
      localTextView3.setVisibility(8);
    } else {
      localTextView3.setText(paramString3);
    }
    localTextView2.setText(paramString2);
    if (paramOnClickListener1 == null)
    {
      localTextView4.setVisibility(8);
    }
    else
    {
      localTextView4.setOnClickListener(paramOnClickListener1);
      localTextView4.setText(paramString4);
    }
    if (paramOnClickListener2 == null)
    {
      localTextView5.setVisibility(8);
    }
    else
    {
      localTextView5.setOnClickListener(paramOnClickListener2);
      localTextView5.setText(paramString5);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131953338);
    paramContext.getWindow().setWindowAnimations(2131951986);
    paramContext.setContentView(2131627374);
    ((TextView)paramContext.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131431902);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131431900);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131431907);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    if (paramInt1 == 0) {
      localTextView2.setVisibility(8);
    } else {
      localTextView2.setText(paramInt1);
    }
    localTextView3.setText(paramInt2);
    localTextView2.setOnClickListener(paramOnClickListener1);
    localTextView3.setOnClickListener(paramOnClickListener2);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, ClickableColorSpanTextView.SpanClickListener paramSpanClickListener)
  {
    paramContext = new ReportDialog(paramContext, 2131953338);
    paramContext.setContentView(2131627374);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131431915);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131431902);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131431900);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131431907);
    if (paramString == null) {
      localTextView3.setVisibility(8);
    } else {
      localTextView3.setText(paramString);
    }
    localClickableColorSpanTextView.setText(paramCharSequence);
    if (paramInt1 == 0) {
      localTextView1.setVisibility(8);
    } else {
      localTextView1.setText(paramInt1);
    }
    if (paramInt2 == 0) {
      localTextView2.setVisibility(8);
    } else {
      localTextView2.setText(paramInt2);
    }
    paramString = new DialogUtil.5(paramOnClickListener1, paramContext, paramOnClickListener2);
    localTextView1.setOnClickListener(paramString);
    localTextView2.setOnClickListener(paramString);
    localClickableColorSpanTextView.setSpanClickListener(paramSpanClickListener);
    return paramContext;
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131953338;
    }
    paramContext = new ReportProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131623999);
      paramContext.setContentView(2131623999);
      ((TextView)paramContext.findViewById(2131431876)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131433567)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static QQCustomContextMenuDialog a(Context paramContext, QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramQQCustomMenu != null) && (paramQQCustomMenu.b() > 0))
    {
      paramContext = new QQCustomContextMenuDialog(paramContext, 2131953338);
      paramContext.setCanceledOnTouchOutside(true);
      paramContext.setContentView(2131624611);
      paramContext.a(paramQQCustomMenu, paramOnClickListener);
      paramContext.a(2131624601);
      ((LinearLayout)paramContext.findViewById(2131429772)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
      paramQQCustomMenu = (ListView)paramContext.findViewById(2131437272);
      paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
      paramOnClickListener.addRule(3, 2131431880);
      paramQQCustomMenu.setLayoutParams(paramOnClickListener);
      return paramContext;
    }
    return null;
  }
  
  public static QQCustomDialog a(Activity paramActivity)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2131901381));
    localQQCustomDialog.setMessage(2131891403);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131898212), new DialogUtil.10(localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131912239), new DialogUtil.11(paramActivity));
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131887648, 2131892267, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    localQQCustomDialog.setTitle(paramActivity.getString(paramInt2));
    localQQCustomDialog.setMessage(paramInt1);
    localQQCustomDialog.setNegativeButton(paramActivity.getString(2131887648), new DialogUtil.12(localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(paramActivity.getString(2131916361), new DialogUtil.13(paramActivity));
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    paramSDCardPermissionCallback = new DialogUtil.1(paramActivity, paramSDCardPermissionCallback);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(HardCodeUtil.a(2131907863));
    paramActivity.setMessage(HardCodeUtil.a(2131913955));
    paramActivity.setNegativeButton(HardCodeUtil.a(2131898212), paramSDCardPermissionCallback);
    paramActivity.setPositiveButton(HardCodeUtil.a(2131913954), paramSDCardPermissionCallback);
    paramActivity.show();
    return paramActivity;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131887648, 2131892267, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131431852)).setVisibility(8);
      ((TextView)paramString.findViewById(2131431876)).setMinHeight(DisplayUtil.a(paramActivity, 35.0F));
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
      paramActivity = HardCodeUtil.a(2131901385);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = HardCodeUtil.a(2131901435);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131901438), local8);
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
      paramActivity = HardCodeUtil.a(2131901381);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = HardCodeUtil.a(2131901417);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131898212), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131901396), paramOnClickListener2);
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
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (j == 1)
        {
          paramArrayOfString = a(new String[] { paramArrayOfString[0] });
          continue;
          j = paramArrayOfInt.length;
          if (i < j)
          {
            localObject1 = localObject2;
            if (paramArrayOfInt[i] == 0) {
              break label148;
            }
            if (localObject2 == null) {
              break label143;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("#");
            ((StringBuilder)localObject1).append(paramArrayOfString[i]);
            localObject1 = ((StringBuilder)localObject1).toString();
            break label148;
          }
          if (localObject2 == null) {
            break label159;
          }
          paramArrayOfString = a(((String)localObject2).split("#"));
          paramActivity = b(paramActivity, null, paramArrayOfString);
          return paramActivity;
        }
      }
      catch (Exception paramActivity)
      {
        return null;
      }
      Object localObject2 = null;
      continue;
      label143:
      Object localObject1 = paramArrayOfString[i];
      label148:
      i += 1;
      localObject2 = localObject1;
      continue;
      label159:
      paramArrayOfString = null;
    }
  }
  
  public static QQCustomDialog a(Context paramContext)
  {
    DialogUtil.2 local2 = new DialogUtil.2(paramContext);
    paramContext = a(paramContext, 230);
    paramContext.setTitle(HardCodeUtil.a(2131907863));
    paramContext.setMessage(HardCodeUtil.a(2131913955));
    paramContext.setNegativeButton(HardCodeUtil.a(2131898212), local2);
    paramContext.setPositiveButton(HardCodeUtil.a(2131913954), local2);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131887648, 2131892267, null, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
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
    paramContext = new QQCustomDialog(paramContext, 2131953338);
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
    return a(paramContext, paramInt1, 2131624611, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624611);
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
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131953338);
    localQQCustomDialog.setContentView(2131624617);
    if (paramInt != 0) {
      localQQCustomDialog.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    } else {
      localQQCustomDialog.setTitle(paramString1);
    }
    localQQCustomDialog.setMessage(paramCharSequence);
    localQQCustomDialog.setNegativeButton(paramString2, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener2);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)localQQCustomDialog.findViewById(2131431854);
    paramContext = paramString4;
    if (paramString4 == null) {
      paramContext = HardCodeUtil.a(2131898212);
    }
    paramString1.setText(paramContext);
    if (paramOnClickListener3 != null)
    {
      paramString1.setOnClickListener(new DialogUtil.6(paramOnClickListener3, localQQCustomDialog));
      return localQQCustomDialog;
    }
    paramString1.setOnClickListener(new DialogUtil.7(localQQCustomDialog));
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624611);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131887648, 2131892267, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624611);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624611);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131431852);
    paramString1 = (TextView)paramContext.findViewById(2131431876);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
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
    paramContext.setTitle(HardCodeUtil.a(2131907863));
    paramContext.setMessage(paramString);
    paramContext.setNegativeButton(HardCodeUtil.a(2131898212), local3);
    paramContext.setPositiveButton(HardCodeUtil.a(2131913954), local3);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean, int paramInt, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    DialogUtil.4 local4 = new DialogUtil.4(paramContext, 2131953425, paramInt, paramBoolean, paramString2);
    local4.setContentView(2131624611);
    local4.setCanceledOnTouchOutside(false);
    local4.setTitle(paramString1);
    local4.setMessage(paramCharSequence);
    local4.title.setTypeface(Typeface.DEFAULT_BOLD);
    local4.rBtn.setTypeface(Typeface.DEFAULT_BOLD);
    local4.lBtn.setTypeface(Typeface.DEFAULT_BOLD);
    local4.lBtn.setTextColor(paramContext.getResources().getColorStateList(2131165897));
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
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624608);
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
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624589);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131431880);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131431876);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131430806);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialogThreeBtns(paramContext, 2131953338);
    paramContext.setContentView(2131624614);
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
    String str2 = HardCodeUtil.a(2131901415);
    String str1 = null;
    if (paramVarArgs != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length;
      str1 = null;
      int i = 0;
      while (i < j)
      {
        String str3 = paramVarArgs[i];
        if ("android.permission.CAMERA".equals(str3)) {
          str1 = HardCodeUtil.a(2131901384);
        } else if ("android.permission.RECORD_AUDIO".equals(str3)) {
          str1 = HardCodeUtil.a(2131901399);
        } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
          str1 = HardCodeUtil.a(2131901388);
        } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
          str1 = HardCodeUtil.a(2131901406);
        } else if ("android.permission.READ_CALENDAR".equals(str3)) {
          str1 = HardCodeUtil.a(2131901416);
        } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
          str1 = HardCodeUtil.a(2131901422);
        } else if ("android.permission.SEND_SMS".equals(str3)) {
          str1 = HardCodeUtil.a(2131901382);
        } else if ("android.permission.READ_CONTACTS".equals(str3)) {
          str1 = HardCodeUtil.a(2131901389);
        } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
          str1 = HardCodeUtil.a(2131901425);
        } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
          str1 = HardCodeUtil.a(2131905758);
        } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
          str1 = HardCodeUtil.a(2131905756);
        }
        if ((str1 != null) && (localStringBuilder.indexOf(str1) < 0))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append("和");
          }
          localStringBuilder.append(str1);
        }
        i += 1;
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static Dialog b(Activity paramActivity, int paramInt)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity, 2131953422);
    localReportDialog.setContentView(2131627751);
    ((TextView)localReportDialog.findViewById(2131442466)).setText(paramActivity.getString(paramInt));
    localReportDialog.setCancelable(true);
    localReportDialog.setCanceledOnTouchOutside(false);
    return localReportDialog;
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
      str = paramActivity.getResources().getString(2131893195);
    }
    localQQCustomDialog.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131893192);
    }
    localQQCustomDialog.setMessage(paramString1);
    localQQCustomDialog.setNegativeButton(paramActivity.getResources().getString(2131887648), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramActivity.getResources().getString(2131892267), paramOnClickListener2);
    localQQCustomDialog.setOnCancelListener(paramOnCancelListener);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131887648, 2131892267, null, null);
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624611);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624595);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static QQCustomDialogThreeBtns c(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static ProgressDialog d(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getResources().getDrawable(2130851670), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil
 * JD-Core Version:    0.7.0.1
 */