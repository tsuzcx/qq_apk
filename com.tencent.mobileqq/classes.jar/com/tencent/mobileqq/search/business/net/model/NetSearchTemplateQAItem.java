package com.tencent.mobileqq.search.business.net.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateQAItem
  extends NetSearchTemplateBaseItem
{
  public static final String a = "NetSearchTemplateQAItem";
  public String b;
  public String c;
  public String d;
  public List<AnswerItem> e;
  
  public NetSearchTemplateQAItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateQAItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void o_(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("askIcon");
      this.c = paramString.optString("headLine");
      this.d = paramString.optString("answerNumText");
      paramString = paramString.optJSONArray("answers");
      if (paramString != null)
      {
        this.e = new ArrayList(paramString.length());
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject2 = paramString.optJSONObject(i);
          Object localObject1 = ((JSONObject)localObject2).optString("leftIcon");
          String str1 = ((JSONObject)localObject2).optString("userNameText");
          String str2 = ((JSONObject)localObject2).optString("praiseText");
          String str3 = ((JSONObject)localObject2).optString("answerText");
          int k = ((JSONObject)localObject2).optInt("imageTotalCount");
          localObject2 = ((JSONObject)localObject2).optJSONArray("imageList");
          ArrayList localArrayList = new ArrayList();
          if (localObject2 != null)
          {
            int j = 0;
            while (j < ((JSONArray)localObject2).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
              localArrayList.add(new ImageItem(localJSONObject.optString("url"), localJSONObject.optInt("type")));
              j += 1;
            }
          }
          localObject1 = new AnswerItem((String)localObject1, str1, str2, str3, k, localArrayList);
          this.e.add(localObject1);
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, QLog.getStackTraceString(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateQAItem
 * JD-Core Version:    0.7.0.1
 */