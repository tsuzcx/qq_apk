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
    //   12: ifne +802 -> 814
    //   15: aload 18
    //   17: ldc_w 588
    //   20: invokevirtual 591	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   23: ifeq +346 -> 369
    //   26: aload_0
    //   27: invokespecial 311	com/tencent/qqmini/miniapp/widget/CanvasView:getMiniAppContext	()Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   30: ldc_w 593
    //   33: invokeinterface 597 2 0
    //   38: checkcast 593	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   41: aload 18
    //   43: invokevirtual 600	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 18
    //   48: aload 18
    //   50: invokestatic 586	com/tencent/qqmini/sdk/core/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   53: ifne +315 -> 368
    //   56: aload_2
    //   57: iconst_1
    //   58: dconst_0
    //   59: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   62: d2f
    //   63: fstore 9
    //   65: aload_2
    //   66: iconst_2
    //   67: dconst_0
    //   68: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   71: d2f
    //   72: fstore 10
    //   74: aload_2
    //   75: iconst_3
    //   76: dconst_0
    //   77: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   80: d2f
    //   81: fstore 6
    //   83: aload_2
    //   84: iconst_4
    //   85: dconst_0
    //   86: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   89: d2f
    //   90: fstore 5
    //   92: aload_2
    //   93: iconst_5
    //   94: dconst_0
    //   95: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   98: d2i
    //   99: istore 12
    //   101: aload_2
    //   102: bipush 6
    //   104: dconst_0
    //   105: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   108: d2i
    //   109: istore 13
    //   111: aload_2
    //   112: bipush 7
    //   114: dconst_0
    //   115: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   118: d2i
    //   119: istore 14
    //   121: aload_2
    //   122: bipush 8
    //   124: dconst_0
    //   125: invokevirtual 342	org/json/JSONArray:optDouble	(ID)D
    //   128: d2i
    //   129: istore 15
    //   131: new 602	android/graphics/BitmapFactory$Options
    //   134: dup
    //   135: invokespecial 603	android/graphics/BitmapFactory$Options:<init>	()V
    //   138: astore 19
    //   140: aload 18
    //   142: invokestatic 608	com/tencent/qqmini/sdk/core/utils/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   145: istore 16
    //   147: fload 6
    //   149: fstore_3
    //   150: aload 19
    //   152: iconst_1
    //   153: putfield 611	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   156: fload 6
    //   158: fstore_3
    //   159: aload 18
    //   161: aload 19
    //   163: invokestatic 617	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   166: pop
    //   167: fload 6
    //   169: fconst_0
    //   170: fcmpg
    //   171: ifle +17 -> 188
    //   174: fload 5
    //   176: fstore_3
    //   177: fload 6
    //   179: fstore 4
    //   181: fload 5
    //   183: fconst_0
    //   184: fcmpg
    //   185: ifgt +22 -> 207
    //   188: iload 14
    //   190: ifle +193 -> 383
    //   193: iload 15
    //   195: ifle +188 -> 383
    //   198: iload 14
    //   200: i2f
    //   201: fstore 4
    //   203: iload 15
    //   205: i2f
    //   206: fstore_3
    //   207: fload 4
    //   209: fconst_0
    //   210: fcmpl
    //   211: ifle +157 -> 368
    //   214: fload_3
    //   215: fconst_0
    //   216: fcmpl
    //   217: ifle +151 -> 368
    //   220: aload 19
    //   222: iconst_1
    //   223: putfield 620	android/graphics/BitmapFactory$Options:inDither	Z
    //   226: iload 14
    //   228: ifle +300 -> 528
    //   231: iload 15
    //   233: ifle +295 -> 528
    //   236: aload 18
    //   238: iconst_0
    //   239: invokestatic 626	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/lang/String;Z)Landroid/graphics/BitmapRegionDecoder;
    //   242: astore 18
    //   244: aload 18
    //   246: aload_0
    //   247: iload 12
    //   249: iload 13
    //   251: iload 14
    //   253: iload 15
    //   255: aload 19
    //   257: iload 16
    //   259: invokespecial 630	com/tencent/qqmini/miniapp/widget/CanvasView:getCropRect	(IIIILandroid/graphics/BitmapFactory$Options;I)Landroid/graphics/Rect;
    //   262: aload 19
    //   264: invokevirtual 634	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   267: astore_2
    //   268: aload 18
    //   270: invokevirtual 637	android/graphics/BitmapRegionDecoder:recycle	()V
    //   273: aload_2
    //   274: ifnull +94 -> 368
    //   277: aload_2
    //   278: astore 18
    //   280: iload 16
    //   282: ifeq +11 -> 293
    //   285: iload 16
    //   287: aload_2
    //   288: invokestatic 641	com/tencent/qqmini/sdk/core/utils/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   291: astore 18
    //   293: new 348	android/graphics/RectF
    //   296: dup
    //   297: invokespecial 349	android/graphics/RectF:<init>	()V
    //   300: astore_2
    //   301: aload_2
    //   302: aload_0
    //   303: fload 9
    //   305: f2d
    //   306: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   309: putfield 352	android/graphics/RectF:left	F
    //   312: aload_2
    //   313: aload_0
    //   314: fload 10
    //   316: f2d
    //   317: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   320: putfield 355	android/graphics/RectF:top	F
    //   323: aload_2
    //   324: aload_2
    //   325: getfield 352	android/graphics/RectF:left	F
    //   328: aload_0
    //   329: fload 4
    //   331: f2d
    //   332: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   335: fadd
    //   336: putfield 358	android/graphics/RectF:right	F
    //   339: aload_2
    //   340: aload_2
    //   341: getfield 355	android/graphics/RectF:top	F
    //   344: aload_0
    //   345: fload_3
    //   346: f2d
    //   347: invokevirtual 346	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   350: fadd
    //   351: putfield 361	android/graphics/RectF:bottom	F
    //   354: aload_1
    //   355: aload 18
    //   357: aconst_null
    //   358: aload_2
    //   359: aconst_null
    //   360: invokevirtual 645	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   363: aload 18
    //   365: invokevirtual 648	android/graphics/Bitmap:recycle	()V
    //   368: return
    //   369: aload_0
    //   370: getfield 255	com/tencent/qqmini/miniapp/widget/CanvasView:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   373: aload 18
    //   375: invokevirtual 653	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:getChildFileAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   378: astore 18
    //   380: goto -332 -> 48
    //   383: iload 16
    //   385: bipush 90
    //   387: if_icmpeq +11 -> 398
    //   390: iload 16
    //   392: sipush 270
    //   395: if_icmpne +31 -> 426
    //   398: fload 6
    //   400: fstore_3
    //   401: aload 19
    //   403: getfield 656	android/graphics/BitmapFactory$Options:outHeight	I
    //   406: i2f
    //   407: fstore 4
    //   409: fload 4
    //   411: fstore_3
    //   412: aload 19
    //   414: getfield 659	android/graphics/BitmapFactory$Options:outWidth	I
    //   417: i2f
    //   418: fstore 6
    //   420: fload 6
    //   422: fstore_3
    //   423: goto -216 -> 207
    //   426: fload 6
    //   428: fstore_3
    //   429: aload 19
    //   431: getfield 659	android/graphics/BitmapFactory$Options:outWidth	I
    //   434: i2f
    //   435: fstore 4
    //   437: fload 4
    //   439: fstore_3
    //   440: aload 19
    //   442: getfield 656	android/graphics/BitmapFactory$Options:outHeight	I
    //   445: istore 17
    //   447: iload 17
    //   449: i2f
    //   450: fstore_3
    //   451: goto -244 -> 207
    //   454: astore_2
    //   455: fload_3
    //   456: fstore 4
    //   458: ldc 149
    //   460: new 476	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   467: ldc_w 661
    //   470: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_2
    //   474: invokestatic 489	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   477: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 499	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: fload 5
    //   488: fstore_3
    //   489: goto -282 -> 207
    //   492: astore 18
    //   494: aconst_null
    //   495: astore_2
    //   496: ldc 149
    //   498: new 476	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 663
    //   508: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 18
    //   513: invokestatic 489	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   516: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 499	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: goto -252 -> 273
    //   528: aload 19
    //   530: iconst_0
    //   531: putfield 611	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   534: aload 19
    //   536: getfield 659	android/graphics/BitmapFactory$Options:outWidth	I
    //   539: i2f
    //   540: fstore 8
    //   542: aload 19
    //   544: getfield 656	android/graphics/BitmapFactory$Options:outHeight	I
    //   547: i2f
    //   548: fstore 7
    //   550: fload 4
    //   552: fload_3
    //   553: fmul
    //   554: aload 19
    //   556: getfield 659	android/graphics/BitmapFactory$Options:outWidth	I
    //   559: i2f
    //   560: fdiv
    //   561: aload 19
    //   563: getfield 656	android/graphics/BitmapFactory$Options:outHeight	I
    //   566: i2f
    //   567: fdiv
    //   568: f2d
    //   569: invokestatic 669	java/lang/Math:sqrt	(D)D
    //   572: d2f
    //   573: fstore 11
    //   575: fload 7
    //   577: fstore 6
    //   579: fload 8
    //   581: fstore 5
    //   583: fload 11
    //   585: fconst_1
    //   586: fcmpg
    //   587: ifge +17 -> 604
    //   590: fload 8
    //   592: fload 11
    //   594: fmul
    //   595: fstore 5
    //   597: fload 7
    //   599: fload 11
    //   601: fmul
    //   602: fstore 6
    //   604: aload 18
    //   606: invokestatic 672	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   609: ifeq +102 -> 711
    //   612: aload 19
    //   614: getstatic 678	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   617: putfield 681	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   620: ldc2_w 145
    //   623: fload 5
    //   625: f2d
    //   626: ddiv
    //   627: fload 6
    //   629: f2d
    //   630: ddiv
    //   631: ldc2_w 682
    //   634: ddiv
    //   635: invokestatic 669	java/lang/Math:sqrt	(D)D
    //   638: d2f
    //   639: fstore 7
    //   641: fload 7
    //   643: fconst_1
    //   644: fcmpg
    //   645: ifge +112 -> 757
    //   648: aload 19
    //   650: aload 19
    //   652: fload 5
    //   654: fload 7
    //   656: fmul
    //   657: fload 6
    //   659: fload 7
    //   661: fmul
    //   662: invokestatic 687	com/tencent/qqmini/sdk/core/utils/ImageUtil:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;FF)I
    //   665: putfield 690	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   668: aload 18
    //   670: aload 19
    //   672: invokestatic 617	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   675: astore_2
    //   676: aload_2
    //   677: ifnonnull +134 -> 811
    //   680: aload 19
    //   682: getfield 690	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   685: ifle +97 -> 782
    //   688: aload 19
    //   690: aload 19
    //   692: getfield 690	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   695: iconst_2
    //   696: imul
    //   697: putfield 690	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   700: aload 18
    //   702: aload 19
    //   704: invokestatic 617	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   707: astore_2
    //   708: goto -435 -> 273
    //   711: aload 19
    //   713: getstatic 693	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   716: putfield 681	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   719: ldc2_w 145
    //   722: fload 5
    //   724: f2d
    //   725: ddiv
    //   726: fload 6
    //   728: f2d
    //   729: ddiv
    //   730: ldc2_w 694
    //   733: ddiv
    //   734: invokestatic 669	java/lang/Math:sqrt	(D)D
    //   737: d2f
    //   738: fstore 7
    //   740: goto -99 -> 641
    //   743: astore_2
    //   744: ldc 149
    //   746: ldc_w 697
    //   749: invokestatic 700	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   752: aconst_null
    //   753: astore_2
    //   754: goto -78 -> 676
    //   757: aload 18
    //   759: aload 19
    //   761: invokestatic 617	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   764: astore_2
    //   765: goto -89 -> 676
    //   768: astore_2
    //   769: ldc 149
    //   771: ldc_w 702
    //   774: invokestatic 700	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   777: aconst_null
    //   778: astore_2
    //   779: goto -103 -> 676
    //   782: aload 19
    //   784: iconst_2
    //   785: putfield 690	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   788: goto -88 -> 700
    //   791: astore_2
    //   792: ldc 149
    //   794: ldc_w 704
    //   797: aload_2
    //   798: invokestatic 707	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   801: aconst_null
    //   802: astore_2
    //   803: goto -530 -> 273
    //   806: astore 18
    //   808: goto -312 -> 496
    //   811: goto -538 -> 273
    //   814: goto -766 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	817	0	this	CanvasView
    //   0	817	1	paramCanvas	Canvas
    //   0	817	2	paramJSONArray	JSONArray
    //   149	404	3	f1	float
    //   179	372	4	f2	float
    //   90	633	5	f3	float
    //   81	646	6	f4	float
    //   548	191	7	f5	float
    //   540	51	8	f6	float
    //   63	241	9	f7	float
    //   72	243	10	f8	float
    //   573	27	11	f9	float
    //   99	149	12	i	int
    //   109	141	13	j	int
    //   119	133	14	k	int
    //   129	125	15	m	int
    //   145	251	16	n	int
    //   445	3	17	i1	int
    //   5	374	18	localObject	Object
    //   492	266	18	localException1	Exception
    //   806	1	18	localException2	Exception
    //   138	645	19	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   150	156	454	java/lang/Exception
    //   159	167	454	java/lang/Exception
    //   401	409	454	java/lang/Exception
    //   412	420	454	java/lang/Exception
    //   429	437	454	java/lang/Exception
    //   440	447	454	java/lang/Exception
    //   236	268	492	java/lang/Exception
    //   668	676	743	java/lang/Throwable
    //   757	765	768	java/lang/Throwable
    //   700	708	791	java/lang/Throwable
    //   268	273	806	java/lang/Exception
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
    //   4: ldc_w 784
    //   7: invokevirtual 567	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10: istore 9
    //   12: aload_3
    //   13: ldc_w 799
    //   16: invokevirtual 567	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   19: istore 10
    //   21: aload_3
    //   22: ldc_w 886
    //   25: invokevirtual 567	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   28: istore 11
    //   30: aload_3
    //   31: ldc_w 888
    //   34: invokevirtual 567	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   37: istore 12
    //   39: aconst_null
    //   40: aload_3
    //   41: ldc 139
    //   43: invokestatic 894	com/tencent/qqmini/sdk/core/utils/NativeBuffer:unpackNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;Lorg/json/JSONObject;Ljava/lang/String;)Lcom/tencent/qqmini/sdk/core/utils/NativeBuffer;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +364 -> 412
    //   51: aload_3
    //   52: getfield 898	com/tencent/qqmini/sdk/core/utils/NativeBuffer:buf	[B
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
    //   164: invokestatic 747	android/graphics/Color:argb	(IIII)I
    //   167: iastore
    //   168: iload 8
    //   170: iconst_1
    //   171: iadd
    //   172: istore 8
    //   174: goto -103 -> 71
    //   177: iload 11
    //   179: iload 12
    //   181: getstatic 678	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   184: invokestatic 732	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   187: astore_3
    //   188: aload_3
    //   189: aload 19
    //   191: iconst_0
    //   192: iload 11
    //   194: iconst_0
    //   195: iconst_0
    //   196: iload 11
    //   198: iload 12
    //   200: invokevirtual 902	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   203: new 259	android/graphics/Paint
    //   206: dup
    //   207: invokespecial 903	android/graphics/Paint:<init>	()V
    //   210: astore 18
    //   212: aload 18
    //   214: iconst_1
    //   215: invokevirtual 906	android/graphics/Paint:setAntiAlias	(Z)V
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
    //   267: invokespecial 909	android/graphics/RectF:<init>	(FFFF)V
    //   270: aload 18
    //   272: invokevirtual 645	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   275: aload_0
    //   276: aload_2
    //   277: aconst_null
    //   278: iload 4
    //   280: invokevirtual 913	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventOK	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   283: aload_3
    //   284: ifnull +14 -> 298
    //   287: aload_3
    //   288: invokevirtual 917	android/graphics/Bitmap:isRecycled	()Z
    //   291: ifne +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 648	android/graphics/Bitmap:recycle	()V
    //   298: return
    //   299: astore_3
    //   300: aconst_null
    //   301: astore_1
    //   302: ldc 149
    //   304: new 476	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 919
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
    //   335: invokevirtual 922	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   338: aload_1
    //   339: ifnull -41 -> 298
    //   342: aload_1
    //   343: invokevirtual 917	android/graphics/Bitmap:isRecycled	()Z
    //   346: ifne -48 -> 298
    //   349: aload_1
    //   350: invokevirtual 648	android/graphics/Bitmap:recycle	()V
    //   353: return
    //   354: astore_1
    //   355: aload 18
    //   357: astore_2
    //   358: aload_2
    //   359: ifnull +14 -> 373
    //   362: aload_2
    //   363: invokevirtual 917	android/graphics/Bitmap:isRecycled	()Z
    //   366: ifne +7 -> 373
    //   369: aload_2
    //   370: invokevirtual 648	android/graphics/Bitmap:recycle	()V
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