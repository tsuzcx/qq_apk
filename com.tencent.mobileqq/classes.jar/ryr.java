import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ryr
  implements InvocationHandler
{
  public ryr(FastWebActivity.25.2 param2) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    this.a.a.a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    FastWebActivity.a(this.a.a.a).setVisibility(8);
    QLog.d(FastWebActivity.a(this.a.a.a), 1, "open web page, set activity transparent");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ryr
 * JD-Core Version:    0.7.0.1
 */