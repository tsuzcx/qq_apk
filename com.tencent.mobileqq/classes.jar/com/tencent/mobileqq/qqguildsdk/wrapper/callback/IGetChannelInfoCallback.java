package com.tencent.mobileqq.qqguildsdk.wrapper.callback;

import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import java.util.List;

public abstract interface IGetChannelInfoCallback
{
  public abstract void a(int paramInt, String paramString, GProChannelInfo paramGProChannelInfo, IGProSecurityResult paramIGProSecurityResult, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelInfoCallback
 * JD-Core Version:    0.7.0.1
 */