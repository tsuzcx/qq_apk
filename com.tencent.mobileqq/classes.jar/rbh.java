import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.persist.DBHandler;

public class rbh
  implements Runnable
{
  private ResultObject a;
  
  public rbh(ResultObject paramResultObject)
  {
    this.a = paramResultObject;
  }
  
  public void run()
  {
    if (MagnifierSDK.a != null) {
      MagnifierSDK.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbh
 * JD-Core Version:    0.7.0.1
 */