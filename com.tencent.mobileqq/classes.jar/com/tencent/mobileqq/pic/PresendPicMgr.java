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
  private static PresendPicMgr e;
  public PresendPicMgr.PresendHandler a;
  Messenger b;
  public boolean c = false;
  private final IPresendPicMgr d;
  private ArrayList<PresendPicMgr.PresendReq> f;
  private HandlerThread g;
  private boolean h = true;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  public PresendPicMgr(IPresendPicMgr paramIPresendPicMgr)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("construct PresendPicMgr, service = ");
    ((StringBuilder)localObject).append(paramIPresendPicMgr);
    Logger.a("PresendPicMgr", "getInstance", ((StringBuilder)localObject).toString());
    this.d = paramIPresendPicMgr;
    this.f = new ArrayList();
    this.g = new HandlerThread("presend_worker_thread");
    this.g.start();
    this.a = new PresendPicMgr.PresendHandler(this.g.getLooper(), this);
    try
    {
      paramIPresendPicMgr = this.d.c();
      if ((paramIPresendPicMgr != null) && (paramIPresendPicMgr.length >= 4))
      {
        this.i = paramIPresendPicMgr[0];
        this.j = paramIPresendPicMgr[1];
        this.k = paramIPresendPicMgr[2];
        this.l = paramIPresendPicMgr[3];
      }
      localObject = this.d.d();
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
      paramIPresendPicMgr.append(this.i);
      paramIPresendPicMgr.append(",mEnablePreCompress_2G = ");
      paramIPresendPicMgr.append(this.j);
      paramIPresendPicMgr.append(",mEnablePreCompress_3G = ");
      paramIPresendPicMgr.append(this.k);
      paramIPresendPicMgr.append(",mEnablePreCompress_4G = ");
      paramIPresendPicMgr.append(this.l);
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
    int m = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4) {
            this.c = true;
          } else {
            this.c = this.l;
          }
        }
        else {
          this.c = this.k;
        }
      }
      else {
        this.c = this.j;
      }
    }
    else {
      this.c = this.i;
    }
    paramIPresendPicMgr = new StringBuilder();
    paramIPresendPicMgr.append("construct PresendPicMgr, NetType = ");
    paramIPresendPicMgr.append(m);
    paramIPresendPicMgr.append(", mEnablePreCompress = ");
    paramIPresendPicMgr.append(this.c);
    Logger.a("PresendPicMgr", "getInstance", paramIPresendPicMgr.toString());
  }
  
  private PresendPicMgr.PresendReq a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("path = ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("PresendPicMgr", "findRequestByPath", ((StringBuilder)localObject).toString());
    localObject = this.f;
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
    localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PresendPicMgr.PresendReq localPresendReq = (PresendPicMgr.PresendReq)((Iterator)localObject).next();
      if (localPresendReq.d.h.equals(paramString)) {
        return localPresendReq;
      }
    }
    return null;
  }
  
  public static PresendPicMgr a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mInstance = ");
    localStringBuilder.append(e);
    Logger.a("PresendPicMgr", "getInstance()", localStringBuilder.toString());
    return e;
  }
  
  public static PresendPicMgr a(IPresendPicMgr paramIPresendPicMgr)
  {
    if (e == null) {
      try
      {
        if ((e == null) && (paramIPresendPicMgr != null)) {
          e = new PresendPicMgr(paramIPresendPicMgr);
        }
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mInstance = ");
    localStringBuilder.append(e);
    localStringBuilder.append(", Ibinder = ");
    localStringBuilder.append(paramIPresendPicMgr);
    Logger.a("PresendPicMgr", "getInstance", localStringBuilder.toString());
    return e;
  }
  
  public static PresendPicMgr b(IPresendPicMgr paramIPresendPicMgr)
  {
    StringBuilder localStringBuilder;
    if (e != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mInstance:");
      localStringBuilder.append(e);
      localStringBuilder.append("is not null,reset mInstance!");
      Logger.a("PresendPicMgr", "newInstance()", localStringBuilder.toString());
      e = null;
    }
    if (paramIPresendPicMgr != null) {}
    try
    {
      e = new PresendPicMgr(paramIPresendPicMgr);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mInstance = ");
      localStringBuilder.append(e);
      localStringBuilder.append(", Ibinder = ");
      localStringBuilder.append(paramIPresendPicMgr);
      Logger.a("PresendPicMgr", "newInstance()", localStringBuilder.toString());
      return e;
    }
    finally {}
  }
  
  private void e()
  {
    Logger.a("PresendPicMgr", "sendMsg___ start!", "");
    try
    {
      this.d.a();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PresendPicMgr", 2, localException.getMessage(), localException);
      }
    }
    Logger.a("PresendPicMgr", "sendMsg___ end!", "");
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      Logger.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Start! cancelType = ");
    localStringBuilder.append(paramInt);
    Logger.a("PresendPicMgr", "cancelAll", localStringBuilder.toString());
    int m = 0;
    while (m < this.f.size())
    {
      ((PresendPicMgr.PresendReq)this.f.get(m)).a(paramInt);
      m += 1;
    }
    this.f.clear();
    try
    {
      this.d.a(paramInt);
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
    if (!this.c)
    {
      Logger.a("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
      return;
    }
    paramIntent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.a).getBinder()));
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.c)
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
      int n = -1;
      int m;
      try
      {
        m = this.d.b();
      }
      catch (RemoteException localRemoteException)
      {
        m = n;
        if (QLog.isColorLevel())
        {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
          m = n;
        }
      }
      paramString.v = m;
      paramString.w = true;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("uinType = ");
      localStringBuilder2.append(m);
      Logger.a("PresendPicMgr", "presendPic", localStringBuilder2.toString());
      paramString = new PresendPicMgr.PresendReq(this, paramString, paramInt1, paramInt2);
      this.f.add(paramString);
      this.a.post(new PresendPicMgr.PresendRunnable(this, paramString));
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
    Logger.a("PresendPicMgr", "disablePicPresend", "");
    Object localObject = BaseApplication.getContext();
    int m;
    if (Build.VERSION.SDK_INT > 10) {
      m = 4;
    } else {
      m = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", m);
    ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", true).commit();
    ((SharedPreferences)localObject).edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!this.c)
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
    this.f.remove(localObject);
    ((PresendPicMgr.PresendReq)localObject).a(paramInt);
  }
  
  public void c()
  {
    Logger.b("PresendPicMgr", "release", "");
    this.g.quit();
    this.f.clear();
    e = null;
  }
  
  public int d()
  {
    ArrayList localArrayList = this.f;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */