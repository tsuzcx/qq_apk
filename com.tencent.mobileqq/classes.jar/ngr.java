import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.view.View;
import com.tencent.avgame.videorecord.GuessPictureGamePaintLogic.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ngr
{
  public int a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ngm jdField_a_of_type_Ngm;
  private volatile boolean jdField_a_of_type_Boolean;
  public int b;
  private int c;
  private int d;
  
  public int a(ArrayList<ngm> paramArrayList)
  {
    boolean bool = false;
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (((ngm)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return 0;
    }
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.b, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    a(localCanvas, (ngm)paramArrayList.get(0), true);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_Ngm == null) {
          bool = true;
        }
        QLog.d("GuessPictureGamePaintLogic", 2, new Object[] { "generateTexture, AnswerImageDataIsNull:", Boolean.valueOf(bool) });
      }
      if (this.jdField_a_of_type_Ngm != null)
      {
        localCanvas.drawColor(this.jdField_a_of_type_Ngm.e);
        b(localCanvas, this.jdField_a_of_type_Ngm, true);
      }
      int i;
      do
      {
        i = GlUtil.createTexture(3553, localBitmap);
        localBitmap.recycle();
        return i;
        i = 1;
      } while (i >= paramArrayList.size());
      b(localCanvas, (ngm)paramArrayList.get(i), true);
      i += 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.b = paramInt4;
  }
  
  public void a(Canvas paramCanvas, ngm paramngm, boolean paramBoolean)
  {
    paramngm = paramngm.jdField_a_of_type_AndroidGraphicsBitmap;
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(new RectF(0.0F, 0.0F, paramngm.getWidth(), paramngm.getHeight()), new RectF(0.0F, 0.0F, this.jdField_a_of_type_Int, this.b), Matrix.ScaleToFit.FILL);
    if (paramBoolean) {
      localMatrix.postScale(1.0F, -1.0F, this.jdField_a_of_type_Int / 2, this.b / 2);
    }
    if (!paramngm.isRecycled()) {
      paramCanvas.drawBitmap(paramngm, localMatrix, null);
    }
  }
  
  public void a(View arg1)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Ngm != null) && (!this.jdField_a_of_type_Ngm.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_Ngm.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Ngm = null;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().postDelayed(new GuessPictureGamePaintLogic.1(this, paramView, paramInt, paramBoolean), 200L);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Ngm != null) && (this.jdField_a_of_type_Ngm.jdField_a_of_type_Boolean);
  }
  
  public void b(Canvas paramCanvas, ngm paramngm, boolean paramBoolean)
  {
    if (paramngm.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    Matrix localMatrix;
    do
    {
      return;
      int i = paramngm.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      int j = paramngm.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      float f1 = this.c / this.jdField_a_of_type_Int;
      float f2 = this.d / this.b;
      localMatrix = new Matrix();
      localMatrix.setRectToRect(new RectF(0.0F, 0.0F, i, j), new RectF(paramngm.c / f1, paramngm.d / f2, (i + paramngm.c) / f1, (j + paramngm.d) / f2), Matrix.ScaleToFit.CENTER);
      if (paramBoolean) {
        localMatrix.postScale(1.0F, -1.0F, this.jdField_a_of_type_Int / 2, this.b / 2);
      }
    } while (paramngm.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled());
    paramCanvas.drawBitmap(paramngm.jdField_a_of_type_AndroidGraphicsBitmap, localMatrix, null);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ngr
 * JD-Core Version:    0.7.0.1
 */