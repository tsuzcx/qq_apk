package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aopo;
import aopq;
import aops;
import aopt;
import aopu;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.FilterDetailAnimationLayout;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import java.util.ArrayList;
import java.util.List;

public class VideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements CaptureComboManager.CaptureComboListener
{
  public int a;
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private aopt jdField_a_of_type_Aopt;
  private aopu jdField_a_of_type_Aopu;
  private ProviderView.ProviderViewListener jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener;
  private VideoFilterViewPager.ScrollCallBack jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$ScrollCallBack;
  public boolean a;
  private int b;
  public long b;
  public boolean b;
  public boolean c;
  private boolean d = true;
  
  public VideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    b();
  }
  
  public VideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    b();
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (MediaCodecDPC.l()) {}
    label555:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageSelect position: " + paramInt + ", mCurPosition: " + this.jdField_b_of_type_Int + ", mFromOnlyChangeUi: " + this.c);
      }
      if (paramInt != this.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_AndroidViewView = paramView;
        int i = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = paramInt;
        paramView.setVisibility(0);
        QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_Aopu.a(paramInt);
        if (localQIMFilterCategoryItem == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
          }
        }
        else
        {
          TextView localTextView = (TextView)paramView.findViewById(2131364388);
          Object localObject2 = (CaptureComboManager)QIMManager.a(5);
          Object localObject1;
          ImageView localImageView;
          if (this.c)
          {
            localObject1 = ((CaptureComboManager)localObject2).a(localQIMFilterCategoryItem);
            a(paramView);
            ((CaptureComboManager)localObject2).a(localQIMFilterCategoryItem);
            this.jdField_a_of_type_Aopu.a(i);
            localObject2 = (ComboProviderView)((Activity)getContext()).findViewById(2131362420);
            localObject2 = (QIMFilterProviderView)((Activity)getContext()).findViewById(2131362421);
            paramInt = ((CaptureComboBase)localObject1).jdField_a_of_type_Int;
            if (QLog.isColorLevel()) {
              QLog.i("QCombo", 2, "onPageSelect state = " + paramInt);
            }
            localObject1 = (LinearLayout)paramView.findViewById(2131364387);
            localObject2 = paramView.findViewById(2131364390);
            localImageView = (ImageView)paramView.findViewById(2131364389);
            ((LinearLayout)localObject1).setGravity(3);
            if ((!localQIMFilterCategoryItem.c()) && (!localQIMFilterCategoryItem.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
              break label460;
            }
            localTextView.setVisibility(8);
            ((View)localObject2).setVisibility(8);
            localImageView.setVisibility(8);
            label331:
            if (this.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_Boolean = false;
            }
            if (!this.d) {
              this.d = true;
            }
            paramView.setVisibility(0);
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener == null) {
              break label555;
            }
            this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.d(true);
            return;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("apply_source", 2);
            ((Bundle)localObject1).putInt("capture_scene", this.jdField_a_of_type_Int);
            localObject1 = ((CaptureComboManager)localObject2).a(localQIMFilterCategoryItem, (Activity)getContext(), (Bundle)localObject1);
            a(paramView);
            break;
            label460:
            localTextView.setVisibility(0);
            ((View)localObject2).setVisibility(8);
            localImageView.setVisibility(8);
            break label331;
            localTextView.setText(localQIMFilterCategoryItem.b);
            ((View)localObject2).setVisibility(8);
            if (localQIMFilterCategoryItem.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              localImageView.setVisibility(0);
              localImageView.startAnimation(a(localImageView));
              continue;
              a(paramView, localQIMFilterCategoryItem, paramInt);
              continue;
              a(paramView, localQIMFilterCategoryItem, paramInt);
            }
          }
        }
      }
    }
  }
  
  private void a(View paramView, QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131364388);
    paramView.findViewById(2131364391);
    paramView.findViewById(2131364393);
    Object localObject = (TextView)paramView.findViewById(2131364392);
    localObject = (TextView)paramView.findViewById(2131364394);
    localObject = (FilterDetailAnimationLayout)paramView.findViewById(2131364390);
    localObject = (ImageView)paramView.findViewById(2131364389);
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      localObject = new aopq(this, paramView);
      paramView.setVisibility(0);
      paramView.postDelayed((Runnable)localObject, 800L);
      paramView.setTag(localObject);
      localTextView.setText(paramQIMFilterCategoryItem.b);
      return;
    }
    localTextView.setText(paramQIMFilterCategoryItem.b);
    ((ImageView)localObject).setVisibility(8);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aopu = new aopu(this);
    this.jdField_a_of_type_Aopt = new aopt(this);
    setAdapter(this.jdField_a_of_type_Aopu);
    setOnPageChangeListener(this.jdField_a_of_type_Aopt);
  }
  
  public AnimationSet a(ImageView paramImageView)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.4F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(200L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(200L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setDuration(200L);
    paramImageView.startAnimation(localAnimationSet);
    localAnimationSet.setAnimationListener(new aops(this, paramImageView));
    return localAnimationSet;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(int paramInt)
  {
    setCurrentItem(this.jdField_a_of_type_Aopu.a() * 50 + paramInt);
  }
  
  public void a(View paramView)
  {
    aopo localaopo = new aopo(this, paramView);
    paramView.setVisibility(0);
    paramView.postDelayed(localaopo, 800L);
    paramView.setTag(localaopo);
  }
  
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
      paramBundle = ((CaptureComboManager)QIMManager.a(5)).a(paramComboSet, this.jdField_a_of_type_Aopu.a);
      ArrayList localArrayList = this.jdField_a_of_type_Aopu.a;
      this.jdField_b_of_type_Boolean = true;
      int i;
      if (localArrayList != null)
      {
        i = localArrayList.indexOf(paramBundle);
        paramInt = i;
        if (i >= 0)
        {
          paramInt = i;
          if (i != getCurrentItem())
          {
            this.c = true;
            a(i);
          }
        }
      }
      for (paramInt = i; QLog.isColorLevel(); paramInt = -1)
      {
        QLog.i("QCombo", 2, "vp onComboApply combo " + paramComboSet.a + " filter " + paramBundle + " index " + paramInt);
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
          } while (!(paramFilterSet.a instanceof QIMFilterCategoryItem));
          paramFilterSet = (QIMFilterCategoryItem)paramFilterSet.a;
          localArrayList = this.jdField_a_of_type_Aopu.a;
        } while (localArrayList == null);
        paramInt = localArrayList.indexOf(paramFilterSet);
      } while (paramInt < 0);
      this.jdField_b_of_type_Boolean = false;
    } while (paramBundle.getInt("apply_source", 2) != 1);
    this.c = true;
    a(paramInt);
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (paramComboFilterData != null)
    {
      paramComboFilterData = paramComboFilterData.a(this.jdField_a_of_type_Int);
      if (paramComboFilterData != null)
      {
        a(paramComboFilterData.c);
        int i = paramComboFilterData.c.indexOf(VideoFilterTools.a().b(this.jdField_a_of_type_Int));
        QLog.i("VideoFilterViewPager", 2, "update viewpagerIndex = " + i + "getCurrentItem()" + getCurrentItem());
        if ((i != -1) && (i != getCurrentItem()))
        {
          QLog.i("VideoFilterViewPager", 2, "initialViewPagerPosition ");
          this.c = true;
          a(i);
          this.c = false;
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    int i = 1;
    if (MediaCodecDPC.l())
    {
      setVisibility(8);
      setEnabled(false);
      int j = getCurrentItem();
      QLog.i("VideoFilterViewPager", 2, "bNeedSetnewPosizton getActualCount " + this.jdField_a_of_type_Aopu.a());
      if ((j != 0) && (j % this.jdField_a_of_type_Aopu.a() != 0)) {
        break label151;
      }
      QLog.i("VideoFilterViewPager", 2, "bNeedSetnewPosizton ");
    }
    for (;;)
    {
      this.jdField_a_of_type_Aopu.a(paramList);
      QLog.i("VideoFilterViewPager", 2, "update getCurrentItem = " + getCurrentItem());
      if (i != 0) {
        setCurrentItem(this.jdField_a_of_type_Aopu.a() * 50, false);
      }
      return;
      setVisibility(0);
      setEnabled(true);
      break;
      label151:
      i = 0;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ((CaptureComboManager)QIMManager.a(5)).a(this);
  }
  
  protected void onDetachedFromWindow()
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
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
  }
  
  public void setReadyToApply(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setScrollCallBack(VideoFilterViewPager.ScrollCallBack paramScrollCallBack)
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$ScrollCallBack = paramScrollCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */