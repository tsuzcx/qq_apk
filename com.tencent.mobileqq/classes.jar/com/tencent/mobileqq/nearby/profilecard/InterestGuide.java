package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ScrollStateDetector;
import com.tencent.mobileqq.widget.ScrollStateDetector.OnScrollListener;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class InterestGuide
  implements Handler.Callback, View.OnClickListener, ScrollStateDetector.OnScrollListener
{
  public static Boolean a;
  public static String a;
  public static WeakReference<InterestGuide> a;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  int[] jdField_a_of_type_ArrayOfInt;
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int c;
  int d = 0;
  int e = 3;
  
  public InterestGuide(String paramString, View paramView, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.e = paramInt;
    paramString = (BounceScrollView)paramView.findViewById(2131363784);
    if (paramString != null) {
      paramString.setScrollListener(new ScrollStateDetector(this, paramString.getContext()));
    }
    int i = NearbyProfileEditPanel.jdField_a_of_type_ArrayOfInt.length;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[i];
    paramInt = 0;
    while (paramInt < i)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = paramView.findViewById(NearbyProfileEditPanel.jdField_a_of_type_ArrayOfInt[paramInt]);
      paramInt += 1;
    }
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 500L);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      if (this.e != 1) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
    this.d = paramInt2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a("InterestGuide", "MSG_CHECK_INTEREST", new Object[] { Integer.valueOf(paramMessage.what), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) });
    }
    if ((paramMessage.what == 0) && (this.d == 0) && (this.e != 1) && (this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() > 0))
    {
      paramMessage = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      if (paramMessage != null)
      {
        paramMessage.dismiss();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      }
      Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
      if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_AndroidGraphicsRectF == null))
      {
        this.jdField_a_of_type_ArrayOfInt = new int[2];
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        paramMessage = localContext.getResources().getDisplayMetrics();
        this.jdField_b_of_type_Int = paramMessage.widthPixels;
        this.c = paramMessage.heightPixels;
        this.jdField_a_of_type_Float = paramMessage.density;
        this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * 120.0F));
      }
      Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131376750);
      int j;
      int k;
      if (localObject != null)
      {
        ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        paramMessage = ((View)localObject).findViewById(2131378881);
        localObject = ((View)localObject).findViewById(2131369824);
        i = this.jdField_a_of_type_ArrayOfInt[1];
        j = paramMessage.getMeasuredHeight();
        k = ((View)localObject).getMeasuredHeight() + (i + j);
      }
      else
      {
        k = 0;
      }
      paramMessage = new int[3];
      Message tmp272_271 = paramMessage;
      tmp272_271[0] = 2131363731;
      Message tmp277_272 = tmp272_271;
      tmp277_272[1] = 2131371784;
      Message tmp282_277 = tmp277_272;
      tmp282_277[2] = 2131368282;
      tmp282_277;
      int i = this.c;
      int m = 0;
      while (m < paramMessage.length)
      {
        localObject = this.jdField_a_of_type_AndroidViewView.findViewById(paramMessage[m]);
        int n;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
          int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
          j = i;
          if (arrayOfInt[1] > k)
          {
            j = i;
            if (arrayOfInt[1] < i) {
              j = arrayOfInt[1];
            }
          }
          n = j;
          if (NearbyUtils.a())
          {
            NearbyUtils.a("InterestGuide", "checkShowGuide_bottom", new Object[] { Integer.valueOf(m), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(((View)localObject).getMeasuredHeight()) });
            n = j;
          }
        }
        else
        {
          n = i;
          if (NearbyUtils.a())
          {
            NearbyUtils.a("InterestGuide", "checkShowGuide_bottom", new Object[] { Integer.valueOf(m), localObject });
            n = i;
          }
        }
        m += 1;
        i = n;
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, k, this.jdField_b_of_type_Int, i);
      if (NearbyUtils.a()) {
        NearbyUtils.a("InterestGuide", "checkShowGuide", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(k), Integer.valueOf(i) });
      }
      i = 0;
      for (;;)
      {
        paramMessage = this.jdField_a_of_type_ArrayOfAndroidViewView;
        if (i >= paramMessage.length) {
          break;
        }
        if ((paramMessage[i] != null) && (paramMessage[i].getVisibility() == 0))
        {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i].getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
          j = this.jdField_a_of_type_ArrayOfAndroidViewView[i].getMeasuredWidth();
          k = this.jdField_a_of_type_ArrayOfAndroidViewView[i].getMeasuredHeight();
          paramMessage = this.jdField_a_of_type_AndroidGraphicsRectF;
          localObject = this.jdField_a_of_type_ArrayOfInt;
          if (paramMessage.contains(localObject[0], localObject[1], localObject[0] + j, localObject[1] + k))
          {
            paramMessage = this.jdField_a_of_type_ArrayOfAndroidViewView[i];
            break label694;
          }
        }
        i += 1;
      }
      paramMessage = null;
      label694:
      if (paramMessage != null)
      {
        localObject = new LinearLayout(localContext);
        ((LinearLayout)localObject).setOrientation(1);
        i = Color.parseColor("#BF000000");
        j = this.jdField_a_of_type_ArrayOfInt[1];
        k = paramMessage.getMeasuredHeight();
        m = this.c - j - k;
        if (j > 0)
        {
          if (m > this.jdField_a_of_type_Int)
          {
            paramMessage = new View(localContext);
          }
          else
          {
            paramMessage = LayoutInflater.from(localContext).inflate(2131561189, null);
            ((Button)paramMessage.findViewById(2131363819)).setOnClickListener(this);
          }
          paramMessage.setBackgroundColor(i);
          ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, j));
        }
        ((LinearLayout)localObject).addView(new View(localContext), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, k));
        if (m > 0)
        {
          if (m > this.jdField_a_of_type_Int)
          {
            paramMessage = LayoutInflater.from(localContext).inflate(2131561188, null);
            ((Button)paramMessage.findViewById(2131363819)).setOnClickListener(this);
          }
          else
          {
            paramMessage = new View(localContext);
          }
          paramMessage.setBackgroundColor(i);
          ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, m));
        }
        if (NearbyUtils.a()) {
          NearbyUtils.a("InterestGuide", "checkShowGuide", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
        }
        this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localContext);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(this.c);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView((View)localObject);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView, 51, 0, 0);
      }
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (paramView != null)
    {
      paramView.dismiss();
      paramView = (BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363784);
      if (paramView != null) {
        paramView.setScrollListener(null);
      }
      jdField_a_of_type_JavaLangRefWeakReference = null;
      jdField_a_of_type_JavaLangBoolean = Boolean.FALSE;
      ThreadManager.post(new InterestGuide.2(this), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide
 * JD-Core Version:    0.7.0.1
 */