package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.request.t;

public class EcdhCrypt
{
  public static final String DEFAULT_PUB_KEY = "04edb8906046f5bfbe9abbc5a88b37d70a6006bfbabc1f0cd49dfb33505e63efc5d78ee4e0a4595033b93d02096dcd3190279211f7b4f6785079e19004aa0e03bc";
  public static final String DEFAULT_SHARE_KEY = "c129edba736f4909ecc4ab8e010f46a3";
  static String SvrPubKey = "04EBCA94D733E399B2DB96EACDD3F69A8BB0F74224E2B44E3357812211D2E62EFBC91BB553098E25E33A799ADC7F76FEB208DA7C6522CDB0719A305180CC54A82E";
  static final String X509Prefix = "3059301306072a8648ce3d020106082a8648ce3d030107034200";
  public static byte[] _c_pri_key = new byte[0];
  public static byte[] _c_pub_key = new byte[0];
  private static byte[] _g_share_key = new byte[0];
  private static boolean initFlg = false;
  public static PrivateKey pkcs8PrivateKey;
  private static int sKeyVersion = 1;
  private static boolean userOpenSSLLib = true;
  public static PublicKey x509PublicKey;
  
  public EcdhCrypt(Context paramContext)
  {
    util.loadLibrary("wtecdh", paramContext);
  }
  
