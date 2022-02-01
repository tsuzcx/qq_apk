package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.ComboProviderGridAdapter;
import dov.com.qq.im.capture.adapter.ComboProviderPagerAdapter;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener;
import dov.com.qq.im.capture.data.CaptureComboObeserver;
import dov.com.qq.im.capture.data.ComboLockManager;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TemplateSet;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComboProviderView
  extends ProviderView
  implements Handler.Callback, BounceViewPager.PageChangedObserver, AdapterView.OnItemClickListener, CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener
{
  public int a;
  public Handler a;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  ComboProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter;
  CaptureComboObeserver jdField_a_of_type_DovComQqImCaptureDataCaptureComboObeserver = new ComboProviderView.1(this);
  public VideoFilterTools.DataSet a;
  ArrayList<FilterCategory> jdField_a_of_type_JavaUtilArrayList;
  
  public ComboProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject = null;
    if (paramBundle != null) {
      localObject = paramBundle.getBundle(ComboProviderView.class.getSimpleName());
    }
    if (localObject != null)
    {
      paramBundle = (QIMFilterCategoryItem)((Bundle)localObject).getParcelable("select_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComboProviderView", 2, "restore " + paramBundle.jdField_a_of_type_JavaLangString);
        }
        localObject = (CaptureComboManager)QIMManager.a(5);
        if (((this.g == 2) || (this.g == 1)) && (VideoFilterTools.a().a[this.g] == null)) {
          VideoFilterTools.a().a[this.g] = ((CaptureComboManager)localObject).a(paramBundle);
        }
        paramBundle = ((CaptureComboManager)localObject).a;
        if (paramBundle != null) {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = paramBundle.a(this.g);
        }
      }
    }
  }
  
  protected int a()
  {
    return 2131561010;
  }
  
  public ArrayList<QIMSlidingTabView.TabIcon> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = VideoFilterTools.a().b();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
      localTabIcon.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      VideoFilterTools.a();
      localTabIcon.jdField_a_of_type_Boolean = VideoFilterTools.a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int, "");
      localArrayList.add(localTabIcon);
      if ((j != -1) && (j == ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Int = i;
        VideoFilterTools.a().a(7, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboObeserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.b(this);
    }
    if (QIMManager.a().a(5)) {
      ((CaptureComboManager)QIMManager.a(5)).b(this);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ComboProviderView", 2, "selectCategoryAndItem when mTagInfos null " + paramInt + " " + paramString2);
      }
      return;
    }
    int i = 0;
    label100:
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if ((paramInt != -1) && (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label139:
      a().onTabChecked(paramInt);
      Object localObject = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
      i = 0;
      label166:
      if (i < ((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.size())
      {
        paramString1 = (QIMFilterCategoryItem)((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.get(i);
        if (!paramString1.jdField_a_of_type_JavaLangString.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComboProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 == null) {
          break;
        }
        if (paramString1.f())
        {
          WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString1);
          return;
          if ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            paramInt = i;
            break label139;
          }
          i += 1;
          break label100;
          i += 1;
          break label166;
        }
        postDelayed(new ComboProviderView.2(this, i), 500L);
        paramString2 = (CaptureComboManager)QIMManager.a(5);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("apply_source", 1);
        ((Bundle)localObject).putInt("capture_scene", this.g);
        ComboSet localComboSet = paramString2.a(paramString1);
        if ((localComboSet.jdField_a_of_type_Int == 1) || (localComboSet.jdField_a_of_type_Int == 2)) {
          QIMCommonLoadingProgress.a(localComboSet).a();
        }
        paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject);
        g();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ComboProviderView", 2, "selectFilterItem state = " + paramString1);
        return;
        i = 0;
        paramString1 = null;
      }
      paramInt = 0;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131561010, this, false));; this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)this.jdField_a_of_type_AndroidViewView))
    {
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboObeserver);
      paramBundle = (CaptureComboManager)QIMManager.a(5);
      paramBundle.a(this);
      paramBundle.a().a(this.g);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "ComboProviderView onCreate");
      }
      paramBundle = paramBundle.a;
      if (paramBundle != null) {
        setup(paramBundle.a(this.g));
      }
      paramBundle = (PasterDataManager)QIMManager.a().c(4);
      paramBundle.forceInit();
      paramBundle.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    g();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    int j = 0;
    int k = paramQIMFilterCategoryItem.jdField_a_of_type_Int;
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int != k) {}
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem() != i) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(i);
      }
      Iterator localIterator = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaUtilList.iterator();
      i = j;
      for (;;)
      {
        if ((!localIterator.hasNext()) || (((QIMFilterCategoryItem)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)))
        {
          paramQIMFilterCategoryItem = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
          if (paramQIMFilterCategoryItem != null)
          {
            paramQIMFilterCategoryItem.setSelection(i);
            ((ComboProviderGridAdapter)paramQIMFilterCategoryItem.getAdapter()).a();
          }
          return;
          i += 1;
          break;
        }
        i += 1;
      }
      i = 0;
    }
  }
  
  public void a(TemplateSet paramTemplateSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    setup(paramComboFilterData.a(this.g));
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet != null)
    {
      CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
      Activity localActivity = (Activity)getContext();
      VideoFilterTools.DataSet localDataSet = localCaptureComboManager.a.a(this.g);
      if (localDataSet.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null) {
        localCaptureComboManager.a(localDataSet.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a(localActivity, this.g);
      }
      VideoFilterTools.a().a(localDataSet.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, localActivity, this.g);
      g();
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a().jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
    if (localQIMFilterCategoryItem != null) {
      a(localQIMFilterCategoryItem);
    }
  }
  
  public void e()
  {
    super.e();
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    if (localCaptureComboManager.a().c)
    {
      localCaptureComboManager.a().c = false;
      ((QIMProviderContainerView)((Activity)getContext()).findViewById(2131373593)).b(0);
    }
    g();
  }
  
  public void f()
  {
    VideoFilterTools.a();
    VideoFilterTools.a(true);
    super.f();
    if (QIMManager.a().a(5)) {
      ((CaptureComboManager)QIMManager.a(5)).a(this.g, (Activity)getContext());
    }
  }
  
  public void g()
  {
    if (!this.d) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "ComboProviderView updateComboState");
      }
      int j = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a.keyAt(i);
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a.get(k)).getAdapter();
        if ((localListAdapter instanceof ComboProviderGridAdapter)) {
          ((ComboProviderGridAdapter)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = b();
    paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramAdapterView.f()) {
      WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView);
    }
    do
    {
      do
      {
        return;
        if ((paramLong > 0L) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(-1, paramAdapterView);
        }
        paramView = (CaptureComboManager)QIMManager.a(5);
        ((QIMPredownManager)QIMManager.a(14)).a(paramAdapterView.jdField_a_of_type_JavaLangString, 0);
        localObject = paramAdapterView.jdField_a_of_type_JavaLangString;
      } while (paramView.a().a((String)localObject, getContext()));
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("apply_source", 1);
      ((Bundle)localObject).putInt("capture_scene", this.g);
      ComboSet localComboSet = paramView.a(paramAdapterView);
      if ((localComboSet.jdField_a_of_type_Int == 1) || (localComboSet.jdField_a_of_type_Int == 2)) {
        QIMCommonLoadingProgress.a(localComboSet).a();
      }
      paramView.a(paramAdapterView, (Activity)getContext(), (Bundle)localObject);
      if ((SlideShowPhotoListManager.a().b() == 22) && (paramAdapterView.f != null) && (paramAdapterView.f.isEmpty())) {
        LpReportInfo_pf00064.allReport(680, 6, 1);
      }
      if ((SlideShowPhotoListManager.a().b() == 22) && (paramAdapterView.f != null) && (!paramAdapterView.f.isEmpty())) {
        LpReportInfo_pf00064.allReport(680, 6, 2);
      }
      g();
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "onItemClick combo " + i + "," + paramInt + ", combo " + localComboSet);
      }
    } while (!QLog.isColorLevel());
    QLog.i("QCombo", 2, "onItemClick state = " + paramAdapterView);
  }
  
  public void onTabChecked(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
    VideoFilterTools.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int, "");
  }
  
  public void setup(VideoFilterTools.DataSet paramDataSet)
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = paramDataSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramDataSet.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureAdapterComboProviderPagerAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_a_of_type_Int);
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ComboProviderView
 * JD-Core Version:    0.7.0.1
 */