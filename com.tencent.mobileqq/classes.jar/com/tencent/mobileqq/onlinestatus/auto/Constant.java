package com.tencent.mobileqq.onlinestatus.auto;

import android.util.SparseArray;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationCategoryDetector.Category;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.config.Category;
import com.tencent.mobileqq.onlinestatus.config.Sensor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Constant
{
  public static int A = 400;
  public static int B = 20;
  public static int C = 3;
  public static int D = 0;
  public static int E = 5;
  public static int F = 40;
  public static int G = 200;
  public static int H = 120000;
  public static int I = 60000;
  public static int J = 100;
  public static int K = 120000;
  public static int L = 120000;
  public static int M = 50;
  public static int N = 300000;
  public static int O = 600000;
  public static double a = 1.0D;
  public static int a = 1;
  public static SparseArray<AutoStatusItem> a;
  public static List<Integer> a;
  public static boolean a = true;
  public static int b = 3;
  public static List<LocationCategoryDetector.Category> b;
  public static boolean b = true;
  public static int c = 300000;
  public static int d = 2;
  public static int e = 50;
  public static int f = 50;
  public static int g = 50;
  public static int h = 120000;
  public static int i = 10000;
  public static int j = 10;
  public static int k = 20;
  public static int l = 100;
  public static int m = 60000;
  public static int n = 30000;
  public static int o = 3;
  public static int p = 5;
  public static int q = 30000;
  public static int r = 600000;
  public static int s = 50;
  public static int t = 10;
  public static int u = 20;
  public static int v = 30;
  public static int w = 120;
  public static int x = 500;
  public static int y = 1500;
  public static int z = 100;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static int a(int paramInt)
  {
    return paramInt * 1000;
  }
  
  public static AutoStatusItem a(int paramInt)
  {
    return (AutoStatusItem)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 40001)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            return String.valueOf(paramInt);
          case 41042: 
            return "移动中";
          }
          return "在餐厅";
        case 41039: 
          return "在咖啡厅";
        case 41038: 
          return "在商场";
        case 41037: 
          return "在机场";
        case 41036: 
          return "在海边";
        case 41035: 
          return "在公园";
        case 41034: 
          return "在学校";
        case 41033: 
          return "在小区";
        case 41032: 
          return "熬夜中";
        }
        return "骑行中";
      case 41014: 
        return "开车中";
      case 41013: 
        return "跑步中";
      }
      return "行走中";
    }
    return "在地球";
  }
  
  public static void a(List<AutoStatusItem> paramList)
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AutoStatusItem localAutoStatusItem = (AutoStatusItem)paramList.next();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][autoMgr] initWithConfig. status : ");
        ((StringBuilder)localObject).append(localAutoStatusItem);
        QLog.d("Constant", 2, ((StringBuilder)localObject).toString());
      }
      jdField_a_of_type_AndroidUtilSparseArray.put((int)localAutoStatusItem.jdField_a_of_type_Long, localAutoStatusItem);
      StringBuilder localStringBuilder;
      if (("category".equalsIgnoreCase(localAutoStatusItem.h)) && (localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory != null))
      {
        localObject = new LocationCategoryDetector.Category((int)localAutoStatusItem.jdField_a_of_type_Long, localAutoStatusItem.b, localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.jdField_a_of_type_JavaLangString, localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.jdField_a_of_type_Int);
        d = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.jdField_b_of_type_Int;
        g = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.c;
        f = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.d;
        e = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.e;
        jdField_a_of_type_Double = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.jdField_a_of_type_Double;
        h = a(localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.f);
        j = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.g;
        l = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory.h;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] initWithConfig. status: ");
          localStringBuilder.append(localAutoStatusItem.jdField_a_of_type_Long);
          localStringBuilder.append(" category : ");
          localStringBuilder.append(localObject);
          QLog.d("Constant", 2, localStringBuilder.toString());
        }
        jdField_b_of_type_JavaUtilList.add(localObject);
      }
      else
      {
        localObject = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigSensor;
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[status][autoMgr] initWithConfig. status: ");
            ((StringBuilder)localObject).append(localAutoStatusItem.jdField_a_of_type_Long);
            ((StringBuilder)localObject).append(" sensor null");
            QLog.d("Constant", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][autoMgr] initWithConfig. status: ");
            localStringBuilder.append(localAutoStatusItem.jdField_a_of_type_Long);
            localStringBuilder.append(" sensor: ");
            localStringBuilder.append(localObject);
            QLog.d("Constant", 2, localStringBuilder.toString());
          }
          switch ((int)localAutoStatusItem.jdField_a_of_type_Long)
          {
          default: 
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[status][autoMgr] initWithConfig. dropped status: ");
              localStringBuilder.append(localAutoStatusItem.jdField_a_of_type_Long);
              localStringBuilder.append(" sensor: ");
              localStringBuilder.append(localObject);
              QLog.d("Constant", 2, localStringBuilder.toString());
            }
            break;
          case 41042: 
            F = ((Sensor)localObject).o;
            G = ((Sensor)localObject).p;
            M = ((Sensor)localObject).q;
            int i1 = ((Sensor)localObject).t;
            boolean bool2 = false;
            if (i1 == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            jdField_a_of_type_Boolean = bool1;
            boolean bool1 = bool2;
            if (((Sensor)localObject).r == 1) {
              bool1 = true;
            }
            jdField_b_of_type_Boolean = bool1;
            H = ((Sensor)localObject).s;
            J = ((Sensor)localObject).u;
            I = ((Sensor)localObject).v;
            K = ((Sensor)localObject).w;
            L = ((Sensor)localObject).x;
            break;
          case 41032: 
            if ((((Sensor)localObject).jdField_b_of_type_Int >= 0) && (((Sensor)localObject).jdField_b_of_type_Int < 23) && (((Sensor)localObject).c >= 0) && (((Sensor)localObject).c < 23))
            {
              D = ((Sensor)localObject).jdField_b_of_type_Int;
              E = ((Sensor)localObject).c;
            }
            break;
          case 41031: 
            t = ((Sensor)localObject).jdField_b_of_type_Int;
            u = ((Sensor)localObject).c;
            break;
          case 41014: 
            v = ((Sensor)localObject).jdField_b_of_type_Int;
            w = ((Sensor)localObject).c;
            c = a(((Sensor)localObject).g);
            o = ((Sensor)localObject).h;
            p = ((Sensor)localObject).i;
            m = a(((Sensor)localObject).j);
            n = a(((Sensor)localObject).k);
            r = a(((Sensor)localObject).m);
            q = a(((Sensor)localObject).l);
            s = ((Sensor)localObject).n;
            C = ((Sensor)localObject).d;
            N = m * 2;
            break;
          case 41013: 
            z = ((Sensor)localObject).jdField_b_of_type_Int;
            A = ((Sensor)localObject).c;
            break;
          case 41012: 
            x = ((Sensor)localObject).jdField_b_of_type_Int;
            y = ((Sensor)localObject).c;
            B = ((Sensor)localObject).d;
            jdField_a_of_type_Int = ((Sensor)localObject).e;
            jdField_b_of_type_Int = ((Sensor)localObject).f;
          }
        }
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((LocationCategoryDetector.Category)localIterator.next()).a() == paramLong) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.Constant
 * JD-Core Version:    0.7.0.1
 */