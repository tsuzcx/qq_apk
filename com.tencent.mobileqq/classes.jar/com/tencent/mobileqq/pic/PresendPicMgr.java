package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import azjm;
import azjq;
import azkr;
import azks;
import azlg;
import azli;
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
  public Messenger a;
  private final azjm jdField_a_of_type_Azjm;
  public azkr a;
  private ArrayList<azks> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = true;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public PresendPicMgr(azjm paramazjm)
  {
    azjq.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, service = " + paramazjm);
    this.jdField_a_of_type_Azjm = paramazjm;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("presend_worker_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Azkr = new azkr(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    try
    {
      paramazjm = this.jdField_a_of_type_Azjm.a();
      if ((paramazjm != null) && (paramazjm.length >= 4))
      {
        this.c = paramazjm[0];
        this.d = paramazjm[1];
        this.e = paramazjm[2];
        this.f = paramazjm[3];
      }
      int[] arrayOfInt = this.jdField_a_of_type_Azjm.a();
      if ((arrayOfInt != null) && (arrayOfInt.length >= 9))
      {
        azli.e = arrayOfInt[0];
        azli.f = arrayOfInt[1];
        azli.g = arrayOfInt[2];
        azli.h = arrayOfInt[3];
        azli.i = arrayOfInt[4];
        azli.j = arrayOfInt[5];
        azli.a = arrayOfInt[6];
        azli.b = arrayOfInt[7];
        azli.c = arrayOfInt[8];
      }
      azjq.a("PresendPicMgr", "getInstance", "preCompressConfig = " + Arrays.toString(paramazjm) + ",compressArgConfig = " + Arrays.toString(arrayOfInt));
      azjq.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, mEnablePreCompress_WIFI = " + this.c + ",mEnablePreCompress_2G = " + this.d + ",mEnablePreCompress_3G = " + this.e + ",mEnablePreCompress_4G = " + this.f + ",PicType.MaxLongSide_Camera_C2C = " + azli.e + ",PicType.MaxLongSide_Camera_Grp = " + azli.f + ",PicType.MaxLongSide_Screenshot_C2C = " + azli.g + ",PicType.MaxLongSide_Screenshot_Grp = " + azli.h + ",PicType.MaxLongSide_Other_C2C = " + azli.i + ",PicType.MaxLongSide_Other_Grp = " + azli.j + ",PicType.SendPhotoWiFiPicQuality = " + azli.a + ",PicType.SendPhoto23GPicQuality = " + azli.b + ",PicType.SendPhoto4GPicQuality = " + azli.c);
    }
    catch (RemoteException paramazjm)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, "getPreCompressConfig" + paramazjm.getMessage(), paramazjm);
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
    i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    switch (i)
    {
    default: 
      this.jdField_a_of_type_Boolean = true;
      azjq.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, NetType = " + i + ", mEnablePreCompress = " + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private azks a(String paramString)
  {
    azjq.a("PresendPicMgr", "findRequestByPath", "path = " + paramString);
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      azjq.b("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      azjq.b("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      azks localazks = (azks)localIterator.next();
      if (localazks.a.c.equals(paramString)) {
        return localazks;
      }
    }
    return null;
  }
  
  public static PresendPicMgr a()
  {
    azjq.a("PresendPicMgr", "getInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  }
  
  public static PresendPicMgr a(azjm paramazjm)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) {}
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) && (paramazjm != null)) {
        jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramazjm);
      }
      azjq.a("PresendPicMgr", "getInstance", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramazjm);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  public static PresendPicMgr b(azjm paramazjm)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
    {
      azjq.a("PresendPicMgr", "newInstance()", "mInstance:" + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + "is not null,reset mInstance!");
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
    }
    if (paramazjm != null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramazjm);
      azjq.a("PresendPicMgr", "newInstance()", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramazjm);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  private void c()
  {
    azjq.a("PresendPicMgr", "sendMsg___ start!", "");
    try
    {
      this.jdField_a_of_type_Azjm.a();
      azjq.a("PresendPicMgr", "sendMsg___ end!", "");
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
    azjq.a("PresendPicMgr", "disablePicPresend", "");
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
      azjq.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    azjq.a("PresendPicMgr", "cancelAll", "Start! cancelType = " + paramInt);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((azks)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    try
    {
      this.jdField_a_of_type_Azjm.a(paramInt);
      azjq.a("PresendPicMgr", "cancelAll", "End!");
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
    azjq.a("PresendPicMgr", "getCompossedIntent", "");
    if (!this.jdField_a_of_type_Boolean)
    {
      azjq.a("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
      return;
    }
    paramIntent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.jdField_a_of_type_Azkr).getBinder()));
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      azjq.a("PresendPicMgr", "presendPic", "mEnablePreCompress is false!");
      return;
    }
    azjq.a("PresendPicMgr", "presendPic", "path = " + paramString + ",busiType = " + paramInt1);
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.fileExistsAndNotEmpty(paramString)))
    {
      azjq.b("PresendPicMgr", "presendPic", "path = " + paramString + " pic not exist,return!");
      return;
    }
    paramString = new CompressInfo(paramString, azlg.a(0), 1052);
    int j = -1;
    try
    {
      i = this.jdField_a_of_type_Azjm.a();
      paramString.j = i;
      paramString.g = true;
      azjq.a("PresendPicMgr", "presendPic", "uinType = " + i);
      paramString = new azks(this, paramString, paramInt1, paramInt2);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.jdField_a_of_type_Azkr.post(new PresendPicMgr.PresendRunnable(this, paramString));
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
    azjq.b("PresendPicMgr", "release", "");
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      azjq.a("PresendPicMgr", "cancelPresendPic", "mEnablePreCompress is false!");
      return;
    }
    azjq.a("PresendPicMgr", "cancelPresendPic", "path = " + paramString);
    azks localazks = a(paramString);
    if (localazks == null)
    {
      azjq.a("PresendPicMgr", "cancelPresendPic", "cannot find PresendReq,path = " + paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localazks);
    localazks.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */