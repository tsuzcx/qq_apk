package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import besl;
import bety;
import bfrm;
import bfrr;
import bfrs;
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
  public TroopFileManager$5$1(bfrr parambfrr, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    bfrs localbfrs;
    synchronized (this.jdField_a_of_type_Bfrr.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localbfrs = (bfrs)this.jdField_a_of_type_Bfrr.a.d.get(str + l);
      if (localbfrs == null) {
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
          localbfrs.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bfrr.a.a(null, false, str, l);
          continue;
          localbfrs.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bfrr.a.a(null, false, str, l);
          continue;
          if (localbfrs.jdField_a_of_type_JavaUtilList != null) {
            if ((localbfrs.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfrs.jdField_a_of_type_Boolean) && (localbfrs.d <= 3))
            {
              localbfrs.d += 1;
              this.jdField_a_of_type_Bfrr.a.b(str, l);
            }
            else
            {
              localbfrs.d = 0;
              this.jdField_a_of_type_Bfrr.a.a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbfrs.jdField_a_of_type_JavaUtilList != null) {
                if ((localbfrs.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfrs.jdField_a_of_type_Boolean) && (localbfrs.d <= 3))
                {
                  localbfrs.d += 1;
                  localbfrs.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bfrr.a.b(str, l);
                }
                else
                {
                  localbfrs.jdField_b_of_type_Boolean = false;
                  localbfrs.d = 0;
                  this.jdField_a_of_type_Bfrr.a.a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbfrs.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
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
          localbfrs.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bfrr.a.a(null, false, str, l);
          continue;
          localbfrs.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bfrr.a.a(null, false, str, l);
          continue;
          if (localbfrs.jdField_a_of_type_JavaUtilList != null) {
            if ((localbfrs.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfrs.jdField_a_of_type_Boolean) && (localbfrs.d <= 3))
            {
              localbfrs.d += 1;
              this.jdField_a_of_type_Bfrr.a.b(str, l);
            }
            else
            {
              localbfrs.d = 0;
              this.jdField_a_of_type_Bfrr.a.a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbfrs.jdField_a_of_type_JavaUtilList != null) {
                if ((localbfrs.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfrs.jdField_a_of_type_Boolean) && (localbfrs.d <= 3))
                {
                  localbfrs.d += 1;
                  localbfrs.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bfrr.a.b(str, l);
                }
                else
                {
                  localbfrs.jdField_b_of_type_Boolean = false;
                  localbfrs.d = 0;
                  this.jdField_a_of_type_Bfrr.a.a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbfrs.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbfrs.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localbfrs.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Bfrr.a.a();
      localbfrs.jdField_a_of_type_JavaUtilList.clear();
      localbfrs.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (besl)((Iterator)localObject2).next();
        this.jdField_a_of_type_Bfrr.a.b.put(((besl)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Bfrr.a.c.put(((besl)???).b, ???);
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
        localObject6 = this.jdField_a_of_type_Bfrr.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
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
        localObject4 = (besl)((Iterator)localObject7).next();
        if (((besl)localObject4).jdField_d_of_type_Boolean)
        {
          if (((besl)localObject4).b == null) {
            continue;
          }
          ??? = (besl)this.jdField_a_of_type_Bfrr.a.c.get(((besl)localObject4).b);
          if (??? == null)
          {
            ((besl)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Bfrr.a.c.put(((besl)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (bety)localIterator.next();
              if (((besl)localObject4).b.equals(((bety)???).i))
              {
                besl localbesl2 = new besl();
                localbesl2.jdField_a_of_type_JavaUtilUUID = ((bety)???).jdField_a_of_type_JavaUtilUUID;
                localbesl2.b = ((bety)???).e;
                localbesl2.f = ((bety)???).i;
                localbesl2.a((bety)???, this.jdField_a_of_type_Bfrr.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((besl)localObject4).a(localbesl2);
              }
            }
            localbfrs.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((besl)???).b((besl)localObject4);
          this.jdField_a_of_type_Bfrr.a.b.put(((besl)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localbfrs.jdField_a_of_type_JavaUtilMap.get(((besl)???).b) == null)
          {
            localbfrs.jdField_a_of_type_JavaUtilList.add(???);
            localbfrs.jdField_a_of_type_JavaUtilMap.put(((besl)???).b, ???);
          }
          this.jdField_a_of_type_Bfrr.a.c.put(((besl)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((besl)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((besl)localObject4).b + ", sha = " + ((besl)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Bfrr.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((besl)localObject4).b);
        if (??? == null)
        {
          ((besl)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((besl)localObject4).jdField_d_of_type_Long = ((besl)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((besl)localObject4).e == 1) || (((besl)localObject4).e == 3) || (((besl)localObject4).e == 2) || (((besl)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (besl)this.jdField_a_of_type_Bfrr.a.c.get(((besl)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((besl)???).b((besl)localObject4);
          localObject4 = ???;
          ((besl)localObject4).a(this.jdField_a_of_type_Bfrr.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfrr.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bfrr.a.b.put(((besl)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localbfrs.jdField_a_of_type_JavaUtilMap.get(((besl)localObject4).b) == null)
          {
            localbfrs.jdField_a_of_type_JavaUtilList.add(localObject4);
            localbfrs.jdField_a_of_type_JavaUtilMap.put(((besl)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Bfrr.a.c.put(((besl)localObject4).b, localObject4);
          break;
          ((besl)localObject4).jdField_a_of_type_JavaUtilUUID = ((bety)???).jdField_a_of_type_JavaUtilUUID;
          ((besl)localObject4).a((bety)???, this.jdField_a_of_type_Bfrr.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((besl)localObject4).e == 9)
          {
            ??? = (besl)this.jdField_a_of_type_Bfrr.a.c.get(((bety)???).i);
            if (??? != null) {
              ((besl)???).a((besl)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (besl)this.jdField_a_of_type_Bfrr.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((besl)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localbfrs.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Bfrr.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (besl)((besl)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localbfrs.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((besl)localbfrs.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((besl)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((besl)localObject7).b == null) || (localbfrs.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((besl)localObject7).b.equals(((besl)localbfrs.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((besl)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((besl)localObject4).jdField_a_of_type_JavaUtilMap.remove(((besl)localObject7).b);
                  this.jdField_a_of_type_Bfrr.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((besl)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Bfrr.a.d(localbesl1);
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
        localbfrs.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Bfrr.a.a(null, false, str, l);
        continue;
        localbfrs.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Bfrr.a.a(null, false, str, l);
        continue;
        if (localbfrs.jdField_a_of_type_JavaUtilList != null) {
          if ((localbfrs.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfrs.jdField_a_of_type_Boolean) && (localbfrs.d <= 3))
          {
            localbfrs.d += 1;
            this.jdField_a_of_type_Bfrr.a.b(str, l);
          }
          else
          {
            localbfrs.d = 0;
            this.jdField_a_of_type_Bfrr.a.a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localbfrs.jdField_a_of_type_JavaUtilList != null) {
              if ((localbfrs.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfrs.jdField_a_of_type_Boolean) && (localbfrs.d <= 3))
              {
                localbfrs.d += 1;
                localbfrs.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bfrr.a.b(str, l);
              }
              else
              {
                localbfrs.jdField_b_of_type_Boolean = false;
                localbfrs.d = 0;
                this.jdField_a_of_type_Bfrr.a.a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, str, l);
                continue;
                localbfrs.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Bfrr.a.a(null, false, str, l);
                break label974;
                localbfrs.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bfrr.a.a(null, false, str, l);
                break label974;
                if (localbfrs.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbfrs.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfrs.jdField_a_of_type_Boolean) && (localbfrs.d <= 3))
                {
                  localbfrs.d += 1;
                  this.jdField_a_of_type_Bfrr.a.b(str, l);
                  break label974;
                }
                localbfrs.d = 0;
                this.jdField_a_of_type_Bfrr.a.a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localbfrs.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbfrs.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfrs.jdField_a_of_type_Boolean) && (localbfrs.d <= 3))
                {
                  localbfrs.d += 1;
                  localbfrs.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bfrr.a.b(str, l);
                  break label974;
                }
                localbfrs.jdField_b_of_type_Boolean = false;
                localbfrs.d = 0;
                this.jdField_a_of_type_Bfrr.a.a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, str, l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.5.1
 * JD-Core Version:    0.7.0.1
 */