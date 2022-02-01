package com.tencent.mobileqq.kandian.biz.fastweb.data;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import mqq.os.MqqHandler;

public class ProteusAnimationItemData
  extends ProteusItemData
{
  @Deprecated
  private View a;
  private int b;
  
  public void a(View paramView)
  {
    this.a = paramView;
    ThreadManager.getUIHandler().post(new ProteusAnimationItemData.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.data.ProteusAnimationItemData
 * JD-Core Version:    0.7.0.1
 */