import com.tencent.qphone.base.util.Cryptor;

public class lcv
{
  private final String a = "ZaDA32%dkn_vs4dAjg";
  
  protected String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new String(new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2));
  }
  
  protected byte[] a()
  {
    return "ZaDA32%dkn_vs4dAjg".getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lcv
 * JD-Core Version:    0.7.0.1
 */