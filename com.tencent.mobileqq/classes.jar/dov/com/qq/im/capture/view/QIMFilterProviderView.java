package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.FilterProviderGridAdapter;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureRecord;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TemplateSet;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import java.util.ArrayList;
import java.util.List;

public class QIMFilterProviderView
  extends ProviderView
  implements BounceViewPager.PageChangedObserver, AdapterView.OnItemClickListener, CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener
{
  public int a;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  FilterProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter;
  public VideoFilterTools.DataSet a;
  public ArrayList<FilterCategory> a;
  public int b = 0;
  
  public QIMFilterProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void c(Bundle paramBundle)
  {
    Bundle localBundle = null;
    if (paramBundle != null) {
      localBundle = paramBundle.getBundle(QIMFilterProviderView.class.getSimpleName());
    }
    if (localBundle != null)
    {
      if (VideoFilterTools.a().a[this.g] != null) {
        VideoFilterTools.a().a[this.g].c = 1;
      }
      paramBundle = (QIMFilterCategoryItem)localBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "restore " + paramBundle.jdField_a_of_type_JavaLangString);
        }
        paramBundle.c = 1;
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
    int j = VideoFilterTools.a().a();
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
        this.b = i;
        VideoFilterTools.a().a(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.b(this);
    }
    VideoFilterTools.a();
    VideoFilterTools.a(true);
    if (QIMManager.a().a(5))
    {
      CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
      localCaptureComboManager.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[this.g].a();
      localCaptureComboManager.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "onDestroy");
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
      QLog.d("FilterProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if ((paramInt != -1) && (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label91:
      a().onTabChecked(paramInt);
      Object localObject = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
      i = 0;
      label118:
      if (i < ((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.size())
      {
        paramString1 = (QIMFilterCategoryItem)((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.get(i);
        if (!paramString1.jdField_a_of_type_JavaLangString.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilterProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 != null)
        {
          postDelayed(new QIMFilterProviderView.1(this, i), 200L);
          paramString2 = (CaptureComboManager)QIMManager.a(5);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("apply_source", 1);
          ((Bundle)localObject).putInt("capture_scene", this.g);
          paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject);
          g();
        }
        return;
        if ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          paramInt = i;
          break label91;
        }
        i += 1;
        break;
        i += 1;
        break label118;
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
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
      paramBundle = (CaptureComboManager)QIMManager.a(5);
      paramBundle.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "FilterProviderView onCreate");
      }
      paramBundle = paramBundle.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
      if (paramBundle != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "filterProviderView get data is null");
      }
      return;
    }
    setup(paramBundle.a(this.g));
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + paramComboSet.a + " filter ");
    }
    g();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(true);
    }
    g();
    if (paramBoolean)
    {
      paramFilterSet = (QimMusicPlayer)QIMManager.a().c(8);
      if (this.g != 0) {
        break label58;
      }
    }
    label58:
    for (paramInt = QQFilterRenderManagerHolder.b;; paramInt = QQFilterRenderManagerHolder.c)
    {
      paramFilterSet.c(paramInt);
      paramFilterSet.d();
      return;
    }
  }
  
  public void a(TemplateSet paramTemplateSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (paramComboFilterData != null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("FilterProviderView", 2, bool);
      if (paramComboFilterData != null) {
        setup(paramComboFilterData.a(this.g));
      }
      return;
    }
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
    VideoFilterTools.DataSet localDataSet = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet;
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    Object localObject;
    if (localDataSet == null)
    {
      localObject = localCaptureComboManager.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
      if (localObject != null) {
        localDataSet = ((VideoFilterTools.ComboFilterData)localObject).a(this.g);
      }
    }
    for (;;)
    {
      if ((localDataSet != null) && (localDataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null))
      {
        localObject = (Activity)getContext();
        localCaptureComboManager.a(localDataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a((Activity)localObject, this.g);
        VideoFilterTools.a().b(localDataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.g);
        VideoFilterTools.a().a(localDataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, this.g);
        g();
        onItemClick(null, null, 0, 0L);
      }
      return;
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
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(true);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b();
    }
    g();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    ((CaptureComboManager)QIMManager.a(5)).a(this);
  }
  
  public void f()
  {
    super.f();
    ((CaptureComboManager)QIMManager.a(5)).b(this);
  }
  
  public void g()
  {
    if (!this.d) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "FilterProviderView updateSelectedState");
      }
      int j = this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a.keyAt(i);
        ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a.get(k)).getAdapter();
        if ((localListAdapter instanceof FilterProviderGridAdapter)) {
          ((FilterProviderGridAdapter)localListAdapter).notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    if (paramView != null) {
      paramAdapterView = paramView.getTag();
    }
    if ((paramAdapterView != null) && ((paramAdapterView instanceof QIMFilterCategoryItem))) {
      paramAdapterView = (QIMFilterCategoryItem)paramAdapterView;
    }
    while (paramAdapterView.f()) {
      do
      {
        WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView);
        do
        {
          return;
        } while (this.jdField_a_of_type_JavaUtilArrayList == null);
        paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b())).jdField_a_of_type_JavaUtilList.get(paramInt);
      } while (paramAdapterView == null);
    }
    if ((paramLong > 0L) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(-1, paramAdapterView);
    }
    paramView = (CaptureComboManager)QIMManager.a(5);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.g);
    paramView.a(paramAdapterView, (Activity)getContext(), localBundle);
    ((QIMPredownManager)QIMManager.a(14)).a(paramAdapterView.b, 1);
    ((CaptureComboManager)QIMManager.a(5)).a(this.g, (Activity)this.jdField_a_of_type_AndroidContentContext);
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
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = paramDataSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramDataSet.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(this.b);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.b);
    }
    this.jdField_a_of_type_DovComQqImCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMFilterProviderView
 * JD-Core Version:    0.7.0.1
 */