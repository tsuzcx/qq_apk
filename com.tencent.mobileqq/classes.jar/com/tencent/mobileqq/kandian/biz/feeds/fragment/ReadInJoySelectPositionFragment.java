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
  private WordNavView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetWordNavView;
  private ReadInJoySelectPositionHeader jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader;
  private SelectCityAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsSelectCityAdapter;
  private SelectCityPresenter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsSelectCityPresenter;
  private PositionData jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData = new PositionData();
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<CityData> jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.changeBg(true);
    a("城市");
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.a())) {
      View.inflate(getQBaseActivity(), 2131560251, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  private void a(String paramString)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      if ((((CityData)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == 1) && (((CityData)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        j = i;
        break;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetListView.setSelection(j + 1);
  }
  
  private void c()
  {
    if (this.b != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.b.findViewById(2131364648));
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetWordNavView = ((WordNavView)this.b.findViewById(2131368757));
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetWordNavView.setOnTouchingWordChangedListener(new ReadInJoySelectPositionFragment.1(this));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsSelectCityAdapter = new SelectCityAdapter(getQBaseActivity());
      d();
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsSelectCityAdapter);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(new ReadInJoySelectPositionFragment.2(this));
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader = new ReadInJoySelectPositionHeader(getQBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader.setSelectCityListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader);
  }
  
  private void e()
  {
    Object localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null)
    {
      PositionData localPositionData = ((SelectPositionModule)localObject).c();
      localObject = ((SelectPositionModule)localObject).b();
      if (localPositionData != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData.copy(localPositionData);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader.setSelectedCity(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData.city);
      }
      else if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader.setSelectedCity(((PositionData)localObject).city);
      }
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader.setGPSCity(((PositionData)localObject).cityGPS);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsSelectCityPresenter = new SelectCityPresenter(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsSelectCityPresenter.a();
  }
  
  protected int a()
  {
    return 2131560276;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData.cityCode == null) || (!this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData.cityCode.equals(paramPositionData.cityCode)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData.copy(paramPositionData);
      localObject = ReadInJoyLogicEngine.a().a();
      if (localObject != null)
      {
        ((SelectPositionModule)localObject).a(paramPositionData);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader.setSelectedCity(paramPositionData.city);
      }
      ReadInJoyLogicEngine.a().a(41695, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData.city);
      paramPositionData = ReadInJoyLogicEngine.a().a();
      if (paramPositionData != null) {
        paramPositionData.a().b(41695);
      }
      ReadInJoyLogicEngineEventDispatcher.a().g(41695);
    }
    onBackEvent();
  }
  
  public void a(List<CityData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsSelectCityAdapter.a(this.jdField_a_of_type_JavaUtilList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((CityData)paramList.get(i)).jdField_a_of_type_Int == 1) {
        localArrayList.add(((CityData)paramList.get(i)).jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetWordNavView.setIndexList(localArrayList);
  }
  
  public void b(PositionData paramPositionData)
  {
    ReadInJoySelectPositionHeader localReadInJoySelectPositionHeader = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySelectPositionFragment
 * JD-Core Version:    0.7.0.1
 */