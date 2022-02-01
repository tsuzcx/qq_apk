package com.tencent.mobileqq.kandian.biz.pts.component;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class ComponentHeaderRecommend$1
  extends ClickableSpan
{
  ComponentHeaderRecommend$1(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.a.getContext(), this.a.a.a.k(), 1, false, 8, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(AIOUtils.a(2, 14, this.a.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderRecommend.1
 * JD-Core Version:    0.7.0.1
 */