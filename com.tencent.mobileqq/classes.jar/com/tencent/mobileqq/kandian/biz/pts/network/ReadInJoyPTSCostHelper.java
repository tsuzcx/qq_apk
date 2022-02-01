package com.tencent.mobileqq.kandian.biz.pts.network;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyPTSCostHelper
{
  private static final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static void a()
  {
    List localList = jdField_a_of_type_JavaUtilList;
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
    List localList = jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
  }
  
  private static void b(String paramString)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((AppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), "", "0X800A064", "0X800A064", 0, 0, "", "", "", paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper
 * JD-Core Version:    0.7.0.1
 */