package com.tencent.mobileqq.kandian.biz.pts.network;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyPTSCostHelper
{
  private static final byte[] a = new byte[0];
  private static final List<String> b = new ArrayList();
  
  public static void a()
  {
    List localList = b;
    if ((localList != null) && (localList.size() <= 0)) {}
  }
  
  public static void a(String paramString1, String paramString2, double paramDouble)
  {
    if (!a(paramDouble)) {}
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    if (!a(paramDouble)) {}
  }
  
  private static boolean a(double paramDouble)
  {
    return false;
  }
  
  public static void b()
  {
    List localList = b;
    if (localList != null) {
      localList.clear();
    }
  }
  
  private static void b(String paramString)
  {
    PublicAccountReportUtils.a((AppInterface)RIJQQAppInterfaceUtil.e(), "", "0X800A064", "0X800A064", 0, 0, "", "", "", paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper
 * JD-Core Version:    0.7.0.1
 */