package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import ayoq;
import ayqd;
import azih;
import azim;
import azin;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class TroopFileManager$5$1
  implements Runnable
{
  public TroopFileManager$5$1(azim paramazim, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    azin localazin;
    synchronized (this.jdField_a_of_type_Azim.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localazin = (azin)this.jdField_a_of_type_Azim.a.d.get(str + l);
      if (localazin == null) {
        return;
      }
      if (m != 1) {}
    }
    int i;
    try
    {
      i = this.jdField_a_of_type_Int;
      if (i == -1000)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label2763;
        }
        if (!QLog.isDevelopLevel()) {
          break label2731;
        }
        QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        break label2731;
        for (;;)
        {
          return;
          localObject1 = finally;
          throw localObject1;
          localazin.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Azim.a.a(null, false, str, l);
          continue;
          localazin.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Azim.a.a(null, false, str, l);
          continue;
          if (localazin.jdField_a_of_type_JavaUtilList != null) {
            if ((localazin.jdField_a_of_type_JavaUtilList.size() < 15) && (!localazin.jdField_a_of_type_Boolean) && (localazin.d <= 3))
            {
              localazin.d += 1;
              this.jdField_a_of_type_Azim.a.b(str, l);
            }
            else
            {
              localazin.d = 0;
              this.jdField_a_of_type_Azim.a.a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localazin.jdField_a_of_type_JavaUtilList != null) {
                if ((localazin.jdField_a_of_type_JavaUtilList.size() < 15) && (!localazin.jdField_a_of_type_Boolean) && (localazin.d <= 3))
                {
                  localazin.d += 1;
                  localazin.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Azim.a.b(str, l);
                }
                else
                {
                  localazin.jdField_b_of_type_Boolean = false;
                  localazin.d = 0;
                  this.jdField_a_of_type_Azim.a.a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localazin.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        if (localObject2 != null) {}
      }
      else
      {
        if (this.jdField_a_of_type_Boolean) {
          break label2827;
        }
        if (!QLog.isDevelopLevel()) {
          break label2795;
        }
        QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        break label2795;
        for (;;)
        {
          label514:
          return;
          localazin.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Azim.a.a(null, false, str, l);
          continue;
          localazin.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Azim.a.a(null, false, str, l);
          continue;
          if (localazin.jdField_a_of_type_JavaUtilList != null) {
            if ((localazin.jdField_a_of_type_JavaUtilList.size() < 15) && (!localazin.jdField_a_of_type_Boolean) && (localazin.d <= 3))
            {
              localazin.d += 1;
              this.jdField_a_of_type_Azim.a.b(str, l);
            }
            else
            {
              localazin.d = 0;
              this.jdField_a_of_type_Azim.a.a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localazin.jdField_a_of_type_JavaUtilList != null) {
                if ((localazin.jdField_a_of_type_JavaUtilList.size() < 15) && (!localazin.jdField_a_of_type_Boolean) && (localazin.d <= 3))
                {
                  localazin.d += 1;
                  localazin.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Azim.a.b(str, l);
                }
                else
                {
                  localazin.jdField_b_of_type_Boolean = false;
                  localazin.d = 0;
                  this.jdField_a_of_type_Azim.a.a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localazin.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localazin.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localazin.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Azim.a.a();
      localazin.jdField_a_of_type_JavaUtilList.clear();
      localazin.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (ayoq)((Iterator)localObject2).next();
        this.jdField_a_of_type_Azim.a.b.put(((ayoq)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Azim.a.c.put(((ayoq)???).b, ???);
      }
      if (!QLog.isDevelopLevel()) {
        break label2859;
      }
    }
    finally
    {
      if (this.jdField_a_of_type_Boolean) {
        break label2963;
      }
    }
    QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
    for (;;)
    {
      label974:
      throw localObject3;
      label977:
      Object localObject6;
      Object localObject7;
      switch (m)
      {
      case 2: 
      default: 
        localObject6 = this.jdField_a_of_type_Azim.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
        localObject7 = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      Object localObject4;
      label1545:
      label1743:
      for (;;)
      {
        if (!((Iterator)localObject7).hasNext()) {
          break label1745;
        }
        localObject4 = (ayoq)((Iterator)localObject7).next();
        if (((ayoq)localObject4).jdField_d_of_type_Boolean)
        {
          if (((ayoq)localObject4).b == null) {
            continue;
          }
          ??? = (ayoq)this.jdField_a_of_type_Azim.a.c.get(((ayoq)localObject4).b);
          if (??? == null)
          {
            ((ayoq)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Azim.a.c.put(((ayoq)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (ayqd)localIterator.next();
              if (((ayoq)localObject4).b.equals(((ayqd)???).i))
              {
                ayoq localayoq2 = new ayoq();
                localayoq2.jdField_a_of_type_JavaUtilUUID = ((ayqd)???).jdField_a_of_type_JavaUtilUUID;
                localayoq2.b = ((ayqd)???).e;
                localayoq2.f = ((ayqd)???).i;
                localayoq2.a((ayqd)???, this.jdField_a_of_type_Azim.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((ayoq)localObject4).a(localayoq2);
              }
            }
            localazin.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((ayoq)???).b((ayoq)localObject4);
          this.jdField_a_of_type_Azim.a.b.put(((ayoq)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localazin.jdField_a_of_type_JavaUtilMap.get(((ayoq)???).b) == null)
          {
            localazin.jdField_a_of_type_JavaUtilList.add(???);
            localazin.jdField_a_of_type_JavaUtilMap.put(((ayoq)???).b, ???);
          }
          this.jdField_a_of_type_Azim.a.c.put(((ayoq)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((ayoq)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((ayoq)localObject4).b + ", sha = " + ((ayoq)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Azim.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((ayoq)localObject4).b);
        if (??? == null)
        {
          ((ayoq)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((ayoq)localObject4).jdField_d_of_type_Long = ((ayoq)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((ayoq)localObject4).e == 1) || (((ayoq)localObject4).e == 3) || (((ayoq)localObject4).e == 2) || (((ayoq)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (ayoq)this.jdField_a_of_type_Azim.a.c.get(((ayoq)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((ayoq)???).b((ayoq)localObject4);
          localObject4 = ???;
          ((ayoq)localObject4).a(this.jdField_a_of_type_Azim.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azim.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Azim.a.b.put(((ayoq)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localazin.jdField_a_of_type_JavaUtilMap.get(((ayoq)localObject4).b) == null)
          {
            localazin.jdField_a_of_type_JavaUtilList.add(localObject4);
            localazin.jdField_a_of_type_JavaUtilMap.put(((ayoq)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Azim.a.c.put(((ayoq)localObject4).b, localObject4);
          break;
          ((ayoq)localObject4).jdField_a_of_type_JavaUtilUUID = ((ayqd)???).jdField_a_of_type_JavaUtilUUID;
          ((ayoq)localObject4).a((ayqd)???, this.jdField_a_of_type_Azim.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((ayoq)localObject4).e == 9)
          {
            ??? = (ayoq)this.jdField_a_of_type_Azim.a.c.get(((ayqd)???).i);
            if (??? != null) {
              ((ayoq)???).a((ayoq)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (ayoq)this.jdField_a_of_type_Azim.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((ayoq)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localazin.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Azim.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (ayoq)((ayoq)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localazin.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((ayoq)localazin.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((ayoq)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((ayoq)localObject7).b == null) || (localazin.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((ayoq)localObject7).b.equals(((ayoq)localazin.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((ayoq)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((ayoq)localObject4).jdField_a_of_type_JavaUtilMap.remove(((ayoq)localObject7).b);
                  this.jdField_a_of_type_Azim.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((ayoq)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Azim.a.d(localayoq1);
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        }
      }
      for (;;)
      {
        return;
        localazin.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Azim.a.a(null, false, str, l);
        continue;
        localazin.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Azim.a.a(null, false, str, l);
        continue;
        if (localazin.jdField_a_of_type_JavaUtilList != null) {
          if ((localazin.jdField_a_of_type_JavaUtilList.size() < 15) && (!localazin.jdField_a_of_type_Boolean) && (localazin.d <= 3))
          {
            localazin.d += 1;
            this.jdField_a_of_type_Azim.a.b(str, l);
          }
          else
          {
            localazin.d = 0;
            this.jdField_a_of_type_Azim.a.a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localazin.jdField_a_of_type_JavaUtilList != null) {
              if ((localazin.jdField_a_of_type_JavaUtilList.size() < 15) && (!localazin.jdField_a_of_type_Boolean) && (localazin.d <= 3))
              {
                localazin.d += 1;
                localazin.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Azim.a.b(str, l);
              }
              else
              {
                localazin.jdField_b_of_type_Boolean = false;
                localazin.d = 0;
                this.jdField_a_of_type_Azim.a.a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, str, l);
                continue;
                localazin.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Azim.a.a(null, false, str, l);
                break label974;
                localazin.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Azim.a.a(null, false, str, l);
                break label974;
                if (localazin.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localazin.jdField_a_of_type_JavaUtilList.size() < 15) && (!localazin.jdField_a_of_type_Boolean) && (localazin.d <= 3))
                {
                  localazin.d += 1;
                  this.jdField_a_of_type_Azim.a.b(str, l);
                  break label974;
                }
                localazin.d = 0;
                this.jdField_a_of_type_Azim.a.a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localazin.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localazin.jdField_a_of_type_JavaUtilList.size() < 15) && (!localazin.jdField_a_of_type_Boolean) && (localazin.d <= 3))
                {
                  localazin.d += 1;
                  localazin.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Azim.a.b(str, l);
                  break label974;
                }
                localazin.jdField_b_of_type_Boolean = false;
                localazin.d = 0;
                this.jdField_a_of_type_Azim.a.a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, str, l);
                break label974;
                label2723:
                break label2894;
                label2726:
                i = 0;
                break label2075;
                label2731:
                switch (m)
                {
                }
                break;
                label2763:
                switch (m)
                {
                }
                break;
                label2795:
                switch (m)
                {
                }
                break label514;
                label2827:
                switch (m)
                {
                }
                break label514;
                label2859:
                switch (m)
                {
                }
                break label974;
                label2891:
                break label1545;
                label2894:
                k += 1;
                break label1984;
                switch (m)
                {
                }
                continue;
                switch (m)
                {
                }
              }
            }
          }
        }
      }
      label2963:
      switch (m)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.5.1
 * JD-Core Version:    0.7.0.1
 */