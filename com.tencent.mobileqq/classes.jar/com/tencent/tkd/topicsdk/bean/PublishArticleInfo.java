package com.tencent.tkd.topicsdk.bean;

import com.tencent.tkd.topicsdk.common.FileUtils;
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
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "Ljava/io/Serializable;", "()V", "allowReprint", "", "getAllowReprint", "()Z", "setAllowReprint", "(Z)V", "circleId", "", "getCircleId", "()Ljava/lang/String;", "setCircleId", "(Ljava/lang/String;)V", "commentAfterPublish", "getCommentAfterPublish", "setCommentAfterPublish", "commodityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;", "getCommodityInfo", "()Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;", "setCommodityInfo", "(Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;)V", "communityId", "getCommunityId", "setCommunityId", "content", "getContent", "contentId", "getContentId", "setContentId", "contentLength", "", "getContentLength", "()I", "setContentLength", "(I)V", "contentList", "", "Lcom/tencent/tkd/weibo/bean/EditObject;", "getContentList", "()Ljava/util/List;", "setContentList", "(Ljava/util/List;)V", "hasUploadFileSize", "", "getHasUploadFileSize", "()J", "setHasUploadFileSize", "(J)V", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/ImageInfo;", "Lkotlin/collections/ArrayList;", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "isFromDraft", "setFromDraft", "isPublishing", "setPublishing", "locationInfo", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "getLocationInfo", "()Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "setLocationInfo", "(Lcom/tencent/tkd/topicsdk/bean/LocationInfo;)V", "originContentInfo", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "getOriginContentInfo", "()Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "setOriginContentInfo", "(Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;)V", "privacySetting", "getPrivacySetting", "setPrivacySetting", "publishErrorCode", "getPublishErrorCode", "setPublishErrorCode", "publishErrorMsg", "getPublishErrorMsg", "setPublishErrorMsg", "publishId", "getPublishId", "setPublishId", "publishScene", "getPublishScene", "setPublishScene", "scene", "getScene", "setScene", "topicId", "getTopicId", "setTopicId", "totalFileSize", "getTotalFileSize", "videoInfo", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "getVideoInfo", "()Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "setVideoInfo", "(Lcom/tencent/tkd/topicsdk/bean/VideoInfo;)V", "videoUploadKey", "getVideoUploadKey", "setVideoUploadKey", "buildLocalPublishJsonData", "Lorg/json/JSONObject;", "calTotalFileSize", "hasImage", "hasText", "hasVideo", "putLocalContentInfo", "", "localPublishData", "putLocalImageData", "putLocalVideoInfo", "putRichContentInfo", "updateDisplayInfoInArticleInfo", "displayItems", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
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
  private String contentId = "";
  private int contentLength;
  @NotNull
  private List<EditObject> contentList = (List)new ArrayList();
  private long hasUploadFileSize;
  @Nullable
  private ArrayList<ImageInfo> imageList;
  private boolean isFromDraft;
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
  @NotNull
  private String scene = "";
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
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("originText", getContent());
    localJSONObject.putOpt("titleLength", Integer.valueOf(this.contentLength));
    if (!((Collection)this.contentList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label360;
      }
      if (((EditObject)this.contentList.get(0)).getType() != EditObject.EditObjectType.TYPE_NORMAL) {
        break label379;
      }
      localJSONObject.putOpt("text", ((EditObject)this.contentList.get(0)).getWording());
    }
    label122:
    label379:
    for (int i = 1;; i = 0)
    {
      JSONArray localJSONArray = new JSONArray();
      EditObject localEditObject;
      Object localObject;
      if (i != 0)
      {
        i = j;
        j = this.contentList.size();
        if (i >= j) {
          break label338;
        }
        localEditObject = (EditObject)this.contentList.get(i);
        if (localEditObject.getType() == EditObject.EditObjectType.TYPE_NORMAL) {
          break label271;
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).putOpt("type", Integer.valueOf(localEditObject.getType().ordinal()));
        ((JSONObject)localObject).putOpt("key", localEditObject.getKey());
        ((JSONObject)localObject).putOpt("wording", localEditObject.getWording());
        ((JSONObject)localObject).putOpt("href", localEditObject.getHref());
        ((JSONObject)localObject).putOpt("avatarUrl", localEditObject.getAvatarUrl());
        localJSONArray.put(localObject);
      }
      for (;;)
      {
        i += 1;
        break label132;
        i = 0;
        break;
        i = 0;
        break label122;
        int k = localJSONArray.length() - 1;
        localObject = localJSONArray.get(k);
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
        localObject = (JSONObject)localObject;
        ((JSONObject)localObject).putOpt("text", localEditObject.getWording());
        localJSONArray.put(k, localObject);
      }
      localJSONObject.putOpt("textLevelList", localJSONArray);
      for (;;)
      {
        paramJSONObject.putOpt("richTextInfo", localJSONObject);
        return;
        localJSONObject.putOpt("textLevelList", new JSONArray());
      }
    }
  }
  
  private final void c(JSONObject paramJSONObject)
  {
    paramJSONObject.put("circleId", this.circleId);
    Object localObject1 = this.imageList;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((ArrayList)localObject1).size();
      paramJSONObject.put("imageDataListCount", i);
      localObject1 = new JSONArray();
      localObject2 = this.imageList;
      if (localObject2 != null) {
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label258;
        }
        Object localObject3 = (ImageInfo)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("imageWidth", ((ImageInfo)localObject3).getWidth());
        localJSONObject.put("imageHeight", ((ImageInfo)localObject3).getHeight());
        localJSONObject.put("imageUrl", ((ImageInfo)localObject3).getUrl());
        localJSONObject.put("imageSize", ((ImageInfo)localObject3).getSize());
        localJSONObject.put("md5", ((ImageInfo)localObject3).getMd5());
        localObject3 = FileUtils.a.a(((ImageInfo)localObject3).getFilePath());
        Locale localLocale = Locale.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.getDefault()");
        if (localObject3 == null)
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          i = 0;
          break;
        }
        localObject3 = ((String)localObject3).toUpperCase(localLocale);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "(this as java.lang.String).toUpperCase(locale)");
        localJSONObject.put("isGif", Intrinsics.areEqual(localObject3, "GIF"));
        ((JSONArray)localObject1).put(localJSONObject);
      }
    }
    label258:
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
      localObject = FileUtils.a.a(((VideoInfo)localObject).getFilePath());
      Locale localLocale = Locale.getDefault();
      Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.getDefault()");
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      localObject = ((String)localObject).toUpperCase(localLocale);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).toUpperCase(locale)");
      paramJSONObject.put("videoFormat", localObject);
    }
  }
  
  @NotNull
  public final JSONObject buildLocalPublishJsonData()
  {
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject);
    if (hasVideo())
    {
      d(localJSONObject);
      localJSONObject.put("fromDraft", this.isFromDraft);
      if (!this.commentAfterPublish) {
        break label72;
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("publishAndComment", i);
      return localJSONObject;
      if (!hasImage()) {
        break;
      }
      c(localJSONObject);
      break;
    }
  }
  
  public final long calTotalFileSize()
  {
    long l3 = 0L;
    Object localObject = this.imageList;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      for (l1 = 0L;; l1 = ((ImageInfo)((Iterator)localObject).next()).getSize() + l1)
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
  
  @NotNull
  public final String getScene()
  {
    return this.scene;
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
    if (this.imageList != null)
    {
      ArrayList localArrayList = this.imageList;
      if (localArrayList != null)
      {
        if (!((Collection)localArrayList).isEmpty()) {}
        for (int i = 1; i == 1; i = 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final boolean hasText()
  {
    return ((CharSequence)getContent()).length() > 0;
  }
  
  public final boolean hasVideo()
  {
    return this.videoInfo != null;
  }
  
  public final boolean isFromDraft()
  {
    return this.isFromDraft;
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
  
  public final void setLocationInfo(@Nullable LocationInfo paramLocationInfo)
  {
    this.locationInfo = paramLocationInfo;
  }
  
  public final void setOriginContentInfo(@Nullable OriginContentInfo paramOriginContentInfo)
  {
    this.originContentInfo = paramOriginContentInfo;
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
  
  public final void setPublishing(boolean paramBoolean)
  {
    this.isPublishing = paramBoolean;
  }
  
  public final void setScene(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.scene = paramString;
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
  
  public final void updateDisplayInfoInArticleInfo(@NotNull ArrayList<DisplayItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "displayItems");
    ArrayList localArrayList = new ArrayList();
    Object localObject = (VideoInfo)null;
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    paramArrayList = (ArrayList<DisplayItem>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (DisplayItem)localIterator.next();
      if (((DisplayItem)localObject).getMedia().getType() == MediaType.PHOTO)
      {
        localObject = ((DisplayItem)localObject).getMedia();
        ImageInfo localImageInfo = new ImageInfo();
        localImageInfo.setFilePath(((Media)localObject).getFilePath());
        localImageInfo.setWidth(((Media)localObject).getWidth());
        localImageInfo.setHeight(((Media)localObject).getHeight());
        localImageInfo.setSize(((Media)localObject).getSize());
        localArrayList.add(localImageInfo);
      }
    }
    for (;;)
    {
      break;
      if (((DisplayItem)localObject).getMedia().getType() == MediaType.VIDEO)
      {
        paramArrayList = new VideoInfo();
        paramArrayList.setFilePath(((DisplayItem)localObject).getRealPath());
        paramArrayList.setCoverPath(((DisplayItem)localObject).getCoverPath());
        paramArrayList.setDuration(((DisplayItem)localObject).getRealDuration());
        localObject = ((DisplayItem)localObject).getMedia();
        paramArrayList.setCoverWidth(((Media)localObject).getWidth());
        paramArrayList.setCoverHeight(((Media)localObject).getHeight());
        paramArrayList.setWidth(((Media)localObject).getWidth());
        paramArrayList.setHeight(((Media)localObject).getHeight());
        paramArrayList.setFileSize(((Media)localObject).getSize());
        continue;
        int i;
        if (!((Collection)localArrayList).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label275;
          }
        }
        for (;;)
        {
          this.imageList = localArrayList;
          this.videoInfo = paramArrayList;
          return;
          i = 0;
          break;
          label275:
          localArrayList = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.PublishArticleInfo
 * JD-Core Version:    0.7.0.1
 */