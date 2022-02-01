package com.tencent.mobileqq.hotchat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.hotchat.api.IHotChatSCMng;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import oicq.wlogin_sdk.tools.MD5;
import org.xmlpull.v1.XmlPullParser;

public class HotChatSCMng
  implements IHotChatSCMng, Manager
{
  static final String SP_CONFIG_KEY = "hotchat_scene_config";
  public static final String TAG = "HotchatSCMng";
  QQAppInterface mApp;
  Comparator<HotChatNote> mComparator = null;
  HashMap<String, HotChatSCMng.HotchatNotice> mConfigs = new HashMap(1);
  String mDirPath;
  public boolean mIsInitCache = false;
  List<WeakReference<HotChatSCMng.HCSCObserver>> mObservers = new ArrayList();
  
  public HotChatSCMng(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private HotChatNote findShowHotChatNote(HotChatSCMng.HotchatNotice paramHotchatNotice, HotChatNote paramHotChatNote1, HotChatNote paramHotChatNote2, long paramLong, int paramInt)
  {
    HotChatNote localHotChatNote = paramHotChatNote1;
    if (paramHotchatNotice.jdField_a_of_type_Int >= 0)
    {
      localHotChatNote = paramHotChatNote1;
      if (paramHotchatNotice.jdField_a_of_type_Int < paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size())
      {
        int i;
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              paramHotChatNote2 = paramHotChatNote1;
            }
            else
            {
              i = paramHotchatNotice.jdField_a_of_type_Int;
              for (;;)
              {
                paramHotChatNote2 = paramHotChatNote1;
                if (i >= paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size()) {
                  break;
                }
                paramHotChatNote2 = (HotChatNote)paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.get(i);
                if ((paramHotChatNote2 != null) && (!paramHotChatNote2.jdField_a_of_type_Boolean)) {
                  break;
                }
                i += 1;
              }
            }
          }
          else
          {
            localHotChatNote = (HotChatNote)paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.get(paramHotchatNotice.jdField_a_of_type_Int);
            paramHotChatNote2 = paramHotChatNote1;
            if (paramLong >= localHotChatNote.jdField_a_of_type_Long)
            {
              paramHotChatNote2 = paramHotChatNote1;
              if (paramLong <= localHotChatNote.jdField_b_of_type_Long)
              {
                paramHotChatNote2 = paramHotChatNote1;
                if (checkHasGrabHbTask(localHotChatNote)) {
                  paramHotChatNote2 = localHotChatNote;
                }
              }
            }
          }
        }
        else
        {
          i = paramHotchatNotice.jdField_a_of_type_Int;
          for (;;)
          {
            paramHotChatNote2 = paramHotChatNote1;
            if (i >= paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            paramHotChatNote2 = (HotChatNote)paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.get(i);
            if ((paramHotChatNote2 != null) && (!paramHotChatNote2.jdField_a_of_type_Boolean) && (paramLong >= paramHotChatNote2.jdField_a_of_type_Long) && (paramLong <= paramHotChatNote2.jdField_b_of_type_Long) && (checkHasGrabHbTask(paramHotChatNote2)))
            {
              paramHotchatNotice.jdField_a_of_type_Int = i;
              break;
            }
            i += 1;
          }
        }
        localHotChatNote = paramHotChatNote2;
        if (QLog.isDevelopLevel())
        {
          NearbyUtils.a("HotchatSCMng", "findShowHotChatNote", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramHotchatNotice.jdField_a_of_type_Int), paramHotChatNote2 });
          localHotChatNote = paramHotChatNote2;
        }
      }
    }
    return localHotChatNote;
  }
  
  /* Error */
  @TargetApi(11)
  private String[] getConfigs()
  {
    // Byte code:
    //   0: ldc 113
    //   2: astore 6
    //   4: aconst_null
    //   5: astore 7
    //   7: aconst_null
    //   8: astore 5
    //   10: aload 5
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 52	com/tencent/mobileqq/hotchat/HotChatSCMng:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: invokestatic 125	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   24: astore 8
    //   26: aload 5
    //   28: astore 4
    //   30: getstatic 130	android/os/Build$VERSION:SDK_INT	I
    //   33: bipush 11
    //   35: if_icmplt +81 -> 116
    //   38: aload 5
    //   40: astore 4
    //   42: aload 8
    //   44: ldc 12
    //   46: new 132	java/util/HashSet
    //   49: dup
    //   50: invokespecial 133	java/util/HashSet:<init>	()V
    //   53: invokeinterface 139 3 0
    //   58: astore 8
    //   60: aload 7
    //   62: astore_3
    //   63: aload 8
    //   65: ifnull +162 -> 227
    //   68: aload 5
    //   70: astore 4
    //   72: aload 7
    //   74: astore_3
    //   75: aload 8
    //   77: invokeinterface 142 1 0
    //   82: ifle +145 -> 227
    //   85: aload 5
    //   87: astore 4
    //   89: aload 8
    //   91: aload 8
    //   93: invokeinterface 142 1 0
    //   98: anewarray 144	java/lang/String
    //   101: invokeinterface 148 2 0
    //   106: checkcast 150	[Ljava/lang/String;
    //   109: checkcast 150	[Ljava/lang/String;
    //   112: astore_3
    //   113: goto +114 -> 227
    //   116: aload 5
    //   118: astore 4
    //   120: aload 8
    //   122: ldc 152
    //   124: iconst_0
    //   125: invokeinterface 156 3 0
    //   130: istore_2
    //   131: aload 7
    //   133: astore_3
    //   134: iload_2
    //   135: ifle +92 -> 227
    //   138: aload 5
    //   140: astore 4
    //   142: iload_2
    //   143: anewarray 144	java/lang/String
    //   146: astore 5
    //   148: iconst_0
    //   149: istore_1
    //   150: aload 5
    //   152: astore_3
    //   153: iload_1
    //   154: iload_2
    //   155: if_icmpge +72 -> 227
    //   158: aload 5
    //   160: astore 4
    //   162: new 158	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   169: astore_3
    //   170: aload 5
    //   172: astore 4
    //   174: aload_3
    //   175: ldc 161
    //   177: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 5
    //   183: astore 4
    //   185: aload_3
    //   186: iload_1
    //   187: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 5
    //   193: astore 4
    //   195: aload 5
    //   197: iload_1
    //   198: aload 8
    //   200: aload_3
    //   201: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: ldc 113
    //   206: invokeinterface 176 3 0
    //   211: aastore
    //   212: iload_1
    //   213: iconst_1
    //   214: iadd
    //   215: istore_1
    //   216: goto -66 -> 150
    //   219: astore_3
    //   220: aload_3
    //   221: invokevirtual 179	java/lang/Throwable:printStackTrace	()V
    //   224: aload 4
    //   226: astore_3
    //   227: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +67 -> 297
    //   233: aload_3
    //   234: ifnonnull +10 -> 244
    //   237: ldc 184
    //   239: astore 4
    //   241: goto +10 -> 251
    //   244: aload_3
    //   245: arraylength
    //   246: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: astore 4
    //   251: aload 6
    //   253: astore 5
    //   255: aload_3
    //   256: ifnull +17 -> 273
    //   259: aload 6
    //   261: astore 5
    //   263: aload_3
    //   264: arraylength
    //   265: ifle +8 -> 273
    //   268: aload_3
    //   269: iconst_0
    //   270: aaload
    //   271: astore 5
    //   273: ldc 15
    //   275: iconst_3
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: ldc 185
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 4
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: aload 5
    //   293: aastore
    //   294: invokestatic 188	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: aload_3
    //   298: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	HotChatSCMng
    //   149	67	1	i	int
    //   130	26	2	j	int
    //   62	139	3	localObject1	Object
    //   219	2	3	localThrowable	Throwable
    //   226	72	3	localObject2	Object
    //   12	275	4	localObject3	Object
    //   8	284	5	localObject4	Object
    //   2	258	6	str	String
    //   5	127	7	localObject5	Object
    //   24	175	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   14	26	219	java/lang/Throwable
    //   30	38	219	java/lang/Throwable
    //   42	60	219	java/lang/Throwable
    //   75	85	219	java/lang/Throwable
    //   89	113	219	java/lang/Throwable
    //   120	131	219	java/lang/Throwable
    //   142	148	219	java/lang/Throwable
    //   162	170	219	java/lang/Throwable
    //   174	181	219	java/lang/Throwable
    //   185	191	219	java/lang/Throwable
    //   195	212	219	java/lang/Throwable
  }
  
  private boolean isRet(ConfigurationService.Config paramConfig, boolean paramBoolean, String paramString, List<String> paramList, Set<String> paramSet)
  {
    if (paramConfig.content_list.has())
    {
      List localList = paramConfig.content_list.get();
      if ((localList != null) && (localList.size() > 0))
      {
        int i = 0;
        while (i < localList.size())
        {
          Object localObject1 = (String)localList.get(i);
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("receiveAllConfigs|type: 49,content: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",version: ");
            ((StringBuilder)localObject2).append(paramConfig.version.get());
            QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
          }
          boolean bool2 = paramBoolean;
          if (localObject1 != null) {
            if (((String)localObject1).length() == 0)
            {
              bool2 = paramBoolean;
            }
            else
            {
              localObject2 = HotChatSCMng.ConfigData.a((String)localObject1);
              boolean bool1;
              if (localObject2 != null)
              {
                paramSet.add(localObject1);
                bool2 = download((HotChatSCMng.ConfigData)localObject2, paramString);
                if ((paramList != null) && (paramList.size() > 0)) {
                  paramList.remove(((HotChatSCMng.ConfigData)localObject2).c);
                }
                bool1 = bool2;
                if (this.mIsInitCache)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(paramString);
                  ((StringBuilder)localObject1).append("/");
                  ((StringBuilder)localObject1).append(((HotChatSCMng.ConfigData)localObject2).c);
                  parse(((StringBuilder)localObject1).toString());
                  bool1 = bool2;
                }
              }
              else
              {
                bool1 = false;
              }
              bool2 = paramBoolean;
              if (!bool1) {
                bool2 = false;
              }
            }
          }
          i += 1;
          paramBoolean = bool2;
        }
        return paramBoolean;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("receiveAllConfigs|type: 49,content_list is empty ,version: ");
        paramString.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, paramString.toString());
      }
    }
    return paramBoolean;
  }
  
  @TargetApi(11)
  private void saveConfigs(Set<String> paramSet)
  {
    try
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).edit();
      if (Build.VERSION.SDK_INT >= 11)
      {
        localEditor.putStringSet("hotchat_scene_config", paramSet);
      }
      else
      {
        localEditor.putInt("hotchat_scene_config_count", paramSet.size());
        Iterator localIterator = paramSet.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hotchat_scene_config_");
          localStringBuilder.append(i);
          localEditor.putString(localStringBuilder.toString(), str);
          i += 1;
        }
      }
      localEditor.commit();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      if (paramSet == null) {
        paramSet = "null";
      } else {
        paramSet = Integer.valueOf(paramSet.size());
      }
      NearbyUtils.a("HotchatSCMng", new Object[] { "saveConfigs", paramSet });
    }
  }
  
  private HotChatSCMng.HotchatNotice sortHotChatNotice(HotChatSCMng.HotchatNotice paramHotchatNotice, HotChatNote paramHotChatNote, long paramLong, String paramString)
  {
    if (paramHotchatNotice.jdField_a_of_type_Int >= 0) {
      return paramHotchatNotice;
    }
    if (this.mComparator == null) {
      this.mComparator = new HotChatSCMng.1(this);
    }
    Collections.sort(paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList, this.mComparator);
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("HotchatSCMng", "sort start", new Object[] { paramString });
    }
    int i = 0;
    while (i < paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramHotChatNote = (HotChatNote)paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramHotChatNote != null)
      {
        if ((paramHotchatNotice.jdField_a_of_type_Int < 0) && (paramLong <= paramHotChatNote.jdField_b_of_type_Long)) {
          paramHotchatNotice.jdField_a_of_type_Int = i;
        } else if ((paramLong <= paramHotChatNote.jdField_b_of_type_Long) && (paramHotChatNote.jdField_a_of_type_Boolean)) {
          paramHotchatNotice.jdField_a_of_type_Int = i;
        }
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("HotchatSCMng", String.valueOf(i), new Object[] { paramHotChatNote });
        }
      }
      i += 1;
    }
    if (paramHotchatNotice.jdField_a_of_type_Int < 0) {
      paramHotchatNotice.jdField_a_of_type_Int = paramHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("HotchatSCMng", "sort end", new Object[] { paramString });
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("HotchatSCMng", "sortHotChatNotice", new Object[] { Integer.valueOf(paramHotchatNotice.jdField_a_of_type_Int) });
    }
    return paramHotchatNotice;
  }
  
  public void addObserver(HotChatSCMng.HCSCObserver paramHCSCObserver)
  {
    if (paramHCSCObserver == null) {
      return;
    }
    List localList = this.mObservers;
    int j = 0;
    try
    {
      if (this.mObservers.size() > 0)
      {
        Iterator localIterator = this.mObservers.iterator();
        WeakReference localWeakReference;
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() != paramHCSCObserver));
        int i = 1;
        if (i == 0)
        {
          paramHCSCObserver = new WeakReference(paramHCSCObserver);
          this.mObservers.add(paramHCSCObserver);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramHCSCObserver;
    }
  }
  
  public boolean checkHasGrabHbTask(HotChatNote paramHotChatNote)
  {
    if ((paramHotChatNote != null) && (!TextUtils.isEmpty(paramHotChatNote.jdField_b_of_type_JavaLangString)))
    {
      PortalManager localPortalManager = (PortalManager)this.mApp.getManager(QQManagerFactory.MGR_PORTAL);
      if ((localPortalManager == null) || (!localPortalManager.a()))
      {
        bool = false;
        break label52;
      }
    }
    boolean bool = true;
    label52:
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotchatSCMng", new Object[] { "checkHasGrabHbTask", paramHotChatNote, Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean download(HotChatSCMng.ConfigData paramConfigData, String paramString)
  {
    if (paramConfigData != null)
    {
      if (TextUtils.isEmpty(paramConfigData.a)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotchatSCMng", new Object[] { "download", paramConfigData });
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramConfigData.c);
      paramString = new File(((StringBuilder)localObject).toString());
      boolean bool1;
      if (paramString.exists())
      {
        if (!TextUtils.isEmpty(paramConfigData.jdField_b_of_type_JavaLangString))
        {
          localObject = MD5.getFileMD5(paramString);
          bool2 = paramConfigData.jdField_b_of_type_JavaLangString.equals(localObject);
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              NearbyUtils.a("download", new Object[] { "cache md5 confilict", localObject, paramConfigData.jdField_b_of_type_JavaLangString });
              bool1 = bool2;
            }
          }
        }
        else
        {
          bool1 = true;
        }
      }
      else {
        bool1 = false;
      }
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool1 = HttpDownloadUtil.download(this.mApp, paramConfigData.a, paramString);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramConfigData.jdField_b_of_type_JavaLangString))
          {
            localObject = MD5.getFileMD5(paramString);
            bool1 = paramConfigData.jdField_b_of_type_JavaLangString.equals(localObject);
            bool2 = bool1;
            if (!bool1)
            {
              bool2 = bool1;
              if (QLog.isColorLevel())
              {
                NearbyUtils.a("download", new Object[] { "md5 conflict", paramConfigData.jdField_b_of_type_JavaLangString, localObject });
                bool2 = bool1;
              }
            }
          }
        }
      }
      if (!bool2) {
        try
        {
          if (paramString.exists())
          {
            paramString.delete();
            return bool2;
          }
        }
        catch (Exception paramConfigData)
        {
          paramConfigData.printStackTrace();
        }
      }
      return bool2;
    }
    return false;
  }
  
  public String getConfigDirPath()
  {
    try
    {
      Object localObject1 = this.mApp;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((QQAppInterface)localObject1).getApp();
      if (localObject1 == null) {
        return null;
      }
      if ((this.mDirPath == null) || (this.mDirPath.length() <= 0))
      {
        this.mDirPath = ((Context)localObject1).getFilesDir().getAbsolutePath();
        if (!this.mDirPath.endsWith("/"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.mDirPath);
          ((StringBuilder)localObject1).append("/");
          this.mDirPath = ((StringBuilder)localObject1).toString();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.mDirPath);
        ((StringBuilder)localObject1).append("hotchat_scene_config");
        this.mDirPath = ((StringBuilder)localObject1).toString();
        NearbyUtils.a("HotchatSCMng", "getConfigDirPath", new Object[] { this.mDirPath });
      }
      localObject1 = this.mDirPath;
      return localObject1;
    }
    finally {}
  }
  
  public HotChatNote getHotChatNote(String paramString, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("HotchatSCMng", "getHotChatNote", new Object[] { "id is null or empty" });
      }
      return null;
    }
    Object localObject2 = null;
    HotChatSCMng.HotchatNotice localHotchatNotice = (HotChatSCMng.HotchatNotice)this.mConfigs.get(paramString);
    Object localObject1 = localObject2;
    if (localHotchatNotice != null)
    {
      localObject1 = localObject2;
      if (localHotchatNotice.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localObject1 = findShowHotChatNote(sortHotChatNotice(localHotchatNotice, null, paramLong, paramString), null, null, paramLong, paramInt);
      }
    }
    return localObject1;
  }
  
  public void initCache()
  {
    if (this.mIsInitCache) {
      return;
    }
    int i;
    boolean bool;
    label436:
    label441:
    synchronized (this.mConfigs)
    {
      if (this.mIsInitCache) {
        return;
      }
      String[] arrayOfString = getConfigs();
      Object localObject1;
      if (QLog.isColorLevel())
      {
        if (arrayOfString == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(arrayOfString.length);
        }
        NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", localObject1 });
      }
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        localObject1 = getConfigDirPath();
        if (localObject1 == null) {
          return;
        }
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          Object localObject3 = arrayOfString[i];
          if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
            break label441;
          }
          HotChatSCMng.ConfigData localConfigData = HotChatSCMng.ConfigData.a((String)localObject3);
          if (localConfigData != null)
          {
            try
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append("/");
              ((StringBuilder)localObject3).append(localConfigData.c);
              if (new File(((StringBuilder)localObject3).toString()).exists()) {
                break label436;
              }
              bool = download(localConfigData, (String)localObject1);
              if (bool)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append("/");
                ((StringBuilder)localObject3).append(localConfigData.c);
                parse(((StringBuilder)localObject3).toString());
              }
              else if (QLog.isColorLevel())
              {
                NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", "download config xml fail", localConfigData });
              }
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                break label441;
              }
            }
            NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", "parse config xml fail", localException.toString() });
            break label441;
          }
          if (!QLog.isColorLevel()) {
            break label441;
          }
          NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", "parse ConfigData fail", localObject3 });
          break label441;
        }
      }
      this.mIsInitCache = true;
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotchatSCMng", new Object[] { "initCache", Integer.valueOf(this.mConfigs.size()) });
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.mConfigs.clear();
  }
  
  public void parse(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("HotchatSCMng", "parse", new Object[] { paramString });
    }
    Object localObject2 = null;
    try
    {
      paramString = new FileInputStream(paramString);
      try
      {
        localBufferedInputStream = new BufferedInputStream(paramString);
        str = paramString;
      }
      catch (FileNotFoundException localFileNotFoundException1) {}
      localFileNotFoundException2.printStackTrace();
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      paramString = null;
    }
    BufferedInputStream localBufferedInputStream = null;
    String str = paramString;
    int i;
    Object localObject3;
    Object localObject1;
    if (localBufferedInputStream != null)
    {
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(localBufferedInputStream, "UTF-8");
        i = localXmlPullParser.getEventType();
        localObject3 = null;
        localObject1 = localObject2;
      }
      catch (Exception paramString)
      {
        XmlPullParser localXmlPullParser;
        label136:
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label216;
        }
        NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
      }
      paramString = new HotChatSCMng.ParserHandler(this, (HotChatSCMng.HotchatNotice)localObject1, (HotChatNote)localObject3, localXmlPullParser).b();
      localObject1 = paramString.a();
      paramString = paramString.a();
      break label341;
      paramString = new HotChatSCMng.ParserHandler(this, (HotChatSCMng.HotchatNotice)localObject1, (HotChatNote)localObject3, localXmlPullParser).a();
      localObject1 = paramString.a();
      paramString = paramString.a();
      break label341;
    }
    for (;;)
    {
      i = localXmlPullParser.next();
      localObject1 = paramString;
      localObject3 = localObject2;
      label216:
      while (i == 1)
      {
        if (localBufferedInputStream != null) {
          try
          {
            localBufferedInputStream.close();
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
            }
          }
        }
        if (str != null) {
          try
          {
            str.close();
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
            }
          }
        }
        return;
      }
      paramString = (String)localObject1;
      localObject2 = localObject3;
      if (i != 0)
      {
        if (i == 2) {
          break label136;
        }
        if (i == 3) {
          break;
        }
        paramString = (String)localObject1;
        localObject2 = localObject3;
        continue;
        label341:
        localObject2 = paramString;
        paramString = (String)localObject1;
      }
    }
  }
  
  public void removeObserver(HotChatSCMng.HCSCObserver paramHCSCObserver)
  {
    if (paramHCSCObserver == null) {
      return;
    }
    int i;
    label97:
    synchronized (this.mObservers)
    {
      if (this.mObservers.size() > 0)
      {
        i = this.mObservers.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.mObservers.get(i);
          if ((localWeakReference == null) || (localWeakReference.get() != paramHCSCObserver)) {
            break label97;
          }
          this.mObservers.remove(i);
          break label97;
        }
      }
      return;
    }
  }
  
  public boolean updateHotChatSceneConfig(ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null) {
      return false;
    }
    synchronized (this.mConfigs)
    {
      this.mConfigs.clear();
      String str = getConfigDirPath();
      if (str == null) {
        return false;
      }
      Object localObject2 = null;
      Object localObject4 = null;
      Object localObject1;
      try
      {
        Object localObject5 = new File(str);
        localObject1 = localObject2;
        if (((File)localObject5).exists())
        {
          localObject5 = ((File)localObject5).list();
          localObject1 = localObject2;
          if (localObject5 != null)
          {
            localObject1 = localObject2;
            if (localObject5.length > 0)
            {
              localObject1 = new ArrayList(localObject5.length);
              try
              {
                int j = localObject5.length;
                int i = 0;
                while (i < j)
                {
                  localObject2 = localObject5[i];
                  if ((localObject2 != null) && (localObject2.length() > 0)) {
                    ((List)localObject1).add(localObject2);
                  }
                  i += 1;
                }
              }
              catch (Exception localException2) {}
              localException3.printStackTrace();
            }
          }
        }
      }
      catch (Exception localException3)
      {
        localObject1 = localObject4;
      }
      Object localObject3 = new HashSet();
      boolean bool = isRet(paramConfig, true, str, (List)localObject1, (Set)localObject3);
      saveConfigs((Set)localObject3);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramConfig = ((List)localObject1).iterator();
        while (paramConfig.hasNext())
        {
          localObject1 = (String)paramConfig.next();
          try
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append("/");
            ((StringBuilder)localObject3).append((String)localObject1);
            new File(((StringBuilder)localObject3).toString()).delete();
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("HotchatSCMng", "updateHotChatSceneConfig", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.mIsInitCache) });
      }
      return bool;
    }
    for (;;)
    {
      throw paramConfig;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCMng
 * JD-Core Version:    0.7.0.1
 */