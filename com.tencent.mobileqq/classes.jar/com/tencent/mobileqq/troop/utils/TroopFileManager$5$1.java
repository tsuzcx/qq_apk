package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import bbnr;
import bbpe;
import bcil;
import bciq;
import bcir;
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
  public TroopFileManager$5$1(bciq parambciq, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    bcir localbcir;
    synchronized (this.jdField_a_of_type_Bciq.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localbcir = (bcir)this.jdField_a_of_type_Bciq.a.d.get(str + l);
      if (localbcir == null) {
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
          localbcir.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bciq.a.a(null, false, str, l);
          continue;
          localbcir.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bciq.a.a(null, false, str, l);
          continue;
          if (localbcir.jdField_a_of_type_JavaUtilList != null) {
            if ((localbcir.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcir.jdField_a_of_type_Boolean) && (localbcir.d <= 3))
            {
              localbcir.d += 1;
              this.jdField_a_of_type_Bciq.a.b(str, l);
            }
            else
            {
              localbcir.d = 0;
              this.jdField_a_of_type_Bciq.a.a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbcir.jdField_a_of_type_JavaUtilList != null) {
                if ((localbcir.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcir.jdField_a_of_type_Boolean) && (localbcir.d <= 3))
                {
                  localbcir.d += 1;
                  localbcir.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bciq.a.b(str, l);
                }
                else
                {
                  localbcir.jdField_b_of_type_Boolean = false;
                  localbcir.d = 0;
                  this.jdField_a_of_type_Bciq.a.a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbcir.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
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
          localbcir.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bciq.a.a(null, false, str, l);
          continue;
          localbcir.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bciq.a.a(null, false, str, l);
          continue;
          if (localbcir.jdField_a_of_type_JavaUtilList != null) {
            if ((localbcir.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcir.jdField_a_of_type_Boolean) && (localbcir.d <= 3))
            {
              localbcir.d += 1;
              this.jdField_a_of_type_Bciq.a.b(str, l);
            }
            else
            {
              localbcir.d = 0;
              this.jdField_a_of_type_Bciq.a.a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbcir.jdField_a_of_type_JavaUtilList != null) {
                if ((localbcir.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcir.jdField_a_of_type_Boolean) && (localbcir.d <= 3))
                {
                  localbcir.d += 1;
                  localbcir.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bciq.a.b(str, l);
                }
                else
                {
                  localbcir.jdField_b_of_type_Boolean = false;
                  localbcir.d = 0;
                  this.jdField_a_of_type_Bciq.a.a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbcir.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbcir.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localbcir.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Bciq.a.a();
      localbcir.jdField_a_of_type_JavaUtilList.clear();
      localbcir.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (bbnr)((Iterator)localObject2).next();
        this.jdField_a_of_type_Bciq.a.b.put(((bbnr)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Bciq.a.c.put(((bbnr)???).b, ???);
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
        localObject6 = this.jdField_a_of_type_Bciq.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
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
        localObject4 = (bbnr)((Iterator)localObject7).next();
        if (((bbnr)localObject4).jdField_d_of_type_Boolean)
        {
          if (((bbnr)localObject4).b == null) {
            continue;
          }
          ??? = (bbnr)this.jdField_a_of_type_Bciq.a.c.get(((bbnr)localObject4).b);
          if (??? == null)
          {
            ((bbnr)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Bciq.a.c.put(((bbnr)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (bbpe)localIterator.next();
              if (((bbnr)localObject4).b.equals(((bbpe)???).i))
              {
                bbnr localbbnr2 = new bbnr();
                localbbnr2.jdField_a_of_type_JavaUtilUUID = ((bbpe)???).jdField_a_of_type_JavaUtilUUID;
                localbbnr2.b = ((bbpe)???).e;
                localbbnr2.f = ((bbpe)???).i;
                localbbnr2.a((bbpe)???, this.jdField_a_of_type_Bciq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((bbnr)localObject4).a(localbbnr2);
              }
            }
            localbcir.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((bbnr)???).b((bbnr)localObject4);
          this.jdField_a_of_type_Bciq.a.b.put(((bbnr)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localbcir.jdField_a_of_type_JavaUtilMap.get(((bbnr)???).b) == null)
          {
            localbcir.jdField_a_of_type_JavaUtilList.add(???);
            localbcir.jdField_a_of_type_JavaUtilMap.put(((bbnr)???).b, ???);
          }
          this.jdField_a_of_type_Bciq.a.c.put(((bbnr)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((bbnr)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((bbnr)localObject4).b + ", sha = " + ((bbnr)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Bciq.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bbnr)localObject4).b);
        if (??? == null)
        {
          ((bbnr)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((bbnr)localObject4).jdField_d_of_type_Long = ((bbnr)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((bbnr)localObject4).e == 1) || (((bbnr)localObject4).e == 3) || (((bbnr)localObject4).e == 2) || (((bbnr)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (bbnr)this.jdField_a_of_type_Bciq.a.c.get(((bbnr)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((bbnr)???).b((bbnr)localObject4);
          localObject4 = ???;
          ((bbnr)localObject4).a(this.jdField_a_of_type_Bciq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bciq.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bciq.a.b.put(((bbnr)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localbcir.jdField_a_of_type_JavaUtilMap.get(((bbnr)localObject4).b) == null)
          {
            localbcir.jdField_a_of_type_JavaUtilList.add(localObject4);
            localbcir.jdField_a_of_type_JavaUtilMap.put(((bbnr)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Bciq.a.c.put(((bbnr)localObject4).b, localObject4);
          break;
          ((bbnr)localObject4).jdField_a_of_type_JavaUtilUUID = ((bbpe)???).jdField_a_of_type_JavaUtilUUID;
          ((bbnr)localObject4).a((bbpe)???, this.jdField_a_of_type_Bciq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((bbnr)localObject4).e == 9)
          {
            ??? = (bbnr)this.jdField_a_of_type_Bciq.a.c.get(((bbpe)???).i);
            if (??? != null) {
              ((bbnr)???).a((bbnr)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (bbnr)this.jdField_a_of_type_Bciq.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((bbnr)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localbcir.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Bciq.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (bbnr)((bbnr)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localbcir.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((bbnr)localbcir.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((bbnr)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((bbnr)localObject7).b == null) || (localbcir.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((bbnr)localObject7).b.equals(((bbnr)localbcir.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((bbnr)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((bbnr)localObject4).jdField_a_of_type_JavaUtilMap.remove(((bbnr)localObject7).b);
                  this.jdField_a_of_type_Bciq.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bbnr)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Bciq.a.d(localbbnr1);
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
        localbcir.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Bciq.a.a(null, false, str, l);
        continue;
        localbcir.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Bciq.a.a(null, false, str, l);
        continue;
        if (localbcir.jdField_a_of_type_JavaUtilList != null) {
          if ((localbcir.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcir.jdField_a_of_type_Boolean) && (localbcir.d <= 3))
          {
            localbcir.d += 1;
            this.jdField_a_of_type_Bciq.a.b(str, l);
          }
          else
          {
            localbcir.d = 0;
            this.jdField_a_of_type_Bciq.a.a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localbcir.jdField_a_of_type_JavaUtilList != null) {
              if ((localbcir.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcir.jdField_a_of_type_Boolean) && (localbcir.d <= 3))
              {
                localbcir.d += 1;
                localbcir.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bciq.a.b(str, l);
              }
              else
              {
                localbcir.jdField_b_of_type_Boolean = false;
                localbcir.d = 0;
                this.jdField_a_of_type_Bciq.a.a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, str, l);
                continue;
                localbcir.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Bciq.a.a(null, false, str, l);
                break label974;
                localbcir.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bciq.a.a(null, false, str, l);
                break label974;
                if (localbcir.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbcir.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcir.jdField_a_of_type_Boolean) && (localbcir.d <= 3))
                {
                  localbcir.d += 1;
                  this.jdField_a_of_type_Bciq.a.b(str, l);
                  break label974;
                }
                localbcir.d = 0;
                this.jdField_a_of_type_Bciq.a.a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localbcir.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbcir.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbcir.jdField_a_of_type_Boolean) && (localbcir.d <= 3))
                {
                  localbcir.d += 1;
                  localbcir.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bciq.a.b(str, l);
                  break label974;
                }
                localbcir.jdField_b_of_type_Boolean = false;
                localbcir.d = 0;
                this.jdField_a_of_type_Bciq.a.a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, str, l);
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