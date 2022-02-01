package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import android.text.TextUtils;
import anvx;
import bece;
import becu;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public class TenDocOCRExportHandler$1
  implements Runnable
{
  public TenDocOCRExportHandler$1(becu parambecu, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a))) {
      return;
    }
    becu localbecu = (becu)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_OCR_EXPORT_HANDLER);
    JSONObject localJSONObject = bece.a(this.this$0.app, this.a, this.this$0.app.getCurrentAccountUin());
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
          localbecu.notifyUI(3, true, new Object[] { localJSONObject });
          QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localbecu.notifyUI(1, true, new Object[] { anvx.a(2131714222), this.a });
        localUnsupportedEncodingException.printStackTrace();
        return;
      }
      localbecu.notifyUI(1, true, new Object[] { anvx.a(2131714221), this.a });
      return;
    }
    localbecu.notifyUI(1, true, new Object[] { anvx.a(2131714220), this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.1
 * JD-Core Version:    0.7.0.1
 */