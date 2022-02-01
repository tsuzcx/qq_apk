package com.tencent.mobileqq.studyroom.api;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.manager.Manager;

@QAPI(process={"all"})
public abstract interface IStudyRoomMisc
  extends QRouteApi
{
  public abstract Class<? extends QPublicBaseFragment> getDebugSettingFragmentClass();
  
  public abstract Class<? extends Manager> getManagerImplClass();
  
  public abstract Class<? extends IQConfigProcessor> getQConfigProcessorClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.IStudyRoomMisc
 * JD-Core Version:    0.7.0.1
 */