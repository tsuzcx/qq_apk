import com.tencent.av.app.VideoAppInterface;

public class lja
{
  private alpd[] a = new alpd[4];
  
  private alpd b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (paramVideoAppInterface = localObject;; paramVideoAppInterface = new lio(paramVideoAppInterface))
    {
      lek.c("BusinessHandlerFactory", "createHandler unknown name");
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        lek.c("BusinessHandlerFactory", "createHandler,cost time:" + (l2 - l1));
        return paramVideoAppInterface;
        paramVideoAppInterface = new liz(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new liw(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new lwb(paramVideoAppInterface);
      }
    }
  }
  
  public alpd a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      alpd localalpd = this.a[paramInt];
      localObject = localalpd;
      if (localalpd == null)
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
  
  public void a(lil paramlil)
  {
    paramlil.a("TransInfoCreate.CreateSession", new int[] { 1 });
    paramlil.a("TransInfo.JoinSession", new int[] { 0 });
    paramlil.a("TransInfo.ExitSession", new int[] { 0 });
    paramlil.a("TransInfo.ChangeSession", new int[] { 0 });
    paramlil.a("TransInfo.RawData", new int[] { 0 });
    paramlil.a("OidbSvc.0xa75", new int[] { 2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lja
 * JD-Core Version:    0.7.0.1
 */