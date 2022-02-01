package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForBeancurd
  extends ChatMessage
{
  private static final String TAG = "MessageForBeancurd";
  private String background;
  private int beancurdStyle;
  private String busi_uuid;
  private long busiid;
  private List<MessageForBeancurd.Content> contentList;
  private MessageForBeancurd.Content description;
  private String icon;
  private List<String> uinList;
  
  public MessageForBeancurd()
  {
    this.msgtype = -7016;
  }
  
  private void parseContentList(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("content_list")) {
      return;
    }
    paramJSONObject = paramJSONObject.getJSONArray("content_list");
    this.contentList = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      MessageForBeancurd.Content localContent = new MessageForBeancurd.Content();
      localContent.detail = localJSONObject.optString("detail");
      localContent.color = localJSONObject.optString("color");
      this.contentList.add(localContent);
      i += 1;
    }
  }
  
  private void parseUinList(JSONObject paramJSONObject)
  {
    this.uinList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONArray("frd_uin");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      this.uinList.add(paramJSONObject.getString(i));
      i += 1;
    }
  }
  
  protected void doParse()
  {
    this.msgtype = -7016;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.msg);
      this.busiid = localJSONObject1.optLong("busiid");
      this.busi_uuid = localJSONObject1.optString("busi_uuid");
      this.beancurdStyle = localJSONObject1.optInt("beancurd_style");
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("description");
      this.description = new MessageForBeancurd.Content();
      this.description.detail = localJSONObject2.optString("detail");
      this.description.color = localJSONObject2.optString("color");
      parseContentList(localJSONObject1);
      this.background = localJSONObject1.optString("background");
      this.icon = localJSONObject1.optString("busiicon");
      parseUinList(localJSONObject1);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("MessageForBeancurd", 1, "doParse err: ", localJSONException);
    }
  }
  
  public String getBackground()
  {
    return this.background;
  }
  
  public int getBeancurdStyle()
  {
    return this.beancurdStyle;
  }
  
  public String getBusi_uuid()
  {
    return this.busi_uuid;
  }
  
  public long getBusiid()
  {
    return this.busiid;
  }
  
  public List<MessageForBeancurd.Content> getContentList()
  {
    return this.contentList;
  }
  
  public MessageForBeancurd.Content getDescription()
  {
    return this.description;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public List<String> getUinList()
  {
    return this.uinList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForBeancurd
 * JD-Core Version:    0.7.0.1
 */