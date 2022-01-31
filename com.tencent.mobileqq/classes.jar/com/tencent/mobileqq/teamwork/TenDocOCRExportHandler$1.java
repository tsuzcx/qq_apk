package com.tencent.mobileqq.teamwork;

import ajjy;
import android.os.Bundle;
import android.text.TextUtils;
import axfe;
import axfv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public class TenDocOCRExportHandler$1
  implements Runnable
{
  public TenDocOCRExportHandler$1(axfv paramaxfv, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a))) {
      return;
    }
    axfv localaxfv = (axfv)this.this$0.app.a(157);
    JSONObject localJSONObject = axfe.a(this.this$0.app, this.a, this.this$0.app.getCurrentAccountUin());
    if (localJSONObject != null)
    {
      String str = localJSONObject.optString("url");
      int i = localJSONObject.optInt("ret");
      try
      {
        str = URLDecoder.decode(str, "UTF-8");
        if ((i == 0) && (str.length() > 0))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("url", str);
          localaxfv.notifyUI(3, true, new Object[] { localJSONObject });
          QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localaxfv.notifyUI(1, true, new Object[] { ajjy.a(2131649050), this.a });
        localUnsupportedEncodingException.printStackTrace();
        return;
      }
      localaxfv.notifyUI(1, true, new Object[] { ajjy.a(2131649049), this.a });
      return;
    }
    localaxfv.notifyUI(1, true, new Object[] { ajjy.a(2131649048), this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.1
 * JD-Core Version:    0.7.0.1
 */