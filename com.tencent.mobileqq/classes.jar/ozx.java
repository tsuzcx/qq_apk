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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListReq;
import tencent.im.oidb.oidb_0xc2f.ReqBody;

public class ozx
  extends ViewBase
  implements rex, rey
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  private ohe jdField_a_of_type_Ohe = new ozz(this);
  private pah jdField_a_of_type_Pah;
  private ViewBase b;
  
  private ozx(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(paramVafContext.getContext()).inflate(2131494456, null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131309213));
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297593);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_Pah = new pah(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(vct.a(paramVafContext.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_Pah);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnViewWindowChangedListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.jdField_a_of_type_Int = vct.a(paramVafContext.getContext(), 6.0F);
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
    mmj.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new paf(this), localReqBody.toByteArray(), "OidbSvc.0xc2f", 3119, 1, null, 0L);
  }
  
  private void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ogy.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ReadInJoySocializeRecommendFollowView.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    pad localpad = new pad(this);
    pae localpae = new pae(this, paramBoolean);
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { vct.a(this.mContext.getContext(), 6.0F), this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight(), vct.a(this.mContext.getContext(), 6.0F) }))
    {
      localValueAnimator.addListener(localpae);
      localValueAnimator.addUpdateListener(localpad);
      localValueAnimator.setDuration(300L);
      localValueAnimator.start();
      return;
    }
  }
  
  private void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!badq.g(this.mContext.getContext())) {
      bbmy.a(this.mContext.getContext(), 1, 2131652679, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySocializeRecommendFollowView", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    paramRecommendFollowInfo = obb.k + baaw.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
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
        if (otl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          localViewBean.valueBean.putTrueDynamicValue("visibility", "GONE");
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.bindDynamicValue(localViewBean);
        localViewBean = new ViewBean();
        localValueBean = localViewBean.valueBean;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isShowRecommendList)
        {
          str1 = "VISIBLE";
          localValueBean.putTrueDynamicValue("visibility", str1);
          this.b.bindDynamicValue(localViewBean);
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
    ohb.a().a(this.jdField_a_of_type_Ohe);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (badq.g(this.mContext.getContext()))
    {
      if ((!paramBoolean) || (paramRecommendFollowInfo.type == 1)) {
        c(paramRecommendFollowInfo, paramBoolean);
      }
      for (;;)
      {
        this.jdField_a_of_type_Pah.notifyDataSetChanged();
        return;
        if (paramRecommendFollowInfo.type == 2) {
          b(paramRecommendFollowInfo, paramBoolean);
        } else {
          QLog.e("ReadInJoySocializeRecommendFollowView", 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
        }
      }
    }
    bbmy.a(this.mContext.getContext(), 1, 2131652679, 0).a();
  }
  
  public void a(opw paramopw)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramopw.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = getParent().findViewBaseByName("id_dislike_button");
    }
    if (this.b == null)
    {
      this.b = getParent().findViewBaseByName("id_social_header_fold_button");
      if (this.b != null) {
        this.b.setOnClickListener(new ozy(this));
      }
    }
    d();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isShowRecommendList) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.a != null))
    {
      this.jdField_a_of_type_Pah.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.a);
      paramopw = new ReadInJoySocializeRecommendFollowView.2(this);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.post(paramopw);
        return;
      }
      paramopw.run();
      return;
    }
    this.jdField_a_of_type_Int = vct.a(this.mContext.getContext(), 6.0F);
  }
  
  public void b()
  {
    ohb.a().b(this.jdField_a_of_type_Ohe);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ogy.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, new paa(this, paramRecommendFollowInfo), 2);
  }
  
  public void c()
  {
    String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.b;
    Intent localIntent = new Intent(this.mContext.getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    this.mContext.getContext().startActivity(localIntent);
    ndn.a(null, obz.a() + "", "0X800984C", "0X800984C", 0, 0, "1", "", "", "", false);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      ogy.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, new pab(this, paramRecommendFollowInfo), 1);
      return;
    }
    ogy.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, new pac(this, paramRecommendFollowInfo), 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozx
 * JD-Core Version:    0.7.0.1
 */