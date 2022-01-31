import com.tencent.av.app.VideoAppInterface;

public class lgx
{
  private ajtb[] a = new ajtb[4];
  
  private ajtb b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (paramVideoAppInterface = localObject;; paramVideoAppInterface = new lgl(paramVideoAppInterface))
    {
      lcg.c("BusinessHandlerFactory", "createHandler unknown name");
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        lcg.c("BusinessHandlerFactory", "createHandler,cost time:" + (l2 - l1));
        return paramVideoAppInterface;
        paramVideoAppInterface = new lgw(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new lgt(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new ltu(paramVideoAppInterface);
      }
    }
  }
  
  public ajtb a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      ajtb localajtb = this.a[paramInt];
      localObject = localajtb;
      if (localajtb == null)
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
  
  public void a(lgi paramlgi)
  {
    paramlgi.a("TransInfoCreate.CreateSession", new int[] { 1 });
    paramlgi.a("TransInfo.JoinSession", new int[] { 0 });
    paramlgi.a("TransInfo.ExitSession", new int[] { 0 });
    paramlgi.a("TransInfo.ChangeSession", new int[] { 0 });
    paramlgi.a("TransInfo.RawData", new int[] { 0 });
    paramlgi.a("OidbSvc.0xa75", new int[] { 2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgx
 * JD-Core Version:    0.7.0.1
 */