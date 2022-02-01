package com.tencent.mobileqq.flashshow.request.feed;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;

public class FSTabFeedCall$Param
{
  private FSMainTabInfo a;
  private int b;
  private boolean c = false;
  private FSTabFeedCall.GetFeedRspListener d;
  
  public Param a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Param a(@NonNull FSMainTabInfo paramFSMainTabInfo)
  {
    this.a = paramFSMainTabInfo;
    return this;
  }
  
  public Param a(@NonNull FSTabFeedCall.GetFeedRspListener paramGetFeedRspListener)
  {
    this.d = paramGetFeedRspListener;
    return this;
  }
  
  public Param a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.feed.FSTabFeedCall.Param
 * JD-Core Version:    0.7.0.1
 */