package com.tencent.mobileqq.campuscircle;

import abpz;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class TopicAdapter
  extends BaseAdapter
{
  final float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int;
  final Context jdField_a_of_type_AndroidContentContext;
  final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  final SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  CampusTopic jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic;
  final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  final int[] jdField_a_of_type_ArrayOfInt;
  final int[][] jdField_a_of_type_Array2dOfInt;
  final int jdField_b_of_type_Int;
  final HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  final int d;
  final int e;
  final int f;
  final int g;
  final int h;
  final int i;
  final int j;
  final int k;
  
  public TopicAdapter(Context paramContext, int paramInt)
  {
    this.k = paramInt;
    Resources localResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = localResources.getDimensionPixelSize(2131559406);
    this.jdField_b_of_type_Int = localResources.getDimensionPixelSize(2131559407);
    this.c = localResources.getColor(2131493376);
    this.d = localResources.getColor(2131493377);
    this.e = localResources.getColor(2131493380);
    this.f = localResources.getDimensionPixelSize(2131559408);
    this.g = localResources.getDimensionPixelSize(2131559411);
    this.h = localResources.getDimensionPixelSize(2131559409);
    this.i = localResources.getDimensionPixelSize(2131559404);
    this.j = localResources.getDimensionPixelSize(2131559405);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ArrayOfInt = new int[] { 16842919 };
    paramContext = StateSet.WILD_CARD;
    this.jdField_a_of_type_Array2dOfInt = new int[][] { { 16842919 }, paramContext };
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    if (QLog.isDevelopLevel()) {
      QLog.i("campuscircle", 4, String.format(Locale.getDefault(), "TopicAdapter iconSize: %d padding: %d", new Object[] { Integer.valueOf(this.f), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
  }
  
  public ColorStateList a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      ??? = (ColorStateList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = ???;
      if (??? == null) {
        ??? = new ColorStateList(this.jdField_a_of_type_Array2dOfInt, new int[] { 0x80FFFFFF & paramInt, paramInt });
      }
    }
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, ???);
      return ???;
      localObject4 = finally;
      throw localObject4;
    }
  }
  
  public StateListDrawable a(CampusTopic arg1, int paramInt)
  {
    String str = String.format(Locale.getDefault(), "%d-%s", new Object[] { Integer.valueOf(???.id), Integer.valueOf(paramInt) });
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      ??? = (StateListDrawable)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      ??? = (CampusTopic)???;
      if (??? == null)
      {
        ??? = new StateListDrawable();
        ??? = new GradientDrawable();
        ((GradientDrawable)???).setShape(0);
        ((GradientDrawable)???).setCornerRadius(this.jdField_a_of_type_Int);
        ((GradientDrawable)???).setColor(0x80FFFFFF & paramInt);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        localGradientDrawable.setCornerRadius(this.jdField_a_of_type_Int);
        localGradientDrawable.setColor(paramInt);
        ???.addState(this.jdField_a_of_type_ArrayOfInt, (Drawable)???);
        ???.addState(StateSet.WILD_CARD, localGradientDrawable);
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(str, ???);
      return ???;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public StateListDrawable a(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      ??? = (StateListDrawable)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
      ??? = ???;
      if (??? == null)
      {
        ??? = new abpz();
        ??? = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)???).mRequestWidth = this.f;
        ((URLDrawable.URLDrawableOptions)???).mRequestHeight = this.f;
        ((URLDrawable.URLDrawableOptions)???).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)???).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ??? = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)???);
        ((StateListDrawable)???).addState(this.jdField_a_of_type_ArrayOfInt, (Drawable)???);
        ((StateListDrawable)???).addState(StateSet.WILD_CARD, (Drawable)???);
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, ???);
      return ???;
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      return;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  public void a(View paramView, CampusTopic paramCampusTopic1, CampusTopic paramCampusTopic2)
  {
    if (paramCampusTopic1 == null) {
      return;
    }
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131362719);
    TextView localTextView = (TextView)paramView.findViewById(2131369915);
    localTextView.setText(paramCampusTopic1.title);
    int m;
    int n;
    if (paramCampusTopic1 == this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic)
    {
      m = this.e;
      n = this.c;
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842348);
      paramCampusTopic2 = null;
    }
    for (;;)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(paramView, null, null, null);
      localTextView.setCompoundDrawablePadding(this.j);
      localTextView.setBackgroundDrawable(a(paramCampusTopic1, m));
      localTextView.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
      localTextView.setTextColor(a(n));
      localTextView.setGravity(16);
      if (TextUtils.isEmpty(paramCampusTopic2)) {
        break;
      }
      localURLImageView.setVisibility(0);
      localURLImageView.setImageDrawable(a(paramCampusTopic2));
      return;
      if (paramCampusTopic1 == paramCampusTopic2)
      {
        m = paramCampusTopic1.color;
        n = this.d;
        paramCampusTopic2 = paramCampusTopic1.iconUrl;
        paramView = null;
      }
      else
      {
        m = this.e;
        n = this.c;
        paramCampusTopic2 = paramCampusTopic1.grayIconUrl;
        paramView = null;
      }
    }
    localURLImageView.setVisibility(8);
  }
  
  public void a(CampusTopic paramCampusTopic)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      String str = String.format(Locale.getDefault(), "%d-%s", new Object[] { Integer.valueOf(paramCampusTopic.id), Integer.valueOf(paramCampusTopic.color) });
      this.jdField_a_of_type_JavaUtilHashMap.remove(str);
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      this.jdField_b_of_type_JavaUtilHashMap.remove(paramCampusTopic.iconUrl);
      return;
      paramCampusTopic = finally;
      throw paramCampusTopic;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (this.k == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic = new CampusTopic();
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic.id = 0;
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic.topicType = 0;
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic.title = "更多版块";
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic.color = -1;
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic.iconUrl = null;
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic.grayIconUrl = null;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    CampusTopic localCampusTopic = (CampusTopic)getItem(paramInt);
    if (localCampusTopic != null) {}
    for (paramInt = localCampusTopic.id;; paramInt = 0) {
      return paramInt;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CampusTopic localCampusTopic = (CampusTopic)getItem(paramInt);
    switch (this.k)
    {
    default: 
      if (paramView != null) {
        paramView.setTag(localCampusTopic);
      }
      return paramView;
    case 0: 
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970275, null);
      }
      if (paramInt != 0) {
        break;
      }
    }
    for (int m = this.i;; m = 0)
    {
      if (paramInt == getCount() - 1) {}
      for (paramInt = this.i - this.h;; paramInt = 0)
      {
        paramViewGroup.setPadding(m, 0, paramInt, 0);
        a(paramViewGroup, localCampusTopic, null);
        paramView = paramViewGroup;
        break;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970275, null);
          paramView = paramViewGroup.getLayoutParams();
          if (paramView != null) {
            break label329;
          }
          paramView = new ViewGroup.LayoutParams(-2, (int)(this.jdField_a_of_type_Float * 50.0F));
        }
        for (;;)
        {
          paramViewGroup.setLayoutParams(paramView);
          localView1 = paramViewGroup.findViewById(2131369915);
          localObject = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_a_of_type_Float * 28.0F));
          }
          paramView.topMargin = ((int)(this.jdField_a_of_type_Float * 22.0F / 2.0F));
          localView1.setLayoutParams(paramView);
          localView1 = paramViewGroup.findViewById(2131362719);
          localObject = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_a_of_type_Float * 16.0F));
          }
          paramView.topMargin = ((int)(this.jdField_a_of_type_Float * 22.0F / 2.0F) - this.h);
          localView1.setLayoutParams(paramView);
          a(paramViewGroup, localCampusTopic, null);
          paramView = paramViewGroup;
          break;
          label329:
          paramView.width = -2;
          paramView.height = ((int)(this.jdField_a_of_type_Float * 50.0F));
        }
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970276, null);
        }
        paramView = paramViewGroup;
        if (localCampusTopic == null) {
          break;
        }
        paramView = (URLImageView)paramViewGroup.findViewById(2131362719);
        Object localObject = (TextView)paramViewGroup.findViewById(2131369923);
        View localView1 = paramViewGroup.findViewById(2131369915);
        TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131369924);
        TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131369925);
        View localView2 = paramViewGroup.findViewById(2131369916);
        if (localCampusTopic.flag == 1)
        {
          ((TextView)localObject).setVisibility(0);
          localTextView2.setVisibility(8);
          ((TextView)localObject).setText("荐");
          ((TextView)localObject).setBackgroundResource(2130842361);
        }
        for (;;)
        {
          localView1.setBackgroundDrawable(a(localCampusTopic, this.e));
          localView1.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
          localTextView1.setText(localCampusTopic.title);
          localTextView1.setTextColor(a(this.c));
          if (TextUtils.isEmpty(localCampusTopic.grayIconUrl)) {
            break label640;
          }
          localView2.setVisibility(0);
          paramView.setVisibility(0);
          paramView.setImageDrawable(a(localCampusTopic.grayIconUrl));
          paramView = paramViewGroup;
          break;
          if (localCampusTopic.flag == 2)
          {
            ((TextView)localObject).setVisibility(0);
            localTextView2.setVisibility(0);
            ((TextView)localObject).setText("热");
            ((TextView)localObject).setBackgroundResource(2130842362);
            localTextView2.setText(localCampusTopic.extra);
          }
          else
          {
            ((TextView)localObject).setVisibility(8);
            localTextView2.setVisibility(8);
          }
        }
        label640:
        localView2.setVisibility(8);
        paramView.setVisibility(8);
        paramView = paramViewGroup;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.TopicAdapter
 * JD-Core Version:    0.7.0.1
 */