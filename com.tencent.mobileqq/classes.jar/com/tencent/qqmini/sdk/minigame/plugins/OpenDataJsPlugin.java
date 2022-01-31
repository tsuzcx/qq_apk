package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import bdcy;
import bdfz;
import bdox;
import bdqa;
import bdrb;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenDataJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "OpenDataJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void getFriendCloudStorage(bdfz parambdfz)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambdfz.b).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getFriendCloudStorage(arrayOfString, parambdfz);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambdfz)
    {
      bdrb.a().e("OpenDataJsPlugin", "handleNativeRequest getFriendCloudStorage error " + parambdfz.getMessage());
      return;
    }
  }
  
  public void getFriendCloudStorage(String[] paramArrayOfString, bdfz parambdfz)
  {
    bdrb localbdrb = bdrb.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage appid:").append(bdqa.a().a()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbdrb.i("OpenDataJsPlugin", str);
      this.mChannelProxy.getFriendCloudStorage(bdqa.a().a(), paramArrayOfString, new OpenDataJsPlugin.3(this, parambdfz));
      return;
    }
  }
  
  public void getGroupCloudStorage(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
      String str = ((JSONObject)localObject).optString("shareTicket");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyList");
      if (localJSONArray != null)
      {
        localObject = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          localObject[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getGroupCloudStorage(str, (String[])localObject, parambdfz);
        return;
        localObject = new String[0];
      }
    }
    catch (Throwable parambdfz)
    {
      bdrb.a().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + parambdfz.getMessage());
      return;
    }
  }
  
  public void getGroupCloudStorage(String paramString, String[] paramArrayOfString, bdfz parambdfz)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("state", "fail");
        parambdfz.a(paramString, "当前小程序不是从群分享卡片打开");
        return;
      }
      catch (JSONException paramString)
      {
        bdrb.a().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramString.getMessage());
        parambdfz.b();
        return;
      }
    }
    this.mChannelProxy.getGroupCloudStorage(bdqa.a().a(), paramString, paramArrayOfString, new OpenDataJsPlugin.2(this, parambdfz));
  }
  
  public void getOpenDataContext(bdfz parambdfz) {}
  
  public void getUserCloudStorage(bdfz parambdfz)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambdfz.b).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getUserCloudStorage(arrayOfString, parambdfz);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambdfz)
    {
      bdrb.a().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + parambdfz.getMessage());
      return;
    }
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, bdfz parambdfz)
  {
    bdrb localbdrb = bdrb.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getUserCloudStorage appid:").append(bdqa.a().a()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbdrb.i("OpenDataJsPlugin", str);
      if ((paramArrayOfString != null) && (parambdfz.a != null)) {
        break;
      }
      return;
    }
    parambdfz = new OpenDataJsPlugin.1(this, parambdfz);
    this.mChannelProxy.getUserCloudStorage(bdqa.a().a(), paramArrayOfString, parambdfz);
  }
  
  public void onMessage(bdfz parambdfz)
  {
    Object localObject;
    if (this.mIsMiniGame) {
      localObject = (bdox)parambdfz.a;
    }
    while (localObject != null) {
      if (((bdox)localObject).a() == 1)
      {
        localObject = this.mMiniAppInfo;
        if ((localObject != null) && (((MiniAppInfo)localObject).whiteList != null) && (((MiniAppInfo)localObject).whiteList.contains("onMessage")))
        {
          parambdfz.a.a("onMessage", parambdfz.b, 0);
          sendSubscribeEvent("onMessage", parambdfz.b);
          return;
          localObject = null;
        }
        else
        {
          bdrb.a().e("OpenDataJsPlugin", "开放域调用了未授权的私有API: postMessage -> onMessage");
          bdrb.a("error 开放域调用了未授权的私有API: postMessage");
        }
      }
      else
      {
        parambdfz.a.a("onMessage", parambdfz.b, 0);
        return;
      }
    }
    bdrb.a().e("OpenDataJsPlugin", "handleNativeRequest onMessage error, not gameJsRuntime!");
  }
  
  public void removeUserCloudStorage(bdfz parambdfz)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambdfz.b).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        removeUserCloudStorage(arrayOfString, parambdfz);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambdfz)
    {
      bdrb.a().e("OpenDataJsPlugin", "handleNativeRequest removeUserCloudStorage error " + parambdfz.getMessage());
      return;
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, bdfz parambdfz)
  {
    bdrb localbdrb = bdrb.a();
    StringBuilder localStringBuilder = new StringBuilder().append("removeUserCloudStorage appid:").append(bdqa.a().a()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbdrb.i("OpenDataJsPlugin", str);
      this.mChannelProxy.removeUserCloudStorage(bdqa.a().a(), paramArrayOfString, new OpenDataJsPlugin.5(this, parambdfz));
      return;
    }
  }
  
  public void setUserCloudStorage(bdfz parambdfz)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambdfz.b).optJSONArray("KVDataList");
      HashMap localHashMap = new HashMap();
      if (localJSONArray != null)
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          localHashMap.put(localJSONObject.get("key").toString(), localJSONObject.get("value").toString());
          i += 1;
        }
      }
      setUserCloudStorage(localHashMap, parambdfz);
      return;
    }
    catch (Throwable parambdfz)
    {
      bdrb.a().e("OpenDataJsPlugin", "handleNativeRequest setUserCloudStorage error " + parambdfz.getMessage());
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, bdfz parambdfz)
  {
    bdrb localbdrb = bdrb.a();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage appid:").append(bdqa.a().a()).append(", kvData:");
    if (paramHashMap != null) {}
    for (String str = paramHashMap.toString();; str = "")
    {
      localbdrb.i("OpenDataJsPlugin", str);
      this.mChannelProxy.setUserCloudStorage(bdqa.a().a(), paramHashMap, new OpenDataJsPlugin.4(this, parambdfz));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */