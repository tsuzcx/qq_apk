package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.association.api.ITroopAssociationHandler;
import com.tencent.mobileqq.troop.association.api.TroopAssociationObserver;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopAssociationsListWrapper
  implements View.OnClickListener
{
  protected AppInterface a;
  protected Context b;
  protected XListView c;
  protected LinearLayout d;
  protected TroopAssociationsAdapter e;
  protected String f;
  protected long g;
  protected View h;
  protected View i;
  protected QFormSimpleItem j;
  protected TextView k;
  protected String l;
  protected boolean m = false;
  protected TroopAssociationObserver n;
  protected ArrayList<AssociatedTroopItem> o = new ArrayList();
  protected TroopAssociationsListWrapper.ICallbacks p;
  protected long q;
  
  public TroopAssociationsListWrapper(AppInterface paramAppInterface, Context paramContext, TroopAssociationsListWrapper.ICallbacks paramICallbacks, XListView paramXListView, LinearLayout paramLinearLayout, String paramString, long paramLong)
  {
    this.a = paramAppInterface;
    this.b = paramContext;
    this.p = paramICallbacks;
    this.c = paramXListView;
    this.d = paramLinearLayout;
    this.f = paramString;
    this.g = paramLong;
    this.l = "";
    this.n = new TroopAssociationsListWrapper.1(this);
    this.a.addObserver(this.n);
    this.q = 0L;
  }
  
  private void d()
  {
    if (this.k == null)
    {
      this.k = new TextView(this.b);
      this.k.setText(MobileQQ.getContext().getResources().getString(2131897482));
      this.k.setTextColor(this.b.getResources().getColor(2131167962));
      this.k.setTextSize(2, 16.0F);
      this.k.setPadding(Utils.a(16.0F, this.b.getResources()), Utils.a(13.0F, this.b.getResources()), 0, Utils.a(5.0F, this.b.getResources()));
      this.k.setClickable(false);
    }
    if (this.h == null)
    {
      this.h = View.inflate(this.b, 2131627926, null);
      this.h.setBackgroundResource(2130853313);
      this.d.addView(this.h);
      this.h.setVisibility(8);
    }
    if (this.i == null)
    {
      this.i = View.inflate(this.b, 2131627908, null);
      this.j = ((QFormSimpleItem)this.i.findViewById(2131436145));
      a(0, 0, this.j, MobileQQ.getContext().getResources().getString(2131897490), MobileQQ.getContext().getResources().getString(2131897487), true);
      TextView localTextView = (TextView)this.i.findViewById(2131435749);
      localTextView.setBackgroundResource(2130839624);
      localTextView.setText(MobileQQ.getContext().getResources().getString(2131897484));
      localTextView.setTextColor(MobileQQ.getContext().getResources().getColor(2131168118));
      this.j.setOnClickListener(this);
      this.d.addView(this.i);
      this.i.setVisibility(8);
    }
  }
  
  public void a()
  {
    if (b()) {
      return;
    }
    ITroopAssociationHandler localITroopAssociationHandler = (ITroopAssociationHandler)this.a.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAssociationHandlerName());
    if ((localITroopAssociationHandler != null) && (!this.m))
    {
      this.m = true;
      this.q = localITroopAssociationHandler.a(this.f, 2, this.l);
    }
  }
  
  protected void a(int paramInt)
  {
    Object localObject;
    if ((paramInt != 1) && (paramInt != 2))
    {
      localObject = this.k;
      if (localObject != null)
      {
        if (this.c.findHeaderViewPosition((View)localObject) < 0) {
          this.c.addHeaderView(this.k);
        }
        this.k.setVisibility(0);
      }
      if (this.e == null)
      {
        this.c.setAdapter(null);
        this.e = new TroopAssociationsAdapter(this.b, this.a, this.f, this.g);
        this.c.setAdapter(this.e);
      }
      localObject = this.h;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.i;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.k;
      if (localObject != null)
      {
        this.c.removeHeaderView((View)localObject);
        this.k.setVisibility(8);
      }
      localObject = this.a;
      boolean bool = TroopInfoUtil.a((AppRuntime)localObject, this.f, ((AppInterface)localObject).getCurrentUin());
      localObject = this.h;
      if (localObject != null) {
        if ((bool) && (paramInt == 1))
        {
          ((View)localObject).setVisibility(0);
          ReportController.b(null, "dc00898", "", this.f, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.g), "0", "", "");
        }
        else
        {
          this.h.setVisibility(8);
        }
      }
      localObject = this.i;
      if (localObject != null)
      {
        if ((bool) && (paramInt == 1))
        {
          ((View)localObject).setVisibility(0);
          return;
        }
        this.i.setVisibility(8);
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, QFormSimpleItem paramQFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramQFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramQFormSimpleItem.setOnClickListener(this);
      paramQFormSimpleItem.a(true);
    }
    else
    {
      paramQFormSimpleItem.setTag(null);
      paramQFormSimpleItem.setOnClickListener(null);
      paramQFormSimpleItem.a(false);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 == 4) {
              paramQFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
            }
          }
          else {
            paramQFormSimpleItem.setBgType(3);
          }
        }
        else {
          paramQFormSimpleItem.setBgType(2);
        }
      }
      else {
        paramQFormSimpleItem.setBgType(1);
      }
    }
    else {
      paramQFormSimpleItem.setBgType(0);
    }
    paramQFormSimpleItem.setRightTextColor(2);
    paramQFormSimpleItem.setLeftTextColor(0);
    paramQFormSimpleItem.getBackground().setAlpha(255);
    String str2 = "";
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    paramQFormSimpleItem.setLeftText(str1);
    paramQFormSimpleItem.getRightTextView().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    if (paramCharSequence == null) {
      paramString = str2;
    } else {
      paramString = new QQText(paramCharSequence, 3);
    }
    paramQFormSimpleItem.setRightText(paramString);
  }
  
  protected void a(String paramString, List<AssociatedTroopItem> paramList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        AssociatedTroopItem localAssociatedTroopItem = (AssociatedTroopItem)localIterator.next();
        if ((!TextUtils.isEmpty(localAssociatedTroopItem.uin)) && (localAssociatedTroopItem.uin.equals(paramString))) {
          paramList.remove(localAssociatedTroopItem);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      d();
      localObject = (ITroopAssociationHandler)this.a.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAssociationHandlerName());
      if (localObject != null)
      {
        this.o.clear();
        this.l = "";
        this.m = true;
        this.q = ((ITroopAssociationHandler)localObject).a(this.f, 2, "");
      }
    }
    else
    {
      localObject = this.a;
      if (TroopInfoUtil.a((AppRuntime)localObject, this.f, ((AppInterface)localObject).getCurrentUin()))
      {
        d();
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        ReportController.b(null, "dc00898", "", this.f, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.g), "0", "", "");
      }
      localObject = this.k;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      this.o.clear();
      localObject = this.e;
      if (localObject != null) {
        ((TroopAssociationsAdapter)localObject).a(this.o);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<AssociatedTroopItem> paramList, long paramLong)
  {
    this.m = false;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.f)))
    {
      paramInt2 = 2;
      if (paramInt1 == 2)
      {
        if (this.q != paramLong) {
          return;
        }
        int i1 = this.o.size();
        this.l = paramString2;
        if (paramList != null)
        {
          this.o.addAll(paramList);
          a(paramString1, this.o);
        }
        if (this.o.size() == 0)
        {
          if ((paramList != null) && (paramList.size() == 1)) {
            paramInt1 = paramInt2;
          } else {
            paramInt1 = 1;
          }
        }
        else {
          paramInt1 = 3;
        }
        if ((this.o.size() > 0) && (i1 == 0)) {
          ReportController.b(null, "dc00898", "", this.f, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.g), "1", "", "");
        }
        a(paramInt1);
        paramString1 = this.e;
        if (paramString1 != null) {
          paramString1.a(this.o);
        }
        paramString1 = this.p;
        if (paramString1 != null) {
          paramString1.a(this.o.size());
        }
      }
    }
  }
  
  protected boolean b()
  {
    return TextUtils.isEmpty(this.l);
  }
  
  public void c()
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface != null)
    {
      TroopAssociationObserver localTroopAssociationObserver = this.n;
      if (localTroopAssociationObserver != null) {
        localAppInterface.removeObserver(localTroopAssociationObserver);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.j)
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).openTroopAssociationWebPage(this.b, this.f);
      ReportController.b(null, "dc00898", "", this.f, "0X800B4B0", "0X800B4B0", 0, 0, String.valueOf(this.g), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopAssociationsListWrapper
 * JD-Core Version:    0.7.0.1
 */