package com.tencent.tkd.topicsdk.bean;

import androidx.annotation.VisibleForTesting;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.tkd.topicsdk.bean.DisplayItem;>;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "Ljava/io/Serializable;", "()V", "allowReprint", "", "getAllowReprint", "()Z", "setAllowReprint", "(Z)V", "circleId", "", "getCircleId", "()Ljava/lang/String;", "setCircleId", "(Ljava/lang/String;)V", "commentAfterPublish", "getCommentAfterPublish", "setCommentAfterPublish", "commodityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;", "getCommodityInfo", "()Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;", "setCommodityInfo", "(Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;)V", "communityId", "getCommunityId", "setCommunityId", "communityName", "getCommunityName", "setCommunityName", "content", "getContent", "contentId", "getContentId", "setContentId", "contentLength", "", "getContentLength", "()I", "setContentLength", "(I)V", "contentList", "", "Lcom/tencent/tkd/weibo/bean/EditObject;", "getContentList", "()Ljava/util/List;", "setContentList", "(Ljava/util/List;)V", "hasUploadFileSize", "", "getHasUploadFileSize", "()J", "setHasUploadFileSize", "(J)V", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/ImageInfo;", "Lkotlin/collections/ArrayList;", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "invitedManuscriptItem", "Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;", "getInvitedManuscriptItem", "()Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;", "setInvitedManuscriptItem", "(Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;)V", "isFromDraft", "setFromDraft", "isOriginalContent", "setOriginalContent", "isPublishing", "setPublishing", "locationInfo", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "getLocationInfo", "()Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "setLocationInfo", "(Lcom/tencent/tkd/topicsdk/bean/LocationInfo;)V", "originContentInfo", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "getOriginContentInfo", "()Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "setOriginContentInfo", "(Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;)V", "privacySetting", "getPrivacySetting", "setPrivacySetting", "publishErrorCode", "getPublishErrorCode", "setPublishErrorCode", "publishErrorMsg", "getPublishErrorMsg", "setPublishErrorMsg", "publishId", "getPublishId", "setPublishId", "publishScene", "getPublishScene", "setPublishScene", "publishType", "getPublishType", "setPublishType", "scene", "getScene", "setScene", "showPublishToast", "getShowPublishToast", "setShowPublishToast", "topicId", "getTopicId", "setTopicId", "totalFileSize", "getTotalFileSize", "videoInfo", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "getVideoInfo", "()Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "setVideoInfo", "(Lcom/tencent/tkd/topicsdk/bean/VideoInfo;)V", "videoUploadKey", "getVideoUploadKey", "setVideoUploadKey", "buildLocalPublishJsonData", "Lorg/json/JSONObject;", "calTotalFileSize", "hasImage", "hasText", "hasVideo", "initMediaByDisplayItems", "", "displayItems", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "putLocalContentInfo", "localPublishData", "putLocalImageData", "putLocalVideoInfo", "putRichContentInfo", "updateImageWH", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticleInfo
  implements Serializable
{
  public static final PublishArticleInfo.Companion Companion = new PublishArticleInfo.Companion(null);
  @NotNull
  public static final String TITLE = "title";
  private static final long serialVersionUID = 0L;
  private boolean allowReprint;
  @NotNull
  private String circleId = "";
  private boolean commentAfterPublish;
  @Nullable
  private CommodityInfo commodityInfo;
  @NotNull
  private String communityId = "";
  @NotNull
  private String communityName = "";
  @NotNull
  private String contentId = "";
  private int contentLength;
  @NotNull
  private List<EditObject> contentList = (List)new ArrayList();
  private long hasUploadFileSize;
  @Nullable
  private ArrayList<ImageInfo> imageList;
  @Nullable
  private InvitedManuscriptItem invitedManuscriptItem;
  private boolean isFromDraft;
  private boolean isOriginalContent;
  private boolean isPublishing;
  @Nullable
  private LocationInfo locationInfo;
  @Nullable
  private OriginContentInfo originContentInfo;
  private int privacySetting = 2;
  private int publishErrorCode;
  @NotNull
  private String publishErrorMsg = "";
  @NotNull
  private String publishId = "";
  @NotNull
  private String publishScene = "";
  private int publishType;
  @NotNull
  private String scene = "";
  private boolean showPublishToast = true;
  private long topicId;
  @Nullable
  private VideoInfo videoInfo;
  @NotNull
  private String videoUploadKey = "";
  
  private final void a(JSONObject paramJSONObject)
  {
    paramJSONObject.putOpt("title", getContent());
    b(paramJSONObject);
  }
  
  private final void b(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("originText", getContent());
    localJSONObject.putOpt("titleLength", Integer.valueOf(this.contentLength));
    if ((((Collection)this.contentList).isEmpty() ^ true))
    {
      Object localObject1 = this.contentList;
      int i = 0;
      if (((EditObject)((List)localObject1).get(0)).getType() == EditObject.EditObjectType.TYPE_NORMAL)
      {
        localJSONObject.putOpt("text", ((EditObject)this.contentList.get(0)).getWording());
        i = 1;
      }
      localObject1 = new JSONArray();
      int j = this.contentList.size();
      while (i < j)
      {
        EditObject localEditObject = (EditObject)this.contentList.get(i);
        Object localObject2;
        if (localEditObject.getType() != EditObject.EditObjectType.TYPE_NORMAL)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).putOpt("type", Integer.valueOf(localEditObject.getType().ordinal()));
          ((JSONObject)localObject2).putOpt("key", localEditObject.getKey());
          ((JSONObject)localObject2).putOpt("wording", localEditObject.getWording());
          ((JSONObject)localObject2).putOpt("href", localEditObject.getHref());
          ((JSONObject)localObject2).putOpt("avatarUrl", localEditObject.getAvatarUrl());
          ((JSONArray)localObject1).put(localObject2);
        }
        else
        {
          int k = ((JSONArray)localObject1).length() - 1;
          localObject2 = ((JSONArray)localObject1).get(k);
          if (localObject2 == null) {
            break label315;
          }
          localObject2 = (JSONObject)localObject2;
          ((JSONObject)localObject2).putOpt("text", localEditObject.getWording());
          ((JSONArray)localObject1).put(k, localObject2);
        }
        i += 1;
        continue;
        label315:
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      localJSONObject.putOpt("textLevelList", localObject1);
    }
    else
    {
      localJSONObject.putOpt("textLevelList", new JSONArray());
    }
    paramJSONObject.putOpt("richTextInfo", localJSONObject);
  }
  
  private final void c(JSONObject paramJSONObject)
  {
    paramJSONObject.put("circleId", this.circleId);
    Object localObject1 = this.imageList;
    int i;
    if (localObject1 != null) {
      i = ((ArrayList)localObject1).size();
    } else {
      i = 0;
    }
    paramJSONObject.put("imageDataListCount", i);
    localObject1 = new JSONArray();
    Object localObject2 = this.imageList;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ImageInfo)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("imageWidth", ((ImageInfo)localObject3).getWidth());
        localJSONObject.put("imageHeight", ((ImageInfo)localObject3).getHeight());
        localJSONObject.put("imageUrl", ((ImageInfo)localObject3).getUrl());
        localJSONObject.put("imageSize", ((ImageInfo)localObject3).getSize());
        localJSONObject.put("md5", ((ImageInfo)localObject3).getMd5());
        localObject3 = FileUtils.a.e(((ImageInfo)localObject3).getFilePath());
        Locale localLocale = Locale.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.getDefault()");
        if (localObject3 != null)
        {
          localObject3 = ((String)localObject3).toUpperCase(localLocale);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "(this as java.lang.String).toUpperCase(locale)");
          localJSONObject.put("isGif", Intrinsics.areEqual(localObject3, "GIF"));
          ((JSONArray)localObject1).put(localJSONObject);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
    }
    paramJSONObject.put("imageDataList", localObject1);
  }
  
  private final void d(JSONObject paramJSONObject)
  {
    Object localObject = this.videoInfo;
    if (localObject != null)
    {
      paramJSONObject.put("videoDuration", ((VideoInfo)localObject).getDuration() / 1000);
      paramJSONObject.put("coverImageUrl", ((VideoInfo)localObject).getCoverUrl());
      paramJSONObject.put("videoUrl", ((VideoInfo)localObject).getUrl());
      paramJSONObject.put("videoSize", ((VideoInfo)localObject).getFileSize());
      paramJSONObject.put("videoWidth", ((VideoInfo)localObject).getWidth());
      paramJSONObject.put("videoHeight", ((VideoInfo)localObject).getHeight());
      paramJSONObject.put("coverImageWidth", ((VideoInfo)localObject).getCoverWidth());
      paramJSONObject.put("coverImageHeight", ((VideoInfo)localObject).getCoverHeight());
      paramJSONObject.put("videoMd5", ((VideoInfo)localObject).getFileMd5());
      paramJSONObject.put("title", getContent());
      localObject = FileUtils.a.e(((VideoInfo)localObject).getFilePath());
      Locale localLocale = Locale.getDefault();
      Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.getDefault()");
      if (localObject != null)
      {
        localObject = ((String)localObject).toUpperCase(localLocale);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).toUpperCase(locale)");
        paramJSONObject.put("videoFormat", localObject);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
  }
  
  @NotNull
  public final JSONObject buildLocalPublishJsonData()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @VisibleForTesting
  public final long calTotalFileSize()
  {
    Object localObject = this.imageList;
    long l3 = 0L;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      for (l1 = 0L;; l1 += ((ImageInfo)((Iterator)localObject).next()).getSize())
      {
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      }
    }
    long l2 = 0L;
    localObject = this.videoInfo;
    long l1 = l3;
    if (localObject != null) {
      l1 = ((VideoInfo)localObject).getFileSize();
    }
    return l2 + l1;
  }
  
  public final boolean getAllowReprint()
  {
    return this.allowReprint;
  }
  
  @NotNull
  public final String getCircleId()
  {
    return this.circleId;
  }
  
  public final boolean getCommentAfterPublish()
  {
    return this.commentAfterPublish;
  }
  
  @Nullable
  public final CommodityInfo getCommodityInfo()
  {
    return this.commodityInfo;
  }
  
  @NotNull
  public final String getCommunityId()
  {
    return this.communityId;
  }
  
  @NotNull
  public final String getCommunityName()
  {
    return this.communityName;
  }
  
  @NotNull
  public final String getContent()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = ((Iterable)this.contentList).iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((EditObject)localIterator.next()).getWording());
    }
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "stringBuilder.toString()");
    return localObject;
  }
  
  @NotNull
  public final String getContentId()
  {
    return this.contentId;
  }
  
  public final int getContentLength()
  {
    return this.contentLength;
  }
  
  @NotNull
  public final List<EditObject> getContentList()
  {
    return this.contentList;
  }
  
  public final long getHasUploadFileSize()
  {
    return this.hasUploadFileSize;
  }
  
  @Nullable
  public final ArrayList<ImageInfo> getImageList()
  {
    return this.imageList;
  }
  
  @Nullable
  public final InvitedManuscriptItem getInvitedManuscriptItem()
  {
    return this.invitedManuscriptItem;
  }
  
  @Nullable
  public final LocationInfo getLocationInfo()
  {
    return this.locationInfo;
  }
  
  @Nullable
  public final OriginContentInfo getOriginContentInfo()
  {
    return this.originContentInfo;
  }
  
  public final int getPrivacySetting()
  {
    return this.privacySetting;
  }
  
  public final int getPublishErrorCode()
  {
    return this.publishErrorCode;
  }
  
  @NotNull
  public final String getPublishErrorMsg()
  {
    return this.publishErrorMsg;
  }
  
  @NotNull
  public final String getPublishId()
  {
    return this.publishId;
  }
  
  @NotNull
  public final String getPublishScene()
  {
    return this.publishScene;
  }
  
  public final int getPublishType()
  {
    return this.publishType;
  }
  
  @NotNull
  public final String getScene()
  {
    return this.scene;
  }
  
  public final boolean getShowPublishToast()
  {
    return this.showPublishToast;
  }
  
  public final long getTopicId()
  {
    return this.topicId;
  }
  
  public final long getTotalFileSize()
  {
    return calTotalFileSize();
  }
  
  @Nullable
  public final VideoInfo getVideoInfo()
  {
    return this.videoInfo;
  }
  
  @NotNull
  public final String getVideoUploadKey()
  {
    return this.videoUploadKey;
  }
  
  public final boolean hasImage()
  {
    ArrayList localArrayList = this.imageList;
    return (localArrayList != null) && (localArrayList != null) && ((((Collection)localArrayList).isEmpty() ^ true) == true);
  }
  
  public final boolean hasText()
  {
    return ((CharSequence)getContent()).length() > 0;
  }
  
  public final boolean hasVideo()
  {
    return this.videoInfo != null;
  }
  
  public final void initMediaByDisplayItems(@NotNull ArrayList<DisplayItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "displayItems");
    ArrayList localArrayList = new ArrayList();
    Object localObject = (VideoInfo)null;
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    paramArrayList = (ArrayList<DisplayItem>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (DisplayItem)localIterator.next();
      if (((DisplayItem)localObject).getMedia().getType() == MediaType.PHOTO) {
        localArrayList.add(ImageInfo.Companion.a((DisplayItem)localObject));
      } else if (((DisplayItem)localObject).getMedia().getType() == MediaType.VIDEO) {
        paramArrayList = VideoInfo.Companion.a((DisplayItem)localObject);
      }
    }
    if (!(((Collection)localArrayList).isEmpty() ^ true)) {
      localArrayList = null;
    }
    this.imageList = localArrayList;
    this.videoInfo = paramArrayList;
  }
  
  public final boolean isFromDraft()
  {
    return this.isFromDraft;
  }
  
  public final boolean isOriginalContent()
  {
    return this.isOriginalContent;
  }
  
  public final boolean isPublishing()
  {
    return this.isPublishing;
  }
  
  public final void setAllowReprint(boolean paramBoolean)
  {
    this.allowReprint = paramBoolean;
  }
  
  public final void setCircleId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.circleId = paramString;
  }
  
  public final void setCommentAfterPublish(boolean paramBoolean)
  {
    this.commentAfterPublish = paramBoolean;
  }
  
  public final void setCommodityInfo(@Nullable CommodityInfo paramCommodityInfo)
  {
    this.commodityInfo = paramCommodityInfo;
  }
  
  public final void setCommunityId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.communityId = paramString;
  }
  
  public final void setCommunityName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.communityName = paramString;
  }
  
  public final void setContentId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.contentId = paramString;
  }
  
  public final void setContentLength(int paramInt)
  {
    this.contentLength = paramInt;
  }
  
  public final void setContentList(@NotNull List<EditObject> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.contentList = paramList;
  }
  
  public final void setFromDraft(boolean paramBoolean)
  {
    this.isFromDraft = paramBoolean;
  }
  
  public final void setHasUploadFileSize(long paramLong)
  {
    this.hasUploadFileSize = paramLong;
  }
  
  public final void setImageList(@Nullable ArrayList<ImageInfo> paramArrayList)
  {
    this.imageList = paramArrayList;
  }
  
  public final void setInvitedManuscriptItem(@Nullable InvitedManuscriptItem paramInvitedManuscriptItem)
  {
    this.invitedManuscriptItem = paramInvitedManuscriptItem;
  }
  
  public final void setLocationInfo(@Nullable LocationInfo paramLocationInfo)
  {
    this.locationInfo = paramLocationInfo;
  }
  
  public final void setOriginContentInfo(@Nullable OriginContentInfo paramOriginContentInfo)
  {
    this.originContentInfo = paramOriginContentInfo;
  }
  
  public final void setOriginalContent(boolean paramBoolean)
  {
    this.isOriginalContent = paramBoolean;
  }
  
  public final void setPrivacySetting(int paramInt)
  {
    this.privacySetting = paramInt;
  }
  
  public final void setPublishErrorCode(int paramInt)
  {
    this.publishErrorCode = paramInt;
  }
  
  public final void setPublishErrorMsg(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishErrorMsg = paramString;
  }
  
  public final void setPublishId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishId = paramString;
  }
  
  public final void setPublishScene(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishScene = paramString;
  }
  
  public final void setPublishType(int paramInt)
  {
    this.publishType = paramInt;
  }
  
  public final void setPublishing(boolean paramBoolean)
  {
    this.isPublishing = paramBoolean;
  }
  
  public final void setScene(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.scene = paramString;
  }
  
  public final void setShowPublishToast(boolean paramBoolean)
  {
    this.showPublishToast = paramBoolean;
  }
  
  public final void setTopicId(long paramLong)
  {
    this.topicId = paramLong;
  }
  
  public final void setVideoInfo(@Nullable VideoInfo paramVideoInfo)
  {
    this.videoInfo = paramVideoInfo;
  }
  
  public final void setVideoUploadKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.videoUploadKey = paramString;
  }
  
  public final void updateImageWH(@Nullable Function1<? super PublishArticleInfo, Unit> paramFunction1)
  {
    Object localObject = this.imageList;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ImageInfo localImageInfo = (ImageInfo)((Iterator)localObject).next();
        Pair localPair = BitmapUtils.a.b(localImageInfo.getFilePath());
        localImageInfo.setWidth(((Number)localPair.getFirst()).intValue());
        localImageInfo.setHeight(((Number)localPair.getSecond()).intValue());
      }
    }
    ThreadManagerKt.a((Function0)new PublishArticleInfo.updateImageWH.2(this, paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.PublishArticleInfo
 * JD-Core Version:    0.7.0.1
 */