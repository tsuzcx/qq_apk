import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;

public class lgj
{
  private final BusinessHandler[] a = new BusinessHandler[5];
  
  private BusinessHandler b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      lbd.f("BusinessHandlerFactory", "createHandler unknown name");
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      lbd.f("BusinessHandlerFactory", "createHandler,cost time = [" + (l2 - l1) + "]");
      return paramVideoAppInterface;
      paramVideoAppInterface = new lgi(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lgf(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ltu(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new lfx(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new mxc(paramVideoAppInterface);
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
  
  public void a(lft paramlft)
  {
    paramlft.a("TransInfoCreate.CreateSession", new int[] { 1 });
    paramlft.a("TransInfo.JoinSession", new int[] { 0 });
    paramlft.a("TransInfo.ExitSession", new int[] { 0 });
    paramlft.a("TransInfo.ChangeSession", new int[] { 0 });
    paramlft.a("TransInfo.RawData", new int[] { 0 });
    paramlft.a("OidbSvc.0xa75", new int[] { 2 });
    String[] arrayOfString = mxc.a();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          paramlft.a(str, new int[] { 4 }, true);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgj
 * JD-Core Version:    0.7.0.1
 */