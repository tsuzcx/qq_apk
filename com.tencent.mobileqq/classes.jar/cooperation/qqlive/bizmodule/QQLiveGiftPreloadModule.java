package cooperation.qqlive.bizmodule;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class QQLiveGiftPreloadModule
  extends QQLiveBaseRoomBizModule
{
  private IQQGiftSDK a;
  private boolean b = false;
  private AtomicBoolean c = new AtomicBoolean(false);
  private IQQGiftResourceDownloadCallback d = new QQLiveGiftPreloadModule.1(this);
  private IliveLiteEventCenter.Observer e = new QQLiveGiftPreloadModule.2(this);
  
  private void a(long paramLong)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new QQLiveGiftPreloadModule.3(this), paramLong);
  }
  
  private void i()
  {
    boolean bool = this.c.get();
    int i = 1;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gift res already preload, roomId:");
      ((StringBuilder)localObject).append(a());
      QLog.i("QQLiveGiftPreloadModule", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.c.set(true);
    if (e() == 1) {
      i = 2;
    }
    Object localObject = new GiftListData(i, String.valueOf(b()), String.valueOf(c()), String.valueOf(j()));
    IQQGiftSDK localIQQGiftSDK = this.a;
    if ((localIQQGiftSDK != null) && (!localIQQGiftSDK.k())) {
      this.a.d().a((GiftListData)localObject, new QQLiveGiftPreloadModule.4(this));
    }
  }
  
  private long j()
  {
    LiveAnchorInfo localLiveAnchorInfo = k();
    if (localLiveAnchorInfo == null)
    {
      QLog.e("QQLiveGiftPreloadModule", 1, "getReceiverUin liveAnchorInfo is null");
      return 0L;
    }
    return localLiveAnchorInfo.uid;
  }
  
  private LiveAnchorInfo k()
  {
    Object localObject = getRoomEngine();
    if (localObject == null)
    {
      QLog.e("QQLiveGiftPreloadModule", 1, "getReceiverUin roomEngine is null");
      return null;
    }
    localObject = ((RoomEngine)localObject).getEnginLogic();
    if (localObject == null)
    {
      QLog.e("QQLiveGiftPreloadModule", 1, "getReceiverUin enginLogic is null");
      return null;
    }
    localObject = ((RoomEnginLogic)localObject).getLiveInfo();
    if (localObject == null)
    {
      QLog.e("QQLiveGiftPreloadModule", 1, "getReceiverUin liveInfo is null");
      return null;
    }
    return ((LiveInfo)localObject).anchorInfo;
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityDestroy(paramLifecycleOwner);
    this.a = null;
    this.d = null;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.a = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
    this.context = paramContext;
    IliveLiteEventCenter.a().a(this.e);
    a(5000L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IliveLiteEventCenter.a().b(this.e);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGiftPreloadModule
 * JD-Core Version:    0.7.0.1
 */