package com.tencent.mobileqq.teamwork;

import alpo;
import android.os.Bundle;
import android.text.TextUtils;
import badg;
import badw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public class TenDocOCRExportHandler$1
  implements Runnable
{
  public TenDocOCRExportHandler$1(badw parambadw, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a))) {
      return;
    }
    badw localbadw = (badw)this.this$0.app.a(157);
    JSONObject localJSONObject = badg.a(this.this$0.app, this.a, this.this$0.app.getCurrentAccountUin());
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
          localbadw.notifyUI(3, true, new Object[] { localJSONObject });
          QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localbadw.notifyUI(1, true, new Object[] { alpo.a(2131715222), this.a });
        localUnsupportedEncodingException.printStackTrace();
        return;
      }
      localbadw.notifyUI(1, true, new Object[] { alpo.a(2131715221), this.a });
      return;
    }
    localbadw.notifyUI(1, true, new Object[] { alpo.a(2131715220), this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.1
 * JD-Core Version:    0.7.0.1
 */