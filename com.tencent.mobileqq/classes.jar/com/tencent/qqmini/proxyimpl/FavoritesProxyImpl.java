package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy;
import com.tencent.qqmini.sdk.launcher.model.InnerFavoritesData;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@ProxyService(proxy=FavoritesProxy.class)
public class FavoritesProxyImpl
  implements FavoritesProxy
{
  String a = "arkAppInfo";
  String b = "appName";
  String c = "appView";
  String d = "metaData";
  String e = "appMinVersion";
  String f = "appConfig";
  String g = "appDesc";
  String h = "promptText";
  String i = "compatibleText";
  
  private void b(InnerFavoritesData paramInnerFavoritesData)
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localQQAppInterface.getApplication().getString(2131889205));
        ((StringBuilder)localObject2).append(paramInnerFavoritesData.title);
        localObject2 = ((StringBuilder)localObject2).toString();
        String str1 = paramInnerFavoritesData.entryPath;
        String str2 = localQQAppInterface.getApplication().getString(2131889204);
        String str3 = paramInnerFavoritesData.summary;
        String str4 = paramInnerFavoritesData.picPath;
        JSONObject localJSONObject = new JSONObject(paramInnerFavoritesData.bizDataList);
        paramInnerFavoritesData = new ArrayList();
        Object localObject3 = new JSONObject();
        ((JSONObject)localObject3).put(this.b, localJSONObject.optString("appName"));
        ((JSONObject)localObject3).put(this.c, localJSONObject.optString("appView"));
        ((JSONObject)localObject3).put(this.d, localJSONObject.optJSONObject("metaData").toString());
        ((JSONObject)localObject3).put(this.e, localJSONObject.optString("appMinVersion"));
        ((JSONObject)localObject3).put(this.f, localJSONObject.optJSONObject("appConfig").toString());
        ((JSONObject)localObject3).put(this.h, localJSONObject.optString("promptText"));
        localJSONObject = new JSONObject();
        localJSONObject.put(this.a, localObject3);
        paramInnerFavoritesData.add(localJSONObject.toString().getBytes());
        localObject3 = new MessageRecord();
        ((MessageRecord)localObject3).senderuin = localQQAppInterface.getAccount();
        localObject1 = ((AppRuntime)localObject1).getApplication().getApplicationContext();
        ThreadManager.getUIHandler().post(new FavoritesProxyImpl.1(this, (String)localObject2, str1, str2, str3, str4, paramInnerFavoritesData, localQQAppInterface, (MessageRecord)localObject3, (Context)localObject1));
        return;
      }
      QLog.d("FavoritesProxyImpl", 1, "addToQQFavorites: failed runtime not instanceof QQAppInterface");
      return;
    }
    catch (Throwable paramInnerFavoritesData)
    {
      QLog.e("FavoritesProxyImpl", 1, "addToQQFavorites: failed ", paramInnerFavoritesData);
    }
  }
  
  public void a(InnerFavoritesData paramInnerFavoritesData)
  {
    if (paramInnerFavoritesData == null)
    {
      QLog.e("FavoritesProxyImpl", 1, "addFavorites: favoritesData == null");
      return;
    }
    try
    {
      b(paramInnerFavoritesData);
      return;
    }
    catch (Throwable paramInnerFavoritesData)
    {
      QLog.e("FavoritesProxyImpl", 1, new Object[] { "shareToFavorite: error: ", paramInnerFavoritesData.getMessage() });
    }
  }
  
  public void onJsAddToFavorites(Object paramObject)
  {
    if (!(paramObject instanceof InnerFavoritesData))
    {
      QLog.w("FavoritesProxyImpl", 1, "onJsAddToFavorites. Unknown type of data");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onJsAddToFavorites. data = ");
    localStringBuilder.append(paramObject);
    QLog.d("FavoritesProxyImpl", 1, localStringBuilder.toString());
    paramObject = (InnerFavoritesData)paramObject;
    if (paramObject.action != 1) {
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.FavoritesProxyImpl
 * JD-Core Version:    0.7.0.1
 */