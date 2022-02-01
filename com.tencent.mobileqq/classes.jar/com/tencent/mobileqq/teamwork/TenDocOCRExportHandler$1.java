package com.tencent.mobileqq.teamwork;

import amtj;
import android.os.Bundle;
import android.text.TextUtils;
import bcvf;
import bcvv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public class TenDocOCRExportHandler$1
  implements Runnable
{
  public TenDocOCRExportHandler$1(bcvv parambcvv, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a))) {
      return;
    }
    bcvv localbcvv = (bcvv)this.this$0.app.getBusinessHandler(157);
    JSONObject localJSONObject = bcvf.a(this.this$0.app, this.a, this.this$0.app.getCurrentAccountUin());
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
          localbcvv.notifyUI(3, true, new Object[] { localJSONObject });
          QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localbcvv.notifyUI(1, true, new Object[] { amtj.a(2131713875), this.a });
        localUnsupportedEncodingException.printStackTrace();
        return;
      }
      localbcvv.notifyUI(1, true, new Object[] { amtj.a(2131713874), this.a });
      return;
    }
    localbcvv.notifyUI(1, true, new Object[] { amtj.a(2131713873), this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.1
 * JD-Core Version:    0.7.0.1
 */