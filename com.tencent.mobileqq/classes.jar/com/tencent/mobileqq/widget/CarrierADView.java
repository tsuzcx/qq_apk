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
  private IFlingSwitch a;
  private MotionEvent b;
  private MqqHandler c;
  
  public CarrierADView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CarrierADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.x.getChildCount() == 0)
    {
      this.x.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.y = new WorkSpaceView(getContext());
      setCircle(this.E);
      this.y.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.y.setId(100000);
      localRelativeLayout.addView(this.y, localLayoutParams);
      this.x.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    else
    {
      this.y = ((WorkSpaceView)((ViewGroup)this.x.getChildAt(0)).getChildAt(0));
    }
    try
    {
      this.y.addView(paramView, this.y.getChildCount());
      return;
    }
    catch (Exception paramView) {}
  }
  
  public int getCurrentScreen()
  {
    if (this.y != null) {
      return this.y.getCurrentScreen();
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      this.c.removeMessages(0);
      return false;
    }
    if (this.y == null) {
      return false;
    }
    if ((this.y.getChildCount() > 1) && (this.y.getWidth() > 0)) {
      this.y.a(this.y.getCurrentScreen() + 1);
    }
    this.c.sendEmptyMessageDelayed(0, 3400);
    return false;
  }
  
  public void j()
  {
    MqqHandler localMqqHandler = this.c;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(0);
      this.c.sendEmptyMessageDelayed(0, 3000L);
    }
  }
  
  public void k()
  {
    MqqHandler localMqqHandler = this.c;
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      int i = paramMotionEvent.getAction();
      MotionEvent localMotionEvent;
      if (i == 0)
      {
        this.a.enableFlingRight(false);
        k();
        localMotionEvent = this.b;
        if (localMotionEvent != null) {
          localMotionEvent.recycle();
        }
        this.b = MotionEvent.obtain(paramMotionEvent);
        return false;
      }
      if (i == 2)
      {
        localMotionEvent = this.b;
        if (localMotionEvent != null)
        {
          float f1 = localMotionEvent.getX();
          float f2 = paramMotionEvent.getX();
          if (Math.abs((this.b.getY() - paramMotionEvent.getY()) / (f1 - f2)) < 0.5F) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
        }
        this.b = MotionEvent.obtain(paramMotionEvent);
        return false;
      }
      if ((i == 1) || (i == 3))
      {
        this.a.enableFlingRight(true);
        j();
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return false;
  }
  
  public void setCarrierData(List<AdData> paramList, int paramInt, CarrierHelper paramCarrierHelper)
  {
    if (this.c == null) {
      this.c = new CustomHandler(Looper.getMainLooper(), this);
    }
    i();
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
          View localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131627527, null);
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
      j();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CarrierADView", 2, "carrier List is null or empty");
    }
    setVisibility(8);
  }
  
  public void setFlingSwitch(IFlingSwitch paramIFlingSwitch)
  {
    this.a = paramIFlingSwitch;
  }
  
  public void setVisibility(int paramInt)
  {
    if ((paramInt != 8) && (paramInt != 4)) {
      j();
    } else {
      k();
    }
    if (this.y != null) {
      this.y.setVisibility(paramInt);
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CarrierADView
 * JD-Core Version:    0.7.0.1
 */