package com.tencent.mobileqq.qqexpand.chat.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/impl/ExpandChatUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/IExpandChatUtils;", "()V", "bNeedShowLimitChatInTitleEntrance", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "clearAllMatchChatLocalData", "", "getInstance", "Lcom/tencent/mobileqq/qqexpand/bean/chat/ExpandFriendData;", "matchUin", "", "getLastMatchChatGrayTipsSection", "", "getMatchAlgorithmId", "handlePreLoadDataForIcebreakerTopic", "uinType", "data", "", "isMiniProfileCard", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "markEnterAio", "needShowLimitChatOnPlus", "reportInSubThread", "setLastMatchChatGrayTipsSection", "section", "showIcebreakerTopic", "matchSrc", "extendObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "updateInstance", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandChatUtilsImpl
  implements IExpandChatUtils
{
  public boolean bNeedShowLimitChatInTitleEntrance(@Nullable BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ExpandChatUtil.a(paramBaseQQAppInterface);
  }
  
  public void clearAllMatchChatLocalData(@Nullable BaseQQAppInterface paramBaseQQAppInterface)
  {
    ExpandChatUtil.a(paramBaseQQAppInterface);
  }
  
  @Nullable
  public ExpandFriendData getInstance(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    return ExpandChatUtil.a(paramBaseQQAppInterface, paramString);
  }
  
  public int getLastMatchChatGrayTipsSection(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    return ExpandChatUtil.a(paramBaseQQAppInterface, paramString);
  }
  
  @Nullable
  public String getMatchAlgorithmId(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    return ExpandChatUtil.a(paramBaseQQAppInterface, paramString);
  }
  
  public void handlePreLoadDataForIcebreakerTopic(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, int paramInt, @Nullable Object paramObject)
  {
    ExpandChatUtil.a(paramBaseQQAppInterface, paramString, paramInt, paramObject);
  }
  
  public boolean isMiniProfileCard(@Nullable MessageRecord paramMessageRecord)
  {
    return ExpandChatUtil.a(paramMessageRecord);
  }
  
  public void markEnterAio(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    ExpandChatUtil.a(paramBaseQQAppInterface, paramString);
  }
  
  public boolean needShowLimitChatOnPlus(@Nullable BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ExpandChatUtil.a((AppInterface)paramBaseQQAppInterface);
  }
  
  public void reportInSubThread(@Nullable String paramString)
  {
    ExpandChatUtil.a(paramString);
  }
  
  public void setLastMatchChatGrayTipsSection(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, int paramInt)
  {
    ExpandChatUtil.a(paramBaseQQAppInterface, paramString, paramInt);
  }
  
  public void showIcebreakerTopic(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, int paramInt1, int paramInt2, @Nullable BusinessObserver paramBusinessObserver)
  {
    ExpandChatUtil.a(paramBaseQQAppInterface, paramString, paramInt1, paramInt2, paramBusinessObserver);
  }
  
  public void updateInstance(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable ExpandFriendData paramExpandFriendData)
  {
    ExpandChatUtil.a(paramBaseQQAppInterface, paramExpandFriendData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.impl.ExpandChatUtilsImpl
 * JD-Core Version:    0.7.0.1
 */