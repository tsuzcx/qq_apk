import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class kvl
{
  int jdField_a_of_type_Int = -1;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new kvn(this);
  private MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private QQLruCache<String, String> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  lmc jdField_a_of_type_Lmc = new kvm(this);
  public lme a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  
  public kvl(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Lme = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public int a(int paramInt, String paramString)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      i = this.jdField_a_of_type_Lme.a(paramInt, paramString);
      return i;
    }
    catch (RemoteException paramString)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", paramString);
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_Lme != null) {
      try
      {
        int i = this.jdField_a_of_type_Lme.c(paramString);
        return i;
      }
      catch (RemoteException paramString)
      {
        QLog.e("QQServiceProxy", 2, "convertUinTypeEx e = ", paramString);
      }
    }
    for (;;)
    {
      return -1;
      QLog.e("QQServiceProxy", 2, "convertUinTypeEx mQQServiceForAV == null");
    }
  }
  
  public long a(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      l1 = this.jdField_a_of_type_Lme.a(paramString);
      return l1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", paramString);
    }
    return 0L;
  }
  
  public Bitmap a()
  {
    return bacm.a(true);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = a(paramInt, paramString1, paramString2, paramBoolean1);
    Object localObject = a(str);
    if (localObject == null) {
      if (this.jdField_a_of_type_Lme == null) {}
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = this.jdField_a_of_type_Lme.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
        localObject = localBitmap;
        if (localObject == null) {}
      }
      catch (RemoteException localRemoteException1)
      {
        if (paramBoolean2) {
          localObject = a();
        }
        i = 2;
        continue;
      }
      catch (NullPointerException localNullPointerException1) {}
      try
      {
        a(str, (Bitmap)localObject);
        i = 0;
      }
      catch (NullPointerException localNullPointerException2)
      {
        break label173;
      }
      catch (RemoteException localRemoteException2)
      {
        continue;
        continue;
      }
      if (AudioHelper.e()) {
        QLog.w("QQServiceProxy", 1, "getFaceBitmap, uinType[" + paramInt + "], uin[" + paramString1 + "], extraUin[" + paramString2 + "], isNeedReturnDefaultValue[" + paramBoolean2 + "], ret[" + i + "]");
      }
      return localObject;
      int i = 1;
      continue;
      label173:
      if (paramBoolean2) {
        localObject = a();
      }
      i = 3;
      continue;
      i = 4;
      if (!paramBoolean2) {
        break;
      }
      localObject = a();
      continue;
      i = -3;
    }
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      return (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
    }
    return null;
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (this.jdField_a_of_type_Lme != null) {
      try
      {
        paramBundle = this.jdField_a_of_type_Lme.a(paramInt1, paramInt2, paramInt3, null, paramBundle, paramResultReceiver);
        return paramBundle;
      }
      catch (RemoteException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceProxy", 2, "requestEvent, mainCmd[" + paramInt1 + "], subType[" + paramInt2 + "], seq[" + paramInt3 + "]");
        }
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.w("QQServiceProxy", 1, "requestEvent, fail, mainCmd[" + paramInt1 + "], subType[" + paramInt2 + "], seq[" + paramInt3 + "]");
      }
    }
  }
  
  public String a()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Lme != null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceProxy", 2, "We will get current user skey");
      }
    }
    while (!QLog.isColorLevel())
    {
      try
      {
        String str = this.jdField_a_of_type_Lme.a();
        localObject = str;
      }
      catch (RemoteException localRemoteException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("QQServiceProxy", 2, "getSKey fail", localRemoteException);
        return null;
      }
      return localObject;
    }
    QLog.d("QQServiceProxy", 2, "getSKey-->mQQServiceForAV is null");
    return null;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    return "" + paramInt + "_" + paramString1 + "_" + paramString2;
  }
  
  public String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = new StringBuilder().append("").append(paramInt).append("_").append(paramString1).append("_").append(paramString2).append("_");
    if (paramBoolean) {}
    for (paramString1 = "0";; paramString1 = "1") {
      return paramString1;
    }
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
      return (String)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(10001, 50, 10);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      this.jdField_a_of_type_Lme.a(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "startPumpMessage", paramString);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      this.jdField_a_of_type_Lme.a(paramInt, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "setPeerInfo", paramString1);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      this.jdField_a_of_type_Lme.a(paramLong);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "syncChatingTime", localRemoteException);
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    if (this.jdField_a_of_type_Lme != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        this.jdField_a_of_type_Lme.a(paramLong1, paramString, paramLong2);
        return;
      }
      catch (RemoteException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList e = ", paramString);
        return;
      }
    }
    QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList mQQServiceForAV==null");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      QLog.w("QQServiceProxy", 1, "stopPumpMessage[" + paramString + "]");
      this.jdField_a_of_type_Lme.a();
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "stopPumpMessage", paramString);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) && (paramBitmap != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) && (!TextUtils.isEmpty(paramString2))) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      this.jdField_a_of_type_Lme.d(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQServiceProxy", 1, "keepVideoProcessAlive fail.", localThrowable);
    }
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isQQServiceBind ");
      if (this.jdField_a_of_type_Lme == null) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQServiceProxy", 2, bool);
      if (this.jdField_a_of_type_Lme == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Lme.a(paramInt, paramLong);
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "curGAInviteIsRight", localRemoteException);
    }
    return true;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool = this.jdField_a_of_type_Lme.a(paramLong);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QQServiceProxy", 2, "getTroopAdmins-->troopUin=" + paramLong, localRemoteException);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool = this.jdField_a_of_type_Lme.a(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      QLog.e("QQServiceProxy", 2, "isFriend", paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool = this.jdField_a_of_type_Lme.b(paramString, paramInt);
      return bool;
    }
    catch (RemoteException paramString)
    {
      QLog.e("QQServiceProxy", 2, "requestDecodeStrangeFace-->false", paramString);
    }
    return false;
  }
  
  public boolean a(lls paramlls)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "getAVRedPacketConfig start mQQServiceForAV = " + this.jdField_a_of_type_Lme);
    }
    if (this.jdField_a_of_type_Lme != null) {
      try
      {
        this.jdField_a_of_type_Lme.a(paramlls);
        return true;
      }
      catch (RemoteException paramlls)
      {
        paramlls.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceProxy", 2, "getAVRedPacketConfig error", paramlls);
        }
      }
    }
    return false;
  }
  
  public long[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Lme.a(paramString);
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberList", paramString);
    }
    return null;
  }
  
  public String b(int paramInt, String paramString1, String paramString2)
  {
    String str2 = a(paramInt, paramString1, paramString2);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      String str1 = this.jdField_a_of_type_Lme.a(paramInt, paramString1, paramString2);
      localObject2 = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject2 = str1;
        a(str2, str1);
      }
      localObject1 = str1;
      localObject2 = str1;
      if (AudioHelper.e())
      {
        localObject2 = str1;
        QLog.w("QQServiceProxy", 1, "getDisplayName, uinType[" + paramInt + "], uin[" + paramString1 + "], extraUin[" + paramString2 + "], name[" + str1 + "]");
        localObject1 = str1;
      }
    }
    catch (RemoteException paramString2)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("QQServiceProxy", 2, "getDisplayName", paramString2);
          localObject1 = localObject2;
        }
      }
    }
    paramString2 = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = a(str2);
      paramString2 = (String)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return paramString1;
      }
    }
    return paramString2;
  }
  
  public String b(String paramString)
  {
    Object localObject2 = a(paramString);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = null;
      localObject1 = null;
      if (this.jdField_a_of_type_Lme == null) {}
    }
    try
    {
      localObject1 = this.jdField_a_of_type_Lme.a(paramString);
      localObject2 = localObject1;
      a(paramString, (String)localObject1);
      localObject2 = localObject1;
      QLog.w("QQServiceProxy", 1, "getPhoneUserNameByPhoneNum, number[" + paramString + "], name[" + (String)localObject1 + "]");
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.w("QQServiceProxy", 2, "getPhoneUserNameByPhoneNum", paramString);
    }
    return localObject1;
    return localObject2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    }
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      this.jdField_a_of_type_Lme.b(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "setBindInfo", paramString);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Lme != null) {
        this.jdField_a_of_type_Lme.d(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "[red dot] redTouchManagerClick", paramString);
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Lme.a();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "isQQpaused", localRemoteException);
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      this.jdField_a_of_type_Lme.a(paramString);
      bool1 = true;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getNearbyProfileData", paramString);
    }
    return bool1;
    return false;
  }
  
  public boolean b(lls paramlls)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "startDownloadAVRedPacketRes start");
    }
    if (this.jdField_a_of_type_Lme != null) {
      try
      {
        this.jdField_a_of_type_Lme.b(paramlls);
        return true;
      }
      catch (RemoteException paramlls)
      {
        paramlls.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceProxy", 2, "startDownloadAVRedPacketRes error", paramlls);
        }
      }
    }
    return false;
  }
  
  public String c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Lme.d(paramString);
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getPhoneNumByUin", paramString);
    }
    return null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "bindQQService");
    }
    if ((this.jdField_a_of_type_Lme == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), QQServiceForAV.class);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Lme != null) {
        this.jdField_a_of_type_Lme.e(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "[red dot] redTouchManagerExposure", paramString);
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Lme.g();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "isPhoneCalling", localRemoteException);
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    if (this.jdField_a_of_type_Lme != null) {
      try
      {
        boolean bool = this.jdField_a_of_type_Lme.a(paramString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        return bool;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return true;
  }
  
  public void d()
  {
    krx.d("QQServiceProxy", "unbindQQService");
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      this.jdField_a_of_type_Lme.a();
      this.jdField_a_of_type_Lme.a(this.jdField_a_of_type_Lmc);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("QQServiceProxy", 2, "unbindService3 ", localException2);
        }
        localRemoteException = localRemoteException;
        QLog.e("QQServiceProxy", 2, "unbindQQService1 ", localRemoteException);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.e("QQServiceProxy", 2, "unbindQQService2 ", localException1);
      }
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Lme.h();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "isQQSVIP remote call exception", localRemoteException);
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Lme != null) {
      try
      {
        this.jdField_a_of_type_Lme.b();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceProxy", 2, "avStartAddFriendService", localRemoteException);
        return;
      }
    }
    this.b = true;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Lme.b();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getNearbyProfileData", localRemoteException);
    }
    return false;
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_Lme != null)) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Lme.c()) {
          continue;
        }
        i = 1;
        this.jdField_a_of_type_Int = i;
      }
      catch (Exception localException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQServiceProxy", 2, "getTalkBack", localException);
        continue;
      }
      if (this.jdField_a_of_type_Int != 1) {
        break label69;
      }
      return true;
      i = 0;
    }
    label69:
    return false;
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Lme.d();
      if (QLog.isColorLevel()) {
        QLog.e("EffectEnable", 2, "getEffectsSoLoadIsOk  result " + this.jdField_a_of_type_Lme + "   " + bool1);
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("EffectEnable", 1, "getEffectsSoLoadIsOk", localRemoteException);
        bool1 = bool2;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        krx.e("EffectEnable", localNullPointerException.getMessage());
        bool1 = bool2;
      }
    }
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lme != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Lme.e();
      if (QLog.isColorLevel()) {
        QLog.e("getEffectLibPagSoLoadIsOk", 2, "getEffectLibPagSoLoadIsOk  result " + this.jdField_a_of_type_Lme + "   " + bool1);
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("getEffectLibPagSoLoadIsOk", 1, "getEffectLibPagSoLoadIsOk", localRemoteException);
        bool1 = bool2;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        krx.e("EffectEnable", localNullPointerException.getMessage());
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kvl
 * JD-Core Version:    0.7.0.1
 */