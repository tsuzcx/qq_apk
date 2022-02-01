package com.tencent.mobileqq.qqguildsdk.wrapper.callback;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract interface ILoadGuildAndChnListCallback
{
  public abstract void a(byte[] paramArrayOfByte, ArrayList<GProGuildInfo> paramArrayList, HashMap<String, GuildInitInfo> paramHashMap, List<GuildMsgNode> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadGuildAndChnListCallback
 * JD-Core Version:    0.7.0.1
 */