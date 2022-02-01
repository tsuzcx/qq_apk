package com.tencent.mobileqq.data;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageForPokeEmo
  extends ChatMessage
{
  public static final int POP_EMO_BUSSINESS_TYPE = 13;
  public String emoCompat;
  public int emoIndex = -1;
  public String emoString;
  public boolean isNeedPlayed = false;
  public int pokeemoId;
  public int pokeemoPressCount;
  public String summary;
  
  protected void doParse()
  {
    if (this.msgData != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(new String(this.msgData));
        this.pokeemoId = localJSONObject.getInt("pokeemoId");
        this.pokeemoPressCount = localJSONObject.getInt("pokeemoPressCount");
        this.summary = localJSONObject.getString("summary");
        this.msg = localJSONObject.getString("msg");
        if (localJSONObject.has("isread")) {
          this.isread = localJSONObject.getBoolean("isread");
        }
        if ((localJSONObject.has("emoIndex")) && (this.pokeemoId == 13))
        {
          this.emoIndex = localJSONObject.getInt("emoIndex");
          this.emoString = localJSONObject.getString("emoString");
          this.emoCompat = localJSONObject.getString("emoCompat");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void initMsg()
  {
    if ((this.pokeemoId == 13) && (this.emoIndex >= 0))
    {
      this.msg = String.format("[%s]x%d", new Object[] { this.emoCompat, Integer.valueOf(this.pokeemoPressCount) });
      return;
    }
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
  
  protected void postRead()
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
      localJSONObject.put("isread", this.isread);
      if ((this.emoIndex >= 0) && (this.pokeemoId == 13))
      {
        localJSONObject.put("emoIndex", this.emoIndex);
        Object localObject = this.emoString;
        String str = "";
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = this.emoString;
        }
        localJSONObject.put("emoString", localObject);
        if (this.emoCompat == null) {
          localObject = str;
        } else {
          localObject = this.emoCompat;
        }
        localJSONObject.put("emoCompat", localObject);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPokeEmo
 * JD-Core Version:    0.7.0.1
 */