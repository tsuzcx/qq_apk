import org.apache.http.conn.ssl.AbstractVerifier;

public final class kog
  extends AbstractVerifier
{
  public kog(String paramString) {}
  
  public final String toString()
  {
    return "CUSTOM_COMPATIBLE";
  }
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    verify(this.a, paramArrayOfString1, paramArrayOfString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     kog
 * JD-Core Version:    0.7.0.1
 */