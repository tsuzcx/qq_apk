package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ComponentHeaderUgc
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  RingAvatarView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  public ReadInJoyNickNameTextView a;
  public ReadInJoyYAFolderTextView a;
  protected ReadInJoyObserver a;
  public boolean a;
  private ImageView b;
  
  public ComponentHeaderUgc(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentHeaderUgc.4(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ComponentHeaderUgc(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentHeaderUgc.4(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(paramLong);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(this);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (localAbsBaseArticleInfo == null)
    {
      this.b.setVisibility(8);
      return;
    }
    if ((localAbsBaseArticleInfo.mSocialFeedInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null))
    {
      if (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Int == 1)
      {
        this.b.setVisibility(0);
        return;
      }
      this.b.setVisibility(8);
    }
  }
  
  private void b(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(paramLong, true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setOnClickListener(this);
    }
  }
  
  private void c(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ReadInJoyConstants.g);
      ((StringBuilder)localObject1).append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      localObject1 = ((StringBuilder)localObject1).toString();
      ReadInJoyUtils.a(getContext(), (String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("personal url =");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("ComponentHeaderUgc", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = (AbsBaseArticleInfo)localObject2;
      String str = RIJTransMergeKanDianReport.a("3", (AbsBaseArticleInfo)localObject2, paramLong);
      if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c())) {
        localObject1 = "0X800935C";
      } else {
        localObject1 = "0X8007BA3";
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramLong = ((AbsBaseArticleInfo)localObject2).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mFeedId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(paramLong), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l), "0", localStringBuilder.toString(), str, false);
      RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMoreSpan(new ComponentHeaderUgc.1(this, localAbsBaseArticleInfo));
      if (RIJFeedsType.b(localAbsBaseArticleInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setVisibility(8);
      }
      else if (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)
      {
        Object localObject1 = localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo;
        if ((CmpCtxt.c(localAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.x(localAbsBaseArticleInfo)))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(((UGCVideoInfo)localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).e);
        }
        else if (RIJFeedsType.a((UGCFeedsInfo)localObject1))
        {
          List localList = localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a;
          StringBuilder localStringBuilder = new StringBuilder();
          Object localObject3 = new ArrayList();
          int i = localList.size();
          Object localObject2 = ((BiuCommentInfo)localList.get(i - 1)).mBiuComment;
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith(":")) || (((String)localObject2).startsWith("："))))
          {
            localObject1 = ((String)localObject2).substring(1);
          }
          else
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
          localStringBuilder.append((String)localObject1);
          int j = localStringBuilder.length();
          i -= 2;
          while (i >= 0)
          {
            BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i);
            long l = localBiuCommentInfo.mUin.longValue();
            localObject1 = ReadInJoyUserInfoModule.a(l, null);
            if (localObject1 != null) {
              localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
            } else {
              localObject1 = ReadInJoyUserInfoModule.a();
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("@");
            ((StringBuilder)localObject2).append((String)localObject1);
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject1 = localObject2;
            if (localBiuCommentInfo.mOpType == 1)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append(" ");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            if (localBiuCommentInfo.mBiuComment == null) {
              localObject2 = "";
            } else {
              localObject2 = localBiuCommentInfo.mBiuComment;
            }
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append((String)localObject2);
            localObject2 = new ComponentHeaderNewSocial.BiuUserStruct();
            ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_a_of_type_Int = j;
            ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).b = (j + ((String)localObject1).length());
            ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_a_of_type_Long = l;
            ((List)localObject3).add(localObject2);
            j = localStringBuilder.length();
            i -= 1;
          }
          localObject1 = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
          localObject2 = ((List)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ComponentHeaderNewSocial.BiuUserStruct)((Iterator)localObject2).next();
            ((SpannableStringBuilder)localObject1).setSpan(new ComponentHeaderUgc.UserSpan(this, ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).jdField_a_of_type_Long, -3355444), ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).b, 17);
          }
          if (localAbsBaseArticleInfo.mSocialFeedInfo.j == 1) {
            i = 1;
          } else {
            i = 0;
          }
          if ((this.jdField_a_of_type_Boolean) && (i == 0))
          {
            localObject2 = HardCodeUtil.a(2131702487);
            ((SpannableStringBuilder)localObject1).append(" ");
            ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
            ((SpannableStringBuilder)localObject1).setSpan(new ComponentHeaderUgc.2(this, localAbsBaseArticleInfo), ((SpannableStringBuilder)localObject1).length() - ((String)localObject2).length(), ((SpannableStringBuilder)localObject1).length(), 33);
            ((SpannableStringBuilder)localObject1).append(" ");
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView;
            ((ReadInJoyYAFolderTextView)localObject3).jdField_a_of_type_Boolean = true;
            ((ReadInJoyYAFolderTextView)localObject3).setSpanText((String)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText((CharSequence)localObject1);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText((CharSequence)localObject1);
          }
        }
        else if (!TextUtils.isEmpty(((UGCFeedsInfo)localObject1).jdField_a_of_type_JavaLangString))
        {
          CharSequence localCharSequence;
          try
          {
            localObject1 = EmotionCodecUtils.b(((UGCFeedsInfo)localObject1).jdField_a_of_type_JavaLangString);
          }
          catch (Exception localException)
          {
            QLog.d("ComponentHeaderUgc", 1, "parse bytes_comments failed ", localException);
            localCharSequence = null;
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(new QQText(localCharSequence, 7, 16));
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setVisibility(8);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setVisibility(8);
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mSocialFeedInfo.d))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mSocialFeedInfo.d);
        return;
      }
      if (localAbsBaseArticleInfo.mTime > 0L)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(localAbsBaseArticleInfo.mSocialFeedInfo.e, true));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702495));
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560149, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((RIJQQAppInterfaceUtil.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a() == paramLong)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131363135));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131371877));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378688));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365536));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363938));
    this.b = ((ImageView)findViewById(2131376025));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView = ((RingAvatarView)findViewById(2131375988));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369505));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a();
    a(l);
    b(l);
    UtilsForComponent.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView, this.jdField_a_of_type_AndroidWidgetImageView);
    d();
    setFollowButton();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363135) {
      if (i != 2131363938)
      {
        if (i == 2131371877) {}
      }
      else
      {
        AppRuntime localAppRuntime = ReadInJoyUtils.a();
        if (localAppRuntime != null)
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
          if (localAbsBaseArticleInfo != null)
          {
            if (ReadinjoyReportUtils.a(localAbsBaseArticleInfo.mChannelID)) {
              paramView = "0X800941D";
            } else {
              paramView = "0X80080EC";
            }
            RIJFrameworkReportManager.a(localAbsBaseArticleInfo, paramView, paramView, (int)localAbsBaseArticleInfo.mChannelID);
            ReadInJoyLogicEngine.d(localAbsBaseArticleInfo);
            if (localAbsBaseArticleInfo.mSocialFeedInfo != null)
            {
              long l = localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
              ReadInJoyLogicEngine.a().a().request0x978(localAppRuntime.getAccount(), String.valueOf(l), true, "", new ComponentHeaderUgc.3(this, localAbsBaseArticleInfo));
            }
          }
        }
        c();
        return;
      }
    }
    c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void setFollowButton()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (localAbsBaseArticleInfo == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
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
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702530));
      return;
    }
    if ((localAbsBaseArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.h == 2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702521));
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderUgc
 * JD-Core Version:    0.7.0.1
 */