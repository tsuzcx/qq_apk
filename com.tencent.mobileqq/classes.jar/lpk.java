import android.util.SparseArray;

public class lpk
{
  public short a;
  public byte[] a;
  public short b = 240;
  public short c;
  public short d;
  
  public lpk(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Short = 320;
    paramArrayOfByte = leq.a(paramArrayOfByte);
    lep locallep = (lep)paramArrayOfByte.get(4);
    if (locallep != null) {
      this.jdField_a_of_type_ArrayOfByte = locallep.a();
    }
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      paramArrayOfByte = (lep)paramArrayOfByte.get(3);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.a();
        this.b = ((short)(paramArrayOfByte[0] << 8 | paramArrayOfByte[1] & 0xFF));
        this.jdField_a_of_type_Short = ((short)(paramArrayOfByte[2] << 8 | paramArrayOfByte[3] & 0xFF));
        this.c = ((short)(paramArrayOfByte[4] << 8 | paramArrayOfByte[5] & 0xFF));
        int i = paramArrayOfByte[6];
        this.d = ((short)(paramArrayOfByte[7] & 0xFF | i << 8));
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SwitchFaceItem face.length = ");
    if (this.jdField_a_of_type_ArrayOfByte != null) {}
    for (int i = this.jdField_a_of_type_ArrayOfByte.length;; i = 0) {
      return i + ", width = " + this.jdField_a_of_type_Short + ", height = " + this.b + ", fameWidth = " + this.c + ", frameHeight = " + this.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpk
 * JD-Core Version:    0.7.0.1
 */