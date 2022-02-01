package com.tencent.mobileqq.mini.widget;

import android.content.Context;
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
import android.graphics.PathEffect;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import bhjr;
import bhsr;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
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
  private static final long REQUEST_IMAGE_MAX_SAFE_SIZE = 8985600L;
  private static final String TAG = CanvasView.class.getSimpleName();
  private ApkgInfo mApkgInfo;
  private int mBitmapH;
  private int mBitmapW;
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
  private RectF mOffScreenCacheRect;
  Path mPath;
  private long mPendingDrawTaskTime;
  private boolean mRepeatX;
  private boolean mRepeatY;
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
  private int mStrokeColorAlpha = 255;
  private Paint mStrokePaint;
  private String mTextBaseline = "normal";
  private boolean mUseHardwareAccelerate;
  Boolean mVivoEnableSplit;
  private final WebviewContainer mWc;
  
  public CanvasView(Context paramContext, WebviewContainer paramWebviewContainer, ApkgInfo paramApkgInfo, String paramString, int paramInt, boolean paramBoolean1, Boolean paramBoolean, boolean paramBoolean2)
  {
    super(paramContext);
    this.mDensity = DisplayUtil.getDensity(paramContext);
    this.mWc = paramWebviewContainer;
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
    setBackgroundResource(CanvasViewDataUtil.getCanvasViewLoadingImageId(paramString));
    super.setIgnoreTouchEventToJS(true);
  }
  
  private void doDraw(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    int i = 0;
    Object localObject6;
    Object localObject1;
    Object localObject7;
    label94:
    float f7;
    float f8;
    float f4;
    float f3;
    int j;
    int k;
    int m;
    int n;
    int i1;
    float f1;
    float f2;
    if (i < paramJSONArray.length())
    {
      localObject6 = paramJSONArray.getJSONObject(i);
      localObject1 = ((JSONObject)localObject6).optString("method");
      localObject7 = ((JSONObject)localObject6).optJSONArray("data");
      if ("drawImage".equals(localObject1))
      {
        localObject1 = ((JSONArray)localObject7).optString(0);
        localObject6 = localObject1;
        if (!bhsr.a((String)localObject1))
        {
          if (((String)localObject1).startsWith("wxfile")) {
            localObject6 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject1);
          }
        }
        else if (!bhsr.a((String)localObject6))
        {
          f7 = (float)((JSONArray)localObject7).optDouble(1, 0.0D);
          f8 = (float)((JSONArray)localObject7).optDouble(2, 0.0D);
          f4 = (float)((JSONArray)localObject7).optDouble(3, 0.0D);
          f3 = (float)((JSONArray)localObject7).optDouble(4, 0.0D);
          j = (int)((JSONArray)localObject7).optDouble(5, 0.0D);
          k = (int)((JSONArray)localObject7).optDouble(6, 0.0D);
          m = (int)((JSONArray)localObject7).optDouble(7, 0.0D);
          n = (int)((JSONArray)localObject7).optDouble(8, 0.0D);
          localObject7 = new BitmapFactory.Options();
          i1 = ImageUtil.getExifOrientation((String)localObject6);
          f1 = f4;
        }
        try
        {
          ((BitmapFactory.Options)localObject7).inJustDecodeBounds = true;
          f1 = f4;
          BitmapFactory.decodeFile((String)localObject6, (BitmapFactory.Options)localObject7);
          if (f4 > 0.0F)
          {
            f1 = f3;
            f2 = f4;
            if (f3 > 0.0F) {}
          }
          else
          {
            if ((m <= 0) || (n <= 0)) {
              break label514;
            }
            f2 = m;
            f1 = n;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            label265:
            QLog.e(TAG, 2, "calculate image size error! " + Log.getStackTraceString(localException1));
            f2 = f1;
            f1 = f3;
            continue;
            if (i1 == 180)
            {
              localException1.left = (((BitmapFactory.Options)localObject7).outWidth - j - m);
              localException1.top = (((BitmapFactory.Options)localObject7).outHeight - k - n);
              localException1.right = (localException1.left + m);
              localException1.bottom = (localException1.top + n);
            }
            else if (i1 == 270)
            {
              localException1.left = (((BitmapFactory.Options)localObject7).outWidth - k - n);
              localException1.top = j;
              localException1.right = (localException1.left + n);
              localException1.bottom = (localException1.top + m);
            }
            else
            {
              localException1.left = j;
              localException1.top = k;
              localException1.right = (localException1.left + m);
              localException1.bottom = (localException1.top + n);
              continue;
              ((BitmapFactory.Options)localObject7).inJustDecodeBounds = false;
              f6 = ((BitmapFactory.Options)localObject7).outWidth;
              f5 = ((BitmapFactory.Options)localObject7).outHeight;
              f9 = (float)Math.sqrt(f2 * f1 / ((BitmapFactory.Options)localObject7).outWidth / ((BitmapFactory.Options)localObject7).outHeight);
              f4 = f5;
              f3 = f6;
              if (f9 < 1.0F)
              {
                f3 = f6 * f9;
                f4 = f5 * f9;
              }
              if (ImageUtil.isPngFile((String)localObject6))
              {
                ((BitmapFactory.Options)localObject7).inPreferredConfig = Bitmap.Config.ARGB_8888;
                f5 = (float)Math.sqrt(8985600.0F / f3 / f4 / 4.0F);
                if (f5 >= 1.0F) {
                  break label1040;
                }
                ((BitmapFactory.Options)localObject7).inSampleSize = ImageUtil.calculateInSampleSize((BitmapFactory.Options)localObject7, f3 * f5, f4 * f5);
              }
              for (;;)
              {
                try
                {
                  for (;;)
                  {
                    localBitmap1 = BitmapFactory.decodeFile((String)localObject6, (BitmapFactory.Options)localObject7);
                    if (localBitmap1 != null) {
                      break label5728;
                    }
                    if (((BitmapFactory.Options)localObject7).inSampleSize <= 0) {
                      break label1070;
                    }
                    ((BitmapFactory.Options)localObject7).inSampleSize *= 2;
                    try
                    {
                      localBitmap1 = BitmapFactory.decodeFile((String)localObject6, (BitmapFactory.Options)localObject7);
                    }
                    catch (Throwable localThrowable3)
                    {
                      QLog.e(TAG, 2, "getLocalBitmap 2nd time error!", localThrowable3);
                      localObject3 = null;
                    }
                  }
                  ((BitmapFactory.Options)localObject7).inPreferredConfig = Bitmap.Config.RGB_565;
                  f5 = (float)Math.sqrt(8985600.0F / f3 / f4 / 2.0F);
                }
                catch (Throwable localThrowable1)
                {
                  QLog.w(TAG, 2, "getLocalBitmap error with inSampleSize error!try again with lower quality!");
                  localBitmap2 = null;
                  continue;
                }
                try
                {
                  localBitmap2 = BitmapFactory.decodeFile((String)localObject6, (BitmapFactory.Options)localObject7);
                }
                catch (Throwable localThrowable2)
                {
                  QLog.w(TAG, 2, "getLocalBitmap error! try again with lower quality!");
                  localObject2 = null;
                }
                continue;
                ((BitmapFactory.Options)localObject7).inSampleSize = 2;
              }
            }
          }
        }
        if ((f2 > 0.0F) && (f1 > 0.0F))
        {
          ((BitmapFactory.Options)localObject7).inDither = true;
          if ((m <= 0) || (n <= 0)) {
            break label807;
          }
          localObject6 = BitmapRegionDecoder.newInstance((String)localObject6, false);
          localObject1 = new Rect();
          if (i1 != 90) {
            break label635;
          }
          ((Rect)localObject1).left = k;
          ((Rect)localObject1).top = (((BitmapFactory.Options)localObject7).outHeight - j - m);
          ((Rect)localObject1).right = (((Rect)localObject1).left + n);
          ((Rect)localObject1).bottom = (((Rect)localObject1).top + m);
          localObject1 = ((BitmapRegionDecoder)localObject6).decodeRegion((Rect)localObject1, (BitmapFactory.Options)localObject7);
          ((BitmapRegionDecoder)localObject6).recycle();
        }
      }
    }
    label514:
    label807:
    label1070:
    label1843:
    label1879:
    label5721:
    label5728:
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject6 = localObject1;
        if (i1 != 0) {
          localObject6 = ImageUtil.rotaingImageView(i1, (Bitmap)localObject1);
        }
        localObject1 = new RectF();
        ((RectF)localObject1).left = mpx2px(f7);
        ((RectF)localObject1).top = mpx2px(f8);
        ((RectF)localObject1).right = (((RectF)localObject1).left + mpx2px(f2));
        ((RectF)localObject1).bottom = (((RectF)localObject1).top + mpx2px(f1));
        paramCanvas.drawBitmap((Bitmap)localObject6, null, (RectF)localObject1, null);
        ((Bitmap)localObject6).recycle();
      }
      label635:
      float f6;
      float f5;
      Object localObject3;
      Object localObject8;
      label1634:
      label1663:
      do
      {
        do
        {
          for (;;)
          {
            i += 1;
            break;
            localObject6 = this.mApkgInfo.getFilePath((String)localObject1);
            break label94;
            if ((i1 == 90) || (i1 == 270))
            {
              f1 = f4;
              f2 = ((BitmapFactory.Options)localObject7).outHeight;
              f1 = f2;
              f4 = ((BitmapFactory.Options)localObject7).outWidth;
              f1 = f4;
              break label265;
            }
            f1 = f4;
            f2 = ((BitmapFactory.Options)localObject7).outWidth;
            f1 = f2;
            int i2 = ((BitmapFactory.Options)localObject7).outHeight;
            f1 = i2;
            break label265;
            float f9;
            Bitmap localBitmap1;
            Bitmap localBitmap2;
            Object localObject2;
            if ((!"setStrokeStyle".equals(localObject3)) && (!"setFillStyle".equals(localObject3))) {
              break label1897;
            }
            this.mRepeatX = false;
            this.mRepeatY = false;
            this.mBitmapW = 0;
            this.mBitmapH = 0;
            localObject6 = ((JSONArray)localObject7).optString(0);
            if ("normal".equals(localObject6))
            {
              localObject6 = ((JSONArray)localObject7).optJSONArray(1);
              if ("setStrokeStyle".equals(localObject3))
              {
                j = getColor((JSONArray)localObject6);
                this.mStrokeColorAlpha = ((JSONArray)localObject6).optInt(3);
                this.mStrokePaint.setShader(null);
                this.mStrokePaint.setColor(j);
              }
              else if ("setFillStyle".equals(localObject3))
              {
                j = getColor((JSONArray)localObject6);
                this.mFillColorAlpha = ((JSONArray)localObject6).optInt(3);
                this.mFillPaint.setShader(null);
                this.mFillPaint.setColor(j);
              }
            }
            else if ("radial".equals(localObject6))
            {
              localObject6 = ((JSONArray)localObject7).optJSONArray(1);
              localObject8 = ((JSONArray)localObject7).optJSONArray(2);
              localObject7 = ((JSONArray)localObject8).optJSONArray(0).optJSONArray(1);
              localObject8 = ((JSONArray)localObject8).optJSONArray(1).optJSONArray(1);
              localObject6 = new RadialGradient(mpx2px(((JSONArray)localObject6).optDouble(0)), mpx2px(((JSONArray)localObject6).optDouble(1)), mpx2px(((JSONArray)localObject6).optDouble(2)), getColor((JSONArray)localObject7), getColor((JSONArray)localObject8), Shader.TileMode.CLAMP);
              if ("setStrokeStyle".equals(localObject3)) {
                this.mStrokePaint.setShader((Shader)localObject6);
              } else if ("setFillStyle".equals(localObject3)) {
                this.mFillPaint.setShader((Shader)localObject6);
              }
            }
            else
            {
              if (!"linear".equals(localObject6)) {
                break label1573;
              }
              localObject6 = ((JSONArray)localObject7).optJSONArray(1);
              localObject8 = ((JSONArray)localObject7).optJSONArray(2);
              localObject7 = ((JSONArray)localObject8).optJSONArray(0).optJSONArray(1);
              localObject8 = ((JSONArray)localObject8).optJSONArray(1).optJSONArray(1);
              localObject6 = new LinearGradient(mpx2px(((JSONArray)localObject6).optDouble(0)), mpx2px(((JSONArray)localObject6).optDouble(1)), mpx2px(((JSONArray)localObject6).optDouble(2)), mpx2px(((JSONArray)localObject6).optDouble(3)), getColor((JSONArray)localObject7), getColor((JSONArray)localObject8), Shader.TileMode.CLAMP);
              if ("setStrokeStyle".equals(localObject3)) {
                this.mStrokePaint.setShader((Shader)localObject6);
              } else if ("setFillStyle".equals(localObject3)) {
                this.mFillPaint.setShader((Shader)localObject6);
              }
            }
          }
        } while ((!"pattern".equals(localObject6)) || (((JSONArray)localObject7).length() != 3));
        localObject6 = ((JSONArray)localObject7).optString(1);
        localObject3 = localObject6;
        if (!bhsr.a((String)localObject6))
        {
          if (!((String)localObject6).startsWith("wxfile")) {
            break label1829;
          }
          localObject3 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject6);
        }
        localObject6 = ((JSONArray)localObject7).optString(2);
        if (!"repeat".equals(localObject6)) {
          break label1843;
        }
        this.mRepeatX = true;
        this.mRepeatY = true;
        if (bhsr.a((String)localObject3)) {
          break label1879;
        }
        localObject3 = ImageUtil.getLocalBitmap((String)localObject3);
        if (localObject3 != null)
        {
          this.mBitmapW = ((Bitmap)localObject3).getWidth();
          this.mBitmapH = ((Bitmap)localObject3).getHeight();
        }
        localObject6 = new Matrix();
        ((Matrix)localObject6).postScale(this.mDensity, this.mDensity);
        localObject7 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, this.mBitmapW, this.mBitmapH, (Matrix)localObject6, true);
      } while (localObject7 == null);
      this.mBitmapW = ((Bitmap)localObject7).getWidth();
      this.mBitmapH = ((Bitmap)localObject7).getHeight();
      if (this.mRepeatX)
      {
        localObject3 = Shader.TileMode.REPEAT;
        label1779:
        if (!this.mRepeatY) {
          break label1889;
        }
      }
      label1889:
      for (localObject6 = Shader.TileMode.REPEAT;; localObject6 = Shader.TileMode.CLAMP)
      {
        localObject3 = new BitmapShader((Bitmap)localObject7, (Shader.TileMode)localObject3, (Shader.TileMode)localObject6);
        this.mFillPaint.setShader((Shader)localObject3);
        this.mStrokePaint.setShader((Shader)localObject3);
        break;
        localObject3 = this.mApkgInfo.getFilePath((String)localObject6);
        break label1634;
        if ("repeat-x".equals(localObject6))
        {
          this.mRepeatX = true;
          break label1663;
        }
        if (!"repeat-y".equals(localObject6)) {
          break label1663;
        }
        this.mRepeatY = true;
        break label1663;
        break;
        localObject3 = Shader.TileMode.CLAMP;
        break label1779;
      }
      label1897:
      if (("strokePath".equals(localObject3)) || ("fillPath".equals(localObject3)) || ("clip".equals(localObject3)))
      {
        if (this.mPath == null) {
          this.mPath = new Path();
        }
        this.mPath.reset();
        j = 0;
        if (j < ((JSONArray)localObject7).length())
        {
          localObject8 = ((JSONArray)localObject7).optJSONObject(j);
          if (localObject8 != null)
          {
            localObject6 = ((JSONObject)localObject8).optString("method");
            localObject8 = ((JSONObject)localObject8).optJSONArray("data");
            if (!"rect".equals(localObject6)) {
              break label2330;
            }
            f2 = mpx2px(((JSONArray)localObject8).optDouble(0, 0.0D));
            f6 = mpx2px(((JSONArray)localObject8).optDouble(1, 0.0D));
            f3 = mpx2px(((JSONArray)localObject8).optDouble(2, 0.0D));
            f5 = mpx2px(((JSONArray)localObject8).optDouble(3, 0.0D));
            if (f3 > 0.0F) {
              break label5721;
            }
            f1 = -f3;
            f2 += f3;
            f3 = f1;
          }
        }
      }
      for (f1 = f2;; f1 = f2)
      {
        for (;;)
        {
          f4 = f5;
          f2 = f6;
          if (f5 <= 0.0F)
          {
            f2 = f6 + f5;
            f4 = -f5;
          }
          localObject6 = new RectF();
          if (((this.mRepeatX) || (this.mRepeatY)) && ((this.mBitmapW != 0) || (this.mBitmapH != 0)))
          {
            if (this.mRepeatX) {
              f1 = 0.0F;
            }
            ((RectF)localObject6).left = f1;
            if (this.mRepeatY) {
              f2 = 0.0F;
            }
            ((RectF)localObject6).top = f2;
            if (this.mRepeatX)
            {
              f1 = ((RectF)localObject6).left + f3;
              ((RectF)localObject6).right = f1;
              if (!this.mRepeatY) {
                break label2277;
              }
              f1 = f4 + ((RectF)localObject6).top;
              ((RectF)localObject6).bottom = f1;
              this.mPath.addRect((RectF)localObject6, Path.Direction.CW);
              f1 = ((RectF)localObject6).right;
              f1 = ((RectF)localObject6).bottom;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            f1 = this.mBitmapW;
            break label2201;
            label2277:
            f1 = this.mBitmapH;
            break label2225;
            ((RectF)localObject6).left = f1;
            ((RectF)localObject6).top = f2;
            ((RectF)localObject6).right = (((RectF)localObject6).left + f3);
            ((RectF)localObject6).bottom = (f4 + ((RectF)localObject6).top);
            break label2232;
            if ("moveTo".equals(localObject6))
            {
              f1 = mpx2px(((JSONArray)localObject8).optDouble(0, 0.0D));
              f2 = mpx2px(((JSONArray)localObject8).optDouble(1, 0.0D));
              this.mPath.moveTo(f1, f2);
            }
            else if ("lineTo".equals(localObject6))
            {
              f1 = mpx2px(((JSONArray)localObject8).optDouble(0, 0.0D));
              f2 = mpx2px(((JSONArray)localObject8).optDouble(1, 0.0D));
              if (this.mPath.isEmpty()) {
                this.mPath.moveTo(f1, f2);
              } else {
                this.mPath.lineTo(f1, f2);
              }
            }
            else if ("closePath".equals(localObject6))
            {
              this.mPath.close();
            }
            else
            {
              if ("arc".equals(localObject6))
              {
                f5 = mpx2px(((JSONArray)localObject8).optDouble(0, 0.0D));
                f3 = mpx2px(((JSONArray)localObject8).optDouble(1, 0.0D));
                f4 = mpx2px(((JSONArray)localObject8).optDouble(2, 0.0D));
                double d1 = ((JSONArray)localObject8).optDouble(3, 0.0D);
                double d2 = ((JSONArray)localObject8).optDouble(4, 0.0D);
                f6 = (float)(d1 / 3.141592653589793D * 180.0D);
                f1 = (float)(d2 / 3.141592653589793D * 180.0D);
                boolean bool = ((JSONArray)localObject7).optBoolean(5);
                localObject6 = new RectF(f5 - f4, f3 - f4, f5 + f4, f3 + f4);
                if (bool)
                {
                  f1 = f6 - f1;
                  f2 = f1 % 360.0F;
                  f1 = f2;
                  if (f2 <= 0.0F) {
                    f1 = f2 + 360.0F;
                  }
                  if (!this.mPath.isEmpty()) {
                    break label2709;
                  }
                  this.mPath.addArc((RectF)localObject6, f6, f1);
                }
                for (;;)
                {
                  f1 = (float)(f5 + f4 * Math.cos(d2));
                  f1 = (float)(f3 + f4 * Math.sin(d2));
                  break;
                  f1 -= f6;
                  break label2614;
                  f2 = (float)(f5 + f4 * Math.cos(d1));
                  double d3 = f3;
                  double d4 = f4;
                  f2 = (float)(Math.sin(d1) * d4 + d3);
                  if (Math.abs(Math.abs(f1) - 360.0F) < 1.0E-014D) {
                    this.mPath.addArc((RectF)localObject6, f6, f1);
                  } else {
                    this.mPath.arcTo((RectF)localObject6, f6, f1);
                  }
                }
              }
              if ("quadraticCurveTo".equals(localObject6))
              {
                f1 = mpx2px(((JSONArray)localObject8).optDouble(0, 0.0D));
                f2 = mpx2px(((JSONArray)localObject8).optDouble(1, 0.0D));
                f3 = mpx2px(((JSONArray)localObject8).optDouble(2, 0.0D));
                f4 = mpx2px(((JSONArray)localObject8).optDouble(3, 0.0D));
                if (this.mPath.isEmpty()) {
                  this.mPath.moveTo(f1, f2);
                }
                this.mPath.quadTo(f1, f2, f3, f4);
              }
              else if ("bezierCurveTo".equals(localObject6))
              {
                f1 = mpx2px(((JSONArray)localObject8).optDouble(0, 0.0D));
                f2 = mpx2px(((JSONArray)localObject8).optDouble(1, 0.0D));
                f3 = mpx2px(((JSONArray)localObject8).optDouble(2, 0.0D));
                f4 = mpx2px(((JSONArray)localObject8).optDouble(3, 0.0D));
                f5 = mpx2px(((JSONArray)localObject8).optDouble(4, 0.0D));
                f6 = mpx2px(((JSONArray)localObject8).optDouble(5, 0.0D));
                if (this.mPath.isEmpty()) {
                  this.mPath.moveTo(f1, f2);
                }
                this.mPath.cubicTo(f1, f2, f3, f4, f5, f6);
              }
              else if ("translate".equals(localObject6))
              {
                paramCanvas.translate(mpx2px(((JSONArray)localObject8).optDouble(0, 0.0D)), mpx2px(((JSONArray)localObject8).optDouble(1, 0.0D)));
              }
            }
          }
          if ("clip".equals(localObject3))
          {
            paramCanvas.clipPath(this.mPath);
            break;
          }
          paramCanvas.drawPath(this.mPath, getCurrentPaint((String)localObject3));
          break;
          if ("setFontSize".equals(localObject3))
          {
            f1 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
            this.mFillPaint.setTextSize(f1);
            this.mStrokePaint.setTextSize(f1);
            break;
          }
          if ("setFontStyle".equals(localObject3))
          {
            localObject3 = ((JSONArray)localObject7).optString(0, "normal");
            if ("normal".equals(localObject3))
            {
              localObject3 = this.mFillPaint.getTypeface();
              if ((localObject3 != null) && (((Typeface)localObject3).isBold()))
              {
                j = 1;
                this.mFillPaint.setTypeface(Typeface.create((Typeface)localObject3, j));
                localObject3 = this.mStrokePaint.getTypeface();
                if ((localObject3 == null) || (!((Typeface)localObject3).isBold())) {
                  break label3272;
                }
              }
              for (j = 1;; j = 0)
              {
                this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject3, j));
                break;
                j = 0;
                break label3208;
              }
            }
            if ((!"italic".equals(localObject3)) && (!"oblique".equals(localObject3))) {
              break;
            }
            localObject3 = this.mFillPaint.getTypeface();
            if ((localObject3 != null) && (((Typeface)localObject3).isBold()))
            {
              j = 3;
              label3325:
              this.mFillPaint.setTypeface(Typeface.create((Typeface)localObject3, j));
              localObject3 = this.mStrokePaint.getTypeface();
              if ((localObject3 == null) || (!((Typeface)localObject3).isBold())) {
                break label3389;
              }
            }
            for (j = 3;; j = 2)
            {
              this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject3, j));
              break;
              j = 2;
              break label3325;
            }
          }
          if ("setFontWeight".equals(localObject3))
          {
            localObject3 = ((JSONArray)localObject7).optString(0);
            if ("normal".equals(localObject3))
            {
              localObject3 = this.mFillPaint.getTypeface();
              if ((localObject3 != null) && (((Typeface)localObject3).isItalic()))
              {
                j = 2;
                label3448:
                this.mFillPaint.setTypeface(Typeface.create((Typeface)localObject3, j));
                localObject3 = this.mStrokePaint.getTypeface();
                if ((localObject3 == null) || (!((Typeface)localObject3).isItalic())) {
                  break label3512;
                }
              }
              for (j = 2;; j = 0)
              {
                this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject3, j));
                break;
                j = 0;
                break label3448;
              }
            }
            if (!"bold".equals(localObject3)) {
              break;
            }
            localObject3 = this.mFillPaint.getTypeface();
            if ((localObject3 != null) && (((Typeface)localObject3).isItalic()))
            {
              j = 3;
              label3554:
              this.mFillPaint.setTypeface(Typeface.create((Typeface)localObject3, j));
              localObject3 = this.mStrokePaint.getTypeface();
              if ((localObject3 == null) || (!((Typeface)localObject3).isItalic())) {
                break label3618;
              }
            }
            for (j = 3;; j = 1)
            {
              this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject3, j));
              break;
              j = 1;
              break label3554;
            }
          }
          if ("setFontFamily".equals(localObject3))
          {
            localObject3 = ((JSONArray)localObject7).optString(0);
            localObject6 = this.mFillPaint.getTypeface();
            if (localObject6 != null)
            {
              j = ((Typeface)localObject6).getStyle();
              this.mFillPaint.setTypeface(Typeface.create((String)localObject3, j));
              localObject3 = this.mStrokePaint.getTypeface();
              if (localObject3 == null) {
                break label3723;
              }
            }
            for (j = ((Typeface)localObject3).getStyle();; j = 0)
            {
              this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject3, j));
              break;
              j = 0;
              break label3663;
            }
          }
          if ("setTextAlign".equals(localObject3))
          {
            localObject3 = ((JSONArray)localObject7).optString(0);
            if ("center".equals(localObject3)) {
              localObject3 = Paint.Align.CENTER;
            }
            for (;;)
            {
              this.mFillPaint.setTextAlign((Paint.Align)localObject3);
              this.mStrokePaint.setTextAlign((Paint.Align)localObject3);
              break;
              if ("right".equals(localObject3)) {
                localObject3 = Paint.Align.RIGHT;
              } else {
                localObject3 = Paint.Align.LEFT;
              }
            }
          }
          if (("fillText".equals(localObject3)) || ("strokeText".equals(localObject3)))
          {
            localObject3 = getCurrentPaint((String)localObject3);
            f5 = ((Paint)localObject3).descent();
            f6 = ((Paint)localObject3).ascent();
            j = (int)(f5 - f6);
            localObject6 = ((JSONArray)localObject7).optString(0);
            f3 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
            f2 = mpx2px(((JSONArray)localObject7).optDouble(2, 0.0D));
            f4 = mpx2px(((JSONArray)localObject7).optDouble(3, -1.0D));
            if (this.mTextBaseline.equals("top")) {
              f1 = f2 - f6;
            }
            for (;;)
            {
              if (f4 <= 0.0F) {
                break label4046;
              }
              paramCanvas.save();
              f2 = f4 / ((Paint)localObject3).measureText((String)localObject6);
              if (f2 < 1.0F) {
                paramCanvas.scale(f2, 1.0F, f3, f1);
              }
              paramCanvas.drawText((String)localObject6, f3, f1, (Paint)localObject3);
              paramCanvas.restore();
              break;
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
            paramCanvas.drawText((String)localObject6, f3, f1, (Paint)localObject3);
            break;
          }
          if ("setGlobalAlpha".equals(localObject3))
          {
            this.mGlobalAlpha = ((JSONArray)localObject7).optInt(0, 0);
            break;
          }
          if ("restore".equals(localObject3)) {
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
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e(TAG, 2, "ACTION_RESTORE: " + Log.getStackTraceString(localException2));
              }
            }
          }
        }
        if ("save".equals(localException2))
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
          break;
        }
        if ("clearRect".equals(localException2))
        {
          paramCanvas.save();
          f4 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
          f6 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
          f3 = mpx2px(((JSONArray)localObject7).optDouble(2, 0.0D));
          f5 = mpx2px(((JSONArray)localObject7).optDouble(3, 0.0D));
          f2 = f3;
          f1 = f4;
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
          localObject4 = new RectF();
          ((RectF)localObject4).left = f1;
          ((RectF)localObject4).top = f3;
          ((RectF)localObject4).right = (((RectF)localObject4).left + f2);
          ((RectF)localObject4).bottom = (f4 + ((RectF)localObject4).top);
          paramCanvas.clipRect((RectF)localObject4);
          paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          paramCanvas.restore();
          break;
        }
        if ("setGlobalCompositeOperation".equals(localObject4))
        {
          localObject6 = ((JSONArray)localObject7).optString(0);
          localObject4 = null;
          if ("xor".equals(localObject6)) {
            localObject4 = PorterDuff.Mode.XOR;
          }
          for (;;)
          {
            if (localObject4 == null) {
              break label4717;
            }
            this.mFillPaint.setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject4));
            this.mStrokePaint.setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject4));
            break;
            if ("source-atop".equals(localObject6)) {
              localObject4 = PorterDuff.Mode.SRC_ATOP;
            } else if ("destination-out".equals(localObject6)) {
              localObject4 = PorterDuff.Mode.DST_OUT;
            } else if (("lighter".equals(localObject6)) || ("lighten".equals(localObject6)) || ("hard-light".equals(localObject6))) {
              localObject4 = PorterDuff.Mode.LIGHTEN;
            } else if ("overlay".equals(localObject6)) {
              localObject4 = PorterDuff.Mode.OVERLAY;
            } else if ("darken".equals(localObject6)) {
              localObject4 = PorterDuff.Mode.DARKEN;
            }
          }
          label4717:
          break;
        }
        if ("rotate".equals(localObject4))
        {
          paramCanvas.rotate((float)(((JSONArray)localObject7).optDouble(0, 0.0D) * 180.0D / 3.141592653589793D));
          break;
        }
        if ("scale".equals(localObject4))
        {
          paramCanvas.scale((float)((JSONArray)localObject7).optDouble(0, 1.0D), (float)((JSONArray)localObject7).optDouble(1, 1.0D));
          break;
        }
        if ("translate".equals(localObject4))
        {
          paramCanvas.translate(mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D)), mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D)));
          break;
        }
        if ("setLineWidth".equals(localObject4))
        {
          f1 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
          this.mStrokePaint.setStrokeWidth(f1);
          break;
        }
        if ("setShadow".equals(localObject4))
        {
          localObject4 = new CanvasView.ShadowLayer(this);
          localObject6 = ((JSONArray)localObject7).optJSONArray(3);
          f1 = mpx2px(((JSONArray)localObject7).optDouble(2, 0.0D));
          f2 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
          f3 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
          ((CanvasView.ShadowLayer)localObject4).radius = f1;
          ((CanvasView.ShadowLayer)localObject4).dx = f2;
          ((CanvasView.ShadowLayer)localObject4).dy = f3;
          ((CanvasView.ShadowLayer)localObject4).color = getColor((JSONArray)localObject6);
          this.mFillPaint.setShadowLayer(((CanvasView.ShadowLayer)localObject4).radius, ((CanvasView.ShadowLayer)localObject4).dx, ((CanvasView.ShadowLayer)localObject4).dy, ((CanvasView.ShadowLayer)localObject4).color);
          this.mStrokePaint.setShadowLayer(((CanvasView.ShadowLayer)localObject4).radius, ((CanvasView.ShadowLayer)localObject4).dx, ((CanvasView.ShadowLayer)localObject4).dy, ((CanvasView.ShadowLayer)localObject4).color);
          break;
        }
        if ("setLineCap".equals(localObject4))
        {
          localObject4 = null;
          localObject6 = ((JSONArray)localObject7).optString(0);
          if ("butt".equals(localObject6)) {
            localObject4 = Paint.Cap.BUTT;
          }
          for (;;)
          {
            if (localObject4 == null) {
              break label5105;
            }
            this.mStrokePaint.setStrokeCap((Paint.Cap)localObject4);
            break;
            if ("round".equals(localObject6)) {
              localObject4 = Paint.Cap.ROUND;
            } else if ("square".equals(localObject6)) {
              localObject4 = Paint.Cap.SQUARE;
            }
          }
          label5105:
          break;
        }
        if ("setLineJoin".equals(localObject4))
        {
          localObject4 = null;
          localObject6 = ((JSONArray)localObject7).optString(0);
          if ("bevel".equals(localObject6)) {
            localObject4 = Paint.Join.BEVEL;
          }
          for (;;)
          {
            if (localObject4 == null) {
              break label5197;
            }
            this.mStrokePaint.setStrokeJoin((Paint.Join)localObject4);
            break;
            if ("round".equals(localObject6)) {
              localObject4 = Paint.Join.ROUND;
            } else if ("miter".equals(localObject6)) {
              localObject4 = Paint.Join.MITER;
            }
          }
          break;
        }
        if ("setLineDash".equals(localObject4))
        {
          localObject4 = (JSONArray)((JSONArray)localObject7).opt(0);
          if (((JSONArray)localObject4).length() <= 0) {
            break label5715;
          }
          f1 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
          localObject6 = new float[((JSONArray)localObject4).length()];
          j = 0;
          while (j < ((JSONArray)localObject4).length())
          {
            localObject6[j] = mpx2px(((JSONArray)localObject4).optDouble(j, 0.0D));
            j += 1;
          }
        }
        Object localObject5;
        for (Object localObject4 = new DashPathEffect((float[])localObject6, f1);; localObject5 = null)
        {
          for (;;)
          {
            this.mFillPaint.setPathEffect((PathEffect)localObject4);
            this.mStrokePaint.setPathEffect((PathEffect)localObject4);
            break;
            if ("setMiterLimit".equals(localObject4))
            {
              f1 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
              this.mFillPaint.setStrokeMiter(f1);
              this.mStrokePaint.setStrokeMiter(f1);
              break;
            }
            if ((!"setTransform".equals(localObject4)) && (!"transform".equals(localObject4))) {
              break label5607;
            }
            f1 = (float)((JSONArray)localObject7).optDouble(0, 1.0D);
            f2 = (float)((JSONArray)localObject7).optDouble(3, 1.0D);
            f3 = (float)((JSONArray)localObject7).optDouble(2, 0.0D);
            f4 = (float)((JSONArray)localObject7).optDouble(1, 0.0D);
            f5 = mpx2px(((JSONArray)localObject7).optDouble(4, 0.0D));
            f6 = mpx2px(((JSONArray)localObject7).optDouble(5, 0.0D));
            localObject7 = new float[9];
            localObject7[2] = f5;
            localObject7[5] = f6;
            localObject7[0] = f1;
            localObject7[4] = f2;
            localObject7[1] = f3;
            localObject7[3] = f4;
            localObject7[6] = 0.0F;
            localObject7[7] = 0.0F;
            localObject7[8] = 1.0F;
            try
            {
              if (!"transform".equals(localObject4)) {
                break label5567;
              }
              localObject4 = new Matrix();
              ((Matrix)localObject4).setValues((float[])localObject7);
              paramCanvas.concat((Matrix)localObject4);
            }
            catch (Exception localException3)
            {
              QLog.e(TAG, 2, Log.getStackTraceString(localException3));
            }
          }
          break;
          localObject6 = paramCanvas.getMatrix();
          localObject5 = localObject6;
          if (localObject6 == null) {
            localObject5 = new Matrix();
          }
          ((Matrix)localObject5).setValues((float[])localObject7);
          paramCanvas.setMatrix((Matrix)localObject5);
          break;
          label5607:
          if ("setTextBaseline".equals(localObject5))
          {
            this.mTextBaseline = ((JSONArray)localObject7).optString(0);
            break;
          }
          if (!"canvasPutImageData".equals(localObject5)) {
            break;
          }
          putImageData(paramCanvas, (String)localObject5, ((JSONObject)localObject6).optJSONObject("data"), ((JSONObject)localObject6).optInt("callbackId"));
          break;
          this.mFillPaint.setShader(null);
          this.mFillPaint.setColor(-16777216);
          this.mFillPaint.clearShadowLayer();
          this.mStrokePaint.setShader(null);
          this.mStrokePaint.setColor(-16777216);
          this.mStrokePaint.clearShadowLayer();
          return;
        }
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
        QLog.e(TAG, 2, "getCacheBitmapFromView failed: " + Log.getStackTraceString(paramView));
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
      QLog.e(TAG, 2, Log.getStackTraceString(paramJSONArray));
    }
    return 0;
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
          QLog.e(TAG, 2, "process draw actions error! " + Log.getStackTraceString(localThrowable));
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
    //   4: ldc_w 1049
    //   7: invokevirtual 965	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10: istore 9
    //   12: aload_3
    //   13: ldc_w 1051
    //   16: invokevirtual 965	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   19: istore 10
    //   21: aload_3
    //   22: ldc_w 1053
    //   25: invokevirtual 965	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   28: istore 11
    //   30: aload_3
    //   31: ldc_w 1055
    //   34: invokevirtual 965	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   37: istore 12
    //   39: aload_3
    //   40: ldc 139
    //   42: aconst_null
    //   43: invokestatic 1061	com/tencent/mobileqq/minigame/utils/NativeBuffer:unpackNativeBuffer	(Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;)Lcom/tencent/mobileqq/minigame/utils/NativeBuffer;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +366 -> 414
    //   51: aload_3
    //   52: getfield 1065	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   55: astore_3
    //   56: iload 11
    //   58: iload 12
    //   60: imul
    //   61: newarray int
    //   63: astore 19
    //   65: iconst_0
    //   66: istore 7
    //   68: goto +333 -> 401
    //   71: iload 8
    //   73: iload 11
    //   75: if_icmpge +344 -> 419
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
    //   164: invokestatic 1007	android/graphics/Color:argb	(IIII)I
    //   167: iastore
    //   168: iload 8
    //   170: iconst_1
    //   171: iadd
    //   172: istore 8
    //   174: goto -103 -> 71
    //   177: iload 11
    //   179: iload 12
    //   181: getstatic 499	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   184: invokestatic 992	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   187: astore_3
    //   188: aload_3
    //   189: aload 19
    //   191: iconst_0
    //   192: iload 11
    //   194: iconst_0
    //   195: iconst_0
    //   196: iload 11
    //   198: iload 12
    //   200: invokevirtual 1069	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   203: new 244	android/graphics/Paint
    //   206: dup
    //   207: invokespecial 1070	android/graphics/Paint:<init>	()V
    //   210: astore 18
    //   212: aload 18
    //   214: iconst_1
    //   215: invokevirtual 1073	android/graphics/Paint:setAntiAlias	(Z)V
    //   218: aload_0
    //   219: iload 9
    //   221: i2d
    //   222: invokevirtual 435	com/tencent/mobileqq/mini/widget/CanvasView:mpx2px	(D)F
    //   225: fstore 5
    //   227: aload_0
    //   228: iload 10
    //   230: i2d
    //   231: invokevirtual 435	com/tencent/mobileqq/mini/widget/CanvasView:mpx2px	(D)F
    //   234: fstore 6
    //   236: aload_1
    //   237: aload_3
    //   238: aconst_null
    //   239: new 430	android/graphics/RectF
    //   242: dup
    //   243: fload 5
    //   245: fload 6
    //   247: aload_0
    //   248: iload 11
    //   250: i2d
    //   251: invokevirtual 435	com/tencent/mobileqq/mini/widget/CanvasView:mpx2px	(D)F
    //   254: fload 5
    //   256: fadd
    //   257: aload_0
    //   258: iload 12
    //   260: i2d
    //   261: invokevirtual 435	com/tencent/mobileqq/mini/widget/CanvasView:mpx2px	(D)F
    //   264: fload 6
    //   266: fadd
    //   267: invokespecial 649	android/graphics/RectF:<init>	(FFFF)V
    //   270: aload 18
    //   272: invokevirtual 449	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   275: aload_0
    //   276: aload_2
    //   277: aconst_null
    //   278: iload 4
    //   280: invokevirtual 1077	com/tencent/mobileqq/mini/widget/CanvasView:callbackJsEventOK	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   283: aload_3
    //   284: ifnull +14 -> 298
    //   287: aload_3
    //   288: invokevirtual 1080	android/graphics/Bitmap:isRecycled	()Z
    //   291: ifne +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 452	android/graphics/Bitmap:recycle	()V
    //   298: return
    //   299: astore_3
    //   300: aconst_null
    //   301: astore_1
    //   302: getstatic 206	com/tencent/mobileqq/mini/widget/CanvasView:TAG	Ljava/lang/String;
    //   305: iconst_2
    //   306: new 462	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 463	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 1082
    //   316: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_3
    //   320: invokestatic 475	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   323: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 478	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 484	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload_0
    //   333: aload_2
    //   334: aconst_null
    //   335: iload 4
    //   337: invokevirtual 1085	com/tencent/mobileqq/mini/widget/CanvasView:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   340: aload_1
    //   341: ifnull -43 -> 298
    //   344: aload_1
    //   345: invokevirtual 1080	android/graphics/Bitmap:isRecycled	()Z
    //   348: ifne -50 -> 298
    //   351: aload_1
    //   352: invokevirtual 452	android/graphics/Bitmap:recycle	()V
    //   355: return
    //   356: astore_1
    //   357: aload 18
    //   359: astore_2
    //   360: aload_2
    //   361: ifnull +14 -> 375
    //   364: aload_2
    //   365: invokevirtual 1080	android/graphics/Bitmap:isRecycled	()Z
    //   368: ifne +7 -> 375
    //   371: aload_2
    //   372: invokevirtual 452	android/graphics/Bitmap:recycle	()V
    //   375: aload_1
    //   376: athrow
    //   377: astore_1
    //   378: aload_3
    //   379: astore_2
    //   380: goto -20 -> 360
    //   383: astore_3
    //   384: aload_1
    //   385: astore_2
    //   386: aload_3
    //   387: astore_1
    //   388: goto -28 -> 360
    //   391: astore 18
    //   393: aload_3
    //   394: astore_1
    //   395: aload 18
    //   397: astore_3
    //   398: goto -96 -> 302
    //   401: iload 7
    //   403: iload 12
    //   405: if_icmpge -228 -> 177
    //   408: iconst_0
    //   409: istore 8
    //   411: goto -340 -> 71
    //   414: aconst_null
    //   415: astore_3
    //   416: goto -360 -> 56
    //   419: iload 7
    //   421: iconst_1
    //   422: iadd
    //   423: istore 7
    //   425: goto -24 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	CanvasView
    //   0	428	1	paramCanvas	Canvas
    //   0	428	2	paramString	String
    //   0	428	3	paramJSONObject	JSONObject
    //   0	428	4	paramInt	int
    //   225	30	5	f1	float
    //   234	31	6	f2	float
    //   66	358	7	i	int
    //   71	339	8	j	int
    //   10	210	9	k	int
    //   19	210	10	m	int
    //   28	221	11	n	int
    //   37	369	12	i1	int
    //   86	33	13	i2	int
    //   92	33	14	i3	int
    //   98	42	15	i4	int
    //   106	44	16	i5	int
    //   114	46	17	i6	int
    //   1	357	18	localPaint	Paint
    //   391	5	18	localThrowable	Throwable
    //   63	127	19	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   3	47	299	java/lang/Throwable
    //   51	56	299	java/lang/Throwable
    //   56	65	299	java/lang/Throwable
    //   116	168	299	java/lang/Throwable
    //   177	188	299	java/lang/Throwable
    //   3	47	356	finally
    //   51	56	356	finally
    //   56	65	356	finally
    //   116	168	356	finally
    //   177	188	356	finally
    //   188	283	377	finally
    //   302	340	383	finally
    //   188	283	391	java/lang/Throwable
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
    paramString = ApiUtil.wrapCallbackFail(paramString, paramJSONObject);
    if (paramString != null) {}
    for (paramString = paramString.toString();; paramString = "")
    {
      this.mWc.appBrandRuntime.serviceRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
    if (paramString != null) {}
    for (paramString = paramString.toString();; paramString = "")
    {
      this.mWc.appBrandRuntime.serviceRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  protected void evaluateSubcribeJS(String paramString1, String paramString2)
  {
    this.mWc.appBrandRuntime.serviceRuntime.evaluateSubcribeJS(paramString1, paramString2, this.mWc.getPageWebview().pageWebviewId);
  }
  
  public void getImageData(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    AppBrandTask.runTaskOnUiThread(new CanvasView.1(this, paramString, paramInt, paramJSONObject));
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
      Object localObject = bhjr.a("ro.vivo.os.version");
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
      QLog.e(TAG, 2, "doDraw failed! " + Log.getStackTraceString(paramCanvas));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mOffScreenCacheRect = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    Object localObject1 = new JSONObject();
    Object localObject2;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      while (this.mHasGuesture)
      {
        localObject1 = this.mDisableScroll;
        if ((localObject1 == null) || (((Boolean)localObject1).booleanValue() != true)) {
          break;
        }
        return true;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "--ACTION_DOWN--");
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("x", px2mpx(paramMotionEvent.getX()));
          ((JSONObject)localObject2).put("y", px2mpx(paramMotionEvent.getY()));
          ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(0));
          ((JSONObject)localObject1).put("data", this.mCanvasData);
          ((JSONObject)localObject1).put("touch", localObject2);
          evaluateSubcribeJS("onTouchStart", ((JSONObject)localObject1).toString());
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "--ACTION_POINTER_DOWN--" + paramMotionEvent.getPointerCount() + "   " + paramMotionEvent.getActionIndex() + "   " + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
        }
        try
        {
          i = paramMotionEvent.getActionIndex();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("x", px2mpx(paramMotionEvent.getX(i)));
          ((JSONObject)localObject2).put("y", px2mpx(paramMotionEvent.getY(i)));
          ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(i));
          localJSONException1.put("data", this.mCanvasData);
          localJSONException1.put("touch", localObject2);
          evaluateSubcribeJS("onTouchStart", localJSONException1.toString());
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject2 = new JSONArray();
              int j = paramMotionEvent.getPointerCount();
              if (i >= j) {
                break label560;
              }
              float f1 = paramMotionEvent.getX(i);
              float f2 = paramMotionEvent.getY(i);
              if ((Math.abs(f1 - this.mLastOnTouchMoveX) < 0.5D) && (Math.abs(f2 - this.mLastOnTouchMoveY) < 0.5D)) {
                break label1039;
              }
              this.mLastOnTouchMoveX = f1;
              this.mLastOnTouchMoveY = f2;
              localJSONObject = new JSONObject();
              localJSONObject.put("x", px2mpx(f1));
              localJSONObject.put("y", px2mpx(f2));
              localJSONObject.put("id", paramMotionEvent.getPointerId(i));
              ((JSONArray)localObject2).put(localJSONObject);
            }
            catch (JSONException localJSONException3)
            {
              localJSONException3.printStackTrace();
            }
            break;
            label560:
            if (((JSONArray)localObject2).length() <= 0) {
              break;
            }
            localJSONException3.put("data", this.mCanvasData);
            localJSONException3.put("touches", localObject2);
            evaluateSubcribeJS("onTouchMove", localJSONException3.toString());
            break;
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "--ACTION_UP--");
            }
            try
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("x", px2mpx(paramMotionEvent.getX()));
              ((JSONObject)localObject2).put("y", px2mpx(paramMotionEvent.getY()));
              ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(0));
              localJSONException3.put("data", this.mCanvasData);
              localJSONException3.put("touch", localObject2);
              evaluateSubcribeJS("onTouchEnd", localJSONException3.toString());
            }
            catch (JSONException localJSONException4)
            {
              localJSONException4.printStackTrace();
            }
          }
          break;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "--ACTION_POINTER_UP--" + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
          }
          try
          {
            i = paramMotionEvent.getActionIndex();
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("x", px2mpx(paramMotionEvent.getX(i)));
            ((JSONObject)localObject2).put("y", px2mpx(paramMotionEvent.getY(i)));
            ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(i));
            localJSONException4.put("data", this.mCanvasData);
            localJSONException4.put("touch", localObject2);
            evaluateSubcribeJS("onTouchEnd", localJSONException4.toString());
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        break;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "--ACTION_CANCEL--");
        }
        localObject2 = new JSONArray();
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("x", px2mpx(paramMotionEvent.getX()));
          localJSONObject.put("y", px2mpx(paramMotionEvent.getY()));
          localJSONObject.put("id", paramMotionEvent.getPointerId(0));
          ((JSONArray)localObject2).put(localJSONObject);
          localException.put("data", this.mCanvasData);
          localException.put("touches", localObject2);
          evaluateSubcribeJS("onTouchCancel", localException.toString());
        }
        catch (JSONException localJSONException5)
        {
          localJSONException5.printStackTrace();
        }
      }
      break;
      return super.onTouchEvent(paramMotionEvent);
      label1039:
      i += 1;
    }
  }
  
  float px2mpx(double paramDouble)
  {
    return (float)(paramDouble / this.mDensity);
  }
  
  int px2mpxInt(double paramDouble)
  {
    return (int)(paramDouble / this.mDensity + 0.5D);
  }
  
  public void saveBitmap(WebviewContainer paramWebviewContainer, Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt)
  {
    boolean bool;
    if (paramJSONObject == null)
    {
      paramContext = "png";
      if ("jpg".equals(paramContext)) {
        break label74;
      }
      bool = true;
      label21:
      if ((getWidth() != 0) && (getHeight() != 0)) {
        break label80;
      }
    }
    label74:
    label80:
    for (long l = 300L;; l = 0L)
    {
      AppBrandTask.runTaskOnUiThreadDelay(new CanvasView.2(this, bool, paramWebviewContainer, paramString, paramInt, paramJSONObject, paramContext), l);
      return;
      paramContext = paramJSONObject.optString("fileType");
      break;
      bool = false;
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */