package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
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
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout;
import com.tencent.tkd.topicsdk.adapter.widget.UploadVideoProgressBar;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.DraftArticleInfo;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig.Companion;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.bean.globalconfig.AddToTopicConfig;
import com.tencent.tkd.topicsdk.bean.globalconfig.InputPanelConfig;
import com.tencent.tkd.topicsdk.bean.globalconfig.PrivacySettingConfig;
import com.tencent.tkd.topicsdk.bean.globalconfig.ReprintAuthorityConfig;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.Companion;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import com.tencent.tkd.topicsdk.common.PermissionUtils;
import com.tencent.tkd.topicsdk.common.ViewKt;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectData;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent.Companion;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.topicsdk.mediaselector.PanelType;
import com.tencent.tkd.topicsdk.mvp.ListContract.IListModel;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import com.tencent.tkd.topicsdk.publisharticle.PublishManager;
import com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticleContract.IPublishArticleView.DefaultImpls;
import com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticlePage;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager.Companion;
import com.tencent.tkd.topicsdk.publisharticle.selectPopup.ISelectPopupModel;
import com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController;
import com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController.Companion;
import com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectTweetTopicPopupModel;
import com.tencent.tkd.topicsdk.qq_adapter.R.color;
import com.tencent.tkd.topicsdk.qq_adapter.R.id;
import com.tencent.tkd.topicsdk.qq_adapter.R.layout;
import com.tencent.tkd.topicsdk.qq_adapter.R.string;
import com.tencent.tkd.topicsdk.selectowner.SelectTopicModel;
import com.tencent.tkd.topicsdk.selectowner.SelectTopicView;
import com.tencent.tkd.topicsdk.widget.AddLocationView;
import com.tencent.tkd.topicsdk.widget.AddToTopicLayout;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import com.tencent.tkd.topicsdk.widget.CustomScrollView;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import com.tencent.tkd.topicsdk.widget.dialog.PrivacySettingDialog;
import com.tencent.tkd.topicsdk.widget.dialog.ReprintActionDialog;
import com.tencent.tkd.topicsdk.widget.dialog.SlidingUpDialog;
import com.tencent.tkd.weibo.UiComponentSdk;
import com.tencent.tkd.weibo.UiComponentSdk.Companion;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import com.tencent.tkd.weibo.richEditText.EditObjectListener;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage;", "Lcom/tencent/tkd/topicsdk/publisharticle/base/BasePublishArticlePage;", "Lcom/tencent/tkd/topicsdk/adapter/publisharticle/QQPublishArticleContract$IPublishArticleView;", "()V", "addKDCommunityLayout", "Landroid/widget/LinearLayout;", "addLocationView", "Lcom/tencent/tkd/topicsdk/widget/AddLocationView;", "addToTopicLayout", "Lcom/tencent/tkd/topicsdk/widget/AddToTopicLayout;", "addToTopicLinear", "bigVideoCoverLayout", "Lcom/tencent/tkd/topicsdk/adapter/widget/BigVideoCoverLayout;", "bottomSelectorLayout", "Lcom/tencent/tkd/topicsdk/mediaselector/BottomSelectorLayout;", "canReprintLayout", "canReprintTextView", "Landroid/widget/TextView;", "contentScrollView", "Lcom/tencent/tkd/topicsdk/widget/CustomScrollView;", "createTopicController", "Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "currentDraftKey", "", "deferRestoreDraft", "", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "hasMediaLoaded", "isContentModified", "()Z", "isCoverFromDefault", "isFromDraft", "location", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "mediaDisplayLayout", "Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout;", "mergeVideoMap", "", "navigationBarView", "onPosPermissionCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "presenter", "Lcom/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePresenter;", "privacyLayout", "privacySettingDialog", "Lcom/tencent/tkd/topicsdk/widget/dialog/PrivacySettingDialog;", "privacyTextView", "publishButton", "publishId", "reprintActionDialog", "Lcom/tencent/tkd/topicsdk/widget/dialog/ReprintActionDialog;", "restoredDraftArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "getRestoredDraftArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "restoredDraftArticleInfo$delegate", "Lkotlin/Lazy;", "richEditText", "Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "rootView", "Landroid/view/ViewGroup;", "selectedCommunityView", "selectedKDCommunityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "shouldShowSaveDraft", "getShouldShowSaveDraft", "titleBar", "Landroid/widget/RelativeLayout;", "updateRichEditTextMaxHeightRunnable", "Ljava/lang/Runnable;", "uploadVideoProgressBar", "Lcom/tencent/tkd/topicsdk/adapter/widget/UploadVideoProgressBar;", "videoCoverContainer", "addAtButtonInSelectorLayout", "addEmotionPanelInSelectorLayout", "addRichEditObjectFailed", "editObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "extraInfo", "Lorg/json/JSONObject;", "addTopicButtonInSelectorLayout", "buildDraftArticleInfo", "buildPublishArticleInfo", "callback", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "changeBottomLayoutEnabled", "enablePic", "enableVideo", "checkShouldRestoreDraft", "getCurrentDisplayItems", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "Lkotlin/collections/ArrayList;", "getDraftKeyByCurrentConfig", "config", "getPanelHeight", "", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "handleCoverSelectResult", "data", "Landroid/content/Intent;", "handleInteraction", "handleLocationResult", "handleVideoCropResult", "resultCode", "initAddToTopicWithData", "initBaseConfigInEditText", "initBottomSelectorLayout", "frameLayout", "initBottomSelectorLayoutWithData", "initContainerView", "view", "Landroid/view/View;", "initData", "initEditVideoSettingsLayout", "initKDCommunityLayoutWithData", "initLocationViewWithData", "initMediaDisplayLayout", "initMediaDisplayLayoutWithData", "initOriginTextInEditText", "initPanelInBottomSelector", "initPrivacyLayoutWithData", "initReprintLayoutWithData", "initRichEditText", "initRichEditTextWithData", "initScrollView", "initSelectPopupController", "initTitleBar", "initUploadVideoProgressBar", "initVideoCoverLayout", "initVideoLimitLengthInBottomSelector", "initVideoPropertyWithData", "loadDefaultColumn", "onActivityResult", "requestCode", "onBackEvent", "onCoverDataUpdated", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "onPause", "onPreExit", "openSelectTopicView", "selectedTopicId", "", "selectTopicCallback", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "topicInfo", "publishArticle", "publishArticleInfo", "reportPublishUserAction", "eventId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "elementId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "restoreDraftContentInfo", "restoreDraftMediaInfo", "showAtContactListView", "hasInputAtInEditText", "showExitDialog", "showLocationListView", "originLocationInfo", "showSaveDraftDialog", "showTopicListView", "tryRestoreDraft", "onlyRestoreMedia", "updateDisplayItemInfo", "item", "updateMapAndDeleteFileForDeletedItem", "newMedias", "", "Lcom/tencent/tkd/topicsdk/bean/Media;", "updatePrivacyTextView", "privacy", "updateReprintTextView", "allowReprint", "updateRichEditTextMaxHeight", "updateSelectedMediaLayout", "displayItems", "updateTopicInfo", "updateTopicWordToObject", "startPos", "createBySpace", "tweetTopicItem", "toPanelType", "Lcom/tencent/tkd/topicsdk/bean/MediaType;", "Companion", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage
  extends BasePublishArticlePage
  implements QQPublishArticleContract.IPublishArticleView
{
  public static final PublishArticlePage.Companion a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final PublishArticlePresenter jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticlePublishArticlePresenter = new PublishArticlePresenter((QQPublishArticleContract.IPublishArticleModel)new PublishArticleModel());
  private BigVideoCoverLayout jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout;
  private UploadVideoProgressBar jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar;
  private CommunityInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo;
  private GlobalPublisherConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  private LocationInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo;
  private BottomSelectorLayout jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
  private SelectPopupController<TweetTopicItem> jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupController;
  private AddLocationView jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
  private AddToTopicLayout jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
  private CustomScrollView jdField_a_of_type_ComTencentTkdTopicsdkWidgetCustomScrollView;
  private MediaDisplayLayout jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
  private PrivacySettingDialog jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogPrivacySettingDialog;
  private ReprintActionDialog jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogReprintActionDialog;
  private RichEditText jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString = DraftManager.a.a().a(null);
  private Map<String, String> jdField_a_of_type_JavaUtilMap = (Map)new HashMap();
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new PublishArticlePage.restoredDraftArticleInfo.2(this));
  private Function1<? super Boolean, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView e;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticlePublishArticlePage$Companion = new PublishArticlePage.Companion(null);
  }
  
  public PublishArticlePage()
  {
    String str = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
    this.jdField_b_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo = new LocationInfo();
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = ((Function1)new PublishArticlePage.onPosPermissionCallback.1(this));
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new PublishArticlePage.updateRichEditTextMaxHeightRunnable.1(this));
  }
  
  private final int a(PanelType paramPanelType)
  {
    int i = PublishArticlePage.WhenMappings.b[paramPanelType.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3)) {
        return 0;
      }
      paramPanelType = this.jdField_a_of_type_AndroidViewViewGroup;
      if (paramPanelType == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      return ViewKt.c((View)paramPanelType);
    }
    paramPanelType = DisplayUtils.a;
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = ((ViewGroup)localObject).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootView.context");
    return paramPanelType.a((Context)localObject, 186.0F);
  }
  
  private final DraftArticleInfo a()
  {
    return (DraftArticleInfo)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final PanelType a(@NotNull MediaType paramMediaType)
  {
    int i = PublishArticlePage.WhenMappings.c[paramMediaType.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return PanelType.VIDEO;
      }
      throw new NoWhenBranchMatchedException();
    }
    return PanelType.PHOTO;
  }
  
  private final String a(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    return DraftManager.a.a().a(paramGlobalPublisherConfig);
  }
  
  private final void a(int paramInt)
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
    if (paramInt != 1)
    {
      if (paramInt != 3) {
        localObject = (CharSequence)((PrivacySettingConfig)localObject).getPublicTitle();
      } else {
        localObject = (CharSequence)((PrivacySettingConfig)localObject).getPrivateTitle();
      }
    }
    else {
      localObject = (CharSequence)((PrivacySettingConfig)localObject).getExtraTitle();
    }
    localTextView.setText((CharSequence)localObject);
  }
  
  private final void a(int paramInt, boolean paramBoolean, TweetTopicItem paramTweetTopicItem)
  {
    Object localObject1 = paramTweetTopicItem.c();
    int i = ((String)localObject1).length() + paramInt;
    if (paramInt >= 0)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject2 = ((RichEditText)localObject2).getText();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "richEditText.text");
      if (Intrinsics.areEqual(((CharSequence)localObject2).subSequence(paramInt, i).toString(), localObject1))
      {
        localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        ((RichEditText)localObject1).getText().delete(paramInt, i);
        localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        ((RichEditText)localObject1).setSelection(paramInt);
        localObject1 = new EditObject(paramTweetTopicItem.c(), EditObject.EditObjectType.TYPE_TOPIC);
        ((EditObject)localObject1).setKey(paramTweetTopicItem.a());
        paramTweetTopicItem = RichEditTextEvent.a.a(2);
        localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        ((RichEditText)localObject2).a((EditObject)localObject1, paramTweetTopicItem);
      }
    }
    paramTweetTopicItem = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (paramTweetTopicItem == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    paramInt = paramTweetTopicItem.getSelectionEnd();
    if (paramBoolean)
    {
      paramTweetTopicItem = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (paramTweetTopicItem == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      if (paramTweetTopicItem.getText().length() > paramInt)
      {
        paramTweetTopicItem = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
        if (paramTweetTopicItem == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        if (paramTweetTopicItem.getText().charAt(paramInt) == ' ')
        {
          paramTweetTopicItem = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
          if (paramTweetTopicItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richEditText");
          }
          paramTweetTopicItem.getText().delete(paramInt, paramInt + 1);
        }
      }
    }
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
  
  private final void a(Intent paramIntent)
  {
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("result_path");
      if (str != null) {}
    }
    else
    {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("获取封面选择结果 coverPath = ");
    localStringBuilder.append(str);
    TLog.d("PublishArticleFragment", localStringBuilder.toString());
    int i = 0;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("from_page", 0);
    }
    float f = 0.0F;
    if (paramIntent != null) {
      f = paramIntent.getFloatExtra("initial_progress", 0.0F);
    }
    paramIntent = new CoverSelectData();
    paramIntent.setCoverPath(str);
    paramIntent.setCoverFrom(i);
    paramIntent.setInitialProgress(f);
    a(paramIntent);
  }
  
  private final void a(Intent paramIntent, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      String str = paramIntent.getStringExtra("video_path");
      paramIntent = paramIntent.getStringExtra("merge_path");
      if (paramInt == -1)
      {
        Intrinsics.checkExpressionValueIsNotNull(str, "videoPath");
        paramInt = ((CharSequence)str).length();
        int i = 1;
        if (paramInt > 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mergePath");
          if (((CharSequence)paramIntent).length() > 0) {
            paramInt = i;
          } else {
            paramInt = 0;
          }
          if (paramInt != 0) {
            this.jdField_a_of_type_JavaUtilMap.put(str, paramIntent);
          }
        }
      }
      paramIntent = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (paramIntent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      paramIntent.d();
    }
  }
  
  private final void a(View paramView)
  {
    paramView = paramView.findViewById(R.id.C);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.upload_video_progress_bar)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar = ((UploadVideoProgressBar)paramView);
    paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("uploadVideoProgressBar");
    }
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    paramView.a(localGlobalPublisherConfig, this.jdField_b_of_type_JavaLangString);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a(ViewGroup paramViewGroup)
  {
    Object localObject = paramViewGroup.findViewById(R.id.o);
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
    ((BottomSelectorLayout)localObject).setOnExtendStateChangeListener((Function1)new PublishArticlePage.initBottomSelectorLayout.2(this));
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    ((BottomSelectorLayout)localObject).setOnTouchListener((View.OnTouchListener)new PublishArticlePage.initBottomSelectorLayout.3(this, paramViewGroup));
    paramViewGroup = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    paramViewGroup.setOnMediaSelectChangeListener((Function1)new PublishArticlePage.initBottomSelectorLayout.4(this));
    paramViewGroup = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    paramViewGroup.setOnMediaLoadedListener((Function1)new PublishArticlePage.initBottomSelectorLayout.5(this));
  }
  
  private final void a(DisplayItem paramDisplayItem)
  {
    ThreadManagerKt.c((Function0)new PublishArticlePage.updateDisplayItemInfo.1(paramDisplayItem));
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    b(paramGlobalPublisherConfig);
    c(paramGlobalPublisherConfig);
    d(paramGlobalPublisherConfig);
    e(paramGlobalPublisherConfig);
    f(paramGlobalPublisherConfig);
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
  
  private final void a(PublishArticleInfo paramPublishArticleInfo)
  {
    PublishArticlePresenter localPublishArticlePresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticlePublishArticlePresenter;
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticlePresenter.a(localGlobalPublisherConfig, paramPublishArticleInfo);
  }
  
  private final void a(TopicInfo paramTopicInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    localObject = ((AddToTopicLayout)localObject).a();
    long l;
    if (localObject != null) {
      l = ((TopicInfo)localObject).getTopicId();
    } else {
      l = 0L;
    }
    localObject = paramTopicInfo;
    if (l == paramTopicInfo.getTopicId()) {
      localObject = null;
    }
    paramTopicInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
    if (paramTopicInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    paramTopicInfo.setSelectedTopic((TopicInfo)localObject);
    if (localObject != null)
    {
      BasePublishArticleContract.IPublishArticleView.DefaultImpls.a(this, false, false, 2, null);
      return;
    }
    BasePublishArticleContract.IPublishArticleView.DefaultImpls.a(this, true, false, 2, null);
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
  
  private final void a(List<Media> paramList)
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
  
  private final void a(Function1<? super PublishArticleInfo, Unit> paramFunction1)
  {
    PublishArticleInfo localPublishArticleInfo = new PublishArticleInfo();
    localPublishArticleInfo.setPublishId(this.jdField_b_of_type_JavaLangString);
    Object localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localObject1 = ((RichEditText)localObject1).a();
    boolean bool = ((ArrayList)localObject1).isEmpty();
    int j = 2;
    Object localObject2;
    int i;
    if (bool)
    {
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      if (((CharSequence)((GlobalPublisherConfig)localObject2).getDefaultPublishText()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
        }
        ((ArrayList)localObject1).add(new EditObject(((GlobalPublisherConfig)localObject2).getDefaultPublishText(), null, 2, null));
      }
    }
    localPublishArticleInfo.setContentList((List)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localPublishArticleInfo.setContentLength(((RichEditText)localObject1).getText().length());
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    localObject1 = ((AddToTopicLayout)localObject1).a();
    long l;
    if (localObject1 != null) {
      l = ((TopicInfo)localObject1).getTopicId();
    } else {
      l = 0L;
    }
    localPublishArticleInfo.setTopicId(l);
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo;
    if (localObject1 != null)
    {
      localPublishArticleInfo.setCommunityId(((CommunityInfo)localObject1).getCommunityId());
      localPublishArticleInfo.setCommunityName(((CommunityInfo)localObject1).getTitle());
    }
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setScene(((GlobalPublisherConfig)localObject1).getScene());
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setPublishScene(((GlobalPublisherConfig)localObject1).getPublishScene());
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setCircleId(((GlobalPublisherConfig)localObject1).getCircleId());
    localPublishArticleInfo.setFromDraft(this.jdField_a_of_type_Boolean);
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    if (((AddLocationView)localObject1).a() == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo;
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
      }
      localObject1 = ((AddLocationView)localObject1).a();
    }
    localPublishArticleInfo.setLocationInfo((LocationInfo)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setAllowReprint(((GlobalPublisherConfig)localObject1).getReprintAuthorityConfig().getAllowReprint());
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setPrivacySetting(((GlobalPublisherConfig)localObject1).getPrivacySettingConfig().getPrivacySetting());
    localPublishArticleInfo.initMediaByDisplayItems(a());
    localObject1 = localPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("uploadVideoProgressBar");
      }
      ((VideoInfo)localObject1).setCoverUrl(((UploadVideoProgressBar)localObject2).a());
    }
    localObject1 = localPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      i = j;
      if (this.jdField_b_of_type_Boolean) {
        i = 1;
      }
      ((VideoInfo)localObject1).setCoverFrom(i);
    }
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setShowPublishToast(((GlobalPublisherConfig)localObject1).getShowPublishToast());
    ThreadManagerKt.b((Function0)new PublishArticlePage.buildPublishArticleInfo.1(localPublishArticleInfo, paramFunction1));
  }
  
  private final void a(boolean paramBoolean)
  {
    if (i()) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (!paramBoolean) {
      k();
    }
    paramBoolean = j();
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((DraftArticleInfo)localObject).getPublishId();
      if (localObject != null) {}
    }
    else
    {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    if (paramBoolean) {
      DraftManager.a.a().a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private final DraftArticleInfo b()
  {
    DraftArticleInfo localDraftArticleInfo = new DraftArticleInfo(null, null, null, null, null, false, false, false, 255, null);
    localDraftArticleInfo.setPublishId(this.jdField_b_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localDraftArticleInfo.setContent(((RichEditText)localObject).a());
    localDraftArticleInfo.setDisplayItems(a());
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
  
  private final void b(View paramView)
  {
    Object localObject = paramView.findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.add_location_view)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView = ((AddLocationView)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    int i;
    if (((View)localObject).getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = a();
      if (localObject != null)
      {
        PermissionUtils localPermissionUtils = PermissionUtils.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
        localPermissionUtils.b((Activity)localObject, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    ((AddLocationView)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.2(this));
    localObject = paramView.findViewById(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.ll_can_reprint)");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
    localObject = paramView.findViewById(R.id.w);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_can_reprint)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
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
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogReprintActionDialog = ((ReprintActionDialog)localObject);
    localObject = paramView.findViewById(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.ll_privacy_setting)");
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
    localObject = paramView.findViewById(R.id.A);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_privacy_setting)");
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
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
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogPrivacySettingDialog = ((PrivacySettingDialog)localObject);
    localObject = paramView.findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.addToTopicLayout)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout = ((AddToTopicLayout)localObject);
    localObject = paramView.findViewById(R.id.k);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.ll_add_topic)");
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    ((AddToTopicLayout)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.7(this));
    localObject = paramView.findViewById(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.addKDCommunityLayout)");
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
    paramView = paramView.findViewById(R.id.u);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.selectedCommunityView)");
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView);
    paramView = this.jdField_d_of_type_AndroidWidgetLinearLayout;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
    }
    paramView.setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.8(this));
  }
  
  private final void b(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    AddLocationView localAddLocationView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
    if (localAddLocationView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    boolean bool = paramGlobalPublisherConfig.getShowAddLocation();
    int j = 0;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    localAddLocationView.setVisibility(i);
    paramGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddLocationView;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    int i = j;
    if (((View)paramGlobalPublisherConfig).getVisibility() == 0) {
      i = 1;
    }
    if (i != 0) {
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_ADD_LOCATION);
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
    if (paramBoolean) {
      localObject = ((ReprintAuthorityConfig)localObject).getAllowReprintTitle();
    } else {
      localObject = ((ReprintAuthorityConfig)localObject).getForbidReprintTitle();
    }
    localTextView.setText((CharSequence)localObject);
  }
  
  private final void c(View paramView)
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      paramView = paramView.findViewById(R.id.m);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.ll_container_view)");
      paramView = (LinearLayout)paramView;
      paramView.setOnClickListener((View.OnClickListener)new PublishArticlePage.initContainerView.1(this, localActivity, paramView));
    }
  }
  
  private final void c(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("canReprintLayout");
    }
    int i;
    if (paramGlobalPublisherConfig.getShowReprintAuthority()) {
      i = 0;
    } else {
      i = 8;
    }
    ((LinearLayout)localObject).setVisibility(i);
    b(paramGlobalPublisherConfig.getReprintAuthorityConfig().getAllowReprint());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogReprintActionDialog;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("reprintActionDialog");
    }
    ((ReprintActionDialog)localObject).a(paramGlobalPublisherConfig.getReprintAuthorityConfig());
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
    ((TextView)paramView.findViewById(R.id.x)).setOnClickListener((View.OnClickListener)new PublishArticlePage.initTitleBar.1(this));
    Object localObject = paramView.findViewById(R.id.B);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_publish)");
    this.e = ((TextView)localObject);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("publishButton");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initTitleBar.2(this));
    localObject = paramView.findViewById(R.id.v);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.titleBar)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    }
    ((RelativeLayout)localObject).setOnLongClickListener((View.OnLongClickListener)PublishArticlePage.initTitleBar.3.a);
    paramView = paramView.findViewById(R.id.z);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_navigation)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
  }
  
  private final void d(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privacyLayout");
    }
    int i;
    if (paramGlobalPublisherConfig.getShowPrivacySetting()) {
      i = 0;
    } else {
      i = 8;
    }
    ((LinearLayout)localObject).setVisibility(i);
    a(paramGlobalPublisherConfig.getPrivacySettingConfig().getPrivacySetting());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogPrivacySettingDialog;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privacySettingDialog");
    }
    ((PrivacySettingDialog)localObject).a(paramGlobalPublisherConfig.getPrivacySettingConfig());
  }
  
  private final void e(View paramView)
  {
    paramView = paramView.findViewById(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.et_scrollview)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetCustomScrollView = ((CustomScrollView)paramView);
  }
  
  private final void e(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLinear");
    }
    int i;
    if (paramGlobalPublisherConfig.getShowAddToTopic()) {
      i = 0;
    } else {
      i = 8;
    }
    ((LinearLayout)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    ((AddToTopicLayout)localObject).a(paramGlobalPublisherConfig.getAddToTopicConfig());
    if (paramGlobalPublisherConfig.getAddToTopicConfig().getDisableSelectTopic())
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAddToTopicLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
      }
      ((AddToTopicLayout)localObject).setOnClickListener(null);
    }
    if (paramGlobalPublisherConfig.getShowDefaultColumn()) {
      o();
    }
  }
  
  private final void f()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      KeyBoardChangeListener.a.a(localActivity).a((KeyBoardChangeListener.KeyboardListener)new PublishArticlePage.handleInteraction..inlined.apply.lambda.1(this));
    }
  }
  
  private final void f(View paramView)
  {
    paramView = paramView.findViewById(R.id.e);
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
  
  private final void f(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject;
    if (paramGlobalPublisherConfig.getShowDeliverToKDCommunity())
    {
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_DELIVER_TO_KD_COMMUNITY);
      localObject = this.jdField_d_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
      }
      ((LinearLayout)localObject).setVisibility(0);
    }
    else
    {
      localObject = this.jdField_d_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
      }
      ((LinearLayout)localObject).setVisibility(8);
    }
    if (paramGlobalPublisherConfig.getCommunityInfo() != null)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo = paramGlobalPublisherConfig.getCommunityInfo();
      paramGlobalPublisherConfig = this.jdField_d_of_type_AndroidWidgetLinearLayout;
      if (paramGlobalPublisherConfig == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
      }
      paramGlobalPublisherConfig.setClickable(false);
      paramGlobalPublisherConfig = this.jdField_d_of_type_AndroidWidgetLinearLayout;
      if (paramGlobalPublisherConfig == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
      }
      paramGlobalPublisherConfig.setEnabled(false);
      localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectedCommunityView");
      }
      paramGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo;
      if (paramGlobalPublisherConfig != null)
      {
        paramGlobalPublisherConfig = paramGlobalPublisherConfig.getTitle();
        if (paramGlobalPublisherConfig != null) {}
      }
      else
      {
        paramGlobalPublisherConfig = "";
      }
      ((TextView)localObject).setText((CharSequence)paramGlobalPublisherConfig);
      return;
    }
    paramGlobalPublisherConfig = this.jdField_d_of_type_AndroidWidgetLinearLayout;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
    }
    paramGlobalPublisherConfig.setClickable(true);
    paramGlobalPublisherConfig = this.jdField_d_of_type_AndroidWidgetLinearLayout;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
    }
    paramGlobalPublisherConfig.setEnabled(true);
    paramGlobalPublisherConfig = a();
    if (paramGlobalPublisherConfig != null)
    {
      localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectedCommunityView");
      }
      ((TextView)localObject).setText((CharSequence)paramGlobalPublisherConfig.getString(R.string.b));
    }
  }
  
  private final void g()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      CommonDialogBuilder.a(new CommonDialogBuilder((Context)localActivity).a(localActivity.getResources().getString(R.string.e)).a(localActivity.getResources().getString(R.string.a), (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showExitDialog.1(this, localActivity)), localActivity.getResources().getString(R.string.d), null, 2, null).a(localActivity.getResources().getColor(R.color.a)).a().show();
    }
  }
  
  private final void g(View paramView)
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      View localView = paramView.findViewById(R.id.D);
      Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.video_cover_layout)");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
      paramView = paramView.findViewById(R.id.d);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.big_video_cover_layout)");
      this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout = ((BigVideoCoverLayout)paramView);
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
      }
      paramView.setOnItemClickListener((Function1)new PublishArticlePage.initVideoCoverLayout.1(localActivity));
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
      }
      paramView.setOnChangeCoverClickListener((Function1)new PublishArticlePage.initVideoCoverLayout.2(this));
    }
  }
  
  private final void g(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    h(paramGlobalPublisherConfig);
    i(paramGlobalPublisherConfig);
    paramGlobalPublisherConfig = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramGlobalPublisherConfig.post((Runnable)new PublishArticlePage.initBottomSelectorLayoutWithData.1(this));
  }
  
  private final void h()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      new CommonDialogBuilder((Context)localActivity).a(localActivity.getResources().getString(R.string.g)).a(localActivity.getResources().getString(R.string.f), (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showSaveDraftDialog.1(this, localActivity)).b(localActivity.getResources().getString(R.string.c), (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showSaveDraftDialog.2(this, localActivity)).a(localActivity.getResources().getColor(R.color.a)).a().show();
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH_DRAFT_DIALOG, ReportEventElement.ELEMENT_INVALID);
    }
  }
  
  private final void h(View paramView)
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      paramView = paramView.findViewById(R.id.p);
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
      paramView.setOnItemDelListener((Function1)new PublishArticlePage.initMediaDisplayLayout.2(this));
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      paramView.setOnScrollListener((Function0)new PublishArticlePage.initMediaDisplayLayout.3(this, localActivity));
    }
  }
  
  private final void h(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    paramGlobalPublisherConfig = paramGlobalPublisherConfig.getInputPanelConfig();
    if (paramGlobalPublisherConfig.getShowPicPanel())
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      BottomSelectorLayout.a((BottomSelectorLayout)localObject, 9, 0L, 2, null);
    }
    if (paramGlobalPublisherConfig.getShowVideoPanel())
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      BottomSelectorLayout.b((BottomSelectorLayout)localObject, 1, 0L, 2, null);
    }
    if (paramGlobalPublisherConfig.getShowEmotionLPanel()) {
      p();
    }
    if (paramGlobalPublisherConfig.getShowAtPanel())
    {
      q();
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_SELECT_AT);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject).setAtInputListener((Function0)null);
    }
    if (paramGlobalPublisherConfig.getShowTopicPanel())
    {
      r();
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_SELECT_TOPIC);
    }
    paramGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    paramGlobalPublisherConfig.setDefaultPanelIndex(0);
    paramGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    paramGlobalPublisherConfig.a(((RichEditText)localObject).a());
  }
  
  private final boolean h()
  {
    if (b())
    {
      h();
      return false;
    }
    if (a())
    {
      g();
      return false;
    }
    PublishManager.a.b();
    a(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_CANCEL_NO_DIALOG);
    return true;
  }
  
  private final void i()
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
  
  private final void i(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    BottomSelectorLayout localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.setMinVideoLength(paramGlobalPublisherConfig.getMinVideoLength());
    localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.setMaxVideoLength(paramGlobalPublisherConfig.getMaxVideoLength());
  }
  
  private final boolean i()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    if (!localGlobalPublisherConfig.getEnableRestoreDraft())
    {
      if (DraftManager.a.a().a(this.jdField_a_of_type_JavaLangString)) {
        DraftManager.a.a().a(this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    return !DraftManager.a.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  private final void j()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = GlobalPublisherConfig.Companion.a((Bundle)localObject1);
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = new GlobalPublisherConfig();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig = ((GlobalPublisherConfig)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("navigationBarView");
    }
    ((TextView)localObject2).setText((CharSequence)((GlobalPublisherConfig)localObject1).getNavigationBarText());
    l();
    localObject2 = ((GlobalPublisherConfig)localObject1).getTopicInfo();
    if (localObject2 != null) {
      a((TopicInfo)localObject2);
    }
    a((GlobalPublisherConfig)localObject1);
    g((GlobalPublisherConfig)localObject1);
    i();
    PublishManager.a.a(((GlobalPublisherConfig)localObject1).getMaxImageSize());
    j((GlobalPublisherConfig)localObject1);
    s();
    this.jdField_a_of_type_JavaLangString = a((GlobalPublisherConfig)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    ((RichEditText)localObject1).setEditObjectListener((EditObjectListener)this);
  }
  
  private final void j(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject = paramGlobalPublisherConfig.getOriginVideoInfo();
    if (localObject != null)
    {
      paramGlobalPublisherConfig = new Media(MediaType.VIDEO);
      paramGlobalPublisherConfig.setFilePath(((VideoInfo)localObject).getFilePath());
      paramGlobalPublisherConfig.setWidth(((VideoInfo)localObject).getWidth());
      paramGlobalPublisherConfig.setHeight(((VideoInfo)localObject).getHeight());
      paramGlobalPublisherConfig.setSize(((VideoInfo)localObject).getFileSize());
      paramGlobalPublisherConfig.setDuration(((VideoInfo)localObject).getDuration());
      paramGlobalPublisherConfig = new DisplayItem(paramGlobalPublisherConfig);
      paramGlobalPublisherConfig.setCoverPath(((VideoInfo)localObject).getCoverPath());
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCoverContainer");
      }
      ((RelativeLayout)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
      }
      ((BigVideoCoverLayout)localObject).setDisplayItem(paramGlobalPublisherConfig);
    }
  }
  
  private final boolean j()
  {
    DraftArticleInfo localDraftArticleInfo = a();
    if (localDraftArticleInfo != null)
    {
      if (!localDraftArticleInfo.getHasMedia()) {
        return false;
      }
      if (localDraftArticleInfo.getMediaType() == MediaType.PHOTO)
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
        }
        if (!((BottomSelectorLayout)localObject).a()) {}
      }
      else
      {
        if (localDraftArticleInfo.getMediaType() != MediaType.VIDEO) {
          break label84;
        }
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
        }
        if (((BottomSelectorLayout)localObject).b()) {
          break label84;
        }
      }
      return false;
      label84:
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = true;
        return false;
      }
      Object localObject = localDraftArticleInfo.getMediaType();
      if (localObject != null) {
        localObject = a((MediaType)localObject);
      } else {
        localObject = null;
      }
      a((PanelType)localObject, (List)localDraftArticleInfo.getDisplayItems());
      this.jdField_d_of_type_Boolean = false;
      return true;
    }
    return false;
  }
  
  private final void k()
  {
    DraftArticleInfo localDraftArticleInfo = a();
    if (localDraftArticleInfo != null)
    {
      RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localRichEditText == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localRichEditText.setAllowMultiTopic(localDraftArticleInfo.getAllowMultiTweetTopic());
      if ((((Collection)localDraftArticleInfo.getContent()).isEmpty() ^ true))
      {
        localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
        if (localRichEditText == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        localRichEditText.setText((CharSequence)"");
        localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
        if (localRichEditText == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        localRichEditText.a((List)localDraftArticleInfo.getContent());
      }
    }
  }
  
  private final void l()
  {
    m();
    n();
    RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setAtInputListener((Function0)new PublishArticlePage.initRichEditTextWithData.1(this));
  }
  
  private final void m()
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
    boolean bool;
    if (localGlobalPublisherConfig.getTweetTopicChoiceType() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localRichEditText.setAllowMultiTopic(bool);
    localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setAllowDeletedTopic(localGlobalPublisherConfig.getAllowDeleteTweetTopic());
  }
  
  private final void n()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localObject = ((Iterable)((GlobalPublisherConfig)localObject).getEditObjectListByOriginText()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EditObject localEditObject = (EditObject)((Iterator)localObject).next();
      JSONObject localJSONObject = RichEditTextEvent.a.a(0);
      RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localRichEditText == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localRichEditText.a(localEditObject, localJSONObject);
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    ((BottomSelectorLayout)localObject).post((Runnable)new PublishArticlePage.initOriginTextInEditText.2(this));
  }
  
  private final void o()
  {
    new SelectTopicModel().a(false, (Function6)new PublishArticlePage.loadDefaultColumn.1(this));
  }
  
  private final void p()
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
  
  private final void q()
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
  
  private final void r()
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
  
  private final void s()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      if (!((GlobalPublisherConfig)localObject2).getAllowCreateTweetTopic()) {
        return;
      }
      localObject2 = SelectPopupController.a;
      RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localRichEditText == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject1 = ((SelectPopupController.Companion)localObject2).a((Activity)localObject1, localRichEditText, (ISelectPopupModel)new SelectTweetTopicPopupModel());
      ((SelectPopupController)localObject1).a((Function3)new PublishArticlePage.initSelectPopupController..inlined.also.lambda.1(this));
      ((SelectPopupController)localObject1).a((Function1)new PublishArticlePage.initSelectPopupController..inlined.also.lambda.2(this));
      this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupController = ((SelectPopupController)localObject1);
    }
  }
  
  private final void t()
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
      Object localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      ((Bundle)localObject1).putBoolean("allow_create_tweet_topic", ((GlobalPublisherConfig)localObject2).getAllowCreateTweetTopic());
      localObject2 = InputMethodUtils.a;
      Context localContext = (Context)localActivity;
      Object localObject3 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
      if (localObject3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject3 = ((RichEditText)localObject3).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "richEditText.windowToken");
      ((InputMethodUtils)localObject2).a(localContext, (IBinder)localObject3);
      TopicSDKHelperKt.a().b(localActivity, (Bundle)localObject1, (Function2)new PublishArticlePage.showTopicListView.1(this, localActivity));
    }
  }
  
  private final void u()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getResources();
      if (localObject != null)
      {
        localObject = ((Resources)localObject).getString(R.string.q);
        break label31;
      }
    }
    localObject = null;
    label31:
    if ((localObject != null) && (localObject != null)) {
      TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
    }
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticlePublishArticlePresenter.a((QQPublishArticleContract.IPublishArticleView)this);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.a, paramViewGroup, false);
    if (paramLayoutInflater != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater);
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
      a(paramLayoutInflater);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      b((View)paramLayoutInflater);
      f();
      j();
      a(this, false, 1, null);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      a((View)paramLayoutInflater);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      return (View)paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
  }
  
  @NotNull
  public ArrayList<DisplayItem> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
    }
    localObject = ((BigVideoCoverLayout)localObject).a();
    if (localObject != null) {
      return CollectionsKt.arrayListOf(new DisplayItem[] { localObject });
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
    }
    return ((MediaDisplayLayout)localObject).a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticlePublishArticlePresenter.a();
    TopicSDK.a.a().a();
    UiComponentSdk.a.a().a();
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    BottomSelectorLayout localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    localBottomSelectorLayout.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1) && (paramIntent != null))
    {
      a(paramIntent);
      return;
    }
    if ((paramInt1 == 4) && (paramIntent != null))
    {
      a(paramIntent, paramInt2);
      return;
    }
    if ((paramInt1 == 4) && (paramIntent != null)) {
      u();
    }
  }
  
  public void a(@NotNull CoverSelectData paramCoverSelectData)
  {
    Intrinsics.checkParameterIsNotNull(paramCoverSelectData, "data");
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
    }
    localObject = ((BigVideoCoverLayout)localObject).a();
    if (localObject != null)
    {
      int i = ((CharSequence)paramCoverSelectData.getCoverPath()).length();
      int j = 1;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (((DisplayItem)localObject).getMedia().getType() == MediaType.VIDEO)) {
        i = j;
      } else {
        i = 0;
      }
      if (i == 0) {
        return;
      }
      ((DisplayItem)localObject).setCoverPath(paramCoverSelectData.getCoverPath());
      ((DisplayItem)localObject).setFromPage(paramCoverSelectData.getCoverFrom());
      float f;
      if (paramCoverSelectData.getCoverFrom() == 0) {
        f = paramCoverSelectData.getInitialProgress();
      } else {
        f = 0.0F;
      }
      ((DisplayItem)localObject).setInitialProgress(f);
      this.jdField_b_of_type_Boolean = false;
      paramCoverSelectData = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout;
      if (paramCoverSelectData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
      }
      paramCoverSelectData.setDisplayItem((DisplayItem)localObject);
      paramCoverSelectData = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar;
      if (paramCoverSelectData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("uploadVideoProgressBar");
      }
      paramCoverSelectData.a((DisplayItem)localObject);
    }
  }
  
  public void a(@NotNull EditObject paramEditObject, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObject, "editObject");
    paramJSONObject = a();
    if ((paramJSONObject != null) && (paramJSONObject != null))
    {
      paramEditObject = paramEditObject.getType();
      int i = PublishArticlePage.WhenMappings.a[paramEditObject.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          TLog.d("PublishArticleFragment", "addRichEditObjectFailed invalid editObject type.");
          return;
        }
        paramEditObject = paramJSONObject.getResources().getString(R.string.s);
        Intrinsics.checkExpressionValueIsNotNull(paramEditObject, "resources.getString(R.st…tle_out_of_limit_tips_at)");
        TopicSDKHelperKt.a(paramEditObject, false, null, 6, null);
        return;
      }
      paramEditObject = paramJSONObject.getResources().getString(R.string.r);
      Intrinsics.checkExpressionValueIsNotNull(paramEditObject, "resources.getString(R.st…_title_out_of_limit_tips)");
      TopicSDKHelperKt.a(paramEditObject, false, null, 6, null);
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
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localObject = ((RichEditText)localObject).getText();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "richEditText.text");
    int i = ((CharSequence)localObject).length();
    boolean bool2 = true;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (i == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      bool1 = bool2;
      if (((MediaDisplayLayout)localObject).a().size() <= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
        }
        if (((BigVideoCoverLayout)localObject).a() != null) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    return (localGlobalPublisherConfig.getEnableSaveDraft()) && (a());
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupController;
    BottomSelectorLayout localBottomSelectorLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
    if (localBottomSelectorLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
    }
    int i = localBottomSelectorLayout.b();
    boolean bool = true;
    if (i == 3)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSelectorLayout");
      }
      ((BottomSelectorLayout)localObject).d();
      return true;
    }
    if ((localObject != null) && (((SelectPopupController)localObject).a()))
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupController;
      if (localObject != null)
      {
        ((SelectPopupController)localObject).a(2);
        return true;
      }
    }
    else
    {
      if (!h()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage
 * JD-Core Version:    0.7.0.1
 */