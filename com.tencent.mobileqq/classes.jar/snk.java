import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class snk
  implements DialogInterface.OnDismissListener
{
  public snk(FastWebActivity paramFastWebActivity) {}
  
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
      ssi.a(localContext, paramDialogInterface, 11, this.a.a);
      ssy.a(this.a, this.a.getAppInterface(), this.a.a, -1, -1, true, false);
      FastWebActivity.c(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snk
 * JD-Core Version:    0.7.0.1
 */