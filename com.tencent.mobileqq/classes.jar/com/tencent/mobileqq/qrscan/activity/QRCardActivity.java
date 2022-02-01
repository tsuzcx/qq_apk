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
  protected static String E = "((?:(?i)https?://|www\\.|[a-zA-Z0-9]+\\.)[a-zA-Z0-9\\-.]+(?::(\\d+))?(?:(?:/[a-zA-Z0-9\\-._?,'+\\\\&%$=~*!;#():@\\\\]*)+)?)";
  protected ActionSheet A;
  protected Resources B;
  protected boolean C = false;
  protected String D = null;
  protected Handler F = new QRCardActivity.1(this);
  private AppRuntime G;
  private View.OnLongClickListener H = new QRCardActivity.8(this);
  protected boolean a = false;
  protected boolean b = false;
  protected LinearLayout c;
  protected ImageView d;
  protected TextView e;
  protected TextView f;
  protected TextView g;
  protected Button h;
  protected QRCard i;
  protected float j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected String p;
  protected String q;
  protected String r;
  protected String s;
  protected String t;
  protected String u;
  protected String v;
  protected String w;
  protected String x;
  protected Thread y;
  protected int z;
  
  public static QQCustomMenuNoIconLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    QQCustomMenuItemPriorityHelper.a(paramQQCustomMenu);
    paramContext = new QQCustomMenuNoIconLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow, null);
    paramContext.setMenu(paramQQCustomMenu);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.c();
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
    this.A = ((ActionSheet)ActionSheetHelper.b(this, null));
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
      String str = this.B.getString(2131917791);
      this.A.addButton(str, 0);
      str = this.B.getString(2131917789);
      this.A.addButton(str, 0);
    }
    if (paramInt == 0)
    {
      arrayOfBoolean[1] = true;
      this.A.addButton(this.B.getString(2131888562), 1);
    }
    if (paramInt == 4)
    {
      arrayOfBoolean[2] = true;
      this.A.addButton(this.B.getString(2131886316), 1);
      this.A.addButton(this.B.getString(2131886312), 1);
    }
    if (paramInt == 3)
    {
      arrayOfBoolean[3] = true;
      this.A.addButton(2131888562, 1);
      this.A.addButton(2131888244, 1);
      this.A.addButton(2131886219, 1);
      this.A.addButton(2131891071, 1);
      this.A.setMainTitle(String.format(paramContext.getString(2131892237), new Object[] { paramString1 }));
    }
    this.A.setOnButtonClickListener(new QRCardActivity.3(this, arrayOfBoolean, paramString2, paramContext, paramString1));
    this.A.addCancelButton(2131887648);
    this.A.setOnDismissListener(new QRCardActivity.4(this));
    if (!this.A.isShowing())
    {
      this.C = false;
      this.A.show();
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater localLayoutInflater = super.getLayoutInflater();
    Object localObject7 = Integer.valueOf(0);
    if (paramInt == 0) {
      i1 = this.i.c.size();
    }
    for (int i2 = this.i.b.size();; i2 = this.i.a.size())
    {
      i1 += i2;
      break label102;
      if (paramInt != 1) {
        break;
      }
      i1 = this.i.e.size() + this.i.f.size() + this.i.d.size();
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
      boolean bool = this.i.c.isEmpty();
      localObject2 = ";";
      Object localObject8;
      Object localObject6;
      int i3;
      int i4;
      int i5;
      if (!bool)
      {
        localObject8 = this.i.c.keySet().iterator();
        paramInt = 0;
        label458:
        while (((Iterator)localObject8).hasNext())
        {
          localObject5 = (String)((Iterator)localObject8).next();
          String str = (String)this.i.c.get(localObject5);
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
                  localObject1 = localLayoutInflater.inflate(2131626482, (ViewGroup)localObject1);
                  ((View)localObject1).setTag(localObject7);
                  localObject4 = (TextView)((View)localObject1).findViewById(2131431322);
                  ((TextView)((View)localObject1).findViewById(2131447463)).setText((CharSequence)localObject5);
                  ((TextView)localObject4).setText((CharSequence)localObject3);
                  a(paramInt, i1, (View)localObject1, paramViewGroup, 1);
                  paramInt += 1;
                  i5 += 1;
                  localObject1 = null;
                }
              }
              localObject3 = localLayoutInflater.inflate(2131626482, (ViewGroup)localObject1);
              ((View)localObject3).setTag(localObject7);
              localObject4 = (TextView)((View)localObject3).findViewById(2131431322);
              ((TextView)((View)localObject3).findViewById(2131447463)).setText((CharSequence)localObject5);
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
      if (!this.i.b.isEmpty())
      {
        localObject3 = this.i.b.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject6 = (String)this.i.b.get(localObject4);
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
                localObject7 = localLayoutInflater.inflate(2131626481, (ViewGroup)localObject2);
                localObject8 = (TextView)((View)localObject7).findViewById(2131431322);
                ((TextView)((View)localObject7).findViewById(2131447463)).setText((CharSequence)localObject4);
                ((TextView)localObject8).setText((CharSequence)localObject6);
                a(i3, i4, (View)localObject7, paramViewGroup, 0);
                i3 += 1;
                i2 += 1;
              }
            }
            localObject5 = localLayoutInflater.inflate(2131626481, (ViewGroup)localObject2);
            localObject7 = (TextView)((View)localObject5).findViewById(2131431322);
            ((TextView)((View)localObject5).findViewById(2131447463)).setText((CharSequence)localObject4);
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
      if (!this.i.f.isEmpty())
      {
        localObject1 = this.u;
        localObject2 = (String)this.i.f.get(this.u);
        localObject3 = localLayoutInflater.inflate(2131626482, null);
        ((View)localObject3).setTag(Integer.valueOf(2));
        localObject4 = (TextView)((View)localObject3).findViewById(2131431322);
        ((TextView)((View)localObject3).findViewById(2131447463)).setText((CharSequence)localObject1);
        ((TextView)localObject4).setText((CharSequence)localObject2);
        a(0, i1, (View)localObject3, paramViewGroup, 1);
        paramInt = 1;
      }
      else
      {
        paramInt = 0;
      }
      i2 = paramInt;
      if (!this.i.e.isEmpty())
      {
        localObject1 = this.t;
        localObject2 = (String)this.i.e.get(this.t);
        localObject3 = localLayoutInflater.inflate(2131626481, null);
        localObject4 = (TextView)((View)localObject3).findViewById(2131431322);
        ((TextView)((View)localObject3).findViewById(2131447463)).setText((CharSequence)localObject1);
        ((TextView)localObject4).setText((CharSequence)localObject2);
        a(paramInt, i1, (View)localObject3, paramViewGroup, 0);
        i2 = paramInt + 1;
      }
      if (!this.i.d.isEmpty())
      {
        localObject1 = this.r;
        localObject2 = (String)this.i.d.get(this.r);
        if (Pattern.compile(E).matcher((CharSequence)localObject2).matches())
        {
          localObject3 = localLayoutInflater.inflate(2131626482, null);
          ((View)localObject3).setTag(Integer.valueOf(1));
          localObject4 = (TextView)((View)localObject3).findViewById(2131431322);
          ((TextView)((View)localObject3).findViewById(2131447463)).setText((CharSequence)localObject1);
          ((TextView)localObject4).setText((CharSequence)localObject2);
          a(i2, i1, (View)localObject3, paramViewGroup, 1);
        }
        else
        {
          localObject3 = localLayoutInflater.inflate(2131626481, null);
          localObject4 = (TextView)((View)localObject3).findViewById(2131431322);
          ((TextView)((View)localObject3).findViewById(2131447463)).setText((CharSequence)localObject1);
          ((TextView)localObject4).setText((CharSequence)localObject2);
          a(i2, i1, (View)localObject3, paramViewGroup, 0);
        }
      }
      if (!this.i.a.isEmpty())
      {
        localObject1 = localLayoutInflater.inflate(2131626481, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131431322);
        localObject3 = (TextView)((View)localObject1).findViewById(2131447463);
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject3).setText(this.s);
        localObject3 = (String)this.i.a.get(this.s);
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
        localObject5 = Pattern.compile(E).matcher((CharSequence)localObject3);
        while (((Matcher)localObject5).find())
        {
          paramInt = ((Matcher)localObject5).start();
          i2 = ((Matcher)localObject5).end();
          ((SpannableString)localObject4).setSpan(new QRCardActivity.NumberSpan(this, ((String)localObject3).toString().substring(paramInt, i2)), paramInt, i2, 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject4);
        if (i1 == 1) {
          ((View)localObject1).setBackgroundResource(2130839622);
        } else {
          ((View)localObject1).setBackgroundResource(2130839629);
        }
        paramViewGroup.addView((View)localObject1);
      }
    }
  }
  
  private void b()
  {
    super.setTitle(2131888474);
    this.d = ((ImageView)super.findViewById(2131435219));
    this.e = ((TextView)super.findViewById(2131447062));
    this.f = ((TextView)super.findViewById(2131449062));
    this.h = ((Button)super.findViewById(2131433513));
    this.g = ((TextView)super.findViewById(2131439320));
    this.h.setOnClickListener(this);
    this.c = ((LinearLayout)super.findViewById(2131435969));
    if (!TextUtils.isEmpty(this.w)) {
      this.e.setText(this.w);
    }
    TextView localTextView;
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(this.k))
    {
      if (!TextUtils.isEmpty(this.x))
      {
        localTextView = this.g;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.B.getString(2131917248));
        localStringBuilder.append(": ");
        localStringBuilder.append(this.x);
        localTextView.setText(localStringBuilder.toString());
      }
    }
    else
    {
      localTextView = this.g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.B.getString(2131892138));
      localStringBuilder.append(": ");
      localStringBuilder.append(this.k);
      localTextView.setText(localStringBuilder.toString());
      if (!TextUtils.isEmpty(this.x))
      {
        localTextView = this.f;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.B.getString(2131917248));
        localStringBuilder.append(": ");
        localStringBuilder.append(this.x);
        localTextView.setText(localStringBuilder.toString());
      }
    }
    boolean bool = AppNetConnInfo.isWifiConn();
    if ((this.b) && (bool))
    {
      this.y = new Thread(new QRCardActivity.2(this));
      this.y.start();
    }
    c();
  }
  
  private void c()
  {
    this.c.removeAllViewsInLayout();
    ViewGroup localViewGroup1 = d();
    a(localViewGroup1, 0);
    ViewGroup localViewGroup2 = d();
    a(localViewGroup2, 1);
    this.c.addView(localViewGroup1);
    this.c.addView(localViewGroup2);
    this.c.requestLayout();
    this.c.invalidate();
  }
  
  private ViewGroup d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i1 = (int)(this.j * 5.0F);
    localLayoutParams.setMargins(0, i1, 0, i1 << 1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  public void a()
  {
    this.B = super.getResources();
    this.j = this.B.getDisplayMetrics().density;
    this.l = this.B.getString(2131917138);
    this.m = this.B.getString(2131890705);
    this.n = this.B.getString(2131918078);
    this.o = this.B.getString(2131886317);
    this.p = this.B.getString(2131890704);
    this.q = this.B.getString(2131918077);
    this.r = this.B.getString(2131917787);
    this.s = this.B.getString(2131892179);
    this.t = this.B.getString(2131892361);
    this.u = this.B.getString(2131888848);
    this.z = super.getResources().getColor(2131166388);
    this.i = new QRCard();
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, int paramInt3)
  {
    if (paramInt1 == 0) {
      paramView.setBackgroundResource(2130839638);
    } else if (paramInt1 == paramInt2 - 1) {
      paramView.setBackgroundResource(2130839629);
    } else {
      paramView.setBackgroundResource(2130839632);
    }
    if (paramInt2 == 1) {
      paramView.setBackgroundResource(2130839622);
    }
    if (paramInt3 == 1)
    {
      paramView.setOnClickListener(new QRCardActivity.7(this));
      paramView.setOnLongClickListener(this.H);
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
                this.w = paramString;
              }
              else if (((String)localObject3).equalsIgnoreCase("til"))
              {
                this.x = paramString;
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
                this.v = paramString;
                this.b = true;
              }
              else if (((String)localObject3).equals("tel"))
              {
                localObject1 = paramString;
                if (this.i.c.containsKey(this.l))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append((String)this.i.c.get(this.l));
                  ((StringBuilder)localObject1).append(";");
                  ((StringBuilder)localObject1).append(paramString);
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
                this.i.c.put(this.l, localObject1);
              }
              else if (((String)localObject3).equals("adr"))
              {
                localObject1 = paramString;
                if (this.i.b.containsKey(this.o))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append((String)this.i.b.get(this.o));
                  ((StringBuilder)localObject1).append(";");
                  ((StringBuilder)localObject1).append(paramString);
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
                this.i.b.put(this.o, localObject1);
              }
              else if (((String)localObject3).equals("email"))
              {
                this.i.f.put(this.u, paramString);
              }
              else if (((String)localObject3).equals("org"))
              {
                this.i.e.put(this.t, paramString);
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
                this.i.d.put(this.r, paramString);
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
                this.i.a.put(this.s, paramString);
              }
              else if (((String)localObject3).equals("nickname"))
              {
                this.k = paramString;
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
              if (((((String)localObject3).equals("n")) || (((String)localObject3).equals("fn"))) && (TextUtils.isEmpty(this.w)))
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
                this.w = paramString;
              }
              else
              {
                localObject4 = localObject1;
                if (((String)localObject3).equals("title"))
                {
                  this.x = paramString;
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
                  this.v = paramString;
                  this.b = true;
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).equals("nickname"))
                {
                  this.k = paramString;
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).startsWith("tel"))
                {
                  if (((String)localObject3).contains("home")) {
                    localObject1 = this.m;
                  } else if (((String)localObject3).contains("work")) {
                    localObject1 = this.n;
                  } else {
                    localObject1 = this.l;
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
                  if (this.i.c.containsKey(localObject1))
                  {
                    paramString = new StringBuilder();
                    paramString.append((String)this.i.c.get(localObject1));
                    paramString.append(";");
                    paramString.append((String)localObject3);
                    paramString = paramString.toString();
                  }
                  this.i.c.put(localObject1, paramString);
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).contains("adr"))
                {
                  if (((String)localObject3).contains("home")) {
                    localObject1 = this.p;
                  } else if (((String)localObject3).contains("work")) {
                    localObject1 = this.q;
                  } else {
                    localObject1 = this.o;
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
                    if (this.i.b.containsKey(localObject1))
                    {
                      paramString = new StringBuilder();
                      paramString.append((String)this.i.b.get(localObject1));
                      paramString.append(";");
                      paramString.append((String)localObject3);
                      paramString = paramString.toString();
                    }
                    this.i.b.put(localObject1, paramString);
                    localObject1 = localObject4;
                  }
                }
                else if (((String)localObject3).equals("email"))
                {
                  this.i.f.put(this.u, paramString);
                  localObject1 = localObject4;
                }
                else if (((String)localObject3).equals("org"))
                {
                  this.i.e.put(this.t, paramString);
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
                  this.i.d.put(this.r, paramString);
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
                    this.i.a.put(this.s, paramString);
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
                this.x = paramString;
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              if (str.equals("b"))
              {
                localObject3 = paramString;
                if (this.i.c.containsKey(this.l))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append((String)this.i.c.get(this.l));
                  ((StringBuilder)localObject3).append(";");
                  ((StringBuilder)localObject3).append(paramString);
                  localObject3 = ((StringBuilder)localObject3).toString();
                }
                this.i.c.put(this.l, localObject3);
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              if (str.equals("a"))
              {
                localObject3 = paramString;
                if (this.i.b.containsKey(this.o))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append((String)this.i.b.get(this.o));
                  ((StringBuilder)localObject3).append(";");
                  ((StringBuilder)localObject3).append(paramString);
                  localObject3 = ((StringBuilder)localObject3).toString();
                }
                this.i.b.put(this.o, localObject3);
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              if (str.equals("e"))
              {
                this.i.f.put(this.u, paramString);
                localObject3 = localObject2;
                localObject4 = localObject1;
                break label2480;
              }
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (!str.equals("c")) {
                break label2480;
              }
              this.i.e.put(this.t, paramString);
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
          this.w = paramString.toString();
          return;
        }
        this.w = ((String)localObject2);
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.w = ((String)localObject1);
      }
    }
  }
  
  protected void a(Intent paramIntent, HashMap<String, String> paramHashMap)
  {
    paramIntent.putExtra("job_title", this.x);
    paramIntent.putExtra("name", this.e.getText().toString());
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      String[] arrayOfString = str2.split(";");
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        if (str1.equals(this.t))
        {
          paramIntent.putExtra("company", str2);
        }
        else if (str1.equals(this.u))
        {
          paramIntent.putExtra("email", str2);
        }
        else if (str1.contains(this.l))
        {
          paramIntent.putExtra("phone", arrayOfString[0]);
          if (str1.contains(this.m)) {
            paramIntent.putExtra("phone_type", 1);
          } else if (str1.contains(this.n)) {
            paramIntent.putExtra("phone_type", 3);
          } else {
            paramIntent.putExtra("phone_type", 7);
          }
          if (arrayOfString.length > 1)
          {
            paramIntent.putExtra("secondary_phone", arrayOfString[1]);
            if (str1.contains(this.m)) {
              paramIntent.putExtra("phone_type", 1);
            } else if (str1.contains(this.n)) {
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
    localQQCustomDialog.setTitle(2131914165);
    localQQCustomDialog.setMessage(paramString);
    QRCardActivity.5 local5 = new QRCardActivity.5(this);
    localQQCustomDialog.setPositiveButton(2131892267, new QRCardActivity.6(this, paramString));
    localQQCustomDialog.setNegativeButton(2131887648, local5);
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
    if (paramView.getId() == 2131433513) {
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
    super.setContentView(2131626489);
    this.G = getAppRuntime();
    paramBundle = super.getIntent();
    a();
    String str = paramBundle.getStringExtra("QRCARDSTR");
    a(paramBundle.getIntExtra("CARDMODE", 3), str);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.y != null)
    {
      this.a = true;
      this.F.removeMessages(0);
    }
    ActionSheet localActionSheet = this.A;
    if (localActionSheet != null) {
      localActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity
 * JD-Core Version:    0.7.0.1
 */