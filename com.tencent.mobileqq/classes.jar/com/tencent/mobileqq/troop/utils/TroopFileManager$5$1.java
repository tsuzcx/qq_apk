package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import azpg;
import azqt;
import bajk;
import bajp;
import bajq;
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
  public TroopFileManager$5$1(bajp parambajp, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    bajq localbajq;
    synchronized (this.jdField_a_of_type_Bajp.a)
    {
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("reqFor");
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFirstPage");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("parentFileId");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("uin_filter");
      localbajq = (bajq)this.jdField_a_of_type_Bajp.a.d.get(str + l);
      if (localbajq == null) {
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
          localbajq.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bajp.a.a(null, false, str, l);
          continue;
          localbajq.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bajp.a.a(null, false, str, l);
          continue;
          if (localbajq.jdField_a_of_type_JavaUtilList != null) {
            if ((localbajq.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbajq.jdField_a_of_type_Boolean) && (localbajq.d <= 3))
            {
              localbajq.d += 1;
              this.jdField_a_of_type_Bajp.a.b(str, l);
            }
            else
            {
              localbajq.d = 0;
              this.jdField_a_of_type_Bajp.a.a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbajq.jdField_a_of_type_JavaUtilList != null) {
                if ((localbajq.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbajq.jdField_a_of_type_Boolean) && (localbajq.d <= 3))
                {
                  localbajq.d += 1;
                  localbajq.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bajp.a.b(str, l);
                }
                else
                {
                  localbajq.jdField_b_of_type_Boolean = false;
                  localbajq.d = 0;
                  this.jdField_a_of_type_Bajp.a.a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbajq.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
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
          localbajq.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Bajp.a.a(null, false, str, l);
          continue;
          localbajq.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bajp.a.a(null, false, str, l);
          continue;
          if (localbajq.jdField_a_of_type_JavaUtilList != null) {
            if ((localbajq.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbajq.jdField_a_of_type_Boolean) && (localbajq.d <= 3))
            {
              localbajq.d += 1;
              this.jdField_a_of_type_Bajp.a.b(str, l);
            }
            else
            {
              localbajq.d = 0;
              this.jdField_a_of_type_Bajp.a.a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, str, l);
              continue;
              if (localbajq.jdField_a_of_type_JavaUtilList != null) {
                if ((localbajq.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbajq.jdField_a_of_type_Boolean) && (localbajq.d <= 3))
                {
                  localbajq.d += 1;
                  localbajq.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bajp.a.b(str, l);
                }
                else
                {
                  localbajq.jdField_b_of_type_Boolean = false;
                  localbajq.d = 0;
                  this.jdField_a_of_type_Bajp.a.a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, str, l);
                }
              }
            }
          }
        }
      }
      localbajq.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbajq.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (!bool) {
        break label977;
      }
      localbajq.jdField_a_of_type_Int = this.c;
      Object localObject2 = this.jdField_a_of_type_Bajp.a.a();
      localbajq.jdField_a_of_type_JavaUtilList.clear();
      localbajq.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (azpg)((Iterator)localObject2).next();
        this.jdField_a_of_type_Bajp.a.b.put(((azpg)???).jdField_a_of_type_JavaUtilUUID, ???);
        this.jdField_a_of_type_Bajp.a.c.put(((azpg)???).b, ???);
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
        localObject6 = this.jdField_a_of_type_Bajp.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
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
        localObject4 = (azpg)((Iterator)localObject7).next();
        if (((azpg)localObject4).jdField_d_of_type_Boolean)
        {
          if (((azpg)localObject4).b == null) {
            continue;
          }
          ??? = (azpg)this.jdField_a_of_type_Bajp.a.c.get(((azpg)localObject4).b);
          if (??? == null)
          {
            ((azpg)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.jdField_a_of_type_Bajp.a.c.put(((azpg)localObject4).b, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (azqt)localIterator.next();
              if (((azpg)localObject4).b.equals(((azqt)???).i))
              {
                azpg localazpg2 = new azpg();
                localazpg2.jdField_a_of_type_JavaUtilUUID = ((azqt)???).jdField_a_of_type_JavaUtilUUID;
                localazpg2.b = ((azqt)???).e;
                localazpg2.f = ((azqt)???).i;
                localazpg2.a((azqt)???, this.jdField_a_of_type_Bajp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((azpg)localObject4).a(localazpg2);
              }
            }
            localbajq.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            break;
          }
          ((azpg)???).b((azpg)localObject4);
          this.jdField_a_of_type_Bajp.a.b.put(((azpg)???).jdField_a_of_type_JavaUtilUUID, ???);
          if (localbajq.jdField_a_of_type_JavaUtilMap.get(((azpg)???).b) == null)
          {
            localbajq.jdField_a_of_type_JavaUtilList.add(???);
            localbajq.jdField_a_of_type_JavaUtilMap.put(((azpg)???).b, ???);
          }
          this.jdField_a_of_type_Bajp.a.c.put(((azpg)???).b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((azpg)localObject4).jdField_c_of_type_JavaLangString + ", filePath = " + ((azpg)localObject4).b + ", sha = " + ((azpg)localObject4).jdField_d_of_type_JavaLangString);
        }
        ??? = this.jdField_a_of_type_Bajp.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((azpg)localObject4).b);
        if (??? == null)
        {
          ((azpg)localObject4).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          ((azpg)localObject4).jdField_d_of_type_Long = ((azpg)localObject4).jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((((azpg)localObject4).e == 1) || (((azpg)localObject4).e == 3) || (((azpg)localObject4).e == 2) || (((azpg)localObject4).e == 12)) {
            break label1743;
          }
          ??? = (azpg)this.jdField_a_of_type_Bajp.a.c.get(((azpg)localObject4).b);
          if (??? == null) {
            break label2891;
          }
          ((azpg)???).b((azpg)localObject4);
          localObject4 = ???;
          ((azpg)localObject4).a(this.jdField_a_of_type_Bajp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajp.a.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bajp.a.b.put(((azpg)localObject4).jdField_a_of_type_JavaUtilUUID, localObject4);
          if (localbajq.jdField_a_of_type_JavaUtilMap.get(((azpg)localObject4).b) == null)
          {
            localbajq.jdField_a_of_type_JavaUtilList.add(localObject4);
            localbajq.jdField_a_of_type_JavaUtilMap.put(((azpg)localObject4).b, localObject4);
          }
          this.jdField_a_of_type_Bajp.a.c.put(((azpg)localObject4).b, localObject4);
          break;
          ((azpg)localObject4).jdField_a_of_type_JavaUtilUUID = ((azqt)???).jdField_a_of_type_JavaUtilUUID;
          ((azpg)localObject4).a((azqt)???, this.jdField_a_of_type_Bajp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((azpg)localObject4).e == 9)
          {
            ??? = (azpg)this.jdField_a_of_type_Bajp.a.c.get(((azqt)???).i);
            if (??? != null) {
              ((azpg)???).a((azpg)localObject4);
            }
          }
        }
      }
      label1745:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (azpg)this.jdField_a_of_type_Bajp.a.c.get(str);
        if (localObject4 != null)
        {
          ??? = ((azpg)localObject4).jdField_a_of_type_JavaUtilMap.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = localbajq.jdField_a_of_type_JavaUtilList.size();
          synchronized (this.jdField_a_of_type_Bajp.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (azpg)((azpg)localObject4).jdField_a_of_type_JavaUtilMap.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (localbajq.jdField_a_of_type_JavaUtilList.get(n - 1) == null)) {
                  break label2726;
                }
                int i1 = ((azpg)localbajq.jdField_a_of_type_JavaUtilList.get(n - 1)).a();
                if (((azpg)localObject7).a() >= i1)
                {
                  k = 0;
                  label1984:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((azpg)localObject7).b == null) || (localbajq.jdField_a_of_type_JavaUtilList.get(k) == null) || (!((azpg)localObject7).b.equals(((azpg)localbajq.jdField_a_of_type_JavaUtilList.get(k)).b))) {
                      break label2723;
                    }
                    i = 1;
                    break label2894;
                  }
                }
                i = j;
                if (((azpg)localObject7).a() <= i1)
                {
                  i = j;
                  if (!this.jdField_b_of_type_Boolean) {
                    i = 1;
                  }
                }
                label2075:
                if (i == 0)
                {
                  ((azpg)localObject4).jdField_a_of_type_JavaUtilMap.remove(((azpg)localObject7).b);
                  this.jdField_a_of_type_Bajp.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(((azpg)localObject7).jdField_a_of_type_JavaUtilUUID, true);
                }
              }
            }
          }
          this.jdField_a_of_type_Bajp.a.d(localazpg1);
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
        localbajq.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Bajp.a.a(null, false, str, l);
        continue;
        localbajq.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Bajp.a.a(null, false, str, l);
        continue;
        if (localbajq.jdField_a_of_type_JavaUtilList != null) {
          if ((localbajq.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbajq.jdField_a_of_type_Boolean) && (localbajq.d <= 3))
          {
            localbajq.d += 1;
            this.jdField_a_of_type_Bajp.a.b(str, l);
          }
          else
          {
            localbajq.d = 0;
            this.jdField_a_of_type_Bajp.a.a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, str, l);
            continue;
            if (localbajq.jdField_a_of_type_JavaUtilList != null) {
              if ((localbajq.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbajq.jdField_a_of_type_Boolean) && (localbajq.d <= 3))
              {
                localbajq.d += 1;
                localbajq.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bajp.a.b(str, l);
              }
              else
              {
                localbajq.jdField_b_of_type_Boolean = false;
                localbajq.d = 0;
                this.jdField_a_of_type_Bajp.a.a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, str, l);
                continue;
                localbajq.jdField_a_of_type_Long = 0L;
                this.jdField_a_of_type_Bajp.a.a(null, false, str, l);
                break label974;
                localbajq.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_Bajp.a.a(null, false, str, l);
                break label974;
                if (localbajq.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbajq.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbajq.jdField_a_of_type_Boolean) && (localbajq.d <= 3))
                {
                  localbajq.d += 1;
                  this.jdField_a_of_type_Bajp.a.b(str, l);
                  break label974;
                }
                localbajq.d = 0;
                this.jdField_a_of_type_Bajp.a.a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, str, l);
                break label974;
                if (localbajq.jdField_a_of_type_JavaUtilList == null) {
                  break label974;
                }
                if ((localbajq.jdField_a_of_type_JavaUtilList.size() < 15) && (!localbajq.jdField_a_of_type_Boolean) && (localbajq.d <= 3))
                {
                  localbajq.d += 1;
                  localbajq.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bajp.a.b(str, l);
                  break label974;
                }
                localbajq.jdField_b_of_type_Boolean = false;
                localbajq.d = 0;
                this.jdField_a_of_type_Bajp.a.a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, str, l);
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