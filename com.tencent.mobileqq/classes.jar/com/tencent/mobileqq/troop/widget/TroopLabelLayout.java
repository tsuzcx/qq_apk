package com.tencent.mobileqq.troop.widget;

import NearbyGroup.GroupLabel;
import actj;
import ajya;
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
import bbdv;
import bbll;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
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
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return null;
    }
    return (TroopLabelTextView)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public boolean a(MayKnowRecommend paramMayKnowRecommend)
  {
    int i;
    int m;
    if (paramMayKnowRecommend != null)
    {
      i = 0;
      if (paramMayKnowRecommend.msgLabel != null) {
        i = paramMayKnowRecommend.msgLabel.size();
      }
      if ((paramMayKnowRecommend.gender != 0) && (paramMayKnowRecommend.gender != 1)) {
        break label545;
      }
      m = 1;
    }
    for (int k = i + 1;; k = i)
    {
      int j = 0;
      removeAllViews();
      i = 0;
      Object localObject;
      label118:
      TroopLabelTextView localTroopLabelTextView;
      if ((i < k) && (j < this.jdField_a_of_type_Int))
      {
        if ((m != 0) && (i == 0))
        {
          if (paramMayKnowRecommend.age > 0)
          {
            localObject = "[icon]" + " " + paramMayKnowRecommend.age + "";
            localObject = new SpannableString((CharSequence)localObject);
            if (paramMayKnowRecommend.gender != 0) {
              break label296;
            }
            n = android.graphics.Color.rgb(0, 202, 252);
          }
          for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130845021);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130845019))
          {
            localTroopLabelTextView = new TroopLabelTextView(getContext(), n, -1, this.jdField_b_of_type_Int);
            if (j >= this.jdField_a_of_type_Int) {
              break label515;
            }
            addView(localTroopLabelTextView);
            n = (int)(localTroopLabelTextView.getTextSize() * 0.8D + 0.5D);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, n, n);
            ((SpannableString)localObject).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, "[icon]".length(), 17);
            localTroopLabelTextView.setText((CharSequence)localObject);
            j += 1;
            label264:
            i += 1;
            break;
            localObject = "[icon]" + " ";
            break label118;
            label296:
            n = android.graphics.Color.rgb(255, 128, 191);
          }
        }
        if (m == 0) {
          break label539;
        }
      }
      label515:
      label539:
      for (int n = i - 1;; n = i)
      {
        if ((paramMayKnowRecommend.msgLabel != null) && (paramMayKnowRecommend.msgLabel.size() > n))
        {
          localObject = (MayKnowRecommend.MayKnowRecommendLabel)paramMayKnowRecommend.msgLabel.get(n);
          n = ((MayKnowRecommend.MayKnowRecommendLabel)localObject).edging_color;
          int i1 = ((MayKnowRecommend.MayKnowRecommendLabel)localObject).text_color;
          localTroopLabelTextView = new TroopLabelTextView(getContext(), n, i1, this.jdField_b_of_type_Int);
          if (j < this.jdField_a_of_type_Int)
          {
            addView(localTroopLabelTextView);
            localTroopLabelTextView.setEllipsize(TextUtils.TruncateAt.END);
            localTroopLabelTextView.bringToFront();
            if (((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name != null)
            {
              localTroopLabelTextView.setText(((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name);
              localTroopLabelTextView.setContentDescription(((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name);
              if (((m == 0) || (i != 1)) && ((m != 0) || (i != 0))) {
                break;
              }
              localTroopLabelTextView.setMaxWidth(bbll.a(150.0F));
              break;
            }
            localTroopLabelTextView.setText("");
            localTroopLabelTextView.setContentDescription("");
            break;
          }
          if (k == 0) {
            setVisibility(8);
          }
          for (;;)
          {
            return true;
            setVisibility(0);
          }
        }
        break label264;
      }
      label545:
      m = 0;
    }
  }
  
  public boolean a(ArrayList<GroupLabel> paramArrayList)
  {
    label357:
    label752:
    label765:
    label767:
    for (;;)
    {
      HashMap localHashMap;
      int i;
      GroupLabel localGroupLabel;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
          break label765;
        }
        localHashMap = new HashMap();
        int m = paramArrayList.size();
        i = 0;
        int j = 0;
        if ((j >= m) || (i >= this.jdField_a_of_type_Int)) {
          break label752;
        }
        localGroupLabel = (GroupLabel)paramArrayList.get(j);
        if (TextUtils.isEmpty(localGroupLabel.strWording)) {
          j += 1;
        }
      }
      if ((localGroupLabel.type != 2001L) && ((this.jdField_b_of_type_Int >= 2) || (localGroupLabel.type < 1000L) || (localGroupLabel.type >= 2000L)) && ((this.jdField_b_of_type_Int != 2) || (localGroupLabel.type >= 1000L)))
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localGroupLabel);
          if ((!this.jdField_b_of_type_Boolean) && (localGroupLabel.type == 4L))
          {
            if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
              break label767;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(localGroupLabel.strWording);
          }
        }
        Object localObject2 = a(i);
        int k = android.graphics.Color.rgb((int)localGroupLabel.edging_color.R, (int)localGroupLabel.edging_color.G, (int)localGroupLabel.edging_color.B);
        int n = android.graphics.Color.rgb((int)localGroupLabel.text_color.R, (int)localGroupLabel.text_color.G, (int)localGroupLabel.text_color.B);
        if (localObject2 == null)
        {
          ??? = new TroopLabelTextView(getContext(), k, n, this.jdField_b_of_type_Int);
          if (i >= this.jdField_a_of_type_Int) {
            break label752;
          }
          addView((View)???);
          setTroopLabel(i, (TroopLabelTextView)???);
          ((TroopLabelTextView)???).bringToFront();
          if (this.jdField_b_of_type_Int == 2)
          {
            k = actj.a(42.0F, getResources());
            n = actj.a(16.0F, getResources());
            ((TroopLabelTextView)???).setWidth(k);
            ((TroopLabelTextView)???).setHeight(n);
            ((TroopLabelTextView)???).setMaskImage(2130843246);
            if (localGroupLabel.strWording.length() < 2) {
              break label685;
            }
            k = 2;
            localGroupLabel.strWording = localGroupLabel.strWording.substring(0, k);
          }
          if (localGroupLabel.type != 1L) {
            break label711;
          }
          localObject2 = new SpannableString("[icon]" + " " + localGroupLabel.strWording);
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            if (this.jdField_b_of_type_Int != 0) {
              break label691;
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130849596);
          }
          k = (int)(((TroopLabelTextView)???).getTextSize() * 0.8D + 0.5D);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, k, k);
          ((SpannableString)localObject2).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, "[icon]".length(), 17);
          ((TroopLabelTextView)???).setText((CharSequence)localObject2);
          ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording + ajya.a(2131715484));
        }
        for (;;)
        {
          ((TroopLabelTextView)???).setVisibility(0);
          localHashMap.put(Integer.valueOf(i), Boolean.valueOf(true));
          i += 1;
          break;
          ((TroopLabelTextView)localObject2).setColor(k, n);
          ??? = localObject2;
          if (!QLog.isColorLevel()) {
            break label357;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "labeltextview cache");
          ??? = localObject2;
          break label357;
          k = 1;
          break label431;
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130843244);
          break label525;
          ((TroopLabelTextView)???).setText(localGroupLabel.strWording + "");
          ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording);
        }
        setLabelsUnVisible(localHashMap);
        localHashMap.clear();
        return true;
      }
    }
  }
  
  public boolean a(List<MayKnowRecommend.MayKnowRecommendLabel> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt3;
    paramInt3 = 0;
    if (paramList != null) {
      paramInt3 = paramList.size();
    }
    int k;
    if ((paramInt2 == 0) || (paramInt2 == 1)) {
      k = 1;
    }
    for (int j = paramInt3 + 1;; j = paramInt3)
    {
      int i = 0;
      removeAllViews();
      paramInt3 = 0;
      Object localObject;
      label110:
      TroopLabelTextView localTroopLabelTextView;
      if ((paramInt3 < j) && (i < this.jdField_a_of_type_Int))
      {
        if ((k != 0) && (paramInt3 == 0))
        {
          if (paramInt1 > 0)
          {
            localObject = "[icon]" + " " + paramInt1 + "";
            localObject = new SpannableString((CharSequence)localObject);
            if (paramInt2 != 0) {
              break label290;
            }
            m = android.graphics.Color.rgb(0, 202, 252);
          }
          for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130845021);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130845019))
          {
            localTroopLabelTextView = new TroopLabelTextView(getContext(), m, -1, this.jdField_b_of_type_Int);
            if (i >= this.jdField_a_of_type_Int) {
              break label504;
            }
            addView(localTroopLabelTextView);
            m = (int)(localTroopLabelTextView.getTextSize() * 0.8D + 0.5D);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, m, m);
            ((SpannableString)localObject).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, "[icon]".length(), 17);
            localTroopLabelTextView.setText((CharSequence)localObject);
            i += 1;
            label256:
            paramInt3 += 1;
            break;
            localObject = "[icon]" + " ";
            break label110;
            label290:
            m = android.graphics.Color.rgb(255, 128, 191);
          }
        }
        if (k == 0) {
          break label528;
        }
      }
      label528:
      for (int m = paramInt3 - 1;; m = paramInt3)
      {
        if ((paramList != null) && (paramList.size() > m))
        {
          localObject = (MayKnowRecommend.MayKnowRecommendLabel)paramList.get(m);
          m = ((MayKnowRecommend.MayKnowRecommendLabel)localObject).edging_color;
          int n = ((MayKnowRecommend.MayKnowRecommendLabel)localObject).text_color;
          localTroopLabelTextView = new TroopLabelTextView(getContext(), m, n, this.jdField_b_of_type_Int);
          if (i < this.jdField_a_of_type_Int)
          {
            addView(localTroopLabelTextView);
            localTroopLabelTextView.setEllipsize(TextUtils.TruncateAt.END);
            localTroopLabelTextView.bringToFront();
            if (((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name != null)
            {
              localTroopLabelTextView.setText(((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name);
              localTroopLabelTextView.setContentDescription(((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name);
              if (((k == 0) || (paramInt3 != 1)) && ((k != 0) || (paramInt3 != 0))) {
                break;
              }
              localTroopLabelTextView.setMaxWidth(bbll.a(150.0F));
              break;
            }
            localTroopLabelTextView.setText("");
            localTroopLabelTextView.setContentDescription("");
            break;
          }
          label504:
          if (j == 0) {
            setVisibility(8);
          }
          for (;;)
          {
            return true;
            setVisibility(0);
          }
        }
        break label256;
      }
      k = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = (int)bbdv.a(getContext(), 2.0F);
    int n = getChildCount();
    paramInt2 = getPaddingLeft();
    int i1 = getPaddingTop();
    paramInt4 = 0;
    View localView;
    if (paramInt4 < n)
    {
      localView = getChildAt(paramInt4);
      if (localView.getVisibility() != 8) {}
    }
    for (;;)
    {
      paramInt4 += 1;
      break;
      int i2 = localView.getMeasuredWidth();
      int i3 = localView.getMeasuredHeight();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (paramInt2 + i2 > paramInt3 - paramInt1 - j - k)
      {
        if (this.jdField_a_of_type_Boolean) {
          post(this.jdField_a_of_type_JavaLangRunnable);
        }
        return;
      }
      int i = localLayoutParams.rightMargin + (m + i2) + paramInt2;
      localView.layout(paramInt2, i1, i2 + paramInt2, i3 + i1);
      paramInt2 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    super.onMeasure(paramInt1, paramInt2);
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    View localView;
    switch (n)
    {
    default: 
      paramInt1 = 0;
      switch (m)
      {
      default: 
        paramInt2 = j;
        if (getChildCount() > 0)
        {
          localView = getChildAt(0);
          i = 0 + (getPaddingBottom() + getPaddingTop());
          paramInt2 = i;
          if (localView == null) {}
        }
        break;
      }
      break;
    }
    for (paramInt2 = i + localView.getMeasuredHeight();; paramInt2 = k)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = i;
      break;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt1 < getChildCount())
      {
        paramInt2 += getChildAt(paramInt1).getWidth();
        paramInt1 += 1;
      }
      paramInt1 = paramInt2;
      if (paramInt2 <= i) {
        break;
      }
      paramInt1 = i;
      break;
    }
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
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!paramMap.containsKey(localEntry.getKey())) {
          ((TroopLabelTextView)localEntry.getValue()).setVisibility(8);
        }
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