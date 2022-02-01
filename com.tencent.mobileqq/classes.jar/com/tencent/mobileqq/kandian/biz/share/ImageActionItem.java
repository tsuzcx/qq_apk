package com.tencent.mobileqq.kandian.biz.share;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/ImageActionItem;", "Lcom/tencent/mobileqq/kandian/biz/share/ActionItem;", "name", "", "action", "", "webHandle", "", "url", "(Ljava/lang/String;IZLjava/lang/String;)V", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ImageActionItem
  extends ActionItem
{
  @JvmField
  @NotNull
  public String b;
  
  public ImageActionItem(@NotNull String paramString1, int paramInt, boolean paramBoolean, @NotNull String paramString2)
  {
    super(paramString1, paramInt, paramBoolean);
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ImageActionItem
 * JD-Core Version:    0.7.0.1
 */