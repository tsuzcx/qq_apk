package com.tencent.mobileqq.mini.push;

import java.util.HashMap;
import java.util.Map;

public class MiniAppControlInfo
{
  public String cmd;
  public Map<String, String> data = new HashMap();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ctrlInfo:[cmd = ");
    localStringBuilder.append(this.cmd);
    localStringBuilder.append(", data = ");
    localStringBuilder.append(this.data);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.MiniAppControlInfo
 * JD-Core Version:    0.7.0.1
 */