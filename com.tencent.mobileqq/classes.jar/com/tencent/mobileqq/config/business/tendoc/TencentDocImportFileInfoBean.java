package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocImportFileInfoBean
{
  private String a = "";
  private long b = 0L;
  private String c = "";
  private String d = "";
  private String e = "";
  
  public static TencentDocImportFileInfoBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TencentDocImportFileInfoBean localTencentDocImportFileInfoBean;
    int j;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      localTencentDocImportFileInfoBean = new TencentDocImportFileInfoBean();
      j = 0;
    }
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        if (paramArrayOfQConfItem.has("DocsImportFileInfo"))
        {
          paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("DocsImportFileInfo");
          if (paramArrayOfQConfItem.has("importFileMaxSize"))
          {
            localObject1 = paramArrayOfQConfItem.getString("importFileMaxSize");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localTencentDocImportFileInfoBean.b = Long.parseLong((String)localObject1);
            }
          }
          boolean bool = paramArrayOfQConfItem.has("importFileType");
          StringBuilder localStringBuilder;
          Object localObject2;
          Object localObject3;
          if (bool)
          {
            localObject1 = paramArrayOfQConfItem.getJSONArray("importFileType");
            localStringBuilder = new StringBuilder();
            localObject2 = new StringBuilder();
            if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
            {
              i = 0;
              if (i < ((JSONArray)localObject1).length())
              {
                localObject3 = (JSONObject)((JSONArray)localObject1).get(i);
                if (!((JSONObject)localObject3).has("suffix")) {
                  break label496;
                }
                localStringBuilder.append(((JSONObject)localObject3).getString("suffix"));
                ((StringBuilder)localObject2).append(((JSONObject)localObject3).getString("suffix"));
                if (!((JSONObject)localObject3).has("maxSize")) {
                  break label496;
                }
                ((StringBuilder)localObject2).append("_");
                ((StringBuilder)localObject2).append(((JSONObject)localObject3).getString("maxSize"));
                ((StringBuilder)localObject2).append("#");
                break label496;
              }
            }
            localTencentDocImportFileInfoBean.c = ((StringBuilder)localObject2).toString();
            localTencentDocImportFileInfoBean.d = localStringBuilder.toString();
          }
          if (paramArrayOfQConfItem.has("fileGroupType"))
          {
            localObject1 = paramArrayOfQConfItem.getJSONArray("fileGroupType");
            localStringBuilder = new StringBuilder();
            if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
            {
              i = j;
              if (i < ((JSONArray)localObject1).length())
              {
                localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
                if ((!((JSONObject)localObject2).has("group")) || (!((JSONObject)localObject2).has("suffix"))) {
                  break label503;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(((JSONObject)localObject2).getString("group"));
                ((StringBuilder)localObject3).append("_");
                ((StringBuilder)localObject3).append(((JSONObject)localObject2).getString("suffix"));
                ((StringBuilder)localObject3).append("&");
                localStringBuilder.append(((StringBuilder)localObject3).toString());
                break label503;
              }
            }
            localTencentDocImportFileInfoBean.e = localStringBuilder.toString();
          }
          if (paramArrayOfQConfItem.has("importFileTips"))
          {
            paramArrayOfQConfItem = paramArrayOfQConfItem.getString("importFileTips");
            if (!TextUtils.isEmpty(paramArrayOfQConfItem))
            {
              localTencentDocImportFileInfoBean.a = paramArrayOfQConfItem;
              return localTencentDocImportFileInfoBean;
            }
          }
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("exception = ");
          ((StringBuilder)localObject1).append(paramArrayOfQConfItem.toString());
          QLog.e("TencentDocImportFileInfoBean", 1, ((StringBuilder)localObject1).toString());
        }
      }
      return localTencentDocImportFileInfoBean;
      return null;
      label496:
      i += 1;
      continue;
      label503:
      i += 1;
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean
 * JD-Core Version:    0.7.0.1
 */