package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import bebc;
import becp;
import bfbb;
import bfbg;
import bfbh;
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
  public TroopFileManager$5$1(bfbg parambfbg, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    bfbh localbfbh;
    synchronized (this.jdField_a_of_type_Bfbg.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localbfbh = (bfbh)this.jdField_a_of_type_Bfbg.a.d.get(str + l);
      if (localbfbh == null) {
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
          localbfbh.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bfbg.a.a(null, false, str, l);
          continue;
          localbfbh.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bfbg.a.a(null, false, str, l);
          continue;
          if (localbfbh.jdField_a_of_type_JavaUtilList != null) {
            if ((localbfbh.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfbh.jdField_a_of_type_Boolean) && (localbfbh.d <= 3))
            {
              localbfbh.d += 1;
              this.jdField_a_of_type_Bfbg.a.b(str, l);
            }
            else
            {
              localbfbh.d = 0;
              this.jdField_a_of_type_Bfbg.a.a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbfbh.jdField_a_of_type_JavaUtilList != null) {
                if ((localbfbh.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfbh.jdField_a_of_type_Boolean) && (localbfbh.d <= 3))
                {
                  localbfbh.d += 1;
                  localbfbh.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bfbg.a.b(str, l);
                }
                else
                {
                  localbfbh.jdField_b_of_type_Boolean = false;
                  localbfbh.d = 0;
                  this.jdField_a_of_type_Bfbg.a.a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbfbh.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
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
          localbfbh.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bfbg.a.a(null, false, str, l);
          continue;
          localbfbh.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bfbg.a.a(null, false, str, l);
          continue;
          if (localbfbh.jdField_a_of_type_JavaUtilList != null) {
            if ((localbfbh.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfbh.jdField_a_of_type_Boolean) && (localbfbh.d <= 3))
            {
              localbfbh.d += 1;
              this.jdField_a_of_type_Bfbg.a.b(str, l);
            }
            else
            {
              localbfbh.d = 0;
              this.jdField_a_of_type_Bfbg.a.a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbfbh.jdField_a_of_type_JavaUtilList != null) {
                if ((localbfbh.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfbh.jdField_a_of_type_Boolean) && (localbfbh.d <= 3))
                {
                  localbfbh.d += 1;
                  localbfbh.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bfbg.a.b(str, l);
                }
                else
                {
                  localbfbh.jdField_b_of_type_Boolean = false;
                  localbfbh.d = 0;
                  this.jdField_a_of_type_Bfbg.a.a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbfbh.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbfbh.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localbfbh.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Bfbg.a.a();
      localbfbh.jdField_a_of_type_JavaUtilList.clear();
      localbfbh.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (bebc)((Iterator)localObject2).next();
        this.jdField_a_of_type_Bfbg.a.b.put(((bebc)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Bfbg.a.c.put(((bebc)???).b, ???);
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
        localObject6 = this.jdField_a_of_type_Bfbg.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
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
        localObject4 = (bebc)((Iterator)localObject7).next();
        if (((bebc)localObject4).jdField_d_of_type_Boolean)
        {
          if (((bebc)localObject4).b == null) {
            continue;
          }
          ??? = (bebc)this.jdField_a_of_type_Bfbg.a.c.get(((bebc)localObject4).b);
          if (??? == null)
          {
            ((bebc)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Bfbg.a.c.put(((bebc)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (becp)localIterator.next();
              if (((bebc)localObject4).b.equals(((becp)???).i))
              {
                bebc localbebc2 = new bebc();
                localbebc2.jdField_a_of_type_JavaUtilUUID = ((becp)???).jdField_a_of_type_JavaUtilUUID;
                localbebc2.b = ((becp)???).e;
                localbebc2.f = ((becp)???).i;
                localbebc2.a((becp)???, this.jdField_a_of_type_Bfbg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((bebc)localObject4).a(localbebc2);
              }
            }
            localbfbh.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((bebc)???).b((bebc)localObject4);
          this.jdField_a_of_type_Bfbg.a.b.put(((bebc)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localbfbh.jdField_a_of_type_JavaUtilMap.get(((bebc)???).b) == null)
          {
            localbfbh.jdField_a_of_type_JavaUtilList.add(???);
            localbfbh.jdField_a_of_type_JavaUtilMap.put(((bebc)???).b, ???);
          }
          this.jdField_a_of_type_Bfbg.a.c.put(((bebc)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((bebc)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((bebc)localObject4).b + ", sha = " + ((bebc)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Bfbg.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bebc)localObject4).b);
        if (??? == null)
        {
          ((bebc)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((bebc)localObject4).jdField_d_of_type_Long = ((bebc)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((bebc)localObject4).e == 1) || (((bebc)localObject4).e == 3) || (((bebc)localObject4).e == 2) || (((bebc)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (bebc)this.jdField_a_of_type_Bfbg.a.c.get(((bebc)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((bebc)???).b((bebc)localObject4);
          localObject4 = ???;
          ((bebc)localObject4).a(this.jdField_a_of_type_Bfbg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfbg.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bfbg.a.b.put(((bebc)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localbfbh.jdField_a_of_type_JavaUtilMap.get(((bebc)localObject4).b) == null)
          {
            localbfbh.jdField_a_of_type_JavaUtilList.add(localObject4);
            localbfbh.jdField_a_of_type_JavaUtilMap.put(((bebc)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Bfbg.a.c.put(((bebc)localObject4).b, localObject4);
          break;
          ((bebc)localObject4).jdField_a_of_type_JavaUtilUUID = ((becp)???).jdField_a_of_type_JavaUtilUUID;
          ((bebc)localObject4).a((becp)???, this.jdField_a_of_type_Bfbg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((bebc)localObject4).e == 9)
          {
            ??? = (bebc)this.jdField_a_of_type_Bfbg.a.c.get(((becp)???).i);
            if (??? != null) {
              ((bebc)???).a((bebc)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (bebc)this.jdField_a_of_type_Bfbg.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((bebc)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localbfbh.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Bfbg.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (bebc)((bebc)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localbfbh.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((bebc)localbfbh.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((bebc)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((bebc)localObject7).b == null) || (localbfbh.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((bebc)localObject7).b.equals(((bebc)localbfbh.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((bebc)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((bebc)localObject4).jdField_a_of_type_JavaUtilMap.remove(((bebc)localObject7).b);
                  this.jdField_a_of_type_Bfbg.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bebc)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Bfbg.a.d(localbebc1);
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
        localbfbh.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Bfbg.a.a(null, false, str, l);
        continue;
        localbfbh.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Bfbg.a.a(null, false, str, l);
        continue;
        if (localbfbh.jdField_a_of_type_JavaUtilList != null) {
          if ((localbfbh.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfbh.jdField_a_of_type_Boolean) && (localbfbh.d <= 3))
          {
            localbfbh.d += 1;
            this.jdField_a_of_type_Bfbg.a.b(str, l);
          }
          else
          {
            localbfbh.d = 0;
            this.jdField_a_of_type_Bfbg.a.a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localbfbh.jdField_a_of_type_JavaUtilList != null) {
              if ((localbfbh.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfbh.jdField_a_of_type_Boolean) && (localbfbh.d <= 3))
              {
                localbfbh.d += 1;
                localbfbh.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bfbg.a.b(str, l);
              }
              else
              {
                localbfbh.jdField_b_of_type_Boolean = false;
                localbfbh.d = 0;
                this.jdField_a_of_type_Bfbg.a.a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, str, l);
                continue;
                localbfbh.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Bfbg.a.a(null, false, str, l);
                break label974;
                localbfbh.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bfbg.a.a(null, false, str, l);
                break label974;
                if (localbfbh.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbfbh.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfbh.jdField_a_of_type_Boolean) && (localbfbh.d <= 3))
                {
                  localbfbh.d += 1;
                  this.jdField_a_of_type_Bfbg.a.b(str, l);
                  break label974;
                }
                localbfbh.d = 0;
                this.jdField_a_of_type_Bfbg.a.a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localbfbh.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbfbh.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbfbh.jdField_a_of_type_Boolean) && (localbfbh.d <= 3))
                {
                  localbfbh.d += 1;
                  localbfbh.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bfbg.a.b(str, l);
                  break label974;
                }
                localbfbh.jdField_b_of_type_Boolean = false;
                localbfbh.d = 0;
                this.jdField_a_of_type_Bfbg.a.a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, str, l);
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