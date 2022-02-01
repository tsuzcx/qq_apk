import com.tencent.av.app.VideoAppInterface;

public class lgd
{
  private anud[] a = new anud[4];
  
  private anud b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (paramVideoAppInterface = localObject;; paramVideoAppInterface = new lfr(paramVideoAppInterface))
    {
      lbj.c("BusinessHandlerFactory", "createHandler unknown name");
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        lbj.c("BusinessHandlerFactory", "createHandler,cost time = [" + (l2 - l1) + "]");
        return paramVideoAppInterface;
        paramVideoAppInterface = new lgc(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new lfz(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new ltz(paramVideoAppInterface);
      }
    }
  }
  
  public anud a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      anud localanud = this.a[paramInt];
      localObject = localanud;
      if (localanud == null)
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
  
  public void a(lfn paramlfn)
  {
    paramlfn.a("TransInfoCreate.CreateSession", new int[] { 1 });
    paramlfn.a("TransInfo.JoinSession", new int[] { 0 });
    paramlfn.a("TransInfo.ExitSession", new int[] { 0 });
    paramlfn.a("TransInfo.ChangeSession", new int[] { 0 });
    paramlfn.a("TransInfo.RawData", new int[] { 0 });
    paramlfn.a("OidbSvc.0xa75", new int[] { 2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgd
 * JD-Core Version:    0.7.0.1
 */