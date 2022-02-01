package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tencent.im.oidb.redInfo.RedInfo;

public class DefaultRedPointPrePostHandler
  implements RedPointPrePostHandleObserver
{
  WeakReference<LocalRedTouchManager> a;
  QQAppInterface b;
  
  public DefaultRedPointPrePostHandler(QQAppInterface paramQQAppInterface, LocalRedTouchManager paramLocalRedTouchManager)
  {
    this.a = new WeakReference(paramLocalRedTouchManager);
    this.b = paramQQAppInterface;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_redpoint_handler_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public LocalRedTouchManager a()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {
      return null;
    }
    return (LocalRedTouchManager)localWeakReference.get();
  }
  
  public void a(RedTouchItem paramRedTouchItem, int paramInt)
  {
    if ((paramInt != 10016) && (paramInt != 10015))
    {
      if (paramInt == 100601)
      {
        paramRedTouchItem.isClosed = (((IUtil)QRoute.api(IUtil.class)).checkLikeRankListRedPointConfig(this.b) ^ true);
        return;
      }
      if (RedPointId.a(paramInt))
      {
        int i = paramRedTouchItem.extMsgs.size();
        Object localObject1 = "";
        Object localObject2;
        boolean bool2;
        RedTouchItemExtMsg localRedTouchItemExtMsg1;
        if (i > 0)
        {
          RedTouchItemExtMsg localRedTouchItemExtMsg2 = (RedTouchItemExtMsg)paramRedTouchItem.extMsgs.get(0);
          boolean bool1;
          if ((localRedTouchItemExtMsg2.bytesData != null) && (localRedTouchItemExtMsg2.bytesData.length > 0))
          {
            Object localObject3;
            try
            {
              localObject2 = new redInfo.RedInfo();
              try
              {
                ((redInfo.RedInfo)localObject2).mergeFrom(localRedTouchItemExtMsg2.bytesData);
                localObject3 = localObject2;
              }
              catch (Throwable localThrowable1) {}
              localObject3 = localObject2;
            }
            catch (Throwable localThrowable2)
            {
              localObject2 = null;
            }
            if (QLog.isColorLevel())
            {
              QLog.i("DefaultRedPointPrePostHandler", 2, localThrowable2.getMessage(), localThrowable2);
              localObject3 = localObject2;
            }
            if ((localObject3 != null) && (localObject3.uint64_from_uin.has()))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(localObject3.uint64_from_uin.get());
              ((StringBuilder)localObject1).append("");
              localObject2 = ((StringBuilder)localObject1).toString();
              bool2 = true;
            }
            else
            {
              bool2 = false;
              localObject2 = localObject1;
            }
            localObject1 = localObject2;
            bool1 = bool2;
            if (localRedTouchItemExtMsg2.bytesData.length > 102400)
            {
              QLog.d("DefaultRedPointPrePostHandler", 1, String.format("onPreHandle() id=[%d] msgs.size=%d bytes_data.len=%d too large !!", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramRedTouchItem.extMsgs.size()), Integer.valueOf(localRedTouchItemExtMsg2.bytesData.length) }));
              localObject1 = localObject2;
              bool1 = bool2;
            }
          }
          else
          {
            bool1 = false;
          }
          localRedTouchItemExtMsg1 = localRedTouchItemExtMsg2;
          localObject2 = localObject1;
          bool2 = bool1;
          if (paramRedTouchItem.extMsgs.size() > 1)
          {
            paramInt = paramRedTouchItem.extMsgs.size() - 1;
            for (;;)
            {
              localRedTouchItemExtMsg1 = localRedTouchItemExtMsg2;
              localObject2 = localObject1;
              bool2 = bool1;
              if (paramInt <= 0) {
                break;
              }
              paramRedTouchItem.extMsgs.remove(paramInt);
              paramInt -= 1;
            }
          }
        }
        else
        {
          localRedTouchItemExtMsg1 = null;
          bool2 = false;
          localObject2 = localObject1;
        }
        if (bool2) {
          FileUtils.writeObject(a(-4), localRedTouchItemExtMsg1);
        } else {
          paramRedTouchItem.count = 0;
        }
        QLog.d("DefaultRedPointPrePostHandler", 1, new Object[] { "isQQSettingMeBubbleMsg show=", Boolean.valueOf(bool2), " uin=", StringUtil.getSimpleUinForPrint((String)localObject2) });
      }
    }
    else
    {
      paramRedTouchItem.isClosed = true;
    }
  }
  
  public void a(List<RedTouchItem> paramList)
  {
    LocalRedTouchManager localLocalRedTouchManager = a();
    Object localObject1;
    Object localObject2;
    if (paramList != null)
    {
      if (localLocalRedTouchManager == null) {
        return;
      }
      localObject1 = null;
      Object localObject3 = paramList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = localObject1;
        if (((RedTouchItem)((Iterator)localObject3).next()).taskId == 10005) {
          localObject2 = "0X800761B";
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ReportController.b(this.b, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
          localObject1 = localObject2;
        }
      }
      localObject3 = localLocalRedTouchManager.a(10015);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (paramList.contains(localObject3))
        {
          localObject2 = "0X8007391";
          ReportController.b(this.b, "dc00898", "", "", "0X8007391", "0X8007391", 0, 0, "", "", "", "");
          ((MedalWallMng)this.b.getManager(QQManagerFactory.MEDAL_WALL_MNG)).c();
        }
      }
      localObject1 = localLocalRedTouchManager.a(10016);
      if ((localObject1 == null) || (!paramList.contains(localObject1)) || (((RedTouchItem)localObject1).bytes == null) || (((RedTouchItem)localObject1).bytes.length <= 0)) {}
    }
    for (;;)
    {
      try
      {
        int i = new JSONObject(new String(((RedTouchItem)localObject1).bytes, "utf-8")).optInt("type", 1);
        if (i != 4)
        {
          if (i == 5) {
            break label444;
          }
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = "0X8007396";
        }
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("DefaultRedPointPrePostHandler", 2, localException, new Object[0]);
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null) {
        ReportController.b(this.b, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
      }
      localObject1 = localLocalRedTouchManager.a(10018);
      if ((localObject1 != null) && (paramList.contains(localObject1)) && (((RedTouchItem)localObject1).extMsgs != null) && (((RedTouchItem)localObject1).extMsgs.size() > 0) && (((RedTouchItem)localObject1).unReadFlag))
      {
        paramList = (ConfessManager)this.b.getManager(QQManagerFactory.CONFESS_MANAGER);
        localObject2 = paramList.a();
        if ((localObject2 != null) && (((ConfessConfig)localObject2).e()))
        {
          paramList.a((RedTouchItem)localObject1);
          return;
        }
        ((RedTouchItem)localObject1).unReadFlag = false;
        localLocalRedTouchManager.e();
        if (QLog.isColorLevel()) {
          QLog.i("DefaultRedPointPrePostHandler", 2, "onPostDealReachedRedPoints frdRecMsgSwitch is off");
        }
      }
      return;
      label444:
      localObject1 = "0X80073B5";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.DefaultRedPointPrePostHandler
 * JD-Core Version:    0.7.0.1
 */