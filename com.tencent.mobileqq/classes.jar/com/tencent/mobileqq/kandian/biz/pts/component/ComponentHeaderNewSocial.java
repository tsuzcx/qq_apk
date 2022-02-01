package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentHeaderNewSocial
  extends ComponentHeaderFriendRecommend
{
  View jdField_a_of_type_AndroidViewView;
  ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView;
  View b;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public ComponentHeaderNewSocial(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderNewSocial(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderNewSocial(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private List<Long> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return null;
      }
      List localList = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      localObject = localIterator;
      if (localList != null)
      {
        if (localList.size() == 0) {
          return null;
        }
        paramAbsBaseArticleInfo = new ArrayList();
        localIterator = localList.iterator();
        for (;;)
        {
          localObject = paramAbsBaseArticleInfo;
          if (!localIterator.hasNext()) {
            break;
          }
          paramAbsBaseArticleInfo.add(Long.valueOf(((FeedsInfoUser)localIterator.next()).jdField_a_of_type_Long));
        }
      }
    }
    return localObject;
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if (paramIReadInJoyModel == null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      return;
    }
    List localList = a(paramIReadInJoyModel);
    if ((localList != null) && (localList.size() != 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("你的其他");
      localStringBuilder.append(localList.size());
      localStringBuilder.append("个好友也Biu了");
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ComponentHeaderNewSocial.1(this, paramIReadInJoyModel));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
  }
  
  private void c(IReadInJoyModel paramIReadInJoyModel)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      paramIReadInJoyModel = localAbsBaseArticleInfo.mSocialFeedInfo;
      Object localObject1;
      if ((paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList != null) && (paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.size() != 1) || ((!TextUtils.isEmpty(((BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment)) && (!TextUtils.equals(((BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, ":")) && (!TextUtils.equals(((BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, "：")))))
      {
        this.b.setVisibility(0);
        List localList = paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList;
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = new ArrayList();
        int i = localList.size();
        localObject1 = ((BiuCommentInfo)localList.get(i - 1)).mBiuComment;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith(":")) || (((String)localObject1).startsWith("："))))
        {
          paramIReadInJoyModel = ((String)localObject1).substring(1);
        }
        else
        {
          paramIReadInJoyModel = (IReadInJoyModel)localObject1;
          if (localObject1 == null) {
            paramIReadInJoyModel = "";
          }
        }
        localStringBuilder.append(paramIReadInJoyModel);
        int j = localStringBuilder.length();
        i -= 2;
        while (i >= 0)
        {
          BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i);
          long l = localBiuCommentInfo.mUin.longValue();
          paramIReadInJoyModel = ReadInJoyUserInfoModule.a(l, null);
          if (paramIReadInJoyModel != null) {
            paramIReadInJoyModel = paramIReadInJoyModel.nick;
          } else {
            paramIReadInJoyModel = ReadInJoyUserInfoModule.a();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("@");
          ((StringBuilder)localObject1).append(paramIReadInJoyModel);
          localObject1 = ((StringBuilder)localObject1).toString();
          paramIReadInJoyModel = (IReadInJoyModel)localObject1;
          if (localBiuCommentInfo.mOpType == 1)
          {
            paramIReadInJoyModel = new StringBuilder();
            paramIReadInJoyModel.append((String)localObject1);
            paramIReadInJoyModel.append(" ");
            paramIReadInJoyModel = paramIReadInJoyModel.toString();
          }
          if (localBiuCommentInfo.mBiuComment == null) {
            localObject1 = "";
          } else {
            localObject1 = localBiuCommentInfo.mBiuComment;
          }
          localStringBuilder.append(paramIReadInJoyModel);
          localStringBuilder.append((String)localObject1);
          localObject1 = new ComponentHeaderNewSocial.BiuUserStruct();
          ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).jdField_a_of_type_Int = j;
          ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).b = (j + paramIReadInJoyModel.length());
          ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).jdField_a_of_type_Long = l;
          ((List)localObject2).add(localObject1);
          j = localStringBuilder.length();
          i -= 1;
        }
        paramIReadInJoyModel = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ComponentHeaderNewSocial.BiuUserStruct)((Iterator)localObject1).next();
          paramIReadInJoyModel.setSpan(new ComponentHeaderNewSocial.UserSpan(this, ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_a_of_type_Long, -3355444), ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).b, 17);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setSpanText(HardCodeUtil.a(2131702462));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMoreSpan(new ComponentHeaderNewSocial.MoreSpan(this, localAbsBaseArticleInfo, -3355444));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(paramIReadInJoyModel);
        return;
      }
      if (!TextUtils.isEmpty(paramIReadInJoyModel.jdField_a_of_type_JavaLangString))
      {
        this.b.setVisibility(0);
        if (paramIReadInJoyModel.jdField_a_of_type_JavaLangString.length() >= 100)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramIReadInJoyModel.jdField_a_of_type_JavaLangString.substring(0, 99));
          ((StringBuilder)localObject1).append('…');
          paramIReadInJoyModel.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(paramIReadInJoyModel.jdField_a_of_type_JavaLangString);
        return;
      }
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560143, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371808);
    ApiCompatibilityUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getDrawable(2130841773));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371810));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371809));
    this.b = findViewById(2131371805);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131371806));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[1].setVisibility(8);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[2].setVisibility(8);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView[3].setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setTextSize(2, 15.5F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i;
    if (b()) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      b(paramObject);
      c(paramObject);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setTextColor(getContext().getResources().getColor(2131165327));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */