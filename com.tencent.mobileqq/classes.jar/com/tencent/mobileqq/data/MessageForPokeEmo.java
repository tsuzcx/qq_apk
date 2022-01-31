package com.tencent.mobileqq.data;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageForPokeEmo
  extends ChatMessage
{
  public boolean isNeedPlayed;
  public int pokeemoId;
  public int pokeemoPressCount;
  public String summary;
  
  protected void doParse()
  {
    if (this.msgData != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(new String(this.msgData));
      this.pokeemoId = localJSONObject.getInt("pokeemoId");
      this.pokeemoPressCount = localJSONObject.getInt("pokeemoPressCount");
      this.summary = localJSONObject.getString("summary");
      this.msg = localJSONObject.getString("msg");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void initMsg()
  {
    this.msg = String.format("[%s]x%d", new Object[] { this.summary, Integer.valueOf(this.pokeemoPressCount) });
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("pokeemoId", this.pokeemoId);
      localJSONObject.put("pokeemoPressCount", this.pokeemoPressCount);
      localJSONObject.put("summary", this.summary);
      localJSONObject.put("msg", this.msg);
      this.msgData = localJSONObject.toString().getBytes();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setIsNeedPlayed(boolean paramBoolean)
  {
    this.isNeedPlayed = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPokeEmo
 * JD-Core Version:    0.7.0.1
 */