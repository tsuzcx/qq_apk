package com.tencent.qqmini.sdk.core.widget;

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
import beiu;
import bejy;
import bekr;
import beks;
import belh;
import bemh;
import bemi;
import beml;
import besl;
import bffu;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasView
  extends CoverView
{
  private static final String jdField_a_of_type_JavaLangString = CanvasView.class.getSimpleName();
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private bejy jdField_a_of_type_Bejy;
  private beml jdField_a_of_type_Beml;
  Boolean jdField_a_of_type_JavaLangBoolean;
  private final LinkedBlockingQueue<bemh> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Boolean jdField_b_of_type_JavaLangBoolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
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
  
  private int a(JSONArray paramJSONArray)
  {
    try
    {
      int m = Color.argb(paramJSONArray.optInt(3, 0), paramJSONArray.optInt(0, 0), paramJSONArray.optInt(1, 0), paramJSONArray.optInt(2, 0));
      return m;
    }
    catch (Exception paramJSONArray)
    {
      besl.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(paramJSONArray));
    }
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int n = 0;
    int m = 0;
    if (paramArrayOfByte != null)
    {
      n = 0;
      for (;;)
      {
        int i1 = n;
        n = m;
        if (i1 >= 4) {
          break;
        }
        int i2 = paramArrayOfByte[i1];
        n = i1 + 1;
        m = ((i2 & 0xFF) << (3 - i1) * 8) + m;
      }
    }
    return n;
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
        besl.d(jdField_a_of_type_JavaLangString, "getCacheBitmapFromView failed: " + Log.getStackTraceString(paramView));
        return localObject;
      }
    }
    return localBitmap;
  }
  
  private Paint a(String paramString)
  {
    if ((paramString != null) && (paramString.contains("fill")))
    {
      if ((this.jdField_b_of_type_Int != -1) && (this.jdField_b_of_type_Int < this.jdField_c_of_type_Int)) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        return this.jdField_a_of_type_AndroidGraphicsPaint;
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_c_of_type_Int);
      }
    }
    if ((this.jdField_b_of_type_Int != -1) && (this.jdField_b_of_type_Int < this.jdField_d_of_type_Int)) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      return this.jdField_b_of_type_AndroidGraphicsPaint;
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_d_of_type_Int);
    }
  }
  
  private void a()
  {
    boolean bool = this.jdField_c_of_type_Boolean;
    Object localObject3 = this.jdField_a_of_type_OrgJsonJSONArray;
    bemh localbemh = (bemh)this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.poll();
    if (localbemh != null)
    {
      Object localObject2;
      label46:
      Object localObject1;
      if (localbemh != null)
      {
        bool = localbemh.jdField_a_of_type_Boolean;
        localObject2 = localbemh.jdField_a_of_type_OrgJsonJSONArray;
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
          besl.d(jdField_a_of_type_JavaLangString, "process draw actions error! " + Log.getStackTraceString(localThrowable));
          continue;
        }
        bool = localbemh.jdField_b_of_type_Boolean;
        localbemh = (bemh)this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.poll();
        break;
        bool = false;
        localObject2 = this.jdField_a_of_type_OrgJsonJSONArray;
        break label46;
        localObject2 = beks.a((JSONArray)localObject3, (JSONArray)localObject1);
      }
    }
    this.jdField_a_of_type_OrgJsonJSONArray = ((JSONArray)localObject3);
  }
  
  private void a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    int m = 0;
    Object localObject4;
    Object localObject1;
    label93:
    float f5;
    float f6;
    float f4;
    float f3;
    int n;
    float f1;
    float f2;
    Object localObject7;
    if (m < paramJSONArray.length())
    {
      localObject4 = paramJSONArray.getJSONObject(m);
      localObject1 = ((JSONObject)localObject4).optString("method");
      Object localObject5 = ((JSONObject)localObject4).optJSONArray("data");
      if ("drawImage".equals(localObject1))
      {
        localObject4 = ((JSONArray)localObject5).optString(0);
        localObject1 = localObject4;
        int i1;
        int i2;
        int i3;
        if (!belh.a((String)localObject4))
        {
          if (((String)localObject4).startsWith("wxfile")) {
            localObject1 = beiu.a().a((String)localObject4);
          }
        }
        else if (!belh.a((String)localObject1))
        {
          f5 = b(((JSONArray)localObject5).optDouble(1, 0.0D));
          f6 = b(((JSONArray)localObject5).optDouble(2, 0.0D));
          f4 = b(((JSONArray)localObject5).optDouble(3, 0.0D));
          f3 = b(((JSONArray)localObject5).optDouble(4, 0.0D));
          n = (int)((JSONArray)localObject5).optDouble(5, 0.0D);
          i1 = (int)((JSONArray)localObject5).optDouble(6, 0.0D);
          i2 = (int)((JSONArray)localObject5).optDouble(7, 0.0D);
          i3 = (int)((JSONArray)localObject5).optDouble(8, 0.0D);
          localObject4 = new BitmapFactory.Options();
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
              if ((i2 <= 0) || (i3 <= 0)) {
                continue;
              }
              f1 = f4;
              f2 = this.jdField_c_of_type_Float * i2;
              f1 = f2;
              f4 = this.jdField_c_of_type_Float;
              f1 = f4 * i3;
            }
          }
          catch (Exception localException3)
          {
            label463:
            int i4;
            besl.d(jdField_a_of_type_JavaLangString, "calculate image size error! " + Log.getStackTraceString(localException3));
            f2 = f1;
            f1 = f3;
            continue;
            f3 = Math.min(1440.0F / f2, 4000.0F / f1);
            if (f3 >= 1.0F) {
              break label5310;
            }
          }
          if ((f2 > 0.0F) && (f1 > 0.0F))
          {
            ((BitmapFactory.Options)localObject4).inDither = true;
            if ((i2 <= 0) || (i3 <= 0)) {
              continue;
            }
            localObject5 = new Rect();
            ((Rect)localObject5).left = n;
            ((Rect)localObject5).top = i1;
            ((Rect)localObject5).right = (((Rect)localObject5).left + i2);
            ((Rect)localObject5).bottom = (((Rect)localObject5).top + i3);
            localObject7 = BitmapRegionDecoder.newInstance((String)localObject1, false);
            localObject1 = ((BitmapRegionDecoder)localObject7).decodeRegion((Rect)localObject5, (BitmapFactory.Options)localObject4);
            ((BitmapRegionDecoder)localObject7).recycle();
            if (localObject1 != null)
            {
              localObject4 = new RectF();
              ((RectF)localObject4).left = f5;
              ((RectF)localObject4).top = f6;
              ((RectF)localObject4).right = (((RectF)localObject4).left + f2);
              ((RectF)localObject4).bottom = (f1 + ((RectF)localObject4).top);
              paramCanvas.drawBitmap((Bitmap)localObject1, null, (RectF)localObject4, null);
              ((Bitmap)localObject1).recycle();
            }
          }
          m += 1;
          break;
          localObject1 = this.jdField_a_of_type_Bejy.g((String)localObject4);
          break label93;
          f1 = f4;
          f2 = this.jdField_c_of_type_Float;
          f1 = f4;
          f2 = ((BitmapFactory.Options)localObject4).outWidth * f2;
          f1 = f2;
          f4 = this.jdField_c_of_type_Float;
          f1 = f2;
          i4 = ((BitmapFactory.Options)localObject4).outHeight;
          f1 = i4 * f4;
          continue;
          f4 = (int)(f3 * f2);
          f3 = (int)(f3 * f1);
        }
      }
    }
    label1414:
    label3207:
    for (;;)
    {
      ((BitmapFactory.Options)localObject4).inSampleSize = bekr.a((BitmapFactory.Options)localObject4, f4, f3);
      ((BitmapFactory.Options)localObject4).inJustDecodeBounds = false;
      localObject1 = bekr.a((String)localObject1, (BitmapFactory.Options)localObject4);
      break;
      Object localObject6;
      if (("setStrokeStyle".equals(localObject1)) || ("setFillStyle".equals(localObject1)))
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = false;
        this.jdField_e_of_type_Int = 0;
        this.jdField_f_of_type_Int = 0;
        localObject4 = localException3.optString(0);
        if ("normal".equals(localObject4))
        {
          localObject4 = localException3.optJSONArray(1);
          if ("setStrokeStyle".equals(localObject1))
          {
            n = a((JSONArray)localObject4);
            this.jdField_d_of_type_Int = ((JSONArray)localObject4).optInt(3);
            this.jdField_b_of_type_AndroidGraphicsPaint.setShader(null);
            this.jdField_b_of_type_AndroidGraphicsPaint.setColor(n);
            break label463;
          }
          if (!"setFillStyle".equals(localObject1)) {
            break label463;
          }
          n = a((JSONArray)localObject4);
          this.jdField_c_of_type_Int = ((JSONArray)localObject4).optInt(3);
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(n);
          break label463;
        }
        if ("radial".equals(localObject4))
        {
          localObject4 = localException3.optJSONArray(1);
          localObject7 = localException3.optJSONArray(2);
          localObject6 = ((JSONArray)localObject7).optJSONArray(0).optJSONArray(1);
          localObject7 = ((JSONArray)localObject7).optJSONArray(1).optJSONArray(1);
          localObject4 = new RadialGradient(b(((JSONArray)localObject4).optDouble(0)), b(((JSONArray)localObject4).optDouble(1)), b(((JSONArray)localObject4).optDouble(2)), a((JSONArray)localObject6), a((JSONArray)localObject7), Shader.TileMode.CLAMP);
          if ("setStrokeStyle".equals(localObject1))
          {
            this.jdField_b_of_type_AndroidGraphicsPaint.setShader((Shader)localObject4);
            break label463;
          }
          if (!"setFillStyle".equals(localObject1)) {
            break label463;
          }
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject4);
          break label463;
        }
        if ("linear".equals(localObject4))
        {
          localObject4 = ((JSONArray)localObject6).optJSONArray(1);
          localObject7 = ((JSONArray)localObject6).optJSONArray(2);
          localObject6 = ((JSONArray)localObject7).optJSONArray(0).optJSONArray(1);
          localObject7 = ((JSONArray)localObject7).optJSONArray(1).optJSONArray(1);
          localObject4 = new LinearGradient(b(((JSONArray)localObject4).optDouble(0)), b(((JSONArray)localObject4).optDouble(1)), b(((JSONArray)localObject4).optDouble(2)), b(((JSONArray)localObject4).optDouble(3)), a((JSONArray)localObject6), a((JSONArray)localObject7), Shader.TileMode.CLAMP);
          if ("setStrokeStyle".equals(localObject1))
          {
            this.jdField_b_of_type_AndroidGraphicsPaint.setShader((Shader)localObject4);
            break label463;
          }
          if (!"setFillStyle".equals(localObject1)) {
            break label463;
          }
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject4);
          break label463;
        }
        if ((!"pattern".equals(localObject4)) || (((JSONArray)localObject6).length() != 3)) {
          break label463;
        }
        localObject4 = ((JSONArray)localObject6).optString(1);
        localObject1 = localObject4;
        if (!belh.a((String)localObject4))
        {
          if (((String)localObject4).startsWith("wxfile")) {
            localObject1 = beiu.a().a((String)localObject4);
          }
        }
        else
        {
          label1205:
          localObject4 = ((JSONArray)localObject6).optString(2);
          if (!"repeat".equals(localObject4)) {
            break label1414;
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_e_of_type_Boolean = true;
          label1234:
          if (belh.a((String)localObject1)) {
            break label1450;
          }
          localObject1 = bekr.a((String)localObject1);
          if (localObject1 != null)
          {
            this.jdField_e_of_type_Int = ((Bitmap)localObject1).getWidth();
            this.jdField_f_of_type_Int = ((Bitmap)localObject1).getHeight();
          }
          localObject4 = new Matrix();
          ((Matrix)localObject4).postScale(this.jdField_c_of_type_Float, this.jdField_c_of_type_Float);
          localObject6 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, (Matrix)localObject4, true);
          if (localObject6 == null) {
            break label463;
          }
          this.jdField_e_of_type_Int = ((Bitmap)localObject6).getWidth();
          this.jdField_f_of_type_Int = ((Bitmap)localObject6).getHeight();
          if (!this.jdField_d_of_type_Boolean) {
            break label1452;
          }
          localObject1 = Shader.TileMode.REPEAT;
          label1350:
          if (!this.jdField_e_of_type_Boolean) {
            break label1460;
          }
        }
        label1450:
        label1452:
        label1460:
        for (localObject4 = Shader.TileMode.REPEAT;; localObject4 = Shader.TileMode.CLAMP)
        {
          localObject1 = new BitmapShader((Bitmap)localObject6, (Shader.TileMode)localObject1, (Shader.TileMode)localObject4);
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject1);
          this.jdField_b_of_type_AndroidGraphicsPaint.setShader((Shader)localObject1);
          break;
          localObject1 = this.jdField_a_of_type_Bejy.g((String)localObject4);
          break label1205;
          if ("repeat-x".equals(localObject4))
          {
            this.jdField_d_of_type_Boolean = true;
            break label1234;
          }
          if (!"repeat-y".equals(localObject4)) {
            break label1234;
          }
          this.jdField_e_of_type_Boolean = true;
          break label1234;
          break;
          localObject1 = Shader.TileMode.CLAMP;
          break label1350;
        }
      }
      if (("strokePath".equals(localObject1)) || ("fillPath".equals(localObject1)) || ("clip".equals(localObject1)))
      {
        if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
          this.jdField_a_of_type_AndroidGraphicsPath = new Path();
        }
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        n = 0;
        if (n < ((JSONArray)localObject6).length())
        {
          localObject7 = ((JSONArray)localObject6).optJSONObject(n);
          if (localObject7 != null)
          {
            localObject4 = ((JSONObject)localObject7).optString("method");
            localObject7 = ((JSONObject)localObject7).optJSONArray("data");
            if (!"rect".equals(localObject4)) {
              break label1905;
            }
            f2 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
            f6 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
            f3 = b(((JSONArray)localObject7).optDouble(2, 0.0D));
            f5 = b(((JSONArray)localObject7).optDouble(3, 0.0D));
            if (f3 > 0.0F) {
              break label5303;
            }
            f1 = -f3;
            f2 += f3;
            f3 = f1;
          }
        }
      }
      label1800:
      label1807:
      label2193:
      label2859:
      label3253:
      label5303:
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
          if (((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) && ((this.jdField_e_of_type_Int != 0) || (this.jdField_f_of_type_Int != 0)))
          {
            if (this.jdField_d_of_type_Boolean) {
              f1 = 0.0F;
            }
            ((RectF)localObject4).left = f1;
            if (this.jdField_e_of_type_Boolean) {
              f2 = 0.0F;
            }
            ((RectF)localObject4).top = f2;
            if (this.jdField_d_of_type_Boolean)
            {
              f1 = ((RectF)localObject4).left + f3;
              label1776:
              ((RectF)localObject4).right = f1;
              if (!this.jdField_e_of_type_Boolean) {
                break label1852;
              }
              f1 = f4 + ((RectF)localObject4).top;
              ((RectF)localObject4).bottom = f1;
              this.jdField_a_of_type_AndroidGraphicsPath.addRect((RectF)localObject4, Path.Direction.CW);
              f1 = ((RectF)localObject4).right;
              f1 = ((RectF)localObject4).bottom;
            }
          }
          label1852:
          label2288:
          for (;;)
          {
            n += 1;
            break;
            f1 = this.jdField_e_of_type_Int;
            break label1776;
            f1 = this.jdField_f_of_type_Int;
            break label1800;
            ((RectF)localObject4).left = f1;
            ((RectF)localObject4).top = f2;
            ((RectF)localObject4).right = (((RectF)localObject4).left + f3);
            ((RectF)localObject4).bottom = (f4 + ((RectF)localObject4).top);
            break label1807;
            label1905:
            if ("moveTo".equals(localObject4))
            {
              f1 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
              f2 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
              this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
            }
            else if ("lineTo".equals(localObject4))
            {
              f1 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
              f2 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
              if (this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()) {
                this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
              } else {
                this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, f2);
              }
            }
            else if ("closePath".equals(localObject4))
            {
              this.jdField_a_of_type_AndroidGraphicsPath.close();
            }
            else
            {
              if ("arc".equals(localObject4))
              {
                f5 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
                f3 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
                f4 = b(((JSONArray)localObject7).optDouble(2, 0.0D));
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
                  if (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()) {
                    break label2288;
                  }
                  this.jdField_a_of_type_AndroidGraphicsPath.addArc((RectF)localObject4, f6, f1);
                }
                for (;;)
                {
                  f1 = (float)(f5 + f4 * Math.cos(d2));
                  f1 = (float)(f3 + f4 * Math.sin(d2));
                  break;
                  f1 -= f6;
                  break label2193;
                  f2 = (float)(f5 + f4 * Math.cos(d1));
                  double d3 = f3;
                  double d4 = f4;
                  f2 = (float)(Math.sin(d1) * d4 + d3);
                  if (Math.abs(Math.abs(f1) - 360.0F) < 1.0E-014D) {
                    this.jdField_a_of_type_AndroidGraphicsPath.addArc((RectF)localObject4, f6, f1);
                  } else {
                    this.jdField_a_of_type_AndroidGraphicsPath.arcTo((RectF)localObject4, f6, f1);
                  }
                }
              }
              if ("quadraticCurveTo".equals(localObject4))
              {
                f1 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
                f2 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
                f3 = b(((JSONArray)localObject7).optDouble(2, 0.0D));
                f4 = b(((JSONArray)localObject7).optDouble(3, 0.0D));
                if (this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()) {
                  this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
                }
                this.jdField_a_of_type_AndroidGraphicsPath.quadTo(f1, f2, f3, f4);
              }
              else if ("bezierCurveTo".equals(localObject4))
              {
                f1 = b(((JSONArray)localObject7).optDouble(0, 0.0D));
                f2 = b(((JSONArray)localObject7).optDouble(1, 0.0D));
                f3 = b(((JSONArray)localObject7).optDouble(2, 0.0D));
                f4 = b(((JSONArray)localObject7).optDouble(3, 0.0D));
                f5 = b(((JSONArray)localObject7).optDouble(4, 0.0D));
                f6 = b(((JSONArray)localObject7).optDouble(5, 0.0D));
                if (this.jdField_a_of_type_AndroidGraphicsPath.isEmpty()) {
                  this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
                }
                this.jdField_a_of_type_AndroidGraphicsPath.cubicTo(f1, f2, f3, f4, f5, f6);
              }
              else if ("translate".equals(localObject4))
              {
                paramCanvas.translate(b(((JSONArray)localObject7).optDouble(0, 0.0D)), b(((JSONArray)localObject7).optDouble(1, 0.0D)));
              }
            }
          }
          if ("clip".equals(localObject1))
          {
            paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
            break;
          }
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, a((String)localObject1));
          break;
          if ("setFontSize".equals(localObject1))
          {
            f1 = b(((JSONArray)localObject6).optDouble(0, 0.0D));
            this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f1);
            this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(f1);
            break;
          }
          if ("setFontStyle".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject6).optString(0, "normal");
            if ("normal".equals(localObject1))
            {
              localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
              if ((localObject1 != null) && (((Typeface)localObject1).isBold()))
              {
                n = 1;
                label2795:
                this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
                localObject1 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
                if ((localObject1 == null) || (!((Typeface)localObject1).isBold())) {
                  break label2859;
                }
              }
              for (n = 1;; n = 0)
              {
                this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
                break;
                n = 0;
                break label2795;
              }
            }
            if ((!"italic".equals(localObject1)) && (!"oblique".equals(localObject1))) {
              break;
            }
            localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
            if ((localObject1 != null) && (((Typeface)localObject1).isBold()))
            {
              n = 3;
              label2912:
              this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
              localObject1 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
              if ((localObject1 == null) || (!((Typeface)localObject1).isBold())) {
                break label2976;
              }
            }
            for (n = 3;; n = 2)
            {
              this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
              break;
              n = 2;
              break label2912;
            }
          }
          if ("setFontWeight".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject6).optString(0);
            if ("normal".equals(localObject1))
            {
              localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
              if ((localObject1 != null) && (((Typeface)localObject1).isItalic()))
              {
                n = 2;
                label3037:
                this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
                localObject1 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
                if ((localObject1 == null) || (!((Typeface)localObject1).isItalic())) {
                  break label3101;
                }
              }
              for (n = 2;; n = 0)
              {
                this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
                break;
                n = 0;
                break label3037;
              }
            }
            if (!"bold".equals(localObject1)) {
              break;
            }
            localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
            if ((localObject1 != null) && (((Typeface)localObject1).isItalic()))
            {
              n = 3;
              label3143:
              this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
              localObject1 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
              if ((localObject1 == null) || (!((Typeface)localObject1).isItalic())) {
                break label3207;
              }
            }
            for (n = 3;; n = 1)
            {
              this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
              break;
              n = 1;
              break label3143;
            }
          }
          if ("setFontFamily".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject6).optString(0);
            localObject4 = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
            if (localObject4 != null)
            {
              n = ((Typeface)localObject4).getStyle();
              this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((String)localObject1, n));
              localObject1 = this.jdField_b_of_type_AndroidGraphicsPaint.getTypeface();
              if (localObject1 == null) {
                break label3313;
              }
            }
            label3313:
            for (n = ((Typeface)localObject1).getStyle();; n = 0)
            {
              this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create((Typeface)localObject1, n));
              break;
              n = 0;
              break label3253;
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
              this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign((Paint.Align)localObject1);
              this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign((Paint.Align)localObject1);
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
            localObject1 = a((String)localObject1);
            f5 = ((Paint)localObject1).descent();
            f6 = ((Paint)localObject1).ascent();
            n = (int)(f5 - f6);
            localObject4 = ((JSONArray)localObject6).optString(0);
            f3 = b(((JSONArray)localObject6).optDouble(1, 0.0D));
            f2 = b(((JSONArray)localObject6).optDouble(2, 0.0D));
            f4 = b(((JSONArray)localObject6).optDouble(3, -1.0D));
            if (this.jdField_c_of_type_JavaLangString.equals("top")) {
              f1 = f2 + n / 2 + f5;
            }
            for (;;)
            {
              if (f4 <= 0.0F) {
                break label3645;
              }
              paramCanvas.save();
              f2 = f4 / ((Paint)localObject1).measureText((String)localObject4);
              if (f2 < 1.0F) {
                paramCanvas.scale(f2, 1.0F, f3, f1);
              }
              paramCanvas.drawText((String)localObject4, f3, f1, (Paint)localObject1);
              paramCanvas.restore();
              break;
              if (this.jdField_c_of_type_JavaLangString.equals("bottom"))
              {
                f1 = f2 - f5;
              }
              else
              {
                f1 = f2;
                if (this.jdField_c_of_type_JavaLangString.equals("middle")) {
                  f1 = f2 - (f5 + f6) / 2.0F;
                }
              }
            }
            label3645:
            paramCanvas.drawText((String)localObject4, f3, f1, (Paint)localObject1);
            break;
          }
          if ("setGlobalAlpha".equals(localObject1))
          {
            this.jdField_b_of_type_Int = ((JSONArray)localObject6).optInt(0, 0);
            break;
          }
          if ("restore".equals(localObject1)) {
            try
            {
              paramCanvas.restore();
              this.jdField_a_of_type_AndroidGraphicsPaint = this.jdField_c_of_type_AndroidGraphicsPaint;
              this.jdField_b_of_type_AndroidGraphicsPaint = this.jdField_d_of_type_AndroidGraphicsPaint;
              this.jdField_b_of_type_Int = this.jdField_g_of_type_Int;
              this.jdField_c_of_type_Int = this.jdField_h_of_type_Int;
              this.jdField_d_of_type_Int = this.i;
              this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
              this.jdField_d_of_type_Boolean = this.jdField_f_of_type_Boolean;
              this.jdField_e_of_type_Boolean = this.jdField_g_of_type_Boolean;
              this.jdField_e_of_type_Int = this.j;
              this.jdField_f_of_type_Int = this.k;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                besl.d(jdField_a_of_type_JavaLangString, "ACTION_RESTORE: " + Log.getStackTraceString(localException1));
              }
            }
          }
        }
        if ("save".equals(localException1))
        {
          paramCanvas.save();
          this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(this.jdField_b_of_type_AndroidGraphicsPaint);
          this.jdField_g_of_type_Int = this.jdField_b_of_type_Int;
          this.jdField_h_of_type_Int = this.jdField_c_of_type_Int;
          this.i = this.jdField_d_of_type_Int;
          this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          this.jdField_f_of_type_Boolean = this.jdField_d_of_type_Boolean;
          this.jdField_g_of_type_Boolean = this.jdField_e_of_type_Boolean;
          this.j = this.jdField_e_of_type_Int;
          this.k = this.jdField_f_of_type_Int;
          break;
        }
        if ("clearRect".equals(localException1))
        {
          paramCanvas.save();
          f4 = b(((JSONArray)localObject6).optDouble(0, 0.0D));
          f6 = b(((JSONArray)localObject6).optDouble(1, 0.0D));
          f3 = b(((JSONArray)localObject6).optDouble(2, 0.0D));
          f5 = b(((JSONArray)localObject6).optDouble(3, 0.0D));
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
              break label4319;
            }
            this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject2));
            this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject2));
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
          label4319:
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
          paramCanvas.translate(b(((JSONArray)localObject6).optDouble(0, 0.0D)), b(((JSONArray)localObject6).optDouble(1, 0.0D)));
          break;
        }
        if ("setLineWidth".equals(localObject2))
        {
          f1 = b(((JSONArray)localObject6).optDouble(0, 0.0D));
          this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
          break;
        }
        if ("setShadow".equals(localObject2))
        {
          localObject2 = new bemi(this);
          localObject4 = ((JSONArray)localObject6).optJSONArray(3);
          f1 = b(((JSONArray)localObject6).optDouble(2, 0.0D));
          f2 = b(((JSONArray)localObject6).optDouble(0, 0.0D));
          f3 = b(((JSONArray)localObject6).optDouble(1, 0.0D));
          ((bemi)localObject2).jdField_a_of_type_Float = f1;
          ((bemi)localObject2).jdField_b_of_type_Float = f2;
          ((bemi)localObject2).jdField_c_of_type_Float = f3;
          ((bemi)localObject2).jdField_a_of_type_Int = a((JSONArray)localObject4);
          this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(((bemi)localObject2).jdField_a_of_type_Float, ((bemi)localObject2).jdField_b_of_type_Float, ((bemi)localObject2).jdField_c_of_type_Float, ((bemi)localObject2).jdField_a_of_type_Int);
          this.jdField_b_of_type_AndroidGraphicsPaint.setShadowLayer(((bemi)localObject2).jdField_a_of_type_Float, ((bemi)localObject2).jdField_b_of_type_Float, ((bemi)localObject2).jdField_c_of_type_Float, ((bemi)localObject2).jdField_a_of_type_Int);
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
              break label4713;
            }
            this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap((Paint.Cap)localObject2);
            break;
            if ("round".equals(localObject4)) {
              localObject2 = Paint.Cap.ROUND;
            } else if ("square".equals(localObject4)) {
              localObject2 = Paint.Cap.SQUARE;
            }
          }
          label4713:
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
              break label4806;
            }
            this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin((Paint.Join)localObject2);
            break;
            if ("round".equals(localObject4)) {
              localObject2 = Paint.Join.ROUND;
            } else if ("miter".equals(localObject4)) {
              localObject2 = Paint.Join.MITER;
            }
          }
          label4806:
          break;
        }
        if ("setLineDash".equals(localObject2))
        {
          localObject2 = (JSONArray)((JSONArray)localObject6).opt(0);
          if (((JSONArray)localObject2).length() <= 0) {
            break label5297;
          }
          f1 = b(((JSONArray)localObject6).optDouble(1, 0.0D));
          localObject4 = new float[((JSONArray)localObject2).length()];
          n = 0;
          while (n < ((JSONArray)localObject2).length())
          {
            localObject4[n] = b(((JSONArray)localObject2).optDouble(n, 0.0D));
            n += 1;
          }
        }
        label5180:
        Object localObject3;
        for (Object localObject2 = new DashPathEffect((float[])localObject4, f1);; localObject3 = null)
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect((PathEffect)localObject2);
            this.jdField_b_of_type_AndroidGraphicsPaint.setPathEffect((PathEffect)localObject2);
            break;
            if ("setMiterLimit".equals(localObject2))
            {
              f1 = b(((JSONArray)localObject6).optDouble(0, 0.0D));
              this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeMiter(f1);
              this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeMiter(f1);
              break;
            }
            if ((!"setTransform".equals(localObject2)) && (!"transform".equals(localObject2))) {
              break label5220;
            }
            f1 = (float)((JSONArray)localObject6).optDouble(0, 1.0D);
            f2 = (float)((JSONArray)localObject6).optDouble(3, 1.0D);
            f3 = (float)((JSONArray)localObject6).optDouble(2, 0.0D);
            f4 = (float)((JSONArray)localObject6).optDouble(1, 0.0D);
            f5 = b(((JSONArray)localObject6).optDouble(4, 0.0D));
            f6 = b(((JSONArray)localObject6).optDouble(5, 0.0D));
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
                break label5180;
              }
              localObject2 = new Matrix();
              ((Matrix)localObject2).setValues((float[])localObject6);
              paramCanvas.concat((Matrix)localObject2);
            }
            catch (Exception localException2)
            {
              besl.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(localException2));
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
          label5220:
          if (!"setTextBaseline".equals(localObject3)) {
            break;
          }
          this.jdField_c_of_type_JavaLangString = ((JSONArray)localObject6).optString(0);
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
      label2976:
      label5297:
      label5310:
      f3 = f1;
      label3101:
      f4 = f2;
    }
  }
  
  public static byte[] a(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfShort.length * 2];
    ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(paramArrayOfShort);
    return arrayOfByte;
  }
  
  float a(double paramDouble)
  {
    return (float)(paramDouble / this.jdField_c_of_type_Float);
  }
  
  int a(double paramDouble)
  {
    return (int)(paramDouble / this.jdField_c_of_type_Float + 0.5D);
  }
  
  float b(double paramDouble)
  {
    return (float)(this.jdField_c_of_type_Float * paramDouble);
  }
  
  int b(double paramDouble)
  {
    return (int)(this.jdField_c_of_type_Float * paramDouble + 0.5D);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_h_of_type_Boolean = true;
    if ((Build.MANUFACTURER.equalsIgnoreCase("vivo")) || (Build.MODEL.toLowerCase().contains("vivo"))) {}
    try
    {
      Object localObject = bffu.a("ro.vivo.os.version", "");
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
      besl.d(jdField_a_of_type_JavaLangString, "doDraw failed! " + Log.getStackTraceString(paramCanvas));
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
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      while ((this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_JavaLangBoolean != null))
      {
        return true;
        besl.a(jdField_a_of_type_JavaLangString, "--ACTION_DOWN--");
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("x", a(paramMotionEvent.getX()));
          ((JSONObject)localObject).put("y", a(paramMotionEvent.getY()));
          ((JSONObject)localObject).put("id", paramMotionEvent.getPointerId(0));
          localJSONObject1.put("data", this.jdField_b_of_type_JavaLangString);
          localJSONObject1.put("touch", localObject);
          this.jdField_a_of_type_Beml.a("onTouchStart", localJSONObject1.toString());
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        continue;
        besl.a(jdField_a_of_type_JavaLangString, "--ACTION_POINTER_DOWN--" + paramMotionEvent.getPointerCount() + "   " + paramMotionEvent.getActionIndex() + "   " + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
        try
        {
          m = paramMotionEvent.getActionIndex();
          localObject = new JSONObject();
          ((JSONObject)localObject).put("x", a(paramMotionEvent.getX(m)));
          ((JSONObject)localObject).put("y", a(paramMotionEvent.getY(m)));
          ((JSONObject)localObject).put("id", paramMotionEvent.getPointerId(m));
          localJSONException1.put("data", this.jdField_b_of_type_JavaLangString);
          localJSONException1.put("touch", localObject);
          this.jdField_a_of_type_Beml.a("onTouchStart", localJSONException1.toString());
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
        JSONObject localJSONObject2;
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject = new JSONArray();
              int n = paramMotionEvent.getPointerCount();
              if (m >= n) {
                break label543;
              }
              float f1 = paramMotionEvent.getX(m);
              float f2 = paramMotionEvent.getY(m);
              if ((Math.abs(f1 - this.jdField_a_of_type_Float) < 0.5D) && (Math.abs(f2 - this.jdField_b_of_type_Float) < 0.5D)) {
                break label1021;
              }
              this.jdField_a_of_type_Float = f1;
              this.jdField_b_of_type_Float = f2;
              localJSONObject2 = new JSONObject();
              localJSONObject2.put("x", a(f1));
              localJSONObject2.put("y", a(f2));
              localJSONObject2.put("id", paramMotionEvent.getPointerId(m));
              ((JSONArray)localObject).put(localJSONObject2);
            }
            catch (JSONException localJSONException3)
            {
              localJSONException3.printStackTrace();
            }
            break;
            label543:
            if (((JSONArray)localObject).length() <= 0) {
              break;
            }
            localJSONException3.put("data", this.jdField_b_of_type_JavaLangString);
            localJSONException3.put("touches", localObject);
            this.jdField_a_of_type_Beml.a("onTouchMove", localJSONException3.toString());
            break;
            besl.a(jdField_a_of_type_JavaLangString, "--ACTION_UP--");
            try
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("x", a(paramMotionEvent.getX()));
              ((JSONObject)localObject).put("y", a(paramMotionEvent.getY()));
              ((JSONObject)localObject).put("id", paramMotionEvent.getPointerId(0));
              localJSONException3.put("data", this.jdField_b_of_type_JavaLangString);
              localJSONException3.put("touch", localObject);
              this.jdField_a_of_type_Beml.a("onTouchEnd", localJSONException3.toString());
            }
            catch (JSONException localJSONException4)
            {
              localJSONException4.printStackTrace();
            }
          }
          break;
          besl.a(jdField_a_of_type_JavaLangString, "--ACTION_POINTER_UP--" + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
          try
          {
            m = paramMotionEvent.getActionIndex();
            localObject = new JSONObject();
            ((JSONObject)localObject).put("x", a(paramMotionEvent.getX(m)));
            ((JSONObject)localObject).put("y", a(paramMotionEvent.getY(m)));
            ((JSONObject)localObject).put("id", paramMotionEvent.getPointerId(m));
            localJSONException4.put("data", this.jdField_b_of_type_JavaLangString);
            localJSONException4.put("touch", localObject);
            this.jdField_a_of_type_Beml.a("onTouchEnd", localJSONException4.toString());
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        break;
        besl.a(jdField_a_of_type_JavaLangString, "--ACTION_CANCEL--");
        localObject = new JSONArray();
        try
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("x", a(paramMotionEvent.getX()));
          localJSONObject2.put("y", a(paramMotionEvent.getY()));
          localJSONObject2.put("id", paramMotionEvent.getPointerId(0));
          ((JSONArray)localObject).put(localJSONObject2);
          localException.put("data", this.jdField_b_of_type_JavaLangString);
          localException.put("touches", localObject);
          this.jdField_a_of_type_Beml.a("onTouchCancel", localException.toString());
        }
        catch (JSONException localJSONException5)
        {
          localJSONException5.printStackTrace();
        }
      }
      break;
      return super.onTouchEvent(paramMotionEvent);
      label1021:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */