package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.b.b;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasView
  extends View
{
  private static final String c = "CanvasView";
  public boolean a;
  public JSONArray b;
  private ArrayList d = new ArrayList();
  private Paint e;
  private Paint f;
  private Paint g;
  private PorterDuff.Mode h;
  private Path i;
  private int j = -1;
  private float k;
  private JSONObject l;
  private WebviewContainer m;
  private c n;
  private JSONArray o;
  private float p;
  private String q;
  private CanvasView.a r;
  private Paint.Cap s;
  private Paint.Join t;
  private float u;
  private int v;
  
  public CanvasView(Context paramContext, WebviewContainer paramWebviewContainer, c paramc, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.k = DisplayUtil.getDensity(paramContext);
    this.m = paramWebviewContainer;
    this.n = paramc;
    paramInt = 1;
    this.e = new Paint(1);
    this.d.add(this.e);
    this.f = new Paint(1);
    this.d.add(this.f);
    this.g = new Paint(1);
    this.d.add(this.g);
    this.q = paramString;
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramBoolean) {
        paramInt = 2;
      }
      setLayerType(paramInt, null);
    }
    setBackgroundColor(getContext().getResources().getColor(17170445));
  }
  
  private Bitmap a(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    paramView.buildDrawingCache(true);
    Bitmap localBitmap = paramView.getDrawingCache();
    if (localBitmap != null)
    {
      localBitmap = Bitmap.createBitmap(localBitmap);
      paramView.setDrawingCacheEnabled(false);
      return localBitmap;
    }
    return null;
  }
  
  private String a(JSONArray paramJSONArray, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("#");
    localStringBuilder.append(String.format("%02X", new Object[] { Integer.valueOf(paramJSONArray.optInt(paramJSONArray.length() - 1)) }));
    while (paramInt < paramJSONArray.length() - 1)
    {
      localStringBuilder.append(String.format("%02X", new Object[] { Integer.valueOf(paramJSONArray.optInt(paramInt)) }));
      paramInt += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(Canvas paramCanvas, JSONArray paramJSONArray, c paramc)
  {
    Object localObject1 = paramCanvas;
    if (paramJSONArray == null) {
      return;
    }
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.getJSONObject(i1);
      Object localObject3 = ((JSONObject)localObject2).optString("method");
      Object localObject4 = ((JSONObject)localObject2).optJSONArray("data");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("method: ");
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append("---");
        ((StringBuilder)localObject2).append(localObject4);
        QLog.d("drawCanvas", 2, ((StringBuilder)localObject2).toString());
      }
      double d1;
      double d2;
      float f1;
      if ("drawImage".equals(localObject3))
      {
        localObject3 = ((JSONArray)localObject4).optString(0);
        localObject2 = localObject3;
        if (!StringUtil.a((String)localObject3)) {
          if (((String)localObject3).startsWith("wxfile")) {
            localObject2 = b.a().c((String)localObject3);
          } else {
            localObject2 = paramc.j((String)localObject3);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("dataPath: ");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.i("drawCanvas", 2, ((StringBuilder)localObject3).toString());
        }
        if (!StringUtil.a((String)localObject2))
        {
          localObject2 = c.q((String)localObject2);
          if (localObject2 != null)
          {
            localObject3 = new RectF();
            d1 = this.k;
            d2 = ((JSONArray)localObject4).optDouble(1);
            Double.isNaN(d1);
            ((RectF)localObject3).left = ((float)(d1 * d2 + 0.5D));
            d1 = this.k;
            d2 = ((JSONArray)localObject4).optDouble(2);
            Double.isNaN(d1);
            ((RectF)localObject3).top = ((float)(d1 * d2 + 0.5D));
            f1 = ((RectF)localObject3).left;
            d1 = this.k;
            d2 = ((JSONArray)localObject4).optDouble(3, ((Bitmap)localObject2).getWidth());
            Double.isNaN(d1);
            ((RectF)localObject3).right = (f1 + (float)(d1 * d2 + 0.5D));
            f1 = ((RectF)localObject3).top;
            d1 = this.k;
            d2 = ((JSONArray)localObject4).optDouble(4, ((Bitmap)localObject2).getHeight());
            Double.isNaN(d1);
            ((RectF)localObject3).bottom = (f1 + (float)(d1 * d2 + 0.5D));
            ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, null, (RectF)localObject3, null);
            localObject2 = localObject1;
            break label437;
          }
        }
        localObject2 = localObject1;
        label437:
        localObject1 = localObject2;
      }
      for (;;)
      {
        break label4203;
        float f2;
        float f3;
        if ((!"setStrokeStyle".equals(localObject3)) && (!"setFillStyle".equals(localObject3)))
        {
          if ((!"strokePath".equals(localObject3)) && (!"fillPath".equals(localObject3)))
          {
            if ("setFontSize".equals(localObject3))
            {
              localObject2 = this.g;
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(0);
              Double.isNaN(d1);
              ((Paint)localObject2).setTextSize((float)(d1 * d2 + 0.5D));
              localObject2 = localObject1;
              break;
            }
            if ("setTextAlign".equals(localObject3))
            {
              localObject2 = ((JSONArray)localObject4).optString(0);
              localObject3 = this.g;
              if ("left".equals(localObject2)) {
                localObject2 = Paint.Align.LEFT;
              } else if ("center".equals(localObject2)) {
                localObject2 = Paint.Align.CENTER;
              } else {
                localObject2 = Paint.Align.RIGHT;
              }
              ((Paint)localObject3).setTextAlign((Paint.Align)localObject2);
              localObject2 = localObject1;
              break;
            }
            if ("fillText".equals(localObject3))
            {
              localObject2 = ((JSONArray)localObject4).optString(0);
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(1);
              Double.isNaN(d1);
              f1 = (float)(d1 * d2 + 0.5D);
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(2);
              Double.isNaN(d1);
              ((Canvas)localObject1).drawText((String)localObject2, f1, (float)(d1 * d2 + 0.5D), this.g);
              localObject2 = localObject1;
              break;
            }
            if ("setGlobalAlpha".equals(localObject3))
            {
              this.j = ((JSONArray)localObject4).optInt(0);
              localObject2 = localObject1;
              break;
            }
            if ("restore".equals(localObject3))
            {
              localObject2 = this.d.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (Paint)((Iterator)localObject2).next();
                ((Paint)localObject3).reset();
                ((Paint)localObject3).setColor(-16777216);
              }
              paramCanvas.restore();
              localObject2 = localObject1;
              break;
            }
            if ("save".equals(localObject3))
            {
              paramCanvas.save();
              localObject2 = localObject1;
              break;
            }
            if ("strokeText".equals(localObject3))
            {
              this.g.setStyle(Paint.Style.STROKE);
              localObject2 = ((JSONArray)localObject4).optString(0);
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(1);
              Double.isNaN(d1);
              f1 = (float)(d1 * d2 + 0.5D);
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(2);
              Double.isNaN(d1);
              ((Canvas)localObject1).drawText((String)localObject2, f1, (float)(d1 * d2 + 0.5D), this.g);
              localObject2 = localObject1;
              break;
            }
            if ("clearRect".equals(localObject3))
            {
              paramCanvas.save();
              localObject2 = new RectF();
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(0);
              Double.isNaN(d1);
              ((RectF)localObject2).left = ((float)(d1 * d2 + 0.5D));
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(1);
              Double.isNaN(d1);
              ((RectF)localObject2).top = ((float)(d1 * d2 + 0.5D));
              f1 = ((RectF)localObject2).left;
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(2);
              Double.isNaN(d1);
              ((RectF)localObject2).right = (f1 + (float)(d1 * d2 + 0.5D));
              f1 = ((RectF)localObject2).top;
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(3);
              Double.isNaN(d1);
              ((RectF)localObject2).bottom = (f1 + (float)(d1 * d2 + 0.5D));
              ((Canvas)localObject1).clipRect((RectF)localObject2);
              ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
              paramCanvas.restore();
              localObject2 = localObject1;
              break;
            }
            if ("setGlobalCompositeOperation".equals(localObject3))
            {
              localObject3 = ((JSONArray)localObject4).optString(0);
              if ("xor".equals(localObject3))
              {
                this.h = PorterDuff.Mode.XOR;
                localObject2 = localObject1;
                break;
              }
              if ("source-atop".equals(localObject3))
              {
                this.h = PorterDuff.Mode.SRC_ATOP;
                localObject2 = localObject1;
                break;
              }
              if ("destination-out".equals(localObject3))
              {
                this.h = PorterDuff.Mode.DST_OUT;
                localObject2 = localObject1;
                break;
              }
              if ((!"lighter".equals(localObject3)) && (!"lighten".equals(localObject3)) && (!"hard-light".equals(localObject3)))
              {
                if ("overlay".equals(localObject3))
                {
                  this.h = PorterDuff.Mode.OVERLAY;
                  localObject2 = localObject1;
                  break;
                }
                localObject2 = localObject1;
                if (!"darken".equals(localObject3)) {
                  break;
                }
                this.h = PorterDuff.Mode.DARKEN;
                localObject2 = localObject1;
                break;
              }
              this.h = PorterDuff.Mode.LIGHTEN;
              localObject2 = localObject1;
              break;
            }
            if ("rotate".equals(localObject3))
            {
              ((Canvas)localObject1).rotate((float)(((JSONArray)localObject4).optDouble(0) * 180.0D / 3.141592653589793D));
              localObject2 = localObject1;
              break;
            }
            if ("scale".equals(localObject3))
            {
              ((Canvas)localObject1).scale((float)((JSONArray)localObject4).optDouble(0), (float)((JSONArray)localObject4).optDouble(1));
              localObject2 = localObject1;
              break;
            }
            if ("setLineWidth".equals(localObject3))
            {
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(0);
              Double.isNaN(d1);
              this.p = ((float)(d1 * d2 + 0.5D));
              localObject2 = localObject1;
              break;
            }
            if ("setShadow".equals(localObject3))
            {
              this.r = new CanvasView.a(this, null);
              localObject2 = ((JSONArray)localObject4).optJSONArray(3);
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(0);
              Double.isNaN(d1);
              f1 = (float)(d1 * d2 + 0.5D);
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(1);
              Double.isNaN(d1);
              f2 = (float)(d1 * d2 + 0.5D);
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(2);
              Double.isNaN(d1);
              f3 = (float)(d1 * d2 + 0.5D);
              localObject3 = this.r;
              ((CanvasView.a)localObject3).a = f1;
              ((CanvasView.a)localObject3).b = f2;
              ((CanvasView.a)localObject3).c = f3;
              ((CanvasView.a)localObject3).d = Color.argb(((JSONArray)localObject2).optInt(3), ((JSONArray)localObject2).optInt(2), ((JSONArray)localObject2).optInt(1), ((JSONArray)localObject2).optInt(0));
              break label4203;
            }
            if ("setLineCap".equals(localObject3))
            {
              localObject3 = ((JSONArray)localObject4).optString(0);
              if ("butt".equals(localObject3))
              {
                this.s = Paint.Cap.BUTT;
                localObject2 = localObject1;
                break;
              }
              if ("round".equals(localObject3))
              {
                this.s = Paint.Cap.ROUND;
                localObject2 = localObject1;
                break;
              }
              localObject2 = localObject1;
              if (!"square".equals(localObject3)) {
                break;
              }
              this.s = Paint.Cap.SQUARE;
              localObject2 = localObject1;
              break;
            }
            if ("setLineJoin".equals(localObject3))
            {
              localObject3 = ((JSONArray)localObject4).optString(0);
              if ("bevel".equals(localObject3))
              {
                this.t = Paint.Join.BEVEL;
                localObject2 = localObject1;
                break;
              }
              if ("round".equals(localObject3))
              {
                this.t = Paint.Join.ROUND;
                localObject2 = localObject1;
                break;
              }
              localObject2 = localObject1;
              if (!"miter".equals(localObject3)) {
                break;
              }
              this.t = Paint.Join.MITER;
              localObject2 = localObject1;
              break;
            }
            if ("setMiterLimit".equals(localObject3))
            {
              d1 = this.k;
              d2 = ((JSONArray)localObject4).optDouble(0);
              Double.isNaN(d1);
              this.u = ((float)(d1 * d2 + 0.5D));
              localObject2 = localObject1;
              break;
            }
            localObject2 = localObject1;
            if (!"translate".equals(localObject3)) {
              break;
            }
            d1 = this.k;
            d2 = ((JSONArray)localObject4).optDouble(0);
            Double.isNaN(d1);
            f1 = (float)(d1 * d2 + 0.5D);
            d1 = this.k;
            d2 = ((JSONArray)localObject4).optDouble(1);
            Double.isNaN(d1);
            ((Canvas)localObject1).translate(f1, (float)(d1 * d2 + 0.5D));
            localObject2 = localObject1;
            break;
          }
          this.i = new Path();
          if ("strokePath".equals(localObject3))
          {
            localObject2 = this.r;
            if (localObject2 != null)
            {
              this.f.setShadowLayer(((CanvasView.a)localObject2).a, this.r.b, this.r.c, this.r.d);
              this.r = null;
            }
            this.f.setStyle(Paint.Style.STROKE);
            localObject2 = this.f;
          }
          else
          {
            localObject2 = this.r;
            if (localObject2 != null)
            {
              this.e.setShadowLayer(((CanvasView.a)localObject2).a, this.r.b, this.r.c, this.r.d);
              this.r = null;
            }
            this.e.setStyle(Paint.Style.FILL);
            localObject2 = this.e;
          }
          localObject3 = this.h;
          if (localObject3 != null)
          {
            ((Paint)localObject2).setXfermode(new PorterDuffXfermode((PorterDuff.Mode)localObject3));
            this.h = null;
          }
          f1 = this.p;
          if (f1 != 0.0F)
          {
            ((Paint)localObject2).setStrokeWidth(f1);
            this.p = 0.0F;
          }
          int i2 = this.j;
          if (i2 != -1)
          {
            ((Paint)localObject2).setAlpha(i2);
            this.j = -1;
          }
          localObject3 = this.s;
          if (localObject3 != null)
          {
            ((Paint)localObject2).setStrokeCap((Paint.Cap)localObject3);
            this.s = null;
          }
          localObject3 = this.t;
          if (localObject3 != null)
          {
            ((Paint)localObject2).setStrokeJoin((Paint.Join)localObject3);
            this.t = null;
          }
          f1 = this.u;
          if (f1 != 0.0F)
          {
            ((Paint)localObject2).setStrokeMiter(f1);
            this.u = 0.0F;
          }
          i2 = 0;
          localObject3 = localObject2;
          for (;;)
          {
            localObject2 = localObject1;
            if (i2 >= ((JSONArray)localObject4).length()) {
              break;
            }
            localObject2 = ((JSONArray)localObject4).optJSONObject(i2);
            if (localObject2 != null)
            {
              String str = ((JSONObject)localObject2).optString("method");
              localObject5 = ((JSONObject)localObject2).optJSONArray("data");
              if ("rect".equals(str))
              {
                localObject2 = new RectF();
                d1 = this.k;
                d2 = ((JSONArray)localObject5).optDouble(0);
                Double.isNaN(d1);
                ((RectF)localObject2).left = ((float)(d1 * d2 + 0.5D));
                d1 = this.k;
                d2 = ((JSONArray)localObject5).optDouble(1);
                Double.isNaN(d1);
                ((RectF)localObject2).top = ((float)(d1 * d2 + 0.5D));
                f1 = ((RectF)localObject2).left;
                d1 = this.k;
                d2 = ((JSONArray)localObject5).optDouble(2);
                Double.isNaN(d1);
                ((RectF)localObject2).right = (f1 + (float)(d1 * d2 + 0.5D));
                f1 = ((RectF)localObject2).top;
                d1 = this.k;
                d2 = ((JSONArray)localObject5).optDouble(3);
                Double.isNaN(d1);
                ((RectF)localObject2).bottom = (f1 + (float)(d1 * d2 + 0.5D));
                ((Canvas)localObject1).drawRect((RectF)localObject2, (Paint)localObject3);
              }
              else if ("moveTo".equals(str))
              {
                localObject2 = this.i;
                d1 = this.k;
                d2 = ((JSONArray)localObject5).optDouble(0);
                Double.isNaN(d1);
                f1 = (float)(d1 * d2 + 0.5D);
                d1 = this.k;
                d2 = ((JSONArray)localObject5).optDouble(1);
                Double.isNaN(d1);
                ((Path)localObject2).moveTo(f1, (float)(d1 * d2 + 0.5D));
                ((Canvas)localObject1).drawPath(this.i, (Paint)localObject3);
              }
              else if ("lineTo".equals(str))
              {
                localObject2 = this.i;
                d1 = this.k;
                d2 = ((JSONArray)localObject5).optDouble(0);
                Double.isNaN(d1);
                f1 = (float)(d1 * d2 + 0.5D);
                d1 = this.k;
                d2 = ((JSONArray)localObject5).optDouble(1);
                Double.isNaN(d1);
                ((Path)localObject2).lineTo(f1, (float)(d1 * d2 + 0.5D));
                ((Canvas)localObject1).drawPath(this.i, (Paint)localObject3);
              }
              else if ("closePath".equals(str))
              {
                localObject2 = this.i;
                if (localObject2 != null) {
                  ((Path)localObject2).close();
                }
              }
              else
              {
                float f4;
                float f5;
                if ("arc".equals(str))
                {
                  d1 = this.k;
                  d2 = ((JSONArray)localObject5).optDouble(0);
                  Double.isNaN(d1);
                  f3 = (float)(d1 * d2 + 0.5D);
                  d1 = this.k;
                  d2 = ((JSONArray)localObject5).optDouble(1);
                  Double.isNaN(d1);
                  f4 = (float)(d1 * d2 + 0.5D);
                  d1 = this.k;
                  d2 = ((JSONArray)localObject5).optDouble(2);
                  Double.isNaN(d1);
                  f5 = (float)(d1 * d2 + 0.5D);
                  float f6 = (float)((JSONArray)localObject5).optDouble(3);
                  d1 = (float)((JSONArray)localObject5).optDouble(4);
                  Double.isNaN(d1);
                  f2 = (float)(d1 / 3.141592653589793D * 180.0D);
                  f1 = f2;
                  if (((JSONArray)localObject4).optBoolean(5)) {
                    f1 = -f2;
                  }
                  paramCanvas.drawArc(new RectF(f3 - f5, f4 - f5, f3 + f5, f4 + f5), f6, f1, false, (Paint)localObject3);
                  localObject1 = paramCanvas;
                }
                else if ("quadraticCurveTo".equals(str))
                {
                  localObject1 = this.i;
                  d1 = this.k;
                  d2 = ((JSONArray)localObject5).optDouble(0);
                  Double.isNaN(d1);
                  f1 = (float)(d1 * d2 + 0.5D);
                  d1 = this.k;
                  d2 = ((JSONArray)localObject5).optDouble(1);
                  Double.isNaN(d1);
                  f2 = (float)(d1 * d2 + 0.5D);
                  d1 = this.k;
                  d2 = ((JSONArray)localObject5).optDouble(2);
                  Double.isNaN(d1);
                  f3 = (float)(d1 * d2 + 0.5D);
                  d1 = this.k;
                  d2 = ((JSONArray)localObject5).optDouble(3);
                  Double.isNaN(d1);
                  ((Path)localObject1).quadTo(f1, f2, f3, (float)(d1 * d2 + 0.5D));
                  localObject2 = this.i;
                  localObject1 = paramCanvas;
                  ((Canvas)localObject1).drawPath((Path)localObject2, (Paint)localObject3);
                }
                else
                {
                  localObject2 = paramCanvas;
                  if ("bezierCurveTo".equals(str))
                  {
                    localObject1 = this.i;
                    d1 = this.k;
                    d2 = ((JSONArray)localObject5).optDouble(0);
                    Double.isNaN(d1);
                    f1 = (float)(d1 * d2 + 0.5D);
                    d1 = this.k;
                    d2 = ((JSONArray)localObject5).optDouble(1);
                    Double.isNaN(d1);
                    f2 = (float)(d1 * d2 + 0.5D);
                    d1 = this.k;
                    d2 = ((JSONArray)localObject5).optDouble(2);
                    Double.isNaN(d1);
                    f3 = (float)(d1 * d2 + 0.5D);
                    d1 = this.k;
                    d2 = ((JSONArray)localObject5).optDouble(3);
                    Double.isNaN(d1);
                    f4 = (float)(d1 * d2 + 0.5D);
                    d1 = this.k;
                    d2 = ((JSONArray)localObject5).optDouble(4);
                    Double.isNaN(d1);
                    f5 = (float)(d1 * d2 + 0.5D);
                    d1 = this.k;
                    d2 = ((JSONArray)localObject5).optDouble(5);
                    Double.isNaN(d1);
                    ((Path)localObject1).cubicTo(f1, f2, f3, f4, f5, (float)(d1 * d2 + 0.5D));
                    ((Canvas)localObject2).drawPath(this.i, (Paint)localObject3);
                    localObject1 = localObject2;
                  }
                  else
                  {
                    localObject1 = localObject2;
                    if ("translate".equals(str))
                    {
                      d1 = this.k;
                      d2 = ((JSONArray)localObject5).optDouble(0);
                      Double.isNaN(d1);
                      f1 = (float)(d1 * d2 + 0.5D);
                      d1 = this.k;
                      d2 = ((JSONArray)localObject5).optDouble(1);
                      Double.isNaN(d1);
                      ((Canvas)localObject2).translate(f1, (float)(d1 * d2 + 0.5D));
                      localObject1 = localObject2;
                    }
                  }
                }
              }
            }
            i2 += 1;
          }
        }
        localObject2 = localObject1;
        Object localObject5 = ((JSONArray)localObject4).optString(0);
        if ("normal".equals(localObject5))
        {
          localObject4 = a(((JSONArray)localObject4).optJSONArray(1), 0);
          if ("setStrokeStyle".equals(localObject3))
          {
            this.f.setColor(Color.parseColor((String)localObject4));
            localObject1 = localObject2;
          }
          else
          {
            localObject1 = localObject2;
            if ("setFillStyle".equals(localObject3))
            {
              this.e.setColor(Color.parseColor((String)localObject4));
              localObject1 = localObject2;
            }
          }
        }
        else if ("radial".equals(localObject5))
        {
          localObject1 = ((JSONArray)localObject4).optJSONArray(1);
          localObject5 = ((JSONArray)localObject4).optJSONArray(2);
          localObject4 = a(((JSONArray)localObject5).optJSONArray(0).optJSONArray(1), 0);
          localObject5 = a(((JSONArray)localObject5).optJSONArray(1).optJSONArray(1), 0);
          d1 = this.k;
          d2 = ((JSONArray)localObject1).optDouble(0);
          Double.isNaN(d1);
          f1 = (float)(d1 * d2 + 0.5D);
          d1 = this.k;
          d2 = ((JSONArray)localObject1).optDouble(1);
          Double.isNaN(d1);
          f2 = (float)(d1 * d2 + 0.5D);
          d1 = this.k;
          d2 = ((JSONArray)localObject1).optDouble(2);
          Double.isNaN(d1);
          localObject4 = new RadialGradient(f1, f2, (float)(d1 * d2 + 0.5D), Color.parseColor((String)localObject4), Color.parseColor((String)localObject5), Shader.TileMode.CLAMP);
          if ("setStrokeStyle".equals(localObject3))
          {
            this.f.setShader((Shader)localObject4);
            localObject1 = localObject2;
          }
          else
          {
            localObject1 = localObject2;
            if ("setFillStyle".equals(localObject3))
            {
              this.e.setShader((Shader)localObject4);
              localObject1 = localObject2;
            }
          }
        }
        else
        {
          localObject1 = localObject2;
          if ("linear".equals(localObject5))
          {
            localObject1 = ((JSONArray)localObject4).optJSONArray(1);
            localObject5 = ((JSONArray)localObject4).optJSONArray(2);
            localObject4 = a(((JSONArray)localObject5).optJSONArray(0).optJSONArray(1), 0);
            localObject5 = a(((JSONArray)localObject5).optJSONArray(1).optJSONArray(1), 0);
            d1 = this.k;
            d2 = ((JSONArray)localObject1).optDouble(0);
            Double.isNaN(d1);
            f1 = (float)(d1 * d2 + 0.5D);
            d1 = this.k;
            d2 = ((JSONArray)localObject1).optDouble(1);
            Double.isNaN(d1);
            f2 = (float)(d1 * d2 + 0.5D);
            d1 = this.k;
            d2 = ((JSONArray)localObject1).optDouble(2);
            Double.isNaN(d1);
            f3 = (float)(d1 * d2 + 0.5D);
            d1 = this.k;
            d2 = ((JSONArray)localObject1).optDouble(3);
            Double.isNaN(d1);
            localObject4 = new LinearGradient(f1, f2, f3, (float)(d1 * d2 + 0.5D), Color.parseColor((String)localObject4), Color.parseColor((String)localObject5), Shader.TileMode.CLAMP);
            if ("setStrokeStyle".equals(localObject3))
            {
              this.f.setShader((Shader)localObject4);
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = localObject2;
              if ("setFillStyle".equals(localObject3))
              {
                this.e.setShader((Shader)localObject4);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      label4203:
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return;
      }
      if (paramCanvas != null)
      {
        if (paramBoolean1) {}
        try
        {
          paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          this.o = new JSONArray();
          this.o = c.a(this.o, paramJSONArray);
          a(paramCanvas, paramJSONArray, this.n);
          return;
        }
        catch (Throwable paramCanvas)
        {
          paramCanvas.printStackTrace();
        }
      }
    }
  }
  
  public float a(JSONObject paramJSONObject)
  {
    if (this.g == null) {
      return -1.0F;
    }
    Object localObject = paramJSONObject.optString("fontFamily");
    if ("normal".equals(paramJSONObject.optString("fontStyle")))
    {
      localObject = Typeface.create((String)localObject, 0);
      this.g.setTypeface((Typeface)localObject);
    }
    localObject = paramJSONObject.optString("text");
    this.g.setTextSize(paramJSONObject.optInt("fontSize"));
    return this.g.measureText((String)localObject);
  }
  
  public void a(WebviewContainer paramWebviewContainer, Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new a(this, paramJSONObject, paramWebviewContainer, paramString, paramInt));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (QLog.isColorLevel()) {
      QLog.w(c, 2, "---onDraw---");
    }
    a(paramCanvas, this.a, true, this.b);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0) {
      if (i1 != 1) {
        if (i1 != 2) {
          if (i1 != 3) {
            if (i1 != 5) {
              if (i1 == 6) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      return true;
      for (;;)
      {
        break label1239;
        if (QLog.isColorLevel()) {
          QLog.e(c, 2, "--ACTION_POINTER_DOWN--");
        }
        this.v += 1;
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("x", paramMotionEvent.getX(1) / this.k);
          ((JSONObject)localObject1).put("y", paramMotionEvent.getY(1) / this.k);
          ((JSONObject)localObject1).put("id", 1);
          this.l = new JSONObject();
          this.l.put("data", this.q);
          this.l.put("touch", localObject1);
        }
        catch (JSONException paramMotionEvent)
        {
          paramMotionEvent.printStackTrace();
        }
        paramMotionEvent = this.m.appBrandRuntime.i;
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WeixinJSBridge.subscribeHandler(\"onTouchStart\", ");
        ((StringBuilder)localObject1).append(this.l);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(this.m.getPageWebview().pageWebviewId);
        ((StringBuilder)localObject1).append(")");
        paramMotionEvent.evaluteJs(((StringBuilder)localObject1).toString());
        break;
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "--ACTION_CANCEL--");
        }
        localObject1 = new JSONArray();
        this.v = 1;
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("x", paramMotionEvent.getX() / this.k);
          ((JSONObject)localObject3).put("y", paramMotionEvent.getY() / this.k);
          ((JSONObject)localObject3).put("id", 0);
          ((JSONArray)localObject1).put(localObject3);
          this.l = new JSONObject();
          this.l.put("data", this.q);
          this.l.put("touches", localObject1);
        }
        catch (JSONException paramMotionEvent)
        {
          paramMotionEvent.printStackTrace();
        }
        paramMotionEvent = this.m.appBrandRuntime.i;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WeixinJSBridge.subscribeHandler(\"onTouchCancel\", ");
        ((StringBuilder)localObject1).append(this.l);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(this.m.getPageWebview().pageWebviewId);
        ((StringBuilder)localObject1).append(")");
        paramMotionEvent.evaluteJs(((StringBuilder)localObject1).toString());
        break;
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "--ACTION_MOVE--");
        }
        if (QLog.isColorLevel())
        {
          localObject1 = c;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("action move mMode: ");
          ((StringBuilder)localObject3).append(this.v);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        }
        if (this.v < 2)
        {
          try
          {
            localObject1 = new JSONArray();
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("x", paramMotionEvent.getX() / this.k);
            ((JSONObject)localObject3).put("y", paramMotionEvent.getY() / this.k);
            ((JSONObject)localObject3).put("id", 0);
            ((JSONArray)localObject1).put(localObject3);
            this.l = new JSONObject();
            this.l.put("data", this.q);
            this.l.put("touches", localObject1);
          }
          catch (JSONException paramMotionEvent)
          {
            paramMotionEvent.printStackTrace();
          }
          if (QLog.isColorLevel()) {
            QLog.i(c, 2, "--单指滑动--");
          }
        }
        else
        {
          try
          {
            localObject1 = new JSONArray();
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("x", paramMotionEvent.getX(0) / this.k);
            ((JSONObject)localObject3).put("y", paramMotionEvent.getY(0) / this.k);
            ((JSONObject)localObject3).put("id", 0);
            ((JSONArray)localObject1).put(localObject3);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("x", paramMotionEvent.getX(1) / this.k);
            ((JSONObject)localObject3).put("y", paramMotionEvent.getY(1) / this.k);
            ((JSONObject)localObject3).put("id", 1);
            ((JSONArray)localObject1).put(localObject3);
            this.l = new JSONObject();
            this.l.put("data", this.q);
            this.l.put("touches", localObject1);
            if (QLog.isColorLevel())
            {
              paramMotionEvent = c;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("--双指缩放--");
              ((StringBuilder)localObject1).append(this.l);
              QLog.i(paramMotionEvent, 2, ((StringBuilder)localObject1).toString());
            }
            if (QLog.isColorLevel()) {
              QLog.d(c, 2, new Object[] { this.l });
            }
          }
          catch (JSONException paramMotionEvent)
          {
            paramMotionEvent.printStackTrace();
          }
        }
        paramMotionEvent = this.m.appBrandRuntime.i;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WeixinJSBridge.subscribeHandler(\"onTouchMove\", ");
        ((StringBuilder)localObject1).append(this.l);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(this.m.getPageWebview().pageWebviewId);
        ((StringBuilder)localObject1).append(")");
        paramMotionEvent.evaluteJs(((StringBuilder)localObject1).toString());
        break;
        if (QLog.isColorLevel())
        {
          localObject1 = c;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("--ACTION_UP--");
          ((StringBuilder)localObject3).append(this.v);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        }
        this.v = 1;
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("x", paramMotionEvent.getX() / this.k);
          ((JSONObject)localObject1).put("y", paramMotionEvent.getY() / this.k);
          ((JSONObject)localObject1).put("id", 0);
          this.l = new JSONObject();
          this.l.put("data", this.q);
          this.l.put("touch", localObject1);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        localObject2 = this.m.appBrandRuntime.i;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("WeixinJSBridge.subscribeHandler(\"onTouchEnd\", ");
        ((StringBuilder)localObject3).append(this.l);
        ((StringBuilder)localObject3).append(",");
        ((StringBuilder)localObject3).append(this.m.getPageWebview().pageWebviewId);
        ((StringBuilder)localObject3).append(")");
        ((ServiceWebview)localObject2).evaluteJs(((StringBuilder)localObject3).toString());
      }
      label1239:
      this.v = 1;
      try
      {
        i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("x", paramMotionEvent.getX(i1) / this.k);
        ((JSONObject)localObject2).put("y", paramMotionEvent.getY(i1) / this.k);
        ((JSONObject)localObject2).put("id", 1);
        this.l = new JSONObject();
        this.l.put("data", this.q);
        this.l.put("touch", localObject2);
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      paramMotionEvent = this.m.appBrandRuntime.i;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("WeixinJSBridge.subscribeHandler(\"onTouchEnd\", ");
      ((StringBuilder)localObject2).append(this.l);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(this.m.getPageWebview().pageWebviewId);
      ((StringBuilder)localObject2).append(")");
      paramMotionEvent.evaluteJs(((StringBuilder)localObject2).toString());
      continue;
      if (QLog.isColorLevel()) {
        QLog.e(c, 2, "--ACTION_DOWN--");
      }
      this.v = 1;
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("x", paramMotionEvent.getX() / this.k);
        ((JSONObject)localObject2).put("y", paramMotionEvent.getY() / this.k);
        ((JSONObject)localObject2).put("id", 0);
        this.l = new JSONObject();
        this.l.put("data", this.q);
        this.l.put("touch", localObject2);
      }
      catch (JSONException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      paramMotionEvent = this.m.appBrandRuntime.i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("WeixinJSBridge.subscribeHandler(\"onTouchStart\", ");
      ((StringBuilder)localObject2).append(this.l);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(this.m.getPageWebview().pageWebviewId);
      ((StringBuilder)localObject2).append(")");
      paramMotionEvent.evaluteJs(((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */