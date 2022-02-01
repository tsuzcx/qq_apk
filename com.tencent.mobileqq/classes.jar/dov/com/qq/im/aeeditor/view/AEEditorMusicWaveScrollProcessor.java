package dov.com.qq.im.aeeditor.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.util.AEQLog;

public class AEEditorMusicWaveScrollProcessor
{
  private static final int jdField_a_of_type_Int = ViewUtils.a(2.0F);
  private static final int jdField_b_of_type_Int = ViewUtils.a(4.0F);
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new AEEditorMusicWaveScrollProcessor.1(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener;
  private AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  
  AEEditorMusicWaveScrollProcessor(AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent paramIMusicScrollProcessorParent, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent = paramIMusicScrollProcessorParent;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = 60000;
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.f = paramInt3;
    this.g = ViewUtils.a(7.0F);
    this.h = ViewUtils.a(3.0F);
    this.i = ViewUtils.a(2.0F);
    this.j = (this.i / 2);
    this.l = paramInt4;
    this.e = paramInt5;
    this.q = (this.l - paramInt3 * 2);
    float f1;
    if (this.jdField_c_of_type_Int < this.jdField_d_of_type_Int)
    {
      this.k = this.l;
      this.n = this.f;
      this.o = (this.k - this.f);
      f1 = 1000.0F / this.jdField_d_of_type_Int * this.q;
      this.jdField_c_of_type_Float = 0.0F;
      if (this.jdField_c_of_type_Int >= this.jdField_d_of_type_Int) {
        break label561;
      }
      this.jdField_b_of_type_Float = (this.jdField_c_of_type_Int * 1.0F / this.jdField_d_of_type_Int * this.q - f1);
      label270:
      if (!this.jdField_a_of_type_Boolean)
      {
        this.r = this.f;
        this.s = ViewUtils.a(9.0F);
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent.a(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setDither(true);
      if (this.jdField_c_of_type_Int >= this.jdField_d_of_type_Int) {
        break label581;
      }
    }
    label561:
    label581:
    for (this.m = ((int)((this.jdField_c_of_type_Int * 1.0F / this.jdField_d_of_type_Int * this.q + paramInt3 * 2) / jdField_b_of_type_Int));; this.m = ((int)(this.k * 1.0F / jdField_b_of_type_Int)))
    {
      if (this.m > 10000) {
        AEQLog.c("AEEditorMusicWaveScrollProcessor", "AEEditorMusicWaveScrollProcessor() called with: parent = [" + paramIMusicScrollProcessorParent + "], audioPath = [" + paramString2 + "], audioDuration = [" + paramInt1 + "], perScreenDuration = [" + paramInt2 + "], padding = [" + paramInt3 + "], isFromLibrary = [" + paramBoolean + "], width = [" + paramInt4 + "], height = [" + paramInt5 + "] lineCount=" + this.m);
      }
      AEEditorMusicWaveRandomGenerator.a(paramString1, paramString2, this.m);
      return;
      this.k = ((int)(this.jdField_c_of_type_Int * 1.0F / this.jdField_d_of_type_Int * this.q) + paramInt3 * 2);
      break;
      this.jdField_b_of_type_Float = (this.k - paramInt3 * 2 - f1);
      break label270;
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.decodeSampledBitmapFromResource(BaseApplicationImpl.getApplication().getResources(), 2130837948, 16, 118);
    }
  }
  
  int a()
  {
    return this.r;
  }
  
  void a(int paramInt)
  {
    if ((paramInt >= this.f) && (paramInt <= this.l - this.f)) {
      this.r = paramInt;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.p = ((int)(1.0F * paramInt1 / paramInt2 * (this.k - this.f * 2)) + this.f);
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent.a();
    }
  }
  
  void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    int i1 = BaseApplicationImpl.getContext().getResources().getColor(2131165257);
    Object localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2131165257);
    if (localObject != null) {
      i1 = ((ColorStateList)localObject).getDefaultColor();
    }
    int i2 = BaseApplicationImpl.getContext().getResources().getColor(2131165259);
    localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2131165259);
    if (localObject != null) {
      i2 = ((ColorStateList)localObject).getDefaultColor();
    }
    int i3 = BaseApplicationImpl.getContext().getResources().getColor(2131165258);
    localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2131165258);
    if (localObject != null) {
      i3 = ((ColorStateList)localObject).getDefaultColor();
    }
    for (;;)
    {
      if (!paramBoolean) {
        i2 = i1;
      }
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsPaint != null) && (paramCanvas != null))
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(BaseApplicationImpl.getContext().getResources().getColor(2131165255));
        paramCanvas.drawRoundRect(new RectF(this.f - this.j, this.g, this.l - this.f + this.j, this.e - this.g), this.h, this.h, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      float f1 = this.l;
      float f2 = this.f;
      float f3 = this.f;
      int i6 = this.l / jdField_b_of_type_Int;
      int i5 = (int)Math.ceil(1.0D * this.n / jdField_b_of_type_Int);
      int i4 = Math.max(Math.min((int)this.jdField_a_of_type_Float / jdField_b_of_type_Int, this.m), i5);
      i6 = Math.min(i6 + i4, this.m);
      localObject = new RectF(0.0F, 0.0F, jdField_a_of_type_Int, this.e);
      if (i4 < i6)
      {
        int i7;
        float f4;
        if (!this.jdField_a_of_type_Boolean)
        {
          i7 = (int)(AEEditorMusicWaveRandomGenerator.a(i4 - i5) * (this.e - this.g * 4));
          ((RectF)localObject).top = ((this.e - i7) / 2);
          f4 = ((RectF)localObject).top;
          ((RectF)localObject).bottom = (i7 + f4);
          label415:
          if ((this.jdField_a_of_type_Float + ((RectF)localObject).right >= this.n) && (this.jdField_a_of_type_Float + ((RectF)localObject).left <= this.o))
          {
            if ((((RectF)localObject).left < f2 + 0.0F) || (((RectF)localObject).left > f1 - f3)) {
              break label678;
            }
            if (!this.jdField_a_of_type_Boolean) {
              break label640;
            }
            if (((RectF)localObject).left >= this.p - this.jdField_a_of_type_Float) {
              break label628;
            }
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i3);
          }
        }
        for (;;)
        {
          paramCanvas.drawRoundRect((RectF)localObject, jdField_a_of_type_Int / 2, jdField_a_of_type_Int / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
          ((RectF)localObject).left += jdField_b_of_type_Int;
          ((RectF)localObject).right += jdField_b_of_type_Int;
          i4 += 1;
          break;
          i7 = (int)(AEEditorMusicWaveRandomGenerator.a(i4 - i5) * this.e);
          ((RectF)localObject).top = ((this.e - i7) / 2);
          f4 = ((RectF)localObject).top;
          ((RectF)localObject).bottom = (i7 + f4);
          break label415;
          label628:
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i2);
          continue;
          label640:
          if (((RectF)localObject).left < this.t)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i3);
          }
          else
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i2);
            continue;
            label678:
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i1);
          }
        }
      }
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsPaint != null) && (paramCanvas != null))
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(BaseApplicationImpl.getContext().getResources().getColor(2131165256));
        this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.i);
        paramCanvas.drawRoundRect(new RectF(this.f - this.j, this.g, this.l - this.f + this.j, this.e - this.g), this.h, this.h, this.jdField_b_of_type_AndroidGraphicsPaint);
        a();
        localObject = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        RectF localRectF = new RectF(this.r - this.s / 2, 0.0F, this.r + this.s / 2, this.e);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject, localRectF, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener.b();
      }
    }
    while (this.jdField_a_of_type_AndroidViewGestureDetector == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  void a(AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener paramIMusicBarMoveListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener = paramIMusicBarMoveListener;
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  int b()
  {
    return this.s;
  }
  
  void b(int paramInt)
  {
    this.t = paramInt;
  }
  
  int c()
  {
    return this.f;
  }
  
  void c(int paramInt)
  {
    this.jdField_a_of_type_Float = (1.0F * paramInt / this.jdField_d_of_type_Int * this.q);
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent.a();
    }
  }
  
  int d()
  {
    return this.l;
  }
  
  int e()
  {
    return this.e;
  }
  
  int f()
  {
    int i2 = (int)(1.0F * this.jdField_a_of_type_Float / this.q * this.jdField_d_of_type_Int);
    int i1 = i2;
    if (i2 > this.jdField_c_of_type_Int) {
      i1 = this.jdField_c_of_type_Int;
    }
    return i1;
  }
  
  int g()
  {
    int i1 = (int)(1.0F * this.jdField_a_of_type_Float / this.q * this.jdField_d_of_type_Int) + this.jdField_d_of_type_Int;
    if (i1 <= this.jdField_c_of_type_Int) {
      return i1;
    }
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.AEEditorMusicWaveScrollProcessor
 * JD-Core Version:    0.7.0.1
 */