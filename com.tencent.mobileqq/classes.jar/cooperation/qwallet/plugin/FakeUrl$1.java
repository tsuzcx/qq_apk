package cooperation.qwallet.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FakeUrl$1
  implements DialogInterface.OnClickListener
{
  FakeUrl$1(FakeUrl paramFakeUrl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.fl != null) {
      this.this$0.fl.onBlHandleFakeurl(this.this$0.fakeInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.FakeUrl.1
 * JD-Core Version:    0.7.0.1
 */