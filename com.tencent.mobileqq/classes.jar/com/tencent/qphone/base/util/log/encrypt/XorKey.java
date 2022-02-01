package com.tencent.qphone.base.util.log.encrypt;

import java.security.SecureRandom;

public class XorKey
{
  private static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA+qHDOmeTf26b/E/J3wFL\nqEYPlEivQJnP6D5MyExZKMhPTK5VN23KjLRg3plqSGduH6gRrNZQsYIuawlnk2Vl\njFKjFIt9+vMxMHh7E/FDBrMMqI/NqYcNhlpGNxnWrFkP8s6f1Jqnv/FDxrroBRd6\nPfAd/lawnC0oGl1uCLelGMnvBGWAyPgnpBU0SVkerkSkEYE+AXMzQavt8je4ersz\nJkFlb7Q8Sk/5IDYu4BvYrzSKuFFymrIOnWcaUs94IY2rz6hcFqWXjsbGGTLDXB1A\nNqQCbQBdG2SoLGHa5sJOM36SAFJIjM1BETDBv3BpFpet0J5ji1ni5UW5KsNhtlbD\nHwIDAQAB";
  
  public static String encryptedKey(String paramString)
  {
    return RSA.encryptByPublic(paramString, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA+qHDOmeTf26b/E/J3wFL\nqEYPlEivQJnP6D5MyExZKMhPTK5VN23KjLRg3plqSGduH6gRrNZQsYIuawlnk2Vl\njFKjFIt9+vMxMHh7E/FDBrMMqI/NqYcNhlpGNxnWrFkP8s6f1Jqnv/FDxrroBRd6\nPfAd/lawnC0oGl1uCLelGMnvBGWAyPgnpBU0SVkerkSkEYE+AXMzQavt8je4ersz\nJkFlb7Q8Sk/5IDYu4BvYrzSKuFFymrIOnWcaUs94IY2rz6hcFqWXjsbGGTLDXB1A\nNqQCbQBdG2SoLGHa5sJOM36SAFJIjM1BETDBv3BpFpet0J5ji1ni5UW5KsNhtlbD\nHwIDAQAB");
  }
  
  public static String genRandomKey()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[12];
    localSecureRandom.nextBytes(arrayOfByte);
    return Base64.encode(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.encrypt.XorKey
 * JD-Core Version:    0.7.0.1
 */