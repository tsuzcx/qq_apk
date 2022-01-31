package cooperation.thirdpay;

import amon;
import amoo;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

@TargetApi(10)
public class NFCPayPluginProxyActivity
  extends PluginProxyActivity
{
  protected PendingIntent a;
  protected NfcAdapter a;
  protected IntentFilter[] a;
  protected String[][] a;
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardPayPluginProxyActivity", 2, "get NfcAdapter");
    }
    this.jdField_a_of_type_AndroidNfcNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    if (this.jdField_a_of_type_AndroidNfcNfcAdapter != null) {
      if (!this.jdField_a_of_type_AndroidNfcNfcAdapter.isEnabled()) {
        DialogUtil.a(this, 0, "", "请到设置界面打开NFC功能", new amon(this), new amoo(this)).show();
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      b();
      return;
    }
    QLog.i("CardPayPluginProxyActivity", 2, "nfcAdapter null");
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidAppPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(536870912), 0);
    try
    {
      String str1 = IsoDep.class.getName();
      String[] arrayOfString1 = { NfcV.class.getName() };
      String str2 = NfcF.class.getName();
      String[] arrayOfString2 = { MifareClassic.class.getName() };
      String str3 = NfcA.class.getName();
      this.jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { str1 }, arrayOfString1, { str2 }, arrayOfString2, { str3 } };
      this.jdField_a_of_type_ArrayOfAndroidContentIntentFilter = new IntentFilter[] { new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*") };
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    paramIntent.putExtra("cleartop", true);
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("CardPayPluginProxyActivity", 2, "onNewIntent");
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_AndroidNfcNfcAdapter != null) {
      this.jdField_a_of_type_AndroidNfcNfcAdapter.disableForegroundDispatch(this);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("CardPayPluginProxyActivity", 2, "nfcAdapter null");
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_AndroidNfcNfcAdapter != null) && (this.jdField_a_of_type_AndroidNfcNfcAdapter.isEnabled()))
    {
      if ((this.jdField_a_of_type_AndroidAppPendingIntent == null) || (this.jdField_a_of_type_ArrayOfAndroidContentIntentFilter == null) || (this.jdField_a_of_type_Array2dOfJavaLangString == null)) {
        b();
      }
      this.jdField_a_of_type_AndroidNfcNfcAdapter.enableForegroundDispatch(this, this.jdField_a_of_type_AndroidAppPendingIntent, this.jdField_a_of_type_ArrayOfAndroidContentIntentFilter, this.jdField_a_of_type_Array2dOfJavaLangString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("CardPayPluginProxyActivity", 2, "nfcAdapter null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.thirdpay.NFCPayPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */