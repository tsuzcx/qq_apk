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
  public static int A;
  public static int B;
  public static int C;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I;
  public static int J;
  public static int K;
  public static int L;
  public static int M;
  public static int N;
  public static int O;
  public static double a;
  public static int a;
  static SparseArray<AutoStatusItem> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  static List<Integer> jdField_a_of_type_JavaUtilList;
  public static boolean a;
  public static int b;
  public static List<LocationCategoryDetector.Category> b;
  public static boolean b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static int t;
  public static int u;
  public static int v;
  public static int w;
  public static int x;
  public static int y;
  public static int z;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 3;
    c = 300000;
    d = 2;
    e = 50;
    f = 50;
    g = 50;
    jdField_a_of_type_Double = 1.0D;
    h = 120000;
    i = 10000;
    j = 10;
    k = 20;
    l = 100;
    m = 60000;
    n = 30000;
    o = 3;
    p = 5;
    q = 30000;
    r = 600000;
    s = 50;
    t = 10;
    u = 20;
    v = 30;
    w = 120;
    x = 500;
    y = 1500;
    z = 100;
    A = 400;
    B = 20;
    C = 3;
    D = 0;
    E = 5;
    F = 40;
    G = 200;
    H = 120000;
    I = 60000;
    J = 100;
    K = 120000;
    L = 120000;
    M = 50;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    N = 300000;
    O = 600000;
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  static int a(int paramInt)
  {
    return paramInt * 1000;
  }
  
  static AutoStatusItem a(int paramInt)
  {
    return (AutoStatusItem)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 40001: 
      return "在地球";
    case 41012: 
      return "行走中";
    case 41013: 
      return "跑步中";
    case 41031: 
      return "骑行中";
    case 41014: 
      return "开车中";
    case 41032: 
      return "熬夜中";
    case 41042: 
      return "移动中";
    case 41033: 
      return "在小区";
    case 41034: 
      return "在学校";
    case 41035: 
      return "在公园";
    case 41036: 
      return "在海边";
    case 41037: 
      return "在机场";
    case 41038: 
      return "在商场";
    case 41039: 
      return "在咖啡厅";
    }
    return "在餐厅";
  }
  
  static void a(List<AutoStatusItem> paramList)
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AutoStatusItem localAutoStatusItem = (AutoStatusItem)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status : " + localAutoStatusItem);
      }
      jdField_a_of_type_AndroidUtilSparseArray.put((int)localAutoStatusItem.jdField_a_of_type_Long, localAutoStatusItem);
      Object localObject;
      if (("category".equalsIgnoreCase(localAutoStatusItem.g)) && (localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory != null))
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
        if (QLog.isColorLevel()) {
          QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localAutoStatusItem.jdField_a_of_type_Long + " category : " + localObject);
        }
        jdField_b_of_type_JavaUtilList.add(localObject);
      }
      else
      {
        localObject = localAutoStatusItem.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigSensor;
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localAutoStatusItem.jdField_a_of_type_Long + " sensor null");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. status: " + localAutoStatusItem.jdField_a_of_type_Long + " sensor: " + localObject);
          }
          switch ((int)localAutoStatusItem.jdField_a_of_type_Long)
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.d("Constant", 2, "[status][autoMgr] initWithConfig. dropped status: " + localAutoStatusItem.jdField_a_of_type_Long + " sensor: " + localObject);
            }
            break;
          case 41012: 
            x = ((Sensor)localObject).jdField_b_of_type_Int;
            y = ((Sensor)localObject).c;
            B = ((Sensor)localObject).d;
            jdField_a_of_type_Int = ((Sensor)localObject).e;
            jdField_b_of_type_Int = ((Sensor)localObject).f;
            break;
          case 41013: 
            z = ((Sensor)localObject).jdField_b_of_type_Int;
            A = ((Sensor)localObject).c;
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
          case 41032: 
            if ((((Sensor)localObject).jdField_b_of_type_Int >= 0) && (((Sensor)localObject).jdField_b_of_type_Int < 23) && (((Sensor)localObject).c >= 0) && (((Sensor)localObject).c < 23))
            {
              D = ((Sensor)localObject).jdField_b_of_type_Int;
              E = ((Sensor)localObject).c;
            }
            break;
          case 41042: 
            F = ((Sensor)localObject).o;
            G = ((Sensor)localObject).p;
            M = ((Sensor)localObject).q;
            if (((Sensor)localObject).t == 1)
            {
              bool = true;
              label747:
              jdField_a_of_type_Boolean = bool;
              if (((Sensor)localObject).r != 1) {
                break label808;
              }
            }
            label808:
            for (boolean bool = true;; bool = false)
            {
              jdField_b_of_type_Boolean = bool;
              H = ((Sensor)localObject).s;
              J = ((Sensor)localObject).u;
              I = ((Sensor)localObject).v;
              K = ((Sensor)localObject).w;
              L = ((Sensor)localObject).x;
              break;
              bool = false;
              break label747;
            }
          }
        }
      }
    }
  }
  
  static boolean a(long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.Constant
 * JD-Core Version:    0.7.0.1
 */