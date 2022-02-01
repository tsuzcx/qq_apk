package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import bfif;
import bfjs;
import bgjh;
import bgjm;
import bgjn;
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
  public TroopFileManager$5$1(bgjm parambgjm, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    bgjn localbgjn;
    synchronized (this.jdField_a_of_type_Bgjm.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localbgjn = (bgjn)this.jdField_a_of_type_Bgjm.a.d.get(str + l);
      if (localbgjn == null) {
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
          localbgjn.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bgjm.a.a(null, false, str, l);
          continue;
          localbgjn.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bgjm.a.a(null, false, str, l);
          continue;
          if (localbgjn.jdField_a_of_type_JavaUtilList != null) {
            if ((localbgjn.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgjn.jdField_a_of_type_Boolean) && (localbgjn.d <= 3))
            {
              localbgjn.d += 1;
              this.jdField_a_of_type_Bgjm.a.b(str, l);
            }
            else
            {
              localbgjn.d = 0;
              this.jdField_a_of_type_Bgjm.a.a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbgjn.jdField_a_of_type_JavaUtilList != null) {
                if ((localbgjn.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgjn.jdField_a_of_type_Boolean) && (localbgjn.d <= 3))
                {
                  localbgjn.d += 1;
                  localbgjn.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bgjm.a.b(str, l);
                }
                else
                {
                  localbgjn.jdField_b_of_type_Boolean = false;
                  localbgjn.d = 0;
                  this.jdField_a_of_type_Bgjm.a.a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbgjn.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
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
          localbgjn.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bgjm.a.a(null, false, str, l);
          continue;
          localbgjn.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bgjm.a.a(null, false, str, l);
          continue;
          if (localbgjn.jdField_a_of_type_JavaUtilList != null) {
            if ((localbgjn.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgjn.jdField_a_of_type_Boolean) && (localbgjn.d <= 3))
            {
              localbgjn.d += 1;
              this.jdField_a_of_type_Bgjm.a.b(str, l);
            }
            else
            {
              localbgjn.d = 0;
              this.jdField_a_of_type_Bgjm.a.a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbgjn.jdField_a_of_type_JavaUtilList != null) {
                if ((localbgjn.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgjn.jdField_a_of_type_Boolean) && (localbgjn.d <= 3))
                {
                  localbgjn.d += 1;
                  localbgjn.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bgjm.a.b(str, l);
                }
                else
                {
                  localbgjn.jdField_b_of_type_Boolean = false;
                  localbgjn.d = 0;
                  this.jdField_a_of_type_Bgjm.a.a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbgjn.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbgjn.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localbgjn.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Bgjm.a.a();
      localbgjn.jdField_a_of_type_JavaUtilList.clear();
      localbgjn.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (bfif)((Iterator)localObject2).next();
        this.jdField_a_of_type_Bgjm.a.b.put(((bfif)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Bgjm.a.c.put(((bfif)???).b, ???);
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
        localObject6 = this.jdField_a_of_type_Bgjm.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
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
        localObject4 = (bfif)((Iterator)localObject7).next();
        if (((bfif)localObject4).jdField_d_of_type_Boolean)
        {
          if (((bfif)localObject4).b == null) {
            continue;
          }
          ??? = (bfif)this.jdField_a_of_type_Bgjm.a.c.get(((bfif)localObject4).b);
          if (??? == null)
          {
            ((bfif)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Bgjm.a.c.put(((bfif)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (bfjs)localIterator.next();
              if (((bfif)localObject4).b.equals(((bfjs)???).i))
              {
                bfif localbfif2 = new bfif();
                localbfif2.jdField_a_of_type_JavaUtilUUID = ((bfjs)???).jdField_a_of_type_JavaUtilUUID;
                localbfif2.b = ((bfjs)???).e;
                localbfif2.g = ((bfjs)???).i;
                localbfif2.a((bfjs)???, this.jdField_a_of_type_Bgjm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((bfif)localObject4).a(localbfif2);
              }
            }
            localbgjn.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((bfif)???).b((bfif)localObject4);
          this.jdField_a_of_type_Bgjm.a.b.put(((bfif)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localbgjn.jdField_a_of_type_JavaUtilMap.get(((bfif)???).b) == null)
          {
            localbgjn.jdField_a_of_type_JavaUtilList.add(???);
            localbgjn.jdField_a_of_type_JavaUtilMap.put(((bfif)???).b, ???);
          }
          this.jdField_a_of_type_Bgjm.a.c.put(((bfif)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((bfif)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((bfif)localObject4).b + ", sha = " + ((bfif)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Bgjm.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bfif)localObject4).b);
        if (??? == null)
        {
          ((bfif)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((bfif)localObject4).jdField_d_of_type_Long = ((bfif)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((bfif)localObject4).e == 1) || (((bfif)localObject4).e == 3) || (((bfif)localObject4).e == 2) || (((bfif)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (bfif)this.jdField_a_of_type_Bgjm.a.c.get(((bfif)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((bfif)???).b((bfif)localObject4);
          localObject4 = ???;
          ((bfif)localObject4).a(this.jdField_a_of_type_Bgjm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgjm.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bgjm.a.b.put(((bfif)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localbgjn.jdField_a_of_type_JavaUtilMap.get(((bfif)localObject4).b) == null)
          {
            localbgjn.jdField_a_of_type_JavaUtilList.add(localObject4);
            localbgjn.jdField_a_of_type_JavaUtilMap.put(((bfif)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Bgjm.a.c.put(((bfif)localObject4).b, localObject4);
          break;
          ((bfif)localObject4).jdField_a_of_type_JavaUtilUUID = ((bfjs)???).jdField_a_of_type_JavaUtilUUID;
          ((bfif)localObject4).a((bfjs)???, this.jdField_a_of_type_Bgjm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((bfif)localObject4).e == 9)
          {
            ??? = (bfif)this.jdField_a_of_type_Bgjm.a.c.get(((bfjs)???).i);
            if (??? != null) {
              ((bfif)???).a((bfif)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (bfif)this.jdField_a_of_type_Bgjm.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((bfif)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localbgjn.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Bgjm.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (bfif)((bfif)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localbgjn.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((bfif)localbgjn.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((bfif)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((bfif)localObject7).b == null) || (localbgjn.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((bfif)localObject7).b.equals(((bfif)localbgjn.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((bfif)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((bfif)localObject4).jdField_a_of_type_JavaUtilMap.remove(((bfif)localObject7).b);
                  this.jdField_a_of_type_Bgjm.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bfif)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Bgjm.a.d(localbfif1);
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
        localbgjn.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Bgjm.a.a(null, false, str, l);
        continue;
        localbgjn.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Bgjm.a.a(null, false, str, l);
        continue;
        if (localbgjn.jdField_a_of_type_JavaUtilList != null) {
          if ((localbgjn.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgjn.jdField_a_of_type_Boolean) && (localbgjn.d <= 3))
          {
            localbgjn.d += 1;
            this.jdField_a_of_type_Bgjm.a.b(str, l);
          }
          else
          {
            localbgjn.d = 0;
            this.jdField_a_of_type_Bgjm.a.a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localbgjn.jdField_a_of_type_JavaUtilList != null) {
              if ((localbgjn.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgjn.jdField_a_of_type_Boolean) && (localbgjn.d <= 3))
              {
                localbgjn.d += 1;
                localbgjn.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bgjm.a.b(str, l);
              }
              else
              {
                localbgjn.jdField_b_of_type_Boolean = false;
                localbgjn.d = 0;
                this.jdField_a_of_type_Bgjm.a.a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, str, l);
                continue;
                localbgjn.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Bgjm.a.a(null, false, str, l);
                break label974;
                localbgjn.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bgjm.a.a(null, false, str, l);
                break label974;
                if (localbgjn.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbgjn.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgjn.jdField_a_of_type_Boolean) && (localbgjn.d <= 3))
                {
                  localbgjn.d += 1;
                  this.jdField_a_of_type_Bgjm.a.b(str, l);
                  break label974;
                }
                localbgjn.d = 0;
                this.jdField_a_of_type_Bgjm.a.a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localbgjn.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbgjn.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgjn.jdField_a_of_type_Boolean) && (localbgjn.d <= 3))
                {
                  localbgjn.d += 1;
                  localbgjn.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bgjm.a.b(str, l);
                  break label974;
                }
                localbgjn.jdField_b_of_type_Boolean = false;
                localbgjn.d = 0;
                this.jdField_a_of_type_Bgjm.a.a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, str, l);
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