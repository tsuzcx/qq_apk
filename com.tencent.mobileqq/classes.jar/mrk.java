import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class mrk
  implements DialogInterface.OnClickListener
{
  public mrk(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ThreadManager.post(new mrl(this), 10, null, true);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrk
 * JD-Core Version:    0.7.0.1
 */