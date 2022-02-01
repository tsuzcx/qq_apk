package com.tencent.mobileqq.leba.feed.impl;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi;
import com.tencent.mobileqq.leba.feed.ILebaPluginFeedController;
import com.tencent.mobileqq.leba.feed.LebaFeedUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class LebaPluginFeedApiImpl
  implements ILebaPluginFeedApi
{
  public static final String TAG = "LebaPluginFeedApiImpl";
  
  public ILebaPluginFeedController getLebaPluginFeedController(Context paramContext, AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    return new LebaPluginFeedController(paramContext, paramAppRuntime, paramQBaseActivity);
  }
  
  public boolean isNeedShowPluginInTab(AppRuntime paramAppRuntime)
  {
    boolean bool1 = LebaFeedUtil.a();
    boolean bool2 = false;
    if (!bool1)
    {
      QLog.i("LebaPluginFeedApiImpl", 1, "isNeedShowPluginInTab no isShowQzoneFrame");
      return false;
    }
    Object localObject1 = ABTestController.a().a("exp_shouq_dongtai_jianjie_copy_copy");
    if ((localObject1 != null) && (((ExpEntityInfo)localObject1).a("exp_shouq_dongtai_jianjie_B")))
    {
      localObject1 = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "");
      HashSet localHashSet = new HashSet();
      Object localObject2 = ((ILebaHelperService)localObject1).getLebaShowList();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (LebaViewItem)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((LebaViewItem)localObject3).b != null)) {
            localHashSet.add(Long.valueOf(((LebaViewItem)localObject3).a));
          }
        }
        localObject2 = ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).requestAppInfoListByAppSet(0);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("isNeedShowPluginInTab");
          int i = 0;
          for (;;)
          {
            bool1 = bool2;
            if (i >= ((List)localObject2).size()) {
              break;
            }
            BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(i);
            if (localAppInfo == null)
            {
              ((StringBuilder)localObject3).append(",appInfo == null");
            }
            else
            {
              int j = localAppInfo.uiAppId.get();
              ((StringBuilder)localObject3).append(",path=");
              ((StringBuilder)localObject3).append(localAppInfo.path.get());
              ((StringBuilder)localObject3).append(",uiAppId=");
              ((StringBuilder)localObject3).append(j);
              if (localAppInfo.mission_level.get() != 0)
              {
                ((StringBuilder)localObject3).append(",mission_level=");
                ((StringBuilder)localObject3).append(localAppInfo.mission_level.get());
              }
              else if ((localAppInfo.iNewFlag.get() == 1) && (localAppInfo.exposure_max.get() > 0))
              {
                if (!((ILebaHelperService)localObject1).needShowRedDot(paramAppRuntime, localAppInfo.uiAppId.get(), localHashSet))
                {
                  ((StringBuilder)localObject3).append(",!needShowRedDot");
                }
                else
                {
                  if ((1130 != j) && (100510 != j))
                  {
                    bool1 = true;
                    break;
                  }
                  ((StringBuilder)localObject3).append(", biz ");
                }
              }
              else
              {
                ((StringBuilder)localObject3).append(",isNewFlag=");
                ((StringBuilder)localObject3).append(localAppInfo.iNewFlag.get());
                ((StringBuilder)localObject3).append(",exposure_max=");
                ((StringBuilder)localObject3).append(localAppInfo.exposure_max.get());
              }
            }
            i += 1;
          }
          ((StringBuilder)localObject3).append(",isShowRedPoint=");
          ((StringBuilder)localObject3).append(bool1);
          QLog.i("LebaPluginFeedApiImpl", 1, ((StringBuilder)localObject3).toString());
          return bool1;
        }
        QLog.i("LebaPluginFeedApiImpl", 1, "isNeedShowPluginInTab appInfoList empty");
        return false;
      }
      QLog.i("LebaPluginFeedApiImpl", 1, "isNeedShowPluginInTab lebaPluginList empty");
      return false;
    }
    QLog.i("LebaPluginFeedApiImpl", 1, "isNeedShowPluginInTab no exp_shouq_dongtai_jianjie_B");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.impl.LebaPluginFeedApiImpl
 * JD-Core Version:    0.7.0.1
 */