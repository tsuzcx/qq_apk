package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.browser.BrowserItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CONFIG_ID", "", "TAG", "", "loadConfig", "Lcom/tencent/mobileqq/config/business/BrowserOpenBean;", "parse", "content", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class BrowserOpenConfProcessorKt
{
  @NotNull
  public static final BrowserOpenBean a()
  {
    BrowserOpenBean localBrowserOpenBean = (BrowserOpenBean)QConfigManager.b().b(627);
    if (localBrowserOpenBean != null) {
      return localBrowserOpenBean;
    }
    return new BrowserOpenBean();
  }
  
  private static final BrowserOpenBean b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i;
    int j;
    try
    {
      localBrowserOpenBean = new BrowserOpenBean();
      paramString = new JSONObject(paramString);
      localObject1 = paramString.optJSONArray("set_top_app");
      if (localObject1 == null) {
        break label270;
      }
      i = ((JSONArray)localObject1).length();
    }
    catch (Exception paramString)
    {
      BrowserOpenBean localBrowserOpenBean;
      Object localObject1;
      Object localObject3;
      Object localObject2;
      String str1;
      String str2;
      String str3;
      QLog.e("[BrowserOpt] H5BrowserOpenConfProcessor", 1, "parse: failed. ", (Throwable)paramString);
      return null;
    }
    if (j < i)
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(j);
      if (localObject3 != null)
      {
        localObject2 = ((JSONObject)localObject3).optString("name");
        str1 = ((JSONObject)localObject3).optString("title");
        str2 = ((JSONObject)localObject3).optString("icon");
        str3 = ((JSONObject)localObject3).optString("jump_url");
        localObject3 = ((JSONObject)localObject3).optString("package_name");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "name");
        Intrinsics.checkExpressionValueIsNotNull(str1, "title");
        Intrinsics.checkExpressionValueIsNotNull(str2, "icon");
        Intrinsics.checkExpressionValueIsNotNull(str3, "jumpUrl");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "packageName");
        localObject2 = new BrowserItem((String)localObject2, str1, str2, str3, (String)localObject3, false);
        localBrowserOpenBean.a().add(localObject2);
      }
    }
    else
    {
      paramString = paramString.optJSONArray("black_list_app");
      if (paramString == null) {
        break label284;
      }
      i = paramString.length();
      break label286;
    }
    for (;;)
    {
      if (j < i)
      {
        localObject1 = paramString.getJSONObject(j);
        if (localObject1 != null)
        {
          localObject1 = ((JSONObject)localObject1).optString("package");
          localObject2 = localBrowserOpenBean.b();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "pkg");
          ((List)localObject2).add(localObject1);
        }
        j += 1;
      }
      else
      {
        return localBrowserOpenBean;
        label270:
        i = 0;
        j = 0;
        break;
        j += 1;
        break;
        label284:
        i = 0;
        label286:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BrowserOpenConfProcessorKt
 * JD-Core Version:    0.7.0.1
 */