import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class mgn
  extends bbgg
{
  public mgn(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static bbgg a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new mgn(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgn
 * JD-Core Version:    0.7.0.1
 */