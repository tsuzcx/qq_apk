import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class tew
  implements DialogInterface.OnDismissListener
{
  public tew(FastWebActivity paramFastWebActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Context localContext;
    if (!FastWebActivity.a(this.a))
    {
      localContext = this.a.getApplicationContext();
      if (!FastWebActivity.b(this.a)) {
        break label80;
      }
    }
    label80:
    for (paramDialogInterface = "0X8008994";; paramDialogInterface = "0X800898D")
    {
      tjt.a(localContext, paramDialogInterface, 11, this.a.a);
      tkj.a(this.a, this.a.getAppInterface(), this.a.a, -1, -1, true, false);
      FastWebActivity.c(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tew
 * JD-Core Version:    0.7.0.1
 */