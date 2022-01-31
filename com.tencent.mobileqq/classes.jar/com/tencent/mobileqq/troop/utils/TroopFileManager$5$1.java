package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import azpi;
import azqv;
import bajy;
import bakd;
import bake;
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
  public TroopFileManager$5$1(bakd parambakd, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    bake localbake;
    synchronized (this.jdField_a_of_type_Bakd.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localbake = (bake)this.jdField_a_of_type_Bakd.a.d.get(str + l);
      if (localbake == null) {
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
          localbake.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bakd.a.a(null, false, str, l);
          continue;
          localbake.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bakd.a.a(null, false, str, l);
          continue;
          if (localbake.jdField_a_of_type_JavaUtilList != null) {
            if ((localbake.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbake.jdField_a_of_type_Boolean) && (localbake.d <= 3))
            {
              localbake.d += 1;
              this.jdField_a_of_type_Bakd.a.b(str, l);
            }
            else
            {
              localbake.d = 0;
              this.jdField_a_of_type_Bakd.a.a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbake.jdField_a_of_type_JavaUtilList != null) {
                if ((localbake.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbake.jdField_a_of_type_Boolean) && (localbake.d <= 3))
                {
                  localbake.d += 1;
                  localbake.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bakd.a.b(str, l);
                }
                else
                {
                  localbake.jdField_b_of_type_Boolean = false;
                  localbake.d = 0;
                  this.jdField_a_of_type_Bakd.a.a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbake.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
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
          localbake.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bakd.a.a(null, false, str, l);
          continue;
          localbake.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bakd.a.a(null, false, str, l);
          continue;
          if (localbake.jdField_a_of_type_JavaUtilList != null) {
            if ((localbake.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbake.jdField_a_of_type_Boolean) && (localbake.d <= 3))
            {
              localbake.d += 1;
              this.jdField_a_of_type_Bakd.a.b(str, l);
            }
            else
            {
              localbake.d = 0;
              this.jdField_a_of_type_Bakd.a.a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbake.jdField_a_of_type_JavaUtilList != null) {
                if ((localbake.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbake.jdField_a_of_type_Boolean) && (localbake.d <= 3))
                {
                  localbake.d += 1;
                  localbake.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bakd.a.b(str, l);
                }
                else
                {
                  localbake.jdField_b_of_type_Boolean = false;
                  localbake.d = 0;
                  this.jdField_a_of_type_Bakd.a.a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbake.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbake.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localbake.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Bakd.a.a();
      localbake.jdField_a_of_type_JavaUtilList.clear();
      localbake.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (azpi)((Iterator)localObject2).next();
        this.jdField_a_of_type_Bakd.a.b.put(((azpi)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Bakd.a.c.put(((azpi)???).b, ???);
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
        localObject6 = this.jdField_a_of_type_Bakd.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
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
        localObject4 = (azpi)((Iterator)localObject7).next();
        if (((azpi)localObject4).jdField_d_of_type_Boolean)
        {
          if (((azpi)localObject4).b == null) {
            continue;
          }
          ??? = (azpi)this.jdField_a_of_type_Bakd.a.c.get(((azpi)localObject4).b);
          if (??? == null)
          {
            ((azpi)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Bakd.a.c.put(((azpi)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (azqv)localIterator.next();
              if (((azpi)localObject4).b.equals(((azqv)???).i))
              {
                azpi localazpi2 = new azpi();
                localazpi2.jdField_a_of_type_JavaUtilUUID = ((azqv)???).jdField_a_of_type_JavaUtilUUID;
                localazpi2.b = ((azqv)???).e;
                localazpi2.f = ((azqv)???).i;
                localazpi2.a((azqv)???, this.jdField_a_of_type_Bakd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((azpi)localObject4).a(localazpi2);
              }
            }
            localbake.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((azpi)???).b((azpi)localObject4);
          this.jdField_a_of_type_Bakd.a.b.put(((azpi)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localbake.jdField_a_of_type_JavaUtilMap.get(((azpi)???).b) == null)
          {
            localbake.jdField_a_of_type_JavaUtilList.add(???);
            localbake.jdField_a_of_type_JavaUtilMap.put(((azpi)???).b, ???);
          }
          this.jdField_a_of_type_Bakd.a.c.put(((azpi)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((azpi)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((azpi)localObject4).b + ", sha = " + ((azpi)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Bakd.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((azpi)localObject4).b);
        if (??? == null)
        {
          ((azpi)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((azpi)localObject4).jdField_d_of_type_Long = ((azpi)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((azpi)localObject4).e == 1) || (((azpi)localObject4).e == 3) || (((azpi)localObject4).e == 2) || (((azpi)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (azpi)this.jdField_a_of_type_Bakd.a.c.get(((azpi)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((azpi)???).b((azpi)localObject4);
          localObject4 = ???;
          ((azpi)localObject4).a(this.jdField_a_of_type_Bakd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bakd.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bakd.a.b.put(((azpi)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localbake.jdField_a_of_type_JavaUtilMap.get(((azpi)localObject4).b) == null)
          {
            localbake.jdField_a_of_type_JavaUtilList.add(localObject4);
            localbake.jdField_a_of_type_JavaUtilMap.put(((azpi)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Bakd.a.c.put(((azpi)localObject4).b, localObject4);
          break;
          ((azpi)localObject4).jdField_a_of_type_JavaUtilUUID = ((azqv)???).jdField_a_of_type_JavaUtilUUID;
          ((azpi)localObject4).a((azqv)???, this.jdField_a_of_type_Bakd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((azpi)localObject4).e == 9)
          {
            ??? = (azpi)this.jdField_a_of_type_Bakd.a.c.get(((azqv)???).i);
            if (??? != null) {
              ((azpi)???).a((azpi)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (azpi)this.jdField_a_of_type_Bakd.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((azpi)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localbake.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Bakd.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (azpi)((azpi)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localbake.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((azpi)localbake.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((azpi)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((azpi)localObject7).b == null) || (localbake.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((azpi)localObject7).b.equals(((azpi)localbake.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((azpi)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((azpi)localObject4).jdField_a_of_type_JavaUtilMap.remove(((azpi)localObject7).b);
                  this.jdField_a_of_type_Bakd.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((azpi)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Bakd.a.d(localazpi1);
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
        localbake.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Bakd.a.a(null, false, str, l);
        continue;
        localbake.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Bakd.a.a(null, false, str, l);
        continue;
        if (localbake.jdField_a_of_type_JavaUtilList != null) {
          if ((localbake.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbake.jdField_a_of_type_Boolean) && (localbake.d <= 3))
          {
            localbake.d += 1;
            this.jdField_a_of_type_Bakd.a.b(str, l);
          }
          else
          {
            localbake.d = 0;
            this.jdField_a_of_type_Bakd.a.a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localbake.jdField_a_of_type_JavaUtilList != null) {
              if ((localbake.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbake.jdField_a_of_type_Boolean) && (localbake.d <= 3))
              {
                localbake.d += 1;
                localbake.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bakd.a.b(str, l);
              }
              else
              {
                localbake.jdField_b_of_type_Boolean = false;
                localbake.d = 0;
                this.jdField_a_of_type_Bakd.a.a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, str, l);
                continue;
                localbake.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Bakd.a.a(null, false, str, l);
                break label974;
                localbake.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bakd.a.a(null, false, str, l);
                break label974;
                if (localbake.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbake.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbake.jdField_a_of_type_Boolean) && (localbake.d <= 3))
                {
                  localbake.d += 1;
                  this.jdField_a_of_type_Bakd.a.b(str, l);
                  break label974;
                }
                localbake.d = 0;
                this.jdField_a_of_type_Bakd.a.a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localbake.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbake.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbake.jdField_a_of_type_Boolean) && (localbake.d <= 3))
                {
                  localbake.d += 1;
                  localbake.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bakd.a.b(str, l);
                  break label974;
                }
                localbake.jdField_b_of_type_Boolean = false;
                localbake.d = 0;
                this.jdField_a_of_type_Bakd.a.a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, str, l);
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