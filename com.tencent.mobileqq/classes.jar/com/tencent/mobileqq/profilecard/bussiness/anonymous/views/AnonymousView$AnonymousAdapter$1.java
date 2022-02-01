package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AnonymousView$AnonymousAdapter$1
  implements View.OnClickListener
{
  AnonymousView$AnonymousAdapter$1(AnonymousView.AnonymousAdapter paramAnonymousAdapter, AnonymousQuestion paramAnonymousQuestion, AnonymousView.ListViewHolder paramListViewHolder) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131374151) && (i != 2131374166))
    {
      if ((i != 2131374165) && (i != 2131374150))
      {
        if (i == 2131374156)
        {
          AnonymousView.access$400(this.this$1.this$0);
          ProfileUtils.setViewClickInterval(paramView);
          AnonymousViewHelper.jumpToAnonymousDetail((Activity)AnonymousView.access$800(this.this$1.this$0), AnonymousView.access$700(this.this$1.this$0), this.val$anonymousInfo.mId, "", 8, this.val$anonymousInfo.mQuestTime);
        }
      }
      else
      {
        AnonymousView.access$400(this.this$1.this$0);
        ProfileUtils.setViewClickInterval(paramView);
        AnonymousViewHelper.jumpToComment((Activity)AnonymousView.access$600(this.this$1.this$0), AnonymousView.access$700(this.this$1.this$0), this.val$anonymousInfo.mId, this.val$anonymousInfo.mQuestTime);
      }
    }
    else
    {
      AnonymousView.access$400(this.this$1.this$0);
      i = (int)this.val$anonymousInfo.mTotalPraiseCount;
      AnonymousQuestion localAnonymousQuestion = this.val$anonymousInfo;
      if (localAnonymousQuestion.mPraised) {
        i -= 1;
      } else {
        i += 1;
      }
      localAnonymousQuestion.mTotalPraiseCount = i;
      AnonymousViewHelper.onClickLike(this.this$1.this$0.appInterface, this.val$anonymousInfo);
      localAnonymousQuestion = this.val$anonymousInfo;
      localAnonymousQuestion.mPraised ^= true;
      AnonymousView.AnonymousAdapter.access$500(this.this$1, this.val$anonymousInfo.mPraised, this.val$listViewHolder.tvLike, this.val$listViewHolder.ivLike, this.val$anonymousInfo.mTotalPraiseCount);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter.1
 * JD-Core Version:    0.7.0.1
 */