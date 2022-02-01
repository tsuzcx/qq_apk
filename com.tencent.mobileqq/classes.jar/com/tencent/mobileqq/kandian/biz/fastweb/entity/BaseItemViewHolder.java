package com.tencent.mobileqq.kandian.biz.fastweb.entity;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.fastweb.OnItemClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

public abstract class BaseItemViewHolder
{
  public static int e = 32;
  public View f;
  public BaseData g;
  protected OnItemClickListener h;
  public float i;
  public float j = 14.0F;
  public int k;
  public int l = 16;
  public int m = 18;
  
  public BaseItemViewHolder() {}
  
  public BaseItemViewHolder(View paramView, BaseData paramBaseData)
  {
    this.f = paramView;
    this.g = paramBaseData;
  }
  
  public void a(OnItemClickListener paramOnItemClickListener)
  {
    this.h = paramOnItemClickListener;
  }
  
  public abstract void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean);
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void b() {}
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    this.g = paramBaseData2;
    a(paramBaseData1, paramBaseData2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder
 * JD-Core Version:    0.7.0.1
 */