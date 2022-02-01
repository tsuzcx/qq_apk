package com.tencent.mobileqq.troop.recommend;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopDataCardRecomTroopListWrapper
  extends RecommendTroopListWrapper
{
  boolean a = false;
  long b;
  int c;
  TextView d;
  View e;
  ArrayList<RecommendTroopItem> f = new ArrayList();
  
  public TroopDataCardRecomTroopListWrapper(AppInterface paramAppInterface, Context paramContext, XListView paramXListView, RecommendTroopListWrapper.RecommendTroopListWrapperCallback paramRecommendTroopListWrapperCallback, String paramString, boolean paramBoolean, TextView paramTextView, View paramView)
  {
    this.i = paramAppInterface;
    this.j = paramContext;
    this.k = paramXListView;
    this.o = paramRecommendTroopListWrapperCallback;
    this.r = false;
    this.p = paramBoolean;
    this.d = paramTextView;
    this.e = paramView;
    try
    {
      this.b = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramAppInterface)
    {
      QLog.d("TroopDataCardRecomTroopListWrapper", 1, "TroopDataCardRecomTroopListWrapper NumberFormatException ", paramAppInterface);
    }
    b();
  }
  
  protected RecommendTroopAdapter a()
  {
    return new TroopDataCardRecomTroopAdapter(this.j, this.i, true);
  }
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList)
  {
    int i = this.f.size();
    int j = paramArrayList.size();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetTroopDataCardRecommendTroopList isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",troopUIN = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",serverPageID = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",dataListSize = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",newDataListSize = ");
      localStringBuilder.append(j);
      QLog.d("TroopDataCardRecomTroopListWrapper", 2, localStringBuilder.toString());
    }
    this.a = paramBoolean2;
    if ((paramBoolean1) && (this.b == paramLong))
    {
      if (j + i >= 50)
      {
        this.f.addAll(paramArrayList.subList(0, 50 - i));
        this.a = true;
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("onGetTroopDataCardRecommendTroopList reach limit,this.dataList.size() = ");
          paramArrayList.append(this.f.size());
          QLog.d("TroopDataCardRecomTroopListWrapper", 2, paramArrayList.toString());
        }
      }
      else
      {
        this.f.addAll(paramArrayList);
      }
      d();
      if (this.f.size() > 0)
      {
        this.l.setVisibility(0);
        if (this.a) {
          this.l.setText("没有更多内容了");
        }
      }
      this.c = paramInt;
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.p)
    {
      this.k.addHeaderView(this.d);
      this.d.setVisibility(8);
    }
    this.k.addFooterView(this.e);
  }
  
  protected void b(boolean paramBoolean)
  {
    ((ITroopRecommendHandler)this.i.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopRecommendHandlerName())).a(this.b, this.c, 25);
  }
  
  protected boolean c()
  {
    return this.a;
  }
  
  protected void d()
  {
    if (!this.p) {
      this.f.clear();
    }
    this.m.a(this.f);
    this.m.notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListView,this.dataList.size() = ");
      localStringBuilder.append(this.f.size());
      QLog.d("TroopDataCardRecomTroopListWrapper", 2, localStringBuilder.toString());
    }
    if (this.f.size() > 0)
    {
      this.k.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  public void j()
  {
    if (this.p)
    {
      this.p = false;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.TroopDataCardRecomTroopListWrapper
 * JD-Core Version:    0.7.0.1
 */