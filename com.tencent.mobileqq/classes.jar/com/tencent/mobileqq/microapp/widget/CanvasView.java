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
import bbkk;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasView
  extends View
{
  private static final String c = CanvasView.class.getSimpleName();
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
  private f n;
  private JSONArray o;
  private float p;
  private String q;
  private CanvasView.a r;
  private Paint.Cap s;
  private Paint.Join t;
  private float u;
  private int v;
  
  public CanvasView(Context paramContext, WebviewContainer paramWebviewContainer, f paramf, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.k = DisplayUtil.getDensity(paramContext);
    this.m = paramWebviewContainer;
    this.n = paramf;
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
  
  private void a(Canvas paramCanvas, JSONArray paramJSONArray, f paramf)
  {
    if (paramJSONArray == null) {
      return;
    }
    int i1 = 0;
    label8:
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (i1 < paramJSONArray.length())
    {
      localObject2 = paramJSONArray.getJSONObject(i1);
      localObject1 = ((JSONObject)localObject2).optString("method");
      localObject3 = ((JSONObject)localObject2).optJSONArray("data");
      if (QLog.isColorLevel()) {
        QLog.d("drawCanvas", 2, "method: " + (String)localObject1 + "---" + localObject3);
      }
      if (!"drawImage".equals(localObject1)) {
        break label338;
      }
      localObject2 = ((JSONArray)localObject3).optString(0);
      localObject1 = localObject2;
      if (!bbkk.a((String)localObject2))
      {
        if (!((String)localObject2).startsWith("wxfile")) {
          break label327;
        }
        localObject1 = b.a().d((String)localObject2);
      }
      label135:
      if (QLog.isColorLevel()) {
        QLog.i("drawCanvas", 2, "dataPath: " + (String)localObject1);
      }
      if (!bbkk.a((String)localObject1))
      {
        localObject1 = com.tencent.mobileqq.microapp.b.a.i((String)localObject1);
        if (localObject1 != null)
        {
          localObject2 = new RectF();
          ((RectF)localObject2).left = ((float)(this.k * ((JSONArray)localObject3).optDouble(1) + 0.5D));
          ((RectF)localObject2).top = ((float)(this.k * ((JSONArray)localObject3).optDouble(2) + 0.5D));
          ((RectF)localObject2).right = (((RectF)localObject2).left + (float)(this.k * ((JSONArray)localObject3).optDouble(3, ((Bitmap)localObject1).getWidth()) + 0.5D));
          ((RectF)localObject2).bottom = (((RectF)localObject2).top + (float)(this.k * ((JSONArray)localObject3).optDouble(4, ((Bitmap)localObject1).getHeight()) + 0.5D));
          paramCanvas.drawBitmap((Bitmap)localObject1, null, (RectF)localObject2, null);
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label8;
      break;
      label327:
      localObject1 = paramf.j((String)localObject2);
      break label135;
      label338:
      Object localObject4;
      if (("setStrokeStyle".equals(localObject1)) || ("setFillStyle".equals(localObject1)))
      {
        localObject2 = ((JSONArray)localObject3).optString(0);
        if ("normal".equals(localObject2))
        {
          localObject2 = a(((JSONArray)localObject3).optJSONArray(1), 0);
          if ("setStrokeStyle".equals(localObject1)) {
            this.f.setColor(Color.parseColor((String)localObject2));
          } else if ("setFillStyle".equals(localObject1)) {
            this.e.setColor(Color.parseColor((String)localObject2));
          }
        }
        else if ("radial".equals(localObject2))
        {
          localObject2 = ((JSONArray)localObject3).optJSONArray(1);
          localObject4 = ((JSONArray)localObject3).optJSONArray(2);
          localObject3 = a(((JSONArray)localObject4).optJSONArray(0).optJSONArray(1), 0);
          localObject4 = a(((JSONArray)localObject4).optJSONArray(1).optJSONArray(1), 0);
          localObject2 = new RadialGradient((float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(2) + 0.5D), Color.parseColor((String)localObject3), Color.parseColor((String)localObject4), Shader.TileMode.CLAMP);
          if ("setStrokeStyle".equals(localObject1)) {
            this.f.setShader((Shader)localObject2);
          } else if ("setFillStyle".equals(localObject1)) {
            this.e.setShader((Shader)localObject2);
          }
        }
        else if ("linear".equals(localObject2))
        {
          localObject2 = ((JSONArray)localObject3).optJSONArray(1);
          localObject4 = ((JSONArray)localObject3).optJSONArray(2);
          localObject3 = a(((JSONArray)localObject4).optJSONArray(0).optJSONArray(1), 0);
          localObject4 = a(((JSONArray)localObject4).optJSONArray(1).optJSONArray(1), 0);
          localObject2 = new LinearGradient((float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(2) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(3) + 0.5D), Color.parseColor((String)localObject3), Color.parseColor((String)localObject4), Shader.TileMode.CLAMP);
          if ("setStrokeStyle".equals(localObject1)) {
            this.f.setShader((Shader)localObject2);
          } else if ("setFillStyle".equals(localObject1)) {
            this.e.setShader((Shader)localObject2);
          }
        }
      }
      else
      {
        label932:
        label1074:
        float f1;
        label1323:
        float f3;
        float f2;
        if (("strokePath".equals(localObject1)) || ("fillPath".equals(localObject1)))
        {
          this.i = new Path();
          int i2;
          if ("strokePath".equals(localObject1))
          {
            if (this.r != null)
            {
              this.f.setShadowLayer(this.r.a, this.r.b, this.r.c, this.r.d);
              this.r = null;
            }
            this.f.setStyle(Paint.Style.STROKE);
            localObject1 = this.f;
            if (this.h != null)
            {
              ((Paint)localObject1).setXfermode(new PorterDuffXfermode(this.h));
              this.h = null;
            }
            if (this.p != 0.0F)
            {
              ((Paint)localObject1).setStrokeWidth(this.p);
              this.p = 0.0F;
            }
            if (this.j != -1)
            {
              ((Paint)localObject1).setAlpha(this.j);
              this.j = -1;
            }
            if (this.s != null)
            {
              ((Paint)localObject1).setStrokeCap(this.s);
              this.s = null;
            }
            if (this.t != null)
            {
              ((Paint)localObject1).setStrokeJoin(this.t);
              this.t = null;
            }
            if (this.u != 0.0F)
            {
              ((Paint)localObject1).setStrokeMiter(this.u);
              this.u = 0.0F;
            }
            i2 = 0;
            if (i2 < ((JSONArray)localObject3).length())
            {
              localObject2 = ((JSONArray)localObject3).optJSONObject(i2);
              if (localObject2 != null)
              {
                localObject4 = ((JSONObject)localObject2).optString("method");
                localObject2 = ((JSONObject)localObject2).optJSONArray("data");
                if (!"rect".equals(localObject4)) {
                  break label1323;
                }
                localObject4 = new RectF();
                ((RectF)localObject4).left = ((float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D));
                ((RectF)localObject4).top = ((float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D));
                ((RectF)localObject4).right = (((RectF)localObject4).left + (float)(this.k * ((JSONArray)localObject2).optDouble(2) + 0.5D));
                f1 = ((RectF)localObject4).top;
                ((RectF)localObject4).bottom = ((float)(this.k * ((JSONArray)localObject2).optDouble(3) + 0.5D) + f1);
                paramCanvas.drawRect((RectF)localObject4, (Paint)localObject1);
              }
            }
          }
          for (;;)
          {
            i2 += 1;
            break label1074;
            break;
            if (this.r != null)
            {
              this.e.setShadowLayer(this.r.a, this.r.b, this.r.c, this.r.d);
              this.r = null;
            }
            this.e.setStyle(Paint.Style.FILL);
            localObject1 = this.e;
            break label932;
            if ("moveTo".equals(localObject4))
            {
              this.i.moveTo((float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D));
              paramCanvas.drawPath(this.i, (Paint)localObject1);
            }
            else if ("lineTo".equals(localObject4))
            {
              this.i.lineTo((float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D));
              paramCanvas.drawPath(this.i, (Paint)localObject1);
            }
            else if ("closePath".equals(localObject4))
            {
              if (this.i != null) {
                this.i.close();
              }
            }
            else
            {
              float f4;
              float f5;
              if ("arc".equals(localObject4))
              {
                f3 = (float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D);
                f4 = (float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D);
                f5 = (float)(this.k * ((JSONArray)localObject2).optDouble(2) + 0.5D);
                float f6 = (float)((JSONArray)localObject2).optDouble(3);
                f2 = (float)((float)((JSONArray)localObject2).optDouble(4) / 3.141592653589793D * 180.0D);
                f1 = f2;
                if (((JSONArray)localObject3).optBoolean(5)) {
                  f1 = -f2;
                }
                paramCanvas.drawArc(new RectF(f3 - f5, f4 - f5, f3 + f5, f4 + f5), f6, f1, false, (Paint)localObject1);
              }
              else if ("quadraticCurveTo".equals(localObject4))
              {
                this.i.quadTo((float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(2) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(3) + 0.5D));
                paramCanvas.drawPath(this.i, (Paint)localObject1);
              }
              else if ("bezierCurveTo".equals(localObject4))
              {
                localObject4 = this.i;
                f1 = (float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D);
                f2 = (float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D);
                f3 = (float)(this.k * ((JSONArray)localObject2).optDouble(2) + 0.5D);
                f4 = (float)(this.k * ((JSONArray)localObject2).optDouble(3) + 0.5D);
                f5 = (float)(this.k * ((JSONArray)localObject2).optDouble(4) + 0.5D);
                double d1 = this.k;
                ((Path)localObject4).cubicTo(f1, f2, f3, f4, f5, (float)(((JSONArray)localObject2).optDouble(5) * d1 + 0.5D));
                paramCanvas.drawPath(this.i, (Paint)localObject1);
              }
              else if ("translate".equals(localObject4))
              {
                paramCanvas.translate((float)(this.k * ((JSONArray)localObject2).optDouble(0) + 0.5D), (float)(this.k * ((JSONArray)localObject2).optDouble(1) + 0.5D));
              }
            }
          }
        }
        if ("setFontSize".equals(localObject1))
        {
          this.g.setTextSize((float)(this.k * ((JSONArray)localObject3).optDouble(0) + 0.5D));
        }
        else
        {
          if ("setTextAlign".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject3).optString(0);
            localObject2 = this.g;
            if ("left".equals(localObject1)) {
              localObject1 = Paint.Align.LEFT;
            }
            for (;;)
            {
              ((Paint)localObject2).setTextAlign((Paint.Align)localObject1);
              break;
              if ("center".equals(localObject1)) {
                localObject1 = Paint.Align.CENTER;
              } else {
                localObject1 = Paint.Align.RIGHT;
              }
            }
          }
          if ("fillText".equals(localObject1))
          {
            paramCanvas.drawText(((JSONArray)localObject3).optString(0), (float)(this.k * ((JSONArray)localObject3).optDouble(1) + 0.5D), (float)(this.k * ((JSONArray)localObject3).optDouble(2) + 0.5D), this.g);
          }
          else if ("setGlobalAlpha".equals(localObject1))
          {
            this.j = ((JSONArray)localObject3).optInt(0);
          }
          else if ("restore".equals(localObject1))
          {
            localObject1 = this.d.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Paint)((Iterator)localObject1).next();
              ((Paint)localObject2).reset();
              ((Paint)localObject2).setColor(-16777216);
            }
            paramCanvas.restore();
          }
          else if ("save".equals(localObject1))
          {
            paramCanvas.save();
          }
          else if ("strokeText".equals(localObject1))
          {
            this.g.setStyle(Paint.Style.STROKE);
            paramCanvas.drawText(((JSONArray)localObject3).optString(0), (float)(this.k * ((JSONArray)localObject3).optDouble(1) + 0.5D), (float)(this.k * ((JSONArray)localObject3).optDouble(2) + 0.5D), this.g);
          }
          else if ("clearRect".equals(localObject1))
          {
            paramCanvas.save();
            localObject1 = new RectF();
            ((RectF)localObject1).left = ((float)(this.k * ((JSONArray)localObject3).optDouble(0) + 0.5D));
            ((RectF)localObject1).top = ((float)(this.k * ((JSONArray)localObject3).optDouble(1) + 0.5D));
            ((RectF)localObject1).right = (((RectF)localObject1).left + (float)(this.k * ((JSONArray)localObject3).optDouble(2) + 0.5D));
            ((RectF)localObject1).bottom = (((RectF)localObject1).top + (float)(this.k * ((JSONArray)localObject3).optDouble(3) + 0.5D));
            paramCanvas.clipRect((RectF)localObject1);
            paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            paramCanvas.restore();
          }
          else if ("setGlobalCompositeOperation".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject3).optString(0);
            if ("xor".equals(localObject1)) {
              this.h = PorterDuff.Mode.XOR;
            } else if ("source-atop".equals(localObject1)) {
              this.h = PorterDuff.Mode.SRC_ATOP;
            } else if ("destination-out".equals(localObject1)) {
              this.h = PorterDuff.Mode.DST_OUT;
            } else if (("lighter".equals(localObject1)) || ("lighten".equals(localObject1)) || ("hard-light".equals(localObject1))) {
              this.h = PorterDuff.Mode.LIGHTEN;
            } else if ("overlay".equals(localObject1)) {
              this.h = PorterDuff.Mode.OVERLAY;
            } else if ("darken".equals(localObject1)) {
              this.h = PorterDuff.Mode.DARKEN;
            }
          }
          else if ("rotate".equals(localObject1))
          {
            paramCanvas.rotate((float)(((JSONArray)localObject3).optDouble(0) * 180.0D / 3.141592653589793D));
          }
          else if ("scale".equals(localObject1))
          {
            paramCanvas.scale((float)((JSONArray)localObject3).optDouble(0), (float)((JSONArray)localObject3).optDouble(1));
          }
          else if ("setLineWidth".equals(localObject1))
          {
            this.p = ((float)(this.k * ((JSONArray)localObject3).optDouble(0) + 0.5D));
          }
          else if ("setShadow".equals(localObject1))
          {
            this.r = new CanvasView.a(this, null);
            localObject1 = ((JSONArray)localObject3).optJSONArray(3);
            f1 = (float)(this.k * ((JSONArray)localObject3).optDouble(0) + 0.5D);
            f2 = (float)(this.k * ((JSONArray)localObject3).optDouble(1) + 0.5D);
            f3 = (float)(this.k * ((JSONArray)localObject3).optDouble(2) + 0.5D);
            this.r.a = f1;
            this.r.b = f2;
            this.r.c = f3;
            this.r.d = Color.argb(((JSONArray)localObject1).optInt(3), ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0));
          }
          else if ("setLineCap".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject3).optString(0);
            if ("butt".equals(localObject1)) {
              this.s = Paint.Cap.BUTT;
            } else if ("round".equals(localObject1)) {
              this.s = Paint.Cap.ROUND;
            } else if ("square".equals(localObject1)) {
              this.s = Paint.Cap.SQUARE;
            }
          }
          else if ("setLineJoin".equals(localObject1))
          {
            localObject1 = ((JSONArray)localObject3).optString(0);
            if ("bevel".equals(localObject1)) {
              this.t = Paint.Join.BEVEL;
            } else if ("round".equals(localObject1)) {
              this.t = Paint.Join.ROUND;
            } else if ("miter".equals(localObject1)) {
              this.t = Paint.Join.MITER;
            }
          }
          else if ("setMiterLimit".equals(localObject1))
          {
            this.u = ((float)(this.k * ((JSONArray)localObject3).optDouble(0) + 0.5D));
          }
          else if ("translate".equals(localObject1))
          {
            paramCanvas.translate((float)(this.k * ((JSONArray)localObject3).optDouble(0) + 0.5D), (float)(this.k * ((JSONArray)localObject3).optDouble(1) + 0.5D));
          }
        }
      }
    }
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2, JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {}
    while (paramCanvas == null) {
      return;
    }
    if (paramBoolean1) {}
    try
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      this.o = new JSONArray();
      this.o = com.tencent.mobileqq.microapp.b.a.a(this.o, paramJSONArray);
      a(paramCanvas, paramJSONArray, this.n);
      return;
    }
    catch (Throwable paramCanvas)
    {
      paramCanvas.printStackTrace();
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
    Object localObject;
    JSONObject localJSONObject;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    default: 
      return true;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.e(c, 2, "--ACTION_DOWN--");
      }
      this.v = 1;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("x", paramMotionEvent.getX() / this.k);
        ((JSONObject)localObject).put("y", paramMotionEvent.getY() / this.k);
        ((JSONObject)localObject).put("id", 0);
        this.l = new JSONObject();
        this.l.put("data", this.q);
        this.l.put("touch", localObject);
        this.m.appBrandRuntime.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchStart\", " + this.l + "," + this.m.getPageWebview().pageWebviewId + ")");
        return true;
      }
      catch (JSONException paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
        }
      }
    case 5: 
      if (QLog.isColorLevel()) {
        QLog.e(c, 2, "--ACTION_POINTER_DOWN--");
      }
      this.v += 1;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("x", paramMotionEvent.getX(1) / this.k);
        ((JSONObject)localObject).put("y", paramMotionEvent.getY(1) / this.k);
        ((JSONObject)localObject).put("id", 1);
        this.l = new JSONObject();
        this.l.put("data", this.q);
        this.l.put("touch", localObject);
        this.m.appBrandRuntime.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchStart\", " + this.l + "," + this.m.getPageWebview().pageWebviewId + ")");
        return true;
      }
      catch (JSONException paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
        }
      }
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "--ACTION_MOVE--");
      }
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "action move mMode: " + this.v);
      }
      if (this.v < 2) {}
      for (;;)
      {
        try
        {
          localObject = new JSONArray();
          localJSONObject = new JSONObject();
          localJSONObject.put("x", paramMotionEvent.getX() / this.k);
          localJSONObject.put("y", paramMotionEvent.getY() / this.k);
          localJSONObject.put("id", 0);
          ((JSONArray)localObject).put(localJSONObject);
          this.l = new JSONObject();
          this.l.put("data", this.q);
          this.l.put("touches", localObject);
          if (QLog.isColorLevel()) {
            QLog.i(c, 2, "--单指滑动--");
          }
          this.m.appBrandRuntime.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchMove\", " + this.l + "," + this.m.getPageWebview().pageWebviewId + ")");
          return true;
        }
        catch (JSONException paramMotionEvent)
        {
          paramMotionEvent.printStackTrace();
          continue;
        }
        try
        {
          localObject = new JSONArray();
          localJSONObject = new JSONObject();
          localJSONObject.put("x", paramMotionEvent.getX(0) / this.k);
          localJSONObject.put("y", paramMotionEvent.getY(0) / this.k);
          localJSONObject.put("id", 0);
          ((JSONArray)localObject).put(localJSONObject);
          localJSONObject = new JSONObject();
          localJSONObject.put("x", paramMotionEvent.getX(1) / this.k);
          localJSONObject.put("y", paramMotionEvent.getY(1) / this.k);
          localJSONObject.put("id", 1);
          ((JSONArray)localObject).put(localJSONObject);
          this.l = new JSONObject();
          this.l.put("data", this.q);
          this.l.put("touches", localObject);
          if (QLog.isColorLevel()) {
            QLog.i(c, 2, "--双指缩放--" + this.l);
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
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "--ACTION_UP--" + this.v);
      }
      this.v = 1;
    }
    JSONArray localJSONArray;
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("x", paramMotionEvent.getX() / this.k);
      ((JSONObject)localObject).put("y", paramMotionEvent.getY() / this.k);
      ((JSONObject)localObject).put("id", 0);
      this.l = new JSONObject();
      this.l.put("data", this.q);
      this.l.put("touch", localObject);
      this.m.appBrandRuntime.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchEnd\", " + this.l + "," + this.m.getPageWebview().pageWebviewId + ")");
      this.v = 1;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        localObject = new JSONObject();
        ((JSONObject)localObject).put("x", paramMotionEvent.getX(i1) / this.k);
        ((JSONObject)localObject).put("y", paramMotionEvent.getY(i1) / this.k);
        ((JSONObject)localObject).put("id", 1);
        this.l = new JSONObject();
        this.l.put("data", this.q);
        this.l.put("touch", localObject);
        this.m.appBrandRuntime.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchEnd\", " + this.l + "," + this.m.getPageWebview().pageWebviewId + ")");
        return true;
        localJSONException = localJSONException;
        localJSONException.printStackTrace();
      }
      catch (Exception paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "--ACTION_CANCEL--");
      }
      localJSONArray = new JSONArray();
      this.v = 1;
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("x", paramMotionEvent.getX() / this.k);
      localJSONObject.put("y", paramMotionEvent.getY() / this.k);
      localJSONObject.put("id", 0);
      localJSONArray.put(localJSONObject);
      this.l = new JSONObject();
      this.l.put("data", this.q);
      this.l.put("touches", localJSONArray);
      this.m.appBrandRuntime.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchCancel\", " + this.l + "," + this.m.getPageWebview().pageWebviewId + ")");
      return true;
    }
    catch (JSONException paramMotionEvent)
    {
      for (;;)
      {
        paramMotionEvent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */