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
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
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

public class DoodleView
  extends View
{
  public int a;
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public EditVideoParams a;
  protected EmptyLayer a;
  protected BaseLayer a;
  public DoodleConfig a;
  public DoodleLayout a;
  private Comparator<BaseLayer> jdField_a_of_type_JavaUtilComparator = new DoodleView.1(this);
  private LinkedList<BaseLayer> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  protected List<BaseLayer> a;
  protected Map<String, BaseLayer> a;
  public boolean a;
  public int b;
  private boolean b;
  public int c;
  public int d;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = false;
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
      SLog.b("DoodleView", "create Doodle bitmap, width:" + this.c + ",height:" + this.d);
      bool1 = bool2;
      return bool1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SLog.c("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
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
      if (!((BaseLayer)localIterator.next()).a(paramLong)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy.a(this.jdField_a_of_type_JavaUtilList, this);
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilMap.put(localBaseLayer.a(), localBaseLayer);
    }
    SLog.b("DoodleView", "DoodleView hold layers:" + this.jdField_a_of_type_JavaUtilMap.toString());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {}
    for (localObject = (BaseLayer)this.jdField_a_of_type_JavaUtilList.get(1);; localObject = null)
    {
      if ((localObject != null) && ((((BaseLayer)localObject).c() != this.jdField_a_of_type_Int) || (((BaseLayer)localObject).d() != this.jdField_b_of_type_Int))) {
        onSizeChanged(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, ((BaseLayer)localObject).c(), ((BaseLayer)localObject).d());
      }
      super.requestLayout();
      return;
    }
  }
  
  private void d()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = (LineLayer)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localObject != null) && (((LineLayer)localObject).a.a()) && (((LineLayer)localObject).a.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      ((LineLayer)localObject).a.b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) && (localObject != null)) {
      ((LineLayer)localObject).c(localCanvas);
    }
    localObject = new LinkedList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
    int i = ((LinkedList)localObject).size() - 1;
    while (i >= 0)
    {
      BaseLayer localBaseLayer = (BaseLayer)((LinkedList)localObject).get(i);
      if (localBaseLayer != null) {
        localBaseLayer.b(localCanvas);
      }
      i -= 1;
    }
    SLog.b("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - l));
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
      SLog.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    d();
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public BaseLayer a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
  }
  
  public BaseLayer a(MotionEvent paramMotionEvent)
  {
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_JavaUtilList);
    Collections.sort(localLinkedList, this.jdField_a_of_type_JavaUtilComparator);
    int i = 0;
    while (i < localLinkedList.size())
    {
      BaseLayer localBaseLayer = (BaseLayer)localLinkedList.get(i);
      if ((localBaseLayer != null) && (localBaseLayer.b(paramMotionEvent))) {
        return localBaseLayer;
      }
      i += 1;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public <LAYER extends BaseLayer> LAYER a(String paramString)
  {
    paramString = (BaseLayer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer = new EmptyLayer(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    Object localObject = (LineLayer)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if (localObject != null)
    {
      localObject = (MosaicOperator)((LineLayer)localObject).a.a(103);
      if (localObject != null)
      {
        if (!paramEditVideoParams.a()) {
          break label55;
        }
        ((MosaicOperator)localObject).a(104);
      }
    }
    return;
    label55:
    if (((paramEditVideoParams.a instanceof EditTakeVideoSource)) || ((paramEditVideoParams.a instanceof EditLocalVideoSource)))
    {
      ((MosaicOperator)localObject).a(105);
      return;
    }
    ((MosaicOperator)localObject).a(103);
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
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseLayer)localIterator.next()).b();
    }
    h();
  }
  
  public boolean c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((BaseLayer)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void f()
  {
    setActiveLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer);
    setTopLevelLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((BaseLayer)localIterator.next()).a();
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    super.invalidate();
  }
  
  public void h()
  {
    SLog.b("DoodleView", "recycle bitmap.");
    if (d())
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    }
  }
  
  public void i()
  {
    LineLayer localLineLayer = (LineLayer)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localLineLayer != null) && (localLineLayer.a.a()) && (this.c > 0)) {
      localLineLayer.a.a(this.c);
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
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
          BaseLayer localBaseLayer = (BaseLayer)((Map.Entry)((Iterator)localObject).next()).getValue();
          if ((localBaseLayer instanceof LineLayer)) {
            ((LineLayer)localBaseLayer).a.a(paramCanvas);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilLinkedList.addAll(this.jdField_a_of_type_JavaUtilMap.values());
      Collections.sort(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilComparator);
      int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
      while (i >= 0)
      {
        localObject = (BaseLayer)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
        if (localObject != null) {
          ((BaseLayer)localObject).d(paramCanvas);
        }
        i -= 1;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
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
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig != null)
    {
      SLog.b("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int + ",MaxHeight:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_b_of_type_Int);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int == 0)
      {
        paramInt3 = this.jdField_a_of_type_Int;
        label108:
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_b_of_type_Int != 0) {
          break label227;
        }
      }
      label227:
      for (paramInt4 = this.jdField_b_of_type_Int;; paramInt4 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_b_of_type_Int)
      {
        float f = DisplayUtil.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt3, paramInt4);
        this.c = ((int)(this.jdField_a_of_type_Int * f));
        this.d = ((int)(this.jdField_b_of_type_Int * f));
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
          localBaseLayer.b(f);
          localBaseLayer.a(paramInt1, paramInt2);
        }
        break;
        paramInt3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int;
        break label108;
      }
    }
    this.c = 0;
    this.d = 0;
    SLog.e("DoodleView", "DoodleConfig is null.");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = a(paramMotionEvent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.d(true);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.n();
      SLog.b("DoodleView", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.d(paramMotionEvent);
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
  }
  
  public void setActiveLayer(BaseLayer paramBaseLayer)
  {
    BaseLayer localBaseLayer = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = paramBaseLayer;
    if (localBaseLayer == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer) {
      return;
    }
    localBaseLayer.l();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.m();
  }
  
  public void setDoodleConfig(DoodleConfig paramDoodleConfig)
  {
    SLog.b("DoodleView", "init DoodleConfig: " + paramDoodleConfig.toString());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig = paramDoodleConfig;
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
  
  public void setTopLevelLayer(BaseLayer paramBaseLayer)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
      if ((localBaseLayer.g_() <= i) || ((localBaseLayer instanceof DynamicFaceLayer))) {
        break label64;
      }
      i = localBaseLayer.g_();
    }
    label64:
    for (;;)
    {
      break;
      paramBaseLayer.c(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */