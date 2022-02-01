package com.tencent.tkd.topicsdk.adapter.publisharticle;

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
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout;
import com.tencent.tkd.topicsdk.adapter.widget.PublishVideoDeliverTypeLayout;
import com.tencent.tkd.topicsdk.adapter.widget.PublishVideoDeliverTypeLayout.DeliverType;
import com.tencent.tkd.topicsdk.adapter.widget.RichEditTextMenuView;
import com.tencent.tkd.topicsdk.adapter.widget.UploadVideoProgressBar;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
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
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.Companion;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import com.tencent.tkd.topicsdk.common.PermissionUtils;
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
import com.tencent.tkd.topicsdk.mvp.ListContract.IListModel;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticleContract.IPublishArticleView.DefaultImpls;
import com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticlePage;
import com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager;
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
import com.tencent.tkd.topicsdk.widget.AddToTopicLayout;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import com.tencent.tkd.topicsdk.widget.CustomScrollView;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import com.tencent.tkd.topicsdk.widget.dialog.PrivacySettingDialog;
import com.tencent.tkd.topicsdk.widget.dialog.SlidingUpDialog;
import com.tencent.tkd.weibo.UiComponentSdk;
import com.tencent.tkd.weibo.UiComponentSdk.Companion;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import com.tencent.tkd.weibo.richEditText.EditObjectListener;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage;", "Lcom/tencent/tkd/topicsdk/publisharticle/base/BasePublishArticlePage;", "Lcom/tencent/tkd/topicsdk/adapter/publisharticle/QQPublishArticleContract$IPublishArticleView;", "()V", "addKDCommunityLayout", "Landroid/widget/LinearLayout;", "addLocationHint", "Landroid/widget/TextView;", "addLocationTextView", "addLocationView", "addToTopicLayout", "Lcom/tencent/tkd/topicsdk/widget/AddToTopicLayout;", "addToTopicLinear", "bigVideoCoverLayout", "Lcom/tencent/tkd/topicsdk/adapter/widget/BigVideoCoverLayout;", "contentScrollView", "Lcom/tencent/tkd/topicsdk/widget/CustomScrollView;", "createTopicController", "Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "deliverTypeLayout", "Lcom/tencent/tkd/topicsdk/adapter/widget/PublishVideoDeliverTypeLayout;", "deliverTypeLayoutContainer", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "isContentModified", "", "()Z", "isCoverFromDefault", "isFromDraft", "location", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "mediaDisplayLayout", "Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout;", "mergeVideoMap", "", "", "navigationBarView", "onPosPermissionCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "presenter", "Lcom/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePresenter;", "privacyLayout", "privacySettingDialog", "Lcom/tencent/tkd/topicsdk/widget/dialog/PrivacySettingDialog;", "privacyTextView", "publishButton", "publishId", "richEditText", "Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "richEdtMenuView", "Lcom/tencent/tkd/topicsdk/adapter/widget/RichEditTextMenuView;", "rootView", "Landroid/view/ViewGroup;", "selectedCommunityView", "selectedKDCommunityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "shouldShowSaveDraft", "getShouldShowSaveDraft", "titleBar", "Landroid/widget/RelativeLayout;", "updateRichEditTextMaxHeightRunnable", "Ljava/lang/Runnable;", "uploadVideoProgressBar", "Lcom/tencent/tkd/topicsdk/adapter/widget/UploadVideoProgressBar;", "videoCoverContainer", "addRichEditObjectFailed", "editObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "extraInfo", "Lorg/json/JSONObject;", "buildPublishArticleInfo", "callback", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "changeBottomLayoutEnabled", "enablePic", "enableVideo", "checkDataBeforePublish", "getCurrentDisplayItems", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "handleCoverSelectResult", "data", "Landroid/content/Intent;", "handleInteraction", "handleLocationResult", "handleVideoCropResult", "resultCode", "", "initAddToTopicWithData", "config", "initBaseConfigInEditText", "initContainerView", "view", "Landroid/view/View;", "initData", "initEditVideoSettingsLayout", "initKDCommunityLayoutWithData", "initLocationViewWithData", "initMediaDisplayLayout", "initMediaDisplayLayoutWithData", "initOriginTextInEditText", "initPrivacyLayoutWithData", "initRichEditText", "initRichEditTextWithData", "initRichEdtMenuViewWithData", "initScrollView", "initSelectPopupController", "initTitleBar", "initUploadVideoProgressBar", "initVideoCoverLayout", "initVideoPropertyWithData", "loadDefaultColumn", "onActivityResult", "requestCode", "onBackEvent", "onCoverDataUpdated", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "onPause", "onPreExit", "openSelectTopicView", "selectedTopicId", "", "selectTopicCallback", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "topicInfo", "publishArticle", "publishArticleInfo", "reportPublishUserAction", "eventId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "elementId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "showAtContactListView", "hasInputAtInEditText", "showExitDialog", "showLocationListView", "originLocationInfo", "showTopicListView", "updateLocationView", "locationInfo", "updatePrivacyTextView", "privacy", "updateRichEditTextMaxHeight", "updateTopicInfo", "updateTopicWordToObject", "startPos", "createBySpace", "tweetTopicItem", "Companion", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage
  extends BasePublishArticlePage
  implements QQPublishArticleContract.IPublishArticleView
{
  public static final PublishArticlePage.Companion a = new PublishArticlePage.Companion(null);
  private Map<String, String> A = (Map)new HashMap();
  private GlobalPublisherConfig B;
  private boolean C;
  private boolean D = true;
  private String E;
  private LocationInfo F;
  private CommunityInfo G;
  private SelectPopupController<TweetTopicItem> H;
  private Function1<? super Boolean, Unit> I;
  private final Runnable J;
  private ViewGroup c;
  private RelativeLayout d;
  private TextView e;
  private RichEditText f;
  private RichEditTextMenuView g;
  private MediaDisplayLayout h;
  private CustomScrollView i;
  private LinearLayout j;
  private TextView k;
  private TextView l;
  private LinearLayout m;
  private TextView n;
  private PrivacySettingDialog o;
  private AddToTopicLayout p;
  private LinearLayout q;
  private LinearLayout r;
  private LinearLayout s;
  private PublishVideoDeliverTypeLayout t;
  private TextView u;
  private TextView v;
  private RelativeLayout w;
  private BigVideoCoverLayout x;
  private UploadVideoProgressBar y;
  private final PublishArticlePresenter z = new PublishArticlePresenter((QQPublishArticleContract.IPublishArticleModel)new PublishArticleModel());
  
  public PublishArticlePage()
  {
    String str = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
    this.E = str;
    this.I = ((Function1)new PublishArticlePage.onPosPermissionCallback.1(this));
    this.J = ((Runnable)new PublishArticlePage.updateRichEditTextMaxHeightRunnable.1(this));
  }
  
  private final void a(int paramInt)
  {
    Object localObject = this.B;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localObject = ((GlobalPublisherConfig)localObject).getPrivacySettingConfig();
    TextView localTextView = this.n;
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
    int i1 = ((String)localObject1).length() + paramInt;
    if (paramInt >= 0)
    {
      Object localObject2 = this.f;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject2 = ((RichEditText)localObject2).getText();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "richEditText.text");
      if (Intrinsics.areEqual(((CharSequence)localObject2).subSequence(paramInt, i1).toString(), localObject1))
      {
        localObject1 = this.f;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        ((RichEditText)localObject1).getText().delete(paramInt, i1);
        localObject1 = this.f;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        ((RichEditText)localObject1).setSelection(paramInt);
        localObject1 = new EditObject(paramTweetTopicItem.c(), EditObject.EditObjectType.TYPE_TOPIC);
        ((EditObject)localObject1).setKey(paramTweetTopicItem.a());
        paramTweetTopicItem = RichEditTextEvent.a.a(2);
        localObject2 = this.f;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        ((RichEditText)localObject2).a((EditObject)localObject1, paramTweetTopicItem);
      }
    }
    paramTweetTopicItem = this.f;
    if (paramTweetTopicItem == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    paramInt = paramTweetTopicItem.getSelectionEnd();
    if (paramBoolean)
    {
      paramTweetTopicItem = this.f;
      if (paramTweetTopicItem == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      if (paramTweetTopicItem.getText().length() > paramInt)
      {
        paramTweetTopicItem = this.f;
        if (paramTweetTopicItem == null) {
          Intrinsics.throwUninitializedPropertyAccessException("richEditText");
        }
        if (paramTweetTopicItem.getText().charAt(paramInt) == ' ')
        {
          paramTweetTopicItem = this.f;
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
    Object localObject = b();
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
    int i1 = 0;
    if (paramIntent != null) {
      i1 = paramIntent.getIntExtra("from_page", 0);
    }
    float f1 = 0.0F;
    if (paramIntent != null) {
      f1 = paramIntent.getFloatExtra("initial_progress", 0.0F);
    }
    paramIntent = new CoverSelectData();
    paramIntent.setCoverPath(str);
    paramIntent.setCoverFrom(i1);
    paramIntent.setInitialProgress(f1);
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
        int i1 = 1;
        if (paramInt > 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mergePath");
          if (((CharSequence)paramIntent).length() > 0) {
            paramInt = i1;
          } else {
            paramInt = 0;
          }
          if (paramInt != 0) {
            this.A.put(str, paramIntent);
          }
        }
      }
    }
  }
  
  private final void a(View paramView)
  {
    paramView = paramView.findViewById(R.id.N);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.upload_video_progress_bar)");
    this.y = ((UploadVideoProgressBar)paramView);
    paramView = this.y;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("uploadVideoProgressBar");
    }
    GlobalPublisherConfig localGlobalPublisherConfig = this.B;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    paramView.a(localGlobalPublisherConfig, this.E);
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    if (paramGlobalPublisherConfig.getInputPanelConfig().getShowAtPanel())
    {
      localObject = this.g;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEdtMenuView");
      }
      ((RichEditTextMenuView)localObject).b(true);
      localObject = this.g;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEdtMenuView");
      }
      ((RichEditTextMenuView)localObject).setAddMentionBtnClickListener((View.OnClickListener)new PublishArticlePage.initRichEdtMenuViewWithData.1(this));
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_SELECT_AT);
    }
    else
    {
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject).setAtInputListener((Function0)null);
    }
    if (paramGlobalPublisherConfig.getInputPanelConfig().getShowTopicPanel())
    {
      paramGlobalPublisherConfig = this.g;
      if (paramGlobalPublisherConfig == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEdtMenuView");
      }
      paramGlobalPublisherConfig.a(true);
      paramGlobalPublisherConfig = this.g;
      if (paramGlobalPublisherConfig == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEdtMenuView");
      }
      paramGlobalPublisherConfig.setAddTopicBtnClickListener((View.OnClickListener)new PublishArticlePage.initRichEdtMenuViewWithData.2(this));
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_SELECT_TOPIC);
    }
    paramGlobalPublisherConfig = this.g;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEdtMenuView");
    }
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    int i1 = ((RichEditText)localObject).getText().length();
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    paramGlobalPublisherConfig.a(i1, ((RichEditText)localObject).getCountLimit());
  }
  
  private final void a(LocationInfo paramLocationInfo)
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      Object localObject1 = this.f;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject1).clearFocus();
      localObject1 = InputMethodUtils.a;
      Context localContext = (Context)localActivity;
      Object localObject2 = this.j;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
      }
      localObject2 = ((LinearLayout)localObject2).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "addLocationView.windowToken");
      ((InputMethodUtils)localObject1).a(localContext, (IBinder)localObject2);
      TopicSDKHelperKt.c().a(localActivity, paramLocationInfo, (Function1)new PublishArticlePage.showLocationListView.1(this));
    }
  }
  
  private final void a(PublishArticleInfo paramPublishArticleInfo)
  {
    PublishArticlePresenter localPublishArticlePresenter = this.z;
    GlobalPublisherConfig localGlobalPublisherConfig = this.B;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticlePresenter.a(localGlobalPublisherConfig, paramPublishArticleInfo);
  }
  
  private final void a(TopicInfo paramTopicInfo)
  {
    Object localObject = this.p;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    localObject = ((AddToTopicLayout)localObject).getSelectedTopic();
    long l1;
    if (localObject != null) {
      l1 = ((TopicInfo)localObject).getTopicId();
    } else {
      l1 = 0L;
    }
    localObject = paramTopicInfo;
    if (l1 == paramTopicInfo.getTopicId()) {
      localObject = null;
    }
    paramTopicInfo = this.p;
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
  
  private final void a(Function1<? super PublishArticleInfo, Unit> paramFunction1)
  {
    PublishArticleInfo localPublishArticleInfo = new PublishArticleInfo();
    localPublishArticleInfo.setPublishId(this.E);
    Object localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localObject1 = ((RichEditText)localObject1).getDataList();
    boolean bool = ((ArrayList)localObject1).isEmpty();
    int i2 = 0;
    Object localObject2;
    if (bool)
    {
      localObject2 = this.B;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      if (((CharSequence)((GlobalPublisherConfig)localObject2).getDefaultPublishText()).length() > 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        localObject2 = this.B;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
        }
        ((ArrayList)localObject1).add(new EditObject(((GlobalPublisherConfig)localObject2).getDefaultPublishText(), null, 2, null));
      }
    }
    localPublishArticleInfo.setContentList((List)localObject1);
    localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localPublishArticleInfo.setContentLength(((RichEditText)localObject1).getText().length());
    localObject1 = this.p;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    localObject1 = ((AddToTopicLayout)localObject1).getSelectedTopic();
    long l1;
    if (localObject1 != null) {
      l1 = ((TopicInfo)localObject1).getTopicId();
    } else {
      l1 = 0L;
    }
    localPublishArticleInfo.setTopicId(l1);
    localObject1 = this.G;
    if (localObject1 != null)
    {
      localPublishArticleInfo.setCommunityId(((CommunityInfo)localObject1).getCommunityId());
      localPublishArticleInfo.setCommunityName(((CommunityInfo)localObject1).getTitle());
    }
    localObject1 = this.B;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setScene(((GlobalPublisherConfig)localObject1).getScene());
    localObject1 = this.B;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setPublishScene(((GlobalPublisherConfig)localObject1).getPublishScene());
    localObject1 = this.B;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setCircleId(((GlobalPublisherConfig)localObject1).getCircleId());
    localPublishArticleInfo.setFromDraft(this.C);
    localPublishArticleInfo.setLocationInfo(this.F);
    localObject1 = this.B;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setPrivacySetting(((GlobalPublisherConfig)localObject1).getPrivacySettingConfig().getPrivacySetting());
    localPublishArticleInfo.initMediaByDisplayItems(dN_());
    localObject1 = localPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      localObject2 = this.y;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("uploadVideoProgressBar");
      }
      ((VideoInfo)localObject1).setCoverUrl(((UploadVideoProgressBar)localObject2).getUploadedCoverUrl());
    }
    localObject1 = localPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      if (this.D) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ((VideoInfo)localObject1).setCoverFrom(i1);
    }
    localObject1 = this.B;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localPublishArticleInfo.setShowPublishToast(((GlobalPublisherConfig)localObject1).getShowPublishToast());
    localObject1 = this.t;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverTypeLayout");
    }
    localObject1 = ((PublishVideoDeliverTypeLayout)localObject1).getDeliverType();
    int i3 = PublishArticlePage.WhenMappings.$EnumSwitchMapping$1[localObject1.ordinal()];
    int i1 = i2;
    if (i3 != 1) {
      if (i3 != 2)
      {
        if (i3 == 3) {
          i1 = 2;
        } else {
          throw new NoWhenBranchMatchedException();
        }
      }
      else {
        i1 = 1;
      }
    }
    localPublishArticleInfo.setPublishType(i1);
    localObject1 = this.t;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverTypeLayout");
    }
    localPublishArticleInfo.setAllowReprint(((PublishVideoDeliverTypeLayout)localObject1).getProhibitReprint() ^ true);
    ThreadManagerKt.b((Function0)new PublishArticlePage.buildPublishArticleInfo.1(localPublishArticleInfo, paramFunction1));
  }
  
  private final void a(boolean paramBoolean)
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      Object localObject1 = this.f;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject1).clearFocus();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isSoftInputActive", InputMethodUtils.a.a(localActivity));
      InputMethodUtils localInputMethodUtils = InputMethodUtils.a;
      Context localContext = (Context)localActivity;
      Object localObject2 = this.f;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject2 = ((RichEditText)localObject2).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "richEditText.windowToken");
      localInputMethodUtils.a(localContext, (IBinder)localObject2);
      TopicSDKHelperKt.c().a(localActivity, (Bundle)localObject1, (Function2)new PublishArticlePage.showAtContactListView.1(this, paramBoolean, localActivity));
    }
  }
  
  private final void b(View paramView)
  {
    Object localObject = b();
    if (localObject != null)
    {
      PermissionUtils localPermissionUtils = PermissionUtils.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      localPermissionUtils.b((Activity)localObject, this.I);
    }
    localObject = paramView.findViewById(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.add_location_layout)");
    this.j = ((LinearLayout)localObject);
    localObject = paramView.findViewById(R.id.E);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_add_location)");
    this.k = ((TextView)localObject);
    localObject = paramView.findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.add_location_hint)");
    this.l = ((TextView)localObject);
    localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.2(this));
    b(this.F);
    localObject = paramView.findViewById(R.id.u);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.ll_privacy_setting)");
    this.m = ((LinearLayout)localObject);
    localObject = paramView.findViewById(R.id.K);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_privacy_setting)");
    this.n = ((TextView)localObject);
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privacyLayout");
    }
    ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.3(this));
    localObject = b();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity!!");
    localObject = new PrivacySettingDialog((Context)localObject);
    ((PrivacySettingDialog)localObject).a((Function1)new PublishArticlePage.initEditVideoSettingsLayout..inlined.apply.lambda.1(this));
    this.o = ((PrivacySettingDialog)localObject);
    localObject = paramView.findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.addToTopicLayout)");
    this.p = ((AddToTopicLayout)localObject);
    localObject = paramView.findViewById(R.id.s);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.ll_add_topic)");
    this.q = ((LinearLayout)localObject);
    localObject = this.p;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    ((AddToTopicLayout)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.5(this));
    localObject = paramView.findViewById(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.addKDCommunityLayout)");
    this.r = ((LinearLayout)localObject);
    localObject = paramView.findViewById(R.id.C);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.selectedCommunityView)");
    this.u = ((TextView)localObject);
    localObject = this.r;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
    }
    ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initEditVideoSettingsLayout.6(this));
    localObject = paramView.findViewById(R.id.k);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.deliver_type_layout)");
    this.s = ((LinearLayout)localObject);
    paramView = paramView.findViewById(R.id.A);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.publish_video_deliver_type)");
    this.t = ((PublishVideoDeliverTypeLayout)paramView);
  }
  
  private final void b(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    c(paramGlobalPublisherConfig);
    d(paramGlobalPublisherConfig);
    e(paramGlobalPublisherConfig);
    f(paramGlobalPublisherConfig);
  }
  
  private final void b(LocationInfo paramLocationInfo)
  {
    if (paramLocationInfo == null)
    {
      paramLocationInfo = this.k;
      if (paramLocationInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addLocationTextView");
      }
      paramLocationInfo.setText(R.string.a);
      paramLocationInfo = this.l;
      if (paramLocationInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addLocationHint");
      }
      paramLocationInfo.setText(R.string.b);
      return;
    }
    TextView localTextView = this.k;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationTextView");
    }
    localTextView.setText((CharSequence)paramLocationInfo.getName());
    paramLocationInfo = this.l;
    if (paramLocationInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationHint");
    }
    paramLocationInfo.setText((CharSequence)"");
  }
  
  private final void c(View paramView)
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      paramView = paramView.findViewById(R.id.t);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.ll_container_view)");
      paramView = (LinearLayout)paramView;
      paramView.setOnClickListener((View.OnClickListener)new PublishArticlePage.initContainerView.1(this, localActivity, paramView));
    }
  }
  
  private final void c(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    LinearLayout localLinearLayout = this.j;
    if (localLinearLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    boolean bool = paramGlobalPublisherConfig.getShowAddLocation();
    int i2 = 0;
    if (bool) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localLinearLayout.setVisibility(i1);
    paramGlobalPublisherConfig = this.j;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addLocationView");
    }
    int i1 = i2;
    if (((View)paramGlobalPublisherConfig).getVisibility() == 0) {
      i1 = 1;
    }
    if (i1 != 0) {
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_ADD_LOCATION);
    }
  }
  
  private final void d(View paramView)
  {
    ((TextView)paramView.findViewById(R.id.H)).setOnClickListener((View.OnClickListener)new PublishArticlePage.initTitleBar.1(this));
    Object localObject = paramView.findViewById(R.id.L);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_publish)");
    this.v = ((TextView)localObject);
    localObject = this.v;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("publishButton");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new PublishArticlePage.initTitleBar.2(this));
    localObject = paramView.findViewById(R.id.D);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.titleBar)");
    this.d = ((RelativeLayout)localObject);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    }
    ((RelativeLayout)localObject).setOnLongClickListener((View.OnLongClickListener)PublishArticlePage.initTitleBar.3.a);
    paramView = paramView.findViewById(R.id.J);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_navigation)");
    this.e = ((TextView)paramView);
  }
  
  private final void d(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privacyLayout");
    }
    int i1;
    if (paramGlobalPublisherConfig.getShowPrivacySetting()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((LinearLayout)localObject).setVisibility(i1);
    a(paramGlobalPublisherConfig.getPrivacySettingConfig().getPrivacySetting());
    localObject = this.o;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privacySettingDialog");
    }
    ((PrivacySettingDialog)localObject).a(paramGlobalPublisherConfig.getPrivacySettingConfig());
  }
  
  private final void e(View paramView)
  {
    paramView = paramView.findViewById(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.et_scrollview)");
    this.i = ((CustomScrollView)paramView);
  }
  
  private final void e(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject = this.q;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLinear");
    }
    int i1;
    if (paramGlobalPublisherConfig.getShowAddToTopic()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((LinearLayout)localObject).setVisibility(i1);
    localObject = this.p;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
    }
    ((AddToTopicLayout)localObject).a(paramGlobalPublisherConfig.getAddToTopicConfig());
    if (paramGlobalPublisherConfig.getAddToTopicConfig().getDisableSelectTopic())
    {
      localObject = this.p;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addToTopicLayout");
      }
      ((AddToTopicLayout)localObject).setOnClickListener(null);
    }
    if (paramGlobalPublisherConfig.getShowDefaultColumn()) {
      w();
    }
  }
  
  private final void f(View paramView)
  {
    View localView = paramView.findViewById(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.et_content)");
    this.f = ((RichEditText)localView);
    paramView = paramView.findViewById(R.id.B);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.rich_edt_menu_view)");
    this.g = ((RichEditTextMenuView)paramView);
    paramView = b();
    if (paramView != null)
    {
      paramView = paramView.getWindow();
      if (paramView != null) {
        paramView.setSoftInputMode(2);
      }
    }
    paramView = this.f;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    paramView.setCountChangeListener((Function1)new PublishArticlePage.initRichEditText.1(this));
  }
  
  private final void f(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject;
    if (paramGlobalPublisherConfig.getShowCommunitySelector())
    {
      a(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_DELIVER_TO_KD_COMMUNITY);
      localObject = this.r;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
      }
      ((LinearLayout)localObject).setVisibility(0);
    }
    else
    {
      localObject = this.r;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
      }
      ((LinearLayout)localObject).setVisibility(8);
    }
    if (paramGlobalPublisherConfig.getCommunityInfo() != null)
    {
      localObject = paramGlobalPublisherConfig.getCommunityInfo();
      if (localObject != null)
      {
        localObject = ((CommunityInfo)localObject).getCommunityId();
        if (localObject != null)
        {
          int i1;
          if (((CharSequence)localObject).length() > 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 == 1)
          {
            this.G = paramGlobalPublisherConfig.getCommunityInfo();
            paramGlobalPublisherConfig = this.r;
            if (paramGlobalPublisherConfig == null) {
              Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
            }
            paramGlobalPublisherConfig.setClickable(false);
            paramGlobalPublisherConfig = this.r;
            if (paramGlobalPublisherConfig == null) {
              Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
            }
            paramGlobalPublisherConfig.setEnabled(false);
            localObject = this.u;
            if (localObject == null) {
              Intrinsics.throwUninitializedPropertyAccessException("selectedCommunityView");
            }
            paramGlobalPublisherConfig = this.G;
            if (paramGlobalPublisherConfig != null) {
              paramGlobalPublisherConfig = paramGlobalPublisherConfig.getTitle();
            } else {
              paramGlobalPublisherConfig = null;
            }
            ((TextView)localObject).setText((CharSequence)paramGlobalPublisherConfig);
            return;
          }
        }
      }
    }
    paramGlobalPublisherConfig = this.r;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
    }
    paramGlobalPublisherConfig.setClickable(true);
    paramGlobalPublisherConfig = this.r;
    if (paramGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addKDCommunityLayout");
    }
    paramGlobalPublisherConfig.setEnabled(true);
    paramGlobalPublisherConfig = b();
    if (paramGlobalPublisherConfig != null)
    {
      localObject = this.u;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectedCommunityView");
      }
      ((TextView)localObject).setText((CharSequence)paramGlobalPublisherConfig.getString(R.string.d));
    }
  }
  
  private final void g(View paramView)
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      View localView = paramView.findViewById(R.id.O);
      Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.video_cover_layout)");
      this.w = ((RelativeLayout)localView);
      paramView = paramView.findViewById(R.id.e);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.big_video_cover_layout)");
      this.x = ((BigVideoCoverLayout)paramView);
      paramView = this.x;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
      }
      paramView.setOnItemClickListener((Function1)new PublishArticlePage.initVideoCoverLayout.1(localActivity));
      paramView = this.x;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
      }
      paramView.setOnChangeCoverClickListener((Function1)new PublishArticlePage.initVideoCoverLayout.2(this));
    }
  }
  
  private final void g(GlobalPublisherConfig paramGlobalPublisherConfig)
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
      localObject = this.w;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCoverContainer");
      }
      ((RelativeLayout)localObject).setVisibility(0);
      localObject = this.x;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
      }
      ((BigVideoCoverLayout)localObject).setDisplayItem(paramGlobalPublisherConfig);
    }
  }
  
  private final void h(View paramView)
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      paramView = paramView.findViewById(R.id.v);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.media_display_layout)");
      this.h = ((MediaDisplayLayout)paramView);
      paramView = this.h;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      paramView.setOnItemClickListener((Function1)new PublishArticlePage.initMediaDisplayLayout.1(this, localActivity));
      paramView = this.h;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      paramView.setOnScrollListener((Function0)new PublishArticlePage.initMediaDisplayLayout.2(this, localActivity));
    }
  }
  
  private final void n()
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      KeyBoardChangeListener.a.a(localActivity).a((KeyBoardChangeListener.KeyboardListener)new PublishArticlePage.handleInteraction..inlined.apply.lambda.1(this));
    }
  }
  
  private final boolean o()
  {
    Object localObject = this.s;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverTypeLayoutContainer");
    }
    if (((LinearLayout)localObject).getVisibility() == 0)
    {
      localObject = this.t;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverTypeLayout");
      }
      if (((PublishVideoDeliverTypeLayout)localObject).getDeliverType() == PublishVideoDeliverTypeLayout.DeliverType.Default)
      {
        localObject = b();
        if (localObject != null)
        {
          localObject = ((Activity)localObject).getString(R.string.h);
          if (localObject != null) {
            TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
          }
        }
        return false;
      }
    }
    return true;
  }
  
  private final boolean p()
  {
    if (dM_())
    {
      q();
      return false;
    }
    PublishManager.a.b();
    a(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_CANCEL_NO_DIALOG);
    return true;
  }
  
  private final void q()
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      CommonDialogBuilder.b(new CommonDialogBuilder((Context)localActivity).a(localActivity.getResources().getString(R.string.j)).a(localActivity.getResources().getString(R.string.c), (CommonDialogBuilder.ICommonDialogListener)new PublishArticlePage.showExitDialog.1(this, localActivity)), localActivity.getResources().getString(R.string.i), null, 2, null).b(localActivity.getResources().getColor(R.color.a)).a().show();
    }
  }
  
  private final void r()
  {
    ViewGroup localViewGroup = this.c;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localViewGroup.removeCallbacks(this.J);
    localViewGroup = this.c;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localViewGroup.post(this.J);
  }
  
  private final void s()
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
    this.B = ((GlobalPublisherConfig)localObject1);
    localObject1 = this.B;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    Object localObject2 = this.e;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("navigationBarView");
    }
    ((TextView)localObject2).setText((CharSequence)((GlobalPublisherConfig)localObject1).getNavigationBarText());
    t();
    a((GlobalPublisherConfig)localObject1);
    localObject2 = ((GlobalPublisherConfig)localObject1).getTopicInfo();
    if (localObject2 != null) {
      a((TopicInfo)localObject2);
    }
    b((GlobalPublisherConfig)localObject1);
    r();
    PublishManager.a.a(((GlobalPublisherConfig)localObject1).getMaxImageSize());
    g((GlobalPublisherConfig)localObject1);
    x();
    localObject2 = this.f;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    ((RichEditText)localObject2).setEditObjectListener((EditObjectListener)this);
    if (((GlobalPublisherConfig)localObject1).getShowDeliverType())
    {
      localObject1 = this.s;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverTypeLayoutContainer");
      }
      ((LinearLayout)localObject1).setVisibility(0);
      return;
    }
    localObject1 = this.s;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverTypeLayoutContainer");
    }
    ((LinearLayout)localObject1).setVisibility(8);
  }
  
  private final void t()
  {
    u();
    v();
    RichEditText localRichEditText = this.f;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setAtInputListener((Function0)new PublishArticlePage.initRichEditTextWithData.1(this));
  }
  
  private final void u()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = this.B;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    RichEditText localRichEditText = this.f;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setCountLimit(localGlobalPublisherConfig.getContentUpperLimit());
    localRichEditText = this.f;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setNeedTextTruncation(localGlobalPublisherConfig.getNeedTextTruncation());
    localRichEditText = this.f;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setHint((CharSequence)localGlobalPublisherConfig.getPlaceHolder());
    localRichEditText = this.f;
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
    localRichEditText = this.f;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.setAllowDeletedTopic(localGlobalPublisherConfig.getAllowDeleteTweetTopic());
  }
  
  private final void v()
  {
    Object localObject = this.B;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localObject = ((Iterable)((GlobalPublisherConfig)localObject).getEditObjectListByOriginText()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EditObject localEditObject = (EditObject)((Iterator)localObject).next();
      JSONObject localJSONObject = RichEditTextEvent.a.a(0);
      RichEditText localRichEditText = this.f;
      if (localRichEditText == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localRichEditText.a(localEditObject, localJSONObject);
    }
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEdtMenuView");
    }
    ((RichEditTextMenuView)localObject).post((Runnable)new PublishArticlePage.initOriginTextInEditText.2(this));
  }
  
  private final void w()
  {
    new SelectTopicModel().a(false, (Function6)new PublishArticlePage.loadDefaultColumn.1(this));
  }
  
  private final void x()
  {
    Object localObject1 = b();
    if (localObject1 != null)
    {
      Object localObject2 = this.B;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      if (!((GlobalPublisherConfig)localObject2).getAllowCreateTweetTopic()) {
        return;
      }
      localObject2 = SelectPopupController.a;
      RichEditText localRichEditText = this.f;
      if (localRichEditText == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject1 = ((SelectPopupController.Companion)localObject2).a((Activity)localObject1, localRichEditText, (ISelectPopupModel)new SelectTweetTopicPopupModel());
      ((SelectPopupController)localObject1).a((Function3)new PublishArticlePage.initSelectPopupController..inlined.also.lambda.1(this));
      ((SelectPopupController)localObject1).a((Function1)new PublishArticlePage.initSelectPopupController..inlined.also.lambda.2(this));
      this.H = ((SelectPopupController)localObject1);
    }
  }
  
  private final void y()
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      Object localObject1 = this.f;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      ((RichEditText)localObject1).clearFocus();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isSoftInputActive", InputMethodUtils.a.a(localActivity));
      Object localObject2 = this.B;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
      }
      ((Bundle)localObject1).putBoolean("allow_create_tweet_topic", ((GlobalPublisherConfig)localObject2).getAllowCreateTweetTopic());
      localObject2 = InputMethodUtils.a;
      Context localContext = (Context)localActivity;
      Object localObject3 = this.f;
      if (localObject3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("richEditText");
      }
      localObject3 = ((RichEditText)localObject3).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "richEditText.windowToken");
      ((InputMethodUtils)localObject2).a(localContext, (IBinder)localObject3);
      TopicSDKHelperKt.c().b(localActivity, (Bundle)localObject1, (Function2)new PublishArticlePage.showTopicListView.1(this, localActivity));
    }
  }
  
  private final void z()
  {
    Object localObject = b();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getResources();
      if (localObject != null)
      {
        localObject = ((Resources)localObject).getString(R.string.s);
        break label31;
      }
    }
    localObject = null;
    label31:
    if ((localObject != null) && (localObject != null)) {
      TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
    }
  }
  
  @NotNull
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    this.z.a((QQPublishArticleContract.IPublishArticleView)this);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.a, paramViewGroup, false);
    if (paramLayoutInflater != null)
    {
      this.c = ((ViewGroup)paramLayoutInflater);
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      c((View)paramLayoutInflater);
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      d((View)paramLayoutInflater);
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      e((View)paramLayoutInflater);
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      f((View)paramLayoutInflater);
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      g((View)paramLayoutInflater);
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      h((View)paramLayoutInflater);
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      b((View)paramLayoutInflater);
      n();
      s();
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      a((View)paramLayoutInflater);
      paramLayoutInflater = this.c;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      return (View)paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
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
      z();
    }
  }
  
  public void a(@NotNull CoverSelectData paramCoverSelectData)
  {
    Intrinsics.checkParameterIsNotNull(paramCoverSelectData, "data");
    Object localObject = this.x;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
    }
    localObject = ((BigVideoCoverLayout)localObject).getDisplayItem();
    if (localObject != null)
    {
      int i1 = ((CharSequence)paramCoverSelectData.getCoverPath()).length();
      int i2 = 1;
      if (i1 > 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 != 0) && (((DisplayItem)localObject).getMedia().getType() == MediaType.VIDEO)) {
        i1 = i2;
      } else {
        i1 = 0;
      }
      if (i1 == 0) {
        return;
      }
      ((DisplayItem)localObject).setCoverPath(paramCoverSelectData.getCoverPath());
      ((DisplayItem)localObject).setFromPage(paramCoverSelectData.getCoverFrom());
      float f1;
      if (paramCoverSelectData.getCoverFrom() == 0) {
        f1 = paramCoverSelectData.getInitialProgress();
      } else {
        f1 = 0.0F;
      }
      ((DisplayItem)localObject).setInitialProgress(f1);
      this.D = false;
      paramCoverSelectData = this.x;
      if (paramCoverSelectData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
      }
      paramCoverSelectData.setDisplayItem((DisplayItem)localObject);
      paramCoverSelectData = this.y;
      if (paramCoverSelectData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("uploadVideoProgressBar");
      }
      paramCoverSelectData.a((DisplayItem)localObject);
    }
  }
  
  public void a(@NotNull EditObject paramEditObject, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObject, "editObject");
    paramJSONObject = b();
    if ((paramJSONObject != null) && (paramJSONObject != null))
    {
      paramEditObject = paramEditObject.getType();
      int i1 = PublishArticlePage.WhenMappings.$EnumSwitchMapping$0[paramEditObject.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          TLog.d("PublishArticleFragment", "addRichEditObjectFailed invalid editObject type.");
          return;
        }
        paramEditObject = paramJSONObject.getResources().getString(R.string.u);
        Intrinsics.checkExpressionValueIsNotNull(paramEditObject, "resources.getString(R.st…tle_out_of_limit_tips_at)");
        TopicSDKHelperKt.a(paramEditObject, false, null, 6, null);
        return;
      }
      paramEditObject = paramJSONObject.getResources().getString(R.string.t);
      Intrinsics.checkExpressionValueIsNotNull(paramEditObject, "resources.getString(R.st…_title_out_of_limit_tips)");
      TopicSDKHelperKt.a(paramEditObject, false, null, 6, null);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean dM_()
  {
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localObject = ((RichEditText)localObject).getText();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "richEditText.text");
    int i1 = ((CharSequence)localObject).length();
    boolean bool2 = true;
    if (i1 > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1 = bool2;
    if (i1 == 0)
    {
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
      }
      bool1 = bool2;
      if (((MediaDisplayLayout)localObject).getDisplayItems().size() <= 0)
      {
        localObject = this.x;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
        }
        if (((BigVideoCoverLayout)localObject).getDisplayItem() != null) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  @NotNull
  public ArrayList<DisplayItem> dN_()
  {
    Object localObject = this.x;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bigVideoCoverLayout");
    }
    localObject = ((BigVideoCoverLayout)localObject).getDisplayItem();
    if (localObject != null) {
      return CollectionsKt.arrayListOf(new DisplayItem[] { localObject });
    }
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaDisplayLayout");
    }
    return ((MediaDisplayLayout)localObject).getDisplayItems();
  }
  
  public boolean e()
  {
    SelectPopupController localSelectPopupController = this.H;
    boolean bool = true;
    if ((localSelectPopupController != null) && (localSelectPopupController.b()))
    {
      localSelectPopupController = this.H;
      if (localSelectPopupController != null)
      {
        localSelectPopupController.a(2);
        return true;
      }
    }
    else
    {
      if (!p()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void f()
  {
    this.z.a();
    TopicSDK.a.a().a();
    UiComponentSdk.a.a().d();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage
 * JD-Core Version:    0.7.0.1
 */