package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import java.util.Map;
import org.json.JSONObject;

class NowUIJs$3
  implements DialogInterface.OnClickListener
{
  NowUIJs$3(NowUIJs paramNowUIJs, Map paramMap) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (String)this.a.get("callback");
    NowUIJs.access$100(this.b).callJs(paramDialogInterface, new String[] { new JSONObject().toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs.3
 * JD-Core Version:    0.7.0.1
 */