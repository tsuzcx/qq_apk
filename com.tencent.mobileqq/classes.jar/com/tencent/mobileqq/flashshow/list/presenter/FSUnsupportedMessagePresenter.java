package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import feedcloud.FeedCloudMeta.StNotice;

public class FSUnsupportedMessagePresenter
  extends FSBaseMessagePresenter
{
  public FSUnsupportedMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  void b(Context paramContext, View paramView) {}
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((this.h != null) && (this.c != null)) {
      this.h.setText(this.c.getString(2131889732));
    }
  }
  
  void c() {}
  
  protected String f()
  {
    return "FSUnsupportedMessagePresenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSUnsupportedMessagePresenter
 * JD-Core Version:    0.7.0.1
 */