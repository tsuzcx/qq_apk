package com.tencent.mobileqq.config.splashlogo;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class KandianConfigServlet
  extends MSFServlet
{
  private static Class<?> a;
  private static boolean c = false;
  private static long d;
  private static long e;
  private static long f;
  private static long g;
  private long b = 0L;
  
  private void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    g = l - paramLong;
    Object localObject = a;
    if (localObject != null)
    {
      localObject = paramQQAppInterface.getHandler((Class)localObject);
      if ((localObject != null) && (g <= 800L))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2005;
        ((MqqHandler)localObject).sendMessage(localMessage);
        QLog.d("KandianConfigServlet", 1, "send msg notify login activity!");
      }
      else
      {
        QLog.d("KandianConfigServlet", 1, "give up send login next msg!");
      }
      a = null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b(paramQQAppInterface.getAccount()));
    ((StringBuilder)localObject).append(" notifyLoginNext, all cost:");
    ((StringBuilder)localObject).append(g);
    ((StringBuilder)localObject).append("  nowTime:");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("  startTime:");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("KandianConfigServlet", 1, ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("totalCost", String.valueOf(g));
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).addExtraInfoInJson((JSONObject)localObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramQQAppInterface.getAccount(), "0X800965D", "0X800965D", 0, 0, String.valueOf(d), String.valueOf(e), String.valueOf(f), ((JSONObject)localObject).toString(), false);
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("only kandian tab switch, report error:");
      ((StringBuilder)localObject).append(paramQQAppInterface.toString());
      QLog.d("KandianConfigServlet", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, Packet paramPacket)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i;
    if ((paramBoolean) && (paramRespGetConfig.result.get() == 0) && (paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0))
    {
      long l1 = System.currentTimeMillis();
      int j = paramRespGetConfig.config_list.size();
      i = 0;
      while (i < j)
      {
        paramArrayOfInt = (ConfigurationService.Config)paramRespGetConfig.config_list.get(i);
        if (paramArrayOfInt != null)
        {
          Object localObject;
          for (;;)
          {
            if (paramArrayOfInt.type.has())
            {
              localObject = Integer.valueOf(paramArrayOfInt.type.get());
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("receiveAllConfigs|receive type: ");
              localStringBuilder.append(localObject);
              localStringBuilder.append(", length: ");
              localStringBuilder.append(j);
              QLog.d("KandianConfigServlet", 1, localStringBuilder.toString());
              try
              {
                int k = ((Integer)localObject).intValue();
                if (k == 92)
                {
                  try
                  {
                    l2 = paramIntent.getLongExtra("startTime", 0L);
                    if (!paramIntent.getBooleanExtra("configkandiantab", false)) {
                      break label270;
                    }
                    a(paramArrayOfInt, l2);
                    if (!paramIntent.getBooleanExtra("needNotifyNext", false)) {
                      break label270;
                    }
                    a(l2, paramQQAppInterface);
                  }
                  catch (Exception paramArrayOfInt) {}
                  localObject = new StringBuilder();
                }
              }
              catch (Exception paramArrayOfInt) {}
            }
          }
          ((StringBuilder)localObject).append("receiveAllConfig..parse error:");
          ((StringBuilder)localObject).append(paramArrayOfInt.getMessage());
          QLog.d("KandianConfigServlet", 1, ((StringBuilder)localObject).toString());
        }
        label270:
        i += 1;
      }
      long l2 = System.currentTimeMillis();
      paramRespGetConfig = new StringBuilder();
      paramRespGetConfig.append("receiveAllConfigs|executeSpendTime: ");
      paramRespGetConfig.append(l2 - l1);
      QLog.d("KandianConfigServlet", 1, paramRespGetConfig.toString());
      return;
    }
    if (!paramBoolean) {
      i = 1;
    } else if (paramRespGetConfig.result.get() != 0) {
      i = 2;
    } else if ((paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0)) {
      i = 0;
    } else {
      i = 3;
    }
    paramRespGetConfig = new StringBuilder();
    paramRespGetConfig.append("receiveAllConfig fail, errorType : ");
    paramRespGetConfig.append(i);
    QLog.d("KandianConfigServlet", 1, paramRespGetConfig.toString());
    if ((paramIntent.getBooleanExtra("configkandiantab", false)) && (paramIntent.getBooleanExtra("needNotifyNext", false))) {
      a(paramIntent.getLongExtra("startTime", 0L), paramQQAppInterface);
    }
    a("0X8009680", "1", String.valueOf(i));
  }
  
  public static void a(String paramString)
  {
    a("0X800967F", paramString, null);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.executeOnSubThread(new KandianConfigServlet.2(paramString1, paramString2, paramString3));
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i] == 92)
        {
          a("0X8009680", paramString, String.valueOf(paramInt));
          break;
        }
        i += 1;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportKDConfigNetFailed isOnly92:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("  cmds:");
    localStringBuilder.append(paramArrayOfInt);
    localStringBuilder.append("   resultCode:");
    localStringBuilder.append(paramInt);
    QLog.d("KandianConfigServlet", 1, localStringBuilder.toString());
  }
  
  public static boolean a(AppRuntime paramAppRuntime, Class<?> paramClass, long paramLong)
  {
    QLog.d("KandianConfigServlet", 1, "getKandianTabConfig,need notify");
    return a(paramAppRuntime, paramClass, paramLong, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime, Class<?> paramClass, long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppRuntime != null)
    {
      bool1 = bool2;
      if ((paramAppRuntime instanceof AppInterface))
      {
        paramAppRuntime = (AppInterface)paramAppRuntime;
        Object localObject = paramAppRuntime.getApp();
        String str = paramAppRuntime.getAccount();
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(str))
          {
            int i = SharedPreUtils.U((Context)localObject, str);
            if (i == 0)
            {
              a = paramClass;
              paramClass = new NewIntent((Context)localObject, KandianConfigServlet.class);
              paramClass.putExtra("k_cmd_type", new int[] { 92 });
              paramClass.putExtra("configkandiantab", true);
              paramClass.putExtra("startTime", paramLong);
              paramClass.putExtra("needNotifyNext", paramBoolean);
              if (!StringUtil.isEmpty(str)) {
                paramClass.putExtra("key_uin", str);
              }
              d = System.currentTimeMillis() - paramLong;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getKandianTabConfig, currentUin : ");
              ((StringBuilder)localObject).append(b(str));
              ((StringBuilder)localObject).append("  cost time：");
              ((StringBuilder)localObject).append(d);
              QLog.d("KandianConfigServlet", 1, ((StringBuilder)localObject).toString());
              paramAppRuntime.startServlet(paramClass);
              bool1 = true;
            }
            else
            {
              paramAppRuntime = new StringBuilder();
              paramAppRuntime.append("getKandianTabConfig local config exist, version : ");
              paramAppRuntime.append(i);
              QLog.d("KandianConfigServlet", 1, paramAppRuntime.toString());
              bool1 = bool2;
            }
          }
        }
      }
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount());
    paramAppRuntime.append(" getKandianTabConfig executed:");
    paramAppRuntime.append(bool1);
    paramAppRuntime.append("  startTime:");
    paramAppRuntime.append(paramLong);
    QLog.d("KandianConfigServlet", 1, paramAppRuntime.toString());
    return bool1;
  }
  
  private static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    int i = (int)l;
    byte[] arrayOfByte = new byte[i + 4];
    PkgTools.dWord2Byte(arrayOfByte, 0, l + 4L);
    PkgTools.copyData(arrayOfByte, 4, paramReqGetConfig, i);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return Base64Util.encodeToString(paramString.getBytes(), 0);
  }
  
  public void a(ConfigurationService.Config paramConfig, long paramLong)
  {
    long l = System.currentTimeMillis();
    int j;
    int i;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
      Object localObject2;
      if ((paramConfig.content_list.has()) && (paramConfig.content_list.size() > 0))
      {
        j = 0;
        i = 0;
        int k = paramConfig.content_list.size();
        if (j >= k) {
          break label426;
        }
        try
        {
          Object localObject1 = ((String)paramConfig.content_list.get(j)).trim();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("kandian_tab_switch")))
          {
            localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild();
            for (;;)
            {
              if (localObject1 != null)
              {
                if (((Node)localObject1).getFirstChild() != null)
                {
                  String str = ((Node)localObject1).getNodeName();
                  localObject2 = ((Node)localObject1).getFirstChild().getNodeValue();
                  boolean bool = TextUtils.equals(str, "kandian_tab_switch");
                  if (!bool) {}
                }
                try
                {
                  a(localQQAppInterface, (String)localObject2, paramLong);
                  try
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("handleReadTabConfig receive config, value : ");
                    ((StringBuilder)localObject1).append((String)localObject2);
                    QLog.d("KandianConfigServlet", 1, ((StringBuilder)localObject1).toString());
                    i = 1;
                  }
                  catch (Exception localException1)
                  {
                    i = 1;
                    break label272;
                  }
                  Node localNode = localException1.getNextSibling();
                }
                catch (Exception localException2) {}
              }
            }
          }
        }
        catch (Exception localException3) {}
      }
      try
      {
        label272:
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleReadTabConfig parse has exception ");
        ((StringBuilder)localObject2).append(localException3);
        QLog.d("KandianConfigServlet", 1, ((StringBuilder)localObject2).toString());
      }
      catch (Exception paramConfig)
      {
        break label329;
      }
      QLog.d("KandianConfigServlet", 1, "handleReadTabConfig receive config is empty!");
    }
    catch (Exception paramConfig) {}
    label329:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleReadTabConfig has exception : ");
    localStringBuilder.append(paramConfig);
    QLog.e("KandianConfigServlet", 1, localStringBuilder.toString());
    label426:
    for (;;)
    {
      f = System.currentTimeMillis() - l;
      paramConfig = new StringBuilder();
      paramConfig.append("handleReadTabConfig parse cost : ");
      paramConfig.append(f);
      QLog.d("KandianConfigServlet", 1, paramConfig.toString());
      return;
      if (i == 0)
      {
        j += 1;
        break;
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l = System.currentTimeMillis();
    e = l - this.b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onReceive  request cost:");
    ((StringBuilder)localObject1).append(e);
    QLog.i("KandianConfigServlet", 1, ((StringBuilder)localObject1).toString());
    localObject1 = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    boolean bool = paramFromServiceMsg.isSuccess();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount());
    ((StringBuilder)localObject2).append(" onReceive   nowTime:");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("   requestCost:");
    ((StringBuilder)localObject2).append(e);
    ((StringBuilder)localObject2).append(" success:");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("  code");
    ((StringBuilder)localObject2).append(paramFromServiceMsg.getResultCode());
    QLog.d("KandianConfigServlet", 1, ((StringBuilder)localObject2).toString());
    if (arrayOfInt != null)
    {
      if (arrayOfInt.length == 0) {
        return;
      }
      localObject2 = paramFromServiceMsg.getWupBuffer();
      if ((localObject2 != null) && (localObject2.length >= 4))
      {
        paramFromServiceMsg.putWupBuffer(a((byte[])localObject2));
        localObject2 = new ConfigurationService.RespGetConfig();
        try
        {
          ((ConfigurationService.RespGetConfig)localObject2).mergeFrom(paramFromServiceMsg.getWupBuffer());
          try
          {
            PatchConfigServlet.a(((ConfigurationService.RespGetConfig)localObject2).min_req_interval_for_reconnect.get());
            a((ConfigurationService.RespGetConfig)localObject2, (QQAppInterface)localObject1, paramIntent, arrayOfInt, bool);
            return;
          }
          catch (Exception paramIntent)
          {
            QLog.w("KandianConfigServlet", 1, paramIntent.toString());
            return;
          }
          QLog.d("KandianConfigServlet", 1, "wup buf is null!!!");
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("error: ");
          paramFromServiceMsg.append(paramIntent.toString());
          QLog.d("KandianConfigServlet", 1, paramFromServiceMsg.toString());
          paramIntent.printStackTrace();
          return;
        }
      }
      a("1", arrayOfInt, paramFromServiceMsg.getResultCode());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    if (arrayOfInt != null)
    {
      if (arrayOfInt.length == 0) {
        return;
      }
      a(localQQAppInterface, paramIntent, arrayOfInt, paramPacket);
      if (!c)
      {
        c = false;
        try
        {
          ThreadManager.executeOnSubThread(new KandianConfigServlet.1(this));
        }
        catch (Exception paramIntent)
        {
          paramPacket = new StringBuilder();
          paramPacket.append("sSpHasRead error:");
          paramPacket.append(paramIntent.toString());
          QLog.i("KandianConfigServlet", 1, paramPacket.toString());
        }
      }
      this.b = System.currentTimeMillis();
      paramIntent = new StringBuilder();
      paramIntent.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount());
      paramIntent.append(" onSend   mRequestStartTime:");
      paramIntent.append(this.b);
      paramIntent.append("  cmds:");
      paramIntent.append(arrayOfInt);
      QLog.d("KandianConfigServlet", 1, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.KandianConfigServlet
 * JD-Core Version:    0.7.0.1
 */