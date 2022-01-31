package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
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
import anzw;
import anzx;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
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
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public EditVideoParams a;
  protected EmptyLayer a;
  protected BaseLayer a;
  public DoodleConfig a;
  public DoodleLayout a;
  private Comparator jdField_a_of_type_JavaUtilComparator = new anzw(this);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  protected List a;
  protected Map a;
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
  
  public BaseLayer a(String paramString)
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
    if ((paramEditVideoParams.a instanceof EditTakeVideoSource))
    {
      ((MosaicOperator)localObject).a(105);
      return;
    }
    ((MosaicOperator)localObject).a(103);
  }
  
  /* Error */
  public boolean a(Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 76
    //   5: new 78	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 327
    //   15: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_3
    //   19: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 99	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 329	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:a	()Landroid/graphics/Bitmap;
    //   32: astore 8
    //   34: aload 8
    //   36: ifnonnull +14 -> 50
    //   39: ldc 76
    //   41: ldc_w 331
    //   44: invokestatic 99	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload 4
    //   49: ireturn
    //   50: aconst_null
    //   51: astore 7
    //   53: aconst_null
    //   54: astore 5
    //   56: aconst_null
    //   57: astore 6
    //   59: new 333	java/io/File
    //   62: dup
    //   63: aload_3
    //   64: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 9
    //   69: aload 5
    //   71: astore_3
    //   72: aload 9
    //   74: invokevirtual 337	java/io/File:exists	()Z
    //   77: ifne +12 -> 89
    //   80: aload 5
    //   82: astore_3
    //   83: aload 9
    //   85: invokevirtual 340	java/io/File:createNewFile	()Z
    //   88: pop
    //   89: aload 5
    //   91: astore_3
    //   92: new 342	java/io/FileOutputStream
    //   95: dup
    //   96: aload 9
    //   98: invokespecial 345	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore 5
    //   103: aload 8
    //   105: aload_1
    //   106: iload_2
    //   107: aload 5
    //   109: invokevirtual 349	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   112: pop
    //   113: iconst_1
    //   114: istore 4
    //   116: aload 5
    //   118: ifnull -71 -> 47
    //   121: aload 5
    //   123: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   133: iconst_1
    //   134: ireturn
    //   135: astore 5
    //   137: aload 6
    //   139: astore_1
    //   140: aload_1
    //   141: astore_3
    //   142: aload 5
    //   144: invokevirtual 356	java/io/FileNotFoundException:printStackTrace	()V
    //   147: aload_1
    //   148: ifnull -101 -> 47
    //   151: aload_1
    //   152: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   162: iconst_0
    //   163: ireturn
    //   164: astore 5
    //   166: aload 7
    //   168: astore_1
    //   169: aload_1
    //   170: astore_3
    //   171: aload 5
    //   173: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull -130 -> 47
    //   180: aload_1
    //   181: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: astore_1
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   202: aload_1
    //   203: athrow
    //   204: astore_3
    //   205: aload_3
    //   206: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   209: goto -7 -> 202
    //   212: astore_1
    //   213: aload 5
    //   215: astore_3
    //   216: goto -22 -> 194
    //   219: astore_3
    //   220: aload 5
    //   222: astore_1
    //   223: aload_3
    //   224: astore 5
    //   226: goto -57 -> 169
    //   229: astore_3
    //   230: aload 5
    //   232: astore_1
    //   233: aload_3
    //   234: astore 5
    //   236: goto -96 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	DoodleView
    //   0	239	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	239	2	paramInt	int
    //   0	239	3	paramString	String
    //   1	114	4	bool	boolean
    //   54	68	5	localFileOutputStream	java.io.FileOutputStream
    //   135	8	5	localFileNotFoundException	java.io.FileNotFoundException
    //   164	57	5	localIOException	java.io.IOException
    //   224	11	5	str	String
    //   57	81	6	localObject1	Object
    //   51	116	7	localObject2	Object
    //   32	72	8	localBitmap	Bitmap
    //   67	30	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   121	126	128	java/io/IOException
    //   72	80	135	java/io/FileNotFoundException
    //   83	89	135	java/io/FileNotFoundException
    //   92	103	135	java/io/FileNotFoundException
    //   151	155	157	java/io/IOException
    //   72	80	164	java/io/IOException
    //   83	89	164	java/io/IOException
    //   92	103	164	java/io/IOException
    //   180	184	186	java/io/IOException
    //   72	80	193	finally
    //   83	89	193	finally
    //   92	103	193	finally
    //   142	147	193	finally
    //   171	176	193	finally
    //   198	202	204	java/io/IOException
    //   103	113	212	finally
    //   103	113	219	java/io/IOException
    //   103	113	229	java/io/FileNotFoundException
  }
  
  public boolean a(String paramString)
  {
    return a(Bitmap.CompressFormat.PNG, 100, paramString);
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
      ((BaseLayer)localIterator.next()).f();
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
          localBaseLayer.a(f);
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
  
  protected void onVisibilityChanged(View paramView, int paramInt)
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
    ThreadManager.getUIHandler().post(new anzx(this, paramLong));
  }
  
  public void setTopLevelLayer(BaseLayer paramBaseLayer)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
      if ((localBaseLayer.f_() <= i) || ((localBaseLayer instanceof DynamicFaceLayer))) {
        break label64;
      }
      i = localBaseLayer.f_();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */