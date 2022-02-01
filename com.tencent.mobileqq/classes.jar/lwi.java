import com.tencent.qphone.base.util.QLog;

public class lwi
{
  public int a;
  public final lwf a;
  public int b;
  public int c;
  private int d;
  
  lwi()
  {
    this.jdField_a_of_type_Lwf = new lwf();
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, lwf paramlwf)
  {
    this.d += 1;
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2) || (!this.jdField_a_of_type_Lwf.equals(paramlwf)) || (this.c != paramInt3)) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("updateFrame, frameIndex[").append(this.d).append("], data[");
        if (paramArrayOfByte != null) {
          break label198;
        }
      }
    }
    label198:
    for (paramArrayOfByte = "null";; paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length))
    {
      QLog.i("AVShare", 2, paramArrayOfByte + "], imgFormat[" + this.b + "-->" + paramInt2 + "], recordParam[" + this.jdField_a_of_type_Lwf + "--->" + paramlwf + "], angle[" + this.c + "-->" + paramInt3 + "]");
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      this.jdField_a_of_type_Lwf.a(paramlwf);
      this.c = paramInt3;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lwi
 * JD-Core Version:    0.7.0.1
 */