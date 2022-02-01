package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

public class QQCustomMenuImageLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static int a = 0;
  public static float b = 1.0F;
  public static int d = 5;
  public static int e = 45;
  public static int f = 53;
  public static int g = 90;
  public int c = 0;
  private ImageView h;
  private ImageView i;
  private int j = -1;
  private BubblePopupWindow k;
  private QQCustomMenu l;
  private int m = 0;
  private View.OnClickListener n;
  
  public QQCustomMenuImageLayout(Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
    this.c = (a - (int)(b * 10.0F));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("screenWidth:");
      paramContext.append(a);
      paramContext.append(" mDensity: ");
      paramContext.append(b);
      paramContext.append(" layoutMaxWidth A:");
      paramContext.append(this.c);
      QLog.d("QQCustomMenuImageLayout", 4, paramContext.toString());
    }
    this.m = 12;
    if (b >= 2.0F) {
      this.m = 20;
    }
  }
  
  private TextView a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    QQCustomMenuImageLayout.1 local1 = new QQCustomMenuImageLayout.1(this, getContext());
    local1.setText(paramQQCustomMenuItem.a());
    local1.setTextSize(10.0F);
    Resources localResources = getContext().getResources();
    local1.setMinimumWidth(90);
    local1.setMaxLines(1);
    Drawable localDrawable2;
    try
    {
      Drawable localDrawable1 = getContext().getResources().getDrawable(paramQQCustomMenuItem.c());
    }
    catch (RuntimeException localRuntimeException)
    {
      AIOUtils.a("QQCustomMenuImageLayout", "creatTextViewWithTopIcon ERR", localRuntimeException);
      localDrawable2 = null;
    }
    local1.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable2, null, null);
    local1.setCompoundDrawablePadding(0);
    int i1 = AIOUtils.b(9.0F, localResources);
    local1.setPadding(0, i1, 0, i1);
    local1.setContentDescription(paramQQCustomMenuItem.a());
    local1.setId(paramQQCustomMenuItem.b());
    local1.setTextColor(-855638017);
    local1.setBackgroundDrawable(null);
    local1.setIncludeFontPadding(true);
    local1.setOnClickListener(this.n);
    local1.setGravity(17);
    return local1;
  }
  
  private TextView b(int paramInt)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText("");
    localTextView.setTextSize(1.0F);
    localTextView.setWidth(paramInt);
    localTextView.setMaxLines(1);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setTextColor(-1);
    localTextView.setBackgroundDrawable(null);
    localTextView.setGravity(17);
    return localTextView;
  }
  
  private ImageView c()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(2130839075);
    localImageView.setContentDescription(HardCodeUtil.a(2131907862));
    localImageView.setBackgroundDrawable(null);
    localImageView.setOnClickListener(this);
    int i1 = this.m;
    float f1 = i1;
    float f2 = b;
    localImageView.setPadding((int)(f1 * f2), (int)(f2 * 10.0F), (int)(i1 * f2), (int)(f2 * 10.0F));
    return localImageView;
  }
  
  private int d()
  {
    int i4 = getChildCount();
    int i2 = 0;
    Object localObject;
    for (int i3 = 0; i2 < i4; i3 = i1)
    {
      localObject = getChildAt(i2);
      i1 = i3;
      if (localObject != null)
      {
        i1 = i3;
        if (((View)localObject).getVisibility() != 8)
        {
          TextView localTextView = (TextView)localObject;
          int i5 = (int)Layout.getDesiredWidth(localTextView.getText(), localTextView.getPaint());
          i3 += ((View)localObject).getPaddingLeft() + i5 + ((View)localObject).getPaddingRight();
          i1 = i3;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("child  TextView text ");
            localStringBuilder.append(localTextView.getText());
            localStringBuilder.append(" measureWidth = ");
            localStringBuilder.append(i5);
            localStringBuilder.append(" paddingL = ");
            localStringBuilder.append(((View)localObject).getPaddingLeft());
            localStringBuilder.append(" paddingR = ");
            localStringBuilder.append(((View)localObject).getPaddingRight());
            QLog.d("QQCustomMenuImageLayout", 4, localStringBuilder.toString());
            i1 = i3;
          }
        }
      }
      i2 += 1;
    }
    int i1 = d * 2 + i3;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("totalWidth   ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("QQCustomMenuImageLayout", 4, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  public void a()
  {
    removeAllViews();
    int i4 = this.l.b();
    int i1 = 0;
    while (i1 < i4)
    {
      Object localObject = a(this.l.a(i1));
      i2 = g;
      int i3 = e;
      if (i2 < i3)
      {
        i2 = i3;
      }
      else
      {
        i3 = f;
        if (i2 > i3) {
          i2 = i3;
        }
      }
      if (a(i2))
      {
        if (i1 == 6)
        {
          i2 = i1 - 1;
          removeViewAt(i2);
          this.i = c();
          localObject = new LinearLayout.LayoutParams(this.i.getPaddingLeft() + 22 + this.i.getPaddingRight(), -2);
          this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
          addView(this.i);
          break label293;
        }
        addView((View)localObject, new LinearLayout.LayoutParams(i2, -2, 0.0F));
        if (i1 == i4 - 1) {
          addView(b(d), new LinearLayout.LayoutParams(d, -2, 0.0F));
        }
        i1 += 1;
      }
      else
      {
        this.i = c();
        i2 = this.i.getPaddingLeft() + 22 + this.i.getPaddingRight();
        localObject = new LinearLayout.LayoutParams(i2, -2);
        this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (a(i2))
        {
          i2 = i1;
        }
        else
        {
          i2 = i1;
          if (i1 > 1)
          {
            i2 = i1 - 1;
            removeViewAt(i2);
          }
        }
        addView(this.i);
        break label293;
      }
    }
    int i2 = -1;
    label293:
    this.j = i2;
  }
  
  public boolean a(int paramInt)
  {
    return d() + paramInt <= this.c;
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public void b()
  {
    if (this.j >= 0)
    {
      removeAllViews();
      this.h = new ImageView(getContext());
      this.h.setImageResource(2130839068);
      this.h.setContentDescription(HardCodeUtil.a(2131907855));
      this.h.setBackgroundDrawable(null);
      this.h.setOnClickListener(this);
      Object localObject = this.h;
      int i1 = this.m;
      float f1 = i1;
      float f2 = b;
      ((ImageView)localObject).setPadding((int)(f1 * f2), (int)(f2 * 10.0F), (int)(i1 * f2), (int)(f2 * 10.0F));
      i1 = this.h.getPaddingLeft() + 22 + this.h.getPaddingRight();
      localObject = new LinearLayout.LayoutParams(i1, -2);
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.h);
      int i2 = i1 + 0;
      int i3 = this.j;
      while (i3 < this.l.b())
      {
        localObject = a(this.l.a(i3));
        i1 = g;
        int i4 = e;
        if (i1 < i4)
        {
          i1 = i4;
        }
        else
        {
          i4 = f;
          if (i1 > i4) {
            i1 = i4;
          }
        }
        addView((View)localObject, new LinearLayout.LayoutParams(i1, -2, 0.0F));
        i2 += i1;
        i3 += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("secondScreenWidth: ");
        ((StringBuilder)localObject).append(i2);
        QLog.d("QQCustomMenuImageLayout", 4, ((StringBuilder)localObject).toString());
      }
      i1 = a;
      if (i2 < i1 / 2)
      {
        i1 = i1 / 2 - i2;
        localObject = b(i1);
        ((TextView)localObject).setVisibility(4);
        addView((View)localObject, new LinearLayout.LayoutParams(i1, -2, 0.0F));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.h) {
      a();
    } else if (paramView == this.i) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setMenu(QQCustomMenu paramQQCustomMenu)
  {
    this.l = paramQQCustomMenu;
    if (QLog.isColorLevel())
    {
      paramQQCustomMenu = new StringBuilder();
      paramQQCustomMenu.append("MENU:");
      paramQQCustomMenu.append(this.l.toString());
      QLog.d("QQCustomMenuImageLayout", 4, paramQQCustomMenu.toString());
    }
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.n = paramOnClickListener;
  }
  
  public void setPopup(BubblePopupWindow paramBubblePopupWindow)
  {
    this.k = paramBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout
 * JD-Core Version:    0.7.0.1
 */