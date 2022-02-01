package com.tencent.mobileqq.kandian.biz.share;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/ActionItem;", "", "name", "", "action", "", "webHandle", "", "(Ljava/lang/String;IZ)V", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public class ActionItem
{
  @JvmField
  @NotNull
  public String a;
  @JvmField
  public int b;
  @JvmField
  public boolean c;
  
  public ActionItem(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ActionItem
 * JD-Core Version:    0.7.0.1
 */