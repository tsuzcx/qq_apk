package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StExpandItem;
import NS_MINI_INTERFACE.INTERFACE.StGetExpandAppListRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bblm;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;

public class MiniAppGetKuolieApplistServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_KUOLIE_APPLIST = "mini_kuolie_applist_data";
  public static final int NO_REQUIRED = 0;
  public static final int REQUIRED = 1;
  public static final String TAG = "MiniAppGetKuolieApplistServlet";
  
  public MiniAppGetKuolieApplistServlet()
  {
    this.observerId = 1044;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetExpandAppListRsp();
    ((INTERFACE.StGetExpandAppListRsp)localObject).mergeFrom(paramArrayOfByte);
    if ((paramBundle.getLong("retCode") == 0L) && (((INTERFACE.StGetExpandAppListRsp)localObject).expandItemList != null))
    {
      MiniAppRecommInfo localMiniAppRecommInfo = new MiniAppRecommInfo();
      localMiniAppRecommInfo.headDesc = ((INTERFACE.StGetExpandAppListRsp)localObject).expandTitle.get();
      localMiniAppRecommInfo.cacheValidTime = (System.currentTimeMillis() / 1000L + ((INTERFACE.StGetExpandAppListRsp)localObject).cacheTime.get());
      QLog.i("MiniAppGetKuolieApplistServlet", 1, "MiniAppKuolie StApiAppInfo cacheTime:" + ((INTERFACE.StGetExpandAppListRsp)localObject).cacheTime.get() + " itemSize:" + ((INTERFACE.StGetExpandAppListRsp)localObject).expandItemList.get().size());
      localObject = ((INTERFACE.StGetExpandAppListRsp)localObject).expandItemList.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        INTERFACE.StExpandItem localStExpandItem = (INTERFACE.StExpandItem)((Iterator)localObject).next();
        if (localStExpandItem != null)
        {
          paramArrayOfByte = (INTERFACE.StApiAppInfo)localStExpandItem.appInfo.get();
          if (paramArrayOfByte != null)
          {
            MiniAppInfo localMiniAppInfo = MiniAppInfo.from(paramArrayOfByte);
            MiniAppRecommInfo.MiniApp localMiniApp = new MiniAppRecommInfo.MiniApp();
            localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo = localMiniAppInfo;
            localMiniApp.jdField_a_of_type_JavaLangString = localMiniAppInfo.appId;
            if (!TextUtils.isEmpty(localStExpandItem.icon.get()))
            {
              paramArrayOfByte = localStExpandItem.icon.get();
              label245:
              localMiniApp.c = paramArrayOfByte;
              if (TextUtils.isEmpty(localStExpandItem.name.get())) {
                break label318;
              }
            }
            label318:
            for (paramArrayOfByte = localStExpandItem.name.get();; paramArrayOfByte = localMiniAppInfo.name)
            {
              localMiniApp.b = paramArrayOfByte;
              localMiniApp.jdField_a_of_type_Int = localStExpandItem.adId.get();
              localMiniAppRecommInfo.appInfoList.add(localMiniApp);
              break;
              paramArrayOfByte = localMiniAppInfo.iconUrl;
              break label245;
            }
          }
        }
      }
      paramBundle.putSerializable("mini_kuolie_applist_data", localMiniAppRecommInfo);
      notifyObserver(paramIntent, 1044, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1044, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject = null;
    if (arrayOfByte != null) {
      localObject = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte);
      arrayOfByte = new GetKuolieApplistRequest((COMM.StCommonExt)localObject).encode(paramIntent, i, getTraceId());
      localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.GetExpandAppList");
      paramPacket.putSendData(bblm.a((byte[])localObject));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetKuolieApplistServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetKuolieApplistServlet
 * JD-Core Version:    0.7.0.1
 */