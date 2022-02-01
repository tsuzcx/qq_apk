package com.tencent.mobileqq.kandian.biz.feeds.ark;

import android.view.View;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import mqq.app.AppRuntime;

public class FeedItemCellArk
{
  private View a;
  
  public FeedItemCellArk(ArkAppMessage paramArkAppMessage, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (ReadInJoyUtils.b() != null)
    {
      paramArkAppMessage = ReadInJoyUtils.b().getApplication();
      if (paramArkAppMessage == null) {
        return;
      }
      this.a = new View(paramArkAppMessage);
      this.a.setVisibility(8);
    }
  }
  
  public View a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ark.FeedItemCellArk
 * JD-Core Version:    0.7.0.1
 */