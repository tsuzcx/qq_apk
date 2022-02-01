package com.tencent.qqavopensdk.PBuffer;

import java.util.HashMap;
import java.util.Map;

public class SSOTunnelEvent
{
  private static SSOTunnelEvent jdField_a_of_type_ComTencentQqavopensdkPBufferSSOTunnelEvent;
  Map<Long, SSOTunnelEvent.CsCmdCallback> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static SSOTunnelEvent a()
  {
    if (jdField_a_of_type_ComTencentQqavopensdkPBufferSSOTunnelEvent == null) {
      jdField_a_of_type_ComTencentQqavopensdkPBufferSSOTunnelEvent = new SSOTunnelEvent();
    }
    return jdField_a_of_type_ComTencentQqavopensdkPBufferSSOTunnelEvent;
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      SSOTunnelEvent.CsCmdCallback localCsCmdCallback = (SSOTunnelEvent.CsCmdCallback)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (paramBoolean) {
        localCsCmdCallback.a(paramArrayOfByte);
      } else {
        localCsCmdCallback.a(1, "Event");
      }
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent
 * JD-Core Version:    0.7.0.1
 */