package com.tencent.mobileqq.kandian.biz.feeds;

import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerTask;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.TraceUtils;

class ReadInJoyProteusFamilyAdapter$2
  extends HandlerTask
{
  ReadInJoyProteusFamilyAdapter$2(ReadInJoyProteusFamilyAdapter paramReadInJoyProteusFamilyAdapter, String paramString, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt2, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(IBaseHandler paramIBaseHandler)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyBaseAdapter.Viewtype ");
    localStringBuilder.append(this.a);
    TraceUtils.traceBegin(localStringBuilder.toString());
    if (this.e.f(this.a)) {
      if ((ProteusSupportUtil.b(this.e.F(), this.a, this.b)) && (ReadInJoyProteusFamilyAdapter.a(this.e) != 56))
      {
        if ((paramIBaseHandler instanceof FrameworkHandler)) {}
      }
      else if ((paramIBaseHandler instanceof FrameworkHandler)) {
        return;
      }
    }
    if (paramIBaseHandler.d(this.a)) {
      this.g = paramIBaseHandler.a(this.c, null, this.d);
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyAdapter.2
 * JD-Core Version:    0.7.0.1
 */