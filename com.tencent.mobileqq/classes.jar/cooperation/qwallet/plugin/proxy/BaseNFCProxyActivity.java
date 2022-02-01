package cooperation.qwallet.plugin.proxy;

import Override;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.ReaderCallback;
import android.os.Bundle;
import android.view.MotionEvent;
import anni;
import bglp;
import bgpa;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    bglp.a(this, 0, paramString1, paramString2, anni.a(2131699850), anni.a(2131699851), new BaseNFCProxyActivity.1(this), new BaseNFCProxyActivity.2(this)).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.proxy.BaseNFCProxyActivity
 * JD-Core Version:    0.7.0.1
 */