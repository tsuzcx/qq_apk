package com.tencent.mobileqq.data;

import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.FrameAnimationState;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.UnlimitedState;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForPoke
  extends ChatMessage
{
  public static final int INTERACT_TYPE_APPROVE = 3;
  public static final int INTERACT_TYPE_GIVING_HEART = 2;
  public static final int INTERACT_TYPE_GREAT_MOVE = 6;
  public static final int INTERACT_TYPE_HEART_BREAK = 4;
  public static final int INTERACT_TYPE_HI_TOGETHER = 5;
  public static final int INTERACT_TYPE_POKE = 1;
  public static final int INTERACT_TYPE_POKE_OLD = 0;
  public static final int INTERACT_TYPE_VAS_POKE = 126;
  public int doubleHitState;
  public boolean hasQuickBackShowed;
  public int interactType = 0;
  public boolean isPlayed;
  public Drawable.ConstantState mBubbleBgState;
  public CustomFrameAnimationDrawable.FrameAnimationState mFrameState = new CustomFrameAnimationDrawable.FrameAnimationState();
  public UnlimitedBladeWorks.UnlimitedState mUnlimitedState = new UnlimitedBladeWorks.UnlimitedState();
  public String minVersion;
  public String name;
  public int state;
  public int strength;
  public int subId = -1;
  
  protected void doParse()
  {
    if (this.msgData != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(new String(this.msgData));
      this.interactType = localJSONObject.getInt("interactType");
      this.isPlayed = localJSONObject.getBoolean("isPlayed");
      this.msg = localJSONObject.getString("msg");
      this.doubleHitState = localJSONObject.getInt("doubltHit");
      this.subId = localJSONObject.getInt("subId");
      this.name = localJSONObject.getString("name");
      this.minVersion = localJSONObject.getString("minVersion");
      this.strength = localJSONObject.getInt("strength");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void initMsg()
  {
    switch (this.interactType)
    {
    default: 
      this.msg = "[戳一戳]";
      return;
    case 1: 
      this.msg = "[戳一戳]";
      return;
    case 2: 
      this.msg = "[比心]";
      return;
    case 3: 
      this.msg = "[点赞]";
      return;
    case 4: 
      this.msg = "[心碎]";
      return;
    case 5: 
      this.msg = "[666]";
      return;
    case 6: 
      this.msg = "[放大招]";
      return;
    }
    this.msg = ("[" + this.name + "]");
  }
  
  public boolean needVipBubble()
  {
    return false;
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
      localJSONObject.put("interactType", this.interactType);
      localJSONObject.put("isPlayed", this.isPlayed);
      localJSONObject.put("msg", this.msg);
      localJSONObject.put("doubltHit", this.doubleHitState);
      localJSONObject.put("subId", this.subId);
      localJSONObject.put("name", this.name);
      localJSONObject.put("minVersion", this.minVersion);
      localJSONObject.put("strength", this.strength);
      this.msgData = localJSONObject.toString().getBytes();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setPlayed(QQAppInterface paramQQAppInterface)
  {
    if (!this.isPlayed)
    {
      this.isPlayed = true;
      prewrite();
      paramQQAppInterface.a().a(this.frienduin, this.istroop, this.uniseq, this.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPoke
 * JD-Core Version:    0.7.0.1
 */