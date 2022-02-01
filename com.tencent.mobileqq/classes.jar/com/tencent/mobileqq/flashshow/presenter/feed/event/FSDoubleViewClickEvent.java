package com.tencent.mobileqq.flashshow.presenter.feed.event;

public class FSDoubleViewClickEvent
  extends FSBaseFeedPresenterEvent
{
  private String a;
  
  public FSDoubleViewClickEvent(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.event.FSDoubleViewClickEvent
 * JD-Core Version:    0.7.0.1
 */