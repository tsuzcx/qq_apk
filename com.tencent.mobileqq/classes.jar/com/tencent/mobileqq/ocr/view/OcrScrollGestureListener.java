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
  private int jdField_a_of_type_Int;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private CommonMenuPopupView jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView;
  private OcrScrollGestureListener.OcrPerformListener jdField_a_of_type_ComTencentMobileqqOcrViewOcrScrollGestureListener$OcrPerformListener;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private GestureFps jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps;
  private List<? extends OcrGestureBeanInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private int jdField_b_of_type_Int;
  private List<? extends OcrGestureBeanInfo> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public OcrScrollGestureListener(GestureFrameLayout paramGestureFrameLayout, List<OcrImageTextBean> paramList, List<OcrImageSectBean> paramList1, View.OnClickListener paramOnClickListener, OcrScrollGestureListener.OcrPerformListener paramOcrPerformListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = paramGestureFrameLayout;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrScrollGestureListener$OcrPerformListener = paramOcrPerformListener;
    paramList = paramGestureFrameLayout.getContext();
    paramGestureFrameLayout.a().a().a().invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView = new CommonMenuPopupView();
    this.jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView.a(2131365311, paramList.getString(2131691291), 2130838903);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView.a(2131367180, paramList.getString(2131692644), 2130838912);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView.a(2131379096, paramList.getString(2131699086), 2130838912);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    if (GestureFps.a()) {
      paramGestureFrameLayout = new GestureFps();
    } else {
      paramGestureFrameLayout = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps = paramGestureFrameLayout;
  }
  
  public static int a(Point paramPoint1, Point paramPoint2)
  {
    return paramPoint1.x * paramPoint2.x + paramPoint1.y * paramPoint2.y;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2)
  {
    return new Point(paramPoint2.x - paramPoint1.x, paramPoint2.y - paramPoint1.y);
  }
  
  private List<? extends OcrGestureBeanInfo> a()
  {
    if (OCRPerformUtil.jdField_a_of_type_Boolean) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int j = 0;
    int i;
    if (!bool)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent1.getX();
      this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent1.getY();
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
      k = Math.round(this.jdField_a_of_type_ArrayOfFloat[0]);
      m = Math.round(this.jdField_a_of_type_ArrayOfFloat[1]);
      paramMotionEvent1 = a();
      i = 0;
      while (i < paramMotionEvent1.size())
      {
        if (a(new Point(k, m), (OcrGestureBeanInfo)paramMotionEvent1.get(i))) {
          a((OcrGestureBeanInfo)paramMotionEvent1.get(i), i);
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent2.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent2.getY();
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    int k = Math.round(this.jdField_a_of_type_ArrayOfFloat[0]);
    int m = Math.round(this.jdField_a_of_type_ArrayOfFloat[1]);
    if (this.jdField_a_of_type_AndroidGraphicsPoint != null)
    {
      paramMotionEvent1 = a();
      i = j;
      while (i < paramMotionEvent1.size())
      {
        if (a(k, m, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, (OcrGestureBeanInfo)paramMotionEvent1.get(i))) {
          a((OcrGestureBeanInfo)paramMotionEvent1.get(i), i);
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(k, m);
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
    Object localObject = paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList;
    boolean bool = false;
    localObject = (Point)((List)localObject).get(0);
    Point localPoint1 = (Point)paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList.get(1);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, ((Point)localObject).x, ((Point)localObject).y, localPoint1.x, localPoint1.y)) {
      return true;
    }
    Point localPoint2 = (Point)paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList.get(2);
    paramOcrGestureBeanInfo = (Point)paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList.get(3);
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
    if ((paramPoint.y <= paramOcrGestureBeanInfo.jdField_c_of_type_Int) && (paramPoint.y >= paramOcrGestureBeanInfo.e) && (paramPoint.x <= paramOcrGestureBeanInfo.jdField_b_of_type_Int))
    {
      if (paramPoint.x < paramOcrGestureBeanInfo.d) {
        return false;
      }
      if (paramOcrGestureBeanInfo.jdField_a_of_type_Int % 90 < 1) {
        return true;
      }
      Point localPoint2 = (Point)paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList.get(0);
      Point localPoint1 = (Point)paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList.get(1);
      paramOcrGestureBeanInfo = (Point)paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList.get(2);
      Point localPoint3 = a(localPoint2, localPoint1);
      int i = a(localPoint3, a(localPoint2, paramPoint));
      if (i < 0) {
        return false;
      }
      if (i > a(localPoint3, localPoint3)) {
        return false;
      }
      paramOcrGestureBeanInfo = a(localPoint1, paramOcrGestureBeanInfo);
      i = a(paramOcrGestureBeanInfo, a(localPoint1, paramPoint));
      if (i < 0) {
        return false;
      }
      return i <= a(paramOcrGestureBeanInfo, paramOcrGestureBeanInfo);
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    int k = Math.round(this.jdField_a_of_type_ArrayOfFloat[0]);
    int m = Math.round(this.jdField_a_of_type_ArrayOfFloat[1]);
    paramMotionEvent = a().iterator();
    boolean bool = false;
    while (paramMotionEvent.hasNext())
    {
      OcrGestureBeanInfo localOcrGestureBeanInfo = (OcrGestureBeanInfo)paramMotionEvent.next();
      if (a(new Point(k, m), localOcrGestureBeanInfo))
      {
        if (!paramBoolean2)
        {
          if ((!paramBoolean1) && (localOcrGestureBeanInfo.jdField_a_of_type_Boolean)) {
            bool = false;
          } else {
            bool = true;
          }
          localOcrGestureBeanInfo.jdField_a_of_type_Boolean = bool;
          GestureFrameLayout localGestureFrameLayout = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
          localGestureFrameLayout.a(localGestureFrameLayout);
          int j = 2;
          if ((!paramBoolean1) && (!localOcrGestureBeanInfo.jdField_a_of_type_Boolean)) {
            i = 2;
          } else {
            i = 1;
          }
          this.jdField_c_of_type_Int = i;
          if (paramBoolean1) {
            a(localOcrGestureBeanInfo);
          }
          int i = j;
          if (localOcrGestureBeanInfo.jdField_a_of_type_Boolean) {
            i = 1;
          }
          OCRPerformUtil.a("0X800AAED", i);
        }
        bool = true;
      }
    }
    return bool;
  }
  
  public void a(Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrScrollGestureListener$OcrPerformListener.b();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 4;
      int i;
      if (this.jdField_c_of_type_Int == 1) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AAEE", "0X800AAEE", i, 0, String.valueOf(this.jdField_a_of_type_Int), "0", "0", "");
    }
    else if (this.d)
    {
      this.jdField_b_of_type_Int = 1;
      OCRPerformUtil.a("0X800AAF6", 0);
    }
    else if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 3;
      OCRPerformUtil.a("0X800AAF7", 0);
    }
    this.jdField_b_of_type_Boolean = false;
    this.d = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 500L);
    this.jdField_a_of_type_AndroidGraphicsPoint = null;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps.a();
    this.d = true;
  }
  
  public void a(OcrGestureBeanInfo paramOcrGestureBeanInfo)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView.a())
    {
      Object localObject = (Point)paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList.get(0);
      paramOcrGestureBeanInfo = (Point)paramOcrGestureBeanInfo.jdField_a_of_type_JavaUtilList.get(1);
      Matrix localMatrix = new Matrix();
      this.jdField_a_of_type_AndroidGraphicsMatrix.invert(localMatrix);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = ((Point)localObject).x;
      arrayOfFloat[1] = ((Point)localObject).y;
      localObject = new float[2];
      localObject[0] = paramOcrGestureBeanInfo.x;
      localObject[1] = paramOcrGestureBeanInfo.y;
      localMatrix.mapPoints(arrayOfFloat);
      localMatrix.mapPoints((float[])localObject);
      int i = (int)(arrayOfFloat[0] + localObject[0]) / 2;
      int j = (int)(arrayOfFloat[1] + localObject[1]) / 2;
      this.jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, i, j);
    }
  }
  
  public void a(OcrGestureBeanInfo paramOcrGestureBeanInfo, int paramInt)
  {
    if (this.jdField_c_of_type_Int == -1)
    {
      if (paramOcrGestureBeanInfo.jdField_a_of_type_Boolean) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_b_of_type_Boolean = true;
    }
    boolean bool;
    if (this.jdField_c_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != paramOcrGestureBeanInfo.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int += 1;
      paramOcrGestureBeanInfo.jdField_a_of_type_Boolean = bool;
      paramOcrGestureBeanInfo = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
      paramOcrGestureBeanInfo.a(paramOcrGestureBeanInfo);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a().a(false);
    }
  }
  
  public boolean a()
  {
    return ((OCRPerformFragment)this.jdField_a_of_type_AndroidViewView$OnClickListener).a();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_Int = 2;
    return super.a(paramMotionEvent);
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent2.getPointerCount() >= 2)
    {
      this.jdField_c_of_type_Boolean = true;
      return false;
    }
    if ((!this.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_AndroidGraphicsPoint != null) || (!a()) || (a(paramMotionEvent1, false, true))))
    {
      a(paramMotionEvent1, paramMotionEvent2);
      return true;
    }
    this.jdField_c_of_type_Boolean = true;
    return false;
  }
  
  public boolean a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps.a(1);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrScrollGestureListener$OcrPerformListener.c();
    return super.a(paramScaleGestureDetector);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewCommonMenuPopupView.a();
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a().a(true);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent, false, false);
    this.jdField_b_of_type_Int = 6;
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Int = 7;
    return super.b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean b(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps.b();
    return super.b(paramScaleGestureDetector);
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent, true, false);
    this.jdField_b_of_type_Int = 5;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    paramMessage = new HashMap();
    paramMessage.put("actType", String.valueOf(this.jdField_b_of_type_Int));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOcrGestureType", true, 0L, 0L, paramMessage, null);
    QLog.d("OcrScroll", 1, new Object[] { "report ActOcrGestureType, type:", Integer.valueOf(this.jdField_b_of_type_Int) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrScrollGestureListener
 * JD-Core Version:    0.7.0.1
 */