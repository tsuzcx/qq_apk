package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController.IPlayCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class ComponentContentUGCVoice
  extends LinearLayout
  implements ComponentInheritView, ReadInJoyVoicePlayController.IPlayCallback
{
  public static final String a = "ComponentContentUGCVoice";
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private UGCVoiceInfo jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo;
  
  public ComponentContentUGCVoice(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560139, this, true);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131380127));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380128));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380126));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ComponentContentUGCVoice.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (paramUGCVoiceInfo == this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849822);
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((ReadInJoyModelImpl)paramObject).a();
    paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a.c == null) {
        return;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a.c;
      if (paramObject.isEmpty()) {
        return;
      }
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((getParent() != null) && (getParent().getParent() != null)) {
          ((View)getParent().getParent()).setBackgroundColor(-460552);
        }
      }
      else if ((getParent() != null) && (getParent().getParent() != null)) {
        ((View)getParent().getParent()).setBackgroundColor(-1);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo = ((UGCVoiceInfo)paramObject.get(0));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%02d″", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo.duration) }));
      paramObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo.duration > 50) {
        paramObject.width = DisplayUtil.a(getContext(), 277.0F);
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo.duration > 40) {
        paramObject.width = DisplayUtil.a(getContext(), 237.0F);
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo.duration > 30) {
        paramObject.width = DisplayUtil.a(getContext(), 197.0F);
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo.duration > 20) {
        paramObject.width = DisplayUtil.a(getContext(), 157.0F);
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo.duration > 10) {
        paramObject.width = DisplayUtil.a(getContext(), 117.0F);
      } else {
        paramObject.width = DisplayUtil.a(getContext(), 85.0F);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramObject);
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
      localStringBuilder.append("");
      paramObject.publicAccountReportClickEvent(null, "", "0X8009CA3", "0X8009CA3", 0, 0, (String)localObject, localStringBuilder.toString(), "", "", false);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo.isPlaying)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849822);
        ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849821);
    }
  }
  
  public void b(UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (paramUGCVoiceInfo == this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849821);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUGCVoice
 * JD-Core Version:    0.7.0.1
 */