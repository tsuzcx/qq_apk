package com.tencent.mobileqq.wink.pick.circle.part.base;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import java.util.ArrayList;

public abstract class WinkCircleBasePart
  extends Part
  implements SimpleEventReceiver
{
  protected WinkCirclePhotoListLogic d;
  protected PhotoListBaseData e;
  
  public WinkCircleBasePart(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    this.d = paramWinkCirclePhotoListLogic;
    this.e = this.d.e;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.base.WinkCircleBasePart
 * JD-Core Version:    0.7.0.1
 */