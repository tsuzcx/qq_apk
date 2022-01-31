import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class rip
  implements DialogInterface.OnDismissListener
{
  public rip(FastWebActivity paramFastWebActivity) {}
  
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
      rmy.a(localContext, paramDialogInterface, 11, FastWebActivity.a(this.a));
      rno.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), -1, -1, true);
      FastWebActivity.d(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rip
 * JD-Core Version:    0.7.0.1
 */