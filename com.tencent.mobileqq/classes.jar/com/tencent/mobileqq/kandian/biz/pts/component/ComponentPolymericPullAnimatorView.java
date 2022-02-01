package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ComponentPolymericPullAnimatorView
  extends LinearLayout
{
  Context a;
  ComponentPolymericView b;
  IReadInJoyModel c;
  int d;
  View e;
  KandianUrlImageView f;
  TextView g;
  TextView h;
  View i;
  
  public ComponentPolymericPullAnimatorView(Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    super(paramContext);
    this.a = paramContext;
    this.c = paramIReadInJoyModel;
    b();
  }
  
  private void b()
  {
    setOrientation(1);
    Object localObject1 = this.c.k();
    if ((RIJFeedsType.L((AbsBaseArticleInfo)localObject1)) || (RIJFeedsType.M((AbsBaseArticleInfo)localObject1)))
    {
      localObject2 = LayoutInflater.from(this.a).inflate(2131626172, null);
      addView((View)localObject2);
      this.f = ((KandianUrlImageView)((View)localObject2).findViewById(2131435219));
      this.g = ((TextView)((View)localObject2).findViewById(2131447463));
      this.h = ((TextView)((View)localObject2).findViewById(2131438844));
      this.i = ((View)localObject2).findViewById(2131432003);
      this.e = ((View)localObject2).findViewById(2131431280);
      if (DailyModeConfigHandler.c(this.c.m()))
      {
        localObject1 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 45.0F));
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.i.setVisibility(8);
        this.d = 2130843895;
        this.f.setImageDrawable(getResources().getDrawable(this.d));
        localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a(getContext(), 18.0F), DisplayUtil.a(getContext(), 18.0F));
        ((RelativeLayout.LayoutParams)localObject1).setMargins(DisplayUtil.a(getContext(), 12.0F), 0, DisplayUtil.a(getContext(), 6.0F), 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        this.f.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.g.setText(HardCodeUtil.a(2131900473));
        this.g.setTextColor(Color.parseColor("#262626"));
        this.g.setTypeface(Typeface.defaultFromStyle(1));
        this.g.setTextSize(0, Utils.rp2px(18.0D));
      }
      else
      {
        localObject2 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 36.0F));
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.i.setVisibility(0);
        if (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.d == 12)
        {
          this.d = 2130844095;
          this.f.setImageDrawable(getResources().getDrawable(this.d));
          this.g.setText(HardCodeUtil.a(2131900497));
        }
        else if (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.d == 13)
        {
          this.d = 2130844035;
          this.f.setImageDrawable(getResources().getDrawable(this.d));
          this.g.setText(HardCodeUtil.a(2131900493));
        }
      }
    }
    localObject1 = new RelativeLayout(this.a);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.b = new ComponentPolymericView(this.a);
    BezierSideBarView localBezierSideBarView = new BezierSideBarView(this.a);
    ((RelativeLayout)localObject1).addView(this.b, (ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).addView(localBezierSideBarView, (ViewGroup.LayoutParams)localObject2);
    this.b.setSideBarView(localBezierSideBarView);
    addView((View)localObject1);
  }
  
  public void a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.c.k();
    if ((RIJFeedsType.L(localAbsBaseArticleInfo)) || (RIJFeedsType.M(localAbsBaseArticleInfo)))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject2 = new StringBuilder();
        localObject3 = localAbsBaseArticleInfo.mNewPolymericInfo.p.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)((Iterator)localObject3).next();
          boolean bool = RIJFeedsType.L(localAbsBaseArticleInfo);
          if (bool)
          {
            localStringBuilder.append(localPackArticleInfo.p.d);
            localStringBuilder.append(",");
          }
          else
          {
            ((StringBuilder)localObject2).append(localPackArticleInfo.q.a);
            ((StringBuilder)localObject2).append(",");
          }
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        localJSONObject.put("channel_id", this.c.m());
        localJSONObject.put("rowkey", ((StringBuilder)localObject2).toString());
        localJSONObject.put("topicid", localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localAbsBaseArticleInfo.mFeedId);
      ((StringBuilder)localObject1).append("");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      if (RIJFeedsType.L(localAbsBaseArticleInfo)) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localAbsBaseArticleInfo.mStrategyId);
      ((StringBuilder)localObject3).append("");
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009828", "0X8009828", 0, 0, (String)localObject2, (String)localObject1, ((StringBuilder)localObject3).toString(), localJSONObject.toString(), false);
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mNewPolymericInfo.e)) {
        try
        {
          localObject1 = new URL(localAbsBaseArticleInfo.mNewPolymericInfo.e);
          this.f.setImagePlaceHolder(this.a.getResources().getDrawable(this.d)).setImage((URL)localObject1);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          QLog.d("ComponentPolymericPullAnimatorView topic icon", 2, localMalformedURLException, new Object[0]);
        }
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mNewPolymericInfo.f)) {
        this.g.setText(localAbsBaseArticleInfo.mNewPolymericInfo.f);
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mNewPolymericInfo.g)) {
        this.h.setText(localAbsBaseArticleInfo.mNewPolymericInfo.g);
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mNewPolymericInfo.h)) {
        this.h.setOnClickListener(new ComponentPolymericPullAnimatorView.1(this, localAbsBaseArticleInfo, localJSONObject));
      }
    }
  }
  
  public ComponentPolymericView getPolyMericView()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericPullAnimatorView
 * JD-Core Version:    0.7.0.1
 */