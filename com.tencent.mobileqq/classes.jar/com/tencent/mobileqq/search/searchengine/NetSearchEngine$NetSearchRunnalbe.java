package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import java.util.concurrent.CountDownLatch;

class NetSearchEngine$NetSearchRunnalbe
  implements Runnable
{
  public CountDownLatch a;
  FriendListObserver b = new NetSearchEngine.NetSearchRunnalbe.1(this);
  private int[] c;
  private ISearchListener d;
  private String e;
  private int f;
  private boolean g;
  
  public NetSearchEngine$NetSearchRunnalbe(NetSearchEngine paramNetSearchEngine, String paramString, int[] paramArrayOfInt, int paramInt, ISearchListener paramISearchListener)
  {
    this.c = paramArrayOfInt;
    this.d = paramISearchListener;
    this.e = paramString;
    this.f = paramInt;
    this.a = new CountDownLatch(1);
  }
  
  public void a()
  {
    this.g = true;
    this.d = null;
    NetSearchEngine.a(this.this$0).removeObserver(this.b);
    this.b = null;
    this.a.countDown();
  }
  
  public void run()
  {
    NetSearchEngine.a(this.this$0).addObserver(this.b);
    this.this$0.c.a(this.f);
    if (NetSearchEngine.b(this.this$0) == 12)
    {
      this.this$0.c.a(this.e, this.c, NetSearchEngine.b, NetSearchEngine.a, false, 1);
      return;
    }
    this.this$0.c.a(this.e, this.c, NetSearchEngine.b, NetSearchEngine.a, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.NetSearchRunnalbe
 * JD-Core Version:    0.7.0.1
 */