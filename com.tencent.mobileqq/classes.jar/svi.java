import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;

public class svi
{
  public static final String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    paramString = new BigInteger(paramString.getBytes());
    return new BigInteger("51901").xor(paramString).toString(16);
  }
  
  public static byte[] a(boolean paramBoolean, byte[] paramArrayOfByte, String paramString)
  {
    int i = 128;
    Object localObject = "RSA";
    if (paramBoolean)
    {
      localObject = "RSA/ECB/PKCS1Padding";
      i = 117;
    }
    paramString = new X509EncodedKeySpec(bdbi.decode(paramString, 0));
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    localObject = Cipher.getInstance((String)localObject);
    ((Cipher)localObject).init(1, paramString);
    int k = paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = 0;
    if (k - j > 0)
    {
      if (k - j > i) {}
      for (paramString = ((Cipher)localObject).doFinal(paramArrayOfByte, j, i);; paramString = ((Cipher)localObject).doFinal(paramArrayOfByte, j, k - j))
      {
        localByteArrayOutputStream.write(paramString, 0, paramString.length);
        j += i;
        break;
      }
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject1 = localObject2;
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject2;
      localGZIPOutputStream.close();
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localObject1;
  }
  
  public static String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      if (localMessageDigest != null)
      {
        localMessageDigest.reset();
        localMessageDigest.update(paramString.getBytes());
        return bdje.a(localMessageDigest.digest());
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
        Object localObject = null;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svi
 * JD-Core Version:    0.7.0.1
 */