package org.apache.http.impl.auth;

@Deprecated
public abstract interface NTLMEngine
{
  public abstract String generateType1Msg(String paramString1, String paramString2);
  
  public abstract String generateType3Msg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.auth.NTLMEngine
 * JD-Core Version:    0.7.0.1
 */