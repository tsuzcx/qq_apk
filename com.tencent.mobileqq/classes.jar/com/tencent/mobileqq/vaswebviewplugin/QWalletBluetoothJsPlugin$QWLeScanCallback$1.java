package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class QWalletBluetoothJsPlugin$QWLeScanCallback$1
  implements Runnable
{
  QWalletBluetoothJsPlugin$QWLeScanCallback$1(QWalletBluetoothJsPlugin.QWLeScanCallback paramQWLeScanCallback, QWalletBluetoothJsPlugin paramQWalletBluetoothJsPlugin) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$1.getTempDevices();
      if (((List)localObject).size() > 0)
      {
        JSONObject localJSONObject = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localJSONArray.put(QWalletBluetoothJsPlugin.access$800((QWalletBluetoothJsPlugin.BluetoothDeviceExtend)((Iterator)localObject).next()));
        }
        localJSONObject.put("devices", localJSONArray);
        QWalletBluetoothJsPlugin.access$200(this.this$1.this$0, "onBluetoothDeviceFound", localJSONObject.toString());
        ThreadManager.getUIHandler().postDelayed(this, QWalletBluetoothJsPlugin.QWLeScanCallback.access$900(this.this$1) * 1000);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.QWLeScanCallback.1
 * JD-Core Version:    0.7.0.1
 */