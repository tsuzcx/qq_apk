package com.tencent.qapmsdk.dns.policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class IpPolicy$IpPolicyRandom
  extends IpPolicy
{
  public List<String> sort(String paramString, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return paramList;
    }
    int j = new Random().nextInt(paramList.size());
    paramString = new ArrayList();
    paramString.add(paramList.get(j));
    int i = 0;
    if (i < paramList.size())
    {
      if (i == j) {}
      for (;;)
      {
        i += 1;
        break;
        paramString.add(paramList.get(i));
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.policy.IpPolicy.IpPolicyRandom
 * JD-Core Version:    0.7.0.1
 */