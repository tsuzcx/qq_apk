package com.tencent.mobileqq.nearby.profilecard;

import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.profile.like.PraiseAnimation;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NearbyCardVoteView
  extends RelativeLayout
  implements PraiseManager.OnPraiseLoadListener
{
  public static int m = 11;
  public static int n = 12;
  public FrameLayout a;
  public TextView b;
  public QQAppInterface c;
  View d;
  View e;
  TextView f;
  public int g;
  public int h;
  public boolean i = true;
  public boolean j = false;
  HeartLayout k;
  FloatViewBuilderFactory l;
  Handler o = new NearbyCardVoteView.1(this);
  PraiseAnimation p = new PraiseAnimation();
  private double q;
  private boolean r;
  private boolean s;
  private NearbyPeopleCard t;
  private boolean u = false;
  
  public NearbyCardVoteView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public NearbyCardVoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public NearbyCardVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.r = false;
    this.s = false;
    this.g = 0;
    this.h = 0;
    this.l = new FloatViewBuilderFactory(getContext());
    this.p.g = this.l;
    Object localObject = getResources();
    this.q = ((Resources)localObject).getDisplayMetrics().density;
    this.d = new View(getContext());
    double d1 = this.q;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(d1 * 50.0D), (int)(d1 * 50.0D));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    this.d.setBackgroundResource(2130847147);
    addView(this.d, localLayoutParams);
    this.e = new SingleLineTextView(getContext());
    this.e.setBackgroundResource(2130847546);
    this.e.setId(2131437182);
    d1 = this.q;
    localLayoutParams = new RelativeLayout.LayoutParams((int)(d1 * 25.0D), (int)(d1 * 25.0D));
    localLayoutParams.topMargin = ((int)(this.q * 15.0D));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(10);
    addView(this.e, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = ((int)(this.q * 2.0D));
    this.f = new TextView(getContext());
    this.f.setTextSize(1, 12.0F);
    this.f.setTextColor(-15550475);
    addView(this.f, localLayoutParams);
    this.a = new FrameLayout(getContext());
    this.a.setId(2131436549);
    this.a.setBackgroundResource(2130852599);
    this.a.setMinimumHeight((int)(this.q * 6.0D));
    this.a.setMinimumWidth((int)(this.q * 6.0D));
    this.a.setContentDescription(((Resources)localObject).getString(2131888097));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.a, (ViewGroup.LayoutParams)localObject);
    this.b = new TextView(getContext());
    this.b.setId(2131439266);
    this.b.setTextSize(1, 11.0F);
    this.b.setTextColor(-1);
    this.a.addView(this.b, -2, -2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new int[2];
    this.e.getLocationInWindow((int[])localObject);
    float f1 = localObject[0] + this.e.getWidth() / 2;
    float f2 = localObject[1] - this.e.getHeight() / 2;
    localObject = this.l.a(paramInt2, this.k.d);
    if (paramInt1 > 0)
    {
      this.p.a(this.c, this.k, ((BaseFloatViewBuilder)localObject).a(), this, paramInt1, true, paramInt2, f1, f2);
      return;
    }
    if (paramInt2 == 2)
    {
      this.k.a(((BaseFloatViewBuilder)localObject).a(), this.c, (BaseFloatViewBuilder)localObject, f1 - DisplayUtil.a(getContext(), 20.0F), f2 - DisplayUtil.a(getContext(), 120.0F), DisplayUtil.a(getContext(), 75.0F), DisplayUtil.a(getContext(), 65.0F));
      return;
    }
    this.k.a(((BaseFloatViewBuilder)localObject).a(), f1, f2);
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      return;
    }
    if (paramPraiseInfo != null)
    {
      if ((!this.s) && (paramInt1 == PraiseManager.a(this.c))) {
        a(paramPraiseInfo);
      }
      paramPraiseInfo = (Pair)this.p.h.get(paramInt1);
      if (paramPraiseInfo != null)
      {
        float f1 = ((Point)paramPraiseInfo.first).x;
        float f2 = ((Point)paramPraiseInfo.first).y;
        paramInt2 = ((Integer)paramPraiseInfo.second).intValue();
        paramPraiseInfo = this.p;
        paramString = this.c;
        HeartLayout localHeartLayout = this.k;
        paramPraiseInfo.a(paramString, localHeartLayout, this.l.a(paramInt2, localHeartLayout.d).a(), this, paramInt1, false, paramInt2, f1, f2);
        this.p.h.remove(paramInt1);
      }
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo)
  {
    if ((!this.s) && (paramPraiseInfo != null) && (!this.p.f))
    {
      Object localObject = this.p;
      ((PraiseAnimation)localObject).c = this.e;
      ((PraiseAnimation)localObject).e = new BitmapDrawable(getResources(), paramPraiseInfo.f);
      paramPraiseInfo = (INearbyLikeLimitManager)this.c.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      localObject = this.t;
      boolean bool;
      if ((localObject != null) && (paramPraiseInfo.a(Long.valueOf(((NearbyPeopleCard)localObject).uin).longValue()))) {
        bool = true;
      } else {
        bool = false;
      }
      this.p.a(this.r, bool, this.e.getBackground(), getResources());
      this.e.startAnimation(PraiseAnimation.a(this.p, 1.0F, 0.3F));
      this.p.f = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    HeartLayout localHeartLayout = this.k;
    if (localHeartLayout != null) {
      localHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.s) && (this.h > 0))
    {
      localObject1 = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      int i2;
      int i1;
      if (paramBoolean)
      {
        i2 = 2130852589;
        i1 = this.g;
        i1 = i2;
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).width = -2;
          ((RelativeLayout.LayoutParams)localObject1).height = -2;
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(3.0D % this.q + 0.5D));
          i1 = i2;
        }
      }
      else
      {
        i2 = 2130852592;
        i1 = this.g;
        i1 = this.h;
        i1 = i2;
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).width = -2;
          ((RelativeLayout.LayoutParams)localObject1).height = -2;
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          i1 = i2;
        }
      }
      this.a.setBackgroundResource(i1);
      if (localObject1 != null) {
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      } else {
        QLog.e("VoteView", 1, "mRedDotView.setLayoutParams(pa) pa == null");
      }
      this.a.setVisibility(paramInt);
      localObject2 = this.b;
      if (paramBoolean)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("+");
        ((StringBuilder)localObject1).append(this.h);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    else
    {
      paramInt = this.g;
      this.a.setVisibility(4);
    }
    Object localObject1 = this.f;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.g);
    ((StringBuilder)localObject2).append("");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3, boolean paramBoolean4, List<TPraiseInfo> paramList)
  {
    this.s = paramBoolean1;
    this.r = paramBoolean2;
    int i2 = 0;
    if (paramInt1 > 0) {
      i1 = paramInt1;
    } else {
      i1 = 0;
    }
    this.g = i1;
    int i1 = this.g;
    if (paramInt2 > i1) {
      this.h = (i1 % 20);
    } else if (paramInt2 < 0) {
      this.h = 0;
    } else {
      this.h = paramInt2;
    }
    this.g -= paramInt2;
    Object localObject1 = (INearbyLikeLimitManager)this.c.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
    if ((!this.s) && (this.r))
    {
      try
      {
        if ((this.t != null) && (((INearbyLikeLimitManager)localObject1).a(Long.valueOf(this.t.uin).longValue())))
        {
          paramNewVoteAnimHelper = getResources().getDrawable(2130843642);
          this.f.setTextColor(-13291);
        }
        else if (!this.i)
        {
          paramNewVoteAnimHelper = getResources().getDrawable(2130847166);
          this.f.setTextColor(-52924);
        }
        else
        {
          paramNewVoteAnimHelper = getResources().getDrawable(2130847546);
          this.f.setTextColor(-15550475);
        }
      }
      catch (NumberFormatException paramNewVoteAnimHelper)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VoteView", 2, paramNewVoteAnimHelper.toString(), paramNewVoteAnimHelper);
        }
        paramNewVoteAnimHelper = getResources().getDrawable(2130847546);
        this.f.setTextColor(-15550475);
      }
    }
    else if (this.i)
    {
      paramNewVoteAnimHelper = getResources().getDrawable(2130843644);
      this.f.setTextColor(-1);
    }
    else
    {
      paramNewVoteAnimHelper = getResources().getDrawable(2130847168);
      this.f.setTextColor(-8947849);
      this.d.setBackgroundDrawable(new ColorDrawable(0));
    }
    Object localObject2;
    if (this.p.f)
    {
      localObject2 = this.t;
      if ((localObject2 != null) && (((INearbyLikeLimitManager)localObject1).a(Long.valueOf(((NearbyPeopleCard)localObject2).uin).longValue()))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      this.p.a(this.r, paramBoolean1, paramNewVoteAnimHelper, getResources());
    }
    else
    {
      this.e.setBackgroundDrawable(paramNewVoteAnimHelper);
      if (!this.i)
      {
        this.d.setBackgroundDrawable(new ColorDrawable(0));
        double d1 = this.q;
        paramNewVoteAnimHelper = new RelativeLayout.LayoutParams((int)(d1 * 32.0D), (int)(d1 * 32.0D));
        paramNewVoteAnimHelper.topMargin = ((int)(this.q * 15.0D));
        paramNewVoteAnimHelper.addRule(14);
        paramNewVoteAnimHelper.addRule(10);
        this.e.setLayoutParams(paramNewVoteAnimHelper);
      }
    }
    if ((!this.s) && (!this.p.f) && (!paramBoolean3))
    {
      i1 = PraiseManager.a(this.c);
      if (i1 > 0)
      {
        paramNewVoteAnimHelper = (PraiseManager)this.c.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        paramNewVoteAnimHelper.a(this);
        a(paramNewVoteAnimHelper.a(i1, true, "from_profile_card"));
      }
    }
    paramNewVoteAnimHelper = new StringBuilder();
    paramNewVoteAnimHelper.append(this.g);
    paramNewVoteAnimHelper.append(HardCodeUtil.a(2131904983));
    setContentDescription(paramNewVoteAnimHelper.toString());
    if (!this.s)
    {
      a(false, 4);
      if (paramBoolean3)
      {
        paramInt2 = PraiseManager.a(this.c);
        if (paramBoolean4) {
          paramInt1 = i2;
        } else {
          paramInt1 = 2;
        }
        a(paramInt2, paramInt1);
      }
      paramNewVoteAnimHelper = this.f;
      paramList = new StringBuilder();
      paramList.append(this.g);
      paramList.append("");
      paramNewVoteAnimHelper.setText(paramList.toString());
      return;
    }
    if ((!this.j) && (paramInt2 > 0) && (!this.u))
    {
      this.u = true;
      paramNewVoteAnimHelper = this.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramInt2);
      paramNewVoteAnimHelper.setText(((StringBuilder)localObject1).toString());
      a(false, 0);
      i1 = getContext().getSharedPreferences("nearby_card_reddot_num", 0).getInt("voteNum", -1);
      i2 = getContext().getSharedPreferences("nearby_card_reddot_num", 0).getInt("increaseNum", -1);
      if ((i1 != paramInt1) || (i2 != paramInt2))
      {
        paramNewVoteAnimHelper = this.o.obtainMessage(n, paramInt1, paramInt2, paramList);
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          localObject1 = (PraiseManager)this.c.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
          localObject2 = new HashSet();
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            TPraiseInfo localTPraiseInfo = (TPraiseInfo)localIterator.next();
            if (localTPraiseInfo.uCustomId > 0L) {
              ((Set)localObject2).add(Integer.valueOf((int)localTPraiseInfo.uCustomId));
            }
          }
          if (((PraiseManager)localObject1).a((Set)localObject2, new NearbyCardVoteView.2(this, paramInt1, paramInt2, paramList)))
          {
            paramNewVoteAnimHelper.sendToTarget();
            return;
          }
          this.o.sendMessageDelayed(paramNewVoteAnimHelper, PraiseConfigHelper.d);
          return;
        }
        paramNewVoteAnimHelper.sendToTarget();
      }
    }
    else
    {
      a(false, 0);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (PraiseManager)((QQAppInterface)localObject).getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
      if (localObject != null) {
        ((PraiseManager)localObject).b(this);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public void setAppInterface(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
  }
  
  public void setHeartLayout(HeartLayout paramHeartLayout)
  {
    this.k = paramHeartLayout;
    FloatViewBuilder.a(this.k);
  }
  
  public void setIsTribe(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setNearbyPeopleCard(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.t = paramNearbyPeopleCard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView
 * JD-Core Version:    0.7.0.1
 */