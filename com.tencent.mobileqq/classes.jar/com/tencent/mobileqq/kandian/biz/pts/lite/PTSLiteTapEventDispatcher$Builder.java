package com.tencent.mobileqq.kandian.biz.pts.lite;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.HashMap;

public class PTSLiteTapEventDispatcher$Builder
{
  private ReadInJoyBaseAdapter a;
  private HashMap<String, Integer> b;
  private HashMap<String, AbsBaseArticleInfo> c;
  
  public Builder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.a = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public Builder a(HashMap<String, Integer> paramHashMap)
  {
    this.b = paramHashMap;
    return this;
  }
  
  public PTSLiteTapEventDispatcher a()
  {
    PTSLiteTapEventDispatcher localPTSLiteTapEventDispatcher = new PTSLiteTapEventDispatcher(null);
    PTSLiteTapEventDispatcher.a(localPTSLiteTapEventDispatcher, this.a);
    PTSLiteTapEventDispatcher.a(localPTSLiteTapEventDispatcher, this.b);
    PTSLiteTapEventDispatcher.b(localPTSLiteTapEventDispatcher, this.c);
    return localPTSLiteTapEventDispatcher;
  }
  
  public Builder b(HashMap<String, AbsBaseArticleInfo> paramHashMap)
  {
    this.c = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteTapEventDispatcher.Builder
 * JD-Core Version:    0.7.0.1
 */