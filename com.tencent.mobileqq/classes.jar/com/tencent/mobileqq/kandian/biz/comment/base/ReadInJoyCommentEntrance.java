package com.tencent.mobileqq.kandian.biz.comment.base;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQLifecycleBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQLogBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQPublishCommentBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQSharedPreferencesImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQUrlImageBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.listener.OnDeliverListener;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.base.model.IPublishScene;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
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
  private static final ReadInJoyCommentEntrance.SaveState a = new ReadInJoyCommentEntrance.SaveState();
  private static String b;
  private final QBaseActivity c;
  private final Intent d;
  private final CommentArgumentModel e;
  private final QQPublishCommentFragment f;
  
  public ReadInJoyCommentEntrance(QBaseActivity paramQBaseActivity, Intent paramIntent)
  {
    this.c = paramQBaseActivity;
    this.d = paramIntent;
    this.e = new CommentArgumentModel(paramIntent);
    paramQBaseActivity = new QQViewBridgeImpl(this.e);
    paramIntent = new QQLifecycleBridgeImpl();
    paramIntent.a(paramQBaseActivity);
    paramIntent.a(this);
    paramQBaseActivity.a(this);
    Object localObject = this.e.d;
    paramQBaseActivity.a((QQReportBridge)localObject);
    this.f = new QQPublishCommentFragment();
    this.f.logBridge = new QQLogBridgeImpl();
    this.f.publishCommentBridge = new QQPublishCommentBridgeImpl(this.e);
    QQPublishCommentFragment localQQPublishCommentFragment = this.f;
    localQQPublishCommentFragment.reportBridge = ((QQReportBridge)localObject);
    localQQPublishCommentFragment.sharedPreferenceBridge = new QQSharedPreferencesImpl();
    localObject = this.f;
    ((QQPublishCommentFragment)localObject).viewBridge = paramQBaseActivity;
    ((QQPublishCommentFragment)localObject).lifecycleBridge = paramIntent;
    ((QQPublishCommentFragment)localObject).urlImageBridge = new QQUrlImageBridgeImpl();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = this.f.getActivity();
    if (localActivity == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult, activity == null;commentFragment isShowing=");
      paramIntent.append(this.f.isShowing());
      QLog.d("ReadInJoyCommentEntrance", 2, paramIntent.toString());
      if (paramInt != 0) {
        QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131915782), 0).show();
      }
      return;
    }
    localActivity.setResult(paramInt, paramIntent);
    if (this.f.isShowing())
    {
      this.f.setDismissListener(new ReadInJoyCommentEntrance.2(this, localActivity));
      return;
    }
    localActivity.finish();
    localActivity.overridePendingTransition(0, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (FastClickUtils.a("ReadInJoyCommentEntrance")) {
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
    b = null;
    if (paramIntent != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
      if (localAbsBaseArticleInfo != null)
      {
        b = localAbsBaseArticleInfo.innerUniqueID;
        return;
      }
      paramIntent = (SimpleCommentData)paramIntent.getParcelableExtra("comment_create_data");
      if (paramIntent != null) {
        b = paramIntent.d();
      }
    }
  }
  
  public static void a(ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    if (c()) {
      ReadInJoyCommentUtils.a((Activity)a.a.get(), paramCustomDialogClickListener);
    }
  }
  
  public static void a(String paramString)
  {
    if (c())
    {
      a.b.putExtra("comment_recreate_draft", paramString);
      a((Activity)a.a.get(), a.b, a.c);
    }
  }
  
  private static void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    QLog.d("ReadInJoyCommentEntrance", 1, "startForResultInner");
    a(paramIntent);
    h();
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicTransFragmentActivity.class, ReadInJoyCommentBridgeFragment.class, paramInt);
  }
  
  private static void c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str;
      if (b == null) {
        str = "";
      } else {
        str = b;
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
  
  public static boolean c()
  {
    return (a.a != null) && (a.a.get() != null) && (a.b != null);
  }
  
  public static void d()
  {
    c("onCommentEditorResume");
  }
  
  private static void d(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a.a = new WeakReference(paramActivity);
    a.b = ((Intent)paramIntent.clone());
    a.c = paramInt;
  }
  
  public static void e()
  {
    c("onCommentEditorPause");
  }
  
  public static void f()
  {
    c("onCommentEditorWillClose");
  }
  
  public static void g()
  {
    c("onCommentEditorClose");
  }
  
  private static void h()
  {
    c("openCommentEditor");
  }
  
  public QQPublishCommentFragment a()
  {
    return this.f;
  }
  
  public void b()
  {
    if (this.f.isShowing()) {
      return;
    }
    this.f.show(this.c.getFragmentManager(), "QQPublishCommentFragment");
  }
  
  public void b(String paramString)
  {
    this.e.d.a(this.d, paramString);
    a(-1, this.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance
 * JD-Core Version:    0.7.0.1
 */