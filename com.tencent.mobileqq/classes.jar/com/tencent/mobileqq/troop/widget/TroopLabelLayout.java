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
  static final SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  int jdField_a_of_type_Int = 5;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new TroopLabelLayout.1(this);
  private String jdField_a_of_type_JavaLangString = "TroopLabelLayout";
  ArrayList<GroupLabel> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<Integer, TroopLabelTextView> jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 1);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(4, 2);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(8, 3);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(7, 4);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(6, 5);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(5, 6);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 8);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 9);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(101, 10);
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
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap == null) {
      return null;
    }
    if (localMap.containsKey(Integer.valueOf(paramInt))) {
      return (TroopLabelTextView)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean a(ArrayList<GroupLabel> paramArrayList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        ??? = new HashMap();
        int m = paramArrayList.size();
        int i = 0;
        int j = 0;
        for (;;)
        {
          ??? = ???;
          if (i < m)
          {
            ??? = ???;
            if (j < this.jdField_a_of_type_Int)
            {
              GroupLabel localGroupLabel = (GroupLabel)paramArrayList.get(i);
              int k;
              int n;
              if (TextUtils.isEmpty(localGroupLabel.strWording))
              {
                ??? = ???;
                k = j;
              }
              else if (localGroupLabel.type == 2001L)
              {
                ??? = ???;
                k = j;
              }
              else
              {
                n = this.jdField_b_of_type_Int;
                k = 2;
                if ((n < 2) && (localGroupLabel.type >= 1000L) && (localGroupLabel.type < 2000L))
                {
                  ??? = ???;
                  k = j;
                }
                else if ((this.jdField_b_of_type_Int == 2) && (localGroupLabel.type < 1000L))
                {
                  ??? = ???;
                  k = j;
                }
              }
              synchronized (this.jdField_a_of_type_JavaUtilArrayList)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(localGroupLabel);
                Object localObject3;
                if ((!this.jdField_b_of_type_Boolean) && (localGroupLabel.type == 4L))
                {
                  localObject3 = this.jdField_a_of_type_AndroidWidgetTextView;
                  ??? = ???;
                  k = j;
                  if (localObject3 != null)
                  {
                    ((TextView)localObject3).setText(localGroupLabel.strWording);
                    ??? = ???;
                    k = j;
                  }
                }
                else
                {
                  localObject3 = a(j);
                  n = android.graphics.Color.rgb((int)localGroupLabel.edging_color.R, (int)localGroupLabel.edging_color.G, (int)localGroupLabel.edging_color.B);
                  int i1 = android.graphics.Color.rgb((int)localGroupLabel.text_color.R, (int)localGroupLabel.text_color.G, (int)localGroupLabel.text_color.B);
                  if (localObject3 == null)
                  {
                    ??? = new TroopLabelTextView(getContext(), n, i1, this.jdField_b_of_type_Int);
                    if (j < this.jdField_a_of_type_Int)
                    {
                      addView((View)???);
                      setTroopLabel(j, (TroopLabelTextView)???);
                    }
                    else
                    {
                      ??? = ???;
                      break;
                    }
                  }
                  else
                  {
                    ((TroopLabelTextView)localObject3).setColor(n, i1);
                    ??? = localObject3;
                    if (QLog.isColorLevel())
                    {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "labeltextview cache");
                      ??? = localObject3;
                    }
                  }
                  ((TroopLabelTextView)???).bringToFront();
                  if (this.jdField_b_of_type_Int == 2)
                  {
                    n = ViewUtils.a(42.0F);
                    i1 = ViewUtils.a(16.0F);
                    ((TroopLabelTextView)???).setWidth(n);
                    ((TroopLabelTextView)???).setHeight(i1);
                    ((TroopLabelTextView)???).setMaskImage(2130843999);
                    if (localGroupLabel.strWording.length() < 2) {
                      k = 1;
                    }
                    localGroupLabel.strWording = localGroupLabel.strWording.substring(0, k);
                  }
                  if (localGroupLabel.type == 1L)
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("[icon]");
                    ((StringBuilder)localObject3).append(" ");
                    ((StringBuilder)localObject3).append(localGroupLabel.strWording);
                    localObject3 = new SpannableString(((StringBuilder)localObject3).toString());
                    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                      if (this.jdField_b_of_type_Int == 0) {
                        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130851128);
                      } else {
                        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130843996);
                      }
                    }
                    double d = ((TroopLabelTextView)???).getTextSize();
                    Double.isNaN(d);
                    k = (int)(d * 0.8D + 0.5D);
                    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, k, k);
                    ((SpannableString)localObject3).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, 6, 17);
                    ((TroopLabelTextView)???).setText((CharSequence)localObject3);
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append(localGroupLabel.strWording);
                    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131715254));
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
                  ((Map)???).put(Integer.valueOf(j), Boolean.valueOf(true));
                  k = j + 1;
                  ??? = ???;
                }
                i += 1;
                ??? = ???;
                j = k;
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
        i = paramList.size();
      } else {
        i = 0;
      }
      int j;
      int k;
      if ((paramInt1 != 0) && (paramInt1 != 1))
      {
        j = 0;
        k = i;
      }
      else
      {
        k = i + 1;
        j = 1;
      }
      removeAllViews();
      int i = 0;
      int n;
      for (int m = 0; (i < k) && (m < this.jdField_a_of_type_Int); m = n)
      {
        Object localObject;
        TroopLabelTextView localTroopLabelTextView;
        if ((j != 0) && (i == 0))
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
            n = android.graphics.Color.rgb(0, 202, 252);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846055);
          }
          else
          {
            n = android.graphics.Color.rgb(255, 128, 191);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846053);
          }
          localTroopLabelTextView = new TroopLabelTextView(getContext(), n, -1, this.jdField_b_of_type_Int);
          if (m >= this.jdField_a_of_type_Int) {
            break;
          }
          addView(localTroopLabelTextView);
          double d = localTroopLabelTextView.getTextSize();
          Double.isNaN(d);
          n = (int)(d * 0.8D + 0.5D);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, n, n);
          ((SpannableString)localObject).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, 6, 17);
          localTroopLabelTextView.setText((CharSequence)localObject);
        }
        else
        {
          if (j != 0) {
            i1 = i - 1;
          } else {
            i1 = i;
          }
          n = m;
          if (paramList == null) {
            break label575;
          }
          n = m;
          if (paramList.size() <= i1) {
            break label575;
          }
          localObject = (RecommendLabel)paramList.get(i1);
          n = ((RecommendLabel)localObject).edging_color;
          int i1 = ((RecommendLabel)localObject).text_color;
          localTroopLabelTextView = new TroopLabelTextView(getContext(), n, i1, this.jdField_b_of_type_Int);
          if (m >= this.jdField_a_of_type_Int) {
            break;
          }
          addView(localTroopLabelTextView);
          localTroopLabelTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTroopLabelTextView.bringToFront();
          if (((RecommendLabel)localObject).bytes_name != null)
          {
            localTroopLabelTextView.setText(((RecommendLabel)localObject).bytes_name);
            localTroopLabelTextView.setContentDescription(((RecommendLabel)localObject).bytes_name);
            if (((j != 0) && (i == 1)) || ((j == 0) && (i == 0))) {
              localTroopLabelTextView.setMaxWidth(ViewUtils.a(150.0F));
            }
          }
          else
          {
            localTroopLabelTextView.setText("");
            localTroopLabelTextView.setContentDescription("");
          }
        }
        n = m + 1;
        label575:
        i += 1;
      }
      if (k == 0)
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
    this.jdField_b_of_type_Int = paramInt3;
    if (paramList != null) {
      paramInt3 = paramList.size();
    } else {
      paramInt3 = 0;
    }
    int i;
    int j;
    if ((paramInt2 != 0) && (paramInt2 != 1))
    {
      i = 0;
      j = paramInt3;
    }
    else
    {
      j = paramInt3 + 1;
      i = 1;
    }
    removeAllViews();
    paramInt3 = 0;
    int m;
    for (int k = 0; (paramInt3 < j) && (k < this.jdField_a_of_type_Int); k = m)
    {
      Object localObject;
      TroopLabelTextView localTroopLabelTextView;
      if ((i != 0) && (paramInt3 == 0))
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
          m = android.graphics.Color.rgb(0, 202, 252);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846055);
        }
        else
        {
          m = android.graphics.Color.rgb(255, 128, 191);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846053);
        }
        localTroopLabelTextView = new TroopLabelTextView(getContext(), m, -1, this.jdField_b_of_type_Int);
        if (k >= this.jdField_a_of_type_Int) {
          break;
        }
        addView(localTroopLabelTextView);
        double d = localTroopLabelTextView.getTextSize();
        Double.isNaN(d);
        m = (int)(d * 0.8D + 0.5D);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, m, m);
        ((SpannableString)localObject).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, 6, 17);
        localTroopLabelTextView.setText((CharSequence)localObject);
      }
      else
      {
        if (i != 0) {
          n = paramInt3 - 1;
        } else {
          n = paramInt3;
        }
        m = k;
        if (paramList == null) {
          break label565;
        }
        m = k;
        if (paramList.size() <= n) {
          break label565;
        }
        localObject = (RecommendLabel)paramList.get(n);
        m = ((RecommendLabel)localObject).edging_color;
        int n = ((RecommendLabel)localObject).text_color;
        localTroopLabelTextView = new TroopLabelTextView(getContext(), m, n, this.jdField_b_of_type_Int);
        if (k >= this.jdField_a_of_type_Int) {
          break;
        }
        addView(localTroopLabelTextView);
        localTroopLabelTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTroopLabelTextView.bringToFront();
        if (((RecommendLabel)localObject).bytes_name != null)
        {
          localTroopLabelTextView.setText(((RecommendLabel)localObject).bytes_name);
          localTroopLabelTextView.setContentDescription(((RecommendLabel)localObject).bytes_name);
          if (((i != 0) && (paramInt3 == 1)) || ((i == 0) && (paramInt3 == 0))) {
            localTroopLabelTextView.setMaxWidth(ViewUtils.a(150.0F));
          }
        }
        else
        {
          localTroopLabelTextView.setText("");
          localTroopLabelTextView.setContentDescription("");
        }
      }
      m = k + 1;
      label565:
      paramInt3 += 1;
    }
    if (j == 0)
    {
      setVisibility(8);
      return true;
    }
    setVisibility(0);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int k = (int)DisplayUtils.a(getContext(), 2.0F);
    int m = getChildCount();
    paramInt4 = getPaddingLeft();
    int n = getPaddingTop();
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        int i3 = paramInt4 + i1;
        if (i3 > paramInt3 - paramInt1 - i - j)
        {
          if (this.jdField_a_of_type_Boolean) {
            post(this.jdField_a_of_type_JavaLangRunnable);
          }
          return;
        }
        int i4 = localLayoutParams.rightMargin;
        localView.layout(paramInt4, n, i3, i2 + n);
        paramInt4 = i1 + k + i4 + paramInt4;
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    paramInt2 = j;
    if (m != -2147483648) {
      if (m != 0)
      {
        paramInt2 = j;
        if (m != 1073741824) {
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
        if (paramInt1 > j) {
          paramInt2 = j;
        } else {
          paramInt2 = paramInt1;
        }
      }
    }
    paramInt1 = i;
    if (k != -2147483648)
    {
      paramInt1 = i;
      if (k != 1073741824) {
        if (getChildCount() > 0)
        {
          View localView = getChildAt(0);
          i = 0 + (getPaddingBottom() + getPaddingTop());
          paramInt1 = i;
          if (localView != null) {
            paramInt1 = i + localView.getMeasuredHeight();
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
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setDistanceTextView(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void setLabelType(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setLabelsUnVisible(Map<Integer, Boolean> paramMap)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
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
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setTroopLabel(int paramInt, TroopLabelTextView paramTroopLabelTextView)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramTroopLabelTextView);
    }
  }
  
  public void setmIsNeedPriority(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelLayout
 * JD-Core Version:    0.7.0.1
 */