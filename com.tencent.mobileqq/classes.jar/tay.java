import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class tay
{
  public static tay a;
  
  public static tay a()
  {
    if (a == null) {
      a = new tay();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), mxe.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(tba paramtba, tbb paramtbb)
  {
    byte[] arrayOfByte = paramtba.a();
    String str = paramtba.a();
    long l = System.currentTimeMillis();
    a(paramtba.a(), arrayOfByte, new taz(this, l, paramtba, str, paramtbb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tay
 * JD-Core Version:    0.7.0.1
 */