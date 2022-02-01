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
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.a.getManager(QQManagerFactory.QZONE_MANAGER);
    int m = 0;
    int n = 0;
    int k;
    if (localQZoneManagerImp != null) {
      k = localQZoneManagerImp.d(1);
    } else {
      k = 0;
    }
    Object localObject1;
    if (localQZoneManagerImp != null) {
      localObject1 = localQZoneManagerImp.e();
    } else {
      localObject1 = null;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TYPE_PASSIVE_FEED freshEntryItemUI num=");
      ((StringBuilder)localObject2).append(k);
      QLog.d("UndealCount.LebaBusinessPartImpl", 2, ((StringBuilder)localObject2).toString());
    }
    this.this$0.a(new LebaQzoneAndPluginPart.8.1(this, k));
    int i;
    if (localQZoneManagerImp != null) {
      i = localQZoneManagerImp.d(2);
    } else {
      i = 0;
    }
    boolean bool;
    if ((i > 0) && (localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      QLog.isColorLevel();
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.LebaBusinessPartImpl", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      this.this$0.a(new LebaQzoneAndPluginPart.8.2(this, (ArrayList)localObject1));
      if (localQZoneManagerImp != null) {
        localObject1 = localQZoneManagerImp.e(2);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        localObject1 = ((QZoneCountInfo)localObject1).strShowMsg;
      } else {
        localObject1 = null;
      }
      this.this$0.j = 2;
      i = 8;
      bool = false;
    }
    label1188:
    label1194:
    label1212:
    label1229:
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateQZoneFlag.noflag count=");
          ((StringBuilder)localObject1).append(i);
          QLog.d("UndealCount.LebaBusinessPartImpl", 2, ((StringBuilder)localObject1).toString());
        }
        if (localQZoneManagerImp == null) {
          break label1188;
        }
        localObject1 = localQZoneManagerImp.e(6);
        if (localQZoneManagerImp != null) {
          localObject6 = localQZoneManagerImp.e(61);
        } else {
          localObject6 = null;
        }
        if ((localObject1 == null) || (((QZoneCountInfo)localObject1).friendList == null) || (((QZoneCountInfo)localObject1).friendList.size() <= 0)) {
          break label1194;
        }
        localObject2 = (QZoneCountUserInfo)((QZoneCountInfo)localObject1).friendList.get(0);
        Object localObject7;
        int j;
        try
        {
          if ((((QZoneCountUserInfo)localObject2).uin <= 0L) || (((QZoneCountInfo)localObject1).uCount <= 0L)) {
            break label1194;
          }
          localObject7 = ((QZoneCountInfo)localObject1).strShowMsg;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((QZoneCountUserInfo)((QZoneCountInfo)localObject1).friendList.get(0)).uin);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          this.this$0.j = 6;
          localObject1 = localObject7;
          i = 1;
          j = i;
          Object localObject8 = localObject1;
          localObject7 = localObject2;
          if (i == 0)
          {
            j = i;
            localObject8 = localObject1;
            localObject7 = localObject2;
            if (localObject6 != null)
            {
              j = i;
              localObject8 = localObject1;
              localObject7 = localObject2;
              if (((QZoneCountInfo)localObject6).friendList != null)
              {
                j = i;
                localObject8 = localObject1;
                localObject7 = localObject2;
                if (((QZoneCountInfo)localObject6).friendList.size() > 0)
                {
                  j = i;
                  localObject8 = localObject1;
                  localObject7 = localObject2;
                  if (((QZoneCountUserInfo)((QZoneCountInfo)localObject6).friendList.get(0)).uin > 0L)
                  {
                    j = i;
                    localObject8 = localObject1;
                    localObject7 = localObject2;
                    if (((QZoneCountInfo)localObject6).uCount > 0L)
                    {
                      localObject8 = ((QZoneCountInfo)localObject6).strShowMsg;
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(((QZoneCountUserInfo)((QZoneCountInfo)localObject6).friendList.get(0)).uin);
                      ((StringBuilder)localObject1).append("");
                      localObject7 = ((StringBuilder)localObject1).toString();
                      this.this$0.j = 61;
                      j = 1;
                    }
                  }
                }
              }
            }
          }
          if (j != 0)
          {
            bool = TextUtils.isEmpty((CharSequence)localObject8);
            if (!bool)
            {
              i = -1;
              try
              {
                this.this$0.a(new LebaQzoneAndPluginPart.8.3(this, (String)localObject8, (String)localObject7));
              }
              catch (Exception localException1)
              {
                i = -1;
                break label1124;
              }
            }
          }
          i = 0;
        }
        catch (Exception localException2)
        {
          i = n;
        }
        if (localQZoneManagerImp == null) {
          break label1212;
        }
        QZoneCountInfo localQZoneCountInfo;
        Object localObject3;
        bool = false;
      }
      catch (Exception localException7)
      {
        try
        {
          localObject1 = localQZoneManagerImp.e(3);
          if (localQZoneManagerImp != null)
          {
            localQZoneCountInfo = localQZoneManagerImp.e(1013);
            if ((j == 0) && (LebaQzoneAndPluginPart.a((QZoneCountInfo)localObject1)))
            {
              localObject7 = ((QZoneCountInfo)localObject1).strShowMsg;
              localObject6 = localObject7;
              try
              {
                this.this$0.j = 3;
                localObject6 = localObject1;
                j = 1;
                localObject1 = localObject7;
              }
              catch (Exception localException3)
              {
                localObject1 = localObject6;
                continue;
              }
            }
            else
            {
              localObject1 = null;
              localObject6 = null;
            }
            if (j == 0)
            {
              try
              {
                if (!LebaQzoneAndPluginPart.b(localException3)) {
                  continue;
                }
                localObject7 = localException3.strShowMsg;
                localObject6 = localObject7;
                this.this$0.j = 1013;
                localObject6 = localObject7;
                if (BaseApplicationImpl.getApplication() != null)
                {
                  localObject6 = localObject7;
                  if (BaseApplicationImpl.getApplication().getRuntime() != null)
                  {
                    localObject6 = localObject7;
                    QZoneUnreadServletLogic.a(BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), localException3.actPageAttach);
                  }
                }
                localObject6 = localObject7;
                if (localException3.friendList != null)
                {
                  localObject6 = localObject7;
                  j = localException3.friendList.size();
                  if (j != 0)
                  {
                    bool = false;
                    continue;
                  }
                }
                bool = true;
                localObject1 = localObject7;
                j = 1;
              }
              catch (Exception localException4) {}
              bool = false;
              break label1130;
            }
            localObject3 = localObject6;
            bool = false;
            if (j == 0) {
              break label1229;
            }
          }
        }
        catch (Exception localException8)
        {
          Object localObject6;
          Object localObject4;
          break label1124;
        }
        try
        {
          localObject6 = new ArrayList();
          if ((localObject3 != null) && (((QZoneCountInfo)localObject3).friendList != null))
          {
            localObject3 = ((QZoneCountInfo)localObject3).friendList.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject7 = (QZoneCountUserInfo)((Iterator)localObject3).next();
              if ((localObject7 == null) || (((QZoneCountUserInfo)localObject7).uin < 10000L)) {
                continue;
              }
              ((ArrayList)localObject6).add(String.valueOf(((QZoneCountUserInfo)localObject7).uin));
              continue;
            }
          }
          n = ((ArrayList)localObject6).size();
          if (n > 0) {
            try
            {
              this.this$0.a(new LebaQzoneAndPluginPart.8.4(this, (ArrayList)localObject6));
              i = 8;
            }
            catch (Exception localException5)
            {
              i = 8;
              break label1130;
            }
          }
          try
          {
            this.this$0.a(new LebaQzoneAndPluginPart.8.5(this));
            i = 0;
            if (j == 0)
            {
              this.this$0.a(new LebaQzoneAndPluginPart.8.6(this));
              if (QLog.isColorLevel()) {
                QLog.d("UndealCount.ZebraAlbum.LebaBusinessPartImpl", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
              }
              i = 0;
            }
          }
          catch (Exception localException6)
          {
            i = m;
            break label1130;
          }
        }
        catch (Exception localException9)
        {
          Object localObject5;
          break label1130;
        }
        localException7 = localException7;
        i = n;
      }
      label1124:
      localObject1 = null;
      label1130:
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("updateQZoneRedFlag");
      ((StringBuilder)localObject6).append(localException7);
      QLog.e("Leba", 1, ((StringBuilder)localObject6).toString());
      this.this$0.a(new LebaQzoneAndPluginPart.8.7(this, i, k, (String)localObject1, bool));
      return;
      localObject1 = null;
      continue;
      localObject1 = "";
      localObject4 = localObject1;
      i = 0;
      continue;
      localObject1 = null;
      continue;
      localObject5 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8
 * JD-Core Version:    0.7.0.1
 */