import android.view.View;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mto
{
  public static int a(View paramView, int paramInt)
  {
    paramView = paramView.getTag(paramInt);
    if (paramView == null) {
      return 2147483647;
    }
    if ((paramView instanceof Integer)) {
      return ((Integer)paramView).intValue();
    }
    a("getInt", paramInt, paramView);
    return 2147483647;
  }
  
  public static String a(View paramView, int paramInt)
  {
    paramView = paramView.getTag(paramInt);
    if (paramView == null) {
      return null;
    }
    if ((paramView instanceof String)) {
      return (String)paramView;
    }
    a("getStr", paramInt, paramView);
    return null;
  }
  
  static void a(String paramString, int paramInt, Object paramObject)
  {
    if (AudioHelper.d())
    {
      paramString = paramString + ajya.a(2131714736) + paramInt + "], object[" + paramObject.getClass().getSimpleName() + "]";
      QLog.w("TagIndex", 1, paramString, new Throwable("打印调用栈"));
      throw new ClassCastException(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mto
 * JD-Core Version:    0.7.0.1
 */