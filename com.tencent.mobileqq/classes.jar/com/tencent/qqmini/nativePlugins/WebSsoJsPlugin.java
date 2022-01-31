package com.tencent.qqmini.nativePlugins;

import alpo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import bfns;
import bfnt;
import bgkd;
import bket;
import bkeu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSsoJsPlugin
  extends BaseJsPlugin
  implements bket
{
  public static final String EVENT_QUERY_WEBSSO = "requestWebSSO";
  public static final String KEY_CMD = "cmd";
  public static final String KEY_RET = "ret";
  public static final String KEY_RSP = "rsp";
  public static final String KEY_SEQ = "mini_seq";
  private static final String TAG = "WebSsoJsPlugin";
  SparseArray<bgkd> callbackMap = new SparseArray();
  private int seq;
  
  public WebSsoJsPlugin()
  {
    bkeu.a().a(this);
  }
  
  private int genSeq()
  {
    try
    {
      int i = this.seq;
      this.seq = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private JSONObject getParam(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("WebSsoJsPlugin", "Failed to parse jsonParams=" + parambgkd.b);
    }
    return null;
  }
  
  public HashSet<String> getFilterCmds()
  {
    bfns localbfns = (bfns)bfnt.a().a("comminfo");
    if (localbfns != null) {
      return localbfns.a();
    }
    return bkeu.a;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("mini_seq", -1);
      if (i != -1) {
        break label26;
      }
    }
    label26:
    bgkd localbgkd;
    do
    {
      return;
      i = -1;
      break;
      localbgkd = (bgkd)this.callbackMap.get(i);
      this.callbackMap.remove(i);
    } while (localbgkd == null);
    paramIntent = paramJSONObject;
    if (paramJSONObject == null) {
      paramIntent = new JSONObject();
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("cmd", paramString);
      paramJSONObject.put("ret", paramLong);
      paramJSONObject.put("rsp", paramIntent);
      if (paramLong == 0L)
      {
        localbgkd.a(paramJSONObject);
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
      localbgkd.a(paramJSONObject, "");
    }
  }
  
  public void requestWebSSO(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = getParam(parambgkd).getJSONObject("data");
      String str = localJSONObject.getString("webssoCmdId");
      localJSONObject = localJSONObject.getJSONObject("webssoReq");
      Object localObject = getFilterCmds();
      if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((HashSet)localObject).contains(str)))
      {
        parambgkd.a(alpo.a(2131717273));
        return;
      }
      int i = genSeq();
      this.callbackMap.put(i, parambgkd);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("mini_seq", i);
      bkeu.a().a(str, localJSONObject, (Bundle)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      parambgkd.a(alpo.a(2131717272));
      if (QLog.isColorLevel()) {
        QLog.w("WebSsoJsPlugin", 2, "requestWebSSO,decode param error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.WebSsoJsPlugin
 * JD-Core Version:    0.7.0.1
 */