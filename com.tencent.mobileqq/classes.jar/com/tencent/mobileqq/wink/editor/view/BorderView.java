package com.tencent.mobileqq.wink.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.sticker.StickerModelExKt;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.utils.QQWinkEditorUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class BorderView
  extends FrameLayout
{
  public static int b = 300;
  public static int c = 150;
  private static final String l;
  private static final String m;
  private boolean A;
  private boolean B;
  private float C;
  private float D;
  public int a = 0;
  ImageView d;
  TextView e;
  LinearLayout f;
  LinearLayout g;
  ConstraintLayout h;
  LinearLayout i;
  public boolean j = true;
  private android.graphics.PointF k = new android.graphics.PointF();
  private float n = 0.0F;
  private float o = 0.0F;
  private float p = 1.0F;
  private int q = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private VasPagView r;
  private WinkStickerModel s;
  private BorderView.StickerOperationCallBack t;
  private android.graphics.PointF u;
  private android.graphics.PointF v;
  private long w = 0L;
  private int x = 0;
  private android.graphics.PointF y;
  private boolean z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(WinkEditorResourceManager.j);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qvideo_editor_delete_bmp.pag");
    l = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(WinkEditorResourceManager.j);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qvideo_editor_delete_close_bmp.pag");
    m = localStringBuilder.toString();
  }
  
  public BorderView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BorderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private float a(double paramDouble1, double paramDouble2)
  {
    return (float)Math.toDegrees(Math.atan2(paramDouble2, paramDouble1));
  }
  
  private float a(float paramFloat)
  {
    double d1 = Math.ceil(paramFloat - this.s.getOriginPointInView().x + this.s.getSizeInView().x / 2.0F);
    double d2 = this.t.k() / 2;
    Double.isNaN(d2);
    return (float)(d1 / d2 - 1.0D);
  }
  
  private float a(Float paramFloat)
  {
    float f1 = paramFloat.floatValue();
    if (paramFloat.floatValue() < 0.2F) {
      f1 = 0.2F;
    }
    if (paramFloat.floatValue() > 10.0F) {
      f1 = 10.0F;
    }
    return f1;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    WinkStickerModel localWinkStickerModel = StickerModelExKt.b(this.s, paramFloat1, paramFloat2);
    localWinkStickerModel.updatePositionInView(this.t.k(), this.t.l(), this.t.m());
    this.t.a(localWinkStickerModel);
  }
  
  private void a(android.graphics.PointF paramPointF)
  {
    WinkStickerModel localWinkStickerModel = this.s;
    if (localWinkStickerModel != null)
    {
      if (localWinkStickerModel.getInitStickerScale() == 0.0F) {
        return;
      }
      float f1 = this.s.scale / this.s.getInitStickerScale();
      paramPointF.x += this.s.width * f1 / 2.0F;
      paramPointF.y += this.s.height * f1 / 2.0F;
      f1 = this.s.width * (this.s.scale / this.s.getInitStickerScale());
      a(this.g, paramPointF, f1);
      a(this.h, paramPointF, f1);
      a(this.i, paramPointF, f1);
    }
  }
  
  private void a(ViewGroup paramViewGroup, android.graphics.PointF paramPointF, float paramFloat)
  {
    if (paramViewGroup != null)
    {
      int i1;
      if (b(paramViewGroup, paramPointF, paramFloat).booleanValue()) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      paramViewGroup.setVisibility(i1);
    }
  }
  
  private void a(PAGView paramPAGView, String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = PAGFile.Load(paramString.getAbsolutePath());
      if (paramString != null)
      {
        paramPAGView.setComposition(paramString);
        paramPAGView.setRepeatCount(1);
        paramPAGView.play();
      }
    }
  }
  
  private float b(float paramFloat)
  {
    double d1 = Math.ceil(paramFloat - this.s.getOriginPointInView().y + this.s.getSizeInView().y / 2.0F);
    double d2 = this.t.l() / 2;
    Double.isNaN(d2);
    return (float)(1.0D - d1 / d2);
  }
  
  private android.graphics.PointF b(float paramFloat1, float paramFloat2)
  {
    float f1 = -this.s.getSizeInView().x / 2.0F + this.s.getOriginPointInView().x;
    float f4 = this.t.k() + f1;
    float f2 = -this.s.getSizeInView().y / 2.0F;
    float f3 = this.s.getOriginPointInView().y + f2;
    f2 = this.t.l() + f3;
    if (paramFloat1 >= f1)
    {
      f1 = paramFloat1;
      if (paramFloat1 > f4) {
        f1 = f4;
      }
    }
    if (paramFloat2 < f3)
    {
      paramFloat1 = f3;
    }
    else
    {
      paramFloat1 = paramFloat2;
      if (paramFloat2 > f2) {
        paramFloat1 = f2;
      }
    }
    return new android.graphics.PointF(f1, paramFloat1);
  }
  
  private Boolean b(ViewGroup paramViewGroup, android.graphics.PointF paramPointF, float paramFloat)
  {
    boolean bool;
    if (QQWinkEditorUtils.a(paramPointF, this.t.a(paramViewGroup)) < paramFloat / 2.0F) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  private void c()
  {
    LinearLayout localLinearLayout = this.g;
    if ((localLinearLayout != null) && (this.h != null) && (this.i != null))
    {
      localLinearLayout.setVisibility(4);
      this.h.setVisibility(4);
      this.i.setVisibility(4);
    }
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    float f3 = a(paramFloat1, paramFloat2) - this.o + this.s.getLastDownRotate();
    float f2 = 0.0F;
    float f1;
    if (f3 < 0.0F)
    {
      f1 = f3 + 360.0F;
    }
    else
    {
      f1 = f3;
      if (f3 > 360.0F) {
        f1 = f3 - 360.0F;
      }
    }
    if (this.n > 0.0F)
    {
      f2 = a(Float.valueOf((float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) / this.n * this.s.getLastDownScale()));
      this.p = f2;
    }
    this.s.setDownScaleRecord(f1);
    d(f2, f1 * -1.0F);
  }
  
  private void d(float paramFloat1, float paramFloat2)
  {
    WinkStickerModel localWinkStickerModel = this.s;
    if (localWinkStickerModel != null)
    {
      localWinkStickerModel = StickerModelExKt.a(localWinkStickerModel, paramFloat2, paramFloat1);
      localWinkStickerModel.updatePositionInView(this.t.k(), this.t.l(), this.t.m());
      this.t.a(localWinkStickerModel);
    }
  }
  
  private boolean g(MotionEvent paramMotionEvent)
  {
    android.graphics.PointF localPointF = this.u;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localPointF != null)
    {
      bool1 = bool2;
      if (Math.abs(paramMotionEvent.getX() - this.u.x) < this.q)
      {
        if (Math.abs(paramMotionEvent.getY() - this.u.y) >= this.q) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean h(MotionEvent paramMotionEvent)
  {
    android.graphics.PointF localPointF = this.y;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localPointF != null)
    {
      int i1 = this.q;
      bool1 = bool2;
      if (Math.abs(paramMotionEvent.getX() - this.y.x) > this.q)
      {
        bool1 = bool2;
        if (Math.abs(paramMotionEvent.getY() - this.y.y) < i1 * 6) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    this.k.x = paramMotionEvent.getX();
    this.k.y = paramMotionEvent.getY();
    this.u = new android.graphics.PointF(this.k.x, this.k.y);
    if (this.v == null) {
      this.v = this.u;
    }
    if (this.w == 0L) {
      this.w = System.currentTimeMillis();
    }
    this.s = this.t.a(this.k.x, this.k.y);
    if (this.s == null)
    {
      this.y = new android.graphics.PointF(this.k.x, this.k.y);
      return this.j;
    }
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("Sticker model got: ");
      paramMotionEvent.append(this.s.id);
      AEQLog.b("WinkBorderView", paramMotionEvent.toString());
    }
    this.C = this.s.getLeftTopInView().x;
    this.D = this.s.getLeftTopInView().y;
    paramMotionEvent = this.s;
    paramMotionEvent.setLastDownScale(paramMotionEvent.scale);
    paramMotionEvent = this.s;
    paramMotionEvent.setLastDownRotate(paramMotionEvent.getDownScaleRecord());
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    return QQWinkEditorUtils.a(this.t.i(), new android.graphics.PointF(paramMotionEvent.getX(), paramMotionEvent.getY())) < paramView.getRight() - paramView.getLeft();
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (this.s == null)
    {
      this.s = this.t.a(new android.graphics.PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0)), new android.graphics.PointF(paramMotionEvent.getX(1), paramMotionEvent.getY(1)));
      if (this.s == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sticker model get with two finger: ");
        ((StringBuilder)localObject).append(this.s.id);
        AEQLog.b("WinkBorderView", ((StringBuilder)localObject).toString());
      }
      localObject = this.s;
      ((WinkStickerModel)localObject).setLastDownScale(((WinkStickerModel)localObject).scale);
      localObject = this.s;
      ((WinkStickerModel)localObject).setLastDownRotate(((WinkStickerModel)localObject).getDownScaleRecord());
    }
    Object localObject = new android.graphics.PointF(paramMotionEvent.getX(this.a), paramMotionEvent.getY(this.a));
    float f1 = paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getX(0);
    float f3 = paramMotionEvent.getY(1);
    float f4 = paramMotionEvent.getY(0);
    this.n = QQWinkEditorUtils.a((android.graphics.PointF)localObject, this.k);
    this.o = a(f1 - f2, f3 - f4);
    return true;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    if (this.s == null) {
      return true;
    }
    if (paramMotionEvent.getPointerCount() == 2)
    {
      c(paramMotionEvent.getX(1) - paramMotionEvent.getX(0), paramMotionEvent.getY(1) - paramMotionEvent.getY(0));
      return true;
    }
    if (paramMotionEvent.getPointerCount() == 1)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = this.k.x;
      float f3 = paramMotionEvent.getY();
      float f4 = this.k.y;
      float f5 = this.C;
      float f6 = this.D;
      if (g(paramMotionEvent))
      {
        this.z = true;
        d(paramMotionEvent);
        this.t.a(true);
        paramMotionEvent = b(f5 + (f1 - f2), f6 + (f3 - f4));
        a(a(paramMotionEvent.x), b(paramMotionEvent.y));
        a(paramMotionEvent);
      }
    }
    return true;
  }
  
  public void d(MotionEvent paramMotionEvent)
  {
    if ((this.d != null) && (this.r != null))
    {
      LinearLayout localLinearLayout = this.f;
      if ((localLinearLayout != null) && (this.e != null))
      {
        if (!this.j) {
          return;
        }
        if (localLinearLayout.getVisibility() == 4) {
          this.f.setVisibility(0);
        }
        if (a(paramMotionEvent, this.d))
        {
          this.d.setBackgroundResource(2130848735);
          this.e.setText(2131913997);
          this.d.setImageDrawable(null);
          this.B = false;
          if (!this.A)
          {
            this.A = true;
            this.r.setVisibility(0);
            this.r.g().a(new BorderView.1(this));
          }
        }
        else
        {
          if (this.r.getVisibility() != 0) {
            this.d.setImageDrawable(getRootView().getResources().getDrawable(2130853667));
          }
          this.d.setBackgroundResource(2130848734);
          this.e.setText(2131913996);
          if ((this.r.getVisibility() == 0) && (!this.B))
          {
            this.B = true;
            this.r.g().a(new BorderView.2(this));
          }
          this.A = false;
        }
      }
    }
  }
  
  public boolean e(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerId(this.a) == 0)
    {
      this.k.x = paramMotionEvent.getX(1);
      this.k.y = paramMotionEvent.getY(1);
    }
    else if (paramMotionEvent.getPointerId(this.a) == 1)
    {
      this.k.x = paramMotionEvent.getX(0);
      this.k.y = paramMotionEvent.getY(0);
    }
    this.s = null;
    this.y = null;
    return true;
  }
  
  public boolean f(MotionEvent paramMotionEvent)
  {
    if (this.d != null)
    {
      if (this.f == null) {
        return true;
      }
      int i1;
      if ((!g(paramMotionEvent)) && (!this.z)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (this.s != null)
      {
        if ((a(paramMotionEvent, this.d)) && (this.j)) {
          this.t.b(this.s);
        }
        this.s.setLastDownScale(this.p);
        if (i1 != 0)
        {
          this.x += 1;
          if (this.x == 2)
          {
            if ((System.currentTimeMillis() - this.w < b) && (Math.abs(paramMotionEvent.getX() - this.v.x) < c) && (Math.abs(paramMotionEvent.getY() - this.v.y) < c)) {
              this.t.d(this.s);
            } else {
              this.t.d(null);
            }
            this.x = 0;
            this.w = 0L;
            this.v = null;
          }
          this.t.c(this.s);
        }
      }
      else if (i1 != 0)
      {
        this.t.c(null);
      }
      if ((this.y != null) && (this.s == null) && (h(paramMotionEvent)))
      {
        BorderView.StickerOperationCallBack localStickerOperationCallBack = this.t;
        if (paramMotionEvent.getX() > this.y.x) {
          paramMotionEvent = BorderView.Direction.Right;
        } else {
          paramMotionEvent = BorderView.Direction.Left;
        }
        localStickerOperationCallBack.a(paramMotionEvent);
      }
      this.z = false;
      this.s = null;
      if (this.f.getVisibility() == 0) {
        this.f.setVisibility(4);
      }
      this.t.a(false);
      if (this.r.getVisibility() == 0)
      {
        this.r.setVisibility(4);
        this.B = false;
      }
      c();
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a = paramMotionEvent.getActionIndex();
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if (i1 != 6) {
                return false;
              }
              return e(paramMotionEvent);
            }
            return b(paramMotionEvent);
          }
        }
        else {
          return c(paramMotionEvent);
        }
      }
      return f(paramMotionEvent);
    }
    return a(paramMotionEvent);
  }
  
  public void setBorderViewEventConsumable(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setOperationCallback(@Nullable BorderView.StickerOperationCallBack paramStickerOperationCallBack)
  {
    this.t = paramStickerOperationCallBack;
    this.r = ((VasPagView)getRootView().findViewById(2131449327));
    paramStickerOperationCallBack = this.r;
    if (paramStickerOperationCallBack != null) {
      paramStickerOperationCallBack.g().a();
    }
    this.d = ((ImageView)getRootView().findViewById(2131436591));
    this.e = ((TextView)getRootView().findViewById(2131436593));
    this.f = ((LinearLayout)getRootView().findViewById(2131436592));
    this.g = ((LinearLayout)getRootView().findViewById(2131450179));
    this.h = ((ConstraintLayout)getRootView().findViewById(2131433389));
    this.i = ((LinearLayout)getRootView().findViewById(2131433365));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.view.BorderView
 * JD-Core Version:    0.7.0.1
 */