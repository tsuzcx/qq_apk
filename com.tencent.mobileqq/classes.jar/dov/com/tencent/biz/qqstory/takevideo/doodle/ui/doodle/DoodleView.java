package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import bovp;
import bovq;
import bowb;
import bown;
import bowq;
import bowt;
import bozt;
import bozw;
import bpal;
import bpdd;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import ykq;

public class DoodleView
  extends View
{
  public int a;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  protected bovq a;
  protected bown a;
  public bowt a;
  public EditVideoParams a;
  public DoodleLayout a;
  private Comparator<bown> jdField_a_of_type_JavaUtilComparator = new bozw(this);
  private LinkedList<bown> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  protected List<bown> a;
  protected Map<String, bown> a;
  public boolean a;
  public int b;
  private boolean b;
  public int c;
  public int d;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.c > 0)
    {
      bool1 = bool3;
      if (this.d > 0) {
        bool1 = bool2;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_8888);
      bool1 = bool2;
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      bool1 = true;
      bool2 = true;
      ykq.b("DoodleView", "create Doodle bitmap, width:" + this.c + ",height:" + this.d);
      bool1 = bool2;
      return bool1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ykq.c("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
    }
    return bool1;
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      if (!((bown)localIterator.next()).a(paramLong)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bovq);
    this.jdField_a_of_type_Bowt.jdField_a_of_type_Bowq.a(this.jdField_a_of_type_JavaUtilList, this);
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bown localbown = (bown)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilMap.put(localbown.a(), localbown);
    }
    ykq.b("DoodleView", "DoodleView hold layers:" + this.jdField_a_of_type_JavaUtilMap.toString());
    this.jdField_a_of_type_Bown = this.jdField_a_of_type_Bovq;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {}
    for (localObject = (bown)this.jdField_a_of_type_JavaUtilList.get(1);; localObject = null)
    {
      if ((localObject != null) && ((((bown)localObject).c() != this.jdField_a_of_type_Int) || (((bown)localObject).d() != this.jdField_b_of_type_Int))) {
        onSizeChanged(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, ((bown)localObject).c(), ((bown)localObject).d());
      }
      super.requestLayout();
      return;
    }
  }
  
  private void d()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = (bowb)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localObject != null) && (((bowb)localObject).a.a()) && (((bowb)localObject).a.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      ((bowb)localObject).a.b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) && (localObject != null)) {
      ((bowb)localObject).c(localCanvas);
    }
    localObject = new LinkedList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
    int i = ((LinkedList)localObject).size() - 1;
    while (i >= 0)
    {
      bown localbown = (bown)((LinkedList)localObject).get(i);
      if (localbown != null) {
        localbown.b(localCanvas);
      }
      i -= 1;
    }
    ykq.b("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - l));
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled());
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Bitmap a()
  {
    if (!a())
    {
      ykq.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    d();
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public bown a()
  {
    return this.jdField_a_of_type_Bown;
  }
  
  public bown a(MotionEvent paramMotionEvent)
  {
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_JavaUtilList);
    Collections.sort(localLinkedList, this.jdField_a_of_type_JavaUtilComparator);
    int i = 0;
    while (i < localLinkedList.size())
    {
      bown localbown = (bown)localLinkedList.get(i);
      if ((localbown != null) && (localbown.b(paramMotionEvent))) {
        return localbown;
      }
      i += 1;
    }
    return this.jdField_a_of_type_Bovq;
  }
  
  public <LAYER extends bown> LAYER a(String paramString)
  {
    paramString = (bown)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      throw new IllegalArgumentException("this layer is not exist in DoodleView.");
    }
    return paramString;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    this.jdField_a_of_type_Bovq = new bovq(this);
    this.jdField_a_of_type_Bown = this.jdField_a_of_type_Bovq;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    Object localObject = (bowb)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if (localObject != null)
    {
      localObject = (bpal)((bowb)localObject).a.a(103);
      if (localObject != null)
      {
        if (!paramEditVideoParams.a()) {
          break label55;
        }
        ((bpal)localObject).a(104);
      }
    }
    return;
    label55:
    if (((paramEditVideoParams.a instanceof EditTakeVideoSource)) || ((paramEditVideoParams.a instanceof EditLocalVideoSource)))
    {
      ((bpal)localObject).a(105);
      return;
    }
    ((bpal)localObject).a(103);
  }
  
  public void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, float paramFloat3, PointF paramPointF, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramFloat1, (int)paramFloat2, (int)paramFloat3, paramPointF, paramBoolean2, paramInt);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bown == this.jdField_a_of_type_Bovq;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bown)localIterator.next()).b();
    }
    h();
  }
  
  public boolean c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((bown)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void f()
  {
    setActiveLayer(this.jdField_a_of_type_Bovq);
    setTopLevelLayer(this.jdField_a_of_type_Bovq);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bown)localIterator.next()).a();
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    super.invalidate();
  }
  
  public void h()
  {
    ykq.b("DoodleView", "recycle bitmap.");
    if (d())
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    }
  }
  
  public void i()
  {
    bowb localbowb = (bowb)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localbowb != null) && (localbowb.a.a()) && (this.c > 0)) {
      localbowb.a.a(this.c);
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()))
      {
        localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          bown localbown = (bown)((Map.Entry)((Iterator)localObject).next()).getValue();
          if ((localbown instanceof bowb)) {
            ((bowb)localbown).a.a(paramCanvas);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilLinkedList.addAll(this.jdField_a_of_type_JavaUtilMap.values());
      Collections.sort(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilComparator);
      int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
      while (i >= 0)
      {
        localObject = (bown)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
        if (localObject != null) {
          ((bown)localObject).d(paramCanvas);
        }
        i -= 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if ((j != -2147483648) || (k == -2147483648)) {
      paramInt1 = i * 3 / 2;
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_Bowt != null)
    {
      ykq.b("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_Bowt.jdField_a_of_type_Int + ",MaxHeight:" + this.jdField_a_of_type_Bowt.jdField_b_of_type_Int);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_a_of_type_Bowt.jdField_a_of_type_Int == 0)
      {
        paramInt3 = this.jdField_a_of_type_Int;
        label108:
        if (this.jdField_a_of_type_Bowt.jdField_b_of_type_Int != 0) {
          break label227;
        }
      }
      label227:
      for (paramInt4 = this.jdField_b_of_type_Int;; paramInt4 = this.jdField_a_of_type_Bowt.jdField_b_of_type_Int)
      {
        float f = bpdd.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt3, paramInt4);
        this.c = ((int)(this.jdField_a_of_type_Int * f));
        this.d = ((int)(this.jdField_b_of_type_Int * f));
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          bown localbown = (bown)localIterator.next();
          localbown.b(f);
          localbown.a(paramInt1, paramInt2);
        }
        break;
        paramInt3 = this.jdField_a_of_type_Bowt.jdField_a_of_type_Int;
        break label108;
      }
    }
    this.c = 0;
    this.d = 0;
    ykq.e("DoodleView", "DoodleConfig is null.");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if ((this.jdField_a_of_type_Bown == this.jdField_a_of_type_Bovq) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_Bown = a(paramMotionEvent);
      this.jdField_a_of_type_Bown.d(true);
      this.jdField_a_of_type_Bown.n();
      ykq.b("DoodleView", this.jdField_a_of_type_Bown.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_Bown.d(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
  }
  
  public void setActiveLayer(bown parambown)
  {
    bown localbown = this.jdField_a_of_type_Bown;
    this.jdField_a_of_type_Bown = parambown;
    if (localbown == this.jdField_a_of_type_Bown) {
      return;
    }
    localbown.l();
    this.jdField_a_of_type_Bown.m();
  }
  
  public void setDoodleConfig(bowt parambowt)
  {
    ykq.b("DoodleView", "init DoodleConfig: " + parambowt.toString());
    this.jdField_a_of_type_Bowt = parambowt;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    b();
  }
  
  public void setDoodleLayout(DoodleLayout paramDoodleLayout)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = paramDoodleLayout;
  }
  
  public void setEnableVisible(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPreventTouch(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (a(paramLong))
      {
        requestLayout();
        invalidate();
      }
      return;
    }
    ThreadManager.getUIHandler().post(new DoodleView.2(this, paramLong));
  }
  
  public void setTopLevelLayer(bown parambown)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      bown localbown = (bown)localIterator.next();
      if ((localbown.a() <= i) || ((localbown instanceof bovp))) {
        break label64;
      }
      i = localbown.a();
    }
    label64:
    for (;;)
    {
      break;
      parambown.c(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */