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
    float f = 0.0F;
    RectF localRectF = new RectF();
    if (((this.mRepeatX) || (this.mRepeatY)) && ((this.mBitmapW != 0) || (this.mBitmapH != 0)))
    {
      if (this.mRepeatX) {
        paramFloat1 = 0.0F;
      }
      localRectF.left = paramFloat1;
      if (this.mRepeatY)
      {
        paramFloat1 = f;
        localRectF.top = paramFloat1;
        if (!this.mRepeatX) {
          break label134;
        }
        paramFloat1 = localRectF.left + paramFloat3;
        label86:
        localRectF.right = paramFloat1;
        if (!this.mRepeatY) {
          break label143;
        }
        paramFloat1 = localRectF.top + paramFloat4;
      }
    }
    label108:
    for (localRectF.bottom = paramFloat1;; localRectF.bottom = (localRectF.top + paramFloat4))
    {
      this.mPath.addRect(localRectF, Path.Direction.CW);
      return localRectF;
      paramFloat1 = paramFloat2;
      break;
      paramFloat1 = this.mBitmapW;
      break label86;
      paramFloat1 = this.mBitmapH;
      break label108;
      localRectF.left = paramFloat1;
      localRectF.top = paramFloat2;
      localRectF.right = (localRectF.left + paramFloat3);
    }
  }
  
  private void clearRect(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    paramCanvas.save();
    float f4 = mpx2px(paramJSONArray.optDouble(0, 0.0D));
    float f6 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f3 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f5 = mpx2px(paramJSONArray.optDouble(3, 0.0D));
    float f2 = f3;
    float f1 = f4;
    if (f3 <= 0.0F)
    {
      f1 = f4 + f3;
      f2 = -f3;
    }
    f4 = f5;
    f3 = f6;
    if (f5 <= 0.0F)
    {
      f3 = f6 + f5;
      f4 = -f5;
    }
    paramJSONArray = new RectF();
    paramJSONArray.left = f1;
    paramJSONArray.top = f3;
    paramJSONArray.right = (paramJSONArray.left + f2);
    paramJSONArray.bottom = (f4 + paramJSONArray.top);
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
    //   9: astore 18
    //   11: aload 18
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
    //   38: astore 19
    //   40: aload_0
    //   41: aload 8
    //   43: ldc_w 574
    //   46: dconst_0
    //   47: invokevirtual 579	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   50: invokevirtual 583	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   53: istore 16
    //   55: aload_0
    //   56: aload 8
    //   58: ldc_w 585
    //   61: dconst_0
    //   62: invokevirtual 579	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   65: invokevirtual 583	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   68: istore 17
    //   70: aload 18
    //   72: aload 9
    //   74: new 569	android/graphics/Rect
    //   77: dup
    //   78: iload 16
    //   80: iload 17
    //   82: iload 16
    //   84: iload_1
    //   85: iadd
    //   86: iload 17
    //   88: iload_2
    //   89: iadd
    //   90: invokespecial 572	android/graphics/Rect:<init>	(IIII)V
    //   93: aload 19
    //   95: aconst_null
    //   96: invokevirtual 589	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   99: aload_0
    //   100: invokespecial 593	com/tencent/qqmini/miniapp/widget/CanvasView:getMiniAppContext	()Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   103: ldc_w 595
    //   106: invokeinterface 599 2 0
    //   111: checkcast 595	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   114: aload 10
    //   116: invokevirtual 603	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 18
    //   121: aload 18
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
    //   150: fstore 15
    //   152: iload 11
    //   154: ifeq +116 -> 270
    //   157: aload 8
    //   159: ldc_w 616
    //   162: dconst_1
    //   163: invokevirtual 579	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   166: fload 15
    //   168: f2d
    //   169: ddiv
    //   170: dstore 13
    //   172: aload 7
    //   174: getstatic 622	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   177: dload 13
    //   179: ldc2_w 623
    //   182: dmul
    //   183: d2i
    //   184: aload 10
    //   186: invokevirtual 630	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   189: pop
    //   190: new 576	org/json/JSONObject
    //   193: dup
    //   194: invokespecial 631	org/json/JSONObject:<init>	()V
    //   197: astore 7
    //   199: aload 7
    //   201: ldc_w 633
    //   204: aload_0
    //   205: invokespecial 593	com/tencent/qqmini/miniapp/widget/CanvasView:getMiniAppContext	()Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   208: ldc_w 595
    //   211: invokeinterface 599 2 0
    //   216: checkcast 595	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   219: aload 18
    //   221: invokevirtual 636	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual 640	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload 12
    //   230: aload 7
    //   232: invokevirtual 646	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   235: pop
    //   236: aload 10
    //   238: ifnull +13 -> 251
    //   241: aload 10
    //   243: invokevirtual 649	java/io/FileOutputStream:flush	()V
    //   246: aload 10
    //   248: invokevirtual 652	java/io/FileOutputStream:close	()V
    //   251: aload 9
    //   253: ifnull +16 -> 269
    //   256: aload 9
    //   258: invokevirtual 656	android/graphics/Bitmap:isRecycled	()Z
    //   261: ifne +8 -> 269
    //   264: aload 9
    //   266: invokevirtual 659	android/graphics/Bitmap:recycle	()V
    //   269: return
    //   270: aload 8
    //   272: ldc_w 661
    //   275: dconst_1
    //   276: invokevirtual 579	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   279: fload 15
    //   281: f2d
    //   282: ddiv
    //   283: dstore 13
    //   285: aload 7
    //   287: getstatic 664	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   290: dload 13
    //   292: ldc2_w 623
    //   295: dmul
    //   296: d2i
    //   297: aload 10
    //   299: invokevirtual 630	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   302: pop
    //   303: goto -113 -> 190
    //   306: astore 7
    //   308: aload 10
    //   310: astore 8
    //   312: aload 8
    //   314: ifnull +13 -> 327
    //   317: aload 8
    //   319: invokevirtual 649	java/io/FileOutputStream:flush	()V
    //   322: aload 8
    //   324: invokevirtual 652	java/io/FileOutputStream:close	()V
    //   327: aload 9
    //   329: ifnull +16 -> 345
    //   332: aload 9
    //   334: invokevirtual 656	android/graphics/Bitmap:isRecycled	()Z
    //   337: ifne +8 -> 345
    //   340: aload 9
    //   342: invokevirtual 659	android/graphics/Bitmap:recycle	()V
    //   345: aload 7
    //   347: athrow
    //   348: astore 7
    //   350: aload 7
    //   352: invokevirtual 667	org/json/JSONException:printStackTrace	()V
    //   355: aload 12
    //   357: invokevirtual 671	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   360: pop
    //   361: goto -125 -> 236
    //   364: astore 7
    //   366: aconst_null
    //   367: astore 8
    //   369: goto -57 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	CanvasView
    //   0	372	1	paramInt1	int
    //   0	372	2	paramInt2	int
    //   0	372	3	paramInt3	int
    //   0	372	4	paramInt4	int
    //   0	372	5	paramInt5	int
    //   0	372	6	paramInt6	int
    //   0	372	7	paramBitmap1	Bitmap
    //   0	372	8	paramJSONObject	JSONObject
    //   0	372	9	paramBitmap2	Bitmap
    //   0	372	10	paramString	String
    //   0	372	11	paramBoolean	boolean
    //   0	372	12	paramNativeViewRequestEvent	NativeViewRequestEvent
    //   170	121	13	d	double
    //   150	130	15	f	float
    //   53	33	16	i	int
    //   68	22	17	j	int
    //   9	211	18	localObject	Object
    //   38	56	19	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   139	152	306	finally
    //   157	190	306	finally
    //   190	236	306	finally
    //   270	303	306	finally
    //   350	361	306	finally
    //   190	236	348	org/json/JSONException
    //   128	139	364	finally
  }
  
  private Bitmap decodeImage(String paramString, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions, int paramInt5)
  {
    paramOptions.inDither = true;
    if ((paramInt3 > 0) && (paramInt4 > 0))
    {
      try
      {
        localObject1 = BitmapRegionDecoder.newInstance(paramString, false);
        paramString = ((BitmapRegionDecoder)localObject1).decodeRegion(getCropRect(paramInt1, paramInt2, paramInt3, paramInt4, paramOptions, paramInt5), paramOptions);
        QMLog.e("CanvasView", "bitmapRegionDecoder newInstance exception: " + Log.getStackTraceString(paramOptions));
      }
      catch (Exception paramOptions)
      {
        try
        {
          ((BitmapRegionDecoder)localObject1).recycle();
          return paramString;
        }
        catch (Exception paramOptions)
        {
          Object localObject1;
          float f2;
          float f1;
          float f3;
          break label58;
        }
        paramOptions = paramOptions;
        paramString = null;
      }
      label58:
      return paramString;
    }
    else
    {
      paramOptions.inJustDecodeBounds = false;
      f2 = paramOptions.outWidth;
      f1 = paramOptions.outHeight;
      f3 = (float)Math.sqrt(paramFloat1 * paramFloat2 / paramOptions.outWidth / paramOptions.outHeight);
      paramFloat2 = f1;
      paramFloat1 = f2;
      if (f3 < 1.0F)
      {
        paramFloat1 = f2 * f3;
        paramFloat2 = f1 * f3;
      }
      if (ImageUtil.isPngFile(paramString))
      {
        paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        f1 = (float)Math.sqrt(8985600.0D / paramFloat1 / paramFloat2 / 4.0D);
        if (f1 >= 1.0F) {
          break label283;
        }
        paramOptions.inSampleSize = ImageUtil.calculateInSampleSize(paramOptions, paramFloat1 * f1, paramFloat2 * f1);
      }
      for (;;)
      {
        Bitmap localBitmap;
        try
        {
          localObject1 = BitmapFactory.decodeFile(paramString, paramOptions);
          return decodeImageQuarter(paramString, paramOptions, (Bitmap)localObject1);
          paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
          f1 = (float)Math.sqrt(8985600.0D / paramFloat1 / paramFloat2 / 2.0D);
        }
        catch (Throwable localThrowable1)
        {
          QMLog.w("CanvasView", "getLocalBitmap error with inSampleSize error!try again with lower quality!");
          localBitmap = null;
          continue;
        }
        try
        {
          label283:
          localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
        }
        catch (Throwable localThrowable2)
        {
          QMLog.w("CanvasView", "getLocalBitmap error! try again with lower quality!");
          Object localObject2 = null;
        }
      }
    }
  }
  
  private Bitmap decodeImageQuarter(String paramString, BitmapFactory.Options paramOptions, Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      if (paramOptions.inSampleSize <= 0) {
        break label34;
      }
    }
    for (paramOptions.inSampleSize *= 2;; paramOptions.inSampleSize = 2) {
      try
      {
        localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
        return localBitmap;
      }
      catch (Throwable paramString)
      {
        label34:
        QMLog.e("CanvasView", "getLocalBitmap 2nd time error!", paramString);
      }
    }
    return null;
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
    float f4;
    int i;
    int j;
    int k;
    int m;
    int n;
    if (!StringUtil.isEmpty(str1))
    {
      f5 = (float)paramJSONArray.optDouble(1, 0.0D);
      f6 = (float)paramJSONArray.optDouble(2, 0.0D);
      f4 = (float)paramJSONArray.optDouble(3, 0.0D);
      f3 = (float)paramJSONArray.optDouble(4, 0.0D);
      i = (int)paramJSONArray.optDouble(5, 0.0D);
      j = (int)paramJSONArray.optDouble(6, 0.0D);
      k = (int)paramJSONArray.optDouble(7, 0.0D);
      m = (int)paramJSONArray.optDouble(8, 0.0D);
      paramJSONArray = new BitmapFactory.Options();
      n = ImageUtil.getExifOrientation(str1);
      f1 = f4;
    }
    for (;;)
    {
      try
      {
        paramJSONArray.inJustDecodeBounds = true;
        f1 = f4;
        BitmapFactory.decodeFile(str1, paramJSONArray);
        if (f4 > 0.0F)
        {
          f1 = f3;
          f2 = f4;
          if (f3 > 0.0F) {}
        }
        else
        {
          if ((k <= 0) || (m <= 0)) {
            continue;
          }
          f2 = k;
          f1 = m;
        }
      }
      catch (Exception localException)
      {
        int i1;
        QMLog.e("CanvasView", "calculate image size error! " + Log.getStackTraceString(localException));
        float f2 = f1;
        f1 = f3;
        continue;
      }
      drawBitmap(paramCanvas, str1, f5, f6, f2, f1, i, j, k, m, paramJSONArray, n);
      return;
      if ((n == 90) || (n == 270))
      {
        f1 = f4;
        f2 = paramJSONArray.outHeight;
        f1 = f2;
        f4 = paramJSONArray.outWidth;
        f1 = f4;
      }
      else
      {
        f1 = f4;
        f2 = paramJSONArray.outWidth;
        f1 = f2;
        i1 = paramJSONArray.outHeight;
        f1 = i1;
      }
    }
  }
  
  private Bitmap getCacheBitmapFromView(View paramView, boolean paramBoolean)
  {
    Bitmap localBitmap;
    for (;;)
    {
      try
      {
        paramView.setDrawingCacheEnabled(true);
        paramView.buildDrawingCache(true);
        Object localObject = paramView.getDrawingCache();
        if (localObject != null)
        {
          localBitmap = Bitmap.createBitmap((Bitmap)localObject);
          localObject = localBitmap;
        }
        int i;
        int j;
        Bitmap.Config localConfig;
        localBitmap = null;
      }
      catch (Throwable paramView)
      {
        try
        {
          paramView.setDrawingCacheEnabled(false);
          localObject = localBitmap;
          paramView.buildDrawingCache(false);
          if (localBitmap != null) {
            break;
          }
          localObject = localBitmap;
          i = paramView.getWidth();
          localObject = localBitmap;
          j = paramView.getHeight();
          if (paramBoolean)
          {
            localObject = localBitmap;
            localConfig = Bitmap.Config.ARGB_8888;
            localObject = localBitmap;
            localBitmap = Bitmap.createBitmap(i, j, localConfig);
            localObject = localBitmap;
            paramView.draw(new Canvas(localBitmap));
            return localBitmap;
          }
          localObject = localBitmap;
          localConfig = Bitmap.Config.RGB_565;
          continue;
          paramView = paramView;
          localObject = null;
        }
        catch (Throwable paramView)
        {
          continue;
        }
        QMLog.e("CanvasView", "getCacheBitmapFromView failed: " + Log.getStackTraceString(paramView));
        return localObject;
      }
    }
    return localBitmap;
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
    if (paramBoolean) {
      return (float)Math.sqrt(8985600.0D / paramInt1 / paramInt2 / 2.0D);
    }
    return (float)Math.sqrt(8985600.0D / paramInt1 / paramInt2 / 2.0D);
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
      if ((this.mGlobalAlpha != -1) && (this.mGlobalAlpha < this.mFillColorAlpha)) {
        this.mFillPaint.setAlpha(this.mGlobalAlpha);
      }
      for (;;)
      {
        return this.mFillPaint;
        this.mFillPaint.setAlpha(this.mFillColorAlpha);
      }
    }
    if ((this.mGlobalAlpha != -1) && (this.mGlobalAlpha < this.mStrokeColorAlpha)) {
      this.mStrokePaint.setAlpha(this.mGlobalAlpha);
    }
    for (;;)
    {
      return this.mStrokePaint;
      this.mStrokePaint.setAlpha(this.mStrokeColorAlpha);
    }
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
      JSONArray localJSONArray;
      int i;
      try
      {
        localJSONArray = new JSONArray();
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
        }
      }
      catch (JSONException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
        return;
      }
      if (localJSONArray.length() > 0)
      {
        paramJSONObject.put("data", this.mCanvasData);
        paramJSONObject.put("touches", localJSONArray);
        evaluateSubcribeJS("onTouchMove", paramJSONObject.toString());
        return;
        label204:
        i += 1;
      }
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
    float f6 = mpx2px(paramJSONArray2.optDouble(0, 0.0D));
    float f4 = mpx2px(paramJSONArray2.optDouble(1, 0.0D));
    float f5 = mpx2px(paramJSONArray2.optDouble(2, 0.0D));
    double d1 = paramJSONArray2.optDouble(3, 0.0D);
    double d2 = paramJSONArray2.optDouble(4, 0.0D);
    float f3 = (float)(d1 / 3.141592653589793D * 180.0D);
    float f1 = (float)(d2 / 3.141592653589793D * 180.0D);
    boolean bool = paramJSONArray1.optBoolean(5);
    paramJSONArray1 = new RectF(f6 - f5, f4 - f5, f6 + f5, f4 + f5);
    if (bool) {}
    for (f1 = f3 - f1;; f1 -= f3)
    {
      f2 = f1 % 360.0F;
      f1 = f2;
      if (f2 <= 0.0F) {
        f1 = f2 + 360.0F;
      }
      if (!this.mPath.isEmpty()) {
        break;
      }
      this.mPath.addArc(paramJSONArray1, f3, f1);
      return;
    }
    float f2 = (float)(f6 + f5 * Math.cos(d1));
    d2 = f4;
    f2 = (float)(f5 * Math.sin(d1) + d2);
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
    float f2 = f3;
    float f1 = f4;
    if (f3 <= 0.0F)
    {
      f1 = f4 + f3;
      f2 = -f3;
    }
    f4 = f5;
    f3 = f6;
    if (f5 <= 0.0F)
    {
      f3 = f6 + f5;
      f4 = -f5;
    }
    addPathRect(f1, f3, f2, f4);
  }
  
  private void processDrawActionCommands()
  {
    boolean bool = this.mUseHardwareAccelerate;
    Object localObject3 = this.mCurrentDrawActions;
    CanvasView.DrawActionCommand localDrawActionCommand = (CanvasView.DrawActionCommand)this.mDrawActionCommandQueue.poll();
    if (localDrawActionCommand != null)
    {
      Object localObject2;
      label46:
      Object localObject1;
      if (localDrawActionCommand != null)
      {
        bool = localDrawActionCommand.reverse;
        localObject2 = localDrawActionCommand.drawAction;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new JSONArray();
        }
        if (((JSONArray)localObject1).length() == 0) {
          ((JSONArray)localObject1).put(new JSONObject());
        }
        localObject2 = localObject1;
        if (bool)
        {
          localObject2 = localObject1;
          if (localObject3 == null) {}
        }
      }
      for (;;)
      {
        try
        {
          int i = ((JSONArray)localObject3).length();
          if (i != 0) {
            continue;
          }
          localObject2 = localObject1;
          localObject3 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("CanvasView", "process draw actions error! " + Log.getStackTraceString(localThrowable));
          continue;
        }
        bool = localDrawActionCommand.useHardwareAccelerate;
        localDrawActionCommand = (CanvasView.DrawActionCommand)this.mDrawActionCommandQueue.poll();
        break;
        bool = false;
        localObject2 = this.mCurrentDrawActions;
        break label46;
        localObject2 = JSONUtil.concatArray((JSONArray)localObject3, (JSONArray)localObject1);
      }
    }
    this.mCurrentDrawActions = ((JSONArray)localObject3);
  }
  
  /* Error */
  private void putImageData(Canvas paramCanvas, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 18
    //   3: aload_3
    //   4: ldc_w 574
    //   7: invokevirtual 1176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10: istore 9
    //   12: aload_3
    //   13: ldc_w 585
    //   16: invokevirtual 1176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   19: istore 10
    //   21: aload_3
    //   22: ldc_w 1178
    //   25: invokevirtual 1176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   28: istore 11
    //   30: aload_3
    //   31: ldc_w 1180
    //   34: invokevirtual 1176	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   37: istore 12
    //   39: aconst_null
    //   40: aload_3
    //   41: ldc 142
    //   43: invokestatic 1186	com/tencent/qqmini/sdk/core/utils/NativeBuffer:unpackNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;Lorg/json/JSONObject;Ljava/lang/String;)Lcom/tencent/qqmini/sdk/core/utils/NativeBuffer;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +364 -> 412
    //   51: aload_3
    //   52: getfield 1190	com/tencent/qqmini/sdk/core/utils/NativeBuffer:buf	[B
    //   55: astore_3
    //   56: iload 11
    //   58: iload 12
    //   60: imul
    //   61: newarray int
    //   63: astore 19
    //   65: iconst_0
    //   66: istore 7
    //   68: goto +331 -> 399
    //   71: iload 8
    //   73: iload 11
    //   75: if_icmpge +342 -> 417
    //   78: iload 11
    //   80: iload 7
    //   82: imul
    //   83: iload 8
    //   85: iadd
    //   86: istore 13
    //   88: iload 13
    //   90: iconst_4
    //   91: imul
    //   92: istore 14
    //   94: aload_3
    //   95: iload 14
    //   97: baload
    //   98: istore 15
    //   100: aload_3
    //   101: iload 14
    //   103: iconst_1
    //   104: iadd
    //   105: baload
    //   106: istore 16
    //   108: aload_3
    //   109: iload 14
    //   111: iconst_2
    //   112: iadd
    //   113: baload
    //   114: istore 17
    //   116: aload 19
    //   118: iload 13
    //   120: aload_3
    //   121: iload 14
    //   123: iconst_3
    //   124: iadd
    //   125: baload
    //   126: sipush 256
    //   129: iadd
    //   130: sipush 256
    //   133: irem
    //   134: iload 15
    //   136: sipush 256
    //   139: iadd
    //   140: sipush 256
    //   143: irem
    //   144: iload 16
    //   146: sipush 256
    //   149: iadd
    //   150: sipush 256
    //   153: irem
    //   154: iload 17
    //   156: sipush 256
    //   159: iadd
    //   160: sipush 256
    //   163: irem
    //   164: invokestatic 907	android/graphics/Color:argb	(IIII)I
    //   167: iastore
    //   168: iload 8
    //   170: iconst_1
    //   171: iadd
    //   172: istore 8
    //   174: goto -103 -> 71
    //   177: iload 11
    //   179: iload 12
    //   181: getstatic 748	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   184: invokestatic 891	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   187: astore_3
    //   188: aload_3
    //   189: aload 19
    //   191: iconst_0
    //   192: iload 11
    //   194: iconst_0
    //   195: iconst_0
    //   196: iload 11
    //   198: iload 12
    //   200: invokevirtual 1194	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   203: new 270	android/graphics/Paint
    //   206: dup
    //   207: invokespecial 1195	android/graphics/Paint:<init>	()V
    //   210: astore 18
    //   212: aload 18
    //   214: iconst_1
    //   215: invokevirtual 1198	android/graphics/Paint:setAntiAlias	(Z)V
    //   218: aload_0
    //   219: iload 9
    //   221: i2d
    //   222: invokevirtual 537	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   225: fstore 5
    //   227: aload_0
    //   228: iload 10
    //   230: i2d
    //   231: invokevirtual 537	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   234: fstore 6
    //   236: aload_1
    //   237: aload_3
    //   238: aconst_null
    //   239: new 495	android/graphics/RectF
    //   242: dup
    //   243: fload 5
    //   245: fload 6
    //   247: aload_0
    //   248: iload 11
    //   250: i2d
    //   251: invokevirtual 537	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   254: fload 5
    //   256: fadd
    //   257: aload_0
    //   258: iload 12
    //   260: i2d
    //   261: invokevirtual 537	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   264: fload 6
    //   266: fadd
    //   267: invokespecial 1111	android/graphics/RectF:<init>	(FFFF)V
    //   270: aload 18
    //   272: invokevirtual 846	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   275: aload_0
    //   276: aload_2
    //   277: aconst_null
    //   278: iload 4
    //   280: invokevirtual 1202	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventOK	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   283: aload_3
    //   284: ifnull +14 -> 298
    //   287: aload_3
    //   288: invokevirtual 656	android/graphics/Bitmap:isRecycled	()Z
    //   291: ifne +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 659	android/graphics/Bitmap:recycle	()V
    //   298: return
    //   299: astore_3
    //   300: aconst_null
    //   301: astore_1
    //   302: ldc 152
    //   304: new 699	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 700	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 1204
    //   314: invokevirtual 706	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokestatic 712	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   321: invokevirtual 706	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 715	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 721	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_0
    //   331: aload_2
    //   332: aconst_null
    //   333: iload 4
    //   335: invokevirtual 1207	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   338: aload_1
    //   339: ifnull -41 -> 298
    //   342: aload_1
    //   343: invokevirtual 656	android/graphics/Bitmap:isRecycled	()Z
    //   346: ifne -48 -> 298
    //   349: aload_1
    //   350: invokevirtual 659	android/graphics/Bitmap:recycle	()V
    //   353: return
    //   354: astore_1
    //   355: aload 18
    //   357: astore_2
    //   358: aload_2
    //   359: ifnull +14 -> 373
    //   362: aload_2
    //   363: invokevirtual 656	android/graphics/Bitmap:isRecycled	()Z
    //   366: ifne +7 -> 373
    //   369: aload_2
    //   370: invokevirtual 659	android/graphics/Bitmap:recycle	()V
    //   373: aload_1
    //   374: athrow
    //   375: astore_1
    //   376: aload_3
    //   377: astore_2
    //   378: goto -20 -> 358
    //   381: astore_3
    //   382: aload_1
    //   383: astore_2
    //   384: aload_3
    //   385: astore_1
    //   386: goto -28 -> 358
    //   389: astore 18
    //   391: aload_3
    //   392: astore_1
    //   393: aload 18
    //   395: astore_3
    //   396: goto -94 -> 302
    //   399: iload 7
    //   401: iload 12
    //   403: if_icmpge -226 -> 177
    //   406: iconst_0
    //   407: istore 8
    //   409: goto -338 -> 71
    //   412: aconst_null
    //   413: astore_3
    //   414: goto -358 -> 56
    //   417: iload 7
    //   419: iconst_1
    //   420: iadd
    //   421: istore 7
    //   423: goto -24 -> 399
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	CanvasView
    //   0	426	1	paramCanvas	Canvas
    //   0	426	2	paramString	String
    //   0	426	3	paramJSONObject	JSONObject
    //   0	426	4	paramInt	int
    //   225	30	5	f1	float
    //   234	31	6	f2	float
    //   66	356	7	i	int
    //   71	337	8	j	int
    //   10	210	9	k	int
    //   19	210	10	m	int
    //   28	221	11	n	int
    //   37	367	12	i1	int
    //   86	33	13	i2	int
    //   92	33	14	i3	int
    //   98	42	15	i4	int
    //   106	44	16	i5	int
    //   114	46	17	i6	int
    //   1	355	18	localPaint	Paint
    //   389	5	18	localThrowable	Throwable
    //   63	127	19	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   3	47	299	java/lang/Throwable
    //   51	56	299	java/lang/Throwable
    //   56	65	299	java/lang/Throwable
    //   116	168	299	java/lang/Throwable
    //   177	188	299	java/lang/Throwable
    //   3	47	354	finally
    //   51	56	354	finally
    //   56	65	354	finally
    //   116	168	354	finally
    //   177	188	354	finally
    //   188	283	375	finally
    //   302	338	381	finally
    //   188	283	389	java/lang/Throwable
  }
  
  private void setFillOrStrokeText(Canvas paramCanvas, String paramString, JSONArray paramJSONArray)
  {
    paramString = getCurrentPaint(paramString);
    float f5 = paramString.descent();
    float f6 = paramString.ascent();
    int i = (int)(f5 - f6);
    String str = paramJSONArray.optString(0);
    float f3 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f2 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f4 = mpx2px(paramJSONArray.optDouble(3, -1.0D));
    float f1;
    if (this.mTextBaseline.equals("top")) {
      f1 = f2 - f6;
    }
    while (f4 > 0.0F)
    {
      paramCanvas.save();
      f2 = f4 / paramString.measureText(str);
      if (f2 < 1.0F) {
        paramCanvas.scale(f2, 1.0F, f3, f1);
      }
      paramCanvas.drawText(str, f3, f1, paramString);
      paramCanvas.restore();
      return;
      if (this.mTextBaseline.equals("bottom"))
      {
        f1 = f2 - f5;
      }
      else
      {
        f1 = f2;
        if (this.mTextBaseline.equals("middle")) {
          f1 = f2 - (f5 + f6) / 2.0F;
        }
      }
    }
    paramCanvas.drawText(str, f3, f1, paramString);
  }
  
  private void setFontStyle(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0, "normal");
    if ("normal".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      i = getFontStyleNormal(paramJSONArray);
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      i = getFontStyleNormal(paramJSONArray);
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
    }
    while ((!"italic".equals(paramJSONArray)) && (!"oblique".equals(paramJSONArray))) {
      return;
    }
    paramJSONArray = this.mFillPaint.getTypeface();
    int i = getFontStyleItalic(paramJSONArray);
    this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
    paramJSONArray = this.mStrokePaint.getTypeface();
    i = getFontStyleItalic(paramJSONArray);
    this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
  }
  
  private void setFontWeight(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0);
    if ("normal".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      i = getFontWeightNormalStyle(paramJSONArray);
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      i = getFontWeightNormalStyle(paramJSONArray);
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
    }
    while (!"bold".equals(paramJSONArray)) {
      return;
    }
    paramJSONArray = this.mFillPaint.getTypeface();
    int i = getFontWeightBoldStyle(paramJSONArray);
    this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
    paramJSONArray = this.mStrokePaint.getTypeface();
    i = getFontWeightBoldStyle(paramJSONArray);
    this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
  }
  
  private void setGlobalCompositeOperation(JSONArray paramJSONArray)
  {
    String str = paramJSONArray.optString(0);
    paramJSONArray = null;
    if ("xor".equals(str)) {
      paramJSONArray = PorterDuff.Mode.XOR;
    }
    for (;;)
    {
      if (paramJSONArray != null)
      {
        this.mFillPaint.setXfermode(new PorterDuffXfermode(paramJSONArray));
        this.mStrokePaint.setXfermode(new PorterDuffXfermode(paramJSONArray));
      }
      return;
      if ("source-atop".equals(str)) {
        paramJSONArray = PorterDuff.Mode.SRC_ATOP;
      } else if ("destination-out".equals(str)) {
        paramJSONArray = PorterDuff.Mode.DST_OUT;
      } else if (("lighter".equals(str)) || ("lighten".equals(str)) || ("hard-light".equals(str))) {
        paramJSONArray = PorterDuff.Mode.LIGHTEN;
      } else if ("overlay".equals(str)) {
        paramJSONArray = PorterDuff.Mode.OVERLAY;
      } else if ("darken".equals(str)) {
        paramJSONArray = PorterDuff.Mode.DARKEN;
      }
    }
  }
  
  private void setLineCap(JSONArray paramJSONArray)
  {
    Object localObject = null;
    String str = paramJSONArray.optString(0);
    if ("butt".equals(str)) {
      paramJSONArray = Paint.Cap.BUTT;
    }
    for (;;)
    {
      if (paramJSONArray != null) {
        this.mStrokePaint.setStrokeCap(paramJSONArray);
      }
      return;
      if ("round".equals(str))
      {
        paramJSONArray = Paint.Cap.ROUND;
      }
      else
      {
        paramJSONArray = localObject;
        if ("square".equals(str)) {
          paramJSONArray = Paint.Cap.SQUARE;
        }
      }
    }
  }
  
  private void setLineDash(JSONArray paramJSONArray)
  {
    int i = 0;
    JSONArray localJSONArray = (JSONArray)paramJSONArray.opt(0);
    float f;
    if (localJSONArray.length() > 0)
    {
      f = mpx2px(paramJSONArray.optDouble(1, 0.0D));
      paramJSONArray = new float[localJSONArray.length()];
      while (i < localJSONArray.length())
      {
        paramJSONArray[i] = mpx2px(localJSONArray.optDouble(i, 0.0D));
        i += 1;
      }
    }
    for (paramJSONArray = new DashPathEffect(paramJSONArray, f);; paramJSONArray = null)
    {
      this.mFillPaint.setPathEffect(paramJSONArray);
      this.mStrokePaint.setPathEffect(paramJSONArray);
      return;
    }
  }
  
  private void setLineJoin(JSONArray paramJSONArray)
  {
    Object localObject = null;
    String str = paramJSONArray.optString(0);
    if ("bevel".equals(str)) {
      paramJSONArray = Paint.Join.BEVEL;
    }
    for (;;)
    {
      if (paramJSONArray != null) {
        this.mStrokePaint.setStrokeJoin(paramJSONArray);
      }
      return;
      if ("round".equals(str))
      {
        paramJSONArray = Paint.Join.ROUND;
      }
      else
      {
        paramJSONArray = localObject;
        if ("miter".equals(str)) {
          paramJSONArray = Paint.Join.MITER;
        }
      }
    }
  }
  
  private void setPathOrClip(Canvas paramCanvas, String paramString, JSONArray paramJSONArray)
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    this.mPath.reset();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      String str;
      if (localObject != null)
      {
        str = ((JSONObject)localObject).optString("method");
        localObject = ((JSONObject)localObject).optJSONArray("data");
        if (!"rect".equals(str)) {
          break label93;
        }
        pathActionRect((JSONArray)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("moveTo".equals(str))
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
    if ("normal".equals(localObject)) {
      setStyleColorTypeNormal(paramString, paramJSONArray);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!"radial".equals(localObject)) {
            break;
          }
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
        } while (!"setFillStyle".equals(paramString));
        this.mFillPaint.setShader(paramJSONArray);
        return;
        if (!"linear".equals(localObject)) {
          break;
        }
        localObject = paramJSONArray.optJSONArray(1);
        JSONArray localJSONArray = paramJSONArray.optJSONArray(2);
        paramJSONArray = localJSONArray.optJSONArray(0).optJSONArray(1);
        localJSONArray = localJSONArray.optJSONArray(1).optJSONArray(1);
        paramJSONArray = new LinearGradient(mpx2px(((JSONArray)localObject).optDouble(0)), mpx2px(((JSONArray)localObject).optDouble(1)), mpx2px(((JSONArray)localObject).optDouble(2)), mpx2px(((JSONArray)localObject).optDouble(3)), getColor(paramJSONArray), getColor(localJSONArray), Shader.TileMode.CLAMP);
        if ("setStrokeStyle".equals(paramString))
        {
          this.mStrokePaint.setShader(paramJSONArray);
          return;
        }
      } while (!"setFillStyle".equals(paramString));
      this.mFillPaint.setShader(paramJSONArray);
      return;
    } while (!"pattern".equals(localObject));
    setStrokeOrFillStyleForTypePatten(paramJSONArray);
  }
  
  private void setStrokeOrFillStyleForTypePatten(JSONArray paramJSONArray)
  {
    String str;
    if (paramJSONArray.length() == 3)
    {
      str = paramJSONArray.optString(1);
      if (StringUtil.isEmpty(str)) {
        break label131;
      }
      if (!str.startsWith("wxfile")) {
        break label83;
      }
      str = ((MiniAppFileManager)getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(str);
    }
    label131:
    for (;;)
    {
      paramJSONArray = paramJSONArray.optString(2);
      if ("repeat".equals(paramJSONArray))
      {
        this.mRepeatX = true;
        this.mRepeatY = true;
      }
      for (;;)
      {
        setStylePatternBitmapShader(str);
        return;
        label83:
        str = this.mApkgInfo.getChildFileAbsolutePath(str);
        break;
        if ("repeat-x".equals(paramJSONArray)) {
          this.mRepeatX = true;
        } else if ("repeat-y".equals(paramJSONArray)) {
          this.mRepeatY = true;
        }
      }
    }
  }
  
  private void setStyleColorTypeNormal(String paramString, JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optJSONArray(1);
    if ("setStrokeStyle".equals(paramString))
    {
      i = getColor(paramJSONArray);
      this.mStrokeColorAlpha = paramJSONArray.optInt(3);
      this.mStrokePaint.setShader(null);
      this.mStrokePaint.setColor(i);
    }
    while (!"setFillStyle".equals(paramString)) {
      return;
    }
    int i = getColor(paramJSONArray);
    this.mFillColorAlpha = paramJSONArray.optInt(3);
    this.mFillPaint.setShader(null);
    this.mFillPaint.setColor(i);
  }
  
  private void setStylePatternBitmapShader(String paramString)
  {
    Bitmap localBitmap;
    if (!StringUtil.isEmpty(paramString))
    {
      paramString = ImageUtil.getLocalBitmap(paramString);
      if (paramString != null)
      {
        this.mBitmapW = paramString.getWidth();
        this.mBitmapH = paramString.getHeight();
      }
      localObject = new Matrix();
      ((Matrix)localObject).postScale(this.mDensity, this.mDensity);
      localBitmap = Bitmap.createBitmap(paramString, 0, 0, this.mBitmapW, this.mBitmapH, (Matrix)localObject, true);
      if (localBitmap != null)
      {
        this.mBitmapW = localBitmap.getWidth();
        this.mBitmapH = localBitmap.getHeight();
        if (!this.mRepeatX) {
          break label142;
        }
        paramString = Shader.TileMode.REPEAT;
        if (!this.mRepeatY) {
          break label149;
        }
      }
    }
    label142:
    label149:
    for (Object localObject = Shader.TileMode.REPEAT;; localObject = Shader.TileMode.CLAMP)
    {
      paramString = new BitmapShader(localBitmap, paramString, (Shader.TileMode)localObject);
      this.mFillPaint.setShader(paramString);
      this.mStrokePaint.setShader(paramString);
      return;
      paramString = Shader.TileMode.CLAMP;
      break;
    }
  }
  
  private void setTextAlign(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0);
    if ("center".equals(paramJSONArray)) {
      paramJSONArray = Paint.Align.CENTER;
    }
    for (;;)
    {
      this.mFillPaint.setTextAlign(paramJSONArray);
      this.mStrokePaint.setTextAlign(paramJSONArray);
      return;
      if ("right".equals(paramJSONArray)) {
        paramJSONArray = Paint.Align.RIGHT;
      } else {
        paramJSONArray = Paint.Align.LEFT;
      }
    }
  }
  
  private void setUseHardwareAccelerate(boolean paramBoolean)
  {
    this.mUseHardwareAccelerate = paramBoolean;
    int i = getLayerType();
    if (paramBoolean) {
      if (i != 2) {
        setLayerType(2, null);
      }
    }
    while (i == 0) {
      return;
    }
    setLayerType(1, null);
    setLayerType(0, null);
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
    long l1;
    if ((this.mIsAttachedToWindow) && (paramDrawActionCommand != null))
    {
      this.mDrawActionCommandQueue.offer(paramDrawActionCommand);
      l1 = System.currentTimeMillis();
      if (this.mLastInvalidateTime != 0L) {
        break label47;
      }
      processDrawActionCommands();
      postInvalidate();
      this.mLastInvalidateTime = l1;
    }
    label47:
    long l2;
    do
    {
      return;
      l2 = l1 - this.mLastInvalidateTime;
      if (l2 >= 16L)
      {
        processDrawActionCommands();
        postInvalidate();
        this.mLastInvalidateTime = l1;
        return;
      }
    } while (this.mPendingDrawTaskTime != 0L);
    this.mPendingDrawTaskTime = l1;
    postDelayed(new CanvasView.26(this), 16L - l2);
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mMiniAppContext != null) {
      ServiceEvaluateCallbackAction.obtain(this.mMiniAppContext).callbackJsEventFail(paramString, paramJSONObject, paramInt);
    }
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mMiniAppContext != null) {
      ServiceEvaluateCallbackAction.obtain(this.mMiniAppContext).callbackJsEventOK(paramString, paramJSONObject, paramInt);
    }
  }
  
  protected void evaluateSubcribeJS(String paramString1, String paramString2)
  {
    if (this.mMiniAppContext != null) {
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, this.mNc.getPageWebviewContainer().getWebViewId()));
    }
  }
  
  public void getImageData(JSONObject paramJSONObject, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new CanvasView.1(this, paramNativeViewRequestEvent, paramJSONObject));
  }
  
  float mpx2px(double paramDouble)
  {
    return (float)(this.mDensity * paramDouble);
  }
  
  int mpx2pxInt(double paramDouble)
  {
    return (int)(this.mDensity * paramDouble + 0.5D);
  }
  
  public void onAttachedToWindow()
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
  
  public void onDetachedFromWindow()
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
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    super.onDraw(paramCanvas);
    try
    {
      if (getLayerType() == 0) {
        i = paramCanvas.saveLayer(this.mOffScreenCacheRect, null, 31);
      }
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      doDraw(paramCanvas, this.mCurrentDrawActions);
      if (i > 0) {
        paramCanvas.restoreToCount(i);
      }
      return;
    }
    catch (Throwable paramCanvas)
    {
      paramCanvas.printStackTrace();
      QMLog.e("CanvasView", "doDraw failed! " + Log.getStackTraceString(paramCanvas));
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mOffScreenCacheRect = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new JSONObject();
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.mHasGuesture)
    {
      localObject = this.mDisableScroll;
      if ((localObject == null) || (((Boolean)localObject).booleanValue() != true)) {
        break;
      }
      return true;
      QMLog.d("CanvasView", "--ACTION_DOWN--");
      handleTouchEvent(paramMotionEvent, (JSONObject)localObject, "onTouchStart");
      continue;
      QMLog.d("CanvasView", "--ACTION_POINTER_DOWN--" + paramMotionEvent.getPointerCount() + "   " + paramMotionEvent.getActionIndex() + "   " + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      handleTouchPointerEvent(paramMotionEvent, (JSONObject)localObject, "onTouchStart");
      continue;
      handleTouchMove(paramMotionEvent, (JSONObject)localObject);
      continue;
      QMLog.d("CanvasView", "--ACTION_UP--");
      handleTouchEvent(paramMotionEvent, (JSONObject)localObject, "onTouchEnd");
      continue;
      QMLog.d("CanvasView", "--ACTION_POINTER_UP--" + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      handleTouchPointerEvent(paramMotionEvent, (JSONObject)localObject, "onTouchEnd");
      continue;
      QMLog.d("CanvasView", "--ACTION_CANCEL--");
      handleTouchCancel(paramMotionEvent, (JSONObject)localObject);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  float px2mpx(double paramDouble)
  {
    return (float)(paramDouble / this.mDensity);
  }
  
  int px2mpxInt(double paramDouble)
  {
    return (int)(paramDouble / this.mDensity + 0.5D);
  }
  
  public void saveBitmap(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject)
  {
    boolean bool;
    if (paramJSONObject == null)
    {
      paramNativeViewContainer = "png";
      if ("jpg".equals(paramNativeViewContainer)) {
        break label70;
      }
      bool = true;
      label21:
      if ((getWidth() != 0) && (getHeight() != 0)) {
        break label76;
      }
    }
    label70:
    label76:
    for (long l = 300L;; l = 0L)
    {
      AppBrandTask.runTaskOnUiThreadDelay(new CanvasView.2(this, bool, paramNativeViewRequestEvent, paramJSONObject, paramNativeViewContainer), l);
      return;
      paramNativeViewContainer = paramJSONObject.optString("fileType");
      break;
      bool = false;
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */