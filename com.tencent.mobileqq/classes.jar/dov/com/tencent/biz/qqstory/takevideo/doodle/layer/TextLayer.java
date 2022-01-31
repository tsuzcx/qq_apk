package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import dov.com.qq.im.capture.text.DynamicTextBuilder;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.TextParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public class TextLayer
  extends BaseLayer
{
  public static int a;
  public static final String a;
  public static final int b;
  private static String jdField_b_of_type_JavaLangString = "TextLayer";
  public static final int c;
  public static int d;
  public static int e;
  public static volatile int f;
  public Paint a;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  DynamicTextBuilder jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder = new DynamicTextBuilder();
  public TextLayer.LayerListener a;
  public TextLayer.TextItem a;
  public GestureHelper a;
  public ArrayList a;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  public TextLayer.TextItem b;
  public int g;
  public int h;
  public int i;
  public int j = c;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  
  static
  {
    jdField_a_of_type_JavaLangString = TextLayer.class.getSimpleName();
    jdField_b_of_type_Int = dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke.a[1];
    c = Color.parseColor("#80000000");
    e = 270;
    f = 5;
  }
  
  public TextLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    o();
  }
  
  /* Error */
  private String a(String paramString, TextLayer.TextItem paramTextItem)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: aload_2
    //   16: getfield 113	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer$TextItem:u	F
    //   19: f2i
    //   20: aload_2
    //   21: getfield 116	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer$TextItem:v	F
    //   24: f2i
    //   25: getstatic 122	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   28: invokestatic 128	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   31: astore 4
    //   33: aload 4
    //   35: astore 5
    //   37: new 130	android/graphics/Canvas
    //   40: dup
    //   41: aload 4
    //   43: invokespecial 133	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   46: astore 6
    //   48: aload 4
    //   50: astore 5
    //   52: aload 6
    //   54: aload_2
    //   55: getfield 113	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer$TextItem:u	F
    //   58: fconst_2
    //   59: fdiv
    //   60: aload_2
    //   61: getfield 116	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer$TextItem:v	F
    //   64: fconst_2
    //   65: fdiv
    //   66: invokevirtual 137	android/graphics/Canvas:translate	(FF)V
    //   69: aload 4
    //   71: astore 5
    //   73: aload_2
    //   74: getfield 140	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer$TextItem:jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem	Ldov/com/qq/im/capture/text/DynamicTextItem;
    //   77: aload 6
    //   79: invokevirtual 145	dov/com/qq/im/capture/text/DynamicTextItem:b	(Landroid/graphics/Canvas;)V
    //   82: aload 4
    //   84: astore 5
    //   86: aload_1
    //   87: ldc 147
    //   89: invokestatic 150	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload 4
    //   95: astore 5
    //   97: aload_0
    //   98: aload 4
    //   100: getstatic 156	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   103: bipush 100
    //   105: aload_1
    //   106: invokevirtual 159	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   109: istore_3
    //   110: aload 4
    //   112: astore 5
    //   114: getstatic 41	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   117: new 161	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   124: ldc 164
    //   126: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_2
    //   130: getfield 113	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer$TextItem:u	F
    //   133: invokevirtual 171	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   136: ldc 173
    //   138: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_2
    //   142: getfield 113	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer$TextItem:u	F
    //   145: invokevirtual 171	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   148: ldc 175
    //   150: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 183	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: iload_3
    //   164: ifne +23 -> 187
    //   167: aload 4
    //   169: ifnull +16 -> 185
    //   172: aload 4
    //   174: invokevirtual 187	android/graphics/Bitmap:isRecycled	()Z
    //   177: ifne +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 190	android/graphics/Bitmap:recycle	()V
    //   185: aconst_null
    //   186: areturn
    //   187: aload_1
    //   188: astore_2
    //   189: aload 4
    //   191: ifnull -178 -> 13
    //   194: aload_1
    //   195: astore_2
    //   196: aload 4
    //   198: invokevirtual 187	android/graphics/Bitmap:isRecycled	()Z
    //   201: ifne -188 -> 13
    //   204: aload 4
    //   206: invokevirtual 190	android/graphics/Bitmap:recycle	()V
    //   209: aload_1
    //   210: areturn
    //   211: astore_2
    //   212: aconst_null
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_1
    //   217: aload 4
    //   219: astore 5
    //   221: getstatic 41	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   224: ldc 192
    //   226: aload_2
    //   227: invokestatic 195	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_1
    //   231: astore_2
    //   232: aload 4
    //   234: ifnull -221 -> 13
    //   237: aload_1
    //   238: astore_2
    //   239: aload 4
    //   241: invokevirtual 187	android/graphics/Bitmap:isRecycled	()Z
    //   244: ifne -231 -> 13
    //   247: aload 4
    //   249: invokevirtual 190	android/graphics/Bitmap:recycle	()V
    //   252: aload_1
    //   253: areturn
    //   254: astore_1
    //   255: aconst_null
    //   256: astore 5
    //   258: aload 5
    //   260: ifnull +16 -> 276
    //   263: aload 5
    //   265: invokevirtual 187	android/graphics/Bitmap:isRecycled	()Z
    //   268: ifne +8 -> 276
    //   271: aload 5
    //   273: invokevirtual 190	android/graphics/Bitmap:recycle	()V
    //   276: aload_1
    //   277: athrow
    //   278: astore_1
    //   279: goto -21 -> 258
    //   282: astore_2
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -68 -> 217
    //   288: astore_2
    //   289: goto -72 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	TextLayer
    //   0	292	1	paramString	String
    //   0	292	2	paramTextItem	TextLayer.TextItem
    //   109	55	3	bool	boolean
    //   31	217	4	localBitmap1	android.graphics.Bitmap
    //   35	237	5	localBitmap2	android.graphics.Bitmap
    //   46	32	6	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   15	33	211	java/lang/OutOfMemoryError
    //   15	33	254	finally
    //   37	48	278	finally
    //   52	69	278	finally
    //   73	82	278	finally
    //   86	93	278	finally
    //   97	110	278	finally
    //   114	163	278	finally
    //   221	230	278	finally
    //   37	48	282	java/lang/OutOfMemoryError
    //   52	69	282	java/lang/OutOfMemoryError
    //   73	82	282	java/lang/OutOfMemoryError
    //   86	93	282	java/lang/OutOfMemoryError
    //   97	110	288	java/lang/OutOfMemoryError
    //   114	163	288	java/lang/OutOfMemoryError
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("folderPath should not be null");
    }
    String str = paramString1;
    if (!paramString1.endsWith("/")) {
      str = paramString1 + "/";
    }
    return str + System.currentTimeMillis() + "_" + paramString2;
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        f -= 1;
        f = Math.min(f, 5);
        f = Math.max(f, 4);
        return;
      }
      finally {}
      f += 1;
    }
  }
  
  private boolean e()
  {
    boolean bool = false;
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    if ((str.equalsIgnoreCase("vivo-vivo X6Plus D")) || (str.equalsIgnoreCase("motorola-Nexus 6"))) {
      bool = true;
    }
    SLog.b(jdField_a_of_type_JavaLangString, "isRubbish:" + bool + " brand:" + str);
    return bool;
  }
  
  private void o()
  {
    this.k = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext);
    this.h = 1;
    this.g = 1;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(6.0F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.2F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    d = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
    if ((e == 270) && (e())) {
      e = 540;
    }
  }
  
  public float a(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(paramZoomItem);
    }
    return 0.0F;
  }
  
  public Bundle a()
  {
    Bundle localBundle = super.a();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(new TextParcelData((TextLayer.TextItem)this.jdField_a_of_type_JavaUtilArrayList.get(i1)));
      i1 += 1;
    }
    localBundle.putParcelableArrayList("TextParcelDataList", localArrayList);
    return localBundle;
  }
  
  public DynamicTextItem a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
  }
  
  public DynamicTextItem a(int paramInt)
  {
    return a(null, null, paramInt);
  }
  
  public DynamicTextItem a(TextLayer.LayerParams paramLayerParams, SegmentKeeper paramSegmentKeeper, int paramInt)
  {
    DynamicTextItem localDynamicTextItem = null;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < f) {
      if (paramLayerParams == null) {
        break label87;
      }
    }
    label87:
    for (paramLayerParams = new TextLayer.TextItem(this, paramLayerParams);; paramLayerParams = new TextLayer.TextItem(this))
    {
      paramLayerParams.jdField_a_of_type_Int = paramInt;
      paramLayerParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      if (paramLayerParams.jdField_a_of_type_Int == 0) {
        SegmentKeeper.b(-1L * System.currentTimeMillis());
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramLayerParams);
      localDynamicTextItem = paramLayerParams.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem = paramLayerParams;
      return localDynamicTextItem;
    }
  }
  
  public TextLayer.TextItem a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > f))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem;
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)localIterator.next();
        if ((localTextItem.c()) || (localTextItem.d()))
        {
          Object localObject = a(paramString, localTextItem);
          localObject = new TrackerStickerParam(localTextItem.jdField_a_of_type_AndroidGraphicsPointF.x, localTextItem.jdField_a_of_type_AndroidGraphicsPointF.y, localTextItem.q, localTextItem.r, localTextItem.s, localTextItem.t, localTextItem.u, localTextItem.v, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_b_of_type_Int, (String)localObject, localTextItem.jdField_a_of_type_JavaUtilMap);
          ((TrackerStickerParam)localObject).a(localTextItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a());
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.g = 1;
    this.h = 1;
    this.j = c;
    this.m = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem = null;
    SLog.b(jdField_a_of_type_JavaLangString, "clear over");
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TextLayer.TextItem localTextItem = (TextLayer.TextItem)localIterator.next();
      if (localTextItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) {
        localTextItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPointF.x = (paramInt1 / 2);
    this.jdField_a_of_type_AndroidGraphicsPointF.y = (0.42F * paramInt2);
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b() * 0.04F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator;
    TextLayer.TextItem localTextItem;
    if (this.g == 6)
    {
      if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null) {
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.a(paramCanvas);
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localTextItem = (TextLayer.TextItem)localIterator.next();
        if ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null) && (localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem)) {
          localTextItem.a(paramCanvas);
        }
      }
    }
    if ((this.g == 4) || (this.g == 3)) {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((TextLayer.TextItem)localIterator.next()).a(paramCanvas);
      continue;
      if (this.g == 5)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localTextItem = (TextLayer.TextItem)localIterator.next();
          if (localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem) {
            localTextItem.a(paramCanvas);
          }
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TextLayer.TextItem localTextItem = (TextLayer.TextItem)localIterator.next();
      if ((!localTextItem.c()) && (!localTextItem.d())) {
        localTextItem.a(paramCanvas);
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.a(paramBundle);
    a(paramBundle.getParcelableArrayList("TextParcelDataList"), paramBundle.getBoolean("edit_type_photo"));
  }
  
  public void a(DynamicTextItem paramDynamicTextItem)
  {
    Object localObject;
    if ((paramDynamicTextItem != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)localIterator.next();
        if (!paramDynamicTextItem.equals(localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem)) {
          break label72;
        }
        localObject = localTextItem;
      }
    }
    label72:
    for (;;)
    {
      break;
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
      return;
    }
  }
  
  public void a(TextLayer.LayerListener paramLayerListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener = paramLayerListener;
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      b(4);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        TextLayer.TextItem localTextItem = ((TextParcelData)paramArrayList.next()).a(this);
        if (!paramBoolean)
        {
          localTextItem.b(true);
          localTextItem.jdField_a_of_type_Int = 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localTextItem);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= f);
    }
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b(jdField_a_of_type_JavaLangString, "setKeyboardState:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      super.k();
      return;
      b(4);
    }
  }
  
  public boolean a()
  {
    return this.g == 1;
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((TextLayer.TextItem)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public boolean a(android.graphics.Bitmap paramBitmap, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: getstatic 41	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: new 161	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 549
    //   16: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload 4
    //   21: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 183	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_1
    //   31: ifnonnull +15 -> 46
    //   34: getstatic 41	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/TextLayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: ldc_w 551
    //   40: invokestatic 183	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: iload 5
    //   45: ireturn
    //   46: aconst_null
    //   47: astore 8
    //   49: aconst_null
    //   50: astore 6
    //   52: aconst_null
    //   53: astore 7
    //   55: new 553	java/io/File
    //   58: dup
    //   59: aload 4
    //   61: invokespecial 554	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 9
    //   66: aload 6
    //   68: astore 4
    //   70: aload 9
    //   72: invokevirtual 557	java/io/File:exists	()Z
    //   75: ifne +13 -> 88
    //   78: aload 6
    //   80: astore 4
    //   82: aload 9
    //   84: invokevirtual 560	java/io/File:createNewFile	()Z
    //   87: pop
    //   88: aload 6
    //   90: astore 4
    //   92: new 562	java/io/FileOutputStream
    //   95: dup
    //   96: aload 9
    //   98: invokespecial 565	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore 6
    //   103: aload_1
    //   104: aload_2
    //   105: iload_3
    //   106: aload 6
    //   108: invokevirtual 569	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: iconst_1
    //   113: istore 5
    //   115: aload 6
    //   117: ifnull -74 -> 43
    //   120: aload 6
    //   122: invokevirtual 572	java/io/FileOutputStream:close	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 575	java/io/IOException:printStackTrace	()V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_2
    //   135: aload 7
    //   137: astore_1
    //   138: aload_1
    //   139: astore 4
    //   141: aload_2
    //   142: invokevirtual 576	java/io/FileNotFoundException:printStackTrace	()V
    //   145: aload_1
    //   146: ifnull -103 -> 43
    //   149: aload_1
    //   150: invokevirtual 572	java/io/FileOutputStream:close	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 575	java/io/IOException:printStackTrace	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aload 8
    //   165: astore_1
    //   166: aload_1
    //   167: astore 4
    //   169: aload_2
    //   170: invokevirtual 575	java/io/IOException:printStackTrace	()V
    //   173: aload_1
    //   174: ifnull -131 -> 43
    //   177: aload_1
    //   178: invokevirtual 572	java/io/FileOutputStream:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 575	java/io/IOException:printStackTrace	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: astore_1
    //   191: aload 4
    //   193: ifnull +8 -> 201
    //   196: aload 4
    //   198: invokevirtual 572	java/io/FileOutputStream:close	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 575	java/io/IOException:printStackTrace	()V
    //   208: goto -7 -> 201
    //   211: astore_1
    //   212: aload 6
    //   214: astore 4
    //   216: goto -25 -> 191
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: goto -57 -> 166
    //   226: astore_2
    //   227: aload 6
    //   229: astore_1
    //   230: goto -92 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	TextLayer
    //   0	233	1	paramBitmap	android.graphics.Bitmap
    //   0	233	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	233	3	paramInt	int
    //   0	233	4	paramString	String
    //   1	113	5	bool	boolean
    //   50	178	6	localFileOutputStream	java.io.FileOutputStream
    //   53	83	7	localObject1	Object
    //   47	117	8	localObject2	Object
    //   64	33	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   120	125	127	java/io/IOException
    //   70	78	134	java/io/FileNotFoundException
    //   82	88	134	java/io/FileNotFoundException
    //   92	103	134	java/io/FileNotFoundException
    //   149	153	155	java/io/IOException
    //   70	78	162	java/io/IOException
    //   82	88	162	java/io/IOException
    //   92	103	162	java/io/IOException
    //   177	181	183	java/io/IOException
    //   70	78	190	finally
    //   82	88	190	finally
    //   92	103	190	finally
    //   141	145	190	finally
    //   169	173	190	finally
    //   196	201	203	java/io/IOException
    //   103	112	211	finally
    //   103	112	219	java/io/IOException
    //   103	112	226	java/io/FileNotFoundException
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1;
    int i2;
    if (b())
    {
      i1 = (int)paramMotionEvent.getY();
      i2 = Math.abs(i1 - this.l);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, false);
      bool = true;
      return bool;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
      j();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.b();
      this.l = i1;
      continue;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.c();
      continue;
      if (this.g == 3) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.c();
      }
      if (i2 > d)
      {
        b(3);
        continue;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.c();
        }
        a(this, false);
        n();
        if (i2 < d) {
          b();
        } else if (this.g == 3) {
          b(4);
        }
      }
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null))
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
  }
  
  public void b(int paramInt)
  {
    SLog.b(jdField_a_of_type_JavaLangString, "setMode:" + paramInt + ",preMode:" + this.h);
    this.h = this.g;
    this.g = paramInt;
    if (paramInt == 4) {
      n();
    }
    super.k();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      SLog.e(jdField_a_of_type_JavaLangString, "setTextOffset x:" + paramInt1 + "y=" + paramInt2);
      return;
    }
    SLog.b(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt1 + "y=" + paramInt2);
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public void b(DynamicTextItem paramDynamicTextItem)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.u = paramDynamicTextItem.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.v = paramDynamicTextItem.b();
    }
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null)
    {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null)
      {
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.q = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.q;
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.b = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.q;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    b(5);
    if (paramBoolean) {
      c();
    }
  }
  
  public boolean b()
  {
    return (this.g == 4) || (this.g == 3);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (b())
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(0);
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i1 >= 0)
      {
        paramMotionEvent = (TextLayer.TextItem)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((paramMotionEvent != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (paramMotionEvent.d()) && (!paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.c())) {}
        while (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, f1, f2, false))
        {
          i1 -= 1;
          break;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem = paramMotionEvent;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
      }
      return bool;
    }
  }
  
  public void c()
  {
    if (!a())
    {
      b(6);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null)
      {
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem = new TextLayer.TextItem(this, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.a();
        TextLayer.TextItem.a(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
      }
    }
    while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerListener.a(1.0F);
  }
  
  public boolean c()
  {
    return (this.n > 0) && (this.o > 0);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    }
  }
  
  public void e()
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject2).next();
        if ((localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
          ((List)localObject1).add(localTextItem);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject2);
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem = null;
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null)
    {
      b(6);
      TextLayer.TextItem.b(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.c();
      SLog.b(jdField_a_of_type_JavaLangString, "delete " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.g = 1;
      this.h = 1;
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, false);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)localIterator.next();
        if (localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, false);
        }
      }
    }
    k();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.a())) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer
 * JD-Core Version:    0.7.0.1
 */