package com.tencent.mobileqq.leba.business.mainbiz;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

class LebaQzoneAndPluginPart$8
  implements Runnable
{
  LebaQzoneAndPluginPart$8(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    Object localObject7 = null;
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject4 = null;
    int n = 0;
    boolean bool1 = false;
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    int k;
    Object localObject1;
    label57:
    int i;
    label116:
    Object localObject2;
    if (localQZoneManagerImp != null)
    {
      k = localQZoneManagerImp.a(1);
      if (localQZoneManagerImp == null) {
        break label240;
      }
      localObject1 = localQZoneManagerImp.a();
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.LebaBusinessPartImpl", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + k);
      }
      this.this$0.a(new LebaQzoneAndPluginPart.8.1(this, k));
      if (localQZoneManagerImp == null) {
        break label246;
      }
      i = localQZoneManagerImp.a(2);
      if ((i <= 0) || (localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label257;
      }
      if ((!QLog.isColorLevel()) || (QLog.isColorLevel())) {
        QLog.d("UndealCount.LebaBusinessPartImpl", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      this.this$0.a(new LebaQzoneAndPluginPart.8.2(this, (ArrayList)localObject1));
      if (localQZoneManagerImp == null) {
        break label251;
      }
      localObject2 = localQZoneManagerImp.a(2);
      label183:
      localObject1 = localObject4;
      if (localObject2 != null) {
        localObject1 = ((QZoneCountInfo)localObject2).strShowMsg;
      }
      this.this$0.a = 2;
      i = 8;
      bool1 = false;
    }
    label257:
    label1153:
    label1156:
    label1162:
    label1175:
    label1190:
    for (;;)
    {
      this.this$0.a(new LebaQzoneAndPluginPart.8.7(this, i, k, (String)localObject1, bool1));
      return;
      k = 0;
      break;
      label240:
      localObject1 = null;
      break label57;
      label246:
      i = 0;
      break label116;
      label251:
      localObject2 = null;
      break label183;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("UndealCount.LebaBusinessPartImpl", 2, "updateQZoneFlag.noflag count=" + i);
        }
        if (localQZoneManagerImp == null) {
          break label996;
        }
        localObject1 = localQZoneManagerImp.a(6);
        label302:
        if (localQZoneManagerImp == null) {
          break label1002;
        }
        localObject4 = localQZoneManagerImp.a(61);
        label316:
        localObject2 = "";
        localObject5 = "";
        if ((localObject1 == null) || (((QZoneCountInfo)localObject1).friendList == null) || (((QZoneCountInfo)localObject1).friendList.size() <= 0) || (((QZoneCountUserInfo)((QZoneCountInfo)localObject1).friendList.get(0)).uin <= 0L) || (((QZoneCountInfo)localObject1).uCount <= 0L)) {
          break label1190;
        }
        localObject2 = ((QZoneCountInfo)localObject1).strShowMsg;
        localObject1 = ((QZoneCountUserInfo)((QZoneCountInfo)localObject1).friendList.get(0)).uin + "";
        this.this$0.a = 6;
        i = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject6;
          int j;
          boolean bool2;
          i = 0;
          localObject1 = localObject9;
          continue;
          break;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          localObject1 = localException5;
          int m = j;
          continue;
          Object localObject5 = null;
          Object localObject3 = localObject7;
          continue;
          i = 0;
          continue;
          i = 0;
          localObject1 = localObject5;
        }
      }
      localObject6 = localObject1;
      localObject5 = localObject2;
      j = i;
      if (i == 0)
      {
        localObject6 = localObject1;
        localObject5 = localObject2;
        j = i;
        if (localObject4 != null)
        {
          localObject6 = localObject1;
          localObject5 = localObject2;
          j = i;
          if (((QZoneCountInfo)localObject4).friendList != null)
          {
            localObject6 = localObject1;
            localObject5 = localObject2;
            j = i;
            if (((QZoneCountInfo)localObject4).friendList.size() > 0)
            {
              localObject6 = localObject1;
              localObject5 = localObject2;
              j = i;
              if (((QZoneCountUserInfo)((QZoneCountInfo)localObject4).friendList.get(0)).uin > 0L)
              {
                localObject6 = localObject1;
                localObject5 = localObject2;
                j = i;
                if (((QZoneCountInfo)localObject4).uCount > 0L)
                {
                  localObject5 = ((QZoneCountInfo)localObject4).strShowMsg;
                  localObject6 = ((QZoneCountUserInfo)((QZoneCountInfo)localObject4).friendList.get(0)).uin + "";
                  this.this$0.a = 61;
                  j = 1;
                }
              }
            }
          }
        }
      }
      if (j != 0)
      {
        bool2 = TextUtils.isEmpty((CharSequence)localObject5);
        if (!bool2) {
          for (;;)
          {
            try
            {
              this.this$0.a(new LebaQzoneAndPluginPart.8.3(this, (String)localObject5, (String)localObject6));
              i = -1;
              if (localQZoneManagerImp != null) {
                localObject1 = localObject8;
              }
            }
            catch (Exception localException3)
            {
              label996:
              label1002:
              ArrayList localArrayList;
              i = -1;
              localObject1 = localObject9;
              continue;
            }
            try
            {
              localObject2 = localQZoneManagerImp.a(3);
              if (localQZoneManagerImp == null) {
                continue;
              }
              localObject1 = localObject8;
              localObject4 = localQZoneManagerImp.a(1013);
              if (j != 0) {
                break label1175;
              }
              localObject1 = localObject8;
              if (!LebaQzoneAndPluginPart.a((QZoneCountInfo)localObject2)) {
                break label1175;
              }
              localObject1 = localObject8;
              localObject5 = ((QZoneCountInfo)localObject2).strShowMsg;
              localObject1 = localObject5;
              this.this$0.a = 3;
              localObject1 = localObject2;
              j = 1;
              localObject2 = localObject5;
              localObject5 = localObject1;
              if (j != 0) {
                break label1162;
              }
              localObject1 = localObject2;
              if (!LebaQzoneAndPluginPart.b((QZoneCountInfo)localObject4)) {
                break label1162;
              }
              localObject1 = localObject2;
              localObject2 = ((QZoneCountInfo)localObject4).strShowMsg;
              localObject1 = localObject2;
              this.this$0.a = 1013;
              localObject1 = localObject2;
              if (BaseApplicationImpl.getApplication() != null)
              {
                localObject1 = localObject2;
                if (BaseApplicationImpl.getApplication().getRuntime() != null)
                {
                  localObject1 = localObject2;
                  QZoneUnreadServletLogic.a(BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), ((QZoneCountInfo)localObject4).actPageAttach);
                }
              }
              localObject1 = localObject2;
              if (((QZoneCountInfo)localObject4).friendList != null)
              {
                localObject1 = localObject2;
                j = ((QZoneCountInfo)localObject4).friendList.size();
                if (j != 0) {
                  break label1156;
                }
              }
              bool1 = true;
              m = 1;
              localObject1 = localObject2;
              localObject5 = localObject4;
              if (m == 0) {
                break label1153;
              }
              j = i;
              try
              {
                localObject2 = new ArrayList();
                if (localObject5 == null) {
                  continue;
                }
                j = i;
                if (((QZoneCountInfo)localObject5).friendList == null) {
                  continue;
                }
                j = i;
                localObject4 = ((QZoneCountInfo)localObject5).friendList.iterator();
                j = i;
                if (!((Iterator)localObject4).hasNext()) {
                  continue;
                }
                j = i;
                localObject5 = (QZoneCountUserInfo)((Iterator)localObject4).next();
                if (localObject5 == null) {
                  continue;
                }
                j = i;
                if (((QZoneCountUserInfo)localObject5).uin < 10000L) {
                  continue;
                }
                j = i;
                ((ArrayList)localObject2).add(String.valueOf(((QZoneCountUserInfo)localObject5).uin));
                continue;
                QLog.e("Leba", 1, "updateQZoneRedFlag" + localException1);
              }
              catch (Exception localException1)
              {
                i = j;
              }
            }
            catch (Exception localException4)
            {
              continue;
              continue;
            }
            break;
            localObject1 = null;
            break label302;
            localObject4 = null;
            break label316;
            localArrayList = null;
            continue;
            localObject4 = null;
            continue;
            j = i;
            if (localArrayList.size() > 0)
            {
              j = 8;
              this.this$0.a(new LebaQzoneAndPluginPart.8.4(this, localArrayList));
            }
            for (i = 8; m == 0; i = 0)
            {
              try
              {
                this.this$0.a(new LebaQzoneAndPluginPart.8.6(this));
                i = n;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("UndealCount.ZebraAlbum.LebaBusinessPartImpl", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
                i = n;
              }
              catch (Exception localException5)
              {
                i = 0;
              }
              this.this$0.a(new LebaQzoneAndPluginPart.8.5(this));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8
 * JD-Core Version:    0.7.0.1
 */