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
import azzu;
import baip;
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
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
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
  private static final float DRAW_IMAGE_MAX_REQUEQST_HEIGHT = 4000.0F;
  private static final float DRAW_IMAGE_MAX_REQUEQST_WIDTH = 1440.0F;
  private static final int INVALIDATE_TIME_INTERVAL = 16;
  public static final String KEY_CALLBACK_ID = "callbackId";
  public static final String KEY_DATA = "data";
  public static final String KEY_METHOD = "method";
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
    Object localObject4;
    Object localObject1;
    label94:
    float f5;
    float f6;
    float f4;
    float f3;
    int j;
    float f1;
    float f2;
    if (i < paramJSONArray.length())
    {
      localObject4 = paramJSONArray.getJSONObject(i);
      localObject1 = ((JSONObject)localObject4).optString("method");
      Object localObject5 = ((JSONObject)localObject4).optJSONArray("data");
      if ("drawImage".equals(localObject1))
      {
        localObject4 = ((JSONArray)localObject5).optString(0);
        localObject1 = localObject4;
        int k;
        int m;
        int n;
        int i1;
        if (!baip.a((String)localObject4))
        {
          if (((String)localObject4).startsWith("wxfile")) {
            localObject1 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject4);
          }
        }
        else if (!baip.a((String)localObject1))
        {
          f5 = mpx2px(((JSONArray)localObject5).optDouble(1, 0.0D));
          f6 = mpx2px(((JSONArray)localObject5).optDouble(2, 0.0D));
          f4 = mpx2px(((JSONArray)localObject5).optDouble(3, 0.0D));
          f3 = mpx2px(((JSONArray)localObject5).optDouble(4, 0.0D));
          j = (int)((JSONArray)localObject5).optDouble(5, 0.0D);
          k = (int)((JSONArray)localObject5).optDouble(6, 0.0D);
          m = (int)((JSONArray)localObject5).optDouble(7, 0.0D);
          n = (int)((JSONArray)localObject5).optDouble(8, 0.0D);
          localObject4 = new BitmapFactory.Options();
          i1 = ImageUtil.getExifOrientation((String)localObject1);
          f1 = f4;
        }
        for (;;)
        {
          try
          {
            ((BitmapFactory.Options)localObject4).inJustDecodeBounds = true;
            f1 = f4;
            BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject4);
            if (f4 > 0.0F)
            {
              f1 = f3;
              f2 = f4;
              if (f3 > 0.0F) {}
            }
            else
            {
              if ((m <= 0) || (n <= 0)) {
                continue;
              }
              f1 = f4;
              f2 = this.mDensity * m;
              f1 = f2;
              f4 = this.mDensity;
              f1 = f4 * n;
            }
          }
          catch (Exception localException3)
          {
            label505:
            int i2;
            QLog.e(TAG, 2, "calculate image size error! " + Log.getStackTraceString(localException3));
            f2 = f1;
            f1 = f3;
            continue;
            if (i1 != 180) {
              continue;
            }
            ((Rect)localObject1).left = (((BitmapFactory.Options)localObject4).outWidth - j - m);
            ((Rect)localObject1).top = (((BitmapFactory.Options)localObject4).outHeight - k - n);
            ((Rect)localObject1).right = (((Rect)localObject1).left + m);
            ((Rect)localObject1).bottom = (((Rect)localObject1).top + n);
            continue;
            if (i1 != 270) {
              continue;
            }
            ((Rect)localObject1).left = (((BitmapFactory.Options)localObject4).outWidth - k - n);
            ((Rect)localObject1).top = j;
            ((Rect)localObject1).right = (((Rect)localObject1).left + n);
            ((Rect)localObject1).bottom = (((Rect)localObject1).top + m);
            continue;
            ((Rect)localObject1).left = j;
            ((Rect)localObject1).top = k;
            ((Rect)localObject1).right = (((Rect)localObject1).left + m);
            ((Rect)localObject1).bottom = (((Rect)localObject1).top + n);
            continue;
            f3 = Math.min(1440.0F / f2, 4000.0F / f1);
            if (f3 >= 1.0F) {
              break label5574;
            }
          }
          if ((f2 > 0.0F) && (f1 > 0.0F))
          {
            ((BitmapFactory.Options)localObject4).inDither = true;
            if ((m <= 0) || (n <= 0)) {
              continue;
            }
            localObject5 = BitmapRegionDecoder.newInstance((String)localObject1, false);
            localObject1 = new Rect();
            if (i1 != 90) {
              continue;
            }
            ((Rect)localObject1).left = k;
            ((Rect)localObject1).top = (((BitmapFactory.Options)localObject4).outHeight - j - m);
            ((Rect)localObject1).right = (((Rect)localObject1).left + n);
            ((Rect)localObject1).bottom = (((Rect)localObject1).top + m);
            localObject1 = ((BitmapRegionDecoder)localObject5).decodeRegion((Rect)localObject1, (BitmapFactory.Options)localObject4);
            ((BitmapRegionDecoder)localObject5).recycle();
            if (localObject1 != null)
            {
              localObject4 = localObject1;
              if (i1 != 0) {
                localObject4 = ImageUtil.rotaingImageView(i1, (Bitmap)localObject1);
              }
              localObject1 = new RectF();
              ((RectF)localObject1).left = f5;
              ((RectF)localObject1).top = f6;
              ((RectF)localObject1).right = (((RectF)localObject1).left + f2);
              ((RectF)localObject1).bottom = (f1 + ((RectF)localObject1).top);
              paramCanvas.drawBitmap((Bitmap)localObject4, null, (RectF)localObject1, null);
              ((Bitmap)localObject4).recycle();
            }
          }
          i += 1;
          break;
          localObject1 = this.mApkgInfo.getFilePath((String)localObject4);
          break label94;
          if ((i1 == 90) || (i1 == 270))
          {
            f1 = f4;
            f2 = this.mDensity;
            f1 = f4;
            f2 = ((BitmapFactory.Options)localObject4).outHeight * f2;
            f1 = f2;
            f4 = this.mDensity;
            f1 = f2;
            f4 = ((BitmapFactory.Options)localObject4).outWidth * f4;
            f1 = f4;
          }
          else
          {
            f1 = f4;
            f2 = this.mDensity;
            f1 = f4;
            f2 = ((BitmapFactory.Options)localObject4).outWidth * f2;
            f1 = f2;
            f4 = this.mDensity;
            f1 = f2;
            i2 = ((BitmapFactory.Options)localObject4).outHeight;
            f1 = i2 * f4;
            continue;
            f4 = (int)(f3 * f2);
            f3 = (int)(f3 * f1);
          }
        }
      }
    }
    label1689:
    label2078:
    label3235:
    label5413:
    for (;;)
    {
      ((BitmapFactory.Options)localObject4).inSampleSize = ImageUtil.calculateInSampleSize((BitmapFactory.Options)localObject4, f4, f3);
      ((BitmapFactory.Options)localObject4).inJustDecodeBounds = false;
      localObject1 = ImageUtil.getLocalCompressedBitmap((String)localObject1, (BitmapFactory.Options)localObject4);
      break;
      Object localObject7;
      Object localObject6;
      if (("setStrokeStyle".equals(localObject1)) || ("setFillStyle".equals(localObject1)))
      {
        this.mRepeatX = false;
        this.mRepeatY = false;
        this.mBitmapW = 0;
        this.mBitmapH = 0;
        localObject4 = localException3.optString(0);
        if ("normal".equals(localObject4))
        {
          localObject4 = localException3.optJSONArray(1);
          if ("setStrokeStyle".equals(localObject1))
          {
            j = getColor((JSONArray)localObject4);
            this.mStrokeColorAlpha = ((JSONArray)localObject4).optInt(3);
            this.mStrokePaint.setShader(null);
            this.mStrokePaint.setColor(j);
            break label505;
          }
          if (!"setFillStyle".equals(localObject1)) {
            break label505;
          }
          j = getColor((JSONArray)localObject4);
          this.mFillColorAlpha = ((JSONArray)localObject4).optInt(3);
          this.mFillPaint.setShader(null);
          this.mFillPaint.setColor(j);
          break label505;
        }
        if ("radial".equals(localObject4))
        {
          localObject4 = localException3.optJSONArray(1);
          localObject7 = localException3.optJSONArray(2);
          localObject6 = ((JSONArray)localObject7).optJSONArray(0).optJSONArray(1);
          localObject7 = ((JSONArray)localObject7).optJSONArray(1).optJSONArray(1);
          localObject4 = new RadialGradient(mpx2px(((JSONArray)localObject4).optDouble(0)), mpx2px(((JSONArray)localObject4).optDouble(1)), mpx2px(((JSONArray)localObject4).optDouble(2)), getColor((JSONArray)localObject6), getColor((JSONArray)localObject7), Shader.TileMode.CLAMP);
          if ("setStrokeStyle".equals(localObject1))
          {
            this.mStrokePaint.setShader((Shader)localObject4);
            break label505;
          }
          if (!"setFillStyle".equals(localObject1)) {
            break label505;
          }
          this.mFillPaint.setShader((Shader)localObject4);
          break label505;
        }
        if ("linear".equals(localObject4))
        {
          localObject4 = ((JSONArray)localObject6).optJSONArray(1);
          localObject7 = ((JSONArray)localObject6).optJSONArray(2);
          localObject6 = ((JSONArray)localObject7).optJSONArray(0).optJSONArray(1);
          localObject7 = ((JSONArray)localObject7).optJSONArray(1).optJSONArray(1);
          localObject4 = new LinearGradient(mpx2px(((JSONArray)localObject4).optDouble(0)), mpx2px(((JSONArray)localObject4).optDouble(1)), mpx2px(((JSONArray)localObject4).optDouble(2)), mpx2px(((JSONArray)localObject4).optDouble(3)), getColor((JSONArray)localObject6), getColor((JSONArray)localObject7), Shader.TileMode.CLAMP);
          if ("setStrokeStyle".equals(localObject1))
          {
            this.mStrokePaint.setShader((Shader)localObject4);
            break label505;
          }
          if (!"setFillStyle".equals(localObject1)) {
            break label505;
          }
          this.mFillPaint.setShader((Shader)localObject4);
          break label505;
        }
        if ((!"pattern".equals(localObject4)) || (((JSONArray)localObject6).length() != 3)) {
          break label505;
        }
        localObject4 = ((JSONArray)localObject6).optString(1);
        localObject1 = localObject4;
        if (!baip.a((String)localObject4))
        {
          if (((String)localObject4).startsWith("wxfile")) {
            localObject1 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject4);
          }
        }
        else
        {
          label1480:
          localObject4 = ((JSONArray)localObject6).optString(2);
          if (!"repeat".equals(localObject4)) {
            break label1689;
          }
          this.mRepeatX = true;
          this.mRepeatY = true;
          label1509:
          if (baip.a((String)localObject1)) {
            break label1725;
          }
          localObject1 = ImageUtil.getLocalBitmap((String)localObject1);
          if (localObject1 != null)
          {
            this.mBitmapW = ((Bitmap)localObject1).getWidth();
            this.mBitmapH = ((Bitmap)localObject1).getHeight();
          }
          localObject4 = new Matrix();
          ((Matrix)localObject4).postScale(this.mDensity, this.mDensity);
          localObject6 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, this.mBitmapW, this.mBitmapH, (Matrix)localObject4, true);
          if (localObject6 == null) {
            break label505;
          }
          this.mBitmapW = ((Bitmap)localObject6).getWidth();
          this.mBitmapH = ((Bitmap)localObject6).getHeight();
          if (!this.mRepeatX) {
            break label1727;
          }
          localObject1 = Shader.TileMode.REPEAT;
          label1625:
          if (!this.mRepeatY) {
            break label1735;
          }
        }
        label1725:
        label1727:
        label1735:
        for (localObject4 = Shader.TileMode.REPEAT;; localObject4 = Shader.TileMode.CLAMP)
        {
          localObject1 = new BitmapShader((Bitmap)localObject6, (Shader.TileMode)localObject1, (Shader.TileMode)localObject4);
          this.mFillPaint.setShader((Shader)localObject1);
          this.mStrokePaint.setShader((Shader)localObject1);
          break;
          localObject1 = this.mApkgInfo.getFilePath((String)localObject4);
          break label1480;
          if ("repeat-x".equals(localObject4))
          {
            this.mRepeatX = true;
            break label1509;
          }
          if (!"repeat-y".equals(localObject4)) {
            break label1509;
          }
          this.mRepeatY = true;
          break label1509;
          break;
          localObject1 = Shader.TileMode.CLAMP;
          break label1625;
        }
      }
      if (("strokePath".equals(localObject1)) || ("fillPath".equals(localObject1)) || ("clip".equals(localObject1)))
      {
        if (this.mPath == null) {
          this.mPath = new Path();
        }
        this.mPath.reset();
        j = 0;
        if (j < ((JSONArray)localObject6).length())
        {
          localObject7 = ((JSONArray)localObject6).optJSONObject(j);
          if (localObject7 != null)
          {
            localObject4 = ((JSONObject)localObject7).optString("method");
            localObject7 = ((JSONObject)localObject7).optJSONArray("data");
            if (!"rect".equals(localObject4)) {
              break label2176;
            }
            f2 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
            f6 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
            f3 = mpx2px(((JSONArray)localObject7).optDouble(2, 0.0D));
            f5 = mpx2px(((JSONArray)localObject7).optDouble(3, 0.0D));
            if (f3 > 0.0F) {
              break label5567;
            }
            f1 = -f3;
            f2 += f3;
            f3 = f1;
          }
        }
      }
      label3118:
      label3509:
      label5561:
      label5567:
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
          localObject4 = new RectF();
          if (((this.mRepeatX) || (this.mRepeatY)) && ((this.mBitmapW != 0) || (this.mBitmapH != 0)))
          {
            if (this.mRepeatX) {
              f1 = 0.0F;
            }
            ((RectF)localObject4).left = f1;
            if (this.mRepeatY) {
              f2 = 0.0F;
            }
            ((RectF)localObject4).top = f2;
            if (this.mRepeatX)
            {
              f1 = ((RectF)localObject4).left + f3;
              label2047:
              ((RectF)localObject4).right = f1;
              if (!this.mRepeatY) {
                break label2123;
              }
              f1 = f4 + ((RectF)localObject4).top;
              ((RectF)localObject4).bottom = f1;
              this.mPath.addRect((RectF)localObject4, Path.Direction.CW);
              f1 = ((RectF)localObject4).right;
              f1 = ((RectF)localObject4).bottom;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            f1 = this.mBitmapW;
            break label2047;
            label2123:
            f1 = this.mBitmapH;
            break label2071;
            ((RectF)localObject4).left = f1;
            ((RectF)localObject4).top = f2;
            ((RectF)localObject4).right = (((RectF)localObject4).left + f3);
            ((RectF)localObject4).bottom = (f4 + ((RectF)localObject4).top);
            break label2078;
            if ("moveTo".equals(localObject4))
            {
              f1 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
              f2 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
              this.mPath.moveTo(f1, f2);
            }
            else if ("lineTo".equals(localObject4))
            {
              f1 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
              f2 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
              if (this.mPath.isEmpty()) {
                this.mPath.moveTo(f1, f2);
              } else {
                this.mPath.lineTo(f1, f2);
              }
            }
            else if ("closePath".equals(localObject4))
            {
              this.mPath.close();
            }
            else
            {
              if ("arc".equals(localObject4))
              {
                f5 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
                f3 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
                f4 = mpx2px(((JSONArray)localObject7).optDouble(2, 0.0D));
                double d1 = ((JSONArray)localObject7).optDouble(3, 0.0D);
                double d2 = ((JSONArray)localObject7).optDouble(4, 0.0D);
                f6 = (float)(d1 / 3.141592653589793D * 180.0D);
                f1 = (float)(d2 / 3.141592653589793D * 180.0D);
                boolean bool = ((JSONArray)localObject6).optBoolean(5);
                localObject4 = new RectF(f5 - f4, f3 - f4, f5 + f4, f3 + f4);
                if (bool)
                {
                  f1 = f6 - f1;
                  f2 = f1 % 360.0F;
                  f1 = f2;
                  if (f2 <= 0.0F) {
                    f1 = f2 + 360.0F;
                  }
                  if (!this.mPath.isEmpty()) {
                    break label2555;
                  }
                  this.mPath.addArc((RectF)localObject4, f6, f1);
                }
                for (;;)
                {
                  f1 = (float)(f5 + f4 * Math.cos(d2));
                  f1 = (float)(f3 + f4 * Math.sin(d2));
                  break;
                  f1 -= f6;
                  break label2460;
                  label2555:
                  f2 = (float)(f5 + f4 * Math.cos(d1));
                  double d3 = f3;
                  double d4 = f4;
                  f2 = (float)(Math.sin(d1) * d4 + d3);
                  if (Math.abs(Math.abs(f1) - 360.0F) < 1.0E-014D) {
                    this.mPath.addArc((RectF)localObject4, f6, f1);
                  } else {
                    this.mPath.arcTo((RectF)localObject4, f6, f1);
                  }
                }
              }
              if ("quadraticCurveTo".equals(localObject4))
              {
                f1 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
                f2 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
                f3 = mpx2px(((JSONArray)localObject7).optDouble(2, 0.0D));
                f4 = mpx2px(((JSONArray)localObject7).optDouble(3, 0.0D));
                if (this.mPath.isEmpty()) {
                  this.mPath.moveTo(f1, f2);
                }
                this.mPath.quadTo(f1, f2, f3, f4);
              }
              else if ("bezierCurveTo".equals(localObject4))
              {
                f1 = mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D));
                f2 = mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D));
                f3 = mpx2px(((JSONArray)localObject7).optDouble(2, 0.0D));
                f4 = mpx2px(((JSONArray)localObject7).optDouble(3, 0.0D));
                f5 = mpx2px(((JSONArray)localObject7).optDouble(4, 0.0D));
                f6 = mpx2px(((JSONArray)localObject7).optDouble(5, 0.0D));
                if (this.mPath.isEmpty()) {
                  this.mPath.moveTo(f1, f2);
                }
                this.mPath.cubicTo(f1, f2, f3, f4, f5, f6);
              }
              else if ("translate".equals(localObject4))
              {
                paramCanvas.translate(mpx2px(((JSONArray)localObject7).optDouble(0, 0.0D)), mpx2px(((JSONArray)localObject7).optDouble(1, 0.0D)));
              }
            }
          }
          if ("clip".equals(localObject1))
          {
            paramCanvas.clipPath(this.mPath);
            break;
          }
          paramCanvas.drawPath(this.mPath, getCurrentPaint((String)localObject1));
          break;
          if ("setFontSize".equals(localObject1))
          {
            f1 = mpx2px(((JSONArray)localObject6).optDouble(0, 0.0D));
            this.mFillPaint.setTextSize(f1);
            this.mStrokePaint.setTextSize(f1);
            break;
          }
          if ("setFontStyle".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject6).optString(0, "normal");
            if ("normal".equals(localObject1))
            {
              localObject1 = this.mFillPaint.getTypeface();
              if ((localObject1 != null) && (((Typeface)localObject1).isBold()))
              {
                j = 1;
                label3054:
                this.mFillPaint.setTypeface(Typeface.create((Typeface)localObject1, j));
                localObject1 = this.mStrokePaint.getTypeface();
                if ((localObject1 == null) || (!((Typeface)localObject1).isBold())) {
                  break label3118;
                }
              }
              for (j = 1;; j = 0)
              {
                this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject1, j));
                break;
                j = 0;
                break label3054;
              }
            }
            if ((!"italic".equals(localObject1)) && (!"oblique".equals(localObject1))) {
              break;
            }
            localObject1 = this.mFillPaint.getTypeface();
            if ((localObject1 != null) && (((Typeface)localObject1).isBold()))
            {
              j = 3;
              label3171:
              this.mFillPaint.setTypeface(Typeface.create((Typeface)localObject1, j));
              localObject1 = this.mStrokePaint.getTypeface();
              if ((localObject1 == null) || (!((Typeface)localObject1).isBold())) {
                break label3235;
              }
            }
            for (j = 3;; j = 2)
            {
              this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject1, j));
              break;
              j = 2;
              break label3171;
            }
          }
          if ("setFontWeight".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject6).optString(0);
            if ("normal".equals(localObject1))
            {
              localObject1 = this.mFillPaint.getTypeface();
              if ((localObject1 != null) && (((Typeface)localObject1).isItalic()))
              {
                j = 2;
                label3294:
                this.mFillPaint.setTypeface(Typeface.create((Typeface)localObject1, j));
                localObject1 = this.mStrokePaint.getTypeface();
                if ((localObject1 == null) || (!((Typeface)localObject1).isItalic())) {
                  break label3358;
                }
              }
              for (j = 2;; j = 0)
              {
                this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject1, j));
                break;
                j = 0;
                break label3294;
              }
            }
            if (!"bold".equals(localObject1)) {
              break;
            }
            localObject1 = this.mFillPaint.getTypeface();
            if ((localObject1 != null) && (((Typeface)localObject1).isItalic()))
            {
              j = 3;
              label3400:
              this.mFillPaint.setTypeface(Typeface.create((Typeface)localObject1, j));
              localObject1 = this.mStrokePaint.getTypeface();
              if ((localObject1 == null) || (!((Typeface)localObject1).isItalic())) {
                break label3464;
              }
            }
            for (j = 3;; j = 1)
            {
              this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject1, j));
              break;
              j = 1;
              break label3400;
            }
          }
          if ("setFontFamily".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject6).optString(0);
            localObject4 = this.mFillPaint.getTypeface();
            if (localObject4 != null)
            {
              j = ((Typeface)localObject4).getStyle();
              this.mFillPaint.setTypeface(Typeface.create((String)localObject1, j));
              localObject1 = this.mStrokePaint.getTypeface();
              if (localObject1 == null) {
                break label3569;
              }
            }
            label3569:
            for (j = ((Typeface)localObject1).getStyle();; j = 0)
            {
              this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject1, j));
              break;
              j = 0;
              break label3509;
            }
          }
          if ("setTextAlign".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject6).optString(0);
            if ("center".equals(localObject1)) {
              localObject1 = Paint.Align.CENTER;
            }
            for (;;)
            {
              this.mFillPaint.setTextAlign((Paint.Align)localObject1);
              this.mStrokePaint.setTextAlign((Paint.Align)localObject1);
              break;
              if ("right".equals(localObject1)) {
                localObject1 = Paint.Align.RIGHT;
              } else {
                localObject1 = Paint.Align.LEFT;
              }
            }
          }
          if (("fillText".equals(localObject1)) || ("strokeText".equals(localObject1)))
          {
            localObject1 = getCurrentPaint((String)localObject1);
            f5 = ((Paint)localObject1).descent();
            f6 = ((Paint)localObject1).ascent();
            j = (int)(f5 - f6);
            localObject4 = ((JSONArray)localObject6).optString(0);
            f3 = mpx2px(((JSONArray)localObject6).optDouble(1, 0.0D));
            f2 = mpx2px(((JSONArray)localObject6).optDouble(2, 0.0D));
            f4 = mpx2px(((JSONArray)localObject6).optDouble(3, -1.0D));
            if (this.mTextBaseline.equals("top")) {
              f1 = f2 - f6;
            }
            for (;;)
            {
              if (f4 <= 0.0F) {
                break label3892;
              }
              paramCanvas.save();
              f2 = f4 / ((Paint)localObject1).measureText((String)localObject4);
              if (f2 < 1.0F) {
                paramCanvas.scale(f2, 1.0F, f3, f1);
              }
              paramCanvas.drawText((String)localObject4, f3, f1, (Paint)localObject1);
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
            paramCanvas.drawText((String)localObject4, f3, f1, (Paint)localObject1);
            break;
          }
          if ("setGlobalAlpha".equals(localObject1))
          {
            this.mGlobalAlpha = ((JSONArray)localObject6).optInt(0, 0);
            break;
          }
          if ("restore".equals(localObject1)) {
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
            catch (Exception localException1)
            {
              for (;;)
              {
                QLog.e(TAG, 2, "ACTION_RESTORE: " + Log.getStackTraceString(localException1));
              }
            }
          }
        }
        if ("save".equals(localException1))
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
        if ("clearRect".equals(localException1))
        {
          paramCanvas.save();
          f4 = mpx2px(((JSONArray)localObject6).optDouble(0, 0.0D));
          f6 = mpx2px(((JSONArray)localObject6).optDouble(1, 0.0D));
          f3 = mpx2px(((JSONArray)localObject6).optDouble(2, 0.0D));
          f5 = mpx2px(((JSONArray)localObject6).optDouble(3, 0.0D));
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
          localObject2 = new RectF();
          ((RectF)localObject2).left = f1;
          ((RectF)localObject2).top = f3;
          ((RectF)localObject2).right = (((RectF)localObject2).left + f2);
          ((RectF)localObject2).bottom = (f4 + ((RectF)localObject2).top);
          paramCanvas.clipRect((RectF)localObject2);
          paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          paramCanvas.restore();
          break;
        }
        if ("setGlobalCompositeOperation".equals(localObject2))
        {
          localObject4 = ((JSONArray)localObject6).optString(0);
          localObject2 = null;
          if ("xor".equals(localObject4)) {
            localObject2 = PorterDuff.Mode.XOR;
          }
          for (;;)
          {
            if (localObject2 == null) {
              break label4563;
            }
            this.mFillPaint.setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject2));
            this.mStrokePaint.setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject2));
            break;
            if ("source-atop".equals(localObject4)) {
              localObject2 = PorterDuff.Mode.SRC_ATOP;
            } else if ("destination-out".equals(localObject4)) {
              localObject2 = PorterDuff.Mode.DST_OUT;
            } else if (("lighter".equals(localObject4)) || ("lighten".equals(localObject4)) || ("hard-light".equals(localObject4))) {
              localObject2 = PorterDuff.Mode.LIGHTEN;
            } else if ("overlay".equals(localObject4)) {
              localObject2 = PorterDuff.Mode.OVERLAY;
            } else if ("darken".equals(localObject4)) {
              localObject2 = PorterDuff.Mode.DARKEN;
            }
          }
          label4563:
          break;
        }
        if ("rotate".equals(localObject2))
        {
          paramCanvas.rotate((float)(((JSONArray)localObject6).optDouble(0, 0.0D) * 180.0D / 3.141592653589793D));
          break;
        }
        if ("scale".equals(localObject2))
        {
          paramCanvas.scale((float)((JSONArray)localObject6).optDouble(0, 1.0D), (float)((JSONArray)localObject6).optDouble(1, 1.0D));
          break;
        }
        if ("translate".equals(localObject2))
        {
          paramCanvas.translate(mpx2px(((JSONArray)localObject6).optDouble(0, 0.0D)), mpx2px(((JSONArray)localObject6).optDouble(1, 0.0D)));
          break;
        }
        if ("setLineWidth".equals(localObject2))
        {
          f1 = mpx2px(((JSONArray)localObject6).optDouble(0, 0.0D));
          this.mStrokePaint.setStrokeWidth(f1);
          break;
        }
        if ("setShadow".equals(localObject2))
        {
          localObject2 = new CanvasView.ShadowLayer(this);
          localObject4 = ((JSONArray)localObject6).optJSONArray(3);
          f1 = mpx2px(((JSONArray)localObject6).optDouble(2, 0.0D));
          f2 = mpx2px(((JSONArray)localObject6).optDouble(0, 0.0D));
          f3 = mpx2px(((JSONArray)localObject6).optDouble(1, 0.0D));
          ((CanvasView.ShadowLayer)localObject2).radius = f1;
          ((CanvasView.ShadowLayer)localObject2).dx = f2;
          ((CanvasView.ShadowLayer)localObject2).dy = f3;
          ((CanvasView.ShadowLayer)localObject2).color = getColor((JSONArray)localObject4);
          this.mFillPaint.setShadowLayer(((CanvasView.ShadowLayer)localObject2).radius, ((CanvasView.ShadowLayer)localObject2).dx, ((CanvasView.ShadowLayer)localObject2).dy, ((CanvasView.ShadowLayer)localObject2).color);
          this.mStrokePaint.setShadowLayer(((CanvasView.ShadowLayer)localObject2).radius, ((CanvasView.ShadowLayer)localObject2).dx, ((CanvasView.ShadowLayer)localObject2).dy, ((CanvasView.ShadowLayer)localObject2).color);
          break;
        }
        if ("setLineCap".equals(localObject2))
        {
          localObject2 = null;
          localObject4 = ((JSONArray)localObject6).optString(0);
          if ("butt".equals(localObject4)) {
            localObject2 = Paint.Cap.BUTT;
          }
          for (;;)
          {
            if (localObject2 == null) {
              break label4951;
            }
            this.mStrokePaint.setStrokeCap((Paint.Cap)localObject2);
            break;
            if ("round".equals(localObject4)) {
              localObject2 = Paint.Cap.ROUND;
            } else if ("square".equals(localObject4)) {
              localObject2 = Paint.Cap.SQUARE;
            }
          }
          label4951:
          break;
        }
        if ("setLineJoin".equals(localObject2))
        {
          localObject2 = null;
          localObject4 = ((JSONArray)localObject6).optString(0);
          if ("bevel".equals(localObject4)) {
            localObject2 = Paint.Join.BEVEL;
          }
          for (;;)
          {
            if (localObject2 == null) {
              break label5043;
            }
            this.mStrokePaint.setStrokeJoin((Paint.Join)localObject2);
            break;
            if ("round".equals(localObject4)) {
              localObject2 = Paint.Join.ROUND;
            } else if ("miter".equals(localObject4)) {
              localObject2 = Paint.Join.MITER;
            }
          }
          break;
        }
        if ("setLineDash".equals(localObject2))
        {
          localObject2 = (JSONArray)((JSONArray)localObject6).opt(0);
          if (((JSONArray)localObject2).length() <= 0) {
            break label5561;
          }
          f1 = mpx2px(((JSONArray)localObject6).optDouble(1, 0.0D));
          localObject4 = new float[((JSONArray)localObject2).length()];
          j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            localObject4[j] = mpx2px(((JSONArray)localObject2).optDouble(j, 0.0D));
            j += 1;
          }
        }
        Object localObject3;
        for (Object localObject2 = new DashPathEffect((float[])localObject4, f1);; localObject3 = null)
        {
          for (;;)
          {
            this.mFillPaint.setPathEffect((PathEffect)localObject2);
            this.mStrokePaint.setPathEffect((PathEffect)localObject2);
            break;
            if ("setMiterLimit".equals(localObject2))
            {
              f1 = mpx2px(((JSONArray)localObject6).optDouble(0, 0.0D));
              this.mFillPaint.setStrokeMiter(f1);
              this.mStrokePaint.setStrokeMiter(f1);
              break;
            }
            if ((!"setTransform".equals(localObject2)) && (!"transform".equals(localObject2))) {
              break label5453;
            }
            f1 = (float)((JSONArray)localObject6).optDouble(0, 1.0D);
            f2 = (float)((JSONArray)localObject6).optDouble(3, 1.0D);
            f3 = (float)((JSONArray)localObject6).optDouble(2, 0.0D);
            f4 = (float)((JSONArray)localObject6).optDouble(1, 0.0D);
            f5 = mpx2px(((JSONArray)localObject6).optDouble(4, 0.0D));
            f6 = mpx2px(((JSONArray)localObject6).optDouble(5, 0.0D));
            localObject6 = new float[9];
            localObject6[2] = f5;
            localObject6[5] = f6;
            localObject6[0] = f1;
            localObject6[4] = f2;
            localObject6[1] = f3;
            localObject6[3] = f4;
            localObject6[6] = 0.0F;
            localObject6[7] = 0.0F;
            localObject6[8] = 1.0F;
            try
            {
              if (!"transform".equals(localObject2)) {
                break label5413;
              }
              localObject2 = new Matrix();
              ((Matrix)localObject2).setValues((float[])localObject6);
              paramCanvas.concat((Matrix)localObject2);
            }
            catch (Exception localException2)
            {
              QLog.e(TAG, 2, Log.getStackTraceString(localException2));
            }
          }
          break;
          localObject4 = paramCanvas.getMatrix();
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = new Matrix();
          }
          ((Matrix)localObject3).setValues((float[])localObject6);
          paramCanvas.setMatrix((Matrix)localObject3);
          break;
          label5453:
          if ("setTextBaseline".equals(localObject3))
          {
            this.mTextBaseline = ((JSONArray)localObject6).optString(0);
            break;
          }
          if (!"canvasPutImageData".equals(localObject3)) {
            break;
          }
          putImageData(paramCanvas, (String)localObject3, ((JSONObject)localObject4).optJSONObject("data"), ((JSONObject)localObject4).optInt("callbackId"));
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
      label3892:
      label5574:
      f3 = f1;
      label5043:
      f4 = f2;
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
            localConfig = Bitmap.Config.ARGB_4444;
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
  
  private void putImageData(Canvas paramCanvas, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    int i1;
    int i;
    label88:
    int j;
    for (;;)
    {
      try
      {
        k = mpx2pxInt(paramJSONObject.optInt("x"));
        m = mpx2pxInt(paramJSONObject.optInt("y"));
        n = mpx2pxInt(paramJSONObject.optInt("width"));
        i1 = mpx2pxInt(paramJSONObject.optInt("height"));
        paramJSONObject = NativeBuffer.unpackNativeBuffer(paramJSONObject, "data", null);
        if (paramJSONObject == null) {
          break;
        }
        paramJSONObject = paramJSONObject.buf;
        localObject = new int[n * i1];
        i = 0;
      }
      catch (Throwable paramCanvas)
      {
        int k;
        int m;
        int n;
        Object localObject;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        QLog.e(TAG, 2, "putImageData failed: " + Log.getStackTraceString(paramCanvas));
        callbackJsEventFail(paramString, null, paramInt);
        return;
      }
      if (j >= n) {
        break label315;
      }
      i2 = n * i + j;
      i3 = i2 * 4;
      i4 = paramJSONObject[i3];
      i5 = paramJSONObject[(i3 + 1)];
      i6 = paramJSONObject[(i3 + 2)];
      localObject[i2] = Color.argb((paramJSONObject[(i3 + 3)] + 256) % 256, (i4 + 256) % 256, (i5 + 256) % 256, (i6 + 256) % 256);
      j += 1;
    }
    label315:
    label322:
    for (;;)
    {
      paramJSONObject = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
      paramJSONObject.setPixels((int[])localObject, 0, n, 0, 0, n, i1);
      localObject = new Paint();
      ((Paint)localObject).setAntiAlias(true);
      paramCanvas.drawBitmap(paramJSONObject, k, m, (Paint)localObject);
      callbackJsEventOK(paramString, null, paramInt);
      return;
      for (;;)
      {
        if (i >= i1) {
          break label322;
        }
        j = 0;
        break label88;
        paramJSONObject = null;
        break;
        i += 1;
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
      Object localObject = azzu.a("ro.vivo.os.version");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */