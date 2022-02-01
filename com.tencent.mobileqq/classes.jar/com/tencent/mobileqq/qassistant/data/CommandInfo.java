package com.tencent.mobileqq.qassistant.data;

import java.util.List;

public class CommandInfo
{
  public int a;
  public String b;
  public boolean c = false;
  public List<FriendItemInfo> d;
  public RecordInfo e;
  public JumpInfo f;
  public boolean g;
  public String h;
  public ConfirmSendInfo i;
  
  public CommandInfo() {}
  
  public CommandInfo(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public CommandInfo(int paramInt, String paramString, ConfirmSendInfo paramConfirmSendInfo)
  {
    this.a = paramInt;
    this.b = paramString;
    this.i = paramConfirmSendInfo;
  }
  
  public CommandInfo(int paramInt, String paramString, JumpInfo paramJumpInfo)
  {
    this.a = paramInt;
    this.b = paramString;
    this.f = paramJumpInfo;
  }
  
  public CommandInfo(int paramInt, String paramString, List<FriendItemInfo> paramList)
  {
    this.a = paramInt;
    this.b = paramString;
    this.d = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.data.CommandInfo
 * JD-Core Version:    0.7.0.1
 */