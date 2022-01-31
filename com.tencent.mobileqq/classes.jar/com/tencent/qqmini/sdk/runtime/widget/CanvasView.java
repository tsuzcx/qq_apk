package com.tencent.qqmini.sdk.runtime.widget;

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
import bgnt;
import bgod;
import bgor;
import bgpe;
import bgpg;
import bgpi;
import bgpv;
import bhiz;
import bhja;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.lang.reflect.Field;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasView
  extends CoverView
{
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private bgod jdField_a_of_type_Bgod;
  private final NativeViewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  Boolean jdField_a_of_type_JavaLangBoolean;
  private String jdField_a_of_type_JavaLangString;
  private final LinkedBlockingQueue<bhiz> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue();
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Boolean jdField_b_of_type_JavaLangBoolean;
  private String jdField_b_of_type_JavaLangString = "normal";
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 255;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 255;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 255;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public CanvasView(Context paramContext, NativeViewContainer paramNativeViewContainer, bgod parambgod, String paramString, int paramInt, boolean paramBoolean1, Boolean paramBoolean, boolean paramBoolean2)
  {
    super(paramContext);
    this.jdField_c_of_type_Float = DisplayUtil.getDensity(paramContext);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer = paramNativeViewContainer;
    this.jdField_a_of_type_Bgod = parambgod;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_b_of_type_JavaLangBoolean = paramBoolean;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString;
    setBackgroundResource(17170445);
    super.setIgnoreTouchEventToJS(true);
  }
  
  private int a(JSONArray paramJSONArray)
  {
    try
    {
      int m = Color.argb(paramJSONArray.optInt(3, 0), paramJSONArray.optInt(0, 0), paramJSONArray.optInt(1, 0), paramJSONArray.optInt(2, 0));
      return m;
    }
    catch (Exception paramJSONArray)
    {
      QMLog.e("CanvasView", Log.getStackTraceString(paramJSONArray));
    }
    return 0;
  }
  
  private Bitmap a(View paramView, boolean paramBoolean)
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
        int m;
        int n;
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
          m = paramView.getWidth();
          localObject = localBitmap;
          n = paramView.getHeight();
          if (paramBoolean)
          {
            localObject = localBitmap;
            localConfig = Bitmap.Config.ARGB_4444;
            localObject = localBitmap;
            localBitmap = Bitmap.createBitmap(m, n, localConfig);
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
  
  private Paint a(String paramString)
  {
    if ((paramString != null) && (paramString.contains("fill")))
    {
      if ((this.jdField_c_of_type_Int != -1) && (this.jdField_c_of_type_Int < this.jdField_d_of_type_Int)) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_c_of_type_Int);
      }
      for (;;)
      {
        return this.jdField_a_of_type_AndroidGraphicsPaint;
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_d_of_type_Int);
      }
    }
    if ((this.jdField_c_of_type_Int != -1) && (this.jdField_c_of_type_Int < this.jdField_e_of_type_Int)) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      return this.jdField_b_of_type_AndroidGraphicsPaint;
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_e_of_type_Int);
    }
  }
  
  private void a()
  {
    boolean bool = this.jdField_c_of_type_Boolean;
    Object localObject3 = this.jdField_a_of_type_OrgJsonJSONArray;
    bhiz localbhiz = (bhiz)this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.poll();
    if (localbhiz != null)
    {
      Object localObject2;
      label46:
      Object localObject1;
      if (localbhiz != null)
      {
        bool = localbhiz.jdField_a_of_type_Boolean;
        localObject2 = localbhiz.jdField_a_of_type_OrgJsonJSONArray;
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
          int m = ((JSONArray)localObject3).length();
          if (m != 0) {
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
        bool = localbhiz.jdField_b_of_type_Boolean;
        localbhiz = (bhiz)this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.poll();
        break;
        bool = false;
        localObject2 = this.jdField_a_of_type_OrgJsonJSONArray;
        break label46;
        localObject2 = bgpg.a((JSONArray)localObject3, (JSONArray)localObject1);
      }
    }
    this.jdField_a_of_type_OrgJsonJSONArray = ((JSONArray)localObject3);
  }
  
  private void a(Canvas paramCanvas, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    int i4;
    int m;
    label88:
    int n;
    for (;;)
    {
      try
      {
        i1 = b(paramJSONObject.optInt("x"));
        i2 = b(paramJSONObject.optInt("y"));
        i3 = b(paramJSONObject.optInt("width"));
        i4 = b(paramJSONObject.optInt("height"));
        paramJSONObject = bgpi.a(null, paramJSONObject, "data");
        if (paramJSONObject == null) {
          break;
        }
        paramJSONObject = paramJSONObject.a;
        localObject = new int[i3 * i4];
        m = 0;
      }
      catch (Throwable paramCanvas)
      {
        int i1;
        int i2;
        int i3;
        Object localObject;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        QMLog.e("CanvasView", "putImageData failed: " + Log.getStackTraceString(paramCanvas));
        c(paramString, null, paramInt);
        return;
      }
      if (n >= i3) {
        break label313;
      }
      i5 = i3 * m + n;
      i6 = i5 * 4;
      i7 = paramJSONObject[i6];
      i8 = paramJSONObject[(i6 + 1)];
      i9 = paramJSONObject[(i6 + 2)];
      localObject[i5] = Color.argb((paramJSONObject[(i6 + 3)] + 256) % 256, (i7 + 256) % 256, (i8 + 256) % 256, (i9 + 256) % 256);
      n += 1;
    }
    label313:
    label320:
    for (;;)
    {
      paramJSONObject = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
      paramJSONObject.setPixels((int[])localObject, 0, i3, 0, 0, i3, i4);
      localObject = new Paint();
      ((Paint)localObject).setAntiAlias(true);
      paramCanvas.drawBitmap(paramJSONObject, i1, i2, (Paint)localObject);
      b(paramString, null, paramInt);
      return;
      for (;;)
      {
        if (m >= i4) {
          break label320;
        }
        n = 0;
        break label88;
        paramJSONObject = null;
        break;
        m += 1;
      }
    }
  }
  
  private void a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    int m = 0;
    Object localObject6;
    Object localObject1;
    Object localObject7;
    label97:
    float f7;
    float f8;
    float f4;
    float f3;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    float f1;
    float f2;
    if (m < paramJSONArray.length())
    {
      localObject6 = paramJSONArray.getJSONObject(m);
      localObject1 = ((JSONObject)localObject6).optString("method");
      localObject7 = ((JSONObject)localObject6).optJSONArray("data");
      if ("drawImage".equals(localObject1))
      {
        localObject1 = ((JSONArray)localObject7).optString(0);
        localObject6 = localObject1;
        if (!bgpv.a((String)localObject1))
        {
          if (((String)localObject1).startsWith("wxfile")) {
            localObject6 = bgnt.a().a((String)localObject1);
          }
        }
        else if (!bgpv.a((String)localObject6))
        {
          f7 = (float)((JSONArray)localObject7).optDouble(1, 0.0D);
          f8 = (float)((JSONArray)localObject7).optDouble(2, 0.0D);
          f4 = (float)((JSONArray)localObject7).optDouble(3, 0.0D);
          f3 = (float)((JSONArray)localObject7).optDouble(4, 0.0D);
          n = (int)((JSONArray)localObject7).optDouble(5, 0.0D);
          i1 = (int)((JSONArray)localObject7).optDouble(6, 0.0D);
          i2 = (int)((JSONArray)localObject7).optDouble(7, 0.0D);
          i3 = (int)((JSONArray)localObject7).optDouble(8, 0.0D);
          localObject7 = new BitmapFactory.Options();
          i4 = bgpe.a((String)localObject6);
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
            if ((i2 <= 0) || (i3 <= 0)) {
              break label517;
            }
            f2 = i2;
            f1 = i3;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            label268:
            QMLog.e("CanvasView", "calculate image size error! " + Log.getStackTraceString(localException1));
            f2 = f1;
            f1 = f3;
            continue;
            if (i4 == 180)
            {
              localException1.left = (((BitmapFactory.Options)localObject7).outWidth - n - i2);
              localException1.top = (((BitmapFactory.Options)localObject7).outHeight - i1 - i3);
              localException1.right = (localException1.left + i2);
              localException1.bottom = (localException1.top + i3);
            }
            else if (i4 == 270)
            {
              localException1.left = (((BitmapFactory.Options)localObject7).outWidth - i1 - i3);
              localException1.top = n;
              localException1.right = (localException1.left + i3);
              localException1.bottom = (localException1.top + i2);
            }
            else
            {
              localException1.left = n;
              localException1.top = i1;
              localException1.right = (localException1.left + i2);
              localException1.bottom = (localException1.top + i3);
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
              if (bgpe.b((String)localObject6))
              {
                ((BitmapFactory.Options)localObject7).inPreferredConfig = Bitmap.Config.ARGB_4444;
                f5 = (float)Math.sqrt(8985600.0F / f3 / f4 / 2.0F);
                if (f5 >= 1.0F) {
                  break label1037;
                }
                ((BitmapFactory.Options)localObject7).inSampleSize = bgpe.a((BitmapFactory.Options)localObject7, f3 * f5, f4 * f5);
              }
              for (;;)
              {
                try
                {
                  for (;;)
                  {
                    localBitmap1 = BitmapFactory.decodeFile((String)localObject6, (BitmapFactory.Options)localObject7);
                    if (localBitmap1 != null) {
                      break label5768;
                    }
                    if (((BitmapFactory.Options)localObject7).inSampleSize <= 0) {
                      break label1065;
                    }
                    ((BitmapFactory.Options)localObject7).inSampleSize *= 2;
                    try
                    {
                      localBitmap1 = BitmapFactory.decodeFile((String)localObject6, (BitmapFactory.Options)localObject7);
                    }
                    catch (Throwable localThrowable3)
                    {
                      QMLog.e("CanvasView", "getLocalBitmap 2nd time error!", localThrowable3);
                      localObject3 = null;
                    }
                  }
                  ((BitmapFactory.Options)localObject7).inPreferredConfig = Bitmap.Config.RGB_565;
                  f5 = (float)Math.sqrt(8985600.0F / f3 / f4 / 2.0F);
                }
                catch (Throwable localThrowable1)
                {
                  QMLog.w("CanvasView", "getLocalBitmap error with inSampleSize error!try again with lower quality!");
                  localBitmap2 = null;
                  continue;
                }
                try
                {
                  localBitmap2 = BitmapFactory.decodeFile((String)localObject6, (BitmapFactory.Options)localObject7);
                }
                catch (Throwable localThrowable2)
                {
                  QMLog.w("CanvasView", "getLocalBitmap error! try again with lower quality!");
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
          if ((i2 <= 0) || (i3 <= 0)) {
            break label808;
          }
          localObject6 = BitmapRegionDecoder.newInstance((String)localObject6, false);
          localObject1 = new Rect();
          if (i4 != 90) {
            break label636;
          }
          ((Rect)localObject1).left = i1;
          ((Rect)localObject1).top = (((BitmapFactory.Options)localObject7).outHeight - n - i2);
          ((Rect)localObject1).right = (((Rect)localObject1).left + i3);
          ((Rect)localObject1).bottom = (((Rect)localObject1).top + i2);
          localObject1 = ((BitmapRegionDecoder)localObject6).decodeRegion((Rect)localObject1, (BitmapFactory.Options)localObject7);
          ((BitmapRegionDecoder)localObject6).recycle();
        }
      }
    }
    label517:
    label4743:
    label5768:
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject6 = localObject1;
        if (i4 != 0) {
          localObject6 = bgpe.a(i4, (Bitmap)localObject1);
        }
        localObject1 = new RectF();
        ((RectF)localObject1).left = b(f7);
        ((RectF)localObject1).top = b(f8);
        ((RectF)localObject1).right = (((RectF)localObject1).left + b(f2));
        ((RectF)localObject1).bottom = (((RectF)localObject1).top + b(f1));
        paramCanvas.drawBitmap((Bitmap)localObject6, null, (RectF)localObject1, null);
        ((Bitmap)localObject6).recycle();
      }
      label636:
      float f6;
      label808:
      float f5;
      label1037:
      label1065:
      Object localObject3;
      Object localObject8;
      label1576:
      label1637:
      do
      {
        do
        {
          for (;;)
          {
            m += 1;
            break;
            localObject6 = this.jdField_a_of_type_Bgod.getChildFileAbsolutePath((String)localObject1);
            break label97;
            if ((i4 == 90) || (i4 == 270))
            {
              f1 = f4;
              f2 = ((BitmapFactory.Options)localObject7).outHeight;
              f1 = f2;
              f4 = ((BitmapFactory.Options)localObject7).outWidth;
              f1 = f4;
              break label268;
            }
            f1 = f4;
            f2 = ((BitmapFactory.Options)localObject7).outWidth;
            f1 = f2;
            int i5 = ((BitmapFactory.Options)localObject7).outHeight;
            f1 = i5;
            break label268;
            float f9;
            Bitmap localBitmap1;
            Bitmap localBitmap2;
            Object localObject2;
            if ((!"setStrokeStyle".equals(localObject3)) && (!"setFillStyle".equals(localObject3))) {
              break label1900;
            }
            this.jdField_d_of_type_Boolean = false;
            this.jdField_e_of_type_Boolean = false;
            this.jdField_f_of_type_Int = 0;
            this.jdField_g_of_type_Int = 0;
            localObject6 = ((JSONArray)localObject7).optString(0);
            if ("normal".equals(localObject6))
            {
              localObject6 = ((JSONArray)localObject7).optJSONArray(1);
              if ("setStrokeStyle".equals(localObject3))
              {
                n = a((JSONArray)localObject6);
                this.jdField_e_of_type_Int = ((JSONArray)localObject6).optInt(3);
                this.jdField_b_of_type_AndroidGraphicsPaint.setShader(null);
                this.jdField_b_of_type_AndroidGraphicsPaint.setColor(n);
              }
              else if ("setFillStyle".equals(localObject3))
              {
                n = a((JSONArray)localObject6);
                this.jdField_d_of_type_Int = ((JSONArray)localObject6).optInt(3);
                this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
                this.jdField_a_of_type_AndroidGraphicsPaint.setColor(n);
              }
            }
            else if ("radial".equals(localObject6))
            {
              localObject6 = ((JSONArray)localObject7).optJSONArray(1);
              localObject8 = ((JSONArray)localObject7).optJSONArray(2);
              localObject7 = ((JSONArray)localObject8).optJSONArray(0).optJSONArray(1);
              localObject8 = ((JSONArray)localObject8).optJSONArray(1).optJSONArray(1);
              localObject6 = new RadialGradient(b(((JSONArray)localObject6).optDouble(0)), b(((JSONArray)localObject6).optDouble(1)), b(((JSONArray)localObject6).optDouble(2)), a((JSONArray)localObject7), a((JSONArray)localObject8), Shader.TileMode.CLAMP);
              if ("setStrokeStyle".equals(localObject3)) {
                this.jdField_b_of_type_AndroidGraphicsPaint.setShader((Shader)localObject6);
              } else if ("setFillStyle".equals(localObject3)) {
                this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject6);
              }
            }
            else
            {
              if (!"linear".equals(localObject6)) {
                break label1576;
              }
              localObject6 = ((JSONArray)localObject7).optJSONArray(1);
              localObject8 = ((JSONArray)localObject7).optJSONArray(2);
              localObject7 = ((JSONArray)localObject8).optJSONArray(0).optJSONArray(1);
              localObject8 = ((JSONArray)localObject8).optJSONArray(1).optJSONArray(1);
              localObject6 = new LinearGradient(b(((JSONArray)localObject6).optDouble(0)), b(((JSONArray)localObject6).optDouble(1)), b(((JSONArray)localObject6).optDouble(2)), b(((JSONArray)localObject6).optDouble(3)), a((JSONArray)localObject7), a((JSONArray)localObject8), Shader.TileMode.CLAMP);
              if ("setStrokeStyle".equals(localObject3)) {
                this.jdField_b_of_type_AndroidGraphicsPaint.setShader((Shader)localObject6);
              } else if ("setFillStyle".equals(localObject3)) {
                this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject6);
              }
            }
          }
        } while ((!"pattern".equals(localObject6)) || (((JSONArray)localObject7).length() != 3));
        localObject6 = ((JSONArray)localObject7).optString(1);
        localObject3 = localObject6;
        if (!bgpv.a((String)localObject6))
        {
          if (!((String)localObject6).startsWith("wxfile")) {
            break label1832;
          }
          localObject3 = bgnt.a().a((String)localObject6);
        }
        localObject6 = ((JSONArray)localObject7).optString(2);
        if (!"repeat".equals(localObject6)) {
          break label1846;
        }
        this.jdField_d_of_type_Boolean = true;
        this.jdField_e_of_type_Boolean = true;
        if (bgpv.a((String)localObject3)) {
          break label1882;
        }
        localObject3 = bgpe.a((String)localObject3);
        if (localObject3 != null)
        {
          this.jdField_f_of_type_Int = ((Bitmap)localObject3).getWidth();
          this.jdField_g_of_type_Int = ((Bitmap)localObject3).getHeight();
        }
        localObject6 = new Matrix();
        ((Matrix)localObject6).postScale(this.jdField_c_of_type_Float, this.jdField_c_of_type_Float);
        localObject7 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, (Matrix)localObject6, true);
      } while (localObject7 == null);
      this.jdField_f_of_type_Int = ((Bitmap)localObject7).getWidth();
      this.jdField_g_of_type_Int = ((Bitmap)localObject7).getHeight();
      if (this.jdField_d_of_type_Boolean)
      {
        localObject3 = Shader.TileMode.REPEAT;
        label1782:
        if (!this.jdField_e_of_type_Boolean) {
          break label1892;
        }
      }
      label1832:
      label1846:
      label1882:
      label1892:
      for (localObject6 = Shader.TileMode.REPEAT;; localObject6 = Shader.TileMode.CLAMP)
      {
        localObject3 = new BitmapShader((Bitmap)localObject7, (Shader.TileMode)localObject3, (Shader.TileMode)localObject6);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject3);
        this.jdField_b_of_type_AndroidGraphicsPaint.setShader((Shader)localObject3);
        break;
        localObject3 = this.jdField_a_of_type_Bgod.getChildFileAbsolutePath((String)localObject6);
        break label1637;
        if ("repeat-x".equals(localObject6))
        {
          this.jdField_d_of_type_Boolean = true;
          break label1666;
        }
        if (!"repeat-y".equals(localObject6)) {
          break label1666;
        }
        this.jdField_e_of_type_Boolean = true;
        break label1666;
        break;
        localObject3 = Shader.TileMode.CLAMP;
        break label1782;
      }
      label1900:
      if (("strokePath".equals(localObject3)) || ("fillPath".equals(localObject3)) || ("clip".equals(localObject3)))
      {
        if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
          this.jdField_a_of_type_AndroidGraphicsPath = new Path();
        }
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        n = 0;
        if (n < ((JSONArray)localObject7).length())
        {
          localObject8 = ((JSONArray)localObject7).optJSONObject(n);
          if (localObject8 != null)
          {
            localObject6 = ((JSONObject)localObject8).optString("method");
            localObject8 = ((JSONObject)localObject8).optJSONArray("data");
            if (!"rect".equals(localObject6)) {
              break label2339;
            }
            f2 = b(((JSONArray)localObject8).optDouble(0, 0.0D));
            f6 = b(((JSONArray)localObject8).optDouble(1, 0.0D));
            f3 = b(((JSONArray)localObject8).optDouble(2, 0.0D));
            f5 = b(((JSONArray)localObject8).optDouble(3, 0.0D));
            if (f3 > 0.0F) {
              break label5761;
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
          if (((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) && ((this.jdField_f_of_type_Int != 0) || (this.jdField_g_of_type_Int != 0)))
          {
            if (this.jdField_d_of_type_Boolean) {
              f1 = 0.0F;
            }
            ((RectF)localObject6).left = f1;
            if (this.jdField_e_of_type_Boolean) {
              f2 = 0.0F;
            }
            ((RectF)localObject6).top = f2;
            if (this.jdField_d_of_type_Boolean)
            {
              f1 = ((RectF)localObject6).left + f3;
              label2210:
              ((RectF)localObject6).right = f1;
              if (!this.jdField_e_of_type_Boolean) {
                break label2286;
              }
              f1 = f4 + ((RectF)localObject6).top;
              label2234:
              ((RectF)localObject6).bottom = f1;
              label2241:
              this.jdField_a_of_type_AndroidGraphicsPath.addRect((RectF)localObject6, Path.Direction.CW);
              f1 = ((RectF)localObject6).right;
              f1 = ((RectF)localObject6).bottom;
            }
          }
          label2722:
          for (;;)
          {
            n += 1;
            break;
            f1 = this.jdField_f_of_type_Int;
            break label2210;
            label2286:
            f1 = this.jdField_g_of_type_Int;
            break label2234;
            ((RectF)localObject6).left = f1;
            ((RectF)localObject6).top = f2;
            ((RectF)localObject6).right = (((RectF)localObject6).left + f3);
            ((RectF)localObject6).bottom = (f4 + ((RectF)localObject6).top);
            break label2241;
            label2339:
            if ("moveTo".equals(localObject6))
            {
              f1 = b(((JSONArray)localObject8).optDouble(0, 0.0D));
              f2 = b(((JSONArray)localObject8).optDouble(1, 0.0D));
              this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
            }
            else if ("lineTo".equals(localObject6))
            {
              f1 = b(((JSONArray)localObject8).optDouble(0, 0.0D));
              f2 = b(((JSONArray)localObject8).optDouble(1, 0.0D));
              if (this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()) {
                this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
              } else {
                this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, f2);
              }
            }
            else if ("closePath".equals(localObject6))
            {
              this.jdField_a_of_type_AndroidGraphicsPath.close();
            }
            else
            {
              if ("arc".equals(localObject6))
              {
                f5 = b(((JSONArray)localObject8).optDouble(0, 0.0D));
                f3 = b(((JSONArray)localObject8).optDouble(1, 0.0D));
                f4 = b(((JSONArray)localObject8).optDouble(2, 0.0D));
                double d1 = ((JSONArray)localObject8).optDouble(3, 0.0D);
                double d2 = ((JSONArray)localObject8).optDouble(4, 0.0D);
                f6 = (float)(d1 / 3.141592653589793D * 180.0D);
                f1 = (float)(d2 / 3.141592653589793D * 180.0D);
                boolean bool = ((JSONArray)localObject7).optBoolean(5);
                localObject6 = new RectF(f5 - f4, f3 - f4, f5 + f4, f3 + f4);
                if (bool)
                {
                  f1 = f6 - f1;
                  label2627:
                  f2 = f1 % 360.0F;
                  f1 = f2;
                  if (f2 <= 0.0F) {
                    f1 = f2 + 360.0F;
                  }
                  if (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()) {
                    break label2722;
                  }
                  this.jdField_a_of_type_AndroidGraphicsPath.addArc((RectF)localObject6, f6, f1);
                }
                for (;;)
                {
                  f1 = (float)(f5 + f4 * Math.cos(d2));
                  f1 = (float)(f3 + f4 * Math.sin(d2));
                  break;
                  f1 -= f6;
                  break label2627;
                  f2 = (float)(f5 + f4 * Math.cos(d1));
                  double d3 = f3;
                  double d4 = f4;
                  f2 = (float)(Math.sin(d1) * d4 + d3);
                  if (Math.abs(Math.abs(f1) - 360.0F) < 1.0E-014D) {
                    this.jdField_a_of_type_AndroidGraphicsPath.addArc((RectF)localObject6, f6, f1);
                  } else {
                    this.jdField_a_of_type_AndroidGraphicsPath.arcTo((RectF)localObject6, f6, f1);
                  }
                }
              }
              if ("quadraticCurveTo".equals(localObject6))
              {
                f1 = b(((JSONArray)localObject8).optDouble(0, 0.0D));
                f2 = b(((JSONArray)localObject8).optDouble(1, 0.0D));
                f3 = b(((JSONArray)localObject8).optDouble(2, 0.0D));
                f4 = b(((JSONArray)localObject8).optDouble(3, 0.0D));
                if (this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()) {
                  this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
                }
                this.jdField_a_of_type_AndroidGraphicsPath.quadTo(f1, f2, f3, f4);
              }
              else if ("bezierCurveTo".equals(localObject6))
              {
                f1 = b(((JSONArray)localObject8).optDouble(0, 0.0D));
                f2 = b(((JSONArray)localObject8).optDouble(1, 0.0D));
                f3 = b(((JSONArray)localObject8).optDouble(2, 0.0D));
                f4 = b(((JSONArray)localObject8).optDouble(3, 0.0D));
                f5 = b(((JSONArray)localObject8).optDouble(4, 0.0D));
                f6 = b(((JSONArray)localObject8).optDouble(5, 0.0D));
                if (this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()) {
                  this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
                }
                this.jdField_a_of_type_AndroidGraphicsPath.cubicTo(f1, f2, f3, f4, f5, f6);
              }
              else if ("translate".equals(localObject6))
              {
                paramCanvas.translate(b(((JSONArray)localObject8).optDouble(0, 0.0D)), b(((JSONArray)localObject8).optDouble(1, 0.0D)));
              }
            }
          }
          if ("clip".equals(localObject3))
          {
            paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
            break;
          }
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, a((String)localObject3));
          break;
          if ("setFontSize".equals(localObject3))
          {
            f1 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
            this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f1);
            this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(f1);
            break;
          }
          if ("setFontStyle".equals(localObject3))
          {
            localObject3 = ((JSONArray)localObject7).optString(0, "normal");
            if ("normal".equals(localObject3))
            {
              localObject3 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
              if ((localObject3 != null) && (((Typeface)localObject3).isBold()))
              {
                n = 1;
                label3227:
                this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
                localObject3 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
                if ((localObject3 == null) || (!((Typeface)localObject3).isBold())) {
                  break label3291;
                }
              }
              label3291:
              for (n = 1;; n = 0)
              {
                this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
                break;
                n = 0;
                break label3227;
              }
            }
            if ((!"italic".equals(localObject3)) && (!"oblique".equals(localObject3))) {
              break;
            }
            localObject3 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
            if ((localObject3 != null) && (((Typeface)localObject3).isBold()))
            {
              n = 3;
              label3344:
              this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
              localObject3 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
              if ((localObject3 == null) || (!((Typeface)localObject3).isBold())) {
                break label3408;
              }
            }
            label3408:
            for (n = 3;; n = 2)
            {
              this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
              break;
              n = 2;
              break label3344;
            }
          }
          if ("setFontWeight".equals(localObject3))
          {
            localObject3 = ((JSONArray)localObject7).optString(0);
            if ("normal".equals(localObject3))
            {
              localObject3 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
              if ((localObject3 != null) && (((Typeface)localObject3).isItalic()))
              {
                n = 2;
                label3468:
                this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
                localObject3 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
                if ((localObject3 == null) || (!((Typeface)localObject3).isItalic())) {
                  break label3532;
                }
              }
              label3532:
              for (n = 2;; n = 0)
              {
                this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
                break;
                n = 0;
                break label3468;
              }
            }
            if (!"bold".equals(localObject3)) {
              break;
            }
            localObject3 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
            if ((localObject3 != null) && (((Typeface)localObject3).isItalic()))
            {
              n = 3;
              label3574:
              this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
              localObject3 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
              if ((localObject3 == null) || (!((Typeface)localObject3).isItalic())) {
                break label3638;
              }
            }
            label3638:
            for (n = 3;; n = 1)
            {
              this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
              break;
              n = 1;
              break label3574;
            }
          }
          if ("setFontFamily".equals(localObject3))
          {
            localObject3 = ((JSONArray)localObject7).optString(0);
            localObject6 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
            if (localObject6 != null)
            {
              n = ((Typeface)localObject6).getStyle();
              label3684:
              this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((String)localObject3, n));
              localObject3 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
              if (localObject3 == null) {
                break label3744;
              }
            }
            label3744:
            for (n = ((Typeface)localObject3).getStyle();; n = 0)
            {
              this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject3, n));
              break;
              n = 0;
              break label3684;
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
              this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign((Paint.Align)localObject3);
              this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign((Paint.Align)localObject3);
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
            localObject3 = a((String)localObject3);
            f5 = ((Paint)localObject3).descent();
            f6 = ((Paint)localObject3).ascent();
            n = (int)(f5 - f6);
            localObject6 = ((JSONArray)localObject7).optString(0);
            f3 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
            f2 = b(((JSONArray)localObject7).optDouble(2, 0.0D));
            f4 = b(((JSONArray)localObject7).optDouble(3, -1.0D));
            if (this.jdField_b_of_type_JavaLangString.equals("top")) {
              f1 = f2 - f6;
            }
            for (;;)
            {
              if (f4 <= 0.0F) {
                break label4070;
              }
              paramCanvas.save();
              f2 = f4 / ((Paint)localObject3).measureText((String)localObject6);
              if (f2 < 1.0F) {
                paramCanvas.scale(f2, 1.0F, f3, f1);
              }
              paramCanvas.drawText((String)localObject6, f3, f1, (Paint)localObject3);
              paramCanvas.restore();
              break;
              if (this.jdField_b_of_type_JavaLangString.equals("bottom"))
              {
                f1 = f2 - f5;
              }
              else
              {
                f1 = f2;
                if (this.jdField_b_of_type_JavaLangString.equals("middle")) {
                  f1 = f2 - (f5 + f6) / 2.0F;
                }
              }
            }
            label4070:
            paramCanvas.drawText((String)localObject6, f3, f1, (Paint)localObject3);
            break;
          }
          if ("setGlobalAlpha".equals(localObject3))
          {
            this.jdField_c_of_type_Int = ((JSONArray)localObject7).optInt(0, 0);
            break;
          }
          if ("restore".equals(localObject3)) {
            try
            {
              paramCanvas.restore();
              this.jdField_a_of_type_AndroidGraphicsPaint = this.jdField_c_of_type_AndroidGraphicsPaint;
              this.jdField_b_of_type_AndroidGraphicsPaint = this.jdField_d_of_type_AndroidGraphicsPaint;
              this.jdField_c_of_type_Int = this.jdField_h_of_type_Int;
              this.jdField_d_of_type_Int = this.i;
              this.jdField_e_of_type_Int = this.j;
              this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
              this.jdField_d_of_type_Boolean = this.jdField_f_of_type_Boolean;
              this.jdField_e_of_type_Boolean = this.jdField_g_of_type_Boolean;
              this.jdField_f_of_type_Int = this.k;
              this.jdField_g_of_type_Int = this.l;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QMLog.e("CanvasView", "ACTION_RESTORE: " + Log.getStackTraceString(localException2));
              }
            }
          }
        }
        if ("save".equals(localException2))
        {
          paramCanvas.save();
          this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(this.jdField_b_of_type_AndroidGraphicsPaint);
          this.jdField_h_of_type_Int = this.jdField_c_of_type_Int;
          this.i = this.jdField_d_of_type_Int;
          this.j = this.jdField_e_of_type_Int;
          this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          this.jdField_f_of_type_Boolean = this.jdField_d_of_type_Boolean;
          this.jdField_g_of_type_Boolean = this.jdField_e_of_type_Boolean;
          this.k = this.jdField_f_of_type_Int;
          this.l = this.jdField_g_of_type_Int;
          break;
        }
        if ("clearRect".equals(localException2))
        {
          paramCanvas.save();
          f4 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
          f6 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
          f3 = b(((JSONArray)localObject7).optDouble(2, 0.0D));
          f5 = b(((JSONArray)localObject7).optDouble(3, 0.0D));
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
              break label4743;
            }
            this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject4));
            this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject4));
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
          paramCanvas.translate(b(((JSONArray)localObject7).optDouble(0, 0.0D)), b(((JSONArray)localObject7).optDouble(1, 0.0D)));
          break;
        }
        if ("setLineWidth".equals(localObject4))
        {
          f1 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
          this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
          break;
        }
        if ("setShadow".equals(localObject4))
        {
          localObject4 = new bhja(this);
          localObject6 = ((JSONArray)localObject7).optJSONArray(3);
          f1 = b(((JSONArray)localObject7).optDouble(2, 0.0D));
          f2 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
          f3 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
          ((bhja)localObject4).jdField_a_of_type_Float = f1;
          ((bhja)localObject4).jdField_b_of_type_Float = f2;
          ((bhja)localObject4).jdField_c_of_type_Float = f3;
          ((bhja)localObject4).jdField_a_of_type_Int = a((JSONArray)localObject6);
          this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(((bhja)localObject4).jdField_a_of_type_Float, ((bhja)localObject4).jdField_b_of_type_Float, ((bhja)localObject4).jdField_c_of_type_Float, ((bhja)localObject4).jdField_a_of_type_Int);
          this.jdField_b_of_type_AndroidGraphicsPaint.setShadowLayer(((bhja)localObject4).jdField_a_of_type_Float, ((bhja)localObject4).jdField_b_of_type_Float, ((bhja)localObject4).jdField_c_of_type_Float, ((bhja)localObject4).jdField_a_of_type_Int);
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
              break label5137;
            }
            this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap((Paint.Cap)localObject4);
            break;
            if ("round".equals(localObject6)) {
              localObject4 = Paint.Cap.ROUND;
            } else if ("square".equals(localObject6)) {
              localObject4 = Paint.Cap.SQUARE;
            }
          }
          label5137:
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
              break label5230;
            }
            this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin((Paint.Join)localObject4);
            break;
            if ("round".equals(localObject6)) {
              localObject4 = Paint.Join.ROUND;
            } else if ("miter".equals(localObject6)) {
              localObject4 = Paint.Join.MITER;
            }
          }
          label5230:
          break;
        }
        if ("setLineDash".equals(localObject4))
        {
          localObject4 = (JSONArray)((JSONArray)localObject7).opt(0);
          if (((JSONArray)localObject4).length() <= 0) {
            break label5755;
          }
          f1 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
          localObject6 = new float[((JSONArray)localObject4).length()];
          n = 0;
          while (n < ((JSONArray)localObject4).length())
          {
            localObject6[n] = b(((JSONArray)localObject4).optDouble(n, 0.0D));
            n += 1;
          }
        }
        label5603:
        Object localObject5;
        label5643:
        label5755:
        for (Object localObject4 = new DashPathEffect((float[])localObject6, f1);; localObject5 = null)
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect((PathEffect)localObject4);
            this.jdField_b_of_type_AndroidGraphicsPaint.setPathEffect((PathEffect)localObject4);
            break;
            if ("setMiterLimit".equals(localObject4))
            {
              f1 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
              this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeMiter(f1);
              this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeMiter(f1);
              break;
            }
            if ((!"setTransform".equals(localObject4)) && (!"transform".equals(localObject4))) {
              break label5643;
            }
            f1 = (float)((JSONArray)localObject7).optDouble(0, 1.0D);
            f2 = (float)((JSONArray)localObject7).optDouble(3, 1.0D);
            f3 = (float)((JSONArray)localObject7).optDouble(2, 0.0D);
            f4 = (float)((JSONArray)localObject7).optDouble(1, 0.0D);
            f5 = b(((JSONArray)localObject7).optDouble(4, 0.0D));
            f6 = b(((JSONArray)localObject7).optDouble(5, 0.0D));
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
                break label5603;
              }
              localObject4 = new Matrix();
              ((Matrix)localObject4).setValues((float[])localObject7);
              paramCanvas.concat((Matrix)localObject4);
            }
            catch (Exception localException3)
            {
              QMLog.e("CanvasView", Log.getStackTraceString(localException3));
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
          if ("setTextBaseline".equals(localObject5))
          {
            this.jdField_b_of_type_JavaLangString = ((JSONArray)localObject7).optString(0);
            break;
          }
          if (!"canvasPutImageData".equals(localObject5)) {
            break;
          }
          a(paramCanvas, (String)localObject5, ((JSONObject)localObject6).optJSONObject("data"), ((JSONObject)localObject6).optInt("callbackId"));
          break;
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
          this.jdField_a_of_type_AndroidGraphicsPaint.clearShadowLayer();
          this.jdField_b_of_type_AndroidGraphicsPaint.setShader(null);
          this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
          this.jdField_b_of_type_AndroidGraphicsPaint.clearShadowLayer();
          return;
        }
      }
    }
  }
  
  float a(double paramDouble)
  {
    return (float)(paramDouble / this.jdField_c_of_type_Float);
  }
  
  int a(double paramDouble)
  {
    return (int)(paramDouble / this.jdField_c_of_type_Float + 0.5D);
  }
  
  public void a(bhiz parambhiz)
  {
    long l1;
    if ((this.jdField_h_of_type_Boolean) && (parambhiz != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.offer(parambhiz);
      l1 = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long != 0L) {
        break label47;
      }
      a();
      postInvalidate();
      this.jdField_a_of_type_Long = l1;
    }
    label47:
    long l2;
    do
    {
      return;
      l2 = l1 - this.jdField_a_of_type_Long;
      if (l2 >= 16L)
      {
        a();
        postInvalidate();
        this.jdField_a_of_type_Long = l1;
        return;
      }
    } while (this.jdField_b_of_type_Long != 0L);
    this.jdField_b_of_type_Long = l1;
    postDelayed(new CanvasView.3(this), 16L - l2);
  }
  
  public void a(NativeViewContainer paramNativeViewContainer, Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt)
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
    for (long l1 = 300L;; l1 = 0L)
    {
      bgor.a(new CanvasView.2(this, bool, paramNativeViewContainer, paramString, paramInt, paramJSONObject, paramContext), l1);
      return;
      paramContext = paramJSONObject.optString("fileType");
      break;
      bool = false;
      break label21;
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a().b(paramString1, paramString2);
  }
  
  public void a(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    bgor.a(new CanvasView.1(this, paramString, paramInt, paramJSONObject));
  }
  
  float b(double paramDouble)
  {
    return (float)(this.jdField_c_of_type_Float * paramDouble);
  }
  
  int b(double paramDouble)
  {
    return (int)(this.jdField_c_of_type_Float * paramDouble + 0.5D);
  }
  
  public void b(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a().b(paramString, paramJSONObject, paramInt);
  }
  
  public void c(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a().c(paramString, paramJSONObject, paramInt);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_h_of_type_Boolean = true;
    if ((Build.MANUFACTURER.equalsIgnoreCase("vivo")) || (Build.MODEL.toLowerCase().contains("vivo"))) {}
    try
    {
      Object localObject = DisplayUtil.getSystemProperty("ro.vivo.os.version", null);
      if ((localObject != null) && ("3.1".equals(((String)localObject).trim())))
      {
        localObject = Class.forName("android.util.VivoSmartMultiWindowConfig").getDeclaredField("ENABLE_SPLIT");
        if (this.jdField_a_of_type_JavaLangBoolean == null) {
          this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Field)localObject).getBoolean(null));
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
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaLangBoolean != null) {}
    try
    {
      Class.forName("android.util.VivoSmartMultiWindowConfig").getDeclaredField("ENABLE_SPLIT").set(null, Boolean.valueOf(this.jdField_a_of_type_JavaLangBoolean.booleanValue()));
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = 0;
    super.onDraw(paramCanvas);
    try
    {
      if (getLayerType() == 0) {
        m = paramCanvas.saveLayer(this.jdField_a_of_type_AndroidGraphicsRectF, null, 31);
      }
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      a(paramCanvas, this.jdField_a_of_type_OrgJsonJSONArray);
      if (m > 0) {
        paramCanvas.restoreToCount(m);
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
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 0;
    Object localObject1 = new JSONObject();
    Object localObject2;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      while (this.jdField_b_of_type_Boolean)
      {
        localObject1 = this.jdField_b_of_type_JavaLangBoolean;
        if ((localObject1 == null) || (((Boolean)localObject1).booleanValue() != true)) {
          break;
        }
        return true;
        QMLog.d("CanvasView", "--ACTION_DOWN--");
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("x", a(paramMotionEvent.getX()));
          ((JSONObject)localObject2).put("y", a(paramMotionEvent.getY()));
          ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(0));
          ((JSONObject)localObject1).put("data", this.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject1).put("touch", localObject2);
          a("onTouchStart", ((JSONObject)localObject1).toString());
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        continue;
        QMLog.d("CanvasView", "--ACTION_POINTER_DOWN--" + paramMotionEvent.getPointerCount() + "   " + paramMotionEvent.getActionIndex() + "   " + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
        try
        {
          m = paramMotionEvent.getActionIndex();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("x", a(paramMotionEvent.getX(m)));
          ((JSONObject)localObject2).put("y", a(paramMotionEvent.getY(m)));
          ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(m));
          localJSONException1.put("data", this.jdField_a_of_type_JavaLangString);
          localJSONException1.put("touch", localObject2);
          a("onTouchStart", localJSONException1.toString());
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
              int n = paramMotionEvent.getPointerCount();
              if (m >= n) {
                break label543;
              }
              float f1 = paramMotionEvent.getX(m);
              float f2 = paramMotionEvent.getY(m);
              if ((Math.abs(f1 - this.jdField_a_of_type_Float) < 0.5D) && (Math.abs(f2 - this.jdField_b_of_type_Float) < 0.5D)) {
                break label999;
              }
              this.jdField_a_of_type_Float = f1;
              this.jdField_b_of_type_Float = f2;
              localJSONObject = new JSONObject();
              localJSONObject.put("x", a(f1));
              localJSONObject.put("y", a(f2));
              localJSONObject.put("id", paramMotionEvent.getPointerId(m));
              ((JSONArray)localObject2).put(localJSONObject);
            }
            catch (JSONException localJSONException3)
            {
              localJSONException3.printStackTrace();
            }
            break;
            label543:
            if (((JSONArray)localObject2).length() <= 0) {
              break;
            }
            localJSONException3.put("data", this.jdField_a_of_type_JavaLangString);
            localJSONException3.put("touches", localObject2);
            a("onTouchMove", localJSONException3.toString());
            break;
            QMLog.d("CanvasView", "--ACTION_UP--");
            try
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("x", a(paramMotionEvent.getX()));
              ((JSONObject)localObject2).put("y", a(paramMotionEvent.getY()));
              ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(0));
              localJSONException3.put("data", this.jdField_a_of_type_JavaLangString);
              localJSONException3.put("touch", localObject2);
              a("onTouchEnd", localJSONException3.toString());
            }
            catch (JSONException localJSONException4)
            {
              localJSONException4.printStackTrace();
            }
          }
          break;
          QMLog.d("CanvasView", "--ACTION_POINTER_UP--" + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
          try
          {
            m = paramMotionEvent.getActionIndex();
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("x", a(paramMotionEvent.getX(m)));
            ((JSONObject)localObject2).put("y", a(paramMotionEvent.getY(m)));
            ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(m));
            localJSONException4.put("data", this.jdField_a_of_type_JavaLangString);
            localJSONException4.put("touch", localObject2);
            a("onTouchEnd", localJSONException4.toString());
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        break;
        QMLog.d("CanvasView", "--ACTION_CANCEL--");
        localObject2 = new JSONArray();
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("x", a(paramMotionEvent.getX()));
          localJSONObject.put("y", a(paramMotionEvent.getY()));
          localJSONObject.put("id", paramMotionEvent.getPointerId(0));
          ((JSONArray)localObject2).put(localJSONObject);
          localException.put("data", this.jdField_a_of_type_JavaLangString);
          localException.put("touches", localObject2);
          a("onTouchCancel", localException.toString());
        }
        catch (JSONException localJSONException5)
        {
          localJSONException5.printStackTrace();
        }
      }
      break;
      return super.onTouchEvent(paramMotionEvent);
      label999:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */