package com.tencent.mobileqq.kandian.biz.fastweb.entity;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.fastweb.OnItemClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

public abstract class BaseItemViewHolder
{
  public static int a = 32;
  public float a;
  public View a;
  protected OnItemClickListener a;
  public BaseData a;
  public float b = 14.0F;
  public int b;
  public int c = 16;
  public int d = 18;
  
  public BaseItemViewHolder() {}
  
  public BaseItemViewHolder(View paramView, BaseData paramBaseData)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData = paramBaseData;
  }
  
  public void a(OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebOnItemClickListener = paramOnItemClickListener;
  }
  
  public abstract void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean);
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void b() {}
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData = paramBaseData2;
    a(paramBaseData1, paramBaseData2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder
 * JD-Core Version:    0.7.0.1
 */