package cooperation.qwallet.plugin.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IFakeUrl.FakeInfo;
import cooperation.qwallet.plugin.IFakeUrl.FakeListener;

class FakeUrlImpl$2
  implements DialogInterface.OnClickListener
{
  FakeUrlImpl$2(FakeUrlImpl paramFakeUrlImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.this$0.fl != null) && (this.this$0.fl.onBlHandleFakeurl(this.this$0.fakeInfo, 1)))
    {
      QLog.i("FakeUrl", 2, "bl has handled fake url...");
      return;
    }
    this.this$0.parseFakeUrl(this.this$0.fakeInfo.retUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.FakeUrlImpl.2
 * JD-Core Version:    0.7.0.1
 */