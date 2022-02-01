import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;

public class lfx
{
  private BusinessHandler[] a = new BusinessHandler[4];
  
  private BusinessHandler b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (paramVideoAppInterface = localObject;; paramVideoAppInterface = new lfl(paramVideoAppInterface))
    {
      lba.f("BusinessHandlerFactory", "createHandler unknown name");
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        lba.f("BusinessHandlerFactory", "createHandler,cost time = [" + (l2 - l1) + "]");
        return paramVideoAppInterface;
        paramVideoAppInterface = new lfw(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new lft(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new lth(paramVideoAppInterface);
      }
    }
  }
  
  public BusinessHandler a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      BusinessHandler localBusinessHandler = this.a[paramInt];
      localObject = localBusinessHandler;
      if (localBusinessHandler == null)
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
  
  public void a(lfh paramlfh)
  {
    paramlfh.a("TransInfoCreate.CreateSession", new int[] { 1 });
    paramlfh.a("TransInfo.JoinSession", new int[] { 0 });
    paramlfh.a("TransInfo.ExitSession", new int[] { 0 });
    paramlfh.a("TransInfo.ChangeSession", new int[] { 0 });
    paramlfh.a("TransInfo.RawData", new int[] { 0 });
    paramlfh.a("OidbSvc.0xa75", new int[] { 2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfx
 * JD-Core Version:    0.7.0.1
 */