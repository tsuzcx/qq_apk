package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TemplateSet;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.tencent.biz.qqstory.takevideo.StoryMediaEditNotifier;
import java.util.ArrayList;
import java.util.List;

public class VideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements CaptureComboManager.CaptureComboListener
{
  public int a;
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private ProviderView.ProviderViewListener jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener;
  private VideoFilterViewPager.SelectCallBack jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$SelectCallBack;
  private VideoFilterViewPager.VideoFilterPageChangeListener jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPageChangeListener;
  private VideoFilterViewPager.VideoFilterPagerAdapter jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter;
  private int jdField_b_of_type_Int = -1;
  long jdField_b_of_type_Long = 0L;
  public boolean b;
  public boolean c = true;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  private boolean g = true;
  private boolean h;
  private boolean i = true;
  private boolean j = false;
  
  public VideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    e();
  }
  
  public VideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    e();
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageSelect position: " + paramInt + ", mCurPosition: " + this.jdField_b_of_type_Int + ", mFromOnlyChangeUi: " + this.e);
    }
    if (paramInt == this.jdField_b_of_type_Int) {}
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_b_of_type_Int = paramInt;
      paramView.setVisibility(0);
      localQIMFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
    return;
    Object localObject2;
    Object localObject1;
    if (AEBaseReportParam.a().b())
    {
      localObject2 = AEBaseDataReporter.a();
      if (paramInt == 0)
      {
        localObject1 = "none";
        label131:
        ((AEBaseDataReporter)localObject2).k((String)localObject1);
        localObject1 = (TextView)paramView.findViewById(2131365012);
        localObject2 = (TextView)paramView.findViewById(2131365011);
        Object localObject3 = (CaptureComboManager)QIMManager.a(5);
        if (!this.e)
        {
          Object localObject4 = new Bundle();
          ((Bundle)localObject4).putInt("apply_source", 2);
          ((Bundle)localObject4).putInt("capture_scene", this.jdField_a_of_type_Int);
          ((CaptureComboManager)localObject3).a(localQIMFilterCategoryItem, (Activity)getContext(), (Bundle)localObject4);
          if ((this.j) && (this.i)) {
            AEFilterProviderView.a(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
          }
          if (paramBoolean)
          {
            localObject4 = (Activity)getContext();
            if (((Activity)localObject4).getIntent() != null)
            {
              paramInt = ((Activity)getContext()).getIntent().getIntExtra("edit_video_type", 10002);
              if (!(localObject4 instanceof QIMCameraCaptureActivity)) {
                break label544;
              }
              StoryReportor.a("clk_swipe", paramInt, 0, new String[] { "", localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString });
            }
          }
        }
        label314:
        localObject3 = ((CaptureComboManager)localObject3).a(localQIMFilterCategoryItem);
        paramInt = ((FilterSet)localObject3).d();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "onPageSelect state = " + paramInt + " " + ((FilterSet)localObject3).toString());
        }
        if ((!localQIMFilterCategoryItem.c()) && (!localQIMFilterCategoryItem.jdField_a_of_type_Boolean) && (!this.d)) {
          break label571;
        }
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.c) {
        this.c = false;
      }
      if (!this.g) {
        this.g = true;
      }
      paramView.setVisibility(0);
      a(paramView, localQIMFilterCategoryItem, paramInt);
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener == null) {
        break;
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(true);
      return;
      localObject1 = "" + localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
      break label131;
      localObject2 = AEBaseDataReporter.a();
      if (paramInt == 0) {}
      for (localObject1 = "none";; localObject1 = "" + localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)
      {
        ((AEBaseDataReporter)localObject2).f((String)localObject1);
        break;
      }
      label544:
      StoryReportor.b("filter_swipe", paramInt, 0, new String[] { "", localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString });
      break label314;
      label571:
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
    }
  }
  
  private void a(View paramView, QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131365012);
    TextView localTextView2 = (TextView)paramView.findViewById(2131365011);
    ViewParent localViewParent = getParent();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localViewParent != null)
    {
      localObject1 = localObject2;
      if ((localViewParent instanceof RelativeLayout)) {
        localObject1 = (RelativeLayout)((RelativeLayout)localViewParent).findViewById(2131370761);
      }
    }
    boolean bool = ((CaptureComboManager)QIMManager.a(5)).c();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.h) && (localTextView1 != null) && (localTextView2 != null))
      {
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(8);
      }
      return;
      if (!bool)
      {
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
        localTextView1.setText(paramQIMFilterCategoryItem.b);
        if (localTextView2 != null) {
          localTextView2.setText(paramQIMFilterCategoryItem.i);
        }
        paramQIMFilterCategoryItem = new VideoFilterViewPager.1(this, paramView);
        paramView.setVisibility(0);
        paramView.postDelayed(paramQIMFilterCategoryItem, 800L);
        paramView.setTag(paramQIMFilterCategoryItem);
      }
      else
      {
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
        localTextView1.setText(paramQIMFilterCategoryItem.b);
        localTextView1.setVisibility(8);
        if (localTextView2 != null)
        {
          localTextView2.setText(paramQIMFilterCategoryItem.i);
          localTextView2.setVisibility(8);
          continue;
          if (!bool)
          {
            if (!this.f) {
              if (localObject1 != null)
              {
                ((RelativeLayout)localObject1).setVisibility(0);
                QLog.i("VideoFilterViewPager", 2, "loadingView VISIBLE");
              }
            }
            for (;;)
            {
              paramView.setVisibility(0);
              localTextView1.setText(paramQIMFilterCategoryItem.b);
              if (localTextView2 == null) {
                break;
              }
              localTextView2.setText(paramQIMFilterCategoryItem.i);
              break;
              if (localObject1 != null)
              {
                ((RelativeLayout)localObject1).setVisibility(8);
                QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
              }
            }
          }
          localTextView1.setText(paramQIMFilterCategoryItem.b);
          localTextView1.setVisibility(8);
          if (localTextView2 != null)
          {
            localTextView2.setText(paramQIMFilterCategoryItem.i);
            localTextView2.setVisibility(8);
          }
          if (localObject1 != null)
          {
            ((RelativeLayout)localObject1).setVisibility(8);
            QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
            continue;
            if (localObject1 != null)
            {
              ((RelativeLayout)localObject1).setVisibility(8);
              QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
            }
            paramView.setVisibility(8);
          }
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    View localView = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, ((CaptureComboManager)QIMManager.a(5)).a(localQIMFilterCategoryItem).jdField_a_of_type_Int);
      }
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, 4);
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter = new VideoFilterViewPager.VideoFilterPagerAdapter(this);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPageChangeListener = new VideoFilterViewPager.VideoFilterPageChangeListener(this);
    setAdapter(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter);
    setOnPageChangeListener(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPageChangeListener);
  }
  
  public void a()
  {
    String str = AEFilterProviderView.a();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(str);
  }
  
  public void a(int paramInt)
  {
    setCurrentItem(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a() * 50 + paramInt);
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      QLog.e("QCombo", 1, "onComboApply aborted");
    }
    for (;;)
    {
      return;
      paramInt = paramBundle.getInt("capture_scene", -1);
      if (this.jdField_a_of_type_Int != paramInt)
      {
        QLog.e("QCombo", 2, "onComboApply aborted " + this.jdField_a_of_type_Int + paramInt);
        return;
      }
      paramBundle = ((CaptureComboManager)QIMManager.a(5)).a(paramComboSet, this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a);
      ArrayList localArrayList = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a;
      this.d = true;
      int k;
      if (localArrayList != null)
      {
        k = localArrayList.indexOf(paramBundle);
        paramInt = k;
        if (k >= 0)
        {
          paramInt = k;
          if (k != getCurrentItem())
          {
            this.e = true;
            a(k);
          }
        }
      }
      for (paramInt = k; QLog.isColorLevel(); paramInt = -1)
      {
        QLog.i("QCombo", 2, "vp onComboApply combo " + paramComboSet.jdField_a_of_type_JavaLangObject + " filter " + paramBundle + " index " + paramInt);
        return;
      }
    }
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      QLog.e("QCombo", 1, "onFilterApply aborted");
    }
    do
    {
      ArrayList localArrayList;
      do
      {
        do
        {
          return;
          paramInt = paramBundle.getInt("capture_scene", -1);
          if (this.jdField_a_of_type_Int != paramInt)
          {
            QLog.e("QCombo", 2, "onFilterApply aborted " + this.jdField_a_of_type_Int + paramInt);
            return;
          }
        } while (!(paramFilterSet.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem));
        AEBaseReportParam.a().e(paramFilterSet.b());
        paramFilterSet = (QIMFilterCategoryItem)paramFilterSet.jdField_a_of_type_JavaLangObject;
        localArrayList = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a;
      } while (localArrayList == null);
      paramInt = localArrayList.indexOf(paramFilterSet);
    } while (paramInt < 0);
    this.d = false;
    int k;
    if ((paramBundle.getInt("apply_source", 2) == 1) || (paramBundle.getInt("apply_source", 2) == CaptureComboManager.jdField_a_of_type_Int))
    {
      this.e = true;
      k = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a() * 50 + paramInt;
      if (k == this.jdField_b_of_type_Int) {
        if (paramBoolean)
        {
          b(k);
          this.e = false;
        }
      }
    }
    for (;;)
    {
      StoryReportor.a((Activity)getContext(), "filter_element", String.valueOf(paramFilterSet.jdField_a_of_type_Int), paramFilterSet.jdField_a_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      StoryMediaEditNotifier.a().a();
      return;
      c(k);
      continue;
      if (paramBoolean)
      {
        a(paramInt);
        continue;
        if ((paramBundle.getInt("apply_source", 2) == 2) && (paramInt == this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(this.jdField_b_of_type_Int)))
        {
          paramInt = this.jdField_b_of_type_Int;
          if (paramBoolean) {
            b(paramInt);
          } else {
            c(paramInt);
          }
        }
      }
    }
  }
  
  public void a(TemplateSet paramTemplateSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (paramComboFilterData != null)
    {
      paramComboFilterData = paramComboFilterData.a(this.jdField_a_of_type_Int);
      if (paramComboFilterData != null)
      {
        a(paramComboFilterData.c);
        int k = paramComboFilterData.c.indexOf(VideoFilterTools.a().c(this.jdField_a_of_type_Int));
        QLog.i("VideoFilterViewPager", 2, "onResourceDownload - update viewpagerIndex = " + k + "; getCurrentItem()" + getCurrentItem());
        if ((k != -1) && (k != getCurrentItem()))
        {
          QLog.i("VideoFilterViewPager", 2, "onResourceDownload - initialViewPagerPosition ");
          this.e = true;
          a(k);
          this.e = false;
        }
      }
    }
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    if (!(getContext() instanceof QzoneEditVideoActivity))
    {
      setVisibility(0);
      setEnabled(true);
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramList);
    QLog.i("VideoFilterViewPager", 2, "update getCurrentItem = " + getCurrentItem());
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b()
  {
    int k = getCurrentItem();
    QLog.i("VideoFilterViewPager", 2, "needReselectMiddle getActualCount " + this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a());
    if ((k == 0) || (k % this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a() == 0)) {
      QLog.i("VideoFilterViewPager", 2, "needReselectMiddle ");
    }
    for (k = 1;; k = 0)
    {
      if (k != 0) {
        setCurrentItem(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a() * 50, false);
      }
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_Long = 0L;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ((CaptureComboManager)QIMManager.a(5)).a(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ((CaptureComboManager)QIMManager.a(5)).b(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void setCaptureScene(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setIsNormalMode(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (!this.j) {
      this.j = true;
    }
  }
  
  public void setReadyToApply(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setSecleteCallBack(VideoFilterViewPager.SelectCallBack paramSelectCallBack)
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$SelectCallBack = paramSelectCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */