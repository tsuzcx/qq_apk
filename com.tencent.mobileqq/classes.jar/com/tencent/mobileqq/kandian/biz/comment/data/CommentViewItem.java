package com.tencent.mobileqq.kandian.biz.comment.data;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
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
  public int a = 0;
  public int b = 0;
  public BaseCommentData c;
  public AbsBaseArticleInfo d;
  public CharSequence e;
  public SpannableStringBuilder f;
  public List<SpannableStringBuilder> g;
  public List<CharSequence> h;
  public List<CharSequence> i;
  public int j = 0;
  public boolean k;
  public boolean l;
  private int m = 18;
  
  public CommentViewItem(int paramInt1, int paramInt2, BaseCommentData paramBaseCommentData, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramInt2;
    this.c = paramBaseCommentData;
    this.d = paramAbsBaseArticleInfo;
    this.b = paramInt1;
    boolean bool2 = true;
    boolean bool1;
    if ((paramBaseCommentData != null) && (paramBaseCommentData.isAuthorSticky)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    if ((paramBaseCommentData != null) && (paramBaseCommentData.isAuthorBottom)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.l = bool1;
    a();
  }
  
  public CommentViewItem(int paramInt, BaseCommentData paramBaseCommentData, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this(0, paramInt, paramBaseCommentData, paramAbsBaseArticleInfo);
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return "";
      }
      return HardCodeUtil.a(2131900408);
    }
    return HardCodeUtil.a(2131900406);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (QBaseActivity.sTopActivity == null)
    {
      QLog.d("CommentViewItem", 1, "setAuthorText | sTopActivity is null");
      return;
    }
    int n = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new CommentViewItem.CustomImageSpan(this, QBaseActivity.sTopActivity, 2130851349, 2, ViewUtils.dip2px(32.0F), ViewUtils.dip2px(15.0F)), n, paramSpannableStringBuilder.length(), 17);
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
    int n = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramString1);
    paramSpannableStringBuilder.setSpan(new CommentViewItem.4(this, paramBaseCommentData, paramString2, paramString3), n, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(SubCommentData paramSubCommentData)
  {
    if (!TextUtils.isEmpty(paramSubCommentData.getWholeStringContent()))
    {
      String str = a(paramSubCommentData.getCommentMediaType());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(EmotionCodecUtils.c(paramSubCommentData.getWholeStringContent()));
      localStringBuilder.append(str);
      paramSubCommentData = new QQText(localStringBuilder.toString(), 7, this.m);
      this.h.add(paramSubCommentData);
    }
  }
  
  private CharSequence b(SubCommentData paramSubCommentData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramSubCommentData.hasTarget())
    {
      localSpannableStringBuilder.append("回复 ");
      int n = localSpannableStringBuilder.length();
      if (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname))
      {
        localSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
        localSpannableStringBuilder.setSpan(new CommentViewItem.3(this, paramSubCommentData), n, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append("：");
      }
    }
    String str = EmotionCodecUtils.c(paramSubCommentData.getWholeStringContent());
    paramSubCommentData = str;
    if (localSpannableStringBuilder.length() > 0) {
      paramSubCommentData = localSpannableStringBuilder.append(str);
    }
    return paramSubCommentData;
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (QBaseActivity.sTopActivity == null)
    {
      QLog.d("CommentViewItem", 1, "setFollowingStatus | sTopActivity is null");
      return;
    }
    int n = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new CommentViewItem.CustomImageSpan(this, QBaseActivity.sTopActivity, 2130851354, 2, ViewUtils.dip2px(51.0F), ViewUtils.dip2px(15.0F)), n, paramSpannableStringBuilder.length(), 17);
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder, SubCommentData paramSubCommentData)
  {
    if ((paramSubCommentData.hasTarget()) && (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname)))
    {
      paramSpannableStringBuilder.append(" 回复 ");
      int n = paramSpannableStringBuilder.length();
      paramSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
      paramSpannableStringBuilder.setSpan(new CommentViewItem.2(this, paramSubCommentData), n, paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void d()
  {
    List localList = this.g;
    if (localList == null) {
      this.g = new ArrayList();
    } else {
      localList.clear();
    }
    localList = this.h;
    if (localList == null) {
      this.h = new ArrayList();
    } else {
      localList.clear();
    }
    localList = this.i;
    if (localList == null)
    {
      this.i = new ArrayList();
      return;
    }
    localList.clear();
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.c.getWholeStringContent()))
    {
      BaseCommentData localBaseCommentData = this.c;
      if ((localBaseCommentData instanceof CommentData))
      {
        this.e = new QQText(EmotionCodecUtils.c(localBaseCommentData.getWholeStringContent()), 3, this.m);
        return;
      }
      this.e = new QQText(b((SubCommentData)localBaseCommentData), 3, this.m);
    }
  }
  
  private void f()
  {
    Object localObject = this.c;
    if ((localObject instanceof CommentData))
    {
      localObject = ((CommentData)localObject).subCommentList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i1 = ((List)localObject).size();
        int n = 0;
        while (n < i1)
        {
          if (n >= 2) {
            return;
          }
          SubCommentData localSubCommentData = (SubCommentData)((List)localObject).get(n);
          if (localSubCommentData != null)
          {
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
            a(localSpannableStringBuilder, localSubCommentData);
            b(localSpannableStringBuilder, localSubCommentData);
            this.g.add(localSpannableStringBuilder);
            a(localSubCommentData);
          }
          n += 1;
        }
      }
    }
  }
  
  private void g()
  {
    Object localObject1 = this.c;
    if ((localObject1 instanceof CommentData))
    {
      localObject1 = ((CommentData)localObject1).subCommentList;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int i1 = ((List)localObject1).size();
        int n = 0;
        while (n < i1)
        {
          Object localObject2 = this.i;
          if ((localObject2 != null) && (((List)localObject2).size() > 2)) {
            return;
          }
          localObject2 = (SubCommentData)((List)localObject1).get(n);
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
          if (!TextUtils.isEmpty(((SubCommentData)localObject2).nickName)) {
            a(localSpannableStringBuilder, ((SubCommentData)localObject2).nickName, ((SubCommentData)localObject2).uin, new CommentReportR5Builder(this).a().b(), (BaseCommentData)localObject2);
          }
          if (((SubCommentData)localObject2).isAuthorReply()) {
            a(localSpannableStringBuilder);
          } else if (((SubCommentData)localObject2).isFollowing) {
            b(localSpannableStringBuilder);
          }
          if (!TextUtils.isEmpty(((SubCommentData)localObject2).repliedUserNickname))
          {
            localSpannableStringBuilder.append(" 回复 ");
            a(localSpannableStringBuilder, ((SubCommentData)localObject2).repliedUserNickname, ((SubCommentData)localObject2).repliedUserUin, new CommentReportR5Builder(this).a().b(((SubCommentData)localObject2).repliedUserUin).b(), (BaseCommentData)localObject2);
          }
          if (!TextUtils.isEmpty(((SubCommentData)localObject2).getWholeStringContent()))
          {
            localSpannableStringBuilder.append(": ");
            String str = a(((SubCommentData)localObject2).getCommentMediaType());
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(EmotionCodecUtils.c(((SubCommentData)localObject2).getWholeStringContent()));
            localStringBuilder.append(str);
            localSpannableStringBuilder.append(new QQText(localStringBuilder.toString(), 7, this.m));
            this.i.add(localSpannableStringBuilder);
          }
          n += 1;
        }
      }
    }
  }
  
  private boolean h()
  {
    BaseCommentData localBaseCommentData = this.c;
    return (localBaseCommentData != null) && (localBaseCommentData.isAd) && (this.c.advertisementInfo != null);
  }
  
  private void i()
  {
    if (!h()) {
      return;
    }
    Object localObject = (AdvertisementInfo)this.c.advertisementInfo;
    if (!TextUtils.isEmpty(((AdvertisementInfo)localObject).mAdTxt)) {
      this.e = new QQText(EmotionCodecUtils.c(((AdvertisementInfo)localObject).mAdTxt), 3, this.m);
    }
    localObject = this.i;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.g;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  public void a()
  {
    if (this.c == null) {
      return;
    }
    d();
    e();
    f();
    g();
    i();
  }
  
  public boolean b()
  {
    if (TextUtils.isEmpty(this.f))
    {
      List localList = this.h;
      if ((localList != null) && (localList.size() > 0))
      {
        localList = this.g;
        if ((localList != null) && (localList.size() > 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public void c()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().c();
    localObject = ((QQAppInterface)localObject).getAccount();
    String str1 = this.c.uin;
    String str2 = this.c.avatarPendantUrl;
    CommentViewItem.5 local5 = new CommentViewItem.5(this);
    int n;
    if (RIJItemViewTypeUtils.m(this.d)) {
      n = 2;
    } else {
      n = 1;
    }
    localUserOperationModule.request0x978((String)localObject, str1, true, str2, local5, n);
    ReadinjoyReportUtils.c(this.d, ReadinjoyReportUtils.g, true, this.c.commentId, this.c.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem
 * JD-Core Version:    0.7.0.1
 */