  private byte[] calShareKeyByBouncycastle(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject1 = util.buf_to_string(paramArrayOfByte);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("3059301306072a8648ce3d020106082a8648ce3d030107034200");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = constructX509PublicKey(((StringBuilder)localObject2).toString());
      localObject2 = KeyAgreement.getInstance("ECDH", "BC");
      ((KeyAgreement)localObject2).init(pkcs8PrivateKey);
      ((KeyAgreement)localObject2).doPhase((Key)localObject1, true);
      localObject1 = ((KeyAgreement)localObject2).generateSecret();
      localObject2 = new byte[16];
      System.arraycopy(localObject1, 0, localObject2, 0, 16);
      localObject1 = MD5.toMD5Byte((byte[])localObject2);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("calShareKeyByBouncycastle failed ");
      ((StringBuilder)localObject2).append(pkcs8PrivateKey.toString());
      ((StringBuilder)localObject2).append(" peer public key ");
      ((StringBuilder)localObject2).append(util.buf_to_string(paramArrayOfByte));
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      util.printThrowable(localThrowable, "calShareKeyByBouncycastle");
      t.at.attr_api(2459818);
      return null;
    }
    catch (ExceptionInInitializerError paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create key failed ExceptionInInitializerError, ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      util.LOGW(localStringBuilder.toString(), "");
      t.at.attr_api(2459818);
    }
    return null;
  }
  
  private byte[] calShareKeyByOpenSSL(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("calShareKeyByOpenSSL publickey ");
    localStringBuilder.append(paramString2);
    util.LOGI(localStringBuilder.toString(), "");
    if (GenECDHKeyEx(paramString3, paramString2, paramString1) == 0) {
      return _g_share_key;
    }
    t.at.attr_api(2461268);
    return null;
  }
  
  private PublicKey constructX509PublicKey(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("constructX509PublicKey publickey ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" at ");
    localStringBuilder.append(t.m());
    util.LOGI(localStringBuilder.toString(), "");
    return KeyFactory.getInstance("EC", "BC").generatePublic(new X509EncodedKeySpec(util.string_to_buf(paramString)));
  }
  
  private int initShareKeyByBouncycastle()
  {
    try
    {
      Object localObject1 = util.buf_to_string(util.string_to_buf(SvrPubKey));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("3059301306072a8648ce3d020106082a8648ce3d030107034200");
      ((StringBuilder)localObject2).append((String)localObject1);
      Object localObject4 = ((StringBuilder)localObject2).toString();
      localObject1 = KeyPairGenerator.getInstance("EC", "BC");
      ((KeyPairGenerator)localObject1).initialize(new ECGenParameterSpec("prime256v1"));
      Object localObject3 = ((KeyPairGenerator)localObject1).genKeyPair();
      localObject1 = ((KeyPair)localObject3).getPublic();
      localObject2 = ((PublicKey)localObject1).getEncoded();
      localObject3 = ((KeyPair)localObject3).getPrivate();
      ((PrivateKey)localObject3).getEncoded();
      localObject4 = constructX509PublicKey((String)localObject4);
      Object localObject5 = KeyAgreement.getInstance("ECDH", "BC");
      ((KeyAgreement)localObject5).init((Key)localObject3);
      ((KeyAgreement)localObject5).doPhase((Key)localObject4, true);
      localObject4 = ((KeyAgreement)localObject5).generateSecret();
      localObject5 = new byte[16];
      System.arraycopy(localObject4, 0, localObject5, 0, 16);
      _g_share_key = MD5.toMD5Byte((byte[])localObject5);
      _c_pub_key = new byte[65];
      System.arraycopy(localObject2, 26, _c_pub_key, 0, 65);
      x509PublicKey = (PublicKey)localObject1;
      pkcs8PrivateKey = (PrivateKey)localObject3;
      util.LOGI("initShareKeyByBouncycastle OK", "");
      return 0;
    }
    catch (Throwable localThrowable)
    {
      util.LOGI("initShareKeyByBouncycastle failed, ", "");
      util.printThrowable(localThrowable, "initShareKeyByBouncycastle");
      t.at.attr_api(2368735);
      return -2;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("create key pair and shared key failed ExceptionInInitializerError, ");
      ((StringBuilder)localObject2).append(localExceptionInInitializerError.getMessage());
      util.LOGW(((StringBuilder)localObject2).toString(), "");
      t.at.attr_api(2368735);
    }
    return -1;
  }
  
  private int initShareKeyByOpenSSL()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return -1;
    }
    if (GenereateKey() != 0) {
      return -1;
    }
    Object localObject = _c_pub_key;
    if ((localObject != null) && (localObject.length != 0))
    {
      localObject = _c_pri_key;
      if ((localObject != null) && (localObject.length != 0))
      {
        localObject = _g_share_key;
        if ((localObject != null) && (localObject.length != 0))
        {
          util.LOGI("initShareKeyByOpenSSL OK", "");
          return 0;
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_c_pub_key ");
    ((StringBuilder)localObject).append(util.buf_to_string(_c_pub_key));
    util.LOGI(((StringBuilder)localObject).toString(), "");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_c_pri_key ");
    ((StringBuilder)localObject).append(util.buf_to_string(_c_pri_key));
    util.LOGI(((StringBuilder)localObject).toString(), "");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_g_share_key ");
    ((StringBuilder)localObject).append(util.buf_to_string(_g_share_key));
    util.LOGI(((StringBuilder)localObject).toString(), "");
    util.LOGI("initShareKeyByOpenSSL generate null key", "");
    return -2;
  }
  
  public native int GenECDHKeyEx(String paramString1, String paramString2, String paramString3);
  
  public int GenereateKey()
  {
    try
    {
      try
      {
        int i = GenECDHKeyEx(SvrPubKey, "", "");
        return i;
      }
      finally {}
      StringBuilder localStringBuilder;
      return -1;
    }
    catch (Error localError)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("GenereateKey failed ");
      localStringBuilder.append(localError.getMessage());
      util.LOGI(localStringBuilder.toString(), "");
      return -4;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("GenereateKey failed ");
      localStringBuilder.append(localException.getMessage());
      util.LOGI(localStringBuilder.toString(), "");
      return -3;
    }
    catch (RuntimeException localRuntimeException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OpenSSL generate key failed, turn another method ");
      localStringBuilder.append(localRuntimeException.getMessage());
      util.LOGW(localStringBuilder.toString(), "");
      return -2;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("GenereateKey failed ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      util.LOGI(localStringBuilder.toString(), "");
    }
  }
  
  public byte[] calShareKeyMd5ByPeerPublicKey(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("userOpenSSLLib ");
    localStringBuilder.append(userOpenSSLLib);
    localStringBuilder.append(" peerRawPublicKey ");
    localStringBuilder.append(util.buf_to_string(paramArrayOfByte));
    localStringBuilder.append(" at ");
    localStringBuilder.append(t.m());
    util.LOGI(localStringBuilder.toString(), "");
    if (true == userOpenSSLLib) {
      return calShareKeyByOpenSSL(util.buf_to_string(_c_pri_key), util.buf_to_string(_c_pub_key), util.buf_to_string(paramArrayOfByte));
    }
    return calShareKeyByBouncycastle(paramArrayOfByte);
  }
  
  public byte[] get_c_pub_key()
  {
    return (byte[])_c_pub_key.clone();
  }
  
  public byte[] get_g_share_key()
  {
    return (byte[])_g_share_key.clone();
  }
  
  public int get_pub_key_ver()
  {
    return sKeyVersion;
  }
  
  public int initShareKey()
  {
    if (true == initFlg) {
      return 0;
    }
    initFlg = true;
    if (initShareKeyByOpenSSL() == 0)
    {
      userOpenSSLLib = true;
      return 0;
    }
    if (initShareKeyByBouncycastle() == 0)
    {
      userOpenSSLLib = false;
      return 0;
    }
    return initShareKeyByDefault();
  }
  
  public int initShareKeyByDefault()
  {
    _c_pub_key = util.string_to_buf("04edb8906046f5bfbe9abbc5a88b37d70a6006bfbabc1f0cd49dfb33505e63efc5d78ee4e0a4595033b93d02096dcd3190279211f7b4f6785079e19004aa0e03bc");
    _g_share_key = util.string_to_buf("c129edba736f4909ecc4ab8e010f46a3");
    util.LOGI("initShareKeyByDefault OK", "");
    return 0;
  }
  
  public void setPubKey(String paramString, int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPubKey ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ver:");
      localStringBuilder.append(paramInt);
      util.LOGI(localStringBuilder.toString(), "");
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramInt <= 0) {
          return;
        }
        SvrPubKey = paramString;
        sKeyVersion = paramInt;
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      util.printThrowable(paramString, "setPubKey");
    }
  }
  
  public void set_c_pri_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _c_pri_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _c_pri_key = new byte[0];
  }
  
  public void set_c_pub_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _c_pub_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _c_pub_key = new byte[0];
  }
  
  public void set_g_share_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _g_share_key = (byte[])paramArrayOfByte.clone();
      return;
    }
    _g_share_key = new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.EcdhCrypt
 * JD-Core Version:    0.7.0.1
 */