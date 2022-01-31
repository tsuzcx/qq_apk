package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import aunc;
import aung;
import auoh;
import auoi;
import auos;
import auou;
import bbdx;
import bbfj;
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
  private final aunc jdField_a_of_type_Aunc;
  public auoh a;
  private ArrayList<auoi> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = true;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public PresendPicMgr(aunc paramaunc)
  {
    aung.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, service = " + paramaunc);
    this.jdField_a_of_type_Aunc = paramaunc;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("presend_worker_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Auoh = new auoh(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    try
    {
      paramaunc = this.jdField_a_of_type_Aunc.a();
      if ((paramaunc != null) && (paramaunc.length >= 4))
      {
        this.c = paramaunc[0];
        this.d = paramaunc[1];
        this.e = paramaunc[2];
        this.f = paramaunc[3];
      }
      int[] arrayOfInt = this.jdField_a_of_type_Aunc.a();
      if ((arrayOfInt != null) && (arrayOfInt.length >= 9))
      {
        auou.e = arrayOfInt[0];
        auou.f = arrayOfInt[1];
        auou.g = arrayOfInt[2];
        auou.h = arrayOfInt[3];
        auou.i = arrayOfInt[4];
        auou.j = arrayOfInt[5];
        auou.a = arrayOfInt[6];
        auou.b = arrayOfInt[7];
        auou.c = arrayOfInt[8];
      }
      aung.a("PresendPicMgr", "getInstance", "preCompressConfig = " + Arrays.toString(paramaunc) + ",compressArgConfig = " + Arrays.toString(arrayOfInt));
      aung.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, mEnablePreCompress_WIFI = " + this.c + ",mEnablePreCompress_2G = " + this.d + ",mEnablePreCompress_3G = " + this.e + ",mEnablePreCompress_4G = " + this.f + ",PicType.MaxLongSide_Camera_C2C = " + auou.e + ",PicType.MaxLongSide_Camera_Grp = " + auou.f + ",PicType.MaxLongSide_Screenshot_C2C = " + auou.g + ",PicType.MaxLongSide_Screenshot_Grp = " + auou.h + ",PicType.MaxLongSide_Other_C2C = " + auou.i + ",PicType.MaxLongSide_Other_Grp = " + auou.j + ",PicType.SendPhotoWiFiPicQuality = " + auou.a + ",PicType.SendPhoto23GPicQuality = " + auou.b + ",PicType.SendPhoto4GPicQuality = " + auou.c);
    }
    catch (RemoteException paramaunc)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, "getPreCompressConfig" + paramaunc.getMessage(), paramaunc);
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
    i = bbfj.a(BaseApplication.getContext());
    switch (i)
    {
    default: 
      this.jdField_a_of_type_Boolean = true;
      aung.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, NetType = " + i + ", mEnablePreCompress = " + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private auoi a(String paramString)
  {
    aung.a("PresendPicMgr", "findRequestByPath", "path = " + paramString);
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      aung.b("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      aung.b("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      auoi localauoi = (auoi)localIterator.next();
      if (localauoi.a.c.equals(paramString)) {
        return localauoi;
      }
    }
    return null;
  }
  
  public static PresendPicMgr a()
  {
    aung.a("PresendPicMgr", "getInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  }
  
  public static PresendPicMgr a(aunc paramaunc)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) {}
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) && (paramaunc != null)) {
        jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramaunc);
      }
      aung.a("PresendPicMgr", "getInstance", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramaunc);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  public static PresendPicMgr b(aunc paramaunc)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
    {
      aung.a("PresendPicMgr", "newInstance()", "mInstance:" + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + "is not null,reset mInstance!");
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
    }
    if (paramaunc != null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramaunc);
      aung.a("PresendPicMgr", "newInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramaunc);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  private void c()
  {
    aung.a("PresendPicMgr", "sendMsg___ start!", "");
    try
    {
      this.jdField_a_of_type_Aunc.a();
      aung.a("PresendPicMgr", "sendMsg___ end!", "");
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
    aung.a("PresendPicMgr", "disablePicPresend", "");
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
      aung.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    aung.a("PresendPicMgr", "cancelAll", "Start! cancelType = " + paramInt);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((auoi)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    try
    {
      this.jdField_a_of_type_Aunc.a(paramInt);
      aung.a("PresendPicMgr", "cancelAll", "End!");
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
    aung.a("PresendPicMgr", "getCompossedIntent", "");
    if (!this.jdField_a_of_type_Boolean)
    {
      aung.a("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
      return;
    }
    paramIntent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.jdField_a_of_type_Auoh).getBinder()));
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      aung.a("PresendPicMgr", "presendPic", "mEnablePreCompress is false!");
      return;
    }
    aung.a("PresendPicMgr", "presendPic", "path = " + paramString + ",busiType = " + paramInt1);
    if ((TextUtils.isEmpty(paramString)) || (!bbdx.b(paramString)))
    {
      aung.b("PresendPicMgr", "presendPic", "path = " + paramString + " pic not exist,return!");
      return;
    }
    paramString = new CompressInfo(paramString, auos.a(0), 1052);
    int j = -1;
    try
    {
      i = this.jdField_a_of_type_Aunc.a();
      paramString.j = i;
      paramString.g = true;
      aung.a("PresendPicMgr", "presendPic", "uinType = " + i);
      paramString = new auoi(this, paramString, paramInt1, paramInt2);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.jdField_a_of_type_Auoh.post(new PresendPicMgr.PresendRunnable(this, paramString));
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
    aung.b("PresendPicMgr", "release", "");
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      aung.a("PresendPicMgr", "cancelPresendPic", "mEnablePreCompress is false!");
      return;
    }
    aung.a("PresendPicMgr", "cancelPresendPic", "path = " + paramString);
    auoi localauoi = a(paramString);
    if (localauoi == null)
    {
      aung.a("PresendPicMgr", "cancelPresendPic", "cannot find PresendReq,path = " + paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localauoi);
    localauoi.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */