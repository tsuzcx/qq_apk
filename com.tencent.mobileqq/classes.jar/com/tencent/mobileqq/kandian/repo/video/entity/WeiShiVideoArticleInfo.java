package com.tencent.mobileqq.kandian.repo.video.entity;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ArticleSummary;
import tencent.im.oidb.readinjoy.Readinjoy.ArticleSummary;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/video/entity/WeiShiVideoArticleInfo;", "Lcom/tencent/mobileqq/kandian/repo/video/entity/BaseVideoArticleInfo;", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoSubscriptColor", "", "videoSubscriptTxt", "writeToParcel", "", "dest", "flags", "", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class WeiShiVideoArticleInfo
  extends BaseVideoArticleInfo
{
  public static final WeiShiVideoArticleInfo.Companion Companion = new WeiShiVideoArticleInfo.Companion(null);
  @JvmField
  @NotNull
  public static final String TABLE_NAME;
  @JvmField
  @Nullable
  public String videoSubscriptColor;
  @JvmField
  @Nullable
  public String videoSubscriptTxt;
  
  static
  {
    String str = WeiShiVideoArticleInfo.class.getSimpleName();
    Intrinsics.checkExpressionValueIsNotNull(str, "WeiShiVideoArticleInfo::class.java.simpleName");
    TABLE_NAME = str;
  }
  
  public WeiShiVideoArticleInfo() {}
  
  private WeiShiVideoArticleInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.videoSubscriptTxt = paramParcel.readString();
    this.videoSubscriptColor = paramParcel.readString();
  }
  
  @JvmStatic
  @Nullable
  public static final WeiShiVideoArticleInfo mergeFromArticleSummaryPb(@Nullable Readinjoy.ArticleSummary paramArticleSummary)
  {
    return Companion.a(paramArticleSummary);
  }
  
  @JvmStatic
  @Nullable
  public static final WeiShiVideoArticleInfo mergeFromCmd0xbedPb(@Nullable oidb_cmd0xbed.ArticleSummary paramArticleSummary)
  {
    return Companion.a(paramArticleSummary);
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.videoSubscriptTxt);
    paramParcel.writeString(this.videoSubscriptColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.WeiShiVideoArticleInfo
 * JD-Core Version:    0.7.0.1
 */