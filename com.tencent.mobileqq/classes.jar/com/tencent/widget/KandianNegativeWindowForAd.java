package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class KandianNegativeWindowForAd
  extends KandianNegativeWindow
  implements View.OnClickListener
{
  HashMap<Integer, DislikeInfo> S = new HashMap();
  ArrayList<DislikeInfo> T = new ArrayList();
  ArrayList<DislikeInfo> U = new ArrayList();
  ArrayList<DislikeInfo> V = new ArrayList();
  ArrayList<DislikeInfo> W = new ArrayList();
  ArrayList<DislikeInfo> X = new ArrayList();
  View Y;
  View Z;
  View aa;
  View ab;
  View ac;
  KandianNegativeWindow.iClickInterface ad = new KandianNegativeWindowForAd.1(this);
  private KandianNegativeWindowForAd.OnComplainListener ae;
  private KandianNegativeWindowForAd.OnDiversionListener af;
  
  public KandianNegativeWindowForAd(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    this.f = LayoutInflater.from(this.b).inflate(2131626295, null);
    setContentView(this.f);
    setHeight(-2);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    try
    {
      a(this.f);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void g()
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).showDiversionBar())
    {
      DislikeInfo localDislikeInfo = new DislikeInfo();
      localDislikeInfo.c = "安装看点App，干净无广告";
      localDislikeInfo.d = 0;
      this.X.add(localDislikeInfo);
      a(this.X, this.ac, 2130842626, localDislikeInfo.c, false);
      this.ab.findViewById(2131445643).setVisibility(0);
      this.ac.findViewById(2131445643).setVisibility(4);
      setBackgroundDrawable(new ColorDrawable());
    }
    else
    {
      this.ab.findViewById(2131445643).setVisibility(4);
      a(new ArrayList(), this.ac, 2130842626, "安装看点App，干净无广告", false);
    }
    setBackgroundDrawable(new ColorDrawable());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<AdDislikeInfo> paramArrayList)
  {
    b();
    this.H = paramInt1;
    this.I = paramInt2;
    this.J = paramInt3;
    StringBuilder localStringBuilder = new StringBuilder();
    Integer localInteger1 = Integer.valueOf(3);
    Integer localInteger2 = Integer.valueOf(2);
    Integer localInteger3 = Integer.valueOf(1);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramArrayList.next();
        if (localAdDislikeInfo != null)
        {
          if (localAdDislikeInfo.a != 0)
          {
            this.S.put(Integer.valueOf(localAdDislikeInfo.a), localAdDislikeInfo);
          }
          else
          {
            paramInt1 = localAdDislikeInfo.b;
            if (paramInt1 != 1)
            {
              if (paramInt1 != 2)
              {
                if (paramInt1 == 3) {
                  this.V.add(localAdDislikeInfo);
                }
              }
              else {
                this.U.add(localAdDislikeInfo);
              }
            }
            else {
              this.T.add(localAdDislikeInfo);
            }
          }
          localStringBuilder.append(localAdDislikeInfo.toString());
          localStringBuilder.append("\n");
        }
      }
    }
    boolean bool;
    if (this.S.containsKey(localInteger3))
    {
      paramArrayList = (DislikeInfo)this.S.get(localInteger3);
      if (this.T.isEmpty())
      {
        this.T.add(paramArrayList);
        bool = false;
      }
      else
      {
        bool = true;
      }
      a(this.T, this.Y, 2130842652, paramArrayList.c, bool);
    }
    else
    {
      a(new ArrayList(), this.Y, 2130842652, HardCodeUtil.a(2131903868), false);
    }
    if (this.S.containsKey(localInteger2))
    {
      paramArrayList = (DislikeInfo)this.S.get(localInteger2);
      if (this.U.isEmpty())
      {
        this.U.add(paramArrayList);
        bool = false;
      }
      else
      {
        bool = true;
      }
      a(this.U, this.Z, 2130842655, paramArrayList.c, bool);
    }
    else
    {
      a(new ArrayList(), this.Z, 2130842655, HardCodeUtil.a(2131903871), false);
    }
    if (this.S.containsKey(localInteger1))
    {
      paramArrayList = (DislikeInfo)this.S.get(localInteger1);
      if (this.V.isEmpty())
      {
        this.V.add(paramArrayList);
        bool = false;
      }
      else
      {
        bool = true;
      }
      a(this.V, this.aa, 2130842644, paramArrayList.c, bool);
    }
    else
    {
      a(new ArrayList(), this.aa, 2130842644, HardCodeUtil.a(2131903872), false);
    }
    paramArrayList = new DislikeInfo();
    paramArrayList.c = HardCodeUtil.a(2131903884);
    paramArrayList.d = 0;
    this.W.add(paramArrayList);
    a(this.W, this.ab, 2130842635, paramArrayList.c, false);
    this.ab.findViewById(2131436114).setVisibility(0);
    g();
    a();
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("setData:");
      paramArrayList.append(localStringBuilder.toString());
      QLog.d("KandianNegativeWindowForAd", 1, paramArrayList.toString());
    }
  }
  
  public void a(View paramView)
  {
    this.e = ((LinearLayout)paramView.findViewById(2131431322));
    this.d = ((LinearLayout)paramView.findViewById(2131437912));
    this.c = ((NegativeChildrenLayout)paramView.findViewById(2131430705));
    this.g = ((ImageView)paramView.findViewById(2131439190));
    this.h = ((ImageView)paramView.findViewById(2131439191));
    this.Y = paramView.findViewById(2131439183);
    this.Z = paramView.findViewById(2131439192);
    this.aa = paramView.findViewById(2131439188);
    this.ab = paramView.findViewById(2131439181);
    this.ac = paramView.findViewById(2131439184);
    this.Y.setOnClickListener(this);
    this.Z.setOnClickListener(this);
    this.aa.setOnClickListener(this);
    this.ab.setOnClickListener(this);
    this.ac.setOnClickListener(this);
    ((ImageView)paramView.findViewById(2131433199).findViewById(2131437082)).setOnClickListener(this);
    this.A = ((int)DeviceInfoUtil.D());
    this.B = ((int)DeviceInfoUtil.E());
    this.D = ((int)this.b.getResources().getDimension(2131299584));
    this.C = (this.A - this.D * 2);
    setWidth(this.C);
    this.E = ((int)this.b.getResources().getDimension(2131299565));
    setOnDismissListener(new KandianNegativeWindowForAd.2(this));
  }
  
  public void a(KandianNegativeWindowForAd.OnComplainListener paramOnComplainListener)
  {
    this.ae = paramOnComplainListener;
  }
  
  public void a(KandianNegativeWindowForAd.OnDiversionListener paramOnDiversionListener)
  {
    this.af = paramOnDiversionListener;
  }
  
  protected void b()
  {
    super.b();
    this.S.clear();
    this.T.clear();
    this.U.clear();
    this.V.clear();
    this.W.clear();
    this.X.clear();
  }
  
  public void b(IReadInJoyModel paramIReadInJoyModel, ArrayList<AdDislikeInfo> paramArrayList)
  {
    int k = 0;
    int i;
    int j;
    if (paramIReadInJoyModel != null)
    {
      i = paramIReadInJoyModel.r();
      j = paramIReadInJoyModel.m();
      paramIReadInJoyModel = paramIReadInJoyModel.k();
    }
    else
    {
      paramIReadInJoyModel = null;
      i = 0;
      j = 0;
    }
    if (paramIReadInJoyModel != null) {
      k = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramIReadInJoyModel);
    }
    a(i, j, k, paramArrayList);
  }
  
  protected int c()
  {
    int j = this.T.size();
    int i = j;
    if (this.U.size() > j) {
      i = this.U.size();
    }
    j = i;
    if (this.V.size() > i) {
      j = this.V.size();
    }
    i = j;
    if (this.W.size() > j) {
      i = this.W.size();
    }
    j = i;
    if (this.X.size() > i) {
      j = this.X.size();
    }
    i = j;
    if (j > 6) {
      i = 6;
    }
    return i;
  }
  
  protected int d()
  {
    if (this.z <= 0)
    {
      b(this.h);
      this.z = this.h.getMeasuredHeight();
    }
    int i = (c() + 1) * this.E + this.z;
    b(this.Y);
    int j = this.Y.getMeasuredHeight() * this.F + this.z;
    if (i > j) {
      return i;
    }
    return j;
  }
  
  protected void f()
  {
    this.P.clear();
    a(this.T.size(), this.Y);
    a(this.U.size(), this.Z);
    a(this.V.size(), this.aa);
    a(this.W.size(), this.ab);
    a(this.X.size(), this.ac);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131439192: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        e();
      }
      else
      {
        this.c.setData(this.T, ((DislikeInfo)this.S.get(Integer.valueOf(2))).c, this.ad);
        a(true);
      }
      break;
    case 2131439188: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        e();
      }
      else
      {
        this.c.setData(this.T, ((DislikeInfo)this.S.get(Integer.valueOf(3))).c, this.ad);
        a(true);
      }
      break;
    case 2131439184: 
      localObject = this.af;
      if (localObject != null) {
        ((KandianNegativeWindowForAd.OnDiversionListener)localObject).a();
      }
      dismiss();
      break;
    case 2131439183: 
      if (paramView.getTag() != null)
      {
        c(paramView);
        e();
        ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).onComplainBackToFeeds();
      }
      else
      {
        this.c.setData(this.T, ((DislikeInfo)this.S.get(Integer.valueOf(1))).c, this.ad);
        a(true);
      }
      break;
    case 2131439181: 
      localObject = this.ae;
      if (localObject != null) {
        ((KandianNegativeWindowForAd.OnComplainListener)localObject).a();
      }
      dismiss();
      break;
    case 2131437082: 
      a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindowForAd
 * JD-Core Version:    0.7.0.1
 */