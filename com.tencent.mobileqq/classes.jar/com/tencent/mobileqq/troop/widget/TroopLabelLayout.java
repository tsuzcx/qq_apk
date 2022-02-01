package com.tencent.mobileqq.troop.widget;

import NearbyGroup.GroupLabel;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TroopLabelLayout
  extends ViewGroup
{
  static final SparseIntArray d = new SparseIntArray();
  int a = 5;
  int b = 0;
  TextView c;
  boolean e = false;
  ArrayList<GroupLabel> f = new ArrayList();
  Runnable g = new TroopLabelLayout.1(this);
  boolean h;
  private String i = "TroopLabelLayout";
  private Map<Integer, TroopLabelTextView> j;
  private Drawable k = null;
  
  static
  {
    d.put(1, 1);
    d.put(4, 2);
    d.put(8, 3);
    d.put(7, 4);
    d.put(6, 5);
    d.put(5, 6);
    d.put(3, 8);
    d.put(2, 9);
    d.put(101, 10);
  }
  
  public TroopLabelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public TroopLabelTextView a(int paramInt)
  {
    Map localMap = this.j;
    if (localMap == null) {
      return null;
    }
    if (localMap.containsKey(Integer.valueOf(paramInt))) {
      return (TroopLabelTextView)this.j.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean a(ArrayList<GroupLabel> paramArrayList)
  {
    synchronized (this.f)
    {
      this.f.clear();
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        ??? = new HashMap();
        int i2 = paramArrayList.size();
        int m = 0;
        int n = 0;
        for (;;)
        {
          ??? = ???;
          if (m < i2)
          {
            ??? = ???;
            if (n < this.a)
            {
              GroupLabel localGroupLabel = (GroupLabel)paramArrayList.get(m);
              int i1;
              int i3;
              if (TextUtils.isEmpty(localGroupLabel.strWording))
              {
                ??? = ???;
                i1 = n;
              }
              else if (localGroupLabel.type == 2001L)
              {
                ??? = ???;
                i1 = n;
              }
              else
              {
                i3 = this.b;
                i1 = 2;
                if ((i3 < 2) && (localGroupLabel.type >= 1000L) && (localGroupLabel.type < 2000L))
                {
                  ??? = ???;
                  i1 = n;
                }
                else if ((this.b == 2) && (localGroupLabel.type < 1000L))
                {
                  ??? = ???;
                  i1 = n;
                }
              }
              synchronized (this.f)
              {
                this.f.add(localGroupLabel);
                Object localObject3;
                if ((!this.h) && (localGroupLabel.type == 4L))
                {
                  localObject3 = this.c;
                  ??? = ???;
                  i1 = n;
                  if (localObject3 != null)
                  {
                    ((TextView)localObject3).setText(localGroupLabel.strWording);
                    ??? = ???;
                    i1 = n;
                  }
                }
                else
                {
                  localObject3 = a(n);
                  i3 = android.graphics.Color.rgb((int)localGroupLabel.edging_color.R, (int)localGroupLabel.edging_color.G, (int)localGroupLabel.edging_color.B);
                  int i4 = android.graphics.Color.rgb((int)localGroupLabel.text_color.R, (int)localGroupLabel.text_color.G, (int)localGroupLabel.text_color.B);
                  if (localObject3 == null)
                  {
                    ??? = new TroopLabelTextView(getContext(), i3, i4, this.b);
                    if (n < this.a)
                    {
                      addView((View)???);
                      setTroopLabel(n, (TroopLabelTextView)???);
                    }
                    else
                    {
                      ??? = ???;
                      break;
                    }
                  }
                  else
                  {
                    ((TroopLabelTextView)localObject3).setColor(i3, i4);
                    ??? = localObject3;
                    if (QLog.isColorLevel())
                    {
                      QLog.d(this.i, 2, "labeltextview cache");
                      ??? = localObject3;
                    }
                  }
                  ((TroopLabelTextView)???).bringToFront();
                  if (this.b == 2)
                  {
                    i3 = ViewUtils.dip2px(42.0F);
                    i4 = ViewUtils.dip2px(16.0F);
                    ((TroopLabelTextView)???).setWidth(i3);
                    ((TroopLabelTextView)???).setHeight(i4);
                    ((TroopLabelTextView)???).setMaskImage(2130844954);
                    if (localGroupLabel.strWording.length() < 2) {
                      i1 = 1;
                    }
                    localGroupLabel.strWording = localGroupLabel.strWording.substring(0, i1);
                  }
                  if (localGroupLabel.type == 1L)
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("[icon]");
                    ((StringBuilder)localObject3).append(" ");
                    ((StringBuilder)localObject3).append(localGroupLabel.strWording);
                    localObject3 = new SpannableString(((StringBuilder)localObject3).toString());
                    if (this.k == null) {
                      if (this.b == 0) {
                        this.k = getContext().getResources().getDrawable(2130853363);
                      } else {
                        this.k = getContext().getResources().getDrawable(2130844951);
                      }
                    }
                    double d1 = ((TroopLabelTextView)???).getTextSize();
                    Double.isNaN(d1);
                    i1 = (int)(d1 * 0.8D + 0.5D);
                    this.k.setBounds(0, 0, i1, i1);
                    ((SpannableString)localObject3).setSpan(new ImageSpan(this.k, 1), 0, 6, 17);
                    ((TroopLabelTextView)???).setText((CharSequence)localObject3);
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append(localGroupLabel.strWording);
                    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131912736));
                    ((TroopLabelTextView)???).setContentDescription(((StringBuilder)localObject3).toString());
                  }
                  else
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append(localGroupLabel.strWording);
                    ((StringBuilder)localObject3).append("");
                    ((TroopLabelTextView)???).setText(((StringBuilder)localObject3).toString());
                    ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording);
                  }
                  ((TroopLabelTextView)???).setVisibility(0);
                  ((Map)???).put(Integer.valueOf(n), Boolean.valueOf(true));
                  i1 = n + 1;
                  ??? = ???;
                }
                m += 1;
                ??? = ???;
                n = i1;
              }
            }
          }
        }
        setLabelsUnVisible((Map)???);
        ((Map)???).clear();
      }
      return true;
    }
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  public boolean a(List<RecommendLabel> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList != null) {
        m = paramList.size();
      } else {
        m = 0;
      }
      int n;
      int i1;
      if ((paramInt1 != 0) && (paramInt1 != 1))
      {
        n = 0;
        i1 = m;
      }
      else
      {
        i1 = m + 1;
        n = 1;
      }
      removeAllViews();
      int m = 0;
      int i3;
      for (int i2 = 0; (m < i1) && (i2 < this.a); i2 = i3)
      {
        Object localObject;
        TroopLabelTextView localTroopLabelTextView;
        if ((n != 0) && (m == 0))
        {
          if (paramInt2 > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[icon]");
            ((StringBuilder)localObject).append(" ");
            ((StringBuilder)localObject).append(paramInt2);
            ((StringBuilder)localObject).append("");
            localObject = ((StringBuilder)localObject).toString();
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[icon]");
            ((StringBuilder)localObject).append(" ");
            localObject = ((StringBuilder)localObject).toString();
          }
          localObject = new SpannableString((CharSequence)localObject);
          if (paramInt1 == 0)
          {
            i3 = android.graphics.Color.rgb(0, 202, 252);
            this.k = getContext().getResources().getDrawable(2130847525);
          }
          else
          {
            i3 = android.graphics.Color.rgb(255, 128, 191);
            this.k = getContext().getResources().getDrawable(2130847523);
          }
          localTroopLabelTextView = new TroopLabelTextView(getContext(), i3, -1, this.b);
          if (i2 >= this.a) {
            break;
          }
          addView(localTroopLabelTextView);
          double d1 = localTroopLabelTextView.getTextSize();
          Double.isNaN(d1);
          i3 = (int)(d1 * 0.8D + 0.5D);
          this.k.setBounds(0, 0, i3, i3);
          ((SpannableString)localObject).setSpan(new ImageSpan(this.k, 1), 0, 6, 17);
          localTroopLabelTextView.setText((CharSequence)localObject);
        }
        else
        {
          if (n != 0) {
            i4 = m - 1;
          } else {
            i4 = m;
          }
          i3 = i2;
          if (paramList == null) {
            break label575;
          }
          i3 = i2;
          if (paramList.size() <= i4) {
            break label575;
          }
          localObject = (RecommendLabel)paramList.get(i4);
          i3 = ((RecommendLabel)localObject).edging_color;
          int i4 = ((RecommendLabel)localObject).text_color;
          localTroopLabelTextView = new TroopLabelTextView(getContext(), i3, i4, this.b);
          if (i2 >= this.a) {
            break;
          }
          addView(localTroopLabelTextView);
          localTroopLabelTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTroopLabelTextView.bringToFront();
          if (((RecommendLabel)localObject).bytes_name != null)
          {
            localTroopLabelTextView.setText(((RecommendLabel)localObject).bytes_name);
            localTroopLabelTextView.setContentDescription(((RecommendLabel)localObject).bytes_name);
            if (((n != 0) && (m == 1)) || ((n == 0) && (m == 0))) {
              localTroopLabelTextView.setMaxWidth(ViewUtils.dip2px(150.0F));
            }
          }
          else
          {
            localTroopLabelTextView.setText("");
            localTroopLabelTextView.setContentDescription("");
          }
        }
        i3 = i2 + 1;
        label575:
        m += 1;
      }
      if (i1 == 0)
      {
        setVisibility(8);
        return true;
      }
      setVisibility(0);
      return true;
    }
    return false;
  }
  
  public boolean a(List<RecommendLabel> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt3;
    if (paramList != null) {
      paramInt3 = paramList.size();
    } else {
      paramInt3 = 0;
    }
    int m;
    int n;
    if ((paramInt2 != 0) && (paramInt2 != 1))
    {
      m = 0;
      n = paramInt3;
    }
    else
    {
      n = paramInt3 + 1;
      m = 1;
    }
    removeAllViews();
    paramInt3 = 0;
    int i2;
    for (int i1 = 0; (paramInt3 < n) && (i1 < this.a); i1 = i2)
    {
      Object localObject;
      TroopLabelTextView localTroopLabelTextView;
      if ((m != 0) && (paramInt3 == 0))
      {
        if (paramInt1 > 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[icon]");
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[icon]");
          ((StringBuilder)localObject).append(" ");
          localObject = ((StringBuilder)localObject).toString();
        }
        localObject = new SpannableString((CharSequence)localObject);
        if (paramInt2 == 0)
        {
          i2 = android.graphics.Color.rgb(0, 202, 252);
          this.k = getContext().getResources().getDrawable(2130847525);
        }
        else
        {
          i2 = android.graphics.Color.rgb(255, 128, 191);
          this.k = getContext().getResources().getDrawable(2130847523);
        }
        localTroopLabelTextView = new TroopLabelTextView(getContext(), i2, -1, this.b);
        if (i1 >= this.a) {
          break;
        }
        addView(localTroopLabelTextView);
        double d1 = localTroopLabelTextView.getTextSize();
        Double.isNaN(d1);
        i2 = (int)(d1 * 0.8D + 0.5D);
        this.k.setBounds(0, 0, i2, i2);
        ((SpannableString)localObject).setSpan(new ImageSpan(this.k, 1), 0, 6, 17);
        localTroopLabelTextView.setText((CharSequence)localObject);
      }
      else
      {
        if (m != 0) {
          i3 = paramInt3 - 1;
        } else {
          i3 = paramInt3;
        }
        i2 = i1;
        if (paramList == null) {
          break label565;
        }
        i2 = i1;
        if (paramList.size() <= i3) {
          break label565;
        }
        localObject = (RecommendLabel)paramList.get(i3);
        i2 = ((RecommendLabel)localObject).edging_color;
        int i3 = ((RecommendLabel)localObject).text_color;
        localTroopLabelTextView = new TroopLabelTextView(getContext(), i2, i3, this.b);
        if (i1 >= this.a) {
          break;
        }
        addView(localTroopLabelTextView);
        localTroopLabelTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTroopLabelTextView.bringToFront();
        if (((RecommendLabel)localObject).bytes_name != null)
        {
          localTroopLabelTextView.setText(((RecommendLabel)localObject).bytes_name);
          localTroopLabelTextView.setContentDescription(((RecommendLabel)localObject).bytes_name);
          if (((m != 0) && (paramInt3 == 1)) || ((m == 0) && (paramInt3 == 0))) {
            localTroopLabelTextView.setMaxWidth(ViewUtils.dip2px(150.0F));
          }
        }
        else
        {
          localTroopLabelTextView.setText("");
          localTroopLabelTextView.setContentDescription("");
        }
      }
      i2 = i1 + 1;
      label565:
      paramInt3 += 1;
    }
    if (n == 0)
    {
      setVisibility(8);
      return true;
    }
    setVisibility(0);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = (int)DisplayUtils.a(getContext(), 2.0F);
    int i2 = getChildCount();
    paramInt4 = getPaddingLeft();
    int i3 = getPaddingTop();
    paramInt2 = 0;
    while (paramInt2 < i2)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        int i4 = localView.getMeasuredWidth();
        int i5 = localView.getMeasuredHeight();
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        int i6 = paramInt4 + i4;
        if (i6 > paramInt3 - paramInt1 - m - n)
        {
          if (this.e) {
            post(this.g);
          }
          return;
        }
        int i7 = localLayoutParams.rightMargin;
        localView.layout(paramInt4, i3, i6, i5 + i3);
        paramInt4 = i4 + i1 + i7 + paramInt4;
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    paramInt2 = n;
    if (i2 != -2147483648) {
      if (i2 != 0)
      {
        paramInt2 = n;
        if (i2 != 1073741824) {
          paramInt2 = 0;
        }
      }
      else
      {
        paramInt2 = 0;
        paramInt1 = 0;
        while (paramInt2 < getChildCount())
        {
          paramInt1 += getChildAt(paramInt2).getWidth();
          paramInt2 += 1;
        }
        if (paramInt1 > n) {
          paramInt2 = n;
        } else {
          paramInt2 = paramInt1;
        }
      }
    }
    paramInt1 = m;
    if (i1 != -2147483648)
    {
      paramInt1 = m;
      if (i1 != 1073741824) {
        if (getChildCount() > 0)
        {
          View localView = getChildAt(0);
          m = 0 + (getPaddingBottom() + getPaddingTop());
          paramInt1 = m;
          if (localView != null) {
            paramInt1 = m + localView.getMeasuredHeight();
          }
        }
        else
        {
          paramInt1 = 0;
        }
      }
    }
    super.setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setAutoCreateDistanceTextView(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setDistanceTextView(TextView paramTextView)
  {
    this.c = paramTextView;
  }
  
  public void setLabelType(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setLabelsUnVisible(Map<Integer, Boolean> paramMap)
  {
    Object localObject = this.j;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!paramMap.containsKey(localEntry.getKey())) {
        ((TroopLabelTextView)localEntry.getValue()).setVisibility(8);
      }
    }
  }
  
  public void setMaxLabelCount(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setTroopLabel(int paramInt, TroopLabelTextView paramTroopLabelTextView)
  {
    if (this.j == null) {
      this.j = new HashMap();
    }
    if (!this.j.containsKey(Integer.valueOf(paramInt))) {
      this.j.put(Integer.valueOf(paramInt), paramTroopLabelTextView);
    }
  }
  
  public void setmIsNeedPriority(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelLayout
 * JD-Core Version:    0.7.0.1
 */