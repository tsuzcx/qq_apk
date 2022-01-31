import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class mqh
  extends mqi
{
  protected int a;
  protected int b;
  
  public static mqh a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, new mqh());
  }
  
  public static mqh a(ByteBuffer paramByteBuffer, mqh parammqh)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (paramByteBuffer.capacity() < paramByteBuffer.position() + 4) {
      return null;
    }
    return parammqh.a(paramByteBuffer.getInt(paramByteBuffer.position()) + paramByteBuffer.position(), paramByteBuffer);
  }
  
  private int b(int paramInt)
  {
    paramInt = (paramInt + 2) * 2;
    if (paramInt < this.b) {
      return this.jdField_a_of_type_JavaNioByteBuffer.getShort(paramInt + this.jdField_a_of_type_Int);
    }
    return 0;
  }
  
  public long a(int paramInt, long paramLong)
  {
    paramInt = b(paramInt);
    if (paramInt != 0) {
      paramLong = this.jdField_a_of_type_JavaNioByteBuffer.getLong(paramInt + this.c);
    }
    return paramLong;
  }
  
  public String a(int paramInt)
  {
    paramInt = b(paramInt);
    if (paramInt != 0) {
      return b(paramInt + this.c);
    }
    return null;
  }
  
  public mqg a(int paramInt)
  {
    return a(paramInt, new mqg());
  }
  
  public mqg a(int paramInt, mqg parammqg)
  {
    paramInt = b(paramInt);
    if (paramInt != 0) {
      return parammqg.a(a(paramInt + this.c), this.jdField_a_of_type_JavaNioByteBuffer);
    }
    return null;
  }
  
  public mqh a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((paramInt < 0) || (paramByteBuffer.capacity() < paramInt + 4)) {
      paramByteBuffer = null;
    }
    do
    {
      return paramByteBuffer;
      this.c = paramInt;
      this.jdField_a_of_type_JavaNioByteBuffer = paramByteBuffer;
      this.jdField_a_of_type_Int = (this.c - this.jdField_a_of_type_JavaNioByteBuffer.getInt(this.c));
      if (!a(this.jdField_a_of_type_Int, 2)) {
        return null;
      }
      this.b = this.jdField_a_of_type_JavaNioByteBuffer.getShort(this.jdField_a_of_type_Int);
      paramByteBuffer = this;
    } while (a(this.jdField_a_of_type_Int, this.b));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqh
 * JD-Core Version:    0.7.0.1
 */