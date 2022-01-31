import com.tencent.biz.authorize.FlatBuffersConfig;
import java.io.File;
import java.nio.ByteBuffer;

public class klo
  implements Runnable
{
  public klo(FlatBuffersConfig paramFlatBuffersConfig, ByteBuffer paramByteBuffer, File paramFile, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || (this.jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig.a(this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Boolean))) {
        return;
      }
      try
      {
        Thread.sleep(100L);
        label36:
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label36;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klo
 * JD-Core Version:    0.7.0.1
 */