import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class sof
{
  public static sof a;
  
  public static sof a()
  {
    if (a == null) {
      a = new sof();
    }
    return a;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), mmi.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
  
  public void a(soh paramsoh, soi paramsoi)
  {
    byte[] arrayOfByte = paramsoh.a();
    String str = paramsoh.a();
    long l = System.currentTimeMillis();
    a(paramsoh.a(), arrayOfByte, new sog(this, l, paramsoh, str, paramsoi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sof
 * JD-Core Version:    0.7.0.1
 */