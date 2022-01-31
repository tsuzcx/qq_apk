package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CropView
  extends View
  implements Handler.Callback, View.OnTouchListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_a_of_type_AndroidGraphicsRect;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  CropView.CropListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_b_of_type_AndroidGraphicsRect;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_c_of_type_Boolean = true;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int = 8;
  Rect jdField_d_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_d_of_type_Boolean = true;
  float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 40;
  Rect jdField_e_of_type_AndroidGraphicsRect;
  float f;
  float g;
  float h;
  float i;
  float j;
  private float k;
  private float l;
  
  public CropView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2) {
      return 0;
    }
    int m = this.jdField_e_of_type_Int;
    Rect localRect1 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2);
    Rect localRect2 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.right + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2);
    Rect localRect3 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom + m * 2);
    Rect localRect4 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.right + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom + m * 2);
    Rect localRect5 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - m, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.left + m, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2);
    Rect localRect6 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right - m, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.right + m, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2);
    Rect localRect7 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top - m, this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top + m);
    Rect localRect8 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m, this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, m + this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    if (localRect1.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 1;
    }
    if (localRect2.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 2;
    }
    if (localRect3.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 3;
    }
    if (localRect4.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 4;
    }
    if (localRect5.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 5;
    }
    if (localRect6.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 7;
    }
    if (localRect7.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 6;
    }
    if (localRect8.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 8;
    }
    return 0;
  }
  
  @TargetApi(10)
  private Bitmap a(int[] paramArrayOfInt)
  {
    try
    {
      localObject1 = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if (((Bitmap)localObject1).isRecycled())
      {
        QLog.e("EditPicActivityCropView", 1, "isRecycled");
        return null;
      }
      localObject3 = new ByteArrayOutputStream();
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject3);
      localObject1 = ((ByteArrayOutputStream)localObject3).toByteArray();
      localObject1 = BitmapRegionDecoder.newInstance((byte[])localObject1, 0, localObject1.length, false);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          Object localObject1;
          int m;
          int n;
          Object localObject3 = ((BitmapRegionDecoder)localObject1).decodeRegion(this.jdField_e_of_type_AndroidGraphicsRect, (BitmapFactory.Options)localObject3);
          int i1 = this.jdField_c_of_type_Int;
          if (i1 == 0)
          {
            ((BitmapRegionDecoder)localObject1).recycle();
            return localObject3;
            localIOException = localIOException;
            SLog.c("EditPicActivityCropView", "[loadRectFromOrigin]", localIOException);
            if (paramArrayOfInt != null) {
              paramArrayOfInt[0] = -3;
            }
            localObject2 = null;
          }
          else
          {
            SLog.b("EditPicActivityCropView", "loadRectFromOrigin rotate " + i1);
            n = ((Bitmap)localObject3).getWidth();
            m = ((Bitmap)localObject3).getHeight();
            if ((i1 == 90) || (i1 == 270))
            {
              n = ((Bitmap)localObject3).getHeight();
              m = ((Bitmap)localObject3).getWidth();
              SLog.b("EditPicActivityCropView", "loadRectFromOrigin  base w " + n + " base h " + m);
              float f1 = getContext().getResources().getDisplayMetrics().widthPixels;
              float f2 = getContext().getResources().getDisplayMetrics().heightPixels;
              float f3 = m / n;
              f1 = f2 / f1;
              SLog.b("EditPicActivityCropView", "loadRectFromOrigin scale " + 1.0F + " final w " + n + " final h " + m);
              Bitmap localBitmap = Bitmap.createBitmap(n, m, Bitmap.Config.ARGB_8888);
              Canvas localCanvas = new Canvas(localBitmap);
              Matrix localMatrix = new Matrix();
              if (i1 != 0) {
                localMatrix.postRotate(i1, ((Bitmap)localObject3).getWidth() / 2, ((Bitmap)localObject3).getHeight() / 2);
              }
              i1 = ((Bitmap)localObject3).getWidth() / 2;
              n /= 2;
              int i2 = ((Bitmap)localObject3).getHeight() / 2;
              m /= 2;
              localMatrix.postTranslate(-(i1 - n), -(i2 - m));
              localCanvas.drawBitmap((Bitmap)localObject3, localMatrix, null);
              SLog.b("EditPicActivityCropView", "harlan harlan crop bitmap inMutable " + localBitmap.isMutable());
              if (paramArrayOfInt != null) {
                paramArrayOfInt[0] = 0;
              }
              return localBitmap;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          SLog.c("EditPicActivityCropView", "[loadRectFromOrigin]", localOutOfMemoryError);
          if (paramArrayOfInt != null) {
            paramArrayOfInt[0] = -2;
          }
          return null;
        }
        catch (Exception localException)
        {
          SLog.c("EditPicActivityCropView", "[loadRectFromOrigin]", localException);
          if (paramArrayOfInt != null) {
            paramArrayOfInt[0] = -1;
          }
          return null;
        }
        finally
        {
          Object localObject2;
          localObject2.recycle();
        }
      }
    }
    if (localObject1 != null)
    {
      localObject3 = a();
      SLog.b("EditPicActivityCropView", "new resultRect");
      if (this.jdField_e_of_type_AndroidGraphicsRect == null)
      {
        this.jdField_e_of_type_AndroidGraphicsRect = new Rect();
        this.jdField_e_of_type_AndroidGraphicsRect.top = 0;
        this.jdField_e_of_type_AndroidGraphicsRect.left = 0;
        this.jdField_e_of_type_AndroidGraphicsRect.right = ((BitmapRegionDecoder)localObject1).getWidth();
        this.jdField_e_of_type_AndroidGraphicsRect.bottom = ((BitmapRegionDecoder)localObject1).getHeight();
        this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_e_of_type_AndroidGraphicsRect);
      }
      m = this.jdField_e_of_type_AndroidGraphicsRect.width();
      n = this.jdField_e_of_type_AndroidGraphicsRect.height();
      this.jdField_e_of_type_AndroidGraphicsRect.top = ((int)(this.jdField_e_of_type_AndroidGraphicsRect.top + n * localObject3[1]));
      this.jdField_e_of_type_AndroidGraphicsRect.bottom = ((int)(this.jdField_e_of_type_AndroidGraphicsRect.bottom - n * localObject3[3]));
      this.jdField_e_of_type_AndroidGraphicsRect.left = ((int)(this.jdField_e_of_type_AndroidGraphicsRect.left + m * localObject3[0]));
      this.jdField_e_of_type_AndroidGraphicsRect.right = ((int)(this.jdField_e_of_type_AndroidGraphicsRect.right - m * localObject3[2]));
      SLog.e("EditPicActivityCropView", "[loadRectFromOrigin] marggin" + localObject3[0] + "  " + localObject3[1] + "  " + localObject3[2] + "  " + localObject3[3] + "result: l:" + this.jdField_e_of_type_AndroidGraphicsRect.left + "  right:" + this.jdField_e_of_type_AndroidGraphicsRect.right + "  top:" + this.jdField_e_of_type_AndroidGraphicsRect.top + "  bottom:" + this.jdField_e_of_type_AndroidGraphicsRect.bottom);
      SLog.b("EditPicActivityCropView", "resultRect : " + this.jdField_e_of_type_AndroidGraphicsRect);
      localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inSampleSize = 1;
    }
    return null;
  }
  
  private Rect a()
  {
    float f2;
    if (this.jdField_c_of_type_Boolean) {
      f2 = this.k;
    }
    for (float f1 = this.l;; f1 = this.k)
    {
      float f3 = this.jdField_d_of_type_Float / 2.0F;
      float f4 = f2 / 2.0F;
      float f5 = this.jdField_e_of_type_Float / 2.0F;
      float f6 = f1 / 2.0F;
      float f7 = this.jdField_d_of_type_Float / 2.0F;
      f2 /= 2.0F;
      float f8 = this.jdField_e_of_type_Float / 2.0F;
      f1 /= 2.0F;
      return new Rect((int)(f3 - f4 + 0.5F), (int)(f5 - f6 + 0.5F), (int)(f2 + f7 + 0.5F), (int)(f1 + f8 + 0.5F));
      f2 = this.l;
    }
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    int m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + paramFloat1);
    int n = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + paramFloat1);
    int i1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.top + paramFloat2);
    int i2 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramFloat2);
    if (m <= this.jdField_b_of_type_AndroidGraphicsRect.left)
    {
      paramFloat1 = this.jdField_b_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.left;
      if (i1 > this.jdField_b_of_type_AndroidGraphicsRect.top) {
        break label195;
      }
      paramFloat2 = this.jdField_b_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.top;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.offset((int)paramFloat1, (int)paramFloat2);
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener != null) && (paramFloat1 > 0.0F) && (paramFloat2 > 0.0F)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener.c();
      }
      return;
      if (this.jdField_b_of_type_AndroidGraphicsRect.right > n) {
        break;
      }
      paramFloat1 = this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right;
      break;
      label195:
      if (this.jdField_b_of_type_AndroidGraphicsRect.bottom <= i2) {
        paramFloat2 = this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      }
    }
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    int m;
    Rect localRect;
    if (paramInt == 1)
    {
      paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + paramFloat1);
      m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.top + paramFloat2);
      if ((paramInt + 64 < this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramInt >= this.jdField_b_of_type_AndroidGraphicsRect.left))
      {
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.left = ((int)(localRect.left + paramFloat1));
      }
      if ((m + 64 < this.jdField_a_of_type_AndroidGraphicsRect.bottom) && (m >= this.jdField_b_of_type_AndroidGraphicsRect.top))
      {
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.top = ((int)(localRect.top + paramFloat2));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener.c();
      }
      return;
      if (paramInt == 2)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + paramFloat1);
        m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.top + paramFloat2);
        if ((paramInt - 64 > this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramInt <= this.jdField_b_of_type_AndroidGraphicsRect.right))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
        if ((m + 64 < this.jdField_a_of_type_AndroidGraphicsRect.bottom) && (m >= this.jdField_b_of_type_AndroidGraphicsRect.top))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.top = ((int)(localRect.top + paramFloat2));
        }
      }
      else if (paramInt == 3)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + paramFloat1);
        m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramFloat2);
        if ((paramInt + 64 < this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramInt >= this.jdField_b_of_type_AndroidGraphicsRect.left))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.left = ((int)(localRect.left + paramFloat1));
        }
        if ((m - 64 > this.jdField_a_of_type_AndroidGraphicsRect.top) && (m <= this.jdField_b_of_type_AndroidGraphicsRect.bottom))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
      else if (paramInt == 4)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + paramFloat1);
        m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramFloat2);
        if ((paramInt - 64 > this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramInt <= this.jdField_b_of_type_AndroidGraphicsRect.right))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
        if ((m - 64 > this.jdField_a_of_type_AndroidGraphicsRect.top) && (m <= this.jdField_b_of_type_AndroidGraphicsRect.bottom))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
      else if (paramInt == 5)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + paramFloat1);
        if ((paramInt + 64 < this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramInt >= this.jdField_b_of_type_AndroidGraphicsRect.left))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.left = ((int)(localRect.left + paramFloat1));
        }
      }
      else if (paramInt == 7)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + paramFloat1);
        if ((paramInt - 64 > this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramInt <= this.jdField_b_of_type_AndroidGraphicsRect.right))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
      }
      else if (paramInt == 6)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.top + paramFloat2);
        if ((paramInt + 64 < this.jdField_a_of_type_AndroidGraphicsRect.bottom) && (paramInt >= this.jdField_b_of_type_AndroidGraphicsRect.top))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.top = ((int)(localRect.top + paramFloat2));
        }
      }
      else if (paramInt == 8)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramFloat2);
        if ((paramInt - 64 > this.jdField_a_of_type_AndroidGraphicsRect.top) && (paramInt <= this.jdField_b_of_type_AndroidGraphicsRect.bottom))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(160);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(255);
    paramCanvas.save();
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      return;
    }
    paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect, Region.Op.XOR);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    Path localPath = new Path();
    localPath.moveTo(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top);
    localPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top);
    localPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    localPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    localPath.close();
    paramCanvas.drawPath(localPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int m = (int)(0.07F * this.jdField_b_of_type_AndroidGraphicsRect.width() + 0.5F);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.left + m, this.jdField_a_of_type_AndroidGraphicsRect.top);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.right - m, this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top + m);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top + m);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.left + m, this.jdField_a_of_type_AndroidGraphicsRect.bottom + this.jdField_d_of_type_Int);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.right - m, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.bottom + this.jdField_d_of_type_Int);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m, this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.save();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(150);
    float f1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    float f2 = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() / 3;
    paramCanvas.drawLine(f1, f2, this.jdField_a_of_type_AndroidGraphicsRect.right, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
    f1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    f2 = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() / 3 * 2;
    paramCanvas.drawLine(f1, f2, this.jdField_a_of_type_AndroidGraphicsRect.right, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
    f1 = this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 3;
    paramCanvas.drawLine(f1, this.jdField_a_of_type_AndroidGraphicsRect.top, f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    f1 = this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 3 * 2;
    paramCanvas.drawLine(f1, this.jdField_a_of_type_AndroidGraphicsRect.top, f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(1.0F, 1.0F);
    float f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.h = Math.min(this.f / f1, this.g / f2);
    SLog.b("EditPicActivityCropView", "setBitmap scale : " + this.h);
    this.k = (f1 * this.h);
    this.l = (this.h * f2);
    SLog.b("EditPicActivityCropView", "setBitmap image width " + this.k + " image height " + this.l);
    this.jdField_a_of_type_AndroidGraphicsRect = a();
    this.jdField_b_of_type_AndroidGraphicsRect = a();
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.h, this.h);
    this.i = (this.jdField_d_of_type_Float / 2.0F);
    this.j = (this.jdField_e_of_type_Float / 2.0F);
    f1 = this.i;
    f2 = this.k / 2.0F;
    float f3 = this.j;
    float f4 = this.l / 2.0F;
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f1 - f2, f3 - f4);
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_e_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(1.0F, 1.0F);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      SLog.e("EditPicActivityCropView", "cropview rotate bitmap is null..");
      return;
    }
    float f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    float f3 = this.i;
    float f4 = f1 / 2.0F;
    float f5 = this.j;
    float f6 = f2 / 2.0F;
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f3 - f4, f5 - f6);
    this.jdField_b_of_type_Int += paramInt;
    this.jdField_b_of_type_Int %= 360;
    this.jdField_c_of_type_Int += paramInt;
    this.jdField_c_of_type_Int %= 360;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      label184:
      if (this.jdField_c_of_type_Boolean)
      {
        f3 = f1;
        label194:
        if (!this.jdField_c_of_type_Boolean) {
          break label455;
        }
        label201:
        if (f2 / f3 <= this.g / this.f) {
          break label460;
        }
      }
      break;
    }
    label455:
    label460:
    for (this.h = (this.g / f2);; this.h = (this.f / f3))
    {
      f1 = this.h;
      SLog.b("EditPicActivityCropView", "calculate picscale : " + this.h + " final : " + f1);
      this.k = (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.h);
      this.l = (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.h);
      this.jdField_a_of_type_AndroidGraphicsRect = a();
      this.jdField_b_of_type_AndroidGraphicsRect = a();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1, this.i, this.j);
      invalidate();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener == null) {
        break;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener.c();
      return;
      this.jdField_c_of_type_Boolean = true;
      break label184;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(90.0F, this.i, this.j);
      this.jdField_c_of_type_Boolean = false;
      break label184;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(180.0F, this.i, this.j);
      this.jdField_c_of_type_Boolean = true;
      break label184;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(270.0F, this.i, this.j);
      this.jdField_c_of_type_Boolean = false;
      break label184;
      f3 = f2;
      break label194;
      f2 = f1;
      break label201;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Float = paramInt1;
    this.jdField_e_of_type_Float = paramInt2;
    this.f = (paramInt1 - this.jdField_d_of_type_Int * 2);
    this.g = (paramInt2 - this.jdField_d_of_type_Int * 2);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOnTouchListener(this);
    this.jdField_d_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131559381);
    this.jdField_e_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131559380);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    Object localObject = new int[2];
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (this.jdField_e_of_type_AndroidGraphicsRect != null) {
      this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_e_of_type_AndroidGraphicsRect);
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {}
    do
    {
      return false;
      localObject = a((int[])localObject);
      if ((localObject != null) && (((Bitmap)localObject).getWidth() >= 64) && (((Bitmap)localObject).getHeight() >= 64)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivityCropView", 2, "too small " + localObject);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener.a(7);
      }
    } while (this.jdField_e_of_type_AndroidGraphicsRect == null);
    this.jdField_e_of_type_AndroidGraphicsRect.set(this.jdField_d_of_type_AndroidGraphicsRect);
    return false;
    if (localObject != null) {
      setBitmap((Bitmap)localObject);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener.a(localBitmap);
    }
    return true;
  }
  
  public float[] a()
  {
    float[] arrayOfFloat = new float[4];
    if (this.jdField_c_of_type_Int == 90)
    {
      arrayOfFloat[3] = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[0] = ((this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      arrayOfFloat[1] = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[2] = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      return arrayOfFloat;
    }
    if (this.jdField_c_of_type_Int == 270)
    {
      arrayOfFloat[1] = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[2] = ((this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      arrayOfFloat[3] = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[0] = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      return arrayOfFloat;
    }
    if (this.jdField_c_of_type_Int == 180)
    {
      arrayOfFloat[2] = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[3] = ((this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      arrayOfFloat[0] = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[1] = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      return arrayOfFloat;
    }
    arrayOfFloat[0] = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / this.jdField_b_of_type_AndroidGraphicsRect.width());
    arrayOfFloat[1] = ((this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height());
    arrayOfFloat[2] = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) / this.jdField_b_of_type_AndroidGraphicsRect.width());
    arrayOfFloat[3] = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / this.jdField_b_of_type_AndroidGraphicsRect.height());
    return arrayOfFloat;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001)
    {
      VideoEditReport.b("0X80075D1");
      a();
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
      a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2);
    b();
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      do
      {
        return false;
      } while (this.jdField_a_of_type_AndroidGraphicsRect == null);
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      this.jdField_c_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = a(paramMotionEvent);
      SLog.b("EditPicActivityCropView", "hitResizeCorner " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Boolean = a(paramMotionEvent);
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_d_of_type_Boolean = false;
      return true;
    case 5: 
    case 261: 
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_c_of_type_Float = 0.0F;
      return true;
    case 6: 
    case 262: 
      this.jdField_a_of_type_Boolean = false;
      return true;
    case 1: 
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 1000L);
      }
      return true;
    }
    if ((paramMotionEvent.getPointerCount() == 2) && (this.jdField_a_of_type_Int == 0))
    {
      f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      f2 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
      f3 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.jdField_a_of_type_Float = f1;
      }
    }
    while (paramMotionEvent.getPointerCount() != 1) {
      for (;;)
      {
        return true;
        if (this.jdField_b_of_type_Float == 0.0F)
        {
          this.jdField_b_of_type_Float = f2;
          this.jdField_c_of_type_Float = f3;
        }
        else if ((f1 - this.jdField_a_of_type_Float >= 10.0F) || (f1 - this.jdField_a_of_type_Float <= -10.0F))
        {
          f2 = f1 / this.jdField_a_of_type_Float;
          this.jdField_a_of_type_Float = f1;
          f1 = this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_a_of_type_AndroidGraphicsRect.width() * f2;
          f2 = this.jdField_a_of_type_AndroidGraphicsRect.height() - f2 * this.jdField_a_of_type_AndroidGraphicsRect.height();
          a(1, f1 / 2.0F, f2 / 2.0F);
          a(4, -f1 / 2.0F, -f2 / 2.0F);
          invalidate();
        }
      }
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = f1 - this.jdField_b_of_type_Float;
    float f4 = f2 - this.jdField_c_of_type_Float;
    if (this.jdField_a_of_type_Int != 0) {
      a(this.jdField_a_of_type_Int, f3, f4);
    }
    for (;;)
    {
      this.jdField_b_of_type_Float = f1;
      this.jdField_c_of_type_Float = f2;
      invalidate();
      break;
      if (this.jdField_a_of_type_Boolean) {
        a(f3, f4);
      }
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    if (this.jdField_d_of_type_Float == 0.0F) {
      return;
    }
    b();
    invalidate();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
  }
  
  public void setCropListener(CropView.CropListener paramCropListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView$CropListener = paramCropListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView
 * JD-Core Version:    0.7.0.1
 */