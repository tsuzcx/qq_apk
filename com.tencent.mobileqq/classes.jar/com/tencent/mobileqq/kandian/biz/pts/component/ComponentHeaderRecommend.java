package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.utils.Base64Util;
import java.text.DecimalFormat;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentHeaderRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  public ReadInJoyNickNameTextView e;
  public ReadInJoyYAFolderTextView f;
  private ReadInJoyHeadImageView g;
  private TextView h;
  private Button i;
  
  public ComponentHeaderRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderRecommend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e()
  {
    this.i.setOnClickListener(this);
    if (f())
    {
      this.i.setText(HardCodeUtil.a(2131900439));
      this.i.setTextColor(Color.parseColor("#BBBBBB"));
      this.i.setEnabled(false);
      this.i.getPaint().setFakeBoldText(false);
      return;
    }
    this.i.setText(HardCodeUtil.a(2131899712));
    this.i.setTextColor(Color.parseColor("#07D0B0"));
    this.i.setEnabled(true);
    this.i.getPaint().setFakeBoldText(true);
  }
  
  private boolean f()
  {
    try
    {
      boolean bool = FollowListInfoModule.a(getUin(), null);
      return bool;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return false;
  }
  
  private void g()
  {
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      Object localObject = this.a.a.k();
      this.e.setText(RIJStringUtils.a(((AbsBaseArticleInfo)localObject).mSubscribeName));
      this.e.setOnClickListener(this);
      if ((((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null) && (RIJItemViewTypeUtils.g((AbsBaseArticleInfo)localObject)) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.c.b == 1))
      {
        localObject = getResources().getDrawable(2130846453);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.b(16.0F, getResources()), AIOUtils.b(16.0F, getResources()));
        this.e.setCompoundDrawables(null, null, (Drawable)localObject, null);
        this.e.setCompoundDrawablePadding(AIOUtils.b(4.0F, getResources()));
      }
    }
  }
  
  private long getUin()
  {
    try
    {
      long l = Long.parseLong(this.a.a.k().mSubscribeID);
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return 0L;
  }
  
  private void h()
  {
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
      this.f.setMaxLines(7);
      this.f.setSpanText(HardCodeUtil.a(2131900450));
      this.f.setMoreSpan(new ComponentHeaderRecommend.1(this));
      if (RIJFeedsType.O(localAbsBaseArticleInfo)) {
        this.f.setVisibility(8);
      } else {
        this.f.setText(localAbsBaseArticleInfo.mSummary);
      }
      i();
      this.h.setOnClickListener(this);
    }
  }
  
  private void i()
  {
    Object localObject1 = this.a.a.k();
    if (RIJFeedsType.O((AbsBaseArticleInfo)localObject1))
    {
      if (((AbsBaseArticleInfo)localObject1).mTime > 0L)
      {
        this.h.setText(ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.k, true));
        return;
      }
      this.h.setText(HardCodeUtil.a(2131900469));
      return;
    }
    if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo != null)
    {
      if (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.w))
      {
        this.h.setText(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.w);
        return;
      }
      if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.t != null)
      {
        int j = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.t.d;
        if (j >= 10000)
        {
          localObject1 = new DecimalFormat("####.0");
          localObject2 = new StringBuilder();
          double d = j;
          Double.isNaN(d);
          ((StringBuilder)localObject2).append(((DecimalFormat)localObject1).format(d / 10000.0D));
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131900468));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(j);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        Object localObject2 = this.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(HardCodeUtil.a(2131900462));
        ((TextView)localObject2).setText(localStringBuilder.toString());
      }
    }
  }
  
  private void j()
  {
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
      Object localObject2 = new StringBuilder();
      Object localObject1 = "";
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(getUin());
      String str = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(ReadInJoyConstants.l);
      ((StringBuilder)localObject2).append(Base64Util.encodeToString(String.valueOf(getUin()).getBytes(), 2));
      localObject2 = ((StringBuilder)localObject2).toString();
      ReadInJoyUtils.a(getContext(), (String)localObject2);
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        ((JSONObject)localObject2).put("rowkey", localAbsBaseArticleInfo.innerUniqueID);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJAppSetting.b());
        ((JSONObject)localObject2).put("kandian_mode", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJTransMergeKanDianReport.b());
        ((JSONObject)localObject2).put("tab_source", localStringBuilder.toString());
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      PublicAccountReportUtils.a(null, str, "0X80080ED", "0X80080ED", 0, 0, String.valueOf(localAbsBaseArticleInfo.mFeedId), String.valueOf(localAbsBaseArticleInfo.mArticleID), "", (String)localObject1, false);
    }
  }
  
  private void k()
  {
    if (!f())
    {
      this.i.setText(HardCodeUtil.a(2131900440));
      this.i.setTextColor(Color.parseColor("#BBBBBB"));
      this.i.setEnabled(false);
      this.i.getPaint().setFakeBoldText(false);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.a.a != null) && (this.a.a.k() != null))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
        if ((localAbsBaseArticleInfo.mGroupSubArticleList != null) && (localAbsBaseArticleInfo.mGroupSubArticleList.size() > 0))
        {
          localAbsBaseArticleInfo = (AbsBaseArticleInfo)localAbsBaseArticleInfo.mGroupSubArticleList.get(0);
          if ((!(localAbsBaseArticleInfo instanceof BaseArticleInfo)) || (RIJItemViewTypeUtils.v(localAbsBaseArticleInfo)))
          {
            j = 2;
            break label153;
          }
        }
      }
      int j = 1;
      label153:
      ReadInJoyLogicEngine.a().c().request0x978(localQQAppInterface.getAccount(), getUin(), true, "", new ComponentHeaderRecommend.2(this), j);
      d();
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626191, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.g = ((ReadInJoyHeadImageView)findViewById(2131428988));
    this.e = ((ReadInJoyNickNameTextView)findViewById(2131439320));
    this.h = ((TextView)findViewById(2131431437));
    this.f = ((ReadInJoyYAFolderTextView)findViewById(2131431757));
    this.i = ((Button)findViewById(2131429893));
    this.i.getPaint().setFakeBoldText(true);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    long l = getUin();
    this.g.setHeadImgByUin(l);
    this.g.setOnClickListener(this);
    g();
    h();
    e();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131429893: 
      k();
      return;
    }
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderRecommend
 * JD-Core Version:    0.7.0.1
 */