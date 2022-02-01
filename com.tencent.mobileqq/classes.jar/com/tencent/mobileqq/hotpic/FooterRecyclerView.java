package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import augg;
import auit;
import com.tencent.qphone.base.util.QLog;

public class FooterRecyclerView
  extends RecyclerView
{
  augg a;
  
  public FooterRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(augg paramaugg)
  {
    if (getAdapter() != null) {}
    this.a = paramaugg;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    Object localObject = paramAdapter;
    if (this.a != null)
    {
      localObject = new auit(paramAdapter, this.a);
      if (QLog.isColorLevel()) {
        QLog.d("FooterRecyclerView", 2, "has footer");
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.FooterRecyclerView
 * JD-Core Version:    0.7.0.1
 */