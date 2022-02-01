package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhotoGridAdapter$PhotoItemClickListener
  implements View.OnClickListener
{
  int a;
  CheckBox b;
  
  public PhotoGridAdapter$PhotoItemClickListener(PhotoGridAdapter paramPhotoGridAdapter) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.b = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    this.c.a(paramView, this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter.PhotoItemClickListener
 * JD-Core Version:    0.7.0.1
 */