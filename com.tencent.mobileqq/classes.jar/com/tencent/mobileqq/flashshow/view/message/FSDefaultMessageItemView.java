package com.tencent.mobileqq.flashshow.view.message;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter;
import com.tencent.mobileqq.flashshow.list.presenter.FSDefaultMessagePresenter;
import com.tencent.mobileqq.flashshow.list.presenter.FSKolMessagePresenter;
import com.tencent.mobileqq.flashshow.list.presenter.FSSystemMessagePresenter;
import com.tencent.mobileqq.flashshow.list.presenter.FSTopReplayMessagePresenter;
import feedcloud.FeedCloudMeta.StNotice;

public class FSDefaultMessageItemView
  extends FSBaseMessageItemView
{
  public FSDefaultMessageItemView(Context paramContext, int paramInt, BlockPart paramBlockPart)
  {
    super(paramContext, Integer.valueOf(paramInt));
    this.a.a(paramBlockPart);
  }
  
  protected FSBaseMessagePresenter a(int paramInt)
  {
    if (paramInt == 3) {
      return new FSSystemMessagePresenter(paramInt);
    }
    if ((paramInt != 10) && (paramInt != 11) && (paramInt != 6) && (paramInt != 7))
    {
      if (paramInt == 14) {
        return new FSKolMessagePresenter(paramInt);
      }
      return new FSDefaultMessagePresenter(paramInt);
    }
    return new FSTopReplayMessagePresenter(paramInt);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramStNotice, paramInt);
    }
  }
  
  protected void beforeInflateView(Context paramContext, int paramInt)
  {
    this.a = a(paramInt);
  }
  
  public int getLayoutId()
  {
    return 2131624819;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (this.a != null) {
      this.a.a(paramContext, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.message.FSDefaultMessageItemView
 * JD-Core Version:    0.7.0.1
 */