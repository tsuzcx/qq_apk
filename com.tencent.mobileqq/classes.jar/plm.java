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

public class plm
  extends ViewBase
  implements rrk, rrl
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  private osm jdField_a_of_type_Osm = new plo(this);
  private plw jdField_a_of_type_Plw;
  private ViewBase b;
  
  private plm(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(paramVafContext.getContext()).inflate(2131560022, null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374959));
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363142);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_Plw = new plw(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(vpm.b(paramVafContext.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_Plw);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnViewWindowChangedListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.jdField_a_of_type_Int = vpm.b(paramVafContext.getContext(), 6.0F);
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
    mxf.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new plu(this), localReqBody.toByteArray(), "OidbSvc.0xc2f", 3119, 1, null, 0L);
  }
  
  private void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    osg.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ReadInJoySocializeRecommendFollowView.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    pls localpls = new pls(this);
    plt localplt = new plt(this, paramBoolean);
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { vpm.b(this.mContext.getContext(), 6.0F), this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight(), vpm.b(this.mContext.getContext(), 6.0F) }))
    {
      localValueAnimator.addListener(localplt);
      localValueAnimator.addUpdateListener(localpls);
      localValueAnimator.setDuration(300L);
      localValueAnimator.start();
      return;
    }
  }
  
  private void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!bbfj.g(this.mContext.getContext())) {
      bcql.a(this.mContext.getContext(), 1, 2131718513, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySocializeRecommendFollowView", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    paramRecommendFollowInfo = omj.k + bbco.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
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
        if (pek.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
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
    osj.a().a(this.jdField_a_of_type_Osm);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (bbfj.g(this.mContext.getContext()))
    {
      if ((!paramBoolean) || (paramRecommendFollowInfo.type == 1)) {
        c(paramRecommendFollowInfo, paramBoolean);
      }
      for (;;)
      {
        this.jdField_a_of_type_Plw.notifyDataSetChanged();
        return;
        if (paramRecommendFollowInfo.type == 2) {
          b(paramRecommendFollowInfo, paramBoolean);
        } else {
          QLog.e("ReadInJoySocializeRecommendFollowView", 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
        }
      }
    }
    bcql.a(this.mContext.getContext(), 1, 2131718513, 0).a();
  }
  
  public void a(pau parampau)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = parampau.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = getParent().findViewBaseByName("id_dislike_button");
    }
    if (this.b == null)
    {
      this.b = getParent().findViewBaseByName("id_social_header_fold_button");
      if (this.b != null) {
        this.b.setOnClickListener(new pln(this));
      }
    }
    d();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isShowRecommendList) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.a != null))
    {
      this.jdField_a_of_type_Plw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.a);
      parampau = new ReadInJoySocializeRecommendFollowView.2(this);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.post(parampau);
        return;
      }
      parampau.run();
      return;
    }
    this.jdField_a_of_type_Int = vpm.b(this.mContext.getContext(), 6.0F);
  }
  
  public void b()
  {
    osj.a().b(this.jdField_a_of_type_Osm);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    osg.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, new plp(this, paramRecommendFollowInfo), 2);
  }
  
  public void c()
  {
    String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.b;
    Intent localIntent = new Intent(this.mContext.getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    this.mContext.getContext().startActivity(localIntent);
    nol.a(null, onh.a() + "", "0X800984C", "0X800984C", 0, 0, "1", "", "", "", false);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      osg.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, new plq(this, paramRecommendFollowInfo), 1);
      return;
    }
    osg.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, new plr(this, paramRecommendFollowInfo), 1);
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
 * Qualified Name:     plm
 * JD-Core Version:    0.7.0.1
 */