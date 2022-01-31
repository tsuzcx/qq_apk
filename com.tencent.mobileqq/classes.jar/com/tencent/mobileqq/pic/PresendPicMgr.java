package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import awej;
import awen;
import awfp;
import awfq;
import awga;
import awgc;
import bdcs;
import bdee;
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
  private final awej jdField_a_of_type_Awej;
  public awfp a;
  private ArrayList<awfq> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = true;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public PresendPicMgr(awej paramawej)
  {
    awen.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, service = " + paramawej);
    this.jdField_a_of_type_Awej = paramawej;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("presend_worker_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Awfp = new awfp(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    try
    {
      paramawej = this.jdField_a_of_type_Awej.a();
      if ((paramawej != null) && (paramawej.length >= 4))
      {
        this.c = paramawej[0];
        this.d = paramawej[1];
        this.e = paramawej[2];
        this.f = paramawej[3];
      }
      int[] arrayOfInt = this.jdField_a_of_type_Awej.a();
      if ((arrayOfInt != null) && (arrayOfInt.length >= 9))
      {
        awgc.e = arrayOfInt[0];
        awgc.f = arrayOfInt[1];
        awgc.g = arrayOfInt[2];
        awgc.h = arrayOfInt[3];
        awgc.i = arrayOfInt[4];
        awgc.j = arrayOfInt[5];
        awgc.a = arrayOfInt[6];
        awgc.b = arrayOfInt[7];
        awgc.c = arrayOfInt[8];
      }
      awen.a("PresendPicMgr", "getInstance", "preCompressConfig = " + Arrays.toString(paramawej) + ",compressArgConfig = " + Arrays.toString(arrayOfInt));
      awen.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, mEnablePreCompress_WIFI = " + this.c + ",mEnablePreCompress_2G = " + this.d + ",mEnablePreCompress_3G = " + this.e + ",mEnablePreCompress_4G = " + this.f + ",PicType.MaxLongSide_Camera_C2C = " + awgc.e + ",PicType.MaxLongSide_Camera_Grp = " + awgc.f + ",PicType.MaxLongSide_Screenshot_C2C = " + awgc.g + ",PicType.MaxLongSide_Screenshot_Grp = " + awgc.h + ",PicType.MaxLongSide_Other_C2C = " + awgc.i + ",PicType.MaxLongSide_Other_Grp = " + awgc.j + ",PicType.SendPhotoWiFiPicQuality = " + awgc.a + ",PicType.SendPhoto23GPicQuality = " + awgc.b + ",PicType.SendPhoto4GPicQuality = " + awgc.c);
    }
    catch (RemoteException paramawej)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, "getPreCompressConfig" + paramawej.getMessage(), paramawej);
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
    i = bdee.a(BaseApplication.getContext());
    switch (i)
    {
    default: 
      this.jdField_a_of_type_Boolean = true;
      awen.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, NetType = " + i + ", mEnablePreCompress = " + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private awfq a(String paramString)
  {
    awen.a("PresendPicMgr", "findRequestByPath", "path = " + paramString);
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      awen.b("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      awen.b("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      awfq localawfq = (awfq)localIterator.next();
      if (localawfq.a.c.equals(paramString)) {
        return localawfq;
      }
    }
    return null;
  }
  
  public static PresendPicMgr a()
  {
    awen.a("PresendPicMgr", "getInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  }
  
  public static PresendPicMgr a(awej paramawej)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) {}
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) && (paramawej != null)) {
        jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramawej);
      }
      awen.a("PresendPicMgr", "getInstance", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramawej);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  public static PresendPicMgr b(awej paramawej)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
    {
      awen.a("PresendPicMgr", "newInstance()", "mInstance:" + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + "is not null,reset mInstance!");
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
    }
    if (paramawej != null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramawej);
      awen.a("PresendPicMgr", "newInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramawej);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  private void c()
  {
    awen.a("PresendPicMgr", "sendMsg___ start!", "");
    try
    {
      this.jdField_a_of_type_Awej.a();
      awen.a("PresendPicMgr", "sendMsg___ end!", "");
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
    awen.a("PresendPicMgr", "disablePicPresend", "");
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
      awen.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    awen.a("PresendPicMgr", "cancelAll", "Start! cancelType = " + paramInt);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((awfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    try
    {
      this.jdField_a_of_type_Awej.a(paramInt);
      awen.a("PresendPicMgr", "cancelAll", "End!");
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
    awen.a("PresendPicMgr", "getCompossedIntent", "");
    if (!this.jdField_a_of_type_Boolean)
    {
      awen.a("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
      return;
    }
    paramIntent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.jdField_a_of_type_Awfp).getBinder()));
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      awen.a("PresendPicMgr", "presendPic", "mEnablePreCompress is false!");
      return;
    }
    awen.a("PresendPicMgr", "presendPic", "path = " + paramString + ",busiType = " + paramInt1);
    if ((TextUtils.isEmpty(paramString)) || (!bdcs.b(paramString)))
    {
      awen.b("PresendPicMgr", "presendPic", "path = " + paramString + " pic not exist,return!");
      return;
    }
    paramString = new CompressInfo(paramString, awga.a(0), 1052);
    int j = -1;
    try
    {
      i = this.jdField_a_of_type_Awej.a();
      paramString.j = i;
      paramString.g = true;
      awen.a("PresendPicMgr", "presendPic", "uinType = " + i);
      paramString = new awfq(this, paramString, paramInt1, paramInt2);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.jdField_a_of_type_Awfp.post(new PresendPicMgr.PresendRunnable(this, paramString));
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
    awen.b("PresendPicMgr", "release", "");
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      awen.a("PresendPicMgr", "cancelPresendPic", "mEnablePreCompress is false!");
      return;
    }
    awen.a("PresendPicMgr", "cancelPresendPic", "path = " + paramString);
    awfq localawfq = a(paramString);
    if (localawfq == null)
    {
      awen.a("PresendPicMgr", "cancelPresendPic", "cannot find PresendReq,path = " + paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localawfq);
    localawfq.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */