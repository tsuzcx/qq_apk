package com.tencent.mobileqq.cmshow.engine.script;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask;
import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask.RoleInfo;
import com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScriptUtils
{
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    String str;
    if (TextUtils.isEmpty(paramString1)) {
      str = ApolloUtilImpl.getApolloId(paramInt);
    } else {
      str = paramString1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getRemoveBubbleJs], apolloId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",bubbleName");
      localStringBuilder.append(paramString2);
      QLog.d("[cmshow][ScriptUtils]", 2, localStringBuilder.toString());
    }
    paramString1 = String.format("if(%s) {%s.removeAccessory('%s')};", new Object[] { str, str, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][ScriptUtils]", 2, new Object[] { "getRemoveBubbleJs", paramString1 });
    }
    return paramString1;
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopFrameRecord(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
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
  
  private static String a(boolean paramBoolean, String paramString, int paramInt, IApolloResManager paramIApolloResManager)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).optJSONObject("action");
      bool2 = false;
      String str;
      if (paramBoolean)
      {
        str = localJSONObject.optString("actionId");
        localObject = str;
        if (localJSONObject.optInt("actionPlatform") <= 0) {
          break label281;
        }
        localObject = str;
      }
      else
      {
        str = localJSONObject.optString("actionPeerId");
        localObject = str;
        if (localJSONObject.optInt("actionPeerPlatform") <= 0) {
          break label281;
        }
        localObject = str;
      }
    }
    catch (Exception paramIApolloResManager)
    {
      for (;;)
      {
        boolean bool2;
        Object localObject;
        continue;
        boolean bool1 = true;
        continue;
        bool1 = false;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!paramBoolean) {
        bool2 = true;
      }
      if (paramIApolloResManager.a(paramInt, bool2, Integer.parseInt((String)localObject), bool1))
      {
        paramIApolloResManager = new StringBuilder();
        paramIApolloResManager.append(File.separator);
        paramIApolloResManager.append((String)localObject);
        localObject = paramIApolloResManager.toString();
        paramIApolloResManager = (IApolloResManager)localObject;
        if (bool1)
        {
          paramIApolloResManager = new StringBuilder();
          paramIApolloResManager.append((String)localObject);
          paramIApolloResManager.append(File.separator);
          paramIApolloResManager.append("android");
          paramIApolloResManager = paramIApolloResManager.toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramIApolloResManager);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append("action");
        paramIApolloResManager = ((StringBuilder)localObject).toString();
        return paramIApolloResManager;
        paramIApolloResManager = new StringBuilder();
        paramIApolloResManager.append("[random] the json is not right,");
        paramIApolloResManager.append(paramString);
        QLog.e("[cmshow][ScriptUtils]", 1, paramIApolloResManager.toString());
      }
    }
    return null;
  }
  
  public static StringBuilder a(MessageForApollo paramMessageForApollo, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", paramMessageForApollo.mApolloMessage.id);
    if (paramMessageForApollo.mApolloMessage.name != null) {
      localJSONObject.put("name", SpriteUtil.a(Base64Util.encodeToString(paramMessageForApollo.mApolloMessage.name, 0)));
    }
    if (paramMessageForApollo.mApolloMessage.text != null) {
      localJSONObject.put("atText", SpriteUtil.a(Base64Util.encodeToString(paramMessageForApollo.mApolloMessage.text, 0)));
    }
    localJSONObject.put("peerUin", paramMessageForApollo.mApolloMessage.peerUin);
    if (!TextUtils.isEmpty(paramMessageForApollo.mApolloMessage.extStr)) {
      localJSONObject.put("extraStr", new JSONObject(paramMessageForApollo.mApolloMessage.extStr));
    }
    Object localObject = paramMessageForApollo.mApolloMessage;
    ((ApolloMessage)localObject).flag |= 0x200;
    localJSONObject.put("model", ApolloActionData.getModelString(paramMessageForApollo.mApolloMessage.id));
    localJSONObject.put("flag", paramMessageForApollo.mApolloMessage.flag);
    localJSONObject.put("senderTS", paramMessageForApollo.mApolloMessage.senderTs);
    localJSONObject.put("peerTS", paramMessageForApollo.mApolloMessage.peerTs);
    localJSONObject.put("senderStatus", paramMessageForApollo.mApolloMessage.senderStatus);
    localJSONObject.put("peerStatus", paramMessageForApollo.mApolloMessage.peerStatus);
    localJSONObject.put("curUsedIdType", paramMessageForApollo.curUsedIdType);
    if (8 == paramMessageForApollo.actionType)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramMessageForApollo.mApolloMessage.id);
      localJSONObject.put("actionRootPath", ((StringBuilder)localObject).toString());
      localJSONObject.put("isSend", paramBoolean);
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("type", paramMessageForApollo.actionType);
    ((JSONObject)localObject).put("basicMsg", localJSONObject);
    paramMessageForApollo = new StringBuilder();
    paramMessageForApollo.append("sendMsg");
    paramMessageForApollo.append("('");
    paramMessageForApollo.append(((JSONObject)localObject).toString());
    paramMessageForApollo.append("');");
    return paramMessageForApollo;
  }
  
  /* Error */
  public static JSONArray a(@NonNull PlayActionTask paramPlayActionTask)
  {
    // Byte code:
    //   0: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: new 268	org/json/JSONArray
    //   7: dup
    //   8: invokespecial 269	org/json/JSONArray:<init>	()V
    //   11: astore 6
    //   13: aload_0
    //   14: invokevirtual 274	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:e	()I
    //   17: iconst_1
    //   18: invokestatic 279	com/tencent/mobileqq/apollo/aio/api/impl/CmShowAioMatcherImpl:judgeSupported	(II)Z
    //   21: istore 5
    //   23: iload 5
    //   25: ifeq +106 -> 131
    //   28: aload_0
    //   29: invokevirtual 282	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:g	()Ljava/lang/String;
    //   32: aload_0
    //   33: iconst_1
    //   34: aconst_null
    //   35: iconst_1
    //   36: invokestatic 285	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;ZLjava/lang/String;Z)Lorg/json/JSONObject;
    //   39: astore 7
    //   41: aload_0
    //   42: invokevirtual 288	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:f	()Ljava/lang/String;
    //   45: aload_0
    //   46: iconst_0
    //   47: aconst_null
    //   48: iconst_1
    //   49: invokestatic 285	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;ZLjava/lang/String;Z)Lorg/json/JSONObject;
    //   52: astore 8
    //   54: aload_0
    //   55: invokevirtual 291	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:h	()Z
    //   58: ifne +54 -> 112
    //   61: aload_0
    //   62: invokevirtual 282	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:g	()Ljava/lang/String;
    //   65: aload_0
    //   66: iconst_1
    //   67: invokestatic 294	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   70: astore 9
    //   72: aload_0
    //   73: invokevirtual 288	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:f	()Ljava/lang/String;
    //   76: aload_0
    //   77: iconst_0
    //   78: invokestatic 294	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   81: astore_0
    //   82: aload 9
    //   84: ifnull +14 -> 98
    //   87: aload 7
    //   89: ldc_w 296
    //   92: aload 9
    //   94: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: aload_0
    //   99: ifnull +13 -> 112
    //   102: aload 8
    //   104: ldc_w 296
    //   107: aload_0
    //   108: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload 6
    //   114: aload 7
    //   116: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   119: pop
    //   120: aload 6
    //   122: aload 8
    //   124: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   127: pop
    //   128: goto +55 -> 183
    //   131: aload_0
    //   132: invokevirtual 302	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:n	()Ljava/lang/String;
    //   135: aload_0
    //   136: iconst_1
    //   137: aconst_null
    //   138: iconst_1
    //   139: invokestatic 285	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;ZLjava/lang/String;Z)Lorg/json/JSONObject;
    //   142: astore 7
    //   144: aload_0
    //   145: invokevirtual 291	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:h	()Z
    //   148: ifne +27 -> 175
    //   151: aload_0
    //   152: invokevirtual 282	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:g	()Ljava/lang/String;
    //   155: aload_0
    //   156: iconst_1
    //   157: invokestatic 294	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +13 -> 175
    //   165: aload 7
    //   167: ldc_w 296
    //   170: aload_0
    //   171: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload 6
    //   177: aload 7
    //   179: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   182: pop
    //   183: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   186: lstore_3
    //   187: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +28 -> 218
    //   193: ldc 42
    //   195: iconst_2
    //   196: iconst_2
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: ldc_w 304
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: lload_3
    //   209: lload_1
    //   210: lsub
    //   211: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   214: aastore
    //   215: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   218: aload 6
    //   220: areturn
    //   221: astore_0
    //   222: goto +51 -> 273
    //   225: astore_0
    //   226: ldc 42
    //   228: iconst_1
    //   229: ldc_w 312
    //   232: aload_0
    //   233: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   239: lstore_3
    //   240: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +28 -> 271
    //   246: ldc 42
    //   248: iconst_2
    //   249: iconst_2
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: ldc_w 304
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: lload_3
    //   262: lload_1
    //   263: lsub
    //   264: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   267: aastore
    //   268: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   271: aconst_null
    //   272: areturn
    //   273: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   276: lstore_3
    //   277: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +28 -> 308
    //   283: ldc 42
    //   285: iconst_2
    //   286: iconst_2
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: ldc_w 304
    //   295: aastore
    //   296: dup
    //   297: iconst_1
    //   298: lload_3
    //   299: lload_1
    //   300: lsub
    //   301: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   304: aastore
    //   305: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   308: aload_0
    //   309: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramPlayActionTask	PlayActionTask
    //   3	297	1	l1	long
    //   186	113	3	l2	long
    //   21	3	5	bool	boolean
    //   11	208	6	localJSONArray	JSONArray
    //   39	139	7	localJSONObject1	JSONObject
    //   52	71	8	localJSONObject2	JSONObject
    //   70	23	9	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   4	23	221	finally
    //   28	82	221	finally
    //   87	98	221	finally
    //   102	112	221	finally
    //   112	128	221	finally
    //   131	161	221	finally
    //   165	175	221	finally
    //   175	183	221	finally
    //   226	236	221	finally
    //   4	23	225	java/lang/Throwable
    //   28	82	225	java/lang/Throwable
    //   87	98	225	java/lang/Throwable
    //   102	112	225	java/lang/Throwable
    //   112	128	225	java/lang/Throwable
    //   131	161	225	java/lang/Throwable
    //   165	175	225	java/lang/Throwable
    //   175	183	225	java/lang/Throwable
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
      ((SpriteTaskParam)localObject2).i = paramPlayActionTask.e();
      ((SpriteTaskParam)localObject2).c = 1;
      if (!paramPlayActionTask.d().a(paramPlayActionTask.w(), paramPlayActionTask.c(), paramPlayActionTask.l(), paramPlayActionTask.e(), paramPlayActionTask.y(), paramPlayActionTask.p(), paramPlayActionTask.z())) {
        return null;
      }
      localObject1 = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt1);
      if (localObject1 == null) {
        return null;
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("actionId", paramInt1);
      boolean bool = CmShowAioMatcherImpl.judgeSupported(paramPlayActionTask.e(), 2);
      ((JSONObject)localObject2).put("action", ApolloActionHelperImpl.getWhiteFaceRscPath(paramInt1, paramInt2, true, bool)[0]);
      int i = ((ApolloActionData)localObject1).personNum;
      if (i == 1) {
        ((JSONObject)localObject2).put("actionPeer", ApolloActionHelperImpl.getWhiteFaceRscPath(paramInt1, paramInt2, false, bool)[0]);
      } else {
        ((JSONObject)localObject2).put("actionPeer", "");
      }
      if (CmShowAioMatcherImpl.judgeSupported(paramPlayActionTask.e(), 1))
      {
        ((JSONObject)localObject2).put("actionDis", ((ApolloActionData)localObject1).actionMoveDis * (float)DeviceInfoUtil.E() / 7.0F / 368.0F);
        ((JSONObject)localObject2).put("actionPeerDis", ((ApolloActionData)localObject1).peerMoveDis * (float)DeviceInfoUtil.E() / 7.0F / 368.0F);
        return localObject2;
      }
      ((JSONObject)localObject2).put("posType", ((ApolloActionData)localObject1).playArea);
      return localObject2;
    }
    catch (Throwable paramPlayActionTask)
    {
      QLog.e("[cmshow][ScriptUtils]", 1, "[getWhiteFaceSingleAction],", paramPlayActionTask);
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
        if ((paramPlayActionTask.k()) && (paramPlayActionTask.c() > 0))
        {
          paramString = (String)localObject;
          JSONObject localJSONObject = a(str, paramPlayActionTask, SpriteUtil.a(str, paramPlayActionTask.n(), paramPlayActionTask.o(), paramBoolean1), paramString, paramPlayActionTask.t());
          if ((paramPlayActionTask.h()) && (localJSONObject != null)) {
            localJSONObject.put("model", localObject);
          }
          localObject = paramPlayActionTask.d();
          if ((paramPlayActionTask.t()) && (!((IApolloResManager)localObject).a(paramPlayActionTask.w(), paramPlayActionTask.c(), paramPlayActionTask.l(), paramPlayActionTask.e(), paramPlayActionTask.y(), paramPlayActionTask.p(), paramPlayActionTask.z()))) {
            return localJSONObject;
          }
          ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
          j = localApolloManagerServiceImpl.getCmShowStatus(str);
          int k = ((Integer)ApolloActionHelperImpl.get3DRoleDressIdByUin(str, j, localQQAppInterface, true, localObject)[0]).intValue();
          paramString = str;
          if (localApolloManagerServiceImpl.getCmShowStatus(str, false) == 0)
          {
            paramString = str;
            if (paramPlayActionTask.k())
            {
              if (!((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(localQQAppInterface, str)) {
                break label649;
              }
              paramString = "-2";
            }
          }
          paramString = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, localQQAppInterface, true, (IApolloResManager)localObject);
          if (paramString != null)
          {
            if (paramString.length != 2) {
              return null;
            }
            int m = ((Integer)paramString[0]).intValue();
            if (localJSONObject != null)
            {
              if (!paramBoolean1) {
                break label656;
              }
              i = 1;
              localJSONObject.put("isMaster", i);
              if ((paramBoolean1) && (!TextUtils.isEmpty(paramPlayActionTask.u())))
              {
                localJSONObject.put("text", SpriteUtil.a(Base64Util.encodeToString(paramPlayActionTask.u().getBytes("utf-8"), 0)));
                boolean bool = paramPlayActionTask.v();
                if (!bool)
                {
                  localJSONObject.put("bubbleType", 0);
                  if ((j == 1) && (paramPlayActionTask.c() > ApolloConstant.f) && (localApolloManagerServiceImpl.is3dAvailable()))
                  {
                    i = 2;
                  }
                  else
                  {
                    if ((j != 2) || (paramPlayActionTask.c() >= ApolloConstant.f)) {
                      break label662;
                    }
                    i = 1;
                  }
                  localJSONObject.put("bubble", a(paramPlayActionTask.u(), m, i));
                }
                else
                {
                  localJSONObject.put("bubbleType", 1);
                }
              }
              int n = paramPlayActionTask.w();
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
                if ((paramPlayActionTask.x() == 0) && (CmShowAioMatcherImpl.judgeSupported(paramPlayActionTask.e(), 1)) && (!paramBoolean1) && (!paramBoolean2)) {
                  return localJSONObject;
                }
                str = paramString[0];
                paramString = str;
                if (8 == paramPlayActionTask.l())
                {
                  paramString = str;
                  if (!TextUtils.isEmpty(paramPlayActionTask.p()))
                  {
                    paramPlayActionTask = a(paramBoolean1, paramPlayActionTask.p(), paramPlayActionTask.c(), (IApolloResManager)localObject);
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
        QLog.e("[cmshow][ScriptUtils]", 1, paramPlayActionTask, new Object[0]);
        return null;
      }
      paramString = null;
      continue;
      label649:
      paramString = "-1";
      continue;
      label656:
      int i = 0;
      continue;
      label662:
      i = j;
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString, AbsScriptTask paramAbsScriptTask, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 501
    //   3: astore 10
    //   5: new 99	org/json/JSONObject
    //   8: dup
    //   9: invokespecial 149	org/json/JSONObject:<init>	()V
    //   12: astore 13
    //   14: new 503	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 504	java/util/ArrayList:<init>	()V
    //   21: astore 15
    //   23: invokestatic 321	com/tencent/mobileqq/apollo/utils/api/impl/ApolloUtilImpl:getQQApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: astore 14
    //   28: iconst_0
    //   29: istore_3
    //   30: aload 14
    //   32: ldc_w 425
    //   35: ldc_w 361
    //   38: invokevirtual 367	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   41: checkcast 427	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   44: astore 9
    //   46: aload 14
    //   48: ldc_w 359
    //   51: ldc_w 361
    //   54: invokevirtual 367	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   57: checkcast 369	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   60: aload_0
    //   61: invokevirtual 508	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:getApolloBaseInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;
    //   64: astore 16
    //   66: aload 16
    //   68: ifnonnull +5 -> 73
    //   71: aconst_null
    //   72: areturn
    //   73: aload 16
    //   75: invokevirtual 514	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:getApolloPetDress	()Lcom/tencent/mobileqq/apollo/model/ApolloDress;
    //   78: astore 17
    //   80: aload 17
    //   82: ifnull +879 -> 961
    //   85: aload 16
    //   87: getfield 518	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:hasPet	Z
    //   90: ifeq +871 -> 961
    //   93: aload 17
    //   95: getfield 524	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   98: ifnull +863 -> 961
    //   101: aload 17
    //   103: getfield 524	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   106: invokevirtual 528	java/util/HashMap:isEmpty	()Z
    //   109: ifne +852 -> 961
    //   112: aload 13
    //   114: ldc_w 530
    //   117: iconst_0
    //   118: aload 17
    //   120: getfield 533	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   123: invokestatic 537	com/tencent/mobileqq/apollo/utils/api/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   126: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload_1
    //   131: invokevirtual 540	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:d	()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;
    //   134: astore 18
    //   136: aload 18
    //   138: iconst_1
    //   139: aload 17
    //   141: getfield 533	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   144: invokeinterface 543 3 0
    //   149: istore 8
    //   151: iload 8
    //   153: ifne +30 -> 183
    //   156: aload 17
    //   158: getfield 533	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   161: istore 4
    //   163: iconst_0
    //   164: istore_3
    //   165: goto +23 -> 188
    //   168: astore 11
    //   170: iconst_m1
    //   171: istore 4
    //   173: iconst_0
    //   174: istore_3
    //   175: goto +993 -> 1168
    //   178: astore 11
    //   180: goto +815 -> 995
    //   183: iconst_1
    //   184: istore_3
    //   185: iconst_m1
    //   186: istore 4
    //   188: aload 17
    //   190: getfield 524	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   193: invokevirtual 546	java/util/HashMap:size	()I
    //   196: newarray int
    //   198: astore 12
    //   200: aload 17
    //   202: getfield 524	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   205: invokevirtual 550	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   208: invokeinterface 556 1 0
    //   213: astore 11
    //   215: iconst_0
    //   216: istore 5
    //   218: aload 11
    //   220: invokeinterface 561 1 0
    //   225: ifeq +38 -> 263
    //   228: aload 12
    //   230: iload 5
    //   232: aload 11
    //   234: invokeinterface 565 1 0
    //   239: checkcast 567	java/util/Map$Entry
    //   242: invokeinterface 570 1 0
    //   247: checkcast 126	java/lang/Integer
    //   250: invokevirtual 437	java/lang/Integer:intValue	()I
    //   253: iastore
    //   254: iload 5
    //   256: iconst_1
    //   257: iadd
    //   258: istore 5
    //   260: goto -42 -> 218
    //   263: new 268	org/json/JSONArray
    //   266: dup
    //   267: invokespecial 269	org/json/JSONArray:<init>	()V
    //   270: astore 19
    //   272: aload 12
    //   274: arraylength
    //   275: istore 5
    //   277: iconst_0
    //   278: istore 6
    //   280: iload 6
    //   282: iload 5
    //   284: if_icmpge +107 -> 391
    //   287: aload 12
    //   289: iload 6
    //   291: iaload
    //   292: istore 7
    //   294: aload 10
    //   296: astore 11
    //   298: aload 19
    //   300: iconst_1
    //   301: iload 7
    //   303: invokestatic 537	com/tencent/mobileqq/apollo/utils/api/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   306: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   309: pop
    //   310: aload 18
    //   312: iconst_2
    //   313: iload 7
    //   315: invokeinterface 543 3 0
    //   320: istore 8
    //   322: iload 8
    //   324: ifne +49 -> 373
    //   327: aload 15
    //   329: iload 7
    //   331: invokestatic 573	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: invokeinterface 579 2 0
    //   339: pop
    //   340: iconst_0
    //   341: istore_3
    //   342: goto +31 -> 373
    //   345: astore 12
    //   347: aload 11
    //   349: astore 10
    //   351: aload 12
    //   353: astore 11
    //   355: goto -182 -> 173
    //   358: astore 12
    //   360: aload 11
    //   362: astore 10
    //   364: iconst_0
    //   365: istore_3
    //   366: aload 12
    //   368: astore 11
    //   370: goto +628 -> 998
    //   373: iload 6
    //   375: iconst_1
    //   376: iadd
    //   377: istore 6
    //   379: aload 11
    //   381: astore 10
    //   383: goto -103 -> 280
    //   386: astore 11
    //   388: goto +610 -> 998
    //   391: aload 10
    //   393: astore 11
    //   395: aload 13
    //   397: ldc_w 581
    //   400: aload 19
    //   402: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   405: pop
    //   406: aload 13
    //   408: ldc_w 582
    //   411: aload 17
    //   413: getfield 533	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   416: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 17
    //   422: getfield 533	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   425: ldc_w 584
    //   428: aload 18
    //   430: invokestatic 589	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)Ljava/lang/String;
    //   433: astore 12
    //   435: aload 17
    //   437: getfield 533	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   440: ldc_w 591
    //   443: aload 18
    //   445: invokestatic 589	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)Ljava/lang/String;
    //   448: astore 19
    //   450: aload 12
    //   452: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   455: istore 8
    //   457: iload 8
    //   459: ifne +33 -> 492
    //   462: aload 19
    //   464: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   467: ifne +25 -> 492
    //   470: aload 13
    //   472: ldc_w 593
    //   475: aload 19
    //   477: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   480: pop
    //   481: aload 13
    //   483: ldc_w 595
    //   486: aload 12
    //   488: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   491: pop
    //   492: aload 17
    //   494: getfield 533	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   497: aload 18
    //   499: invokestatic 598	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)Ljava/lang/String;
    //   502: astore 12
    //   504: aload 12
    //   506: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   509: istore 8
    //   511: iload 8
    //   513: ifne +14 -> 527
    //   516: aload 13
    //   518: ldc_w 600
    //   521: aload 12
    //   523: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   526: pop
    //   527: aload 16
    //   529: getfield 603	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   532: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   535: istore 8
    //   537: iload 8
    //   539: ifne +37 -> 576
    //   542: aload_1
    //   543: invokevirtual 605	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:i	()I
    //   546: ifne +30 -> 576
    //   549: aload 13
    //   551: ldc_w 607
    //   554: aload 16
    //   556: getfield 603	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   559: ldc_w 466
    //   562: invokevirtual 470	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   565: iconst_0
    //   566: invokestatic 177	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   569: invokestatic 181	com/tencent/mobileqq/apollo/script/SpriteUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   572: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   575: pop
    //   576: aload 16
    //   578: getfield 610	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBgImgPath	Ljava/lang/String;
    //   581: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: istore 8
    //   586: iload 8
    //   588: ifne +24 -> 612
    //   591: aload_1
    //   592: invokevirtual 605	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:i	()I
    //   595: ifne +17 -> 612
    //   598: aload 13
    //   600: ldc_w 612
    //   603: aload 16
    //   605: getfield 610	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBgImgPath	Ljava/lang/String;
    //   608: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   611: pop
    //   612: aload 16
    //   614: getfield 615	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBallImgPath	Ljava/lang/String;
    //   617: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   620: istore 8
    //   622: iload 8
    //   624: ifne +24 -> 648
    //   627: aload_1
    //   628: invokevirtual 605	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:i	()I
    //   631: ifne +17 -> 648
    //   634: aload 13
    //   636: ldc_w 617
    //   639: aload 16
    //   641: getfield 615	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBallImgPath	Ljava/lang/String;
    //   644: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   647: pop
    //   648: aload 16
    //   650: getfield 620	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mLevel	Ljava/lang/String;
    //   653: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   656: istore 8
    //   658: iload 8
    //   660: ifne +24 -> 684
    //   663: aload_1
    //   664: invokevirtual 605	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:i	()I
    //   667: ifne +17 -> 684
    //   670: aload 13
    //   672: ldc_w 622
    //   675: aload 16
    //   677: getfield 620	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mLevel	Ljava/lang/String;
    //   680: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   683: pop
    //   684: aload 13
    //   686: ldc_w 624
    //   689: aload 9
    //   691: getfield 627	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPetConfig	Ljava/lang/String;
    //   694: aload 17
    //   696: getfield 533	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   699: iload_2
    //   700: invokestatic 630	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   703: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   706: pop
    //   707: aload_1
    //   708: invokevirtual 634	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:j	()Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo;
    //   711: astore 12
    //   713: aload 12
    //   715: ifnull +54 -> 769
    //   718: aload 13
    //   720: ldc_w 636
    //   723: aload_1
    //   724: invokevirtual 634	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:j	()Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo;
    //   727: getfield 640	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo:a	F
    //   730: f2d
    //   731: invokevirtual 398	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   734: pop
    //   735: aload 13
    //   737: ldc_w 642
    //   740: aload_1
    //   741: invokevirtual 634	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:j	()Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo;
    //   744: getfield 644	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo:b	F
    //   747: f2d
    //   748: invokevirtual 398	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   751: pop
    //   752: aload 13
    //   754: ldc_w 646
    //   757: aload_1
    //   758: invokevirtual 634	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:j	()Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo;
    //   761: getfield 648	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask$RoleInfo:c	F
    //   764: f2d
    //   765: invokevirtual 398	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   768: pop
    //   769: iload_3
    //   770: ifeq +10 -> 780
    //   773: aload 13
    //   775: astore 10
    //   777: goto +6 -> 783
    //   780: aconst_null
    //   781: astore 10
    //   783: iload_3
    //   784: ifne +146 -> 930
    //   787: aload 14
    //   789: ifnull +141 -> 930
    //   792: new 31	java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   799: astore 12
    //   801: aload 12
    //   803: ldc_w 650
    //   806: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 12
    //   812: aload_0
    //   813: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: ldc_w 652
    //   820: iconst_1
    //   821: aload 12
    //   823: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: aload 9
    //   831: ifnull +99 -> 930
    //   834: aload 15
    //   836: invokeinterface 653 1 0
    //   841: newarray int
    //   843: astore 9
    //   845: aload 15
    //   847: invokeinterface 654 1 0
    //   852: astore 12
    //   854: iconst_0
    //   855: istore_3
    //   856: aload 12
    //   858: invokeinterface 561 1 0
    //   863: ifeq +27 -> 890
    //   866: aload 9
    //   868: iload_3
    //   869: aload 12
    //   871: invokeinterface 565 1 0
    //   876: checkcast 126	java/lang/Integer
    //   879: invokevirtual 437	java/lang/Integer:intValue	()I
    //   882: iastore
    //   883: iload_3
    //   884: iconst_1
    //   885: iadd
    //   886: istore_3
    //   887: goto -31 -> 856
    //   890: aload_1
    //   891: ifnull +30 -> 921
    //   894: aload_1
    //   895: invokevirtual 540	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:d	()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;
    //   898: invokeinterface 657 1 0
    //   903: aload 14
    //   905: aload_0
    //   906: iload 4
    //   908: aload 9
    //   910: iconst_m1
    //   911: iconst_m1
    //   912: iconst_1
    //   913: invokeinterface 662 8 0
    //   918: aload 10
    //   920: areturn
    //   921: ldc_w 652
    //   924: iconst_1
    //   925: aload 11
    //   927: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: aload 10
    //   932: areturn
    //   933: astore 11
    //   935: goto +18 -> 953
    //   938: astore 12
    //   940: aload 11
    //   942: astore 10
    //   944: aload 12
    //   946: astore 11
    //   948: goto +50 -> 998
    //   951: astore 11
    //   953: goto +215 -> 1168
    //   956: astore 11
    //   958: goto +40 -> 998
    //   961: aconst_null
    //   962: areturn
    //   963: astore 11
    //   965: goto +15 -> 980
    //   968: astore 11
    //   970: iconst_1
    //   971: istore_3
    //   972: goto +23 -> 995
    //   975: astore 11
    //   977: aconst_null
    //   978: astore 9
    //   980: iconst_m1
    //   981: istore 4
    //   983: iconst_1
    //   984: istore_3
    //   985: goto +183 -> 1168
    //   988: astore 11
    //   990: iconst_1
    //   991: istore_3
    //   992: aconst_null
    //   993: astore 9
    //   995: iconst_m1
    //   996: istore 4
    //   998: iconst_0
    //   999: istore 5
    //   1001: ldc 42
    //   1003: iconst_1
    //   1004: aload 11
    //   1006: iconst_0
    //   1007: anewarray 4	java/lang/Object
    //   1010: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1013: iload_3
    //   1014: ifne +147 -> 1161
    //   1017: aload 14
    //   1019: ifnull +142 -> 1161
    //   1022: new 31	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   1029: astore 11
    //   1031: aload 11
    //   1033: ldc_w 650
    //   1036: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload 11
    //   1042: aload_0
    //   1043: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: ldc_w 652
    //   1050: iconst_1
    //   1051: aload 11
    //   1053: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1059: aload 9
    //   1061: ifnull +100 -> 1161
    //   1064: aload 15
    //   1066: invokeinterface 653 1 0
    //   1071: newarray int
    //   1073: astore 9
    //   1075: aload 15
    //   1077: invokeinterface 654 1 0
    //   1082: astore 11
    //   1084: iload 5
    //   1086: istore_3
    //   1087: aload 11
    //   1089: invokeinterface 561 1 0
    //   1094: ifeq +27 -> 1121
    //   1097: aload 9
    //   1099: iload_3
    //   1100: aload 11
    //   1102: invokeinterface 565 1 0
    //   1107: checkcast 126	java/lang/Integer
    //   1110: invokevirtual 437	java/lang/Integer:intValue	()I
    //   1113: iastore
    //   1114: iload_3
    //   1115: iconst_1
    //   1116: iadd
    //   1117: istore_3
    //   1118: goto -31 -> 1087
    //   1121: aload_1
    //   1122: ifnull +30 -> 1152
    //   1125: aload_1
    //   1126: invokevirtual 540	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:d	()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;
    //   1129: invokeinterface 657 1 0
    //   1134: aload 14
    //   1136: aload_0
    //   1137: iload 4
    //   1139: aload 9
    //   1141: iconst_m1
    //   1142: iconst_m1
    //   1143: iconst_1
    //   1144: invokeinterface 662 8 0
    //   1149: goto +12 -> 1161
    //   1152: ldc_w 652
    //   1155: iconst_1
    //   1156: aload 10
    //   1158: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1161: aconst_null
    //   1162: areturn
    //   1163: astore 11
    //   1165: goto +3 -> 1168
    //   1168: iconst_0
    //   1169: istore 5
    //   1171: iload_3
    //   1172: ifne +147 -> 1319
    //   1175: aload 14
    //   1177: ifnull +142 -> 1319
    //   1180: new 31	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   1187: astore 12
    //   1189: aload 12
    //   1191: ldc_w 650
    //   1194: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: pop
    //   1198: aload 12
    //   1200: aload_0
    //   1201: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: ldc_w 652
    //   1208: iconst_1
    //   1209: aload 12
    //   1211: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1214: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1217: aload 9
    //   1219: ifnull +100 -> 1319
    //   1222: aload 15
    //   1224: invokeinterface 653 1 0
    //   1229: newarray int
    //   1231: astore 9
    //   1233: aload 15
    //   1235: invokeinterface 654 1 0
    //   1240: astore 12
    //   1242: iload 5
    //   1244: istore_3
    //   1245: aload 12
    //   1247: invokeinterface 561 1 0
    //   1252: ifeq +27 -> 1279
    //   1255: aload 9
    //   1257: iload_3
    //   1258: aload 12
    //   1260: invokeinterface 565 1 0
    //   1265: checkcast 126	java/lang/Integer
    //   1268: invokevirtual 437	java/lang/Integer:intValue	()I
    //   1271: iastore
    //   1272: iload_3
    //   1273: iconst_1
    //   1274: iadd
    //   1275: istore_3
    //   1276: goto -31 -> 1245
    //   1279: aload_1
    //   1280: ifnull +30 -> 1310
    //   1283: aload_1
    //   1284: invokevirtual 540	com/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask:d	()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;
    //   1287: invokeinterface 657 1 0
    //   1292: aload 14
    //   1294: aload_0
    //   1295: iload 4
    //   1297: aload 9
    //   1299: iconst_m1
    //   1300: iconst_m1
    //   1301: iconst_1
    //   1302: invokeinterface 662 8 0
    //   1307: goto +12 -> 1319
    //   1310: ldc_w 652
    //   1313: iconst_1
    //   1314: aload 10
    //   1316: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1319: goto +6 -> 1325
    //   1322: aload 11
    //   1324: athrow
    //   1325: goto -3 -> 1322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1328	0	paramString	String
    //   0	1328	1	paramAbsScriptTask	AbsScriptTask
    //   0	1328	2	paramBoolean	boolean
    //   29	1247	3	i	int
    //   161	1135	4	j	int
    //   216	1027	5	k	int
    //   278	100	6	m	int
    //   292	38	7	n	int
    //   149	510	8	bool	boolean
    //   44	1254	9	localObject1	Object
    //   3	1312	10	localObject2	Object
    //   168	1	11	localObject3	Object
    //   178	1	11	localThrowable1	Throwable
    //   213	167	11	localObject4	Object
    //   386	1	11	localThrowable2	Throwable
    //   393	533	11	localObject5	Object
    //   933	8	11	localObject6	Object
    //   946	1	11	localObject7	Object
    //   951	1	11	localObject8	Object
    //   956	1	11	localThrowable3	Throwable
    //   963	1	11	localObject9	Object
    //   968	1	11	localThrowable4	Throwable
    //   975	1	11	localObject10	Object
    //   988	17	11	localThrowable5	Throwable
    //   1029	72	11	localObject11	Object
    //   1163	160	11	localObject12	Object
    //   198	90	12	arrayOfInt	int[]
    //   345	7	12	localObject13	Object
    //   358	9	12	localThrowable6	Throwable
    //   433	437	12	localObject14	Object
    //   938	7	12	localThrowable7	Throwable
    //   1187	72	12	localObject15	Object
    //   12	762	13	localJSONObject	JSONObject
    //   26	1267	14	localQQAppInterface	QQAppInterface
    //   21	1213	15	localArrayList	java.util.ArrayList
    //   64	612	16	localApolloBaseInfo	com.tencent.mobileqq.apollo.model.ApolloBaseInfo
    //   78	617	17	localApolloDress	com.tencent.mobileqq.apollo.model.ApolloDress
    //   134	364	18	localIApolloResManager	IApolloResManager
    //   270	206	19	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   156	163	168	finally
    //   156	163	178	java/lang/Throwable
    //   327	340	345	finally
    //   327	340	358	java/lang/Throwable
    //   298	322	386	java/lang/Throwable
    //   462	492	386	java/lang/Throwable
    //   516	527	386	java/lang/Throwable
    //   542	576	386	java/lang/Throwable
    //   591	612	386	java/lang/Throwable
    //   627	648	386	java/lang/Throwable
    //   663	684	386	java/lang/Throwable
    //   718	769	386	java/lang/Throwable
    //   298	322	933	finally
    //   395	457	933	finally
    //   462	492	933	finally
    //   492	511	933	finally
    //   516	527	933	finally
    //   527	537	933	finally
    //   542	576	933	finally
    //   576	586	933	finally
    //   591	612	933	finally
    //   612	622	933	finally
    //   627	648	933	finally
    //   648	658	933	finally
    //   663	684	933	finally
    //   684	713	933	finally
    //   718	769	933	finally
    //   395	457	938	java/lang/Throwable
    //   492	511	938	java/lang/Throwable
    //   527	537	938	java/lang/Throwable
    //   576	586	938	java/lang/Throwable
    //   612	622	938	java/lang/Throwable
    //   648	658	938	java/lang/Throwable
    //   684	713	938	java/lang/Throwable
    //   188	215	951	finally
    //   218	254	951	finally
    //   263	277	951	finally
    //   188	215	956	java/lang/Throwable
    //   218	254	956	java/lang/Throwable
    //   263	277	956	java/lang/Throwable
    //   46	66	963	finally
    //   73	80	963	finally
    //   85	151	963	finally
    //   46	66	968	java/lang/Throwable
    //   73	80	968	java/lang/Throwable
    //   85	151	968	java/lang/Throwable
    //   30	46	975	finally
    //   30	46	988	java/lang/Throwable
    //   1001	1013	1163	finally
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
        if ((i != 0) || (!paramAbsScriptTask.k())) {
          break label493;
        }
        if (((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(ApolloUtilImpl.getQQApp(), paramString1))
        {
          paramString2 = "-2";
          Object localObject = paramAbsScriptTask.d();
          paramString2 = ApolloActionHelperImpl.getRoleDressIdByUin(paramString2, ApolloUtilImpl.getQQApp(), paramBoolean2, (IApolloResManager)localObject);
          if ((paramString2 != null) && (paramString2.length == 2))
          {
            int j = ((Integer)paramString2[0]).intValue();
            paramString2 = (int[])paramString2[1];
            if ((paramString2 != null) && (paramString2.length != 0))
            {
              localObject = new JSONArray();
              int k = paramString2.length;
              i = 0;
              if (i < k)
              {
                ((JSONArray)localObject).put(ApolloActionHelperImpl.getApolloRsc(1, Integer.valueOf(paramString2[i]).intValue()));
                i += 1;
                continue;
              }
              localJSONObject.put("dress", localObject);
              localJSONObject.put("role", ApolloActionHelperImpl.getApolloRsc(0, j));
              if (((paramAbsScriptTask.e() == 1) || (paramAbsScriptTask.e() == 3000)) && (!"-1".equals(paramString1)) && (!"-2".equals(paramString1)) && (!paramAbsScriptTask.h()))
              {
                localJSONObject.put("nameplate", SpriteRscBuilder.a(ApolloUtilImpl.getQQApp(), paramString1, j, paramBoolean1));
                paramString2 = paramAbsScriptTask.g();
                if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals(paramString1))) {
                  paramString1 = HardCodeUtil.a(2131911658);
                } else {
                  paramString1 = SpriteUtil.a(ApolloUtilImpl.getQQApp(), paramAbsScriptTask.e(), paramString1, paramAbsScriptTask.f(), true);
                }
                if (!TextUtils.isEmpty(paramString1)) {
                  localJSONObject.put("nickname", SpriteUtil.a(Base64Util.encodeToString(paramString1.getBytes("utf-8"), 0)));
                }
              }
              if (paramAbsScriptTask.j() == null) {
                break;
              }
              localJSONObject.put("scale", paramAbsScriptTask.j().a);
              localJSONObject.put("xPos", paramAbsScriptTask.j().b);
              localJSONObject.put("yPos", paramAbsScriptTask.j().c);
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
        QLog.e("[cmshow][ScriptUtils]", 1, paramString1, new Object[0]);
        return null;
      }
      paramString2 = "-1";
      continue;
      label493:
      paramString2 = paramString1;
    }
    return localJSONObject;
  }
  
  /* Error */
  public static JSONArray b(PlayActionTask paramPlayActionTask)
  {
    // Byte code:
    //   0: invokestatic 321	com/tencent/mobileqq/apollo/utils/api/impl/ApolloUtilImpl:getQQApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3: astore 9
    //   5: aload 9
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 700	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:q	()Ljava/util/List;
    //   16: astore 11
    //   18: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: new 268	org/json/JSONArray
    //   26: dup
    //   27: invokespecial 269	org/json/JSONArray:<init>	()V
    //   30: astore 10
    //   32: aload 9
    //   34: ldc_w 359
    //   37: ldc_w 361
    //   40: invokevirtual 367	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   43: checkcast 369	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   46: astore 12
    //   48: iconst_0
    //   49: istore_2
    //   50: iconst_m1
    //   51: istore_3
    //   52: iconst_0
    //   53: istore_1
    //   54: iload_2
    //   55: aload 11
    //   57: invokeinterface 653 1 0
    //   62: if_icmpge +192 -> 254
    //   65: aload 11
    //   67: iload_2
    //   68: invokeinterface 704 2 0
    //   73: checkcast 126	java/lang/Integer
    //   76: invokevirtual 437	java/lang/Integer:intValue	()I
    //   79: istore 4
    //   81: iconst_m1
    //   82: iload_3
    //   83: if_icmpeq +51 -> 134
    //   86: aload 12
    //   88: iload_3
    //   89: invokevirtual 373	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:findActionById	(I)Lcom/tencent/mobileqq/apollo/model/ApolloActionData;
    //   92: astore 13
    //   94: aload 13
    //   96: ifnull +38 -> 134
    //   99: aload 13
    //   101: invokevirtual 707	com/tencent/mobileqq/apollo/model/ApolloActionData:isHasPostAction	()Z
    //   104: ifeq +30 -> 134
    //   107: iload_3
    //   108: iload 4
    //   110: if_icmpeq +24 -> 134
    //   113: aload_0
    //   114: iload_3
    //   115: iconst_2
    //   116: invokestatic 709	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;II)Lorg/json/JSONObject;
    //   119: astore 13
    //   121: aload 13
    //   123: ifnull +11 -> 134
    //   126: aload 10
    //   128: aload 13
    //   130: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   133: pop
    //   134: aload 12
    //   136: iload 4
    //   138: invokevirtual 373	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:findActionById	(I)Lcom/tencent/mobileqq/apollo/model/ApolloActionData;
    //   141: astore 13
    //   143: aload 13
    //   145: ifnull +64 -> 209
    //   148: iload 4
    //   150: iload_3
    //   151: if_icmpeq +33 -> 184
    //   154: aload 13
    //   156: invokevirtual 712	com/tencent/mobileqq/apollo/model/ApolloActionData:isHasPreAction	()Z
    //   159: ifeq +25 -> 184
    //   162: aload_0
    //   163: iload 4
    //   165: iconst_0
    //   166: invokestatic 709	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;II)Lorg/json/JSONObject;
    //   169: astore 13
    //   171: aload 13
    //   173: ifnull +11 -> 184
    //   176: aload 10
    //   178: aload 13
    //   180: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   183: pop
    //   184: aload_0
    //   185: iload 4
    //   187: iconst_1
    //   188: invokestatic 709	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;II)Lorg/json/JSONObject;
    //   191: astore 13
    //   193: aload 13
    //   195: ifnull +255 -> 450
    //   198: aload 10
    //   200: aload 13
    //   202: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   205: pop
    //   206: goto +244 -> 450
    //   209: new 31	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   216: astore 13
    //   218: aload 13
    //   220: ldc_w 714
    //   223: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 13
    //   229: iload 4
    //   231: invokevirtual 69	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: ldc 42
    //   237: iconst_1
    //   238: aload 13
    //   240: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 716	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: iconst_m1
    //   247: istore_1
    //   248: iconst_1
    //   249: istore 4
    //   251: goto +207 -> 458
    //   254: iconst_m1
    //   255: iload_3
    //   256: if_icmpeq +42 -> 298
    //   259: aload 12
    //   261: iload_3
    //   262: invokevirtual 373	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:findActionById	(I)Lcom/tencent/mobileqq/apollo/model/ApolloActionData;
    //   265: astore 11
    //   267: aload 11
    //   269: ifnull +29 -> 298
    //   272: aload 11
    //   274: invokevirtual 707	com/tencent/mobileqq/apollo/model/ApolloActionData:isHasPostAction	()Z
    //   277: ifeq +21 -> 298
    //   280: aload_0
    //   281: iload_3
    //   282: iconst_2
    //   283: invokestatic 709	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;II)Lorg/json/JSONObject;
    //   286: astore_0
    //   287: aload_0
    //   288: ifnull +10 -> 298
    //   291: aload 10
    //   293: aload_0
    //   294: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   297: pop
    //   298: iload_1
    //   299: ifeq +9 -> 308
    //   302: aload 9
    //   304: iconst_1
    //   305: invokestatic 721	com/tencent/mobileqq/apollo/handler/ApolloContentUpdateHandler:a	(Lcom/tencent/common/app/AppInterface;I)V
    //   308: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   311: lstore 7
    //   313: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +30 -> 346
    //   319: ldc 42
    //   321: iconst_2
    //   322: iconst_2
    //   323: anewarray 4	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: ldc_w 723
    //   331: aastore
    //   332: dup
    //   333: iconst_1
    //   334: lload 7
    //   336: lload 5
    //   338: lsub
    //   339: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   342: aastore
    //   343: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   346: aload 10
    //   348: areturn
    //   349: astore_0
    //   350: goto +54 -> 404
    //   353: astore_0
    //   354: ldc 42
    //   356: iconst_1
    //   357: ldc_w 725
    //   360: aload_0
    //   361: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   364: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   367: lstore 7
    //   369: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +30 -> 402
    //   375: ldc 42
    //   377: iconst_2
    //   378: iconst_2
    //   379: anewarray 4	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: ldc_w 723
    //   387: aastore
    //   388: dup
    //   389: iconst_1
    //   390: lload 7
    //   392: lload 5
    //   394: lsub
    //   395: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   398: aastore
    //   399: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   402: aconst_null
    //   403: areturn
    //   404: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   407: lstore 7
    //   409: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +30 -> 442
    //   415: ldc 42
    //   417: iconst_2
    //   418: iconst_2
    //   419: anewarray 4	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: ldc_w 723
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: lload 7
    //   432: lload 5
    //   434: lsub
    //   435: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: aastore
    //   439: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   442: goto +5 -> 447
    //   445: aload_0
    //   446: athrow
    //   447: goto -2 -> 445
    //   450: iload 4
    //   452: istore_3
    //   453: iload_1
    //   454: istore 4
    //   456: iload_3
    //   457: istore_1
    //   458: iload_2
    //   459: iconst_1
    //   460: iadd
    //   461: istore_2
    //   462: iload_1
    //   463: istore_3
    //   464: iload 4
    //   466: istore_1
    //   467: goto -413 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramPlayActionTask	PlayActionTask
    //   53	414	1	i	int
    //   49	413	2	j	int
    //   51	413	3	k	int
    //   79	386	4	m	int
    //   21	412	5	l1	long
    //   311	120	7	l2	long
    //   3	300	9	localQQAppInterface	QQAppInterface
    //   30	317	10	localJSONArray	JSONArray
    //   16	257	11	localObject1	Object
    //   46	214	12	localApolloDaoManagerServiceImpl	ApolloDaoManagerServiceImpl
    //   92	147	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	48	349	finally
    //   54	81	349	finally
    //   86	94	349	finally
    //   99	107	349	finally
    //   113	121	349	finally
    //   126	134	349	finally
    //   134	143	349	finally
    //   154	171	349	finally
    //   176	184	349	finally
    //   184	193	349	finally
    //   198	206	349	finally
    //   209	246	349	finally
    //   259	267	349	finally
    //   272	287	349	finally
    //   291	298	349	finally
    //   302	308	349	finally
    //   354	364	349	finally
    //   23	48	353	java/lang/Throwable
    //   54	81	353	java/lang/Throwable
    //   86	94	353	java/lang/Throwable
    //   99	107	353	java/lang/Throwable
    //   113	121	353	java/lang/Throwable
    //   126	134	353	java/lang/Throwable
    //   134	143	353	java/lang/Throwable
    //   154	171	353	java/lang/Throwable
    //   176	184	353	java/lang/Throwable
    //   184	193	353	java/lang/Throwable
    //   198	206	353	java/lang/Throwable
    //   209	246	353	java/lang/Throwable
    //   259	267	353	java/lang/Throwable
    //   272	287	353	java/lang/Throwable
    //   291	298	353	java/lang/Throwable
    //   302	308	353	java/lang/Throwable
  }
  
  /* Error */
  public static JSONArray c(@NonNull PlayActionTask paramPlayActionTask)
  {
    // Byte code:
    //   0: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: new 268	org/json/JSONArray
    //   7: dup
    //   8: invokespecial 269	org/json/JSONArray:<init>	()V
    //   11: astore 6
    //   13: aload_0
    //   14: aload_0
    //   15: invokevirtual 302	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:n	()Ljava/lang/String;
    //   18: iconst_1
    //   19: iconst_0
    //   20: invokestatic 727	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;Ljava/lang/String;ZZ)Lorg/json/JSONObject;
    //   23: astore 7
    //   25: aload_0
    //   26: invokevirtual 274	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:e	()I
    //   29: iconst_1
    //   30: invokestatic 279	com/tencent/mobileqq/apollo/aio/api/impl/CmShowAioMatcherImpl:judgeSupported	(II)Z
    //   33: ifne +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 492	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:x	()I
    //   40: iconst_1
    //   41: if_icmpne +236 -> 277
    //   44: goto +3 -> 47
    //   47: aload_0
    //   48: aload_0
    //   49: invokevirtual 417	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:o	()Ljava/lang/String;
    //   52: iconst_0
    //   53: iconst_0
    //   54: invokestatic 727	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;Ljava/lang/String;ZZ)Lorg/json/JSONObject;
    //   57: astore 5
    //   59: aload 7
    //   61: ifnull +45 -> 106
    //   64: aload 6
    //   66: aload 7
    //   68: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   71: pop
    //   72: aload_0
    //   73: invokevirtual 291	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:h	()Z
    //   76: ifne +30 -> 106
    //   79: aload_0
    //   80: invokevirtual 302	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:n	()Ljava/lang/String;
    //   83: aload_0
    //   84: iconst_1
    //   85: invokestatic 294	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   88: astore 8
    //   90: aload 8
    //   92: ifnull +14 -> 106
    //   95: aload 7
    //   97: ldc_w 296
    //   100: aload 8
    //   102: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload 5
    //   108: ifnull +42 -> 150
    //   111: aload 6
    //   113: aload 5
    //   115: invokevirtual 299	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   118: pop
    //   119: aload_0
    //   120: invokevirtual 291	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:h	()Z
    //   123: ifne +27 -> 150
    //   126: aload_0
    //   127: invokevirtual 417	com/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask:o	()Ljava/lang/String;
    //   130: aload_0
    //   131: iconst_0
    //   132: invokestatic 294	com/tencent/mobileqq/cmshow/engine/script/ScriptUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;Z)Lorg/json/JSONObject;
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull +13 -> 150
    //   140: aload 5
    //   142: ldc_w 296
    //   145: aload_0
    //   146: invokevirtual 184	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   149: pop
    //   150: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   153: lstore_3
    //   154: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +28 -> 185
    //   160: ldc 42
    //   162: iconst_2
    //   163: iconst_2
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: ldc_w 729
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: lload_3
    //   176: lload_1
    //   177: lsub
    //   178: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   181: aastore
    //   182: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   185: aload 6
    //   187: areturn
    //   188: astore_0
    //   189: goto +51 -> 240
    //   192: astore_0
    //   193: ldc 42
    //   195: iconst_1
    //   196: ldc_w 731
    //   199: aload_0
    //   200: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   206: lstore_3
    //   207: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +28 -> 238
    //   213: ldc 42
    //   215: iconst_2
    //   216: iconst_2
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: ldc_w 729
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: lload_3
    //   229: lload_1
    //   230: lsub
    //   231: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   234: aastore
    //   235: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   238: aconst_null
    //   239: areturn
    //   240: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   243: lstore_3
    //   244: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +28 -> 275
    //   250: ldc 42
    //   252: iconst_2
    //   253: iconst_2
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: ldc_w 729
    //   262: aastore
    //   263: dup
    //   264: iconst_1
    //   265: lload_3
    //   266: lload_1
    //   267: lsub
    //   268: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   271: aastore
    //   272: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   275: aload_0
    //   276: athrow
    //   277: aconst_null
    //   278: astore 5
    //   280: goto -221 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramPlayActionTask	PlayActionTask
    //   3	264	1	l1	long
    //   153	113	3	l2	long
    //   57	222	5	localJSONObject1	JSONObject
    //   11	175	6	localJSONArray	JSONArray
    //   23	73	7	localJSONObject2	JSONObject
    //   88	13	8	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   4	44	188	finally
    //   47	59	188	finally
    //   64	90	188	finally
    //   95	106	188	finally
    //   111	136	188	finally
    //   140	150	188	finally
    //   193	203	188	finally
    //   4	44	192	java/lang/Throwable
    //   47	59	192	java/lang/Throwable
    //   64	90	192	java/lang/Throwable
    //   95	106	192	java/lang/Throwable
    //   111	136	192	java/lang/Throwable
    //   140	150	192	java/lang/Throwable
  }
  
  public static JSONObject d(@NonNull PlayActionTask paramPlayActionTask)
  {
    Object localObject2 = ApolloUtilImpl.getQQApp();
    if (localObject2 == null) {
      return null;
    }
    label371:
    for (;;)
    {
      try
      {
        int i = paramPlayActionTask.c();
        if ((paramPlayActionTask.w() == 12) && (i > 0))
        {
          localObject2 = ApolloUtilImpl.getAudioPathForAction(i, paramPlayActionTask.d());
          if (!new File((String)localObject2).exists())
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[getAudioParam] audio not found for ");
              ((StringBuilder)localObject1).append((String)localObject2);
              QLog.d("[cmshow][ScriptUtils]", 1, new Object[] { ((StringBuilder)localObject1).toString(), ",action:", Integer.valueOf(i) });
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
          ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(i);
          IApolloResManager localIApolloResManager = paramPlayActionTask.d();
          if ((localApolloActionData != null) && (localApolloActionData.hasSound))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append("music.amr");
            localObject2 = ((StringBuilder)localObject1).toString();
            localObject1 = localObject2;
            if (!new File((String)localObject2).exists())
            {
              localIApolloResManager.a(localApolloActionData, 4, null);
              localObject1 = localObject2;
            }
          }
          else
          {
            if (paramPlayActionTask.r() <= 0) {
              continue;
            }
            localObject1 = localIApolloResManager.i(paramPlayActionTask.r());
            if (new File((String)localObject1).exists()) {
              break label371;
            }
            localIApolloResManager.a().a((AppInterface)localObject2, null, paramPlayActionTask.r(), false);
            break label371;
          }
        }
        i = ((String)localObject1).indexOf(".apollo");
        localObject2 = localObject1;
        if (-1 != i) {
          localObject2 = ((String)localObject1).substring(i + 15);
        }
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("path", localObject2);
        ((JSONObject)localObject1).put("delayMill", paramPlayActionTask.s() * 1000.0F);
        return localObject1;
        return null;
      }
      catch (Exception paramPlayActionTask)
      {
        QLog.e("[cmshow][ScriptUtils]", 1, paramPlayActionTask, new Object[0]);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.ScriptUtils
 * JD-Core Version:    0.7.0.1
 */