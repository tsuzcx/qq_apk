package com.tencent.tkd.topicsdk.publisharticle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.AddToTopicConfig;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.DraftArticleInfo;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.InputPanelConfig;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.bean.OriginContentInfo;
import com.tencent.tkd.topicsdk.bean.PrivacySettingConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.ReprintAuthorityConfig;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import com.tencent.tkd.topicsdk.common.NetworkUtils;
import com.tencent.tkd.topicsdk.common.StringKt;
import com.tencent.tkd.topicsdk.common.ViewKt;
import com.tencent.tkd.topicsdk.common.report.ReportKeys;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectData;
import com.tencent.tkd.topicsdk.framework.BaseSDKPage;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter.ACTION;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.topicsdk.mediaselector.PanelType;
import com.tencent.tkd.topicsdk.mvp.ListContract.IListModel;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager.Companion;
import com.tencent.tkd.topicsdk.selecttopic.SelectCommunityModel;
import com.tencent.tkd.topicsdk.selecttopic.SelectCommunityView;
import com.tencent.tkd.topicsdk.selecttopic.SelectTopicModel;
import com.tencent.tkd.topicsdk.selecttopic.SelectTopicView;
import com.tencent.tkd.topicsdk.uiImpl.UIDataTransferImpl;
import com.tencent.tkd.topicsdk.uiImpl.UIEmoJiBridgeImpl;
import com.tencent.tkd.topicsdk.uiImpl.UIImageLoaderImpl;
import com.tencent.tkd.topicsdk.uiImpl.UILoggerImpl;
import com.tencent.tkd.topicsdk.widget.AddLocationView;
import com.tencent.tkd.topicsdk.widget.AddToTopicLayout;
import com.tencent.tkd.topicsdk.widget.AssociateModuleLayout;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import com.tencent.tkd.topicsdk.widget.CustomScrollView;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.MediaDisplayGridAdapter;
import com.tencent.tkd.topicsdk.widget.OriginContentLayout;
import com.tencent.tkd.topicsdk.widget.SlidingUpDialog;
import com.tencent.tkd.weibo.UiComponentSdk;
import com.tencent.tkd.weibo.UiComponentSdk.Companion;
import com.tencent.tkd.weibo.UiComponentSdkConfig;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.data.IDataTransfer;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import com.tencent.tkd.weibo.framework.IImageLoader;
import com.tencent.tkd.weibo.framework.ILogger;
import com.tencent.tkd.weibo.richEditText.EditObjectListener;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import com.tencent.tkd.weibo.tweetTopic.recentTopic.RecentTopicLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticlePage;", "Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleContract$IPublishArticleView;", "()V", "addEditObjectListener", "com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$addEditObjectListener$1", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$addEditObjectListener$1;", "addLocationView", "Lcom/tencent/tkd/topicsdk/widget/AddLocationView;", "addToTopicLayout", "Lcom/tencent/tkd/topicsdk/widget/AddToTopicLayout;", "addToTopicLinear", "Landroid/widget/LinearLayout;", "associateLayout", "Lcom/tencent/tkd/topicsdk/widget/AssociateModuleLayout;", "bindAccountDialog", "Landroid/app/Dialog;", "bindAccountInfo", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "bottomSelectorLayout", "Lcom/tencent/tkd/topicsdk/mediaselector/BottomSelectorLayout;", "canReprintLayout", "canReprintTextView", "Landroid/widget/TextView;", "commentCheckBox", "Landroid/widget/CheckBox;", "contentScrollView", "Lcom/tencent/tkd/topicsdk/widget/CustomScrollView;", "currentDraftKey", "", "deferRestoreDraft", "", "enterTime", "", "extraPropertyContainer", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "hasMediaLoaded", "hasShowBindAccountDialog", "isFromDraft", "isFromRealNameConfirmPage", "isInRealNameConfirmPage", "isModified", "()Z", "location", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "mediaDisplayLayout", "Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout;", "mergeVideoMap", "", "navigationBarView", "needRealNameConfirm", "needShowBindAccountDialog", "onPosPermissionCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "originContentLayout", "Lcom/tencent/tkd/topicsdk/widget/OriginContentLayout;", "presenter", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticlePresenter;", "privacyLayout", "privacySettingDialog", "Lcom/tencent/tkd/topicsdk/publisharticle/PrivacySettingDialog;", "privacyTextView", "publishButton", "realNameConfirmUrl", "recentTopicLayout", "Lcom/tencent/tkd/weibo/tweetTopic/recentTopic/RecentTopicLayout;", "reprintActionDialog", "Lcom/tencent/tkd/topicsdk/publisharticle/ReprintActionDialog;", "restoredDraftArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "getRestoredDraftArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "restoredDraftArticleInfo$delegate", "Lkotlin/Lazy;", "richEditText", "Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "rootView", "Landroid/view/ViewGroup;", "shouldSaveDraft", "getShouldSaveDraft", "titleBar", "Landroid/widget/RelativeLayout;", "updateRichEditTextMaxHeightRunnable", "Ljava/lang/Runnable;", "addAtButtonInSelectorLayout", "addEmotionPanelInSelectorLayout", "addTopicButtonInSelectorLayout", "buildDraftArticleInfo", "buildPublishArticleInfo", "callback", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "changeBottomLayoutEnabled", "enablePic", "enableVideo", "getCurrentSelectedTopicId", "getDraftKeyByCurrentContent", "getPanelHeight", "", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "handleCoverSelectResult", "data", "Landroid/content/Intent;", "coverSelectData", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "handleInteraction", "handlePublishErrCode", "errCode", "handleVideoCropResult", "resultCode", "initAssociateModuleLayout", "view", "Landroid/view/View;", "initBaseConfigInEditText", "initBottomSelectorLayout", "frameLayout", "initBottomSelectorLayoutWithData", "initCommentAfterPublishCheckBox", "initContainerView", "initData", "initEditVideoSettingsLayout", "initExtraPropertyLayout", "initMediaDisplayLayout", "initOriginContentLayout", "initOriginTextInEditText", "initRecentTopicLayout", "initRecentTopicWithData", "initRichEditText", "initRichEditTextWithData", "initScrollView", "initTitleBar", "initUiSDK", "jumpRealNameConfirmPage", "loadDefaultColumn", "needJumpRealNameConfirmPage", "onActivityResult", "requestCode", "onBackEvent", "onBindAccount", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "onGetBindAccountInfo", "onGetRealNameStatus", "onPause", "onPreExit", "onResume", "openSelectCommunityView", "selectCommunityCallback", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "communityInfo", "openSelectTopicView", "selectedTopicId", "selectTopicCallback", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "topicInfo", "publishArticle", "publishArticleInfo", "reportEnterPublishPage", "reportPublishUserAction", "eventId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "elementId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "reportUseTime", "setInfoIntoAssociateLayout", "showAtContactListView", "hasInputAtInEditText", "showBindAccountDialog", "showExitDialog", "showLocationListView", "originLocationInfo", "showPublishErrorToast", "activity", "Landroid/app/Activity;", "showSaveDraftDialog", "showTopicListView", "showUserProtocol", "url", "tryRestoreDraft", "updateAndShowRecentTopic", "topicList", "", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "updateCommentCheckBox", "updateCommunityInfo", "updateDisplayItemInfo", "item", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "updateMapAndDeleteFileForDeletedItem", "newMedias", "Lcom/tencent/tkd/topicsdk/bean/Media;", "updateMediaDisplayLayout", "updateOriginContentLayout", "info", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "updatePrivacyTextView", "privacy", "updateReprintTextView", "allowReprint", "updateRichEditTextMaxHeight", "updateSelectedMediaLayout", "displayItems", "updateTopicInfo", "updateVideoSetting", "toPanelType", "Lcom/tencent/tkd/topicsdk/bean/MediaType;", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage
  extends BaseSDKPage
  implements PublishArticleContract.IPublishArticleView
{
  public static final PublishArticlePage.Companion a;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GlobalPublisherConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  private LocationInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo = new LocationInfo();
  private BottomSelectorLayout jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
  private BindAccountInfo jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleBindAccountInfo;
  private PrivacySettingDialog jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePrivacySettingDialog;
  private final PublishArticlePage.addEditObjectListener.1 jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage$addEditObjectListener$1 = new PublishArticlePage.addEditObjectListener.1(this);
  private final PublishArticlePresenter jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePresenter = new PublishArticlePresenter((PublishArticleContract.IPublishArticleModel)new PublishArticleModel());
  private ReprintActionDialog jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleReprintActionDialog;
  private AddLocationView jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
  private AddToTopicLayout jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
  private AssociateModuleLayout jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
  private CustomScrollView jdField_a_of_type_ComTencentTkdTopicsdkWidgetCustomScrollView;
  private MediaDisplayLayout jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
  private OriginContentLayout jdField_a_of_type_ComTencentTkdTopicsdkWidgetOriginContentLayout;
  private RichEditText jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
  private RecentTopicLayout jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout;
  private final Runnable jdField_a_of_type_JavaLangRunnable = (Runnable)new PublishArticlePage.updateRichEditTextMaxHeightRunnable.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  private Map<String, String> jdField_a_of_type_JavaUtilMap = (Map)new HashMap();
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new PublishArticlePage.restoredDraftArticleInfo.2(this));
  private Function1<? super Boolean, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = (Function1)new PublishArticlePage.onPosPermissionCallback.1(this);
  private boolean jdField_a_of_type_Boolean;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = DraftManager.a.a().a(null);
  private boolean jdField_b_of_type_Boolean;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage$Companion = new PublishArticlePage.Companion(null);
  }
  
  private final void A()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    String str = ReportKeys.a.a();
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localMap.put(str, localGlobalPublisherConfig.getScene());
    TopicSDKHelperKt.a(IDataReporter.ACTION.ACTION_ENTER_PUBLISH, (Map)localHashMap, null, 4, null);
  }
  
  private final int a(PanelType paramPanelType)
  {
    switch (PublishArticlePage.WhenMappings.b[paramPanelType.ordinal()])
    {
    default: 
      return 0;
    case 1: 
      paramPanelType = DisplayUtils.a;
      Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      localObject = ((ViewGroup)localObject).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "rootView.context");
      return paramPanelType.a((Context)localObject, 186.0F);
    }
    paramPanelType = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramPanelType == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    return ViewKt.c((View)paramPanelType);
  }
  
  private final long a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
    }
    long l2 = ((AssociateModuleLayout)localObject).a();
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    localObject = ((AddToTopicLayout)localObject).a();
    if (localObject != null) {}
    for (long l1 = ((TopicInfo)localObject).getTopicId(); l2 != 0L; l1 = 0L) {
      return l2;
    }
    return l1;
  }
  
  private final DraftArticleInfo a()
  {
    return (DraftArticleInfo)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final PanelType a(@NotNull MediaType paramMediaType)
  {
    switch (PublishArticlePage.WhenMappings.c[paramMediaType.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 1: 
      return PanelType.PHOTO;
    }
    return PanelType.VIDEO;
  }
  
  private final String a()
  {
    DraftManager localDraftManager = DraftManager.a.a();
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    return localDraftManager.a(localGlobalPublisherConfig);
  }
  
  private final void a(long paramLong, Function1<? super TopicInfo, Unit> paramFunction1)
  {
    Object localObject = a();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      SelectTopicView localSelectTopicView = new SelectTopicView((Activity)localObject, paramLong, new ListPresenter((ListContract.IListModel)new SelectTopicModel()));
      localObject = new SlidingUpDialog((Context)localObject, (View)localSelectTopicView, new RelativeLayout.LayoutParams(-1, -2));
      localSelectTopicView.setOnSelectCallback((Function1)new PublishArticlePage.openSelectTopicView..inlined.let.lambda.1((SlidingUpDialog)localObject, paramLong, paramFunction1));
      ((SlidingUpDialog)localObject).show();
    }
  }
  
  private final void a(Activity paramActivity, int paramInt)
  {
    paramActivity = paramActivity.getResources();
    if (paramActivity != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return;
      paramActivity = paramActivity.getString(R.string.N);
      Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.net_failed)");
      TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
      continue;
      paramActivity = paramActivity.getString(R.string.P);
      Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.over_content_tips)");
      TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
      continue;
      GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localGlobalPublisherConfig == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      if ((Intrinsics.areEqual(localGlobalPublisherConfig.getPublishScene(), "rijugc") ^ true))
      {
        paramActivity = paramActivity.getString(R.string.B);
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.empty_content_publish_tips)");
        TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
      }
      else
      {
        paramActivity = paramActivity.getString(R.string.ao);
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.title_has_none_text)");
        TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
        continue;
        paramActivity = paramActivity.getString(R.string.S);
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.pleas…c_or_community_for_video)");
        TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
        continue;
        paramActivity = paramActivity.getString(R.string.R);
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.pleas…ciate_topic_or_community)");
        TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
        continue;
        paramActivity = paramActivity.getString(R.string.g);
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.assoc…te_topic_without_content)");
        TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
        continue;
        paramActivity = paramActivity.getString(R.string.h);
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.associate_topic_without_video)");
        TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
        continue;
        localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
        if (localGlobalPublisherConfig == null) {
          Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
        }
        if ((Intrinsics.areEqual(localGlobalPublisherConfig.getPublishScene(), "rijugc") ^ true))
        {
          paramActivity = paramActivity.getString(R.string.O);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.no_content_with_video)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
        }
        else
        {
          paramActivity = paramActivity.getString(R.string.ao);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.title_has_none_text)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
          continue;
          paramActivity = paramActivity.getString(R.string.aa);
          Intrinsics.checkExpressionValueIsNotNull(paramActivity, "getString(R.string.pure_content_ask_for_video)");
          TopicSDKHelperKt.a(paramActivity, false, null, 6, null);
        }
      }
    }
  }
  
  private final void a(Intent paramIntent)
  {
    int i = 0;
    float f1 = 0.0F;
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("result_path");
      if (str == null) {}
    }
    for (;;)
    {
      TLog.d("PublishArticleFragment", "获取封面选择结果 coverPath = " + str);
      if (paramIntent != null) {
        i = paramIntent.getIntExtra("from_page", 0);
      }
      if (paramIntent != null) {
        f1 = paramIntent.getFloatExtra("initial_progress", 0.0F);
      }
      paramIntent = new CoverSelectData();
      paramIntent.setCoverPath(str);
      paramIntent.setCoverFrom(i);
      paramIntent.setInitialProgress(f1);
      a(paramIntent);
      return;
      str = "";
    }
  }
  
  private final void a(Intent paramIntent, int paramInt)
  {
    String str;
    if (Build.VERSION.SDK_INT >= 18)
    {
      str = paramIntent.getStringExtra("video_path");
      paramIntent = paramIntent.getStringExtra("merge_path");
      if (paramInt == -1)
      {
        Intrinsics.checkExpressionValueIsNotNull(str, "videoPath");
        if (((CharSequence)str).length() <= 0) {
          break label111;
        }
        paramInt = 1;
        if (paramInt != 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mergePath");
          if (((CharSequence)paramIntent).length() <= 0) {
            break label116;
          }
        }
      }
    }
    label111:
    label116:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        this.jdField_a_of_type_JavaUtilMap.put(str, paramIntent);
      }
      paramIntent = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (paramIntent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      paramIntent.d();
      return;
      paramInt = 0;
      break;
    }
  }
  
  private final void a(View paramView)
  {
    Object localObject = paramView.findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.add_location_view)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView = ((AddLocationView)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    if (((View)localObject).getVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = a();
        if (localObject != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
          TopicSDKHelperKt.b((Activity)localObject, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
      }
      ((AddLocationView)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.2(this));
      localObject = paramView.findViewById(R.id.aw);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.ll_can_reprint)");
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
      localObject = paramView.findViewById(R.id.bu);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_can_reprint)");
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject);
      localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("canReprintLayout");
      }
      ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.3(this));
      localObject = a();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity!!");
      localObject = new ReprintActionDialog((Context)localObject);
      ((ReprintActionDialog)localObject).a((Function1)new PublishArticlePage.initEditVideoSettingsLayout..inlined.apply.lambda.1(this));
      this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleReprintActionDialog = ((ReprintActionDialog)localObject);
      localObject = paramView.findViewById(R.id.aB);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.ll_privacy_setting)");
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
      localObject = paramView.findViewById(R.id.bI);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_privacy_setting)");
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
      localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("privacyLayout");
      }
      ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.5(this));
      localObject = a();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity!!");
      localObject = new PrivacySettingDialog((Context)localObject);
      ((PrivacySettingDialog)localObject).a((Function1)new PublishArticlePage.initEditVideoSettingsLayout..inlined.apply.lambda.2(this));
      this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePrivacySettingDialog = ((PrivacySettingDialog)localObject);
      localObject = paramView.findViewById(R.id.b);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.addToTopicLayout)");
      this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout = ((AddToTopicLayout)localObject);
      paramView = paramView.findViewById(R.id.av);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.ll_add_topic)");
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView);
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
      }
      paramView.setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.7(this));
      return;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a(ViewGroup paramViewGroup)
  {
    Object localObject = paramViewGroup.findViewById(R.id.aF);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "frameLayout.findViewById(R.id.mediaSelectorLayout)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout = ((BottomSelectorLayout)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    ((RichEditText)localObject).setCountChangeListener((Function1)new PublishArticlePage.initBottomSelectorLayout.1(this));
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    ((BottomSelectorLayout)localObject).setOnTranslateListener((Function1)new PublishArticlePage.initBottomSelectorLayout.2(this));
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    ((BottomSelectorLayout)localObject).setOnExtendStateChangeListener((Function1)new PublishArticlePage.initBottomSelectorLayout.3(this));
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    ((BottomSelectorLayout)localObject).setOnTouchListener((View.OnTouchListener)new PublishArticlePage.initBottomSelectorLayout.4(this, paramViewGroup));
    paramViewGroup = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    paramViewGroup.setOnMediaSelectChangeListener((Function1)new PublishArticlePage.initBottomSelectorLayout.5(this));
    paramViewGroup = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    paramViewGroup.setOnMediaLoadedListener((Function1)new PublishArticlePage.initBottomSelectorLayout.6(this));
  }
  
  private final void a(CommunityInfo paramCommunityInfo)
  {
    AssociateModuleLayout localAssociateModuleLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
    if (localAssociateModuleLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
    }
    CommunityInfo localCommunityInfo = paramCommunityInfo;
    if (Intrinsics.areEqual(localAssociateModuleLayout.a(), paramCommunityInfo.getCommunityId())) {
      localCommunityInfo = null;
    }
    PublishArticleContract.IPublishArticleView.DefaultImpls.a(this, true, false, 2, null);
    a(this, null, localCommunityInfo, 1, null);
  }
  
  private final void a(DisplayItem paramDisplayItem)
  {
    ThreadManagerKt.c((Function0)new PublishArticlePage.updateDisplayItemInfo.1(paramDisplayItem));
  }
  
  private final void a(LocationInfo paramLocationInfo)
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      Object localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject1).clearFocus();
      localObject1 = InputMethodUtils.a;
      Context localContext = (Context)localActivity;
      Object localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
      }
      localObject2 = ((AddLocationView)localObject2).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "addLocationView.windowToken");
      ((InputMethodUtils)localObject1).a(localContext, (IBinder)localObject2);
      TopicSDKHelperKt.a().a(localActivity, paramLocationInfo, (Function1)new PublishArticlePage.showLocationListView.1(this));
    }
  }
  
  private final void a(OriginContentInfo paramOriginContentInfo)
  {
    if (paramOriginContentInfo == null)
    {
      paramOriginContentInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetOriginContentLayout;
      if (paramOriginContentInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("originContentLayout");
      }
      ((View)paramOriginContentInfo).setVisibility(8);
      return;
    }
    OriginContentLayout localOriginContentLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetOriginContentLayout;
    if (localOriginContentLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("originContentLayout");
    }
    localOriginContentLayout.setOriginContentInfo(paramOriginContentInfo);
  }
  
  private final void a(PublishArticleInfo paramPublishArticleInfo)
  {
    Object localObject = a();
    if ((localObject != null) && (localObject != null) && (!NetworkUtils.a.a((Context)localObject)))
    {
      a((Activity)localObject, -1);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePresenter;
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    ((PublishArticlePresenter)localObject).a(localGlobalPublisherConfig, paramPublishArticleInfo);
  }
  
  private final void a(TopicInfo paramTopicInfo)
  {
    TopicInfo localTopicInfo = paramTopicInfo;
    if (a() == paramTopicInfo.getTopicId()) {
      localTopicInfo = null;
    }
    a(this, localTopicInfo, null, 2, null);
    paramTopicInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
    if (paramTopicInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    paramTopicInfo.setSelectedTopic(localTopicInfo);
    if (localTopicInfo != null)
    {
      PublishArticleContract.IPublishArticleView.DefaultImpls.a(this, false, false, 2, null);
      return;
    }
    PublishArticleContract.IPublishArticleView.DefaultImpls.a(this, true, false, 2, null);
  }
  
  private final void a(TopicInfo paramTopicInfo, CommunityInfo paramCommunityInfo)
  {
    AssociateModuleLayout localAssociateModuleLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
    if (localAssociateModuleLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
    }
    Object localObject;
    long l;
    if (paramTopicInfo != null)
    {
      localObject = paramTopicInfo.getTitle();
      if (localObject != null)
      {
        localAssociateModuleLayout.setTopicName((String)localObject);
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
        }
        if (paramTopicInfo == null) {
          break label152;
        }
        l = paramTopicInfo.getTopicId();
        label65:
        ((AssociateModuleLayout)localObject).setTopicId(l);
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
        }
        if (paramCommunityInfo == null) {
          break label157;
        }
        paramTopicInfo = paramCommunityInfo.getTitle();
        if (paramTopicInfo == null) {
          break label157;
        }
        label101:
        ((AssociateModuleLayout)localObject).setCommunityName(paramTopicInfo);
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
        }
        if (paramCommunityInfo == null) {
          break label164;
        }
        paramTopicInfo = paramCommunityInfo.getCommunityId();
        if (paramTopicInfo == null) {
          break label164;
        }
      }
    }
    for (;;)
    {
      ((AssociateModuleLayout)localObject).setCommunityId(paramTopicInfo);
      return;
      localObject = "";
      break;
      label152:
      l = 0L;
      break label65;
      label157:
      paramTopicInfo = "";
      break label101;
      label164:
      paramTopicInfo = "";
    }
  }
  
  private final void a(CoverSelectData paramCoverSelectData)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
    }
    int j = ((MediaDisplayLayout)localObject).a();
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
    }
    localObject = ((MediaDisplayLayout)localObject).a().get(j);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mediaDisplayLayout.displayItems[lastClickPosition]");
    localObject = (DisplayItem)localObject;
    int i;
    if (((CharSequence)paramCoverSelectData.getCoverPath()).length() > 0)
    {
      i = 1;
      if ((i == 0) || (j == -1) || (((DisplayItem)localObject).getMedia().getType() != MediaType.VIDEO)) {
        break label179;
      }
      i = 1;
      label111:
      if (i != 0)
      {
        ((DisplayItem)localObject).setCoverPath(paramCoverSelectData.getCoverPath());
        ((DisplayItem)localObject).setFromPage(paramCoverSelectData.getCoverFrom());
        if (paramCoverSelectData.getCoverFrom() != 0) {
          break label184;
        }
      }
    }
    label179:
    label184:
    for (float f1 = paramCoverSelectData.getInitialProgress();; f1 = 0.0F)
    {
      ((DisplayItem)localObject).setInitialProgress(f1);
      paramCoverSelectData = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (paramCoverSelectData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      paramCoverSelectData.a().notifyDataSetChanged();
      return;
      i = 0;
      break;
      i = 0;
      break label111;
    }
  }
  
  private final void a(ReportEventKey paramReportEventKey, ReportEventPage paramReportEventPage, ReportEventElement paramReportEventElement)
  {
    a((Function1)new PublishArticlePage.reportPublishUserAction.1(this, paramReportEventKey, paramReportEventPage, paramReportEventElement));
  }
  
  private final void a(PanelType paramPanelType, List<DisplayItem> paramList)
  {
    if (paramPanelType != null)
    {
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add(((DisplayItem)((Iterator)localObject).next()).getMedia().getFilePath());
      }
      paramList = (List)paramList;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      ((BottomSelectorLayout)localObject).a(paramPanelType, new ArrayList((Collection)paramList));
    }
  }
  
  private final void a(Function1<? super PublishArticleInfo, Unit> paramFunction1)
  {
    PublishArticleInfo localPublishArticleInfo = new PublishArticleInfo();
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localObject = ((RichEditText)localObject).a();
    int i;
    if (((ArrayList)localObject).isEmpty())
    {
      GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localGlobalPublisherConfig == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      if (((CharSequence)localGlobalPublisherConfig.getDefaultPublishText()).length() <= 0) {
        break label440;
      }
      i = 1;
      if (i != 0)
      {
        localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
        if (localGlobalPublisherConfig == null) {
          Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
        }
        ((ArrayList)localObject).add(new EditObject(localGlobalPublisherConfig.getDefaultPublishText(), null, 2, null));
      }
    }
    localPublishArticleInfo.setContentList((List)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localPublishArticleInfo.setContentLength(((RichEditText)localObject).getText().length());
    localPublishArticleInfo.setTopicId(a());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
    }
    localPublishArticleInfo.setCommunityId(((AssociateModuleLayout)localObject).a());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setScene(((GlobalPublisherConfig)localObject).getScene());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setPublishScene(((GlobalPublisherConfig)localObject).getPublishScene());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setCircleId(((GlobalPublisherConfig)localObject).getCircleId());
    localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("commentCheckBox");
    }
    localPublishArticleInfo.setCommentAfterPublish(((CheckBox)localObject).isChecked());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setOriginContentInfo(((GlobalPublisherConfig)localObject).getOriginContentInfo());
    localPublishArticleInfo.setFromDraft(this.f);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    if (((AddLocationView)localObject).a() == null) {}
    for (localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo;; localObject = ((AddLocationView)localObject).a())
    {
      localPublishArticleInfo.setLocationInfo((LocationInfo)localObject);
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      localPublishArticleInfo.setAllowReprint(((GlobalPublisherConfig)localObject).getReprintAuthorityConfig().getAllowReprint());
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      localPublishArticleInfo.setPrivacySetting(((GlobalPublisherConfig)localObject).getPrivacySettingConfig().getPrivacySetting());
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      localPublishArticleInfo.updateDisplayInfoInArticleInfo(((MediaDisplayLayout)localObject).a());
      ThreadManagerKt.b((Function0)new PublishArticlePage.buildPublishArticleInfo.1(localPublishArticleInfo, paramFunction1));
      return;
      label440:
      i = 0;
      break;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
      }
    }
  }
  
  private final DraftArticleInfo b()
  {
    DraftArticleInfo localDraftArticleInfo = new DraftArticleInfo(null, null, null, false, false, false, 63, null);
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localDraftArticleInfo.setContent(((RichEditText)localObject).a());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
    }
    localDraftArticleInfo.setDisplayItems(((MediaDisplayLayout)localObject).a());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localDraftArticleInfo.setOriginContentInfo(((GlobalPublisherConfig)localObject).getOriginContentInfo());
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localDraftArticleInfo.setAllowMultiTweetTopic(((RichEditText)localObject).a());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localDraftArticleInfo.setAllowCommentAfterPublishConfig(((GlobalPublisherConfig)localObject).getShowCommentAfterPublish());
    return localDraftArticleInfo;
  }
  
  private final void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localObject = ((GlobalPublisherConfig)localObject).getPrivacySettingConfig();
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privacyTextView");
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      localObject = (CharSequence)((PrivacySettingConfig)localObject).getPublicTitle();
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return;
      localObject = (CharSequence)((PrivacySettingConfig)localObject).getExtraTitle();
      continue;
      localObject = (CharSequence)((PrivacySettingConfig)localObject).getPrivateTitle();
    }
  }
  
  private final void b(View paramView)
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      paramView = paramView.findViewById(R.id.ax);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.ll_container_view)");
      paramView = (LinearLayout)paramView;
      paramView.setOnClickListener((View.OnClickListener)new PublishArticlePage.initContainerView.1(this, localActivity, paramView));
    }
  }
  
  private final void b(List<Media> paramList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
    }
    localObject = ((Iterable)((MediaDisplayLayout)localObject).a()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DisplayItem localDisplayItem = (DisplayItem)((Iterator)localObject).next();
      if (!paramList.contains(localDisplayItem.getMedia()))
      {
        if (FileUtils.a.a((String)this.jdField_a_of_type_JavaUtilMap.get(localDisplayItem.getMedia().getFilePath()))) {
          FileUtils.a.b((String)this.jdField_a_of_type_JavaUtilMap.get(localDisplayItem.getMedia().getFilePath()));
        }
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localDisplayItem.getMedia().getFilePath())) {
          this.jdField_a_of_type_JavaUtilMap.remove(localDisplayItem.getMedia().getFilePath());
        }
      }
    }
  }
  
  private final void b(Function1<? super CommunityInfo, Unit> paramFunction1)
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
      }
      if (((AssociateModuleLayout)localObject2).a() != 0L)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "it");
        localObject2 = ((Activity)localObject1).getResources().getString(R.string.b);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.resources.getString(R…ssociate_community_toast)");
        TopicSDKHelperKt.a((String)localObject2, false, null, 6, null);
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "it");
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
      }
      localObject2 = new SelectCommunityView((Activity)localObject1, ((AssociateModuleLayout)localObject2).a(), new ListPresenter((ListContract.IListModel)new SelectCommunityModel()));
      localObject1 = new SlidingUpDialog((Context)localObject1, (View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      ((SelectCommunityView)localObject2).setOnSelectCallback((Function1)new PublishArticlePage.openSelectCommunityView..inlined.let.lambda.1((SlidingUpDialog)localObject1, this, paramFunction1));
      ((SlidingUpDialog)localObject1).show();
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localObject = ((GlobalPublisherConfig)localObject).getReprintAuthorityConfig();
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("canReprintTextView");
    }
    if (paramBoolean) {}
    for (localObject = (CharSequence)((ReprintAuthorityConfig)localObject).getAllowReprintTitle();; localObject = (CharSequence)((ReprintAuthorityConfig)localObject).getForbidReprintTitle())
    {
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  private final void c(View paramView)
  {
    ((TextView)paramView.findViewById(R.id.bv)).setOnClickListener((View.OnClickListener)new PublishArticlePage.initTitleBar.1(this));
    Object localObject = paramView.findViewById(R.id.bJ);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_publish)");
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("publishButton");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initTitleBar.2(this));
    localObject = paramView.findViewById(R.id.bo);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.titleBar)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    }
    ((RelativeLayout)localObject).setOnLongClickListener((View.OnLongClickListener)PublishArticlePage.initTitleBar.3.a);
    paramView = paramView.findViewById(R.id.bH);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_navigation)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
  }
  
  private final void c(boolean paramBoolean)
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      Object localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject1).clearFocus();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isSoftInputActive", InputMethodUtils.a.a(localActivity));
      InputMethodUtils localInputMethodUtils = InputMethodUtils.a;
      Context localContext = (Context)localActivity;
      Object localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject2 = ((RichEditText)localObject2).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "richEditText.windowToken");
      localInputMethodUtils.a(localContext, (IBinder)localObject2);
      TopicSDKHelperKt.a().a(localActivity, (Bundle)localObject1, (Function2)new PublishArticlePage.showAtContactListView.1(this, paramBoolean, localActivity));
    }
  }
  
  private final void d(View paramView)
  {
    paramView = paramView.findViewById(R.id.K);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.et_scrollview)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetCustomScrollView = ((CustomScrollView)paramView);
  }
  
  private final void e(View paramView)
  {
    paramView = paramView.findViewById(R.id.J);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.et_content)");
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText = ((RichEditText)paramView);
    paramView = a();
    if (paramView != null)
    {
      paramView = paramView.getWindow();
      if (paramView != null) {
        paramView.setSoftInputMode(2);
      }
    }
  }
  
  private final void f()
  {
    UiComponentSdkConfig localUiComponentSdkConfig = new UiComponentSdkConfig((IImageLoader)new UIImageLoaderImpl(), (IDataTransfer)new UIDataTransferImpl(), (ILogger)new UILoggerImpl(), (IEmoJiBridge)new UIEmoJiBridgeImpl());
    UiComponentSdk.a.a().a(localUiComponentSdkConfig);
    UiComponentSdk.a.a().a(false);
  }
  
  private final void f(View paramView)
  {
    paramView = paramView.findViewById(R.id.u);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.cb_comment_after_publish)");
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView);
  }
  
  private final boolean f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localObject = ((RichEditText)localObject).getText();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "richEditText.text");
    if (((CharSequence)localObject).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
        }
        if (((MediaDisplayLayout)localObject).a().size() <= 0) {
          break;
        }
      }
      return true;
    }
    return false;
  }
  
  private final void g()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      KeyBoardChangeListener.a(localActivity).a((KeyBoardChangeListener.KeyboardListener)new PublishArticlePage.handleInteraction.1(this));
    }
  }
  
  private final void g(View paramView)
  {
    paramView = paramView.findViewById(R.id.aY);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.recentTopicLayout)");
    this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout = ((RecentTopicLayout)paramView);
    paramView = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    paramView.setOnItemClickListener((Function1)new PublishArticlePage.initRecentTopicLayout.1(this));
  }
  
  private final boolean g()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    return (localGlobalPublisherConfig.getEnableSaveDraft()) && (f());
  }
  
  private final void h()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      CommonDialogBuilder.a(new CommonDialogBuilder((Context)localActivity).a(localActivity.getResources().getString(R.string.ah)).a(localActivity.getResources().getString(R.string.n), (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showExitDialog.1(this, localActivity)), localActivity.getResources().getString(R.string.af), null, 2, null).a(localActivity.getResources().getColor(R.color.c)).a().show();
    }
  }
  
  private final void h(View paramView)
  {
    paramView = paramView.findViewById(R.id.aJ);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.originContentLayout)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetOriginContentLayout = ((OriginContentLayout)paramView);
  }
  
  private final boolean h()
  {
    if (g())
    {
      i();
      return false;
    }
    if (f())
    {
      h();
      return false;
    }
    PublishManager.a.b();
    a(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_CANCEL_NO_DIALOG);
    return true;
  }
  
  private final void i()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      new CommonDialogBuilder((Context)localActivity).a(localActivity.getResources().getString(R.string.ak)).a(localActivity.getResources().getString(R.string.aj), (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showSaveDraftDialog.1(this, localActivity)).b(localActivity.getResources().getString(R.string.w), (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showSaveDraftDialog.2(this, localActivity)).a(localActivity.getResources().getColor(R.color.c)).a().show();
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH_DRAFT_DIALOG, ReportEventElement.ELEMENT_INVALID);
    }
  }
  
  private final void i(View paramView)
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      paramView = paramView.findViewById(R.id.aG);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.media_display_layout)");
      this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout = ((MediaDisplayLayout)paramView);
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      paramView.setOnItemClickListener((Function1)new PublishArticlePage.initMediaDisplayLayout.1(this, localActivity));
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      paramView.setOnCoverSelectListener((Function1)new PublishArticlePage.initMediaDisplayLayout.2(this, localActivity));
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      paramView.setOnItemDelListener((Function1)new PublishArticlePage.initMediaDisplayLayout.3(this));
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      paramView.setOnScrollListener((Function0)new PublishArticlePage.initMediaDisplayLayout.4(this, localActivity));
    }
  }
  
  private final void j()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localViewGroup.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localViewGroup.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private final void j(View paramView)
  {
    paramView = paramView.findViewById(R.id.N);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.extraPropertyContainer)");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView);
  }
  
  private final void k()
  {
    Object localObject1 = a();
    label26:
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getSerializable("global_publisher_config");
      localObject1 = (GlobalPublisherConfig)localObject1;
      if (localObject1 == null) {
        break label326;
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig = ((GlobalPublisherConfig)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("navigationBarView");
      }
      ((TextView)localObject2).setText((CharSequence)((GlobalPublisherConfig)localObject1).getNavigationBarText());
      n();
      localObject2 = ((GlobalPublisherConfig)localObject1).getTopicInfo();
      if (localObject2 == null) {
        break label337;
      }
      a((TopicInfo)localObject2);
      label90:
      localObject2 = ((GlobalPublisherConfig)localObject1).getCommunityInfo();
      if (localObject2 == null) {
        break label340;
      }
      a((CommunityInfo)localObject2);
      label104:
      localObject2 = ((GlobalPublisherConfig)localObject1).getOriginContentInfo();
      if (localObject2 == null) {
        break label343;
      }
      a((OriginContentInfo)localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject2).setSelection(0);
      localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject2).postDelayed((Runnable)new PublishArticlePage.initData..inlined.apply.lambda.1(this), 100L);
    }
    label326:
    label337:
    label340:
    label343:
    for (;;)
    {
      q();
      s();
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
      }
      GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localGlobalPublisherConfig == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      ((AssociateModuleLayout)localObject2).a(localGlobalPublisherConfig);
      t();
      j();
      x();
      PublishManager.a.a(((GlobalPublisherConfig)localObject1).getMaxImageSize());
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      ((BottomSelectorLayout)localObject2).setMinVideoLength(((GlobalPublisherConfig)localObject1).getMinVideoLength());
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      ((BottomSelectorLayout)localObject2).setMaxVideoLength(((GlobalPublisherConfig)localObject1).getMaxVideoLength());
      y();
      localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject1).setEditObjectListener((EditObjectListener)this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage$addEditObjectListener$1);
      this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePresenter.b();
      return;
      localObject1 = null;
      break;
      localObject1 = new GlobalPublisherConfig();
      break label26;
      break label90;
      break label104;
    }
  }
  
  private final void k(View paramView)
  {
    paramView = paramView.findViewById(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.associateModuleLayout)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout = ((AssociateModuleLayout)paramView);
    paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
    }
    paramView.a().setOnClickListener((View.OnClickListener)new PublishArticlePage.initAssociateModuleLayout.1(this));
    paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
    }
    paramView.b().setOnClickListener((View.OnClickListener)new PublishArticlePage.initAssociateModuleLayout.2(this));
  }
  
  private final void l()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
    }
    localObject = (View)localObject;
    MediaDisplayLayout localMediaDisplayLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
    if (localMediaDisplayLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
    }
    if (localMediaDisplayLayout.a().size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
    }
    label69:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  private final void m()
  {
    this.jdField_b_of_type_JavaLangString = a();
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    if (!((GlobalPublisherConfig)localObject).getEnableRestoreDraft()) {
      if (DraftManager.a.a().a(this.jdField_b_of_type_JavaLangString)) {
        DraftManager.a.a().a(this.jdField_b_of_type_JavaLangString);
      }
    }
    DraftArticleInfo localDraftArticleInfo;
    do
    {
      do
      {
        return;
      } while (!DraftManager.a.a().a(this.jdField_b_of_type_JavaLangString));
      localObject = a();
      if ((localObject != null) && (((DraftArticleInfo)localObject).getHasMedia() == true) && (!this.g))
      {
        this.h = true;
        return;
      }
      localDraftArticleInfo = a();
    } while (localDraftArticleInfo == null);
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    ((RichEditText)localObject).setAllowMultiTopic(localDraftArticleInfo.getAllowMultiTweetTopic());
    int i;
    if (!((Collection)localDraftArticleInfo.getContent()).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        ((RichEditText)localObject).setText((CharSequence)"");
        localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        ((RichEditText)localObject).a((List)localDraftArticleInfo.getContent());
      }
      localObject = localDraftArticleInfo.getMediaType();
      if (localObject == null) {
        break label270;
      }
    }
    label270:
    for (localObject = a((MediaType)localObject);; localObject = null)
    {
      a((PanelType)localObject, (List)localDraftArticleInfo.getDisplayItems());
      s();
      this.h = false;
      this.f = true;
      DraftManager.a.a().a(this.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
      break;
    }
  }
  
  private final void n()
  {
    o();
    p();
    RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setAtInputListener((Function0)new PublishArticlePage.initRichEditTextWithData.1(this));
  }
  
  private final void o()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setCountLimit(localGlobalPublisherConfig.getCountLimit());
    localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setNeedTextTruncation(localGlobalPublisherConfig.getNeedTextTruncation());
    localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setHint((CharSequence)localGlobalPublisherConfig.getPlaceHolder());
    localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    if (localGlobalPublisherConfig.getTweetTopicChoiceType() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localRichEditText.setAllowMultiTopic(bool);
      localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localRichEditText == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localRichEditText.setAllowDeletedTopic(localGlobalPublisherConfig.getAllowDeleteTweetTopic());
      return;
    }
  }
  
  private final void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localObject = ((Iterable)((GlobalPublisherConfig)localObject).getEditObjectListByOriginText()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EditObject localEditObject = (EditObject)((Iterator)localObject).next();
      RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localRichEditText == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      RichEditText.a(localRichEditText, localEditObject, false, 2, null);
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    ((BottomSelectorLayout)localObject).post((Runnable)new PublishArticlePage.initOriginTextInEditText.2(this));
  }
  
  private final void q()
  {
    int j = 0;
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    if (localGlobalPublisherConfig.getShowAddLocation())
    {
      i = 0;
      ((AddLocationView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
      }
      if (((View)localObject).getVisibility() != 0) {
        break label343;
      }
      i = 1;
      label79:
      if (i != 0) {
        a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_ADD_LOCATION);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("canReprintLayout");
      }
      if (!localGlobalPublisherConfig.getShowReprintAuthority()) {
        break label348;
      }
      i = 0;
      label122:
      ((LinearLayout)localObject).setVisibility(i);
      b(localGlobalPublisherConfig.getReprintAuthorityConfig().getAllowReprint());
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleReprintActionDialog;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("reprintActionDialog");
      }
      ((ReprintActionDialog)localObject).a(localGlobalPublisherConfig.getReprintAuthorityConfig());
      localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("privacyLayout");
      }
      if (!localGlobalPublisherConfig.getShowPrivacySetting()) {
        break label354;
      }
      i = 0;
      label191:
      ((LinearLayout)localObject).setVisibility(i);
      b(localGlobalPublisherConfig.getPrivacySettingConfig().getPrivacySetting());
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePrivacySettingDialog;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("privacySettingDialog");
      }
      ((PrivacySettingDialog)localObject).a(localGlobalPublisherConfig.getPrivacySettingConfig());
      localObject = this.jdField_d_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addToTopicLinear");
      }
      if (!localGlobalPublisherConfig.getShowAddToTopic()) {
        break label360;
      }
    }
    label343:
    label348:
    label354:
    label360:
    for (int i = j;; i = 8)
    {
      ((LinearLayout)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
      }
      ((AddToTopicLayout)localObject).a(localGlobalPublisherConfig.getAddToTopicConfig());
      if (localGlobalPublisherConfig.getAddToTopicConfig().getDisableSelectTopic())
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
        }
        ((AddToTopicLayout)localObject).setOnClickListener(null);
      }
      if (localGlobalPublisherConfig.getShowDefaultColumn()) {
        r();
      }
      return;
      i = 8;
      break;
      i = 0;
      break label79;
      i = 8;
      break label122;
      i = 8;
      break label191;
    }
  }
  
  private final void r()
  {
    new SelectTopicModel().a(false, (Function6)new PublishArticlePage.loadDefaultColumn.1(this));
  }
  
  private final void s()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    if (((GlobalPublisherConfig)localObject).getShowCommentAfterPublish())
    {
      localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("commentCheckBox");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("commentCheckBox");
      }
      ((CheckBox)localObject).setChecked(StorageManager.a.a("sp_comment_after_publish", false));
      return;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("commentCheckBox");
    }
    ((View)localObject).setVisibility(8);
  }
  
  private final void t()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localObject1 = ((GlobalPublisherConfig)localObject1).getInputPanelConfig();
    Object localObject2;
    if (((InputPanelConfig)localObject1).getShowPicPanel())
    {
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      BottomSelectorLayout.a((BottomSelectorLayout)localObject2, 9, 0L, 2, null);
    }
    if (((InputPanelConfig)localObject1).getShowVideoPanel())
    {
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      BottomSelectorLayout.b((BottomSelectorLayout)localObject2, 1, 0L, 2, null);
    }
    if (((InputPanelConfig)localObject1).getShowEmotionLPanel()) {
      u();
    }
    if (((InputPanelConfig)localObject1).getShowAtPanel())
    {
      v();
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_SELECT_AT);
    }
    for (;;)
    {
      if (((InputPanelConfig)localObject1).getShowTopicPanel())
      {
        w();
        a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_SELECT_TOPIC);
      }
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      ((BottomSelectorLayout)localObject1).setDefaultPanelIndex(0);
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((BottomSelectorLayout)localObject1).a(((RichEditText)localObject2).a());
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      ((ViewGroup)localObject1).post((Runnable)new PublishArticlePage.initBottomSelectorLayoutWithData.2(this));
      return;
      localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject2).setAtInputListener((Function0)null);
    }
  }
  
  private final void u()
  {
    BottomSelectorLayout localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.a();
    localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.setOnEmoJiItemClickListener((Function1)new PublishArticlePage.addEmotionPanelInSelectorLayout.1(this));
  }
  
  private final void v()
  {
    BottomSelectorLayout localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.b();
    localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.setOnAtButtonClickListener((Function0)new PublishArticlePage.addAtButtonInSelectorLayout.1(this));
  }
  
  private final void w()
  {
    BottomSelectorLayout localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.c();
    localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.setOnTopicButtonClickListener((Function0)new PublishArticlePage.addTopicButtonInSelectorLayout.1(this));
  }
  
  private final void x()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    if (localGlobalPublisherConfig.getShowRecentTopic()) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePresenter.c();
    }
  }
  
  private final void y()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localObject1 = ((GlobalPublisherConfig)localObject1).getOriginVideoInfo();
    if (localObject1 != null)
    {
      Object localObject2 = new Media(MediaType.VIDEO);
      ((Media)localObject2).setFilePath(((VideoInfo)localObject1).getFilePath());
      ((Media)localObject2).setWidth(((VideoInfo)localObject1).getWidth());
      ((Media)localObject2).setHeight(((VideoInfo)localObject1).getHeight());
      ((Media)localObject2).setSize(((VideoInfo)localObject1).getFileSize());
      ((Media)localObject2).setDuration(((VideoInfo)localObject1).getDuration());
      localObject2 = new DisplayItem((Media)localObject2);
      ((DisplayItem)localObject2).setCoverPath(((VideoInfo)localObject1).getCoverPath());
      a((DisplayItem)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      ((MediaDisplayLayout)localObject1).a().add(localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      ((MediaDisplayLayout)localObject1).setShowDelImage(false);
      l();
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      ((MediaDisplayLayout)localObject1).a().notifyDataSetChanged();
    }
  }
  
  private final void z()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      Object localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject1).clearFocus();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isSoftInputActive", InputMethodUtils.a.a(localActivity));
      InputMethodUtils localInputMethodUtils = InputMethodUtils.a;
      Context localContext = (Context)localActivity;
      Object localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject2 = ((RichEditText)localObject2).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "richEditText.windowToken");
      localInputMethodUtils.a(localContext, (IBinder)localObject2);
      TopicSDKHelperKt.a().b(localActivity, (Bundle)localObject1, (Function2)new PublishArticlePage.showTopicListView.1(this, localActivity));
    }
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePresenter.a((PublishArticleContract.IPublishArticleView)this);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.k, paramViewGroup, false);
    if (paramLayoutInflater == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater);
    f();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    b((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    c((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    d((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    e((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    f((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    g((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    h((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    i((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    j((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    k((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    a(paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    a((View)paramLayoutInflater);
    g();
    k();
    m();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    return (View)paramLayoutInflater;
  }
  
  public void a()
  {
    StorageManager localStorageManager = StorageManager.a;
    CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (localCheckBox == null) {
      Intrinsics.throwUninitializedPropertyAccessException("commentCheckBox");
    }
    localStorageManager.a("sp_comment_after_publish", localCheckBox.isChecked());
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePresenter.a();
    TopicSDKHelperKt.a().a();
    super.a();
  }
  
  public void a(int paramInt)
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      if (paramInt == 0)
      {
        localActivity.setResult(-1);
        IUserActionHandler localIUserActionHandler = TopicSDKHelperKt.a();
        Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
        }
        long l = ((AssociateModuleLayout)localObject).a();
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
        }
        localIUserActionHandler.a(localActivity, l, ((GlobalPublisherConfig)localObject).getScene());
        c();
      }
    }
    else
    {
      return;
    }
    a(localActivity, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    BottomSelectorLayout localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1) && (paramIntent != null)) {
      a(paramIntent);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramInt1 == 4) && (paramIntent != null))
            {
              a(paramIntent, paramInt2);
              return;
            }
          } while ((paramInt1 != 2) || (paramIntent == null));
          paramIntent = a();
        } while (paramIntent == null);
        paramIntent = paramIntent.getResources();
      } while (paramIntent == null);
      paramIntent = paramIntent.getString(R.string.aC);
    } while (paramIntent == null);
    TopicSDKHelperKt.a(paramIntent, false, null, 6, null);
  }
  
  public void a(@NotNull BindAccountInfo paramBindAccountInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBindAccountInfo, "bindAccountInfo");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleBindAccountInfo = paramBindAccountInfo;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    AssociateModuleLayout localAssociateModuleLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout;
    if (localAssociateModuleLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("associateLayout");
    }
    localAssociateModuleLayout.setUserProtocolUrl(paramString);
  }
  
  public void a(@NotNull List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "topicList");
    if (paramList.isEmpty())
    {
      paramList = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout;
      if (paramList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
      }
      paramList.setVisibility(8);
      return;
    }
    RecentTopicLayout localRecentTopicLayout = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout;
    if (localRecentTopicLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localRecentTopicLayout.setViewDisappearTime(localGlobalPublisherConfig.getRecentTopicDismissTime() * 1000L);
    localRecentTopicLayout.a(paramList);
    localRecentTopicLayout.a();
    paramList = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout;
    if (paramList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recentTopicLayout");
    }
    paramList.post((Runnable)new PublishArticlePage.updateAndShowRecentTopic.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    TLog.b("PublishArticleFragment", "onBindAccount, isSuccess = " + paramBoolean);
    a((Function1)new PublishArticlePage.onBindAccount.1(this));
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "realNameConfirmUrl");
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    TLog.b("PublishArticleFragment", "onGetRealNameStatus, needRealNameConfirm=" + paramBoolean + ", realNameConfirmUrl=" + paramString);
    if (this.e)
    {
      this.e = false;
      if ((!paramBoolean) && (!this.jdField_d_of_type_Boolean)) {
        a((Function1)new PublishArticlePage.onGetRealNameStatus.1(this));
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    BottomSelectorLayout localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.setPicPanelEnable(paramBoolean1);
    localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.setVideoPanelEnable(paramBoolean2);
  }
  
  public void aG_()
  {
    Object localObject1 = a();
    BindAccountInfo localBindAccountInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleBindAccountInfo;
    if ((localObject1 == null) || (localBindAccountInfo == null))
    {
      TLog.d("PublishArticleFragment", "showBindAccountDialog, activity == null || bindAccountInfo == null.");
      return;
    }
    View localView = LayoutInflater.from((Context)localObject1).inflate(R.layout.B, null);
    Intrinsics.checkExpressionValueIsNotNull(localView, "customView");
    localView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
    Object localObject2 = localView.findViewById(R.id.bp);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "customView.findViewById<TextView>(R.id.titleView)");
    ((TextView)localObject2).setText((CharSequence)localBindAccountInfo.a());
    localObject2 = (TextView)localView.findViewById(R.id.bl);
    int i;
    if (((CharSequence)localBindAccountInfo.b()).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label429;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "subTitleView");
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText((CharSequence)localBindAccountInfo.b());
    }
    for (;;)
    {
      localObject2 = (ImageView)localView.findViewById(R.id.ae);
      Object localObject3 = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a.a((Context)localObject1).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "imageView");
      ((com.tencent.tkd.topicsdk.framework.ImageLoader)localObject3).a((ImageView)localObject2).a(localBindAccountInfo.e());
      localObject2 = localView.findViewById(R.id.aH);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "customView.findViewById<…tView>(R.id.nickNameView)");
      ((TextView)localObject2).setText((CharSequence)localBindAccountInfo.d());
      localObject2 = localBindAccountInfo.f();
      localObject3 = ((Activity)localObject1).getString(R.string.i);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "activity.getString(R.string.cancel)");
      localObject2 = StringKt.a((String)localObject2, (String)localObject3);
      localObject3 = localBindAccountInfo.g();
      String str = ((Activity)localObject1).getString(R.string.m);
      Intrinsics.checkExpressionValueIsNotNull(str, "activity.getString(R.string.confirm)");
      localObject3 = StringKt.a((String)localObject3, str);
      this.jdField_a_of_type_AndroidAppDialog = ((Dialog)new CommonDialogBuilder((Context)localObject1).a(localView).b((String)localObject2, (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showBindAccountDialog..inlined.apply.lambda.1(localBindAccountInfo, this, localView, (Activity)localObject1)).a((String)localObject3, (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showBindAccountDialog..inlined.apply.lambda.2(localBindAccountInfo, this, localView, (Activity)localObject1)).a(false).a().a(((Activity)localObject1).getResources().getColor(R.color.c)).a());
      localObject1 = this.jdField_a_of_type_AndroidAppDialog;
      if (localObject1 != null) {
        ((Dialog)localObject1).show();
      }
      this.jdField_b_of_type_Boolean = true;
      TLog.a("PublishArticleFragment", "bindAccountDialog is shown.");
      return;
      i = 0;
      break;
      label429:
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "subTitleView");
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  public void aH_()
  {
    Activity localActivity = a();
    int i;
    if (localActivity != null)
    {
      if (((CharSequence)this.jdField_a_of_type_JavaLangString).length() <= 0) {
        break label62;
      }
      i = 1;
      if (i == 0) {
        break label67;
      }
      this.e = true;
      this.jdField_d_of_type_Boolean = true;
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "it");
      TopicSDKHelperKt.a((Context)localActivity, this.jdField_a_of_type_JavaLangString, null, 4, null);
    }
    for (;;)
    {
      return;
      label62:
      i = 0;
      break;
      label67:
      TLog.d("PublishArticleFragment", "jumpRealNameConfirmPage, realNameConfirmUrl is empty");
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_d_of_type_Boolean = false;
    if (this.e) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePresenter.b();
    }
    A();
  }
  
  public boolean e()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing() == true)) {}
    do
    {
      return true;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      if (((BottomSelectorLayout)localObject).c() == 3)
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
        }
        ((BottomSelectorLayout)localObject).d();
        return true;
      }
    } while (!h());
    return false;
  }
  
  public boolean o_()
  {
    return (this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean);
  }
  
  public boolean p_()
  {
    return (this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage
 * JD-Core Version:    0.7.0.1
 */