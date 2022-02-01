package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementHelper;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AnonymousView$AnonymousAdapter$1
  implements View.OnClickListener
{
  AnonymousView$AnonymousAdapter$1(AnonymousView.AnonymousAdapter paramAnonymousAdapter, AnonymousQuestion paramAnonymousQuestion, AnonymousView.ListViewHolder paramListViewHolder) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AnonymousView.access$400(this.this$1.this$0);
      int i = (int)this.val$anonymousInfo.mTotalPraiseCount;
      AnonymousQuestion localAnonymousQuestion = this.val$anonymousInfo;
      long l;
      if (this.val$anonymousInfo.mPraised)
      {
        l = i - 1;
        label104:
        localAnonymousQuestion.mTotalPraiseCount = l;
        AnonymousViewHelper.onClickLike(this.this$1.this$0.appInterface, this.val$anonymousInfo);
        localAnonymousQuestion = this.val$anonymousInfo;
        if (this.val$anonymousInfo.mPraised) {
          break label199;
        }
      }
      label199:
      for (boolean bool = true;; bool = false)
      {
        localAnonymousQuestion.mPraised = bool;
        AnonymousView.AnonymousAdapter.access$500(this.this$1, this.val$anonymousInfo.mPraised, this.val$listViewHolder.tvLike, this.val$listViewHolder.ivLike, this.val$anonymousInfo.mTotalPraiseCount);
        break;
        l = i + 1;
        break label104;
      }
      AnonymousView.access$400(this.this$1.this$0);
      LifeAchivementHelper.a(paramView);
      AnonymousViewHelper.jumpToComment((BaseActivity)AnonymousView.access$600(this.this$1.this$0), AnonymousView.access$700(this.this$1.this$0), this.val$anonymousInfo.mId, this.val$anonymousInfo.mQuestTime);
      continue;
      AnonymousView.access$400(this.this$1.this$0);
      LifeAchivementHelper.a(paramView);
      AnonymousViewHelper.jumpToAnonymousDetail((BaseActivity)AnonymousView.access$800(this.this$1.this$0), AnonymousView.access$700(this.this$1.this$0), this.val$anonymousInfo.mId, "", 8, this.val$anonymousInfo.mQuestTime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter.1
 * JD-Core Version:    0.7.0.1
 */