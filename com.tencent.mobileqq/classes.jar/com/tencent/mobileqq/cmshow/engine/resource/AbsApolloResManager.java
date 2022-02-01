package com.tencent.mobileqq.cmshow.engine.resource;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.NotifyDressReady;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.ApolloDownloadListener;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler.OnQueryBaseInfoListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.model.ApolloActionTag;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloCommConfigKvData;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.model.ApolloDressInfo;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.model.ApolloRelationTag;
import com.tencent.mobileqq.apollo.model.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResHelperImpl;
import com.tencent.mobileqq.apollo.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.apollo.utils.ApolloResDownloaderUtil;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Service(process={"all"})
public abstract class AbsApolloResManager
  implements IApolloResManager
{
  private static AtomicBoolean e = new AtomicBoolean(false);
  private static ConcurrentHashMap<Integer, Boolean> g = new ConcurrentHashMap();
  ApolloListenerManager a;
  JSONObject b = new JSONObject();
  DownloadListener c = new AbsApolloResManager.18(this);
  private ApolloExtensionHandler.OnQueryBaseInfoListener d;
  private AtomicBoolean f = new AtomicBoolean(false);
  private IApolloResDownloader.OnApolloDownLoadListener h;
  private AppInterface i;
  private DownloadListener j = new AbsApolloResManager.8(this);
  private Runnable k = new AbsApolloResManager.15(this);
  private Runnable l = new AbsApolloResManager.16(this);
  private DownloadListener m = new AbsApolloResManager.17(this);
  
  private int a(ArrayList<Integer> paramArrayList, ApolloDress paramApolloDress, StringBuilder paramStringBuilder, String paramString)
  {
    long l1 = g(1, paramApolloDress.roleId) / 1000L;
    int n;
    if ((l1 != paramApolloDress.roleTimeStamp) && (!paramArrayList.contains(Integer.valueOf(paramApolloDress.roleId))))
    {
      int i1 = paramApolloDress.roleId;
      paramArrayList.add(Integer.valueOf(paramApolloDress.roleId));
      n = i1;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(paramApolloDress.roleId);
        paramStringBuilder.append(", local TS: ");
        paramStringBuilder.append(l1);
        paramStringBuilder.append(", svr TS: ");
        paramStringBuilder.append(paramApolloDress.roleTimeStamp);
        return i1;
      }
    }
    else
    {
      n = -1;
    }
    return n;
  }
  
  @NotNull
  private ApolloExtensionHandler.OnQueryBaseInfoListener a(String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener, AppInterface paramAppInterface)
  {
    return new AbsApolloResManager.3(this, paramString, paramAppInterface, paramApolloUserDressInfoListener);
  }
  
  @NotNull
  private List<Integer> a(List<ApolloActionData> paramList, List<ApolloActionPackage> paramList1, List<ApolloActionPackageData> paramList2, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONObject != null) && (paramJSONObject.has("packageInfo")))
    {
      paramJSONObject = paramJSONObject.getJSONArray("packageInfo");
      if (paramJSONObject != null)
      {
        int n = 0;
        while (n < paramJSONObject.length())
        {
          Object localObject = paramJSONObject.getJSONObject(n);
          if (localObject != null)
          {
            ApolloActionPackage localApolloActionPackage = new ApolloActionPackage();
            if (!a(paramList, paramList1, (JSONObject)localObject, localApolloActionPackage))
            {
              localObject = ((JSONObject)localObject).optJSONArray("actionSet");
              if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
                a(paramList, paramList2, localArrayList, localApolloActionPackage, (JSONArray)localObject);
              } else {
                a(paramList1, localApolloActionPackage);
              }
            }
          }
          n += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]cm_res", 2, new Object[] { "[parseActionInfo] world action list=", localArrayList });
    }
    return localArrayList;
  }
  
  private AtomicInteger a(List<Integer> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    if ((paramBoolean1) || (paramList.size() > 0)) {
      localAtomicInteger.getAndIncrement();
    }
    if (paramBoolean2) {
      localAtomicInteger.getAndIncrement();
    }
    return localAtomicInteger;
  }
  
  /* Error */
  private void a(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +53 -> 56
    //   6: new 123	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: ldc 221
    //   19: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 5
    //   25: aload_2
    //   26: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 5
    //   32: ldc 223
    //   34: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 5
    //   40: aload_3
    //   41: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 194
    //   47: iconst_2
    //   48: aload 5
    //   50: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aconst_null
    //   57: astore 7
    //   59: aconst_null
    //   60: astore 6
    //   62: new 232	java/io/File
    //   65: dup
    //   66: ldc 234
    //   68: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 240	java/io/File:mkdirs	()Z
    //   74: pop
    //   75: aload_1
    //   76: invokevirtual 246	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   79: aload_2
    //   80: invokevirtual 252	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   83: astore 5
    //   85: new 254	java/io/FileOutputStream
    //   88: dup
    //   89: new 232	java/io/File
    //   92: dup
    //   93: aload_3
    //   94: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   100: astore_2
    //   101: sipush 4096
    //   104: newarray byte
    //   106: astore_1
    //   107: aload 5
    //   109: aload_1
    //   110: invokevirtual 263	java/io/InputStream:read	([B)I
    //   113: istore 4
    //   115: iload 4
    //   117: iconst_m1
    //   118: if_icmpeq +14 -> 132
    //   121: aload_2
    //   122: aload_1
    //   123: iconst_0
    //   124: iload 4
    //   126: invokevirtual 267	java/io/FileOutputStream:write	([BII)V
    //   129: goto -22 -> 107
    //   132: aload_2
    //   133: invokevirtual 270	java/io/FileOutputStream:flush	()V
    //   136: aload 5
    //   138: ifnull +11 -> 149
    //   141: aload 5
    //   143: invokevirtual 273	java/io/InputStream:close	()V
    //   146: goto +3 -> 149
    //   149: aload_2
    //   150: invokevirtual 274	java/io/FileOutputStream:close	()V
    //   153: return
    //   154: new 123	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   161: astore_2
    //   162: goto +119 -> 281
    //   165: astore_1
    //   166: aload_2
    //   167: astore_3
    //   168: goto +10 -> 178
    //   171: astore_3
    //   172: goto +20 -> 192
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_3
    //   178: aload 5
    //   180: astore_2
    //   181: aload_3
    //   182: astore 5
    //   184: aload_1
    //   185: astore_3
    //   186: goto +129 -> 315
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_2
    //   192: aload 5
    //   194: astore_1
    //   195: goto +19 -> 214
    //   198: astore_3
    //   199: aconst_null
    //   200: astore 5
    //   202: aload 7
    //   204: astore_2
    //   205: goto +110 -> 315
    //   208: astore_3
    //   209: aconst_null
    //   210: astore_2
    //   211: aload 6
    //   213: astore_1
    //   214: new 123	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   221: astore 5
    //   223: aload 5
    //   225: ldc_w 276
    //   228: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 5
    //   234: aload_3
    //   235: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   238: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: ldc 194
    //   244: iconst_1
    //   245: aload 5
    //   247: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_1
    //   254: ifnull +10 -> 264
    //   257: aload_1
    //   258: invokevirtual 273	java/io/InputStream:close	()V
    //   261: goto +3 -> 264
    //   264: aload_2
    //   265: ifnull +43 -> 308
    //   268: aload_2
    //   269: invokevirtual 274	java/io/FileOutputStream:close	()V
    //   272: return
    //   273: new 123	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   280: astore_2
    //   281: aload_2
    //   282: ldc_w 283
    //   285: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_2
    //   290: aload_1
    //   291: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: ldc 194
    //   300: iconst_1
    //   301: aload_2
    //   302: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: return
    //   309: astore_3
    //   310: aload_2
    //   311: astore 5
    //   313: aload_1
    //   314: astore_2
    //   315: aload_2
    //   316: ifnull +10 -> 326
    //   319: aload_2
    //   320: invokevirtual 273	java/io/InputStream:close	()V
    //   323: goto +3 -> 326
    //   326: aload 5
    //   328: ifnull +46 -> 374
    //   331: aload 5
    //   333: invokevirtual 274	java/io/FileOutputStream:close	()V
    //   336: goto +38 -> 374
    //   339: new 123	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   346: astore_1
    //   347: aload_1
    //   348: ldc_w 283
    //   351: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload_1
    //   356: aload_2
    //   357: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   360: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: ldc 194
    //   366: iconst_1
    //   367: aload_1
    //   368: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: goto +5 -> 379
    //   377: aload_3
    //   378: athrow
    //   379: goto -2 -> 377
    //   382: astore_1
    //   383: goto -229 -> 154
    //   386: astore_1
    //   387: goto -114 -> 273
    //   390: astore_2
    //   391: goto -52 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	AbsApolloResManager
    //   0	394	1	paramContext	android.content.Context
    //   0	394	2	paramString1	String
    //   0	394	3	paramString2	String
    //   113	12	4	n	int
    //   13	319	5	localObject1	Object
    //   60	152	6	localObject2	Object
    //   57	146	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   101	107	165	finally
    //   107	115	165	finally
    //   121	129	165	finally
    //   132	136	165	finally
    //   101	107	171	java/lang/Exception
    //   107	115	171	java/lang/Exception
    //   121	129	171	java/lang/Exception
    //   132	136	171	java/lang/Exception
    //   85	101	175	finally
    //   85	101	189	java/lang/Exception
    //   62	85	198	finally
    //   62	85	208	java/lang/Exception
    //   214	253	309	finally
    //   141	146	382	java/lang/Exception
    //   149	153	382	java/lang/Exception
    //   257	261	386	java/lang/Exception
    //   268	272	386	java/lang/Exception
    //   319	323	390	java/lang/Exception
    //   331	336	390	java/lang/Exception
  }
  
  private void a(AppInterface paramAppInterface, ApolloBaseInfo paramApolloBaseInfo)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramApolloBaseInfo.uin);
    paramAppInterface = (ApolloExtensionHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    paramAppInterface.notifyUI(2, true, localArrayList);
    CmGameServerQIPCModule.b().a(localArrayList);
    paramAppInterface.a(paramApolloBaseInfo.uin, paramApolloBaseInfo);
  }
  
  private void a(AppInterface paramAppInterface, String paramString, ApolloBaseInfo paramApolloBaseInfo, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    if (paramApolloBaseInfo == null)
    {
      QLog.d("[cmshow]cm_res", 1, "handleBaseInfoListener  apolloBaseInfo is null");
      paramApolloUserDressInfoListener.a(null, "apolloBaseInfo is null", -5005);
      return;
    }
    if ((paramApolloBaseInfo.apolloStatus != 0) && (paramApolloBaseInfo.apolloStatus != 2))
    {
      a(paramApolloBaseInfo, paramString, paramApolloUserDressInfoListener, paramAppInterface, true);
      return;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("apolloStatus not open");
    paramAppInterface.append(paramApolloBaseInfo.apolloStatus);
    paramApolloUserDressInfoListener.a(null, paramAppInterface.toString(), -5006);
  }
  
  private void a(ApolloActionPackage paramApolloActionPackage, List<ApolloActionData> paramList)
  {
    Object localObject1 = this.i;
    if ((paramApolloActionPackage == null) || (localObject1 == null) || (paramList != null)) {}
    for (;;)
    {
      try
      {
        if (paramList.size() != 0)
        {
          Object localObject2 = ((AppRuntime)localObject1).getApp();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("apollo_sp");
          ((StringBuilder)localObject3).append(((AppRuntime)localObject1).getCurrentUin());
          localObject2 = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0).getString(String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramApolloActionPackage.packageId) }), "");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("[cmshow]cm_res", 2, "checkPackageRedDots, no new action info");
            return;
          }
          localObject3 = new JSONObject((String)localObject2);
          int i1 = ((JSONObject)localObject3).getInt("actionId");
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            continue;
          }
          if (((ApolloActionData)paramList.next()).actionId != i1) {
            continue;
          }
          n = 1;
          if (n == 0)
          {
            QLog.d("[cmshow]cm_res", 1, new Object[] { "checkPackageRedDots, new action, pkdId=", Integer.valueOf(paramApolloActionPackage.packageId), ", actionId=", Integer.valueOf(i1) });
            return;
          }
          long l1 = ((JSONObject)localObject3).getLong("startTime");
          long l2 = ((JSONObject)localObject3).getLong("interval");
          paramList = ((ApolloDaoManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).findPackageById(paramApolloActionPackage.packageId);
          if (paramList == null) {
            continue;
          }
          if (l1 != paramList.redStartTime) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]cm_res", 2, new Object[] { "checkPackageRedDots", " have not new red push" });
          }
          paramApolloActionPackage.isUpdate = paramList.isUpdate;
          paramApolloActionPackage.redFlowId = paramList.redFlowId;
          paramApolloActionPackage.redStartTime = paramList.redStartTime;
          paramApolloActionPackage.redInterval = paramList.redInterval;
          return;
          paramApolloActionPackage.isUpdate = true;
          paramApolloActionPackage.redFlowId = i1;
          paramApolloActionPackage.redStartTime = l1;
          paramApolloActionPackage.redInterval = l2;
          ((ApolloManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloManagerService.class, "all")).saveRedAppearTime(paramApolloActionPackage.packageId);
          paramList = new ArrayList();
          localObject1 = new ApolloActionData();
          ((ApolloActionData)localObject1).actionId = i1;
          paramList.add(localObject1);
          a(paramList, "apollo_key");
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("[cmshow]cm_res", 2, new Object[] { "checkPackageRedDots", " push red:", Integer.valueOf(paramApolloActionPackage.packageId), " newActionInfoStr:", localObject2 });
          return;
        }
        try
        {
          QLog.e("[cmshow]cm_res", 1, "[checkPackageRedDots] error, allAction is empty!");
          return;
        }
        catch (Exception paramApolloActionPackage) {}
      }
      catch (Exception paramApolloActionPackage)
      {
        int n;
        continue;
      }
      QLog.e("[cmshow]cm_res", 1, "checkPackageRedDots Exception:", paramApolloActionPackage);
      return;
      QLog.e("[cmshow]cm_res", 1, "[checkPackageRedDots] error, invalid params!");
      return;
      return;
      n = 0;
      continue;
    }
  }
  
  private void a(ApolloBaseInfo paramApolloBaseInfo, ApolloDress paramApolloDress, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    try
    {
      ApolloDressInfo localApolloDressInfo = new ApolloDressInfo();
      localApolloDressInfo.setUin(paramString);
      localApolloDressInfo.setDressMap(paramApolloBaseInfo.getApolloDress3D().dressMap);
      paramApolloDress = MD5Utils.toMD5(paramApolloDress.faceData);
      paramString = new StringBuilder();
      paramString.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/");
      paramString.append(paramApolloDress);
      paramString.append(File.separator);
      paramString.append("face.json");
      localApolloDressInfo.setFaceJson(new JSONObject(FileUtils.readFileToString(new File(paramString.toString()))));
      paramApolloDress = new StringBuilder();
      paramApolloDress.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      paramApolloDress.append(paramApolloBaseInfo.getApolloDress3D().roleId);
      localApolloDressInfo.setRoleDir(paramApolloDress.toString());
      paramApolloUserDressInfoListener.a(localApolloDressInfo, "success", 0);
      return;
    }
    catch (Throwable paramApolloBaseInfo)
    {
      QLog.e("[cmshow]cm_res", 1, "getApolloUserDressInfo error ,", paramApolloBaseInfo);
      paramApolloUserDressInfoListener.a(null, "exception", -5008);
    }
  }
  
  private void a(ApolloPreDownloadData paramApolloPreDownloadData, String paramString1, String paramString2)
  {
    if ((paramApolloPreDownloadData != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (this.i == null)
      {
        QLog.e("[cmshow]cm_res", 1, "[doPreDownloadResDone] error! mApp is null! ");
        return;
      }
      try
      {
        File localFile = new File(paramString1);
        if (!localFile.exists()) {
          return;
        }
        String str = MD5FileUtil.a(localFile);
        if ((str != null) && (!str.equalsIgnoreCase(paramApolloPreDownloadData.md5)))
        {
          QLog.e("[cmshow]cm_res", 1, "preDownloadListener md5 not match!");
          localFile.delete();
          return;
        }
        FileUtils.uncompressZip(paramString1, paramString2, false);
        if (TextUtils.isEmpty(paramApolloPreDownloadData.zipDir)) {
          localFile.delete();
        }
        paramString2 = (ApolloDaoManagerServiceImpl)this.i.getRuntimeService(IApolloDaoManagerService.class, "all");
        paramApolloPreDownloadData.status = 1;
        paramString2.updatePreDownloadRes(paramApolloPreDownloadData);
        VipUtils.a(this.i, "cmshow", "Apollo", "pre_download_res", 0, 0, new String[] { paramApolloPreDownloadData.reportId });
        return;
      }
      catch (Exception paramApolloPreDownloadData)
      {
        paramString2 = new StringBuilder();
        paramString2.append("preDownloadListener fail zip file: ");
        paramString2.append(paramString1);
        QLog.e("[cmshow]cm_res", 1, paramString2.toString(), paramApolloPreDownloadData);
        return;
      }
    }
    QLog.e("[cmshow]cm_res", 1, "preDownloadListener err param");
  }
  
  private void a(ArrayList<Integer> paramArrayList1, ApolloBaseInfo paramApolloBaseInfo, StringBuilder paramStringBuilder, ArrayList<Integer> paramArrayList2)
  {
    paramApolloBaseInfo = paramApolloBaseInfo.getApolloPetDress();
    if ((paramApolloBaseInfo != null) && (paramApolloBaseInfo.dressMap != null))
    {
      paramApolloBaseInfo = paramApolloBaseInfo.dressMap.entrySet().iterator();
      while (paramApolloBaseInfo.hasNext())
      {
        ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)paramApolloBaseInfo.next()).getValue();
        long l1 = g(2, localDress.id) / 1000L;
        if ((l1 != localDress.ts) && (!paramArrayList1.contains(Integer.valueOf(localDress.id))))
        {
          paramArrayList2.add(Integer.valueOf(localDress.id));
          paramArrayList1.add(Integer.valueOf(localDress.id));
          if (QLog.isColorLevel())
          {
            paramStringBuilder.append("\npet dress id: ");
            paramStringBuilder.append(localDress.id);
            paramStringBuilder.append(", local TS: ");
            paramStringBuilder.append(l1);
            paramStringBuilder.append(", svr TS: ");
            paramStringBuilder.append(localDress.ts);
          }
        }
      }
    }
  }
  
  private void a(ArrayList<Integer> paramArrayList1, ApolloDress paramApolloDress, StringBuilder paramStringBuilder, ArrayList<Integer> paramArrayList2, String paramString)
  {
    paramApolloDress = paramApolloDress.dressMap.entrySet().iterator();
    while (paramApolloDress.hasNext())
    {
      ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)paramApolloDress.next()).getValue();
      long l1 = g(2, localDress.id) / 1000L;
      if ((l1 != localDress.ts) && (!paramArrayList1.contains(Integer.valueOf(localDress.id))))
      {
        paramArrayList2.add(Integer.valueOf(localDress.id));
        paramArrayList1.add(Integer.valueOf(localDress.id));
        if (QLog.isColorLevel())
        {
          paramStringBuilder.append(paramString);
          paramStringBuilder.append(localDress.id);
          paramStringBuilder.append(", local TS: ");
          paramStringBuilder.append(l1);
          paramStringBuilder.append(", svr TS: ");
          paramStringBuilder.append(localDress.ts);
        }
      }
    }
  }
  
  private void a(List<ApolloActionPackage> paramList, ApolloActionPackage paramApolloActionPackage)
  {
    if ((paramApolloActionPackage.type != 2) && (paramApolloActionPackage.packageId != 8) && (paramApolloActionPackage.packageId != 10) && (paramApolloActionPackage.packageId != 302)) {
      paramList.remove(paramApolloActionPackage);
    }
  }
  
  private void a(List<ApolloActionData> paramList, List<Integer> paramList1)
  {
    if ((paramList1.size() > 0) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)paramList.next();
        if (paramList1.contains(Integer.valueOf(localApolloActionData.actionId))) {
          localApolloActionData.hasExtraAction = true;
        } else {
          localApolloActionData.hasExtraAction = false;
        }
      }
    }
  }
  
  private void a(List<ApolloActionData> paramList, List<ApolloActionPackageData> paramList1, List<Integer> paramList2, ApolloActionPackage paramApolloActionPackage, JSONArray paramJSONArray)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int n = 0;
    while (n < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.getJSONObject(n);
      ApolloActionPackageData localApolloActionPackageData = new ApolloActionPackageData();
      localApolloActionPackageData.packageId = paramApolloActionPackage.packageId;
      localApolloActionPackageData.acitonId = ((JSONObject)localObject).optInt("actionId");
      localApolloActionPackageData.text = ((JSONObject)localObject).optString("text");
      localApolloActionPackageData.textType = ((JSONObject)localObject).optInt("textType");
      if (a(localApolloActionPackageData.acitonId, paramList))
      {
        paramList1.add(localApolloActionPackageData);
        if (localApolloActionPackageData.packageId == 5) {
          paramList2.add(Integer.valueOf(localApolloActionPackageData.acitonId));
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("action list has not packageAction id=");
        ((StringBuilder)localObject).append(localApolloActionPackageData.acitonId);
        QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject).toString());
      }
      localStringBuilder.append(localApolloActionPackageData.acitonId);
      localStringBuilder.append(" ");
      n += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]cm_res", 2, new Object[] { "addActionPackageData packageId=", Integer.valueOf(paramApolloActionPackage.packageId), " actionId=[", localStringBuilder.toString(), "]" });
    }
  }
  
  private void a(List<ApolloActionData> paramList, List<ApolloActionPackage> paramList1, List<ApolloActionPackageData> paramList2, List<ApolloActionTag> paramList3, JSONObject paramJSONObject)
  {
    try
    {
      b(paramList, paramJSONObject);
      if (this.i == null)
      {
        QLog.e("[cmshow]cm_res", 1, "[parseActionInfo] update packageInfo error! app is null! ");
        return;
      }
      a(paramList, a(paramList, paramList1, paramList2, paramJSONObject));
      a(paramList3, paramJSONObject);
      return;
    }
    catch (Exception paramList)
    {
      paramList1 = new StringBuilder();
      paramList1.append("parse ActionInfo error:");
      paramList1.append(paramList);
      QLog.e("[cmshow]cm_res", 1, paramList1.toString());
    }
  }
  
  private void a(List<ApolloActionData> paramList1, List<ApolloActionData> paramList2, JSONArray paramJSONArray, int paramInt)
  {
    paramJSONArray = paramJSONArray.getJSONObject(paramInt);
    if (paramJSONArray != null)
    {
      ApolloActionData localApolloActionData = new ApolloActionData();
      e(paramJSONArray, localApolloActionData);
      d(paramJSONArray, localApolloActionData);
      c(paramJSONArray, localApolloActionData);
      b(paramJSONArray, localApolloActionData);
      a(paramJSONArray, localApolloActionData);
      h(paramJSONArray, localApolloActionData);
      g(paramJSONArray, localApolloActionData);
      f(paramJSONArray, localApolloActionData);
      f(localApolloActionData);
      e(localApolloActionData);
      paramList1.add(localApolloActionData);
      if (localApolloActionData.feeType == 6) {
        paramList2.add(localApolloActionData);
      }
    }
  }
  
  private void a(List<String> paramList, Map<String, File> paramMap, List<ApolloActionData> paramList1, Bundle paramBundle)
  {
    if ((paramList1 != null) && (paramList1.size() > 0) && (paramList != null))
    {
      if (paramMap == null) {
        return;
      }
      int n = 0;
      while (n < paramList1.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)paramList1.get(n);
        String str1 = a(localApolloActionData, 1);
        Object localObject = a(localApolloActionData, 0);
        String str2 = a(localApolloActionData, 5);
        String str3 = a(localApolloActionData, 4);
        if (FileUtil.d((String)localObject))
        {
          localObject = new DownloadTask(str1, new File((String)localObject));
          Bundle localBundle = new Bundle();
          localBundle.putSerializable(str1, localApolloActionData);
          ((DownloadTask)localObject).h = str1;
          ((DownloadTask)localObject).a(localBundle);
          this.m.onDoneFile((DownloadTask)localObject);
        }
        else
        {
          paramList.add(str1);
          paramMap.put(str1, new File((String)localObject));
          if (paramBundle != null) {
            paramBundle.putSerializable(str1, localApolloActionData);
          }
        }
        if (!c(localApolloActionData.actionId, localApolloActionData.personNum))
        {
          paramList.add(str2);
          paramMap.put(str2, new File(str3));
          if (paramBundle != null) {
            paramBundle.putSerializable(str2, localApolloActionData);
          }
        }
        n += 1;
      }
    }
  }
  
  private void a(List<ApolloCommConfigKvData> paramList, JSONArray paramJSONArray)
  {
    if (paramList != null)
    {
      if (paramJSONArray == null) {
        return;
      }
      int n = 0;
      try
      {
        while (n < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.optJSONObject(n);
          if (localJSONObject != null)
          {
            ApolloCommConfigKvData localApolloCommConfigKvData = new ApolloCommConfigKvData();
            localApolloCommConfigKvData.key = localJSONObject.optString("key");
            localApolloCommConfigKvData.value = localJSONObject.optString("value");
            if (!TextUtils.isEmpty(localApolloCommConfigKvData.key)) {
              paramList.add(localApolloCommConfigKvData);
            }
          }
          n += 1;
        }
        return;
      }
      catch (Exception paramList)
      {
        QLog.e("[cmshow]cm_res", 1, "parseTableKvMap failed", paramList);
      }
    }
  }
  
  private void a(List<ApolloActionTag> paramList, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("actionTag")))
    {
      paramJSONObject = paramJSONObject.getJSONArray("actionTag");
      if (paramJSONObject != null)
      {
        int n = 0;
        while (n < paramJSONObject.length())
        {
          Object localObject = paramJSONObject.getJSONObject(n);
          if (localObject != null)
          {
            JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("actionList");
            String str = ((JSONObject)localObject).getString("tagName");
            int i2 = ((JSONObject)localObject).getInt("packageId");
            int i1 = 0;
            while (i1 < localJSONArray.length())
            {
              localObject = new ApolloActionTag();
              ((ApolloActionTag)localObject).tagName = str;
              ((ApolloActionTag)localObject).packageId = i2;
              ((ApolloActionTag)localObject).actionId = localJSONArray.getInt(i1);
              paramList.add(localObject);
              i1 += 1;
            }
          }
          n += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]cm_res", 2, new Object[] { "[parseActionInfo] apolloActionTagList = ", paramList });
    }
  }
  
  private void a(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, IApolloDaoManagerService paramIApolloDaoManagerService, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    if (paramAtomicInteger1.get() == paramAtomicInteger2.get())
    {
      if (paramAtomicInteger3.get() == paramAtomicInteger1.get())
      {
        paramAtomicInteger1 = paramIApolloDaoManagerService.getApolloBaseInfo(paramString);
        a(paramAtomicInteger1, paramAtomicInteger1.getApolloDress3D(), paramString, paramApolloUserDressInfoListener);
        return;
      }
      paramApolloUserDressInfoListener.a(null, "download error", -5003);
    }
  }
  
  private void a(JSONArray paramJSONArray, List<ApolloRelationTag> paramList)
  {
    if (paramJSONArray == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseRelationTags: ");
      ((StringBuilder)localObject).append(paramJSONArray.toString());
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      int i1 = paramJSONArray.length();
      int n = 0;
      while (n < i1)
      {
        localObject = paramJSONArray.optJSONObject(n);
        if (localObject != null)
        {
          ApolloRelationTag localApolloRelationTag = new ApolloRelationTag();
          localApolloRelationTag.type = ((JSONObject)localObject).optInt("type");
          localApolloRelationTag.action = ((JSONObject)localObject).optString("action");
          localApolloRelationTag.tag2D = ((JSONObject)localObject).optString("tag2D");
          localApolloRelationTag.tag3D = ((JSONObject)localObject).optString("tag3D");
          paramList.add(localApolloRelationTag);
        }
        n += 1;
      }
      return;
    }
    catch (Exception paramJSONArray)
    {
      QLog.e("[cmshow]cm_res", 1, "parseRelationTags", paramJSONArray);
    }
  }
  
  private void a(JSONObject paramJSONObject, ApolloActionData paramApolloActionData)
  {
    paramApolloActionData.gameId = paramJSONObject.optInt("gameId");
    paramApolloActionData.gameName = paramJSONObject.optString("gameName");
    paramApolloActionData.activeValue = paramJSONObject.optInt("activeValue");
    paramApolloActionData.soundURL = paramJSONObject.optString("soundURL");
    paramApolloActionData.soundType = paramJSONObject.optInt("soundType");
  }
  
  private void a(JSONObject paramJSONObject, ApolloActionPackage paramApolloActionPackage)
  {
    paramApolloActionPackage.packageId = paramJSONObject.getInt("packageId");
    paramApolloActionPackage.version = paramJSONObject.optInt("version");
    paramApolloActionPackage.startVersion = paramJSONObject.optString("startVersion");
    paramApolloActionPackage.endVersion = paramJSONObject.optString("endVersion");
    paramApolloActionPackage.type = paramJSONObject.optInt("type");
    paramApolloActionPackage.sessionType = paramJSONObject.optInt("use");
    paramApolloActionPackage.name = paramJSONObject.optString("name");
    paramApolloActionPackage.mIconUnselectedUrl = paramJSONObject.optString("apImg");
    paramApolloActionPackage.mIconSelectedUrl = paramJSONObject.optString("apcImg");
  }
  
  private void a(JSONObject paramJSONObject, List<ApolloWhiteFaceID> paramList)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      int n;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("IDMap");
        if (paramJSONObject != null) {
          break label114;
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        JSONObject localJSONObject;
        ApolloWhiteFaceID localApolloWhiteFaceID;
        QLog.e("[cmshow]cm_res", 1, "parseWhiteFaceIdMapping:", paramJSONObject);
      }
      if (n < paramJSONObject.length())
      {
        localJSONObject = paramJSONObject.optJSONObject(n);
        if (localJSONObject != null)
        {
          localApolloWhiteFaceID = new ApolloWhiteFaceID();
          localApolloWhiteFaceID.terminalId = localJSONObject.optInt("terminalID");
          localApolloWhiteFaceID.action2d = localJSONObject.optInt("action2D");
          localApolloWhiteFaceID.action3d = localJSONObject.optInt("action3D");
          paramList.add(localApolloWhiteFaceID);
        }
        n += 1;
      }
      else
      {
        return;
        label114:
        n = 0;
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, long paramLong)
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt1);
    if (localApolloActionData == null)
    {
      paramString = new StringBuilder();
      paramString.append("warning: data is null. call checkApolloPanelJsonVer, id:");
      paramString.append(paramInt1);
      QLog.i("[cmshow]cm_res", 1, paramString.toString());
      ApolloContentUpdateHandler.a(localQQAppInterface, 1);
      return false;
    }
    if (paramInt2 == 1)
    {
      bool1 = CmShowAioMatcherImpl.judgeSupported(paramInt3, 2);
      if (bool1) {
        paramInt3 = 0;
      } else {
        paramInt3 = localApolloActionData.personNum;
      }
      bool1 = a(paramInt1, paramInt4, paramInt3, bool1);
    }
    else
    {
      bool1 = c(paramInt1, localApolloActionData.personNum);
      if ((8 != paramInt2) || (paramString == null) || (!bool1)) {}
    }
    try
    {
      localObject = new JSONObject(paramString).optJSONObject("action");
      str = ((JSONObject)localObject).optString("actionId");
      if (TextUtils.isEmpty(str)) {
        break label237;
      }
      paramInt3 = Integer.parseInt(str);
      if (((JSONObject)localObject).optInt("actionPlatform") <= 0) {
        break label638;
      }
      bool2 = true;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        String str;
        boolean bool3;
        continue;
        boolean bool2 = false;
        continue;
        boolean bool4 = false;
      }
    }
    bool2 = a(paramInt1, false, paramInt3, bool2);
    if (!bool2) {
      bool1 = false;
    }
    label237:
    bool2 = bool1;
    bool3 = bool1;
    try
    {
      if (1 == localApolloActionData.personNum)
      {
        bool2 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          str = ((JSONObject)localObject).optString("actionPeerId");
          bool2 = bool1;
          bool3 = bool1;
          if (!TextUtils.isEmpty(str))
          {
            bool3 = bool1;
            paramInt3 = Integer.parseInt(str);
            bool3 = bool1;
            if (((JSONObject)localObject).optInt("actionPeerPlatform") <= 0) {
              break label644;
            }
            bool4 = true;
            bool2 = bool1;
            bool3 = bool1;
            if (!a(paramInt1, true, paramInt3, bool4)) {
              bool2 = false;
            }
          }
        }
      }
      bool1 = bool2;
      if (bool2) {
        break label456;
      }
      bool3 = bool2;
      localObject = new StringBuilder();
      bool3 = bool2;
      ((StringBuilder)localObject).append("[random] action nis not exist,");
      bool3 = bool2;
      ((StringBuilder)localObject).append(paramString);
      bool3 = bool2;
      QLog.e("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
      bool1 = bool2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        bool1 = bool3;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[random] the json is not right,");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
    label456:
    paramString = ((ISpriteScriptManager)localQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getUIHandler();
    if (!bool1)
    {
      if (paramString != null) {
        paramString.a(0, 0, paramLong);
      }
      bool1 = a(localApolloActionData, 4, null);
      if (paramString != null)
      {
        if (bool1) {
          paramInt3 = 0;
        } else {
          paramInt3 = 6;
        }
        paramString.a(paramInt3, 1, paramLong);
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]cm_res", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramInt1), ", costT:", Long.valueOf(paramLong - l1), ", threadId:", Long.valueOf(Thread.currentThread().getId()), ", actionType:", Integer.valueOf(paramInt2) });
    }
    return true;
  }
  
  private boolean a(int paramInt, List<ApolloActionData> paramList)
  {
    if (paramList != null)
    {
      int n = 0;
      while (n < paramList.size())
      {
        if (((ApolloActionData)paramList.get(n)).actionId == paramInt) {
          return true;
        }
        n += 1;
      }
    }
    return false;
  }
  
  private boolean a(AppInterface paramAppInterface, ApolloBaseInfo paramApolloBaseInfo, boolean paramBoolean, StringBuilder paramStringBuilder, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    if ((paramInt == -1) && ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)))
    {
      paramStringBuilder.append("\nlocal dress is OK");
      return true;
    }
    a().a(paramAppInterface, paramApolloBaseInfo.uin, g(), paramInt, paramArrayOfInt, -1, -1, true);
    if (QLog.isColorLevel()) {
      paramStringBuilder.append(paramString);
    }
    return paramBoolean;
  }
  
  private boolean a(AppInterface paramAppInterface, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2, ApolloBaseInfo paramApolloBaseInfo, boolean paramBoolean)
  {
    ApolloDress localApolloDress = paramApolloBaseInfo.getApolloDress3D();
    boolean bool = false;
    int n = 0;
    if (localApolloDress != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("3d updateUserDress uin: ");
        localStringBuilder.append(paramApolloBaseInfo.uin);
        localStringBuilder.append(", dress info: ");
        localStringBuilder.append(localApolloDress.toString());
      }
      int i1 = a(paramArrayList1, localApolloDress, localStringBuilder, "\n3d role id: ");
      if (localApolloDress.dressMap != null)
      {
        ArrayList localArrayList = new ArrayList();
        a(paramArrayList2, localApolloDress, localStringBuilder, localArrayList, "\n3d dress id: ");
        if (localArrayList.size() > 0)
        {
          paramArrayList1 = new int[localArrayList.size()];
          paramArrayList2 = localArrayList.iterator();
          while (paramArrayList2.hasNext())
          {
            paramArrayList1[n] = ((Integer)paramArrayList2.next()).intValue();
            n += 1;
          }
          break label182;
        }
      }
      paramArrayList1 = null;
      label182:
      paramBoolean = a(paramAppInterface, paramApolloBaseInfo, paramBoolean, localStringBuilder, i1, paramArrayList1, "\n3d download dress");
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("[cmshow]cm_res", 2, localStringBuilder.toString());
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  private boolean a(ApolloBaseInfo paramApolloBaseInfo, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener, AppInterface paramAppInterface, boolean paramBoolean)
  {
    ApolloDress localApolloDress = paramApolloBaseInfo.getApolloDress3D();
    if (localApolloDress == null)
    {
      if ((paramBoolean) && (paramApolloUserDressInfoListener != null)) {
        paramApolloUserDressInfoListener.a(null, "dress3DData is null", -5007);
      }
      QLog.e("[cmshow]cm_res", 1, "handleParseApolloBaseInfo dress3DData is null");
      return false;
    }
    paramBoolean = a(localApolloDress);
    ArrayList localArrayList = b(localApolloDress);
    boolean bool = c(localApolloDress);
    if ((!paramBoolean) && (!bool) && (localArrayList.size() == 0))
    {
      a(paramApolloBaseInfo, localApolloDress, paramString, paramApolloUserDressInfoListener);
      return true;
    }
    paramApolloBaseInfo = a();
    AtomicInteger localAtomicInteger1 = a(localArrayList, paramBoolean, bool);
    AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
    AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
    if ((!paramBoolean) && (localArrayList.size() <= 0)) {
      break label198;
    }
    paramApolloBaseInfo.a(paramAppInterface, paramString, new AbsApolloResManager.4(this, localAtomicInteger3, localAtomicInteger2, paramAppInterface, localAtomicInteger1, paramString, paramApolloUserDressInfoListener), localApolloDress.roleId, b(localArrayList), -1, -1, false);
    label198:
    if (bool) {
      paramApolloBaseInfo.a(paramAppInterface, localApolloDress.faceData, new AbsApolloResManager.5(this, localAtomicInteger3, localAtomicInteger2, paramAppInterface, localAtomicInteger1, paramString, paramApolloUserDressInfoListener));
    }
    return true;
  }
  
  private boolean a(ApolloDress paramApolloDress)
  {
    return (paramApolloDress.roleId > 0) && (!b(paramApolloDress.roleId));
  }
  
  private boolean a(String paramString, ApolloActionData paramApolloActionData)
  {
    int i1 = 0;
    if (paramString != null) {
      if (paramApolloActionData == null) {
        return false;
      }
    }
    for (;;)
    {
      boolean bool3;
      int n;
      try
      {
        paramString = new JSONObject(paramString);
        bool1 = paramString.has("audio");
        if (bool1) {
          try
          {
            paramApolloActionData.hasSound = paramString.optJSONObject("audio").optBoolean("hasSound");
            bool3 = true;
          }
          catch (Exception paramString)
          {
            bool3 = true;
            break label604;
          }
        } else {
          bool3 = false;
        }
        bool1 = bool3;
        try
        {
          if (paramString.has("vibrate")) {
            bool1 = true;
          }
          bool3 = bool1;
          Object localObject = paramString.optJSONArray("vibrate");
          if (localObject != null)
          {
            bool3 = bool1;
            StringBuilder localStringBuilder = new StringBuilder(50);
            n = 0;
            bool3 = bool1;
            if (n < ((JSONArray)localObject).length())
            {
              bool3 = bool1;
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(n);
              if (localJSONObject == null) {
                break label623;
              }
              bool3 = bool1;
              int i2 = localJSONObject.optInt("time");
              bool3 = bool1;
              int i3 = localJSONObject.optInt("duration");
              bool3 = bool1;
              localStringBuilder.append(i2);
              bool3 = bool1;
              localStringBuilder.append(",");
              bool3 = bool1;
              localStringBuilder.append(i3);
              bool3 = bool1;
              if (n >= ((JSONArray)localObject).length() - 1) {
                break label623;
              }
              bool3 = bool1;
              localStringBuilder.append(",");
              break label623;
            }
            bool3 = bool1;
            paramApolloActionData.vibrate = localStringBuilder.toString();
          }
          boolean bool2 = bool1;
          bool3 = bool1;
          if (paramString.has("bubbleText")) {
            bool2 = true;
          }
          bool3 = bool2;
          paramString = paramString.optJSONArray("bubbleText");
          if (paramString != null)
          {
            bool3 = bool2;
            localObject = new StringBuilder(50);
            n = i1;
            bool3 = bool2;
            if (n < paramString.length())
            {
              bool3 = bool2;
              ((StringBuilder)localObject).append(paramString.getString(n));
              bool3 = bool2;
              if (n >= paramString.length() - 1) {
                break label630;
              }
              bool3 = bool2;
              ((StringBuilder)localObject).append("@$");
              break label630;
            }
            bool3 = bool2;
            paramApolloActionData.bubbleText = ((StringBuilder)localObject).toString();
          }
          bool3 = bool2;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break label618;
          }
          bool3 = bool2;
          if (!paramApolloActionData.hasSound)
          {
            bool3 = bool2;
            if (TextUtils.isEmpty(paramApolloActionData.vibrate))
            {
              bool3 = bool2;
              bool1 = bool2;
              if (TextUtils.isEmpty(paramApolloActionData.bubbleText)) {
                break label618;
              }
            }
          }
          bool3 = bool2;
          paramString = new StringBuilder();
          bool3 = bool2;
          paramString.append("action id ");
          bool3 = bool2;
          paramString.append(paramApolloActionData.actionId);
          bool3 = bool2;
          paramString.append(", name: ");
          bool3 = bool2;
          paramString.append(paramApolloActionData.actionName);
          bool3 = bool2;
          paramString.append(", hasSound: ");
          bool3 = bool2;
          paramString.append(paramApolloActionData.hasSound);
          bool3 = bool2;
          paramString.append(", vibrate=");
          bool3 = bool2;
          paramString.append(paramApolloActionData.vibrate);
          bool3 = bool2;
          paramString.append(", bubbleText =");
          bool3 = bool2;
          paramString.append(paramApolloActionData.bubbleText);
          bool3 = bool2;
          QLog.d("[cmshow]cm_res", 2, paramString.toString());
          return bool2;
        }
        catch (Exception paramString) {}
        QLog.e("[cmshow]cm_res", 1, "parse action config.json error", paramString);
      }
      catch (Exception paramString)
      {
        bool3 = false;
      }
      label604:
      boolean bool1 = bool3;
      label618:
      return bool1;
      return false;
      label623:
      n += 1;
      continue;
      label630:
      n += 1;
    }
  }
  
  private boolean a(List<ApolloActionData> paramList, List<ApolloActionPackage> paramList1, JSONObject paramJSONObject, ApolloActionPackage paramApolloActionPackage)
  {
    a(paramJSONObject, paramApolloActionPackage);
    if (!ApolloUtilImpl.verifyActionPackageVersion(paramApolloActionPackage, "8.8.17"))
    {
      paramList = new StringBuilder();
      paramList.append("version not correct packageId=");
      paramList.append(paramApolloActionPackage.packageId);
      QLog.w("[cmshow]cm_res", 1, paramList.toString());
      return true;
    }
    a(paramApolloActionPackage, paramList);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("ActionPackage pid = ");
      paramList.append(paramApolloActionPackage.packageId);
      paramList.append(" actionPackage.isUpdate = ");
      paramList.append(paramApolloActionPackage.isUpdate);
      QLog.d("[cmshow]cm_res", 2, paramList.toString());
    }
    paramList1.add(paramApolloActionPackage);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("add actionPackage pid=");
      paramList.append(paramApolloActionPackage.packageId);
      QLog.d("[cmshow]cm_res", 2, paramList.toString());
    }
    return false;
  }
  
  private ArrayList<Integer> b(ApolloDress paramApolloDress)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramApolloDress.dressMap != null) && (!paramApolloDress.dressMap.isEmpty()))
    {
      paramApolloDress = paramApolloDress.dressMap.entrySet().iterator();
      JSONArray localJSONArray = new JSONArray();
      while (paramApolloDress.hasNext())
      {
        ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)paramApolloDress.next()).getValue();
        localJSONArray.put(String.valueOf(localDress.id));
        if (!a(localDress.id)) {
          localArrayList.add(Integer.valueOf(localDress.id));
        }
      }
    }
    return localArrayList;
  }
  
  private void b(List<ApolloActionData> paramList, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONObject != null) && (paramJSONObject.has("data")))
    {
      paramJSONObject = paramJSONObject.getJSONArray("data");
      if (paramJSONObject != null)
      {
        int n = 0;
        int i1 = paramJSONObject.length();
        while (n < i1)
        {
          a(paramList, localArrayList, paramJSONObject, n);
          n += 1;
        }
      }
    }
  }
  
  private void b(JSONObject paramJSONObject, ApolloActionData paramApolloActionData)
  {
    paramApolloActionData.currencyType = paramJSONObject.optInt("currencyType");
    paramApolloActionData.currencyNum = paramJSONObject.optInt("currencyNum");
    paramApolloActionData.description = paramJSONObject.optString("description");
    paramApolloActionData.extraWording = paramJSONObject.optString("extraWording");
    paramApolloActionData.minVer = paramJSONObject.optString("minVer");
    paramApolloActionData.maxVer = paramJSONObject.optString("maxVer");
  }
  
  private boolean b(AppInterface paramAppInterface, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2, ApolloBaseInfo paramApolloBaseInfo, boolean paramBoolean)
  {
    ApolloDress localApolloDress = paramApolloBaseInfo.getApolloDress();
    boolean bool = false;
    int n = 0;
    if (localApolloDress != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("updateUserDress uin: ");
        localStringBuilder.append(paramApolloBaseInfo.uin);
        localStringBuilder.append(", dress info: ");
        localStringBuilder.append(localApolloDress.toString());
      }
      int i1 = a(paramArrayList1, localApolloDress, localStringBuilder, "\nrole id: ");
      Object localObject = null;
      paramArrayList1 = localObject;
      if (localApolloDress.dressMap != null)
      {
        ArrayList localArrayList = new ArrayList();
        a(paramArrayList2, localApolloDress, localStringBuilder, localArrayList, "\ndress id: ");
        a(paramArrayList2, paramApolloBaseInfo, localStringBuilder, localArrayList);
        paramArrayList1 = localObject;
        if (localArrayList.size() > 0)
        {
          paramArrayList1 = new int[localArrayList.size()];
          paramArrayList2 = localArrayList.iterator();
          while (paramArrayList2.hasNext())
          {
            paramArrayList1[n] = ((Integer)paramArrayList2.next()).intValue();
            n += 1;
          }
        }
      }
      paramBoolean = a(paramAppInterface, paramApolloBaseInfo, paramBoolean, localStringBuilder, i1, paramArrayList1, "\ndown load dress");
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("[cmshow]cm_res", 2, localStringBuilder.toString());
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  private int[] b(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int[] arrayOfInt = new int[paramList.size()];
      int n = 0;
      while (n < paramList.size())
      {
        arrayOfInt[n] = ((Integer)paramList.get(n)).intValue();
        n += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  private void c(List<ApolloBaseInfo> paramList)
  {
    AppInterface localAppInterface = this.i;
    if (localAppInterface == null)
    {
      QLog.e("[cmshow]cm_res", 1, "[updateUserDress] error, app is null!");
      return;
    }
    ArrayList localArrayList1 = new ArrayList(8);
    ArrayList localArrayList2 = new ArrayList(16);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ApolloBaseInfo localApolloBaseInfo = (ApolloBaseInfo)paramList.next();
      if (localApolloBaseInfo == null) {
        return;
      }
      if (a(localAppInterface, localArrayList1, localArrayList2, localApolloBaseInfo, b(localAppInterface, localArrayList1, localArrayList2, localApolloBaseInfo, false))) {
        a(localAppInterface, localApolloBaseInfo);
      }
    }
  }
  
  private void c(JSONObject paramJSONObject, ApolloActionData paramApolloActionData)
  {
    paramApolloActionData.startTime = paramJSONObject.optLong("startTime");
    paramApolloActionData.endTime = paramJSONObject.optLong("endTime");
    paramApolloActionData.url = paramJSONObject.optString("activeUrl");
    paramApolloActionData.version = paramJSONObject.getLong("version");
    paramApolloActionData.actionMoveDis = ((float)paramJSONObject.optDouble("actionDis", 0.0D));
    paramApolloActionData.peerMoveDis = ((float)paramJSONObject.optDouble("actionPeerDis", 0.0D));
    paramApolloActionData.compoundType = paramJSONObject.optInt("actionSubType");
    paramApolloActionData.playArea = paramJSONObject.optInt("posType");
    paramApolloActionData.actionType = paramJSONObject.optInt("actionType");
    paramApolloActionData.slaveActionId = paramJSONObject.optInt("slaveActionId");
  }
  
  private boolean c(ApolloDress paramApolloDress)
  {
    return (!TextUtils.isEmpty(paramApolloDress.faceData)) && (!a(paramApolloDress.faceData));
  }
  
  private void d(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) && (!FileUtils.fileExists(a(paramApolloActionData, 7)))) {
      return;
    }
    if (a(FileUtils.readFileContent(new File(a(paramApolloActionData, 7))), paramApolloActionData))
    {
      AppInterface localAppInterface = this.i;
      if (localAppInterface != null)
      {
        ((ApolloDaoManagerServiceImpl)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).updateAction(paramApolloActionData);
        return;
      }
      QLog.e("[cmshow]cm_res", 1, "[parseActionConfigJson] error! app is null! ");
    }
  }
  
  private void d(JSONObject paramJSONObject, ApolloActionData paramApolloActionData)
  {
    if (g(paramApolloActionData)) {
      paramApolloActionData.isForPlayerAction = 1;
    } else {
      paramApolloActionData.isForPlayerAction = paramJSONObject.optInt("isForPlayerAction");
    }
    paramApolloActionData.textImg = paramJSONObject.optString("textImg");
    if (paramJSONObject.has("limitFree"))
    {
      paramApolloActionData.limitFree = paramJSONObject.getInt("limitFree");
      paramApolloActionData.limitStart = paramJSONObject.getLong("begin");
      paramApolloActionData.limitEnd = paramJSONObject.getLong("end");
    }
  }
  
  private void e(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    Object localObject = new File(a(paramApolloActionData, 7));
    if (!((File)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkActionVersion configFile not exists for ");
      ((StringBuilder)localObject).append(paramApolloActionData);
      QLog.e("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
      return;
    }
    try
    {
      localObject = FileUtils.readFileContent((File)localObject);
      if (new JSONObject((String)localObject).optLong("version") < paramApolloActionData.version)
      {
        boolean bool = FileUtil.e(a(paramApolloActionData, 6));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramApolloActionData.actionId);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramApolloActionData.actionName);
        URLDrawable.removeMemoryCacheByUrl(new URL("apollo_pic", null, ((StringBuilder)localObject).toString()).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("del old action res id:");
        ((StringBuilder)localObject).append(paramApolloActionData.actionId);
        ((StringBuilder)localObject).append(", ret: ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
        return;
      }
      a((String)localObject, paramApolloActionData);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkActionVersion failed for ");
      localStringBuilder.append(paramApolloActionData);
      QLog.e("[cmshow]cm_res", 1, localStringBuilder.toString(), localException);
    }
  }
  
  private void e(JSONObject paramJSONObject, ApolloActionData paramApolloActionData)
  {
    paramApolloActionData.actionId = paramJSONObject.getInt("id");
    paramApolloActionData.sessionType = paramJSONObject.optInt("use");
    paramApolloActionData.actionName = paramJSONObject.getString("name");
    paramApolloActionData.vipLevel = paramJSONObject.optInt("vipLevel");
    paramApolloActionData.feeType = paramJSONObject.optInt("feeType", 1);
    if (paramJSONObject.has("icon")) {
      paramApolloActionData.icon = paramJSONObject.getInt("icon");
    }
    paramApolloActionData.iconUrl = paramJSONObject.optString("iconUrl");
    paramApolloActionData.personNum = paramJSONObject.getInt("type");
    paramApolloActionData.anmiName = paramJSONObject.optString("animationName");
    paramApolloActionData.isShow = paramJSONObject.optInt("isShow");
  }
  
  private void f(ApolloActionData paramApolloActionData)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = (ApolloManagerServiceImpl)((AppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
      if ((((ApolloManagerServiceImpl)localObject).mUserActionId != null) && (((ApolloManagerServiceImpl)localObject).mUserActionId.containsKey(Integer.valueOf(paramApolloActionData.actionId))))
      {
        if (paramApolloActionData.isShow == 0) {
          paramApolloActionData.isShow = 1;
        }
        ApolloUtilImpl.updateObtainedAction(paramApolloActionData, (Bundle)((ApolloManagerServiceImpl)localObject).mUserActionId.get(Integer.valueOf(paramApolloActionData.actionId)));
      }
    }
    else
    {
      QLog.e("[cmshow]cm_res", 1, "[parseActionInfo] updateObtainedAction error! mApp is null! ");
    }
  }
  
  private void f(JSONObject paramJSONObject, ApolloActionData paramApolloActionData)
  {
    paramJSONObject = paramJSONObject.optJSONArray("keywords");
    if (paramJSONObject != null)
    {
      int i1 = paramJSONObject.length();
      StringBuilder localStringBuilder = new StringBuilder();
      int n = 0;
      while (n < i1)
      {
        localStringBuilder.append(String.valueOf(paramJSONObject.get(n)));
        if (n != i1 - 1) {
          localStringBuilder.append(",");
        }
        n += 1;
      }
      paramApolloActionData.keywords = localStringBuilder.toString();
    }
  }
  
  private void g(JSONObject paramJSONObject, ApolloActionData paramApolloActionData)
  {
    paramJSONObject = paramJSONObject.optJSONArray("pk3DIds");
    if (paramJSONObject != null)
    {
      int i1 = paramJSONObject.length();
      StringBuilder localStringBuilder = new StringBuilder();
      int n = 0;
      while (n < i1)
      {
        localStringBuilder.append(String.valueOf(paramJSONObject.get(n)));
        if (n != i1 - 1) {
          localStringBuilder.append(",");
        }
        n += 1;
      }
      paramApolloActionData.pk3DIds = localStringBuilder.toString();
    }
  }
  
  private boolean g(ApolloActionData paramApolloActionData)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_test", 0);
    return false;
  }
  
  private void h(int paramInt1, int paramInt2)
  {
    AppInterface localAppInterface = this.i;
    if (localAppInterface == null)
    {
      QLog.e("[cmshow]cm_res", 1, "[downloadActionIfNotExist] error! app is null! ");
      return;
    }
    if (!c(paramInt1, paramInt2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start download action:");
        ((StringBuilder)localObject1).append(paramInt1);
        QLog.i("[cmshow]ApolloPet", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = paramInt1;
      Object localObject1 = a((ApolloActionData)localObject2, 5);
      localObject2 = a((ApolloActionData)localObject2, 4);
      a().a(localAppInterface, (String)localObject2, (String)localObject1);
    }
  }
  
  private void h(JSONObject paramJSONObject, ApolloActionData paramApolloActionData)
  {
    paramJSONObject = paramJSONObject.optJSONArray("pkIds");
    if (paramJSONObject != null)
    {
      int i1 = paramJSONObject.length();
      StringBuilder localStringBuilder = new StringBuilder();
      int n = 0;
      while (n < i1)
      {
        localStringBuilder.append(String.valueOf(paramJSONObject.get(n)));
        if (n != i1 - 1) {
          localStringBuilder.append(",");
        }
        n += 1;
      }
      paramApolloActionData.pkIds = localStringBuilder.toString();
    }
  }
  
  private void i()
  {
    AbsApolloResManager.1 local1 = new AbsApolloResManager.1(this);
    if (!e.getAndSet(true)) {
      ThreadManager.post(local1, 8, null, false);
    }
  }
  
  /* Error */
  private boolean j()
  {
    // Byte code:
    //   0: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 232	java/io/File
    //   7: dup
    //   8: getstatic 1442	com/tencent/mobileqq/apollo/utils/ApolloConstant:a	Ljava/lang/String;
    //   11: ldc_w 1444
    //   14: invokespecial 1447	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: invokevirtual 1450	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokestatic 1453	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   23: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   26: lstore 4
    //   28: aload_0
    //   29: invokestatic 1407	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   32: invokevirtual 1457	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   35: ldc_w 1459
    //   38: ldc_w 1461
    //   41: invokespecial 1463	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   47: lstore 6
    //   49: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +43 -> 95
    //   55: new 123	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   62: astore 8
    //   64: aload 8
    //   66: ldc_w 1465
    //   69: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 8
    //   75: lload 6
    //   77: lload 4
    //   79: lsub
    //   80: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 194
    //   86: iconst_2
    //   87: aload 8
    //   89: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: new 232	java/io/File
    //   98: dup
    //   99: getstatic 1442	com/tencent/mobileqq/apollo/utils/ApolloConstant:a	Ljava/lang/String;
    //   102: ldc_w 1467
    //   105: invokespecial 1447	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: invokevirtual 240	java/io/File:mkdirs	()Z
    //   111: pop
    //   112: invokestatic 1407	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   115: invokevirtual 1457	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   118: astore 8
    //   120: new 123	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   127: astore 9
    //   129: aload 9
    //   131: getstatic 1442	com/tencent/mobileqq/apollo/utils/ApolloConstant:a	Ljava/lang/String;
    //   134: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 9
    //   140: ldc_w 1469
    //   143: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 8
    //   149: ldc_w 1461
    //   152: aload 9
    //   154: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 1474	com/tencent/mobileqq/vas/LzmaUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    //   160: istore_1
    //   161: ldc_w 1461
    //   164: invokestatic 1477	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   167: pop
    //   168: iload_1
    //   169: ifne +60 -> 229
    //   172: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +52 -> 227
    //   178: new 123	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   185: astore 8
    //   187: aload 8
    //   189: ldc_w 1479
    //   192: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 8
    //   198: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   201: lload_2
    //   202: lsub
    //   203: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 8
    //   209: ldc_w 1481
    //   212: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 194
    //   218: iconst_2
    //   219: aload 8
    //   221: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iconst_1
    //   228: ireturn
    //   229: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +52 -> 284
    //   235: new 123	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   242: astore 8
    //   244: aload 8
    //   246: ldc_w 1479
    //   249: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 8
    //   255: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   258: lload_2
    //   259: lsub
    //   260: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 8
    //   266: ldc_w 1481
    //   269: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: ldc 194
    //   275: iconst_2
    //   276: aload 8
    //   278: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: iconst_0
    //   285: ireturn
    //   286: astore 8
    //   288: goto +102 -> 390
    //   291: astore 8
    //   293: new 123	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   300: astore 9
    //   302: aload 9
    //   304: ldc_w 276
    //   307: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 9
    //   313: aload 8
    //   315: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: ldc 194
    //   324: iconst_1
    //   325: aload 9
    //   327: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +52 -> 388
    //   339: new 123	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   346: astore 8
    //   348: aload 8
    //   350: ldc_w 1479
    //   353: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 8
    //   359: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   362: lload_2
    //   363: lsub
    //   364: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 8
    //   370: ldc_w 1481
    //   373: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: ldc 194
    //   379: iconst_2
    //   380: aload 8
    //   382: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: iconst_0
    //   389: ireturn
    //   390: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +52 -> 445
    //   396: new 123	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   403: astore 9
    //   405: aload 9
    //   407: ldc_w 1479
    //   410: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 9
    //   416: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   419: lload_2
    //   420: lsub
    //   421: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 9
    //   427: ldc_w 1481
    //   430: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: ldc 194
    //   436: iconst_2
    //   437: aload 9
    //   439: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload 8
    //   447: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	AbsApolloResManager
    //   160	9	1	n	int
    //   3	417	2	l1	long
    //   26	52	4	l2	long
    //   47	29	6	l3	long
    //   62	215	8	localObject1	Object
    //   286	1	8	localObject2	Object
    //   291	23	8	localException	Exception
    //   346	100	8	localStringBuilder1	StringBuilder
    //   127	311	9	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   23	95	286	finally
    //   95	168	286	finally
    //   293	333	286	finally
    //   23	95	291	java/lang/Exception
    //   95	168	291	java/lang/Exception
  }
  
  private DownloaderInterface k()
  {
    AppInterface localAppInterface = this.i;
    if (localAppInterface == null)
    {
      QLog.e("[cmshow]cm_res", 1, "[getDownloader] error! mApp is null! ");
      return null;
    }
    return ApolloResDownloaderUtil.a(localAppInterface);
  }
  
  private boolean k(int paramInt)
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return false;
    }
    Object localObject = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadIfActionPanelFrameNotExist warning: data is null. call checkApolloPanelJsonVer, id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
      ApolloContentUpdateHandler.a(localQQAppInterface, 1);
      return false;
    }
    if (!e(paramInt, ((ApolloActionData)localObject).personNum)) {
      return a((ApolloActionData)localObject, 4, null);
    }
    return true;
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:b	Lorg/json/JSONObject;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 54	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 55	org/json/JSONObject:<init>	()V
    //   15: putfield 57	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:b	Lorg/json/JSONObject;
    //   18: aconst_null
    //   19: astore 11
    //   21: iload_1
    //   22: iconst_3
    //   23: if_icmpne +11 -> 34
    //   26: ldc_w 1495
    //   29: astore 11
    //   31: goto +26 -> 57
    //   34: iload_1
    //   35: iconst_2
    //   36: if_icmpne +11 -> 47
    //   39: ldc_w 1497
    //   42: astore 11
    //   44: goto +13 -> 57
    //   47: iload_1
    //   48: iconst_1
    //   49: if_icmpne +8 -> 57
    //   52: ldc_w 1499
    //   55: astore 11
    //   57: aload 11
    //   59: ifnonnull +4 -> 63
    //   62: return
    //   63: aload_0
    //   64: getfield 57	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:b	Lorg/json/JSONObject;
    //   67: aload 11
    //   69: invokevirtual 970	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   72: astore 13
    //   74: aload 13
    //   76: astore 12
    //   78: aload 13
    //   80: ifnonnull +12 -> 92
    //   83: new 54	org/json/JSONObject
    //   86: dup
    //   87: invokespecial 55	org/json/JSONObject:<init>	()V
    //   90: astore 12
    //   92: iconst_0
    //   93: istore 6
    //   95: aload_0
    //   96: getfield 57	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:b	Lorg/json/JSONObject;
    //   99: astore 13
    //   101: aload 13
    //   103: monitorenter
    //   104: lconst_0
    //   105: lstore 7
    //   107: aload 12
    //   109: iload_2
    //   110: invokestatic 367	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   113: lconst_0
    //   114: invokevirtual 1502	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   117: lstore 9
    //   119: iload 6
    //   121: istore 5
    //   123: lload 9
    //   125: lstore 7
    //   127: lload 9
    //   129: lload_3
    //   130: lcmp
    //   131: ifeq +66 -> 197
    //   134: lload 9
    //   136: lstore 7
    //   138: aload 12
    //   140: iload_2
    //   141: invokestatic 367	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   144: lload_3
    //   145: invokevirtual 1505	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   148: pop
    //   149: lload 9
    //   151: lstore 7
    //   153: aload_0
    //   154: getfield 57	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:b	Lorg/json/JSONObject;
    //   157: aload 11
    //   159: aload 12
    //   161: invokevirtual 1508	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: iconst_1
    //   166: istore 5
    //   168: lload 9
    //   170: lstore 7
    //   172: goto +25 -> 197
    //   175: astore 11
    //   177: goto +144 -> 321
    //   180: astore 11
    //   182: ldc 194
    //   184: iconst_1
    //   185: aload 11
    //   187: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   190: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload 6
    //   195: istore 5
    //   197: aload 13
    //   199: monitorexit
    //   200: iload 5
    //   202: ifeq +118 -> 320
    //   205: invokestatic 1512	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   208: aload_0
    //   209: getfield 74	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:l	Ljava/lang/Runnable;
    //   212: invokevirtual 1518	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   215: invokestatic 1512	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   218: aload_0
    //   219: getfield 74	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:l	Ljava/lang/Runnable;
    //   222: ldc2_w 1519
    //   225: invokevirtual 1524	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   228: pop
    //   229: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +88 -> 320
    //   235: new 123	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   242: astore 11
    //   244: aload 11
    //   246: ldc_w 1526
    //   249: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 11
    //   255: iload_2
    //   256: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 11
    //   262: ldc_w 1528
    //   265: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 11
    //   271: lload 7
    //   273: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 11
    //   279: ldc_w 1530
    //   282: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 11
    //   288: lload_3
    //   289: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 11
    //   295: ldc_w 1532
    //   298: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 11
    //   304: iload_1
    //   305: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: ldc 194
    //   311: iconst_2
    //   312: aload 11
    //   314: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: return
    //   321: aload 13
    //   323: monitorexit
    //   324: aload 11
    //   326: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	AbsApolloResManager
    //   0	327	1	paramInt1	int
    //   0	327	2	paramInt2	int
    //   0	327	3	paramLong	long
    //   121	80	5	n	int
    //   93	101	6	i1	int
    //   105	167	7	l1	long
    //   117	52	9	l2	long
    //   19	139	11	str	String
    //   175	1	11	localObject	Object
    //   180	6	11	localException	Exception
    //   242	83	11	localStringBuilder	StringBuilder
    //   76	84	12	localJSONObject1	JSONObject
    //   72	250	13	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   107	119	175	finally
    //   138	149	175	finally
    //   153	165	175	finally
    //   182	193	175	finally
    //   197	200	175	finally
    //   321	324	175	finally
    //   107	119	180	java/lang/Exception
    //   138	149	180	java/lang/Exception
    //   153	165	180	java/lang/Exception
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = (IApolloManagerService)this.i.getRuntimeService(IApolloManagerService.class, "all");
        if (((IApolloManagerService)localObject).isApolloSupport(this.i.getApp()))
        {
          int n = ((IApolloManagerService)localObject).getApolloStatus(this.i.getCurrentUin());
          bool = true;
          if (1 == n)
          {
            n = Integer.parseInt(paramString);
            long l1 = g(2, n) / 1000L;
            long l2 = paramInt2;
            if (l1 != l2) {
              a().b(this.i, this.i.getCurrentUin(), null, -1, new int[] { n }, -1, -1, true);
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("appId:");
              ((StringBuilder)localObject).append(paramInt1);
              ((StringBuilder)localObject).append(" version:");
              ((StringBuilder)localObject).append(paramInt2);
              ((StringBuilder)localObject).append(" localVersion:");
              ((StringBuilder)localObject).append(l1);
              ((StringBuilder)localObject).append(" update:");
              if (l2 <= l1) {
                break label269;
              }
              ((StringBuilder)localObject).append(bool);
              QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject).toString());
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo dress real time update id:");
        localStringBuilder.append(paramString);
        QLog.e("[cmshow]cm_res", 2, localStringBuilder.toString(), localException);
      }
      return;
      label269:
      boolean bool = false;
    }
  }
  
  public void a(int paramInt, long paramLong, JSONArray paramJSONArray)
  {
    int n = 0;
    boolean bool = CMResUtil.a(paramJSONArray, false, paramInt, paramLong);
    if (!c(paramInt, 0))
    {
      QLog.i("[cmshow]cm_res", 2, "handleApolloStandAction download res first time.");
      bool = true;
    }
    if (bool)
    {
      Object localObject1 = new ApolloActionData();
      ((ApolloActionData)localObject1).actionId = paramInt;
      paramJSONArray = a((ApolloActionData)localObject1, 5);
      localObject1 = a((ApolloActionData)localObject1, 4);
      Object localObject2 = new File((String)localObject1).getParentFile();
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          int i1 = localObject2.length;
          paramInt = n;
          while (paramInt < i1)
          {
            localObject2[paramInt].delete();
            paramInt += 1;
          }
        }
      }
      a().a(this.i, (String)localObject1, paramJSONArray);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new AbsApolloResManager.9(this, paramBoolean, paramInt), 5, null, false);
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      ApolloExtensionHandler localApolloExtensionHandler = (ApolloExtensionHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      Object localObject2 = (ApolloManagerServiceImpl)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((ApolloManagerServiceImpl)localObject2).getApolloBaseInfo(((StringBuilder)localObject1).toString());
      if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloUpdateTime != 0L))
      {
        if ((((ApolloBaseInfo)localObject1).isApolloStatusOpen()) && (((ApolloBaseInfo)localObject1).apolloServerTS != ((ApolloBaseInfo)localObject1).apolloLocalTS))
        {
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(Long.valueOf(Long.parseLong(paramString1)));
          localObject2 = ((ApolloManagerServiceImpl)localObject2).getApolloBaseInfo(paramAppInterface.getCurrentUin());
          if ((localObject2 != null) && (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS)) {
            localArrayList.add(Long.valueOf(paramAppInterface.getLongAccountUin()));
          }
          localApolloExtensionHandler.a(localArrayList, paramString2);
          if (QLog.isColorLevel())
          {
            if (paramString1.length() >= 4) {
              paramAppInterface = paramString1.substring(0, 4);
            } else {
              paramAppInterface = paramString1;
            }
            paramString2 = new StringBuilder();
            paramString2.append("checkUserDress---> getGetUserApolloDress uin: ");
            paramString2.append(paramAppInterface);
            paramString2.append(", old dress: ");
            paramString2.append(((ApolloBaseInfo)localObject1).getApolloDress());
            QLog.d("[cmshow]cm_res", 2, paramString2.toString());
          }
        }
      }
      else
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append(paramString1);
        paramAppInterface.append("");
        localApolloExtensionHandler.b(paramAppInterface.toString());
        if (QLog.isColorLevel())
        {
          if (paramString1.length() >= 4) {
            paramAppInterface = paramString1.substring(0, 4);
          } else {
            paramAppInterface = paramString1;
          }
          paramString2 = new StringBuilder();
          paramString2.append("checkUserDress---> getApolloBaseInfo uin: ");
          paramString2.append(paramAppInterface);
          QLog.d("[cmshow]cm_res", 2, paramString2.toString());
        }
      }
      if ((QLog.isColorLevel()) && (localObject1 != null) && (!((ApolloBaseInfo)localObject1).isApolloStatusOpen()))
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("checkUserDress---> user apollo status is not open uin: ");
        paramAppInterface.append(paramString1);
        paramAppInterface.append(", status: ");
        paramAppInterface.append(((ApolloBaseInfo)localObject1).apolloStatus);
        QLog.d("[cmshow]cm_res", 2, paramAppInterface.toString());
      }
      if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).isApolloStatusOpen()) && (0L != ((ApolloBaseInfo)localObject1).apolloSignValidTS) && (NetConnInfoCenter.getServerTime() < ((ApolloBaseInfo)localObject1).apolloSignValidTS) && (((ApolloBaseInfo)localObject1).apolloSignValidTS != ((ApolloBaseInfo)localObject1).apolloLocalSignTs))
      {
        localApolloExtensionHandler.c(paramString1, "AIO");
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]cm_res", 2, "getUserSignStr...");
        }
      }
    }
  }
  
  public void a(IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener != null) {}
    try
    {
      if (this.a != null) {
        this.a.a(paramIResDownloadListener);
      }
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    if ((a(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, new AbsApolloResManager.14(this, paramNotifyDressReady, paramQQAppInterface, paramInt, paramArrayOfInt))) && (paramNotifyDressReady != null)) {
      paramNotifyDressReady.a(paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 22);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    if ((a(paramString) ^ true))
    {
      a().a(paramQQAppInterface, paramString, paramOnFaceDataDownloadListener);
      return;
    }
    if (paramOnFaceDataDownloadListener != null) {
      paramOnFaceDataDownloadListener.a(true, 0);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    Object localObject2 = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject1 = localApolloDaoManagerServiceImpl.getApolloBaseInfo(paramString1);
    if (localObject1 != null)
    {
      paramInt = ((ApolloBaseInfo)localObject1).apolloStatus;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin: ");
        localStringBuilder.append(((ApolloBaseInfo)localObject1).uin);
        localStringBuilder.append(", funcSwitch:");
        localStringBuilder.append(paramInt);
        QLog.d("[cmshow]cm_res", 2, localStringBuilder.toString());
      }
      int i1 = 0;
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress(false);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        paramInt = localObject1.length;
        int n = 0;
        while (n < paramInt)
        {
          localStringBuilder = localObject1[n];
          i1 = localStringBuilder.mRoleGender;
          int[] arrayOfInt = localStringBuilder.getDressIds();
          if ((a(paramString1, localStringBuilder.roleId, arrayOfInt, paramQQAppInterface, new AbsApolloResManager.13(this, paramNotifyDressReady, paramQQAppInterface, paramString2, paramString3, localStringBuilder, arrayOfInt))) && (localStringBuilder.roleId != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]cm_res", 2, "valid role and dress RSC.");
            }
            if (paramNotifyDressReady != null) {
              paramNotifyDressReady.a(paramQQAppInterface, paramString1, paramString2, paramString3, localStringBuilder.roleId, arrayOfInt, 3);
            }
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]cm_res", 2, "try to get history dress ....");
          }
          n += 1;
        }
        if (paramNotifyDressReady != null)
        {
          if (i1 == 2) {
            paramInt = 2;
          } else {
            paramInt = 1;
          }
          paramNotifyDressReady.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(paramInt), 1);
        }
        a(paramQQAppInterface, paramString1, "apllo_game");
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("uin: ");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(" dress is null,try to pull player's dress info.");
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
        }
        a(paramQQAppInterface, paramString1, "apllo_game");
        if (paramNotifyDressReady != null) {
          paramNotifyDressReady.a(paramQQAppInterface, paramString1, paramString2, paramString3, 1, ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(1), 1);
        }
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.n(paramString1)))
      {
        paramQQAppInterface = localApolloDaoManagerServiceImpl.getApolloBaseInfo(paramString1);
        long l1;
        if (paramQQAppInterface != null) {
          l1 = paramQQAppInterface.apolloUpdateTime;
        } else {
          l1 = 0L;
        }
        if (NetConnInfoCenter.getServerTime() - l1 > 300L) {
          ((ApolloManagerServiceImpl)localObject2).addToBulkPullMap(paramString1, 2);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject2).toString());
      }
      if (paramNotifyDressReady != null) {
        paramNotifyDressReady.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(paramInt), 1);
      }
      a(paramQQAppInterface, paramString1, "apllo_game");
    }
  }
  
  public void a(String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getApolloUserDressInfo requestUin : ");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramApolloUserDressInfoListener != null) && (this.i != null))
    {
      ThreadManager.getSubThreadHandler().post(new AbsApolloResManager.2(this, paramString, paramApolloUserDressInfoListener));
      return;
    }
    if (paramApolloUserDressInfoListener != null) {
      paramApolloUserDressInfoListener.a(null, "parameter error", -5001);
    }
  }
  
  public void a(List<ApolloBaseInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ThreadManager.getSubThreadHandler().post(new AbsApolloResManager.10(this, paramList));
      return;
    }
    QLog.e("[cmshow]cm_res", 1, "[updateUserDress] error, apolloBaseInfos is empty!");
  }
  
  public void a(List<ApolloActionData> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Bundle localBundle = new Bundle();
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      a(localArrayList, localHashMap, paramList, localBundle);
      if (localBundle.size() == 0) {
        return;
      }
      paramList = new DownloadTask(localArrayList, localHashMap, paramString);
      paramList.J = true;
      paramList.L = "apollo_res";
      paramList.N = true;
      paramList.T = false;
      paramList.Q = true;
      paramList.P = true;
      if (localArrayList.size() == 0)
      {
        QLog.e("[cmshow]cm_res", 1, "downloadResAndPanel taskUrl.size() == 0");
        return;
      }
      if (k() == null) {
        return;
      }
      VipUtils.a(this.i, "cmshow", "Apollo", "action_download_begin", 0, 0, new String[0]);
      k().startDownload(paramList, this.m, localBundle);
    }
  }
  
  public void a(Map<String, ApolloPreDownloadData> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      if (this.i == null)
      {
        QLog.e("[cmshow]cm_res", 1, "[updateAndDownloadPreRes] error! mApp is null! ");
        return;
      }
      try
      {
        ArrayList localArrayList = new ArrayList();
        HashMap localHashMap = new HashMap();
        Bundle localBundle = new Bundle();
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)this.i.getRuntimeService(IApolloDaoManagerService.class, "all");
        Map localMap = localApolloDaoManagerServiceImpl.getPreDownloadRes();
        Iterator localIterator = paramMap.values().iterator();
        while (localIterator.hasNext())
        {
          ApolloPreDownloadData localApolloPreDownloadData = (ApolloPreDownloadData)localIterator.next();
          if ((!TextUtils.isEmpty(localApolloPreDownloadData.resId)) && (!TextUtils.isEmpty(localApolloPreDownloadData.dir)) && (!TextUtils.isEmpty(localApolloPreDownloadData.md5)) && ((localApolloPreDownloadData.endTime <= 0L) || (localApolloPreDownloadData.endTime >= NetConnInfoCenter.getServerTime())))
          {
            Object localObject = (ApolloPreDownloadData)localMap.get(localApolloPreDownloadData.resId);
            if ((localObject != null) && (((ApolloPreDownloadData)localObject).status != 0) && (localApolloPreDownloadData.version <= ((ApolloPreDownloadData)localObject).version))
            {
              localApolloPreDownloadData.status = 1;
            }
            else
            {
              localStringBuilder2.append(localApolloPreDownloadData.reportId);
              localStringBuilder2.append(",ver:");
              localStringBuilder2.append(localApolloPreDownloadData.version);
              localStringBuilder2.append(" | ");
              localArrayList.add(localApolloPreDownloadData.url);
              if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(d(localApolloPreDownloadData.dirType));
                ((StringBuilder)localObject).append(localApolloPreDownloadData.zipDir);
              }
              for (;;)
              {
                localObject = ((StringBuilder)localObject).toString();
                break;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/pre_download/");
                ((StringBuilder)localObject).append(localApolloPreDownloadData.resId);
                ((StringBuilder)localObject).append(".zip");
              }
              localHashMap.put(localApolloPreDownloadData.url, new File((String)localObject));
              localBundle.putSerializable(localApolloPreDownloadData.url, localApolloPreDownloadData);
            }
          }
          else
          {
            localStringBuilder1.append(localApolloPreDownloadData.reportId);
            localStringBuilder1.append(",");
          }
        }
        localApolloDaoManagerServiceImpl.savePreDownloadRes(paramMap, true);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]cm_res", 2, new Object[] { "updateAndDownloadPreRes valid download:", localStringBuilder2.toString(), "\ninvalid config:", localStringBuilder1.toString() });
        }
        if (localArrayList.size() > 0)
        {
          paramMap = new DownloadTask(localArrayList, localHashMap, "apollo_preDownload");
          paramMap.J = true;
          paramMap.L = "apollo_res";
          paramMap.N = true;
          paramMap.T = false;
          paramMap.Q = true;
          paramMap.P = true;
          paramMap.e = 0;
          if (k() != null)
          {
            k().startDownload(paramMap, this.j, localBundle);
            return;
          }
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("[cmshow]cm_res", 1, "updateAndDownloadPreRes e:", paramMap);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.i = ((AppInterface)paramAppRuntime);
    if (ApolloHardWareTester.a(this.i.getApp()))
    {
      this.a = new ApolloListenerManager();
      i();
      ThreadManager.getFileThreadHandler().post(this.k);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    paramAppRuntime = new File(d(paramInt1, paramInt2), "config.json");
    if (!paramAppRuntime.exists()) {
      return;
    }
    try
    {
      paramAppRuntime = new JSONObject(FileUtils.readFileToString(paramAppRuntime));
      a(paramInt1, paramInt2, paramAppRuntime.optLong("version"));
      if (paramInt1 != 1) {
        break label178;
      }
      paramAppRuntime = paramAppRuntime.optJSONArray("dressIds");
      if ((paramAppRuntime == null) || (paramAppRuntime.length() <= 0)) {
        break label178;
      }
      int n = paramAppRuntime.length();
      localObject = new IntArray();
      paramInt1 = 0;
      while (paramInt1 < n)
      {
        ((IntArray)localObject).a(paramAppRuntime.optInt(paramInt1));
        paramInt1 += 1;
      }
      ApolloResHelperImpl.sRoleDefaultDress.put(Integer.valueOf(paramInt2), localObject);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveResTimestamp ex!");
      ((StringBuilder)localObject).append(paramAppRuntime.getMessage());
      QLog.e("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label128:
      break label128;
    }
    QLog.e("[cmshow]cm_res", 1, "saveResTimestamp oom!");
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt, IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getApolloRoleInfo roleId : ");
    localStringBuilder.append(paramInt);
    QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
    if (((paramAppRuntime == null) || (paramInt < 0) || (paramApolloRoleInfoListener == null)) && (paramApolloRoleInfoListener != null)) {
      paramApolloRoleInfoListener.a(null, "parameter error", -5001);
    }
    ThreadManager.getSubThreadHandler().post(new AbsApolloResManager.7(this, paramInt, paramApolloRoleInfoListener, paramAppRuntime));
  }
  
  public void a(AppRuntime paramAppRuntime, ArrayList<Integer> paramArrayList, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener)
  {
    if (((paramAppRuntime == null) || (paramArrayList == null) || (paramArrayList.size() == 0) || (paramApolloDressInfoListener == null)) && (paramApolloDressInfoListener != null)) {
      paramApolloDressInfoListener.a(null, "parameter error", -5001);
    }
    ThreadManager.getSubThreadHandler().post(new AbsApolloResManager.6(this, paramArrayList, paramApolloDressInfoListener, paramAppRuntime));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkApolloPanelJsonCfg begin...");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",task:");
      localStringBuilder.append(paramInt);
      QLog.d("[cmshow]cm_res", 2, localStringBuilder.toString());
    }
    if ((!paramBoolean) && (((paramInt & 0x1) != 1) || (FileUtil.d("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"))))
    {
      ApolloUtilImpl.checkJsonParse(this.i);
      return;
    }
    j(paramInt);
    paramString = new StringBuilder();
    paramString.append("checkApolloPanelJsonCfg download json  forceDownload is: ");
    paramString.append(paramBoolean);
    QLog.d("[cmshow]cm_res", 1, paramString.toString());
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, long paramLong)
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return false;
    }
    if (paramInt1 == 1) {
      return a(paramInt2, paramInt3, paramInt4, paramInt5, paramString, paramLong);
    }
    Object localObject;
    if (paramInt1 == 6)
    {
      if (!f(5, paramInt2))
      {
        paramString = a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(e(paramInt2));
        ((StringBuilder)localObject).append("/d.zip");
        paramString.a(localQQAppInterface, ((StringBuilder)localObject).toString(), f(paramInt2));
        return false;
      }
    }
    else if (paramInt1 == 12)
    {
      if (!c(paramInt2, 0))
      {
        localObject = new ApolloActionData();
        ((ApolloActionData)localObject).actionId = paramInt2;
        paramString = a((ApolloActionData)localObject, 5);
        localObject = a((ApolloActionData)localObject, 4);
        a().a(localQQAppInterface, (String)localObject, paramString);
        return false;
      }
    }
    else if ((paramInt1 != 11) && (paramInt1 != 7))
    {
      if (paramInt1 == 15) {
        return k(paramInt2);
      }
    }
    else
    {
      paramString = ApolloActionHelperImpl.getActionRscPath(paramInt1, paramInt2, 0, true);
      if ((paramString.length > 0) && (!TextUtils.isEmpty(paramString[0])) && (!new File(a(paramString[0], "json")).exists()))
      {
        a().a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    return true;
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt, IResDownloadListener paramIResDownloadListener)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    if (Utils.b())
    {
      if (Utils.c() < 1048576L)
      {
        paramIResDownloadListener = new StringBuilder();
        paramIResDownloadListener.append("1sdcardcheck,sdcard full .return. aid=");
        paramIResDownloadListener.append(paramApolloActionData.actionId);
        QLog.e("[cmshow]cm_res", 1, paramIResDownloadListener.toString());
        return false;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start download action res actionId:");
        ((StringBuilder)localObject1).append(paramApolloActionData.actionId);
        QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2;
      int n;
      if ((paramInt & 0x1) == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start download action panelpic aid=");
          ((StringBuilder)localObject1).append(paramApolloActionData.actionId);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = a(paramApolloActionData, 1);
        localObject2 = a(paramApolloActionData, 0);
        if (!FileUtils.fileExists((String)localObject2))
        {
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).L = "apollo_res";
          ((DownloadTask)localObject1).e = 1;
          ((DownloadTask)localObject1).J = true;
          ((DownloadTask)localObject1).P = true;
          ((DownloadTask)localObject1).Q = true;
          n = DownloaderFactory.a((DownloadTask)localObject1, this.i);
          if (n != 0) {
            return false;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ret:");
            ((StringBuilder)localObject1).append(n);
            QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start download action gif aid=");
          ((StringBuilder)localObject1).append(paramApolloActionData.actionId);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = a(paramApolloActionData, 3);
        localObject2 = a(paramApolloActionData, 2);
        if (!FileUtils.fileExists((String)localObject2))
        {
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).L = "apollo_res";
          ((DownloadTask)localObject1).J = true;
          n = DownloaderFactory.a((DownloadTask)localObject1, this.i);
          if (n != 0) {
            return false;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ret:");
            ((StringBuilder)localObject1).append(n);
            QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      if ((paramInt & 0x4) == 4)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start download action zip actionId:");
          ((StringBuilder)localObject1).append(paramApolloActionData.actionId);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = a(paramApolloActionData, 5);
        localObject2 = a(paramApolloActionData, 4);
        boolean bool2 = c(paramApolloActionData.actionId, paramApolloActionData.personNum);
        boolean bool1 = bool2;
        if (paramApolloActionData.isForPlayerAction == 1) {
          bool1 = bool2 & e(paramApolloActionData.actionId, paramApolloActionData.personNum);
        }
        if (!bool1)
        {
          Object localObject3 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject3).L = "apollo_res";
          ((DownloadTask)localObject3).e = 1;
          ((DownloadTask)localObject3).J = true;
          ((DownloadTask)localObject3).P = true;
          ((DownloadTask)localObject3).Q = true;
          paramInt = DownloaderFactory.a((DownloadTask)localObject3, this.i);
          if (paramInt == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("download actionId:");
          ((StringBuilder)localObject3).append(paramApolloActionData.actionId);
          ((StringBuilder)localObject3).append(", url:");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(", success:");
          ((StringBuilder)localObject3).append(bool1);
          ((StringBuilder)localObject3).append(", ret:");
          ((StringBuilder)localObject3).append(paramInt);
          QLog.d("[cmshow]cm_res", 1, ((StringBuilder)localObject3).toString());
          if (!bool1) {
            return false;
          }
          try
          {
            FileUtils.uncompressZip((String)localObject2, a(paramApolloActionData, 6), false);
            FileUtils.deleteFile((String)localObject2);
            d(paramApolloActionData);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("uncompresszip error");
              ((StringBuilder)localObject2).append(localException.toString());
              QLog.e("[cmshow]cm_res", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      if (paramIResDownloadListener != null)
      {
        if (!c(paramApolloActionData.actionId, paramApolloActionData.personNum))
        {
          if (QLog.isColorLevel()) {
            QLog.e("[cmshow]cm_res", 2, "download finished, but rsc NOT complete.");
          }
          return false;
        }
        paramIResDownloadListener.b(paramApolloActionData);
      }
      return true;
    }
    paramIResDownloadListener = new StringBuilder();
    paramIResDownloadListener.append("1sdcardcheck,has sdcard FALSE .return. aid=");
    paramIResDownloadListener.append(paramApolloActionData.actionId);
    QLog.e("[cmshow]cm_res", 1, paramIResDownloadListener.toString());
    return false;
  }
  
  public boolean a(String paramString, int paramInt, QQAppInterface paramQQAppInterface, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener)
  {
    Object localObject1 = paramString;
    String str = LogUtil.wrapLogUin(paramString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkRoleDress, uin:");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(", model:");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.i("[cmshow]cm_res", 1, ((StringBuilder)localObject2).toString());
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = ((IApolloDaoManagerService)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo((String)localObject1);
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("[checkRoleDress] apolloBaseInfo is null, uin:");
        paramString.append(str);
        QLog.e("[cmshow]cm_res", 1, paramString.toString());
        return false;
      }
      if (paramString.apolloLocalTS != paramString.apolloServerTS)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkRoleDress, dress changed, uin:");
        ((StringBuilder)localObject2).append(str);
        QLog.i("[cmshow]cm_res", 1, ((StringBuilder)localObject2).toString());
        a(paramQQAppInterface, (String)localObject1, "checkRoleDress");
      }
      if (2 == paramInt) {
        paramString = paramString.getApolloDress3D();
      } else {
        paramString = paramString.getApolloDress();
      }
      int n;
      if (paramString != null)
      {
        localObject2 = paramString.getDressIds();
        n = paramString.roleId;
        paramString = (String)localObject2;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("checkRoleDress, get null dressId list from apolloBaseInfo for uin:");
        paramString.append(str);
        paramString.append(", model:");
        paramString.append(paramInt);
        QLog.e("[cmshow]cm_res", 1, paramString.toString());
        n = 0;
        paramString = null;
      }
      if (paramString == null)
      {
        if (2 == paramInt)
        {
          n = 3000055;
          paramString = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(3000055);
        }
        else
        {
          localObject2 = localObject1;
          if (!"-1".equals(localObject1))
          {
            paramString = "-2";
            if ("-2".equals(localObject1))
            {
              localObject2 = localObject1;
            }
            else
            {
              if (!((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(paramQQAppInterface, (String)localObject1)) {
                paramString = "-1";
              }
              localObject2 = paramString;
            }
          }
          if ("-1".equals(localObject2)) {
            n = 1;
          } else {
            n = 2;
          }
          paramString = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(n);
          localObject1 = localObject2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkRoleDress, get default dress for uin:");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(", model:");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.e("[cmshow]cm_res", 1, ((StringBuilder)localObject2).toString());
      }
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("checkRoleDress, no dressId list, uin:");
        paramString.append(str);
        paramString.append(", model:");
        paramString.append(paramInt);
        QLog.e("[cmshow]cm_res", 1, paramString.toString());
        return false;
      }
      boolean bool = a((String)localObject1, n, paramString, paramQQAppInterface, paramOnApolloDownLoadListener);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkRoleDress, uin:");
      paramQQAppInterface.append(str);
      paramQQAppInterface.append(", model:");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append(", allDressReady:");
      paramQQAppInterface.append(bool);
      paramQQAppInterface.append(", finalCheckDressIds:");
      paramQQAppInterface.append(paramString);
      QLog.i("[cmshow]cm_res", 1, paramQQAppInterface.toString());
      return bool;
    }
    paramString = new StringBuilder();
    paramString.append("checkRoleDress fail, uin:");
    paramString.append(str);
    paramString.append(", app:");
    paramString.append(paramQQAppInterface);
    QLog.e("[cmshow]cm_res", 1, paramString.toString());
    return false;
  }
  
  public boolean a(String paramString, int paramInt, int[] paramArrayOfInt, AppRuntime paramAppRuntime)
  {
    return a(paramString, paramInt, paramArrayOfInt, paramAppRuntime, null);
  }
  
  public boolean a(String paramString, int paramInt, int[] paramArrayOfInt, AppRuntime paramAppRuntime, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isRscValid], roleId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",dressId:");
      ((StringBuilder)localObject).append(paramArrayOfInt);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = 0;
    if (paramArrayOfInt == null) {
      return false;
    }
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder;
    boolean bool;
    if (!b(paramInt))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("need download role id:");
        localStringBuilder.append(paramInt);
        QLog.d("[cmshow]cm_res", 2, localStringBuilder.toString());
      }
      bool = false;
    }
    else
    {
      bool = true;
      paramInt = -1;
    }
    int n = 0;
    while (n < paramArrayOfInt.length)
    {
      if (!a(paramArrayOfInt[n]))
      {
        localArrayList.add(Integer.valueOf(paramArrayOfInt[n]));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("need download dress id:");
          localStringBuilder.append(paramArrayOfInt[n]);
          QLog.d("[cmshow]cm_res", 2, localStringBuilder.toString());
        }
        bool = false;
      }
      n += 1;
    }
    if (!bool)
    {
      paramArrayOfInt = (int[])localObject;
      if (localArrayList.size() > 0)
      {
        localObject = new int[localArrayList.size()];
        n = i1;
        for (;;)
        {
          paramArrayOfInt = (int[])localObject;
          if (n >= localArrayList.size()) {
            break;
          }
          localObject[n] = ((Integer)localArrayList.get(n)).intValue();
          n += 1;
        }
      }
      if (paramAppRuntime != null)
      {
        if (paramOnApolloDownLoadListener == null) {
          paramOnApolloDownLoadListener = g();
        }
        a().a(paramAppRuntime, paramString, paramOnApolloDownLoadListener, paramInt, paramArrayOfInt, -1, -1, false);
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("ret:");
      paramString.append(bool);
      QLog.d("[cmshow]cm_res", 2, paramString.toString());
    }
    return bool;
  }
  
  public File b(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    if ((paramInt & 0x1) == 1) {
      paramApolloActionData = b(paramApolloActionData);
    } else if ((paramInt & 0x2) == 2) {
      paramApolloActionData = a(paramApolloActionData, 2);
    } else {
      paramApolloActionData = "";
    }
    return new File(paramApolloActionData);
  }
  
  public String b(ApolloActionData paramApolloActionData)
  {
    if (ApolloActionHelperImpl.isPlayerAction(paramApolloActionData))
    {
      String str = a(paramApolloActionData, 10);
      if (new File(str).exists()) {
        return str;
      }
    }
    return a(paramApolloActionData, 0);
  }
  
  public void b()
  {
    ApolloListenerManager localApolloListenerManager = this.a;
    if (localApolloListenerManager != null) {
      localApolloListenerManager.a();
    }
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      try
      {
        int n = Integer.parseInt(paramString);
        long l1 = g(1, n) / 1000L;
        long l2 = paramInt2;
        if (l1 == l2) {
          break label171;
        }
        a().a(this.i, this.i.getCurrentAccountUin(), null, n, null, -1, -1, true);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("appId:");
          paramString.append(paramInt1);
          paramString.append(" version:");
          paramString.append(paramInt2);
          paramString.append(" roleLocalVersion:");
          paramString.append(l1);
          paramString.append(" update:");
          if (l2 <= l1) {
            break label174;
          }
          bool = true;
          paramString.append(bool);
          QLog.d("[cmshow]cm_res", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]cm_res", 1, paramString, new Object[0]);
      }
      return;
      label171:
      continue;
      label174:
      boolean bool = false;
    }
  }
  
  public void b(IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener != null)
    {
      ApolloListenerManager localApolloListenerManager = this.a;
      if (localApolloListenerManager != null) {
        localApolloListenerManager.b(paramIResDownloadListener);
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    int i1 = 1;
    StringBuilder localStringBuilder;
    int n;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("role id is 0, uin:");
      localStringBuilder.append(LogUtil.wrapLogUin(paramString));
      QLog.i("[cmshow]cm_res", 1, localStringBuilder.toString());
      n = i1;
    }
    else
    {
      n = 0;
      while (n < paramArrayOfInt.length)
      {
        if (!a(paramArrayOfInt[n]))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("dress rsc NOT exist, id:");
          localStringBuilder.append(paramArrayOfInt[n]);
          QLog.w("[cmshow]cm_res", 2, localStringBuilder.toString());
          n = i1;
          break label141;
        }
        n += 1;
      }
      n = 0;
    }
    label141:
    if (n != 0)
    {
      a(paramQQAppInterface, paramString, "", 0, "", paramNotifyDressReady);
      return;
    }
    if (paramNotifyDressReady != null) {
      paramNotifyDressReady.a(paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
    }
  }
  
  public void c(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = this.i;
    if (localObject == null)
    {
      QLog.d("[cmshow]cm_res", 2, "[handlePushUpdateBaseRes] error, mApp is null!");
      return;
    }
    localObject = (ApolloContentUpdateHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
    if (!TextUtils.equals(((ApolloContentUpdateHandler)localObject).a(), paramString)) {
      return;
    }
    paramString = new File(ApolloConstant.V);
    boolean bool2 = paramString.exists();
    boolean bool1 = false;
    if (!bool2) {}
    while ((paramString.list() == null) || (paramString.list().length == 0))
    {
      n = 1;
      break;
    }
    int n = 0;
    int i1 = (int)((ApolloContentUpdateHandler)localObject).h();
    if (paramInt2 > i1) {
      n = 1;
    } else {
      QLog.e("[cmshow]cm_res", 1, "onReceiveApolloPush not newVersion < localVersion");
    }
    paramString = new StringBuilder();
    paramString.append(ApolloConstant.V);
    paramString.append("base.zip");
    paramString = paramString.toString();
    if (n != 0)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("version", paramInt2);
      a().a(this.i, paramString, ApolloConstant.T, (Bundle)localObject, new ApolloContentUpdateHandler.ApolloDownloadListener());
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("appId:");
      paramString.append(paramInt1);
      paramString.append(" version:");
      paramString.append(paramInt2);
      paramString.append(" localVersion:");
      paramString.append(i1);
      paramString.append(" update:");
      if (paramInt2 > i1) {
        bool1 = true;
      }
      paramString.append(bool1);
      QLog.d("[cmshow]cm_res", 2, paramString.toString());
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    int i2 = 0;
    int n = 0;
    int i1;
    for (;;)
    {
      i1 = i2;
      if (n >= paramArrayOfInt.length) {
        break;
      }
      if (!a(paramArrayOfInt[n]))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkThreeDressRsc rsc NOT exist, id:");
        localStringBuilder.append(paramArrayOfInt[n]);
        QLog.w("[cmshow]cm_res", 2, localStringBuilder.toString());
        i1 = 1;
        break;
      }
      n += 1;
    }
    if (i1 != 0)
    {
      a(paramQQAppInterface, paramString, paramInt, paramArrayOfInt, paramNotifyDressReady);
      return;
    }
    if (paramNotifyDressReady != null) {
      paramNotifyDressReady.a(paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 10
    //   3: ldc_w 2103
    //   6: astore 19
    //   8: ldc_w 2105
    //   11: astore 9
    //   13: aload 10
    //   15: getfield 340	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:i	Lcom/tencent/common/app/AppInterface;
    //   18: astore 16
    //   20: ldc 194
    //   22: astore 8
    //   24: aload 16
    //   26: ifnonnull +14 -> 40
    //   29: ldc 194
    //   31: iconst_2
    //   32: ldc_w 2107
    //   35: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: iconst_0
    //   39: ireturn
    //   40: aload 10
    //   42: getfield 52	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   45: invokevirtual 2109	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   48: iconst_1
    //   49: if_icmpne +20 -> 69
    //   52: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +12 -> 67
    //   58: ldc 194
    //   60: iconst_2
    //   61: ldc_w 2111
    //   64: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: iconst_1
    //   68: ireturn
    //   69: aload 10
    //   71: getfield 52	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: invokevirtual 2114	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   78: aconst_null
    //   79: astore 15
    //   81: new 108	java/util/ArrayList
    //   84: dup
    //   85: invokespecial 155	java/util/ArrayList:<init>	()V
    //   88: astore 18
    //   90: new 108	java/util/ArrayList
    //   93: dup
    //   94: invokespecial 155	java/util/ArrayList:<init>	()V
    //   97: astore 12
    //   99: new 108	java/util/ArrayList
    //   102: dup
    //   103: invokespecial 155	java/util/ArrayList:<init>	()V
    //   106: astore 23
    //   108: new 108	java/util/ArrayList
    //   111: dup
    //   112: invokespecial 155	java/util/ArrayList:<init>	()V
    //   115: astore 17
    //   117: new 108	java/util/ArrayList
    //   120: dup
    //   121: invokespecial 155	java/util/ArrayList:<init>	()V
    //   124: astore 24
    //   126: new 108	java/util/ArrayList
    //   129: dup
    //   130: invokespecial 155	java/util/ArrayList:<init>	()V
    //   133: astore 25
    //   135: new 108	java/util/ArrayList
    //   138: dup
    //   139: invokespecial 155	java/util/ArrayList:<init>	()V
    //   142: astore 26
    //   144: new 232	java/io/File
    //   147: dup
    //   148: ldc_w 1908
    //   151: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   154: invokestatic 524	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   157: astore 11
    //   159: aload 11
    //   161: astore 15
    //   163: goto +45 -> 208
    //   166: astore 11
    //   168: new 123	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   175: astore 13
    //   177: aload 13
    //   179: ldc_w 2116
    //   182: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 13
    //   188: aload 11
    //   190: invokevirtual 2117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   193: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 194
    //   199: iconst_1
    //   200: aload 13
    //   202: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: new 123	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   215: astore 11
    //   217: aload 11
    //   219: ldc_w 2119
    //   222: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 15
    //   228: ifnonnull +8 -> 236
    //   231: iconst_0
    //   232: istore_1
    //   233: goto +9 -> 242
    //   236: aload 15
    //   238: invokevirtual 1600	java/lang/String:length	()I
    //   241: istore_1
    //   242: aload 11
    //   244: iload_1
    //   245: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 11
    //   251: ldc_w 2121
    //   254: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 194
    //   260: iconst_1
    //   261: aload 11
    //   263: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 954	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload 15
    //   271: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   274: ifeq +14 -> 288
    //   277: aload 10
    //   279: getfield 52	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   282: iconst_0
    //   283: invokevirtual 2114	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   286: iconst_0
    //   287: ireturn
    //   288: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   291: lstore 5
    //   293: aload 16
    //   295: ldc_w 455
    //   298: ldc_w 426
    //   301: invokevirtual 570	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   304: checkcast 457	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   307: astore 22
    //   309: aload 8
    //   311: astore 13
    //   313: aload 9
    //   315: astore 10
    //   317: aload 8
    //   319: astore 14
    //   321: aload 9
    //   323: astore 11
    //   325: aload 22
    //   327: getfield 1377	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mUserActionId	Ljava/util/HashMap;
    //   330: ifnull +1395 -> 1725
    //   333: aload 8
    //   335: astore 13
    //   337: aload 9
    //   339: astore 10
    //   341: aload 8
    //   343: astore 14
    //   345: aload 9
    //   347: astore 11
    //   349: aload 22
    //   351: getfield 1377	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mUserActionId	Ljava/util/HashMap;
    //   354: invokevirtual 2122	java/util/HashMap:size	()I
    //   357: ifle +1368 -> 1725
    //   360: iconst_1
    //   361: istore_1
    //   362: goto +3 -> 365
    //   365: aload 8
    //   367: astore 13
    //   369: aload 9
    //   371: astore 10
    //   373: aload 8
    //   375: astore 14
    //   377: aload 9
    //   379: astore 11
    //   381: new 54	org/json/JSONObject
    //   384: dup
    //   385: aload 15
    //   387: invokespecial 388	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   390: astore 21
    //   392: aload 8
    //   394: astore 13
    //   396: aload 9
    //   398: astore 10
    //   400: aload 8
    //   402: astore 14
    //   404: aload 9
    //   406: astore 11
    //   408: aload 21
    //   410: ldc_w 2124
    //   413: invokevirtual 165	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   416: astore 20
    //   418: iconst_0
    //   419: istore_2
    //   420: aload 16
    //   422: astore 15
    //   424: aload 21
    //   426: astore 16
    //   428: aload 8
    //   430: astore 13
    //   432: aload 9
    //   434: astore 10
    //   436: aload 8
    //   438: astore 14
    //   440: aload 9
    //   442: astore 11
    //   444: aload 20
    //   446: invokevirtual 171	org/json/JSONArray:length	()I
    //   449: istore_3
    //   450: iload_2
    //   451: iload_3
    //   452: if_icmpge +111 -> 563
    //   455: aload 20
    //   457: iload_2
    //   458: invokevirtual 1121	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   461: astore 11
    //   463: aload 16
    //   465: aload 11
    //   467: invokevirtual 970	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   470: astore 10
    //   472: ldc_w 2126
    //   475: aload 11
    //   477: invokevirtual 2009	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   480: istore 7
    //   482: iload 7
    //   484: ifeq +20 -> 504
    //   487: aload_0
    //   488: aload 18
    //   490: aload 12
    //   492: aload 23
    //   494: aload 24
    //   496: aload 10
    //   498: invokespecial 2128	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:a	(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lorg/json/JSONObject;)V
    //   501: goto +12 -> 513
    //   504: ldc_w 2130
    //   507: aload 11
    //   509: invokevirtual 2009	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   512: pop
    //   513: aload 8
    //   515: astore 10
    //   517: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +1210 -> 1730
    //   523: new 123	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   530: astore 13
    //   532: aload 13
    //   534: ldc_w 2132
    //   537: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 13
    //   543: aload 11
    //   545: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 10
    //   551: iconst_2
    //   552: aload 13
    //   554: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: goto +1170 -> 1730
    //   563: aload 9
    //   565: astore 13
    //   567: aload 8
    //   569: astore 10
    //   571: aload 16
    //   573: ldc_w 2134
    //   576: invokevirtual 970	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   579: pop
    //   580: aload 16
    //   582: ldc_w 2136
    //   585: invokevirtual 161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   588: ifeq +82 -> 670
    //   591: aload 10
    //   593: iconst_1
    //   594: ldc_w 2138
    //   597: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: aload 16
    //   602: ldc_w 2136
    //   605: invokevirtual 970	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   608: astore 11
    //   610: aload 11
    //   612: ldc_w 2126
    //   615: invokevirtual 161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   618: ifeq +23 -> 641
    //   621: aload_0
    //   622: aload 18
    //   624: aload 12
    //   626: aload 23
    //   628: aload 24
    //   630: aload 11
    //   632: ldc_w 2126
    //   635: invokevirtual 970	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   638: invokespecial 2128	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:a	(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lorg/json/JSONObject;)V
    //   641: aload 11
    //   643: ldc_w 2140
    //   646: invokevirtual 161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   649: pop
    //   650: aload 11
    //   652: ldc_w 2134
    //   655: invokevirtual 161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   658: ifeq +12 -> 670
    //   661: aload 11
    //   663: ldc_w 2134
    //   666: invokevirtual 970	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   669: pop
    //   670: aload 16
    //   672: ldc_w 2142
    //   675: invokevirtual 161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   678: ifeq +1115 -> 1793
    //   681: aload 16
    //   683: ldc_w 2142
    //   686: invokevirtual 970	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   689: astore 11
    //   691: aload_0
    //   692: aload 11
    //   694: aload 17
    //   696: invokespecial 2144	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:a	(Lorg/json/JSONObject;Ljava/util/List;)V
    //   699: goto +3 -> 702
    //   702: aload_0
    //   703: astore 11
    //   705: aload 16
    //   707: aload 19
    //   709: invokevirtual 161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   712: ifeq +1090 -> 1802
    //   715: aload 16
    //   717: aload 19
    //   719: invokevirtual 970	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   722: astore 14
    //   724: aload 14
    //   726: ifnull +1070 -> 1796
    //   729: aload 14
    //   731: ldc_w 2146
    //   734: invokevirtual 161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   737: ifeq +1059 -> 1796
    //   740: aload 10
    //   742: iconst_1
    //   743: ldc_w 2148
    //   746: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: aload 11
    //   751: aload 26
    //   753: aload 14
    //   755: ldc_w 2146
    //   758: invokevirtual 186	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   761: invokespecial 2150	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:a	(Ljava/util/List;Lorg/json/JSONArray;)V
    //   764: goto +3 -> 767
    //   767: aload 14
    //   769: ifnull +1030 -> 1799
    //   772: aload 14
    //   774: ldc_w 2152
    //   777: invokevirtual 161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   780: ifeq +1019 -> 1799
    //   783: aload 14
    //   785: ldc_w 2152
    //   788: invokevirtual 186	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   791: astore 14
    //   793: aload 14
    //   795: ifnull +1004 -> 1799
    //   798: aload 11
    //   800: aload 14
    //   802: aload 25
    //   804: invokespecial 2154	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:a	(Lorg/json/JSONArray;Ljava/util/List;)V
    //   807: goto +3 -> 810
    //   810: aload 15
    //   812: ldc_w 425
    //   815: ldc_w 426
    //   818: invokevirtual 570	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   821: checkcast 432	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   824: astore 14
    //   826: aload 14
    //   828: iconst_0
    //   829: aload 17
    //   831: invokevirtual 2158	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveWhiteFaceIdMapping	(ZLjava/util/List;)V
    //   834: aload 14
    //   836: invokevirtual 2161	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removeAllAction	()V
    //   839: aload 14
    //   841: aload 18
    //   843: invokevirtual 2164	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveAction	(Ljava/util/List;)V
    //   846: aload 14
    //   848: iconst_1
    //   849: invokevirtual 2167	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removePackageInfo	(I)V
    //   852: aload 14
    //   854: aload 12
    //   856: invokevirtual 2170	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:savePackageInfo	(Ljava/util/List;)V
    //   859: aload 14
    //   861: invokevirtual 2173	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removeAllPackageData	()V
    //   864: aload 14
    //   866: aload 23
    //   868: invokevirtual 2176	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveActionPackageInfo	(Ljava/util/List;)V
    //   871: aload 14
    //   873: invokevirtual 2179	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removeAllActionTag	()V
    //   876: aload 14
    //   878: aload 24
    //   880: invokevirtual 2182	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveActionTag	(Ljava/util/List;)V
    //   883: aload 14
    //   885: aload 26
    //   887: invokevirtual 2185	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveCommConfigTableKvMap	(Ljava/util/List;)V
    //   890: aload 14
    //   892: invokevirtual 2188	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removeAllRelationTag	()V
    //   895: aload 14
    //   897: aload 25
    //   899: invokevirtual 2191	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveRelationTag	(Ljava/util/List;)V
    //   902: iload_1
    //   903: ifne +49 -> 952
    //   906: getstatic 2194	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:sFirstOpenPanel	Z
    //   909: ifne +43 -> 952
    //   912: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   915: ifeq +12 -> 927
    //   918: aload 10
    //   920: iconst_1
    //   921: ldc_w 2196
    //   924: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: aload 15
    //   929: getstatic 296	com/tencent/mobileqq/app/BusinessHandlerFactory:APOLLO_EXTENSION_HANDLER	Ljava/lang/String;
    //   932: invokevirtual 302	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   935: checkcast 304	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler
    //   938: aload 15
    //   940: invokevirtual 1539	com/tencent/common/app/AppInterface:getCurrentUin	()Ljava/lang/String;
    //   943: ldc2_w 2197
    //   946: ldc_w 2200
    //   949: invokevirtual 2203	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:a	(Ljava/lang/String;JLjava/lang/String;)V
    //   952: aload 11
    //   954: getfield 1636	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:a	Lcom/tencent/mobileqq/apollo/utils/ApolloListenerManager;
    //   957: iconst_1
    //   958: invokestatic 2208	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   961: invokevirtual 2211	com/tencent/mobileqq/apollo/utils/ApolloListenerManager:a	(Ljava/lang/Boolean;)V
    //   964: aload_0
    //   965: invokevirtual 2213	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:e	()V
    //   968: aload 15
    //   970: ifnull +281 -> 1251
    //   973: aload 15
    //   975: invokevirtual 2216	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   978: aload 15
    //   980: invokevirtual 2049	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   983: iconst_0
    //   984: invokevirtual 2219	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   987: invokeinterface 2223 1 0
    //   992: astore 8
    //   994: new 123	java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1001: astore 9
    //   1003: aload 9
    //   1005: ldc_w 2225
    //   1008: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: aload 9
    //   1014: aload 15
    //   1016: invokevirtual 2049	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1019: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: pop
    //   1023: aload 8
    //   1025: aload 9
    //   1027: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: iconst_1
    //   1031: invokeinterface 2231 3 0
    //   1036: invokeinterface 2234 1 0
    //   1041: pop
    //   1042: aload 15
    //   1044: invokevirtual 2216	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1047: ldc_w 348
    //   1050: iconst_0
    //   1051: invokevirtual 2219	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1054: astore 8
    //   1056: new 123	java/lang/StringBuilder
    //   1059: dup
    //   1060: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1063: astore 9
    //   1065: aload 9
    //   1067: ldc_w 1147
    //   1070: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload 9
    //   1076: aload 15
    //   1078: invokevirtual 2049	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1081: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload 8
    //   1087: aload 9
    //   1089: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: iconst_0
    //   1093: invokeinterface 2238 3 0
    //   1098: ifne +60 -> 1158
    //   1101: aload 8
    //   1103: invokeinterface 2223 1 0
    //   1108: astore 9
    //   1110: new 123	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1117: astore 12
    //   1119: aload 12
    //   1121: ldc_w 1147
    //   1124: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload 12
    //   1130: aload 15
    //   1132: invokevirtual 2049	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1135: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: pop
    //   1139: aload 9
    //   1141: aload 12
    //   1143: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: iconst_1
    //   1147: invokeinterface 2231 3 0
    //   1152: invokeinterface 2234 1 0
    //   1157: pop
    //   1158: aload 16
    //   1160: ldc_w 2240
    //   1163: invokevirtual 1240	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1166: ldc2_w 95
    //   1169: ldiv
    //   1170: l2i
    //   1171: istore_1
    //   1172: aload 8
    //   1174: invokeinterface 2223 1 0
    //   1179: astore 9
    //   1181: new 123	java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1188: astore 12
    //   1190: aload 12
    //   1192: ldc_w 2242
    //   1195: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload 12
    //   1201: aload 15
    //   1203: invokevirtual 2049	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1206: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: aload 9
    //   1212: aload 12
    //   1214: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: iload_1
    //   1218: invokeinterface 2246 3 0
    //   1223: invokeinterface 2234 1 0
    //   1228: pop
    //   1229: aload 8
    //   1231: invokeinterface 2223 1 0
    //   1236: ldc_w 2242
    //   1239: iload_1
    //   1240: invokeinterface 2246 3 0
    //   1245: invokeinterface 2234 1 0
    //   1250: pop
    //   1251: aload 16
    //   1253: ldc_w 2248
    //   1256: invokevirtual 186	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1259: astore 8
    //   1261: aload 8
    //   1263: ifnull +118 -> 1381
    //   1266: aload 15
    //   1268: ifnull +113 -> 1381
    //   1271: aload 15
    //   1273: invokevirtual 2216	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1276: ldc_w 2250
    //   1279: iconst_0
    //   1280: invokevirtual 2219	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1283: invokeinterface 2223 1 0
    //   1288: ldc_w 2252
    //   1291: aload 8
    //   1293: invokevirtual 834	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1296: invokeinterface 2256 3 0
    //   1301: invokeinterface 2234 1 0
    //   1306: pop
    //   1307: aload 22
    //   1309: aload 8
    //   1311: invokevirtual 834	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1314: putfield 2259	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPetConfig	Ljava/lang/String;
    //   1317: aload 8
    //   1319: invokevirtual 171	org/json/JSONArray:length	()I
    //   1322: istore_2
    //   1323: iconst_0
    //   1324: istore_1
    //   1325: iload_1
    //   1326: iload_2
    //   1327: if_icmpge +54 -> 1381
    //   1330: aload 8
    //   1332: iload_1
    //   1333: invokevirtual 175	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1336: astore 9
    //   1338: aload 9
    //   1340: ldc_w 2261
    //   1343: iconst_0
    //   1344: invokevirtual 1357	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1347: istore_3
    //   1348: aload 9
    //   1350: ldc_w 2263
    //   1353: iconst_0
    //   1354: invokevirtual 1357	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1357: istore 4
    //   1359: aload 11
    //   1361: iload_3
    //   1362: iconst_0
    //   1363: invokespecial 2265	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:h	(II)V
    //   1366: aload 11
    //   1368: iload 4
    //   1370: iconst_0
    //   1371: invokespecial 2265	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:h	(II)V
    //   1374: iload_1
    //   1375: iconst_1
    //   1376: iadd
    //   1377: istore_1
    //   1378: goto -53 -> 1325
    //   1381: aload 15
    //   1383: ifnull +7 -> 1390
    //   1386: aload_0
    //   1387: invokevirtual 2267	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:d	()V
    //   1390: aload 11
    //   1392: getfield 52	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1395: iconst_0
    //   1396: invokevirtual 2114	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1399: new 123	java/lang/StringBuilder
    //   1402: dup
    //   1403: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1406: astore 8
    //   1408: aload 8
    //   1410: aload 13
    //   1412: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: pop
    //   1416: aload 8
    //   1418: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   1421: lload 5
    //   1423: lsub
    //   1424: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: goto +189 -> 1617
    //   1431: astore 8
    //   1433: aload 11
    //   1435: astore 12
    //   1437: goto +221 -> 1658
    //   1440: astore 8
    //   1442: aload 13
    //   1444: astore 9
    //   1446: goto +122 -> 1568
    //   1449: astore 10
    //   1451: goto +10 -> 1461
    //   1454: astore 10
    //   1456: goto +33 -> 1489
    //   1459: astore 10
    //   1461: aload 8
    //   1463: astore 12
    //   1465: aload_0
    //   1466: astore 11
    //   1468: aload 10
    //   1470: astore 8
    //   1472: aload 11
    //   1474: astore 10
    //   1476: aload 9
    //   1478: astore 11
    //   1480: aload 12
    //   1482: astore 9
    //   1484: goto +36 -> 1520
    //   1487: astore 10
    //   1489: aload 8
    //   1491: astore 13
    //   1493: aload_0
    //   1494: astore 11
    //   1496: aload 10
    //   1498: astore 8
    //   1500: aload 9
    //   1502: astore 12
    //   1504: goto +56 -> 1560
    //   1507: astore 8
    //   1509: aload 13
    //   1511: astore 9
    //   1513: aload 10
    //   1515: astore 11
    //   1517: aload_0
    //   1518: astore 10
    //   1520: aload 10
    //   1522: astore 12
    //   1524: aload 11
    //   1526: astore 13
    //   1528: aload 9
    //   1530: astore 10
    //   1532: goto +126 -> 1658
    //   1535: astore 8
    //   1537: aload 11
    //   1539: astore 10
    //   1541: aload_0
    //   1542: astore 9
    //   1544: aload 14
    //   1546: astore 11
    //   1548: aload 11
    //   1550: astore 13
    //   1552: aload 10
    //   1554: astore 12
    //   1556: aload 9
    //   1558: astore 11
    //   1560: aload 13
    //   1562: astore 10
    //   1564: aload 12
    //   1566: astore 9
    //   1568: aload 10
    //   1570: iconst_1
    //   1571: ldc_w 2269
    //   1574: aload 8
    //   1576: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1579: aload 11
    //   1581: getfield 52	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1584: iconst_0
    //   1585: invokevirtual 2114	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1588: new 123	java/lang/StringBuilder
    //   1591: dup
    //   1592: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1595: astore 8
    //   1597: aload 8
    //   1599: aload 9
    //   1601: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: pop
    //   1605: aload 8
    //   1607: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   1610: lload 5
    //   1612: lsub
    //   1613: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1616: pop
    //   1617: aload 8
    //   1619: ldc_w 2271
    //   1622: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: pop
    //   1626: aload 10
    //   1628: iconst_1
    //   1629: aload 8
    //   1631: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1634: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1637: aload 11
    //   1639: getfield 52	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1642: iconst_0
    //   1643: invokevirtual 2114	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1646: iconst_1
    //   1647: ireturn
    //   1648: astore 8
    //   1650: aload 9
    //   1652: astore 13
    //   1654: aload 11
    //   1656: astore 12
    //   1658: aload 12
    //   1660: getfield 52	com/tencent/mobileqq/cmshow/engine/resource/AbsApolloResManager:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1663: iconst_0
    //   1664: invokevirtual 2114	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1667: new 123	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1674: astore 9
    //   1676: aload 9
    //   1678: aload 13
    //   1680: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: pop
    //   1684: aload 9
    //   1686: invokestatic 943	java/lang/System:currentTimeMillis	()J
    //   1689: lload 5
    //   1691: lsub
    //   1692: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1695: pop
    //   1696: aload 9
    //   1698: ldc_w 2271
    //   1701: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: pop
    //   1705: aload 10
    //   1707: iconst_1
    //   1708: aload 9
    //   1710: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1713: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1716: goto +6 -> 1722
    //   1719: aload 8
    //   1721: athrow
    //   1722: goto -3 -> 1719
    //   1725: iconst_0
    //   1726: istore_1
    //   1727: goto -1362 -> 365
    //   1730: iload_2
    //   1731: iconst_1
    //   1732: iadd
    //   1733: istore_2
    //   1734: aload 10
    //   1736: astore 8
    //   1738: goto -1310 -> 428
    //   1741: astore 11
    //   1743: aload 8
    //   1745: astore 12
    //   1747: aload_0
    //   1748: astore 10
    //   1750: aload 11
    //   1752: astore 8
    //   1754: aload 9
    //   1756: astore 11
    //   1758: aload 12
    //   1760: astore 9
    //   1762: goto -242 -> 1520
    //   1765: astore 13
    //   1767: aload 8
    //   1769: astore 11
    //   1771: aload_0
    //   1772: astore 10
    //   1774: aload 9
    //   1776: astore 12
    //   1778: aload 13
    //   1780: astore 8
    //   1782: aload 10
    //   1784: astore 9
    //   1786: aload 12
    //   1788: astore 10
    //   1790: goto -242 -> 1548
    //   1793: goto -1091 -> 702
    //   1796: goto -1029 -> 767
    //   1799: goto -989 -> 810
    //   1802: goto -992 -> 810
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1805	0	this	AbsApolloResManager
    //   232	1495	1	n	int
    //   419	1315	2	i1	int
    //   449	913	3	i2	int
    //   1357	12	4	i3	int
    //   291	1399	5	l1	long
    //   480	3	7	bool	boolean
    //   22	1395	8	localObject1	Object
    //   1431	1	8	localObject2	Object
    //   1440	22	8	localException1	Exception
    //   1470	29	8	localObject3	Object
    //   1507	1	8	localObject4	Object
    //   1535	40	8	localException2	Exception
    //   1595	35	8	localStringBuilder	StringBuilder
    //   1648	72	8	localObject5	Object
    //   1736	45	8	localObject6	Object
    //   11	1774	9	localObject7	Object
    //   1	918	10	localObject8	Object
    //   1449	1	10	localObject9	Object
    //   1454	1	10	localException3	Exception
    //   1459	10	10	localObject10	Object
    //   1474	1	10	localObject11	Object
    //   1487	27	10	localException4	Exception
    //   1518	271	10	localObject12	Object
    //   157	3	11	str1	String
    //   166	23	11	localThrowable	Throwable
    //   215	1440	11	localObject13	Object
    //   1741	10	11	localObject14	Object
    //   1756	14	11	localObject15	Object
    //   97	1690	12	localObject16	Object
    //   175	1504	13	localObject17	Object
    //   1765	14	13	localException5	Exception
    //   319	1226	14	localObject18	Object
    //   79	1303	15	localObject19	Object
    //   18	1234	16	localObject20	Object
    //   115	715	17	localArrayList1	ArrayList
    //   88	754	18	localArrayList2	ArrayList
    //   6	712	19	str2	String
    //   416	40	20	localJSONArray	JSONArray
    //   390	35	21	localJSONObject	JSONObject
    //   307	1001	22	localApolloManagerServiceImpl	ApolloManagerServiceImpl
    //   106	761	23	localArrayList3	ArrayList
    //   124	755	24	localArrayList4	ArrayList
    //   133	765	25	localArrayList5	ArrayList
    //   142	744	26	localArrayList6	ArrayList
    // Exception table:
    //   from	to	target	type
    //   144	159	166	java/lang/Throwable
    //   826	902	1431	finally
    //   906	927	1431	finally
    //   927	952	1431	finally
    //   952	968	1431	finally
    //   973	1158	1431	finally
    //   1158	1251	1431	finally
    //   1251	1261	1431	finally
    //   1271	1323	1431	finally
    //   1330	1374	1431	finally
    //   1386	1390	1431	finally
    //   826	902	1440	java/lang/Exception
    //   906	927	1440	java/lang/Exception
    //   927	952	1440	java/lang/Exception
    //   952	968	1440	java/lang/Exception
    //   973	1158	1440	java/lang/Exception
    //   1158	1251	1440	java/lang/Exception
    //   1251	1261	1440	java/lang/Exception
    //   1271	1323	1440	java/lang/Exception
    //   1330	1374	1440	java/lang/Exception
    //   1386	1390	1440	java/lang/Exception
    //   691	699	1449	finally
    //   705	724	1449	finally
    //   729	764	1449	finally
    //   772	793	1449	finally
    //   798	807	1449	finally
    //   810	826	1449	finally
    //   691	699	1454	java/lang/Exception
    //   705	724	1454	java/lang/Exception
    //   729	764	1454	java/lang/Exception
    //   772	793	1454	java/lang/Exception
    //   798	807	1454	java/lang/Exception
    //   810	826	1454	java/lang/Exception
    //   487	501	1459	finally
    //   504	513	1459	finally
    //   517	560	1459	finally
    //   571	641	1459	finally
    //   641	670	1459	finally
    //   670	691	1459	finally
    //   487	501	1487	java/lang/Exception
    //   504	513	1487	java/lang/Exception
    //   517	560	1487	java/lang/Exception
    //   571	641	1487	java/lang/Exception
    //   641	670	1487	java/lang/Exception
    //   670	691	1487	java/lang/Exception
    //   325	333	1507	finally
    //   349	360	1507	finally
    //   381	392	1507	finally
    //   408	418	1507	finally
    //   444	450	1507	finally
    //   325	333	1535	java/lang/Exception
    //   349	360	1535	java/lang/Exception
    //   381	392	1535	java/lang/Exception
    //   408	418	1535	java/lang/Exception
    //   444	450	1535	java/lang/Exception
    //   1568	1579	1648	finally
    //   455	482	1741	finally
    //   455	482	1765	java/lang/Exception
  }
  
  public boolean c(ApolloActionData paramApolloActionData)
  {
    return (ApolloActionHelperImpl.isPlayerAction(paramApolloActionData)) && (new File(a(paramApolloActionData, 10)).exists());
  }
  
  public boolean c(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    if ((paramInt & 0x1) == 1) {
      paramApolloActionData = a(paramApolloActionData, 0);
    } else if ((paramInt & 0x2) == 2) {
      paramApolloActionData = a(paramApolloActionData, 2);
    } else {
      paramApolloActionData = "";
    }
    return FileUtil.d(paramApolloActionData);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]cm_res", 2, "[checkCompat2DActionRsc]");
    }
    Object localObject = this.i;
    if (localObject == null)
    {
      QLog.e("[cmshow]cm_res", 1, "[checkCompat2DActionRsc] error! app is null! ");
      return;
    }
    localObject = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localObject).findActionById(1450);
    if (localApolloActionData != null) {
      h(localApolloActionData.actionId, localApolloActionData.personNum);
    }
    localObject = ((ApolloDaoManagerServiceImpl)localObject).findActionById(1454);
    if (localObject != null) {
      h(((ApolloActionData)localObject).actionId, ((ApolloActionData)localObject).personNum);
    }
  }
  
  public void d(int paramInt1, int paramInt2, String paramString)
  {
    if (!"tab_list_android_json_v665".equals(paramString)) {
      return;
    }
    paramString = (IApolloUtil)QRoute.api(IApolloUtil.class);
    boolean bool = true;
    int n = paramString.getApolloPanelJsonVer(1);
    if (paramInt2 > n) {
      a(true, "onLinePush", 1);
    } else {
      QLog.e("[cmshow]cm_res", 1, "onReceiveApolloPush not newVersion < localVersion");
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("appId:");
      paramString.append(paramInt1);
      paramString.append(" version:");
      paramString.append(paramInt2);
      paramString.append(" jsonVersion:");
      paramString.append(n);
      paramString.append(" update:");
      if (paramInt2 <= n) {
        bool = false;
      }
      paramString.append(bool);
      QLog.d("[cmshow]cm_res", 2, paramString.toString());
    }
  }
  
  public void e()
  {
    Object localObject1 = this.i;
    if (localObject1 == null)
    {
      QLog.e("[cmshow]cm_res", 1, "[checkResForGuidePanel] error! app is null! ");
      return;
    }
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject2 = localApolloDaoManagerServiceImpl.getActionByPackageId(400);
    localObject1 = localObject2;
    if (localApolloDaoManagerServiceImpl.getActionInfoById(3000059) != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = 3000059;
      ((List)localObject1).add(localObject2);
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      a((List)localObject1, "apollo_key");
    }
  }
  
  public void f()
  {
    ApolloListenerManager localApolloListenerManager = this.a;
    if (localApolloListenerManager != null) {
      localApolloListenerManager.a(Boolean.valueOf(true));
    }
  }
  
  public long g(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject2 = this.b;
    if (localJSONObject2 == null) {
      return 0L;
    }
    JSONObject localJSONObject1 = null;
    if (paramInt1 == 3) {
      localJSONObject1 = localJSONObject2.optJSONObject("action_version");
    } else if (paramInt1 == 2) {
      localJSONObject1 = localJSONObject2.optJSONObject("dress_version");
    } else if (paramInt1 == 1) {
      localJSONObject1 = localJSONObject2.optJSONObject("role_version");
    }
    if (localJSONObject1 != null) {
      return localJSONObject1.optLong(String.valueOf(paramInt2));
    }
    return 0L;
  }
  
  public IApolloResDownloader.OnApolloDownLoadListener g()
  {
    if (this.h == null) {
      this.h = new AbsApolloResManager.19(this);
    }
    return this.h;
  }
  
  public boolean g(int paramInt)
  {
    if (g.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)g.get(Integer.valueOf(paramInt))).booleanValue();
    }
    Object localObject = new File(d(3, paramInt), "config.json");
    if (!((File)localObject).exists()) {
      return false;
    }
    try
    {
      localObject = new JSONObject(FileUtils.readFileToString((File)localObject)).optJSONObject("audio");
      if (localObject == null) {
        break label163;
      }
      bool = ((JSONObject)localObject).optBoolean("hasSound");
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveResTimestamp ex!");
      localStringBuilder.append(localException.getMessage());
      QLog.e("[cmshow]cm_res", 1, localStringBuilder.toString());
      return false;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        continue;
        boolean bool = false;
      }
    }
    g.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
    return bool;
    QLog.e("[cmshow]cm_res", 1, "saveResTimestamp OOM!");
    return false;
  }
  
  public String h(int paramInt)
  {
    Object localObject = new File(d(1, paramInt), "config.json");
    if (!((File)localObject).exists()) {
      return null;
    }
    try
    {
      localObject = new JSONObject(FileUtils.readFileToString((File)localObject)).optString("bubbleTips");
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveResTimestamp ex!");
      localStringBuilder.append(localException.getMessage());
      QLog.e("[cmshow]cm_res", 1, localStringBuilder.toString());
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label46:
      break label46;
    }
    QLog.e("[cmshow]cm_res", 1, "saveResTimestamp OOM!");
    return null;
  }
  
  public String i(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d(4, paramInt));
    localStringBuilder.append("music.amr");
    return localStringBuilder.toString();
  }
  
  public void j(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[downloadJson], task:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject1 = new Bundle();
    String str = CmShowWnsUtils.V();
    paramInt &= 0x1;
    if (paramInt == 1)
    {
      ((List)localObject2).add(str);
      ((List)localObject3).add("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json");
      localHashMap.put(str, new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"));
      ((Bundle)localObject1).putInt(str, 1);
    }
    if (k() == null) {
      return;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("apollo_json_task");
    ((StringBuilder)localObject3).append(System.currentTimeMillis());
    localObject2 = new DownloadTask((List)localObject2, localHashMap, ((StringBuilder)localObject3).toString());
    ((DownloadTask)localObject2).N = true;
    ((DownloadTask)localObject2).D = false;
    ((DownloadTask)localObject2).J = true;
    ((DownloadTask)localObject2).T = false;
    ((DownloadTask)localObject2).L = "apollo_res";
    ((DownloadTask)localObject2).Q = true;
    ((DownloadTask)localObject2).P = true;
    k().startDownload((DownloadTask)localObject2, this.c, (Bundle)localObject1);
    if (paramInt == 1) {
      VipUtils.a(this.i, "cmshow", "Apollo", "json_download_begin", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager
 * JD-Core Version:    0.7.0.1
 */