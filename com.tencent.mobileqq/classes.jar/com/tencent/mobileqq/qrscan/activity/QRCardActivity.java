package com.tencent.mobileqq.qrscan.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qrscan.QRCard;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class QRCardActivity
  extends QIphoneTitleBarActivity
  implements View.OnClickListener
{
  protected static String p = "((?:(?i)https?://|www\\.|[a-zA-Z0-9]+\\.)[a-zA-Z0-9\\-.]+(?::(\\d+))?(?:(?:/[a-zA-Z0-9\\-._?,'+\\\\&%$=~*!;#():@\\\\]*)+)?)";
  protected float a;
  protected int a;
  protected Resources a;
  protected Handler a;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new QRCardActivity.8(this);
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected QRCard a;
  protected ActionSheet a;
  protected String a;
  protected Thread a;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  protected boolean a;
  protected TextView b;
  protected String b;
  protected boolean b;
  protected TextView c;
  protected String c;
  protected boolean c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  protected String o = null;
  
  public QRCardActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new QRCardActivity.1(this);
  }
  
  private ViewGroup a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i1 = (int)(this.jdField_a_of_type_Float * 5.0F);
    localLayoutParams.setMargins(0, i1, 0, i1 << 1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  public static QQCustomMenuNoIconLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    QQCustomMenuItemPriorityHelper.a(paramQQCustomMenu);
    paramContext = new QQCustomMenuNoIconLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow, null);
    paramContext.setMenu(paramQQCustomMenu);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.a();
    return paramContext;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.setOnDismissListener(paramOnDismissListener);
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.showAsDropDown(paramView);
    return localBubblePopupWindow;
  }
  
  private void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    boolean[] arrayOfBoolean = new boolean[4];
    boolean[] tmp19_17 = arrayOfBoolean;
    tmp19_17[0] = 0;
    boolean[] tmp24_19 = tmp19_17;
    tmp24_19[1] = 0;
    boolean[] tmp29_24 = tmp24_19;
    tmp29_24[2] = 0;
    boolean[] tmp34_29 = tmp29_24;
    tmp34_29[3] = 0;
    tmp34_29;
    if (paramInt == 2)
    {
      arrayOfBoolean[0] = true;
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131720161);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(str, 0);
      str = this.jdField_a_of_type_AndroidContentResResources.getString(2131720159);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(str, 0);
    }
    if (paramInt == 0)
    {
      arrayOfBoolean[1] = true;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131691600), 1);
    }
    if (paramInt == 4)
    {
      arrayOfBoolean[2] = true;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131689704), 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131689700), 1);
    }
    if (paramInt == 3)
    {
      arrayOfBoolean[3] = true;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131691600, 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131691294, 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131689609, 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693517, 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(String.format(paramContext.getString(2131694553), new Object[] { paramString1 }));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new QRCardActivity.3(this, arrayOfBoolean, paramString2, paramContext, paramString1));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new QRCardActivity.4(this));
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater localLayoutInflater = super.getLayoutInflater();
    Object localObject7 = Integer.valueOf(0);
    if (paramInt == 0) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.size();
    }
    for (int i2 = this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.size();; i2 = this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.a.size())
    {
      i1 += i2;
      break label102;
      if (paramInt != 1) {
        break;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.e.size() + this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.f.size() + this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.d.size();
    }
    int i1 = 0;
    label102:
    Object localObject1 = null;
    Object localObject2;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    if (paramInt == 0)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.isEmpty();
      localObject2 = ";";
      Object localObject8;
      Object localObject6;
      int i3;
      int i4;
      int i5;
      if (!bool)
      {
        localObject8 = this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.keySet().iterator();
        paramInt = 0;
        label458:
        while (((Iterator)localObject8).hasNext())
        {
          localObject5 = (String)((Iterator)localObject8).next();
          String str = (String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.get(localObject5);
          localObject6 = str.split((String)localObject2);
          localObject4 = localObject2;
          localObject3 = localObject1;
          i2 = i1;
          i3 = paramInt;
          if (localObject6 != null) {
            if (localObject6.length <= 0)
            {
              localObject4 = localObject2;
              localObject3 = localObject1;
              i2 = i1;
              i3 = paramInt;
            }
            else
            {
              i1 += localObject6.length - 1;
              if (localObject6.length > 1)
              {
                i4 = localObject6.length;
                i5 = 0;
                for (;;)
                {
                  localObject4 = localObject2;
                  localObject3 = localObject1;
                  i2 = i1;
                  i3 = paramInt;
                  if (i5 >= i4) {
                    break;
                  }
                  localObject3 = localObject6[i5];
                  localObject1 = localLayoutInflater.inflate(2131560437, (ViewGroup)localObject1);
                  ((View)localObject1).setTag(localObject7);
                  localObject4 = (TextView)((View)localObject1).findViewById(2131365169);
                  ((TextView)((View)localObject1).findViewById(2131378784)).setText((CharSequence)localObject5);
                  ((TextView)localObject4).setText((CharSequence)localObject3);
                  a(paramInt, i1, (View)localObject1, paramViewGroup, 1);
                  paramInt += 1;
                  i5 += 1;
                  localObject1 = null;
                }
              }
              localObject3 = localLayoutInflater.inflate(2131560437, (ViewGroup)localObject1);
              ((View)localObject3).setTag(localObject7);
              localObject4 = (TextView)((View)localObject3).findViewById(2131365169);
              ((TextView)((View)localObject3).findViewById(2131378784)).setText((CharSequence)localObject5);
              ((TextView)localObject4).setText(str);
              a(paramInt, i1, (View)localObject3, paramViewGroup, 1);
              paramInt += 1;
              break label458;
            }
          }
          localObject2 = localObject4;
          localObject1 = localObject3;
          paramInt = i3;
          i1 = i2;
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else
      {
        localObject1 = ";";
        localObject2 = null;
        paramInt = 0;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.isEmpty())
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject6 = (String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.get(localObject4);
          localObject5 = ((String)localObject6).split((String)localObject1);
          if ((localObject5 != null) && (localObject5.length > 0))
          {
            i4 = i1 + (localObject5.length - 1);
            if (localObject5.length > 1)
            {
              i5 = localObject5.length;
              i2 = 0;
              i3 = paramInt;
              for (;;)
              {
                i1 = i4;
                paramInt = i3;
                if (i2 >= i5) {
                  break;
                }
                localObject6 = localObject5[i2];
                localObject7 = localLayoutInflater.inflate(2131560436, (ViewGroup)localObject2);
                localObject8 = (TextView)((View)localObject7).findViewById(2131365169);
                ((TextView)((View)localObject7).findViewById(2131378784)).setText((CharSequence)localObject4);
                ((TextView)localObject8).setText((CharSequence)localObject6);
                a(i3, i4, (View)localObject7, paramViewGroup, 0);
                i3 += 1;
                i2 += 1;
              }
            }
            localObject5 = localLayoutInflater.inflate(2131560436, (ViewGroup)localObject2);
            localObject7 = (TextView)((View)localObject5).findViewById(2131365169);
            ((TextView)((View)localObject5).findViewById(2131378784)).setText((CharSequence)localObject4);
            ((TextView)localObject7).setText((CharSequence)localObject6);
            a(paramInt, i4, (View)localObject5, paramViewGroup, 0);
            paramInt += 1;
            i1 = i4;
          }
        }
      }
    }
    else if (paramInt == 1)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.f.isEmpty())
      {
        localObject1 = this.k;
        localObject2 = (String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.f.get(this.k);
        localObject3 = localLayoutInflater.inflate(2131560437, null);
        ((View)localObject3).setTag(Integer.valueOf(2));
        localObject4 = (TextView)((View)localObject3).findViewById(2131365169);
        ((TextView)((View)localObject3).findViewById(2131378784)).setText((CharSequence)localObject1);
        ((TextView)localObject4).setText((CharSequence)localObject2);
        a(0, i1, (View)localObject3, paramViewGroup, 1);
        paramInt = 1;
      }
      else
      {
        paramInt = 0;
      }
      i2 = paramInt;
      if (!this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.e.isEmpty())
      {
        localObject1 = this.j;
        localObject2 = (String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.e.get(this.j);
        localObject3 = localLayoutInflater.inflate(2131560436, null);
        localObject4 = (TextView)((View)localObject3).findViewById(2131365169);
        ((TextView)((View)localObject3).findViewById(2131378784)).setText((CharSequence)localObject1);
        ((TextView)localObject4).setText((CharSequence)localObject2);
        a(paramInt, i1, (View)localObject3, paramViewGroup, 0);
        i2 = paramInt + 1;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.d.isEmpty())
      {
        localObject1 = this.h;
        localObject2 = (String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.d.get(this.h);
        if (Pattern.compile(p).matcher((CharSequence)localObject2).matches())
        {
          localObject3 = localLayoutInflater.inflate(2131560437, null);
          ((View)localObject3).setTag(Integer.valueOf(1));
          localObject4 = (TextView)((View)localObject3).findViewById(2131365169);
          ((TextView)((View)localObject3).findViewById(2131378784)).setText((CharSequence)localObject1);
          ((TextView)localObject4).setText((CharSequence)localObject2);
          a(i2, i1, (View)localObject3, paramViewGroup, 1);
        }
        else
        {
          localObject3 = localLayoutInflater.inflate(2131560436, null);
          localObject4 = (TextView)((View)localObject3).findViewById(2131365169);
          ((TextView)((View)localObject3).findViewById(2131378784)).setText((CharSequence)localObject1);
          ((TextView)localObject4).setText((CharSequence)localObject2);
          a(i2, i1, (View)localObject3, paramViewGroup, 0);
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.a.isEmpty())
      {
        localObject1 = localLayoutInflater.inflate(2131560436, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131365169);
        localObject3 = (TextView)((View)localObject1).findViewById(2131378784);
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject3).setText(this.i);
        localObject3 = (String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.a.get(this.i);
        localObject4 = new SpannableString((CharSequence)localObject3);
        localObject5 = Pattern.compile("\\d{5,}").matcher((CharSequence)localObject3);
        while (((Matcher)localObject5).find())
        {
          paramInt = ((Matcher)localObject5).start();
          i2 = ((Matcher)localObject5).end();
          if (i2 - paramInt <= 16) {
            ((SpannableString)localObject4).setSpan(new QRCardActivity.NumberSpan(this, ((String)localObject3).toString().substring(paramInt, i2)), paramInt, i2, 33);
          }
        }
        localObject5 = Pattern.compile(p).matcher((CharSequence)localObject3);
        while (((Matcher)localObject5).find())
        {
          paramInt = ((Matcher)localObject5).start();
          i2 = ((Matcher)localObject5).end();
          ((SpannableString)localObject4).setSpan(new QRCardActivity.NumberSpan(this, ((String)localObject3).toString().substring(paramInt, i2)), paramInt, i2, 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject4);
        if (i1 == 1) {
          ((View)localObject1).setBackgroundResource(2130839433);
        } else {
          ((View)localObject1).setBackgroundResource(2130839440);
        }
        paramViewGroup.addView((View)localObject1);
      }
    }
  }
  
  private void b()
  {
    super.setTitle(2131691512);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368343));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378460));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380148));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131367060));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371877));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131369009));
    if (!TextUtils.isEmpty(this.m)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.m);
    }
    TextView localTextView;
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!TextUtils.isEmpty(this.n))
      {
        localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentResResources.getString(2131719647));
        localStringBuilder.append(": ");
        localStringBuilder.append(this.n);
        localTextView.setText(localStringBuilder.toString());
      }
    }
    else
    {
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentResResources.getString(2131694458));
      localStringBuilder.append(": ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localTextView.setText(localStringBuilder.toString());
      if (!TextUtils.isEmpty(this.n))
      {
        localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentResResources.getString(2131719647));
        localStringBuilder.append(": ");
        localStringBuilder.append(this.n);
        localTextView.setText(localStringBuilder.toString());
      }
    }
    boolean bool = AppNetConnInfo.isWifiConn();
    if ((this.jdField_b_of_type_Boolean) && (bool))
    {
      this.jdField_a_of_type_JavaLangThread = new Thread(new QRCardActivity.2(this));
      this.jdField_a_of_type_JavaLangThread.start();
    }
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
    ViewGroup localViewGroup1 = a();
    a(localViewGroup1, 0);
    ViewGroup localViewGroup2 = a();
    a(localViewGroup2, 1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentResResources.getString(2131719575);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentResResources.getString(2131693165);
    this.d = this.jdField_a_of_type_AndroidContentResResources.getString(2131720402);
    this.e = this.jdField_a_of_type_AndroidContentResResources.getString(2131689705);
    this.f = this.jdField_a_of_type_AndroidContentResResources.getString(2131693164);
    this.g = this.jdField_a_of_type_AndroidContentResResources.getString(2131720401);
    this.h = this.jdField_a_of_type_AndroidContentResResources.getString(2131720157);
    this.i = this.jdField_a_of_type_AndroidContentResResources.getString(2131694496);
    this.j = this.jdField_a_of_type_AndroidContentResResources.getString(2131694669);
    this.k = this.jdField_a_of_type_AndroidContentResResources.getString(2131691881);
    this.jdField_a_of_type_Int = super.getResources().getColor(2131165777);
    this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard = new QRCard();
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, int paramInt3)
  {
    if (paramInt1 == 0) {
      paramView.setBackgroundResource(2130839449);
    } else if (paramInt1 == paramInt2 - 1) {
      paramView.setBackgroundResource(2130839440);
    } else {
      paramView.setBackgroundResource(2130839443);
    }
    if (paramInt2 == 1) {
      paramView.setBackgroundResource(2130839433);
    }
    if (paramInt3 == 1)
    {
      paramView.setOnClickListener(new QRCardActivity.7(this));
      paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    }
    paramViewGroup.addView(paramView);
  }
  
  protected void a(int paramInt, String paramString)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int i1;
    if (paramInt == 0)
    {
      if (paramString.length() <= 7) {
        return;
      }
      paramString = paramString.substring(7);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = paramString.split(";");
        if (localObject2 == null) {
          return;
        }
        paramInt = 0;
        while (paramInt < localObject2.length)
        {
          if (localObject2[paramInt].contains(":"))
          {
            localObject1 = localObject2[paramInt].split(":");
            if ((localObject1 != null) && (localObject1.length > 1) && (!TextUtils.isEmpty(localObject1[0])) && (!TextUtils.isEmpty(localObject1[1])))
            {
              localObject3 = localObject1[0].toLowerCase().trim();
              paramString = localObject1[1].trim();
              if (((String)localObject3).equalsIgnoreCase("n"))
              {
                this.m = paramString;
              }
              else if (((String)localObject3).equalsIgnoreCase("til"))
              {
                this.n = paramString;
              }
              else if (((String)localObject3).startsWith("photo"))
              {
                if (localObject1.length > 2)
                {
                  paramString = new StringBuilder();
                  i1 = 1;
                  while (i1 < localObject1.length)
                  {
                    paramString.append(localObject1[i1]);
                    if (i1 != localObject1.length - 1) {
                      paramString.append(":");
                    }
                    i1 += 1;
                  }
                  paramString = paramString.toString();
                }
                this.l = paramString;
                this.jdField_b_of_type_Boolean = true;
              }
              else if (((String)localObject3).equals("tel"))
              {
                localObject1 = paramString;
                if (this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.containsKey(this.jdField_b_of_type_JavaLangString))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.get(this.jdField_b_of_type_JavaLangString));
                  ((StringBuilder)localObject1).append(";");
                  ((StringBuilder)localObject1).append(paramString);
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.put(this.jdField_b_of_type_JavaLangString, localObject1);
              }
              else if (((String)localObject3).equals("adr"))
              {
                localObject1 = paramString;
                if (this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.containsKey(this.e))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.get(this.e));
                  ((StringBuilder)localObject1).append(";");
                  ((StringBuilder)localObject1).append(paramString);
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.put(this.e, localObject1);
              }
              else if (((String)localObject3).equals("email"))
              {
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.f.put(this.k, paramString);
              }
              else if (((String)localObject3).equals("org"))
              {
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.e.put(this.j, paramString);
              }
              else if (((String)localObject3).equals("url"))
              {
                if (localObject1.length > 2)
                {
                  paramString = new StringBuilder();
                  i1 = 1;
                  while (i1 < localObject1.length)
                  {
                    paramString.append(localObject1[i1]);
                    if (i1 != localObject1.length - 1) {
                      paramString.append(":");
                    }
                    i1 += 1;
                  }
                  paramString = paramString.toString();
                }
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.d.put(this.h, paramString);
              }
              else if (((String)localObject3).equals("note"))
              {
                if (localObject1.length > 2)
                {
                  paramString = new StringBuilder();
                  i1 = 1;
                  while (i1 < localObject1.length)
                  {
                    paramString.append(localObject1[i1]);
                    if (i1 != localObject1.length - 1) {
                      paramString.append(":");
                    }
                    i1 += 1;
                  }
                  paramString = paramString.toString();
                }
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.a.put(this.i, paramString);
              }
              else if (((String)localObject3).equals("nickname"))
              {
                this.jdField_a_of_type_JavaLangString = paramString;
              }
            }
          }
          paramInt += 1;
        }
      }
      return;
    }
    Object localObject5;
    Object localObject4;
    if (paramInt == 1)
    {
      if (paramString.length() <= 21) {
        return;
      }
      boolean bool = paramString.contains("\n");
      localObject2 = "\r\n";
      if (bool) {
        localObject2 = "\n";
      } else if (paramString.contains("\r")) {
        localObject2 = "\r";
      } else {
        if (!paramString.contains("\r\n")) {
          break label1926;
        }
      }
      paramString = paramString.substring(11, paramString.length() - 9);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = paramString.split((String)localObject2);
        if (localObject1 == null) {
          return;
        }
        paramInt = 0;
        while (paramInt < localObject1.length)
        {
          if (localObject1[paramInt].contains(":"))
          {
            localObject5 = localObject1[paramInt].split(":");
            if ((localObject5 != null) && (localObject5.length > 1) && (!TextUtils.isEmpty(localObject5[0])) && (!TextUtils.isEmpty(localObject5[1])))
            {
              localObject3 = localObject5[0].toLowerCase().trim();
              paramString = localObject5[1].trim();
              if (((((String)localObject3).equals("n")) || (((String)localObject3).equals("fn"))) && (TextUtils.isEmpty(this.m)))
              {
                if (paramString.contains(";"))
                {
                  localObject3 = paramString.split(";");
                  if ((localObject3 != null) && (localObject3.length > 0))
                  {
                    int i2 = localObject3.length;
                    i1 = 0;
                    while (i1 < i2)
                    {
                      localObject4 = localObject3[i1];
                      localObject5 = new StringBuilder();
                      ((StringBuilder)localObject5).append(paramString);
                      ((StringBuilder)localObject5).append(" ");
                      ((StringBuilder)localObject5).append((String)localObject4);
                      paramString = ((StringBuilder)localObject5).toString();
                      i1 += 1;
                    }
                  }
                  else
                  {
                    paramString = "";
                  }
                }
                this.m = paramString;
              }
              else
              {
                localObject4 = localObject1;
                if (((String)localObject3).equals("title"))
                {
                  this.n = paramString;
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).startsWith("photo"))
                {
                  if (localObject5.length > 2)
                  {
                    paramString = new StringBuilder();
                    i1 = 1;
                    while (i1 < localObject5.length)
                    {
                      paramString.append(localObject5[i1]);
                      if (i1 != localObject5.length - 1) {
                        paramString.append(":");
                      }
                      i1 += 1;
                    }
                    paramString = paramString.toString();
                  }
                  this.l = paramString;
                  this.jdField_b_of_type_Boolean = true;
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).equals("nickname"))
                {
                  this.jdField_a_of_type_JavaLangString = paramString;
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).startsWith("tel"))
                {
                  if (((String)localObject3).contains("home")) {
                    localObject1 = this.jdField_c_of_type_JavaLangString;
                  } else if (((String)localObject3).contains("work")) {
                    localObject1 = this.d;
                  } else {
                    localObject1 = this.jdField_b_of_type_JavaLangString;
                  }
                  localObject3 = paramString;
                  if ("tel".equals(paramString))
                  {
                    localObject3 = paramString;
                    if (localObject5.length > 2) {
                      localObject3 = localObject5[2];
                    }
                  }
                  paramString = (String)localObject3;
                  if (this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.containsKey(localObject1))
                  {
                    paramString = new StringBuilder();
                    paramString.append((String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.get(localObject1));
                    paramString.append(";");
                    paramString.append((String)localObject3);
                    paramString = paramString.toString();
                  }
                  this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.put(localObject1, paramString);
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).contains("adr"))
                {
                  if (((String)localObject3).contains("home")) {
                    localObject1 = this.f;
                  } else if (((String)localObject3).contains("work")) {
                    localObject1 = this.g;
                  } else {
                    localObject1 = this.e;
                  }
                  localObject3 = paramString;
                  if (paramString.contains(";;"))
                  {
                    localObject3 = new StringBuilder();
                    paramString = paramString.substring(2);
                    if (TextUtils.isEmpty(paramString))
                    {
                      localObject1 = localObject4;
                    }
                    else
                    {
                      paramString = paramString.split(";");
                      if (paramString == null)
                      {
                        localObject1 = localObject4;
                      }
                      else
                      {
                        i1 = 0;
                        while (i1 < paramString.length)
                        {
                          if (!TextUtils.isEmpty(paramString[i1]))
                          {
                            ((StringBuilder)localObject3).append(paramString[i1]);
                            if (i1 != paramString.length - 1) {
                              ((StringBuilder)localObject3).append((String)localObject2);
                            }
                          }
                          i1 += 1;
                        }
                        localObject3 = ((StringBuilder)localObject3).toString();
                      }
                    }
                  }
                  else
                  {
                    paramString = (String)localObject3;
                    if (this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.containsKey(localObject1))
                    {
                      paramString = new StringBuilder();
                      paramString.append((String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.get(localObject1));
                      paramString.append(";");
                      paramString.append((String)localObject3);
                      paramString = paramString.toString();
                    }
                    this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.put(localObject1, paramString);
                    localObject1 = localObject4;
                  }
                }
                else if (((String)localObject3).equals("email"))
                {
                  this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.f.put(this.k, paramString);
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).equals("org"))
                {
                  this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.e.put(this.j, paramString);
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).equals("url"))
                {
                  if (localObject5.length > 2)
                  {
                    paramString = new StringBuilder();
                    i1 = 1;
                    while (i1 < localObject5.length)
                    {
                      paramString.append(localObject5[i1]);
                      if (i1 != localObject5.length - 1) {
                        paramString.append(":");
                      }
                      i1 += 1;
                    }
                    paramString = paramString.toString();
                  }
                  this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.d.put(this.h, paramString);
                  localObject1 = localObject4;
                }
                else
                {
                  localObject1 = localObject4;
                  if (((String)localObject3).equals("note"))
                  {
                    if (localObject5.length > 2)
                    {
                      paramString = new StringBuilder();
                      i1 = 1;
                      while (i1 < localObject5.length)
                      {
                        paramString.append(localObject5[i1]);
                        if (i1 != localObject5.length - 1) {
                          paramString.append(":");
                        }
                        i1 += 1;
                      }
                      paramString = paramString.toString();
                    }
                    this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.a.put(this.i, paramString);
                    localObject1 = localObject4;
                  }
                }
              }
            }
          }
          paramInt += 1;
        }
      }
      label1926:
      return;
    }
    if (paramString.length() <= 10) {
      return;
    }
    paramString = paramString.substring(8, paramString.length() - 2);
    if (!TextUtils.isEmpty(paramString))
    {
      localObject5 = paramString.split(";");
      if (localObject5 == null) {
        return;
      }
      localObject2 = null;
      localObject1 = localObject2;
      paramInt = 0;
      while (paramInt < localObject5.length)
      {
        if (localObject5[paramInt].contains(":"))
        {
          paramString = localObject5[paramInt].split(":");
          if (paramString != null)
          {
            if (paramString.length > 1)
            {
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (TextUtils.isEmpty(paramString[0])) {
                break label2480;
              }
              if (TextUtils.isEmpty(paramString[1]))
              {
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              String str = paramString[0].toLowerCase().trim();
              paramString = paramString[1].trim();
              if (str.equals("x"))
              {
                localObject3 = paramString;
                localObject4 = localObject1;
                break label2480;
              }
              if (str.equals("n"))
              {
                localObject3 = localObject2;
                localObject4 = paramString;
                break label2480;
              }
              if (str.equals("t"))
              {
                this.n = paramString;
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              if (str.equals("b"))
              {
                localObject3 = paramString;
                if (this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.containsKey(this.jdField_b_of_type_JavaLangString))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append((String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.get(this.jdField_b_of_type_JavaLangString));
                  ((StringBuilder)localObject3).append(";");
                  ((StringBuilder)localObject3).append(paramString);
                  localObject3 = ((StringBuilder)localObject3).toString();
                }
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.c.put(this.jdField_b_of_type_JavaLangString, localObject3);
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              if (str.equals("a"))
              {
                localObject3 = paramString;
                if (this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.containsKey(this.e))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append((String)this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.get(this.e));
                  ((StringBuilder)localObject3).append(";");
                  ((StringBuilder)localObject3).append(paramString);
                  localObject3 = ((StringBuilder)localObject3).toString();
                }
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.b.put(this.e, localObject3);
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              if (str.equals("e"))
              {
                this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.f.put(this.k, paramString);
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (!str.equals("c")) {
                break label2480;
              }
              this.jdField_a_of_type_ComTencentMobileqqQrscanQRCard.e.put(this.j, paramString);
              localObject3 = localObject2;
              localObject4 = localObject1;
              break label2480;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            break label2480;
          }
        }
        localObject4 = localObject1;
        localObject3 = localObject2;
        label2480:
        paramInt += 1;
        localObject2 = localObject3;
        localObject1 = localObject4;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject2);
          paramString.append(" ");
          paramString.append((String)localObject1);
          this.m = paramString.toString();
          return;
        }
        this.m = ((String)localObject2);
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.m = ((String)localObject1);
      }
    }
  }
  
  protected void a(Intent paramIntent, HashMap<String, String> paramHashMap)
  {
    paramIntent.putExtra("job_title", this.n);
    paramIntent.putExtra("name", this.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      String[] arrayOfString = str2.split(";");
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        if (str1.equals(this.j))
        {
          paramIntent.putExtra("company", str2);
        }
        else if (str1.equals(this.k))
        {
          paramIntent.putExtra("email", str2);
        }
        else if (str1.contains(this.jdField_b_of_type_JavaLangString))
        {
          paramIntent.putExtra("phone", arrayOfString[0]);
          if (str1.contains(this.jdField_c_of_type_JavaLangString)) {
            paramIntent.putExtra("phone_type", 1);
          } else if (str1.contains(this.d)) {
            paramIntent.putExtra("phone_type", 3);
          } else {
            paramIntent.putExtra("phone_type", 7);
          }
          if (arrayOfString.length > 1)
          {
            paramIntent.putExtra("secondary_phone", arrayOfString[1]);
            if (str1.contains(this.jdField_c_of_type_JavaLangString)) {
              paramIntent.putExtra("phone_type", 1);
            } else if (str1.contains(this.d)) {
              paramIntent.putExtra("phone_type", 3);
            } else {
              paramIntent.putExtra("phone_type", 7);
            }
          }
        }
      }
    }
    try
    {
      startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      label315:
      break label315;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_QrcodeScannerCard", 2, "Intent.ACTION_INSERT or ACTION_INSERT_OR_EDIT do not exist");
    }
  }
  
  protected void a(String paramString)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(2131716701);
    localQQCustomDialog.setMessage(paramString);
    QRCardActivity.5 local5 = new QRCardActivity.5(this);
    localQQCustomDialog.setPositiveButton(2131694583, new QRCardActivity.6(this, paramString));
    localQQCustomDialog.setNegativeButton(2131690728, local5);
    localQQCustomDialog.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131367060) {
      a(null, 4, null, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131560444);
    this.jdField_a_of_type_MqqAppAppRuntime = getAppRuntime();
    paramBundle = super.getIntent();
    a();
    String str = paramBundle.getStringExtra("QRCARDSTR");
    a(paramBundle.getIntExtra("CARDMODE", 3), str);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localActionSheet != null) {
      localActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity
 * JD-Core Version:    0.7.0.1
 */