import com.tencent.qphone.base.util.QLog;

public class lyk
{
  public int a;
  public final lyh a;
  public int b;
  public int c;
  private int d;
  
  lyk()
  {
    this.jdField_a_of_type_Lyh = new lyh();
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, lyh paramlyh)
  {
    this.d += 1;
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2) || (!this.jdField_a_of_type_Lyh.equals(paramlyh)) || (this.c != paramInt3)) {
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
      QLog.i("AVShare", 2, paramArrayOfByte + "], imgFormat[" + this.b + "-->" + paramInt2 + "], recordParam[" + this.jdField_a_of_type_Lyh + "--->" + paramlyh + "], angle[" + this.c + "-->" + paramInt3 + "]");
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      this.jdField_a_of_type_Lyh.a(paramlyh);
      this.c = paramInt3;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lyk
 * JD-Core Version:    0.7.0.1
 */