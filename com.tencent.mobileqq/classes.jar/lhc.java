import com.tencent.av.app.VideoAppInterface;

public class lhc
{
  private ajtd[] a = new ajtd[4];
  
  private ajtd b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (paramVideoAppInterface = localObject;; paramVideoAppInterface = new lgq(paramVideoAppInterface))
    {
      lcl.c("BusinessHandlerFactory", "createHandler unknown name");
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        lcl.c("BusinessHandlerFactory", "createHandler,cost time:" + (l2 - l1));
        return paramVideoAppInterface;
        paramVideoAppInterface = new lhb(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new lgy(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new ltz(paramVideoAppInterface);
      }
    }
  }
  
  public ajtd a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      ajtd localajtd = this.a[paramInt];
      localObject = localajtd;
      if (localajtd == null)
      {
        paramVideoAppInterface = b(paramVideoAppInterface, paramInt);
        localObject = paramVideoAppInterface;
        if (paramVideoAppInterface != null)
        {
          this.a[paramInt] = paramVideoAppInterface;
          localObject = paramVideoAppInterface;
        }
      }
      return localObject;
    }
  }
  
  public void a(lgn paramlgn)
  {
    paramlgn.a("TransInfoCreate.CreateSession", new int[] { 1 });
    paramlgn.a("TransInfo.JoinSession", new int[] { 0 });
    paramlgn.a("TransInfo.ExitSession", new int[] { 0 });
    paramlgn.a("TransInfo.ChangeSession", new int[] { 0 });
    paramlgn.a("TransInfo.RawData", new int[] { 0 });
    paramlgn.a("OidbSvc.0xa75", new int[] { 2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhc
 * JD-Core Version:    0.7.0.1
 */