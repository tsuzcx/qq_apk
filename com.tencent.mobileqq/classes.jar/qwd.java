import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class qwd
  implements DialogInterface.OnDismissListener
{
  public qwd(FastWebActivity paramFastWebActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Context localContext;
    if (!FastWebActivity.a(this.a))
    {
      localContext = this.a.getApplicationContext();
      if (!FastWebActivity.b(this.a)) {
        break label79;
      }
    }
    label79:
    for (paramDialogInterface = "0X8008994";; paramDialogInterface = "0X800898D")
    {
      raj.a(localContext, paramDialogInterface, 11, FastWebActivity.a(this.a));
      raz.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), -1, -1, true);
      FastWebActivity.c(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwd
 * JD-Core Version:    0.7.0.1
 */