import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class naw
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public byte[] a()
  {
    if (TextUtils.isEmpty(this.a)) {}
    do
    {
      return null;
      try
      {
        byte[] arrayOfByte = this.a.getBytes("ISO-8859-1");
        return arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AnonymousChatHelper", 2, "getByteAnId UnsupportedEncodingException");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     naw
 * JD-Core Version:    0.7.0.1
 */