import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import com.tencent.qphone.base.util.QLog;

public class rcl
  implements APICallback
{
  public rcl(TestAppFragment paramTestAppFragment) {}
  
  public void a()
  {
    this.a.a.append("onComplete\n");
    QLog.d("DoraemonOpenAPI.test", 2, "onComplete");
  }
  
  public void a(int paramInt)
  {
    this.a.a.append("onPermission " + paramInt + "\n");
    QLog.d("DoraemonOpenAPI.test", 2, "onPermission: " + paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a.append("onFailure code=" + paramInt + " msg=" + paramString + "\n");
    QLog.d("DoraemonOpenAPI.test", 2, "onFailure code=" + paramInt + " msg=" + paramString);
  }
  
  public void a(APIParam paramAPIParam)
  {
    this.a.a.append("onSuccess " + paramAPIParam + "\n");
    StringBuilder localStringBuilder = new StringBuilder().append("onSuccess: ");
    if (paramAPIParam != null) {}
    for (paramAPIParam = paramAPIParam.toJSONString();; paramAPIParam = null)
    {
      QLog.d("DoraemonOpenAPI.test", 2, paramAPIParam);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rcl
 * JD-Core Version:    0.7.0.1
 */