import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.2;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.6;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListReq;
import tencent.im.oidb.oidb_0xc2f.ReqBody;

public class quh
  extends ViewBase
  implements toq, tor
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  private pvq jdField_a_of_type_Pvq = new quj(this);
  private qur jdField_a_of_type_Qur;
  private ViewBase b;
  
  private quh(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(paramVafContext.getContext()).inflate(2131560330, null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376358));
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363485);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_Qur = new qur(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(DisplayUtil.dip2px(paramVafContext.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_Qur);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnViewWindowChangedListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.jdField_a_of_type_Int = DisplayUtil.dip2px(paramVafContext.getContext(), 6.0F);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "requestRecommendList, uin = " + BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    }
    oidb_0xc2f.ReqBody localReqBody = new oidb_0xc2f.ReqBody();
    oidb_0xc2f.GetFollowUserRecommendListReq localGetFollowUserRecommendListReq = new oidb_0xc2f.GetFollowUserRecommendListReq();
    localGetFollowUserRecommendListReq.uint64_followed_uin.set(paramLong);
    localReqBody.msg_get_follow_user_recommend_list_req.set(localGetFollowUserRecommendListReq);
    ntb.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new qup(this), localReqBody.toByteArray(), "OidbSvc.0xc2f", 3119, 1, null, 0L);
  }
  
  private void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    pvj.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ReadInJoySocializeRecommendFollowView.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    qun localqun = new qun(this);
    quo localquo = new quo(this, paramBoolean);
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { DisplayUtil.dip2px(this.mContext.getContext(), 6.0F), this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight(), DisplayUtil.dip2px(this.mContext.getContext(), 6.0F) }))
    {
      localValueAnimator.addListener(localquo);
      localValueAnimator.addUpdateListener(localqun);
      localValueAnimator.setDuration(300L);
      localValueAnimator.start();
      return;
    }
  }
  
  private void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.isNetworkAvailable(this.mContext.getContext())) {
      QQToast.a(this.mContext.getContext(), 1, 2131717802, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySocializeRecommendFollowView", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    paramRecommendFollowInfo = pjj.k + bhcu.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(this.mContext.getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", paramRecommendFollowInfo);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    this.mContext.getContext().startActivity(localIntent);
  }
  
  private void d()
  {
    ViewBean localViewBean = new ViewBean();
    ValueBean localValueBean = localViewBean.valueBean;
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isShowRecommendList) {
      str1 = "VISIBLE";
    }
    for (;;)
    {
      localValueBean.putTrueDynamicValue("visibility", str1);
      bindDynamicValue(localViewBean);
      localViewBean = new ViewBean();
      localValueBean = localViewBean.valueBean;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isShowRecommendList)
      {
        str1 = "GONE";
        localValueBean.putTrueDynamicValue("visibility", str1);
      }
      try
      {
        if (qmm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          localViewBean.valueBean.putTrueDynamicValue("visibility", "GONE");
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.bindDynamicValue(localViewBean);
        }
        localViewBean = new ViewBean();
        localValueBean = localViewBean.valueBean;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isShowRecommendList)
        {
          str1 = "VISIBLE";
          localValueBean.putTrueDynamicValue("visibility", str1);
          if (this.b != null) {
            this.b.bindDynamicValue(localViewBean);
          }
          return;
          str1 = "GONE";
          continue;
          str1 = "VISIBLE";
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ReadInJoySocializeRecommendFollowView", 2, localJSONException, new Object[0]);
          continue;
          String str2 = "GONE";
        }
      }
    }
  }
  
  public void a()
  {
    pvm.a().a(this.jdField_a_of_type_Pvq);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (NetworkUtil.isNetworkAvailable(this.mContext.getContext()))
    {
      if ((!paramBoolean) || (paramRecommendFollowInfo.type == 1)) {
        c(paramRecommendFollowInfo, paramBoolean);
      }
      for (;;)
      {
        this.jdField_a_of_type_Qur.notifyDataSetChanged();
        return;
        if (paramRecommendFollowInfo.type == 2) {
          b(paramRecommendFollowInfo, paramBoolean);
        } else {
          QLog.e("ReadInJoySocializeRecommendFollowView", 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
        }
      }
    }
    QQToast.a(this.mContext.getContext(), 1, 2131717802, 0).a();
  }
  
  public void a(qfw paramqfw)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramqfw.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = getParent().findViewBaseByName("id_dislike_button");
    }
    if (this.b == null)
    {
      this.b = getParent().findViewBaseByName("id_social_header_fold_button");
      if (this.b != null) {
        this.b.setOnClickListener(new qui(this));
      }
    }
    d();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isShowRecommendList) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.a != null))
    {
      this.jdField_a_of_type_Qur.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.a);
      paramqfw = new ReadInJoySocializeRecommendFollowView.2(this);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.post(paramqfw);
        return;
      }
      paramqfw.run();
      return;
    }
    this.jdField_a_of_type_Int = DisplayUtil.dip2px(this.mContext.getContext(), 6.0F);
  }
  
  public void b()
  {
    pvm.a().b(this.jdField_a_of_type_Pvq);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    pvj.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, paramRecommendFollowInfo.headUrl, new quk(this, paramRecommendFollowInfo), 2);
  }
  
  public void c()
  {
    String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.b;
    Intent localIntent = new Intent(this.mContext.getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    this.mContext.getContext().startActivity(localIntent);
    olh.a(null, pkh.a() + "", "0X800984C", "0X800984C", 0, 0, "1", "", "", "", false);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      pvj.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, paramRecommendFollowInfo.headUrl, new qul(this, paramRecommendFollowInfo), 1);
      return;
    }
    pvj.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, paramRecommendFollowInfo.headUrl, new qum(this, paramRecommendFollowInfo), 1);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     quh
 * JD-Core Version:    0.7.0.1
 */