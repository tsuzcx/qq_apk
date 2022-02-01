package cooperation.qwallet.plugin.pay;

import android.content.Intent;

public class PayLogic$OnActivityResult
{
  public Intent data;
  public int requestCode;
  public int resultCode;
  
  public PayLogic$OnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.requestCode = paramInt1;
    this.resultCode = paramInt2;
    this.data = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.pay.PayLogic.OnActivityResult
 * JD-Core Version:    0.7.0.1
 */