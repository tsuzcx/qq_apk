package com.tencent.mobileqq.data;

import alud;
import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public class TencentDocData
{
  public String action = "web";
  public long aioTime;
  public long appid;
  public String creatorNick;
  public long creatorUid;
  public long creatorUin;
  public String docIcon;
  String[] docId = new String[2];
  public int docStatus;
  public int docType;
  public String docUrl;
  public String icon = "https://docs.qq.com/desktop/favicon.ico";
  public String ownerNick;
  public long ownerUid;
  public long ownerUin;
  public String peerTips;
  public long sendUin;
  public int serviceId = 95;
  public String sourceAction = alud.a(2131715222);
  public String sourceName = alud.a(2131715218);
  public String summary = alud.a(2131715226);
  public String title;
  public String url;
  
  public static void obtainFromJsonObject(JSONObject paramJSONObject1, JSONObject paramJSONObject2, TencentDocData paramTencentDocData)
  {
    if (paramJSONObject1 != null)
    {
      JSONObject localJSONObject1 = (JSONObject)paramJSONObject1.opt("doc_meta");
      if (localJSONObject1 != null)
      {
        JSONObject localJSONObject2 = (JSONObject)localJSONObject1.opt("doc_id");
        if (localJSONObject2 != null)
        {
          paramTencentDocData.docId[0] = String.valueOf(localJSONObject2.optLong("domain_id"));
          paramTencentDocData.docId[1] = localJSONObject2.optString("pad_id");
        }
        paramTencentDocData.title = localJSONObject1.optString("title");
        paramTencentDocData.creatorUin = localJSONObject1.optLong("creator_uin");
        paramTencentDocData.ownerUin = localJSONObject1.optLong("owner_uin");
        paramTencentDocData.creatorUid = localJSONObject1.optLong("creator_uid");
        paramTencentDocData.ownerUid = localJSONObject1.optLong("owner_uid");
        paramTencentDocData.docType = localJSONObject1.optInt("doc_type");
        paramTencentDocData.docStatus = localJSONObject1.optInt("doc_status");
        paramTencentDocData.docIcon = localJSONObject1.optString("doc_icon");
        paramTencentDocData.creatorNick = paramJSONObject1.optString("creator_nick");
        paramTencentDocData.ownerNick = paramJSONObject1.optString("owner_nick");
        paramTencentDocData.docUrl = paramJSONObject1.optString("doc_url");
        paramTencentDocData.aioTime = (paramJSONObject1.optLong("add_list_ts") * 1000L);
      }
    }
    if (paramJSONObject2 != null)
    {
      paramTencentDocData.action = paramJSONObject2.optString("action");
      paramTencentDocData.sourceAction = paramJSONObject2.optString("source_name");
      paramTencentDocData.serviceId = paramJSONObject2.optInt("service_id");
      paramTencentDocData.sourceName = paramJSONObject2.optString("source_name");
      paramTencentDocData.summary = paramJSONObject2.optString("summary");
      paramTencentDocData.icon = paramJSONObject2.optString("icon");
      paramTencentDocData.appid = paramJSONObject2.optLong("appid");
      paramTencentDocData.url = paramJSONObject2.optString("url");
      paramTencentDocData.sendUin = paramJSONObject2.optLong("send_uin");
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TencentDocData))
    {
      paramObject = (TencentDocData)paramObject;
      return (paramObject.docId[0].equals(this.docId[0])) && (paramObject.docId[1].equals(this.docId[1])) && (paramObject.aioTime == this.aioTime);
    }
    return false;
  }
  
  public String getBriefDes(Context paramContext)
  {
    return paramContext.getString(2131692779, new Object[] { getTitle() });
  }
  
  public String getTitle()
  {
    try
    {
      if (TextUtils.isEmpty(this.title)) {
        return "";
      }
      this.title = this.title.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
      String str = URLDecoder.decode(this.title, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      return "";
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  public JSONObject translate2JsonObject()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject1.put("doc_meta", localJSONObject2);
    JSONObject localJSONObject3 = new JSONObject();
    localJSONObject2.put("doc_id", localJSONObject3);
    localJSONObject3.put("domain_id", this.docId[0]);
    localJSONObject3.put("pad_id", this.docId[1]);
    if (this.aioTime != 0L) {
      localJSONObject1.put("add_list_ts", this.aioTime / 1000L);
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TencentDocData
 * JD-Core Version:    0.7.0.1
 */