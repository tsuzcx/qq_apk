import java.nio.ByteBuffer;

public class nbh
  extends nbj
{
  public int a;
  
  public byte a(int paramInt)
  {
    paramInt = this.c + paramInt;
    if (a(paramInt, 1)) {
      return this.jdField_a_of_type_JavaNioByteBuffer.get(paramInt);
    }
    return 0;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return a(this.c - 4, true);
  }
  
  public String a(int paramInt)
  {
    return b(this.c + paramInt * 4);
  }
  
  public nbh a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((paramInt < 0) || (paramByteBuffer.capacity() < paramInt + 4)) {
      return null;
    }
    this.jdField_a_of_type_Int = paramByteBuffer.getInt(paramInt);
    this.c = (paramInt + 4);
    this.jdField_a_of_type_JavaNioByteBuffer = paramByteBuffer;
    return this;
  }
  
  public nbh a(int paramInt, nbh paramnbh)
  {
    return paramnbh.a(a(this.c + paramInt * 4), this.jdField_a_of_type_JavaNioByteBuffer);
  }
  
  public nbi a(int paramInt)
  {
    return a(paramInt, new nbi());
  }
  
  public nbi a(int paramInt, nbi paramnbi)
  {
    return paramnbi.a(a(this.c + paramInt * 4), this.jdField_a_of_type_JavaNioByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbh
 * JD-Core Version:    0.7.0.1
 */