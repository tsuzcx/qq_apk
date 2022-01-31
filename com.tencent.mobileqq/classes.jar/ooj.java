import java.security.SecureRandom;
import javax.crypto.spec.IvParameterSpec;

public class ooj
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private SecureRandom jdField_a_of_type_JavaSecuritySecureRandom;
  private IvParameterSpec jdField_a_of_type_JavaxCryptoSpecIvParameterSpec;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  private int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private String a()
  {
    return this.e;
  }
  
  private SecureRandom a()
  {
    return this.jdField_a_of_type_JavaSecuritySecureRandom;
  }
  
  private IvParameterSpec a()
  {
    return this.jdField_a_of_type_JavaxCryptoSpecIvParameterSpec;
  }
  
  public static ooj a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return new ooj().a(paramArrayOfByte).f(paramString1).e(paramString2).b(128).c("AES").a("UTF8").c(1).h("SHA1").a(0).b("AES/CBC/PKCS5Padding").g("SHA1PRNG").d("PBKDF2WithHmacSHA1");
  }
  
  private byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  private int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  private int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  private String c()
  {
    return this.d;
  }
  
  private String d()
  {
    return this.f;
  }
  
  private String e()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  private String f()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  private String g()
  {
    return this.h;
  }
  
  private String h()
  {
    return this.g;
  }
  
  public ooi a()
  {
    a(SecureRandom.getInstance(g()));
    a(new IvParameterSpec(a()));
    return new ooi(this, null);
  }
  
  public ooj a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ooj a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public ooj a(SecureRandom paramSecureRandom)
  {
    this.jdField_a_of_type_JavaSecuritySecureRandom = paramSecureRandom;
    return this;
  }
  
  public ooj a(IvParameterSpec paramIvParameterSpec)
  {
    this.jdField_a_of_type_JavaxCryptoSpecIvParameterSpec = paramIvParameterSpec;
    return this;
  }
  
  public ooj a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return this;
  }
  
  public ooj b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ooj b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ooj c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public ooj c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public ooj d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public ooj e(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ooj f(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ooj g(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public ooj h(String paramString)
  {
    this.g = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooj
 * JD-Core Version:    0.7.0.1
 */