package com.tencent.mobileqq.search;

import ahco;
import ahcp;
import ahcq;
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
  
  private void a(int paramInt, ahcq paramahcq, ContentRecommendDataModel.ContentRecommendItem paramContentRecommendItem)
  {
    ColorDrawable localColorDrawable = new ColorDrawable();
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      localColorDrawable.setColor(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources().getColor(2131492955));
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
      paramahcq.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#040E1C"));
      paramahcq.jdField_e_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5F6062"));
      paramahcq.g.setTextColor(Color.parseColor("#5F6062"));
      paramahcq.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#040E1C"));
      return;
      localColorDrawable.setColor(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources().getColor(2131492954));
      break;
      paramahcq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramahcq.jdField_c_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.e);
      paramahcq.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      paramahcq.jdField_e_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.g);
      paramahcq.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramahcq.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramahcq.jdField_f_of_type_AndroidViewView.setVisibility(8);
      if (paramContentRecommendItem.jdField_a_of_type_JavaUtilList.size() >= 3)
      {
        paramahcq.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(0), localURLDrawableOptions));
        paramahcq.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(1), localURLDrawableOptions));
        paramahcq.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(2), localURLDrawableOptions));
      }
      else
      {
        paramahcq.jdField_e_of_type_AndroidViewView.setVisibility(8);
        continue;
        paramahcq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahcq.jdField_e_of_type_AndroidViewView.setVisibility(8);
        paramahcq.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahcq.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahcq.jdField_f_of_type_AndroidViewView.setVisibility(0);
        paramahcq.jdField_f_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.e);
        paramahcq.g.setText(paramContentRecommendItem.g);
        paramahcq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramahcq.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(0), localURLDrawableOptions));
        continue;
        paramahcq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahcq.jdField_e_of_type_AndroidViewView.setVisibility(8);
        paramahcq.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahcq.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahcq.jdField_f_of_type_AndroidViewView.setVisibility(0);
        paramahcq.jdField_f_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.e);
        paramahcq.g.setText(paramContentRecommendItem.g);
        paramahcq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramahcq.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((String)paramContentRecommendItem.jdField_a_of_type_JavaUtilList.get(0), localURLDrawableOptions));
        continue;
        paramahcq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramahcq.jdField_c_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.e);
        paramahcq.jdField_d_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.f);
        paramahcq.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        paramahcq.jdField_e_of_type_AndroidWidgetTextView.setText(paramContentRecommendItem.g);
        paramahcq.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramahcq.jdField_e_of_type_AndroidViewView.setVisibility(8);
        paramahcq.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label626:
    paramahcq.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#F7F7F8"));
    paramahcq.jdField_e_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
    paramahcq.g.setTextColor(Color.parseColor("#BBBBBB"));
    paramahcq.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#DEDFE0"));
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
      paramViewGroup = new ahcq(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363938);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363937);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363939));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363360));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363940));
      paramViewGroup.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131363926);
      paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363925);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((EllipsizingTextView)paramView.findViewById(2131363927));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((EllipsizingTextView)paramView.findViewById(2131363935));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363936));
      paramViewGroup.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131363932);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363678));
      paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363933));
      paramViewGroup.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363934));
      paramViewGroup.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131363928);
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363930));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131363931));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362749));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363526));
      paramView.setTag(paramViewGroup);
      localContentRecommendItem = (ContentRecommendDataModel.ContentRecommendItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localContentRecommendItem != null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqSearchModelContentRecommendDataModel$ContentRecommendItem = localContentRecommendItem;
        localObject = new ColorDrawable();
        if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          break label495;
        }
        ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources().getColor(2131492955));
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
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(new ahco(this, paramViewGroup));
      paramViewGroup.jdField_d_of_type_AndroidViewView.setOnClickListener(new ahcp(this, paramViewGroup));
      return paramView;
      paramViewGroup = (ahcq)paramView.getTag();
      break;
      label495:
      ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel.a.getResources().getColor(2131492954));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContentRecommendModel.ContentRecommendListAdapter
 * JD-Core Version:    0.7.0.1
 */