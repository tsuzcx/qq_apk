package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppProxyImpl$14
  implements IActivityResultListener
{
  MiniAppProxyImpl$14(MiniAppProxyImpl paramMiniAppProxyImpl, AsyncResult paramAsyncResult, IActivityResultManager paramIActivityResultManager) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnActivityResult requestCode=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",resultCode=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",data=");
    ((StringBuilder)localObject).append(paramIntent);
    QLog.d("MiniAppProxyImpl", 2, ((StringBuilder)localObject).toString());
    if (paramInt1 == 3)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("name");
        String str = paramIntent.getStringExtra("address");
        double d1 = paramIntent.getIntExtra("latitude", 0);
        Double.isNaN(d1);
        d1 /= 1000000.0D;
        double d2 = paramIntent.getIntExtra("longitude", 0);
        Double.isNaN(d2);
        d2 /= 1000000.0D;
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("doOnActivityResult name=");
          paramIntent.append((String)localObject);
          paramIntent.append(",address=");
          paramIntent.append(str);
          paramIntent.append(",latitude=");
          paramIntent.append(d1);
          paramIntent.append(",longitude=");
          paramIntent.append(d2);
          QLog.d("MiniAppProxyImpl", 2, paramIntent.toString());
        }
        paramIntent = new JSONObject();
        try
        {
          paramIntent.put("name", localObject);
          paramIntent.put("address", str);
          paramIntent.put("latitude", d1);
          paramIntent.put("longitude", d2);
          this.a.onReceiveResult(true, paramIntent);
        }
        catch (JSONException paramIntent)
        {
          QLog.e("MiniAppProxyImpl", 1, " error, ", paramIntent);
          this.a.onReceiveResult(false, new JSONObject());
        }
      }
      this.b.removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.14
 * JD-Core Version:    0.7.0.1
 */