package com.tencent.mobileqq.kandian.biz.comment.base;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQLifecycleBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQLogBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQPublishCommentBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQReportBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQSharedPreferencesImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQUrlImageBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.listener.OnDeliverListener;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentEntrance
  implements OnDeliverListener, QQLifecycleBridge
{
  private static final ReadInJoyCommentEntrance.SaveState jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState = new ReadInJoyCommentEntrance.SaveState();
  private static String jdField_a_of_type_JavaLangString;
  private final Intent jdField_a_of_type_AndroidContentIntent;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final CommentArgumentModel jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel;
  private final QQPublishCommentFragment jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment;
  
  public ReadInJoyCommentEntrance(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel = new CommentArgumentModel(paramIntent);
    paramBaseActivity = new QQViewBridgeImpl(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel);
    paramIntent = new QQLifecycleBridgeImpl();
    paramIntent.a(paramBaseActivity);
    paramIntent.a(this);
    paramBaseActivity.a(this);
    Object localObject = new QQReportBridgeImpl(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel);
    paramBaseActivity.a((QQReportBridge)localObject);
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment = new QQPublishCommentFragment();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.logBridge = new QQLogBridgeImpl();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.publishCommentBridge = new QQPublishCommentBridgeImpl(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel);
    QQPublishCommentFragment localQQPublishCommentFragment = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment;
    localQQPublishCommentFragment.reportBridge = ((QQReportBridge)localObject);
    localQQPublishCommentFragment.sharedPreferenceBridge = new QQSharedPreferencesImpl();
    localObject = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment;
    ((QQPublishCommentFragment)localObject).viewBridge = paramBaseActivity;
    ((QQPublishCommentFragment)localObject).lifecycleBridge = paramIntent;
    ((QQPublishCommentFragment)localObject).urlImageBridge = new QQUrlImageBridgeImpl();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.getActivity();
    if (localActivity == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult, activity == null;commentFragment isShowing=");
      paramIntent.append(this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing());
      QLog.d("ReadInJoyCommentEntrance", 2, paramIntent.toString());
      if (paramInt != 0) {
        QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131718290), 0).a();
      }
      return;
    }
    localActivity.setResult(paramInt, paramIntent);
    if (this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing())
    {
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.setDismissListener(new ReadInJoyCommentEntrance.2(this, localActivity));
      return;
    }
    localActivity.finish();
    localActivity.overridePendingTransition(0, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (((IWSManager)QRoute.api(IWSManager.class)).isFastClick()) {
      return;
    }
    d(paramActivity, paramIntent, paramInt);
    boolean bool = paramIntent.getBooleanExtra("need_intercept", true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startForResult: needIntercept=");
    localStringBuilder.append(bool);
    QLog.d("ReadInJoyCommentEntrance", 1, localStringBuilder.toString());
    if (bool)
    {
      RIJUserLevelModule.getInstance().doActionsByUserLevel(paramActivity, 1, new ReadInJoyCommentEntrance.1(paramActivity, paramIntent, paramInt));
      return;
    }
    c(paramActivity, paramIntent, paramInt);
  }
  
  private static void a(Intent paramIntent)
  {
    jdField_a_of_type_JavaLangString = null;
    if (paramIntent != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
      if (localAbsBaseArticleInfo != null)
      {
        jdField_a_of_type_JavaLangString = localAbsBaseArticleInfo.innerUniqueID;
        return;
      }
      paramIntent = (SimpleCommentData)paramIntent.getParcelableExtra("comment_create_data");
      if (paramIntent != null) {
        jdField_a_of_type_JavaLangString = paramIntent.c();
      }
    }
  }
  
  public static void a(ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    if (a()) {
      ReadInJoyCommentUtils.a((Activity)jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference.get(), paramCustomDialogClickListener);
    }
  }
  
  public static void a(String paramString)
  {
    if (a())
    {
      jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_AndroidContentIntent.putExtra("comment_recreate_draft", paramString);
      a((Activity)jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference.get(), jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_AndroidContentIntent, jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_Int);
    }
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_AndroidContentIntent != null);
  }
  
  public static void b()
  {
    d("onCommentEditorResume");
  }
  
  public static void c()
  {
    d("onCommentEditorPause");
  }
  
  private static void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    QLog.d("ReadInJoyCommentEntrance", 1, "startForResultInner");
    a(paramIntent);
    f();
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicTransFragmentActivity.class, ReadInJoyCommentBridgeFragment.class, paramInt);
  }
  
  public static void d()
  {
    d("onCommentEditorWillClose");
  }
  
  private static void d(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_AndroidContentIntent = ((Intent)paramIntent.clone());
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_Int = paramInt;
  }
  
  private static void d(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str;
      if (jdField_a_of_type_JavaLangString == null) {
        str = "";
      } else {
        str = jdField_a_of_type_JavaLangString;
      }
      localJSONObject.put("rowkey", str);
    }
    catch (JSONException localJSONException)
    {
      QLog.w("ReadInJoyCommentEntrance", 4, localJSONException.getMessage(), localJSONException);
    }
    paramString = new ViolaEvent(paramString, localJSONObject);
    SimpleEventBus.getInstance().dispatchEvent(paramString);
  }
  
  public static void e()
  {
    d("onCommentEditorClose");
  }
  
  private static void f()
  {
    d("openCommentEditor");
  }
  
  public QQPublishCommentFragment a()
  {
    return this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.show(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFragmentManager(), "QQPublishCommentFragment");
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("arg_result_json", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_article_info", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_gallery_channel", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel.jdField_a_of_type_Boolean);
    paramString = this.jdField_a_of_type_AndroidContentIntent;
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel.f)) {
      i = 2;
    } else {
      i = 3;
    }
    paramString.putExtra("click_comment_edit_src", i);
    a(-1, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("arg_result_json", paramString);
    paramString = this.jdField_a_of_type_AndroidContentIntent;
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel.f)) {
      i = 2;
    } else {
      i = 3;
    }
    paramString.putExtra("click_comment_edit_src", i);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_article_info", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    a(1699, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onDestroy(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(0, new Intent());
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance
 * JD-Core Version:    0.7.0.1
 */