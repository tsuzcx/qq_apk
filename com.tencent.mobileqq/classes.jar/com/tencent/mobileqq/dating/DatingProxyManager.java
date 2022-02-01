package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import mqq.manager.Manager;

public class DatingProxyManager
  implements Manager
{
  private QQAppInterface a;
  private VoteEventMgr b;
  private StrangerHdHeadUrlFetcher c;
  private Object d = new Object();
  private Object e = new Object();
  
  public DatingProxyManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public VoteEventMgr a()
  {
    ??? = this.b;
    if (??? != null) {
      return ???;
    }
    synchronized (this.d)
    {
      if (this.b == null) {
        this.b = new VoteEventMgr(this.a);
      }
      VoteEventMgr localVoteEventMgr = this.b;
      return localVoteEventMgr;
    }
  }
  
  public StrangerHdHeadUrlFetcher b()
  {
    ??? = this.c;
    if (??? != null) {
      return ???;
    }
    synchronized (this.e)
    {
      if (this.c == null) {
        this.c = new StrangerHdHeadUrlFetcher(this.a);
      }
      StrangerHdHeadUrlFetcher localStrangerHdHeadUrlFetcher = this.c;
      return localStrangerHdHeadUrlFetcher;
    }
  }
  
  public void onDestroy()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((VoteEventMgr)localObject).d();
    }
    this.b = null;
    localObject = this.c;
    if (localObject != null)
    {
      ((StrangerHdHeadUrlFetcher)localObject).a();
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingProxyManager
 * JD-Core Version:    0.7.0.1
 */