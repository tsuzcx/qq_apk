package com.tencent.mobileqq.troop.widget;

import NearbyGroup.GroupLabel;
import ajtz;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TroopLabelLayout
  extends ViewGroup
{
  public static final SparseIntArray a;
  int jdField_a_of_type_Int = 5;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new ajtz(this);
  private String jdField_a_of_type_JavaLangString = "TroopLabelLayout";
  public ArrayList a;
  private Map jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
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
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopLabelTextView a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return null;
    }
    return (TroopLabelTextView)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    label350:
    label739:
    label752:
    label754:
    for (;;)
    {
      HashMap localHashMap;
      int i;
      GroupLabel localGroupLabel;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
          break label752;
        }
        localHashMap = new HashMap();
        int m = paramArrayList.size();
        i = 0;
        int j = 0;
        if ((j >= m) || (i >= this.jdField_a_of_type_Int)) {
          break label739;
        }
        localGroupLabel = (GroupLabel)paramArrayList.get(j);
        if (TextUtils.isEmpty(localGroupLabel.strWording)) {
          j += 1;
        }
      }
      if ((localGroupLabel.type != 2001L) && ((this.b >= 2) || (localGroupLabel.type < 1000L) || (localGroupLabel.type >= 2000L)) && ((this.b != 2) || (localGroupLabel.type >= 1000L)))
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localGroupLabel);
          if (localGroupLabel.type == 4L)
          {
            if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
              break label754;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(localGroupLabel.strWording);
          }
        }
        Object localObject2 = a(i);
        int k = android.graphics.Color.rgb((int)localGroupLabel.edging_color.R, (int)localGroupLabel.edging_color.G, (int)localGroupLabel.edging_color.B);
        int n = android.graphics.Color.rgb((int)localGroupLabel.text_color.R, (int)localGroupLabel.text_color.G, (int)localGroupLabel.text_color.B);
        if (localObject2 == null)
        {
          ??? = new TroopLabelTextView(getContext(), k, n, this.b);
          if (i >= this.jdField_a_of_type_Int) {
            break label739;
          }
          addView((View)???);
          setTroopLabel(i, (TroopLabelTextView)???);
          ((TroopLabelTextView)???).bringToFront();
          if (this.b == 2)
          {
            k = AIOUtils.a(42.0F, getResources());
            n = AIOUtils.a(16.0F, getResources());
            ((TroopLabelTextView)???).setWidth(k);
            ((TroopLabelTextView)???).setHeight(n);
            ((TroopLabelTextView)???).setMaskImage(2130841446);
            if (localGroupLabel.strWording.length() < 2) {
              break label671;
            }
            k = 2;
            localGroupLabel.strWording = localGroupLabel.strWording.substring(0, k);
          }
          if (localGroupLabel.type != 1L) {
            break label697;
          }
          localObject2 = new SpannableString("[icon]" + " " + localGroupLabel.strWording);
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            if (this.b != 0) {
              break label677;
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846297);
          }
          k = (int)(((TroopLabelTextView)???).getTextSize() * 0.8D + 0.5D);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, k, k);
          ((SpannableString)localObject2).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, "[icon]".length(), 17);
          ((TroopLabelTextView)???).setText((CharSequence)localObject2);
          ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording + "人");
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
            break label350;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "labeltextview cache");
          ??? = localObject2;
          break label350;
          k = 1;
          break label421;
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130841440);
          break label514;
          ((TroopLabelTextView)???).setText(localGroupLabel.strWording + "");
          ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording);
        }
        setLabelsUnVisible(localHashMap);
        localHashMap.clear();
        return true;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = (int)DisplayUtils.a(getContext(), 2.0F);
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
  
  public void setDistanceTextView(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void setLabelType(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setLabelsUnVisible(Map paramMap)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelLayout
 * JD-Core Version:    0.7.0.1
 */