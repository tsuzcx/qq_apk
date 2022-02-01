package com.tencent.mobileqq.flashshow.api.instance;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.flashshow.api.IFlashShowColdBootService;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.api.events.FSAccountChangeEvent;
import com.tencent.mobileqq.flashshow.api.events.FSFrameEvent;
import com.tencent.mobileqq.flashshow.api.interfaces.IFlashShowController;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.helper.FSGlobalInfoHelper;
import com.tencent.mobileqq.flashshow.helper.FSGpsHelper;
import com.tencent.mobileqq.flashshow.manager.FSMainTabInfoManager;
import com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager;
import com.tencent.mobileqq.flashshow.model.barrage.FSBarrageModel;
import com.tencent.mobileqq.flashshow.model.comment.FSCommentManager;
import com.tencent.mobileqq.flashshow.preload.FSFolderPreLoaderTask;
import com.tencent.mobileqq.flashshow.report.FSNativeSessionManager;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.report.dc.FSMonitorReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.tool.RFWBarrageThreadManager;
import java.util.ArrayList;

public class FlashShowController
  implements SimpleEventReceiver, IFlashShowController
{
  private static FlashShowController a;
  
  private FlashShowController()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public static FlashShowController a()
  {
    try
    {
      if (a == null) {
        a = new FlashShowController();
      }
      FlashShowController localFlashShowController = a;
      return localFlashShowController;
    }
    finally {}
  }
  
  private boolean a(FSRedPointData paramFSRedPointData)
  {
    return paramFSRedPointData.hasRedPointInfo();
  }
  
  private int b(FSRedPointData paramFSRedPointData)
  {
    int i = 2;
    if (paramFSRedPointData != null)
    {
      if (paramFSRedPointData.getBadgeInfoByte() == null) {
        return 2;
      }
      if (!paramFSRedPointData.hasRedPointInfo()) {
        return 2;
      }
      int j = paramFSRedPointData.getBadgeSubTypeValue();
      i = 1;
      if (j == 1) {
        return 3;
      }
    }
    return i;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSAccountChangeEvent.class);
    return localArrayList;
  }
  
  public Fragment getFragmentInstance()
  {
    FSGpsHelper.a().c();
    PreLoader.preLoad("3002", new FSFolderPreLoaderTask());
    return FSFolderFragmentManager.a().b();
  }
  
  public View getRootView()
  {
    return FSFolderFragmentManager.a().c();
  }
  
  public void onAccountChange(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FSDataCenter.c();
      FSNativeSessionManager.a().c();
      FSMainTabInfoManager.b();
      FSBarrageModel.b();
      FSCommentManager.b();
      RFWBarrageThreadManager.a();
      FSRichMediaDownLoadManager.a().b();
      FSGlobalInfoHelper.c();
      ((IFlashShowColdBootService)QRoute.api(IFlashShowColdBootService.class)).release();
      QLog.d("FlashShowController", 1, "onAccountChange:true");
    }
  }
  
  public boolean onBackPressed()
  {
    return FSFolderFragmentManager.a().h();
  }
  
  public void onPageClickSelf()
  {
    if (getFragmentInstance() == null) {
      return;
    }
    SimpleEventBus.getInstance().dispatchEvent(new FSFrameEvent(getFragmentInstance().hashCode(), 0));
  }
  
  public void onPageDestroy()
  {
    FSFolderFragmentManager.a().g();
  }
  
  public void onPageSelected()
  {
    FSFolderFragmentManager.a().d();
    SimpleEventBus.getInstance().dispatchEvent(new FSFrameEvent(getFragmentInstance().hashCode(), 4));
    FSMonitorReporter.a().f();
  }
  
  public void onPageUnSelected()
  {
    FSFolderFragmentManager.a().e();
    FSMonitorReporter.a().g();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSAccountChangeEvent)) {
      onAccountChange(((FSAccountChangeEvent)paramSimpleBaseEvent).hasSwitchAccount());
    }
  }
  
  public void reportFrameExpose(int paramInt)
  {
    FSRedPointData localFSRedPointData = ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).getBottomRedPointInfo();
    byte[] arrayOfByte = null;
    DataBuilder localDataBuilder = new DataBuilder(null).setActionType(110).setSubActionType(1).setExt2(String.valueOf(paramInt)).setThrActionType(b(localFSRedPointData));
    if (a(localFSRedPointData)) {
      arrayOfByte = localFSRedPointData.getBadgeContentTraceInfoByte();
    }
    FSLpReportDc11001.a(localDataBuilder.setCommonReportInfo(arrayOfByte));
  }
  
  public void reportFrameTabClick()
  {
    FSRedPointData localFSRedPointData = ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).getBottomRedPointInfo();
    byte[] arrayOfByte = null;
    DataBuilder localDataBuilder = new DataBuilder(null).setActionType(110).setSubActionType(2).setThrActionType(b(localFSRedPointData));
    if (a(localFSRedPointData)) {
      arrayOfByte = localFSRedPointData.getBadgeContentTraceInfoByte();
    }
    FSLpReportDc11001.a(localDataBuilder.setCommonReportInfo(arrayOfByte));
  }
  
  public void setTabHeight(int paramInt)
  {
    FSFolderFragmentManager.a().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.instance.FlashShowController
 * JD-Core Version:    0.7.0.1
 */