package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.message.api.IMessageRecordForGuildWelcome;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageRecordForGuildWelcome
  extends ChatMessage
  implements IMessageRecordForGuildWelcome
{
  public int channelType;
  public String channelUin;
  public String guildUin;
  public String showMsg = HardCodeUtil.a(2131890350);
  public int welcomeType;
  
  protected void doParse()
  {
    if (this.msgData != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(new String(this.msgData));
        this.welcomeType = localJSONObject.optInt("welcomeType");
        this.channelType = localJSONObject.optInt("channelType");
        this.channelUin = localJSONObject.optString("channelUin");
        this.guildUin = localJSONObject.optString("guildUin");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    this.msg = this.showMsg;
  }
  
  public int getChannelType()
  {
    return this.channelType;
  }
  
  public String getChannelUin()
  {
    return this.channelUin;
  }
  
  public String getGuildUin()
  {
    return this.guildUin;
  }
  
  public String getSummaryMsg()
  {
    return this.showMsg;
  }
  
  public int getWelcomeType()
  {
    return this.welcomeType;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("welcomeType", this.welcomeType);
      localJSONObject.put("channelType", this.channelType);
      localJSONObject.put("channelUin", this.channelUin);
      localJSONObject.put("guildUin", this.guildUin);
      this.msgData = localJSONObject.toString().getBytes();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.MessageRecordForGuildWelcome
 * JD-Core Version:    0.7.0.1
 */