package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.base.view.widget.WordNavView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoySelectPositionHeader;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoySelectPositionHeader.ISelectCityListener;
import com.tencent.mobileqq.kandian.biz.feeds.SelectCityAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.SelectCityPresenter;
import com.tencent.mobileqq.kandian.biz.feeds.SelectCityPresenter.IView;
import com.tencent.mobileqq.kandian.biz.ugc.Utils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.CityData;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoySelectPositionFragment
  extends QIphoneTitleBarFragment
  implements ReadInJoySelectPositionHeader.ISelectCityListener, SelectCityPresenter.IView
{
  private ListView a;
  private WordNavView b;
  private ReadInJoySelectPositionHeader c;
  private SelectCityAdapter d;
  private SelectCityPresenter e;
  private PositionData f = new PositionData();
  private List<CityData> g;
  
  private void a(String paramString)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.g.size()) {
        break;
      }
      if ((((CityData)this.g.get(i)).a == 1) && (((CityData)this.g.get(i)).b.equals(paramString)))
      {
        j = i;
        break;
      }
      i += 1;
    }
    this.a.setSelection(j + 1);
  }
  
  private void b()
  {
    this.p.changeBg(true);
    a("城市");
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.b())) {
      View.inflate(getQBaseActivity(), 2131626298, this.s);
    }
  }
  
  private void c()
  {
    if (this.t != null)
    {
      this.a = ((ListView)this.t.findViewById(2131430735));
      this.b = ((WordNavView)this.t.findViewById(2131435674));
      this.b.setOnTouchingWordChangedListener(new ReadInJoySelectPositionFragment.1(this));
      this.d = new SelectCityAdapter(getQBaseActivity());
      d();
      this.a.setAdapter(this.d);
      this.a.setOnItemClickListener(new ReadInJoySelectPositionFragment.2(this));
    }
  }
  
  private void d()
  {
    this.c = new ReadInJoySelectPositionHeader(getQBaseActivity());
    this.c.setSelectCityListener(this);
    this.a.addHeaderView(this.c);
  }
  
  private void e()
  {
    Object localObject = ReadInJoyLogicEngine.a().j();
    if (localObject != null)
    {
      PositionData localPositionData = ((SelectPositionModule)localObject).e();
      localObject = ((SelectPositionModule)localObject).c();
      if (localPositionData != null)
      {
        this.f.copy(localPositionData);
        this.c.setSelectedCity(this.f.city);
      }
      else if (localObject != null)
      {
        this.c.setSelectedCity(((PositionData)localObject).city);
      }
      if (localObject != null) {
        this.c.setGPSCity(((PositionData)localObject).cityGPS);
      }
    }
    this.e = new SelectCityPresenter(this);
    this.e.a();
  }
  
  protected int a()
  {
    return 2131626323;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    c();
    e();
    RIJDtReportHelper.a.a(getQBaseActivity());
  }
  
  public void a(PositionData paramPositionData)
  {
    if (paramPositionData == null)
    {
      QLog.e("ReadInJoySelectPositionFragment", 2, "selectPosition positionData = null");
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("selectPosition positionData");
      ((StringBuilder)localObject).append(paramPositionData);
      QLog.i("ReadInJoySelectPositionFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.f.cityCode == null) || (!this.f.cityCode.equals(paramPositionData.cityCode)))
    {
      this.f.copy(paramPositionData);
      localObject = ReadInJoyLogicEngine.a().j();
      if (localObject != null)
      {
        ((SelectPositionModule)localObject).b(paramPositionData);
        this.c.setSelectedCity(paramPositionData.city);
      }
      ReadInJoyLogicEngine.a().a(41695, this.f.city);
      paramPositionData = ReadInJoyLogicEngine.a().ab();
      if (paramPositionData != null) {
        paramPositionData.i().e(41695);
      }
      ReadInJoyLogicEngineEventDispatcher.a().f(41695);
    }
    onBackEvent();
  }
  
  public void a(List<CityData> paramList)
  {
    this.g = paramList;
    this.d.a(this.g);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((CityData)paramList.get(i)).a == 1) {
        localArrayList.add(((CityData)paramList.get(i)).b);
      }
      i += 1;
    }
    this.b.setIndexList(localArrayList);
  }
  
  public void b(PositionData paramPositionData)
  {
    ReadInJoySelectPositionHeader localReadInJoySelectPositionHeader = this.c;
    if (localReadInJoySelectPositionHeader != null) {
      localReadInJoySelectPositionHeader.setGPSCity(paramPositionData.cityGPS);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Utils.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySelectPositionFragment
 * JD-Core Version:    0.7.0.1
 */