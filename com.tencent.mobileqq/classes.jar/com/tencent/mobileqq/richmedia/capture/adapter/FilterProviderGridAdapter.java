package com.tencent.mobileqq.richmedia.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.view.CaptureCommonLoadingView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FilterProviderGridAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public String a;
  List<FilterCategoryItem> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  int b;
  
  public FilterProviderGridAdapter(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = "FilterProviderGridAdapter";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(List<FilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    else
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)((Iterator)localObject).next();
        if (!localFilterCategoryItem.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilList.add(localFilterCategoryItem);
        }
      }
    }
    notifyDataSetChanged();
    if ((paramList != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FilterProviderGridAdapter setData size = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size()) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Int <= 0) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Int = paramViewGroup.getMeasuredWidth();
      this.jdField_b_of_type_Int = ((int)((this.jdField_a_of_type_Int - FilterProviderPagerAdapter.jdField_b_of_type_Int * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561006, paramViewGroup, false);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131366842);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131368744);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131368343);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131365257);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131362281);
    CaptureCommonLoadingView localCaptureCommonLoadingView = (CaptureCommonLoadingView)paramView.findViewById(2131366846);
    FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = ((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).getSelectFilterCategoryItem();
    boolean bool1;
    if (localObject != null) {
      bool1 = TextUtils.equals(((FilterCategoryItem)localObject).jdField_a_of_type_JavaLangString, localFilterCategoryItem.jdField_a_of_type_JavaLangString);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      if (((localObject == null) || (((FilterCategoryItem)localObject).a())) && (localFilterCategoryItem.a())) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    paramView.setTag(localFilterCategoryItem);
    AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ((AbsListView.LayoutParams)localObject).height = this.jdField_b_of_type_Int;
    if (localFilterCategoryItem.a())
    {
      localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846130));
      if (bool2) {
        localImageView3.setVisibility(0);
      } else {
        localImageView3.setVisibility(8);
      }
      localImageView2.setVisibility(8);
      localTextView.setText(HardCodeUtil.a(2131704706));
      localImageView1.setContentDescription(HardCodeUtil.a(2131704709));
      localTextView.setContentDescription(HardCodeUtil.a(2131704710));
    }
    else
    {
      if (bool2)
      {
        localImageView3.setVisibility(0);
        localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167004));
      }
      else
      {
        localImageView3.setVisibility(8);
        localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167004));
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846126);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846126);
      localCaptureCommonLoadingView.setMax(10000);
      localCaptureCommonLoadingView.setVisibility(8);
      localObject = URLDrawable.getDrawable(localFilterCategoryItem.d, URLDrawable.URLDrawableOptions.obtain());
      ((URLDrawable)localObject).startDownload();
      localImageView1.setImageDrawable((Drawable)localObject);
      localTextView.setText(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
      localImageView1.setContentDescription(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
      localTextView.setContentDescription(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
      if (localFilterCategoryItem.jdField_a_of_type_Boolean)
      {
        localImageView2.setVisibility(8);
        if (StringUtil.a(localFilterCategoryItem.j)) {
          localURLImageView.setVisibility(8);
        } else {
          try
          {
            localURLImageView.setVisibility(0);
            localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFilterCategoryItem.j));
            localObject = localURLImageView.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject).height = 42;
            ((ViewGroup.LayoutParams)localObject).width = 42;
            localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          catch (Exception localException)
          {
            QLog.e("PtvTemplateItemView", 1, "PtvTemplateItemView bindData mBadgeImg.setImageDrawable(URLDrawable.getDrawable(info.badgeurl)) catch an Exception.", localException);
            localURLImageView.setVisibility(8);
          }
        }
        ReportController.b(null, "dc00898", "", "", "0X800859E", "0X800859E", 2, 0, "", "", localFilterCategoryItem.jdField_a_of_type_JavaLangString, "");
      }
      else
      {
        bool1 = ((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).needShowRedDot(3, localFilterCategoryItem.jdField_b_of_type_Int, localFilterCategoryItem.jdField_a_of_type_JavaLangString);
        if (bool1)
        {
          localImageView2.setVisibility(0);
          if (bool1) {
            localImageView2.setImageResource(2130846132);
          }
        }
        else
        {
          localImageView2.setVisibility(8);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */