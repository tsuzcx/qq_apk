package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import anni;
import bkgm;
import bkij;
import bojv;
import bolb;
import bomw;
import bone;
import boty;
import bouq;
import bour;
import bouz;
import bpfw;
import bpye;
import bpyf;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.TransitionProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.ArrayList;
import java.util.List;
import yqu;
import zgi;
import zgj;
import zgl;

public class TransitionProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, bkij, bouq
{
  public int a;
  public bkgm a;
  bomw jdField_a_of_type_Bomw = new bouz(this);
  public MusicItemInfo a;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private TransitionProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter;
  public ArrayList<FilterCategory> a;
  public int b;
  
  public TransitionProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this);
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    bone localbone;
    if (paramMusicItemInfo != null)
    {
      localbone = (bone)bojv.a().c(8);
      if ((localbone == null) || (!localbone.b(paramMusicItemInfo))) {
        break label52;
      }
      localbone.a(paramMusicItemInfo);
      if (this.jdField_a_of_type_Boty != null) {
        this.jdField_a_of_type_Boty.c(true);
      }
    }
    label52:
    while (localbone == null) {
      return;
    }
    localbone.a(paramMusicItemInfo, this.jdField_a_of_type_Bomw);
  }
  
  protected int a()
  {
    return 0;
  }
  
  public ArrayList<bour> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bour localbour = new bour();
      localbour.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      localbour.jdField_a_of_type_Boolean = false;
      localbour.b = (anni.a(2131713738) + localbour.jdField_a_of_type_JavaLangString + anni.a(2131713739));
      localArrayList.add(localbour);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter != null) {
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.a();
    }
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "TransitionProviderView onCreate");
    }
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131560959, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      paramBundle = ((bolb)bojv.a(5)).a;
      if (paramBundle != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "comboFilterData null");
      }
      return;
    }
    setup(paramBundle.a());
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
  }
  
  public void e()
  {
    ApngImage.playByTag(16);
    super.e();
  }
  
  public void f()
  {
    ApngImage.pauseByTag(16);
    super.f();
  }
  
  public void g()
  {
    if (!this.d) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TransitionProviderView", 2, "TransitionProviderView updateSelectedState");
      }
    } while (this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter == null);
    this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramAdapterView = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
        if (paramInt >= paramAdapterView.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        paramView = (TransitionCategoryItem)paramAdapterView.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((paramView != null) && (!paramView.equals(bpye.a().a())))
        {
          bpye.a().a(paramView);
          g();
          if (this.jdField_a_of_type_Boty != null)
          {
            paramInt = Integer.parseInt(paramView.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Boty.e(paramInt);
          }
          yqu.a("video_edit_transition", "clk_effects", bpfw.a(this.jdField_a_of_type_Int), 0, new String[] { paramView.k, paramView.n, paramView.l, paramView.m });
        }
        if (zgl.a().b() == 22)
        {
          if ((paramView == null) || (Integer.valueOf(paramView.jdField_a_of_type_JavaLangString).intValue() >= 0)) {
            break label307;
          }
          LpReportInfo_pf00064.allReport(680, 7, 2);
        }
        while (paramView != null)
        {
          paramAdapterView = new MusicItemInfo();
          paramAdapterView.mType = 2;
          paramView = zgi.a(getContext()).a(paramView.k);
          if ((paramView == null) || (paramView.size() <= 0)) {
            break label372;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((QIMMusicConfigManager)bojv.a(2)).a(((zgj)paramView.get(0)).jdField_a_of_type_Int, ((zgj)paramView.get(0)).b);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {
            break label366;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          return;
          label307:
          if ((paramView != null) && (Integer.valueOf(paramView.jdField_a_of_type_JavaLangString).intValue() == 4)) {
            LpReportInfo_pf00064.allReport(680, 7, 1);
          } else if ((paramView != null) && (Integer.valueOf(paramView.jdField_a_of_type_JavaLangString).intValue() > 0)) {
            LpReportInfo_pf00064.allReport(680, 7, 3);
          }
        }
      }
    }
    label366:
    a(paramAdapterView);
    return;
    label372:
    a(paramAdapterView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
  }
  
  public void setup(ArrayList<FilterCategory> paramArrayList)
  {
    if (paramArrayList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(a());
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter = new TransitionProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.notifyDataSetChanged();
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= this.b);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.b);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.TransitionProviderView
 * JD-Core Version:    0.7.0.1
 */