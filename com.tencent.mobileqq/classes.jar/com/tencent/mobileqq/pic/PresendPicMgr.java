package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import azps;
import azpw;
import azqx;
import azqy;
import azrm;
import azro;
import bhmi;
import bhnv;
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
  public Messenger a;
  private final azps jdField_a_of_type_Azps;
  public azqx a;
  private ArrayList<azqy> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = true;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public PresendPicMgr(azps paramazps)
  {
    azpw.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, service = " + paramazps);
    this.jdField_a_of_type_Azps = paramazps;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("presend_worker_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Azqx = new azqx(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    try
    {
      paramazps = this.jdField_a_of_type_Azps.a();
      if ((paramazps != null) && (paramazps.length >= 4))
      {
        this.c = paramazps[0];
        this.d = paramazps[1];
        this.e = paramazps[2];
        this.f = paramazps[3];
      }
      int[] arrayOfInt = this.jdField_a_of_type_Azps.a();
      if ((arrayOfInt != null) && (arrayOfInt.length >= 9))
      {
        azro.e = arrayOfInt[0];
        azro.f = arrayOfInt[1];
        azro.g = arrayOfInt[2];
        azro.h = arrayOfInt[3];
        azro.i = arrayOfInt[4];
        azro.j = arrayOfInt[5];
        azro.a = arrayOfInt[6];
        azro.b = arrayOfInt[7];
        azro.c = arrayOfInt[8];
      }
      azpw.a("PresendPicMgr", "getInstance", "preCompressConfig = " + Arrays.toString(paramazps) + ",compressArgConfig = " + Arrays.toString(arrayOfInt));
      azpw.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, mEnablePreCompress_WIFI = " + this.c + ",mEnablePreCompress_2G = " + this.d + ",mEnablePreCompress_3G = " + this.e + ",mEnablePreCompress_4G = " + this.f + ",PicType.MaxLongSide_Camera_C2C = " + azro.e + ",PicType.MaxLongSide_Camera_Grp = " + azro.f + ",PicType.MaxLongSide_Screenshot_C2C = " + azro.g + ",PicType.MaxLongSide_Screenshot_Grp = " + azro.h + ",PicType.MaxLongSide_Other_C2C = " + azro.i + ",PicType.MaxLongSide_Other_Grp = " + azro.j + ",PicType.SendPhotoWiFiPicQuality = " + azro.a + ",PicType.SendPhoto23GPicQuality = " + azro.b + ",PicType.SendPhoto4GPicQuality = " + azro.c);
    }
    catch (RemoteException paramazps)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, "getPreCompressConfig" + paramazps.getMessage(), paramazps);
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
    i = bhnv.a(BaseApplication.getContext());
    switch (i)
    {
    default: 
      this.jdField_a_of_type_Boolean = true;
      azpw.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, NetType = " + i + ", mEnablePreCompress = " + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private azqy a(String paramString)
  {
    azpw.a("PresendPicMgr", "findRequestByPath", "path = " + paramString);
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      azpw.b("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      azpw.b("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      azqy localazqy = (azqy)localIterator.next();
      if (localazqy.a.c.equals(paramString)) {
        return localazqy;
      }
    }
    return null;
  }
  
  public static PresendPicMgr a()
  {
    azpw.a("PresendPicMgr", "getInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  }
  
  public static PresendPicMgr a(azps paramazps)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) {}
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) && (paramazps != null)) {
        jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramazps);
      }
      azpw.a("PresendPicMgr", "getInstance", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramazps);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  public static PresendPicMgr b(azps paramazps)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
    {
      azpw.a("PresendPicMgr", "newInstance()", "mInstance:" + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + "is not null,reset mInstance!");
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
    }
    if (paramazps != null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramazps);
      azpw.a("PresendPicMgr", "newInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramazps);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  private void c()
  {
    azpw.a("PresendPicMgr", "sendMsg___ start!", "");
    try
    {
      this.jdField_a_of_type_Azps.a();
      azpw.a("PresendPicMgr", "sendMsg___ end!", "");
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
    azpw.a("PresendPicMgr", "disablePicPresend", "");
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
      azpw.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    azpw.a("PresendPicMgr", "cancelAll", "Start! cancelType = " + paramInt);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((azqy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    try
    {
      this.jdField_a_of_type_Azps.a(paramInt);
      azpw.a("PresendPicMgr", "cancelAll", "End!");
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
    azpw.a("PresendPicMgr", "getCompossedIntent", "");
    if (!this.jdField_a_of_type_Boolean)
    {
      azpw.a("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
      return;
    }
    paramIntent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.jdField_a_of_type_Azqx).getBinder()));
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      azpw.a("PresendPicMgr", "presendPic", "mEnablePreCompress is false!");
      return;
    }
    azpw.a("PresendPicMgr", "presendPic", "path = " + paramString + ",busiType = " + paramInt1);
    if ((TextUtils.isEmpty(paramString)) || (!bhmi.b(paramString)))
    {
      azpw.b("PresendPicMgr", "presendPic", "path = " + paramString + " pic not exist,return!");
      return;
    }
    paramString = new CompressInfo(paramString, azrm.a(0), 1052);
    int j = -1;
    try
    {
      i = this.jdField_a_of_type_Azps.a();
      paramString.j = i;
      paramString.g = true;
      azpw.a("PresendPicMgr", "presendPic", "uinType = " + i);
      paramString = new azqy(this, paramString, paramInt1, paramInt2);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.jdField_a_of_type_Azqx.post(new PresendPicMgr.PresendRunnable(this, paramString));
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
    azpw.b("PresendPicMgr", "release", "");
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      azpw.a("PresendPicMgr", "cancelPresendPic", "mEnablePreCompress is false!");
      return;
    }
    azpw.a("PresendPicMgr", "cancelPresendPic", "path = " + paramString);
    azqy localazqy = a(paramString);
    if (localazqy == null)
    {
      azpw.a("PresendPicMgr", "cancelPresendPic", "cannot find PresendReq,path = " + paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localazqy);
    localazqy.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */