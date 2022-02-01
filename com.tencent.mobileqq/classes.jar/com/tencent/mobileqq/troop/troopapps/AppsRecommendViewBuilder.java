package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AppsRecommendViewBuilder
  extends AppsBaseBuilder
  implements View.OnClickListener, AddTroopAppCgi.CgiCallBack
{
  protected TroopAppShortcutContainer.TroopAppInfo a = new TroopAppShortcutContainer.TroopAppInfo();
  
  AppsRecommendViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramBaseActivity, paramTroopAppShortcutContainer, paramBundle);
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt > 100000000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt / 100000000));
      localStringBuilder.append("亿");
      return localStringBuilder.toString();
    }
    if (paramInt > 10000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt / 10000));
      localStringBuilder.append("万");
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  private void a(View paramView)
  {
    TroopAppShortcutUtils.a(this.g, this.f, this.h, String.valueOf(this.b), this.a.c, this.a.f, 1, 0);
    ReportController.b(null, "dc00898", "", String.valueOf(this.b), "0X800AFBD", "0X800AFBD", 0, 0, String.valueOf(this.c), String.valueOf(this.a.c), "", this.a.l);
  }
  
  private void a(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    if (this.j)
    {
      if (this.a.j)
      {
        paramItemViewHolder.e.setEnabled(false);
        paramItemViewHolder.e.setTextColor(-5196865);
      }
      else
      {
        paramItemViewHolder.e.setEnabled(true);
        paramItemViewHolder.e.setText(this.f.getResources().getString(2131897594));
        paramItemViewHolder.e.setTextColor(-16578534);
        if (this.i) {
          paramItemViewHolder.e.setTextColor(Color.parseColor("#ffffff"));
        }
      }
    }
    else
    {
      paramItemViewHolder.e.setEnabled(true);
      paramItemViewHolder.e.setText(this.f.getResources().getString(2131897603));
      paramItemViewHolder.e.setTextColor(-16578534);
      if (this.i) {
        paramItemViewHolder.e.setTextColor(Color.parseColor("#ffffff"));
      }
    }
    paramItemViewHolder.e.setVisibility(0);
    paramItemViewHolder.e.setClickable(true);
    paramItemViewHolder.e.setOnClickListener(this);
  }
  
  private void b(View paramView)
  {
    ReportController.b(null, "dc00898", "", String.valueOf(this.b), "0X800AFBE", "0X800AFBE", 0, 0, String.valueOf(this.c), String.valueOf(this.a.c), "", this.a.l);
    if (!TroopAppShortcutUtils.a(this.g, this.b))
    {
      QQToast.makeText(this.h, 1, this.f.getString(2131897600), 0).show();
      return;
    }
    new AddTroopAppCgi(this, String.valueOf(this.b), this.a.c, this.a.b, false, this.a).a(this.g);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onClickAdd mTroopUin:");
      paramView.append(this.b);
      paramView.append(" append_appid:");
      paramView.append(this.a.c);
      QLog.d("AppsRecommendViewBuilder", 2, paramView.toString());
    }
  }
  
  private void b(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    int j = this.a.r.size();
    int i;
    if ((this.a.n <= 0) && (this.a.o <= 0) && (this.a.p <= 0))
    {
      i = j;
      if (j > 2) {
        i = 2;
      }
    }
    else
    {
      i = j;
      if (j > 1) {
        i = 1;
      }
    }
    if (i > 0)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      if (this.i)
      {
        j = -7959655;
        localGradientDrawable.setColor(-14803426);
      }
      else
      {
        j = -8091759;
        localGradientDrawable.setColor(-1315339);
      }
      int k = 0;
      while (k < paramItemViewHolder.i.size())
      {
        if (k >= i)
        {
          ((TextView)paramItemViewHolder.i.get(k)).setVisibility(8);
        }
        else
        {
          ((TextView)paramItemViewHolder.i.get(k)).setText((CharSequence)this.a.r.get(k));
          ((TextView)paramItemViewHolder.i.get(k)).setVisibility(0);
          ((TextView)paramItemViewHolder.i.get(k)).setTextColor(j);
          ((TextView)paramItemViewHolder.i.get(k)).setBackgroundDrawable(localGradientDrawable);
        }
        k += 1;
      }
    }
    paramItemViewHolder.h.setVisibility(8);
  }
  
  private void c(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    if ((this.a.n <= 0) && (this.a.o <= 0) && (this.a.p <= 0))
    {
      paramItemViewHolder.c.setVisibility(8);
      return;
    }
    if (this.a.n > 0)
    {
      paramItemViewHolder.c.setText(String.format(this.f.getResources().getString(2131897604).replace("$COUNT", a(this.a.n)), new Object[0]));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      paramItemViewHolder.c.setBackgroundDrawable(localGradientDrawable);
    }
    else if (this.a.o > 0)
    {
      paramItemViewHolder.c.setText(String.format(this.f.getResources().getString(2131897595).replace("$COUNT", a(this.a.o)), new Object[0]));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      paramItemViewHolder.c.setBackgroundDrawable(localGradientDrawable);
    }
    else if (this.a.p > 0)
    {
      paramItemViewHolder.c.setText(String.format(this.f.getResources().getString(2131897605).replace("$COUNT", a(this.a.p)), new Object[0]));
    }
    paramItemViewHolder.c.setVisibility(0);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(34.0F);
    if (this.i)
    {
      paramItemViewHolder.c.setTextColor(-7959655);
      localGradientDrawable.setColor(-14803426);
    }
    else
    {
      paramItemViewHolder.c.setTextColor(-8091759);
      localGradientDrawable.setColor(-1315339);
    }
    paramItemViewHolder.c.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void d(AppsRecommendViewBuilder.ItemViewHolder paramItemViewHolder)
  {
    int j = this.a.q.size();
    Object localObject = (RelativeLayout.LayoutParams)paramItemViewHolder.c.getLayoutParams();
    if (j > 0)
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(-21.0F, paramItemViewHolder.c.getResources());
      paramItemViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramItemViewHolder.c.setPadding(AIOUtils.b(19.0F, paramItemViewHolder.c.getResources()), 0, AIOUtils.b(7.0F, paramItemViewHolder.c.getResources()), 0);
      paramItemViewHolder.f.setVisibility(0);
      int i = 0;
      while (i < paramItemViewHolder.g.size())
      {
        if (i >= j)
        {
          ((ImageView)paramItemViewHolder.g.get(i)).setVisibility(8);
        }
        else
        {
          localObject = (String)this.a.q.get(i);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.g != null))
          {
            Drawable localDrawable = ImageUtil.a(true);
            localObject = FaceDrawable.getFaceDrawable(this.g, 1, (String)localObject, 4, localDrawable, localDrawable);
            localDrawable = ((ImageView)paramItemViewHolder.g.get(i)).getDrawable();
            if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof FaceDrawable))) {
              ((FaceDrawable)localDrawable).cancel();
            }
            ((ImageView)paramItemViewHolder.g.get(i)).setImageDrawable((Drawable)localObject);
            ((ImageView)paramItemViewHolder.g.get(i)).setVisibility(0);
          }
          else
          {
            localObject = ImageUtil.a(true);
            ((ImageView)paramItemViewHolder.g.get(i)).setImageDrawable((Drawable)localObject);
            ((ImageView)paramItemViewHolder.g.get(i)).setVisibility(0);
          }
        }
        i += 1;
      }
    }
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(0.0F, paramItemViewHolder.c.getResources());
    paramItemViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramItemViewHolder.c.setPadding(AIOUtils.b(7.0F, paramItemViewHolder.c.getResources()), 0, AIOUtils.b(7.0F, paramItemViewHolder.c.getResources()), 0);
    paramItemViewHolder.f.setVisibility(8);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = false;
    if (paramView == null)
    {
      paramView = new AppsRecommendViewBuilder.ItemViewHolder();
      localObject = LayoutInflater.from(this.f).inflate(2131625896, paramViewGroup, false);
      paramView.a = ((ImageView)((View)localObject).findViewById(2131428619));
      paramView.b = ((TextView)((View)localObject).findViewById(2131428632));
      paramView.c = ((TextView)((View)localObject).findViewById(2131428636));
      paramView.d = ((TextView)((View)localObject).findViewById(2131428613));
      paramView.e = ((Button)((View)localObject).findViewById(2131428514));
      paramView.g = new ArrayList();
      paramView.f = ((RelativeLayout)((View)localObject).findViewById(2131428638));
      paramInt = 0;
      while (paramInt < paramView.f.getChildCount())
      {
        paramViewGroup = (ImageView)paramView.f.getChildAt(paramInt);
        paramViewGroup.setVisibility(8);
        paramView.g.add(paramViewGroup);
        paramInt += 1;
      }
      paramView.i = new ArrayList();
      paramView.h = ((RelativeLayout)((View)localObject).findViewById(2131446839));
      paramInt = 0;
      while (paramInt < paramView.h.getChildCount())
      {
        paramViewGroup = (TextView)paramView.h.getChildAt(paramInt);
        paramViewGroup.setVisibility(8);
        paramView.i.add(paramViewGroup);
        paramInt += 1;
      }
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    else
    {
      paramViewGroup = (AppsRecommendViewBuilder.ItemViewHolder)paramView.getTag();
    }
    paramView.setClickable(true);
    paramView.setOnClickListener(this);
    Object localObject = this.f;
    ImageView localImageView = paramViewGroup.a;
    String str = this.a.e;
    if (this.a.m == 1) {
      bool = true;
    }
    TroopAppShortcutUtils.a((Context)localObject, localImageView, str, 48.0F, bool);
    d(paramViewGroup);
    c(paramViewGroup);
    b(paramViewGroup);
    paramViewGroup.b.setText(this.a.d);
    paramViewGroup.d.setText(this.a.i);
    a(paramViewGroup);
    if (this.i)
    {
      paramViewGroup.b.setTextColor(Color.parseColor("#ffffff"));
      paramView.setBackgroundColor(-16777216);
    }
    return paramView;
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    QLog.e("AppsRecommendViewBuilder", 1, new Object[] { "add appid retCode: ", Integer.valueOf(paramInt) });
    if (paramInt == 41005)
    {
      paramInt = this.e.f();
      if (paramInt > 0)
      {
        paramString = this.f.getString(2131897602).replace("$COUNT", String.valueOf(paramInt));
        QQToast.makeText(this.h, 1, paramString, 0).show();
        return;
      }
      QQToast.makeText(this.h, 1, this.f.getString(2131897601), 0).show();
      return;
    }
    QQToast.makeText(this.h, 1, this.f.getString(2131897600), 0).show();
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof TroopAppShortcutContainer.TroopAppInfo)) {
        return;
      }
      paramObject = (TroopAppShortcutContainer.TroopAppInfo)paramObject;
      Object localObject = (TroopAppShortcutMgr)this.g.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null)
      {
        ArrayList localArrayList = ((TroopAppShortcutMgr)localObject).a(this.b);
        if ((localArrayList != null) && (!localArrayList.contains(paramObject)))
        {
          localArrayList.add(paramObject);
          this.e.g();
        }
        localObject = ((TroopAppShortcutMgr)localObject).b(this.b);
        if (localObject != null)
        {
          int i = ((ArrayList)localObject).indexOf(paramObject);
          if ((i >= 0) && (i < ((ArrayList)localObject).size()))
          {
            ((TroopAppShortcutContainer.TroopAppInfo)((ArrayList)localObject).get(i)).j = true;
            this.e.h();
          }
        }
      }
    }
  }
  
  public void a_(Object paramObject)
  {
    if ((paramObject instanceof TroopAppShortcutContainer.TroopAppInfo)) {
      this.a = ((TroopAppShortcutContainer.TroopAppInfo)paramObject);
    }
  }
  
  public Object b()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131428514)
    {
      if (i == 2131428639) {
        a(paramView);
      }
    }
    else if (this.j) {
      b(paramView);
    } else {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsRecommendViewBuilder
 * JD-Core Version:    0.7.0.1
 */