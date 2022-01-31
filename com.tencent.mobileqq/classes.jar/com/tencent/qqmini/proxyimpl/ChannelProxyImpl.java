package com.tencent.qqmini.proxyimpl;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import Wallet.FocusMpIdReq;
import aiqs;
import alxe;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bcgx;
import bdcs;
import bduw;
import bexd;
import bgjd;
import bheo;
import bize;
import bkcg;
import bkci;
import bkcj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.SoLoaderOption;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import common.config.service.QzoneConfig;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class ChannelProxyImpl
  implements ChannelProxy
{
  private static final String TAG = "ChannelProxyImpl";
  public static volatile boolean mIsOskPlayerInited;
  private static final String oskPlayerContentTypeList = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  
  private void copyDebugSo()
  {
    String str1 = TissueGlobal.tissueEnv.getNativeLibDir();
    Object localObject = new File(bduw.a("Tencent/tissue_dbg/"));
    File localFile = ((File)localObject).getParentFile();
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdirs();
    }
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      int i = 0;
      if (i < localObject.length)
      {
        if (localObject[i] == null) {}
        for (;;)
        {
          i += 1;
          break;
          localFile = new File(str1, localObject[i].getName());
          String str2 = md5sum(localObject[i].getAbsolutePath());
          if (localFile.exists())
          {
            String str3 = md5sum(localFile.getAbsolutePath());
            if ((str2 != null) && (!str2.equals(str3)))
            {
              QMLog.i("V8JsLoader", "overwrite " + localFile.getAbsolutePath() + " from " + localObject[i].getAbsolutePath());
              bdcs.a(localObject[i], localFile);
            }
            QMLog.i("V8JsLoader", localObject[i].getAbsolutePath() + ":" + str2 + "|" + localFile.getAbsolutePath() + ":" + str3);
          }
        }
      }
    }
  }
  
  private static MiniAppCmdInterface createCmdInterface(AsyncResult paramAsyncResult)
  {
    return new ChannelProxyImpl.7(paramAsyncResult);
  }
  
  private static void initOskOnce(Context paramContext)
  {
    if (!mIsOskPlayerInited)
    {
      OskPlayerConfig localOskPlayerConfig = new OskPlayerConfig();
      localOskPlayerConfig.setEnableHLSCache(true);
      localOskPlayerConfig.setDebugVersion(true);
      localOskPlayerConfig.setLogger(new DefaultLogger());
      localOskPlayerConfig.setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), localOskPlayerConfig);
      paramContext = PlayerConfig.g().getContentTypeList();
      if (paramContext == null) {
        break label123;
      }
    }
    for (;;)
    {
      try
      {
        paramContext.addAll(Arrays.asList(oskPlayerContentTypeList.split("|")));
        PlayerConfig.g().setContentTypeList(paramContext);
        mIsOskPlayerInited = true;
        return;
      }
      catch (Exception paramContext)
      {
        QMLog.e("ChannelProxyImpl", "initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:" + paramContext);
        continue;
      }
      label123:
      QMLog.e("ChannelProxyImpl", "getContentTypeList null");
    }
  }
  
  /* Error */
  public static String md5sum(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: sipush 1024
    //   5: newarray byte
    //   7: astore 4
    //   9: new 222	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: ldc 225
    //   22: invokestatic 230	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   25: astore 5
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: aload 4
    //   32: invokevirtual 236	java/io/InputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle +41 -> 78
    //   40: aload_2
    //   41: astore_0
    //   42: aload 5
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 240	java/security/MessageDigest:update	([BII)V
    //   51: goto -24 -> 27
    //   54: astore_0
    //   55: aload_2
    //   56: astore_0
    //   57: ldc 10
    //   59: ldc 241
    //   61: invokestatic 216	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_3
    //   65: astore_0
    //   66: aload_2
    //   67: ifnull +9 -> 76
    //   70: aload_2
    //   71: invokevirtual 244	java/io/InputStream:close	()V
    //   74: aload_3
    //   75: astore_0
    //   76: aload_0
    //   77: areturn
    //   78: aload_2
    //   79: astore_0
    //   80: aload 5
    //   82: invokevirtual 248	java/security/MessageDigest:digest	()[B
    //   85: invokestatic 252	com/tencent/qqmini/proxyimpl/ChannelProxyImpl:toHexString	([B)Ljava/lang/String;
    //   88: astore 4
    //   90: aload 4
    //   92: astore_3
    //   93: aload_3
    //   94: astore_0
    //   95: aload_2
    //   96: ifnull -20 -> 76
    //   99: aload_2
    //   100: invokevirtual 244	java/io/InputStream:close	()V
    //   103: aload_3
    //   104: areturn
    //   105: astore_0
    //   106: aload_3
    //   107: areturn
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 244	java/io/InputStream:close	()V
    //   119: aload_2
    //   120: athrow
    //   121: astore_0
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: goto -6 -> 119
    //   128: astore_2
    //   129: goto -18 -> 111
    //   132: astore_0
    //   133: aconst_null
    //   134: astore_2
    //   135: goto -80 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   35	13	1	i	int
    //   17	83	2	localFileInputStream	java.io.FileInputStream
    //   108	12	2	localObject1	Object
    //   128	1	2	localObject2	Object
    //   134	1	2	localObject3	Object
    //   1	106	3	localObject4	Object
    //   7	84	4	localObject5	Object
    //   25	56	5	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   20	27	54	java/lang/Exception
    //   29	36	54	java/lang/Exception
    //   42	51	54	java/lang/Exception
    //   80	90	54	java/lang/Exception
    //   99	103	105	java/io/IOException
    //   2	18	108	finally
    //   70	74	121	java/io/IOException
    //   115	119	124	java/io/IOException
    //   20	27	128	finally
    //   29	36	128	finally
    //   42	51	128	finally
    //   57	64	128	finally
    //   80	90	128	finally
    //   2	18	132	java/lang/Exception
  }
  
  private bkcj newTianShuReportData(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    bkcj localbkcj = new bkcj();
    localbkcj.b = (String.valueOf(bexd.a().a()) + '_' + i);
    localbkcj.d = paramInt;
    localbkcj.jdField_e_of_type_Int = 1;
    localbkcj.g = String.valueOf(paramAdItem.iAdId.get());
    localbkcj.n = paramString;
    localbkcj.jdField_a_of_type_Long = i;
    localbkcj.jdField_a_of_type_Int = 1;
    localbkcj.jdField_e_of_type_JavaLangString = "tianshu.81";
    localbkcj.i = "";
    return localbkcj;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 49;
    char[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 50;
    char[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 51;
    char[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 52;
    char[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 53;
    char[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 54;
    char[] tmp51_44 = tmp44_38;
    tmp51_44[7] = 55;
    char[] tmp58_51 = tmp51_44;
    tmp58_51[8] = 56;
    char[] tmp65_58 = tmp58_51;
    tmp65_58[9] = 57;
    char[] tmp72_65 = tmp65_58;
    tmp72_65[10] = 65;
    char[] tmp79_72 = tmp72_65;
    tmp79_72[11] = 66;
    char[] tmp86_79 = tmp79_72;
    tmp86_79[12] = 67;
    char[] tmp93_86 = tmp86_79;
    tmp93_86[13] = 68;
    char[] tmp100_93 = tmp93_86;
    tmp100_93[14] = 69;
    char[] tmp107_100 = tmp100_93;
    tmp107_100[15] = 70;
    tmp107_100;
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(arrayOfChar[((k & 0xF0) >>> 4)]);
      localStringBuilder.append(arrayOfChar[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void JudgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    INTERFACE.StJudgeTimingReq localStJudgeTimingReq = new INTERFACE.StJudgeTimingReq();
    localStJudgeTimingReq.appid.set(paramString1);
    localStJudgeTimingReq.appType.set(paramInt1);
    localStJudgeTimingReq.scene.set(paramInt2);
    localStJudgeTimingReq.factType.set(paramInt3);
    localStJudgeTimingReq.reportTime.set(paramLong);
    localStJudgeTimingReq.totalTime.set(paramInt4);
    localStJudgeTimingReq.launchId.set(paramString2);
    localStJudgeTimingReq.afterCertify.set(paramInt5);
    localStJudgeTimingReq.via.set(paramString3);
    localStJudgeTimingReq.AdsTotalTime.set(paramInt6);
    if (paramStCommonExt != null) {
      localStJudgeTimingReq.extInfo.set(paramStCommonExt);
    }
    MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.JudgeTiming", paramString1, localStJudgeTimingReq, INTERFACE.StJudgeTimingRsp.class, new ChannelProxyImpl.2(this, paramAsyncResult));
  }
  
  public void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    INTERFACE.StReportExecuteReq localStReportExecuteReq = new INTERFACE.StReportExecuteReq();
    localStReportExecuteReq.appid.set(paramString1);
    localStReportExecuteReq.execTime.set(paramInt);
    localStReportExecuteReq.instrTraceId.set(paramString2);
    localStReportExecuteReq.ruleName.set(paramString3);
    MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.ReportExecute", paramString1, localStReportExecuteReq, INTERFACE.StReportExecuteRsp.class, new ChannelProxyImpl.3(this, paramAsyncResult));
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    aiqs.a(new FocusMpIdReq(paramString1, paramString2), new ChannelProxyImpl.6(this, paramAsyncResult));
    return true;
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().batchGetContact(paramArrayList, createCmdInterface(paramAsyncResult));
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkNavigateRight(paramString1, paramString2, null, createCmdInterface(paramAsyncResult));
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkOfferId(paramString1, paramString2, null, createCmdInterface(paramAsyncResult));
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkSession(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().performDataReport(paramArrayOfByte, createCmdInterface(paramAsyncResult));
  }
  
  public void downloadQQBrowser(String paramString) {}
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByIdForSDK(null, paramString1, paramString2, paramString3, createCmdInterface(paramAsyncResult));
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLinkForSDK(paramString, paramInt, createCmdInterface(paramAsyncResult));
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    MiniAppCmdUtil.getInstance().getAuthList(null, paramString, new ChannelProxyImpl.1(this, paramAuthListResult));
  }
  
  public String getDeviceInfo()
  {
    return bize.a().c();
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getFormId(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getFriendCloudStorage(paramString, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult) {}
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGroupCloudStorage(paramString1, paramString2, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGroupShareInfo(paramString1, paramString2, null, createCmdInterface(paramAsyncResult));
  }
  
  public IMediaPlayer getMediaPlayer()
  {
    if (!PlayerConfig.hasInit())
    {
      Context localContext = AppLoaderFactory.g().getContext();
      if (localContext == null) {
        throw new RuntimeException("BaseApplicationImpl ctx is null");
      }
      PlayerConfig.init(localContext);
      PlayerConfig.g().setLogger(new bheo());
    }
    if (!VideoManager.hasInit()) {
      VideoManager.init(AppLoaderFactory.g().getContext());
    }
    initOskOnce(AppLoaderFactory.g().getContext());
    return new MediaPlayerImpl();
  }
  
  public IMediaPlayerUtil getMediaPlayerUtil()
  {
    return new ChannelProxyImpl.9(this);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, createCmdInterface(paramAsyncResult));
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMiniAppStoreAppList(paramInt, createCmdInterface(paramAsyncResult));
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getNativeAppInfoForJump(null, paramString1, paramString2, paramString3, paramInt, createCmdInterface(paramAsyncResult));
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getPhoneNumber(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getPotentialFriendList(paramStCommonExt, paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getRobotUin(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult) {}
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getShareInfo(paramStAdaptShareInfoReq, createCmdInterface(paramAsyncResult));
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getTcbTicket(paramString1, null, paramString2, createCmdInterface(paramAsyncResult));
  }
  
  public ChannelProxy.SoLoaderOption getTissueSoLoaderOption()
  {
    return null;
  }
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserCloudStorage(paramString, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserHealthData(paramString, null, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfo(paramString1, paramBoolean, paramString2, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfoExtra(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfoOpenData(paramString1, paramString2, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInteractiveStorage(paramStCommonExt, paramString, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserSetting(paramString1, paramString2, paramString3, createCmdInterface(paramAsyncResult));
  }
  
  public void httpReport(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (alxe)((QQAppInterface)localObject).a(5);
        if (localObject != null) {
          ((alxe)localObject).a(paramBundle);
        }
      }
    }
  }
  
  public boolean isGooglePlayVersion()
  {
    return false;
  }
  
  public boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, ChatActivity.class));
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("chat_subType", 2);
    localIntent.putExtra("uinname", paramString2);
    localIntent.setFlags(67108864);
    return true;
  }
  
  public void login(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getLoginCode(paramString, createCmdInterface(paramAsyncResult));
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().modifyFriendInteractiveStorage(paramStCommonExt, paramString1, paramString2, paramString3, paramInt, paramString4, paramHashMap, createCmdInterface(paramAsyncResult));
  }
  
  public boolean openGroup(Context paramContext, String paramString, AsyncResult paramAsyncResult)
  {
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      paramContext = new Intent(paramContext, QQBrowserActivity.class);
      paramContext.putExtra("url", paramString);
      paramString = new Bundle();
      paramString.putBoolean("hide_more_button", true);
      paramContext.putExtras(paramString);
      bgjd.a().a(new ChannelProxyImpl.5(this, paramAsyncResult));
      localActivity.startActivityForResult(paramContext, 9);
      return true;
    }
    return false;
  }
  
  public boolean openPermissionSettingsActivity(Context paramContext, String paramString1, String paramString2)
  {
    PermissionSettingFragment.launchForResult((Activity)paramContext, paramString1, paramString2, 5);
    return true;
  }
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    bcgx.a(paramContext, paramString1, paramString2);
    return true;
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt2, null, createCmdInterface(paramAsyncResult));
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().removeUserCloudStorage(paramString, paramArrayOfString, createCmdInterface(paramAsyncResult));
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().performReport(paramArrayOfByte, createCmdInterface(paramAsyncResult), "LightAppSvc." + paramString1 + "." + paramString2);
  }
  
  public void reportShare(COMM.StCommonExt paramStCommonExt, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, AsyncResult paramAsyncResult)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      MiniAppCmdUtil.getInstance().reportShare(paramStCommonExt, paramLong, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, createCmdInterface(paramAsyncResult));
    }
  }
  
  public void setAuth(String paramString, UserAuthInfo paramUserAuthInfo, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(paramUserAuthInfo.scope);
    if (!TextUtils.isEmpty(paramUserAuthInfo.desc)) {
      localStUserAuthInfo.desc.set(paramUserAuthInfo.desc);
    }
    localStUserAuthInfo.authState.set(paramUserAuthInfo.authState);
    MiniAppCmdUtil.getInstance().setAuth(null, paramString, localStUserAuthInfo, createCmdInterface(paramAsyncResult));
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().setPersonalizeInfo(paramString1, paramString2, paramInt, paramString3, paramString4, createCmdInterface(paramAsyncResult));
  }
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().setUserCloudStorage(paramString, paramHashMap, createCmdInterface(paramAsyncResult));
  }
  
  public boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2)
  {
    AddFriendLogicActivity.a = paramString1;
    paramContext.startActivity(AddFriendLogicActivity.a(paramContext, 3, paramString2, paramString1, 3024, Integer.parseInt(paramString1), null, null, null, "", null));
    return true;
  }
  
  public boolean startTransparentBrowserActivityForResult(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramString = new Bundle();
    paramString.putBoolean("hide_left_button", true);
    paramString.putBoolean("hide_more_button", true);
    localIntent.putExtras(paramString);
    if (paramActivity != null)
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    bkci.a().a(newTianShuReportData(paramAdItem, paramString, paramInt));
    return true;
  }
  
  public boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult)
  {
    paramContext = new bkcg();
    paramContext.jdField_a_of_type_Int = paramInt2;
    paramContext.b = paramInt3;
    bkci.a().a(Collections.singletonList(paramContext), new ChannelProxyImpl.4(this, paramAsyncResult));
    return true;
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().transForRoomId(paramString1, paramString2, createCmdInterface(paramAsyncResult));
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    return MiniAppCmdUtil.getInstance().updateBaseLibForSDK(paramString, paramBoolean1, paramBoolean2, createCmdInterface(paramAsyncResult));
  }
  
  public boolean updateEntryList(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data", paramString);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "update_entry_list", localBundle, null);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ChannelProxyImpl", 1, paramString, new Object[0]);
      paramString.printStackTrace();
    }
    return true;
  }
  
  public void updateUserSetting(String paramString, UserSettingInfo paramUserSettingInfo, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserSettingInfo localStUserSettingInfo = new INTERFACE.StUserSettingInfo();
    localStUserSettingInfo.settingItem.set(paramUserSettingInfo.settingItem);
    localStUserSettingInfo.authState.set(paramUserSettingInfo.authState);
    localStUserSettingInfo.desc.set(paramUserSettingInfo.desc);
    MiniAppCmdUtil.getInstance().updateUserSetting(null, paramString, localStUserSettingInfo, createCmdInterface(paramAsyncResult));
  }
  
  public void uploadUserLog(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("appid", paramString);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "upload_user_log", localBundle, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ChannelProxyImpl", 1, paramString, new Object[0]);
      paramString.printStackTrace();
    }
  }
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().useUserApp(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramStCommonExt, createCmdInterface(paramAsyncResult));
  }
  
  public void verifyPlugin(String paramString, ArrayList<com.tencent.qqmini.sdk.launcher.model.PluginInfo> paramArrayList, AsyncResult paramAsyncResult)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.qqmini.sdk.launcher.model.PluginInfo localPluginInfo = (com.tencent.qqmini.sdk.launcher.model.PluginInfo)paramArrayList.next();
      com.tencent.mobileqq.mini.apkg.PluginInfo localPluginInfo1 = new com.tencent.mobileqq.mini.apkg.PluginInfo();
      localPluginInfo1.setInnerVersion(localPluginInfo.getInnerVersion());
      localPluginInfo1.setPluginId(localPluginInfo.getInnerVersion());
      localArrayList.add(localPluginInfo1);
    }
    MiniAppCmdUtil.getInstance().verifyPlugin(paramString, localArrayList, createCmdInterface(paramAsyncResult));
  }
  
  public boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    return MiniAppUtils.performWnsCgiRequest(paramJSONObject, paramAsyncResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl
 * JD-Core Version:    0.7.0.1
 */