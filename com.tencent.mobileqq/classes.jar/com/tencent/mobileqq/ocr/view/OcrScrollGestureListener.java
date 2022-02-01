package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.OCRPerformUtil;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.animation.GestureFps;
import com.tencent.mobileqq.ocr.view.gesture.control.SimpleOnGestureListener;
import com.tencent.mobileqq.ocr.view.gesture.state.State;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class OcrScrollGestureListener
  extends SimpleOnGestureListener
  implements Handler.Callback
{
  private GestureFrameLayout a;
  private List<? extends OcrGestureBeanInfo> b;
  private List<? extends OcrGestureBeanInfo> c;
  private Matrix d = new Matrix();
  private final float[] e = new float[2];
  private Point f;
  private boolean g;
  private int h;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l;
  private Handler m;
  private GestureFps n;
  private int o = -1;
  private CommonMenuPopupView p;
  private View.OnClickListener q;
  private OcrScrollGestureListener.OcrPerformListener r;
  
  public OcrScrollGestureListener(GestureFrameLayout paramGestureFrameLayout, List<OcrImageTextBean> paramList, List<OcrImageSectBean> paramList1, View.OnClickListener paramOnClickListener, OcrScrollGestureListener.OcrPerformListener paramOcrPerformListener)
  {
    this.a = paramGestureFrameLayout;
    this.b = paramList;
    this.c = paramList1;
    this.q = paramOnClickListener;
    this.r = paramOcrPerformListener;
    paramList = paramGestureFrameLayout.getContext();
    paramGestureFrameLayout.getGestureProxy().c().a().invert(this.d);
    this.p = new CommonMenuPopupView();
    this.p.a(2131431492, paramList.getString(2131888241), 2130839057);
    this.p.a(2131433636, paramList.getString(2131889668), 2130839066);
    this.p.a(2131447830, paramList.getString(2131897095), 2130839066);
    this.p.a(this.q);
    this.m = new Handler(ThreadManager.getSubThreadLooper(), this);
    if (GestureFps.a()) {
      paramGestureFrameLayout = new GestureFps();
    } else {
      paramGestureFrameLayout = null;
    }
    this.n = paramGestureFrameLayout;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2)
  {
    return new Point(paramPoint2.x - paramPoint1.x, paramPoint2.y - paramPoint1.y);
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    boolean bool = this.g;
    int i2 = 0;
    int i1;
    if (!bool)
    {
      this.g = true;
      this.e[0] = paramMotionEvent1.getX();
      this.e[1] = paramMotionEvent1.getY();
      this.d.mapPoints(this.e);
      i3 = Math.round(this.e[0]);
      i4 = Math.round(this.e[1]);
      paramMotionEvent1 = b();
      i1 = 0;
      while (i1 < paramMotionEvent1.size())
      {
        if (a(new Point(i3, i4), (OcrGestureBeanInfo)paramMotionEvent1.get(i1))) {
          a((OcrGestureBeanInfo)paramMotionEvent1.get(i1), i1);
        }
        i1 += 1;
      }
    }
    this.e[0] = paramMotionEvent2.getX();
    this.e[1] = paramMotionEvent2.getY();
    this.d.mapPoints(this.e);
    int i3 = Math.round(this.e[0]);
    int i4 = Math.round(this.e[1]);
    if (this.f != null)
    {
      paramMotionEvent1 = b();
      i1 = i2;
      while (i1 < paramMotionEvent1.size())
      {
        if (a(i3, i4, this.f.x, this.f.y, (OcrGestureBeanInfo)paramMotionEvent1.get(i1))) {
          a((OcrGestureBeanInfo)paramMotionEvent1.get(i1), i1);
        }
        i1 += 1;
      }
    }
    this.f = new Point(i3, i4);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt8 -= paramInt6;
    paramInt3 -= paramInt1;
    paramInt7 -= paramInt5;
    paramInt4 -= paramInt2;
    paramInt2 -= paramInt6;
    paramInt1 -= paramInt5;
    float f2 = paramInt7 * paramInt2 - paramInt8 * paramInt1;
    float f1 = paramInt8 * paramInt3 - paramInt7 * paramInt4;
    f2 /= f1;
    f1 = (paramInt3 * paramInt2 - paramInt4 * paramInt1) / f1;
    return (f2 >= 0.0F) && (f2 <= 1.0F) && (f1 >= 0.0F) && (f1 <= 1.0F);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, OcrGestureBeanInfo paramOcrGestureBeanInfo)
  {
    Object localObject = paramOcrGestureBeanInfo.a;
    boolean bool = false;
    localObject = (Point)((List)localObject).get(0);
    Point localPoint1 = (Point)paramOcrGestureBeanInfo.a.get(1);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, ((Point)localObject).x, ((Point)localObject).y, localPoint1.x, localPoint1.y)) {
      return true;
    }
    Point localPoint2 = (Point)paramOcrGestureBeanInfo.a.get(2);
    paramOcrGestureBeanInfo = (Point)paramOcrGestureBeanInfo.a.get(3);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint2.x, localPoint2.y, paramOcrGestureBeanInfo.x, paramOcrGestureBeanInfo.y)) {
      return true;
    }
    if ((a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint1.x, localPoint1.y, localPoint2.x, localPoint2.y)) || (a(paramInt1, paramInt2, paramInt3, paramInt4, paramOcrGestureBeanInfo.x, paramOcrGestureBeanInfo.y, ((Point)localObject).x, ((Point)localObject).y))) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean a(Point paramPoint, OcrGestureBeanInfo paramOcrGestureBeanInfo)
  {
    if ((paramPoint.y <= paramOcrGestureBeanInfo.e) && (paramPoint.y >= paramOcrGestureBeanInfo.g) && (paramPoint.x <= paramOcrGestureBeanInfo.d))
    {
      if (paramPoint.x < paramOcrGestureBeanInfo.f) {
        return false;
      }
      if (paramOcrGestureBeanInfo.c % 90 < 1) {
        return true;
      }
      Point localPoint2 = (Point)paramOcrGestureBeanInfo.a.get(0);
      Point localPoint1 = (Point)paramOcrGestureBeanInfo.a.get(1);
      paramOcrGestureBeanInfo = (Point)paramOcrGestureBeanInfo.a.get(2);
      Point localPoint3 = a(localPoint2, localPoint1);
      int i1 = b(localPoint3, a(localPoint2, paramPoint));
      if (i1 < 0) {
        return false;
      }
      if (i1 > b(localPoint3, localPoint3)) {
        return false;
      }
      paramOcrGestureBeanInfo = a(localPoint1, paramOcrGestureBeanInfo);
      i1 = b(paramOcrGestureBeanInfo, a(localPoint1, paramPoint));
      if (i1 < 0) {
        return false;
      }
      return i1 <= b(paramOcrGestureBeanInfo, paramOcrGestureBeanInfo);
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e[0] = paramMotionEvent.getX();
    this.e[1] = paramMotionEvent.getY();
    this.d.mapPoints(this.e);
    int i3 = Math.round(this.e[0]);
    int i4 = Math.round(this.e[1]);
    paramMotionEvent = b().iterator();
    boolean bool = false;
    while (paramMotionEvent.hasNext())
    {
      OcrGestureBeanInfo localOcrGestureBeanInfo = (OcrGestureBeanInfo)paramMotionEvent.next();
      if (a(new Point(i3, i4), localOcrGestureBeanInfo))
      {
        if (!paramBoolean2)
        {
          if ((!paramBoolean1) && (localOcrGestureBeanInfo.b)) {
            bool = false;
          } else {
            bool = true;
          }
          localOcrGestureBeanInfo.b = bool;
          GestureFrameLayout localGestureFrameLayout = this.a;
          localGestureFrameLayout.a(localGestureFrameLayout);
          int i2 = 2;
          if ((!paramBoolean1) && (!localOcrGestureBeanInfo.b)) {
            i1 = 2;
          } else {
            i1 = 1;
          }
          this.o = i1;
          if (paramBoolean1) {
            a(localOcrGestureBeanInfo);
          }
          int i1 = i2;
          if (localOcrGestureBeanInfo.b) {
            i1 = 1;
          }
          OCRPerformUtil.a("0X800AAED", i1);
        }
        bool = true;
      }
    }
    return bool;
  }
  
  public static int b(Point paramPoint1, Point paramPoint2)
  {
    return paramPoint1.x * paramPoint2.x + paramPoint1.y * paramPoint2.y;
  }
  
  private List<? extends OcrGestureBeanInfo> b()
  {
    if (OCRPerformUtil.a) {
      return this.c;
    }
    return this.b;
  }
  
  public void a(Matrix paramMatrix)
  {
    this.d.set(paramMatrix);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.r.b();
    if (this.i)
    {
      this.l = 4;
      int i1;
      if (this.o == 1) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AAEE", "0X800AAEE", i1, 0, String.valueOf(this.h), "0", "0", "");
    }
    else if (this.k)
    {
      this.l = 1;
      OCRPerformUtil.a("0X800AAF6", 0);
    }
    else if (this.j)
    {
      this.l = 3;
      OCRPerformUtil.a("0X800AAF7", 0);
    }
    this.i = false;
    this.k = false;
    this.j = false;
    this.m.removeMessages(1);
    this.m.sendEmptyMessageDelayed(1, 500L);
    this.f = null;
    this.o = -1;
    this.h = 0;
    this.g = false;
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.n.b();
    this.k = true;
  }
  
  public void a(OcrGestureBeanInfo paramOcrGestureBeanInfo)
  {
    if (!this.p.b())
    {
      Object localObject = (Point)paramOcrGestureBeanInfo.a.get(0);
      paramOcrGestureBeanInfo = (Point)paramOcrGestureBeanInfo.a.get(1);
      Matrix localMatrix = new Matrix();
      this.d.invert(localMatrix);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = ((Point)localObject).x;
      arrayOfFloat[1] = ((Point)localObject).y;
      localObject = new float[2];
      localObject[0] = paramOcrGestureBeanInfo.x;
      localObject[1] = paramOcrGestureBeanInfo.y;
      localMatrix.mapPoints(arrayOfFloat);
      localMatrix.mapPoints((float[])localObject);
      int i1 = (int)(arrayOfFloat[0] + localObject[0]) / 2;
      int i2 = (int)(arrayOfFloat[1] + localObject[1]) / 2;
      this.p.a(this.a, i1, i2);
    }
  }
  
  public void a(OcrGestureBeanInfo paramOcrGestureBeanInfo, int paramInt)
  {
    if (this.o == -1)
    {
      if (paramOcrGestureBeanInfo.b) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      this.o = paramInt;
      this.i = true;
    }
    boolean bool;
    if (this.o == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != paramOcrGestureBeanInfo.b)
    {
      this.h += 1;
      paramOcrGestureBeanInfo.b = bool;
      paramOcrGestureBeanInfo = this.a;
      paramOcrGestureBeanInfo.a(paramOcrGestureBeanInfo);
      this.a.getGestureProxy().b().a(false);
    }
  }
  
  public boolean a()
  {
    return ((OCRPerformFragment)this.q).e();
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent2.getPointerCount() >= 2)
    {
      this.j = true;
      return false;
    }
    if ((!this.j) && ((this.f != null) || (!a()) || (a(paramMotionEvent1, false, true))))
    {
      a(paramMotionEvent1, paramMotionEvent2);
      return true;
    }
    this.j = true;
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.l = 2;
    return super.b(paramMotionEvent);
  }
  
  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.l = 7;
    return super.b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean b(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.n.a(1);
    this.r.c();
    return super.b(paramScaleGestureDetector);
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent, false, false);
    this.l = 6;
    return true;
  }
  
  public boolean c(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.n.c();
    return super.c(paramScaleGestureDetector);
  }
  
  public void d(MotionEvent paramMotionEvent)
  {
    this.p.a();
    this.a.getGestureProxy().b().a(true);
  }
  
  public void e(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent, true, false);
    this.l = 5;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    paramMessage = new HashMap();
    paramMessage.put("actType", String.valueOf(this.l));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOcrGestureType", true, 0L, 0L, paramMessage, null);
    QLog.d("OcrScroll", 1, new Object[] { "report ActOcrGestureType, type:", Integer.valueOf(this.l) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrScrollGestureListener
 * JD-Core Version:    0.7.0.1
 */