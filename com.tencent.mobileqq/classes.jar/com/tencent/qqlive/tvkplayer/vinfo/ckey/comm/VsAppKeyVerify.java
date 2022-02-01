package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class VsAppKeyVerify
{
  private static final int BLOCK_SIZE = 373;
  private static final int KEY_SIZE = 384;
  private static final byte[] PUBLIC_KEY = { 48, -126, 1, -94, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, -113, 0, 48, -126, 1, -118, 2, -126, 1, -127, 0, -66, -78, -88, -127, 116, 46, 31, 74, 52, 37, -63, -20, 44, -87, -60, -86, -66, -8, 53, 53, -80, 35, -122, 122, -26, 68, -32, -45, -4, -1, 59, -105, 88, 77, 102, -44, -27, 88, 25, 80, -59, -90, -41, 93, 48, 8, -121, 115, -93, 60, 127, -57, -120, -30, 8, -11, -12, 97, -81, -36, 106, -59, 5, -21, 10, 86, 92, 106, 12, 87, -35, -22, 88, 29, -87, -32, 67, -63, -101, 24, -46, 52, -68, 99, -60, -8, 19, 89, -13, -78, 50, -34, 47, -44, 66, -57, -53, -45, -109, -80, 87, -59, -87, -77, -48, -41, 4, -92, 72, -76, 4, -97, -78, 126, -47, -108, -122, -59, -106, 87, -79, 73, -92, -66, -27, 9, -63, -33, -49, -63, 91, -69, -12, 40, -21, 9, 84, -103, -78, 9, -26, -87, -54, 101, 42, -10, -43, -87, -124, -4, 7, -52, -63, -86, 124, -9, -108, -121, 1, 120, -62, 13, 89, -117, -72, -119, -34, -116, -126, 8, -111, 16, 103, 52, -18, 60, 63, 85, 22, 28, -69, -10, 60, 19, -59, 10, -111, 23, -38, -7, -68, 79, 75, 48, 90, 48, -75, -111, -52, 108, 87, 28, -72, 107, -128, 113, 67, -124, 23, 72, 52, -27, -55, -118, -35, 0, -32, 8, 73, -48, 7, 36, 50, -63, 28, 21, 68, -124, -39, 97, 86, -28, 95, 26, -14, 6, -90, -3, -112, -5, -98, 62, 109, -97, 37, 76, -45, 126, 42, -126, 5, 126, 91, -45, -14, -123, 45, -63, -24, 20, 96, 34, 65, 71, -112, -38, -12, -53, -116, -37, -61, -28, 80, 12, 36, -92, 24, 106, -107, 4, 33, -50, 88, 88, 77, 71, -22, 37, 90, 41, -95, -121, 6, -79, 88, -82, 3, 49, 21, 71, -108, -20, -120, -4, -15, 61, -4, -86, 116, 94, -25, 123, 80, -50, -71, -81, -8, -53, -128, -63, -73, -12, -20, -5, -118, -105, -34, -87, -82, 18, -83, 54, 26, 5, -23, -104, 90, -1, 88, 67, 79, 90, -19, 57, -7, -70, 114, 27, -46, 124, 102, 44, 122, 27, 77, 0, 103, -127, -78, -88, -87, -59, -58, -101, -98, -83, -95, -123, -95, 27, -30, -48, 125, -60, -93, 57, -92, -37, 67, 119, -49, 72, 49, 65, 2, 3, 1, 0, 1 };
  private static final String PUB_KEY_BASE = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAvrKogXQuH0o0JcHsLKnEqr74NTWwI4Z65kTg0/z/O5dYTWbU5VgZUMWm110wCIdzozx/x4jiCPX0Ya/casUF6wpWXGoMV93qWB2p4EPBmxjSNLxjxPgTWfOyMt4v1ELHy9OTsFfFqbPQ1wSkSLQEn7J+0ZSGxZZXsUmkvuUJwd/PwVu79CjrCVSZsgnmqcplKvbVqYT8B8zBqnz3lIcBeMINWYu4id6MggiREGc07jw/VRYcu/Y8E8UKkRfa+bxPSzBaMLWRzGxXHLhrgHFDhBdINOXJit0A4AhJ0AckMsEcFUSE2WFW5F8a8gam/ZD7nj5tnyVM034qggV+W9PyhS3B6BRgIkFHkNr0y4zbw+RQDCSkGGqVBCHOWFhNR+olWimhhwaxWK4DMRVHlOyI/PE9/Kp0Xud7UM65r/jLgMG39Oz7ipfeqa4SrTYaBemYWv9YQ09a7Tn5unIb0nxmLHobTQBngbKoqcXGm56toYWhG+LQfcSjOaTbQ3fPSDFBAgMBAAE=";
  private static VsAppKeyVerify instance;
  private Context mContext;
  private Map<String, Map<String, String>> mMapAppKey = new HashMap();
  private String mPkgName = "";
  private String mPlatform = "";
  private String mSdtfrom = "";
  private String mVsKey = "";
  
  private static byte[] decrypt(Key paramKey, byte[] paramArrayOfByte)
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramKey);
    int j = paramArrayOfByte.length / 384;
    if (paramArrayOfByte.length % 384 == 0)
    {
      paramKey = new ByteArrayOutputStream(j * 373);
      int i = 0;
      while (i < j)
      {
        paramKey.write(localCipher.doFinal(paramArrayOfByte, i * 384, 384));
        i += 1;
      }
      return paramKey.toByteArray();
    }
    paramKey = new StringBuilder();
    paramKey.append("The size of data is not a multiple of cipher block size. Data size=");
    paramKey.append(paramArrayOfByte.length);
    paramKey = new IllegalBlockSizeException(paramKey.toString());
    for (;;)
    {
      throw paramKey;
    }
  }
  
  public static VsAppKeyVerify getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new VsAppKeyVerify();
      }
      VsAppKeyVerify localVsAppKeyVerify = instance;
      return localVsAppKeyVerify;
    }
    finally {}
  }
  
  public boolean addVsAppKey(Context paramContext, String paramString)
  {
    try
    {
      this.mContext = paramContext;
      paramContext = Base64.decode(paramString, 0);
      paramString = Base64.decode("MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAvrKogXQuH0o0JcHsLKnEqr74NTWwI4Z65kTg0/z/O5dYTWbU5VgZUMWm110wCIdzozx/x4jiCPX0Ya/casUF6wpWXGoMV93qWB2p4EPBmxjSNLxjxPgTWfOyMt4v1ELHy9OTsFfFqbPQ1wSkSLQEn7J+0ZSGxZZXsUmkvuUJwd/PwVu79CjrCVSZsgnmqcplKvbVqYT8B8zBqnz3lIcBeMINWYu4id6MggiREGc07jw/VRYcu/Y8E8UKkRfa+bxPSzBaMLWRzGxXHLhrgHFDhBdINOXJit0A4AhJ0AckMsEcFUSE2WFW5F8a8gam/ZD7nj5tnyVM034qggV+W9PyhS3B6BRgIkFHkNr0y4zbw+RQDCSkGGqVBCHOWFhNR+olWimhhwaxWK4DMRVHlOyI/PE9/Kp0Xud7UM65r/jLgMG39Oz7ipfeqa4SrTYaBemYWv9YQ09a7Tn5unIb0nxmLHobTQBngbKoqcXGm56toYWhG+LQfcSjOaTbQ3fPSDFBAgMBAAE=", 0);
      paramContext = decrypt(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString)), paramContext);
      VsLog.info(new String(paramContext), new Object[0]);
      Object localObject = new Properties();
      ((Properties)localObject).load(new ByteArrayInputStream(paramContext));
      paramString = ((Properties)localObject).getProperty("vskey");
      VsLog.info(paramString, new Object[0]);
      if (paramString == null) {
        VsLog.error("verify appkey fail vskey", new Object[0]);
      }
      paramContext = ((Properties)localObject).getProperty("platform");
      if (paramContext == null) {
        VsLog.error("verify appkey fail platform", new Object[0]);
      }
      String str = ((Properties)localObject).getProperty("sdtfrom");
      if (str == null) {
        VsLog.error("verify appkey fail sdtfrom", new Object[0]);
      }
      localObject = ((Properties)localObject).getProperty("pkg");
      if (localObject == null) {
        VsLog.error("verify appkey fail pkg", new Object[0]);
      }
      if (!this.mContext.getPackageName().equals(localObject))
      {
        paramString = new StringBuilder();
        paramString.append("verify appkey fail platform ");
        paramString.append(paramContext);
        Log.e("VERIFY VSAPPKEY", paramString.toString());
        return false;
      }
      localObject = new HashMap();
      ((Map)localObject).put("platform", paramContext);
      ((Map)localObject).put("sdtfrom", str);
      ((Map)localObject).put("vskey", paramString);
      updateMap(paramContext, (Map)localObject);
      return true;
    }
    catch (Throwable paramContext)
    {
      if ((paramContext instanceof GeneralSecurityException))
      {
        VsLog.error(paramContext.toString(), new Object[0]);
        return false;
      }
      VsLog.error(paramContext.toString(), new Object[0]);
    }
    return false;
  }
  
  public Map<String, Map<String, String>> getAppKeyMap()
  {
    return this.mMapAppKey;
  }
  
  public String getmPkgName()
  {
    return this.mPkgName;
  }
  
  public String getmPlatform()
  {
    return this.mPlatform;
  }
  
  public String getmSdtfrom()
  {
    return this.mSdtfrom;
  }
  
  public String getmVsKey()
  {
    return this.mVsKey;
  }
  
  public void setmPkgName(String paramString)
  {
    this.mPkgName = paramString;
  }
  
  public void setmPlatform(String paramString)
  {
    this.mPlatform = paramString;
  }
  
  public void setmSdtfrom(String paramString)
  {
    this.mSdtfrom = paramString;
  }
  
  public void setmVsKey(String paramString)
  {
    this.mVsKey = paramString;
  }
  
  public void updateMap(String paramString, Map<String, String> paramMap)
  {
    try
    {
      this.mMapAppKey.put(paramString, paramMap);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean verifyVsAppKey(Context paramContext, String paramString)
  {
    try
    {
      this.mContext = paramContext;
      paramContext = Base64.decode(paramString, 0);
      paramString = Base64.decode("MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAvrKogXQuH0o0JcHsLKnEqr74NTWwI4Z65kTg0/z/O5dYTWbU5VgZUMWm110wCIdzozx/x4jiCPX0Ya/casUF6wpWXGoMV93qWB2p4EPBmxjSNLxjxPgTWfOyMt4v1ELHy9OTsFfFqbPQ1wSkSLQEn7J+0ZSGxZZXsUmkvuUJwd/PwVu79CjrCVSZsgnmqcplKvbVqYT8B8zBqnz3lIcBeMINWYu4id6MggiREGc07jw/VRYcu/Y8E8UKkRfa+bxPSzBaMLWRzGxXHLhrgHFDhBdINOXJit0A4AhJ0AckMsEcFUSE2WFW5F8a8gam/ZD7nj5tnyVM034qggV+W9PyhS3B6BRgIkFHkNr0y4zbw+RQDCSkGGqVBCHOWFhNR+olWimhhwaxWK4DMRVHlOyI/PE9/Kp0Xud7UM65r/jLgMG39Oz7ipfeqa4SrTYaBemYWv9YQ09a7Tn5unIb0nxmLHobTQBngbKoqcXGm56toYWhG+LQfcSjOaTbQ3fPSDFBAgMBAAE=", 0);
      paramContext = decrypt(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString)), paramContext);
      VsLog.info(new String(paramContext), new Object[0]);
      paramString = new Properties();
      paramString.load(new ByteArrayInputStream(paramContext));
      String str1 = paramString.getProperty("vskey");
      VsLog.info(str1, new Object[0]);
      if (str1 == null) {
        VsLog.error("verify appkey fail vskey", new Object[0]);
      }
      paramContext = paramString.getProperty("platform");
      if (paramContext == null) {
        VsLog.error("verify appkey fail platform", new Object[0]);
      }
      String str2 = paramString.getProperty("sdtfrom");
      if (str2 == null) {
        VsLog.error("verify appkey fail sdtfrom", new Object[0]);
      }
      paramString = paramString.getProperty("pkg");
      if (paramString == null) {
        VsLog.error("verify appkey fail pkg", new Object[0]);
      }
      this.mPkgName = paramString;
      this.mSdtfrom = str2;
      this.mPlatform = paramContext;
      if (!this.mContext.getPackageName().equals(paramString))
      {
        paramString = new StringBuilder();
        paramString.append("verify appkey fail platform ");
        paramString.append(paramContext);
        Log.e("VERIFY VSAPPKEY", paramString.toString());
        return false;
      }
      this.mVsKey = str1;
      return true;
    }
    catch (Throwable paramContext)
    {
      if ((paramContext instanceof GeneralSecurityException))
      {
        VsLog.error(paramContext.toString(), new Object[0]);
        return false;
      }
      VsLog.error(paramContext.toString(), new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyVerify
 * JD-Core Version:    0.7.0.1
 */