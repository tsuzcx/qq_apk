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
import axkt;
import bizt;
import bizx;
import bjav;
import bjcb;
import bjce;
import bjcq;
import bjct;
import bjda;
import bjky;
import bjzt;
import bkrf;
import bkrg;
import bkrh;
import bkrk;
import bkrl;
import bkrm;
import bkrn;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.List;
import vei;

public class VideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements bjce
{
  public int a;
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private bjky jdField_a_of_type_Bjky;
  private bkrk jdField_a_of_type_Bkrk;
  private bkrl jdField_a_of_type_Bkrl;
  private bkrm jdField_a_of_type_Bkrm;
  private bkrn jdField_a_of_type_Bkrn;
  private int b;
  public boolean b;
  public boolean c = true;
  public boolean d;
  public boolean e;
  public boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i = true;
  private boolean j;
  
  public VideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    e();
  }
  
  public VideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    e();
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (axkt.l()) {}
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "onPageSelect position: " + paramInt + ", mCurPosition: " + this.jdField_b_of_type_Int + ", mFromOnlyChangeUi: " + this.e);
        }
      } while (paramInt == this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_b_of_type_Int = paramInt;
      paramView.setVisibility(0);
      localQIMFilterCategoryItem = this.jdField_a_of_type_Bkrn.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
    return;
    Object localObject2;
    Object localObject1;
    if (bizx.a().b())
    {
      localObject2 = bizt.a();
      if (paramInt == 0)
      {
        localObject1 = "none";
        label137:
        ((bizt)localObject2).h((String)localObject1);
        localObject1 = (TextView)paramView.findViewById(2131364435);
        localObject2 = (TextView)paramView.findViewById(2131364434);
        Object localObject3 = (bjcb)bjav.a(5);
        if (!this.e)
        {
          Object localObject4 = new Bundle();
          ((Bundle)localObject4).putInt("apply_source", 2);
          ((Bundle)localObject4).putInt("capture_scene", this.jdField_a_of_type_Int);
          ((bjcb)localObject3).a(localQIMFilterCategoryItem, (Activity)getContext(), (Bundle)localObject4);
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
                break label550;
              }
              vei.a("clk_swipe", paramInt, 0, new String[] { "", localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString });
            }
          }
        }
        label320:
        localObject3 = ((bjcb)localObject3).a(localQIMFilterCategoryItem);
        paramInt = ((bjct)localObject3).d();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "onPageSelect state = " + paramInt + " " + ((bjct)localObject3).toString());
        }
        if ((!localQIMFilterCategoryItem.c()) && (!localQIMFilterCategoryItem.jdField_a_of_type_Boolean) && (!this.d)) {
          break label577;
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
      if (this.jdField_a_of_type_Bjky == null) {
        break;
      }
      this.jdField_a_of_type_Bjky.b(true);
      return;
      localObject1 = "" + localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
      break label137;
      localObject2 = bizt.a();
      if (paramInt == 0) {}
      for (localObject1 = "none";; localObject1 = "" + localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)
      {
        ((bizt)localObject2).d((String)localObject1);
        break;
      }
      label550:
      vei.b("filter_swipe", paramInt, 0, new String[] { "", localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString });
      break label320;
      label577:
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
    }
  }
  
  private void a(View paramView, QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131364435);
    TextView localTextView2 = (TextView)paramView.findViewById(2131364434);
    ViewParent localViewParent = getParent();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localViewParent != null)
    {
      localObject1 = localObject2;
      if ((localViewParent instanceof RelativeLayout)) {
        localObject1 = (RelativeLayout)((RelativeLayout)localViewParent).findViewById(2131369512);
      }
    }
    boolean bool = ((bjcb)bjav.a(5)).d();
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
    View localView = this.jdField_a_of_type_Bkrn.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_Bkrn.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, ((bjcb)bjav.a(5)).a(localQIMFilterCategoryItem).jdField_a_of_type_Int);
      }
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_Bkrn.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_Bkrn.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, 4);
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bkrn = new bkrn(this);
    this.jdField_a_of_type_Bkrm = new bkrm(this);
    setAdapter(this.jdField_a_of_type_Bkrn);
    setOnPageChangeListener(this.jdField_a_of_type_Bkrm);
  }
  
  public void a()
  {
    String str = AEFilterProviderView.a();
    this.jdField_a_of_type_Bkrn.a(str);
  }
  
  public void a(int paramInt)
  {
    setCurrentItem(this.jdField_a_of_type_Bkrn.a() * 50 + paramInt);
  }
  
  public void a(bjcq parambjcq) {}
  
  public void a(bjcq parambjcq, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
      paramBundle = ((bjcb)bjav.a(5)).a(parambjcq, this.jdField_a_of_type_Bkrn.a);
      ArrayList localArrayList = this.jdField_a_of_type_Bkrn.a;
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
        QLog.i("QCombo", 2, "vp onComboApply combo " + parambjcq.jdField_a_of_type_JavaLangObject + " filter " + paramBundle + " index " + paramInt);
        return;
      }
    }
  }
  
  public void a(bjct parambjct, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
        } while (!(parambjct.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem));
        bizx.a().e(parambjct.b());
        parambjct = (QIMFilterCategoryItem)parambjct.jdField_a_of_type_JavaLangObject;
        localArrayList = this.jdField_a_of_type_Bkrn.a;
      } while (localArrayList == null);
      paramInt = localArrayList.indexOf(parambjct);
    } while (paramInt < 0);
    this.d = false;
    int k;
    if ((paramBundle.getInt("apply_source", 2) == 1) || (paramBundle.getInt("apply_source", 2) == bjcb.jdField_a_of_type_Int))
    {
      this.e = true;
      k = this.jdField_a_of_type_Bkrn.a() * 50 + paramInt;
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
      vei.a((Activity)getContext(), "filter_element", String.valueOf(parambjct.jdField_a_of_type_Int), parambjct.jdField_a_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      bjzt.a().a();
      return;
      c(k);
      continue;
      if (paramBoolean)
      {
        a(paramInt);
        continue;
        if ((paramBundle.getInt("apply_source", 2) == 2) && (paramInt == this.jdField_a_of_type_Bkrn.a(this.jdField_b_of_type_Int)))
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
  
  public void a(bjda parambjda, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bkrg parambkrg)
  {
    if (parambkrg != null)
    {
      parambkrg = parambkrg.a(this.jdField_a_of_type_Int);
      if (parambkrg != null)
      {
        a(parambkrg.c);
        int k = parambkrg.c.indexOf(bkrf.a().c(this.jdField_a_of_type_Int));
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
    if (axkt.l())
    {
      setVisibility(8);
      setEnabled(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkrn.a(paramList);
      QLog.i("VideoFilterViewPager", 2, "update getCurrentItem = " + getCurrentItem());
      return;
      if (!(getContext() instanceof QzoneEditVideoActivity))
      {
        setVisibility(0);
        setEnabled(true);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
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
  
  public void b()
  {
    int k = getCurrentItem();
    QLog.i("VideoFilterViewPager", 2, "needReselectMiddle getActualCount " + this.jdField_a_of_type_Bkrn.a());
    if ((k == 0) || (k % this.jdField_a_of_type_Bkrn.a() == 0)) {
      QLog.i("VideoFilterViewPager", 2, "needReselectMiddle ");
    }
    for (k = 1;; k = 0)
    {
      if (k != 0) {
        setCurrentItem(this.jdField_a_of_type_Bkrn.a() * 50, false);
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
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ((bjcb)bjav.a(5)).a(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ((bjcb)bjav.a(5)).b(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
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
  
  public void setProviderViewListener(bjky parambjky)
  {
    this.jdField_a_of_type_Bjky = parambjky;
  }
  
  public void setReadyToApply(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setScrollCallBack(bkrk parambkrk)
  {
    this.jdField_a_of_type_Bkrk = parambkrk;
  }
  
  public void setSecleteCallBack(bkrl parambkrl)
  {
    this.jdField_a_of_type_Bkrl = parambkrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */