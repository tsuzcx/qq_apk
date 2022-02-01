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
  public static String b;
  public static WeakReference<InterestGuide> c;
  String d;
  PopupWindow e;
  Handler f;
  View g;
  View[] h;
  int[] i;
  RectF j;
  float k;
  int l;
  int m;
  int n;
  int o = 0;
  int p = 3;
  
  public InterestGuide(String paramString, View paramView, int paramInt)
  {
    this.d = paramString;
    this.p = paramInt;
    paramString = (BounceScrollView)paramView.findViewById(2131429717);
    if (paramString != null) {
      paramString.setScrollListener(new ScrollStateDetector(this, paramString.getContext()));
    }
    int i1 = NearbyProfileEditPanel.e.length;
    this.g = paramView;
    this.h = new View[i1];
    paramInt = 0;
    while (paramInt < i1)
    {
      this.h[paramInt] = paramView.findViewById(NearbyProfileEditPanel.e[paramInt]);
      paramInt += 1;
    }
    this.f = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.f.sendEmptyMessageDelayed(0, 500L);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.f.removeMessages(0);
      if (this.p != 1) {
        this.f.sendEmptyMessageDelayed(0, 100L);
      }
    }
    else
    {
      this.f.removeMessages(0);
    }
    this.o = paramInt2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a("InterestGuide", "MSG_CHECK_INTEREST", new Object[] { Integer.valueOf(paramMessage.what), Integer.valueOf(this.o), Integer.valueOf(this.p), Integer.valueOf(this.g.getMeasuredHeight()) });
    }
    if ((paramMessage.what == 0) && (this.o == 0) && (this.p != 1) && (this.g.getMeasuredHeight() > 0))
    {
      paramMessage = this.e;
      if (paramMessage != null)
      {
        paramMessage.dismiss();
        this.e = null;
      }
      Context localContext = this.g.getContext();
      if ((this.i == null) || (this.j == null))
      {
        this.i = new int[2];
        this.j = new RectF();
        paramMessage = localContext.getResources().getDisplayMetrics();
        this.m = paramMessage.widthPixels;
        this.n = paramMessage.heightPixels;
        this.k = paramMessage.density;
        this.l = ((int)(this.k * 120.0F));
      }
      Object localObject = this.g.findViewById(2131445041);
      int i2;
      int i3;
      if (localObject != null)
      {
        ((View)localObject).getLocationInWindow(this.i);
        paramMessage = ((View)localObject).findViewById(2131447582);
        localObject = ((View)localObject).findViewById(2131436959);
        i1 = this.i[1];
        i2 = paramMessage.getMeasuredHeight();
        i3 = ((View)localObject).getMeasuredHeight() + (i1 + i2);
      }
      else
      {
        i3 = 0;
      }
      paramMessage = new int[3];
      Message tmp272_271 = paramMessage;
      tmp272_271[0] = 2131429654;
      Message tmp277_272 = tmp272_271;
      tmp277_272[1] = 2131439219;
      Message tmp282_277 = tmp277_272;
      tmp282_277[2] = 2131435155;
      tmp282_277;
      int i1 = this.n;
      int i4 = 0;
      while (i4 < paramMessage.length)
      {
        localObject = this.g.findViewById(paramMessage[i4]);
        int i5;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          ((View)localObject).getLocationInWindow(this.i);
          int[] arrayOfInt = this.i;
          i2 = i1;
          if (arrayOfInt[1] > i3)
          {
            i2 = i1;
            if (arrayOfInt[1] < i1) {
              i2 = arrayOfInt[1];
            }
          }
          i5 = i2;
          if (NearbyUtils.a())
          {
            NearbyUtils.a("InterestGuide", "checkShowGuide_bottom", new Object[] { Integer.valueOf(i4), Integer.valueOf(this.i[0]), Integer.valueOf(this.i[1]), Integer.valueOf(((View)localObject).getMeasuredHeight()) });
            i5 = i2;
          }
        }
        else
        {
          i5 = i1;
          if (NearbyUtils.a())
          {
            NearbyUtils.a("InterestGuide", "checkShowGuide_bottom", new Object[] { Integer.valueOf(i4), localObject });
            i5 = i1;
          }
        }
        i4 += 1;
        i1 = i5;
      }
      this.j.set(0.0F, i3, this.m, i1);
      if (NearbyUtils.a()) {
        NearbyUtils.a("InterestGuide", "checkShowGuide", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.l), Integer.valueOf(i3), Integer.valueOf(i1) });
      }
      i1 = 0;
      for (;;)
      {
        paramMessage = this.h;
        if (i1 >= paramMessage.length) {
          break;
        }
        if ((paramMessage[i1] != null) && (paramMessage[i1].getVisibility() == 0))
        {
          this.h[i1].getLocationInWindow(this.i);
          i2 = this.h[i1].getMeasuredWidth();
          i3 = this.h[i1].getMeasuredHeight();
          paramMessage = this.j;
          localObject = this.i;
          if (paramMessage.contains(localObject[0], localObject[1], localObject[0] + i2, localObject[1] + i3))
          {
            paramMessage = this.h[i1];
            break label694;
          }
        }
        i1 += 1;
      }
      paramMessage = null;
      label694:
      if (paramMessage != null)
      {
        localObject = new LinearLayout(localContext);
        ((LinearLayout)localObject).setOrientation(1);
        i1 = Color.parseColor("#BF000000");
        i2 = this.i[1];
        i3 = paramMessage.getMeasuredHeight();
        i4 = this.n - i2 - i3;
        if (i2 > 0)
        {
          if (i4 > this.l)
          {
            paramMessage = new View(localContext);
          }
          else
          {
            paramMessage = LayoutInflater.from(localContext).inflate(2131627541, null);
            ((Button)paramMessage.findViewById(2131429754)).setOnClickListener(this);
          }
          paramMessage.setBackgroundColor(i1);
          ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.m, i2));
        }
        ((LinearLayout)localObject).addView(new View(localContext), new LinearLayout.LayoutParams(this.m, i3));
        if (i4 > 0)
        {
          if (i4 > this.l)
          {
            paramMessage = LayoutInflater.from(localContext).inflate(2131627540, null);
            ((Button)paramMessage.findViewById(2131429754)).setOnClickListener(this);
          }
          else
          {
            paramMessage = new View(localContext);
          }
          paramMessage.setBackgroundColor(i1);
          ((LinearLayout)localObject).addView(paramMessage, new LinearLayout.LayoutParams(this.m, i4));
        }
        if (NearbyUtils.a()) {
          NearbyUtils.a("InterestGuide", "checkShowGuide", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) });
        }
        this.e = new PopupWindow(localContext);
        this.e.setWidth(this.m);
        this.e.setHeight(this.n);
        this.e.setContentView((View)localObject);
        this.e.setBackgroundDrawable(null);
        this.e.setOutsideTouchable(false);
        this.e.showAtLocation(this.g, 51, 0, 0);
      }
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.e;
    if (paramView != null)
    {
      paramView.dismiss();
      paramView = (BounceScrollView)this.g.findViewById(2131429717);
      if (paramView != null) {
        paramView.setScrollListener(null);
      }
      c = null;
      a = Boolean.FALSE;
      ThreadManager.post(new InterestGuide.2(this), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide
 * JD-Core Version:    0.7.0.1
 */