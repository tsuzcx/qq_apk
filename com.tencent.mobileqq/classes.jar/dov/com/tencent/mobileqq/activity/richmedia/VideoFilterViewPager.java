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
import azfz;
import blen;
import bler;
import blmf;
import blnl;
import blno;
import blob;
import bloe;
import blol;
import blwi;
import bmld;
import bncp;
import bncq;
import bncr;
import bncu;
import bncv;
import bncw;
import bncx;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.List;
import wta;

public class VideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements blno
{
  public int a;
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private blwi jdField_a_of_type_Blwi;
  private bncu jdField_a_of_type_Bncu;
  private bncv jdField_a_of_type_Bncv;
  private bncw jdField_a_of_type_Bncw;
  private bncx jdField_a_of_type_Bncx;
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
    if (azfz.l()) {}
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
      localQIMFilterCategoryItem = this.jdField_a_of_type_Bncx.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
    return;
    Object localObject2;
    Object localObject1;
    if (bler.a().b())
    {
      localObject2 = blen.a();
      if (paramInt == 0)
      {
        localObject1 = "none";
        label137:
        ((blen)localObject2).i((String)localObject1);
        localObject1 = (TextView)paramView.findViewById(2131364507);
        localObject2 = (TextView)paramView.findViewById(2131364506);
        Object localObject3 = (blnl)blmf.a(5);
        if (!this.e)
        {
          Object localObject4 = new Bundle();
          ((Bundle)localObject4).putInt("apply_source", 2);
          ((Bundle)localObject4).putInt("capture_scene", this.jdField_a_of_type_Int);
          ((blnl)localObject3).a(localQIMFilterCategoryItem, (Activity)getContext(), (Bundle)localObject4);
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
              wta.a("clk_swipe", paramInt, 0, new String[] { "", localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString });
            }
          }
        }
        label320:
        localObject3 = ((blnl)localObject3).a(localQIMFilterCategoryItem);
        paramInt = ((bloe)localObject3).d();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "onPageSelect state = " + paramInt + " " + ((bloe)localObject3).toString());
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
      if (this.jdField_a_of_type_Blwi == null) {
        break;
      }
      this.jdField_a_of_type_Blwi.b(true);
      return;
      localObject1 = "" + localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
      break label137;
      localObject2 = blen.a();
      if (paramInt == 0) {}
      for (localObject1 = "none";; localObject1 = "" + localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)
      {
        ((blen)localObject2).e((String)localObject1);
        break;
      }
      label550:
      wta.b("filter_swipe", paramInt, 0, new String[] { "", localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString });
      break label320;
      label577:
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
    }
  }
  
  private void a(View paramView, QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131364507);
    TextView localTextView2 = (TextView)paramView.findViewById(2131364506);
    ViewParent localViewParent = getParent();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localViewParent != null)
    {
      localObject1 = localObject2;
      if ((localViewParent instanceof RelativeLayout)) {
        localObject1 = (RelativeLayout)((RelativeLayout)localViewParent).findViewById(2131369774);
      }
    }
    boolean bool = ((blnl)blmf.a(5)).d();
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
    View localView = this.jdField_a_of_type_Bncx.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_Bncx.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, ((blnl)blmf.a(5)).a(localQIMFilterCategoryItem).jdField_a_of_type_Int);
      }
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_Bncx.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_Bncx.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, 4);
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bncx = new bncx(this);
    this.jdField_a_of_type_Bncw = new bncw(this);
    setAdapter(this.jdField_a_of_type_Bncx);
    setOnPageChangeListener(this.jdField_a_of_type_Bncw);
  }
  
  public void a()
  {
    String str = AEFilterProviderView.a();
    this.jdField_a_of_type_Bncx.a(str);
  }
  
  public void a(int paramInt)
  {
    setCurrentItem(this.jdField_a_of_type_Bncx.a() * 50 + paramInt);
  }
  
  public void a(blob paramblob) {}
  
  public void a(blob paramblob, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
      paramBundle = ((blnl)blmf.a(5)).a(paramblob, this.jdField_a_of_type_Bncx.a);
      ArrayList localArrayList = this.jdField_a_of_type_Bncx.a;
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
        QLog.i("QCombo", 2, "vp onComboApply combo " + paramblob.jdField_a_of_type_JavaLangObject + " filter " + paramBundle + " index " + paramInt);
        return;
      }
    }
  }
  
  public void a(bloe parambloe, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
        } while (!(parambloe.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem));
        bler.a().e(parambloe.b());
        parambloe = (QIMFilterCategoryItem)parambloe.jdField_a_of_type_JavaLangObject;
        localArrayList = this.jdField_a_of_type_Bncx.a;
      } while (localArrayList == null);
      paramInt = localArrayList.indexOf(parambloe);
    } while (paramInt < 0);
    this.d = false;
    int k;
    if ((paramBundle.getInt("apply_source", 2) == 1) || (paramBundle.getInt("apply_source", 2) == blnl.jdField_a_of_type_Int))
    {
      this.e = true;
      k = this.jdField_a_of_type_Bncx.a() * 50 + paramInt;
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
      wta.a((Activity)getContext(), "filter_element", String.valueOf(parambloe.jdField_a_of_type_Int), parambloe.jdField_a_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      bmld.a().a();
      return;
      c(k);
      continue;
      if (paramBoolean)
      {
        a(paramInt);
        continue;
        if ((paramBundle.getInt("apply_source", 2) == 2) && (paramInt == this.jdField_a_of_type_Bncx.a(this.jdField_b_of_type_Int)))
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
  
  public void a(blol paramblol, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bncq parambncq)
  {
    if (parambncq != null)
    {
      parambncq = parambncq.a(this.jdField_a_of_type_Int);
      if (parambncq != null)
      {
        a(parambncq.c);
        int k = parambncq.c.indexOf(bncp.a().c(this.jdField_a_of_type_Int));
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
    if (azfz.l())
    {
      setVisibility(8);
      setEnabled(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bncx.a(paramList);
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
    QLog.i("VideoFilterViewPager", 2, "needReselectMiddle getActualCount " + this.jdField_a_of_type_Bncx.a());
    if ((k == 0) || (k % this.jdField_a_of_type_Bncx.a() == 0)) {
      QLog.i("VideoFilterViewPager", 2, "needReselectMiddle ");
    }
    for (k = 1;; k = 0)
    {
      if (k != 0) {
        setCurrentItem(this.jdField_a_of_type_Bncx.a() * 50, false);
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
    ((blnl)blmf.a(5)).a(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ((blnl)blmf.a(5)).b(this);
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
  
  public void setProviderViewListener(blwi paramblwi)
  {
    this.jdField_a_of_type_Blwi = paramblwi;
  }
  
  public void setReadyToApply(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setScrollCallBack(bncu parambncu)
  {
    this.jdField_a_of_type_Bncu = parambncu;
  }
  
  public void setSecleteCallBack(bncv parambncv)
  {
    this.jdField_a_of_type_Bncv = parambncv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */