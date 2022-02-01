package com.tencent.tkd.topicsdk.bean;

import com.tencent.tkd.weibo.bean.EditObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "Ljava/io/Serializable;", "publishId", "", "content", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "displayItems", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "originContentInfo", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "commodityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;", "invitedManuscriptItem", "Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;", "allowMultiTweetTopic", "", "allowCommentAfterPublishConfig", "allowSaveAlbums", "isOriginalContent", "deliverType", "", "canReprint", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;ZZZZIZ)V", "getAllowCommentAfterPublishConfig", "()Z", "setAllowCommentAfterPublishConfig", "(Z)V", "getAllowMultiTweetTopic", "setAllowMultiTweetTopic", "getAllowSaveAlbums", "setAllowSaveAlbums", "getCanReprint", "setCanReprint", "getCommodityInfo", "()Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;", "setCommodityInfo", "(Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;)V", "getContent", "()Ljava/util/ArrayList;", "setContent", "(Ljava/util/ArrayList;)V", "getDeliverType", "()I", "setDeliverType", "(I)V", "getDisplayItems", "setDisplayItems", "hasMedia", "getHasMedia", "getInvitedManuscriptItem", "()Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;", "setInvitedManuscriptItem", "(Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;)V", "setOriginalContent", "mediaType", "Lcom/tencent/tkd/topicsdk/bean/MediaType;", "getMediaType", "()Lcom/tencent/tkd/topicsdk/bean/MediaType;", "getOriginContentInfo", "()Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "setOriginContentInfo", "(Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;)V", "getPublishId", "()Ljava/lang/String;", "setPublishId", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DraftArticleInfo
  implements Serializable
{
  public static final DraftArticleInfo.Companion Companion = new DraftArticleInfo.Companion(null);
  private static final long serialVersionUID = 0L;
  private boolean allowCommentAfterPublishConfig;
  private boolean allowMultiTweetTopic;
  private boolean allowSaveAlbums;
  private boolean canReprint;
  @Nullable
  private CommodityInfo commodityInfo;
  @NotNull
  private ArrayList<EditObject> content;
  private int deliverType;
  @NotNull
  private ArrayList<DisplayItem> displayItems;
  @Nullable
  private InvitedManuscriptItem invitedManuscriptItem;
  private boolean isOriginalContent;
  @Nullable
  private OriginContentInfo originContentInfo;
  @NotNull
  private String publishId;
  
  public DraftArticleInfo()
  {
    this(null, null, null, null, null, null, false, false, false, false, 0, false, 4095, null);
  }
  
  public DraftArticleInfo(@NotNull String paramString, @NotNull ArrayList<EditObject> paramArrayList, @NotNull ArrayList<DisplayItem> paramArrayList1, @Nullable OriginContentInfo paramOriginContentInfo, @Nullable CommodityInfo paramCommodityInfo, @Nullable InvitedManuscriptItem paramInvitedManuscriptItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5)
  {
    this.publishId = paramString;
    this.content = paramArrayList;
    this.displayItems = paramArrayList1;
    this.originContentInfo = paramOriginContentInfo;
    this.commodityInfo = paramCommodityInfo;
    this.invitedManuscriptItem = paramInvitedManuscriptItem;
    this.allowMultiTweetTopic = paramBoolean1;
    this.allowCommentAfterPublishConfig = paramBoolean2;
    this.allowSaveAlbums = paramBoolean3;
    this.isOriginalContent = paramBoolean4;
    this.deliverType = paramInt;
    this.canReprint = paramBoolean5;
  }
  
  @NotNull
  public final String component1()
  {
    return this.publishId;
  }
  
  public final boolean component10()
  {
    return this.isOriginalContent;
  }
  
  public final int component11()
  {
    return this.deliverType;
  }
  
  public final boolean component12()
  {
    return this.canReprint;
  }
  
  @NotNull
  public final ArrayList<EditObject> component2()
  {
    return this.content;
  }
  
  @NotNull
  public final ArrayList<DisplayItem> component3()
  {
    return this.displayItems;
  }
  
  @Nullable
  public final OriginContentInfo component4()
  {
    return this.originContentInfo;
  }
  
  @Nullable
  public final CommodityInfo component5()
  {
    return this.commodityInfo;
  }
  
  @Nullable
  public final InvitedManuscriptItem component6()
  {
    return this.invitedManuscriptItem;
  }
  
  public final boolean component7()
  {
    return this.allowMultiTweetTopic;
  }
  
  public final boolean component8()
  {
    return this.allowCommentAfterPublishConfig;
  }
  
  public final boolean component9()
  {
    return this.allowSaveAlbums;
  }
  
  @NotNull
  public final DraftArticleInfo copy(@NotNull String paramString, @NotNull ArrayList<EditObject> paramArrayList, @NotNull ArrayList<DisplayItem> paramArrayList1, @Nullable OriginContentInfo paramOriginContentInfo, @Nullable CommodityInfo paramCommodityInfo, @Nullable InvitedManuscriptItem paramInvitedManuscriptItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "content");
    Intrinsics.checkParameterIsNotNull(paramArrayList1, "displayItems");
    return new DraftArticleInfo(paramString, paramArrayList, paramArrayList1, paramOriginContentInfo, paramCommodityInfo, paramInvitedManuscriptItem, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, paramBoolean5);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DraftArticleInfo))
      {
        paramObject = (DraftArticleInfo)paramObject;
        if ((Intrinsics.areEqual(this.publishId, paramObject.publishId)) && (Intrinsics.areEqual(this.content, paramObject.content)) && (Intrinsics.areEqual(this.displayItems, paramObject.displayItems)) && (Intrinsics.areEqual(this.originContentInfo, paramObject.originContentInfo)) && (Intrinsics.areEqual(this.commodityInfo, paramObject.commodityInfo)) && (Intrinsics.areEqual(this.invitedManuscriptItem, paramObject.invitedManuscriptItem)) && (this.allowMultiTweetTopic == paramObject.allowMultiTweetTopic) && (this.allowCommentAfterPublishConfig == paramObject.allowCommentAfterPublishConfig) && (this.allowSaveAlbums == paramObject.allowSaveAlbums) && (this.isOriginalContent == paramObject.isOriginalContent) && (this.deliverType == paramObject.deliverType) && (this.canReprint == paramObject.canReprint)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getAllowCommentAfterPublishConfig()
  {
    return this.allowCommentAfterPublishConfig;
  }
  
  public final boolean getAllowMultiTweetTopic()
  {
    return this.allowMultiTweetTopic;
  }
  
  public final boolean getAllowSaveAlbums()
  {
    return this.allowSaveAlbums;
  }
  
  public final boolean getCanReprint()
  {
    return this.canReprint;
  }
  
  @Nullable
  public final CommodityInfo getCommodityInfo()
  {
    return this.commodityInfo;
  }
  
  @NotNull
  public final ArrayList<EditObject> getContent()
  {
    return this.content;
  }
  
  public final int getDeliverType()
  {
    return this.deliverType;
  }
  
  @NotNull
  public final ArrayList<DisplayItem> getDisplayItems()
  {
    return this.displayItems;
  }
  
  public final boolean getHasMedia()
  {
    return ((Collection)this.displayItems).isEmpty() ^ true;
  }
  
  @Nullable
  public final InvitedManuscriptItem getInvitedManuscriptItem()
  {
    return this.invitedManuscriptItem;
  }
  
  @Nullable
  public final MediaType getMediaType()
  {
    Object localObject = (DisplayItem)CollectionsKt.firstOrNull((List)this.displayItems);
    if (localObject != null)
    {
      localObject = ((DisplayItem)localObject).getMedia();
      if (localObject != null) {
        return ((Media)localObject).getType();
      }
    }
    return null;
  }
  
  @Nullable
  public final OriginContentInfo getOriginContentInfo()
  {
    return this.originContentInfo;
  }
  
  @NotNull
  public final String getPublishId()
  {
    return this.publishId;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isOriginalContent()
  {
    return this.isOriginalContent;
  }
  
  public final void setAllowCommentAfterPublishConfig(boolean paramBoolean)
  {
    this.allowCommentAfterPublishConfig = paramBoolean;
  }
  
  public final void setAllowMultiTweetTopic(boolean paramBoolean)
  {
    this.allowMultiTweetTopic = paramBoolean;
  }
  
  public final void setAllowSaveAlbums(boolean paramBoolean)
  {
    this.allowSaveAlbums = paramBoolean;
  }
  
  public final void setCanReprint(boolean paramBoolean)
  {
    this.canReprint = paramBoolean;
  }
  
  public final void setCommodityInfo(@Nullable CommodityInfo paramCommodityInfo)
  {
    this.commodityInfo = paramCommodityInfo;
  }
  
  public final void setContent(@NotNull ArrayList<EditObject> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.content = paramArrayList;
  }
  
  public final void setDeliverType(int paramInt)
  {
    this.deliverType = paramInt;
  }
  
  public final void setDisplayItems(@NotNull ArrayList<DisplayItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.displayItems = paramArrayList;
  }
  
  public final void setInvitedManuscriptItem(@Nullable InvitedManuscriptItem paramInvitedManuscriptItem)
  {
    this.invitedManuscriptItem = paramInvitedManuscriptItem;
  }
  
  public final void setOriginContentInfo(@Nullable OriginContentInfo paramOriginContentInfo)
  {
    this.originContentInfo = paramOriginContentInfo;
  }
  
  public final void setOriginalContent(boolean paramBoolean)
  {
    this.isOriginalContent = paramBoolean;
  }
  
  public final void setPublishId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishId = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DraftArticleInfo(publishId=");
    localStringBuilder.append(this.publishId);
    localStringBuilder.append(", content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append(", displayItems=");
    localStringBuilder.append(this.displayItems);
    localStringBuilder.append(", originContentInfo=");
    localStringBuilder.append(this.originContentInfo);
    localStringBuilder.append(", commodityInfo=");
    localStringBuilder.append(this.commodityInfo);
    localStringBuilder.append(", invitedManuscriptItem=");
    localStringBuilder.append(this.invitedManuscriptItem);
    localStringBuilder.append(", allowMultiTweetTopic=");
    localStringBuilder.append(this.allowMultiTweetTopic);
    localStringBuilder.append(", allowCommentAfterPublishConfig=");
    localStringBuilder.append(this.allowCommentAfterPublishConfig);
    localStringBuilder.append(", allowSaveAlbums=");
    localStringBuilder.append(this.allowSaveAlbums);
    localStringBuilder.append(", isOriginalContent=");
    localStringBuilder.append(this.isOriginalContent);
    localStringBuilder.append(", deliverType=");
    localStringBuilder.append(this.deliverType);
    localStringBuilder.append(", canReprint=");
    localStringBuilder.append(this.canReprint);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.DraftArticleInfo
 * JD-Core Version:    0.7.0.1
 */