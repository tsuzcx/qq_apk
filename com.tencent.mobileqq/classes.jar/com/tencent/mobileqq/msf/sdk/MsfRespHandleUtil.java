package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.d.e;
import com.tencent.mobileqq.msf.core.d.e.a;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MsfRespHandleUtil
{
  public static final String tag = "MSF.D.RespHandleUtil";
  IAuthHandler authHandler;
  IMsfMsgHandler msfMsgHandler;
  INotifyHandler notifyHandler;
  IPushHandler pushHandler;
  IRegisterUinHandler registerUinHandler;
  IServerInfoHandler serverInfoHandler;
  IServerMsgPushHandler serverMsgPushHandler;
  
  public MsfRespHandleUtil(IMsfHandler[] paramArrayOfIMsfHandler)
  {
    if (paramArrayOfIMsfHandler != null)
    {
      int j = paramArrayOfIMsfHandler.length;
      int i = 0;
      while (i < j)
      {
        IMsfHandler localIMsfHandler = paramArrayOfIMsfHandler[i];
        if ((localIMsfHandler instanceof IAuthHandler)) {
          this.authHandler = ((IAuthHandler)localIMsfHandler);
        } else if ((localIMsfHandler instanceof IMsfMsgHandler)) {
          this.msfMsgHandler = ((IMsfMsgHandler)localIMsfHandler);
        } else if ((localIMsfHandler instanceof INotifyHandler)) {
          this.notifyHandler = ((INotifyHandler)localIMsfHandler);
        } else if ((localIMsfHandler instanceof IServerInfoHandler)) {
          this.serverInfoHandler = ((IServerInfoHandler)localIMsfHandler);
        } else if ((localIMsfHandler instanceof IPushHandler)) {
          this.pushHandler = ((IPushHandler)localIMsfHandler);
        } else if ((localIMsfHandler instanceof IRegisterUinHandler)) {
          this.registerUinHandler = ((IRegisterUinHandler)localIMsfHandler);
        } else if ((localIMsfHandler instanceof IServerMsgPushHandler)) {
          this.serverMsgPushHandler = ((IServerMsgPushHandler)localIMsfHandler);
        }
        i += 1;
      }
    }
  }
  
  public boolean handlePushMsg(FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1;
    boolean bool2;
    try
    {
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onConnOpened)
      {
        com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 2;
        if (this.serverMsgPushHandler == null) {
          break label480;
        }
        AppNetConnInfo.checkNetEvent();
        this.serverMsgPushHandler.onConnOpened(paramFromServiceMsg);
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onReceFirstResp)
      {
        com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 4;
        if (this.serverMsgPushHandler == null) {
          break label480;
        }
        this.serverMsgPushHandler.onReceFirstResp(paramFromServiceMsg);
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onOepnConnAllFailed)
      {
        com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 3;
        if (this.serverMsgPushHandler == null) {
          break label480;
        }
        this.serverMsgPushHandler.onOpenConnAllFailed(paramFromServiceMsg);
      }
      else
      {
        if (paramFromServiceMsg.getMsfCommand() != MsfCommand.onConnClosed) {
          break label480;
        }
        com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 1;
        if (this.serverMsgPushHandler == null) {
          break label480;
        }
        this.serverMsgPushHandler.onConnClose(paramFromServiceMsg);
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      long l;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle push msg error ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      QLog.d("MSF.D.RespHandleUtil", 1, ((StringBuilder)localObject).toString(), paramFromServiceMsg);
      return true;
    }
    if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvConfigPush)
    {
      bool2 = bool1;
      if (this.serverMsgPushHandler != null)
      {
        this.serverMsgPushHandler.onRecvServerConfigPush(paramFromServiceMsg);
        break label485;
      }
    }
    else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvNotifyMsg)
    {
      bool2 = bool1;
      if (this.notifyHandler != null)
      {
        l = ((Long)paramFromServiceMsg.getAttributes().get("notifyId")).longValue();
        this.notifyHandler.onRecvNotify(l, paramFromServiceMsg);
        break label485;
      }
    }
    else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.registerPush)
    {
      bool2 = bool1;
      if (this.pushHandler != null)
      {
        this.pushHandler.onRegisterPushResp(null, paramFromServiceMsg);
        break label485;
      }
    }
    else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onTicketChanged)
    {
      bool2 = bool1;
      if (this.pushHandler != null)
      {
        this.pushHandler.onTicketChanged(paramFromServiceMsg);
        break label485;
      }
    }
    else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onProxyIpChanged)
    {
      bool2 = bool1;
      if (this.pushHandler != null)
      {
        this.pushHandler.onProxyIpChanged(paramFromServiceMsg.getUin());
        break label485;
      }
    }
    else
    {
      bool2 = bool1;
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onOverloadPushNotify)
      {
        bool2 = bool1;
        if (this.pushHandler != null)
        {
          localObject = (String)paramFromServiceMsg.getAttributes().get("msg");
          this.pushHandler.onOverloadPushNotify((String)localObject);
          break label485;
        }
      }
    }
    for (;;)
    {
      if (!bool2)
      {
        if (this.pushHandler != null)
        {
          this.pushHandler.onRecvCmdPush(paramFromServiceMsg);
          return true;
        }
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          e.a().a(e.a.b, paramFromServiceMsg.getWupBuffer(), 18);
        }
        return false;
      }
      return bool2;
      bool1 = true;
      break;
      label480:
      bool1 = false;
      break;
      label485:
      bool2 = true;
    }
  }
  
  /* Error */
  public boolean handleRespMsg(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 223	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore_3
    //   5: aload_2
    //   6: invokevirtual 226	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   9: istore 4
    //   11: aload_2
    //   12: invokevirtual 229	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   15: astore 8
    //   17: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +38 -> 58
    //   23: new 198	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   30: astore 7
    //   32: aload 7
    //   34: ldc 235
    //   36: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 7
    //   42: aload_2
    //   43: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 8
    //   49: iconst_2
    //   50: aload 7
    //   52: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_2
    //   59: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   62: getstatic 241	com/tencent/mobileqq/msf/sdk/MsfCommand:loginAuth	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   65: if_acmpeq +2118 -> 2183
    //   68: aload_2
    //   69: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   72: getstatic 244	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_loginAuth	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   75: if_acmpne +6 -> 81
    //   78: goto +2105 -> 2183
    //   81: aload_2
    //   82: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   85: getstatic 247	com/tencent/mobileqq/msf/sdk/MsfCommand:changeUinLogin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   88: if_acmpeq +2069 -> 2157
    //   91: aload_2
    //   92: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   95: getstatic 250	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_GetStViaSMSVerifyLogin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   98: if_acmpne +6 -> 104
    //   101: goto +2056 -> 2157
    //   104: aload_2
    //   105: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   108: astore 7
    //   110: getstatic 253	com/tencent/mobileqq/msf/sdk/MsfCommand:changeToken	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   113: astore 10
    //   115: aconst_null
    //   116: astore 9
    //   118: aload 7
    //   120: aload 10
    //   122: if_acmpeq +1932 -> 2054
    //   125: aload_2
    //   126: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   129: getstatic 256	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_exchange	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   132: if_acmpne +6 -> 138
    //   135: goto +1919 -> 2054
    //   138: aload_2
    //   139: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   142: getstatic 259	com/tencent/mobileqq/msf/sdk/MsfCommand:submitPuzzleVerifyCodeTicket	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   145: if_acmpne +29 -> 174
    //   148: aload_0
    //   149: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   152: ifnull +2129 -> 2281
    //   155: aload_0
    //   156: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   159: iload_3
    //   160: iload 4
    //   162: aload 8
    //   164: aload_1
    //   165: aload_2
    //   166: invokeinterface 263 6 0
    //   171: goto +2104 -> 2275
    //   174: aload_2
    //   175: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   178: getstatic 266	com/tencent/mobileqq/msf/sdk/MsfCommand:submitVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   181: if_acmpne +29 -> 210
    //   184: aload_0
    //   185: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   188: ifnull +2093 -> 2281
    //   191: aload_0
    //   192: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   195: iload_3
    //   196: iload 4
    //   198: aload 8
    //   200: aload_1
    //   201: aload_2
    //   202: invokeinterface 263 6 0
    //   207: goto +2068 -> 2275
    //   210: aload_2
    //   211: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   214: getstatic 269	com/tencent/mobileqq/msf/sdk/MsfCommand:refreVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   217: if_acmpne +29 -> 246
    //   220: aload_0
    //   221: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   224: ifnull +2057 -> 2281
    //   227: aload_0
    //   228: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   231: iload_3
    //   232: iload 4
    //   234: aload 8
    //   236: aload_1
    //   237: aload_2
    //   238: invokeinterface 263 6 0
    //   243: goto +2032 -> 2275
    //   246: aload_2
    //   247: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   250: getstatic 272	com/tencent/mobileqq/msf/sdk/MsfCommand:delLoginedAccount	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   253: if_acmpne +29 -> 282
    //   256: aload_0
    //   257: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   260: ifnull +2021 -> 2281
    //   263: aload_0
    //   264: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   267: iload_3
    //   268: iload 4
    //   270: aload 8
    //   272: aload_1
    //   273: aload_2
    //   274: invokeinterface 275 6 0
    //   279: goto +1996 -> 2275
    //   282: aload_2
    //   283: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   286: getstatic 278	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_name2uin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   289: if_acmpne +29 -> 318
    //   292: aload_0
    //   293: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   296: ifnull +1985 -> 2281
    //   299: aload_0
    //   300: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   303: iload_3
    //   304: iload 4
    //   306: aload 8
    //   308: aload_1
    //   309: aload_2
    //   310: invokeinterface 281 6 0
    //   315: goto +1960 -> 2275
    //   318: aload_2
    //   319: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   322: getstatic 284	com/tencent/mobileqq/msf/sdk/MsfCommand:onRecvVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   325: if_acmpne +32 -> 357
    //   328: aload_0
    //   329: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   332: ifnull +1949 -> 2281
    //   335: aload_2
    //   336: invokestatic 290	com/tencent/mobileqq/msf/sdk/VerifyCodeInfo:getVerifyCodeInfo	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Lcom/tencent/mobileqq/msf/sdk/VerifyCodeInfo;
    //   339: astore 7
    //   341: aload_0
    //   342: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   345: aload 7
    //   347: aload_1
    //   348: aload_2
    //   349: invokeinterface 294 4 0
    //   354: goto +1921 -> 2275
    //   357: aload_2
    //   358: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   361: getstatic 297	com/tencent/mobileqq/msf/sdk/MsfCommand:reportMsg	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   364: if_acmpne +29 -> 393
    //   367: aload_0
    //   368: getfield 43	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:serverInfoHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IServerInfoHandler;
    //   371: ifnull +1910 -> 2281
    //   374: aload_0
    //   375: getfield 43	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:serverInfoHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IServerInfoHandler;
    //   378: iload_3
    //   379: iload 4
    //   381: aload 8
    //   383: aload_1
    //   384: aload_2
    //   385: invokeinterface 300 6 0
    //   390: goto +1885 -> 2275
    //   393: aload_2
    //   394: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   397: getstatic 303	com/tencent/mobileqq/msf/sdk/MsfCommand:getServerConfig	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   400: if_acmpne +105 -> 505
    //   403: aload_2
    //   404: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   407: istore 6
    //   409: iload 6
    //   411: ifeq +1864 -> 2275
    //   414: aload_2
    //   415: invokevirtual 116	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   418: ldc_w 308
    //   421: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   424: checkcast 310	java/lang/Integer
    //   427: invokevirtual 313	java/lang/Integer:intValue	()I
    //   430: istore_3
    //   431: aload_2
    //   432: invokevirtual 116	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   435: ldc_w 315
    //   438: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   441: checkcast 163	java/lang/String
    //   444: astore 7
    //   446: aload_1
    //   447: invokestatic 320	com/tencent/mobileqq/msf/service/u:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   450: iload_3
    //   451: aload 7
    //   453: aload_1
    //   454: invokevirtual 323	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   457: invokestatic 329	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:writeServerConfig	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   460: goto +1815 -> 2275
    //   463: astore 7
    //   465: new 198	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   472: astore 8
    //   474: aload 8
    //   476: ldc_w 331
    //   479: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 8
    //   485: aload 7
    //   487: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: ldc 8
    //   493: iconst_1
    //   494: aload 8
    //   496: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: goto +1773 -> 2275
    //   505: aload_2
    //   506: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   509: getstatic 137	com/tencent/mobileqq/msf/sdk/MsfCommand:registerPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   512: if_acmpne +24 -> 536
    //   515: aload_0
    //   516: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   519: ifnull +1762 -> 2281
    //   522: aload_0
    //   523: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   526: aload_1
    //   527: aload_2
    //   528: invokeinterface 141 3 0
    //   533: goto +1742 -> 2275
    //   536: aload_2
    //   537: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   540: getstatic 337	com/tencent/mobileqq/msf/sdk/MsfCommand:unRegisterPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   543: if_acmpne +24 -> 567
    //   546: aload_0
    //   547: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   550: ifnull +1731 -> 2281
    //   553: aload_0
    //   554: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   557: aload_1
    //   558: aload_2
    //   559: invokeinterface 340 3 0
    //   564: goto +1711 -> 2275
    //   567: aload_2
    //   568: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   571: getstatic 343	com/tencent/mobileqq/msf/sdk/MsfCommand:registerCmdCallback	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   574: if_acmpne +24 -> 598
    //   577: aload_0
    //   578: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   581: ifnull +1700 -> 2281
    //   584: aload_0
    //   585: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   588: aload_1
    //   589: aload_2
    //   590: invokeinterface 346 3 0
    //   595: goto +1680 -> 2275
    //   598: aload_2
    //   599: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   602: getstatic 349	com/tencent/mobileqq/msf/sdk/MsfCommand:resetCmdCallback	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   605: if_acmpne +24 -> 629
    //   608: aload_0
    //   609: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   612: ifnull +1669 -> 2281
    //   615: aload_0
    //   616: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   619: aload_1
    //   620: aload_2
    //   621: invokeinterface 352 3 0
    //   626: goto +1649 -> 2275
    //   629: aload_2
    //   630: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   633: astore 7
    //   635: getstatic 355	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_queryMobile	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   638: astore 8
    //   640: aload 7
    //   642: aload 8
    //   644: if_acmpne +104 -> 748
    //   647: aload_0
    //   648: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   651: ifnull +1630 -> 2281
    //   654: iconst_0
    //   655: newarray byte
    //   657: astore 8
    //   659: aload_2
    //   660: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   663: ifeq +46 -> 709
    //   666: aload_2
    //   667: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   670: ldc_w 361
    //   673: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   676: checkcast 310	java/lang/Integer
    //   679: invokevirtual 313	java/lang/Integer:intValue	()I
    //   682: istore_3
    //   683: aload_2
    //   684: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   687: ldc_w 363
    //   690: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   693: checkcast 365	[B
    //   696: checkcast 365	[B
    //   699: astore 7
    //   701: goto +30 -> 731
    //   704: astore 7
    //   706: goto +16 -> 722
    //   709: iconst_0
    //   710: istore_3
    //   711: aload 8
    //   713: astore 7
    //   715: goto +16 -> 731
    //   718: astore 7
    //   720: iconst_0
    //   721: istore_3
    //   722: aload 7
    //   724: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   727: aload 8
    //   729: astore 7
    //   731: aload_0
    //   732: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   735: iload_3
    //   736: aload 7
    //   738: aload_1
    //   739: aload_2
    //   740: invokeinterface 372 5 0
    //   745: goto +1530 -> 2275
    //   748: aload_2
    //   749: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   752: astore 7
    //   754: getstatic 375	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitMobile	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   757: astore 8
    //   759: aload 7
    //   761: aload 8
    //   763: if_acmpne +150 -> 913
    //   766: aload_0
    //   767: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   770: ifnull +1511 -> 2281
    //   773: iconst_0
    //   774: newarray byte
    //   776: astore 9
    //   778: iconst_0
    //   779: newarray byte
    //   781: astore 8
    //   783: aload_2
    //   784: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   787: ifeq +85 -> 872
    //   790: aload_2
    //   791: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   794: ldc_w 361
    //   797: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   800: checkcast 310	java/lang/Integer
    //   803: invokevirtual 313	java/lang/Integer:intValue	()I
    //   806: istore_3
    //   807: aload_2
    //   808: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   811: ldc_w 363
    //   814: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   817: checkcast 365	[B
    //   820: checkcast 365	[B
    //   823: astore 7
    //   825: aload_2
    //   826: ldc_w 377
    //   829: iconst_0
    //   830: newarray byte
    //   832: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   835: checkcast 365	[B
    //   838: checkcast 365	[B
    //   841: astore 10
    //   843: aload 7
    //   845: astore 8
    //   847: aload 10
    //   849: astore 7
    //   851: goto +27 -> 878
    //   854: astore 10
    //   856: aload 7
    //   858: astore 8
    //   860: aload 10
    //   862: astore 7
    //   864: goto +21 -> 885
    //   867: astore 7
    //   869: goto +16 -> 885
    //   872: aload 9
    //   874: astore 7
    //   876: iconst_0
    //   877: istore_3
    //   878: goto +16 -> 894
    //   881: astore 7
    //   883: iconst_0
    //   884: istore_3
    //   885: aload 7
    //   887: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   890: aload 9
    //   892: astore 7
    //   894: aload_0
    //   895: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   898: iload_3
    //   899: aload 8
    //   901: aload 7
    //   903: aload_1
    //   904: aload_2
    //   905: invokeinterface 385 6 0
    //   910: goto +1365 -> 2275
    //   913: aload_2
    //   914: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   917: astore 7
    //   919: getstatic 388	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_reSendSms	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   922: astore 8
    //   924: aload 7
    //   926: aload 8
    //   928: if_acmpne +190 -> 1118
    //   931: aload_0
    //   932: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   935: ifnull +1346 -> 2281
    //   938: iconst_0
    //   939: newarray byte
    //   941: astore 8
    //   943: aload_2
    //   944: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   947: ifeq +108 -> 1055
    //   950: aload_2
    //   951: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   954: ldc_w 361
    //   957: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   960: checkcast 310	java/lang/Integer
    //   963: invokevirtual 313	java/lang/Integer:intValue	()I
    //   966: istore_3
    //   967: aload_2
    //   968: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   971: ldc_w 363
    //   974: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   977: checkcast 365	[B
    //   980: checkcast 365	[B
    //   983: astore 7
    //   985: aload_2
    //   986: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   989: ldc_w 390
    //   992: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   995: checkcast 310	java/lang/Integer
    //   998: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1001: istore 5
    //   1003: aload_2
    //   1004: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1007: ldc_w 392
    //   1010: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1013: checkcast 310	java/lang/Integer
    //   1016: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1019: istore 4
    //   1021: goto +46 -> 1067
    //   1024: astore 9
    //   1026: iload 5
    //   1028: istore 4
    //   1030: aload 7
    //   1032: astore 8
    //   1034: goto +47 -> 1081
    //   1037: astore 9
    //   1039: aload 7
    //   1041: astore 8
    //   1043: aload 9
    //   1045: astore 7
    //   1047: goto +27 -> 1074
    //   1050: astore 7
    //   1052: goto +22 -> 1074
    //   1055: iconst_0
    //   1056: istore 5
    //   1058: iconst_0
    //   1059: istore_3
    //   1060: iconst_0
    //   1061: istore 4
    //   1063: aload 8
    //   1065: astore 7
    //   1067: goto +30 -> 1097
    //   1070: astore 7
    //   1072: iconst_0
    //   1073: istore_3
    //   1074: iconst_0
    //   1075: istore 4
    //   1077: aload 7
    //   1079: astore 9
    //   1081: aload 9
    //   1083: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   1086: iload 4
    //   1088: istore 5
    //   1090: iconst_0
    //   1091: istore 4
    //   1093: aload 8
    //   1095: astore 7
    //   1097: aload_0
    //   1098: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1101: iload_3
    //   1102: aload 7
    //   1104: iload 5
    //   1106: iload 4
    //   1108: aload_1
    //   1109: aload_2
    //   1110: invokeinterface 396 7 0
    //   1115: goto +1160 -> 2275
    //   1118: aload_2
    //   1119: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1122: getstatic 399	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitSmsCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1125: if_acmpne +66 -> 1191
    //   1128: aload_0
    //   1129: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1132: astore 7
    //   1134: aload 7
    //   1136: ifnull +1145 -> 2281
    //   1139: aload_2
    //   1140: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1143: ifeq +1141 -> 2284
    //   1146: aload_2
    //   1147: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1150: ldc_w 361
    //   1153: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1156: checkcast 310	java/lang/Integer
    //   1159: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1162: istore_3
    //   1163: goto +13 -> 1176
    //   1166: astore 7
    //   1168: aload 7
    //   1170: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   1173: goto +1111 -> 2284
    //   1176: aload_0
    //   1177: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1180: iload_3
    //   1181: aload_1
    //   1182: aload_2
    //   1183: invokeinterface 403 4 0
    //   1188: goto +1087 -> 2275
    //   1191: aload_2
    //   1192: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1195: astore 8
    //   1197: getstatic 406	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitPass	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1200: astore 10
    //   1202: ldc_w 408
    //   1205: astore 7
    //   1207: aload 8
    //   1209: aload 10
    //   1211: if_acmpne +142 -> 1353
    //   1214: aload_0
    //   1215: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1218: ifnull +1063 -> 2281
    //   1221: iconst_0
    //   1222: newarray byte
    //   1224: astore 9
    //   1226: aload_2
    //   1227: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1230: ifeq +82 -> 1312
    //   1233: aload_2
    //   1234: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1237: ldc_w 361
    //   1240: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1243: checkcast 310	java/lang/Integer
    //   1246: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1249: istore_3
    //   1250: aload_2
    //   1251: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1254: ldc_w 410
    //   1257: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1260: checkcast 163	java/lang/String
    //   1263: astore 8
    //   1265: aload_2
    //   1266: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1269: ldc_w 412
    //   1272: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1275: checkcast 365	[B
    //   1278: checkcast 365	[B
    //   1281: astore 10
    //   1283: aload 8
    //   1285: astore 7
    //   1287: aload 10
    //   1289: astore 8
    //   1291: goto +27 -> 1318
    //   1294: astore 10
    //   1296: aload 8
    //   1298: astore 7
    //   1300: aload 10
    //   1302: astore 8
    //   1304: goto +25 -> 1329
    //   1307: astore 8
    //   1309: goto +20 -> 1329
    //   1312: aload 9
    //   1314: astore 8
    //   1316: iconst_0
    //   1317: istore_3
    //   1318: aload 8
    //   1320: astore 9
    //   1322: goto +12 -> 1334
    //   1325: astore 8
    //   1327: iconst_0
    //   1328: istore_3
    //   1329: aload 8
    //   1331: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   1334: aload_0
    //   1335: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1338: iload_3
    //   1339: aload 7
    //   1341: aload 9
    //   1343: aload_1
    //   1344: aload_2
    //   1345: invokeinterface 416 6 0
    //   1350: goto +925 -> 2275
    //   1353: aload_2
    //   1354: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1357: getstatic 419	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_querySmsStat	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1360: if_acmpne +340 -> 1700
    //   1363: aload_0
    //   1364: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1367: ifnull +914 -> 2281
    //   1370: iconst_0
    //   1371: newarray byte
    //   1373: astore 8
    //   1375: aload_2
    //   1376: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1379: ifeq +216 -> 1595
    //   1382: aload_2
    //   1383: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1386: ldc_w 361
    //   1389: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1392: checkcast 310	java/lang/Integer
    //   1395: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1398: istore 4
    //   1400: aload_2
    //   1401: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1404: ldc_w 363
    //   1407: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1410: checkcast 365	[B
    //   1413: checkcast 365	[B
    //   1416: astore 7
    //   1418: aload_2
    //   1419: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1422: ldc_w 390
    //   1425: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1428: checkcast 310	java/lang/Integer
    //   1431: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1434: istore_3
    //   1435: aload_2
    //   1436: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1439: ldc_w 392
    //   1442: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1445: checkcast 310	java/lang/Integer
    //   1448: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1451: istore 5
    //   1453: aload_2
    //   1454: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1457: ldc_w 410
    //   1460: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1463: checkcast 163	java/lang/String
    //   1466: astore 9
    //   1468: aload_2
    //   1469: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1472: ldc_w 421
    //   1475: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1478: checkcast 163	java/lang/String
    //   1481: astore 11
    //   1483: aload_2
    //   1484: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1487: ldc_w 423
    //   1490: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1493: checkcast 163	java/lang/String
    //   1496: astore 10
    //   1498: aload 7
    //   1500: astore 8
    //   1502: aload 9
    //   1504: astore 7
    //   1506: aload 11
    //   1508: astore 9
    //   1510: goto +100 -> 1610
    //   1513: astore 8
    //   1515: aload 7
    //   1517: astore 10
    //   1519: aload 11
    //   1521: astore 7
    //   1523: goto +130 -> 1653
    //   1526: astore 8
    //   1528: aconst_null
    //   1529: astore 11
    //   1531: aload 7
    //   1533: astore 10
    //   1535: aload 11
    //   1537: astore 7
    //   1539: goto +114 -> 1653
    //   1542: astore 8
    //   1544: aconst_null
    //   1545: astore 9
    //   1547: aload 9
    //   1549: astore 11
    //   1551: aload 7
    //   1553: astore 10
    //   1555: aload 11
    //   1557: astore 7
    //   1559: goto +94 -> 1653
    //   1562: astore 8
    //   1564: aload 7
    //   1566: astore 10
    //   1568: goto +76 -> 1644
    //   1571: astore 8
    //   1573: goto +13 -> 1586
    //   1576: astore 9
    //   1578: aload 8
    //   1580: astore 7
    //   1582: aload 9
    //   1584: astore 8
    //   1586: iconst_0
    //   1587: istore_3
    //   1588: aload 7
    //   1590: astore 10
    //   1592: goto +52 -> 1644
    //   1595: aconst_null
    //   1596: astore 10
    //   1598: aload 10
    //   1600: astore 7
    //   1602: iconst_0
    //   1603: istore_3
    //   1604: iconst_0
    //   1605: istore 4
    //   1607: iconst_0
    //   1608: istore 5
    //   1610: aload 7
    //   1612: astore 11
    //   1614: aload 8
    //   1616: astore 7
    //   1618: aload 11
    //   1620: astore 8
    //   1622: aload 10
    //   1624: astore 11
    //   1626: goto +47 -> 1673
    //   1629: astore 7
    //   1631: iconst_0
    //   1632: istore_3
    //   1633: iconst_0
    //   1634: istore 4
    //   1636: aload 8
    //   1638: astore 10
    //   1640: aload 7
    //   1642: astore 8
    //   1644: aconst_null
    //   1645: astore 7
    //   1647: aconst_null
    //   1648: astore 9
    //   1650: iconst_0
    //   1651: istore 5
    //   1653: aload 8
    //   1655: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   1658: aconst_null
    //   1659: astore 11
    //   1661: aload 9
    //   1663: astore 8
    //   1665: aload 7
    //   1667: astore 9
    //   1669: aload 10
    //   1671: astore 7
    //   1673: aload_0
    //   1674: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1677: iload 4
    //   1679: aload 7
    //   1681: iload_3
    //   1682: iload 5
    //   1684: aload 8
    //   1686: aload 9
    //   1688: aload 11
    //   1690: aload_1
    //   1691: aload_2
    //   1692: invokeinterface 427 10 0
    //   1697: goto +598 -> 2295
    //   1700: aload_2
    //   1701: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1704: astore 8
    //   1706: getstatic 430	com/tencent/mobileqq/msf/sdk/MsfCommand:quick_register_checkAccount	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1709: astore 9
    //   1711: iconst_m1
    //   1712: istore_3
    //   1713: aload 8
    //   1715: aload 9
    //   1717: if_acmpne +114 -> 1831
    //   1720: aload_0
    //   1721: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1724: astore 7
    //   1726: aload 7
    //   1728: ifnull +573 -> 2301
    //   1731: iload_3
    //   1732: istore 4
    //   1734: aload_2
    //   1735: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1738: ifeq +34 -> 1772
    //   1741: aload_2
    //   1742: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1745: ldc_w 361
    //   1748: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1751: checkcast 310	java/lang/Integer
    //   1754: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1757: istore 4
    //   1759: goto +13 -> 1772
    //   1762: astore 7
    //   1764: aload 7
    //   1766: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   1769: iload_3
    //   1770: istore 4
    //   1772: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1775: ifeq +40 -> 1815
    //   1778: new 198	java/lang/StringBuilder
    //   1781: dup
    //   1782: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1785: astore 7
    //   1787: aload 7
    //   1789: ldc_w 432
    //   1792: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: pop
    //   1796: aload 7
    //   1798: aload_2
    //   1799: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1802: pop
    //   1803: ldc_w 434
    //   1806: iconst_2
    //   1807: aload 7
    //   1809: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1812: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1815: aload_0
    //   1816: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1819: iload 4
    //   1821: aload_1
    //   1822: aload_2
    //   1823: invokeinterface 437 4 0
    //   1828: goto +467 -> 2295
    //   1831: aload_2
    //   1832: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1835: getstatic 440	com/tencent/mobileqq/msf/sdk/MsfCommand:quick_register_getAccount	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1838: if_acmpne +171 -> 2009
    //   1841: aload_0
    //   1842: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1845: ifnull +456 -> 2301
    //   1848: iload_3
    //   1849: istore 4
    //   1851: aload_2
    //   1852: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1855: ifeq +64 -> 1919
    //   1858: iload_3
    //   1859: istore 4
    //   1861: aload_2
    //   1862: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1865: ldc_w 361
    //   1868: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1871: checkcast 310	java/lang/Integer
    //   1874: invokevirtual 313	java/lang/Integer:intValue	()I
    //   1877: istore_3
    //   1878: iload_3
    //   1879: istore 4
    //   1881: aload_2
    //   1882: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1885: ldc_w 410
    //   1888: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1891: checkcast 163	java/lang/String
    //   1894: astore 7
    //   1896: aload_2
    //   1897: getfield 359	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1900: ldc_w 377
    //   1903: invokevirtual 124	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1906: checkcast 163	java/lang/String
    //   1909: astore 8
    //   1911: goto +13 -> 1924
    //   1914: astore 8
    //   1916: goto +21 -> 1937
    //   1919: ldc_w 408
    //   1922: astore 8
    //   1924: goto +23 -> 1947
    //   1927: astore 8
    //   1929: ldc_w 408
    //   1932: astore 7
    //   1934: iload 4
    //   1936: istore_3
    //   1937: aload 8
    //   1939: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   1942: ldc_w 408
    //   1945: astore 8
    //   1947: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1950: ifeq +40 -> 1990
    //   1953: new 198	java/lang/StringBuilder
    //   1956: dup
    //   1957: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1960: astore 9
    //   1962: aload 9
    //   1964: ldc_w 432
    //   1967: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: pop
    //   1971: aload 9
    //   1973: aload_2
    //   1974: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1977: pop
    //   1978: ldc_w 434
    //   1981: iconst_2
    //   1982: aload 9
    //   1984: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1987: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1990: aload_0
    //   1991: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1994: iload_3
    //   1995: aload 7
    //   1997: aload 8
    //   1999: aload_1
    //   2000: aload_2
    //   2001: invokeinterface 444 6 0
    //   2006: goto +289 -> 2295
    //   2009: aload_2
    //   2010: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   2013: getstatic 447	com/tencent/mobileqq/msf/sdk/MsfCommand:getKey	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   2016: if_acmpne +285 -> 2301
    //   2019: aload_0
    //   2020: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   2023: astore 7
    //   2025: aload 7
    //   2027: ifnull +274 -> 2301
    //   2030: aload_0
    //   2031: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   2034: aload_1
    //   2035: aload_2
    //   2036: invokeinterface 450 3 0
    //   2041: goto +254 -> 2295
    //   2044: astore 7
    //   2046: aload 7
    //   2048: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   2051: goto +244 -> 2295
    //   2054: aload_0
    //   2055: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   2058: ifnull +243 -> 2301
    //   2061: aload_2
    //   2062: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   2065: istore 6
    //   2067: iload 6
    //   2069: ifeq +220 -> 2289
    //   2072: aload_2
    //   2073: invokevirtual 193	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2076: astore 7
    //   2078: new 452	com/qq/jce/wup/UniPacket
    //   2081: dup
    //   2082: iconst_1
    //   2083: invokespecial 455	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   2086: astore 9
    //   2088: aload 9
    //   2090: ldc_w 457
    //   2093: invokevirtual 460	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   2096: aload 9
    //   2098: aload 7
    //   2100: invokevirtual 464	com/qq/jce/wup/UniPacket:decode	([B)V
    //   2103: aload 9
    //   2105: ldc_w 466
    //   2108: new 468	com/tencent/msf/service/protocol/security/RespondCustomSig
    //   2111: dup
    //   2112: invokespecial 469	com/tencent/msf/service/protocol/security/RespondCustomSig:<init>	()V
    //   2115: invokevirtual 472	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2118: checkcast 468	com/tencent/msf/service/protocol/security/RespondCustomSig
    //   2121: astore 7
    //   2123: goto +13 -> 2136
    //   2126: astore 7
    //   2128: aload 7
    //   2130: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   2133: goto +156 -> 2289
    //   2136: aload_0
    //   2137: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   2140: iload_3
    //   2141: iload 4
    //   2143: aload 8
    //   2145: aload 7
    //   2147: aload_1
    //   2148: aload_2
    //   2149: invokeinterface 476 7 0
    //   2154: goto +141 -> 2295
    //   2157: aload_0
    //   2158: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   2161: ifnull +140 -> 2301
    //   2164: aload_0
    //   2165: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   2168: iload_3
    //   2169: iload 4
    //   2171: aload 8
    //   2173: aload_1
    //   2174: aload_2
    //   2175: invokeinterface 479 6 0
    //   2180: goto +115 -> 2295
    //   2183: aload_0
    //   2184: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   2187: ifnull +114 -> 2301
    //   2190: aload_0
    //   2191: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   2194: iload_3
    //   2195: iload 4
    //   2197: aload 8
    //   2199: aload_1
    //   2200: aload_2
    //   2201: invokeinterface 263 6 0
    //   2206: goto +89 -> 2295
    //   2209: iload 6
    //   2211: ifne +25 -> 2236
    //   2214: aload_0
    //   2215: getfield 35	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:msfMsgHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IMsfMsgHandler;
    //   2218: ifnull +16 -> 2234
    //   2221: aload_0
    //   2222: getfield 35	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:msfMsgHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IMsfMsgHandler;
    //   2225: aload_1
    //   2226: aload_2
    //   2227: invokeinterface 482 3 0
    //   2232: iconst_1
    //   2233: ireturn
    //   2234: iconst_0
    //   2235: ireturn
    //   2236: iload 6
    //   2238: ireturn
    //   2239: astore_1
    //   2240: new 198	java/lang/StringBuilder
    //   2243: dup
    //   2244: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   2247: astore_2
    //   2248: aload_2
    //   2249: ldc_w 484
    //   2252: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: pop
    //   2256: aload_2
    //   2257: aload_1
    //   2258: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2261: pop
    //   2262: ldc 8
    //   2264: iconst_1
    //   2265: aload_2
    //   2266: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2269: aload_1
    //   2270: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2273: iconst_1
    //   2274: ireturn
    //   2275: iconst_1
    //   2276: istore 6
    //   2278: goto -69 -> 2209
    //   2281: goto +20 -> 2301
    //   2284: iconst_0
    //   2285: istore_3
    //   2286: goto -1110 -> 1176
    //   2289: aconst_null
    //   2290: astore 7
    //   2292: goto -156 -> 2136
    //   2295: iconst_1
    //   2296: istore 6
    //   2298: goto -89 -> 2209
    //   2301: iconst_0
    //   2302: istore 6
    //   2304: goto -95 -> 2209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2307	0	this	MsfRespHandleUtil
    //   0	2307	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	2307	2	paramFromServiceMsg	FromServiceMsg
    //   4	2282	3	i	int
    //   9	2187	4	j	int
    //   1001	682	5	k	int
    //   407	1896	6	bool	boolean
    //   30	422	7	localObject1	Object
    //   463	23	7	localException1	Exception
    //   633	67	7	localObject2	Object
    //   704	1	7	localException2	Exception
    //   713	1	7	localObject3	Object
    //   718	5	7	localException3	Exception
    //   729	134	7	localObject4	Object
    //   867	1	7	localException4	Exception
    //   874	1	7	localObject5	Object
    //   881	5	7	localException5	Exception
    //   892	154	7	localObject6	Object
    //   1050	1	7	localException6	Exception
    //   1065	1	7	localObject7	Object
    //   1070	8	7	localException7	Exception
    //   1095	40	7	localObject8	Object
    //   1166	3	7	localException8	Exception
    //   1205	412	7	localObject9	Object
    //   1629	12	7	localException9	Exception
    //   1645	82	7	localObject10	Object
    //   1762	3	7	localException10	Exception
    //   1785	241	7	localObject11	Object
    //   2044	3	7	localException11	Exception
    //   2076	46	7	localObject12	Object
    //   2126	20	7	localException12	Exception
    //   2290	1	7	localObject13	Object
    //   15	1288	8	localObject14	Object
    //   1307	1	8	localException13	Exception
    //   1314	5	8	localObject15	Object
    //   1325	5	8	localException14	Exception
    //   1373	128	8	localObject16	Object
    //   1513	1	8	localException15	Exception
    //   1526	1	8	localException16	Exception
    //   1542	1	8	localException17	Exception
    //   1562	1	8	localException18	Exception
    //   1571	8	8	localException19	Exception
    //   1584	326	8	localObject17	Object
    //   1914	1	8	localException20	Exception
    //   1922	1	8	str1	String
    //   1927	11	8	localException21	Exception
    //   1945	253	8	str2	String
    //   116	775	9	arrayOfByte	byte[]
    //   1024	1	9	localException22	Exception
    //   1037	7	9	localException23	Exception
    //   1079	469	9	localObject18	Object
    //   1576	7	9	localException24	Exception
    //   1648	456	9	localObject19	Object
    //   113	735	10	localObject20	Object
    //   854	7	10	localException25	Exception
    //   1200	88	10	localObject21	Object
    //   1294	7	10	localException26	Exception
    //   1496	174	10	localObject22	Object
    //   1481	208	11	localObject23	Object
    // Exception table:
    //   from	to	target	type
    //   414	460	463	java/lang/Exception
    //   683	701	704	java/lang/Exception
    //   659	683	718	java/lang/Exception
    //   825	843	854	java/lang/Exception
    //   807	825	867	java/lang/Exception
    //   783	807	881	java/lang/Exception
    //   1003	1021	1024	java/lang/Exception
    //   985	1003	1037	java/lang/Exception
    //   967	985	1050	java/lang/Exception
    //   943	967	1070	java/lang/Exception
    //   1139	1163	1166	java/lang/Exception
    //   1265	1283	1294	java/lang/Exception
    //   1250	1265	1307	java/lang/Exception
    //   1226	1250	1325	java/lang/Exception
    //   1483	1498	1513	java/lang/Exception
    //   1468	1483	1526	java/lang/Exception
    //   1453	1468	1542	java/lang/Exception
    //   1435	1453	1562	java/lang/Exception
    //   1418	1435	1571	java/lang/Exception
    //   1400	1418	1576	java/lang/Exception
    //   1375	1400	1629	java/lang/Exception
    //   1734	1759	1762	java/lang/Exception
    //   1896	1911	1914	java/lang/Exception
    //   1851	1858	1927	java/lang/Exception
    //   1861	1878	1927	java/lang/Exception
    //   1881	1896	1927	java/lang/Exception
    //   2030	2041	2044	java/lang/Exception
    //   2072	2123	2126	java/lang/Exception
    //   0	58	2239	java/lang/Exception
    //   58	78	2239	java/lang/Exception
    //   81	101	2239	java/lang/Exception
    //   104	115	2239	java/lang/Exception
    //   125	135	2239	java/lang/Exception
    //   138	171	2239	java/lang/Exception
    //   174	207	2239	java/lang/Exception
    //   210	243	2239	java/lang/Exception
    //   246	279	2239	java/lang/Exception
    //   282	315	2239	java/lang/Exception
    //   318	354	2239	java/lang/Exception
    //   357	390	2239	java/lang/Exception
    //   393	409	2239	java/lang/Exception
    //   465	502	2239	java/lang/Exception
    //   505	533	2239	java/lang/Exception
    //   536	564	2239	java/lang/Exception
    //   567	595	2239	java/lang/Exception
    //   598	626	2239	java/lang/Exception
    //   629	640	2239	java/lang/Exception
    //   647	659	2239	java/lang/Exception
    //   722	727	2239	java/lang/Exception
    //   731	745	2239	java/lang/Exception
    //   748	759	2239	java/lang/Exception
    //   766	783	2239	java/lang/Exception
    //   885	890	2239	java/lang/Exception
    //   894	910	2239	java/lang/Exception
    //   913	924	2239	java/lang/Exception
    //   931	943	2239	java/lang/Exception
    //   1081	1086	2239	java/lang/Exception
    //   1097	1115	2239	java/lang/Exception
    //   1118	1134	2239	java/lang/Exception
    //   1168	1173	2239	java/lang/Exception
    //   1176	1188	2239	java/lang/Exception
    //   1191	1202	2239	java/lang/Exception
    //   1214	1226	2239	java/lang/Exception
    //   1329	1334	2239	java/lang/Exception
    //   1334	1350	2239	java/lang/Exception
    //   1353	1375	2239	java/lang/Exception
    //   1653	1658	2239	java/lang/Exception
    //   1673	1697	2239	java/lang/Exception
    //   1700	1711	2239	java/lang/Exception
    //   1720	1726	2239	java/lang/Exception
    //   1764	1769	2239	java/lang/Exception
    //   1772	1815	2239	java/lang/Exception
    //   1815	1828	2239	java/lang/Exception
    //   1831	1848	2239	java/lang/Exception
    //   1937	1942	2239	java/lang/Exception
    //   1947	1990	2239	java/lang/Exception
    //   1990	2006	2239	java/lang/Exception
    //   2009	2025	2239	java/lang/Exception
    //   2046	2051	2239	java/lang/Exception
    //   2054	2067	2239	java/lang/Exception
    //   2128	2133	2239	java/lang/Exception
    //   2136	2154	2239	java/lang/Exception
    //   2157	2180	2239	java/lang/Exception
    //   2183	2206	2239	java/lang/Exception
    //   2214	2232	2239	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil
 * JD-Core Version:    0.7.0.1
 */