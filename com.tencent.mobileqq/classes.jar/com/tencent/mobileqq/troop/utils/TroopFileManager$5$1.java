package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import bfrs;
import bftf;
import bgrn;
import bgrs;
import bgrt;
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
  public TroopFileManager$5$1(bgrs parambgrs, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    bgrt localbgrt;
    synchronized (this.jdField_a_of_type_Bgrs.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localbgrt = (bgrt)this.jdField_a_of_type_Bgrs.a.d.get(str + l);
      if (localbgrt == null) {
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
          localbgrt.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bgrs.a.a(null, false, str, l);
          continue;
          localbgrt.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bgrs.a.a(null, false, str, l);
          continue;
          if (localbgrt.jdField_a_of_type_JavaUtilList != null) {
            if ((localbgrt.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgrt.jdField_a_of_type_Boolean) && (localbgrt.d <= 3))
            {
              localbgrt.d += 1;
              this.jdField_a_of_type_Bgrs.a.b(str, l);
            }
            else
            {
              localbgrt.d = 0;
              this.jdField_a_of_type_Bgrs.a.a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbgrt.jdField_a_of_type_JavaUtilList != null) {
                if ((localbgrt.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgrt.jdField_a_of_type_Boolean) && (localbgrt.d <= 3))
                {
                  localbgrt.d += 1;
                  localbgrt.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bgrs.a.b(str, l);
                }
                else
                {
                  localbgrt.jdField_b_of_type_Boolean = false;
                  localbgrt.d = 0;
                  this.jdField_a_of_type_Bgrs.a.a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbgrt.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
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
          localbgrt.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bgrs.a.a(null, false, str, l);
          continue;
          localbgrt.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bgrs.a.a(null, false, str, l);
          continue;
          if (localbgrt.jdField_a_of_type_JavaUtilList != null) {
            if ((localbgrt.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgrt.jdField_a_of_type_Boolean) && (localbgrt.d <= 3))
            {
              localbgrt.d += 1;
              this.jdField_a_of_type_Bgrs.a.b(str, l);
            }
            else
            {
              localbgrt.d = 0;
              this.jdField_a_of_type_Bgrs.a.a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbgrt.jdField_a_of_type_JavaUtilList != null) {
                if ((localbgrt.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgrt.jdField_a_of_type_Boolean) && (localbgrt.d <= 3))
                {
                  localbgrt.d += 1;
                  localbgrt.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bgrs.a.b(str, l);
                }
                else
                {
                  localbgrt.jdField_b_of_type_Boolean = false;
                  localbgrt.d = 0;
                  this.jdField_a_of_type_Bgrs.a.a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbgrt.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbgrt.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localbgrt.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Bgrs.a.a();
      localbgrt.jdField_a_of_type_JavaUtilList.clear();
      localbgrt.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (bfrs)((Iterator)localObject2).next();
        this.jdField_a_of_type_Bgrs.a.b.put(((bfrs)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Bgrs.a.c.put(((bfrs)???).b, ???);
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
        localObject6 = this.jdField_a_of_type_Bgrs.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
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
        localObject4 = (bfrs)((Iterator)localObject7).next();
        if (((bfrs)localObject4).jdField_d_of_type_Boolean)
        {
          if (((bfrs)localObject4).b == null) {
            continue;
          }
          ??? = (bfrs)this.jdField_a_of_type_Bgrs.a.c.get(((bfrs)localObject4).b);
          if (??? == null)
          {
            ((bfrs)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Bgrs.a.c.put(((bfrs)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (bftf)localIterator.next();
              if (((bfrs)localObject4).b.equals(((bftf)???).i))
              {
                bfrs localbfrs2 = new bfrs();
                localbfrs2.jdField_a_of_type_JavaUtilUUID = ((bftf)???).jdField_a_of_type_JavaUtilUUID;
                localbfrs2.b = ((bftf)???).e;
                localbfrs2.f = ((bftf)???).i;
                localbfrs2.a((bftf)???, this.jdField_a_of_type_Bgrs.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((bfrs)localObject4).a(localbfrs2);
              }
            }
            localbgrt.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((bfrs)???).b((bfrs)localObject4);
          this.jdField_a_of_type_Bgrs.a.b.put(((bfrs)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localbgrt.jdField_a_of_type_JavaUtilMap.get(((bfrs)???).b) == null)
          {
            localbgrt.jdField_a_of_type_JavaUtilList.add(???);
            localbgrt.jdField_a_of_type_JavaUtilMap.put(((bfrs)???).b, ???);
          }
          this.jdField_a_of_type_Bgrs.a.c.put(((bfrs)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((bfrs)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((bfrs)localObject4).b + ", sha = " + ((bfrs)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Bgrs.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bfrs)localObject4).b);
        if (??? == null)
        {
          ((bfrs)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((bfrs)localObject4).jdField_d_of_type_Long = ((bfrs)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((bfrs)localObject4).e == 1) || (((bfrs)localObject4).e == 3) || (((bfrs)localObject4).e == 2) || (((bfrs)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (bfrs)this.jdField_a_of_type_Bgrs.a.c.get(((bfrs)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((bfrs)???).b((bfrs)localObject4);
          localObject4 = ???;
          ((bfrs)localObject4).a(this.jdField_a_of_type_Bgrs.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgrs.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bgrs.a.b.put(((bfrs)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localbgrt.jdField_a_of_type_JavaUtilMap.get(((bfrs)localObject4).b) == null)
          {
            localbgrt.jdField_a_of_type_JavaUtilList.add(localObject4);
            localbgrt.jdField_a_of_type_JavaUtilMap.put(((bfrs)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Bgrs.a.c.put(((bfrs)localObject4).b, localObject4);
          break;
          ((bfrs)localObject4).jdField_a_of_type_JavaUtilUUID = ((bftf)???).jdField_a_of_type_JavaUtilUUID;
          ((bfrs)localObject4).a((bftf)???, this.jdField_a_of_type_Bgrs.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((bfrs)localObject4).e == 9)
          {
            ??? = (bfrs)this.jdField_a_of_type_Bgrs.a.c.get(((bftf)???).i);
            if (??? != null) {
              ((bfrs)???).a((bfrs)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (bfrs)this.jdField_a_of_type_Bgrs.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((bfrs)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localbgrt.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Bgrs.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (bfrs)((bfrs)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localbgrt.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((bfrs)localbgrt.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((bfrs)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((bfrs)localObject7).b == null) || (localbgrt.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((bfrs)localObject7).b.equals(((bfrs)localbgrt.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((bfrs)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((bfrs)localObject4).jdField_a_of_type_JavaUtilMap.remove(((bfrs)localObject7).b);
                  this.jdField_a_of_type_Bgrs.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((bfrs)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Bgrs.a.d(localbfrs1);
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
        localbgrt.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Bgrs.a.a(null, false, str, l);
        continue;
        localbgrt.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Bgrs.a.a(null, false, str, l);
        continue;
        if (localbgrt.jdField_a_of_type_JavaUtilList != null) {
          if ((localbgrt.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgrt.jdField_a_of_type_Boolean) && (localbgrt.d <= 3))
          {
            localbgrt.d += 1;
            this.jdField_a_of_type_Bgrs.a.b(str, l);
          }
          else
          {
            localbgrt.d = 0;
            this.jdField_a_of_type_Bgrs.a.a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localbgrt.jdField_a_of_type_JavaUtilList != null) {
              if ((localbgrt.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgrt.jdField_a_of_type_Boolean) && (localbgrt.d <= 3))
              {
                localbgrt.d += 1;
                localbgrt.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bgrs.a.b(str, l);
              }
              else
              {
                localbgrt.jdField_b_of_type_Boolean = false;
                localbgrt.d = 0;
                this.jdField_a_of_type_Bgrs.a.a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, str, l);
                continue;
                localbgrt.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Bgrs.a.a(null, false, str, l);
                break label974;
                localbgrt.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bgrs.a.a(null, false, str, l);
                break label974;
                if (localbgrt.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbgrt.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgrt.jdField_a_of_type_Boolean) && (localbgrt.d <= 3))
                {
                  localbgrt.d += 1;
                  this.jdField_a_of_type_Bgrs.a.b(str, l);
                  break label974;
                }
                localbgrt.d = 0;
                this.jdField_a_of_type_Bgrs.a.a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localbgrt.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbgrt.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbgrt.jdField_a_of_type_Boolean) && (localbgrt.d <= 3))
                {
                  localbgrt.d += 1;
                  localbgrt.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bgrs.a.b(str, l);
                  break label974;
                }
                localbgrt.jdField_b_of_type_Boolean = false;
                localbgrt.d = 0;
                this.jdField_a_of_type_Bgrs.a.a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, str, l);
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