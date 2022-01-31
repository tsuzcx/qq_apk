package com.tencent.mobileqq.hotpic;

import adsq;
import adsr;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.ArrayList;

public class VideoItemEventManager
{
  private static volatile VideoItemEventManager jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new adsr(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new adsq(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  private VideoItemEventManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a(true);
  }
  
  public static VideoItemEventManager a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager == null) {
        jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager = new VideoItemEventManager(paramContext);
      }
      return jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager;
    }
    finally {}
  }
  
  public void a(VideoItemEventManager.onVideoItemEventListener paramonVideoItemEventListener)
  {
    if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramonVideoItemEventListener)) && (paramonVideoItemEventListener != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramonVideoItemEventListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      localIntentFilter.addAction("VolumeBtnDown");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return false;
    }
    return true;
  }
  
  public void b(VideoItemEventManager.onVideoItemEventListener paramonVideoItemEventListener)
  {
    if ((paramonVideoItemEventListener != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramonVideoItemEventListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramonVideoItemEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoItemEventManager
 * JD-Core Version:    0.7.0.1
 */