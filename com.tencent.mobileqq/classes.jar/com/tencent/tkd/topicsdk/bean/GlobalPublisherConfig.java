package com.tencent.tkd.topicsdk.bean;

import com.tencent.tkd.topicsdk.debug.DebugHelper;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "Ljava/io/Serializable;", "()V", "addToTopicConfig", "Lcom/tencent/tkd/topicsdk/bean/AddToTopicConfig;", "getAddToTopicConfig", "()Lcom/tencent/tkd/topicsdk/bean/AddToTopicConfig;", "setAddToTopicConfig", "(Lcom/tencent/tkd/topicsdk/bean/AddToTopicConfig;)V", "allowDeleteTweetTopic", "", "getAllowDeleteTweetTopic", "()Z", "setAllowDeleteTweetTopic", "(Z)V", "businessToastConfig", "Lcom/tencent/tkd/topicsdk/bean/BusinessToastConfig;", "getBusinessToastConfig", "()Lcom/tencent/tkd/topicsdk/bean/BusinessToastConfig;", "setBusinessToastConfig", "(Lcom/tencent/tkd/topicsdk/bean/BusinessToastConfig;)V", "circleId", "", "getCircleId", "()Ljava/lang/String;", "setCircleId", "(Ljava/lang/String;)V", "commodityConfig", "Lcom/tencent/tkd/topicsdk/bean/CommodityConfig;", "getCommodityConfig", "()Lcom/tencent/tkd/topicsdk/bean/CommodityConfig;", "setCommodityConfig", "(Lcom/tencent/tkd/topicsdk/bean/CommodityConfig;)V", "communityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "getCommunityInfo", "()Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "setCommunityInfo", "(Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;)V", "countLimit", "", "getCountLimit", "()I", "setCountLimit", "(I)V", "defaultPublishText", "getDefaultPublishText", "setDefaultPublishText", "enableRestoreDraft", "getEnableRestoreDraft", "setEnableRestoreDraft", "enableSaveDraft", "getEnableSaveDraft", "setEnableSaveDraft", "eventInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventInfo", "()Ljava/util/HashMap;", "setEventInfo", "(Ljava/util/HashMap;)V", "forbidHighLightText", "getForbidHighLightText", "setForbidHighLightText", "forbidJumpUrl", "getForbidJumpUrl", "setForbidJumpUrl", "forbidToastText", "getForbidToastText", "setForbidToastText", "inputPanelConfig", "Lcom/tencent/tkd/topicsdk/bean/InputPanelConfig;", "getInputPanelConfig", "()Lcom/tencent/tkd/topicsdk/bean/InputPanelConfig;", "setInputPanelConfig", "(Lcom/tencent/tkd/topicsdk/bean/InputPanelConfig;)V", "maxImageSize", "getMaxImageSize", "setMaxImageSize", "maxVideoLength", "getMaxVideoLength", "setMaxVideoLength", "minVideoLength", "getMinVideoLength", "setMinVideoLength", "navigationBarText", "getNavigationBarText", "setNavigationBarText", "needTextTruncation", "getNeedTextTruncation", "setNeedTextTruncation", "originContentInfo", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "getOriginContentInfo", "()Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "setOriginContentInfo", "(Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;)V", "originText", "getOriginText", "setOriginText", "originVideoInfo", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "getOriginVideoInfo", "()Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "setOriginVideoInfo", "(Lcom/tencent/tkd/topicsdk/bean/VideoInfo;)V", "permissionFlag", "getPermissionFlag", "setPermissionFlag", "placeHolder", "getPlaceHolder", "setPlaceHolder", "privacySettingConfig", "Lcom/tencent/tkd/topicsdk/bean/PrivacySettingConfig;", "getPrivacySettingConfig", "()Lcom/tencent/tkd/topicsdk/bean/PrivacySettingConfig;", "setPrivacySettingConfig", "(Lcom/tencent/tkd/topicsdk/bean/PrivacySettingConfig;)V", "publishScene", "getPublishScene", "setPublishScene", "publisherTheme", "getPublisherTheme", "setPublisherTheme", "recentTopicDismissTime", "getRecentTopicDismissTime", "setRecentTopicDismissTime", "reportInfo", "getReportInfo", "setReportInfo", "reprintAuthorityConfig", "Lcom/tencent/tkd/topicsdk/bean/ReprintAuthorityConfig;", "getReprintAuthorityConfig", "()Lcom/tencent/tkd/topicsdk/bean/ReprintAuthorityConfig;", "setReprintAuthorityConfig", "(Lcom/tencent/tkd/topicsdk/bean/ReprintAuthorityConfig;)V", "scene", "getScene", "setScene", "showAddLocation", "getShowAddLocation", "setShowAddLocation", "showAddToTopic", "getShowAddToTopic", "setShowAddToTopic", "showBottomSelectorPanel", "getShowBottomSelectorPanel", "setShowBottomSelectorPanel", "showCommentAfterPublish", "getShowCommentAfterPublish", "setShowCommentAfterPublish", "showCommunitySelector", "getShowCommunitySelector", "setShowCommunitySelector", "showDefaultColumn", "getShowDefaultColumn", "setShowDefaultColumn", "showExtraPropertyContainer", "getShowExtraPropertyContainer", "setShowExtraPropertyContainer", "showPrivacySetting", "getShowPrivacySetting", "setShowPrivacySetting", "showRecentTopic", "getShowRecentTopic", "setShowRecentTopic", "showReprintAuthority", "getShowReprintAuthority", "setShowReprintAuthority", "showSaveAlbums", "getShowSaveAlbums", "setShowSaveAlbums", "showTopicSelector", "getShowTopicSelector", "setShowTopicSelector", "topicConfig", "Lcom/tencent/tkd/topicsdk/bean/ManageTopicConfig;", "getTopicConfig", "()Lcom/tencent/tkd/topicsdk/bean/ManageTopicConfig;", "setTopicConfig", "(Lcom/tencent/tkd/topicsdk/bean/ManageTopicConfig;)V", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "getTopicInfo", "()Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "setTopicInfo", "(Lcom/tencent/tkd/topicsdk/bean/TopicInfo;)V", "tweetTopicChoiceType", "getTweetTopicChoiceType", "setTweetTopicChoiceType", "applyValidProtect", "", "getEditObjectListByOriginText", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "getEditObjectTypeByValue", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "type", "needShowSelectCommunityView", "ownerType", "needShowSelectTopicView", "putBottomPanelConfig", "eventInfoJson", "Lorg/json/JSONObject;", "putBusinessToastConfig", "putCircleID", "putColumnConfig", "putCommodityConfig", "putInputPanelConfig", "putOriginVideoInfo", "putPermissionInfo", "putPrivacyConfig", "putPublishOwner", "putPublishScene", "putRecentTopicConfig", "putReportInfo", "putReprintAuthorityConfig", "updatePanelConfig", "updateSelectorConfig", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GlobalPublisherConfig
  implements Serializable
{
  public static final GlobalPublisherConfig.Companion Companion = new GlobalPublisherConfig.Companion(null);
  @NotNull
  public static final String TAG = "GlobalPublisherConfig";
  public static final int THEME_DEFAULT = 0;
  public static final int THEME_FIREWORKS = 1;
  @NotNull
  private AddToTopicConfig addToTopicConfig = new AddToTopicConfig();
  private boolean allowDeleteTweetTopic = true;
  @NotNull
  private BusinessToastConfig businessToastConfig = new BusinessToastConfig();
  @NotNull
  private String circleId = "";
  @NotNull
  private CommodityConfig commodityConfig = new CommodityConfig();
  @Nullable
  private CommunityInfo communityInfo;
  private int countLimit;
  @NotNull
  private String defaultPublishText = "";
  private boolean enableRestoreDraft = true;
  private boolean enableSaveDraft;
  @Nullable
  private HashMap<?, ?> eventInfo;
  @NotNull
  private String forbidHighLightText = "";
  @NotNull
  private String forbidJumpUrl = "";
  @NotNull
  private String forbidToastText = "";
  @NotNull
  private InputPanelConfig inputPanelConfig = new InputPanelConfig(false, false, false, false, false, false, 63, null);
  private int maxImageSize = 15360;
  private int maxVideoLength = 60000;
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
  private int permissionFlag = 1;
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
  private boolean showExtraPropertyContainer = true;
  private boolean showPrivacySetting;
  private boolean showRecentTopic;
  private boolean showReprintAuthority;
  private boolean showSaveAlbums = true;
  private boolean showTopicSelector;
  @NotNull
  private ManageTopicConfig topicConfig = new ManageTopicConfig();
  @Nullable
  private TopicInfo topicInfo;
  private int tweetTopicChoiceType;
  
  private final EditObject.EditObjectType a(int paramInt)
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
  
  private final void a()
  {
    if (this.communityInfo != null)
    {
      this.showTopicSelector = false;
      this.showCommunitySelector = true;
    }
    while (this.topicInfo != null)
    {
      this.showCommunitySelector = false;
      this.showTopicSelector = true;
      return;
    }
  }
  
  private final void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    Object localObject = paramJSONObject.optJSONObject("commodityConfig");
    if (localObject != null)
    {
      paramJSONObject = new CommodityConfig();
      if (((JSONObject)localObject).optInt("showUserHint") != 1) {
        break label87;
      }
    }
    for (;;)
    {
      paramJSONObject.setShowUserHint(bool);
      String str = ((JSONObject)localObject).optString("userHint");
      Intrinsics.checkExpressionValueIsNotNull(str, "info.optString(J_KEY_USER_HINT)");
      paramJSONObject.setUserHint(str);
      localObject = ((JSONObject)localObject).optString("userHintUrl");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "info.optString(J_KEY_USER_HINT_URL)");
      paramJSONObject.setUserHintUrl((String)localObject);
      this.commodityConfig = paramJSONObject;
      return;
      label87:
      bool = false;
    }
  }
  
  private final boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 4);
  }
  
  private final void b()
  {
    boolean bool2 = false;
    label39:
    int j;
    label55:
    label72:
    int k;
    label88:
    InputPanelConfig localInputPanelConfig;
    boolean bool1;
    if (!Intrinsics.areEqual(this.publishScene, "KOL"))
    {
      if (((CharSequence)this.publishScene).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label182;
        }
      }
    }
    else
    {
      i = 1;
      if ((!this.showTopicSelector) || (this.showCommunitySelector)) {
        break label187;
      }
      j = 1;
      if ((j != 0) || (this.topicInfo != null) || (i == 0)) {
        break label192;
      }
      j = 1;
      if ((!this.inputPanelConfig.getShowPicPanel()) || (i != 0)) {
        break label197;
      }
      k = 1;
      localInputPanelConfig = this.inputPanelConfig;
      if ((j == 0) && (k == 0)) {
        break label202;
      }
      bool1 = true;
      label105:
      localInputPanelConfig.setShowPicPanel(bool1);
      if (((!this.showTopicSelector) && (!this.showCommunitySelector)) || (i == 0)) {
        break label208;
      }
      j = 1;
      label132:
      if ((!this.inputPanelConfig.getShowVideoPanel()) || (i != 0)) {
        break label213;
      }
    }
    label182:
    label187:
    label192:
    label197:
    label202:
    label208:
    label213:
    for (int i = 1;; i = 0)
    {
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
      return;
      i = 0;
      break;
      i = 0;
      break label39;
      j = 0;
      break label55;
      j = 0;
      break label72;
      k = 0;
      break label88;
      bool1 = false;
      break label105;
      j = 0;
      break label132;
    }
  }
  
  private final void b(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("businessToastConfig");
    if (localObject != null)
    {
      paramJSONObject = new BusinessToastConfig();
      localObject = ((JSONObject)localObject).optString("publishSuccessToast");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "info.optString(J_KEY_PUBLISH_SUCCESS_TOAST)");
      paramJSONObject.setPublishSuccessToast((String)localObject);
      this.businessToastConfig = paramJSONObject;
    }
  }
  
  private final boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 5);
  }
  
  private final void c(JSONObject paramJSONObject)
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
  
  private final void d(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("permissionInfo");
    if (paramJSONObject != null)
    {
      this.permissionFlag = paramJSONObject.optInt("hasPermission", 1);
      String str = paramJSONObject.optString("text");
      Intrinsics.checkExpressionValueIsNotNull(str, "optString(J_KEY_TEXT)");
      this.forbidToastText = str;
      str = paramJSONObject.optString("highLightText");
      Intrinsics.checkExpressionValueIsNotNull(str, "optString(J_KEY_HIGH_LIGHT_TEXT)");
      this.forbidHighLightText = str;
      paramJSONObject = paramJSONObject.optString("jumpUrl");
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "optString(J_KEY_JUMP_URL)");
      this.forbidJumpUrl = paramJSONObject;
    }
  }
  
  private final void e(JSONObject paramJSONObject)
  {
    int i = 0;
    if ((paramJSONObject.optInt("allowKOL") == 1) || (StorageManager.a(StorageManager.a, "kolPermissionView", false, 2, null)) || (Intrinsics.areEqual(this.publishScene, "KOL"))) {
      i = 1;
    }
    if (i != 0) {
      this.publishScene = "KOL";
    }
    paramJSONObject = paramJSONObject.optString("publishScene");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "eventInfoJson.optString(J_KEY_PUBLISH_SCENE)");
    this.publishScene = paramJSONObject;
  }
  
  private final void f(JSONObject paramJSONObject)
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
    if (i == 4)
    {
      localObject = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
      Intrinsics.checkExpressionValueIsNotNull(str, "ownerID");
      ((TopicInfo)localObject).setTopicId(Long.parseLong(str));
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "ownerName");
      ((TopicInfo)localObject).setTitle(paramJSONObject);
      this.topicInfo = ((TopicInfo)localObject);
    }
    while (i != 5) {
      return;
    }
    Object localObject = new CommunityInfo(null, null, null, null, null, 31, null);
    Intrinsics.checkExpressionValueIsNotNull(str, "ownerID");
    ((CommunityInfo)localObject).setCommunityId(str);
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "ownerName");
    ((CommunityInfo)localObject).setTitle(paramJSONObject);
    this.communityInfo = ((CommunityInfo)localObject);
  }
  
  private final void g(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("circleID");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "circleId");
    if (((CharSequence)paramJSONObject).length() == 0)
    {
      i = 1;
      if ((i == 0) || (!DebugHelper.a.a()) || (!StorageManager.a(StorageManager.a, "useDebugCircleIdView", false, 2, null))) {
        break label78;
      }
    }
    label78:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramJSONObject = "q_1345078251_1508915917578995";
      }
      this.circleId = paramJSONObject;
      return;
      i = 0;
      break;
    }
  }
  
  private final void h(JSONObject paramJSONObject)
  {
    boolean bool6 = true;
    int i = paramJSONObject.optInt("inputPanelConfig");
    boolean bool1;
    boolean bool2;
    label28:
    boolean bool3;
    label37:
    boolean bool4;
    label47:
    boolean bool5;
    if ((i & 0x1) != 0)
    {
      bool1 = true;
      if ((i & 0x2) == 0) {
        break label92;
      }
      bool2 = true;
      if ((i & 0x4) == 0) {
        break label98;
      }
      bool3 = true;
      if ((i & 0x8) == 0) {
        break label104;
      }
      bool4 = true;
      if ((i & 0x10) == 0) {
        break label110;
      }
      bool5 = true;
      label57:
      if ((i & 0x20) == 0) {
        break label116;
      }
    }
    for (;;)
    {
      this.inputPanelConfig = new InputPanelConfig(bool1, bool2, bool3, bool4, bool5, bool6);
      return;
      bool1 = false;
      break;
      label92:
      bool2 = false;
      break label28;
      label98:
      bool3 = false;
      break label37;
      label104:
      bool4 = false;
      break label47;
      label110:
      bool5 = false;
      break label57;
      label116:
      bool6 = false;
    }
  }
  
  private final void i(JSONObject paramJSONObject)
  {
    boolean bool = true;
    paramJSONObject = paramJSONObject.optJSONObject("recentTopicConfig");
    if (paramJSONObject != null) {
      if (paramJSONObject.optInt("showRecentTopic") != 1) {
        break label43;
      }
    }
    for (;;)
    {
      this.showRecentTopic = bool;
      this.recentTopicDismissTime = paramJSONObject.optInt("dismissTime", 5);
      return;
      label43:
      bool = false;
    }
  }
  
  private final void j(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("bottomPanelConfig");
    if (paramJSONObject != null)
    {
      this.minVideoLength = (paramJSONObject.optInt("minVideoLength", 5) * 1000);
      this.maxVideoLength = (paramJSONObject.optInt("maxVideoLength", 60) * 1000);
    }
  }
  
  private final void k(JSONObject paramJSONObject)
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
  
  private final void l(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("authorityConfig");
    if (paramJSONObject != null)
    {
      ReprintAuthorityConfig localReprintAuthorityConfig = new ReprintAuthorityConfig();
      this.showReprintAuthority = paramJSONObject.optBoolean("showAuthority");
      localReprintAuthorityConfig.setAllowReprint(paramJSONObject.optBoolean("allowReprint"));
      this.reprintAuthorityConfig = localReprintAuthorityConfig;
    }
  }
  
  private final void m(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    paramJSONObject = paramJSONObject.optJSONObject("addToTopicConfig");
    label45:
    AddToTopicConfig localAddToTopicConfig;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optInt("showAddToTopic") != 1) {
        break label121;
      }
      bool1 = true;
      this.showAddToTopic = bool1;
      if (paramJSONObject.optInt("default_column") != 1) {
        break label126;
      }
      bool1 = true;
      this.showDefaultColumn = bool1;
      localAddToTopicConfig = new AddToTopicConfig();
      localAddToTopicConfig.setSelectedTopicId(paramJSONObject.optLong("selectedTopicID"));
      String str = paramJSONObject.optString("selectedTopicName");
      Intrinsics.checkExpressionValueIsNotNull(str, "columnJson.optString(J_KEY_SELECTED_TOPIC_NAME)");
      localAddToTopicConfig.setSelectedTopicName(str);
      if (paramJSONObject.optInt("disableSelectTopic") != 1) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAddToTopicConfig.setDisableSelectTopic(bool1);
      this.addToTopicConfig = localAddToTopicConfig;
      return;
      label121:
      bool1 = false;
      break;
      label126:
      bool1 = false;
      break label45;
    }
  }
  
  private final void n(JSONObject paramJSONObject)
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
    int i = 1;
    boolean bool;
    if ((this.inputPanelConfig.getShowEmotionLPanel()) || (this.inputPanelConfig.getShowVideoPanel()) || (this.inputPanelConfig.getShowAtPanel()) || (this.inputPanelConfig.getShowPicPanel()) || (this.inputPanelConfig.getShowTopicPanel()))
    {
      bool = true;
      this.showBottomSelectorPanel = bool;
      if ((!this.showTopicSelector) && (!this.showCommunitySelector) && (!this.showRecentTopic)) {
        break label153;
      }
      bool = true;
      label82:
      this.showExtraPropertyContainer = bool;
      if (this.countLimit == 0) {
        this.countLimit = 500;
      }
      if (((CharSequence)this.placeHolder).length() != 0) {
        break label158;
      }
    }
    for (;;)
    {
      if (i != 0) {
        this.placeHolder = "写点什么吧，万一火了呢";
      }
      a();
      b();
      if (this.originContentInfo == null) {
        this.showCommentAfterPublish = false;
      }
      return;
      bool = false;
      break;
      label153:
      bool = false;
      break label82;
      label158:
      i = 0;
    }
  }
  
  @NotNull
  public final AddToTopicConfig getAddToTopicConfig()
  {
    return this.addToTopicConfig;
  }
  
  public final boolean getAllowDeleteTweetTopic()
  {
    return this.allowDeleteTweetTopic;
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
  
  public final int getCountLimit()
  {
    return this.countLimit;
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
    if (((CharSequence)this.originText).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(this.originText);
        localObject2 = ((JSONObject)localObject1).optString("text");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "pureContent");
        if (((CharSequence)localObject2).length() <= 0) {
          break label183;
        }
        i = 1;
        if (i != 0) {
          localArrayList.add(new EditObject((String)localObject2, null, 2, null));
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("textLevelList");
        if (localObject1 == null) {
          break label188;
        }
        int j = ((JSONArray)localObject1).length();
        i = 0;
        if (i < j)
        {
          localObject2 = ((JSONArray)localObject1).get(i);
          if (localObject2 != null) {
            break label199;
          }
          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
      }
      catch (JSONException localJSONException)
      {
        TLog.d("GlobalPublisherConfig", "invalid original text info " + this.originText);
      }
      return localArrayList;
      label183:
      i = 0;
      continue;
      label188:
      JSONArray localJSONArray = new JSONArray();
      continue;
      label199:
      Object localObject2 = (JSONObject)localObject2;
      Object localObject3 = a(((JSONObject)localObject2).optInt("type"));
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
  public final String getForbidHighLightText()
  {
    return this.forbidHighLightText;
  }
  
  @NotNull
  public final String getForbidJumpUrl()
  {
    return this.forbidJumpUrl;
  }
  
  @NotNull
  public final String getForbidToastText()
  {
    return this.forbidToastText;
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
  
  public final int getPermissionFlag()
  {
    return this.permissionFlag;
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
  
  public final boolean getShowExtraPropertyContainer()
  {
    return this.showExtraPropertyContainer;
  }
  
  public final boolean getShowPrivacySetting()
  {
    return this.showPrivacySetting;
  }
  
  public final boolean getShowRecentTopic()
  {
    return this.showRecentTopic;
  }
  
  public final boolean getShowReprintAuthority()
  {
    return this.showReprintAuthority;
  }
  
  public final boolean getShowSaveAlbums()
  {
    return this.showSaveAlbums;
  }
  
  public final boolean getShowTopicSelector()
  {
    return this.showTopicSelector;
  }
  
  @NotNull
  public final ManageTopicConfig getTopicConfig()
  {
    return this.topicConfig;
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
  
  public final void setAllowDeleteTweetTopic(boolean paramBoolean)
  {
    this.allowDeleteTweetTopic = paramBoolean;
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
  
  public final void setCountLimit(int paramInt)
  {
    this.countLimit = paramInt;
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
  
  public final void setForbidHighLightText(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidHighLightText = paramString;
  }
  
  public final void setForbidJumpUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidJumpUrl = paramString;
  }
  
  public final void setForbidToastText(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidToastText = paramString;
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
  
  public final void setPermissionFlag(int paramInt)
  {
    this.permissionFlag = paramInt;
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
  
  public final void setShowExtraPropertyContainer(boolean paramBoolean)
  {
    this.showExtraPropertyContainer = paramBoolean;
  }
  
  public final void setShowPrivacySetting(boolean paramBoolean)
  {
    this.showPrivacySetting = paramBoolean;
  }
  
  public final void setShowRecentTopic(boolean paramBoolean)
  {
    this.showRecentTopic = paramBoolean;
  }
  
  public final void setShowReprintAuthority(boolean paramBoolean)
  {
    this.showReprintAuthority = paramBoolean;
  }
  
  public final void setShowSaveAlbums(boolean paramBoolean)
  {
    this.showSaveAlbums = paramBoolean;
  }
  
  public final void setShowTopicSelector(boolean paramBoolean)
  {
    this.showTopicSelector = paramBoolean;
  }
  
  public final void setTopicConfig(@NotNull ManageTopicConfig paramManageTopicConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramManageTopicConfig, "<set-?>");
    this.topicConfig = paramManageTopicConfig;
  }
  
  public final void setTopicInfo(@Nullable TopicInfo paramTopicInfo)
  {
    this.topicInfo = paramTopicInfo;
  }
  
  public final void setTweetTopicChoiceType(int paramInt)
  {
    this.tweetTopicChoiceType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig
 * JD-Core Version:    0.7.0.1
 */