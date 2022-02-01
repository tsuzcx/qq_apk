package com.tencent.mobileqq.qqguildsdk.callback;

import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.List;

public abstract interface IFetchGuestGuildCallback
{
  public abstract void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo, List<ICategoryInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback
 * JD-Core Version:    0.7.0.1
 */