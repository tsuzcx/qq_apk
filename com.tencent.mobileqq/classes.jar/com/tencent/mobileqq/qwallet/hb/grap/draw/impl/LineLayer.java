package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.doodle.DoodleParam;
import com.tencent.mobileqq.activity.aio.doodle.PathData;
import com.tencent.mobileqq.activity.aio.doodle.PathDesc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LineLayer
  extends BaseLayer
  implements LoadTempFileJobListener, SaveTempFileJobListener
{
  public static final int a;
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private DoodleParam jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam = new DoodleParam();
  private PathDesc jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc;
  private LineLayer.LineLayerListener jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LineLayerListener;
  private LineLayer.LoadTempFileJob jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob;
  private List<PathDesc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_c_of_type_Int = 0;
  private Map<Integer, Integer> jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = -1;
  private int h = 0;
  private int i = 0;
  
  static
  {
    jdField_a_of_type_Int = Color.parseColor("#ff000000");
  }
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  private void a(Canvas paramCanvas, PathDesc paramPathDesc, boolean paramBoolean)
  {
    paramPathDesc.a(paramCanvas, paramBoolean);
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      return arrayOfInt;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PathDesc localPathDesc = (PathDesc)((Iterator)localObject).next();
      arrayOfInt[0] += 1;
    }
    return arrayOfInt;
  }
  
  private void c()
  {
    this.i += 1;
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.i));
    LineLayer.LoadTempFileJob localLoadTempFileJob = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob;
    if (localLoadTempFileJob != null)
    {
      ThreadManager.remove(localLoadTempFileJob);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob = new LineLayer.LoadTempFileJob(this, this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaUtilMap, this.i, this);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob, 5, null, false);
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (!c()) {
        d();
      }
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = this.e;
      if (k - 1 > j)
      {
        while (j < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          a(this.jdField_a_of_type_AndroidGraphicsCanvas, (PathDesc)this.jdField_a_of_type_JavaUtilList.get(j), false);
          j += 1;
        }
        this.f = 0;
        this.e = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      }
      else if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        this.e = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      }
      localObject = (PathDesc)this.jdField_a_of_type_JavaUtilList.get(this.e);
      j = ((PathDesc)localObject).a();
      k = this.f;
      if (j > k)
      {
        ((PathDesc)localObject).a(this.jdField_a_of_type_AndroidGraphicsCanvas, k, j);
        this.f = j;
        if (this.f == 1) {
          this.f = 0;
        }
      }
      return;
    }
    e();
  }
  
  private void e()
  {
    Canvas localCanvas = this.jdField_a_of_type_AndroidGraphicsCanvas;
    if (localCanvas != null)
    {
      Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (localPaint != null) {
        localCanvas.drawPaint(localPaint);
      }
    }
    this.e = 0;
    this.f = 0;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final DoodleParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam;
  }
  
  public List<PathData> a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      PathDesc localPathDesc = (PathDesc)localIterator.next();
      PathData localPathData = new PathData();
      localPathData.a(localPathDesc.a());
      localArrayList.add(localPathData);
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.g = -1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(paramInt1, paramInt2);
    d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob = null;
    Object localObject = (Integer)this.jdField_c_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("undo result, seq not exist:");
        paramBitmap.append(paramInt1);
        paramBitmap.append("-");
        paramBitmap.append(paramInt2);
        paramBitmap.append("-");
        paramBitmap.append(paramInt3);
        QLog.d("LineLayer", 2, paramBitmap.toString());
      }
      return;
    }
    if (paramInt3 != ((Integer)localObject).intValue())
    {
      this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), localObject);
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("undo result, seq not match:");
        paramBitmap.append(paramInt1);
        paramBitmap.append("-");
        paramBitmap.append(paramInt2);
        paramBitmap.append("-");
        paramBitmap.append(paramInt3);
        paramBitmap.append("-");
        paramBitmap.append(((Integer)localObject).intValue());
        QLog.d("LineLayer", 2, paramBitmap.toString());
      }
      return;
    }
    if (paramInt1 != this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("undo result, pathsize not match:");
        paramBitmap.append(paramInt1);
        paramBitmap.append("-");
        paramBitmap.append(paramInt2);
        paramBitmap.append("-");
        paramBitmap.append(paramInt3);
        paramBitmap.append("-");
        paramBitmap.append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("LineLayer", 2, paramBitmap.toString());
      }
      return;
    }
    if ((paramInt2 != 0) && (paramBitmap != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("undo result, use cache:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("LineLayer", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Paint();
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, (Paint)localObject);
      this.e = (paramInt2 - 1);
      paramBitmap = (PathDesc)this.jdField_a_of_type_JavaUtilList.get(this.e);
      if (paramBitmap != null)
      {
        this.f = paramBitmap.a();
        if (this.f == 1) {
          this.f = 0;
        }
      }
      if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size()) {
        d();
      }
      super.a();
      return;
    }
    e();
    super.a();
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("undo result, no cache:");
      paramBitmap.append(paramInt1);
      paramBitmap.append("-");
      paramBitmap.append(paramInt2);
      paramBitmap.append("-");
      paramBitmap.append(paramInt3);
      QLog.d("LineLayer", 2, paramBitmap.toString());
    }
  }
  
  public void a(LineLayer.LineLayerListener paramLineLayerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LineLayerListener = paramLineLayerListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = null;
    this.h = 0;
    ThreadManager.post(new LineLayer.ClearTempFileJob(this), 5, null, true);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localBitmap != null)
      {
        localBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (Integer)this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("save result, seq not exist:");
        paramString.append(paramInt1);
        paramString.append("-");
        paramString.append(paramInt2);
        QLog.d("LineLayer", 2, paramString.toString());
      }
      return;
    }
    if (paramInt2 != ((Integer)localObject).intValue())
    {
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), localObject);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("save result, seq not match:");
        paramString.append(paramInt1);
        paramString.append("-");
        paramString.append(paramInt2);
        paramString.append("-");
        paramString.append(((Integer)localObject).intValue());
        QLog.d("LineLayer", 2, paramString.toString());
      }
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save result, add cache:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilMap.size());
      QLog.d("LineLayer", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public int b()
  {
    int[] arrayOfInt = a();
    return arrayOfInt[0] + arrayOfInt[1];
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo begin");
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_c_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      localList = this.jdField_a_of_type_JavaUtilList;
      localList.remove(localList.size() - 1);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.h = 0;
        ThreadManager.post(new LineLayer.ClearTempFileJob(this), 5, null, true);
        this.jdField_b_of_type_JavaUtilMap.clear();
        this.jdField_c_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap.clear();
        e();
      }
      else
      {
        this.h = c();
      }
    }
    if (this.h < 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo draw directly");
      }
      e();
      super.a();
    }
    else
    {
      c();
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo try use cache");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo end");
    }
  }
  
  public void b(int paramInt)
  {
    if (this.g == paramInt) {
      return;
    }
    this.jdField_b_of_type_Int = -1;
    this.g = paramInt;
  }
  
  protected void b(Canvas paramCanvas)
  {
    d();
    c(paramCanvas);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    int j = this.h;
    int k = 0;
    if (j > 10000)
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LineLayerListener;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.a(2, 10000);
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LineLayerListener.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = null;
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return true;
        }
        long l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Long;
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a(f1, f2, l1 - l2);
          this.h += 1;
          return true;
        }
      }
      else
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LineLayerListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.b();
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a(false);
          d();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a(true);
          this.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a();
          if (this.f == 1) {
            this.f = 0;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = null;
        this.h = c();
        paramMotionEvent = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        j = 0;
        while (paramMotionEvent.hasNext())
        {
          m = ((Integer)paramMotionEvent.next()).intValue();
          if (j < m) {
            j = m;
          }
        }
        paramMotionEvent = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        while (paramMotionEvent.hasNext())
        {
          m = ((Integer)paramMotionEvent.next()).intValue();
          if (j < m) {
            j = m;
          }
        }
        int m = 0;
        while (k < j)
        {
          m += ((PathDesc)this.jdField_a_of_type_JavaUtilList.get(k)).b();
          k += 1;
        }
        if (m + 100 < this.h)
        {
          d();
          this.i += 1;
          this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.i));
          ThreadManager.post(new LineLayer.SaveTempFileJob(this, this.jdField_a_of_type_JavaUtilList.size(), this.i, this.jdField_a_of_type_AndroidGraphicsBitmap, this), 5, null, true);
          return true;
        }
      }
    }
    else
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LineLayerListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = new PathDesc(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam, a(), null, this.g);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a(f1, f2);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc);
      this.h = c();
    }
    return true;
  }
  
  public int c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      j += ((PathDesc)((Iterator)localObject).next()).b();
    }
    return j;
  }
  
  public void c(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (paramCanvas != null)) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidGraphicsCanvas != null);
  }
  
  public boolean d()
  {
    int j = this.jdField_a_of_type_AndroidGraphicsRect.width();
    int k = this.jdField_a_of_type_AndroidGraphicsRect.height();
    if (j > 0)
    {
      if (k <= 0) {
        return false;
      }
      try
      {
        if ((this.jdField_c_of_type_Int == j) && (this.d == k) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
          if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
            break label269;
          }
        }
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsCanvas = null;
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_c_of_type_Int = j;
          this.d = k;
        }
        this.e = 0;
        this.f = 0;
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkcache oom:");
          localStringBuilder.append(localOutOfMemoryError.toString());
          QLog.e("LineLayer", 2, localStringBuilder.toString());
        }
        this.jdField_c_of_type_Int = 0;
        this.d = 0;
        this.jdField_a_of_type_AndroidGraphicsCanvas = null;
        this.e = 0;
        this.f = 0;
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if (localBitmap != null)
        {
          localBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_c_of_type_Int = 0;
        this.d = 0;
        this.jdField_a_of_type_AndroidGraphicsCanvas = null;
        this.e = 0;
        this.f = 0;
        return true;
      }
    }
    else
    {
      return false;
    }
    label269:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.LineLayer
 * JD-Core Version:    0.7.0.1
 */