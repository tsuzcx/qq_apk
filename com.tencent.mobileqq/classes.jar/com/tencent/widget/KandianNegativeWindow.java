package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class KandianNegativeWindow
  extends PopupWindow
{
  int A;
  int B;
  int C;
  int D;
  int E;
  int F = 0;
  Map<Long, String> G = new HashMap(6);
  protected int H;
  protected int I;
  protected int J;
  KandianNegativeWindow.OnUninterestConfirmListener K;
  public final String L = HardCodeUtil.a(2131903867);
  int M;
  String N = "";
  String O = "";
  ArrayList<View> P = new ArrayList();
  View.OnClickListener Q = new KandianNegativeWindow.2(this);
  KandianNegativeWindow.iClickInterface R = new KandianNegativeWindow.4(this);
  public final String a = "KandianNegativeWindow";
  Context b;
  NegativeChildrenLayout c;
  LinearLayout d;
  LinearLayout e;
  View f;
  ImageView g;
  ImageView h;
  ArrayList<DislikeInfo> i = new ArrayList();
  ArrayList<DislikeInfo> j = new ArrayList();
  ArrayList<DislikeInfo> k = new ArrayList();
  ArrayList<DislikeInfo> l = new ArrayList();
  ArrayList<DislikeInfo> m = new ArrayList();
  View n;
  View o;
  View p;
  View q;
  View r;
  public final int s = 1;
  public final int t = 2;
  public final int u = 3;
  public final int v = 5;
  public final int w = 8;
  public final int x = 9;
  public final int y = 3;
  int z = -1;
  
  public KandianNegativeWindow(@NonNull Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    this.f = LayoutInflater.from(this.b).inflate(2131626294, null);
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
  
  private String a(ArrayList<DislikeInfo> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while ((i1 < paramArrayList.size()) && (i1 < 3))
    {
      if (!TextUtils.isEmpty(((DislikeInfo)paramArrayList.get(i1)).c))
      {
        if (i1 != 0) {
          localStringBuilder.append("、");
        }
        localStringBuilder.append(((DislikeInfo)paramArrayList.get(i1)).c);
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = this.d;
    Object localObject2 = this.c;
    float f1 = 1.0F;
    float f2;
    Object localObject1;
    if (paramBoolean)
    {
      f1 = -1.0F;
      f2 = 1.0F;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    else
    {
      f2 = -1.0F;
      localObject1 = localObject2;
    }
    localObject2 = new TranslateAnimation(1, f2, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, f1, 1, 0.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation((Animation)localObject2);
    ((View)localObject1).startAnimation(localTranslateAnimation);
  }
  
  private void a(Object paramObject, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("folder_status", ((IRIJKanDianFolderStatus)QRoute.api(IRIJKanDianFolderStatus.class)).getReportFolderStatus());
      localJSONObject.put("kandian_mode", ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getKanDianMode());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.J);
      localJSONObject.put("feeds_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.I);
      localStringBuilder.append("");
      localJSONObject.put("channel_id", localStringBuilder.toString());
      if (TextUtils.isEmpty(this.O)) {
        this.O = "";
      }
      localJSONObject.put("rowkey", this.O);
      paramObject = (DislikeInfo)paramObject;
      if (paramObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.e);
        localStringBuilder.append("");
        localJSONObject.put("tag_id", localStringBuilder.toString());
        localJSONObject.put("tag_name", paramObject.c);
        if (paramBoolean) {
          this.N = paramObject.c;
        }
      }
    }
    catch (Exception paramObject)
    {
      label247:
      break label247;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009990", "0X8009990", 0, 0, String.valueOf(this.M), "", this.N, localJSONObject.toString(), false);
  }
  
  private boolean a(View paramView, int[] paramArrayOfInt)
  {
    int i3 = d();
    paramView.getLocationOnScreen(paramArrayOfInt);
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramArrayOfInt[0];
    int i2 = paramArrayOfInt[1];
    boolean bool;
    if (paramArrayOfInt[1] + i3 + paramView.getHeight() <= this.B)
    {
      paramArrayOfInt[1] = (paramArrayOfInt[1] + paramView.getHeight() / 2 + paramView.getHeight() / 8);
      setAnimationStyle(2131951657);
      bool = false;
    }
    else
    {
      setAnimationStyle(2131951660);
      paramArrayOfInt[1] = (paramArrayOfInt[1] + paramView.getHeight() / 2 - i3 - paramView.getHeight() / 8);
      bool = true;
    }
    b(paramView, bool);
    c(paramView, bool);
    paramArrayOfInt[0] = ((this.A - this.C) / 2);
    if ((this.z > 0) && (this.B > 0) && (paramArrayOfInt[0] > 0) && (paramArrayOfInt[1] > 0)) {
      i3 = this.E;
    }
    ThreadManager.executeOnSubThread(new KandianNegativeWindow.3(this, localStringBuilder, i1, i2, true));
    return true;
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i1 = 0;
    if (arrayOfInt[0] >= this.A * 2 / 3) {
      i1 = 1;
    }
    if (paramBoolean)
    {
      if (i1 != 0) {
        i1 = 2131951659;
      } else {
        i1 = 2131951660;
      }
    }
    else if (i1 != 0) {
      i1 = 2131951656;
    } else {
      i1 = 2131951657;
    }
    setAnimationStyle(i1);
  }
  
  private void b(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, this.e.getId());
    if (paramBoolean) {
      localLayoutParams.addRule(12);
    } else {
      localLayoutParams.addRule(10);
    }
    this.e.setLayoutParams(localLayoutParams);
  }
  
  private void c(View paramView, boolean paramBoolean)
  {
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    int i1 = localObject[0];
    int i2 = paramView.getWidth() / 2;
    int i3 = this.D;
    localObject = (LinearLayout.LayoutParams)this.h.getLayoutParams();
    if (!paramBoolean) {
      localObject = (LinearLayout.LayoutParams)this.g.getLayoutParams();
    }
    ((LinearLayout.LayoutParams)localObject).leftMargin = (i1 + i2 - i3 - paramView.getWidth() / 5);
    if (paramBoolean)
    {
      this.h.setVisibility(0);
      this.g.setVisibility(8);
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      this.g.setVisibility(0);
      this.h.setVisibility(8);
      this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    b(paramBoolean);
  }
  
  private void g()
  {
    f();
    int i1 = this.P.size();
    if (i1 > 0)
    {
      if (i1 <= 1)
      {
        ((View)this.P.get(0)).setBackgroundResource(2130844016);
        return;
      }
      ((View)this.P.get(0)).setBackgroundResource(2130844018);
      ((View)this.P.get(i1 - 1)).setBackgroundResource(2130844017);
    }
  }
  
  protected void a()
  {
    setHeight(d());
    g();
  }
  
  public void a(float paramFloat)
  {
    boolean bool = this.b instanceof Activity;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<DislikeInfo> paramArrayList, String paramString)
  {
    b();
    this.H = paramInt1;
    this.I = paramInt2;
    this.J = paramInt3;
    this.O = paramString;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
        if (localDislikeInfo != null)
        {
          paramInt1 = localDislikeInfo.d;
          if ((paramInt1 != 1) && (paramInt1 != 2))
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 == 5) {
                this.k.add(localDislikeInfo);
              }
            }
            else
            {
              if (TextUtils.isEmpty(localDislikeInfo.c))
              {
                String str = (String)this.G.get(Long.valueOf(localDislikeInfo.e));
                paramString = str;
                if (str == null) {
                  paramString = "";
                }
                localDislikeInfo.c = paramString;
              }
              this.j.add(localDislikeInfo);
            }
          }
          else {
            this.i.add(localDislikeInfo);
          }
          paramString = new StringBuilder();
          paramString.append("dislikeInfo,");
          paramString.append(localDislikeInfo.toString());
          QLog.e("KandianNegativeWindow", 1, paramString.toString());
        }
      }
      paramInt1 = paramArrayList.size();
    }
    else
    {
      paramInt1 = 0;
    }
    paramArrayList = new DislikeInfo();
    paramArrayList.c = this.L;
    paramArrayList.d = 9;
    paramArrayList.f = "";
    this.l.add(paramArrayList);
    paramArrayList = new DislikeInfo();
    paramArrayList.c = BaseApplicationImpl.getContext().getString(2131915414);
    paramArrayList.d = 8;
    paramArrayList.f = "";
    this.m.add(paramArrayList);
    a(this.i, this.n, 2130842652, HardCodeUtil.a(2131903873), true);
    a(this.j, this.o, 2130842657, HardCodeUtil.a(2131903883), true);
    paramArrayList = this.k;
    a(paramArrayList, this.p, 2130842644, a(paramArrayList), false);
    a(this.l, this.q, 2130842649, HardCodeUtil.a(2131903879), false);
    a(this.m, this.r, 2130842643, BaseApplicationImpl.getContext().getString(2131915414), false);
    a();
    paramArrayList = new StringBuilder();
    paramArrayList.append("setData,size:");
    paramArrayList.append(paramInt1);
    QLog.e("KandianNegativeWindow", 1, paramArrayList.toString());
  }
  
  protected void a(int paramInt, View paramView)
  {
    if (paramInt > 0) {
      this.P.add(paramView);
    }
  }
  
  protected void a(View paramView)
  {
    this.n = paramView.findViewById(2131439187);
    this.o = paramView.findViewById(2131439182);
    this.p = paramView.findViewById(2131439189);
    this.q = paramView.findViewById(2131439186);
    this.r = paramView.findViewById(2131439185);
    this.n.setOnClickListener(this.Q);
    this.o.setOnClickListener(this.Q);
    this.p.setOnClickListener(this.Q);
    this.q.setOnClickListener(this.Q);
    this.r.setOnClickListener(this.Q);
    this.g = ((ImageView)paramView.findViewById(2131439190));
    this.h = ((ImageView)paramView.findViewById(2131439191));
    this.c = ((NegativeChildrenLayout)paramView.findViewById(2131430705));
    this.d = ((LinearLayout)paramView.findViewById(2131437912));
    ((ImageView)paramView.findViewById(2131433199).findViewById(2131437082)).setOnClickListener(this.Q);
    this.A = ((int)DeviceInfoUtil.D());
    this.B = ((int)DeviceInfoUtil.E());
    this.D = ((int)this.b.getResources().getDimension(2131299584));
    this.C = (this.A - this.D * 2);
    setWidth(this.C);
    this.e = ((LinearLayout)paramView.findViewById(2131431322));
    this.G.put(Long.valueOf(1L), HardCodeUtil.a(2131903880));
    this.G.put(Long.valueOf(2L), HardCodeUtil.a(2131903878));
    this.G.put(Long.valueOf(3L), HardCodeUtil.a(2131903869));
    this.G.put(Long.valueOf(4L), HardCodeUtil.a(2131903870));
    this.G.put(Long.valueOf(5L), HardCodeUtil.a(2131903875));
    this.G.put(Long.valueOf(6L), HardCodeUtil.a(2131903874));
    this.E = ((int)this.b.getResources().getDimension(2131299565));
    this.q.findViewById(2131445643).setVisibility(4);
    setBackgroundDrawable(new ColorDrawable());
    setOnDismissListener(new KandianNegativeWindow.1(this));
    this.f.setOnClickListener(this.Q);
  }
  
  public void a(View paramView, KandianNegativeWindow.OnUninterestConfirmListener paramOnUninterestConfirmListener)
  {
    if (isShowing()) {
      dismiss();
    }
    this.K = paramOnUninterestConfirmListener;
    paramOnUninterestConfirmListener = new int[2];
    try
    {
      bool = a(paramView, paramOnUninterestConfirmListener);
    }
    catch (Exception localException)
    {
      boolean bool;
      label30:
      break label30;
    }
    bool = false;
    if (bool)
    {
      showAtLocation(paramView, 51, paramOnUninterestConfirmListener[0], paramOnUninterestConfirmListener[1]);
      a(0.8F);
      a(this);
    }
  }
  
  public void a(PopupWindow paramPopupWindow)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = (View)paramPopupWindow.getContentView().getParent();
      } else {
        localObject1 = paramPopupWindow.getContentView();
      }
      Object localObject2 = localObject1;
      if (paramPopupWindow.getBackground() != null) {
        localObject2 = (View)((View)localObject1).getParent();
      }
      paramPopupWindow = (WindowManager)paramPopupWindow.getContentView().getContext().getSystemService("window");
      Object localObject1 = (WindowManager.LayoutParams)((View)localObject2).getLayoutParams();
      ((WindowManager.LayoutParams)localObject1).flags |= 0x2;
      ((WindowManager.LayoutParams)localObject1).dimAmount = 0.2F;
      paramPopupWindow.updateViewLayout((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      return;
    }
    catch (Exception paramPopupWindow) {}
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, ArrayList<DislikeInfo> paramArrayList)
  {
    if (paramIReadInJoyModel != null) {}
    for (;;)
    {
      try
      {
        i1 = paramIReadInJoyModel.r();
        i2 = paramIReadInJoyModel.m();
        paramIReadInJoyModel = paramIReadInJoyModel.k();
        if (paramIReadInJoyModel == null) {
          break label118;
        }
        String str = paramIReadInJoyModel.innerUniqueID;
        i3 = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramIReadInJoyModel);
        paramIReadInJoyModel = str;
        a(i1, i2, i3, paramArrayList, paramIReadInJoyModel);
        return;
      }
      catch (Exception paramIReadInJoyModel)
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("setData error! msg=");
        paramArrayList.append(paramIReadInJoyModel);
        QLog.e("KandianNegativeWindow", 1, paramArrayList.toString());
        return;
      }
      paramIReadInJoyModel = null;
      int i1 = 0;
      int i2 = 0;
      continue;
      label118:
      paramIReadInJoyModel = "";
      int i3 = 0;
    }
  }
  
  protected void a(ArrayList<DislikeInfo> paramArrayList, View paramView, int paramInt, String paramString, boolean paramBoolean)
  {
    boolean bool = paramArrayList.isEmpty();
    int i1 = 8;
    int i2 = i1;
    if (!bool)
    {
      i2 = i1;
      if (!TextUtils.isEmpty(paramString))
      {
        ((TextView)paramView.findViewById(2131436136)).setText(paramString);
        paramString = (TextView)paramView.findViewById(2131436132);
        ImageView localImageView = (ImageView)paramView.findViewById(2131436114);
        ((ImageView)paramView.findViewById(2131436047)).setImageResource(paramInt);
        if (paramBoolean)
        {
          paramArrayList = a(paramArrayList);
          paramView.setTag(null);
        }
        else
        {
          paramView.setTag(paramArrayList.get(0));
          paramArrayList = "";
        }
        if (!TextUtils.isEmpty(paramArrayList)) {
          i1 = 0;
        }
        localImageView.setVisibility(i1);
        paramString.setText(paramArrayList);
        paramString.setVisibility(i1);
        this.F += 1;
        i2 = 0;
      }
    }
    paramView.setVisibility(i2);
  }
  
  protected void a(boolean paramBoolean)
  {
    int i1 = 8;
    int i2 = 0;
    if (!paramBoolean)
    {
      i1 = 0;
      i2 = 8;
    }
    this.d.setVisibility(i1);
    this.c.setVisibility(i2);
    if (paramBoolean)
    {
      a(this.c, paramBoolean);
      return;
    }
    a(this.d, paramBoolean);
  }
  
  protected void b()
  {
    this.i.clear();
    this.j.clear();
    this.k.clear();
    this.l.clear();
    this.P.clear();
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.F = 0;
  }
  
  protected void b(View paramView)
  {
    paramView.measure(0, 0);
  }
  
  protected int c()
  {
    int i2 = this.i.size();
    int i1 = i2;
    if (this.j.size() > i2) {
      i1 = this.j.size();
    }
    i2 = i1;
    if (this.k.size() > i1) {
      i2 = this.k.size();
    }
    i1 = i2;
    if (this.l.size() > i2) {
      i1 = this.l.size();
    }
    i2 = i1;
    if (i1 > 6) {
      i2 = 6;
    }
    return i2;
  }
  
  protected void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.K != null)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof DislikeInfo))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add((DislikeInfo)paramView);
        this.K.a(null, this.H, localArrayList, null);
      }
    }
  }
  
  protected int d()
  {
    if (this.z <= 0)
    {
      b(this.h);
      this.z = this.h.getMeasuredHeight();
    }
    int i1 = (c() + 1) * this.E + this.z;
    b(this.n);
    int i2 = this.n.getMeasuredHeight() * this.F + this.z;
    if (i1 > i2) {
      return i1;
    }
    return i2;
  }
  
  protected void e()
  {
    dismiss();
  }
  
  protected void f()
  {
    this.P.clear();
    a(this.i.size(), this.n);
    a(this.j.size(), this.o);
    a(this.k.size(), this.p);
    a(this.l.size(), this.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindow
 * JD-Core Version:    0.7.0.1
 */