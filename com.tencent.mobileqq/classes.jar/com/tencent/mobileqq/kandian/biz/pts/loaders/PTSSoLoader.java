package com.tencent.mobileqq.kandian.biz.pts.loaders;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport.R5Builder;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class PTSSoLoader
{
  private static volatile PTSSoLoader jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSSoLoader;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static PTSSoLoader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSSoLoader == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSSoLoader == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSSoLoader = new PTSSoLoader();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSSoLoader;
  }
  
  private List<Integer> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    paramString = paramString.split("\\.");
    Object localObject = new ArrayList();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      try
      {
        ((List)localObject).add(Integer.valueOf(Integer.parseInt(str)));
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getVersionList] error, e = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("PTSSoLoader", 1, ((StringBuilder)localObject).toString());
        return new ArrayList();
      }
    }
    return localObject;
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new PTSReport.R5Builder().a("name", paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    paramString1 = paramString1.a("resCode", localStringBuilder.toString()).a("version", paramString2).a();
    if (paramInt == 0)
    {
      PTSReport.a("0X800A832", "", "", "", paramString1);
      return;
    }
    PTSReport.a("0X800A833", "", "", "", paramString1);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isVersionValid], currentVersion = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", supportMinVersion = ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("PTSSoLoader", 1, ((StringBuilder)localObject).toString());
    localObject = a(paramString1);
    paramString2 = a(paramString2);
    int i = paramString1.length();
    boolean bool = false;
    if (i <= 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[isVersionValid] false, currentVersion = ");
      paramString2.append(paramString1);
      QLog.i("PTSSoLoader", 1, paramString2.toString());
      return false;
    }
    int j = Math.min(((List)localObject).size(), paramString2.size());
    i = 0;
    while (i < j)
    {
      if (((Integer)((List)localObject).get(i)).intValue() < ((Integer)paramString2.get(i)).intValue())
      {
        QLog.i("PTSSoLoader", 1, "[isVersionValid] = false");
        return false;
      }
      if (((Integer)((List)localObject).get(i)).intValue() > ((Integer)paramString2.get(i)).intValue())
      {
        QLog.i("PTSSoLoader", 1, "[isVersionValid] = true");
        return true;
      }
      i += 1;
    }
    if (((List)localObject).size() >= paramString2.size()) {
      bool = true;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[isVersionValid] = ");
    paramString1.append(bool);
    QLog.i("PTSSoLoader", 1, paramString1.toString());
    return bool;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[load], name = ");
    localStringBuilder.append(paramString);
    QLog.i("PTSSoLoader", 1, localStringBuilder.toString());
    SoLoadManager.getInstance().load(paramString, new PTSSoLoader.1(this, paramString));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSSoLoader
 * JD-Core Version:    0.7.0.1
 */