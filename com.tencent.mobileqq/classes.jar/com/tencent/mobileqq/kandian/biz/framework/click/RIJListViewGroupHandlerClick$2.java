package com.tencent.mobileqq.kandian.biz.framework.click;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler.RequestSearchWordCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.HashMap;
import mqq.os.MqqHandler;
import tencent.im.oidb.search.RequestSearchWord.Rcmd;

class RIJListViewGroupHandlerClick$2
  implements UniteSearchHandler.RequestSearchWordCallback
{
  RIJListViewGroupHandlerClick$2(RIJListViewGroupHandlerClick paramRIJListViewGroupHandlerClick, HashMap paramHashMap, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, RIJListViewGroupHandlerClick.Builder paramBuilder, int paramInt2) {}
  
  public void a(PBRepeatMessageField<RequestSearchWord.Rcmd> paramPBRepeatMessageField, PBStringField paramPBStringField)
  {
    if (paramPBRepeatMessageField != null)
    {
      if (paramPBRepeatMessageField.size() <= 0) {
        return;
      }
      if (this.a.containsKey(this.b.mRefreshTime)) {
        this.a.put(this.b.mRefreshTime, Integer.valueOf(this.c + 1));
      } else {
        this.a.put(this.b.mRefreshTime, Integer.valueOf(1));
      }
      SharedPreUtils.a("search_word_prefix_show_times", SharedPreUtils.k("search_word_prefix_show_times") + 1L);
      ThreadManager.getUIHandler().post(new RIJListViewGroupHandlerClick.2.1(this, paramPBRepeatMessageField, paramPBStringField));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick.2
 * JD-Core Version:    0.7.0.1
 */