package com.tencent.mobileqq.nearby.now.location.adapter;

import aetk;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.nearby.now.widget.CommonAdapter;
import com.tencent.mobileqq.nearby.now.widget.CommonViewHolder;
import com.tencent.mobileqq.nearby.now.widget.CommonViewHolder.ItemClickListener;
import java.util.List;

public abstract class SelectableAdapter
  extends CommonAdapter
{
  public int a;
  public View a;
  public Object a;
  private int c = 1;
  
  public SelectableAdapter(Context paramContext, int paramInt, List paramList)
  {
    super(paramContext, paramInt, paramList);
    this.jdField_a_of_type_Int = -1;
  }
  
  public abstract void a(View paramView);
  
  public void a(CommonViewHolder.ItemClickListener paramItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener = new aetk(this, paramItemClickListener);
  }
  
  public void a(CommonViewHolder paramCommonViewHolder, Object paramObject) {}
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public abstract void b(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.location.adapter.SelectableAdapter
 * JD-Core Version:    0.7.0.1
 */