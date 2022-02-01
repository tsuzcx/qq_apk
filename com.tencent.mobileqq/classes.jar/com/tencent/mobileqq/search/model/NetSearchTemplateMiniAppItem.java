package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;

public class NetSearchTemplateMiniAppItem
  extends NetSearchTemplateBaseItem
{
  public MiniProgramSearchResultModel a;
  public boolean b;
  
  public NetSearchTemplateMiniAppItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      str1 = localJSONObject.optString("appname");
      localObject = localJSONObject.optString("desc");
      str2 = localJSONObject.optString("appIcon");
      str3 = localJSONObject.optString("appid");
      i = localJSONObject.optInt("showMask", 0);
      StringBuilder localStringBuilder = null;
      paramString = localStringBuilder;
      if (localJSONObject.has("friendExtra"))
      {
        localJSONObject = localJSONObject.optJSONObject("friendExtra");
        paramString = localStringBuilder;
        if (localJSONObject != null)
        {
          paramString = localStringBuilder;
          if (localJSONObject.has("displayText")) {
            paramString = localJSONObject.optString("displayText");
          }
        }
      }
      if (TextUtils.isEmpty(paramString)) {
        break label277;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | ");
      localStringBuilder.append((String)localObject);
      paramString = localStringBuilder.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        String str1;
        Object localObject;
        String str2;
        String str3;
        int i;
        continue;
        label277:
        paramString = (String)localObject;
      }
    }
    paramString = new MiniAppLocalSearchEntity(str3, str1, str2, paramString, i);
    localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.a = new MiniProgramSearchResultModel((QQAppInterface)localObject, this.c, paramString, this.jdField_g_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (str1.equalsIgnoreCase(this.jdField_g_of_type_JavaLangString))) {
      this.b = true;
    } else {
      this.b = false;
    }
    if (localObject != null)
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateDataDbFromNetResultInLocalSearchManager(paramString);
      return;
      QLog.e("NetSearchTemplateMiniAppItem", 1, "parseLayoutExtensions, exception.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem
 * JD-Core Version:    0.7.0.1
 */