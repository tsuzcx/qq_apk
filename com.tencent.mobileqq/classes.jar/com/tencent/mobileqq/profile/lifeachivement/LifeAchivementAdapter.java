package com.tencent.mobileqq.profile.lifeachivement;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableTextView;
import java.util.ArrayList;
import java.util.List;

public class LifeAchivementAdapter
  extends RecyclerView.Adapter<LifeAchivementAdapter.ViewHolder>
{
  Context jdField_a_of_type_AndroidContentContext;
  LifeAchivementAdapter.onItemClickListener jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter$onItemClickListener;
  List<LifeAchivementData> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public LifeAchivementAdapter(Context paramContext, List<LifeAchivementData> paramList, LifeAchivementAdapter.onItemClickListener paramonItemClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter$onItemClickListener = paramonItemClickListener;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementAdapter", 2, "LifeAchivementAdapter itemClickListener = " + this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter$onItemClickListener + ",listener = " + paramonItemClickListener);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    paramTextView.setText(LifeAchivementHelper.a(paramInt));
    if (paramBoolean) {}
    for (paramInt = 2130846104;; paramInt = 2130846103)
    {
      Drawable localDrawable = paramTextView.getResources().getDrawable(paramInt);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, paramTextView.getResources()));
      return;
    }
  }
  
  private void a(LifeAchivementAdapter.ViewHolder paramViewHolder, LifeAchivementData paramLifeAchivementData)
  {
    if (!TextUtils.isEmpty(paramLifeAchivementData.b))
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramLifeAchivementData.b, null);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
      {
        localURLDrawable.setAutoDownload(true);
        localURLDrawable.startDownload(true);
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setImageDrawable(localURLDrawable);
    }
    if (paramLifeAchivementData.jdField_a_of_type_Int == 2)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText("+" + paramLifeAchivementData.d);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
    }
    for (;;)
    {
      paramViewHolder.b.setText(paramLifeAchivementData.jdField_a_of_type_JavaLangString);
      return;
      if (paramLifeAchivementData.jdField_a_of_type_Int == 1)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramViewHolder.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramViewHolder.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(0);
        a(paramViewHolder.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView, paramLifeAchivementData.jdField_a_of_type_Boolean, paramLifeAchivementData.c);
      }
    }
  }
  
  public LifeAchivementAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new LifeAchivementAdapter.ViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561490, paramViewGroup, false));
  }
  
  public LifeAchivementData a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (LifeAchivementData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public void a(LifeAchivementAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    a(paramViewHolder, (LifeAchivementData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setOnClickListener(new LifeAchivementAdapter.1(this, paramInt));
    paramViewHolder.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setOnClickListener(new LifeAchivementAdapter.2(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<LifeAchivementData> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramInt <= 10) {
        break label150;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, 10));
      paramList = new LifeAchivementData();
      paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698901);
      paramList.b = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
      paramList.d = (paramInt - 10);
      paramList.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramList = new LifeAchivementData();
        paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698895);
        paramList.b = "https://downv6.qq.com/qq_relation/life_achivement/add_badge_v2.png";
        paramList.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_JavaUtilList.add(0, paramList);
      }
      notifyDataSetChanged();
      return;
      label150:
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.lifeachivement.LifeAchivementAdapter
 * JD-Core Version:    0.7.0.1
 */