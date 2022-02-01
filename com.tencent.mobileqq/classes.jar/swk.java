import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class swk
  implements DialogInterface.OnDismissListener
{
  public swk(FastWebActivity paramFastWebActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Context localContext;
    if (!FastWebActivity.c(this.a))
    {
      localContext = this.a.getApplicationContext();
      if (!FastWebActivity.d(this.a)) {
        break label86;
      }
    }
    label86:
    for (paramDialogInterface = "0X8008994";; paramDialogInterface = "0X800898D")
    {
      tbm.a(localContext, paramDialogInterface, 11, this.a.a);
      tcc.a(this.a, this.a.getAppInterface(), this.a.a, -1, -1, true, FastWebActivity.e(this.a));
      FastWebActivity.c(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swk
 * JD-Core Version:    0.7.0.1
 */