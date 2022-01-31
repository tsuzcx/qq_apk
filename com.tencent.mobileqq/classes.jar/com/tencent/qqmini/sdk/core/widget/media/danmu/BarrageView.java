package com.tencent.qqmini.sdk.core.widget.media.danmu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bdkh;
import bdki;
import bdkj;
import bdkk;
import bdyn;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BarrageView
  extends RelativeLayout
  implements Comparator<bdki>
{
  private int jdField_a_of_type_Int = 500;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private final SparseArray<Animation> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<bdki> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private final Set<Animation> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 10;
  private final List<bdki> jdField_b_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 15;
  private int d = 15;
  private int e = 15;
  private int f = 15;
  private int g = 18;
  private int h = 18;
  private int i = 24;
  private int j = -16777216;
  private int k = -1;
  
  public BarrageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (a(paramContext, this.i) < this.g) {
      this.g = a(paramContext, this.i);
    }
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  private Animation a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    Animation localAnimation = bdkh.a(getContext(), paramInt, -bdyn.a(getContext()));
    localAnimation.setAnimationListener(paramAnimationListener);
    localAnimation.setDuration(3000L);
    return localAnimation;
  }
  
  private TextView a(bdki parambdki, int paramInt1, int paramInt2)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setPadding(this.c, this.e, this.d, this.f);
    localTextView.setTextSize(paramInt1);
    localTextView.setText(parambdki.jdField_a_of_type_JavaLangString);
    localTextView.setTextColor(parambdki.jdField_a_of_type_Int);
    parambdki = new RelativeLayout.LayoutParams(-2, -2);
    parambdki.addRule(10);
    parambdki.topMargin = paramInt2;
    Log.i("BarrageView", "createTextByBarrage: " + paramInt2);
    localTextView.setLayoutParams(parambdki);
    return localTextView;
  }
  
  private void a(TextView paramTextView, Animation paramAnimation)
  {
    paramTextView.startAnimation(paramAnimation);
    addView(paramTextView);
  }
  
  private void a(List<Integer> paramList)
  {
    Log.i("BarrageView", "showBarrage: " + Arrays.toString(paramList.toArray()));
    int n = getRight() - getLeft() - getPaddingLeft();
    int i1 = this.h;
    paramList = paramList.iterator();
    int m = 10;
    TextView localTextView;
    Animation localAnimation;
    while (paramList.hasNext())
    {
      int i2 = ((Integer)paramList.next()).intValue();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i2) == null)
      {
        localTextView = a((bdki)this.jdField_a_of_type_JavaUtilList.get(i2), i1, m);
        localAnimation = a(n, new bdkj(this, localTextView, i2));
        a(localTextView, localAnimation);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i2, localAnimation);
        m = i1 * 3 + m;
      }
    }
    paramList = this.jdField_b_of_type_JavaUtilList.iterator();
    while (paramList.hasNext())
    {
      localTextView = a((bdki)paramList.next(), i1, m);
      m += i1 * 3;
      localAnimation = a(n, new bdkk(this, localTextView));
      a(localTextView, localAnimation);
      this.jdField_a_of_type_JavaUtilSet.add(localAnimation);
    }
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public int a(bdki parambdki1, bdki parambdki2)
  {
    if (parambdki1.jdField_a_of_type_Long < parambdki2.jdField_a_of_type_Long) {
      return -1;
    }
    if (parambdki1.jdField_a_of_type_Long == parambdki2.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int m = 0;
    while (m < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((Animation)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(m)).cancel();
      m += 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((Animation)localIterator.next()).cancel();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.k = -1;
  }
  
  public void a(long paramLong)
  {
    if ((paramLong < 0L) || (paramLong == this.jdField_a_of_type_Long)) {
      return;
    }
    if (paramLong < this.jdField_a_of_type_Long) {
      this.k = -1;
    }
    LinkedList localLinkedList = new LinkedList();
    int m = this.k + 1;
    for (;;)
    {
      long l;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        l = ((bdki)this.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_Long * 1000L;
        if (l <= paramLong) {}
      }
      else
      {
        this.jdField_a_of_type_Long = paramLong;
        if ((localLinkedList.size() <= 0) && (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
          break;
        }
        a(localLinkedList);
        return;
      }
      this.k += 1;
      if (paramLong - l < 400L) {
        localLinkedList.add(Integer.valueOf(m));
      }
      m += 1;
    }
  }
  
  public void a(bdki parambdki)
  {
    this.jdField_b_of_type_JavaUtilList.add(parambdki);
  }
  
  public void setBarrages(List<bdki> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      Collections.sort(paramList, this);
    } while (this.jdField_a_of_type_JavaUtilList.equals(paramList));
    a();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.danmu.BarrageView
 * JD-Core Version:    0.7.0.1
 */