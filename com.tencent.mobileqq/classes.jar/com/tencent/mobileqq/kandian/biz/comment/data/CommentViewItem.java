package com.tencent.mobileqq.kandian.biz.comment.data;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.comment.CommentReportR5Builder;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CommentViewItem
{
  public int a;
  public SpannableStringBuilder a;
  public BaseCommentData a;
  public AbsBaseArticleInfo a;
  public CharSequence a;
  public List<SpannableStringBuilder> a;
  public boolean a;
  public int b;
  public List<CharSequence> b;
  public boolean b;
  public int c;
  public List<CharSequence> c;
  private int d = 18;
  
  public CommentViewItem(int paramInt1, int paramInt2, BaseCommentData paramBaseCommentData, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData = paramBaseCommentData;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_b_of_type_Int = paramInt1;
    boolean bool2 = true;
    boolean bool1;
    if ((paramBaseCommentData != null) && (paramBaseCommentData.isAuthorSticky)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    if ((paramBaseCommentData != null) && (paramBaseCommentData.isAuthorBottom)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    a();
  }
  
  public CommentViewItem(int paramInt, BaseCommentData paramBaseCommentData, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this(0, paramInt, paramBaseCommentData, paramAbsBaseArticleInfo);
  }
  
  private CharSequence a(SubCommentData paramSubCommentData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramSubCommentData.hasTarget())
    {
      localSpannableStringBuilder.append("回复 ");
      int i = localSpannableStringBuilder.length();
      if (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname))
      {
        localSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
        localSpannableStringBuilder.setSpan(new CommentViewItem.3(this, paramSubCommentData), i, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append("：");
      }
    }
    String str = EmotionCodecUtils.b(paramSubCommentData.getWholeStringContent());
    paramSubCommentData = str;
    if (localSpannableStringBuilder.length() > 0) {
      paramSubCommentData = localSpannableStringBuilder.append(str);
    }
    return paramSubCommentData;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return "";
      }
      return HardCodeUtil.a(2131702404);
    }
    return HardCodeUtil.a(2131702402);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (QBaseActivity.sTopActivity == null)
    {
      QLog.d("CommentViewItem", 1, "setAuthorText | sTopActivity is null");
      return;
    }
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new CommentViewItem.CustomImageSpan(this, QBaseActivity.sTopActivity, 2130849644, 2, ViewUtils.a(32.0F), ViewUtils.a(15.0F)), i, paramSpannableStringBuilder.length(), 17);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, SubCommentData paramSubCommentData)
  {
    if (!TextUtils.isEmpty(paramSubCommentData.nickName))
    {
      paramSpannableStringBuilder.append(paramSubCommentData.nickName);
      paramSpannableStringBuilder.setSpan(new CommentViewItem.1(this, paramSubCommentData), 0, paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3, BaseCommentData paramBaseCommentData)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramString1);
    paramSpannableStringBuilder.setSpan(new CommentViewItem.4(this, paramBaseCommentData, paramString2, paramString3), i, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(SubCommentData paramSubCommentData)
  {
    if (!TextUtils.isEmpty(paramSubCommentData.getWholeStringContent()))
    {
      String str = a(paramSubCommentData.getCommentMediaType());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(EmotionCodecUtils.b(paramSubCommentData.getWholeStringContent()));
      localStringBuilder.append(str);
      paramSubCommentData = new QQText(localStringBuilder.toString(), 7, this.d);
      this.jdField_b_of_type_JavaUtilList.add(paramSubCommentData);
    }
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (QBaseActivity.sTopActivity == null)
    {
      QLog.d("CommentViewItem", 1, "setFollowingStatus | sTopActivity is null");
      return;
    }
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new CommentViewItem.CustomImageSpan(this, QBaseActivity.sTopActivity, 2130849649, 2, ViewUtils.a(51.0F), ViewUtils.a(15.0F)), i, paramSpannableStringBuilder.length(), 17);
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder, SubCommentData paramSubCommentData)
  {
    if ((paramSubCommentData.hasTarget()) && (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname)))
    {
      paramSpannableStringBuilder.append(" 回复 ");
      int i = paramSpannableStringBuilder.length();
      paramSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
      paramSpannableStringBuilder.setSpan(new CommentViewItem.2(this, paramSubCommentData), i, paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void c()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    } else {
      localList.clear();
    }
    localList = this.jdField_b_of_type_JavaUtilList;
    if (localList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    } else {
      localList.clear();
    }
    localList = this.jdField_c_of_type_JavaUtilList;
    if (localList == null)
    {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
      return;
    }
    localList.clear();
  }
  
  private void d()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.getWholeStringContent()))
    {
      BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if ((localBaseCommentData instanceof CommentData))
      {
        this.jdField_a_of_type_JavaLangCharSequence = new QQText(EmotionCodecUtils.b(localBaseCommentData.getWholeStringContent()), 3, this.d);
        return;
      }
      this.jdField_a_of_type_JavaLangCharSequence = new QQText(a((SubCommentData)localBaseCommentData), 3, this.d);
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if ((localObject instanceof CommentData))
    {
      localObject = ((CommentData)localObject).subCommentList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int j = ((List)localObject).size();
        int i = 0;
        while (i < j)
        {
          if (i >= 2) {
            return;
          }
          SubCommentData localSubCommentData = (SubCommentData)((List)localObject).get(i);
          if (localSubCommentData != null)
          {
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
            a(localSpannableStringBuilder, localSubCommentData);
            b(localSpannableStringBuilder, localSubCommentData);
            this.jdField_a_of_type_JavaUtilList.add(localSpannableStringBuilder);
            a(localSubCommentData);
          }
          i += 1;
        }
      }
    }
  }
  
  private void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if ((localObject1 instanceof CommentData))
    {
      localObject1 = ((CommentData)localObject1).subCommentList;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int j = ((List)localObject1).size();
        int i = 0;
        while (i < j)
        {
          Object localObject2 = this.jdField_c_of_type_JavaUtilList;
          if ((localObject2 != null) && (((List)localObject2).size() > 2)) {
            return;
          }
          localObject2 = (SubCommentData)((List)localObject1).get(i);
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
          if (!TextUtils.isEmpty(((SubCommentData)localObject2).nickName)) {
            a(localSpannableStringBuilder, ((SubCommentData)localObject2).nickName, ((SubCommentData)localObject2).uin, new CommentReportR5Builder(this).a().a(), (BaseCommentData)localObject2);
          }
          if (((SubCommentData)localObject2).isAuthorReply()) {
            a(localSpannableStringBuilder);
          } else if (((SubCommentData)localObject2).isFollowing) {
            b(localSpannableStringBuilder);
          }
          if (!TextUtils.isEmpty(((SubCommentData)localObject2).repliedUserNickname))
          {
            localSpannableStringBuilder.append(" 回复 ");
            a(localSpannableStringBuilder, ((SubCommentData)localObject2).repliedUserNickname, ((SubCommentData)localObject2).repliedUserUin, new CommentReportR5Builder(this).a().b(((SubCommentData)localObject2).repliedUserUin).a(), (BaseCommentData)localObject2);
          }
          if (!TextUtils.isEmpty(((SubCommentData)localObject2).getWholeStringContent()))
          {
            localSpannableStringBuilder.append(": ");
            String str = a(((SubCommentData)localObject2).getCommentMediaType());
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(EmotionCodecUtils.b(((SubCommentData)localObject2).getWholeStringContent()));
            localStringBuilder.append(str);
            localSpannableStringBuilder.append(new QQText(localStringBuilder.toString(), 7, this.d));
            this.jdField_c_of_type_JavaUtilList.add(localSpannableStringBuilder);
          }
          i += 1;
        }
      }
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if ((localObject != null) && (((BaseCommentData)localObject).isAd))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.mAdTxt == null) {
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.mAdTxt)) {
        this.jdField_a_of_type_JavaLangCharSequence = new QQText(EmotionCodecUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.mAdTxt), 3, this.d);
      }
      localObject = this.jdField_c_of_type_JavaUtilList;
      if (localObject != null) {
        ((List)localObject).clear();
      }
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null) {
        ((List)localObject).clear();
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
      return;
    }
    c();
    d();
    e();
    f();
    g();
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder))
    {
      List localList = this.jdField_b_of_type_JavaUtilList;
      if ((localList != null) && (localList.size() > 0))
      {
        localList = this.jdField_a_of_type_JavaUtilList;
        if ((localList != null) && (localList.size() > 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public void b()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    localObject = ((QQAppInterface)localObject).getAccount();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.uin;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.avatarPendantUrl;
    CommentViewItem.5 local5 = new CommentViewItem.5(this);
    int i;
    if (RIJItemViewTypeUtils.m(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
      i = 2;
    } else {
      i = 1;
    }
    localUserOperationModule.request0x978((String)localObject, str1, true, str2, local5, i);
    ReadinjoyReportUtils.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, ReadinjoyReportUtils.g, true, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem
 * JD-Core Version:    0.7.0.1
 */