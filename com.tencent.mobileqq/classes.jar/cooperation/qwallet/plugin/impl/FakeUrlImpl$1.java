package cooperation.qwallet.plugin.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qwallet.plugin.IFakeUrl.FakeListener;

class FakeUrlImpl$1
  implements DialogInterface.OnClickListener
{
  FakeUrlImpl$1(FakeUrlImpl paramFakeUrlImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.fl != null) {
      this.this$0.fl.onBlHandleFakeurl(this.this$0.fakeInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.FakeUrlImpl.1
 * JD-Core Version:    0.7.0.1
 */