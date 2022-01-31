package com.tencent.qqavopensdk.PBuffer;

import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import java.util.HashMap;
import java.util.Map;

public class SSOTunnelEvent
{
  private static SSOTunnelEvent jdField_a_of_type_ComTencentQqavopensdkPBufferSSOTunnelEvent;
  long jdField_a_of_type_Long = 1L;
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static SSOTunnelEvent a()
  {
    if (jdField_a_of_type_ComTencentQqavopensdkPBufferSSOTunnelEvent == null) {
      jdField_a_of_type_ComTencentQqavopensdkPBufferSSOTunnelEvent = new SSOTunnelEvent();
    }
    return jdField_a_of_type_ComTencentQqavopensdkPBufferSSOTunnelEvent;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, SSOTunnelEvent.CsCmdCallback paramCsCmdCallback)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), paramCsCmdCallback);
    paramCsCmdCallback = CmGameUtil.a();
    if (paramCsCmdCallback != null) {
      paramCsCmdCallback.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    SSOTunnelEvent.CsCmdCallback localCsCmdCallback;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localCsCmdCallback = (SSOTunnelEvent.CsCmdCallback)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localCsCmdCallback.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localCsCmdCallback.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, SSOTunnelEvent.CsCmdCallback paramCsCmdCallback)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), paramCsCmdCallback);
    paramString1 = CmGameUtil.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent
 * JD-Core Version:    0.7.0.1
 */