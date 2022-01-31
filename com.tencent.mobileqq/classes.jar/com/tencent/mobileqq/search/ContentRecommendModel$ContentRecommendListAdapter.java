package com.tencent.mobileqq.search;

import ahqq;
import ahqr;
import ahqs;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.search.model.ContentRecommendDataModel.ContentRecommendItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import java.util.ArrayList;
import java.util.List;

public class ContentRecommendModel$ContentRecommendListAdapter
  extends BaseAdapter
{
  public List a;
  
  public ContentRecommendModel$ContentRecommendListAdapter(ContentRecommendModel paramContentRecommendModel)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(int paramInt, ahqs paramahqs, ContentRecommendDataModel.ContentRecommendItem paramContentRecommendItem)
  {
    ColorDrawable localColorDrawable = new ColorDrawable();
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      localColorDrawable.setColor(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources().getColor(2131492956));
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label626;
      }
      paramahqs.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#040E1C"));
      paramahqs.jdField_e_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5F6062"));
      paramahqs.g.setTextColor(Color.parseColor("#5F6062"));
      paramahqs.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#040E1C"));
      return;
      localColorDrawable.setColor(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources().getColor(2131492955));
      break;
      paramahqs.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramahqs.jdField_c_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.e);
      paramahqs.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      paramahqs.jdField_e_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.g);
      paramahqs.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramahqs.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramahqs.jdField_f_of_type_AndroidViewView.setVisibility(8);
      if (paramContentRecommendItem.jdField_a_of_type_JavaUtilList.size() >= 3)
      {
        paramahqs.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(0), localURLDrawableOptions));
        paramahqs.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(1), localURLDrawableOptions));
        paramahqs.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(2), localURLDrawableOptions));
      }
      else
      {
        paramahqs.jdField_e_of_type_AndroidViewView.setVisibility(8);
        continue;
        paramahqs.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahqs.jdField_e_of_type_AndroidViewView.setVisibility(8);
        paramahqs.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahqs.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahqs.jdField_f_of_type_AndroidViewView.setVisibility(0);
        paramahqs.jdField_f_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.e);
        paramahqs.g.setText(paramContentRecommendItem.g);
        paramahqs.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramahqs.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(0), localURLDrawableOptions));
        continue;
        paramahqs.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahqs.jdField_e_of_type_AndroidViewView.setVisibility(8);
        paramahqs.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahqs.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahqs.jdField_f_of_type_AndroidViewView.setVisibility(0);
        paramahqs.jdField_f_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.e);
        paramahqs.g.setText(paramContentRecommendItem.g);
        paramahqs.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramahqs.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(0), localURLDrawableOptions));
        continue;
        paramahqs.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramahqs.jdField_c_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.e);
        paramahqs.jdField_d_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.f);
        paramahqs.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        paramahqs.jdField_e_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.g);
        paramahqs.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramahqs.jdField_e_of_type_AndroidViewView.setVisibility(8);
        paramahqs.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label626:
    paramahqs.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#F7F7F8"));
    paramahqs.jdField_e_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
    paramahqs.g.setTextColor(Color.parseColor("#BBBBBB"));
    paramahqs.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#DEDFE0"));
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      notifyDataSetChanged();
      return;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ContentRecommendDataModel.ContentRecommendItem localContentRecommendItem;
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a).inflate(2130968824, paramViewGroup, false);
      paramViewGroup = new ahqs(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363961);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363960);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363962));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363378));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363963));
      paramViewGroup.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131363949);
      paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363948);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((EllipsizingTextView)paramView.findViewById(2131363950));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((EllipsizingTextView)paramView.findViewById(2131363958));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363959));
      paramViewGroup.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131363955);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363701));
      paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363956));
      paramViewGroup.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363957));
      paramViewGroup.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131363951);
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363953));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131363954));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362767));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363544));
      paramView.setTag(paramViewGroup);
      localContentRecommendItem = (ContentRecommendDataModel.ContentRecommendItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localContentRecommendItem != null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqSearchModelContentRecommendDataModel$ContentRecommendItem = localContentRecommendItem;
        localObject = new ColorDrawable();
        if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          break label495;
        }
        ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources().getColor(2131492956));
      }
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = AIOUtils.a(16.0F, this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources());
      localURLDrawableOptions.mRequestHeight = AIOUtils.a(16.0F, this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources());
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(localContentRecommendItem.b, localURLDrawableOptions);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localContentRecommendItem.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localContentRecommendItem.c);
      a(localContentRecommendItem.jdField_a_of_type_Int, paramViewGroup, localContentRecommendItem);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(new ahqq(this, paramViewGroup));
      paramViewGroup.jdField_d_of_type_AndroidViewView.setOnClickListener(new ahqr(this, paramViewGroup));
      return paramView;
      paramViewGroup = (ahqs)paramView.getTag();
      break;
      label495:
      ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources().getColor(2131492955));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContentRecommendModel.ContentRecommendListAdapter
 * JD-Core Version:    0.7.0.1
 */