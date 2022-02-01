package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.IFlingSwitch;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class CarrierADView
  extends ADView
  implements Handler.Callback
{
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private IFlingSwitch jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public CarrierADView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CarrierADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a();
    }
    return 0;
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.b.getChildCount() == 0)
    {
      this.b.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.f);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      this.b.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)this.b.getChildAt(0)).getChildAt(0));
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount());
      return;
    }
    catch (Exception paramView) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView == null) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount() > 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getWidth() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a() + 1);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 3400);
    return false;
  }
  
  public void i()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 3000L);
    }
  }
  
  public void j()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch != null)
    {
      int i = paramMotionEvent.getAction();
      MotionEvent localMotionEvent;
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch.enableFlingRight(false);
        j();
        localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
        if (localMotionEvent != null) {
          localMotionEvent.recycle();
        }
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        return false;
      }
      if (i == 2)
      {
        localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
        if (localMotionEvent != null)
        {
          float f1 = localMotionEvent.getX();
          float f2 = paramMotionEvent.getX();
          if (Math.abs((this.jdField_a_of_type_AndroidViewMotionEvent.getY() - paramMotionEvent.getY()) / (f1 - f2)) < 0.5F) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
        }
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        return false;
      }
      if ((i == 1) || (i == 3))
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch.enableFlingRight(true);
        i();
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return false;
  }
  
  public void setCarrierData(List<AdData> paramList, int paramInt, CarrierHelper paramCarrierHelper)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
    }
    h();
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i;
      for (;;)
      {
        i = 0;
        if (paramInt <= 0) {
          break;
        }
        paramList.add(paramList.get(0));
        paramList.remove(0);
        paramInt -= 1;
      }
      paramInt = i;
      if (getVisibility() != 0)
      {
        setVisibility(0);
        paramInt = i;
      }
      while (paramInt < paramList.size())
      {
        try
        {
          View localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131561175, null);
          paramCarrierHelper.a(localView, (AdData)paramList.get(paramInt));
          b(localView, paramInt);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CarrierADView", 2, localException.toString());
          }
        }
        paramInt += 1;
      }
      i();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CarrierADView", 2, "carrier List is null or empty");
    }
    setVisibility(8);
  }
  
  public void setFlingSwitch(IFlingSwitch paramIFlingSwitch)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch = paramIFlingSwitch;
  }
  
  public void setVisibility(int paramInt)
  {
    if ((paramInt != 8) && (paramInt != 4)) {
      i();
    } else {
      j();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setVisibility(paramInt);
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CarrierADView
 * JD-Core Version:    0.7.0.1
 */