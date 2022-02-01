import org.apache.http.conn.ssl.AbstractVerifier;

final class nns
  extends AbstractVerifier
{
  nns(String paramString) {}
  
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
 * Qualified Name:     nns
 * JD-Core Version:    0.7.0.1
 */