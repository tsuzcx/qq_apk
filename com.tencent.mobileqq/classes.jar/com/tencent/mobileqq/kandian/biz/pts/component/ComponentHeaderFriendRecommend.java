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
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  LinearLayout e;
  LinearLayout f;
  ReadInJoyHeadImageView[] g;
  ReadInJoyNickNameTextView h;
  ImageView i;
  TextView j;
  TextView k;
  Button l;
  RingAvatarView m;
  ImageView n;
  private List<Long> o = null;
  
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
    if ((!this.a.j()) && (!CmpCtxt.a(paramAbsBaseArticleInfo)))
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
    String str = paramAbsBaseArticleInfo.mSocialFeedInfo.g;
    paramAbsBaseArticleInfo = str;
    if (TextUtils.isEmpty(str)) {
      paramAbsBaseArticleInfo = "";
    }
    return paramAbsBaseArticleInfo;
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
        String str = RIJFeedsType.m(this.a.a.k());
        if (ReadinjoyReportUtils.d(this.a.a.m()))
        {
          paramString = "0X8009357";
          PublicAccountReportUtils.a(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", localJSONObject.toString(), false);
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
  
  private String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = null;
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    if ((this.a.j()) || (g()))
    {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.w)) {
        return paramAbsBaseArticleInfo.mSocialFeedInfo.w;
      }
      int i1 = paramAbsBaseArticleInfo.mSocialFeedInfo.k;
      if (i1 > 0) {
        return ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(i1, true);
      }
      str = HardCodeUtil.a(2131900463);
    }
    return str;
  }
  
  private void b(long paramLong)
  {
    if (this.a.b())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.l);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      ReadInJoyUtils.a(getContext(), (String)localObject);
    }
    else
    {
      a(paramLong);
    }
    a(RIJFeedsType.k(this.a.a.k()));
  }
  
  private void f()
  {
    if (this.a.b())
    {
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      return;
    }
    if ((!this.a.j()) && (!g()))
    {
      this.j.setVisibility(0);
      this.k.setVisibility(8);
      this.j.setText(a(this.a.a.k()));
      return;
    }
    this.j.setVisibility(0);
    this.j.setText(a(this.a.a.k()));
    Object localObject = this.a.a.k().mSocialFeedInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject).w)))
    {
      this.k.setText(((SocializeFeedsInfo)localObject).w);
      return;
    }
    localObject = b(this.a.a.k());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.k.setVisibility(8);
      return;
    }
    this.k.setVisibility(0);
    this.k.setText((CharSequence)localObject);
  }
  
  private boolean g()
  {
    if (this.a.a.k() == null) {
      return false;
    }
    return CmpCtxt.a(this.a.a.k());
  }
  
  private List<Long> getFriendRecommendUinList()
  {
    Object localObject = this.a.a.k();
    ArrayList localArrayList1 = new ArrayList();
    if (localObject == null) {
      return localArrayList1;
    }
    if (this.a.b())
    {
      localObject = new ArrayList(1);
      try
      {
        ((List)localObject).add(Long.valueOf(Long.parseLong(this.a.a.k().mSubscribeID)));
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return localObject;
      }
    }
    if ((!this.a.j()) && (!g()))
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
    localArrayList2.add(Long.valueOf(localException.mSocialFeedInfo.c.a));
    return localArrayList2;
  }
  
  private void setTitle(List<Long> paramList)
  {
    if ((paramList != null) && (paramList.size() == 1))
    {
      if ((!this.a.j()) && (!g())) {
        setOnClickListener(this);
      }
      this.h.setOnClickListener(this);
      this.h.setVisibility(0);
      if (this.a.b())
      {
        this.h.setText(RIJStringUtils.a(this.a.a.k().mSubscribeName));
        this.i.setVisibility(8);
        return;
      }
      this.h.setNickNameByUin(((Long)paramList.get(0)).longValue());
      if ((!this.a.j()) && (!g()))
      {
        this.i.setVisibility(8);
        return;
      }
      if (this.a.a.k().mSocialFeedInfo.c.b == 1)
      {
        this.i.setVisibility(0);
        return;
      }
      this.i.setVisibility(8);
      return;
    }
    setOnClickListener(null);
    this.h.setOnClickListener(null);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626189, this, true);
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ReadInJoyConstants.h);
    ((StringBuilder)localObject1).append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
    localObject1 = ((StringBuilder)localObject1).toString();
    ReadInJoyUtils.a(getContext(), (String)localObject1);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = localAbsBaseArticleInfo;
    String str = RIJTransMergeKanDianReport.a("1", localAbsBaseArticleInfo, paramLong);
    if (ReadinjoyReportUtils.d(this.a.a.m())) {
      localObject1 = "0X800935C";
    } else {
      localObject1 = "0X8007BA3";
    }
    if (CmpCtxt.a(localAbsBaseArticleInfo))
    {
      paramLong = localAbsBaseArticleInfo.mSocialFeedInfo.s.e;
      l1 = this.a.a.k().mFeedId;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mStrategyId);
      PublicAccountReportUtils.a(null, String.valueOf(paramLong), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l1), "0", ((StringBuilder)localObject2).toString(), str, false);
      RIJFrameworkReportManager.b(this.a.a.k(), this.a.a.m());
      return;
    }
    Object localObject2 = localAbsBaseArticleInfo.mSubscribeID;
    paramLong = this.a.a.k().mFeedId;
    long l1 = this.a.a.k().mArticleID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
    PublicAccountReportUtils.a(null, (String)localObject2, (String)localObject1, (String)localObject1, 0, 0, String.valueOf(paramLong), String.valueOf(l1), localStringBuilder.toString(), str, false);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (RIJQQAppInterfaceUtil.g())
    {
      List localList = getFriendRecommendUinList();
      if ((localList.size() > 0) && (localList.contains(Long.valueOf(paramLong))))
      {
        int i1 = localList.indexOf(Long.valueOf(paramLong));
        this.g[i1].setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = ((LinearLayout)findViewById(2131444228));
    this.f = ((LinearLayout)findViewById(2131444232));
    this.g = new ReadInJoyHeadImageView[4];
    this.g[0] = ((ReadInJoyHeadImageView)findViewById(2131444215));
    this.g[1] = ((ReadInJoyHeadImageView)findViewById(2131444216));
    this.g[2] = ((ReadInJoyHeadImageView)findViewById(2131444217));
    this.g[3] = ((ReadInJoyHeadImageView)findViewById(2131444218));
    this.h = ((ReadInJoyNickNameTextView)findViewById(2131444231));
    this.i = ((ImageView)findViewById(2131444225));
    this.j = ((TextView)findViewById(2131444222));
    this.k = ((TextView)findViewById(2131444230));
    this.l = ((Button)findViewById(2131429893));
    this.l.setOnClickListener(this);
    this.m = ((RingAvatarView)findViewById(2131444175));
    this.n = ((ImageView)findViewById(2131436589));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    int i1;
    if (e()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    setVisibility(i1);
    if (e())
    {
      this.o = getFriendRecommendUinList();
      a(paramIReadInJoyModel, this.o);
      setTitle(this.o);
      UtilsForComponent.a(this.a.a, this.m, this.n);
      f();
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
      int i1 = 0;
      while (i1 < Math.min(4, paramList.size()))
      {
        this.g[i1].setHeadImgByUin(((Long)paramList.get(i1)).longValue());
        this.g[i1].setVisibility(0);
        this.g[i1].setOnClickListener(new ComponentHeaderFriendRecommend.1(this, paramList, i1));
        i1 += 1;
      }
      i1 = Math.min(4, paramList.size());
      while (i1 < 4)
      {
        this.g[i1].setVisibility(8);
        this.g[i1].setOnClickListener(null);
        i1 += 1;
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
    Object localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    LinearLayout localLinearLayout;
    if ((!this.a.j()) && (!g()))
    {
      localLinearLayout = this.e;
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), AIOUtils.b(7.5F, getResources()), this.e.getPaddingRight(), AIOUtils.b(7.5F, getResources()));
      localLinearLayout = this.f;
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), AIOUtils.b(7.5F, getResources()), this.f.getPaddingRight(), this.f.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.k.setVisibility(8);
    }
    else
    {
      localLinearLayout = this.e;
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), AIOUtils.b(15.0F, getResources()), this.e.getPaddingRight(), AIOUtils.b(12.0F, getResources()));
      localLinearLayout = this.f;
      localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), AIOUtils.b(15.0F, getResources()), this.f.getPaddingRight(), this.f.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 48;
      this.k.setVisibility(0);
    }
    localObject = (LinearLayout)findViewById(2131444227);
    if ((((LinearLayout)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
      if (c())
      {
        ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.dip2px(12.0F), 0, ViewUtils.dip2px(12.0F), 0);
        return;
      }
      ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.dip2px(12.0F), 0, ViewUtils.dip2px(2.25F), 0);
    }
  }
  
  public boolean e()
  {
    IReadInJoyModel localIReadInJoyModel = this.a.a;
    return (localIReadInJoyModel.a()) && ((localIReadInJoyModel.b() == 2) || (localIReadInJoyModel.b() == 3));
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429893)
    {
      if (i1 != 2131444231)
      {
        if (paramView == this)
        {
          paramView = getFriendRecommendUinList();
          if ((paramView != null) && (paramView.size() == 1)) {
            b(((Long)paramView.get(0)).longValue());
          }
        }
      }
      else
      {
        paramView = getFriendRecommendUinList();
        if ((paramView != null) && (paramView.size() == 1)) {
          b(((Long)paramView.get(0)).longValue());
        }
      }
    }
    else
    {
      AppRuntime localAppRuntime = ReadInJoyUtils.b();
      if (localAppRuntime != null)
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
        if (ReadinjoyReportUtils.d(this.a.a.m())) {
          paramView = "0X800941D";
        } else {
          paramView = "0X80080EC";
        }
        RIJFrameworkReportManager.a(localAbsBaseArticleInfo, paramView, paramView, this.a.a.m());
        ReadInJoyLogicEngine.e(localAbsBaseArticleInfo);
        if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null))
        {
          long l1 = localAbsBaseArticleInfo.mSocialFeedInfo.c.a;
          ReadInJoyLogicEngine.a().c().request0x978(localAppRuntime.getAccount(), String.valueOf(l1), true, "", new ComponentHeaderFriendRecommend.2(this, localAbsBaseArticleInfo));
        }
      }
      d();
    }
  }
  
  public void setFollowBotton()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo == null)
    {
      this.l.setVisibility(8);
      return;
    }
    if (localSocializeFeedsInfo.o == 1)
    {
      this.l.setVisibility(0);
      this.l.setEnabled(true);
      this.l.getPaint().setFakeBoldText(true);
      this.l.setText(HardCodeUtil.a(2131899712));
      return;
    }
    if ((localAbsBaseArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.o == 2))
    {
      this.l.setVisibility(0);
      this.l.setText(HardCodeUtil.a(2131900521));
      this.l.getPaint().setFakeBoldText(false);
      this.l.setEnabled(false);
      return;
    }
    this.l.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderFriendRecommend
 * JD-Core Version:    0.7.0.1
 */