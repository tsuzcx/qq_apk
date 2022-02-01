package dov.com.qq.im.capture.view;

import amtj;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import bhkl;
import bjng;
import bmql;
import bmrr;
import bmte;
import bmtm;
import bmyx;
import bmzp;
import bmzq;
import bmzw;
import bnev;
import bnub;
import bnuc;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.TransitionProviderPagerAdapter;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.ArrayList;
import java.util.List;
import xwa;
import yld;
import yle;
import ylg;

public class TransitionProviderView
  extends ProviderView
  implements Handler.Callback, bhkl, bmzp, AdapterView.OnItemClickListener
{
  public int a;
  public bjng a;
  bmte jdField_a_of_type_Bmte = new bmzw(this);
  public MusicItemInfo a;
  private BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  private TransitionProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter;
  public ArrayList<FilterCategory> a;
  public int b;
  
  public TransitionProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Bjng = new bjng(Looper.getMainLooper(), this);
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    bmtm localbmtm;
    if (paramMusicItemInfo != null)
    {
      localbmtm = (bmtm)bmql.a().c(8);
      if ((localbmtm == null) || (!localbmtm.b(paramMusicItemInfo))) {
        break label52;
      }
      localbmtm.a(paramMusicItemInfo);
      if (this.jdField_a_of_type_Bmyx != null) {
        this.jdField_a_of_type_Bmyx.c(true);
      }
    }
    label52:
    while (localbmtm == null) {
      return;
    }
    localbmtm.a(paramMusicItemInfo, this.jdField_a_of_type_Bmte);
  }
  
  protected int a()
  {
    return 0;
  }
  
  public ArrayList<bmzq> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bmzq localbmzq = new bmzq();
      localbmzq.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      localbmzq.jdField_a_of_type_Boolean = false;
      localbmzq.b = (amtj.a(2131714079) + localbmzq.jdField_a_of_type_JavaLangString + amtj.a(2131714080));
      localArrayList.add(localbmzq);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter != null) {
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.b(this);
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "TransitionProviderView onCreate");
    }
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131560861, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
      paramBundle = ((bmrr)bmql.a(5)).a;
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
  
  public void b(int paramInt) {}
  
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem() < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramAdapterView = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
        if (paramInt >= paramAdapterView.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        paramView = (TransitionCategoryItem)paramAdapterView.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((paramView != null) && (!paramView.equals(bnub.a().a())))
        {
          bnub.a().a(paramView);
          g();
          if (this.jdField_a_of_type_Bmyx != null)
          {
            paramInt = Integer.parseInt(paramView.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Bmyx.d(paramInt);
          }
          xwa.a("video_edit_transition", "clk_effects", bnev.a(this.jdField_a_of_type_Int), 0, new String[] { paramView.k, paramView.n, paramView.l, paramView.m });
        }
        if (ylg.a().b() == 22)
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
          paramView = yld.a(getContext()).a(paramView.k);
          if ((paramView == null) || (paramView.size() <= 0)) {
            break label372;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((QIMMusicConfigManager)bmql.a(2)).a(((yle)paramView.get(0)).jdField_a_of_type_Int, ((yle)paramView.get(0)).b);
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
  
  public void onTabChecked(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
  }
  
  public void setup(ArrayList<FilterCategory> paramArrayList)
  {
    if (paramArrayList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter = new TransitionProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderPagerAdapter.notifyDataSetChanged();
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= this.b);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(this.b);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.TransitionProviderView
 * JD-Core Version:    0.7.0.1
 */