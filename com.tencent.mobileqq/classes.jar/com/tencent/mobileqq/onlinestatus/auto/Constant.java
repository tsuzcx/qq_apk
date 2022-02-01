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
  public static int A = 100;
  public static int B = 400;
  public static int C = 20;
  public static int D = 3;
  public static int E = 0;
  public static int F = 5;
  public static int G = 40;
  public static int H = 200;
  public static int I = 120000;
  public static int J = 60000;
  public static int K = 100;
  public static int L = 120000;
  public static int M = 120000;
  public static int N = 50;
  public static boolean O = true;
  public static boolean P = true;
  public static int Q = 300000;
  public static int R = 600000;
  public static List<Integer> S = new ArrayList();
  public static List<LocationCategoryDetector.Category> T = new ArrayList();
  public static SparseArray<AutoStatusItem> U = new SparseArray();
  public static int a = 1;
  public static int b = 3;
  public static int c = 300000;
  public static int d = 2;
  public static int e = 50;
  public static int f = 50;
  public static int g = 50;
  public static double h = 1.0D;
  public static int i = 120000;
  public static int j = 10000;
  public static int k = 10;
  public static int l = 20;
  public static int m = 100;
  public static int n = 60000;
  public static int o = 30000;
  public static int p = 3;
  public static int q = 5;
  public static int r = 30000;
  public static int s = 600000;
  public static int t = 50;
  public static int u = 10;
  public static int v = 20;
  public static int w = 30;
  public static int x = 120;
  public static int y = 500;
  public static int z = 1500;
  
  public static int a(int paramInt)
  {
    return paramInt * 1000;
  }
  
  public static void a(List<AutoStatusItem> paramList)
  {
    U = new SparseArray();
    T = new ArrayList();
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
      U.put((int)localAutoStatusItem.b, localAutoStatusItem);
      StringBuilder localStringBuilder;
      if (("category".equalsIgnoreCase(localAutoStatusItem.o)) && (localAutoStatusItem.p != null))
      {
        localObject = new LocationCategoryDetector.Category((int)localAutoStatusItem.b, localAutoStatusItem.c, localAutoStatusItem.p.b, localAutoStatusItem.p.a);
        d = localAutoStatusItem.p.c;
        g = localAutoStatusItem.p.d;
        f = localAutoStatusItem.p.e;
        e = localAutoStatusItem.p.f;
        h = localAutoStatusItem.p.g;
        i = a(localAutoStatusItem.p.h);
        k = localAutoStatusItem.p.i;
        m = localAutoStatusItem.p.j;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] initWithConfig. status: ");
          localStringBuilder.append(localAutoStatusItem.b);
          localStringBuilder.append(" category : ");
          localStringBuilder.append(localObject);
          QLog.d("Constant", 2, localStringBuilder.toString());
        }
        T.add(localObject);
      }
      else
      {
        localObject = localAutoStatusItem.q;
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[status][autoMgr] initWithConfig. status: ");
            ((StringBuilder)localObject).append(localAutoStatusItem.b);
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
            localStringBuilder.append(localAutoStatusItem.b);
            localStringBuilder.append(" sensor: ");
            localStringBuilder.append(localObject);
            QLog.d("Constant", 2, localStringBuilder.toString());
          }
          switch ((int)localAutoStatusItem.b)
          {
          default: 
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[status][autoMgr] initWithConfig. dropped status: ");
              localStringBuilder.append(localAutoStatusItem.b);
              localStringBuilder.append(" sensor: ");
              localStringBuilder.append(localObject);
              QLog.d("Constant", 2, localStringBuilder.toString());
            }
            break;
          case 41042: 
            G = ((Sensor)localObject).p;
            H = ((Sensor)localObject).q;
            N = ((Sensor)localObject).r;
            int i1 = ((Sensor)localObject).u;
            boolean bool2 = false;
            if (i1 == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            O = bool1;
            boolean bool1 = bool2;
            if (((Sensor)localObject).s == 1) {
              bool1 = true;
            }
            P = bool1;
            I = ((Sensor)localObject).t;
            K = ((Sensor)localObject).v;
            J = ((Sensor)localObject).w;
            L = ((Sensor)localObject).x;
            M = ((Sensor)localObject).y;
            break;
          case 41032: 
            if ((((Sensor)localObject).c >= 0) && (((Sensor)localObject).c < 23) && (((Sensor)localObject).d >= 0) && (((Sensor)localObject).d < 23))
            {
              E = ((Sensor)localObject).c;
              F = ((Sensor)localObject).d;
            }
            break;
          case 41031: 
            u = ((Sensor)localObject).c;
            v = ((Sensor)localObject).d;
            break;
          case 41014: 
            w = ((Sensor)localObject).c;
            x = ((Sensor)localObject).d;
            c = a(((Sensor)localObject).h);
            p = ((Sensor)localObject).i;
            q = ((Sensor)localObject).j;
            n = a(((Sensor)localObject).k);
            o = a(((Sensor)localObject).l);
            s = a(((Sensor)localObject).n);
            r = a(((Sensor)localObject).m);
            t = ((Sensor)localObject).o;
            D = ((Sensor)localObject).e;
            Q = n * 2;
            break;
          case 41013: 
            A = ((Sensor)localObject).c;
            B = ((Sensor)localObject).d;
            break;
          case 41012: 
            y = ((Sensor)localObject).c;
            z = ((Sensor)localObject).d;
            C = ((Sensor)localObject).e;
            a = ((Sensor)localObject).f;
            b = ((Sensor)localObject).g;
          }
        }
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    Iterator localIterator = T.iterator();
    while (localIterator.hasNext()) {
      if (((LocationCategoryDetector.Category)localIterator.next()).a() == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public static AutoStatusItem b(int paramInt)
  {
    return (AutoStatusItem)U.get(paramInt);
  }
  
  public static String c(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.Constant
 * JD-Core Version:    0.7.0.1
 */