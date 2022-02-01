package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.action.ServiceEvaluateCallbackAction;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasView
  extends CoverView
{
  public static final String ACTION_ARC = "arc";
  public static final String ACTION_CLIP = "clip";
  public static final String ACTION_CLOSEPATH = "closePath";
  public static final String ACTION_CLRAERECT = "clearRect";
  public static final String ACTION_CREATE_PATTERN = "createPattern";
  public static final String ACTION_DRAWIMAGE = "drawImage";
  public static final String ACTION_FILLPATH = "fillPath";
  public static final String ACTION_FILLTEXT = "fillText";
  public static final String ACTION_LINER = "linear";
  public static final String ACTION_LINETO = "lineTo";
  public static final String ACTION_MOVETO = "moveTo";
  public static final String ACTION_PUT_IMAGE_DATA = "canvasPutImageData";
  public static final String ACTION_QBEZIER_CURVETO = "bezierCurveTo";
  public static final String ACTION_QUADRATIC_CURVETO = "quadraticCurveTo";
  public static final String ACTION_RADIAL = "radial";
  public static final String ACTION_RECT = "rect";
  public static final String ACTION_RESTORE = "restore";
  public static final String ACTION_ROTATE = "rotate";
  public static final String ACTION_SAVE = "save";
  public static final String ACTION_SCALE = "scale";
  public static final String ACTION_SETGLOBALCOMPOSITEOPERATION = "setGlobalCompositeOperation";
  public static final String ACTION_SET_BASELINE = "setTextBaseline";
  public static final String ACTION_SET_FILLSTYLE = "setFillStyle";
  public static final String ACTION_SET_FONT_FAMILY = "setFontFamily";
  public static final String ACTION_SET_FONT_SIZE = "setFontSize";
  public static final String ACTION_SET_FONT_STYLE = "setFontStyle";
  public static final String ACTION_SET_FONT_WEIGHT = "setFontWeight";
  public static final String ACTION_SET_GLOBALALPHA = "setGlobalAlpha";
  public static final String ACTION_SET_LINECAP = "setLineCap";
  public static final String ACTION_SET_LINEDASH = "setLineDash";
  public static final String ACTION_SET_LINEJOIN = "setLineJoin";
  public static final String ACTION_SET_LINEWIDTH = "setLineWidth";
  public static final String ACTION_SET_MITERLIMIT = "setMiterLimit";
  public static final String ACTION_SET_SHADOW = "setShadow";
  public static final String ACTION_SET_STROKESTYLE = "setStrokeStyle";
  public static final String ACTION_SET_TEXTALIGN = "setTextAlign";
  public static final String ACTION_SET_TRANSFORM = "setTransform";
  public static final String ACTION_STROKEPATH = "strokePath";
  public static final String ACTION_STROKETEXT = "strokeText";
  public static final String ACTION_TRANSFORM = "transform";
  public static final String ACTION_TRANSLATE = "translate";
  public static final String CUSTOM_ACTION_FILL = "fill";
  private static final int DEFAULT_PAINT_COLOR = -16777216;
  private static final int INVALIDATE_TIME_INTERVAL = 16;
  public static final String KEY_CALLBACK_ID = "callbackId";
  public static final String KEY_DATA = "data";
  public static final String KEY_METHOD = "method";
  private static final double REQUEST_IMAGE_MAX_SAFE_SIZE = 8985600.0D;
  private static final String TAG = "CanvasView";
  private HashMap<String, CanvasView.DrawAction> drawActions = new HashMap();
  private ApkgInfo mApkgInfo;
  private int mBitmapH = 0;
  private int mBitmapW = 0;
  private String mCanvasData;
  private int mCanvasId;
  private JSONArray mCurrentDrawActions;
  private float mDensity;
  private Boolean mDisableScroll;
  private final LinkedBlockingQueue<CanvasView.DrawActionCommand> mDrawActionCommandQueue = new LinkedBlockingQueue();
  private int mFillColorAlpha = 255;
  private Paint mFillPaint;
  private int mGlobalAlpha = 255;
  private boolean mHasGuesture;
  private boolean mIsAttachedToWindow;
  private long mLastInvalidateTime;
  float mLastOnTouchMoveX;
  float mLastOnTouchMoveY;
  private IMiniAppContext mMiniAppContext;
  private final NativeViewContainer mNc;
  private RectF mOffScreenCacheRect;
  Path mPath;
  private long mPendingDrawTaskTime;
  private boolean mRepeatX = false;
  private boolean mRepeatY = false;
  private int mSaveBitmapH;
  private int mSaveBitmapW;
  private int mSaveFillColorAlpha;
  private Paint mSaveFillPaint;
  private int mSaveGlobalAlpha;
  private boolean mSaveRepeatX;
  private boolean mSaveRepeatY;
  private int mSaveStrokeColorAlpha;
  private Paint mSaveStrokePaint;
  private String mSaveTextBaseline;
  private IJsService mService;
  private int mStrokeColorAlpha = 255;
  private Paint mStrokePaint;
  private String mTextBaseline = "normal";
  private boolean mUseHardwareAccelerate;
  Boolean mVivoEnableSplit;
  
  public CanvasView(IMiniAppContext paramIMiniAppContext, NativeViewContainer paramNativeViewContainer, IJsService paramIJsService, ApkgInfo paramApkgInfo, String paramString, int paramInt, boolean paramBoolean1, Boolean paramBoolean, boolean paramBoolean2)
  {
    super(paramIMiniAppContext.getContext());
    this.mMiniAppContext = paramIMiniAppContext;
    this.mDensity = DisplayUtil.getDensity(paramIMiniAppContext.getContext());
    this.mService = paramIJsService;
    this.mNc = paramNativeViewContainer;
    this.mApkgInfo = paramApkgInfo;
    this.mCanvasId = paramInt;
    this.mFillPaint = new Paint(1);
    this.mFillPaint.setStyle(Paint.Style.FILL);
    this.mFillPaint.setColor(-16777216);
    this.mStrokePaint = new Paint(1);
    this.mStrokePaint.setStyle(Paint.Style.STROKE);
    this.mStrokePaint.setColor(-16777216);
    this.mDisableScroll = paramBoolean;
    this.mHasGuesture = paramBoolean2;
    this.mCanvasData = paramString;
    setBackgroundResource(17170445);
    super.setIgnoreTouchEventToJS(true);
    initDrawActions();
  }
  
  private RectF addPathRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    RectF localRectF = new RectF();
    if (((!this.mRepeatX) && (!this.mRepeatY)) || ((this.mBitmapW == 0) && (this.mBitmapH == 0)))
    {
      localRectF.left = paramFloat1;
      localRectF.top = paramFloat2;
      localRectF.right = (localRectF.left + paramFloat3);
      localRectF.bottom = (localRectF.top + paramFloat4);
    }
    else
    {
      if (this.mRepeatX) {
        paramFloat1 = 0.0F;
      }
      localRectF.left = paramFloat1;
      if (this.mRepeatY) {
        paramFloat2 = 0.0F;
      }
      localRectF.top = paramFloat2;
      if (this.mRepeatX) {
        paramFloat1 = localRectF.left + paramFloat3;
      } else {
        paramFloat1 = this.mBitmapW;
      }
      localRectF.right = paramFloat1;
      if (this.mRepeatY) {
        paramFloat1 = localRectF.top + paramFloat4;
      } else {
        paramFloat1 = this.mBitmapH;
      }
      localRectF.bottom = paramFloat1;
    }
    this.mPath.addRect(localRectF, Path.Direction.CW);
    return localRectF;
  }
  
  private void clearRect(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    paramCanvas.save();
    float f4 = mpx2px(paramJSONArray.optDouble(0, 0.0D));
    float f6 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f3 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f5 = mpx2px(paramJSONArray.optDouble(3, 0.0D));
    float f2 = f4;
    float f1 = f3;
    if (f3 <= 0.0F)
    {
      f2 = f4 + f3;
      f1 = -f3;
    }
    f4 = f6;
    f3 = f5;
    if (f5 <= 0.0F)
    {
      f4 = f6 + f5;
      f3 = -f5;
    }
    paramJSONArray = new RectF();
    paramJSONArray.left = f2;
    paramJSONArray.top = f4;
    paramJSONArray.right = (paramJSONArray.left + f1);
    paramJSONArray.bottom = (paramJSONArray.top + f3);
    paramCanvas.clipRect(paramJSONArray);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.restore();
  }
  
  /* Error */
  private void compressAndSaveBitmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Bitmap paramBitmap1, JSONObject paramJSONObject, Bitmap paramBitmap2, String paramString, boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    // Byte code:
    //   0: new 524	android/graphics/Canvas
    //   3: dup
    //   4: aload 7
    //   6: invokespecial 558	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   9: astore 20
    //   11: aload 20
    //   13: new 560	android/graphics/PaintFlagsDrawFilter
    //   16: dup
    //   17: iconst_0
    //   18: iconst_3
    //   19: invokespecial 563	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   22: invokevirtual 567	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   25: new 569	android/graphics/Rect
    //   28: dup
    //   29: iconst_0
    //   30: iconst_0
    //   31: iload 5
    //   33: iload 6
    //   35: invokespecial 572	android/graphics/Rect:<init>	(IIII)V
    //   38: astore 21
    //   40: aload_0
    //   41: aload 8
    //   43: ldc_w 574
    //   46: dconst_0
    //   47: invokevirtual 579	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   50: invokevirtual 583	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   53: istore 18
    //   55: aload_0
    //   56: aload 8
    //   58: ldc_w 585
    //   61: dconst_0
    //   62: invokevirtual 579	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   65: invokevirtual 583	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   68: istore 19
    //   70: aload 20
    //   72: aload 9
    //   74: new 569	android/graphics/Rect
    //   77: dup
    //   78: iload 18
    //   80: iload 19
    //   82: iload 18
    //   84: iload_1
    //   85: iadd
    //   86: iload 19
    //   88: iload_2
    //   89: iadd
    //   90: invokespecial 572	android/graphics/Rect:<init>	(IIII)V
    //   93: aload 21
    //   95: aconst_null
    //   96: invokevirtual 589	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   99: aload_0
    //   100: invokespecial 593	com/tencent/qqmini/miniapp/widget/CanvasView:getMiniAppContext	()Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   103: ldc_w 595
    //   106: invokeinterface 599 2 0
    //   111: checkcast 595	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   114: aload 10
    //   116: invokevirtual 603	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 20
    //   121: aload 20
    //   123: invokestatic 609	com/tencent/qqmini/sdk/core/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   126: astore 10
    //   128: new 611	java/io/FileOutputStream
    //   131: dup
    //   132: aload 10
    //   134: invokespecial 614	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   137: astore 10
    //   139: iload 5
    //   141: iload 6
    //   143: imul
    //   144: iload_3
    //   145: idiv
    //   146: iload 4
    //   148: idiv
    //   149: i2f
    //   150: fstore 17
    //   152: iload 11
    //   154: ifeq +53 -> 207
    //   157: aload 8
    //   159: ldc_w 616
    //   162: dconst_1
    //   163: invokevirtual 579	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   166: dstore 13
    //   168: fload 17
    //   170: f2d
    //   171: dstore 15
    //   173: dload 15
    //   175: invokestatic 622	java/lang/Double:isNaN	(D)Z
    //   178: pop
    //   179: dload 13
    //   181: dload 15
    //   183: ddiv
    //   184: dstore 13
    //   186: aload 7
    //   188: getstatic 628	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   191: dload 13
    //   193: ldc2_w 629
    //   196: dmul
    //   197: d2i
    //   198: aload 10
    //   200: invokevirtual 636	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   203: pop
    //   204: goto +50 -> 254
    //   207: aload 8
    //   209: ldc_w 638
    //   212: dconst_1
    //   213: invokevirtual 579	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   216: dstore 13
    //   218: fload 17
    //   220: f2d
    //   221: dstore 15
    //   223: dload 15
    //   225: invokestatic 622	java/lang/Double:isNaN	(D)Z
    //   228: pop
    //   229: dload 13
    //   231: dload 15
    //   233: ddiv
    //   234: dstore 13
    //   236: aload 7
    //   238: getstatic 641	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   241: dload 13
    //   243: ldc2_w 629
    //   246: dmul
    //   247: d2i
    //   248: aload 10
    //   250: invokevirtual 636	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   253: pop
    //   254: new 576	org/json/JSONObject
    //   257: dup
    //   258: invokespecial 642	org/json/JSONObject:<init>	()V
    //   261: astore 7
    //   263: aload 7
    //   265: ldc_w 644
    //   268: aload_0
    //   269: invokespecial 593	com/tencent/qqmini/miniapp/widget/CanvasView:getMiniAppContext	()Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   272: ldc_w 595
    //   275: invokeinterface 599 2 0
    //   280: checkcast 595	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   283: aload 20
    //   285: invokevirtual 647	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokevirtual 651	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   291: pop
    //   292: aload 12
    //   294: aload 7
    //   296: invokevirtual 657	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   299: pop
    //   300: goto +21 -> 321
    //   303: astore 7
    //   305: goto +5 -> 310
    //   308: astore 7
    //   310: aload 7
    //   312: invokevirtual 660	org/json/JSONException:printStackTrace	()V
    //   315: aload 12
    //   317: invokevirtual 664	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   320: pop
    //   321: aload 10
    //   323: invokevirtual 667	java/io/FileOutputStream:flush	()V
    //   326: aload 10
    //   328: invokevirtual 670	java/io/FileOutputStream:close	()V
    //   331: aload 9
    //   333: ifnull +16 -> 349
    //   336: aload 9
    //   338: invokevirtual 674	android/graphics/Bitmap:isRecycled	()Z
    //   341: ifne +8 -> 349
    //   344: aload 9
    //   346: invokevirtual 677	android/graphics/Bitmap:recycle	()V
    //   349: return
    //   350: astore 7
    //   352: aload 10
    //   354: astore 8
    //   356: goto +8 -> 364
    //   359: astore 7
    //   361: aconst_null
    //   362: astore 8
    //   364: aload 8
    //   366: ifnull +13 -> 379
    //   369: aload 8
    //   371: invokevirtual 667	java/io/FileOutputStream:flush	()V
    //   374: aload 8
    //   376: invokevirtual 670	java/io/FileOutputStream:close	()V
    //   379: aload 9
    //   381: ifnull +16 -> 397
    //   384: aload 9
    //   386: invokevirtual 674	android/graphics/Bitmap:isRecycled	()Z
    //   389: ifne +8 -> 397
    //   392: aload 9
    //   394: invokevirtual 677	android/graphics/Bitmap:recycle	()V
    //   397: aload 7
    //   399: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	CanvasView
    //   0	400	1	paramInt1	int
    //   0	400	2	paramInt2	int
    //   0	400	3	paramInt3	int
    //   0	400	4	paramInt4	int
    //   0	400	5	paramInt5	int
    //   0	400	6	paramInt6	int
    //   0	400	7	paramBitmap1	Bitmap
    //   0	400	8	paramJSONObject	JSONObject
    //   0	400	9	paramBitmap2	Bitmap
    //   0	400	10	paramString	String
    //   0	400	11	paramBoolean	boolean
    //   0	400	12	paramNativeViewRequestEvent	NativeViewRequestEvent
    //   166	76	13	d1	double
    //   171	61	15	d2	double
    //   150	69	17	f	float
    //   53	33	18	i	int
    //   68	22	19	j	int
    //   9	275	20	localObject	Object
    //   38	56	21	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   292	300	303	org/json/JSONException
    //   254	292	308	org/json/JSONException
    //   139	152	350	finally
    //   157	168	350	finally
    //   186	204	350	finally
    //   207	218	350	finally
    //   236	254	350	finally
    //   254	292	350	finally
    //   292	300	350	finally
    //   310	321	350	finally
    //   128	139	359	finally
  }
  
  private Bitmap decodeImage(String paramString, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions, int paramInt5)
  {
    paramOptions.inDither = true;
    Object localObject = null;
    Bitmap localBitmap = null;
    if ((paramInt3 > 0) && (paramInt4 > 0))
    {
      localObject = localBitmap;
      try
      {
        BitmapRegionDecoder localBitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramString, false);
        localObject = localBitmap;
        paramString = localBitmapRegionDecoder.decodeRegion(getCropRect(paramInt1, paramInt2, paramInt3, paramInt4, paramOptions, paramInt5), paramOptions);
        localObject = paramString;
        localBitmapRegionDecoder.recycle();
      }
      catch (Exception paramString)
      {
        paramOptions = new StringBuilder();
        paramOptions.append("bitmapRegionDecoder newInstance exception: ");
        paramOptions.append(Log.getStackTraceString(paramString));
        QMLog.e("CanvasView", paramOptions.toString());
        paramString = (String)localObject;
      }
      return paramString;
    }
    paramOptions.inJustDecodeBounds = false;
    float f2 = paramOptions.outWidth;
    float f1 = paramOptions.outHeight;
    float f3 = (float)Math.sqrt(paramFloat1 * paramFloat2 / paramOptions.outWidth / paramOptions.outHeight);
    paramFloat2 = f2;
    paramFloat1 = f1;
    if (f3 < 1.0F)
    {
      paramFloat2 = f2 * f3;
      paramFloat1 = f1 * f3;
    }
    double d1;
    double d2;
    if (ImageUtil.isPngFile(paramString))
    {
      paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      d1 = paramFloat2;
      Double.isNaN(d1);
      d1 = 8985600.0D / d1;
      d2 = paramFloat1;
      Double.isNaN(d2);
      d1 = Math.sqrt(d1 / d2 / 4.0D);
    }
    else
    {
      paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      d1 = paramFloat2;
      Double.isNaN(d1);
      d1 = 8985600.0D / d1;
      d2 = paramFloat1;
      Double.isNaN(d2);
      d1 = Math.sqrt(d1 / d2 / 2.0D);
    }
    f1 = (float)d1;
    if (f1 < 1.0F) {
      paramOptions.inSampleSize = ImageUtil.calculateInSampleSize(paramOptions, paramFloat2 * f1, paramFloat1 * f1);
    }
    try
    {
      localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (Throwable localThrowable1)
    {
      label342:
      break label342;
    }
    QMLog.w("CanvasView", "getLocalBitmap error with inSampleSize error!try again with lower quality!");
    for (;;)
    {
      try
      {
        localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
        localObject = localBitmap;
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      QMLog.w("CanvasView", "getLocalBitmap error! try again with lower quality!");
    }
    return decodeImageQuarter(paramString, paramOptions, (Bitmap)localObject);
  }
  
  private Bitmap decodeImageQuarter(String paramString, BitmapFactory.Options paramOptions, Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null)
    {
      if (paramOptions.inSampleSize > 0) {
        paramOptions.inSampleSize *= 2;
      } else {
        paramOptions.inSampleSize = 2;
      }
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, paramOptions);
        return paramString;
      }
      catch (Throwable paramString)
      {
        QMLog.e("CanvasView", "getLocalBitmap 2nd time error!", paramString);
        localBitmap = null;
      }
    }
    return localBitmap;
  }
  
  private void doDraw(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      String str = localJSONObject.optString("method");
      JSONArray localJSONArray = localJSONObject.optJSONArray("data");
      CanvasView.DrawAction localDrawAction = (CanvasView.DrawAction)this.drawActions.get(str);
      if (localDrawAction != null) {
        localDrawAction.doAction(paramCanvas, localJSONObject, str, localJSONArray);
      }
      i += 1;
    }
    this.mFillPaint.setShader(null);
    this.mFillPaint.setColor(-16777216);
    this.mFillPaint.clearShadowLayer();
    this.mStrokePaint.setShader(null);
    this.mStrokePaint.setColor(-16777216);
    this.mStrokePaint.clearShadowLayer();
  }
  
  private void doSaveBitmap(boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    Bitmap localBitmap = getCacheBitmapFromView(this, paramBoolean);
    ThreadManager.getSubThreadHandler().post(new CanvasView.3(this, localBitmap, paramNativeViewRequestEvent, paramJSONObject, paramBoolean, paramString));
  }
  
  private void drawBitmap(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions, int paramInt5)
  {
    if ((paramFloat3 > 0.0F) && (paramFloat4 > 0.0F))
    {
      paramOptions = decodeImage(paramString, paramFloat3, paramFloat4, paramInt1, paramInt2, paramInt3, paramInt4, paramOptions, paramInt5);
      if (paramOptions != null)
      {
        paramString = paramOptions;
        if (paramInt5 != 0) {
          paramString = ImageUtil.rotaingImageView(paramInt5, paramOptions);
        }
        paramOptions = new RectF();
        paramOptions.left = mpx2px(paramFloat1);
        paramOptions.top = mpx2px(paramFloat2);
        paramOptions.right = (paramOptions.left + mpx2px(paramFloat3));
        paramOptions.bottom = (paramOptions.top + mpx2px(paramFloat4));
        paramCanvas.drawBitmap(paramString, null, paramOptions, null);
        paramString.recycle();
      }
    }
  }
  
  private void drawImage(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    String str2 = paramJSONArray.optString(0);
    String str1 = str2;
    if (!StringUtil.isEmpty(str2)) {
      str1 = ((MiniAppFileManager)getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(str2);
    }
    float f5;
    float f6;
    float f3;
    float f4;
    int j;
    int k;
    int m;
    int n;
    int i1;
    float f1;
    float f2;
    if (!StringUtil.isEmpty(str1))
    {
      f5 = (float)paramJSONArray.optDouble(1, 0.0D);
      f6 = (float)paramJSONArray.optDouble(2, 0.0D);
      f3 = (float)paramJSONArray.optDouble(3, 0.0D);
      f4 = (float)paramJSONArray.optDouble(4, 0.0D);
      j = (int)paramJSONArray.optDouble(5, 0.0D);
      k = (int)paramJSONArray.optDouble(6, 0.0D);
      m = (int)paramJSONArray.optDouble(7, 0.0D);
      n = (int)paramJSONArray.optDouble(8, 0.0D);
      paramJSONArray = new BitmapFactory.Options();
      i1 = ImageUtil.getExifOrientation(str1);
      f1 = f3;
      try
      {
        paramJSONArray.inJustDecodeBounds = true;
        f1 = f3;
        BitmapFactory.decodeFile(str1, paramJSONArray);
        if (f3 <= 0.0F) {
          break label307;
        }
        f1 = f3;
        f2 = f4;
        if (f4 > 0.0F) {
          break label281;
        }
      }
      catch (Exception localException)
      {
        int i;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("calculate image size error! ");
        localStringBuilder.append(Log.getStackTraceString(localException));
        QMLog.e("CanvasView", localStringBuilder.toString());
        f2 = f4;
      }
      f1 = f3;
      f2 = paramJSONArray.outWidth;
      f1 = f2;
      i = paramJSONArray.outHeight;
      f1 = f2;
    }
    for (;;)
    {
      f1 = f3;
      f2 = paramJSONArray.outHeight;
      f1 = f2;
      i = paramJSONArray.outWidth;
      f1 = f2;
      f2 = i;
      for (;;)
      {
        StringBuilder localStringBuilder;
        label281:
        drawBitmap(paramCanvas, str1, f5, f6, f1, f2, j, k, m, n, paramJSONArray, i1);
        return;
        label307:
        if ((m <= 0) || (n <= 0)) {
          break;
        }
        f1 = m;
        f2 = n;
      }
      if (i1 != 90) {
        if (i1 != 270) {
          break;
        }
      }
    }
  }
  
  private Bitmap getCacheBitmapFromView(View paramView, boolean paramBoolean)
  {
    Bitmap.Config localConfig = null;
    Object localObject2 = null;
    Object localObject1 = localConfig;
    try
    {
      paramView.setDrawingCacheEnabled(true);
      localObject1 = localConfig;
      paramView.buildDrawingCache(true);
      localObject1 = localConfig;
      Bitmap localBitmap = paramView.getDrawingCache();
      if (localBitmap != null)
      {
        localObject1 = localConfig;
        localObject2 = Bitmap.createBitmap(localBitmap);
      }
      localObject1 = localObject2;
      paramView.setDrawingCacheEnabled(false);
      localObject1 = localObject2;
      paramView.buildDrawingCache(false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i = paramView.getWidth();
        localObject1 = localObject2;
        int j = paramView.getHeight();
        if (paramBoolean)
        {
          localObject1 = localObject2;
          localConfig = Bitmap.Config.ARGB_8888;
        }
        else
        {
          localObject1 = localObject2;
          localConfig = Bitmap.Config.RGB_565;
        }
        localObject1 = localObject2;
        localObject2 = Bitmap.createBitmap(i, j, localConfig);
        localObject1 = localObject2;
        paramView.draw(new Canvas((Bitmap)localObject2));
        return localObject2;
      }
    }
    catch (Throwable paramView)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCacheBitmapFromView failed: ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(paramView));
      QMLog.e("CanvasView", ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private int getColor(JSONArray paramJSONArray)
  {
    try
    {
      int i = Color.argb(paramJSONArray.optInt(3, 0), paramJSONArray.optInt(0, 0), paramJSONArray.optInt(1, 0), paramJSONArray.optInt(2, 0));
      return i;
    }
    catch (Exception paramJSONArray)
    {
      QMLog.e("CanvasView", Log.getStackTraceString(paramJSONArray));
    }
    return 0;
  }
  
  private float getCompressRadio(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    double d1;
    double d2;
    if (paramBoolean)
    {
      d1 = paramInt1;
      Double.isNaN(d1);
      d1 = 8985600.0D / d1;
      d2 = paramInt2;
      Double.isNaN(d2);
      d1 = Math.sqrt(d1 / d2 / 2.0D);
    }
    else
    {
      d1 = paramInt1;
      Double.isNaN(d1);
      d1 = 8985600.0D / d1;
      d2 = paramInt2;
      Double.isNaN(d2);
      d1 = Math.sqrt(d1 / d2 / 2.0D);
    }
    return (float)d1;
  }
  
  private Bitmap.Config getConfig(boolean paramBoolean)
  {
    if (paramBoolean) {
      return Bitmap.Config.ARGB_8888;
    }
    return Bitmap.Config.RGB_565;
  }
  
  private Rect getCropRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions, int paramInt5)
  {
    Rect localRect = new Rect();
    if (paramInt5 == 90)
    {
      localRect.left = paramInt2;
      localRect.top = (paramOptions.outHeight - paramInt1 - paramInt3);
      localRect.right = (localRect.left + paramInt4);
      localRect.bottom = (localRect.top + paramInt3);
      return localRect;
    }
    if (paramInt5 == 180)
    {
      localRect.left = (paramOptions.outWidth - paramInt1 - paramInt3);
      localRect.top = (paramOptions.outHeight - paramInt2 - paramInt4);
      localRect.right = (localRect.left + paramInt3);
      localRect.bottom = (localRect.top + paramInt4);
      return localRect;
    }
    if (paramInt5 == 270)
    {
      localRect.left = (paramOptions.outWidth - paramInt2 - paramInt4);
      localRect.top = paramInt1;
      localRect.right = (localRect.left + paramInt4);
      localRect.bottom = (localRect.top + paramInt3);
      return localRect;
    }
    localRect.left = paramInt1;
    localRect.top = paramInt2;
    localRect.right = (localRect.left + paramInt3);
    localRect.bottom = (localRect.top + paramInt4);
    return localRect;
  }
  
  private Paint getCurrentPaint(String paramString)
  {
    if ((paramString != null) && (paramString.contains("fill")))
    {
      i = this.mGlobalAlpha;
      if ((i != -1) && (i < this.mFillColorAlpha)) {
        this.mFillPaint.setAlpha(i);
      } else {
        this.mFillPaint.setAlpha(this.mFillColorAlpha);
      }
      return this.mFillPaint;
    }
    int i = this.mGlobalAlpha;
    if ((i != -1) && (i < this.mStrokeColorAlpha)) {
      this.mStrokePaint.setAlpha(i);
    } else {
      this.mStrokePaint.setAlpha(this.mStrokeColorAlpha);
    }
    return this.mStrokePaint;
  }
  
  private int getFontStyleItalic(Typeface paramTypeface)
  {
    if ((paramTypeface != null) && (paramTypeface.isBold())) {
      return 3;
    }
    return 2;
  }
  
  private int getFontStyleNormal(Typeface paramTypeface)
  {
    if ((paramTypeface != null) && (paramTypeface.isBold())) {
      return 1;
    }
    return 0;
  }
  
  private int getFontWeightBoldStyle(Typeface paramTypeface)
  {
    if ((paramTypeface != null) && (paramTypeface.isItalic())) {
      return 3;
    }
    return 1;
  }
  
  private int getFontWeightNormalStyle(Typeface paramTypeface)
  {
    if ((paramTypeface != null) && (paramTypeface.isItalic())) {
      return 2;
    }
    return 0;
  }
  
  private IMiniAppContext getMiniAppContext()
  {
    return this.mNc.getPageWebviewContainer().getMiniAppContext();
  }
  
  private void handleTouchCancel(MotionEvent paramMotionEvent, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("x", px2mpx(paramMotionEvent.getX()));
      localJSONObject.put("y", px2mpx(paramMotionEvent.getY()));
      localJSONObject.put("id", paramMotionEvent.getPointerId(0));
      localJSONArray.put(localJSONObject);
      paramJSONObject.put("data", this.mCanvasData);
      paramJSONObject.put("touches", localJSONArray);
      evaluateSubcribeJS("onTouchCancel", paramJSONObject.toString());
      return;
    }
    catch (JSONException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  private void handleTouchEvent(MotionEvent paramMotionEvent, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("x", px2mpx(paramMotionEvent.getX()));
      localJSONObject.put("y", px2mpx(paramMotionEvent.getY()));
      localJSONObject.put("id", paramMotionEvent.getPointerId(0));
      paramJSONObject.put("data", this.mCanvasData);
      paramJSONObject.put("touch", localJSONObject);
      evaluateSubcribeJS(paramString, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  private void handleTouchMove(MotionEvent paramMotionEvent, JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int j = paramMotionEvent.getPointerCount();
        i = 0;
        if (i < j)
        {
          float f1 = paramMotionEvent.getX(i);
          float f2 = paramMotionEvent.getY(i);
          if ((Math.abs(f1 - this.mLastOnTouchMoveX) < 0.5D) && (Math.abs(f2 - this.mLastOnTouchMoveY) < 0.5D)) {
            break label204;
          }
          this.mLastOnTouchMoveX = f1;
          this.mLastOnTouchMoveY = f2;
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("x", px2mpx(f1));
          localJSONObject.put("y", px2mpx(f2));
          localJSONObject.put("id", paramMotionEvent.getPointerId(i));
          localJSONArray.put(localJSONObject);
          break label204;
        }
        if (localJSONArray.length() > 0)
        {
          paramJSONObject.put("data", this.mCanvasData);
          paramJSONObject.put("touches", localJSONArray);
          evaluateSubcribeJS("onTouchMove", paramJSONObject.toString());
          return;
        }
      }
      catch (JSONException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return;
      label204:
      i += 1;
    }
  }
  
  private void handleTouchPointerEvent(MotionEvent paramMotionEvent, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      int i = paramMotionEvent.getActionIndex();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("x", px2mpx(paramMotionEvent.getX(i)));
      localJSONObject.put("y", px2mpx(paramMotionEvent.getY(i)));
      localJSONObject.put("id", paramMotionEvent.getPointerId(i));
      paramJSONObject.put("data", this.mCanvasData);
      paramJSONObject.put("touch", localJSONObject);
      evaluateSubcribeJS(paramString, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  private void initDrawActions()
  {
    this.drawActions.put("drawImage", new CanvasView.4(this));
    this.drawActions.put("setStrokeStyle", new CanvasView.SetStrokeOrFillStyleAction(this));
    this.drawActions.put("setFillStyle", new CanvasView.SetStrokeOrFillStyleAction(this));
    this.drawActions.put("strokePath", new CanvasView.SetPathOrClipAction(this));
    this.drawActions.put("fillPath", new CanvasView.SetPathOrClipAction(this));
    this.drawActions.put("clip", new CanvasView.SetPathOrClipAction(this));
    this.drawActions.put("setFontSize", new CanvasView.5(this));
    this.drawActions.put("setFontStyle", new CanvasView.6(this));
    this.drawActions.put("setFontWeight", new CanvasView.7(this));
    this.drawActions.put("setFontFamily", new CanvasView.8(this));
    this.drawActions.put("setTextAlign", new CanvasView.9(this));
    this.drawActions.put("fillText", new CanvasView.SetFillOrStrokeTextAction(this));
    this.drawActions.put("strokeText", new CanvasView.SetFillOrStrokeTextAction(this));
    this.drawActions.put("setGlobalAlpha", new CanvasView.10(this));
    this.drawActions.put("restore", new CanvasView.11(this));
    this.drawActions.put("save", new CanvasView.12(this));
    this.drawActions.put("clearRect", new CanvasView.13(this));
    this.drawActions.put("setGlobalCompositeOperation", new CanvasView.14(this));
    this.drawActions.put("rotate", new CanvasView.15(this));
    this.drawActions.put("scale", new CanvasView.16(this));
    this.drawActions.put("translate", new CanvasView.17(this));
    this.drawActions.put("setLineWidth", new CanvasView.18(this));
    this.drawActions.put("setShadow", new CanvasView.19(this));
    this.drawActions.put("setLineCap", new CanvasView.20(this));
    this.drawActions.put("setLineJoin", new CanvasView.21(this));
    this.drawActions.put("setLineDash", new CanvasView.22(this));
    this.drawActions.put("setMiterLimit", new CanvasView.23(this));
    this.drawActions.put("setTransform", new CanvasView.TransformAction(this));
    this.drawActions.put("transform", new CanvasView.TransformAction(this));
    this.drawActions.put("setTextBaseline", new CanvasView.24(this));
    this.drawActions.put("canvasPutImageData", new CanvasView.25(this));
  }
  
  private void pathActionArc(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    float f1 = mpx2px(paramJSONArray2.optDouble(0, 0.0D));
    float f2 = mpx2px(paramJSONArray2.optDouble(1, 0.0D));
    float f4 = mpx2px(paramJSONArray2.optDouble(2, 0.0D));
    double d1 = paramJSONArray2.optDouble(3, 0.0D);
    double d2 = paramJSONArray2.optDouble(4, 0.0D);
    float f3 = (float)(d1 / 3.141592653589793D * 180.0D);
    float f5 = (float)(d2 / 3.141592653589793D * 180.0D);
    boolean bool = paramJSONArray1.optBoolean(5);
    paramJSONArray1 = new RectF(f1 - f4, f2 - f4, f1 + f4, f2 + f4);
    if (bool) {
      f1 = f3 - f5;
    } else {
      f1 = f5 - f3;
    }
    f2 = f1 % 360.0F;
    f1 = f2;
    if (f2 <= 0.0F) {
      f1 = f2 + 360.0F;
    }
    if (this.mPath.isEmpty())
    {
      this.mPath.addArc(paramJSONArray1, f3, f1);
      return;
    }
    Math.cos(d1);
    Math.sin(d1);
    if (Math.abs(Math.abs(f1) - 360.0F) < 1.0E-014D)
    {
      this.mPath.addArc(paramJSONArray1, f3, f1);
      return;
    }
    this.mPath.arcTo(paramJSONArray1, f3, f1);
  }
  
  private void pathActionBezierCurveTo(JSONArray paramJSONArray)
  {
    float f1 = mpx2px(paramJSONArray.optDouble(0, 0.0D));
    float f2 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f3 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f4 = mpx2px(paramJSONArray.optDouble(3, 0.0D));
    float f5 = mpx2px(paramJSONArray.optDouble(4, 0.0D));
    float f6 = mpx2px(paramJSONArray.optDouble(5, 0.0D));
    if (this.mPath.isEmpty()) {
      this.mPath.moveTo(f1, f2);
    }
    this.mPath.cubicTo(f1, f2, f3, f4, f5, f6);
  }
  
  private void pathActionLineTo(JSONArray paramJSONArray)
  {
    float f1 = mpx2px(paramJSONArray.optDouble(0, 0.0D));
    float f2 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    if (this.mPath.isEmpty())
    {
      this.mPath.moveTo(f1, f2);
      return;
    }
    this.mPath.lineTo(f1, f2);
  }
  
  private void pathActionQuadraticCurveTo(JSONArray paramJSONArray)
  {
    float f1 = mpx2px(paramJSONArray.optDouble(0, 0.0D));
    float f2 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f3 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f4 = mpx2px(paramJSONArray.optDouble(3, 0.0D));
    if (this.mPath.isEmpty()) {
      this.mPath.moveTo(f1, f2);
    }
    this.mPath.quadTo(f1, f2, f3, f4);
  }
  
  private void pathActionRect(JSONArray paramJSONArray)
  {
    float f4 = mpx2px(paramJSONArray.optDouble(0, 0.0D));
    float f6 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f3 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f5 = mpx2px(paramJSONArray.optDouble(3, 0.0D));
    float f2 = f4;
    float f1 = f3;
    if (f3 <= 0.0F)
    {
      f2 = f4 + f3;
      f1 = -f3;
    }
    f4 = f6;
    f3 = f5;
    if (f5 <= 0.0F)
    {
      f4 = f6 + f5;
      f3 = -f5;
    }
    addPathRect(f2, f4, f1, f3);
  }
  
  private void processDrawActionCommands()
  {
    boolean bool = this.mUseHardwareAccelerate;
    Object localObject3 = this.mCurrentDrawActions;
    for (CanvasView.DrawActionCommand localDrawActionCommand = (CanvasView.DrawActionCommand)this.mDrawActionCommandQueue.poll(); localDrawActionCommand != null; localDrawActionCommand = (CanvasView.DrawActionCommand)this.mDrawActionCommandQueue.poll())
    {
      if (localDrawActionCommand != null)
      {
        bool = localDrawActionCommand.reverse;
        localObject2 = localDrawActionCommand.drawAction;
      }
      else
      {
        bool = false;
        localObject2 = this.mCurrentDrawActions;
      }
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONArray();
      }
      if (((JSONArray)localObject1).length() == 0) {
        ((JSONArray)localObject1).put(new JSONObject());
      }
      Object localObject2 = localObject1;
      if (bool)
      {
        localObject2 = localObject1;
        if (localObject3 != null) {
          try
          {
            if (((JSONArray)localObject3).length() == 0) {
              localObject2 = localObject1;
            } else {
              localObject2 = JSONUtil.concatArray((JSONArray)localObject3, (JSONArray)localObject1);
            }
          }
          catch (Throwable localThrowable)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("process draw actions error! ");
            ((StringBuilder)localObject2).append(Log.getStackTraceString(localThrowable));
            QMLog.e("CanvasView", ((StringBuilder)localObject2).toString());
            break label165;
          }
        }
      }
      localObject3 = localObject2;
      label165:
      bool = localDrawActionCommand.useHardwareAccelerate;
    }
    this.mCurrentDrawActions = ((JSONArray)localObject3);
  }
  
  /* Error */
  private void putImageData(Canvas paramCanvas, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 19
    //   3: aconst_null
    //   4: astore 18
    //   6: aload_3
    //   7: ldc_w 574
    //   10: invokevirtual 1182	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13: istore 9
    //   15: aload_3
    //   16: ldc_w 585
    //   19: invokevirtual 1182	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   22: istore 10
    //   24: aload_3
    //   25: ldc_w 1184
    //   28: invokevirtual 1182	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   31: istore 11
    //   33: aload_3
    //   34: ldc_w 1186
    //   37: invokevirtual 1182	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   40: istore 12
    //   42: aconst_null
    //   43: aload_3
    //   44: ldc 142
    //   46: invokestatic 1192	com/tencent/qqmini/sdk/core/utils/NativeBuffer:unpackNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;Lorg/json/JSONObject;Ljava/lang/String;)Lcom/tencent/qqmini/sdk/core/utils/NativeBuffer;
    //   49: astore 20
    //   51: aload 20
    //   53: ifnull +27 -> 80
    //   56: aload 19
    //   58: astore_3
    //   59: aload 20
    //   61: getfield 1196	com/tencent/qqmini/sdk/core/utils/NativeBuffer:buf	[B
    //   64: astore 19
    //   66: aload 19
    //   68: astore_3
    //   69: goto +13 -> 82
    //   72: astore 19
    //   74: aload 18
    //   76: astore_1
    //   77: goto +313 -> 390
    //   80: aconst_null
    //   81: astore_3
    //   82: iload 11
    //   84: iload 12
    //   86: imul
    //   87: newarray int
    //   89: astore 20
    //   91: iconst_0
    //   92: istore 7
    //   94: goto +395 -> 489
    //   97: iload 8
    //   99: iload 11
    //   101: if_icmpge +401 -> 502
    //   104: iload 11
    //   106: iload 7
    //   108: imul
    //   109: iload 8
    //   111: iadd
    //   112: istore 13
    //   114: iload 13
    //   116: iconst_4
    //   117: imul
    //   118: istore 14
    //   120: aload_3
    //   121: iload 14
    //   123: baload
    //   124: istore 15
    //   126: aload_3
    //   127: iload 14
    //   129: iconst_1
    //   130: iadd
    //   131: baload
    //   132: istore 16
    //   134: aload_3
    //   135: iload 14
    //   137: iconst_2
    //   138: iadd
    //   139: baload
    //   140: istore 17
    //   142: aload 20
    //   144: iload 13
    //   146: aload_3
    //   147: iload 14
    //   149: iconst_3
    //   150: iadd
    //   151: baload
    //   152: sipush 256
    //   155: iadd
    //   156: sipush 256
    //   159: irem
    //   160: iload 15
    //   162: sipush 256
    //   165: iadd
    //   166: sipush 256
    //   169: irem
    //   170: iload 16
    //   172: sipush 256
    //   175: iadd
    //   176: sipush 256
    //   179: irem
    //   180: iload 17
    //   182: sipush 256
    //   185: iadd
    //   186: sipush 256
    //   189: irem
    //   190: invokestatic 913	android/graphics/Color:argb	(IIII)I
    //   193: iastore
    //   194: iload 8
    //   196: iconst_1
    //   197: iadd
    //   198: istore 8
    //   200: goto -103 -> 97
    //   203: iload 11
    //   205: iload 12
    //   207: getstatic 754	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   210: invokestatic 897	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   213: astore 19
    //   215: aload 19
    //   217: astore 18
    //   219: aload 19
    //   221: astore_3
    //   222: aload 19
    //   224: aload 20
    //   226: iconst_0
    //   227: iload 11
    //   229: iconst_0
    //   230: iconst_0
    //   231: iload 11
    //   233: iload 12
    //   235: invokevirtual 1200	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   238: aload 19
    //   240: astore 18
    //   242: aload 19
    //   244: astore_3
    //   245: new 270	android/graphics/Paint
    //   248: dup
    //   249: invokespecial 1201	android/graphics/Paint:<init>	()V
    //   252: astore 20
    //   254: aload 19
    //   256: astore 18
    //   258: aload 19
    //   260: astore_3
    //   261: aload 20
    //   263: iconst_1
    //   264: invokevirtual 1204	android/graphics/Paint:setAntiAlias	(Z)V
    //   267: aload 19
    //   269: astore 18
    //   271: aload 19
    //   273: astore_3
    //   274: aload_0
    //   275: iload 9
    //   277: i2d
    //   278: invokevirtual 537	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   281: fstore 5
    //   283: aload 19
    //   285: astore 18
    //   287: aload 19
    //   289: astore_3
    //   290: aload_0
    //   291: iload 10
    //   293: i2d
    //   294: invokevirtual 537	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   297: fstore 6
    //   299: aload 19
    //   301: astore 18
    //   303: aload 19
    //   305: astore_3
    //   306: aload_1
    //   307: aload 19
    //   309: aconst_null
    //   310: new 495	android/graphics/RectF
    //   313: dup
    //   314: fload 5
    //   316: fload 6
    //   318: aload_0
    //   319: iload 11
    //   321: i2d
    //   322: invokevirtual 537	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   325: fload 5
    //   327: fadd
    //   328: aload_0
    //   329: iload 12
    //   331: i2d
    //   332: invokevirtual 537	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   335: fload 6
    //   337: fadd
    //   338: invokespecial 1117	android/graphics/RectF:<init>	(FFFF)V
    //   341: aload 20
    //   343: invokevirtual 852	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   346: aload 19
    //   348: astore 18
    //   350: aload 19
    //   352: astore_3
    //   353: aload_0
    //   354: aload_2
    //   355: aconst_null
    //   356: iload 4
    //   358: invokevirtual 1208	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventOK	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   361: aload 19
    //   363: ifnull +99 -> 462
    //   366: aload 19
    //   368: invokevirtual 674	android/graphics/Bitmap:isRecycled	()Z
    //   371: ifne +91 -> 462
    //   374: aload 19
    //   376: astore_1
    //   377: goto +81 -> 458
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_2
    //   383: goto +83 -> 466
    //   386: astore 19
    //   388: aconst_null
    //   389: astore_1
    //   390: aload_1
    //   391: astore_3
    //   392: new 705	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 706	java/lang/StringBuilder:<init>	()V
    //   399: astore 18
    //   401: aload_1
    //   402: astore_3
    //   403: aload 18
    //   405: ldc_w 1210
    //   408: invokevirtual 712	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_1
    //   413: astore_3
    //   414: aload 18
    //   416: aload 19
    //   418: invokestatic 718	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   421: invokevirtual 712	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_1
    //   426: astore_3
    //   427: ldc 152
    //   429: aload 18
    //   431: invokevirtual 721	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 727	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload_1
    //   438: astore_3
    //   439: aload_0
    //   440: aload_2
    //   441: aconst_null
    //   442: iload 4
    //   444: invokevirtual 1213	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   447: aload_1
    //   448: ifnull +14 -> 462
    //   451: aload_1
    //   452: invokevirtual 674	android/graphics/Bitmap:isRecycled	()Z
    //   455: ifne +7 -> 462
    //   458: aload_1
    //   459: invokevirtual 677	android/graphics/Bitmap:recycle	()V
    //   462: return
    //   463: astore_1
    //   464: aload_3
    //   465: astore_2
    //   466: aload_2
    //   467: ifnull +14 -> 481
    //   470: aload_2
    //   471: invokevirtual 674	android/graphics/Bitmap:isRecycled	()Z
    //   474: ifne +7 -> 481
    //   477: aload_2
    //   478: invokevirtual 677	android/graphics/Bitmap:recycle	()V
    //   481: goto +5 -> 486
    //   484: aload_1
    //   485: athrow
    //   486: goto -2 -> 484
    //   489: iload 7
    //   491: iload 12
    //   493: if_icmpge -290 -> 203
    //   496: iconst_0
    //   497: istore 8
    //   499: goto -402 -> 97
    //   502: iload 7
    //   504: iconst_1
    //   505: iadd
    //   506: istore 7
    //   508: goto -19 -> 489
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	CanvasView
    //   0	511	1	paramCanvas	Canvas
    //   0	511	2	paramString	String
    //   0	511	3	paramJSONObject	JSONObject
    //   0	511	4	paramInt	int
    //   281	45	5	f1	float
    //   297	39	6	f2	float
    //   92	415	7	i	int
    //   97	401	8	j	int
    //   13	263	9	k	int
    //   22	270	10	m	int
    //   31	289	11	n	int
    //   40	454	12	i1	int
    //   112	33	13	i2	int
    //   118	33	14	i3	int
    //   124	42	15	i4	int
    //   132	44	16	i5	int
    //   140	46	17	i6	int
    //   4	426	18	localObject1	Object
    //   1	66	19	arrayOfByte	byte[]
    //   72	1	19	localThrowable1	Throwable
    //   213	162	19	localBitmap	Bitmap
    //   386	31	19	localThrowable2	Throwable
    //   49	293	20	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	66	72	java/lang/Throwable
    //   222	238	72	java/lang/Throwable
    //   245	254	72	java/lang/Throwable
    //   261	267	72	java/lang/Throwable
    //   274	283	72	java/lang/Throwable
    //   290	299	72	java/lang/Throwable
    //   306	346	72	java/lang/Throwable
    //   353	361	72	java/lang/Throwable
    //   6	51	380	finally
    //   82	91	380	finally
    //   142	194	380	finally
    //   203	215	380	finally
    //   6	51	386	java/lang/Throwable
    //   82	91	386	java/lang/Throwable
    //   142	194	386	java/lang/Throwable
    //   203	215	386	java/lang/Throwable
    //   59	66	463	finally
    //   222	238	463	finally
    //   245	254	463	finally
    //   261	267	463	finally
    //   274	283	463	finally
    //   290	299	463	finally
    //   306	346	463	finally
    //   353	361	463	finally
    //   392	401	463	finally
    //   403	412	463	finally
    //   414	425	463	finally
    //   427	437	463	finally
    //   439	447	463	finally
  }
  
  private void setFillOrStrokeText(Canvas paramCanvas, String paramString, JSONArray paramJSONArray)
  {
    paramString = getCurrentPaint(paramString);
    float f3 = paramString.descent();
    float f6 = paramString.ascent();
    String str = paramJSONArray.optString(0);
    float f4 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f2 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f5 = mpx2px(paramJSONArray.optDouble(3, -1.0D));
    float f1;
    if (this.mTextBaseline.equals("top"))
    {
      f1 = f2 - f6;
    }
    else
    {
      if (this.mTextBaseline.equals("bottom")) {}
      for (f1 = f3;; f1 = (f3 + f6) / 2.0F)
      {
        f1 = f2 - f1;
        break;
        f1 = f2;
        if (!this.mTextBaseline.equals("middle")) {
          break;
        }
      }
    }
    if (f5 > 0.0F)
    {
      paramCanvas.save();
      f2 = f5 / paramString.measureText(str);
      if (f2 < 1.0F) {
        paramCanvas.scale(f2, 1.0F, f4, f1);
      }
      paramCanvas.drawText(str, f4, f1, paramString);
      paramCanvas.restore();
      return;
    }
    paramCanvas.drawText(str, f4, f1, paramString);
  }
  
  private void setFontStyle(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0, "normal");
    int i;
    if ("normal".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      i = getFontStyleNormal(paramJSONArray);
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      i = getFontStyleNormal(paramJSONArray);
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      return;
    }
    if (("italic".equals(paramJSONArray)) || ("oblique".equals(paramJSONArray)))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      i = getFontStyleItalic(paramJSONArray);
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      i = getFontStyleItalic(paramJSONArray);
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
    }
  }
  
  private void setFontWeight(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0);
    int i;
    if ("normal".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      i = getFontWeightNormalStyle(paramJSONArray);
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      i = getFontWeightNormalStyle(paramJSONArray);
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      return;
    }
    if ("bold".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      i = getFontWeightBoldStyle(paramJSONArray);
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      i = getFontWeightBoldStyle(paramJSONArray);
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
    }
  }
  
  private void setGlobalCompositeOperation(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0);
    if ("xor".equals(paramJSONArray)) {
      paramJSONArray = PorterDuff.Mode.XOR;
    } else if ("source-atop".equals(paramJSONArray)) {
      paramJSONArray = PorterDuff.Mode.SRC_ATOP;
    } else if ("destination-out".equals(paramJSONArray)) {
      paramJSONArray = PorterDuff.Mode.DST_OUT;
    } else if ((!"lighter".equals(paramJSONArray)) && (!"lighten".equals(paramJSONArray)) && (!"hard-light".equals(paramJSONArray)))
    {
      if ("overlay".equals(paramJSONArray)) {
        paramJSONArray = PorterDuff.Mode.OVERLAY;
      } else if ("darken".equals(paramJSONArray)) {
        paramJSONArray = PorterDuff.Mode.DARKEN;
      } else {
        paramJSONArray = null;
      }
    }
    else {
      paramJSONArray = PorterDuff.Mode.LIGHTEN;
    }
    if (paramJSONArray != null)
    {
      this.mFillPaint.setXfermode(new PorterDuffXfermode(paramJSONArray));
      this.mStrokePaint.setXfermode(new PorterDuffXfermode(paramJSONArray));
    }
  }
  
  private void setLineCap(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0);
    if ("butt".equals(paramJSONArray)) {
      paramJSONArray = Paint.Cap.BUTT;
    } else if ("round".equals(paramJSONArray)) {
      paramJSONArray = Paint.Cap.ROUND;
    } else if ("square".equals(paramJSONArray)) {
      paramJSONArray = Paint.Cap.SQUARE;
    } else {
      paramJSONArray = null;
    }
    if (paramJSONArray != null) {
      this.mStrokePaint.setStrokeCap(paramJSONArray);
    }
  }
  
  private void setLineDash(JSONArray paramJSONArray)
  {
    int i = 0;
    JSONArray localJSONArray = (JSONArray)paramJSONArray.opt(0);
    if (localJSONArray.length() > 0)
    {
      float f = mpx2px(paramJSONArray.optDouble(1, 0.0D));
      paramJSONArray = new float[localJSONArray.length()];
      while (i < localJSONArray.length())
      {
        paramJSONArray[i] = mpx2px(localJSONArray.optDouble(i, 0.0D));
        i += 1;
      }
      paramJSONArray = new DashPathEffect(paramJSONArray, f);
    }
    else
    {
      paramJSONArray = null;
    }
    this.mFillPaint.setPathEffect(paramJSONArray);
    this.mStrokePaint.setPathEffect(paramJSONArray);
  }
  
  private void setLineJoin(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0);
    if ("bevel".equals(paramJSONArray)) {
      paramJSONArray = Paint.Join.BEVEL;
    } else if ("round".equals(paramJSONArray)) {
      paramJSONArray = Paint.Join.ROUND;
    } else if ("miter".equals(paramJSONArray)) {
      paramJSONArray = Paint.Join.MITER;
    } else {
      paramJSONArray = null;
    }
    if (paramJSONArray != null) {
      this.mStrokePaint.setStrokeJoin(paramJSONArray);
    }
  }
  
  private void setPathOrClip(Canvas paramCanvas, String paramString, JSONArray paramJSONArray)
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    this.mPath.reset();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null)
      {
        String str = ((JSONObject)localObject).optString("method");
        localObject = ((JSONObject)localObject).optJSONArray("data");
        if ("rect".equals(str))
        {
          pathActionRect((JSONArray)localObject);
        }
        else if ("moveTo".equals(str))
        {
          float f1 = mpx2px(((JSONArray)localObject).optDouble(0, 0.0D));
          float f2 = mpx2px(((JSONArray)localObject).optDouble(1, 0.0D));
          this.mPath.moveTo(f1, f2);
        }
        else if ("lineTo".equals(str))
        {
          pathActionLineTo((JSONArray)localObject);
        }
        else if ("closePath".equals(str))
        {
          this.mPath.close();
        }
        else if ("arc".equals(str))
        {
          pathActionArc(paramJSONArray, (JSONArray)localObject);
        }
        else if ("quadraticCurveTo".equals(str))
        {
          pathActionQuadraticCurveTo((JSONArray)localObject);
        }
        else if ("bezierCurveTo".equals(str))
        {
          pathActionBezierCurveTo((JSONArray)localObject);
        }
        else if ("translate".equals(str))
        {
          paramCanvas.translate(mpx2px(((JSONArray)localObject).optDouble(0, 0.0D)), mpx2px(((JSONArray)localObject).optDouble(1, 0.0D)));
        }
      }
      i += 1;
    }
    if ("clip".equals(paramString))
    {
      paramCanvas.clipPath(this.mPath);
      return;
    }
    paramCanvas.drawPath(this.mPath, getCurrentPaint(paramString));
  }
  
  private void setStrokeOrFillStyle(String paramString, JSONArray paramJSONArray)
  {
    this.mRepeatX = false;
    this.mRepeatY = false;
    this.mBitmapW = 0;
    this.mBitmapH = 0;
    Object localObject = paramJSONArray.optString(0);
    if ("normal".equals(localObject))
    {
      setStyleColorTypeNormal(paramString, paramJSONArray);
      return;
    }
    JSONArray localJSONArray;
    if ("radial".equals(localObject))
    {
      localObject = paramJSONArray.optJSONArray(1);
      localJSONArray = paramJSONArray.optJSONArray(2);
      paramJSONArray = localJSONArray.optJSONArray(0).optJSONArray(1);
      localJSONArray = localJSONArray.optJSONArray(1).optJSONArray(1);
      paramJSONArray = new RadialGradient(mpx2px(((JSONArray)localObject).optDouble(0)), mpx2px(((JSONArray)localObject).optDouble(1)), mpx2px(((JSONArray)localObject).optDouble(2)), getColor(paramJSONArray), getColor(localJSONArray), Shader.TileMode.CLAMP);
      if ("setStrokeStyle".equals(paramString))
      {
        this.mStrokePaint.setShader(paramJSONArray);
        return;
      }
      if ("setFillStyle".equals(paramString)) {
        this.mFillPaint.setShader(paramJSONArray);
      }
    }
    else if ("linear".equals(localObject))
    {
      localObject = paramJSONArray.optJSONArray(1);
      localJSONArray = paramJSONArray.optJSONArray(2);
      paramJSONArray = localJSONArray.optJSONArray(0).optJSONArray(1);
      localJSONArray = localJSONArray.optJSONArray(1).optJSONArray(1);
      paramJSONArray = new LinearGradient(mpx2px(((JSONArray)localObject).optDouble(0)), mpx2px(((JSONArray)localObject).optDouble(1)), mpx2px(((JSONArray)localObject).optDouble(2)), mpx2px(((JSONArray)localObject).optDouble(3)), getColor(paramJSONArray), getColor(localJSONArray), Shader.TileMode.CLAMP);
      if ("setStrokeStyle".equals(paramString))
      {
        this.mStrokePaint.setShader(paramJSONArray);
        return;
      }
      if ("setFillStyle".equals(paramString)) {
        this.mFillPaint.setShader(paramJSONArray);
      }
    }
    else if ("pattern".equals(localObject))
    {
      setStrokeOrFillStyleForTypePatten(paramJSONArray);
    }
  }
  
  private void setStrokeOrFillStyleForTypePatten(JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() == 3)
    {
      String str2 = paramJSONArray.optString(1);
      String str1 = str2;
      if (!StringUtil.isEmpty(str2)) {
        if (str2.startsWith("wxfile")) {
          str1 = ((MiniAppFileManager)getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(str2);
        } else {
          str1 = this.mApkgInfo.getChildFileAbsolutePath(str2);
        }
      }
      paramJSONArray = paramJSONArray.optString(2);
      if ("repeat".equals(paramJSONArray))
      {
        this.mRepeatX = true;
        this.mRepeatY = true;
      }
      else if ("repeat-x".equals(paramJSONArray))
      {
        this.mRepeatX = true;
      }
      else if ("repeat-y".equals(paramJSONArray))
      {
        this.mRepeatY = true;
      }
      setStylePatternBitmapShader(str1);
    }
  }
  
  private void setStyleColorTypeNormal(String paramString, JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optJSONArray(1);
    int i;
    if ("setStrokeStyle".equals(paramString))
    {
      i = getColor(paramJSONArray);
      this.mStrokeColorAlpha = paramJSONArray.optInt(3);
      this.mStrokePaint.setShader(null);
      this.mStrokePaint.setColor(i);
      return;
    }
    if ("setFillStyle".equals(paramString))
    {
      i = getColor(paramJSONArray);
      this.mFillColorAlpha = paramJSONArray.optInt(3);
      this.mFillPaint.setShader(null);
      this.mFillPaint.setColor(i);
    }
  }
  
  private void setStylePatternBitmapShader(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      paramString = ImageUtil.getLocalBitmap(paramString);
      if (paramString != null)
      {
        this.mBitmapW = paramString.getWidth();
        this.mBitmapH = paramString.getHeight();
      }
      Object localObject = new Matrix();
      float f = this.mDensity;
      ((Matrix)localObject).postScale(f, f);
      Bitmap localBitmap = Bitmap.createBitmap(paramString, 0, 0, this.mBitmapW, this.mBitmapH, (Matrix)localObject, true);
      if (localBitmap != null)
      {
        this.mBitmapW = localBitmap.getWidth();
        this.mBitmapH = localBitmap.getHeight();
        if (this.mRepeatX) {
          paramString = Shader.TileMode.REPEAT;
        } else {
          paramString = Shader.TileMode.CLAMP;
        }
        if (this.mRepeatY) {
          localObject = Shader.TileMode.REPEAT;
        } else {
          localObject = Shader.TileMode.CLAMP;
        }
        paramString = new BitmapShader(localBitmap, paramString, (Shader.TileMode)localObject);
        this.mFillPaint.setShader(paramString);
        this.mStrokePaint.setShader(paramString);
      }
    }
  }
  
  private void setTextAlign(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0);
    if ("center".equals(paramJSONArray)) {
      paramJSONArray = Paint.Align.CENTER;
    } else if ("right".equals(paramJSONArray)) {
      paramJSONArray = Paint.Align.RIGHT;
    } else {
      paramJSONArray = Paint.Align.LEFT;
    }
    this.mFillPaint.setTextAlign(paramJSONArray);
    this.mStrokePaint.setTextAlign(paramJSONArray);
  }
  
  private void setUseHardwareAccelerate(boolean paramBoolean)
  {
    this.mUseHardwareAccelerate = paramBoolean;
    int i = getLayerType();
    if (paramBoolean)
    {
      if (i != 2) {
        setLayerType(2, null);
      }
    }
    else if (i != 0)
    {
      setLayerType(1, null);
      setLayerType(0, null);
    }
  }
  
  private void transform(Canvas paramCanvas, String paramString, JSONArray paramJSONArray)
  {
    float f1 = (float)paramJSONArray.optDouble(0, 1.0D);
    float f2 = (float)paramJSONArray.optDouble(3, 1.0D);
    float f3 = (float)paramJSONArray.optDouble(2, 0.0D);
    float f4 = (float)paramJSONArray.optDouble(1, 0.0D);
    float f5 = mpx2px(paramJSONArray.optDouble(4, 0.0D));
    float f6 = mpx2px(paramJSONArray.optDouble(5, 0.0D));
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[2] = f5;
    arrayOfFloat[5] = f6;
    arrayOfFloat[0] = f1;
    arrayOfFloat[4] = f2;
    arrayOfFloat[1] = f3;
    arrayOfFloat[3] = f4;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    try
    {
      if ("transform".equals(paramString))
      {
        paramString = new Matrix();
        paramString.setValues(arrayOfFloat);
        paramCanvas.concat(paramString);
        return;
      }
      paramJSONArray = paramCanvas.getMatrix();
      paramString = paramJSONArray;
      if (paramJSONArray == null) {
        paramString = new Matrix();
      }
      paramString.setValues(arrayOfFloat);
      paramCanvas.setMatrix(paramString);
      return;
    }
    catch (Exception paramCanvas)
    {
      QMLog.e("CanvasView", Log.getStackTraceString(paramCanvas));
    }
  }
  
  public void addDrawActionCommand(CanvasView.DrawActionCommand paramDrawActionCommand)
  {
    if ((this.mIsAttachedToWindow) && (paramDrawActionCommand != null))
    {
      this.mDrawActionCommandQueue.offer(paramDrawActionCommand);
      long l1 = System.currentTimeMillis();
      long l2 = this.mLastInvalidateTime;
      if (l2 == 0L)
      {
        processDrawActionCommands();
        postInvalidate();
        this.mLastInvalidateTime = l1;
        return;
      }
      l2 = l1 - l2;
      if (l2 >= 16L)
      {
        processDrawActionCommands();
        postInvalidate();
        this.mLastInvalidateTime = l1;
        return;
      }
      if (this.mPendingDrawTaskTime == 0L)
      {
        this.mPendingDrawTaskTime = l1;
        postDelayed(new CanvasView.26(this), 16L - l2);
      }
    }
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if (localIMiniAppContext != null) {
      ServiceEvaluateCallbackAction.obtain(localIMiniAppContext).callbackJsEventFail(paramString, paramJSONObject, paramInt);
    }
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if (localIMiniAppContext != null) {
      ServiceEvaluateCallbackAction.obtain(localIMiniAppContext).callbackJsEventOK(paramString, paramJSONObject, paramInt);
    }
  }
  
  protected void evaluateSubcribeJS(String paramString1, String paramString2)
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if (localIMiniAppContext != null) {
      localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, this.mNc.getPageWebviewContainer().getWebViewId()));
    }
  }
  
  public void getImageData(JSONObject paramJSONObject, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new CanvasView.1(this, paramNativeViewRequestEvent, paramJSONObject));
  }
  
  float mpx2px(double paramDouble)
  {
    double d = this.mDensity;
    Double.isNaN(d);
    return (float)(paramDouble * d);
  }
  
  int mpx2pxInt(double paramDouble)
  {
    double d = this.mDensity;
    Double.isNaN(d);
    return (int)(paramDouble * d + 0.5D);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mIsAttachedToWindow = true;
    if ((Build.MANUFACTURER.equalsIgnoreCase("vivo")) || (Build.MODEL.toLowerCase().contains("vivo"))) {}
    try
    {
      Object localObject = DisplayUtil.getSystemProperty("ro.vivo.os.version", null);
      if ((localObject != null) && ("3.1".equals(((String)localObject).trim())))
      {
        localObject = Class.forName("android.util.VivoSmartMultiWindowConfig").getDeclaredField("ENABLE_SPLIT");
        if (this.mVivoEnableSplit == null) {
          this.mVivoEnableSplit = Boolean.valueOf(((Field)localObject).getBoolean(null));
        }
        ((Field)localObject).set(null, Boolean.valueOf(false));
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mIsAttachedToWindow = false;
    if (this.mVivoEnableSplit != null) {}
    try
    {
      Class.forName("android.util.VivoSmartMultiWindowConfig").getDeclaredField("ENABLE_SPLIT").set(null, Boolean.valueOf(this.mVivoEnableSplit.booleanValue()));
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    for (;;)
    {
      try
      {
        if (getLayerType() != 0) {
          break label99;
        }
        i = paramCanvas.saveLayer(this.mOffScreenCacheRect, null, 31);
        paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        doDraw(paramCanvas, this.mCurrentDrawActions);
        if (i > 0)
        {
          paramCanvas.restoreToCount(i);
          return;
        }
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doDraw failed! ");
        localStringBuilder.append(Log.getStackTraceString(paramCanvas));
        QMLog.e("CanvasView", localStringBuilder.toString());
      }
      return;
      label99:
      int i = 0;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mOffScreenCacheRect = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new JSONObject();
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            StringBuilder localStringBuilder;
            if (i != 5)
            {
              if (i == 6)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("--ACTION_POINTER_UP--");
                localStringBuilder.append(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
                QMLog.d("CanvasView", localStringBuilder.toString());
                handleTouchPointerEvent(paramMotionEvent, (JSONObject)localObject, "onTouchEnd");
              }
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("--ACTION_POINTER_DOWN--");
              localStringBuilder.append(paramMotionEvent.getPointerCount());
              localStringBuilder.append("   ");
              localStringBuilder.append(paramMotionEvent.getActionIndex());
              localStringBuilder.append("   ");
              localStringBuilder.append(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
              QMLog.d("CanvasView", localStringBuilder.toString());
              handleTouchPointerEvent(paramMotionEvent, (JSONObject)localObject, "onTouchStart");
            }
          }
          else
          {
            QMLog.d("CanvasView", "--ACTION_CANCEL--");
            handleTouchCancel(paramMotionEvent, (JSONObject)localObject);
          }
        }
        else {
          handleTouchMove(paramMotionEvent, (JSONObject)localObject);
        }
      }
      else
      {
        QMLog.d("CanvasView", "--ACTION_UP--");
        handleTouchEvent(paramMotionEvent, (JSONObject)localObject, "onTouchEnd");
      }
    }
    else
    {
      QMLog.d("CanvasView", "--ACTION_DOWN--");
      handleTouchEvent(paramMotionEvent, (JSONObject)localObject, "onTouchStart");
    }
    if (this.mHasGuesture)
    {
      localObject = this.mDisableScroll;
      if ((localObject != null) && (((Boolean)localObject).booleanValue() == true)) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  float px2mpx(double paramDouble)
  {
    double d = this.mDensity;
    Double.isNaN(d);
    return (float)(paramDouble / d);
  }
  
  int px2mpxInt(double paramDouble)
  {
    double d = this.mDensity;
    Double.isNaN(d);
    return (int)(paramDouble / d + 0.5D);
  }
  
  public void saveBitmap(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramNativeViewContainer = "png";
    } else {
      paramNativeViewContainer = paramJSONObject.optString("fileType");
    }
    boolean bool = "jpg".equals(paramNativeViewContainer);
    long l = 0L;
    if ((getWidth() == 0) || (getHeight() == 0)) {
      l = 300L;
    }
    AppBrandTask.runTaskOnUiThreadDelay(new CanvasView.2(this, bool ^ true, paramNativeViewRequestEvent, paramJSONObject, paramNativeViewContainer), l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */