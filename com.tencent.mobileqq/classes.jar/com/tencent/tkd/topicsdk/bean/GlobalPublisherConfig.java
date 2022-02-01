package com.tencent.tkd.topicsdk.bean;

import com.tencent.tkd.topicsdk.bean.globalconfig.AddToTopicConfig;
import com.tencent.tkd.topicsdk.bean.globalconfig.BusinessToastConfig;
import com.tencent.tkd.topicsdk.bean.globalconfig.CommodityConfig;
import com.tencent.tkd.topicsdk.bean.globalconfig.InputPanelConfig;
import com.tencent.tkd.topicsdk.bean.globalconfig.PrivacySettingConfig;
import com.tencent.tkd.topicsdk.bean.globalconfig.ReprintAuthorityConfig;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "Ljava/io/Serializable;", "()V", "addToTopicConfig", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/AddToTopicConfig;", "getAddToTopicConfig", "()Lcom/tencent/tkd/topicsdk/bean/globalconfig/AddToTopicConfig;", "setAddToTopicConfig", "(Lcom/tencent/tkd/topicsdk/bean/globalconfig/AddToTopicConfig;)V", "allowCreateTweetTopic", "", "getAllowCreateTweetTopic", "()Z", "setAllowCreateTweetTopic", "(Z)V", "allowDeleteTweetTopic", "getAllowDeleteTweetTopic", "setAllowDeleteTweetTopic", "allowEmoji", "getAllowEmoji", "setAllowEmoji", "businessToastConfig", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/BusinessToastConfig;", "getBusinessToastConfig", "()Lcom/tencent/tkd/topicsdk/bean/globalconfig/BusinessToastConfig;", "setBusinessToastConfig", "(Lcom/tencent/tkd/topicsdk/bean/globalconfig/BusinessToastConfig;)V", "circleId", "", "getCircleId", "()Ljava/lang/String;", "setCircleId", "(Ljava/lang/String;)V", "commodityConfig", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/CommodityConfig;", "getCommodityConfig", "()Lcom/tencent/tkd/topicsdk/bean/globalconfig/CommodityConfig;", "setCommodityConfig", "(Lcom/tencent/tkd/topicsdk/bean/globalconfig/CommodityConfig;)V", "communityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "getCommunityInfo", "()Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "setCommunityInfo", "(Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;)V", "contentLowerLimit", "", "getContentLowerLimit", "()I", "setContentLowerLimit", "(I)V", "contentUpperLimit", "getContentUpperLimit", "setContentUpperLimit", "defaultPublishText", "getDefaultPublishText", "setDefaultPublishText", "enableRestoreDraft", "getEnableRestoreDraft", "setEnableRestoreDraft", "enableSaveDraft", "getEnableSaveDraft", "setEnableSaveDraft", "eventInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventInfo", "()Ljava/util/HashMap;", "setEventInfo", "(Ljava/util/HashMap;)V", "inputPanelConfig", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/InputPanelConfig;", "getInputPanelConfig", "()Lcom/tencent/tkd/topicsdk/bean/globalconfig/InputPanelConfig;", "setInputPanelConfig", "(Lcom/tencent/tkd/topicsdk/bean/globalconfig/InputPanelConfig;)V", "maxImageSize", "getMaxImageSize", "setMaxImageSize", "maxVideoLength", "getMaxVideoLength", "setMaxVideoLength", "maxVideoSize", "getMaxVideoSize", "setMaxVideoSize", "minVideoLength", "getMinVideoLength", "setMinVideoLength", "navigationBarText", "getNavigationBarText", "setNavigationBarText", "needTextTruncation", "getNeedTextTruncation", "setNeedTextTruncation", "originContentInfo", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "getOriginContentInfo", "()Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "setOriginContentInfo", "(Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;)V", "originText", "getOriginText", "setOriginText", "originVideoInfo", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "getOriginVideoInfo", "()Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "setOriginVideoInfo", "(Lcom/tencent/tkd/topicsdk/bean/VideoInfo;)V", "permissionInfo", "Lcom/tencent/tkd/topicsdk/bean/PermissionInfo;", "getPermissionInfo", "()Lcom/tencent/tkd/topicsdk/bean/PermissionInfo;", "setPermissionInfo", "(Lcom/tencent/tkd/topicsdk/bean/PermissionInfo;)V", "placeHolder", "getPlaceHolder", "setPlaceHolder", "privacySettingConfig", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/PrivacySettingConfig;", "getPrivacySettingConfig", "()Lcom/tencent/tkd/topicsdk/bean/globalconfig/PrivacySettingConfig;", "setPrivacySettingConfig", "(Lcom/tencent/tkd/topicsdk/bean/globalconfig/PrivacySettingConfig;)V", "publishScene", "getPublishScene", "setPublishScene", "publisherTheme", "getPublisherTheme", "setPublisherTheme", "recentTopicDismissTime", "getRecentTopicDismissTime", "setRecentTopicDismissTime", "reportInfo", "getReportInfo", "setReportInfo", "reprintAuthorityConfig", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/ReprintAuthorityConfig;", "getReprintAuthorityConfig", "()Lcom/tencent/tkd/topicsdk/bean/globalconfig/ReprintAuthorityConfig;", "setReprintAuthorityConfig", "(Lcom/tencent/tkd/topicsdk/bean/globalconfig/ReprintAuthorityConfig;)V", "scene", "getScene", "setScene", "showAddLocation", "getShowAddLocation", "setShowAddLocation", "showAddToTopic", "getShowAddToTopic", "setShowAddToTopic", "showBottomSelectorPanel", "getShowBottomSelectorPanel", "setShowBottomSelectorPanel", "showCommentAfterPublish", "getShowCommentAfterPublish", "setShowCommentAfterPublish", "showCommunitySelector", "getShowCommunitySelector", "setShowCommunitySelector", "showDefaultColumn", "getShowDefaultColumn", "setShowDefaultColumn", "showDeliverType", "getShowDeliverType", "setShowDeliverType", "showExtraPropertyContainer", "getShowExtraPropertyContainer", "setShowExtraPropertyContainer", "showOriginalTag", "getShowOriginalTag", "setShowOriginalTag", "showPrivacySetting", "getShowPrivacySetting", "setShowPrivacySetting", "showPublishToast", "getShowPublishToast", "setShowPublishToast", "showRecentTopic", "getShowRecentTopic", "setShowRecentTopic", "showSaveAlbums", "getShowSaveAlbums", "setShowSaveAlbums", "showTopicSelector", "getShowTopicSelector", "setShowTopicSelector", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "getTopicInfo", "()Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "setTopicInfo", "(Lcom/tencent/tkd/topicsdk/bean/TopicInfo;)V", "tweetTopicChoiceType", "getTweetTopicChoiceType", "setTweetTopicChoiceType", "applyValidProtect", "", "getEditObjectListByOriginText", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "getEditObjectTypeByValue", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "type", "needShowSelectCommunityView", "ownerType", "needShowSelectTopicView", "putBottomPanelConfig", "eventInfoJson", "Lorg/json/JSONObject;", "putBusinessToastConfig", "putCircleID", "putColumnConfig", "putCommodityConfig", "putInputPanelConfig", "putNeedShowPublishToast", "putOriginVideoInfo", "putPermissionInfo", "putPrivacyConfig", "putPublishOwner", "putPublishScene", "putRecentTopicConfig", "putReportInfo", "putReprintAuthorityConfig", "updateByRestrictInfo", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishRestrictInfo;", "updatePanelConfig", "updateSelectorConfig", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GlobalPublisherConfig
  implements Serializable
{
  public static final GlobalPublisherConfig.Companion Companion = new GlobalPublisherConfig.Companion(null);
  @NotNull
  private AddToTopicConfig addToTopicConfig = new AddToTopicConfig();
  private boolean allowCreateTweetTopic;
  private boolean allowDeleteTweetTopic = true;
  private boolean allowEmoji = true;
  @NotNull
  private BusinessToastConfig businessToastConfig = new BusinessToastConfig();
  @NotNull
  private String circleId = "";
  @NotNull
  private CommodityConfig commodityConfig = new CommodityConfig();
  @Nullable
  private CommunityInfo communityInfo;
  private int contentLowerLimit;
  private int contentUpperLimit;
  @NotNull
  private String defaultPublishText = "";
  private boolean enableRestoreDraft = true;
  private boolean enableSaveDraft;
  @Nullable
  private HashMap<?, ?> eventInfo;
  @NotNull
  private InputPanelConfig inputPanelConfig = new InputPanelConfig(false, false, false, false, false, false, false, false, 255, null);
  private int maxImageSize = 15360;
  private int maxVideoLength = 60000;
  private int maxVideoSize = 1048576;
  private int minVideoLength = 5000;
  @NotNull
  private String navigationBarText = "";
  private boolean needTextTruncation;
  @Nullable
  private OriginContentInfo originContentInfo;
  @NotNull
  private String originText = "";
  @Nullable
  private VideoInfo originVideoInfo;
  @NotNull
  private PermissionInfo permissionInfo = new PermissionInfo();
  @NotNull
  private String placeHolder = "";
  @NotNull
  private PrivacySettingConfig privacySettingConfig = new PrivacySettingConfig();
  @NotNull
  private String publishScene = "";
  private int publisherTheme;
  private int recentTopicDismissTime = 5;
  @Nullable
  private HashMap<String, String> reportInfo;
  @NotNull
  private ReprintAuthorityConfig reprintAuthorityConfig = new ReprintAuthorityConfig();
  @NotNull
  private String scene = "";
  private boolean showAddLocation;
  private boolean showAddToTopic;
  private boolean showBottomSelectorPanel = true;
  private boolean showCommentAfterPublish = true;
  private boolean showCommunitySelector;
  private boolean showDefaultColumn;
  private boolean showDeliverType;
  private boolean showExtraPropertyContainer = true;
  private boolean showOriginalTag;
  private boolean showPrivacySetting;
  private boolean showPublishToast = true;
  private boolean showRecentTopic;
  private boolean showSaveAlbums = true;
  private boolean showTopicSelector;
  @Nullable
  private TopicInfo topicInfo;
  private int tweetTopicChoiceType;
  
  private final void a()
  {
    if (this.communityInfo != null)
    {
      this.showTopicSelector = false;
      this.showCommunitySelector = true;
    }
    if (this.topicInfo != null)
    {
      this.showCommunitySelector = false;
      this.showTopicSelector = true;
    }
  }
  
  private final void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("commodityConfig");
    if (localObject != null)
    {
      paramJSONObject = new CommodityConfig();
      int i = ((JSONObject)localObject).optInt("showUserHint");
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramJSONObject.setShowUserHint(bool);
      String str = ((JSONObject)localObject).optString("userHint");
      Intrinsics.checkExpressionValueIsNotNull(str, "info.optString(J_KEY_USER_HINT)");
      paramJSONObject.setUserHint(str);
      localObject = ((JSONObject)localObject).optString("userHintUrl");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "info.optString(J_KEY_USER_HINT_URL)");
      paramJSONObject.setUserHintUrl((String)localObject);
      this.commodityConfig = paramJSONObject;
    }
  }
  
  private final boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        if (paramInt == 4) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private final void b()
  {
    boolean bool1 = Intrinsics.areEqual(this.publishScene, "KOL");
    boolean bool2 = false;
    if (!bool1)
    {
      if (((CharSequence)this.publishScene).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        i = 0;
        break label56;
      }
    }
    int i = 1;
    label56:
    int j;
    if ((this.showTopicSelector) && (!this.showCommunitySelector)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j == 0) && (this.topicInfo == null) && (i != 0)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((this.inputPanelConfig.getShowPicPanel()) && (i == 0)) {
      k = 1;
    } else {
      k = 0;
    }
    InputPanelConfig localInputPanelConfig = this.inputPanelConfig;
    if ((j == 0) && (k == 0)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localInputPanelConfig.setShowPicPanel(bool1);
    if (((this.showTopicSelector) || (this.showCommunitySelector)) && (i != 0)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((this.inputPanelConfig.getShowVideoPanel()) && (i == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    localInputPanelConfig = this.inputPanelConfig;
    if (j == 0)
    {
      bool1 = bool2;
      if (i == 0) {}
    }
    else
    {
      bool1 = true;
    }
    localInputPanelConfig.setShowVideoPanel(bool1);
  }
  
  private final void b(JSONObject paramJSONObject)
  {
    this.showPublishToast = paramJSONObject.optBoolean("needShowPublishSuccesToast", true);
  }
  
  private final boolean b(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 3)
      {
        if (paramInt == 5) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private final EditObject.EditObjectType c(int paramInt)
  {
    if (paramInt == EditObject.EditObjectType.TYPE_AT.ordinal()) {
      return EditObject.EditObjectType.TYPE_AT;
    }
    if (paramInt == EditObject.EditObjectType.TYPE_TOPIC.ordinal()) {
      return EditObject.EditObjectType.TYPE_TOPIC;
    }
    if (paramInt == EditObject.EditObjectType.TYPE_URL.ordinal()) {
      return EditObject.EditObjectType.TYPE_URL;
    }
    return EditObject.EditObjectType.TYPE_NORMAL;
  }
  
  private final void c(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("businessToastConfig");
    if (localObject != null)
    {
      paramJSONObject = new BusinessToastConfig();
      String str = ((JSONObject)localObject).optString("publishSuccessToast");
      Intrinsics.checkExpressionValueIsNotNull(str, "info.optString(J_KEY_PUBLISH_SUCCESS_TOAST)");
      paramJSONObject.setPublishSuccessToast(str);
      str = ((JSONObject)localObject).optString("publishFailToast");
      Intrinsics.checkExpressionValueIsNotNull(str, "info.optString(J_KEY_PUBLISH_FAIL_TOAST)");
      paramJSONObject.setPublishFailToast(str);
      localObject = ((JSONObject)localObject).optString("saveDraftToast");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "info.optString(J_KEY_SAVE_DRAFT_TOAST)");
      paramJSONObject.setSaveDraftToast((String)localObject);
      this.businessToastConfig = paramJSONObject;
    }
  }
  
  private final void d(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("reportInfo");
    if (paramJSONObject != null)
    {
      this.reportInfo = new HashMap();
      Iterator localIterator = paramJSONObject.keys();
      Intrinsics.checkExpressionValueIsNotNull(localIterator, "info.keys()");
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        HashMap localHashMap = this.reportInfo;
        if (localHashMap != null) {
          str = (String)localHashMap.put(str, paramJSONObject.get(str).toString());
        }
      }
    }
  }
  
  private final void e(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("permissionInfo");
    if (localObject != null)
    {
      paramJSONObject = this.permissionInfo;
      paramJSONObject.setPermissionFlag(((JSONObject)localObject).optInt("hasPermission", 1));
      String str = ((JSONObject)localObject).optString("text");
      Intrinsics.checkExpressionValueIsNotNull(str, "info.optString(J_KEY_TEXT)");
      paramJSONObject.setForbidToastText(str);
      str = ((JSONObject)localObject).optString("highLightText");
      Intrinsics.checkExpressionValueIsNotNull(str, "info.optString(J_KEY_HIGH_LIGHT_TEXT)");
      paramJSONObject.setForbidHighLightText(str);
      localObject = ((JSONObject)localObject).optString("jumpUrl");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "info.optString(J_KEY_JUMP_URL)");
      paramJSONObject.setForbidJumpUrl((String)localObject);
    }
  }
  
  private final void f(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.optInt("allowKOL");
    int i = 0;
    if ((j == 1) || (StorageManager.a(StorageManager.b, "kolPermissionView", false, 2, null)) || (Intrinsics.areEqual(this.publishScene, "KOL"))) {
      i = 1;
    }
    if (i != 0) {
      this.publishScene = "KOL";
    }
    paramJSONObject = paramJSONObject.optString("publishScene");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "eventInfoJson.optString(J_KEY_PUBLISH_SCENE)");
    this.publishScene = paramJSONObject;
  }
  
  private final void g(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("ownerType");
    if (a(i)) {
      this.showTopicSelector = true;
    }
    if (b(i)) {
      this.showCommunitySelector = true;
    }
    String str = paramJSONObject.optString("ownerID");
    paramJSONObject = paramJSONObject.optString("ownerName");
    Object localObject;
    if (i == 4)
    {
      localObject = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
      Intrinsics.checkExpressionValueIsNotNull(str, "ownerID");
      ((TopicInfo)localObject).setTopicId(Long.parseLong(str));
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "ownerName");
      ((TopicInfo)localObject).setTitle(paramJSONObject);
      this.topicInfo = ((TopicInfo)localObject);
      return;
    }
    if (i == 5)
    {
      localObject = new CommunityInfo(null, null, null, null, null, null, 63, null);
      Intrinsics.checkExpressionValueIsNotNull(str, "ownerID");
      ((CommunityInfo)localObject).setCommunityId(str);
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "ownerName");
      ((CommunityInfo)localObject).setTitle(paramJSONObject);
      this.communityInfo = ((CommunityInfo)localObject);
    }
  }
  
  private final void h(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("circleID");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "circleId");
    int i = ((CharSequence)paramJSONObject).length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (StorageManager.a(StorageManager.b, "useDebugCircleIdView", false, 2, null))) {
      i = j;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramJSONObject = "q_1345078251_1508915917578995";
    }
    this.circleId = paramJSONObject;
  }
  
  private final void i(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("inputPanelConfig");
    boolean bool1;
    if ((i & 0x1) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((i & 0x2) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((i & 0x4) != 0) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if ((i & 0x8) != 0) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool5;
    if ((i & 0x10) != 0) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    boolean bool6;
    if ((i & 0x40) != 0) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    boolean bool7;
    if ((i & 0x80) != 0) {
      bool7 = true;
    } else {
      bool7 = false;
    }
    boolean bool8;
    if ((i & 0x100) != 0) {
      bool8 = true;
    } else {
      bool8 = false;
    }
    this.inputPanelConfig = new InputPanelConfig(bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8);
  }
  
  private final void j(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("recentTopicConfig");
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("showRecentTopic");
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.showRecentTopic = bool;
      this.recentTopicDismissTime = paramJSONObject.optInt("dismissTime", 5);
    }
  }
  
  private final void k(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("bottomPanelConfig");
    if (paramJSONObject != null)
    {
      this.minVideoLength = (paramJSONObject.optInt("minVideoLength", 5) * 1000);
      this.maxVideoLength = (paramJSONObject.optInt("maxVideoLength", 60) * 1000);
      this.maxVideoSize = paramJSONObject.optInt("maxVideoSize", 1048576);
    }
  }
  
  private final void l(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("originVideoInfo");
    if (paramJSONObject != null)
    {
      VideoInfo localVideoInfo = new VideoInfo();
      String str = paramJSONObject.optString("videoPath");
      Intrinsics.checkExpressionValueIsNotNull(str, "videoObject.optString(J_KEY_VIDEO_PATH)");
      localVideoInfo.setFilePath(str);
      localVideoInfo.setDuration(paramJSONObject.optLong("videoDuration"));
      localVideoInfo.setFileSize(paramJSONObject.optLong("fileSize"));
      str = paramJSONObject.optString("coverPath");
      Intrinsics.checkExpressionValueIsNotNull(str, "videoObject.optString(J_KEY_COVER_PATH)");
      localVideoInfo.setCoverPath(str);
      localVideoInfo.setWidth(paramJSONObject.optInt("width"));
      localVideoInfo.setHeight(paramJSONObject.optInt("height"));
      this.originVideoInfo = localVideoInfo;
    }
  }
  
  private final void m(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("authorityConfig");
    if (paramJSONObject != null)
    {
      ReprintAuthorityConfig localReprintAuthorityConfig = new ReprintAuthorityConfig();
      this.showDeliverType = paramJSONObject.optBoolean("showAuthority");
      localReprintAuthorityConfig.setAllowReprint(paramJSONObject.optBoolean("allowReprint"));
      this.reprintAuthorityConfig = localReprintAuthorityConfig;
    }
  }
  
  private final void n(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("addToTopicConfig");
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("showAddToTopic");
      boolean bool2 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.showAddToTopic = bool1;
      if (paramJSONObject.optInt("default_column") == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.showDefaultColumn = bool1;
      AddToTopicConfig localAddToTopicConfig = new AddToTopicConfig();
      localAddToTopicConfig.setSelectedTopicId(paramJSONObject.optLong("selectedTopicID"));
      String str = paramJSONObject.optString("selectedTopicName");
      Intrinsics.checkExpressionValueIsNotNull(str, "columnJson.optString(J_KEY_SELECTED_TOPIC_NAME)");
      localAddToTopicConfig.setSelectedTopicName(str);
      boolean bool1 = bool2;
      if (paramJSONObject.optInt("disableSelectTopic") == 1) {
        bool1 = true;
      }
      localAddToTopicConfig.setDisableSelectTopic(bool1);
      this.addToTopicConfig = localAddToTopicConfig;
    }
  }
  
  private final void o(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("privacyConfig");
    if (localObject != null)
    {
      paramJSONObject = new PrivacySettingConfig();
      this.showPrivacySetting = ((JSONObject)localObject).optBoolean("showPrivacy");
      paramJSONObject.setPrivacySetting(((JSONObject)localObject).optInt("defaultPrivacy"));
      String str = ((JSONObject)localObject).optString("publicAndNotifyTitle");
      Intrinsics.checkExpressionValueIsNotNull(str, "privacyJson.optString(J_…_PUBLIC_AND_NOTIFY_TITLE)");
      paramJSONObject.setExtraTitle(str);
      str = ((JSONObject)localObject).optString("publicAndNotifyDesc");
      Intrinsics.checkExpressionValueIsNotNull(str, "privacyJson.optString(J_…Y_PUBLIC_AND_NOTIFY_DESC)");
      paramJSONObject.setExtraDesc(str);
      str = ((JSONObject)localObject).optString("publicTitle");
      Intrinsics.checkExpressionValueIsNotNull(str, "privacyJson.optString(J_KEY_PUBLIC_TITLE)");
      paramJSONObject.setPublicTitle(str);
      str = ((JSONObject)localObject).optString("publicDesc");
      Intrinsics.checkExpressionValueIsNotNull(str, "privacyJson.optString(J_KEY_PUBLIC_DESC)");
      paramJSONObject.setPublicDesc(str);
      str = ((JSONObject)localObject).optString("privateTitle");
      Intrinsics.checkExpressionValueIsNotNull(str, "privacyJson.optString(J_KEY_PRIVATE_TITLE)");
      paramJSONObject.setPrivateTitle(str);
      localObject = ((JSONObject)localObject).optString("privateDesc");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "privacyJson.optString(J_KEY_PRIVATE_DESC)");
      paramJSONObject.setPrivacyDesc((String)localObject);
      this.privacySettingConfig = paramJSONObject;
    }
  }
  
  public final void applyValidProtect()
  {
    boolean bool = this.inputPanelConfig.getShowEmotionLPanel();
    int i = 1;
    if ((!bool) && (!this.inputPanelConfig.getShowVideoPanel()) && (!this.inputPanelConfig.getShowAtPanel()) && (!this.inputPanelConfig.getShowPicPanel()) && (!this.inputPanelConfig.getShowTopicPanel())) {
      bool = false;
    } else {
      bool = true;
    }
    this.showBottomSelectorPanel = bool;
    if ((!this.showTopicSelector) && (!this.showCommunitySelector) && (!this.showRecentTopic)) {
      bool = false;
    } else {
      bool = true;
    }
    this.showExtraPropertyContainer = bool;
    if (this.contentUpperLimit == 0) {
      this.contentUpperLimit = 500;
    }
    if (((CharSequence)this.placeHolder).length() != 0) {
      i = 0;
    }
    if (i != 0) {
      this.placeHolder = "写点什么吧，万一火了呢";
    }
    a();
    b();
    if (this.originContentInfo == null) {
      this.showCommentAfterPublish = false;
    }
  }
  
  @NotNull
  public final AddToTopicConfig getAddToTopicConfig()
  {
    return this.addToTopicConfig;
  }
  
  public final boolean getAllowCreateTweetTopic()
  {
    return this.allowCreateTweetTopic;
  }
  
  public final boolean getAllowDeleteTweetTopic()
  {
    return this.allowDeleteTweetTopic;
  }
  
  public final boolean getAllowEmoji()
  {
    return this.allowEmoji;
  }
  
  @NotNull
  public final BusinessToastConfig getBusinessToastConfig()
  {
    return this.businessToastConfig;
  }
  
  @NotNull
  public final String getCircleId()
  {
    return this.circleId;
  }
  
  @NotNull
  public final CommodityConfig getCommodityConfig()
  {
    return this.commodityConfig;
  }
  
  @Nullable
  public final CommunityInfo getCommunityInfo()
  {
    return this.communityInfo;
  }
  
  public final int getContentLowerLimit()
  {
    return this.contentLowerLimit;
  }
  
  public final int getContentUpperLimit()
  {
    return this.contentUpperLimit;
  }
  
  @NotNull
  public final String getDefaultPublishText()
  {
    return this.defaultPublishText;
  }
  
  @NotNull
  public final ArrayList<EditObject> getEditObjectListByOriginText()
  {
    ArrayList localArrayList = new ArrayList();
    i = ((CharSequence)this.originText).length();
    int k = 1;
    int j = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return localArrayList;
    }
    try
    {
      localObject1 = new JSONObject(this.originText);
      localObject2 = ((JSONObject)localObject1).optString("text");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "pureContent");
      if (((CharSequence)localObject2).length() <= 0) {
        break label379;
      }
      i = k;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        continue;
        i = 0;
      }
    }
    if (i != 0) {
      localArrayList.add(new EditObject((String)localObject2, null, 2, null));
    }
    localObject1 = ((JSONObject)localObject1).optJSONArray("textLevelList");
    if (localObject1 == null) {
      localObject1 = new JSONArray();
    }
    k = ((JSONArray)localObject1).length();
    i = j;
    for (;;)
    {
      if (i >= k) {
        break label371;
      }
      localObject2 = ((JSONArray)localObject1).get(i);
      if (localObject2 == null) {
        break;
      }
      localObject2 = (JSONObject)localObject2;
      Object localObject3 = c(((JSONObject)localObject2).optInt("type"));
      String str = ((JSONObject)localObject2).optString("wording");
      Intrinsics.checkExpressionValueIsNotNull(str, "curTextInfo.optString(J_KEY_WORDING)");
      localObject3 = new EditObject(str, (EditObject.EditObjectType)localObject3);
      str = ((JSONObject)localObject2).optString("key");
      Intrinsics.checkExpressionValueIsNotNull(str, "curTextInfo.optString(J_KEY_KEY)");
      ((EditObject)localObject3).setKey(str);
      str = ((JSONObject)localObject2).optString("href");
      Intrinsics.checkExpressionValueIsNotNull(str, "curTextInfo.optString(J_KEY_HREF)");
      ((EditObject)localObject3).setHref(str);
      localArrayList.add(localObject3);
      localObject2 = ((JSONObject)localObject2).optString("text");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "curTextInfo.optString(J_KEY_TEXT)");
      localArrayList.add(new EditObject((String)localObject2, null, 2, null));
      i += 1;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("invalid original text info ");
    ((StringBuilder)localObject1).append(this.originText);
    TLog.d("GlobalPublisherConfig", ((StringBuilder)localObject1).toString());
    label371:
    return localArrayList;
  }
  
  public final boolean getEnableRestoreDraft()
  {
    return this.enableRestoreDraft;
  }
  
  public final boolean getEnableSaveDraft()
  {
    return this.enableSaveDraft;
  }
  
  @Nullable
  public final HashMap<?, ?> getEventInfo()
  {
    return this.eventInfo;
  }
  
  @NotNull
  public final InputPanelConfig getInputPanelConfig()
  {
    return this.inputPanelConfig;
  }
  
  public final int getMaxImageSize()
  {
    return this.maxImageSize;
  }
  
  public final int getMaxVideoLength()
  {
    return this.maxVideoLength;
  }
  
  public final int getMaxVideoSize()
  {
    return this.maxVideoSize;
  }
  
  public final int getMinVideoLength()
  {
    return this.minVideoLength;
  }
  
  @NotNull
  public final String getNavigationBarText()
  {
    return this.navigationBarText;
  }
  
  public final boolean getNeedTextTruncation()
  {
    return this.needTextTruncation;
  }
  
  @Nullable
  public final OriginContentInfo getOriginContentInfo()
  {
    return this.originContentInfo;
  }
  
  @NotNull
  public final String getOriginText()
  {
    return this.originText;
  }
  
  @Nullable
  public final VideoInfo getOriginVideoInfo()
  {
    return this.originVideoInfo;
  }
  
  @NotNull
  public final PermissionInfo getPermissionInfo()
  {
    return this.permissionInfo;
  }
  
  @NotNull
  public final String getPlaceHolder()
  {
    return this.placeHolder;
  }
  
  @NotNull
  public final PrivacySettingConfig getPrivacySettingConfig()
  {
    return this.privacySettingConfig;
  }
  
  @NotNull
  public final String getPublishScene()
  {
    return this.publishScene;
  }
  
  public final int getPublisherTheme()
  {
    return this.publisherTheme;
  }
  
  public final int getRecentTopicDismissTime()
  {
    return this.recentTopicDismissTime;
  }
  
  @Nullable
  public final HashMap<String, String> getReportInfo()
  {
    return this.reportInfo;
  }
  
  @NotNull
  public final ReprintAuthorityConfig getReprintAuthorityConfig()
  {
    return this.reprintAuthorityConfig;
  }
  
  @NotNull
  public final String getScene()
  {
    return this.scene;
  }
  
  public final boolean getShowAddLocation()
  {
    return this.showAddLocation;
  }
  
  public final boolean getShowAddToTopic()
  {
    return this.showAddToTopic;
  }
  
  public final boolean getShowBottomSelectorPanel()
  {
    return this.showBottomSelectorPanel;
  }
  
  public final boolean getShowCommentAfterPublish()
  {
    return this.showCommentAfterPublish;
  }
  
  public final boolean getShowCommunitySelector()
  {
    return this.showCommunitySelector;
  }
  
  public final boolean getShowDefaultColumn()
  {
    return this.showDefaultColumn;
  }
  
  public final boolean getShowDeliverType()
  {
    return this.showDeliverType;
  }
  
  public final boolean getShowExtraPropertyContainer()
  {
    return this.showExtraPropertyContainer;
  }
  
  public final boolean getShowOriginalTag()
  {
    return this.showOriginalTag;
  }
  
  public final boolean getShowPrivacySetting()
  {
    return this.showPrivacySetting;
  }
  
  public final boolean getShowPublishToast()
  {
    return this.showPublishToast;
  }
  
  public final boolean getShowRecentTopic()
  {
    return this.showRecentTopic;
  }
  
  public final boolean getShowSaveAlbums()
  {
    return this.showSaveAlbums;
  }
  
  public final boolean getShowTopicSelector()
  {
    return this.showTopicSelector;
  }
  
  @Nullable
  public final TopicInfo getTopicInfo()
  {
    return this.topicInfo;
  }
  
  public final int getTweetTopicChoiceType()
  {
    return this.tweetTopicChoiceType;
  }
  
  public final void setAddToTopicConfig(@NotNull AddToTopicConfig paramAddToTopicConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramAddToTopicConfig, "<set-?>");
    this.addToTopicConfig = paramAddToTopicConfig;
  }
  
  public final void setAllowCreateTweetTopic(boolean paramBoolean)
  {
    this.allowCreateTweetTopic = paramBoolean;
  }
  
  public final void setAllowDeleteTweetTopic(boolean paramBoolean)
  {
    this.allowDeleteTweetTopic = paramBoolean;
  }
  
  public final void setAllowEmoji(boolean paramBoolean)
  {
    this.allowEmoji = paramBoolean;
  }
  
  public final void setBusinessToastConfig(@NotNull BusinessToastConfig paramBusinessToastConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramBusinessToastConfig, "<set-?>");
    this.businessToastConfig = paramBusinessToastConfig;
  }
  
  public final void setCircleId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.circleId = paramString;
  }
  
  public final void setCommodityConfig(@NotNull CommodityConfig paramCommodityConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramCommodityConfig, "<set-?>");
    this.commodityConfig = paramCommodityConfig;
  }
  
  public final void setCommunityInfo(@Nullable CommunityInfo paramCommunityInfo)
  {
    this.communityInfo = paramCommunityInfo;
  }
  
  public final void setContentLowerLimit(int paramInt)
  {
    this.contentLowerLimit = paramInt;
  }
  
  public final void setContentUpperLimit(int paramInt)
  {
    this.contentUpperLimit = paramInt;
  }
  
  public final void setDefaultPublishText(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.defaultPublishText = paramString;
  }
  
  public final void setEnableRestoreDraft(boolean paramBoolean)
  {
    this.enableRestoreDraft = paramBoolean;
  }
  
  public final void setEnableSaveDraft(boolean paramBoolean)
  {
    this.enableSaveDraft = paramBoolean;
  }
  
  public final void setEventInfo(@Nullable HashMap<?, ?> paramHashMap)
  {
    this.eventInfo = paramHashMap;
  }
  
  public final void setInputPanelConfig(@NotNull InputPanelConfig paramInputPanelConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramInputPanelConfig, "<set-?>");
    this.inputPanelConfig = paramInputPanelConfig;
  }
  
  public final void setMaxImageSize(int paramInt)
  {
    this.maxImageSize = paramInt;
  }
  
  public final void setMaxVideoLength(int paramInt)
  {
    this.maxVideoLength = paramInt;
  }
  
  public final void setMaxVideoSize(int paramInt)
  {
    this.maxVideoSize = paramInt;
  }
  
  public final void setMinVideoLength(int paramInt)
  {
    this.minVideoLength = paramInt;
  }
  
  public final void setNavigationBarText(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.navigationBarText = paramString;
  }
  
  public final void setNeedTextTruncation(boolean paramBoolean)
  {
    this.needTextTruncation = paramBoolean;
  }
  
  public final void setOriginContentInfo(@Nullable OriginContentInfo paramOriginContentInfo)
  {
    this.originContentInfo = paramOriginContentInfo;
  }
  
  public final void setOriginText(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.originText = paramString;
  }
  
  public final void setOriginVideoInfo(@Nullable VideoInfo paramVideoInfo)
  {
    this.originVideoInfo = paramVideoInfo;
  }
  
  public final void setPermissionInfo(@NotNull PermissionInfo paramPermissionInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPermissionInfo, "<set-?>");
    this.permissionInfo = paramPermissionInfo;
  }
  
  public final void setPlaceHolder(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.placeHolder = paramString;
  }
  
  public final void setPrivacySettingConfig(@NotNull PrivacySettingConfig paramPrivacySettingConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramPrivacySettingConfig, "<set-?>");
    this.privacySettingConfig = paramPrivacySettingConfig;
  }
  
  public final void setPublishScene(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishScene = paramString;
  }
  
  public final void setPublisherTheme(int paramInt)
  {
    this.publisherTheme = paramInt;
  }
  
  public final void setRecentTopicDismissTime(int paramInt)
  {
    this.recentTopicDismissTime = paramInt;
  }
  
  public final void setReportInfo(@Nullable HashMap<String, String> paramHashMap)
  {
    this.reportInfo = paramHashMap;
  }
  
  public final void setReprintAuthorityConfig(@NotNull ReprintAuthorityConfig paramReprintAuthorityConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramReprintAuthorityConfig, "<set-?>");
    this.reprintAuthorityConfig = paramReprintAuthorityConfig;
  }
  
  public final void setScene(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.scene = paramString;
  }
  
  public final void setShowAddLocation(boolean paramBoolean)
  {
    this.showAddLocation = paramBoolean;
  }
  
  public final void setShowAddToTopic(boolean paramBoolean)
  {
    this.showAddToTopic = paramBoolean;
  }
  
  public final void setShowBottomSelectorPanel(boolean paramBoolean)
  {
    this.showBottomSelectorPanel = paramBoolean;
  }
  
  public final void setShowCommentAfterPublish(boolean paramBoolean)
  {
    this.showCommentAfterPublish = paramBoolean;
  }
  
  public final void setShowCommunitySelector(boolean paramBoolean)
  {
    this.showCommunitySelector = paramBoolean;
  }
  
  public final void setShowDefaultColumn(boolean paramBoolean)
  {
    this.showDefaultColumn = paramBoolean;
  }
  
  public final void setShowDeliverType(boolean paramBoolean)
  {
    this.showDeliverType = paramBoolean;
  }
  
  public final void setShowExtraPropertyContainer(boolean paramBoolean)
  {
    this.showExtraPropertyContainer = paramBoolean;
  }
  
  public final void setShowOriginalTag(boolean paramBoolean)
  {
    this.showOriginalTag = paramBoolean;
  }
  
  public final void setShowPrivacySetting(boolean paramBoolean)
  {
    this.showPrivacySetting = paramBoolean;
  }
  
  public final void setShowPublishToast(boolean paramBoolean)
  {
    this.showPublishToast = paramBoolean;
  }
  
  public final void setShowRecentTopic(boolean paramBoolean)
  {
    this.showRecentTopic = paramBoolean;
  }
  
  public final void setShowSaveAlbums(boolean paramBoolean)
  {
    this.showSaveAlbums = paramBoolean;
  }
  
  public final void setShowTopicSelector(boolean paramBoolean)
  {
    this.showTopicSelector = paramBoolean;
  }
  
  public final void setTopicInfo(@Nullable TopicInfo paramTopicInfo)
  {
    this.topicInfo = paramTopicInfo;
  }
  
  public final void setTweetTopicChoiceType(int paramInt)
  {
    this.tweetTopicChoiceType = paramInt;
  }
  
  public final void updateByRestrictInfo(@NotNull PublishRestrictInfo paramPublishRestrictInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishRestrictInfo, "info");
    int i;
    if (paramPublishRestrictInfo.h())
    {
      i = this.permissionInfo.getPermissionFlag();
      this.permissionInfo.setPermissionFlag(PermissionInfo.Companion.c(i));
    }
    Object localObject = paramPublishRestrictInfo.i();
    if ((localObject != null) && (localObject != null))
    {
      i = this.permissionInfo.getPermissionFlag();
      this.permissionInfo.setPermissionFlag(PermissionInfo.Companion.a(i));
      this.permissionInfo.setPermissionStyle(2);
      this.permissionInfo.setDialogInfo((DialogInfo)localObject);
    }
    this.showOriginalTag = paramPublishRestrictInfo.a();
    if (paramPublishRestrictInfo.b())
    {
      this.contentUpperLimit = paramPublishRestrictInfo.c();
      this.contentLowerLimit = paramPublishRestrictInfo.d();
    }
    localObject = this.inputPanelConfig;
    ((InputPanelConfig)localObject).setShowTopicPanel(paramPublishRestrictInfo.e());
    ((InputPanelConfig)localObject).setShowInvitedManuscript(paramPublishRestrictInfo.f());
    this.allowEmoji = paramPublishRestrictInfo.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig
 * JD-Core Version:    0.7.0.1
 */