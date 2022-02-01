import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentBridgeFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;

public class pcp
  implements QQLifecycleBridge, pdk
{
  private final Intent jdField_a_of_type_AndroidContentIntent;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQPublishCommentFragment jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment;
  private final pdl jdField_a_of_type_Pdl;
  
  public pcp(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Pdl = new pdl(paramIntent);
    paramBaseActivity = new pdd(this.jdField_a_of_type_Pdl);
    paramIntent = new pcs();
    paramIntent.a(paramBaseActivity);
    paramIntent.a(this);
    paramBaseActivity.a(this);
    QQPublishCommentManager localQQPublishCommentManager = QQPublishCommentManager.getInstance();
    localQQPublishCommentManager.setLogBridge(new pct());
    localQQPublishCommentManager.setPublisherBridge(new pcu(this.jdField_a_of_type_Pdl));
    localQQPublishCommentManager.setReportBridge(new pcz(this.jdField_a_of_type_Pdl));
    localQQPublishCommentManager.setSpBridge(new pda());
    localQQPublishCommentManager.setViewBridge(paramBaseActivity);
    localQQPublishCommentManager.setLifecycleBridge(paramIntent);
    localQQPublishCommentManager.setUrlImageBridge(new pdb());
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment = new QQPublishCommentFragment();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.getActivity();
    if (localActivity == null)
    {
      QLog.d("ReadInJoyCommentEntrance", 2, "onActivityResult, activity == null;commentFragment isShowing=" + this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing());
      if (paramInt != 0) {
        QQToast.a(BaseApplicationImpl.getApplication(), anvx.a(2131718081), 0).a();
      }
      return;
    }
    localActivity.setResult(paramInt, paramIntent);
    if (this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing())
    {
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.setDismissListener(new pcr(this, localActivity));
      return;
    }
    localActivity.finish();
    localActivity.overridePendingTransition(0, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (vnd.b()) {
      return;
    }
    if (paramIntent.getBooleanExtra("need_intercept", true))
    {
      qgx.a().a(paramActivity, 1, new pcq(paramActivity, paramIntent, paramInt));
      return;
    }
    c(paramActivity, paramIntent, paramInt);
  }
  
  private static void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    aeow.a(paramActivity, paramIntent, PublicTransFragmentActivity.class, ReadInJoyCommentBridgeFragment.class, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.show(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFragmentManager(), "QQPublishCommentFragment");
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("arg_result_json", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_article_info", this.jdField_a_of_type_Pdl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_gallery_channel", this.jdField_a_of_type_Pdl.jdField_a_of_type_Boolean);
    paramString = this.jdField_a_of_type_AndroidContentIntent;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Pdl.f)) {}
    for (int i = 2;; i = 3)
    {
      paramString.putExtra("click_comment_edit_src", i);
      a(-1, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("arg_result_json", paramString);
    paramString = this.jdField_a_of_type_AndroidContentIntent;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Pdl.f)) {}
    for (int i = 2;; i = 3)
    {
      paramString.putExtra("click_comment_edit_src", i);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_article_info", this.jdField_a_of_type_Pdl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      a(1699, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  public void onDestroy(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(0, new Intent());
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcp
 * JD-Core Version:    0.7.0.1
 */