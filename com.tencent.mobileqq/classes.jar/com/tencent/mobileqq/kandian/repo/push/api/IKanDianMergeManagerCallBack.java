package com.tencent.mobileqq.kandian.repo.push.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/push/api/IKanDianMergeManagerCallBack;", "", "notifyNewMessage", "", "functionName", "", "isSuccess", "", "unreadCount", "", "needNotifyNotification", "isPullRoam", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianMergeManagerCallBack
{
  public abstract void a(@NotNull String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.push.api.IKanDianMergeManagerCallBack
 * JD-Core Version:    0.7.0.1
 */