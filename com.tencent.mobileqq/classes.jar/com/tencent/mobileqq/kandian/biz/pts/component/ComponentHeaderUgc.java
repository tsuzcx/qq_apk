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
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  public ReadInJoyNickNameTextView e;
  public ReadInJoyYAFolderTextView f;
  Button g;
  RingAvatarView h;
  ImageView i;
  public boolean j = false;
  protected ReadInJoyObserver k = new ComponentHeaderUgc.4(this);
  private ReadInJoyHeadImageView l;
  private TextView m;
  private ImageView n;
  private Context o;
  
  public ComponentHeaderUgc(Context paramContext)
  {
    super(paramContext);
    this.o = paramContext;
  }
  
  public ComponentHeaderUgc(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = paramContext;
  }
  
  private void a(long paramLong)
  {
    if ((this.a.a != null) && (this.a.a.k() != null) && (this.a.a.k().mSocialFeedInfo != null))
    {
      if (this.a.a.k().mSocialFeedInfo.s == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ReadInJoyConstants.h);
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
      Object localObject2 = this.a.a.k();
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = (AbsBaseArticleInfo)localObject2;
      String str = RIJTransMergeKanDianReport.a("3", (AbsBaseArticleInfo)localObject2, paramLong);
      if (ReadinjoyReportUtils.d(this.a.a.m())) {
        localObject1 = "0X800935C";
      } else {
        localObject1 = "0X8007BA3";
      }
      paramLong = ((AbsBaseArticleInfo)localObject2).mSocialFeedInfo.c.a;
      long l1 = this.a.a.k().mFeedId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mStrategyId);
      PublicAccountReportUtils.a(null, String.valueOf(paramLong), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l1), "0", localStringBuilder.toString(), str, false);
      RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject2, this.a.a.m());
    }
  }
  
  private void e()
  {
    if ((this.a.a != null) && (this.a.a.k() != null) && (this.a.a.k().mSocialFeedInfo != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
      this.f.setMaxLines(7);
      this.f.setMoreSpan(new ComponentHeaderUgc.1(this, localAbsBaseArticleInfo));
      if (RIJFeedsType.b(localAbsBaseArticleInfo))
      {
        this.f.setVisibility(8);
      }
      else if (localAbsBaseArticleInfo.mSocialFeedInfo.s != null)
      {
        Object localObject1 = localAbsBaseArticleInfo.mSocialFeedInfo.s;
        if ((CmpCtxt.c(localAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.x(localAbsBaseArticleInfo)))
        {
          this.f.setText(((UGCVideoInfo)localAbsBaseArticleInfo.mSocialFeedInfo.s.c.get(0)).e);
        }
        else if (RIJFeedsType.a((UGCFeedsInfo)localObject1))
        {
          List localList = localAbsBaseArticleInfo.mSocialFeedInfo.s.h.a;
          StringBuilder localStringBuilder = new StringBuilder();
          Object localObject3 = new ArrayList();
          int i1 = localList.size();
          Object localObject2 = ((BiuCommentInfo)localList.get(i1 - 1)).mBiuComment;
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
          int i2 = localStringBuilder.length();
          i1 -= 2;
          while (i1 >= 0)
          {
            BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i1);
            long l1 = localBiuCommentInfo.mUin.longValue();
            localObject1 = ReadInJoyUserInfoModule.a(l1, null);
            if (localObject1 != null) {
              localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
            } else {
              localObject1 = ReadInJoyUserInfoModule.d();
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
            ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).a = i2;
            ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).b = (i2 + ((String)localObject1).length());
            ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).c = l1;
            ((List)localObject3).add(localObject2);
            i2 = localStringBuilder.length();
            i1 -= 1;
          }
          localObject1 = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
          localObject2 = ((List)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ComponentHeaderNewSocial.BiuUserStruct)((Iterator)localObject2).next();
            ((SpannableStringBuilder)localObject1).setSpan(new ComponentHeaderUgc.UserSpan(this, ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).c, -3355444), ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).a, ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).b, 17);
          }
          if (localAbsBaseArticleInfo.mSocialFeedInfo.y == 1) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if ((this.j) && (i1 == 0))
          {
            localObject2 = HardCodeUtil.a(2131900486);
            ((SpannableStringBuilder)localObject1).append(" ");
            ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
            ((SpannableStringBuilder)localObject1).setSpan(new ComponentHeaderUgc.2(this, localAbsBaseArticleInfo), ((SpannableStringBuilder)localObject1).length() - ((String)localObject2).length(), ((SpannableStringBuilder)localObject1).length(), 33);
            ((SpannableStringBuilder)localObject1).append(" ");
            localObject3 = this.f;
            ((ReadInJoyYAFolderTextView)localObject3).b = true;
            ((ReadInJoyYAFolderTextView)localObject3).setSpanText((String)localObject2);
            this.f.setText((CharSequence)localObject1);
          }
          else
          {
            this.f.setText((CharSequence)localObject1);
          }
        }
        else if (!TextUtils.isEmpty(((UGCFeedsInfo)localObject1).f))
        {
          CharSequence localCharSequence;
          try
          {
            localObject1 = EmotionCodecUtils.c(((UGCFeedsInfo)localObject1).f);
          }
          catch (Exception localException)
          {
            QLog.d("ComponentHeaderUgc", 1, "parse bytes_comments failed ", localException);
            localCharSequence = null;
          }
          this.f.setText(new QQText(localCharSequence, 7, 16));
        }
        else
        {
          this.f.setVisibility(8);
        }
      }
      else
      {
        this.f.setVisibility(8);
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mSocialFeedInfo.w))
      {
        this.m.setText(localAbsBaseArticleInfo.mSocialFeedInfo.w);
        return;
      }
      if (localAbsBaseArticleInfo.mTime > 0L)
      {
        this.m.setText(ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(localAbsBaseArticleInfo.mSocialFeedInfo.k, true));
        return;
      }
      this.m.setText(HardCodeUtil.a(2131900491));
    }
  }
  
  private void setAvatar(long paramLong)
  {
    this.l.setHeadImgByUin(paramLong);
    this.l.setOnClickListener(this);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    if (localAbsBaseArticleInfo == null)
    {
      this.n.setVisibility(8);
      return;
    }
    if ((localAbsBaseArticleInfo.mSocialFeedInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.c != null))
    {
      if (localAbsBaseArticleInfo.mSocialFeedInfo.c.b == 1)
      {
        this.n.setVisibility(0);
        return;
      }
      this.n.setVisibility(8);
    }
  }
  
  private void setNickname(long paramLong)
  {
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      this.e.setNickNameByUin(paramLong, true);
      this.e.setOnClickListener(this);
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626196, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((RIJQQAppInterfaceUtil.g()) && (this.a.o() == paramLong)) {
      this.l.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.l = ((ReadInJoyHeadImageView)findViewById(2131428988));
    this.e = ((ReadInJoyNickNameTextView)findViewById(2131439320));
    this.e.getPaint().setFakeBoldText(true);
    this.m = ((TextView)findViewById(2131447345));
    this.f = ((ReadInJoyYAFolderTextView)findViewById(2131431757));
    this.g = ((Button)findViewById(2131429893));
    this.n = ((ImageView)findViewById(2131444225));
    this.g.setOnClickListener(this);
    this.h = ((RingAvatarView)findViewById(2131444175));
    this.i = ((ImageView)findViewById(2131436589));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    long l1 = this.a.o();
    setAvatar(l1);
    setNickname(l1);
    UtilsForComponent.a(this.a.a, this.h, this.i);
    e();
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
    ReadInJoyLogicEngineEventDispatcher.a().a(this.k);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131428988) {
      if (i1 != 2131429893)
      {
        if (i1 == 2131439320) {}
      }
      else
      {
        AppRuntime localAppRuntime = ReadInJoyUtils.b();
        if (localAppRuntime != null)
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
          if (localAbsBaseArticleInfo != null)
          {
            if (ReadinjoyReportUtils.d(localAbsBaseArticleInfo.mChannelID)) {
              paramView = "0X800941D";
            } else {
              paramView = "0X80080EC";
            }
            RIJFrameworkReportManager.a(localAbsBaseArticleInfo, paramView, paramView, (int)localAbsBaseArticleInfo.mChannelID);
            ReadInJoyLogicEngine.e(localAbsBaseArticleInfo);
            if (localAbsBaseArticleInfo.mSocialFeedInfo != null)
            {
              long l1 = localAbsBaseArticleInfo.mSocialFeedInfo.c.a;
              ReadInJoyLogicEngine.a().c().request0x978(localAppRuntime.getAccount(), String.valueOf(l1), true, "", new ComponentHeaderUgc.3(this, localAbsBaseArticleInfo));
            }
          }
        }
        d();
        return;
      }
    }
    a(this.a.o());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.k);
  }
  
  public void setFollowButton()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    if (localAbsBaseArticleInfo == null)
    {
      this.g.setVisibility(8);
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo == null)
    {
      this.g.setVisibility(8);
      return;
    }
    if (localSocializeFeedsInfo.o == 1)
    {
      this.g.setVisibility(0);
      this.g.setEnabled(true);
      this.g.getPaint().setFakeBoldText(true);
      this.g.setText(HardCodeUtil.a(2131899712));
      return;
    }
    if ((localAbsBaseArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.o == 2))
    {
      this.g.setVisibility(0);
      this.g.setText(HardCodeUtil.a(2131900516));
      this.g.getPaint().setFakeBoldText(false);
      this.g.setEnabled(false);
      return;
    }
    this.g.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderUgc
 * JD-Core Version:    0.7.0.1
 */