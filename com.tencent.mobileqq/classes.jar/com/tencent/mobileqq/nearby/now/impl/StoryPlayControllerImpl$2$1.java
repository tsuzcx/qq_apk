package com.tencent.mobileqq.nearby.now.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;

class StoryPlayControllerImpl$2$1
  implements View.OnClickListener
{
  StoryPlayControllerImpl$2$1(StoryPlayControllerImpl.2 param2) {}
  
  public void onClick(View paramView)
  {
    this.a.a.mPlayListDataModel.b();
    this.a.a.stuffContainerView.j.setVisibility(8);
    this.a.a.stuffContainerView.m.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.2.1
 * JD-Core Version:    0.7.0.1
 */