package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentContentUgcOriginalHeader
  extends LinearLayout
  implements ComponentView
{
  private SpannableStringBuilder jdField_a_of_type_AndroidTextSpannableStringBuilder;
  public ReadInJoyYAFolderTextView a;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  
  public ComponentContentUgcOriginalHeader(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ComponentContentUgcOriginalHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l = paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long;
    Object localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaLangString;
    Object localObject1 = ReadInJoyUserInfoModule.a(l, null);
    if (localObject1 != null) {
      localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
    } else {
      localObject1 = ReadInJoyUserInfoModule.a();
    }
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(RIJStringUtils.a((String)localObject1));
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(new ComponentContentUgcOriginalHeader.UserSpan(this, l, -3355444), 0, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length(), 33);
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(": ");
    if ((CmpCtxt.c(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)))
    {
      localObject1 = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.a.b.get(0)).e;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
      }
    }
    else if (RIJFeedsType.a(paramAbsBaseArticleInfo.mSocialFeedInfo.a))
    {
      List localList = paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject3 = new ArrayList();
      int i = localList.size();
      localObject2 = ((BiuCommentInfo)localList.get(i - 1)).mBiuComment;
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
        l = localBiuCommentInfo.mUin.longValue();
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
        ((SpannableStringBuilder)localObject1).setSpan(new ComponentContentUgcOriginalHeader.UserSpan(this, ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).jdField_a_of_type_Long, -3355444), ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).b, 17);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
      }
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new QQText(EmotionCodecUtils.b((String)localObject2), 7, 16);
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMoreSpan(new ComponentContentUgcOriginalHeader.MoreSpan(this, paramAbsBaseArticleInfo, -3355444));
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(AIOUtils.b(12.0F, paramContext.getResources()), AIOUtils.b(12.0F, paramContext.getResources()), AIOUtils.b(20.0F, paramContext.getResources()), 0);
    setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView = new ReadInJoyYAFolderTextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#606060"));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setSpanText(HardCodeUtil.a(2131702524));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMoreSpan(new ComponentContentUgcOriginalHeader.1(this));
    addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
      paramObject = (IReadInJoyModel)paramObject;
      localCmpCtxt.a(paramObject);
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null))
      {
        a(paramObject);
        if ((RIJItemViewTypeUtils.r(paramObject)) && (TextUtils.isEmpty(paramObject.businessName)))
        {
          paramObject = (LinearLayout.LayoutParams)getLayoutParams();
          paramObject.bottomMargin = AIOUtils.b(12.0F, getContext().getResources());
          setLayoutParams(paramObject);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ComponentContentUgcOriginalHeader", 2, "article info is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcOriginalHeader
 * JD-Core Version:    0.7.0.1
 */