import com.tencent.av.app.VideoAppInterface;

public class lfv
{
  private anii[] a = new anii[4];
  
  private anii b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (paramVideoAppInterface = localObject;; paramVideoAppInterface = new lfj(paramVideoAppInterface))
    {
      lbc.c("BusinessHandlerFactory", "createHandler unknown name");
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        lbc.c("BusinessHandlerFactory", "createHandler,cost time:" + (l2 - l1));
        return paramVideoAppInterface;
        paramVideoAppInterface = new lfu(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new lfr(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new ltd(paramVideoAppInterface);
      }
    }
  }
  
  public anii a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      anii localanii = this.a[paramInt];
      localObject = localanii;
      if (localanii == null)
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
  
  public void a(lfg paramlfg)
  {
    paramlfg.a("TransInfoCreate.CreateSession", new int[] { 1 });
    paramlfg.a("TransInfo.JoinSession", new int[] { 0 });
    paramlfg.a("TransInfo.ExitSession", new int[] { 0 });
    paramlfg.a("TransInfo.ChangeSession", new int[] { 0 });
    paramlfg.a("TransInfo.RawData", new int[] { 0 });
    paramlfg.a("OidbSvc.0xa75", new int[] { 2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfv
 * JD-Core Version:    0.7.0.1
 */