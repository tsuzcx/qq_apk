package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

class TenDocOCRExportHandler$1
  implements Runnable
{
  TenDocOCRExportHandler$1(TenDocOCRExportHandler paramTenDocOCRExportHandler, String paramString) {}
  
  public void run()
  {
    if ((TenDocOCRExportHandler.a(this.this$0) == null) || (TextUtils.isEmpty(this.a))) {
      return;
    }
    TenDocOCRExportHandler localTenDocOCRExportHandler = (TenDocOCRExportHandler)TenDocOCRExportHandler.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_OCR_EXPORT_HANDLER);
    JSONObject localJSONObject = TeamWorkHttpUtils.a(TenDocOCRExportHandler.a(this.this$0), this.a, TenDocOCRExportHandler.a(this.this$0).getCurrentAccountUin());
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
          localTenDocOCRExportHandler.notifyUI(3, true, new Object[] { localJSONObject });
          QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localTenDocOCRExportHandler.notifyUI(1, true, new Object[] { HardCodeUtil.a(2131714718), this.a });
        localUnsupportedEncodingException.printStackTrace();
        return;
      }
      localTenDocOCRExportHandler.notifyUI(1, true, new Object[] { HardCodeUtil.a(2131714717), this.a });
      return;
    }
    localTenDocOCRExportHandler.notifyUI(1, true, new Object[] { HardCodeUtil.a(2131714716), this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.1
 * JD-Core Version:    0.7.0.1
 */