import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class ooi
{
  private final ooj a;
  
  private ooi(ooj paramooj)
  {
    this.a = paramooj;
  }
  
  private SecretKey a(char[] paramArrayOfChar)
  {
    return new SecretKeySpec(SecretKeyFactory.getInstance(ooj.d(this.a)).generateSecret(new PBEKeySpec(paramArrayOfChar, ooj.e(this.a).getBytes(ooj.b(this.a)), ooj.b(this.a), ooj.c(this.a))).getEncoded(), ooj.f(this.a));
  }
  
  public static ooi a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      paramString1 = ooj.a(paramString1, paramString2, paramArrayOfByte).a();
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1) {}
    return null;
  }
  
  private char[] a(String paramString)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance(ooj.g(this.a));
    localMessageDigest.update(paramString.getBytes(ooj.b(this.a)));
    return baaw.encodeToString(localMessageDigest.digest(), 1).toCharArray();
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    SecretKey localSecretKey = a(a(ooj.a(this.a)));
    paramString = paramString.getBytes(ooj.b(this.a));
    Cipher localCipher = Cipher.getInstance(ooj.c(this.a));
    localCipher.init(1, localSecretKey, ooj.a(this.a), ooj.a(this.a));
    return baaw.encodeToString(localCipher.doFinal(paramString), ooj.a(this.a));
  }
  
  public String b(String paramString)
  {
    try
    {
      paramString = a(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = baaw.decode(paramString, ooj.a(this.a));
    SecretKey localSecretKey = a(a(ooj.a(this.a)));
    Cipher localCipher = Cipher.getInstance(ooj.c(this.a));
    localCipher.init(2, localSecretKey, ooj.a(this.a), ooj.a(this.a));
    return new String(localCipher.doFinal(paramString));
  }
  
  public String d(String paramString)
  {
    try
    {
      paramString = c(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooi
 * JD-Core Version:    0.7.0.1
 */