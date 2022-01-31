import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class tbb
{
  public static tbb a;
  
  public static tbb a()
  {
    if (a == null) {
      a = new tbb();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), mxh.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(tbd paramtbd, tbe paramtbe)
  {
    byte[] arrayOfByte = paramtbd.a();
    String str = paramtbd.a();
    long l = System.currentTimeMillis();
    a(paramtbd.a(), arrayOfByte, new tbc(this, l, paramtbd, str, paramtbe));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbb
 * JD-Core Version:    0.7.0.1
 */