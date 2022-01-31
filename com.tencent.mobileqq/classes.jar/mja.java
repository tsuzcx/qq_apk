import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class mja
  extends bdjz
{
  public mja(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static bdjz a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new mja(paramContext, 2131755801);
    paramContext.setContentView(2131558942);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    QLog.w("MultiVideoEnterPageActivity", 1, "onWindowFocusChanged, hasFocus[" + paramBoolean + "]");
    if (!paramBoolean) {
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mja
 * JD-Core Version:    0.7.0.1
 */