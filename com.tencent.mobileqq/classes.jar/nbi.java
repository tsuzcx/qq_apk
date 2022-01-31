import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class nbi
  extends nbj
{
  protected int a;
  protected int b;
  
  public static nbi a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, new nbi());
  }
  
  public static nbi a(ByteBuffer paramByteBuffer, nbi paramnbi)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (paramByteBuffer.capacity() < paramByteBuffer.position() + 4) {
      return null;
    }
    return paramnbi.a(paramByteBuffer.getInt(paramByteBuffer.position()) + paramByteBuffer.position(), paramByteBuffer);
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
  
  public nbh a(int paramInt)
  {
    return a(paramInt, new nbh());
  }
  
  public nbh a(int paramInt, nbh paramnbh)
  {
    paramInt = b(paramInt);
    if (paramInt != 0) {
      return paramnbh.a(a(paramInt + this.c), this.jdField_a_of_type_JavaNioByteBuffer);
    }
    return null;
  }
  
  public nbi a(int paramInt, ByteBuffer paramByteBuffer)
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
 * Qualified Name:     nbi
 * JD-Core Version:    0.7.0.1
 */