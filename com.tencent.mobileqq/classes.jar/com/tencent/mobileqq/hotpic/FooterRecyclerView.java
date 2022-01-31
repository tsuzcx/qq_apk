package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import aqet;
import aqhh;
import com.tencent.qphone.base.util.QLog;

public class FooterRecyclerView
  extends RecyclerView
{
  aqet a;
  
  public FooterRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(aqet paramaqet)
  {
    if (getAdapter() != null) {}
    this.a = paramaqet;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    Object localObject = paramAdapter;
    if (this.a != null)
    {
      localObject = new aqhh(paramAdapter, this.a);
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