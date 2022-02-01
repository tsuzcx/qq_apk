package com.tencent.mobileqq.qqgamepub.config;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfigBean$Companion;", "", "()V", "TAG", "", "parse", "Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfigBean;", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfigBean;", "qqgamepubaccount-api_release"}, k=1, mv={1, 1, 16})
public final class DnFlutterConfigBean$Companion
{
  @NotNull
  public final DnFlutterConfigBean a(@NotNull QConfItem[] paramArrayOfQConfItem)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfQConfItem, "confFiles");
    DnFlutterConfigBean localDnFlutterConfigBean = new DnFlutterConfigBean();
    int k = paramArrayOfQConfItem.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramArrayOfQConfItem[i];
      Object localObject1 = ((QConfItem)localObject2).b;
      if (localObject1 != null)
      {
        int j;
        if (((CharSequence)localObject1).length() > 0) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 1)
        {
          localObject1 = ((QConfItem)localObject2).b;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "confFile.content");
          localDnFlutterConfigBean.f((String)localObject1);
          localObject1 = (JSONObject)null;
          try
          {
            localObject2 = new JSONObject(((QConfItem)localObject2).b);
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse error e=");
            localStringBuilder.append(localJSONException);
            QLog.e("DnFlutterConfigBean", 1, localStringBuilder.toString());
          }
          if (localObject1 == null) {
            return localDnFlutterConfigBean;
          }
          localDnFlutterConfigBean.a(((JSONObject)localObject1).optInt("dynamicSwitch"));
          localDnFlutterConfigBean.b(((JSONObject)localObject1).optInt("preDownloadSwitch"));
          String str = ((JSONObject)localObject1).optString("version");
          Intrinsics.checkExpressionValueIsNotNull(str, "optString(\"version\")");
          localDnFlutterConfigBean.a(str);
          str = ((JSONObject)localObject1).optString("resourceUrl");
          Intrinsics.checkExpressionValueIsNotNull(str, "optString(\"resourceUrl\")");
          localDnFlutterConfigBean.b(str);
          str = ((JSONObject)localObject1).optString("resourceMd5");
          Intrinsics.checkExpressionValueIsNotNull(str, "optString(\"resourceMd5\")");
          localDnFlutterConfigBean.c(str);
          str = ((JSONObject)localObject1).optString("resourceSign");
          Intrinsics.checkExpressionValueIsNotNull(str, "optString(\"resourceSign\")");
          localDnFlutterConfigBean.d(str);
          localObject1 = ((JSONObject)localObject1).optString("packageName");
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "optString(\"packageName\")");
          localDnFlutterConfigBean.e((String)localObject1);
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("onParsed DnFlutterConfigBean=");
      paramArrayOfQConfItem.append(localDnFlutterConfigBean);
      QLog.d("DnFlutterConfigBean", 2, paramArrayOfQConfItem.toString());
    }
    return localDnFlutterConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.DnFlutterConfigBean.Companion
 * JD-Core Version:    0.7.0.1
 */