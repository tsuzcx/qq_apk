import android.graphics.PointF;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.nio.ByteBuffer;
import java.util.List;

public class lqc
{
  public int a;
  public List<PointF> a;
  public short a;
  public byte[] a;
  public float[] a;
  public int b;
  public short b;
  public byte[] b;
  public int c;
  public byte[] c;
  
  public lqc()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
  }
  
  private byte[] a(int paramInt1, int paramInt2, float paramFloat)
  {
    PointF localPointF = null;
    Object localObject = localPointF;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = localPointF;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject = localPointF;
        if (paramInt1 != 0)
        {
          localObject = localPointF;
          if (paramInt2 != 0)
          {
            localObject = localPointF;
            if (paramFloat > 0.0001D)
            {
              float f = 240.0F / (paramInt1 * paramFloat);
              paramFloat = 320.0F / (paramInt2 * paramFloat);
              lcl.c("FaceData", "getFaceFeature:" + paramInt1 + "|" + paramInt2 + "|" + f);
              localObject = ByteBuffer.allocate(this.jdField_a_of_type_JavaUtilList.size() * 4);
              paramInt1 = 0;
              while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
              {
                localPointF = (PointF)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
                short s1 = (short)(int)(localPointF.x * f);
                short s2 = (short)(int)(localPointF.y * paramFloat);
                ((ByteBuffer)localObject).putShort(s1);
                ((ByteBuffer)localObject).putShort(s2);
                paramInt1 += 1;
              }
              localObject = ((ByteBuffer)localObject).array();
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private byte[] b(int paramInt1, int paramInt2, float paramFloat)
  {
    PointF localPointF = null;
    Object localObject = localPointF;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = localPointF;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject = localPointF;
        if (paramInt1 != 0)
        {
          localObject = localPointF;
          if (paramInt2 != 0)
          {
            localObject = localPointF;
            if (paramFloat > 0.0001D)
            {
              float f = 2.4E+008F / (paramInt1 * paramFloat);
              paramFloat = 3.2E+008F / (paramInt2 * paramFloat);
              lcl.c("FaceData", "getFaceFeature2:" + paramInt1 + "|" + paramInt2 + "|" + f);
              localObject = ByteBuffer.allocate(this.jdField_a_of_type_JavaUtilList.size() * 8);
              paramInt1 = 0;
              while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
              {
                localPointF = (PointF)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
                paramInt2 = (int)(localPointF.x * f);
                int i = (int)(localPointF.y * paramFloat);
                ((ByteBuffer)localObject).putInt(paramInt2);
                ((ByteBuffer)localObject).putInt(i);
                paramInt1 += 1;
              }
              localObject = ((ByteBuffer)localObject).array();
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
  }
  
  public void a(PTFaceAttr paramPTFaceAttr, float paramFloat, boolean paramBoolean)
  {
    if (paramPTFaceAttr != null)
    {
      this.jdField_a_of_type_Int = paramPTFaceAttr.getFaceCount();
      if ((this.jdField_a_of_type_Int > 0) && (paramPTFaceAttr != null))
      {
        if (paramBoolean) {
          break label104;
        }
        this.jdField_a_of_type_JavaUtilList = ((List)paramPTFaceAttr.getAllFacePoints().get(0));
        this.jdField_a_of_type_ArrayOfFloat = ((float[])paramPTFaceAttr.getAllFaceAngles().get(0));
        this.jdField_a_of_type_ArrayOfByte = a(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, paramFloat);
        this.jdField_b_of_type_ArrayOfByte = b(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, paramFloat);
      }
    }
    label104:
    do
    {
      return;
      this.jdField_a_of_type_Int = 0;
      break;
      paramPTFaceAttr = paramPTFaceAttr.genOrigFaceData();
    } while (paramPTFaceAttr == null);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramPTFaceAttr.getBytes().length + 4);
    this.jdField_a_of_type_Short = ((short)(int)(this.jdField_c_of_type_Int * paramFloat));
    this.jdField_b_of_type_Short = ((short)(int)(this.jdField_b_of_type_Int * paramFloat));
    localByteBuffer.put(new byte[] { (byte)(this.jdField_b_of_type_Short >> 8), (byte)(this.jdField_b_of_type_Short >> 0), (byte)(this.jdField_a_of_type_Short >> 8), (byte)(this.jdField_a_of_type_Short >> 0) });
    localByteBuffer.put(paramPTFaceAttr.getBytes());
    this.jdField_c_of_type_ArrayOfByte = localByteBuffer.array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqc
 * JD-Core Version:    0.7.0.1
 */