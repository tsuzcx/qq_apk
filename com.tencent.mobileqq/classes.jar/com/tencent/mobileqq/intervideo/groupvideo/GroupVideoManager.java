package com.tencent.mobileqq.intervideo.groupvideo;

import adjr;
import adjs;
import adjt;
import adjv;
import adjw;
import adjx;
import adjy;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class GroupVideoManager
  implements Manager
{
  private static UpgradeablePluginManager jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager = new UpgradeablePluginManager(HuayangPluginNewDownloader.a(BaseApplicationImpl.getContext()), "group_video");
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PluginLoadListener jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoPluginLoadListener = new adjs(this);
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new adjx(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  public GroupVideoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      Context localContext2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.getContext();
      Context localContext1 = localContext2;
      if ((localContext2 instanceof ContextWrapper)) {
        localContext1 = ((ContextWrapper)localContext2).getBaseContext();
      }
      if ((localContext1 instanceof JumpActivity)) {
        ((Activity)localContext1).finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public static void a(String paramString, GroupVideoManager.CheckListener paramCheckListener)
  {
    ThreadManager.executeOnFileThread(new adjy(paramString, paramCheckListener));
  }
  
  public void a(Context paramContext)
  {
    IVPluginLoader.a(paramContext, "com.tencent.od").a();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isGroupCode", paramInt);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("roomCode", paramString1);
    localIntent.putExtra("backType", paramString5);
    localIntent.putExtra("fromId", paramString4);
    localIntent.putExtra("action", paramString3);
    localIntent.putExtra("openType", paramString6);
    localIntent.putExtra("extra", paramString7);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    PublicFragmentActivity.a(paramContext, localIntent, GroupVideoLoadingFragment.class);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, PluginLoadListener paramPluginLoadListener)
  {
    IVPluginLoader.a(paramContext, "com.tencent.od").a("group_video", "openGroupvideo", paramString1, paramString2, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7, paramPluginLoadListener);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramContext);
    localQQProgressDialog.c(2131429504);
    localQQProgressDialog.show();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = localQQProgressDialog;
    a("group_video", new adjr(this, paramContext, paramString2, paramString1, paramString3, paramString4));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      return;
    }
    GVideoGrayConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new adjt(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        } while (localObject1 == null);
        localObject2 = ((RecentUserProxy)localObject1).a(false);
      } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if (localRecentUser.type == 1) {
          try
          {
            ((List)localObject1).add(Long.valueOf(Long.parseLong(localRecentUser.uin)));
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
      }
      localObject2 = new adjv(this, paramBoolean);
      if (((List)localObject1).size() <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject2);
      this.jdField_a_of_type_Int = 0;
      localObject2 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    } while (localObject2 == null);
    ((TroopHandler)localObject2).a((List)localObject1, new adjw(this));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "updateGroupVideoStateList try count:" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Int < 8) && (paramBoolean))
    {
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject2, 1000L);
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "onDestroy");
    }
    a();
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    GVideoGrayConfig.a().b();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager
 * JD-Core Version:    0.7.0.1
 */