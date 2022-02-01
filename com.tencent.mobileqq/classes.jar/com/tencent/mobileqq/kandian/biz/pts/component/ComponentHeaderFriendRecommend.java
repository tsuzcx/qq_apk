package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;

public class ComponentHeaderFriendRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RingAvatarView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView;
  private List<Long> jdField_a_of_type_JavaUtilList = null;
  ReadInJoyHeadImageView[] jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ComponentHeaderFriendRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderFriendRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderFriendRecommend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.i()) && (!CmpCtxt.a(paramAbsBaseArticleInfo)))
    {
      try
      {
        paramAbsBaseArticleInfo = ((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
        paramAbsBaseArticleInfo = null;
      }
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
        QLog.w("ComponentHeaderFriendRecommend", 1, "ReadInJoyHeader friend recommend description empty");
      }
      return paramAbsBaseArticleInfo;
    }
    String str = paramAbsBaseArticleInfo.mSocialFeedInfo.c;
    paramAbsBaseArticleInfo = str;
    if (TextUtils.isEmpty(str)) {
      paramAbsBaseArticleInfo = "";
    }
    return paramAbsBaseArticleInfo;
  }
  
  private List<Long> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    ArrayList localArrayList1 = new ArrayList();
    if (localObject == null) {
      return localArrayList1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a())
    {
      localObject = new ArrayList(1);
      try
      {
        ((List)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSubscribeID)));
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return localObject;
      }
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.i()) && (!c()))
    {
      if ((((AbsBaseArticleInfo)localObject).mPackInfoObj != null) && (((AbsBaseArticleInfo)localObject).mPackInfoObj.has()))
      {
        try
        {
          localNumberFormatException.addAll(((articlesummary.FriendRecommendInfo)((AbsBaseArticleInfo)localObject).mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (localNumberFormatException.isEmpty()) {
          QLog.w("ComponentHeaderFriendRecommend", 1, "ReadInJoyHeader friend recommend uin list empty");
        }
      }
      return localNumberFormatException;
    }
    ArrayList localArrayList2 = new ArrayList(1);
    localArrayList2.add(Long.valueOf(localException.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long));
    return localArrayList2;
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", RIJAppSetting.a());
        String str = RIJFeedsType.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a());
        if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c()))
        {
          paramString = "0X8009357";
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = "0X800744D";
    }
  }
  
  private void a(List<Long> paramList)
  {
    if ((paramList != null) && (paramList.size() == 1))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.i()) && (!c())) {
        setOnClickListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(RIJStringUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSubscribeName));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(((Long)paramList.get(0)).longValue());
      if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.i()) && (!c()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    setOnClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = null;
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.i()) || (c()))
    {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.d)) {
        return paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      }
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.e;
      if (i > 0) {
        return ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(i, true);
      }
      str = HardCodeUtil.a(2131702461);
    }
    return str;
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.k);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      ReadInJoyUtils.a(getContext(), (String)localObject);
    }
    else
    {
      a(paramLong);
    }
    a(RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()));
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() == null) {
      return false;
    }
    return CmpCtxt.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.i()) && (!c()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject).d)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((SocializeFeedsInfo)localObject).d);
      return;
    }
    localObject = b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560142, this, true);
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ReadInJoyConstants.g);
    ((StringBuilder)localObject1).append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
    localObject1 = ((StringBuilder)localObject1).toString();
    ReadInJoyUtils.a(getContext(), (String)localObject1);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = localAbsBaseArticleInfo;
    String str = RIJTransMergeKanDianReport.a("1", localAbsBaseArticleInfo, paramLong);
    if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c())) {
      localObject1 = "0X800935C";
    } else {
      localObject1 = "0X8007BA3";
    }
    if (CmpCtxt.a(localAbsBaseArticleInfo))
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramLong = localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
      l = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mFeedId;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(paramLong), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l), "0", ((StringBuilder)localObject2).toString(), str, false);
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
      return;
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject2 = localAbsBaseArticleInfo.mSubscribeID;
    paramLong = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mFeedId;
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mArticleID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject2, (String)localObject1, (String)localObject1, 0, 0, String.valueOf(paramLong), String.valueOf(l), localStringBuilder.toString(), str, false);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (RIJQQAppInterfaceUtil.a())
    {
      List localList = a();
      if ((localList.size() > 0) && (localList.contains(Long.valueOf(paramLong))))
      {
        int i = localList.indexOf(Long.valueOf(paramLong));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[i].setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376028));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376032));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = new ReadInJoyHeadImageView[4];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[0] = ((ReadInJoyHeadImageView)findViewById(2131376015));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[1] = ((ReadInJoyHeadImageView)findViewById(2131376016));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[2] = ((ReadInJoyHeadImageView)findViewById(2131376017));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[3] = ((ReadInJoyHeadImageView)findViewById(2131376018));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131376031));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376025));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376022));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376030));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363938));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView = ((RingAvatarView)findViewById(2131375988));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369505));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    int i;
    if (b()) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
    if (b())
    {
      this.jdField_a_of_type_JavaUtilList = a();
      a(paramIReadInJoyModel, this.jdField_a_of_type_JavaUtilList);
      a(this.jdField_a_of_type_JavaUtilList);
      UtilsForComponent.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView, this.jdField_b_of_type_AndroidWidgetImageView);
      d();
      setFollowBotton();
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, List<Long> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int i = 0;
      while (i < Math.min(4, paramList.size()))
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[i].setHeadImgByUin(((Long)paramList.get(i)).longValue());
        this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[i].setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[i].setOnClickListener(new ComponentHeaderFriendRecommend.1(this, paramList, i));
        i += 1;
      }
      i = Math.min(4, paramList.size());
      while (i < 4)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[i].setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[i].setOnClickListener(null);
        i += 1;
      }
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void b()
  {
    super.b();
    Object localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout;
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.i()) && (!c()))
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), AIOUtils.b(7.5F, getResources()), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), AIOUtils.b(7.5F, getResources()));
      localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), AIOUtils.b(7.5F, getResources()), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), AIOUtils.b(15.0F, getResources()), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), AIOUtils.b(12.0F, getResources()));
      localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), AIOUtils.b(15.0F, getResources()), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 48;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    localObject = (LinearLayout)findViewById(2131376027);
    if ((((LinearLayout)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
      if (a())
      {
        ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.a(12.0F), 0, ViewUtils.a(12.0F), 0);
        return;
      }
      ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.a(12.0F), 0, ViewUtils.a(2.25F), 0);
    }
  }
  
  public boolean b()
  {
    IReadInJoyModel localIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a;
    return (localIReadInJoyModel.a()) && ((localIReadInJoyModel.a() == 2) || (localIReadInJoyModel.a() == 3));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363938)
    {
      if (i != 2131376031)
      {
        if (paramView == this)
        {
          paramView = a();
          if ((paramView != null) && (paramView.size() == 1)) {
            b(((Long)paramView.get(0)).longValue());
          }
        }
      }
      else
      {
        paramView = a();
        if ((paramView != null) && (paramView.size() == 1)) {
          b(((Long)paramView.get(0)).longValue());
        }
      }
    }
    else
    {
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      if (localAppRuntime != null)
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
        if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c())) {
          paramView = "0X800941D";
        } else {
          paramView = "0X80080EC";
        }
        RIJFrameworkReportManager.a(localAbsBaseArticleInfo, paramView, paramView, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
        ReadInJoyLogicEngine.d(localAbsBaseArticleInfo);
        if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null))
        {
          long l = localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
          ReadInJoyLogicEngine.a().a().request0x978(localAppRuntime.getAccount(), String.valueOf(l), true, "", new ComponentHeaderFriendRecommend.2(this, localAbsBaseArticleInfo));
        }
      }
      c();
    }
  }
  
  public void setFollowBotton()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    if (localSocializeFeedsInfo.h == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702490));
      return;
    }
    if ((localAbsBaseArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.h == 2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702526));
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderFriendRecommend
 * JD-Core Version:    0.7.0.1
 */