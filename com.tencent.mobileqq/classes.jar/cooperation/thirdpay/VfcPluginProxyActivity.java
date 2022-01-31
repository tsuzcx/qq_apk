package cooperation.thirdpay;

import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class VfcPluginProxyActivity
  extends PluginProxyActivity
{
  public boolean isWrapContent()
  {
    boolean bool = false;
    if (super.getIntent() != null) {
      bool = super.getIntent().getBooleanExtra("QWalletExtra.isFling", false);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.thirdpay.VfcPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */