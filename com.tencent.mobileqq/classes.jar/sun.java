import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class sun
  extends sok<ssm, son<ssm>>
{
  private int a;
  
  public sun(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    ssm localssm = (ssm)a(paramInt);
    if (localssm != null) {
      return localssm.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((ssm)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(son<ssm> paramson)
  {
    super.onViewDetachedFromWindow(paramson);
    paramson.a();
  }
  
  public son b(ViewGroup paramViewGroup, int paramInt)
  {
    return swa.a(paramViewGroup, paramInt);
  }
  
  public void b(son paramson, int paramInt)
  {
    paramson.a((ssm)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sun
 * JD-Core Version:    0.7.0.1
 */