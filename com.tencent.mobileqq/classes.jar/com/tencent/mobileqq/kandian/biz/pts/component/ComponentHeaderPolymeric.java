package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ComponentHeaderPolymeric
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView;
  protected ReadInJoyObserver a;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ComponentHeaderPolymeric(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentHeaderPolymeric.6(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentHeaderPolymeric.6(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentHeaderPolymeric.6(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      QQToast.a(getContext(), HardCodeUtil.a(2131702505), 0).a();
      return;
    }
    if (paramInt == 2)
    {
      a(true);
      QQToast.a(getContext(), HardCodeUtil.a(2131702510), 0).a();
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    paramAbsBaseArticleInfo.mPolymericInfo.e = paramInt;
    Object localObject = paramAbsBaseArticleInfo.mGroupSubArticleList;
    boolean bool = false;
    localObject = ((AbsBaseArticleInfo)((List)localObject).get(0)).mSocialFeedInfo;
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).h = paramInt;
    }
    localObject = ReadInJoyLogicEngineEventDispatcher.a();
    long l = paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
    if (paramAbsBaseArticleInfo.mPolymericInfo.e == 2) {
      bool = true;
    }
    ((ReadInJoyLogicEngineEventDispatcher)localObject).b(l, bool);
    ThreadManager.post(new ComponentHeaderPolymeric.5(this, paramAbsBaseArticleInfo, paramInt), 5, null, true);
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("followUGCAccount followUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", followStatus = ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mPolymericInfo.e);
      ((StringBuilder)localObject).append(", articleInfoID = ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
      QLog.d("ComponentHeaderPolymeric", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ReadInJoyLogicEngine.a().a();
    paramAppRuntime = paramAppRuntime.getAccount();
    boolean bool;
    if (paramAbsBaseArticleInfo.mPolymericInfo.e != 2) {
      bool = true;
    } else {
      bool = false;
    }
    ((UserOperationModule)localObject).request0x978(paramAppRuntime, paramString, bool, paramAbsBaseArticleInfo.mPolymericInfo.c, new ComponentHeaderPolymeric.1(this, paramAbsBaseArticleInfo), 2);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setBackgroundResource(2130849620);
      this.c.setText(HardCodeUtil.a(2131702444));
      this.c.setTextColor(-2147483648);
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.c.setBackgroundResource(2130849619);
    this.c.setText(HardCodeUtil.a(2131702481));
    this.c.setTextColor(-1);
    this.c.setCompoundDrawablePadding(AIOUtils.b(3.0F, getResources()));
    this.c.setCompoundDrawablesWithIntrinsicBounds(2130849617, 0, 0, 0);
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = RIJKanDianFolderStatus.getPolymericCommonR5Report(paramAbsBaseArticleInfo.mPolymericInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
    if (RIJFeedsType.A(paramAbsBaseArticleInfo))
    {
      localObject = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0);
      String str1 = ReadinjoyReportUtils.a(getContext(), ((AbsBaseArticleInfo)localObject).mArticleID, ((AbsBaseArticleInfo)localObject).mAlgorithmID, 54, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(), ((AbsBaseArticleInfo)localObject).getInnerUniqueID(), ((AbsBaseArticleInfo)localObject).getVideoVid(), ReadinjoyReportUtils.a((AbsBaseArticleInfo)localObject), ((AbsBaseArticleInfo)localObject).videoReportInfo);
      String str2 = ReadinjoyReportUtils.b(paramAbsBaseArticleInfo.mChannelID);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long), str2, str2, 0, 0, Long.toString(((AbsBaseArticleInfo)localObject).mFeedId), String.valueOf(((AbsBaseArticleInfo)localObject).mArticleID), Integer.toString(((AbsBaseArticleInfo)localObject).mStrategyId), str1, false);
      return;
    }
    RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a());
  }
  
  private void b(AppRuntime paramAppRuntime, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followPGCAccount followUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", followStatus = ");
      localStringBuilder.append(paramAbsBaseArticleInfo.mPolymericInfo.e);
      localStringBuilder.append(", articleInfoID = ");
      localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
      QLog.d("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
    }
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (paramAbsBaseArticleInfo.mPolymericInfo.e == 1)
      {
        ReadInJoyLogicEngine.a().a().request0x978(paramAppRuntime.getAccount(), paramString, true, paramAbsBaseArticleInfo.mPolymericInfo.c, new ComponentHeaderPolymeric.2(this, paramAbsBaseArticleInfo), 1);
        return;
      }
      if (paramAbsBaseArticleInfo.mPolymericInfo.e == 2) {
        ReadInJoyLogicEngine.a().a().request0x978(paramAppRuntime.getAccount(), paramString, false, paramAbsBaseArticleInfo.mPolymericInfo.c, new ComponentHeaderPolymeric.3(this, paramAbsBaseArticleInfo), 1);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ComponentHeaderPolymeric", 2, "followPGCAccount fail, appInterface is null!");
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560145, this, true);
  }
  
  String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str;
    if (paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Long > 0L) {
      str = ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Long, true);
    } else {
      str = HardCodeUtil.a(2131702463);
    }
    Object localObject = str;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Long != paramLong) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImageBitmap(paramBitmap);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131379004);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131376029));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376021));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131376024));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376032));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376033));
    this.c = ((TextView)paramView.findViewById(2131376023));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376025));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376809);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    super.a(paramCellListener);
  }
  
  void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 10)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setVisibility(0);
  }
  
  void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    int i = paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int;
    if (i != 6)
    {
      boolean bool = false;
      switch (i)
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_a_of_type_Long = 0L;
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mPolymericInfo.c)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImage(RIJConvertString2URL.a(paramAbsBaseArticleInfo.mPolymericInfo.c));
        paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
        if (paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Int == 0) {
          bool = true;
        }
        paramString.setRound(bool);
        return;
      case 11: 
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
        if ((paramAbsBaseArticleInfo.mGroupSubArticleList == null) || (paramAbsBaseArticleInfo.mGroupSubArticleList.size() <= 0)) {
          break;
        }
        paramString = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0);
        if (((paramString instanceof BaseArticleInfo)) && (RIJItemViewTypeUtils.v(paramString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, String.valueOf(this.jdField_a_of_type_Long), 1));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_Long);
        return;
      case 10: 
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        return;
      case 9: 
        Object localObject = paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString;
        if (((String)localObject).startsWith("#"))
        {
          paramString = (String)localObject;
          if (!((String)localObject).startsWith("# "))
          {
            paramString = new StringBuilder();
            paramString.append("# ");
            paramString.append(((String)localObject).substring(1));
            paramString = paramString.toString();
          }
          paramString = new SpannableString(paramString);
          paramString.setSpan(new ForegroundColorSpan(getResources().getColor(2131166915)), 0, 1, 33);
          paramString.setSpan(new ImageSpan(getContext(), 2130843027), 1, 2, 33);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(paramString);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Long = 0L;
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mPolymericInfo.c)) {
          break;
        }
        paramString = URLDrawable.URLDrawableOptions.obtain();
        localObject = new ColorDrawable(0);
        paramString.mFailedDrawable = ((Drawable)localObject);
        paramString.mLoadingDrawable = ((Drawable)localObject);
        paramAbsBaseArticleInfo = URLDrawable.getDrawable(RIJConvertString2URL.a(paramAbsBaseArticleInfo.mPolymericInfo.c), paramString);
        paramAbsBaseArticleInfo.setTag(URLDrawableDecodeHandler.b(72, 72, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.getContext(), 2.0F)));
        paramAbsBaseArticleInfo.setDecodeHandler(URLDrawableDecodeHandler.i);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImageDrawable(paramAbsBaseArticleInfo);
        return;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, String.valueOf(this.jdField_a_of_type_Long), 1));
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    AbsBaseArticleInfo localAbsBaseArticleInfo = ((IReadInJoyModel)paramObject).a();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mPolymericInfo != null))
    {
      String str = a(localAbsBaseArticleInfo);
      a(localAbsBaseArticleInfo);
      a(localAbsBaseArticleInfo, str);
    }
    a(paramObject, localAbsBaseArticleInfo);
  }
  
  void a(Object paramObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mGroupSubArticleList != null) && (!paramAbsBaseArticleInfo.mGroupSubArticleList.isEmpty()) && (paramAbsBaseArticleInfo.mPolymericInfo != null))
    {
      int k = paramAbsBaseArticleInfo.mPolymericInfo.e;
      int i = 1;
      int j = 1;
      if ((k == 2) || (paramAbsBaseArticleInfo.mPolymericInfo.e == 1))
      {
        this.jdField_a_of_type_Boolean = true;
        if (paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
        {
          if (paramAbsBaseArticleInfo.mPolymericInfo.e == 2) {
            i = 1;
          } else {
            i = 0;
          }
          this.c.setTag(String.valueOf(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long));
          paramAbsBaseArticleInfo = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
          if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.a != null))
          {
            if (paramAbsBaseArticleInfo.a != null)
            {
              if (paramAbsBaseArticleInfo.a.jdField_a_of_type_Int == 1) {
                this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              } else {
                this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              }
            }
            else {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          else {
            this.c.setVisibility(8);
          }
        }
        else if (paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9)
        {
          if (paramAbsBaseArticleInfo.mPolymericInfo.e == 2) {
            i = j;
          } else {
            i = 0;
          }
          this.c.setTag(String.valueOf(paramAbsBaseArticleInfo.mPolymericInfo.f));
        }
        if (i == 0)
        {
          this.c.setVisibility(0);
          a(false);
        }
        else
        {
          this.c.setVisibility(8);
        }
        paramAbsBaseArticleInfo = (LinearLayout.LayoutParams)this.c.getLayoutParams();
        if (a()) {
          paramAbsBaseArticleInfo.rightMargin = DisplayUtil.a(getContext(), 12.0F);
        } else {
          paramAbsBaseArticleInfo.rightMargin = DisplayUtil.a(getContext(), 0.0F);
        }
        this.c.setLayoutParams(paramAbsBaseArticleInfo);
        if ((paramObject instanceof ReadInJoyModelImpl))
        {
          paramObject = (ReadInJoyModelImpl)paramObject;
          if ((paramObject.c() == 56) && (paramObject.jdField_b_of_type_Int != 0))
          {
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            return;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return;
      }
    }
    this.c.setVisibility(8);
    if ((QLog.isColorLevel()) && (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mPolymericInfo != null))
    {
      paramObject = new StringBuilder();
      paramObject.append("articleInfo.mPolymericInfo = ");
      paramObject.append(paramAbsBaseArticleInfo.mPolymericInfo.toString());
      QLog.d("ComponentHeaderPolymeric", 2, paramObject.toString());
    }
  }
  
  public boolean a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mPolymericInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a instanceof ReadInJoyModelImpl)))
    {
      ReadInJoyModelImpl localReadInJoyModelImpl = (ReadInJoyModelImpl)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a;
      int i = localAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int;
      if (((i == 9) || (i == 10) || (i == 11)) && (localReadInJoyModelImpl.jdField_a_of_type_Int == 56)) {
        return true;
      }
      if (i == 10) {
        return true;
      }
    }
    return super.a();
  }
  
  protected void d()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if (localAppRuntime != null)
    {
      int i = 0;
      this.jdField_a_of_type_Boolean = false;
      AbsBaseArticleInfo localAbsBaseArticleInfo1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c())) {
        str = "0X800941D";
      } else {
        str = "0X80080EC";
      }
      RIJFrameworkReportManager.a(localAbsBaseArticleInfo1, str, str, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
      ReadInJoyLogicEngine.d(localAbsBaseArticleInfo1);
      String str = String.valueOf(localAbsBaseArticleInfo1.mPolymericInfo.jdField_b_of_type_Long);
      if ((localAbsBaseArticleInfo1.mGroupSubArticleList != null) && (localAbsBaseArticleInfo1.mGroupSubArticleList.size() > 0))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo2 = (AbsBaseArticleInfo)localAbsBaseArticleInfo1.mGroupSubArticleList.get(0);
        if (((localAbsBaseArticleInfo2 instanceof BaseArticleInfo)) && (RIJItemViewTypeUtils.v(localAbsBaseArticleInfo2))) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        a(localAppRuntime, str, localAbsBaseArticleInfo1);
        return;
      }
      b(localAppRuntime, str, localAbsBaseArticleInfo1);
    }
  }
  
  protected void e()
  {
    Object localObject1 = ReadInJoyUtils.a();
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mGroupSubArticleList.get(0);
    localObject1 = ((AppRuntime)localObject1).getAccount();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("followPGCAccount topicID = ");
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mPolymericInfo.f);
      ((StringBuilder)localObject2).append(", followStatus = ");
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mPolymericInfo.e);
      ((StringBuilder)localObject2).append(", articleInfoID = ");
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mArticleID);
      QLog.d("ComponentHeaderPolymeric", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = ReadInJoyLogicEngine.a().a();
    String str = Long.toString(localAbsBaseArticleInfo.mPolymericInfo.f);
    boolean bool;
    if (localAbsBaseArticleInfo.mPolymericInfo.e != 2) {
      bool = true;
    } else {
      bool = false;
    }
    ((UserOperationModule)localObject2).request0x978((String)localObject1, str, bool, localAbsBaseArticleInfo.mPolymericInfo.c, new ComponentHeaderPolymeric.4(this, localAbsBaseArticleInfo), 3);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    switch (paramView.getId())
    {
    default: 
    case 2131376024: 
    case 2131376029: 
      switch (localAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
      {
      case 10: 
      default: 
        break;
      case 11: 
        paramView = new StringBuilder();
        paramView.append(ReadInJoyConstants.k);
        paramView.append(Base64Util.encodeToString(String.valueOf(localAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2));
        paramView = paramView.toString();
        ReadInJoyUtils.a(getContext(), paramView);
        break;
      case 7: 
      case 8: 
      case 9: 
        ReadInJoyUtils.a(getContext(), localAbsBaseArticleInfo.mPolymericInfo.d);
        break;
      case 6: 
        paramView = new StringBuilder();
        paramView.append(ReadInJoyConstants.g);
        paramView.append(Base64Util.encodeToString(String.valueOf(localAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2));
        paramView = paramView.toString();
        ReadInJoyUtils.a(getContext(), paramView);
      }
      b(localAbsBaseArticleInfo);
      return;
    case 2131376023: 
      if ((localAbsBaseArticleInfo.mPolymericInfo.e != 2) && (localAbsBaseArticleInfo.mPolymericInfo.e != 1)) {
        return;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        QQToast.a(getContext(), HardCodeUtil.a(2131702464), 0).a();
        if (QLog.isColorLevel()) {
          QLog.d("ComponentHeaderPolymeric", 2, "click when the button is disabled");
        }
        return;
      }
      if (localAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
      {
        d();
        return;
      }
      if (localAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9) {
        e();
      }
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric
 * JD-Core Version:    0.7.0.1
 */