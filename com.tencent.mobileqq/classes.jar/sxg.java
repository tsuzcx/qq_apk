import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class sxg
  extends swk
  implements slx<sxi, sxj>
{
  public List<String> a = new ArrayList();
  
  public sxg(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    sxi localsxi = new sxi();
    localsxi.c = 1;
    localsxi.a = this.a;
    slv.a().a(localsxi, this);
  }
  
  public void a(@NonNull sxi paramsxi, @Nullable sxj paramsxj, @NonNull ErrorMessage paramErrorMessage)
  {
    paramsxi = new sxh(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramsxj != null) && (paramsxj.a != null))
    {
      paramsxi.a = paramsxj.a;
      b();
    }
    for (;;)
    {
      sgi.a().dispatch(paramsxi);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxg
 * JD-Core Version:    0.7.0.1
 */