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
import bnfx;
import bnfy;
import bngj;
import bngv;
import bngy;
import bnhb;
import bnkb;
import bnke;
import bnkt;
import bnnl;
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
import xvv;

public class DoodleView
  extends View
{
  public int a;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  protected bnfy a;
  protected bngv a;
  public bnhb a;
  public EditVideoParams a;
  public DoodleLayout a;
  private Comparator<bngv> jdField_a_of_type_JavaUtilComparator = new bnke(this);
  private LinkedList<bngv> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  protected List<bngv> a;
  protected Map<String, bngv> a;
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
      xvv.b("DoodleView", "create Doodle bitmap, width:" + this.c + ",height:" + this.d);
      bool1 = bool2;
      return bool1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      xvv.c("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
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
      if (!((bngv)localIterator.next()).a(paramLong)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bnfy);
    this.jdField_a_of_type_Bnhb.jdField_a_of_type_Bngy.a(this.jdField_a_of_type_JavaUtilList, this);
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bngv localbngv = (bngv)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilMap.put(localbngv.a(), localbngv);
    }
    xvv.b("DoodleView", "DoodleView hold layers:" + this.jdField_a_of_type_JavaUtilMap.toString());
    this.jdField_a_of_type_Bngv = this.jdField_a_of_type_Bnfy;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {}
    for (localObject = (bngv)this.jdField_a_of_type_JavaUtilList.get(1);; localObject = null)
    {
      if ((localObject != null) && ((((bngv)localObject).c() != this.jdField_a_of_type_Int) || (((bngv)localObject).d() != this.jdField_b_of_type_Int))) {
        onSizeChanged(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, ((bngv)localObject).c(), ((bngv)localObject).d());
      }
      super.requestLayout();
      return;
    }
  }
  
  private void d()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = (bngj)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localObject != null) && (((bngj)localObject).a.a()) && (((bngj)localObject).a.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      ((bngj)localObject).a.b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) && (localObject != null)) {
      ((bngj)localObject).c(localCanvas);
    }
    localObject = new LinkedList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
    int i = ((LinkedList)localObject).size() - 1;
    while (i >= 0)
    {
      bngv localbngv = (bngv)((LinkedList)localObject).get(i);
      if (localbngv != null) {
        localbngv.b(localCanvas);
      }
      i -= 1;
    }
    xvv.b("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - l));
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
      xvv.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    d();
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public bngv a()
  {
    return this.jdField_a_of_type_Bngv;
  }
  
  public bngv a(MotionEvent paramMotionEvent)
  {
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_JavaUtilList);
    Collections.sort(localLinkedList, this.jdField_a_of_type_JavaUtilComparator);
    int i = 0;
    while (i < localLinkedList.size())
    {
      bngv localbngv = (bngv)localLinkedList.get(i);
      if ((localbngv != null) && (localbngv.b(paramMotionEvent))) {
        return localbngv;
      }
      i += 1;
    }
    return this.jdField_a_of_type_Bnfy;
  }
  
  public <LAYER extends bngv> LAYER a(String paramString)
  {
    paramString = (bngv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    this.jdField_a_of_type_Bnfy = new bnfy(this);
    this.jdField_a_of_type_Bngv = this.jdField_a_of_type_Bnfy;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    Object localObject = (bngj)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if (localObject != null)
    {
      localObject = (bnkt)((bngj)localObject).a.a(103);
      if (localObject != null)
      {
        if (!paramEditVideoParams.a()) {
          break label55;
        }
        ((bnkt)localObject).a(104);
      }
    }
    return;
    label55:
    if (((paramEditVideoParams.a instanceof EditTakeVideoSource)) || ((paramEditVideoParams.a instanceof EditLocalVideoSource)))
    {
      ((bnkt)localObject).a(105);
      return;
    }
    ((bnkt)localObject).a(103);
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
    return this.jdField_a_of_type_Bngv == this.jdField_a_of_type_Bnfy;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bngv)localIterator.next()).b();
    }
    h();
  }
  
  public boolean c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((bngv)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void f()
  {
    setActiveLayer(this.jdField_a_of_type_Bnfy);
    setTopLevelLayer(this.jdField_a_of_type_Bnfy);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bngv)localIterator.next()).a();
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    super.invalidate();
  }
  
  public void h()
  {
    xvv.b("DoodleView", "recycle bitmap.");
    if (d())
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    }
  }
  
  public void i()
  {
    bngj localbngj = (bngj)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localbngj != null) && (localbngj.a.a()) && (this.c > 0)) {
      localbngj.a.a(this.c);
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
          bngv localbngv = (bngv)((Map.Entry)((Iterator)localObject).next()).getValue();
          if ((localbngv instanceof bngj)) {
            ((bngj)localbngv).a.a(paramCanvas);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilLinkedList.addAll(this.jdField_a_of_type_JavaUtilMap.values());
      Collections.sort(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilComparator);
      int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
      while (i >= 0)
      {
        localObject = (bngv)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
        if (localObject != null) {
          ((bngv)localObject).d(paramCanvas);
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
    if (this.jdField_a_of_type_Bnhb != null)
    {
      xvv.b("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_Bnhb.jdField_a_of_type_Int + ",MaxHeight:" + this.jdField_a_of_type_Bnhb.jdField_b_of_type_Int);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_a_of_type_Bnhb.jdField_a_of_type_Int == 0)
      {
        paramInt3 = this.jdField_a_of_type_Int;
        label108:
        if (this.jdField_a_of_type_Bnhb.jdField_b_of_type_Int != 0) {
          break label227;
        }
      }
      label227:
      for (paramInt4 = this.jdField_b_of_type_Int;; paramInt4 = this.jdField_a_of_type_Bnhb.jdField_b_of_type_Int)
      {
        float f = bnnl.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt3, paramInt4);
        this.c = ((int)(this.jdField_a_of_type_Int * f));
        this.d = ((int)(this.jdField_b_of_type_Int * f));
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          bngv localbngv = (bngv)localIterator.next();
          localbngv.b(f);
          localbngv.a(paramInt1, paramInt2);
        }
        break;
        paramInt3 = this.jdField_a_of_type_Bnhb.jdField_a_of_type_Int;
        break label108;
      }
    }
    this.c = 0;
    this.d = 0;
    xvv.e("DoodleView", "DoodleConfig is null.");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if ((this.jdField_a_of_type_Bngv == this.jdField_a_of_type_Bnfy) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_Bngv = a(paramMotionEvent);
      this.jdField_a_of_type_Bngv.d(true);
      this.jdField_a_of_type_Bngv.n();
      xvv.b("DoodleView", this.jdField_a_of_type_Bngv.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_Bngv.d(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
  }
  
  public void setActiveLayer(bngv parambngv)
  {
    bngv localbngv = this.jdField_a_of_type_Bngv;
    this.jdField_a_of_type_Bngv = parambngv;
    if (localbngv == this.jdField_a_of_type_Bngv) {
      return;
    }
    localbngv.l();
    this.jdField_a_of_type_Bngv.m();
  }
  
  public void setDoodleConfig(bnhb parambnhb)
  {
    xvv.b("DoodleView", "init DoodleConfig: " + parambnhb.toString());
    this.jdField_a_of_type_Bnhb = parambnhb;
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
  
  public void setTopLevelLayer(bngv parambngv)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      bngv localbngv = (bngv)localIterator.next();
      if ((localbngv.a() <= i) || ((localbngv instanceof bnfx))) {
        break label64;
      }
      i = localbngv.a();
    }
    label64:
    for (;;)
    {
      break;
      parambngv.c(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */