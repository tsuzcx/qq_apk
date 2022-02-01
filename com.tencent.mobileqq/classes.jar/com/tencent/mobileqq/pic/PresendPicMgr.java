package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.pic.compress.PicType;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PresendPicMgr
{
  private static PresendPicMgr jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  private final IPresendPicMgr jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr;
  public PresendPicMgr.PresendHandler a;
  private ArrayList<PresendPicMgr.PresendReq> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = true;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public PresendPicMgr(IPresendPicMgr paramIPresendPicMgr)
  {
    this.jdField_a_of_type_Boolean = false;
    Logger.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, service = " + paramIPresendPicMgr);
    this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr = paramIPresendPicMgr;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("presend_worker_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr$PresendHandler = new PresendPicMgr.PresendHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    try
    {
      paramIPresendPicMgr = this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a();
      if ((paramIPresendPicMgr != null) && (paramIPresendPicMgr.length >= 4))
      {
        this.c = paramIPresendPicMgr[0];
        this.d = paramIPresendPicMgr[1];
        this.e = paramIPresendPicMgr[2];
        this.f = paramIPresendPicMgr[3];
      }
      int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a();
      if ((arrayOfInt != null) && (arrayOfInt.length >= 9))
      {
        PicType.e = arrayOfInt[0];
        PicType.f = arrayOfInt[1];
        PicType.g = arrayOfInt[2];
        PicType.h = arrayOfInt[3];
        PicType.i = arrayOfInt[4];
        PicType.j = arrayOfInt[5];
        PicType.a = arrayOfInt[6];
        PicType.b = arrayOfInt[7];
        PicType.c = arrayOfInt[8];
      }
      Logger.a("PresendPicMgr", "getInstance", "preCompressConfig = " + Arrays.toString(paramIPresendPicMgr) + ",compressArgConfig = " + Arrays.toString(arrayOfInt));
      Logger.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, mEnablePreCompress_WIFI = " + this.c + ",mEnablePreCompress_2G = " + this.d + ",mEnablePreCompress_3G = " + this.e + ",mEnablePreCompress_4G = " + this.f + ",PicType.MaxLongSide_Camera_C2C = " + PicType.e + ",PicType.MaxLongSide_Camera_Grp = " + PicType.f + ",PicType.MaxLongSide_Screenshot_C2C = " + PicType.g + ",PicType.MaxLongSide_Screenshot_Grp = " + PicType.h + ",PicType.MaxLongSide_Other_C2C = " + PicType.i + ",PicType.MaxLongSide_Other_Grp = " + PicType.j + ",PicType.SendPhotoWiFiPicQuality = " + PicType.a + ",PicType.SendPhoto23GPicQuality = " + PicType.b + ",PicType.SendPhoto4GPicQuality = " + PicType.c);
    }
    catch (RemoteException paramIPresendPicMgr)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, "getPreCompressConfig" + paramIPresendPicMgr.getMessage(), paramIPresendPicMgr);
          continue;
          this.jdField_a_of_type_Boolean = this.c;
          continue;
          this.jdField_a_of_type_Boolean = this.d;
          continue;
          this.jdField_a_of_type_Boolean = this.e;
          continue;
          this.jdField_a_of_type_Boolean = this.f;
        }
      }
    }
    i = NetworkUtil.a(BaseApplication.getContext());
    switch (i)
    {
    default: 
      this.jdField_a_of_type_Boolean = true;
      Logger.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, NetType = " + i + ", mEnablePreCompress = " + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private PresendPicMgr.PresendReq a(String paramString)
  {
    Logger.a("PresendPicMgr", "findRequestByPath", "path = " + paramString);
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      Logger.b("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      Logger.b("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PresendPicMgr.PresendReq localPresendReq = (PresendPicMgr.PresendReq)localIterator.next();
      if (localPresendReq.a.c.equals(paramString)) {
        return localPresendReq;
      }
    }
    return null;
  }
  
  public static PresendPicMgr a()
  {
    Logger.a("PresendPicMgr", "getInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  }
  
  public static PresendPicMgr a(IPresendPicMgr paramIPresendPicMgr)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) {}
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) && (paramIPresendPicMgr != null)) {
        jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramIPresendPicMgr);
      }
      Logger.a("PresendPicMgr", "getInstance", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramIPresendPicMgr);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  public static PresendPicMgr b(IPresendPicMgr paramIPresendPicMgr)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
    {
      Logger.a("PresendPicMgr", "newInstance()", "mInstance:" + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + "is not null,reset mInstance!");
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
    }
    if (paramIPresendPicMgr != null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramIPresendPicMgr);
      Logger.a("PresendPicMgr", "newInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramIPresendPicMgr);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  private void c()
  {
    Logger.a("PresendPicMgr", "sendMsg___ start!", "");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a();
      Logger.a("PresendPicMgr", "sendMsg___ end!", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgr", 2, localException.getMessage(), localException);
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void a()
  {
    Logger.a("PresendPicMgr", "disablePicPresend", "");
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", true).commit();
      ((SharedPreferences)localObject).edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Logger.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    Logger.a("PresendPicMgr", "cancelAll", "Start! cancelType = " + paramInt);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((PresendPicMgr.PresendReq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a(paramInt);
      Logger.a("PresendPicMgr", "cancelAll", "End!");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    Logger.a("PresendPicMgr", "getCompossedIntent", "");
    if (!this.jdField_a_of_type_Boolean)
    {
      Logger.a("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
      return;
    }
    paramIntent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr$PresendHandler).getBinder()));
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Logger.a("PresendPicMgr", "presendPic", "mEnablePreCompress is false!");
      return;
    }
    Logger.a("PresendPicMgr", "presendPic", "path = " + paramString + ",busiType = " + paramInt1);
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.b(paramString)))
    {
      Logger.b("PresendPicMgr", "presendPic", "path = " + paramString + " pic not exist,return!");
      return;
    }
    paramString = new CompressInfo(paramString, CompressOperator.a(0), 1052);
    int j = -1;
    try
    {
      i = this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a();
      paramString.j = i;
      paramString.g = true;
      Logger.a("PresendPicMgr", "presendPic", "uinType = " + i);
      paramString = new PresendPicMgr.PresendReq(this, paramString, paramInt1, paramInt2);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr$PresendHandler.post(new PresendPicMgr.PresendRunnable(this, paramString));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
          i = j;
        }
      }
    }
  }
  
  public void b()
  {
    Logger.b("PresendPicMgr", "release", "");
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Logger.a("PresendPicMgr", "cancelPresendPic", "mEnablePreCompress is false!");
      return;
    }
    Logger.a("PresendPicMgr", "cancelPresendPic", "path = " + paramString);
    PresendPicMgr.PresendReq localPresendReq = a(paramString);
    if (localPresendReq == null)
    {
      Logger.a("PresendPicMgr", "cancelPresendPic", "cannot find PresendReq,path = " + paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localPresendReq);
    localPresendReq.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */