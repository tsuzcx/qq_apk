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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "Ljava/io/Serializable;", "content", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "displayItems", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "originContentInfo", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "allowMultiTweetTopic", "", "allowCommentAfterPublishConfig", "allowSaveAlbums", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;ZZZ)V", "getAllowCommentAfterPublishConfig", "()Z", "setAllowCommentAfterPublishConfig", "(Z)V", "getAllowMultiTweetTopic", "setAllowMultiTweetTopic", "getAllowSaveAlbums", "setAllowSaveAlbums", "getContent", "()Ljava/util/ArrayList;", "setContent", "(Ljava/util/ArrayList;)V", "getDisplayItems", "setDisplayItems", "hasMedia", "getHasMedia", "mediaType", "Lcom/tencent/tkd/topicsdk/bean/MediaType;", "getMediaType", "()Lcom/tencent/tkd/topicsdk/bean/MediaType;", "getOriginContentInfo", "()Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "setOriginContentInfo", "(Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DraftArticleInfo
  implements Serializable
{
  public static final DraftArticleInfo.Companion Companion = new DraftArticleInfo.Companion(null);
  private static final long serialVersionUID = 0L;
  private boolean allowCommentAfterPublishConfig;
  private boolean allowMultiTweetTopic;
  private boolean allowSaveAlbums;
  @NotNull
  private ArrayList<EditObject> content;
  @NotNull
  private ArrayList<DisplayItem> displayItems;
  @Nullable
  private OriginContentInfo originContentInfo;
  
  public DraftArticleInfo()
  {
    this(null, null, null, false, false, false, 63, null);
  }
  
  public DraftArticleInfo(@NotNull ArrayList<EditObject> paramArrayList, @NotNull ArrayList<DisplayItem> paramArrayList1, @Nullable OriginContentInfo paramOriginContentInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.content = paramArrayList;
    this.displayItems = paramArrayList1;
    this.originContentInfo = paramOriginContentInfo;
    this.allowMultiTweetTopic = paramBoolean1;
    this.allowCommentAfterPublishConfig = paramBoolean2;
    this.allowSaveAlbums = paramBoolean3;
  }
  
  @NotNull
  public final ArrayList<EditObject> component1()
  {
    return this.content;
  }
  
  @NotNull
  public final ArrayList<DisplayItem> component2()
  {
    return this.displayItems;
  }
  
  @Nullable
  public final OriginContentInfo component3()
  {
    return this.originContentInfo;
  }
  
  public final boolean component4()
  {
    return this.allowMultiTweetTopic;
  }
  
  public final boolean component5()
  {
    return this.allowCommentAfterPublishConfig;
  }
  
  public final boolean component6()
  {
    return this.allowSaveAlbums;
  }
  
  @NotNull
  public final DraftArticleInfo copy(@NotNull ArrayList<EditObject> paramArrayList, @NotNull ArrayList<DisplayItem> paramArrayList1, @Nullable OriginContentInfo paramOriginContentInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "content");
    Intrinsics.checkParameterIsNotNull(paramArrayList1, "displayItems");
    return new DraftArticleInfo(paramArrayList, paramArrayList1, paramOriginContentInfo, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DraftArticleInfo))
      {
        paramObject = (DraftArticleInfo)paramObject;
        if ((!Intrinsics.areEqual(this.content, paramObject.content)) || (!Intrinsics.areEqual(this.displayItems, paramObject.displayItems)) || (!Intrinsics.areEqual(this.originContentInfo, paramObject.originContentInfo)) || (this.allowMultiTweetTopic != paramObject.allowMultiTweetTopic) || (this.allowCommentAfterPublishConfig != paramObject.allowCommentAfterPublishConfig) || (this.allowSaveAlbums != paramObject.allowSaveAlbums)) {}
      }
    }
    else {
      return true;
    }
    return false;
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
  
  @NotNull
  public final ArrayList<EditObject> getContent()
  {
    return this.content;
  }
  
  @NotNull
  public final ArrayList<DisplayItem> getDisplayItems()
  {
    return this.displayItems;
  }
  
  public final boolean getHasMedia()
  {
    return !((Collection)this.displayItems).isEmpty();
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
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
  
  public final void setContent(@NotNull ArrayList<EditObject> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.content = paramArrayList;
  }
  
  public final void setDisplayItems(@NotNull ArrayList<DisplayItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.displayItems = paramArrayList;
  }
  
  public final void setOriginContentInfo(@Nullable OriginContentInfo paramOriginContentInfo)
  {
    this.originContentInfo = paramOriginContentInfo;
  }
  
  @NotNull
  public String toString()
  {
    return "DraftArticleInfo(content=" + this.content + ", displayItems=" + this.displayItems + ", originContentInfo=" + this.originContentInfo + ", allowMultiTweetTopic=" + this.allowMultiTweetTopic + ", allowCommentAfterPublishConfig=" + this.allowCommentAfterPublishConfig + ", allowSaveAlbums=" + this.allowSaveAlbums + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.DraftArticleInfo
 * JD-Core Version:    0.7.0.1
 */