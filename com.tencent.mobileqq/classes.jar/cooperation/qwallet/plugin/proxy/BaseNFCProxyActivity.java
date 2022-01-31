package cooperation.qwallet.plugin.proxy;

import ajyc;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.ReaderCallback;
import android.os.Bundle;
import bbcv;
import bbgg;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardHelper;

@TargetApi(19)
public class BaseNFCProxyActivity
  extends PluginProxyActivity
{
  private IntentFilter[] intentFiltersArray;
  private boolean isHasNfcPermission = true;
  public NfcAdapter.ReaderCallback mReaderCallback;
  private NfcAdapter nfcAdapter;
  private PendingIntent pendingIntent;
  private String[][] techListsArray;
  
  private void showNoNfcDialog(String paramString1, String paramString2)
  {
    bbcv.a(this, 0, paramString1, paramString2, ajyc.a(2131701034), ajyc.a(2131701035), new BaseNFCProxyActivity.1(this), new BaseNFCProxyActivity.2(this)).show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    if (this.nfcAdapter == null) {}
    do
    {
      return;
      if (!this.nfcAdapter.isEnabled())
      {
        showNoNfcDialog("NFC未开启", "请在设置界面开启NFC功能");
        return;
      }
      this.isHasNfcPermission = BuscardHelper.a(this);
    } while (this.isHasNfcPermission);
    showNoNfcDialog("无NFC权限", "请重新打开手Q的NFC权限");
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    paramIntent.putExtra("cleartop", true);
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("BaseNFCProxyActivity", 2, "onNewIntent");
    }
  }
  
  public void onPause()
  {
    BuscardHelper.a(this, true, getIntent().getStringExtra("buscard_pluginNewNfcAPIFlag"), getIntent().getStringExtra("buscard_pluginNewNfcAPIBlackModel"));
    if (QLog.isColorLevel()) {
      QLog.i("BaseNFCProxyActivity", 2, "onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    BuscardHelper.a(this, true, getIntent().getStringExtra("buscard_pluginNewNfcAPIFlag"), getIntent().getStringExtra("buscard_pluginNewNfcAPIBlackModel"), null);
    if (QLog.isColorLevel()) {
      QLog.i("BaseNFCProxyActivity", 2, "onResume");
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.proxy.BaseNFCProxyActivity
 * JD-Core Version:    0.7.0.1
 */