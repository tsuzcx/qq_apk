package com.tencent.mobileqq.dpc;

public class DeviceProfileManager$StringToIntParser
  implements DeviceProfileManager.StringParser<Integer>
{
  public Integer parse(String paramString)
  {
    return Integer.decode(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.DeviceProfileManager.StringToIntParser
 * JD-Core Version:    0.7.0.1
 */