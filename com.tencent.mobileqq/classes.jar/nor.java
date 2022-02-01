import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class nor
{
  public static final ThreadLocal<Charset> a;
  private static final ThreadLocal<CharsetDecoder> b = new nos();
  private static final ThreadLocal<CharBuffer> c = new ThreadLocal();
  protected ByteBuffer a;
  protected int c;
  
  static
  {
    jdField_a_of_type_JavaLangThreadLocal = new not();
  }
  
  protected int a(int paramInt)
  {
    if (a(paramInt, 4)) {
      return this.jdField_a_of_type_JavaNioByteBuffer.getInt(paramInt) + paramInt;
    }
    return -1;
  }
  
  protected String a(int paramInt, boolean paramBoolean)
  {
    CharsetDecoder localCharsetDecoder = (CharsetDecoder)b.get();
    localCharsetDecoder.reset();
    int i = paramInt;
    if (!paramBoolean)
    {
      if (!a(paramInt, 4)) {
        return null;
      }
      i = paramInt + this.jdField_a_of_type_JavaNioByteBuffer.getInt(paramInt);
    }
    if (!a(i, 4)) {
      return null;
    }
    ByteBuffer localByteBuffer = this.jdField_a_of_type_JavaNioByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    paramInt = localByteBuffer.getInt(i);
    if (!a(i, paramInt + 4)) {
      return null;
    }
    localByteBuffer.position(i + 4);
    localByteBuffer.limit(i + 4 + paramInt);
    paramInt = (int)(paramInt * localCharsetDecoder.maxCharsPerByte());
    Object localObject2 = (CharBuffer)c.get();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((CharBuffer)localObject2).capacity() >= paramInt) {}
    }
    else
    {
      localObject1 = CharBuffer.allocate(paramInt);
      c.set(localObject1);
    }
    ((CharBuffer)localObject1).clear();
    try
    {
      localObject2 = localCharsetDecoder.decode(localByteBuffer, (CharBuffer)localObject1, true);
      if (!((CoderResult)localObject2).isUnderflow()) {
        ((CoderResult)localObject2).throwException();
      }
      return ((CharBuffer)localObject1).flip().toString();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FlatBuffersParser", 1, "convertString error", localThrowable);
    }
    return null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 + paramInt2 <= this.jdField_a_of_type_JavaNioByteBuffer.capacity());
  }
  
  protected String b(int paramInt)
  {
    return a(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nor
 * JD-Core Version:    0.7.0.1
 */