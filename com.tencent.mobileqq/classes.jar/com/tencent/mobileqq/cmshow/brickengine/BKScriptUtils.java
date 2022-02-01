package com.tencent.mobileqq.cmshow.brickengine;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask;
import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask.RoleInfo;
import com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class BKScriptUtils
{
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = ApolloUtilImpl.handleBubbleType(208.0F, paramString, paramInt2);
    if ((!ApolloUtilImpl.isBubbleRscExist(paramInt1, i)) && (!ApolloUtilImpl.isBubbleRscExist(0, i))) {
      return "";
    }
    return ApolloActionHelperImpl.getBubbleRscName(paramInt1, i, paramInt2);
  }
  
  private static String a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).optJSONObject("action");
      bool2 = false;
      if (paramBoolean)
      {
        localObject2 = localJSONObject.optString("actionId");
        localObject1 = localObject2;
        if (localJSONObject.optInt("actionPlatform") <= 0) {
          break label294;
        }
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = localJSONObject.optString("actionPeerId");
        localObject1 = localObject2;
        if (localJSONObject.optInt("actionPeerPlatform") <= 0) {
          break label294;
        }
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool2;
        Object localObject2;
        Object localObject1;
        continue;
        boolean bool1 = true;
        continue;
        bool1 = false;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!paramBoolean) {
        bool2 = true;
      }
      if (CMResUtil.a(paramInt, bool2, Integer.parseInt((String)localObject1), bool1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (bool1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append("android");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("action");
        localObject1 = ((StringBuilder)localObject2).toString();
        return localObject1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[random] the json is not right,");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("[cmshow]BKScriptUtils", 1, ((StringBuilder)localObject1).toString());
      }
    }
    return null;
  }
  
  /* Error */
  public static JSONArray a(@NonNull PlayActionTask paramPlayActionTask)
  {
    // Byte code:
    //   0: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: new 117	org/json/JSONArray
    //   7: dup
    //   8: invokespecial 118	org/json/JSONArray:<init>	()V
    //   11: astore 6
    //   13: aload_0
    //   14: invokevirtual 123	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:a	()I
    //   17: iconst_1
    //   18: invokestatic 128	com/tencent/mobileqq/apollo/aio/api/impl/CmShowAioMatcherImpl:judgeSupported	(II)Z
    //   21: istore 5
    //   23: iload 5
    //   25: ifeq +104 -> 129
    //   28: aload_0
    //   29: invokevirtual 131	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:d	()Ljava/lang/String;
    //   32: aload_0
    //   33: iconst_1
    //   34: aconst_null
    //   35: iconst_1
    //   36: invokestatic 134	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;ZLjava/lang/String;Z)Lorg/json/JSONObject;
    //   39: astore 7
    //   41: aload_0
    //   42: invokevirtual 137	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:c	()Ljava/lang/String;
    //   45: aload_0
    //   46: iconst_0
    //   47: aconst_null
    //   48: iconst_1
    //   49: invokestatic 134	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;ZLjava/lang/String;Z)Lorg/json/JSONObject;
    //   52: astore 8
    //   54: aload_0
    //   55: invokevirtual 140	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:a	()Z
    //   58: ifne +52 -> 110
    //   61: aload_0
    //   62: invokevirtual 131	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:d	()Ljava/lang/String;
    //   65: aload_0
    //   66: iconst_1
    //   67: invokestatic 143	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   70: astore 9
    //   72: aload_0
    //   73: invokevirtual 137	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:c	()Ljava/lang/String;
    //   76: aload_0
    //   77: iconst_0
    //   78: invokestatic 143	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   81: astore_0
    //   82: aload 9
    //   84: ifnull +13 -> 97
    //   87: aload 7
    //   89: ldc 145
    //   91: aload 9
    //   93: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload_0
    //   98: ifnull +12 -> 110
    //   101: aload 8
    //   103: ldc 145
    //   105: aload_0
    //   106: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   109: pop
    //   110: aload 6
    //   112: aload 7
    //   114: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   117: pop
    //   118: aload 6
    //   120: aload 8
    //   122: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   125: pop
    //   126: goto +54 -> 180
    //   129: aload_0
    //   130: invokevirtual 155	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:g	()Ljava/lang/String;
    //   133: aload_0
    //   134: iconst_1
    //   135: aconst_null
    //   136: iconst_1
    //   137: invokestatic 134	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;ZLjava/lang/String;Z)Lorg/json/JSONObject;
    //   140: astore 7
    //   142: aload_0
    //   143: invokevirtual 140	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:a	()Z
    //   146: ifne +26 -> 172
    //   149: aload_0
    //   150: invokevirtual 131	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:d	()Ljava/lang/String;
    //   153: aload_0
    //   154: iconst_1
    //   155: invokestatic 143	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   158: astore_0
    //   159: aload_0
    //   160: ifnull +12 -> 172
    //   163: aload 7
    //   165: ldc 145
    //   167: aload_0
    //   168: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload 6
    //   174: aload 7
    //   176: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   179: pop
    //   180: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   183: lstore_3
    //   184: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +27 -> 214
    //   190: ldc 99
    //   192: iconst_2
    //   193: iconst_2
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: ldc 160
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: lload_3
    //   205: lload_1
    //   206: lsub
    //   207: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   210: aastore
    //   211: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   214: aload 6
    //   216: areturn
    //   217: astore_0
    //   218: goto +49 -> 267
    //   221: astore_0
    //   222: ldc 99
    //   224: iconst_1
    //   225: ldc 171
    //   227: aload_0
    //   228: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   234: lstore_3
    //   235: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +27 -> 265
    //   241: ldc 99
    //   243: iconst_2
    //   244: iconst_2
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: ldc 160
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: lload_3
    //   256: lload_1
    //   257: lsub
    //   258: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   261: aastore
    //   262: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   265: aconst_null
    //   266: areturn
    //   267: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   270: lstore_3
    //   271: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +27 -> 301
    //   277: ldc 99
    //   279: iconst_2
    //   280: iconst_2
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: ldc 160
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: lload_3
    //   292: lload_1
    //   293: lsub
    //   294: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   297: aastore
    //   298: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   301: aload_0
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramPlayActionTask	PlayActionTask
    //   3	290	1	l1	long
    //   183	109	3	l2	long
    //   21	3	5	bool	boolean
    //   11	204	6	localJSONArray	JSONArray
    //   39	136	7	localJSONObject1	JSONObject
    //   52	69	8	localJSONObject2	JSONObject
    //   70	22	9	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   4	23	217	finally
    //   28	82	217	finally
    //   87	97	217	finally
    //   101	110	217	finally
    //   110	126	217	finally
    //   129	159	217	finally
    //   163	172	217	finally
    //   172	180	217	finally
    //   222	231	217	finally
    //   4	23	221	java/lang/Throwable
    //   28	82	221	java/lang/Throwable
    //   87	97	221	java/lang/Throwable
    //   101	110	221	java/lang/Throwable
    //   110	126	221	java/lang/Throwable
    //   129	159	221	java/lang/Throwable
    //   163	172	221	java/lang/Throwable
    //   172	180	221	java/lang/Throwable
  }
  
  public static JSONObject a(@NonNull PlayActionTask paramPlayActionTask)
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return null;
    }
    label366:
    for (;;)
    {
      try
      {
        int i = paramPlayActionTask.c();
        if ((paramPlayActionTask.j() == 12) && (i > 0))
        {
          localObject2 = ApolloUtilImpl.getAudioPathForAction(i);
          if (!new File((String)localObject2).exists())
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[getAudioParam] audio not found for ");
              ((StringBuilder)localObject1).append((String)localObject2);
              QLog.d("[cmshow]BKScriptUtils", 1, new Object[] { ((StringBuilder)localObject1).toString(), ",action:", Integer.valueOf(i) });
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = ((String)localObject2).substring(74);
          }
        }
        else
        {
          localObject2 = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(i);
          if ((localObject2 != null) && (((ApolloActionData)localObject2).hasSound))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append("music.amr");
            localObject1 = ((StringBuilder)localObject1).toString();
            if (new File((String)localObject1).exists()) {
              break label366;
            }
            ((ApolloResManagerImpl)localQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).downloadApolloRes((ApolloActionData)localObject2, 4, null);
            break label366;
          }
          if (paramPlayActionTask.i() <= 0) {
            continue;
          }
          localObject2 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).getAudioFilePath(paramPlayActionTask.i());
          localObject1 = localObject2;
          if (!new File((String)localObject2).exists())
          {
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloAudio(localQQAppInterface, null, paramPlayActionTask.i(), false);
            localObject1 = localObject2;
          }
        }
        i = ((String)localObject1).indexOf(".apollo");
        Object localObject2 = localObject1;
        if (-1 != i) {
          localObject2 = ((String)localObject1).substring(i + 15);
        }
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("path", localObject2);
        ((JSONObject)localObject1).put("delayMill", paramPlayActionTask.b() * 1000.0F);
        return localObject1;
        return null;
      }
      catch (Exception paramPlayActionTask)
      {
        QLog.e("[cmshow]BKScriptUtils", 1, paramPlayActionTask, new Object[0]);
        return null;
      }
    }
  }
  
  private static JSONObject a(PlayActionTask paramPlayActionTask, int paramInt1, int paramInt2)
  {
    Object localObject1 = ApolloUtilImpl.getQQApp();
    if (localObject1 == null) {
      return null;
    }
    try
    {
      Object localObject2 = new SpriteTaskParam();
      ((SpriteTaskParam)localObject2).f = paramInt1;
      ((SpriteTaskParam)localObject2).d = paramInt2;
      ((SpriteTaskParam)localObject2).h = paramPlayActionTask.a();
      ((SpriteTaskParam)localObject2).c = 1;
      if (!SpriteRscBuilder.a(paramPlayActionTask.j(), paramPlayActionTask.c(), paramPlayActionTask.d(), paramPlayActionTask.a(), paramPlayActionTask.l(), paramPlayActionTask.i(), paramPlayActionTask.a())) {
        return null;
      }
      localObject1 = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt1);
      if (localObject1 == null) {
        return null;
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("actionId", paramInt1);
      boolean bool = CmShowAioMatcherImpl.judgeSupported(paramPlayActionTask.a(), 2);
      ((JSONObject)localObject2).put("action", ApolloActionHelperImpl.getWhiteFaceRscPath(paramInt1, paramInt2, true, bool)[0]);
      int i = ((ApolloActionData)localObject1).personNum;
      if (i == 1) {
        ((JSONObject)localObject2).put("actionPeer", ApolloActionHelperImpl.getWhiteFaceRscPath(paramInt1, paramInt2, false, bool)[0]);
      } else {
        ((JSONObject)localObject2).put("actionPeer", "");
      }
      if (CmShowAioMatcherImpl.judgeSupported(paramPlayActionTask.a(), 1))
      {
        ((JSONObject)localObject2).put("actionDis", ((ApolloActionData)localObject1).actionMoveDis * (float)DeviceInfoUtil.j() / 7.0F / 368.0F);
        ((JSONObject)localObject2).put("actionPeerDis", ((ApolloActionData)localObject1).peerMoveDis * (float)DeviceInfoUtil.j() / 7.0F / 368.0F);
        return localObject2;
      }
      ((JSONObject)localObject2).put("posType", ((ApolloActionData)localObject1).playArea);
      return localObject2;
    }
    catch (Throwable paramPlayActionTask)
    {
      QLog.e("[cmshow]BKScriptUtils", 1, "[getWhiteFaceSingleAction],", paramPlayActionTask);
    }
    return null;
  }
  
  private static JSONObject a(@NonNull PlayActionTask paramPlayActionTask, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramString;
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return null;
    }
    for (;;)
    {
      int j;
      try
      {
        Object localObject = ApolloActionData.getModelString(paramPlayActionTask.c());
        if ((paramPlayActionTask.b()) && (paramPlayActionTask.c() > 0))
        {
          paramString = (String)localObject;
          JSONObject localJSONObject = a(str, paramPlayActionTask, SpriteUtil.a(str, paramPlayActionTask.g(), paramPlayActionTask.h(), paramBoolean1), paramString, paramPlayActionTask.d());
          if ((paramPlayActionTask.a()) && (localJSONObject != null)) {
            localJSONObject.put("model", localObject);
          }
          if ((paramPlayActionTask.d()) && (!SpriteRscBuilder.a(paramPlayActionTask.j(), paramPlayActionTask.c(), paramPlayActionTask.d(), paramPlayActionTask.a(), paramPlayActionTask.l(), paramPlayActionTask.i(), paramPlayActionTask.a()))) {
            return localJSONObject;
          }
          localObject = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
          j = ((ApolloManagerServiceImpl)localObject).getCmShowStatus(str);
          int k = ((Integer)ApolloActionHelperImpl.get3DRoleDressIdByUin(str, j, localQQAppInterface, true)[0]).intValue();
          paramString = str;
          if (((ApolloManagerServiceImpl)localObject).getCmShowStatus(str, false) == 0)
          {
            paramString = str;
            if (paramPlayActionTask.b())
            {
              if (!((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(localQQAppInterface, str)) {
                break label633;
              }
              paramString = "-2";
            }
          }
          paramString = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, localQQAppInterface, true);
          if (paramString != null)
          {
            if (paramString.length != 2) {
              return null;
            }
            int m = ((Integer)paramString[0]).intValue();
            if (localJSONObject != null)
            {
              if (!paramBoolean1) {
                break label640;
              }
              i = 1;
              localJSONObject.put("isMaster", i);
              if ((paramBoolean1) && (!TextUtils.isEmpty(paramPlayActionTask.j())))
              {
                localJSONObject.put("text", SpriteUtil.a(Base64Util.encodeToString(paramPlayActionTask.j().getBytes("utf-8"), 0)));
                boolean bool = paramPlayActionTask.e();
                if (!bool)
                {
                  localJSONObject.put("bubbleType", 0);
                  if ((j == 1) && (paramPlayActionTask.c() > ApolloConstant.a) && (((ApolloManagerServiceImpl)localObject).is3dAvailable()))
                  {
                    i = 2;
                  }
                  else
                  {
                    if ((j != 2) || (paramPlayActionTask.c() >= ApolloConstant.a)) {
                      break label646;
                    }
                    i = 1;
                  }
                  localJSONObject.put("bubble", a(paramPlayActionTask.j(), m, i));
                }
                else
                {
                  localJSONObject.put("bubbleType", 1);
                }
              }
              int n = paramPlayActionTask.j();
              int i1 = paramPlayActionTask.c();
              i = m;
              if (k >= 0) {
                i = k;
              }
              paramString = ApolloActionHelperImpl.getActionRscPath(n, i1, i, paramBoolean1, j);
              if (paramString != null)
              {
                if (paramString.length < 2) {
                  return null;
                }
                if ((paramPlayActionTask.k() == 0) && (CmShowAioMatcherImpl.judgeSupported(paramPlayActionTask.a(), 1)) && (!paramBoolean1) && (!paramBoolean2)) {
                  return localJSONObject;
                }
                str = paramString[0];
                paramString = str;
                if (8 == paramPlayActionTask.d())
                {
                  paramString = str;
                  if (!TextUtils.isEmpty(paramPlayActionTask.i()))
                  {
                    paramPlayActionTask = a(paramBoolean1, paramPlayActionTask.i(), paramPlayActionTask.c());
                    paramString = str;
                    if (!TextUtils.isEmpty(paramPlayActionTask))
                    {
                      paramString = new StringBuilder();
                      paramString.append(str);
                      paramString.append(paramPlayActionTask);
                      paramString = paramString.toString();
                    }
                  }
                }
                localJSONObject.put("action", paramString);
                return localJSONObject;
              }
              return null;
            }
            return localJSONObject;
          }
          return null;
        }
      }
      catch (Throwable paramPlayActionTask)
      {
        QLog.e("[cmshow]BKScriptUtils", 1, paramPlayActionTask, new Object[0]);
        return null;
      }
      paramString = null;
      continue;
      label633:
      paramString = "-1";
      continue;
      label640:
      int i = 0;
      continue;
      label646:
      i = j;
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString, AbsScriptTask paramAbsScriptTask, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 41	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 268	org/json/JSONObject:<init>	()V
    //   7: astore 10
    //   9: new 442	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 443	java/util/ArrayList:<init>	()V
    //   16: astore 12
    //   18: invokestatic 180	com/tencent/mobileqq/apollo/utils/api/impl/ApolloUtilImpl:getQQApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: astore 11
    //   23: iconst_0
    //   24: istore 4
    //   26: aload 11
    //   28: ldc_w 367
    //   31: ldc 209
    //   33: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   36: checkcast 369	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   39: astore 9
    //   41: aload 11
    //   43: ldc 207
    //   45: ldc 209
    //   47: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   50: checkcast 217	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   53: aload_0
    //   54: invokevirtual 447	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:getApolloBaseInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;
    //   57: astore 13
    //   59: aload 13
    //   61: ifnonnull +5 -> 66
    //   64: aconst_null
    //   65: areturn
    //   66: aload 13
    //   68: invokevirtual 453	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:getApolloPetDress	()Lcom/tencent/mobileqq/apollo/model/ApolloDress;
    //   71: astore 14
    //   73: aload 14
    //   75: ifnull +817 -> 892
    //   78: aload 13
    //   80: getfield 456	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:hasPet	Z
    //   83: ifeq +809 -> 892
    //   86: aload 14
    //   88: getfield 462	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   91: ifnull +801 -> 892
    //   94: aload 14
    //   96: getfield 462	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   99: invokevirtual 466	java/util/HashMap:isEmpty	()Z
    //   102: ifne +790 -> 892
    //   105: aload 10
    //   107: ldc_w 468
    //   110: iconst_0
    //   111: aload 14
    //   113: getfield 471	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   116: invokestatic 475	com/tencent/mobileqq/apollo/utils/api/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   119: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: iconst_1
    //   124: aload 14
    //   126: getfield 471	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   129: invokestatic 477	com/tencent/mobileqq/cmshow/engine/util/CMResUtil:c	(II)Z
    //   132: istore 8
    //   134: iload 8
    //   136: ifne +36 -> 172
    //   139: aload 14
    //   141: getfield 471	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   144: istore_3
    //   145: iconst_0
    //   146: istore 4
    //   148: goto +29 -> 177
    //   151: astore_1
    //   152: iconst_m1
    //   153: istore_3
    //   154: iconst_0
    //   155: istore 4
    //   157: goto +943 -> 1100
    //   160: astore 10
    //   162: aload 9
    //   164: astore_1
    //   165: aload 10
    //   167: astore 9
    //   169: goto +763 -> 932
    //   172: iconst_1
    //   173: istore 4
    //   175: iconst_m1
    //   176: istore_3
    //   177: aload 14
    //   179: getfield 462	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   182: invokevirtual 480	java/util/HashMap:size	()I
    //   185: newarray int
    //   187: astore 15
    //   189: aload 14
    //   191: getfield 462	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   194: invokevirtual 484	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   197: invokeinterface 490 1 0
    //   202: astore 16
    //   204: iconst_0
    //   205: istore 5
    //   207: aload 16
    //   209: invokeinterface 495 1 0
    //   214: ifeq +38 -> 252
    //   217: aload 15
    //   219: iload 5
    //   221: aload 16
    //   223: invokeinterface 499 1 0
    //   228: checkcast 501	java/util/Map$Entry
    //   231: invokeinterface 504 1 0
    //   236: checkcast 68	java/lang/Integer
    //   239: invokevirtual 379	java/lang/Integer:intValue	()I
    //   242: iastore
    //   243: iload 5
    //   245: iconst_1
    //   246: iadd
    //   247: istore 5
    //   249: goto -42 -> 207
    //   252: new 117	org/json/JSONArray
    //   255: dup
    //   256: invokespecial 118	org/json/JSONArray:<init>	()V
    //   259: astore 16
    //   261: aload 15
    //   263: arraylength
    //   264: istore 5
    //   266: iconst_0
    //   267: istore 6
    //   269: iload 6
    //   271: iload 5
    //   273: if_icmpge +82 -> 355
    //   276: aload 15
    //   278: iload 6
    //   280: iaload
    //   281: istore 7
    //   283: aload 16
    //   285: iconst_1
    //   286: iload 7
    //   288: invokestatic 475	com/tencent/mobileqq/apollo/utils/api/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   291: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   294: pop
    //   295: iconst_2
    //   296: iload 7
    //   298: invokestatic 477	com/tencent/mobileqq/cmshow/engine/util/CMResUtil:c	(II)Z
    //   301: istore 8
    //   303: iload 8
    //   305: ifne +41 -> 346
    //   308: aload 12
    //   310: iload 7
    //   312: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: invokeinterface 510 2 0
    //   320: pop
    //   321: iconst_0
    //   322: istore 4
    //   324: goto +22 -> 346
    //   327: astore_1
    //   328: goto -174 -> 154
    //   331: astore 10
    //   333: aload 9
    //   335: astore_1
    //   336: iconst_0
    //   337: istore 4
    //   339: aload 10
    //   341: astore 9
    //   343: goto +591 -> 934
    //   346: iload 6
    //   348: iconst_1
    //   349: iadd
    //   350: istore 6
    //   352: goto -83 -> 269
    //   355: aload 10
    //   357: ldc_w 512
    //   360: aload 16
    //   362: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   365: pop
    //   366: aload 10
    //   368: ldc_w 513
    //   371: aload 14
    //   373: getfield 471	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   376: invokevirtual 315	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   379: pop
    //   380: aload 14
    //   382: getfield 471	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   385: ldc_w 515
    //   388: invokestatic 518	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   391: astore 15
    //   393: aload 14
    //   395: getfield 471	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   398: ldc_w 520
    //   401: invokestatic 518	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   404: astore 16
    //   406: aload 15
    //   408: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   411: ifne +33 -> 444
    //   414: aload 16
    //   416: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   419: ifne +25 -> 444
    //   422: aload 10
    //   424: ldc_w 522
    //   427: aload 16
    //   429: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   432: pop
    //   433: aload 10
    //   435: ldc_w 524
    //   438: aload 15
    //   440: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload 14
    //   446: getfield 471	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   449: invokestatic 526	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(I)Ljava/lang/String;
    //   452: astore 15
    //   454: aload 15
    //   456: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   459: ifne +14 -> 473
    //   462: aload 10
    //   464: ldc_w 528
    //   467: aload 15
    //   469: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   472: pop
    //   473: aload 13
    //   475: getfield 531	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   478: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +48 -> 529
    //   484: aload_1
    //   485: invokevirtual 535	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:b	()I
    //   488: ifne +41 -> 529
    //   491: aload 13
    //   493: getfield 531	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   496: ldc_w 402
    //   499: invokevirtual 406	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   502: astore 15
    //   504: aload 15
    //   506: iconst_0
    //   507: invokestatic 412	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   510: astore 15
    //   512: aload 10
    //   514: ldc_w 537
    //   517: aload 15
    //   519: invokestatic 414	com/tencent/mobileqq/apollo/script/SpriteUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   522: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   525: pop
    //   526: goto +3 -> 529
    //   529: aload 13
    //   531: getfield 540	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBgImgPath	Ljava/lang/String;
    //   534: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   537: ifne +24 -> 561
    //   540: aload_1
    //   541: invokevirtual 535	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:b	()I
    //   544: ifne +17 -> 561
    //   547: aload 10
    //   549: ldc_w 542
    //   552: aload 13
    //   554: getfield 540	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBgImgPath	Ljava/lang/String;
    //   557: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   560: pop
    //   561: aload 13
    //   563: getfield 545	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBallImgPath	Ljava/lang/String;
    //   566: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   569: ifne +24 -> 593
    //   572: aload_1
    //   573: invokevirtual 535	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:b	()I
    //   576: ifne +17 -> 593
    //   579: aload 10
    //   581: ldc_w 547
    //   584: aload 13
    //   586: getfield 545	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBallImgPath	Ljava/lang/String;
    //   589: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   592: pop
    //   593: aload 13
    //   595: getfield 550	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mLevel	Ljava/lang/String;
    //   598: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   601: ifne +24 -> 625
    //   604: aload_1
    //   605: invokevirtual 535	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:b	()I
    //   608: ifne +17 -> 625
    //   611: aload 10
    //   613: ldc_w 552
    //   616: aload 13
    //   618: getfield 550	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mLevel	Ljava/lang/String;
    //   621: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   624: pop
    //   625: aload 10
    //   627: ldc_w 554
    //   630: aload 9
    //   632: getfield 557	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPetConfig	Ljava/lang/String;
    //   635: aload 14
    //   637: getfield 471	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   640: iload_2
    //   641: invokestatic 560	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   644: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   647: pop
    //   648: aload_1
    //   649: invokevirtual 563	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:a	()Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo;
    //   652: ifnull +54 -> 706
    //   655: aload 10
    //   657: ldc_w 565
    //   660: aload_1
    //   661: invokevirtual 563	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:a	()Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo;
    //   664: getfield 569	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo:a	F
    //   667: f2d
    //   668: invokevirtual 280	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   671: pop
    //   672: aload 10
    //   674: ldc_w 571
    //   677: aload_1
    //   678: invokevirtual 563	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:a	()Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo;
    //   681: getfield 573	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo:b	F
    //   684: f2d
    //   685: invokevirtual 280	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   688: pop
    //   689: aload 10
    //   691: ldc_w 575
    //   694: aload_1
    //   695: invokevirtual 563	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:a	()Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo;
    //   698: getfield 577	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo:c	F
    //   701: f2d
    //   702: invokevirtual 280	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   705: pop
    //   706: iload 4
    //   708: ifeq +9 -> 717
    //   711: aload 10
    //   713: astore_1
    //   714: goto +5 -> 719
    //   717: aconst_null
    //   718: astore_1
    //   719: iload 4
    //   721: ifne +137 -> 858
    //   724: aload 11
    //   726: ifnull +132 -> 858
    //   729: new 78	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   736: astore 10
    //   738: aload 10
    //   740: ldc_w 579
    //   743: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 10
    //   749: aload_0
    //   750: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: ldc_w 581
    //   757: iconst_1
    //   758: aload 10
    //   760: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   763: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   766: aload 9
    //   768: ifnull +90 -> 858
    //   771: aload 12
    //   773: invokeinterface 582 1 0
    //   778: newarray int
    //   780: astore 10
    //   782: aload 12
    //   784: invokeinterface 583 1 0
    //   789: astore 12
    //   791: iconst_0
    //   792: istore 4
    //   794: aload 12
    //   796: invokeinterface 495 1 0
    //   801: ifeq +30 -> 831
    //   804: aload 10
    //   806: iload 4
    //   808: aload 12
    //   810: invokeinterface 499 1 0
    //   815: checkcast 68	java/lang/Integer
    //   818: invokevirtual 379	java/lang/Integer:intValue	()I
    //   821: iastore
    //   822: iload 4
    //   824: iconst_1
    //   825: iadd
    //   826: istore 4
    //   828: goto -34 -> 794
    //   831: ldc 249
    //   833: invokestatic 255	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   836: checkcast 249	com/tencent/mobileqq/apollo/res/api/IApolloResDownloader
    //   839: aload 11
    //   841: aload_0
    //   842: aload 9
    //   844: invokevirtual 587	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/res/api/IApolloResDownloader$OnApolloDownLoadListener;
    //   847: iload_3
    //   848: aload 10
    //   850: iconst_m1
    //   851: iconst_m1
    //   852: iconst_1
    //   853: invokeinterface 591 9 0
    //   858: aload_1
    //   859: areturn
    //   860: astore_1
    //   861: goto +16 -> 877
    //   864: astore 10
    //   866: aload 9
    //   868: astore_1
    //   869: aload 10
    //   871: astore 9
    //   873: goto +61 -> 934
    //   876: astore_1
    //   877: goto +223 -> 1100
    //   880: astore 10
    //   882: aload 9
    //   884: astore_1
    //   885: aload 10
    //   887: astore 9
    //   889: goto +45 -> 934
    //   892: aconst_null
    //   893: areturn
    //   894: astore_1
    //   895: goto +22 -> 917
    //   898: astore 10
    //   900: aload 9
    //   902: astore_1
    //   903: iconst_1
    //   904: istore 4
    //   906: aload 10
    //   908: astore 9
    //   910: goto +22 -> 932
    //   913: astore_1
    //   914: aconst_null
    //   915: astore 9
    //   917: iconst_m1
    //   918: istore_3
    //   919: iconst_1
    //   920: istore 4
    //   922: goto +178 -> 1100
    //   925: astore 9
    //   927: iconst_1
    //   928: istore 4
    //   930: aconst_null
    //   931: astore_1
    //   932: iconst_m1
    //   933: istore_3
    //   934: iconst_0
    //   935: istore 5
    //   937: ldc 99
    //   939: iconst_1
    //   940: aload 9
    //   942: iconst_0
    //   943: anewarray 4	java/lang/Object
    //   946: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   949: iload 4
    //   951: ifne +136 -> 1087
    //   954: aload 11
    //   956: ifnull +131 -> 1087
    //   959: new 78	java/lang/StringBuilder
    //   962: dup
    //   963: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   966: astore 9
    //   968: aload 9
    //   970: ldc_w 579
    //   973: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload 9
    //   979: aload_0
    //   980: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: ldc_w 581
    //   987: iconst_1
    //   988: aload 9
    //   990: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: aload_1
    //   997: ifnull +90 -> 1087
    //   1000: aload 12
    //   1002: invokeinterface 582 1 0
    //   1007: newarray int
    //   1009: astore 9
    //   1011: aload 12
    //   1013: invokeinterface 583 1 0
    //   1018: astore 10
    //   1020: iload 5
    //   1022: istore 4
    //   1024: aload 10
    //   1026: invokeinterface 495 1 0
    //   1031: ifeq +30 -> 1061
    //   1034: aload 9
    //   1036: iload 4
    //   1038: aload 10
    //   1040: invokeinterface 499 1 0
    //   1045: checkcast 68	java/lang/Integer
    //   1048: invokevirtual 379	java/lang/Integer:intValue	()I
    //   1051: iastore
    //   1052: iload 4
    //   1054: iconst_1
    //   1055: iadd
    //   1056: istore 4
    //   1058: goto -34 -> 1024
    //   1061: ldc 249
    //   1063: invokestatic 255	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1066: checkcast 249	com/tencent/mobileqq/apollo/res/api/IApolloResDownloader
    //   1069: aload 11
    //   1071: aload_0
    //   1072: aload_1
    //   1073: invokevirtual 587	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/res/api/IApolloResDownloader$OnApolloDownLoadListener;
    //   1076: iload_3
    //   1077: aload 9
    //   1079: iconst_m1
    //   1080: iconst_m1
    //   1081: iconst_1
    //   1082: invokeinterface 591 9 0
    //   1087: aconst_null
    //   1088: areturn
    //   1089: astore 10
    //   1091: goto +3 -> 1094
    //   1094: aload_1
    //   1095: astore 9
    //   1097: aload 10
    //   1099: astore_1
    //   1100: iconst_0
    //   1101: istore 5
    //   1103: iload 4
    //   1105: ifne +138 -> 1243
    //   1108: aload 11
    //   1110: ifnull +133 -> 1243
    //   1113: new 78	java/lang/StringBuilder
    //   1116: dup
    //   1117: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1120: astore 10
    //   1122: aload 10
    //   1124: ldc_w 579
    //   1127: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: pop
    //   1131: aload 10
    //   1133: aload_0
    //   1134: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: ldc_w 581
    //   1141: iconst_1
    //   1142: aload 10
    //   1144: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1147: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1150: aload 9
    //   1152: ifnull +91 -> 1243
    //   1155: aload 12
    //   1157: invokeinterface 582 1 0
    //   1162: newarray int
    //   1164: astore 10
    //   1166: aload 12
    //   1168: invokeinterface 583 1 0
    //   1173: astore 12
    //   1175: iload 5
    //   1177: istore 4
    //   1179: aload 12
    //   1181: invokeinterface 495 1 0
    //   1186: ifeq +30 -> 1216
    //   1189: aload 10
    //   1191: iload 4
    //   1193: aload 12
    //   1195: invokeinterface 499 1 0
    //   1200: checkcast 68	java/lang/Integer
    //   1203: invokevirtual 379	java/lang/Integer:intValue	()I
    //   1206: iastore
    //   1207: iload 4
    //   1209: iconst_1
    //   1210: iadd
    //   1211: istore 4
    //   1213: goto -34 -> 1179
    //   1216: ldc 249
    //   1218: invokestatic 255	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1221: checkcast 249	com/tencent/mobileqq/apollo/res/api/IApolloResDownloader
    //   1224: aload 11
    //   1226: aload_0
    //   1227: aload 9
    //   1229: invokevirtual 587	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/res/api/IApolloResDownloader$OnApolloDownLoadListener;
    //   1232: iload_3
    //   1233: aload 10
    //   1235: iconst_m1
    //   1236: iconst_m1
    //   1237: iconst_1
    //   1238: invokeinterface 591 9 0
    //   1243: goto +5 -> 1248
    //   1246: aload_1
    //   1247: athrow
    //   1248: goto -2 -> 1246
    //   1251: astore_1
    //   1252: goto -152 -> 1100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1255	0	paramString	String
    //   0	1255	1	paramAbsScriptTask	AbsScriptTask
    //   0	1255	2	paramBoolean	boolean
    //   144	1089	3	i	int
    //   24	1188	4	j	int
    //   205	971	5	k	int
    //   267	84	6	m	int
    //   281	30	7	n	int
    //   132	172	8	bool	boolean
    //   39	877	9	localObject1	Object
    //   925	16	9	localThrowable1	Throwable
    //   966	262	9	localObject2	Object
    //   7	99	10	localJSONObject	JSONObject
    //   160	6	10	localThrowable2	Throwable
    //   331	381	10	localThrowable3	Throwable
    //   736	113	10	localObject3	Object
    //   864	6	10	localThrowable4	Throwable
    //   880	6	10	localThrowable5	Throwable
    //   898	9	10	localThrowable6	Throwable
    //   1018	21	10	localIterator	java.util.Iterator
    //   1089	9	10	localObject4	Object
    //   1120	114	10	localObject5	Object
    //   21	1204	11	localQQAppInterface	QQAppInterface
    //   16	1178	12	localObject6	Object
    //   57	560	13	localApolloBaseInfo	com.tencent.mobileqq.apollo.model.ApolloBaseInfo
    //   71	565	14	localApolloDress	com.tencent.mobileqq.apollo.model.ApolloDress
    //   187	331	15	localObject7	Object
    //   202	226	16	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   139	145	151	finally
    //   139	145	160	java/lang/Throwable
    //   308	321	327	finally
    //   308	321	331	java/lang/Throwable
    //   283	303	860	finally
    //   355	444	860	finally
    //   444	473	860	finally
    //   473	504	860	finally
    //   512	526	860	finally
    //   529	561	860	finally
    //   561	593	860	finally
    //   593	625	860	finally
    //   625	706	860	finally
    //   283	303	864	java/lang/Throwable
    //   355	444	864	java/lang/Throwable
    //   444	473	864	java/lang/Throwable
    //   473	504	864	java/lang/Throwable
    //   504	512	864	java/lang/Throwable
    //   512	526	864	java/lang/Throwable
    //   529	561	864	java/lang/Throwable
    //   561	593	864	java/lang/Throwable
    //   593	625	864	java/lang/Throwable
    //   625	706	864	java/lang/Throwable
    //   177	204	876	finally
    //   207	243	876	finally
    //   252	266	876	finally
    //   177	204	880	java/lang/Throwable
    //   207	243	880	java/lang/Throwable
    //   252	266	880	java/lang/Throwable
    //   41	59	894	finally
    //   66	73	894	finally
    //   78	134	894	finally
    //   41	59	898	java/lang/Throwable
    //   66	73	898	java/lang/Throwable
    //   78	134	898	java/lang/Throwable
    //   26	41	913	finally
    //   26	41	925	java/lang/Throwable
    //   937	949	1089	finally
    //   504	512	1251	finally
  }
  
  public static JSONObject a(String paramString1, AbsScriptTask paramAbsScriptTask, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramString1);
        ApolloActionHelperImpl.attach3DInfoToJson(paramString1, ApolloUtilImpl.getQQApp(), localJSONObject, paramString2);
        int i = ((ApolloManagerServiceImpl)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString1, false);
        if ((i != 0) || (!paramAbsScriptTask.b())) {
          break label484;
        }
        if (((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(ApolloUtilImpl.getQQApp(), paramString1))
        {
          paramString2 = "-2";
          paramString2 = ApolloActionHelperImpl.getRoleDressIdByUin(paramString2, ApolloUtilImpl.getQQApp(), paramBoolean2);
          if ((paramString2 != null) && (paramString2.length == 2))
          {
            int j = ((Integer)paramString2[0]).intValue();
            paramString2 = (int[])paramString2[1];
            if ((paramString2 != null) && (paramString2.length != 0))
            {
              JSONArray localJSONArray = new JSONArray();
              int k = paramString2.length;
              i = 0;
              if (i < k)
              {
                localJSONArray.put(ApolloActionHelperImpl.getApolloRsc(1, Integer.valueOf(paramString2[i]).intValue()));
                i += 1;
                continue;
              }
              localJSONObject.put("dress", localJSONArray);
              localJSONObject.put("role", ApolloActionHelperImpl.getApolloRsc(0, j));
              if (((paramAbsScriptTask.a() == 1) || (paramAbsScriptTask.a() == 3000)) && (!"-1".equals(paramString1)) && (!"-2".equals(paramString1)) && (!paramAbsScriptTask.a()))
              {
                localJSONObject.put("nameplate", SpriteRscBuilder.a(ApolloUtilImpl.getQQApp(), paramString1, j, paramBoolean1));
                paramString2 = paramAbsScriptTask.d();
                if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals(paramString1))) {
                  paramString1 = HardCodeUtil.a(2131714128);
                } else {
                  paramString1 = SpriteUtil.a(ApolloUtilImpl.getQQApp(), paramAbsScriptTask.a(), paramString1, paramAbsScriptTask.c(), true);
                }
                if (!TextUtils.isEmpty(paramString1)) {
                  localJSONObject.put("nickname", SpriteUtil.a(Base64Util.encodeToString(paramString1.getBytes("utf-8"), 0)));
                }
              }
              if (paramAbsScriptTask.a() == null) {
                break;
              }
              localJSONObject.put("scale", paramAbsScriptTask.a().a);
              localJSONObject.put("xPos", paramAbsScriptTask.a().b);
              localJSONObject.put("yPos", paramAbsScriptTask.a().c);
              return localJSONObject;
            }
            SpriteUtil.a(301, new Object[] { "dressInfo is null" });
            return null;
          }
          SpriteUtil.a(301, new Object[] { "roleInfos is null" });
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow]BKScriptUtils", 1, paramString1, new Object[0]);
        return null;
      }
      paramString2 = "-1";
      continue;
      label484:
      paramString2 = paramString1;
    }
    return localJSONObject;
  }
  
  /* Error */
  public static JSONArray b(PlayActionTask paramPlayActionTask)
  {
    // Byte code:
    //   0: invokestatic 180	com/tencent/mobileqq/apollo/utils/api/impl/ApolloUtilImpl:getQQApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3: astore 9
    //   5: aload 9
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 627	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:a	()Ljava/util/List;
    //   16: astore 11
    //   18: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: new 117	org/json/JSONArray
    //   26: dup
    //   27: invokespecial 118	org/json/JSONArray:<init>	()V
    //   30: astore 10
    //   32: aload 9
    //   34: ldc 207
    //   36: ldc 209
    //   38: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   41: checkcast 217	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   44: astore 12
    //   46: iconst_0
    //   47: istore_2
    //   48: iconst_m1
    //   49: istore_3
    //   50: iconst_0
    //   51: istore_1
    //   52: iload_2
    //   53: aload 11
    //   55: invokeinterface 582 1 0
    //   60: if_icmpge +192 -> 252
    //   63: aload 11
    //   65: iload_2
    //   66: invokeinterface 631 2 0
    //   71: checkcast 68	java/lang/Integer
    //   74: invokevirtual 379	java/lang/Integer:intValue	()I
    //   77: istore 4
    //   79: iconst_m1
    //   80: iload_3
    //   81: if_icmpeq +51 -> 132
    //   84: aload 12
    //   86: iload_3
    //   87: invokevirtual 221	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:findActionById	(I)Lcom/tencent/mobileqq/apollo/model/ApolloActionData;
    //   90: astore 13
    //   92: aload 13
    //   94: ifnull +38 -> 132
    //   97: aload 13
    //   99: invokevirtual 634	com/tencent/mobileqq/apollo/model/ApolloActionData:isHasPostAction	()Z
    //   102: ifeq +30 -> 132
    //   105: iload_3
    //   106: iload 4
    //   108: if_icmpeq +24 -> 132
    //   111: aload_0
    //   112: iload_3
    //   113: iconst_2
    //   114: invokestatic 636	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;II)Lorg/json/JSONObject;
    //   117: astore 13
    //   119: aload 13
    //   121: ifnull +11 -> 132
    //   124: aload 10
    //   126: aload 13
    //   128: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   131: pop
    //   132: aload 12
    //   134: iload 4
    //   136: invokevirtual 221	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:findActionById	(I)Lcom/tencent/mobileqq/apollo/model/ApolloActionData;
    //   139: astore 13
    //   141: aload 13
    //   143: ifnull +64 -> 207
    //   146: iload 4
    //   148: iload_3
    //   149: if_icmpeq +33 -> 182
    //   152: aload 13
    //   154: invokevirtual 639	com/tencent/mobileqq/apollo/model/ApolloActionData:isHasPreAction	()Z
    //   157: ifeq +25 -> 182
    //   160: aload_0
    //   161: iload 4
    //   163: iconst_0
    //   164: invokestatic 636	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;II)Lorg/json/JSONObject;
    //   167: astore 13
    //   169: aload 13
    //   171: ifnull +11 -> 182
    //   174: aload 10
    //   176: aload 13
    //   178: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   181: pop
    //   182: aload_0
    //   183: iload 4
    //   185: iconst_1
    //   186: invokestatic 636	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;II)Lorg/json/JSONObject;
    //   189: astore 13
    //   191: aload 13
    //   193: ifnull +255 -> 448
    //   196: aload 10
    //   198: aload 13
    //   200: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   203: pop
    //   204: goto +244 -> 448
    //   207: new 78	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   214: astore 13
    //   216: aload 13
    //   218: ldc_w 641
    //   221: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 13
    //   227: iload 4
    //   229: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: ldc 99
    //   235: iconst_1
    //   236: aload 13
    //   238: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 643	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: iconst_m1
    //   245: istore_1
    //   246: iconst_1
    //   247: istore 4
    //   249: goto +207 -> 456
    //   252: iconst_m1
    //   253: iload_3
    //   254: if_icmpeq +42 -> 296
    //   257: aload 12
    //   259: iload_3
    //   260: invokevirtual 221	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:findActionById	(I)Lcom/tencent/mobileqq/apollo/model/ApolloActionData;
    //   263: astore 11
    //   265: aload 11
    //   267: ifnull +29 -> 296
    //   270: aload 11
    //   272: invokevirtual 634	com/tencent/mobileqq/apollo/model/ApolloActionData:isHasPostAction	()Z
    //   275: ifeq +21 -> 296
    //   278: aload_0
    //   279: iload_3
    //   280: iconst_2
    //   281: invokestatic 636	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;II)Lorg/json/JSONObject;
    //   284: astore_0
    //   285: aload_0
    //   286: ifnull +10 -> 296
    //   289: aload 10
    //   291: aload_0
    //   292: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   295: pop
    //   296: iload_1
    //   297: ifeq +9 -> 306
    //   300: aload 9
    //   302: iconst_1
    //   303: invokestatic 648	com/tencent/mobileqq/apollo/handler/ApolloContentUpdateHandler:a	(Lcom/tencent/common/app/AppInterface;I)V
    //   306: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   309: lstore 7
    //   311: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +30 -> 344
    //   317: ldc 99
    //   319: iconst_2
    //   320: iconst_2
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: ldc_w 650
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: lload 7
    //   334: lload 5
    //   336: lsub
    //   337: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   340: aastore
    //   341: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   344: aload 10
    //   346: areturn
    //   347: astore_0
    //   348: goto +54 -> 402
    //   351: astore_0
    //   352: ldc 99
    //   354: iconst_1
    //   355: ldc_w 652
    //   358: aload_0
    //   359: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   365: lstore 7
    //   367: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +30 -> 400
    //   373: ldc 99
    //   375: iconst_2
    //   376: iconst_2
    //   377: anewarray 4	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: ldc_w 650
    //   385: aastore
    //   386: dup
    //   387: iconst_1
    //   388: lload 7
    //   390: lload 5
    //   392: lsub
    //   393: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   396: aastore
    //   397: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   400: aconst_null
    //   401: areturn
    //   402: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   405: lstore 7
    //   407: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +30 -> 440
    //   413: ldc 99
    //   415: iconst_2
    //   416: iconst_2
    //   417: anewarray 4	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: ldc_w 650
    //   425: aastore
    //   426: dup
    //   427: iconst_1
    //   428: lload 7
    //   430: lload 5
    //   432: lsub
    //   433: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   436: aastore
    //   437: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   440: goto +5 -> 445
    //   443: aload_0
    //   444: athrow
    //   445: goto -2 -> 443
    //   448: iload 4
    //   450: istore_3
    //   451: iload_1
    //   452: istore 4
    //   454: iload_3
    //   455: istore_1
    //   456: iload_2
    //   457: iconst_1
    //   458: iadd
    //   459: istore_2
    //   460: iload_1
    //   461: istore_3
    //   462: iload 4
    //   464: istore_1
    //   465: goto -413 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramPlayActionTask	PlayActionTask
    //   51	414	1	i	int
    //   47	413	2	j	int
    //   49	413	3	k	int
    //   77	386	4	m	int
    //   21	410	5	l1	long
    //   309	120	7	l2	long
    //   3	298	9	localQQAppInterface	QQAppInterface
    //   30	315	10	localJSONArray	JSONArray
    //   16	255	11	localObject1	Object
    //   44	214	12	localApolloDaoManagerServiceImpl	ApolloDaoManagerServiceImpl
    //   90	147	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	46	347	finally
    //   52	79	347	finally
    //   84	92	347	finally
    //   97	105	347	finally
    //   111	119	347	finally
    //   124	132	347	finally
    //   132	141	347	finally
    //   152	169	347	finally
    //   174	182	347	finally
    //   182	191	347	finally
    //   196	204	347	finally
    //   207	244	347	finally
    //   257	265	347	finally
    //   270	285	347	finally
    //   289	296	347	finally
    //   300	306	347	finally
    //   352	362	347	finally
    //   23	46	351	java/lang/Throwable
    //   52	79	351	java/lang/Throwable
    //   84	92	351	java/lang/Throwable
    //   97	105	351	java/lang/Throwable
    //   111	119	351	java/lang/Throwable
    //   124	132	351	java/lang/Throwable
    //   132	141	351	java/lang/Throwable
    //   152	169	351	java/lang/Throwable
    //   174	182	351	java/lang/Throwable
    //   182	191	351	java/lang/Throwable
    //   196	204	351	java/lang/Throwable
    //   207	244	351	java/lang/Throwable
    //   257	265	351	java/lang/Throwable
    //   270	285	351	java/lang/Throwable
    //   289	296	351	java/lang/Throwable
    //   300	306	351	java/lang/Throwable
  }
  
  /* Error */
  public static JSONArray c(@NonNull PlayActionTask paramPlayActionTask)
  {
    // Byte code:
    //   0: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: new 117	org/json/JSONArray
    //   7: dup
    //   8: invokespecial 118	org/json/JSONArray:<init>	()V
    //   11: astore 6
    //   13: aload_0
    //   14: aload_0
    //   15: invokevirtual 155	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:g	()Ljava/lang/String;
    //   18: iconst_1
    //   19: iconst_0
    //   20: invokestatic 654	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;Ljava/lang/String;ZZ)Lorg/json/JSONObject;
    //   23: astore 7
    //   25: aload_0
    //   26: invokevirtual 123	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:a	()I
    //   29: iconst_1
    //   30: invokestatic 128	com/tencent/mobileqq/apollo/aio/api/impl/CmShowAioMatcherImpl:judgeSupported	(II)Z
    //   33: ifne +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 436	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:k	()I
    //   40: iconst_1
    //   41: if_icmpne +234 -> 275
    //   44: goto +3 -> 47
    //   47: aload_0
    //   48: aload_0
    //   49: invokevirtual 356	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:h	()Ljava/lang/String;
    //   52: iconst_0
    //   53: iconst_0
    //   54: invokestatic 654	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;Ljava/lang/String;ZZ)Lorg/json/JSONObject;
    //   57: astore 5
    //   59: aload 7
    //   61: ifnull +44 -> 105
    //   64: aload 6
    //   66: aload 7
    //   68: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   71: pop
    //   72: aload_0
    //   73: invokevirtual 140	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:a	()Z
    //   76: ifne +29 -> 105
    //   79: aload_0
    //   80: invokevirtual 155	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:g	()Ljava/lang/String;
    //   83: aload_0
    //   84: iconst_1
    //   85: invokestatic 143	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   88: astore 8
    //   90: aload 8
    //   92: ifnull +13 -> 105
    //   95: aload 7
    //   97: ldc 145
    //   99: aload 8
    //   101: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   104: pop
    //   105: aload 5
    //   107: ifnull +41 -> 148
    //   110: aload 6
    //   112: aload 5
    //   114: invokevirtual 152	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   117: pop
    //   118: aload_0
    //   119: invokevirtual 140	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:a	()Z
    //   122: ifne +26 -> 148
    //   125: aload_0
    //   126: invokevirtual 356	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:h	()Ljava/lang/String;
    //   129: aload_0
    //   130: iconst_0
    //   131: invokestatic 143	com/tencent/mobileqq/cmshow/brickengine/BKScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   134: astore_0
    //   135: aload_0
    //   136: ifnull +12 -> 148
    //   139: aload 5
    //   141: ldc 145
    //   143: aload_0
    //   144: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   151: lstore_3
    //   152: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +28 -> 183
    //   158: ldc 99
    //   160: iconst_2
    //   161: iconst_2
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: ldc_w 656
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: lload_3
    //   174: lload_1
    //   175: lsub
    //   176: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   179: aastore
    //   180: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   183: aload 6
    //   185: areturn
    //   186: astore_0
    //   187: goto +51 -> 238
    //   190: astore_0
    //   191: ldc 99
    //   193: iconst_1
    //   194: ldc_w 658
    //   197: aload_0
    //   198: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   204: lstore_3
    //   205: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +28 -> 236
    //   211: ldc 99
    //   213: iconst_2
    //   214: iconst_2
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: ldc_w 656
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: lload_3
    //   227: lload_1
    //   228: lsub
    //   229: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   232: aastore
    //   233: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   236: aconst_null
    //   237: areturn
    //   238: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   241: lstore_3
    //   242: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +28 -> 273
    //   248: ldc 99
    //   250: iconst_2
    //   251: iconst_2
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: ldc_w 656
    //   260: aastore
    //   261: dup
    //   262: iconst_1
    //   263: lload_3
    //   264: lload_1
    //   265: lsub
    //   266: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: aastore
    //   270: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   273: aload_0
    //   274: athrow
    //   275: aconst_null
    //   276: astore 5
    //   278: goto -219 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramPlayActionTask	PlayActionTask
    //   3	262	1	l1	long
    //   151	113	3	l2	long
    //   57	220	5	localJSONObject1	JSONObject
    //   11	173	6	localJSONArray	JSONArray
    //   23	73	7	localJSONObject2	JSONObject
    //   88	12	8	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   4	44	186	finally
    //   47	59	186	finally
    //   64	90	186	finally
    //   95	105	186	finally
    //   110	135	186	finally
    //   139	148	186	finally
    //   191	201	186	finally
    //   4	44	190	java/lang/Throwable
    //   47	59	190	java/lang/Throwable
    //   64	90	190	java/lang/Throwable
    //   95	105	190	java/lang/Throwable
    //   110	135	190	java/lang/Throwable
    //   139	148	190	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKScriptUtils
 * JD-Core Version:    0.7.0.1
 */