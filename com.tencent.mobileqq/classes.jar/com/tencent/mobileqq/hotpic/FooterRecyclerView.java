package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;

public class FooterRecyclerView
  extends RecyclerView
{
  HotPicFooterInterface a;
  
  public FooterRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(HotPicFooterInterface paramHotPicFooterInterface)
  {
    getAdapter();
    this.a = paramHotPicFooterInterface;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    HotPicFooterInterface localHotPicFooterInterface = this.a;
    Object localObject = paramAdapter;
    if (localHotPicFooterInterface != null)
    {
      localObject = new RecyclerFooterWrapperAdapter(paramAdapter, localHotPicFooterInterface);
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