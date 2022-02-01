package com.tencent.tkd.weibo.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toEditObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "tkd-weibo-component_release"}, k=2, mv={1, 1, 16})
public final class AtPersonItemKt
{
  @NotNull
  public static final EditObject a(@NotNull AtPersonItem paramAtPersonItem)
  {
    Intrinsics.checkParameterIsNotNull(paramAtPersonItem, "$this$toEditObject");
    EditObject localEditObject = new EditObject('@' + paramAtPersonItem.b(), EditObject.EditObjectType.TYPE_AT);
    localEditObject.setKey(paramAtPersonItem.c());
    localEditObject.setHref(paramAtPersonItem.d());
    localEditObject.setAvatarUrl(paramAtPersonItem.a());
    return localEditObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.bean.AtPersonItemKt
 * JD-Core Version:    0.7.0.1
 */