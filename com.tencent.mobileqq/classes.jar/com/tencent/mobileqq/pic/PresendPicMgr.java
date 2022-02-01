package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.compress.AbstractPicType;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("construct PresendPicMgr, service = ");
    ((StringBuilder)localObject).append(paramIPresendPicMgr);
    Logger.a("PresendPicMgr", "getInstance", ((StringBuilder)localObject).toString());
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a();
      if ((localObject != null) && (localObject.length >= 9))
      {
        AbstractPicType.d = localObject[0];
        AbstractPicType.e = localObject[1];
        AbstractPicType.f = localObject[2];
        AbstractPicType.g = localObject[3];
        AbstractPicType.h = localObject[4];
        AbstractPicType.i = localObject[5];
        AbstractPicType.a = localObject[6];
        AbstractPicType.b = localObject[7];
        AbstractPicType.c = localObject[8];
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preCompressConfig = ");
      localStringBuilder.append(Arrays.toString(paramIPresendPicMgr));
      localStringBuilder.append(",compressArgConfig = ");
      localStringBuilder.append(Arrays.toString((int[])localObject));
      Logger.a("PresendPicMgr", "getInstance", localStringBuilder.toString());
      paramIPresendPicMgr = new StringBuilder();
      paramIPresendPicMgr.append("construct PresendPicMgr, mEnablePreCompress_WIFI = ");
      paramIPresendPicMgr.append(this.c);
      paramIPresendPicMgr.append(",mEnablePreCompress_2G = ");
      paramIPresendPicMgr.append(this.d);
      paramIPresendPicMgr.append(",mEnablePreCompress_3G = ");
      paramIPresendPicMgr.append(this.e);
      paramIPresendPicMgr.append(",mEnablePreCompress_4G = ");
      paramIPresendPicMgr.append(this.f);
      paramIPresendPicMgr.append(",PicType.MaxLongSide_Camera_C2C = ");
      paramIPresendPicMgr.append(AbstractPicType.d);
      paramIPresendPicMgr.append(",PicType.MaxLongSide_Camera_Grp = ");
      paramIPresendPicMgr.append(AbstractPicType.e);
      paramIPresendPicMgr.append(",PicType.MaxLongSide_Screenshot_C2C = ");
      paramIPresendPicMgr.append(AbstractPicType.f);
      paramIPresendPicMgr.append(",PicType.MaxLongSide_Screenshot_Grp = ");
      paramIPresendPicMgr.append(AbstractPicType.g);
      paramIPresendPicMgr.append(",PicType.MaxLongSide_Other_C2C = ");
      paramIPresendPicMgr.append(AbstractPicType.h);
      paramIPresendPicMgr.append(",PicType.MaxLongSide_Other_Grp = ");
      paramIPresendPicMgr.append(AbstractPicType.i);
      paramIPresendPicMgr.append(",PicType.SendPhotoWiFiPicQuality = ");
      paramIPresendPicMgr.append(AbstractPicType.a);
      paramIPresendPicMgr.append(",PicType.SendPhoto23GPicQuality = ");
      paramIPresendPicMgr.append(AbstractPicType.b);
      paramIPresendPicMgr.append(",PicType.SendPhoto4GPicQuality = ");
      paramIPresendPicMgr.append(AbstractPicType.c);
      Logger.a("PresendPicMgr", "getInstance", paramIPresendPicMgr.toString());
    }
    catch (RemoteException paramIPresendPicMgr)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getPreCompressConfig");
        ((StringBuilder)localObject).append(paramIPresendPicMgr.getMessage());
        QLog.e("PresendPicMgr", 2, ((StringBuilder)localObject).toString(), paramIPresendPicMgr);
      }
    }
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            this.jdField_a_of_type_Boolean = true;
          } else {
            this.jdField_a_of_type_Boolean = this.f;
          }
        }
        else {
          this.jdField_a_of_type_Boolean = this.e;
        }
      }
      else {
        this.jdField_a_of_type_Boolean = this.d;
      }
    }
    else {
      this.jdField_a_of_type_Boolean = this.c;
    }
    paramIPresendPicMgr = new StringBuilder();
    paramIPresendPicMgr.append("construct PresendPicMgr, NetType = ");
    paramIPresendPicMgr.append(i);
    paramIPresendPicMgr.append(", mEnablePreCompress = ");
    paramIPresendPicMgr.append(this.jdField_a_of_type_Boolean);
    Logger.a("PresendPicMgr", "getInstance", paramIPresendPicMgr.toString());
  }
  
  private PresendPicMgr.PresendReq a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("path = ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("PresendPicMgr", "findRequestByPath", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject == null)
    {
      Logger.b("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
      return null;
    }
    if (((ArrayList)localObject).size() == 0)
    {
      Logger.b("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
      return null;
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PresendPicMgr.PresendReq localPresendReq = (PresendPicMgr.PresendReq)((Iterator)localObject).next();
      if (localPresendReq.a.c.equals(paramString)) {
        return localPresendReq;
      }
    }
    return null;
  }
  
  public static PresendPicMgr a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mInstance = ");
    localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
    Logger.a("PresendPicMgr", "getInstance()", localStringBuilder.toString());
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  }
  
  public static PresendPicMgr a(IPresendPicMgr paramIPresendPicMgr)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) {
      try
      {
        if ((jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) && (paramIPresendPicMgr != null)) {
          jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramIPresendPicMgr);
        }
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mInstance = ");
    localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
    localStringBuilder.append(", Ibinder = ");
    localStringBuilder.append(paramIPresendPicMgr);
    Logger.a("PresendPicMgr", "getInstance", localStringBuilder.toString());
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  }
  
  public static PresendPicMgr b(IPresendPicMgr paramIPresendPicMgr)
  {
    StringBuilder localStringBuilder;
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mInstance:");
      localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
      localStringBuilder.append("is not null,reset mInstance!");
      Logger.a("PresendPicMgr", "newInstance()", localStringBuilder.toString());
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
    }
    if (paramIPresendPicMgr != null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramIPresendPicMgr);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mInstance = ");
      localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr);
      localStringBuilder.append(", Ibinder = ");
      localStringBuilder.append(paramIPresendPicMgr);
      Logger.a("PresendPicMgr", "newInstance()", localStringBuilder.toString());
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
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PresendPicMgr", 2, localException.getMessage(), localException);
      }
    }
    Logger.a("PresendPicMgr", "sendMsg___ end!", "");
  }
  
  public int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public void a()
  {
    Logger.a("PresendPicMgr", "disablePicPresend", "");
    Object localObject = BaseApplication.getContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
    ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", true).commit();
    ((SharedPreferences)localObject).edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Logger.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Start! cancelType = ");
    localStringBuilder.append(paramInt);
    Logger.a("PresendPicMgr", "cancelAll", localStringBuilder.toString());
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
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
      }
    }
    Logger.a("PresendPicMgr", "cancelAll", "End!");
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("path = ");
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(",busiType = ");
    localStringBuilder1.append(paramInt1);
    Logger.a("PresendPicMgr", "presendPic", localStringBuilder1.toString());
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.fileExistsAndNotEmpty(paramString)))
    {
      paramString = new CompressInfo(paramString, ((ICompressOperator)QRoute.api(ICompressOperator.class)).transformQuality(0), 1052);
      int j = -1;
      int i;
      try
      {
        i = this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a();
      }
      catch (RemoteException localRemoteException)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
          i = j;
        }
      }
      paramString.j = i;
      paramString.g = true;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("uinType = ");
      localStringBuilder2.append(i);
      Logger.a("PresendPicMgr", "presendPic", localStringBuilder2.toString());
      paramString = new PresendPicMgr.PresendReq(this, paramString, paramInt1, paramInt2);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr$PresendHandler.post(new PresendPicMgr.PresendRunnable(this, paramString));
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("path = ");
    localStringBuilder2.append(paramString);
    localStringBuilder2.append(" pic not exist,return!");
    Logger.b("PresendPicMgr", "presendPic", localStringBuilder2.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("path = ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("PresendPicMgr", "cancelPresendPic", ((StringBuilder)localObject).toString());
    localObject = a(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot find PresendReq,path = ");
      ((StringBuilder)localObject).append(paramString);
      Logger.a("PresendPicMgr", "cancelPresendPic", ((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
    ((PresendPicMgr.PresendReq)localObject).a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */