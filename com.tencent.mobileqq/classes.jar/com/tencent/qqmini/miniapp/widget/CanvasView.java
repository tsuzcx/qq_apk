package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.action.ServiceEvaluateCallbackAction;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
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
  
  private void doDraw(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.getJSONObject(i);
      Object localObject3 = ((JSONObject)localObject2).optString("method");
      Object localObject1 = ((JSONObject)localObject2).optJSONArray("data");
      if ("drawImage".equals(localObject3)) {
        drawImage(paramCanvas, (JSONArray)localObject1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (("setStrokeStyle".equals(localObject3)) || ("setFillStyle".equals(localObject3)))
        {
          setStrokeOrFillStyle((String)localObject3, (JSONArray)localObject1);
        }
        else if (("strokePath".equals(localObject3)) || ("fillPath".equals(localObject3)) || ("clip".equals(localObject3)))
        {
          setPathOrClip(paramCanvas, (String)localObject3, (JSONArray)localObject1);
        }
        else
        {
          float f1;
          if ("setFontSize".equals(localObject3))
          {
            f1 = mpx2px(((JSONArray)localObject1).optDouble(0, 0.0D));
            this.mFillPaint.setTextSize(f1);
            this.mStrokePaint.setTextSize(f1);
          }
          else if ("setFontStyle".equals(localObject3))
          {
            setFontStyle((JSONArray)localObject1);
          }
          else if ("setFontWeight".equals(localObject3))
          {
            setFontWeight((JSONArray)localObject1);
          }
          else
          {
            if ("setFontFamily".equals(localObject3))
            {
              localObject1 = ((JSONArray)localObject1).optString(0);
              localObject2 = this.mFillPaint.getTypeface();
              if (localObject2 != null)
              {
                j = ((Typeface)localObject2).getStyle();
                label260:
                this.mFillPaint.setTypeface(Typeface.create((String)localObject1, j));
                localObject1 = this.mStrokePaint.getTypeface();
                if (localObject1 == null) {
                  break label320;
                }
              }
              label320:
              for (int j = ((Typeface)localObject1).getStyle();; j = 0)
              {
                this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject1, j));
                break;
                j = 0;
                break label260;
              }
            }
            if ("setTextAlign".equals(localObject3))
            {
              setTextAlign((JSONArray)localObject1);
            }
            else if (("fillText".equals(localObject3)) || ("strokeText".equals(localObject3)))
            {
              setFillOrStrokeText(paramCanvas, (String)localObject3, (JSONArray)localObject1);
            }
            else if ("setGlobalAlpha".equals(localObject3))
            {
              this.mGlobalAlpha = ((JSONArray)localObject1).optInt(0, 0);
            }
            else if ("restore".equals(localObject3))
            {
              try
              {
                paramCanvas.restore();
                this.mFillPaint = this.mSaveFillPaint;
                this.mStrokePaint = this.mSaveStrokePaint;
                this.mGlobalAlpha = this.mSaveGlobalAlpha;
                this.mFillColorAlpha = this.mSaveFillColorAlpha;
                this.mStrokeColorAlpha = this.mSaveStrokeColorAlpha;
                this.mTextBaseline = this.mSaveTextBaseline;
                this.mRepeatX = this.mSaveRepeatX;
                this.mRepeatY = this.mSaveRepeatY;
                this.mBitmapW = this.mSaveBitmapW;
                this.mBitmapH = this.mSaveBitmapH;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  QMLog.e("CanvasView", "ACTION_RESTORE: " + Log.getStackTraceString(localException));
                }
              }
            }
            else if ("save".equals(localObject3))
            {
              paramCanvas.save();
              this.mSaveFillPaint = new Paint(this.mFillPaint);
              this.mSaveStrokePaint = new Paint(this.mStrokePaint);
              this.mSaveGlobalAlpha = this.mGlobalAlpha;
              this.mSaveFillColorAlpha = this.mFillColorAlpha;
              this.mSaveStrokeColorAlpha = this.mStrokeColorAlpha;
              this.mSaveTextBaseline = this.mTextBaseline;
              this.mSaveRepeatX = this.mRepeatX;
              this.mSaveRepeatY = this.mRepeatY;
              this.mSaveBitmapW = this.mBitmapW;
              this.mSaveBitmapH = this.mBitmapH;
            }
            else if ("clearRect".equals(localObject3))
            {
              clearRect(paramCanvas, localException);
            }
            else if ("setGlobalCompositeOperation".equals(localObject3))
            {
              setGlobalCompositeOperation(localException);
            }
            else if ("rotate".equals(localObject3))
            {
              paramCanvas.rotate((float)(localException.optDouble(0, 0.0D) * 180.0D / 3.141592653589793D));
            }
            else if ("scale".equals(localObject3))
            {
              paramCanvas.scale((float)localException.optDouble(0, 1.0D), (float)localException.optDouble(1, 1.0D));
            }
            else if ("translate".equals(localObject3))
            {
              paramCanvas.translate(mpx2px(localException.optDouble(0, 0.0D)), mpx2px(localException.optDouble(1, 0.0D)));
            }
            else if ("setLineWidth".equals(localObject3))
            {
              f1 = mpx2px(localException.optDouble(0, 0.0D));
              this.mStrokePaint.setStrokeWidth(f1);
            }
            else if ("setShadow".equals(localObject3))
            {
              localObject2 = new CanvasView.ShadowLayer(this);
              localObject3 = localException.optJSONArray(3);
              f1 = mpx2px(localException.optDouble(2, 0.0D));
              float f2 = mpx2px(localException.optDouble(0, 0.0D));
              float f3 = mpx2px(localException.optDouble(1, 0.0D));
              ((CanvasView.ShadowLayer)localObject2).radius = f1;
              ((CanvasView.ShadowLayer)localObject2).dx = f2;
              ((CanvasView.ShadowLayer)localObject2).dy = f3;
              ((CanvasView.ShadowLayer)localObject2).color = getColor((JSONArray)localObject3);
              this.mFillPaint.setShadowLayer(((CanvasView.ShadowLayer)localObject2).radius, ((CanvasView.ShadowLayer)localObject2).dx, ((CanvasView.ShadowLayer)localObject2).dy, ((CanvasView.ShadowLayer)localObject2).color);
              this.mStrokePaint.setShadowLayer(((CanvasView.ShadowLayer)localObject2).radius, ((CanvasView.ShadowLayer)localObject2).dx, ((CanvasView.ShadowLayer)localObject2).dy, ((CanvasView.ShadowLayer)localObject2).color);
            }
            else if ("setLineCap".equals(localObject3))
            {
              setLineCap(localException);
            }
            else if ("setLineJoin".equals(localObject3))
            {
              setLineJoin(localException);
            }
            else if ("setLineDash".equals(localObject3))
            {
              setLineDash(localException);
            }
            else if ("setMiterLimit".equals(localObject3))
            {
              f1 = mpx2px(localException.optDouble(0, 0.0D));
              this.mFillPaint.setStrokeMiter(f1);
              this.mStrokePaint.setStrokeMiter(f1);
            }
            else if (("setTransform".equals(localObject3)) || ("transform".equals(localObject3)))
            {
              transform(paramCanvas, (String)localObject3, localException);
            }
            else if ("setTextBaseline".equals(localObject3))
            {
              this.mTextBaseline = localException.optString(0);
            }
            else if ("canvasPutImageData".equals(localObject3))
            {
              putImageData(paramCanvas, (String)localObject3, ((JSONObject)localObject2).optJSONObject("data"), ((JSONObject)localObject2).optInt("callbackId"));
            }
          }
        }
      }
    }
    this.mFillPaint.setShader(null);
    this.mFillPaint.setColor(-16777216);
    this.mFillPaint.clearShadowLayer();
    this.mStrokePaint.setShader(null);
    this.mStrokePaint.setColor(-16777216);
    this.mStrokePaint.clearShadowLayer();
  }
  
  /* Error */
  private void drawImage(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokevirtual 425	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   5: astore 18
    //   7: aload 18
    //   9: invokestatic 586	com/tencent/qqmini/sdk/core/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   12: ifne +777 -> 789
    //   15: aload_0
    //   16: invokespecial 311	com/tencent/qqmini/miniapp/widget/CanvasView:getMiniAppContext	()Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   19: ldc_w 588
    //   22: invokeinterface 592 2 0
    //   27: checkcast 588	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   30: aload 18
    //   32: invokevirtual 595	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 18
    //   37: aload 18
    //   39: invokestatic 586	com/tencent/qqmini/sdk/core/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   42: ifne +315 -> 357
    //   45: aload_2
    //   46: iconst_1
    //   47: dconst_0
    //   48: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   51: d2f
    //   52: fstore 9
    //   54: aload_2
    //   55: iconst_2
    //   56: dconst_0
    //   57: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   60: d2f
    //   61: fstore 10
    //   63: aload_2
    //   64: iconst_3
    //   65: dconst_0
    //   66: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   69: d2f
    //   70: fstore 6
    //   72: aload_2
    //   73: iconst_4
    //   74: dconst_0
    //   75: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   78: d2f
    //   79: fstore 5
    //   81: aload_2
    //   82: iconst_5
    //   83: dconst_0
    //   84: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   87: d2i
    //   88: istore 12
    //   90: aload_2
    //   91: bipush 6
    //   93: dconst_0
    //   94: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   97: d2i
    //   98: istore 13
    //   100: aload_2
    //   101: bipush 7
    //   103: dconst_0
    //   104: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   107: d2i
    //   108: istore 14
    //   110: aload_2
    //   111: bipush 8
    //   113: dconst_0
    //   114: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   117: d2i
    //   118: istore 15
    //   120: new 597	android/graphics/BitmapFactory$Options
    //   123: dup
    //   124: invokespecial 598	android/graphics/BitmapFactory$Options:<init>	()V
    //   127: astore 19
    //   129: aload 18
    //   131: invokestatic 603	com/tencent/qqmini/sdk/core/utils/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   134: istore 16
    //   136: fload 6
    //   138: fstore_3
    //   139: aload 19
    //   141: iconst_1
    //   142: putfield 606	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   145: fload 6
    //   147: fstore_3
    //   148: aload 18
    //   150: aload 19
    //   152: invokestatic 612	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   155: pop
    //   156: fload 6
    //   158: fconst_0
    //   159: fcmpg
    //   160: ifle +17 -> 177
    //   163: fload 5
    //   165: fstore_3
    //   166: fload 6
    //   168: fstore 4
    //   170: fload 5
    //   172: fconst_0
    //   173: fcmpg
    //   174: ifgt +22 -> 196
    //   177: iload 14
    //   179: ifle +179 -> 358
    //   182: iload 15
    //   184: ifle +174 -> 358
    //   187: iload 14
    //   189: i2f
    //   190: fstore 4
    //   192: iload 15
    //   194: i2f
    //   195: fstore_3
    //   196: fload 4
    //   198: fconst_0
    //   199: fcmpl
    //   200: ifle +157 -> 357
    //   203: fload_3
    //   204: fconst_0
    //   205: fcmpl
    //   206: ifle +151 -> 357
    //   209: aload 19
    //   211: iconst_1
    //   212: putfield 615	android/graphics/BitmapFactory$Options:inDither	Z
    //   215: iload 14
    //   217: ifle +286 -> 503
    //   220: iload 15
    //   222: ifle +281 -> 503
    //   225: aload 18
    //   227: iconst_0
    //   228: invokestatic 621	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/lang/String;Z)Landroid/graphics/BitmapRegionDecoder;
    //   231: astore 18
    //   233: aload 18
    //   235: aload_0
    //   236: iload 12
    //   238: iload 13
    //   240: iload 14
    //   242: iload 15
    //   244: aload 19
    //   246: iload 16
    //   248: invokespecial 625	com/tencent/qqmini/miniapp/widget/CanvasView:getCropRect	(IIIILandroid/graphics/BitmapFactory$Options;I)Landroid/graphics/Rect;
    //   251: aload 19
    //   253: invokevirtual 629	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   256: astore_2
    //   257: aload 18
    //   259: invokevirtual 632	android/graphics/BitmapRegionDecoder:recycle	()V
    //   262: aload_2
    //   263: ifnull +94 -> 357
    //   266: aload_2
    //   267: astore 18
    //   269: iload 16
    //   271: ifeq +11 -> 282
    //   274: iload 16
    //   276: aload_2
    //   277: invokestatic 636	com/tencent/qqmini/sdk/core/utils/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   280: astore 18
    //   282: new 348	android/graphics/RectF
    //   285: dup
    //   286: invokespecial 349	android/graphics/RectF:<init>	()V
    //   289: astore_2
    //   290: aload_2
    //   291: aload_0
    //   292: fload 9
    //   294: f2d
    //   295: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   298: putfield 352	android/graphics/RectF:left	F
    //   301: aload_2
    //   302: aload_0
    //   303: fload 10
    //   305: f2d
    //   306: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   309: putfield 355	android/graphics/RectF:top	F
    //   312: aload_2
    //   313: aload_2
    //   314: getfield 352	android/graphics/RectF:left	F
    //   317: aload_0
    //   318: fload 4
    //   320: f2d
    //   321: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   324: fadd
    //   325: putfield 358	android/graphics/RectF:right	F
    //   328: aload_2
    //   329: aload_2
    //   330: getfield 355	android/graphics/RectF:top	F
    //   333: aload_0
    //   334: fload_3
    //   335: f2d
    //   336: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   339: fadd
    //   340: putfield 361	android/graphics/RectF:bottom	F
    //   343: aload_1
    //   344: aload 18
    //   346: aconst_null
    //   347: aload_2
    //   348: aconst_null
    //   349: invokevirtual 640	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   352: aload 18
    //   354: invokevirtual 643	android/graphics/Bitmap:recycle	()V
    //   357: return
    //   358: iload 16
    //   360: bipush 90
    //   362: if_icmpeq +11 -> 373
    //   365: iload 16
    //   367: sipush 270
    //   370: if_icmpne +31 -> 401
    //   373: fload 6
    //   375: fstore_3
    //   376: aload 19
    //   378: getfield 646	android/graphics/BitmapFactory$Options:outHeight	I
    //   381: i2f
    //   382: fstore 4
    //   384: fload 4
    //   386: fstore_3
    //   387: aload 19
    //   389: getfield 649	android/graphics/BitmapFactory$Options:outWidth	I
    //   392: i2f
    //   393: fstore 6
    //   395: fload 6
    //   397: fstore_3
    //   398: goto -202 -> 196
    //   401: fload 6
    //   403: fstore_3
    //   404: aload 19
    //   406: getfield 649	android/graphics/BitmapFactory$Options:outWidth	I
    //   409: i2f
    //   410: fstore 4
    //   412: fload 4
    //   414: fstore_3
    //   415: aload 19
    //   417: getfield 646	android/graphics/BitmapFactory$Options:outHeight	I
    //   420: istore 17
    //   422: iload 17
    //   424: i2f
    //   425: fstore_3
    //   426: goto -230 -> 196
    //   429: astore_2
    //   430: fload_3
    //   431: fstore 4
    //   433: ldc 149
    //   435: new 476	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 651
    //   445: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_2
    //   449: invokestatic 489	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   452: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 499	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: fload 5
    //   463: fstore_3
    //   464: goto -268 -> 196
    //   467: astore 18
    //   469: aconst_null
    //   470: astore_2
    //   471: ldc 149
    //   473: new 476	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 653
    //   483: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 18
    //   488: invokestatic 489	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   491: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 499	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: goto -238 -> 262
    //   503: aload 19
    //   505: iconst_0
    //   506: putfield 606	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   509: aload 19
    //   511: getfield 649	android/graphics/BitmapFactory$Options:outWidth	I
    //   514: i2f
    //   515: fstore 8
    //   517: aload 19
    //   519: getfield 646	android/graphics/BitmapFactory$Options:outHeight	I
    //   522: i2f
    //   523: fstore 7
    //   525: fload 4
    //   527: fload_3
    //   528: fmul
    //   529: aload 19
    //   531: getfield 649	android/graphics/BitmapFactory$Options:outWidth	I
    //   534: i2f
    //   535: fdiv
    //   536: aload 19
    //   538: getfield 646	android/graphics/BitmapFactory$Options:outHeight	I
    //   541: i2f
    //   542: fdiv
    //   543: f2d
    //   544: invokestatic 659	java/lang/Math:sqrt	(D)D
    //   547: d2f
    //   548: fstore 11
    //   550: fload 7
    //   552: fstore 6
    //   554: fload 8
    //   556: fstore 5
    //   558: fload 11
    //   560: fconst_1
    //   561: fcmpg
    //   562: ifge +17 -> 579
    //   565: fload 8
    //   567: fload 11
    //   569: fmul
    //   570: fstore 5
    //   572: fload 7
    //   574: fload 11
    //   576: fmul
    //   577: fstore 6
    //   579: aload 18
    //   581: invokestatic 662	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   584: ifeq +102 -> 686
    //   587: aload 19
    //   589: getstatic 668	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   592: putfield 671	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   595: ldc2_w 145
    //   598: fload 5
    //   600: f2d
    //   601: ddiv
    //   602: fload 6
    //   604: f2d
    //   605: ddiv
    //   606: ldc2_w 672
    //   609: ddiv
    //   610: invokestatic 659	java/lang/Math:sqrt	(D)D
    //   613: d2f
    //   614: fstore 7
    //   616: fload 7
    //   618: fconst_1
    //   619: fcmpg
    //   620: ifge +112 -> 732
    //   623: aload 19
    //   625: aload 19
    //   627: fload 5
    //   629: fload 7
    //   631: fmul
    //   632: fload 6
    //   634: fload 7
    //   636: fmul
    //   637: invokestatic 677	com/tencent/qqmini/sdk/core/utils/ImageUtil:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;FF)I
    //   640: putfield 680	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   643: aload 18
    //   645: aload 19
    //   647: invokestatic 612	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   650: astore_2
    //   651: aload_2
    //   652: ifnonnull +134 -> 786
    //   655: aload 19
    //   657: getfield 680	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   660: ifle +97 -> 757
    //   663: aload 19
    //   665: aload 19
    //   667: getfield 680	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   670: iconst_2
    //   671: imul
    //   672: putfield 680	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   675: aload 18
    //   677: aload 19
    //   679: invokestatic 612	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   682: astore_2
    //   683: goto -421 -> 262
    //   686: aload 19
    //   688: getstatic 683	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   691: putfield 671	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   694: ldc2_w 145
    //   697: fload 5
    //   699: f2d
    //   700: ddiv
    //   701: fload 6
    //   703: f2d
    //   704: ddiv
    //   705: ldc2_w 684
    //   708: ddiv
    //   709: invokestatic 659	java/lang/Math:sqrt	(D)D
    //   712: d2f
    //   713: fstore 7
    //   715: goto -99 -> 616
    //   718: astore_2
    //   719: ldc 149
    //   721: ldc_w 687
    //   724: invokestatic 690	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: aconst_null
    //   728: astore_2
    //   729: goto -78 -> 651
    //   732: aload 18
    //   734: aload 19
    //   736: invokestatic 612	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   739: astore_2
    //   740: goto -89 -> 651
    //   743: astore_2
    //   744: ldc 149
    //   746: ldc_w 692
    //   749: invokestatic 690	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   752: aconst_null
    //   753: astore_2
    //   754: goto -103 -> 651
    //   757: aload 19
    //   759: iconst_2
    //   760: putfield 680	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   763: goto -88 -> 675
    //   766: astore_2
    //   767: ldc 149
    //   769: ldc_w 694
    //   772: aload_2
    //   773: invokestatic 697	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   776: aconst_null
    //   777: astore_2
    //   778: goto -516 -> 262
    //   781: astore 18
    //   783: goto -312 -> 471
    //   786: goto -524 -> 262
    //   789: goto -752 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	792	0	this	CanvasView
    //   0	792	1	paramCanvas	Canvas
    //   0	792	2	paramJSONArray	JSONArray
    //   138	390	3	f1	float
    //   168	358	4	f2	float
    //   79	619	5	f3	float
    //   70	632	6	f4	float
    //   523	191	7	f5	float
    //   515	51	8	f6	float
    //   52	241	9	f7	float
    //   61	243	10	f8	float
    //   548	27	11	f9	float
    //   88	149	12	i	int
    //   98	141	13	j	int
    //   108	133	14	k	int
    //   118	125	15	m	int
    //   134	237	16	n	int
    //   420	3	17	i1	int
    //   5	348	18	localObject	Object
    //   467	266	18	localException1	Exception
    //   781	1	18	localException2	Exception
    //   127	631	19	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   139	145	429	java/lang/Exception
    //   148	156	429	java/lang/Exception
    //   376	384	429	java/lang/Exception
    //   387	395	429	java/lang/Exception
    //   404	412	429	java/lang/Exception
    //   415	422	429	java/lang/Exception
    //   225	257	467	java/lang/Exception
    //   643	651	718	java/lang/Throwable
    //   732	740	743	java/lang/Throwable
    //   675	683	766	java/lang/Throwable
    //   257	262	781	java/lang/Exception
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
    //   4: ldc_w 774
    //   7: invokevirtual 567	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10: istore 9
    //   12: aload_3
    //   13: ldc_w 789
    //   16: invokevirtual 567	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   19: istore 10
    //   21: aload_3
    //   22: ldc_w 876
    //   25: invokevirtual 567	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   28: istore 11
    //   30: aload_3
    //   31: ldc_w 878
    //   34: invokevirtual 567	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   37: istore 12
    //   39: aconst_null
    //   40: aload_3
    //   41: ldc 139
    //   43: invokestatic 884	com/tencent/qqmini/sdk/core/utils/NativeBuffer:unpackNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;Lorg/json/JSONObject;Ljava/lang/String;)Lcom/tencent/qqmini/sdk/core/utils/NativeBuffer;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +364 -> 412
    //   51: aload_3
    //   52: getfield 888	com/tencent/qqmini/sdk/core/utils/NativeBuffer:buf	[B
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
    //   164: invokestatic 737	android/graphics/Color:argb	(IIII)I
    //   167: iastore
    //   168: iload 8
    //   170: iconst_1
    //   171: iadd
    //   172: istore 8
    //   174: goto -103 -> 71
    //   177: iload 11
    //   179: iload 12
    //   181: getstatic 668	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   184: invokestatic 722	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   187: astore_3
    //   188: aload_3
    //   189: aload 19
    //   191: iconst_0
    //   192: iload 11
    //   194: iconst_0
    //   195: iconst_0
    //   196: iload 11
    //   198: iload 12
    //   200: invokevirtual 892	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   203: new 259	android/graphics/Paint
    //   206: dup
    //   207: invokespecial 893	android/graphics/Paint:<init>	()V
    //   210: astore 18
    //   212: aload 18
    //   214: iconst_1
    //   215: invokevirtual 896	android/graphics/Paint:setAntiAlias	(Z)V
    //   218: aload_0
    //   219: iload 9
    //   221: i2d
    //   222: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   225: fstore 5
    //   227: aload_0
    //   228: iload 10
    //   230: i2d
    //   231: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   234: fstore 6
    //   236: aload_1
    //   237: aload_3
    //   238: aconst_null
    //   239: new 348	android/graphics/RectF
    //   242: dup
    //   243: fload 5
    //   245: fload 6
    //   247: aload_0
    //   248: iload 11
    //   250: i2d
    //   251: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   254: fload 5
    //   256: fadd
    //   257: aload_0
    //   258: iload 12
    //   260: i2d
    //   261: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   264: fload 6
    //   266: fadd
    //   267: invokespecial 899	android/graphics/RectF:<init>	(FFFF)V
    //   270: aload 18
    //   272: invokevirtual 640	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   275: aload_0
    //   276: aload_2
    //   277: aconst_null
    //   278: iload 4
    //   280: invokevirtual 903	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventOK	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   283: aload_3
    //   284: ifnull +14 -> 298
    //   287: aload_3
    //   288: invokevirtual 907	android/graphics/Bitmap:isRecycled	()Z
    //   291: ifne +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 643	android/graphics/Bitmap:recycle	()V
    //   298: return
    //   299: astore_3
    //   300: aconst_null
    //   301: astore_1
    //   302: ldc 149
    //   304: new 476	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 909
    //   314: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokestatic 489	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   321: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 499	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_0
    //   331: aload_2
    //   332: aconst_null
    //   333: iload 4
    //   335: invokevirtual 912	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   338: aload_1
    //   339: ifnull -41 -> 298
    //   342: aload_1
    //   343: invokevirtual 907	android/graphics/Bitmap:isRecycled	()Z
    //   346: ifne -48 -> 298
    //   349: aload_1
    //   350: invokevirtual 643	android/graphics/Bitmap:recycle	()V
    //   353: return
    //   354: astore_1
    //   355: aload 18
    //   357: astore_2
    //   358: aload_2
    //   359: ifnull +14 -> 373
    //   362: aload_2
    //   363: invokevirtual 907	android/graphics/Bitmap:isRecycled	()Z
    //   366: ifne +7 -> 373
    //   369: aload_2
    //   370: invokevirtual 643	android/graphics/Bitmap:recycle	()V
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
    int j = 3;
    int k = 1;
    paramJSONArray = paramJSONArray.optString(0, "normal");
    if ("normal".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      if ((paramJSONArray != null) && (paramJSONArray.isBold()))
      {
        i = 1;
        this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
        paramJSONArray = this.mStrokePaint.getTypeface();
        if ((paramJSONArray == null) || (!paramJSONArray.isBold())) {
          break label97;
        }
        i = k;
        this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      }
    }
    label97:
    while ((!"italic".equals(paramJSONArray)) && (!"oblique".equals(paramJSONArray))) {
      for (;;)
      {
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
    paramJSONArray = this.mFillPaint.getTypeface();
    if ((paramJSONArray != null) && (paramJSONArray.isBold()))
    {
      i = 3;
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      if ((paramJSONArray == null) || (!paramJSONArray.isBold())) {
        break label196;
      }
    }
    label196:
    for (int i = j;; i = 2)
    {
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      return;
      i = 2;
      break;
    }
  }
  
  private void setFontWeight(JSONArray paramJSONArray)
  {
    int j = 3;
    int k = 2;
    paramJSONArray = paramJSONArray.optString(0);
    if ("normal".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      if ((paramJSONArray != null) && (paramJSONArray.isItalic()))
      {
        i = 2;
        this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
        paramJSONArray = this.mStrokePaint.getTypeface();
        if ((paramJSONArray == null) || (!paramJSONArray.isItalic())) {
          break label95;
        }
        i = k;
        this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      }
    }
    label95:
    while (!"bold".equals(paramJSONArray)) {
      for (;;)
      {
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
    paramJSONArray = this.mFillPaint.getTypeface();
    if ((paramJSONArray != null) && (paramJSONArray.isItalic()))
    {
      i = 3;
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      if ((paramJSONArray == null) || (!paramJSONArray.isItalic())) {
        break label184;
      }
    }
    label184:
    for (int i = j;; i = 1)
    {
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      return;
      i = 1;
      break;
    }
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
    Object localObject2;
    Object localObject1;
    float f2;
    float f6;
    float f3;
    float f5;
    if (i < paramJSONArray.length())
    {
      localObject2 = paramJSONArray.optJSONObject(i);
      if (localObject2 != null)
      {
        localObject1 = ((JSONObject)localObject2).optString("method");
        localObject2 = ((JSONObject)localObject2).optJSONArray("data");
        if (!"rect".equals(localObject1)) {
          break label401;
        }
        f2 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
        f6 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
        f3 = mpx2px(((JSONArray)localObject2).optDouble(2, 0.0D));
        f5 = mpx2px(((JSONArray)localObject2).optDouble(3, 0.0D));
        if (f3 > 0.0F) {
          break label1177;
        }
        f1 = -f3;
        f2 += f3;
        f3 = f1;
      }
    }
    label272:
    label401:
    label1177:
    for (float f1 = f2;; f1 = f2)
    {
      float f4 = f5;
      f2 = f6;
      if (f5 <= 0.0F)
      {
        f2 = f6 + f5;
        f4 = -f5;
      }
      localObject1 = new RectF();
      if (((this.mRepeatX) || (this.mRepeatY)) && ((this.mBitmapW != 0) || (this.mBitmapH != 0)))
      {
        if (this.mRepeatX) {
          f1 = 0.0F;
        }
        ((RectF)localObject1).left = f1;
        if (this.mRepeatY) {
          f2 = 0.0F;
        }
        ((RectF)localObject1).top = f2;
        if (this.mRepeatX)
        {
          f1 = ((RectF)localObject1).left + f3;
          ((RectF)localObject1).right = f1;
          if (!this.mRepeatY) {
            break label348;
          }
          f1 = f4 + ((RectF)localObject1).top;
          label296:
          ((RectF)localObject1).bottom = f1;
          label303:
          this.mPath.addRect((RectF)localObject1, Path.Direction.CW);
          f1 = ((RectF)localObject1).right;
          f1 = ((RectF)localObject1).bottom;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        f1 = this.mBitmapW;
        break label272;
        label348:
        f1 = this.mBitmapH;
        break label296;
        ((RectF)localObject1).left = f1;
        ((RectF)localObject1).top = f2;
        ((RectF)localObject1).right = (((RectF)localObject1).left + f3);
        ((RectF)localObject1).bottom = (f4 + ((RectF)localObject1).top);
        break label303;
        if ("moveTo".equals(localObject1))
        {
          f1 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
          f2 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
          this.mPath.moveTo(f1, f2);
        }
        else if ("lineTo".equals(localObject1))
        {
          f1 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
          f2 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
          if (this.mPath.isEmpty()) {
            this.mPath.moveTo(f1, f2);
          } else {
            this.mPath.lineTo(f1, f2);
          }
        }
        else if ("closePath".equals(localObject1))
        {
          this.mPath.close();
        }
        else
        {
          if ("arc".equals(localObject1))
          {
            f5 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
            f3 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
            f4 = mpx2px(((JSONArray)localObject2).optDouble(2, 0.0D));
            double d1 = ((JSONArray)localObject2).optDouble(3, 0.0D);
            double d2 = ((JSONArray)localObject2).optDouble(4, 0.0D);
            f6 = (float)(d1 / 3.141592653589793D * 180.0D);
            f1 = (float)(d2 / 3.141592653589793D * 180.0D);
            boolean bool = paramJSONArray.optBoolean(5);
            localObject1 = new RectF(f5 - f4, f3 - f4, f5 + f4, f3 + f4);
            if (bool)
            {
              f1 = f6 - f1;
              label686:
              f2 = f1 % 360.0F;
              f1 = f2;
              if (f2 <= 0.0F) {
                f1 = f2 + 360.0F;
              }
              if (!this.mPath.isEmpty()) {
                break label781;
              }
              this.mPath.addArc((RectF)localObject1, f6, f1);
            }
            for (;;)
            {
              f1 = (float)(f5 + f4 * Math.cos(d2));
              f1 = (float)(f3 + f4 * Math.sin(d2));
              break;
              f1 -= f6;
              break label686;
              f2 = (float)(f5 + f4 * Math.cos(d1));
              double d3 = f3;
              double d4 = f4;
              f2 = (float)(Math.sin(d1) * d4 + d3);
              if (Math.abs(Math.abs(f1) - 360.0F) < 1.0E-014D) {
                this.mPath.addArc((RectF)localObject1, f6, f1);
              } else {
                this.mPath.arcTo((RectF)localObject1, f6, f1);
              }
            }
          }
          if ("quadraticCurveTo".equals(localObject1))
          {
            f1 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
            f2 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
            f3 = mpx2px(((JSONArray)localObject2).optDouble(2, 0.0D));
            f4 = mpx2px(((JSONArray)localObject2).optDouble(3, 0.0D));
            if (this.mPath.isEmpty()) {
              this.mPath.moveTo(f1, f2);
            }
            this.mPath.quadTo(f1, f2, f3, f4);
          }
          else if ("bezierCurveTo".equals(localObject1))
          {
            f1 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
            f2 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
            f3 = mpx2px(((JSONArray)localObject2).optDouble(2, 0.0D));
            f4 = mpx2px(((JSONArray)localObject2).optDouble(3, 0.0D));
            f5 = mpx2px(((JSONArray)localObject2).optDouble(4, 0.0D));
            f6 = mpx2px(((JSONArray)localObject2).optDouble(5, 0.0D));
            if (this.mPath.isEmpty()) {
              this.mPath.moveTo(f1, f2);
            }
            this.mPath.cubicTo(f1, f2, f3, f4, f5, f6);
          }
          else if ("translate".equals(localObject1))
          {
            paramCanvas.translate(mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D)), mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D)));
          }
        }
      }
      if ("clip".equals(paramString))
      {
        paramCanvas.clipPath(this.mPath);
        return;
      }
      paramCanvas.drawPath(this.mPath, getCurrentPaint(paramString));
      return;
    }
  }
  
  private void setStrokeOrFillStyle(String paramString, JSONArray paramJSONArray)
  {
    this.mRepeatX = false;
    this.mRepeatY = false;
    this.mBitmapW = 0;
    this.mBitmapH = 0;
    Object localObject = paramJSONArray.optString(0);
    int i;
    if ("normal".equals(localObject))
    {
      paramJSONArray = paramJSONArray.optJSONArray(1);
      if ("setStrokeStyle".equals(paramString))
      {
        i = getColor(paramJSONArray);
        this.mStrokeColorAlpha = paramJSONArray.optInt(3);
        this.mStrokePaint.setShader(null);
        this.mStrokePaint.setColor(i);
      }
    }
    label84:
    do
    {
      do
      {
        do
        {
          break label84;
          break label84;
          do
          {
            return;
          } while (!"setFillStyle".equals(paramString));
          i = getColor(paramJSONArray);
          this.mFillColorAlpha = paramJSONArray.optInt(3);
          this.mFillPaint.setShader(null);
          this.mFillPaint.setColor(i);
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
    } while ((!"pattern".equals(localObject)) || (paramJSONArray.length() != 3));
    paramString = paramJSONArray.optString(1);
    if (!StringUtil.isEmpty(paramString)) {
      if (paramString.startsWith("wxfile")) {
        paramString = ((MiniAppFileManager)getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      }
    }
    for (;;)
    {
      label473:
      paramJSONArray = paramJSONArray.optString(2);
      if ("repeat".equals(paramJSONArray))
      {
        this.mRepeatX = true;
        this.mRepeatY = true;
        label499:
        if (StringUtil.isEmpty(paramString)) {
          break label692;
        }
        paramString = ImageUtil.getLocalBitmap(paramString);
        if (paramString != null)
        {
          this.mBitmapW = paramString.getWidth();
          this.mBitmapH = paramString.getHeight();
        }
        paramJSONArray = new Matrix();
        paramJSONArray.postScale(this.mDensity, this.mDensity);
        localObject = Bitmap.createBitmap(paramString, 0, 0, this.mBitmapW, this.mBitmapH, paramJSONArray, true);
        if (localObject == null) {
          break;
        }
        this.mBitmapW = ((Bitmap)localObject).getWidth();
        this.mBitmapH = ((Bitmap)localObject).getHeight();
        if (!this.mRepeatX) {
          break label694;
        }
        paramString = Shader.TileMode.REPEAT;
        label604:
        if (!this.mRepeatY) {
          break label701;
        }
      }
      label692:
      label694:
      label701:
      for (paramJSONArray = Shader.TileMode.REPEAT;; paramJSONArray = Shader.TileMode.CLAMP)
      {
        paramString = new BitmapShader((Bitmap)localObject, paramString, paramJSONArray);
        this.mFillPaint.setShader(paramString);
        this.mStrokePaint.setShader(paramString);
        return;
        paramString = this.mApkgInfo.getChildFileAbsolutePath(paramString);
        break label473;
        if ("repeat-x".equals(paramJSONArray))
        {
          this.mRepeatX = true;
          break label499;
        }
        if (!"repeat-y".equals(paramJSONArray)) {
          break label499;
        }
        this.mRepeatY = true;
        break label499;
        break;
        paramString = Shader.TileMode.CLAMP;
        break label604;
      }
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
    postDelayed(new CanvasView.3(this), 16L - l2);
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
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */