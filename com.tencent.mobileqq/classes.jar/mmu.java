import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;

public class mmu
  implements DialogInterface.OnDismissListener
{
  public mmu(FastWebActivity paramFastWebActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Context localContext;
    if (!FastWebActivity.b(this.a))
    {
      localContext = this.a.getApplicationContext();
      if (!FastWebActivity.a(this.a)) {
        break label55;
      }
    }
    label55:
    for (paramDialogInterface = "0X8008994";; paramDialogInterface = "0X800898D")
    {
      FastWebShareUtils.a(localContext, paramDialogInterface, 11, FastWebActivity.a(this.a));
      FastWebActivity.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmu
 * JD-Core Version:    0.7.0.1
 */