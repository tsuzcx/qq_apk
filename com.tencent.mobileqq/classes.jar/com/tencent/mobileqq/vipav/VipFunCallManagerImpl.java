package com.tencent.mobileqq.vipav;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

public class VipFunCallManagerImpl
  implements IVipFunCallManager, Manager
{
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  private IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  /* Error */
  public VipFunCallManagerImpl()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 20	java/lang/Object:<init>	()V
    //   4: aconst_null
    //   5: astore_2
    //   6: aconst_null
    //   7: astore_1
    //   8: aload_0
    //   9: aconst_null
    //   10: putfield 22	com/tencent/mobileqq/vipav/VipFunCallManagerImpl:jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener	Lcom/tencent/mobileqq/vip/IPCDownloadListener;
    //   13: aload_0
    //   14: new 24	com/tencent/mobileqq/vipav/VipFunCallManagerImpl$1
    //   17: dup
    //   18: aload_0
    //   19: ldc 26
    //   21: ldc 28
    //   23: invokespecial 31	com/tencent/mobileqq/vipav/VipFunCallManagerImpl$1:<init>	(Lcom/tencent/mobileqq/vipav/VipFunCallManagerImpl;Ljava/lang/String;Ljava/lang/String;)V
    //   26: putfield 33	com/tencent/mobileqq/vipav/VipFunCallManagerImpl:jdField_a_of_type_ComTencentMobileqqVipDownloadListener	Lcom/tencent/mobileqq/vip/DownloadListener;
    //   29: aload_0
    //   30: invokestatic 38	com/tencent/mobileqq/vas/util/VasUtil:a	()Lmqq/app/AppRuntime;
    //   33: putfield 40	com/tencent/mobileqq/vipav/VipFunCallManagerImpl:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   36: new 42	java/io/File
    //   39: dup
    //   40: invokestatic 47	com/tencent/mobileqq/vas/vipav/api/VipFunCallUtil:a	()Ljava/lang/String;
    //   43: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore_3
    //   47: aload_3
    //   48: invokevirtual 54	java/io/File:exists	()Z
    //   51: ifne +8 -> 59
    //   54: aload_3
    //   55: invokevirtual 57	java/io/File:mkdirs	()Z
    //   58: pop
    //   59: aload_0
    //   60: invokespecial 59	com/tencent/mobileqq/vipav/VipFunCallManagerImpl:a	()Z
    //   63: ifne +107 -> 170
    //   66: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +11 -> 80
    //   72: ldc 66
    //   74: iconst_2
    //   75: ldc 68
    //   77: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: getfield 40	com/tencent/mobileqq/vipav/VipFunCallManagerImpl:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   84: invokevirtual 78	mqq/app/AppRuntime:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   87: invokevirtual 84	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   90: ldc 86
    //   92: invokevirtual 92	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   95: astore_3
    //   96: aload_3
    //   97: astore_1
    //   98: aload_3
    //   99: astore_2
    //   100: invokestatic 47	com/tencent/mobileqq/vas/vipav/api/VipFunCallUtil:a	()Ljava/lang/String;
    //   103: new 94	java/lang/StringBuffer
    //   106: dup
    //   107: ldc 96
    //   109: invokespecial 97	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   112: aload_3
    //   113: invokestatic 103	com/tencent/mobileqq/utils/FileUtils:writeFile	(Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/io/InputStream;)Z
    //   116: pop
    //   117: aload_3
    //   118: ifnull +52 -> 170
    //   121: aload_3
    //   122: invokevirtual 108	java/io/InputStream:close	()V
    //   125: return
    //   126: astore_2
    //   127: goto +25 -> 152
    //   130: astore_3
    //   131: aload_2
    //   132: astore_1
    //   133: aload_3
    //   134: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   137: aload_2
    //   138: ifnull +32 -> 170
    //   141: aload_2
    //   142: invokevirtual 108	java/io/InputStream:close	()V
    //   145: return
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   151: return
    //   152: aload_1
    //   153: ifnull +15 -> 168
    //   156: aload_1
    //   157: invokevirtual 108	java/io/InputStream:close	()V
    //   160: goto +8 -> 168
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   168: aload_2
    //   169: athrow
    //   170: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	VipFunCallManagerImpl
    //   7	126	1	localObject1	Object
    //   146	11	1	localException1	java.lang.Exception
    //   163	2	1	localException2	java.lang.Exception
    //   5	95	2	localObject2	Object
    //   126	43	2	localObject3	Object
    //   46	76	3	localObject4	Object
    //   130	4	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   80	96	126	finally
    //   100	117	126	finally
    //   133	137	126	finally
    //   80	96	130	java/io/IOException
    //   100	117	130	java/io/IOException
    //   121	125	146	java/lang/Exception
    //   141	145	146	java/lang/Exception
    //   156	160	163	java/lang/Exception
  }
  
  private int a(List<Long> paramList, SharedPreferences paramSharedPreferences, String paramString1, String paramString2, SharedPreferences.Editor paramEditor, int paramInt)
  {
    String[] arrayOfString = paramString2.split(",");
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < arrayOfString.length)
    {
      if (paramString1.equals(arrayOfString[paramInt]))
      {
        j = paramInt;
      }
      else
      {
        j = i;
        if (!TextUtils.isEmpty(arrayOfString[paramInt]))
        {
          paramString2 = new StringBuilder();
          paramString2.append("group_");
          paramString2.append(arrayOfString[paramInt]);
          Object localObject = paramSharedPreferences.getString(paramString2.toString(), "");
          Iterator localIterator = paramList.iterator();
          paramString2 = (String)localObject;
          while (localIterator.hasNext())
          {
            String str = String.valueOf((Long)localIterator.next());
            if (!TextUtils.isEmpty(str))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(str);
              localStringBuilder.append("-");
              paramString2 = paramString2.replace(localStringBuilder.toString(), "");
            }
          }
          j = i;
          if (!((String)localObject).equals(paramString2))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("group_");
            ((StringBuilder)localObject).append(arrayOfString[paramInt]);
            paramEditor.putString(((StringBuilder)localObject).toString(), paramString2);
            j = i;
          }
        }
      }
      paramInt += 1;
      i = j;
    }
    return i;
  }
  
  @Nullable
  private SharedPreferences a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = VasUtil.a();
    }
    if (localAppRuntime == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("setFunCallData null == app opType=");
      paramAppRuntime.append(paramInt1);
      paramAppRuntime.append(", callId=");
      paramAppRuntime.append(paramInt2);
      QLog.e("VipFunCallManager", 1, paramAppRuntime.toString());
      return null;
    }
    paramAppRuntime = VipFunCallUtil.a(localAppRuntime, 1, null);
    if (paramAppRuntime == null)
    {
      QLog.e("VipFunCallManager", 1, "setFunCallData null == sp");
      return null;
    }
    return paramAppRuntime;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<Long> paramList, long paramLong, SharedPreferences paramSharedPreferences)
  {
    if ((paramInt2 != 0) && (paramList != null) && (paramList.size() >= 1))
    {
      Object localObject1 = String.valueOf(paramInt2);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      Object localObject2 = paramSharedPreferences.getString("group", null);
      SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
      paramInt1 = -1;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramInt1 = a(paramList, paramSharedPreferences, (String)localObject1, (String)localObject2, localEditor, -1);
      }
      if (paramInt1 < 0)
      {
        paramSharedPreferences = (SharedPreferences)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramSharedPreferences = new StringBuilder();
          paramSharedPreferences.append((String)localObject2);
          paramSharedPreferences.append(",");
          paramSharedPreferences.append((String)localObject1);
          paramSharedPreferences = paramSharedPreferences.toString();
        }
        localEditor.putString("group", paramSharedPreferences);
      }
      paramSharedPreferences = paramList.iterator();
      for (paramList = "-"; paramSharedPreferences.hasNext(); paramList = ((StringBuilder)localObject2).toString())
      {
        localObject1 = (Long)paramSharedPreferences.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramList);
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("-");
      }
      paramSharedPreferences = new StringBuilder();
      paramSharedPreferences.append(paramInt2);
      paramSharedPreferences.append(",");
      paramSharedPreferences.append(paramInt3);
      paramSharedPreferences.append(",");
      paramSharedPreferences.append(paramList);
      paramSharedPreferences.append(",");
      paramSharedPreferences.append(paramLong);
      paramList = paramSharedPreferences.toString();
      paramSharedPreferences = new StringBuilder();
      paramSharedPreferences.append("group_");
      paramSharedPreferences.append(paramInt2);
      localEditor.putString(paramSharedPreferences.toString(), paramList);
      localEditor.commit();
      return;
    }
    paramList = new StringBuilder();
    paramList.append("setGroup uins.size() < 1 opType=");
    paramList.append(paramInt1);
    paramList.append(", callId=");
    paramList.append(paramInt2);
    QLog.e("VipFunCallManager", 1, paramList.toString());
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    boolean bool = false;
    if (localObject != null) {
      bool = VipFunCallUtil.a(((AppRuntime)localObject).getApp(), "VipFunCallManager", false);
    }
    if ((QLog.isColorLevel()) || (!bool))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownload, id=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resType=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", isIPC=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", srcType=");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(", haveSDCard=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("VipFunCallManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(int paramInt, SharedPreferences paramSharedPreferences)
  {
    if (paramInt == 0)
    {
      QLog.e("VipFunCallManager", 1, "setGroup callId == 0, opType=SET_DATA_DELET_GROUP");
      return;
    }
    String str1 = String.valueOf(paramInt);
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = paramSharedPreferences.getString("group", null);
    if (!TextUtils.isEmpty(str2))
    {
      String[] arrayOfString = str2.split(",");
      paramInt = 0;
      Object localObject2;
      for (Object localObject1 = ""; paramInt < arrayOfString.length; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (!str1.equals(arrayOfString[paramInt]))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          if (((String)localObject1).length() > 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(arrayOfString[paramInt]);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = arrayOfString[paramInt];
          }
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        paramInt += 1;
      }
      if (!str2.equals(localObject1)) {
        paramSharedPreferences.edit().putString("group", (String)localObject1).commit();
      }
    }
  }
  
  private boolean a()
  {
    return new File(VipFunCallConstants.a).exists();
  }
  
  private boolean a(DownloadTask paramDownloadTask)
  {
    boolean bool;
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.jdField_a_of_type_Int == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mDownloadListener onDone fail, task.getStatus():");
      localStringBuilder.append(paramDownloadTask.a());
      localStringBuilder.append(", task.errCode:");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Int);
      QLog.e("VipFunCallManager", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean downloadFCSuit(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
    int i = VipFunCallUtil.a();
    startDownload(paramInt1, 9, paramBoolean, paramInt3);
    startDownload(paramInt1, i, paramBoolean, paramInt3);
    if (paramInt2 != 0) {
      ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).colorRingDownload(this.jdField_a_of_type_MqqAppAppRuntime, paramInt2, paramBoolean, paramInt3, paramIPCDownloadListener);
    }
    if (i == 6) {
      startDownload(paramInt1, 7, false, 0);
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
  }
  
  public void setFunCallData(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2, int paramInt3, List<Long> paramList, long paramLong)
  {
    paramAppRuntime = a(paramAppRuntime, paramInt1, paramInt2);
    if (paramAppRuntime == null) {
      return;
    }
    if (2 == paramInt1)
    {
      a(paramInt2, paramAppRuntime);
      return;
    }
    if (1 == paramInt1)
    {
      a(paramInt1, paramInt2, paramInt3, paramList, paramLong, paramAppRuntime);
      return;
    }
    if (paramInt1 == 0)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("callId");
      paramList.append(6);
      paramAppRuntime.putInt(paramList.toString(), paramInt2);
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("callId");
      paramList.append(9);
      paramAppRuntime.putInt(paramList.toString(), paramInt2);
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("callId");
      paramList.append(7);
      paramAppRuntime.putInt(paramList.toString(), paramInt2);
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("callId");
      paramList.append(3);
      paramAppRuntime.putInt(paramList.toString(), paramInt3);
      paramAppRuntime.commit();
      return;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("setFunCallData opType == unknow ");
    paramAppRuntime.append(paramInt1);
    QLog.e("VipFunCallManager", 1, paramAppRuntime.toString());
  }
  
  public void startDownload(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    a(paramInt1, paramInt2, paramBoolean, paramInt3);
    if (paramInt1 == 0) {
      return;
    }
    String str1 = VipFunCallUtil.b(this.jdField_a_of_type_MqqAppAppRuntime, paramInt1, paramInt2, null);
    if (TextUtils.isEmpty(str1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startDownload error0 url=null, id=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", resType=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", isIPC=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", srcType=");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.e("VipFunCallManager", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    String str2 = VipFunCallUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt1, paramInt2, null);
    if (TextUtils.isEmpty(str2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startDownload error resPath=null, id=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", resType=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", isIPC=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", srcType=");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.e("VipFunCallManager", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = new VipFunCallManagerImpl.OnDownLoadDone(this, paramInt1, paramInt2, paramBoolean, paramInt3, str1, str2).a();
    if (((VipFunCallManagerImpl.OnDownLoadDone)localObject2).a()) {
      return;
    }
    Object localObject1 = ((VipFunCallManagerImpl.OnDownLoadDone)localObject2).a();
    paramInt3 = ((VipFunCallManagerImpl.OnDownLoadDone)localObject2).a();
    localObject2 = ((VipFunCallManagerImpl.OnDownLoadDone)localObject2).a();
    if (paramInt3 != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(".tmp");
      localObject1 = new File(((StringBuilder)localObject1).toString());
    }
    localObject1 = new DownloadTask(str1, (File)localObject1);
    ((DownloadTask)localObject1).jdField_a_of_type_Byte = 1;
    ((DownloadTask)localObject1).jdField_e_of_type_Long = 5242880L;
    ((DownloadTask)localObject1).jdField_e_of_type_JavaLangString = VipFunCallConstants.b;
    if ((9 == paramInt2) || (7 == paramInt2))
    {
      if (WebpSoLoader.a() != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((DownloadTask)localObject1).l = paramBoolean;
    }
    if (7 != paramInt2) {
      ((DownloadTask)localObject1).b = true;
    }
    ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).startDownload(this.jdField_a_of_type_MqqAppAppRuntime, (Bundle)localObject2, (DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startDownload, id=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", resType=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", url=");
      ((StringBuilder)localObject1).append(str1);
      QLog.d("VipFunCallManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallManagerImpl
 * JD-Core Version:    0.7.0.1
 */