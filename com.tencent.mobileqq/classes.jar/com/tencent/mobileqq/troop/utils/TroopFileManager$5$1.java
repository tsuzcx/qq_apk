package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import bbsa;
import bbtn;
import bcmu;
import bcmz;
import bcna;
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
  public TroopFileManager$5$1(bcmz parambcmz, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    bcna localbcna;
    synchronized (this.jdField_a_of_type_Bcmz.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localbcna = (bcna)this.jdField_a_of_type_Bcmz.a.d.get(str + l);
      if (localbcna == null) {
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
          localbcna.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bcmz.a.a(null, false, str, l);
          continue;
          localbcna.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bcmz.a.a(null, false, str, l);
          continue;
          if (localbcna.jdField_a_of_type_JavaUtilList != null) {
            if ((localbcna.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcna.jdField_a_of_type_Boolean) && (localbcna.d <= 3))
            {
              localbcna.d += 1;
              this.jdField_a_of_type_Bcmz.a.b(str, l);
            }
            else
            {
              localbcna.d = 0;
              this.jdField_a_of_type_Bcmz.a.a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbcna.jdField_a_of_type_JavaUtilList != null) {
                if ((localbcna.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcna.jdField_a_of_type_Boolean) && (localbcna.d <= 3))
                {
                  localbcna.d += 1;
                  localbcna.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bcmz.a.b(str, l);
                }
                else
                {
                  localbcna.jdField_b_of_type_Boolean = false;
                  localbcna.d = 0;
                  this.jdField_a_of_type_Bcmz.a.a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbcna.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
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
          localbcna.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bcmz.a.a(null, false, str, l);
          continue;
          localbcna.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bcmz.a.a(null, false, str, l);
          continue;
          if (localbcna.jdField_a_of_type_JavaUtilList != null) {
            if ((localbcna.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcna.jdField_a_of_type_Boolean) && (localbcna.d <= 3))
            {
              localbcna.d += 1;
              this.jdField_a_of_type_Bcmz.a.b(str, l);
            }
            else
            {
              localbcna.d = 0;
              this.jdField_a_of_type_Bcmz.a.a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbcna.jdField_a_of_type_JavaUtilList != null) {
                if ((localbcna.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcna.jdField_a_of_type_Boolean) && (localbcna.d <= 3))
                {
                  localbcna.d += 1;
                  localbcna.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bcmz.a.b(str, l);
                }
                else
                {
                  localbcna.jdField_b_of_type_Boolean = false;
                  localbcna.d = 0;
                  this.jdField_a_of_type_Bcmz.a.a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbcna.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbcna.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localbcna.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Bcmz.a.a();
      localbcna.jdField_a_of_type_JavaUtilList.clear();
      localbcna.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (bbsa)((Iterator)localObject2).next();
        this.jdField_a_of_type_Bcmz.a.b.put(((bbsa)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Bcmz.a.c.put(((bbsa)???).b, ???);
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
        localObject6 = this.jdField_a_of_type_Bcmz.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
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
        localObject4 = (bbsa)((Iterator)localObject7).next();
        if (((bbsa)localObject4).jdField_d_of_type_Boolean)
        {
          if (((bbsa)localObject4).b == null) {
            continue;
          }
          ??? = (bbsa)this.jdField_a_of_type_Bcmz.a.c.get(((bbsa)localObject4).b);
          if (??? == null)
          {
            ((bbsa)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Bcmz.a.c.put(((bbsa)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (bbtn)localIterator.next();
              if (((bbsa)localObject4).b.equals(((bbtn)???).i))
              {
                bbsa localbbsa2 = new bbsa();
                localbbsa2.jdField_a_of_type_JavaUtilUUID = ((bbtn)???).jdField_a_of_type_JavaUtilUUID;
                localbbsa2.b = ((bbtn)???).e;
                localbbsa2.f = ((bbtn)???).i;
                localbbsa2.a((bbtn)???, this.jdField_a_of_type_Bcmz.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((bbsa)localObject4).a(localbbsa2);
              }
            }
            localbcna.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((bbsa)???).b((bbsa)localObject4);
          this.jdField_a_of_type_Bcmz.a.b.put(((bbsa)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localbcna.jdField_a_of_type_JavaUtilMap.get(((bbsa)???).b) == null)
          {
            localbcna.jdField_a_of_type_JavaUtilList.add(???);
            localbcna.jdField_a_of_type_JavaUtilMap.put(((bbsa)???).b, ???);
          }
          this.jdField_a_of_type_Bcmz.a.c.put(((bbsa)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((bbsa)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((bbsa)localObject4).b + ", sha = " + ((bbsa)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Bcmz.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bbsa)localObject4).b);
        if (??? == null)
        {
          ((bbsa)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((bbsa)localObject4).jdField_d_of_type_Long = ((bbsa)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((bbsa)localObject4).e == 1) || (((bbsa)localObject4).e == 3) || (((bbsa)localObject4).e == 2) || (((bbsa)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (bbsa)this.jdField_a_of_type_Bcmz.a.c.get(((bbsa)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((bbsa)???).b((bbsa)localObject4);
          localObject4 = ???;
          ((bbsa)localObject4).a(this.jdField_a_of_type_Bcmz.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcmz.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bcmz.a.b.put(((bbsa)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localbcna.jdField_a_of_type_JavaUtilMap.get(((bbsa)localObject4).b) == null)
          {
            localbcna.jdField_a_of_type_JavaUtilList.add(localObject4);
            localbcna.jdField_a_of_type_JavaUtilMap.put(((bbsa)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Bcmz.a.c.put(((bbsa)localObject4).b, localObject4);
          break;
          ((bbsa)localObject4).jdField_a_of_type_JavaUtilUUID = ((bbtn)???).jdField_a_of_type_JavaUtilUUID;
          ((bbsa)localObject4).a((bbtn)???, this.jdField_a_of_type_Bcmz.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((bbsa)localObject4).e == 9)
          {
            ??? = (bbsa)this.jdField_a_of_type_Bcmz.a.c.get(((bbtn)???).i);
            if (??? != null) {
              ((bbsa)???).a((bbsa)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (bbsa)this.jdField_a_of_type_Bcmz.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((bbsa)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localbcna.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Bcmz.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (bbsa)((bbsa)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localbcna.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((bbsa)localbcna.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((bbsa)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((bbsa)localObject7).b == null) || (localbcna.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((bbsa)localObject7).b.equals(((bbsa)localbcna.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((bbsa)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((bbsa)localObject4).jdField_a_of_type_JavaUtilMap.remove(((bbsa)localObject7).b);
                  this.jdField_a_of_type_Bcmz.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bbsa)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Bcmz.a.d(localbbsa1);
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
        localbcna.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Bcmz.a.a(null, false, str, l);
        continue;
        localbcna.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Bcmz.a.a(null, false, str, l);
        continue;
        if (localbcna.jdField_a_of_type_JavaUtilList != null) {
          if ((localbcna.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcna.jdField_a_of_type_Boolean) && (localbcna.d <= 3))
          {
            localbcna.d += 1;
            this.jdField_a_of_type_Bcmz.a.b(str, l);
          }
          else
          {
            localbcna.d = 0;
            this.jdField_a_of_type_Bcmz.a.a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localbcna.jdField_a_of_type_JavaUtilList != null) {
              if ((localbcna.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcna.jdField_a_of_type_Boolean) && (localbcna.d <= 3))
              {
                localbcna.d += 1;
                localbcna.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bcmz.a.b(str, l);
              }
              else
              {
                localbcna.jdField_b_of_type_Boolean = false;
                localbcna.d = 0;
                this.jdField_a_of_type_Bcmz.a.a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, str, l);
                continue;
                localbcna.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Bcmz.a.a(null, false, str, l);
                break label974;
                localbcna.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bcmz.a.a(null, false, str, l);
                break label974;
                if (localbcna.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbcna.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcna.jdField_a_of_type_Boolean) && (localbcna.d <= 3))
                {
                  localbcna.d += 1;
                  this.jdField_a_of_type_Bcmz.a.b(str, l);
                  break label974;
                }
                localbcna.d = 0;
                this.jdField_a_of_type_Bcmz.a.a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localbcna.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbcna.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcna.jdField_a_of_type_Boolean) && (localbcna.d <= 3))
                {
                  localbcna.d += 1;
                  localbcna.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bcmz.a.b(str, l);
                  break label974;
                }
                localbcna.jdField_b_of_type_Boolean = false;
                localbcna.d = 0;
                this.jdField_a_of_type_Bcmz.a.a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, str, l);
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