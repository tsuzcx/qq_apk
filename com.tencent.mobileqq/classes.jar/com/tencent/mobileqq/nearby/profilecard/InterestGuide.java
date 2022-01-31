package com.tencent.mobileqq.nearby.profilecard;

import afgu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
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
import com.tencent.mobileqq.widget.ScrollStateDetector.OnScrollListener;
import java.lang.ref.WeakReference;

public class InterestGuide
  implements Handler.Callback, View.OnClickListener, ScrollStateDetector.OnScrollListener
{
  public static Boolean a;
  public static WeakReference a;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  public String a;
  int[] jdField_a_of_type_ArrayOfInt;
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  int b;
  int c;
  int d;
  int e;
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      if (this.e != 1) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
      }
    }
    for (;;)
    {
      this.d = paramInt2;
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a("InterestGuide", "MSG_CHECK_INTEREST", new Object[] { Integer.valueOf(paramMessage.what), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) });
    }
    Context localContext;
    int k;
    Object localObject;
    int i;
    int m;
    int j;
    if ((paramMessage.what == 0) && (this.d == 0) && (this.e != 1) && (this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() > 0))
    {
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
      {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      }
      localContext = this.jdField_a_of_type_AndroidViewView.getContext();
      if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_AndroidGraphicsRectF == null))
      {
        this.jdField_a_of_type_ArrayOfInt = new int[2];
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        paramMessage = localContext.getResources().getDisplayMetrics();
        this.b = paramMessage.widthPixels;
        this.c = paramMessage.heightPixels;
        this.jdField_a_of_type_Float = paramMessage.density;
        this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * 120.0F));
      }
      k = 0;
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131370707);
      if (localObject != null)
      {
        ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        paramMessage = ((View)localObject).findViewById(2131363398);
        localObject = ((View)localObject).findViewById(2131370708);
        i = this.jdField_a_of_type_ArrayOfInt[1];
        k = paramMessage.getMeasuredHeight() + i + ((View)localObject).getMeasuredHeight();
      }
      paramMessage = new int[3];
      Message tmp268_267 = paramMessage;
      tmp268_267[0] = 2131363065;
      Message tmp273_268 = tmp268_267;
      tmp273_268[1] = 2131370721;
      Message tmp278_273 = tmp273_268;
      tmp278_273[2] = 2131370722;
      tmp278_273;
      i = this.c;
      m = 0;
      if (m < paramMessage.length)
      {
        localObject = this.jdField_a_of_type_AndroidViewView.findViewById(paramMessage[m]);
        int n;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          ((View)localObject).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
          j = i;
          if (this.jdField_a_of_type_ArrayOfInt[1] > k)
          {
            j = i;
            if (this.jdField_a_of_type_ArrayOfInt[1] < i) {
              j = this.jdField_a_of_type_ArrayOfInt[1];
            }
          }
          n = j;
          if (NearbyUtils.a())
          {
            NearbyUtils.a("InterestGuide", "checkShowGuide_bottom", new Object[] { Integer.valueOf(m), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(((View)localObject).getMeasuredHeight()) });
            n = j;
          }
        }
        for (;;)
        {
          m += 1;
          i = n;
          break;
          n = i;
          if (NearbyUtils.a())
          {
            NearbyUtils.a("InterestGuide", "checkShowGuide_bottom", new Object[] { Integer.valueOf(m), localObject });
            n = i;
          }
        }
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, k, this.b, i);
      if (NearbyUtils.a()) {
        NearbyUtils.a("InterestGuide", "checkShowGuide", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(k), Integer.valueOf(i) });
      }
      localObject = null;
      i = 0;
      paramMessage = (Message)localObject;
      if (0 == 0)
      {
        paramMessage = (Message)localObject;
        if (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
        {
          if ((this.jdField_a_of_type_ArrayOfAndroidViewView[i] == null) || (this.jdField_a_of_type_ArrayOfAndroidViewView[i].getVisibility() != 0)) {}
          do
          {
            i += 1;
            break;
            this.jdField_a_of_type_ArrayOfAndroidViewView[i].getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
            j = this.jdField_a_of_type_ArrayOfAndroidViewView[i].getMeasuredWidth();
            k = this.jdField_a_of_type_ArrayOfAndroidViewView[i].getMeasuredHeight();
          } while (!this.jdField_a_of_type_AndroidGraphicsRectF.contains(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], j + this.jdField_a_of_type_ArrayOfInt[0], k + this.jdField_a_of_type_ArrayOfInt[1]));
          paramMessage = this.jdField_a_of_type_ArrayOfAndroidViewView[i];
        }
      }
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
          if (m <= this.jdField_a_of_type_Int) {
            break label1003;
          }
          paramMessage = new View(localContext);
          paramMessage.setBackgroundColor(i);
          ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.b, j));
        }
        ((LinearLayout)localObject).addView(new View(localContext), new LinearLayout.LayoutParams(this.b, k));
        if (m > 0)
        {
          if (m <= this.jdField_a_of_type_Int) {
            break label1031;
          }
          paramMessage = LayoutInflater.from(localContext).inflate(2130970449, null);
          ((Button)paramMessage.findViewById(2131365815)).setOnClickListener(this);
        }
      }
    }
    for (;;)
    {
      paramMessage.setBackgroundColor(i);
      ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.b, m));
      if (NearbyUtils.a()) {
        NearbyUtils.a("InterestGuide", "checkShowGuide", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localContext);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(this.b);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(this.c);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView((View)localObject);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView, 51, 0, 0);
      return true;
      label1003:
      paramMessage = LayoutInflater.from(localContext).inflate(2130970450, null);
      ((Button)paramMessage.findViewById(2131365815)).setOnClickListener(this);
      break;
      label1031:
      paramMessage = new View(localContext);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      paramView = (BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370696);
      if (paramView != null) {
        paramView.setScrollListener(null);
      }
      jdField_a_of_type_JavaLangRefWeakReference = null;
      jdField_a_of_type_JavaLangBoolean = Boolean.FALSE;
      ThreadManager.post(new afgu(this), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide
 * JD-Core Version:    0.7.0.1
 */