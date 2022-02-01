package com.tencent.mobileqq.qqexpand.manager;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/manager/IExpandLimitChatManager;", "", "clearAllExpandFriendData", "", "getMatchSwitchOpenFromSp", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "initManager", "isMatchVoiceShowToUser", "saveRealNameConfirm", "confirm", "saveRealNameDialogContent", "needShowDialog", "title", "", "content", "url", "showRealNameAuthDialog", "context", "Landroid/content/Context;", "Companion", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandLimitChatManager
{
  public static final IExpandLimitChatManager.Companion a = IExpandLimitChatManager.Companion.a;
  
  public abstract void a();
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3);
  
  public abstract boolean a(@Nullable Context paramContext);
  
  public abstract boolean a(@Nullable BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean b(@Nullable BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.IExpandLimitChatManager
 * JD-Core Version:    0.7.0.1
 */