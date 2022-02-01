package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
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
    this.ag = false;
  }
  
  public void e(int paramInt)
  {
    MiniProgramSearchResultModel localMiniProgramSearchResultModel = this.a;
    if (localMiniProgramSearchResultModel != null) {
      localMiniProgramSearchResultModel.e(paramInt);
    }
    super.e(paramInt);
  }
  
  public void o_(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      str1 = localJSONObject.optString("appname");
      localObject = localJSONObject.optString("desc");
      str2 = localJSONObject.optString("appIcon");
      str3 = localJSONObject.optString("appid");
      i = localJSONObject.optInt("showMask", 0);
      j = localJSONObject.optInt("miniAppType", 0);
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
        break label327;
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
        int j;
        continue;
        label327:
        paramString = (String)localObject;
      }
    }
    paramString = new MiniAppLocalSearchEntity(str3, str1, str2, paramString, i, j);
    localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.a = new MiniProgramSearchResultModel((QQAppInterface)localObject, this.p, paramString, this.m);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(this.m)) && (str1.equalsIgnoreCase(this.m))) {
      this.b = true;
    } else {
      this.b = false;
    }
    if (localObject != null) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateDataDbFromNetResultInLocalSearchManager(paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseLayoutExtensions, content=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("NetSearchTemplateMiniAppItem", 1, ((StringBuilder)localObject).toString());
    return;
    QLog.e("NetSearchTemplateMiniAppItem", 1, "parseLayoutExtensions, exception.");
  }
  
  public void p()
  {
    super.p();
    String str;
    if (this.b) {
      str = "0X8009D32";
    } else {
      str = "0X8009D44";
    }
    UniteSearchReportController.a(null, 0, this.p, str, 0, 0, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem
 * JD-Core Version:    0.7.0.1
 */