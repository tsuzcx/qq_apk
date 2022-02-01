import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.RGBATexSaveProcess;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.Arrays;
import java.util.List;

public class lzv
{
  public float a;
  public int a;
  public RectF a;
  public Frame a;
  public List<PointF> a;
  public byte[] a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d;
  public float e;
  public float f;
  
  public lzv()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_Float = 0.5F;
    this.jdField_b_of_type_Float = 0.5F;
    this.jdField_c_of_type_Float = 0.5F;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 80) && (paramInt2 <= 80) && (paramInt3 <= 80)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return false;
      } while (((paramInt1 < 230) && (paramInt2 < 230) && (paramInt3 < 230) && ((paramInt3 >= paramInt2) || (paramInt2 >= paramInt1))) || (paramInt1 + paramInt2 > 400));
      l1 = 12800 - paramInt1 * 32 + paramInt2 * 48 - paramInt3 * 12;
      l2 = paramInt1 * 44 + 12800 - paramInt2 * 37 - paramInt3 * 7;
    } while ((l1 < 8500L) || (l1 > 13500L) || (l2 < 26000L - l1) || (l2 > 28000L - l1));
    return true;
  }
  
  public void a()
  {
    int m = 0;
    int n = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    if (m < this.jdField_a_of_type_ArrayOfByte.length)
    {
      int i11 = this.jdField_a_of_type_ArrayOfByte[m] & 0xFF;
      int i10 = this.jdField_a_of_type_ArrayOfByte[(m + 1)] & 0xFF;
      int i9 = this.jdField_a_of_type_ArrayOfByte[(m + 2)] & 0xFF;
      int i4 = (m >> 2) / 240;
      if ((this.jdField_a_of_type_AndroidGraphicsRectF.contains((m >> 2) % 240, i4)) && (a(i11, i10, i9))) {}
      for (int i8 = 1;; i8 = 0)
      {
        int i7 = n;
        int i6 = i1;
        int i5 = i2;
        i4 = i3;
        if (i8 != 0)
        {
          i4 = i3 + i11;
          i5 = i2 + i10;
          i6 = i1 + i9;
          i7 = n + 1;
        }
        k += i11;
        j += i10;
        i += i9;
        m += 4;
        n = i7;
        i1 = i6;
        i2 = i5;
        i3 = i4;
        break;
      }
    }
    float f3;
    float f2;
    if (n == 0)
    {
      f1 = (this.jdField_a_of_type_ArrayOfByte.length >> 2) * 255;
      f3 = k / f1;
      f2 = j / f1;
    }
    for (float f1 = i / f1;; f1 = i1 / f1)
    {
      this.jdField_a_of_type_Float = f3;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f1;
      return;
      f1 = n * 255;
      f3 = i3 / f1;
      f2 = i2 / f1;
    }
  }
  
  public void a(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    float f1 = 320.0F / Math.max(paramInt1, paramInt2);
    paramList = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList));
    float[] arrayOfFloat1 = new float[4];
    arrayOfFloat1[0] = ((PointF)paramList.get(99)).x;
    arrayOfFloat1[1] = ((PointF)paramList.get(101)).x;
    arrayOfFloat1[2] = ((PointF)paramList.get(103)).x;
    arrayOfFloat1[3] = ((PointF)paramList.get(105)).x;
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = ((PointF)paramList.get(99)).y;
    arrayOfFloat2[1] = ((PointF)paramList.get(101)).y;
    arrayOfFloat2[2] = ((PointF)paramList.get(103)).y;
    arrayOfFloat2[3] = ((PointF)paramList.get(105)).y;
    Arrays.sort(arrayOfFloat1);
    Arrays.sort(arrayOfFloat2);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (arrayOfFloat1[0] * f1);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (arrayOfFloat1[3] * f1);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (arrayOfFloat2[0] * f1);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (f1 * arrayOfFloat2[3]);
  }
  
  public boolean a(RGBATexSaveProcess paramRGBATexSaveProcess)
  {
    float f1 = 320.0F / Math.max(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    int i = (int)(this.jdField_b_of_type_Int * f1);
    int j = (int)(f1 * this.jdField_c_of_type_Int);
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != i * j * 4)) {
      this.jdField_a_of_type_ArrayOfByte = new byte[i * j * 4];
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwitchFaceProcessorItem", 2, "WL_DEBUG retrieveData w=" + i + "h=" + j);
    }
    this.jdField_a_of_type_ArrayOfByte = paramRGBATexSaveProcess.retrieveData(this.jdField_a_of_type_Int, i, j);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzv
 * JD-Core Version:    0.7.0.1
 */