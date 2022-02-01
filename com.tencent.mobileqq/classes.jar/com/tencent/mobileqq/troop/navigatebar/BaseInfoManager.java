package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.Observable;

public abstract class BaseInfoManager
  extends Observable
{
  public abstract MessageInfo a(String paramString);
  
  public abstract MessageInfo a(String paramString, MessageInfo paramMessageInfo);
  
  public abstract MessageInfo b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseInfoManager
 * JD-Core Version:    0.7.0.1
 */