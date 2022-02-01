package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/IExpandChatUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "bNeedShowLimitChatInTitleEntrance", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "clearAllMatchChatLocalData", "", "getInstance", "Lcom/tencent/mobileqq/qqexpand/bean/chat/ExpandFriendData;", "matchUin", "", "getLastMatchChatGrayTipsSection", "", "getMatchAlgorithmId", "handlePreLoadDataForIcebreakerTopic", "uinType", "data", "", "isMiniProfileCard", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "markEnterAio", "needShowLimitChatOnPlus", "reportInSubThread", "setLastMatchChatGrayTipsSection", "section", "showIcebreakerTopic", "matchSrc", "extendObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "updateInstance", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandChatUtils
  extends QRouteApi
{
  public abstract boolean bNeedShowLimitChatInTitleEntrance(@Nullable BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void clearAllMatchChatLocalData(@Nullable BaseQQAppInterface paramBaseQQAppInterface);
  
  @Nullable
  public abstract ExpandFriendData getInstance(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  public abstract int getLastMatchChatGrayTipsSection(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  @Nullable
  public abstract String getMatchAlgorithmId(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  public abstract void handlePreLoadDataForIcebreakerTopic(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, int paramInt, @Nullable Object paramObject);
  
  public abstract boolean isMiniProfileCard(@Nullable MessageRecord paramMessageRecord);
  
  public abstract void markEnterAio(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  public abstract boolean needShowLimitChatOnPlus(@Nullable BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void reportInSubThread(@Nullable String paramString);
  
  public abstract void setLastMatchChatGrayTipsSection(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, int paramInt);
  
  public abstract void showIcebreakerTopic(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, int paramInt1, int paramInt2, @Nullable BusinessObserver paramBusinessObserver);
  
  public abstract void updateInstance(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable ExpandFriendData paramExpandFriendData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils
 * JD-Core Version:    0.7.0.1
 */