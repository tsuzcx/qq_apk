package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer.LayerEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MosaicOperator
  extends DoodleOperator
{
  public static final int a;
  public float a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public BitmapShader a;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  public LineLayer.LayerEventListener a;
  DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  DoodleLineListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener;
  public MosaicLinePath a;
  public boolean a;
  public byte[] a;
  public byte[][] a;
  public float b;
  public int b;
  public Bitmap b;
  private boolean b;
  float c;
  public int c;
  public float d;
  public int d;
  public float e;
  public int e;
  public int f;
  int g = 103;
  int h = 0;
  int i;
  int j;
  
  static
  {
    jdField_a_of_type_Int = Color.parseColor("#FF000000");
  }
  
  public MosaicOperator(DoodleLineListener paramDoodleLineListener)
  {
    this.jdField_b_of_type_Int = 10;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener = paramDoodleLineListener;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    int k = 0;
    SLog.b("MosaicOperator", "increaseMask:x=" + paramInt1 + ",y=" + paramInt2 + ",MosaicMaskWidth:" + this.jdField_e_of_type_Int + ",MosaicMaskHeight:" + this.f);
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = paramInt1;
    arrayOfInt1[1] = (paramInt1 - 1);
    arrayOfInt1[2] = paramInt1;
    arrayOfInt1[3] = (paramInt1 + 1);
    arrayOfInt1[4] = paramInt1;
    int[] arrayOfInt2 = new int[5];
    arrayOfInt2[0] = paramInt2;
    arrayOfInt2[1] = paramInt2;
    arrayOfInt2[2] = (paramInt2 - 1);
    arrayOfInt2[3] = paramInt2;
    arrayOfInt2[4] = (paramInt2 + 1);
    paramInt1 = k;
    while ((paramInt1 < arrayOfInt1.length) && (paramInt1 < arrayOfInt2.length))
    {
      paramInt2 = arrayOfInt1[paramInt1];
      k = arrayOfInt2[paramInt1];
      if ((paramInt2 >= 0) && (k >= 0) && (paramInt2 < this.jdField_e_of_type_Int) && (k < this.f))
      {
        int m = this.jdField_e_of_type_Int * k + paramInt2;
        byte[] arrayOfByte;
        if (this.jdField_a_of_type_ArrayOfByte[m] != 127)
        {
          arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
          arrayOfByte[m] = ((byte)(arrayOfByte[m] + 1));
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Array2dOfByte[k][paramInt2] < 127))
        {
          arrayOfByte = this.jdField_a_of_type_Array2dOfByte[k];
          arrayOfByte[paramInt2] = ((byte)(arrayOfByte[paramInt2] + 1));
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    int k = 0;
    SLog.b("MosaicOperator", "decreaseMask:x=" + paramInt1 + ",y=" + paramInt2 + ",MosaicMaskWidth:" + this.jdField_e_of_type_Int + ",MosaicMaskHeight:" + this.f);
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = paramInt1;
    arrayOfInt1[1] = (paramInt1 - 1);
    arrayOfInt1[2] = paramInt1;
    arrayOfInt1[3] = (paramInt1 + 1);
    arrayOfInt1[4] = paramInt1;
    int[] arrayOfInt2 = new int[5];
    arrayOfInt2[0] = paramInt2;
    arrayOfInt2[1] = paramInt2;
    arrayOfInt2[2] = (paramInt2 - 1);
    arrayOfInt2[3] = paramInt2;
    arrayOfInt2[4] = (paramInt2 + 1);
    paramInt1 = k;
    while ((paramInt1 < arrayOfInt1.length) && (paramInt1 < arrayOfInt2.length))
    {
      paramInt2 = arrayOfInt1[paramInt1];
      k = arrayOfInt2[paramInt1];
      if ((paramInt2 >= 0) && (k >= 0) && (paramInt2 < this.jdField_e_of_type_Int) && (k < this.f))
      {
        int m = this.jdField_e_of_type_Int * k + paramInt2;
        byte[] arrayOfByte;
        if (this.jdField_a_of_type_ArrayOfByte[m] > 0)
        {
          arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
          arrayOfByte[m] = ((byte)(arrayOfByte[m] - 1));
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Array2dOfByte[k][paramInt2] > 0))
        {
          arrayOfByte = this.jdField_a_of_type_Array2dOfByte[k];
          arrayOfByte[paramInt2] = ((byte)(arrayOfByte[paramInt2] - 1));
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      SLog.b("MosaicOperator", "------------------------------------------------------------------------");
      StringBuilder localStringBuilder = new StringBuilder();
      int k = 0;
      while (k < this.jdField_a_of_type_Array2dOfByte.length)
      {
        int m = 0;
        while (m < this.jdField_a_of_type_Array2dOfByte[0].length)
        {
          localStringBuilder.append(this.jdField_a_of_type_Array2dOfByte[k][m] + " ");
          m += 1;
        }
        SLog.b("MosaicOperator", localStringBuilder.toString());
        localStringBuilder.delete(0, localStringBuilder.length());
        k += 1;
      }
    }
  }
  
  public void a()
  {
    if (this.g == 105)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.h);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(45.0F);
    } while (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      return;
    }
    this.i = paramInt1;
    this.j = paramInt2;
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(Canvas paramCanvas, MosaicLinePath paramMosaicLinePath, float paramFloat)
  {
    if (paramMosaicLinePath.jdField_a_of_type_Int == 103) {}
    do
    {
      return;
      if (paramMosaicLinePath.jdField_a_of_type_Int == 104)
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null) {
          b();
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(45.0F);
        if (this.jdField_a_of_type_AndroidGraphicsBitmapShader != null) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
        }
        paramCanvas.drawPath(paramMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
    } while (paramMosaicLinePath.jdField_a_of_type_Int != 105);
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
    {
      SLog.d("MosaicOperator", "do not init yet");
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsCanvas.scale(paramFloat, paramFloat);
    if (this.h == 0) {
      this.h = AIOUtils.a(16.0F, BaseApplicationImpl.getContext().getResources());
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.h);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPath(paramMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsCanvas.restore();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(LineLayer.LayerEventListener paramLayerEventListener, float paramFloat, Bitmap paramBitmap, Rect paramRect)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener = paramLayerEventListener;
    this.jdField_c_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public void a(DoodleLayout paramDoodleLayout)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = paramDoodleLayout;
  }
  
  public void a(MosaicLinePath paramMosaicLinePath)
  {
    if (paramMosaicLinePath.jdField_a_of_type_Int == 103)
    {
      DoodleLayout.a("delete_mosaics");
      VideoEditReport.a("0X80076C2");
      List localList = paramMosaicLinePath.jdField_a_of_type_JavaUtilList;
      paramMosaicLinePath = paramMosaicLinePath.b;
      int k = 0;
      while ((k < localList.size()) && (k < paramMosaicLinePath.size()))
      {
        e(((Integer)localList.get(k)).intValue(), ((Integer)paramMosaicLinePath.get(k)).intValue());
        k += 1;
      }
      c();
    }
    do
    {
      return;
      if (paramMosaicLinePath.jdField_a_of_type_Int == 104)
      {
        VideoEditReport.b("0X80075CF");
        return;
      }
    } while (paramMosaicLinePath.jdField_a_of_type_Int != 105);
    a(false);
    DoodleLayout.a("delete_mosaics");
    VideoEditReport.a("0X80076C2");
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.g == 105) && (this.jdField_a_of_type_AndroidGraphicsCanvas != null))
    {
      SLog.a("MosaicOperator", "clearMp4MosaicCanvasAndDraw notify=%s", Boolean.valueOf(paramBoolean));
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(localPaint);
      this.jdField_b_of_type_Boolean = true;
      if (paramBoolean) {
        c();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_d_of_type_Float = f1;
      this.jdField_e_of_type_Float = f2;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath = new MosaicLinePath(this.g);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath);
      }
      int k;
      int m;
      if (this.g == 103)
      {
        DoodleLayout.a("use_mosaics");
        VideoEditReport.a("0X80076C1");
        k = (int)(this.jdField_b_of_type_Float * f1 / this.jdField_b_of_type_Int);
        m = (int)(this.jdField_b_of_type_Float * f2 / this.jdField_b_of_type_Int);
        if ((k >= 0) && (m >= 0))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(k));
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.b.add(Integer.valueOf(m));
          d(k, m);
          c();
        }
      }
      else if (this.g == 104)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + 1.0F, f2 + 1.0F);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_a_of_type_Int, f1, f2));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_b_of_type_Int, f1 + 1.0F, 1.0F + f2));
      }
      else if (this.g == 105)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + 1.0F, f2 + 1.0F);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_a_of_type_Int, f1, f2));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_b_of_type_Int, f1 + 1.0F, 1.0F + f2));
        continue;
        int n;
        int i1;
        if (this.g == 103)
        {
          k = ((Integer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.size() - 1)).intValue();
          m = ((Integer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.b.get(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.b.size() - 1)).intValue();
          n = (int)(this.jdField_b_of_type_Float * f1 / this.jdField_b_of_type_Int);
          i1 = (int)(this.jdField_b_of_type_Float * f2 / this.jdField_b_of_type_Int);
          if (((n != k) || (i1 != m)) && (n >= 0) && (i1 >= 0))
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(n));
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.b.add(Integer.valueOf(i1));
            d(n, i1);
            c();
          }
        }
        else
        {
          float f3;
          float f4;
          if (this.g == 104)
          {
            f3 = (this.jdField_d_of_type_Float + f1) / 2.0F;
            f4 = (this.jdField_e_of_type_Float + f2) / 2.0F;
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f3, f4);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_c_of_type_Int, this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f3, f4));
            this.jdField_d_of_type_Float = f1;
            this.jdField_e_of_type_Float = f2;
          }
          else if (this.g == 105)
          {
            f3 = (this.jdField_d_of_type_Float + f1) / 2.0F;
            f4 = (this.jdField_e_of_type_Float + f2) / 2.0F;
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f3, f4);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_c_of_type_Int, this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f3, f4));
            this.jdField_d_of_type_Float = f1;
            this.jdField_e_of_type_Float = f2;
            continue;
            if (this.g == 103)
            {
              k = ((Integer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.size() - 1)).intValue();
              m = ((Integer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.b.get(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.b.size() - 1)).intValue();
              n = (int)(this.jdField_b_of_type_Float * f1 / this.jdField_b_of_type_Int);
              i1 = (int)(this.jdField_b_of_type_Float * f2 / this.jdField_b_of_type_Int);
              if (((n != k) || (i1 != m)) && (n >= 0) && (i1 >= 0))
              {
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(n));
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath.b.add(Integer.valueOf(i1));
                d(n, i1);
                c();
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmapShader != null) {}
    Bitmap localBitmap;
    label24:
    do
    {
      return;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
        break;
      }
      localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    } while (this.jdField_a_of_type_AndroidGraphicsBitmap == null);
    if (Math.min(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height()) / 8 < 28) {}
    for (int k = 2;; k = 8)
    {
      Object localObject;
      try
      {
        localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width() / k, this.jdField_a_of_type_AndroidGraphicsRect.height() / k, Bitmap.Config.RGB_565);
        float f1 = localBitmap.getWidth() / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        SLog.a("MosaicOperator", "init matrix. scale[%f, %f]. translate[%f, %f].", Float.valueOf(f1), Float.valueOf(f1), Float.valueOf(0.0F), Float.valueOf(0.0F));
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f1, f1);
        ((Matrix)localObject).postTranslate(0.0F, 0.0F);
        new Canvas(localBitmap).drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Matrix)localObject, null);
        int n = Math.min(localBitmap.getWidth(), localBitmap.getHeight()) / 28;
        int m = n;
        if (n == 0) {
          m = 1;
        }
        DoodleUtil.a(localBitmap, m);
        localObject = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), Bitmap.Config.RGB_565);
        if (localObject != null) {
          break label288;
        }
        localBitmap.recycle();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MosaicOperator", 2, "failed to create mosaic bitmap");
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        SLog.c("MosaicOperator", "initMosaicPicMode.", localOutOfMemoryError);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        SLog.c("MosaicOperator", "initMosaicPicMode.", localIllegalArgumentException);
        return;
      }
      localBitmap = null;
      break label24;
      label288:
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(k, k);
      localCanvas.drawBitmap(localIllegalArgumentException, localMatrix, null);
      localIllegalArgumentException.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    SLog.b("MosaicOperator", "set MosaicSize:" + paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    SLog.b("MosaicOperator", "standardWidth:" + paramInt1 + ",standardHeight:" + paramInt2);
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener != null)
    {
      if (this.g != 105) {
        break label50;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener.a(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_Boolean);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Boolean) {
        f();
      }
      return;
      label50:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer$LayerEventListener.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_e_of_type_Int, this.f);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Float = (this.jdField_c_of_type_Int / paramInt1);
    this.jdField_b_of_type_Float = (this.jdField_d_of_type_Int / paramInt2);
    if (this.jdField_b_of_type_Float <= 0.0F)
    {
      SLog.e("MosaicOperator", "mosaicHeightScale <= 0.");
      this.jdField_b_of_type_Float = this.jdField_c_of_type_Float;
    }
    this.jdField_e_of_type_Int = ((int)(paramInt1 * this.jdField_b_of_type_Float / this.jdField_b_of_type_Int));
    this.f = ((int)(this.jdField_d_of_type_Int / this.jdField_b_of_type_Int));
    SLog.b("MosaicOperator", "create mosaic mask array, width:" + this.jdField_e_of_type_Int + ",height:" + this.f + ",array length:" + this.jdField_e_of_type_Int * this.f);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_e_of_type_Int * this.f];
    paramInt1 = 0;
    while (paramInt1 < this.jdField_a_of_type_ArrayOfByte.length)
    {
      this.jdField_a_of_type_ArrayOfByte[paramInt1] = 0;
      paramInt1 += 1;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt1 = this.f;
      paramInt2 = this.jdField_e_of_type_Int;
      this.jdField_a_of_type_Array2dOfByte = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt1, paramInt2 }));
      paramInt1 = 0;
      while (paramInt1 < this.f)
      {
        paramInt2 = 0;
        while (paramInt2 < this.jdField_e_of_type_Int)
        {
          this.jdField_a_of_type_Array2dOfByte[paramInt1][paramInt2] = 0;
          paramInt2 += 1;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicLinePath = new MosaicLinePath(this.g);
    if (this.g == 104) {
      return;
    }
    if (this.g == 105)
    {
      a(true);
      return;
    }
    int k;
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      k = 0;
      while (k < this.jdField_a_of_type_ArrayOfByte.length)
      {
        this.jdField_a_of_type_ArrayOfByte[k] = 0;
        k += 1;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      k = 0;
      while (k < this.jdField_a_of_type_Array2dOfByte.length)
      {
        int m = 0;
        while (m < this.jdField_a_of_type_Array2dOfByte[0].length)
        {
          this.jdField_a_of_type_Array2dOfByte[k][m] = 0;
          m += 1;
        }
        k += 1;
      }
    }
    c();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmapShader = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.MosaicOperator
 * JD-Core Version:    0.7.0.1
 */