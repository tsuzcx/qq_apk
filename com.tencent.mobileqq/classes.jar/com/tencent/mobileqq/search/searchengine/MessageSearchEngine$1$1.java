package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import java.util.Observable;
import java.util.Observer;

class MessageSearchEngine$1$1
  implements Observer
{
  MessageSearchEngine$1$1(MessageSearchEngine.1 param1) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.a.a.a(MessageSearchEngine.a(this.a.this$0, this.a.this$0.c, (FullMessageSearchResult)paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MessageSearchEngine.1.1
 * JD-Core Version:    0.7.0.1
 */