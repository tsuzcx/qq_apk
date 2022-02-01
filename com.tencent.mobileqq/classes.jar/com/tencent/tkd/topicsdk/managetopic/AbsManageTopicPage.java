package com.tencent.tkd.topicsdk.managetopic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.ManageTopicConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.bean.TopicPublishInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.FileProvideHelper;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.common.PictureUtil;
import com.tencent.tkd.topicsdk.common.report.ReportKeys;
import com.tencent.tkd.topicsdk.common.report.ReportValues;
import com.tencent.tkd.topicsdk.framework.BaseSDKPage;
import com.tencent.tkd.topicsdk.framework.ImageLoader;
import com.tencent.tkd.topicsdk.framework.ImageLoader.Companion;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.Uploader;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader.UploaderType;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter.ACTION;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.widget.LimitWordEditText;
import com.tencent.tkd.topicsdk.widget.SlidingUpDialog;
import com.tencent.tkd.topicsdk.widget.dialog.CommonProgressDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/AbsManageTopicPage;", "Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicView;", "Landroid/view/View$OnClickListener;", "()V", "addCoverTipView", "Landroid/widget/TextView;", "allowSubmitArrowView", "Landroid/widget/ImageView;", "allowSubmitContainer", "Landroid/view/View;", "allowSubmitDescView", "allowSubmitTitle", "", "allowSubmitTitleView", "callback", "getCallback", "()Ljava/lang/String;", "setCallback", "(Ljava/lang/String;)V", "cameraIconView", "changeCoverTipView", "coverImageView", "coverPath", "cropPicFile", "Ljava/io/File;", "currentAllowSubmit", "", "getCurrentAllowSubmit", "()Z", "setCurrentAllowSubmit", "(Z)V", "currentCoverUrl", "getCurrentCoverUrl", "setCurrentCoverUrl", "forbidSubmitArrowView", "forbidSubmitContainer", "forbidSubmitDescView", "forbidSubmitTitle", "forbidSubmitTitleView", "hasEditIntro", "getHasEditIntro", "hasSelectCover", "getHasSelectCover", "imageLoader", "Lcom/tencent/tkd/topicsdk/framework/ImageLoader;", "imageUploader", "Lcom/tencent/tkd/topicsdk/framework/Uploader;", "presenter", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicPresenter;", "getPresenter", "()Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicPresenter;", "publishingDialog", "Lcom/tencent/tkd/topicsdk/widget/dialog/CommonProgressDialog;", "scene", "getScene", "setScene", "submitDialog", "Lcom/tencent/tkd/topicsdk/widget/SlidingUpDialog;", "submitTextView", "tempPicFileForCrop", "titleCenterView", "getTitleCenterView", "()Landroid/widget/TextView;", "setTitleCenterView", "(Landroid/widget/TextView;)V", "titleLeftView", "titleRightView", "getTitleRightView", "setTitleRightView", "topicIntroView", "Lcom/tencent/tkd/topicsdk/widget/LimitWordEditText;", "getTopicIntroView", "()Lcom/tencent/tkd/topicsdk/widget/LimitWordEditText;", "setTopicIntroView", "(Lcom/tencent/tkd/topicsdk/widget/LimitWordEditText;)V", "topicTitleView", "getTopicTitleView", "setTopicTitleView", "uploadingCoverDialog", "urlMap", "", "afterActivityFinish", "", "bindTopicData", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "buildPublishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "buildPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "buildTopicPublishInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicPublishInfo;", "cutPicture", "path", "fixBlackBlockByInputMethod", "handleCoverLayoutWithExistCover", "handleCoverLayoutWithNoCover", "handleCoverViewClick", "handleLeftBtnClick", "handleRightClick", "hidePublishLoadingProgress", "hideUploadLoadingProgress", "initCoverView", "contentView", "initData", "initProgressDialog", "initSubmitDialog", "submitView", "initTextView", "initTitleBarView", "isModified", "isRightBtnClickable", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCoverUploaded", "url", "localPath", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onTopicCreated", "isSuccess", "onTopicEdited", "reportTopicResultReturn", "type", "showPublishLoadingProgress", "showSaveDialog", "showTips", "tipsId", "tips", "showUploadLoadingProgress", "updateActionBtnStatus", "updateCoverLayout", "updateCoverPath", "updateSubmitStatus", "allowSubmit", "updateSubmitUIByConfig", "config", "Lcom/tencent/tkd/topicsdk/bean/ManageTopicConfig;", "updateUIByConfig", "updateViewElement", "uploadAndUpdateCover", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract class AbsManageTopicPage
  extends BaseSDKPage
  implements View.OnClickListener, ManageTopicContract.IManageTopicView
{
  public static final AbsManageTopicPage.Companion a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  public TextView a;
  private ImageLoader jdField_a_of_type_ComTencentTkdTopicsdkFrameworkImageLoader;
  private Uploader jdField_a_of_type_ComTencentTkdTopicsdkFrameworkUploader;
  @NotNull
  private final ManageTopicPresenter jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter = new ManageTopicPresenter((ManageTopicContract.IManageTopicModel)new ManageTopicModel());
  @NotNull
  public LimitWordEditText a;
  private SlidingUpDialog jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog;
  private CommonProgressDialog jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
  private File jdField_a_of_type_JavaIoFile;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  private Map<String, String> jdField_a_of_type_JavaUtilMap = (Map)new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  @NotNull
  public TextView b;
  @NotNull
  public LimitWordEditText b;
  private CommonProgressDialog jdField_b_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
  private File jdField_b_of_type_JavaIoFile;
  private String jdField_b_of_type_JavaLangString = "";
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_e_of_type_JavaLangString = "";
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkManagetopicAbsManageTopicPage$Companion = new AbsManageTopicPage.Companion(null);
  }
  
  private final void a(View paramView)
  {
    Object localObject = a();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity!!");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog = new SlidingUpDialog((Context)localObject, paramView, new RelativeLayout.LayoutParams(-1, -2));
    localObject = paramView.findViewById(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.allow_submit_title)");
    this.f = ((TextView)localObject);
    localObject = paramView.findViewById(R.id.j);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.allow_submit_content)");
    this.g = ((TextView)localObject);
    localObject = paramView.findViewById(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.allow_submit_select_view)");
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    localObject = paramView.findViewById(R.id.k);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.allow_submit_layout)");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("allowSubmitContainer");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = paramView.findViewById(R.id.aa);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.forbid_submit_title)");
    this.h = ((TextView)localObject);
    localObject = paramView.findViewById(R.id.X);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.forbid_submit_content)");
    this.i = ((TextView)localObject);
    localObject = paramView.findViewById(R.id.Z);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.forbid_submit_select_view)");
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    paramView = paramView.findViewById(R.id.Y);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "findViewById(R.id.forbid_submit_layout)");
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramView = this.jdField_b_of_type_AndroidViewView;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("forbidSubmitContainer");
    }
    paramView.setOnClickListener((View.OnClickListener)this);
  }
  
  private final void a(TopicInfo paramTopicInfo, boolean paramBoolean, String paramString)
  {
    Map localMap = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter.a(this.jdField_a_of_type_JavaLangString, h(), g());
    localMap.put(ReportKeys.a.h(), paramString);
    localMap.put(ReportKeys.a.i(), String.valueOf(paramTopicInfo.getTopicId()));
    if (paramBoolean)
    {
      TopicSDKHelperKt.a(IDataReporter.ACTION.ACTION_SUCCESS_TOPIC, localMap, null, 4, null);
      return;
    }
    TopicSDKHelperKt.a(IDataReporter.ACTION.ACTION_FAIL_TOPIC, localMap, null, 4, null);
  }
  
  private final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter.a(paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
    SlidingUpDialog localSlidingUpDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog;
    if (localSlidingUpDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("submitDialog");
    }
    if (localSlidingUpDialog.isShowing())
    {
      localSlidingUpDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog;
      if (localSlidingUpDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("submitDialog");
      }
      localSlidingUpDialog.dismiss();
    }
  }
  
  private final void b(View paramView)
  {
    Object localObject = paramView.findViewById(R.id.as);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById(R.id.iv_title_left_btn)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleLeftView");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = paramView.findViewById(R.id.bO);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById(R.id.tv_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleCenterView");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    paramView = paramView.findViewById(R.id.bP);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "contentView.findViewById(R.id.tv_title_right_btn)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView);
    paramView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleRightView");
    }
    paramView.setOnClickListener((View.OnClickListener)this);
  }
  
  private final void b(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      j = 1;
      if (j != 0) {
        break label158;
      }
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkUploader;
      if (localObject != null) {
        ((Uploader)localObject).c();
      }
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkUploader;
      if (localObject == null) {
        break label148;
      }
      localObject = ((Uploader)localObject).a();
      label51:
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label153;
      }
    }
    label148:
    label153:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ThreadManagerKt.c((Function0)new AbsManageTopicPage.uploadAndUpdateCover.1((String)localObject));
      }
      localObject = TopicSDK.a.a().a().a().a(BaseUploader.UploaderType.IMAGE);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "TopicSDK.instance().topi…oader.UploaderType.IMAGE)");
      localObject = new Uploader(paramString, (BaseUploader)localObject);
      this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter.a((Uploader)localObject, paramString);
      this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkUploader = ((Uploader)localObject);
      return;
      j = 0;
      break;
      localObject = null;
      break label51;
    }
    label158:
    TLog.a("AbsManageTopicPage", "onActivityResult,REQUEST_CODE_CUT_PHOTO cutPath = null");
  }
  
  private final void c(View paramView)
  {
    Activity localActivity = a();
    Object localObject;
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      ((RelativeLayout)paramView.findViewById(R.id.bc)).setOnClickListener((View.OnClickListener)this);
      paramView = paramView.findViewById(R.id.ao);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "contentView.findViewById(R.id.iv_cover)");
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView);
      paramView = ImageLoader.a.a((Context)localActivity, TopicSDK.a.a().a().a()).a(DisplayUtils.a.a((Context)localActivity, 12.0F));
      localObject = localActivity.getResources();
      if (localObject == null) {
        break label194;
      }
    }
    label194:
    for (int j = ((Resources)localObject).getColor(R.color.d);; j = 15988215)
    {
      paramView = paramView.a((Drawable)new ColorDrawable(j));
      localObject = this.jdField_c_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverImageView");
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkImageLoader = paramView.a((ImageView)localObject).a(DisplayUtils.a.a((Context)localActivity, 150.0F), DisplayUtils.a.a((Context)localActivity, 150.0F));
      d("");
      return;
    }
  }
  
  private final void c(String paramString)
  {
    Activity localActivity = a();
    if (localActivity != null) {
      if (Build.VERSION.SDK_INT < 24) {
        break label73;
      }
    }
    label73:
    for (paramString = FileProvideHelper.a((Context)localActivity, TopicSDKHelperKt.c(), new File(paramString));; paramString = Uri.fromFile(new File(paramString)))
    {
      PictureUtil localPictureUtil = PictureUtil.a;
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "it");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "pictureUri");
      this.jdField_b_of_type_JavaIoFile = new File(localPictureUtil.a(localActivity, paramString, 3));
      return;
    }
  }
  
  private final void d(View paramView)
  {
    Object localObject = paramView.findViewById(R.id.M);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById(R.id.et_topic_title)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText = ((LimitWordEditText)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    ((LimitWordEditText)localObject).setCountChangeListener((Function1)new AbsManageTopicPage.initTextView.1(this));
    localObject = paramView.findViewById(R.id.L);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById(R.id.et_topic_intro)");
    this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText = ((LimitWordEditText)localObject);
    localObject = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicIntroView");
    }
    ((LimitWordEditText)localObject).setDisableManualEnter(true);
    paramView = paramView.findViewById(R.id.bL);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "contentView.findViewById….id.tv_submit_permission)");
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView);
    paramView = this.jdField_e_of_type_AndroidWidgetTextView;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("submitTextView");
    }
    paramView.setOnClickListener((View.OnClickListener)this);
  }
  
  private final void d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    ImageLoader localImageLoader = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkImageLoader;
    if (localImageLoader != null) {
      localImageLoader.a(paramString);
    }
  }
  
  private final void o()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getSerializable("global_publisher_config");
      localObject = (GlobalPublisherConfig)localObject;
      if (localObject == null) {
        break label69;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = ((GlobalPublisherConfig)localObject).getScene();
      localObject = ((GlobalPublisherConfig)localObject).getTopicConfig();
      this.jdField_b_of_type_JavaLangString = ((ManageTopicConfig)localObject).getAllowSubmitTitle();
      this.jdField_c_of_type_JavaLangString = ((ManageTopicConfig)localObject).getForbidSubmitTitle();
      this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter.a((ManageTopicConfig)localObject);
      return;
      localObject = null;
      break;
      label69:
      localObject = new GlobalPublisherConfig();
    }
  }
  
  private final void p()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "this");
      this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog = new CommonProgressDialog((Context)localActivity, 1);
      this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog = new CommonProgressDialog((Context)localActivity, 1);
    }
  }
  
  private final void q()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(-1);
        }
      }
    }
  }
  
  private final void r()
  {
    if (((CharSequence)this.jdField_e_of_type_JavaLangString).length() == 0) {}
    for (int j = 1; j != 0; j = 0)
    {
      s();
      return;
    }
    String str = (String)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_e_of_type_JavaLangString);
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (j = 1;; j = 0)
    {
      if (j != 0)
      {
        TLog.b("AbsManageTopicPage", "updateCoverLayout localPath is null or empty.");
        str = this.jdField_e_of_type_JavaLangString;
      }
      d(str);
      t();
      return;
    }
  }
  
  private final void s()
  {
    Object localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("changeCoverTipView");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cameraIconView");
    }
    ((ImageView)localObject).setVisibility(0);
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addCoverTipView");
    }
    ((TextView)localObject).setVisibility(0);
  }
  
  private final void t()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cameraIconView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("addCoverTipView");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("changeCoverTipView");
    }
    ((TextView)localObject).setVisibility(0);
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter.a((ManageTopicContract.IManageTopicView)this);
    View localView1 = paramLayoutInflater.inflate(R.layout.j, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(localView1, "contentView");
    b(localView1);
    c(localView1);
    View localView2 = localView1.findViewById(R.id.al);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "contentView.findViewById(R.id.iv_camera_icon)");
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView2);
    localView2 = localView1.findViewById(R.id.bt);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "contentView.findViewById(R.id.tv_add_cover)");
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView2);
    localView2 = localView1.findViewById(R.id.bw);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "contentView.findViewById(R.id.tv_change_cover)");
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView2);
    d(localView1);
    p();
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.e, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "submitView");
    a(paramLayoutInflater);
    f();
    q();
    o();
    return localView1;
  }
  
  @NotNull
  public final TextView a()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleCenterView");
    }
    return localTextView;
  }
  
  @NotNull
  public final GlobalPublisherConfig a()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = new GlobalPublisherConfig();
    localGlobalPublisherConfig.setTopicConfig(new ManageTopicConfig());
    TopicInfo localTopicInfo = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
    localTopicInfo.setCoverUrl(this.jdField_e_of_type_JavaLangString);
    LimitWordEditText localLimitWordEditText = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    localTopicInfo.setTitle(localLimitWordEditText.a());
    localLimitWordEditText = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicIntroView");
    }
    localTopicInfo.setIntro(localLimitWordEditText.a());
    localTopicInfo.setAllowSubmit(this.jdField_a_of_type_Boolean);
    localGlobalPublisherConfig.setTopicInfo(localTopicInfo);
    return localGlobalPublisherConfig;
  }
  
  @NotNull
  public final PublishArticleInfo a()
  {
    Object localObject = null;
    PublishArticleInfo localPublishArticleInfo = new PublishArticleInfo();
    localPublishArticleInfo.setVideoInfo((VideoInfo)null);
    if (Intrinsics.areEqual(this.jdField_d_of_type_JavaLangString, "")) {
      localObject = CollectionsKt.arrayListOf(new ImageInfo[] { new ImageInfo() });
    }
    localPublishArticleInfo.setImageList((ArrayList)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    localPublishArticleInfo.setContentLength(((LimitWordEditText)localObject).b());
    return localPublishArticleInfo;
  }
  
  @NotNull
  public TopicPublishInfo a()
  {
    String str = this.jdField_e_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    localObject = ((LimitWordEditText)localObject).a();
    LimitWordEditText localLimitWordEditText = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicIntroView");
    }
    return new TopicPublishInfo(str, (String)localObject, localLimitWordEditText.a(), this.jdField_a_of_type_Boolean);
  }
  
  @NotNull
  protected final ManageTopicPresenter a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter;
  }
  
  @NotNull
  public final LimitWordEditText a()
  {
    LimitWordEditText localLimitWordEditText = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    return localLimitWordEditText;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter.a();
    Uploader localUploader = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkUploader;
    if (localUploader != null) {
      localUploader.c();
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity ?: return");
      localObject = ((Activity)localObject).getResources().getString(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      a((String)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    String str = null;
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if ((paramIntent == null) || (paramInt1 != 5)) {
        break label266;
      }
      str = paramIntent.getStringExtra("select_path");
      if (str != null)
      {
        if (((CharSequence)str).length() <= 0) {
          break label208;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          paramIntent = new File(TopicSDKHelperKt.a());
          if (!paramIntent.exists()) {
            paramIntent.mkdirs();
          }
          this.jdField_a_of_type_JavaIoFile = new File(paramIntent, "Image_" + System.currentTimeMillis() + ".jpg");
          if (new File(str).exists()) {
            break label220;
          }
          paramIntent = a();
          if (paramIntent == null) {
            break label213;
          }
          paramIntent = paramIntent.getResources();
          if (paramIntent == null) {
            break label213;
          }
          paramIntent = paramIntent.getString(R.string.Q);
          if (paramIntent == null) {
            break label213;
          }
          TopicSDKHelperKt.a(paramIntent, false, null, 6, null);
          TLog.d("AbsManageTopicPage", "onSelectPhoto, path=" + str + ", but file is not exist");
        }
      }
    }
    label208:
    label213:
    label220:
    while (paramInt1 != 3)
    {
      do
      {
        for (;;)
        {
          return;
          paramInt1 = 0;
          continue;
          paramIntent = "图片不存在，请重新选择";
        }
        paramIntent = this.jdField_a_of_type_JavaIoFile;
      } while (paramIntent == null);
      FilesKt.copyTo$default(new File(str), paramIntent, false, 0, 6, null);
      paramIntent = paramIntent.getAbsolutePath();
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "it.absolutePath");
      c(paramIntent);
      return;
    }
    label266:
    ThreadManagerKt.c((Function0)new AbsManageTopicPage.onActivityResult.2(this));
    File localFile = this.jdField_b_of_type_JavaIoFile;
    paramIntent = str;
    if (localFile != null)
    {
      localFile = localFile.getAbsoluteFile();
      paramIntent = str;
      if (localFile != null) {
        paramIntent = localFile.getAbsolutePath();
      }
    }
    b(paramIntent);
  }
  
  public void a(@NotNull ManageTopicConfig paramManageTopicConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramManageTopicConfig, "config");
    LimitWordEditText localLimitWordEditText = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    localLimitWordEditText.setCountLimit(paramManageTopicConfig.getTitleCountLimit());
    localLimitWordEditText = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    localLimitWordEditText.setHint(paramManageTopicConfig.getTitleHint());
    localLimitWordEditText = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicIntroView");
    }
    localLimitWordEditText.setCountLimit(paramManageTopicConfig.getBriefCountLimit());
    localLimitWordEditText = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicIntroView");
    }
    localLimitWordEditText.setHint(paramManageTopicConfig.getBriefHint());
    b(paramManageTopicConfig);
  }
  
  public void a(@NotNull TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    b(paramTopicInfo);
  }
  
  public void a(@NotNull TopicInfo paramTopicInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    a(paramTopicInfo, paramBoolean, ReportValues.a.a());
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tips");
    TopicSDKHelperKt.a(paramString, false, null, 6, null);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "localPath");
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    this.jdField_e_of_type_JavaLangString = paramString1;
    r();
    f();
  }
  
  @NotNull
  public final TextView b()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleRightView");
    }
    return localTextView;
  }
  
  @NotNull
  public final LimitWordEditText b()
  {
    LimitWordEditText localLimitWordEditText = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicIntroView");
    }
    return localLimitWordEditText;
  }
  
  @NotNull
  protected final String b()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void b(@NotNull ManageTopicConfig paramManageTopicConfig)
  {
    int k = 8;
    Intrinsics.checkParameterIsNotNull(paramManageTopicConfig, "config");
    Object localObject;
    if (paramManageTopicConfig.getShowSubmit())
    {
      localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("submitTextView");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("allowSubmitTitleView");
      }
      ((TextView)localObject).setText((CharSequence)paramManageTopicConfig.getAllowSubmitTitle());
      localObject = this.g;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("allowSubmitDescView");
      }
      ((TextView)localObject).setText((CharSequence)paramManageTopicConfig.getAllowSubmitDesc());
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("forbidSubmitTitleView");
      }
      ((TextView)localObject).setText((CharSequence)paramManageTopicConfig.getForbidSubmitTitle());
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("forbidSubmitDescView");
      }
      ((TextView)localObject).setText((CharSequence)paramManageTopicConfig.getForbidSubmitDesc());
      TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("submitTextView");
      }
      if (!paramManageTopicConfig.getCurrentAllowSubmit()) {
        break label288;
      }
      localObject = (CharSequence)this.jdField_b_of_type_JavaLangString;
      label189:
      localTextView.setText((CharSequence)localObject);
      localObject = this.jdField_d_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("allowSubmitArrowView");
      }
      if (!paramManageTopicConfig.getCurrentAllowSubmit()) {
        break label300;
      }
      j = 0;
      label222:
      ((ImageView)localObject).setVisibility(j);
      localObject = this.jdField_e_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("forbidSubmitArrowView");
      }
      if (!paramManageTopicConfig.getCurrentAllowSubmit()) {
        break label306;
      }
    }
    label288:
    label300:
    label306:
    for (int j = k;; j = 0)
    {
      ((ImageView)localObject).setVisibility(j);
      return;
      localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("submitTextView");
      }
      ((TextView)localObject).setVisibility(8);
      break;
      localObject = (CharSequence)this.jdField_c_of_type_JavaLangString;
      break label189;
      j = 8;
      break label222;
    }
  }
  
  protected final void b(@NotNull TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    this.jdField_e_of_type_JavaLangString = paramTopicInfo.getCoverUrl();
    LimitWordEditText localLimitWordEditText = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    localLimitWordEditText.setContent(paramTopicInfo.getTitle());
    localLimitWordEditText = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicTitleView");
    }
    localLimitWordEditText.setSelectionEnd();
    localLimitWordEditText = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicIntroView");
    }
    localLimitWordEditText.setContent(paramTopicInfo.getIntro());
    r();
    f();
  }
  
  public void b(@NotNull TopicInfo paramTopicInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    a(paramTopicInfo, paramBoolean, ReportValues.a.b());
  }
  
  public void d()
  {
    super.d();
    ThreadManagerKt.c((Function0)new AbsManageTopicPage.afterActivityFinish.1(this));
  }
  
  protected void f()
  {
    if (i())
    {
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleRightView");
      }
      localTextView.setClickable(true);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleRightView");
      }
      localTextView.setEnabled(true);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleRightView");
      }
      localTextView.setAlpha(1.0F);
      return;
    }
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleRightView");
    }
    localTextView.setClickable(false);
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleRightView");
    }
    localTextView.setEnabled(false);
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleRightView");
    }
    localTextView.setAlpha(0.5F);
  }
  
  protected final boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g() {}
  
  public final boolean g()
  {
    return ((CharSequence)this.jdField_d_of_type_JavaLangString).length() > 0;
  }
  
  public void h()
  {
    CommonProgressDialog localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
    if (localCommonProgressDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("uploadingCoverDialog");
    }
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getResources();
      if (localObject != null)
      {
        localObject = ((Resources)localObject).getString(R.string.as);
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      localCommonProgressDialog.a((String)localObject);
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("uploadingCoverDialog");
      }
      if (!((CommonProgressDialog)localObject).isShowing())
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("uploadingCoverDialog");
        }
        ((CommonProgressDialog)localObject).show();
      }
      return;
      localObject = "";
    }
  }
  
  public final boolean h()
  {
    LimitWordEditText localLimitWordEditText = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetLimitWordEditText;
    if (localLimitWordEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicIntroView");
    }
    return ((CharSequence)localLimitWordEditText.a()).length() > 0;
  }
  
  public void i()
  {
    CommonProgressDialog localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
    if (localCommonProgressDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("uploadingCoverDialog");
    }
    if (localCommonProgressDialog.isShowing())
    {
      localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("uploadingCoverDialog");
      }
      localCommonProgressDialog.dismiss();
    }
  }
  
  protected abstract boolean i();
  
  public void j()
  {
    CommonProgressDialog localCommonProgressDialog = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
    if (localCommonProgressDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("publishingDialog");
    }
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getResources();
      if (localObject != null)
      {
        localObject = ((Resources)localObject).getString(R.string.t);
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      localCommonProgressDialog.a((String)localObject);
      localObject = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("publishingDialog");
      }
      ((CommonProgressDialog)localObject).setCancelable(true);
      localObject = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("publishingDialog");
      }
      if (!((CommonProgressDialog)localObject).isShowing())
      {
        localObject = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("publishingDialog");
        }
        ((CommonProgressDialog)localObject).show();
      }
      return;
      localObject = "";
    }
  }
  
  protected abstract boolean j();
  
  public void k()
  {
    CommonProgressDialog localCommonProgressDialog = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
    if (localCommonProgressDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("publishingDialog");
    }
    if (localCommonProgressDialog.isShowing())
    {
      localCommonProgressDialog = this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("publishingDialog");
      }
      localCommonProgressDialog.dismiss();
    }
  }
  
  public void l() {}
  
  public void m() {}
  
  public void n()
  {
    if (InputMethodUtils.a.a(a()))
    {
      localObject1 = InputMethodUtils.a;
      localObject2 = a();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity!!");
      localObject2 = (Context)localObject2;
      Object localObject3 = this.jdField_c_of_type_AndroidWidgetImageView;
      if (localObject3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverImageView");
      }
      localObject3 = ((ImageView)localObject3).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "coverImageView.windowToken");
      ((InputMethodUtils)localObject1).a((Context)localObject2, (IBinder)localObject3);
    }
    Object localObject1 = TopicSDKHelperKt.a();
    Object localObject2 = a();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity!!");
    ((IUserActionHandler)localObject1).a((Activity)localObject2, (Function2)new AbsManageTopicPage.handleCoverViewClick.1(this));
  }
  
  public void onClick(@Nullable View paramView)
  {
    int j;
    if (paramView != null)
    {
      j = paramView.getId();
      if (j != R.id.as) {
        break label21;
      }
      l();
    }
    for (;;)
    {
      return;
      label21:
      if (j == R.id.bP)
      {
        m();
      }
      else if (j == R.id.bL)
      {
        paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog;
        if (paramView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("submitDialog");
        }
        paramView.show();
      }
      else if (j == R.id.k)
      {
        a(true);
      }
      else if (j == R.id.Y)
      {
        a(false);
      }
      else if (j == R.id.bc)
      {
        n();
      }
      else
      {
        TLog.d("AbsManageTopicPage", "onClick, no handler, view = " + paramView.getClass().getSimpleName());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.AbsManageTopicPage
 * JD-Core Version:    0.7.0.1
 */