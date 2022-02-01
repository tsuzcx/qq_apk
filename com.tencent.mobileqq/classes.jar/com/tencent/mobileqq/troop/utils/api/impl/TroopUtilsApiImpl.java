package com.tencent.mobileqq.troop.utils.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleLaunchParam;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.api.TroopUtilsConstant;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class TroopUtilsApiImpl
  implements ITroopUtilsApi
{
  public static final int CMD_0X88D_SERVICE_TYPE_14 = 14;
  public static final String TAG = "TroopUtilsApiImpl";
  public int mExposureSource;
  
  private void handleRequestTroopPrivilegeReply(int paramInt, byte[] paramArrayOfByte, String paramString, Context paramContext, structmsg.StructMsg paramStructMsg, TroopNotificationUtils.TroopPrivilegeCallback paramTroopPrivilegeCallback)
  {
    Object localObject1 = null;
    int i = -1;
    if (paramInt == 0)
    {
      Object localObject3 = new oidb_sso.OIDBSSOPkg();
      Object localObject4;
      try
      {
        paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject3).mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handle_oidb_0x88d_0|oidb_sso parseFrom byte ");
          ((StringBuilder)localObject4).append(paramArrayOfByte.toString());
          QLog.d("TroopUtilsApiImpl", 2, ((StringBuilder)localObject4).toString());
        }
        paramArrayOfByte = (byte[])localObject3;
      }
      int j;
      if (paramArrayOfByte != null)
      {
        j = paramArrayOfByte.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result ");
          ((StringBuilder)localObject3).append(j);
          QLog.d("TroopUtilsApiImpl", 2, ((StringBuilder)localObject3).toString());
          i = j;
        }
      }
      if ((i == 0) && (paramArrayOfByte != null) && (paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null))
      {
        paramArrayOfByte = paramArrayOfByte.bytes_bodybuffer.get().toByteArray();
        try
        {
          localObject3 = new oidb_0x88d.RspBody();
          ((oidb_0x88d.RspBody)localObject3).mergeFrom(paramArrayOfByte);
          if ((i != 0) && (((oidb_0x88d.RspBody)localObject3).str_errorinfo.has())) {
            paramArrayOfByte = String.valueOf(((oidb_0x88d.RspBody)localObject3).str_errorinfo.get().toByteArray());
          } else {
            paramArrayOfByte = null;
          }
          try
          {
            localObject4 = ((oidb_0x88d.RspBody)localObject3).stzrspgroupinfo.get();
            int k = 0;
            if (localObject4 == null) {
              j = 0;
            } else {
              j = ((List)localObject4).size();
            }
            for (;;)
            {
              if ((localObject1 == null) && (k < j)) {}
              try
              {
                oidb_0x88d.RspGroupInfo localRspGroupInfo = (oidb_0x88d.RspGroupInfo)((List)localObject4).get(k);
                localObject3 = localObject1;
                int m = i;
                if (localRspGroupInfo != null) {
                  if (!paramString.equals(String.valueOf(localRspGroupInfo.uint64_group_code.get())))
                  {
                    localObject3 = localObject1;
                    m = i;
                  }
                  else
                  {
                    m = localRspGroupInfo.uint32_result.get();
                    localObject3 = localObject1;
                    if (m == 0)
                    {
                      localObject3 = localObject1;
                      try
                      {
                        if (localRspGroupInfo.stgroupinfo.has()) {
                          localObject3 = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get();
                        }
                      }
                      catch (Exception localException1)
                      {
                        i = m;
                        break label498;
                      }
                    }
                  }
                }
                k += 1;
                localObject2 = localObject3;
                i = m;
              }
              catch (Exception localException2)
              {
                Object localObject2;
                break label498;
              }
            }
            localObject3 = paramArrayOfByte;
            j = i;
            if (localObject2 == null) {
              break label529;
            }
            localObject3 = paramArrayOfByte;
            j = i;
            if (!localObject2.uint32_app_privilege_flag.has()) {
              break label529;
            }
            j = localObject2.uint32_app_privilege_flag.get();
            new Handler(paramContext.getMainLooper()).post(new TroopUtilsApiImpl.2(this, paramTroopPrivilegeCallback, paramString, paramStructMsg, j));
            return;
          }
          catch (Exception localException3) {}
          localObject3 = paramArrayOfByte;
        }
        catch (Exception localException4)
        {
          paramArrayOfByte = null;
        }
        label498:
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troopdisband.", 2, localException4.toString());
          j = i;
          localObject3 = paramArrayOfByte;
        }
        label529:
        paramArrayOfByte = (byte[])localObject3;
        i = j;
      }
      else
      {
        paramArrayOfByte = null;
      }
    }
    else
    {
      paramArrayOfByte = null;
      i = -1;
    }
    new Handler(paramContext.getMainLooper()).post(new TroopUtilsApiImpl.3(this, paramTroopPrivilegeCallback, paramString, paramStructMsg, i, paramInt, paramArrayOfByte));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder(150);
      paramContext.append("handle_oidb_0x88d_0");
      paramContext.append("|result = ");
      paramContext.append(i);
      paramContext.append("|errorCode = ");
      paramContext.append(paramInt);
      paramContext.append("|troopuin = ");
      paramContext.append(paramString);
      paramContext.append("|strErrorMsg = ");
      paramContext.append(paramArrayOfByte);
      QLog.i("TroopUtilsApiImpl", 2, paramContext.toString());
    }
  }
  
  private static char hexDigit(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      paramInt += 48;
    } else {
      paramInt = paramInt - 10 + 97;
    }
    return (char)paramInt;
  }
  
  public void calJoinTroop(TroopInfoData paramTroopInfoData, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTroopInfoData.pa == 19)
    {
      ReportController.b(null, "P_CliOper", "Grp_nearby", "", "recom", "Clk_joingrp", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 18)
    {
      ReportController.b(null, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 24)
    {
      ReportController.b(null, "P_CliOper", "Grp_nearby", "", "search", "Clk_joingrp", 0, 0, "", "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 17)
    {
      ReportController.b(null, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    int i = paramTroopInfoData.pa;
    int j = 10;
    if (i != 10)
    {
      if (i != 11)
      {
        if (i != 15)
        {
          if (i != 34)
          {
            if (i != 20)
            {
              if (i != 21) {
                i = -1;
              } else {
                i = 7;
              }
            }
            else {
              i = 6;
            }
          }
          else {
            i = 11;
          }
        }
        else {
          i = 0;
        }
      }
      else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    if (i == -1) {
      if (paramTroopInfoData.nStatOption == 7) {
        i = 3;
      } else if (paramTroopInfoData.nStatOption == 8) {
        i = 4;
      } else if (paramTroopInfoData.nStatOption == 10002) {
        i = j;
      }
    }
    j = paramTroopInfoData.getStatOption();
    Object localObject1 = paramTroopInfoData.troopUin;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(j);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    ReportController.b(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", i, 0, (String)localObject1, (String)localObject2, (String)localObject3, localStringBuilder.toString());
    paramTroopInfoData = paramTroopInfoData.troopUin;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append("");
    ReportController.b(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", i, 0, paramTroopInfoData, (String)localObject1, ((StringBuilder)localObject2).toString(), "");
  }
  
  public void checkApiState(AppRuntime paramAppRuntime, Context paramContext, String paramString, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(TroopUtilsConstant.a);
    String str = paramAppRuntime.getAccount();
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    paramAppRuntime = ((TicketManager)localObject).getSkey(str);
    localObject = ((TicketManager)localObject).getPskey(str, "connect.qq.com");
    localBundle.putString("Referer", "https://cgi.connect.qq.com/");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("p_skey=");
    localStringBuilder2.append((String)localObject);
    localStringBuilder2.append(";p_uin=");
    localStringBuilder2.append(str);
    localStringBuilder2.append(";skey=");
    localStringBuilder2.append(paramAppRuntime);
    localStringBuilder2.append(";uin=");
    localStringBuilder2.append(str);
    localBundle.putString("Cookie", localStringBuilder2.toString());
    localStringBuilder1.append("?");
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("appid=");
    paramAppRuntime.append(paramString);
    localStringBuilder1.append(paramAppRuntime.toString());
    paramAppRuntime = new HashMap();
    paramAppRuntime.put("BUNDLE", localBundle);
    paramAppRuntime.put("CONTEXT", paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("checkApiState params = ");
      paramContext.append(localBundle);
      QLog.i("TroopUtilsApiImpl", 2, paramContext.toString());
    }
    new HttpWebCgiAsyncTask2(localStringBuilder1.toString(), "GET", paramCallback, paramInt, paramBundle).a(paramAppRuntime);
  }
  
  public boolean checkIsShowCacheAppInfos(AppRuntime paramAppRuntime, String paramString, ArrayList<TroopAppInfo> paramArrayList)
  {
    paramAppRuntime = (ITroopAppService)paramAppRuntime.getRuntimeService(ITroopAppService.class, "all");
    paramAppRuntime = paramAppRuntime.getTroopCardAppInfosCache(paramAppRuntime.getTroopCardAppIdListCache(paramString));
    return (paramAppRuntime != null) && (paramAppRuntime.size() > 0);
  }
  
  public String constructParams(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      Object localObject = new JSONObject();
      Iterator localIterator = paramBundle1.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((JSONObject)localObject).put(str, wrap(paramBundle1.get(str)));
      }
      localJSONObject2.put("param", localObject);
      if (paramBundle2 != null)
      {
        paramBundle1 = paramBundle2.keySet().iterator();
        while (paramBundle1.hasNext())
        {
          localObject = (String)paramBundle1.next();
          localJSONObject2.put((String)localObject, wrap(paramBundle2.get((String)localObject)));
        }
      }
      localJSONObject1.put("key", localJSONObject2);
      paramBundle1 = localJSONObject1.toString();
      return paramBundle1;
    }
    catch (JSONException paramBundle1)
    {
      paramBundle1.printStackTrace();
    }
    return null;
  }
  
  public long convertQQFullVersion2Long(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    int k = 0;
    i = 0;
    int j;
    for (int m = 0; k < paramString.length(); m = j)
    {
      j = paramString.charAt(k);
      int n;
      if ((j >= 48) && (j <= 57))
      {
        arrayOfInt[i] = (arrayOfInt[i] * 10 + (j - 48));
        j = 1;
        n = i;
      }
      else
      {
        if ((m != 0) && ((i == 3) || (j == 46)))
        {
          j = i + 1;
          i = j;
          if (j >= arrayOfInt.length) {
            break;
          }
        }
        else
        {
          n = i;
          j = m;
          if (m == 0) {
            break label148;
          }
          arrayOfInt[i] = 0;
        }
        j = 0;
        n = i;
      }
      label148:
      k += 1;
      i = n;
    }
    long l = arrayOfInt[3] % 10000 + arrayOfInt[2] % 1000 * 10000 + arrayOfInt[1] % 1000 * 10000000 + arrayOfInt[0] % 1000 * 10000000000L;
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtilsApiImpl", 2, String.format("convertQQFullVersion2Long [%s, %s]", new Object[] { Long.valueOf(l), paramString }));
    }
    return l;
  }
  
  public EntryModel createEntryModel(TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {
      return null;
    }
    EntryModel localEntryModel = new EntryModel(1, Long.parseLong(paramTroopInfo.troopuin), paramTroopInfo.troopname, paramTroopInfo.isAdmin());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("groupid=");
    localStringBuilder.append(paramString);
    localEntryModel.reportData = localStringBuilder.toString();
    localEntryModel.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
    return localEntryModel;
  }
  
  public int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public String encrypt(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(getBytesUTF8(paramString));
      localObject = ((MessageDigest)localObject).digest();
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = localObject[i];
          localStringBuilder.append(hexDigit(k >>> 4));
          localStringBuilder.append(hexDigit(k));
          i += 1;
        }
        localObject = localStringBuilder.toString();
        return localObject;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("encrypt has exception: ");
        localStringBuilder.append(localNoSuchAlgorithmException.getMessage());
        QLog.e("TroopUtilsApiImpl", 2, localStringBuilder.toString());
      }
    }
    return paramString;
  }
  
  public byte[] getBytesUTF8(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public String getDateString(long paramLong)
  {
    if (paramLong > 0L) {
      return new SimpleDateFormat("yyyy年MM月dd日").format(Long.valueOf(paramLong * 1000L));
    }
    return "";
  }
  
  public String getDateString(Context paramContext, long paramLong)
  {
    if (paramLong > 0L)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getResources().getString(2131696128));
      localStringBuilder.append(localSimpleDateFormat.format(Long.valueOf(paramLong * 1000L)));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public int getExposureSource()
  {
    return this.mExposureSource;
  }
  
  public int getExposureSourceReportVal()
  {
    if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSource() == 1) {
      return 1;
    }
    return 2;
  }
  
  public String getLocalSkey(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public int getMaxWidthForNameInTroopMemberListActivity(int paramInt)
  {
    int i;
    if (FontSettingManager.getFontLevel() > 17.0F) {
      i = 1;
    } else {
      i = 0;
    }
    Resources localResources = BaseApplication.getContext().getResources();
    float f = 130.0F;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (i != 0) {
            f = 160.0F;
          } else {
            f = 180.0F;
          }
          return dp2px(f, localResources);
        }
        if (i != 0) {
          f = 50.0F;
        } else {
          f = 100.0F;
        }
        return dp2px(f, localResources);
      }
      if (i == 0) {
        f = 150.0F;
      }
      return dp2px(f, localResources);
    }
    if (i == 0) {
      f = 150.0F;
    }
    return dp2px(f, localResources);
  }
  
  public int getMessageHistoryCont(AppRuntime paramAppRuntime, String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramAppRuntime == null) {
      return 0;
    }
    paramAppRuntime = paramAppRuntime.getReadableDatabase();
    if (paramAppRuntime == null) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(" where msgtype ");
    localStringBuilder.append(UinTypeUtil.a());
    localStringBuilder.append(" and isValid=1 ");
    paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), paramAppRuntime, localStringBuilder.toString());
    if (paramString == null) {
      return 0;
    }
    paramAppRuntime = paramAppRuntime.rawQuery(paramString.toString(), null);
    if (paramAppRuntime == null) {
      return 0;
    }
    if ((paramAppRuntime.getCount() > 0) && (paramStringBuilder != null))
    {
      paramAppRuntime.moveToLast();
      paramInt = paramAppRuntime.getColumnIndex("shmsgseq");
      long l;
      try
      {
        if (!paramAppRuntime.isNull(paramInt)) {
          l = paramAppRuntime.getLong(paramInt);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TroopUtilsApiImpl", 1, "lastMessage error:", paramString);
        l = 0L;
      }
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
    }
    paramInt = paramAppRuntime.getCount();
    paramAppRuntime.close();
    return paramInt;
  }
  
  public int getSpecialCareRingRoamingSetting(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return 0;
    }
    return ((IRoamSettingService)paramAppRuntime.getRuntimeService(IRoamSettingService.class, "")).getSettingValue("message.ring.care", 0);
  }
  
  public int getTroopGeneralSettingRing(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return 0;
    }
    return ((IRoamSettingService)paramAppRuntime.getRuntimeService(IRoamSettingService.class, "")).getSettingValue("message.group.ring", 0);
  }
  
  public int getTroopGeneralSettingVibrate(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return 0;
    }
    return ((IRoamSettingService)paramAppRuntime.getRuntimeService(IRoamSettingService.class, "")).getSettingValue("message.group.vibrate", 0);
  }
  
  public boolean getTroopInfoEditRedShow(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppRuntime != null)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        MobileQQ localMobileQQ = paramAppRuntime.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_troop_info_edit_red_show_");
        localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append(paramString);
        paramAppRuntime = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
        paramString = new StringBuilder();
        paramString.append("red_tag_");
        paramString.append(paramInt);
        bool1 = paramAppRuntime.getBoolean(paramString.toString(), true);
      }
    }
    return bool1;
  }
  
  public int getTroopMask(AppRuntime paramAppRuntime, String paramString)
  {
    int j = 1;
    if (paramAppRuntime == null) {
      return 1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramAppRuntime = ((IRoamSettingService)paramAppRuntime.getRuntimeService(IRoamSettingService.class, "")).getTroopMsgFilterList(localArrayList, 1);
    int i = j;
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (Integer)paramAppRuntime.get(paramString);
      i = j;
      if (paramAppRuntime != null) {
        i = paramAppRuntime.intValue();
      }
    }
    return i;
  }
  
  public Intent getTroopMemberListActivityLaunchIntent(Context paramContext, String paramString, int paramInt)
  {
    return TroopMemberListActivity.getLaunchIntent(paramContext, paramString, paramInt);
  }
  
  public void handleJoinTroopFailed(Activity paramActivity, int paramInt)
  {
    QQToastNotifier localQQToastNotifier = new QQToastNotifier(paramActivity);
    int i = paramActivity.getResources().getDimensionPixelSize(2131299168);
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if ((paramInt != 8) && (paramInt != 11))
            {
              localQQToastNotifier.a(2131693506, i, 0, 1);
              return;
            }
            localQQToastNotifier.a(2131719931, i, 0, 1);
            return;
          }
          localQQToastNotifier.a(HardCodeUtil.a(2131715586), i, 0, 1);
          return;
        }
        localQQToastNotifier.a(HardCodeUtil.a(2131715591), i, 0, 1);
        return;
      }
      localQQToastNotifier.a(HardCodeUtil.a(2131715585), i, 0, 1);
      return;
    }
    localQQToastNotifier.a(HardCodeUtil.a(2131715596), i, 0, 1);
  }
  
  public TroopInfo initTroopInfo(AppRuntime paramAppRuntime, TroopInfoData paramTroopInfoData, Context paramContext)
  {
    TroopInfo localTroopInfo = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramTroopInfoData.troopUin);
    if (localTroopInfo != null)
    {
      paramTroopInfoData.isMember = true;
      paramTroopInfoData.updateForTroopChatSetting(localTroopInfo, paramContext.getResources(), paramAppRuntime.getCurrentAccountUin());
    }
    return localTroopInfo;
  }
  
  public TroopInfoData initTroopInfoData(Bundle paramBundle, Context paramContext)
  {
    TroopInfoData localTroopInfoData = new TroopInfoData();
    if (paramBundle == null) {
      return localTroopInfoData;
    }
    localTroopInfoData.troopUin = paramBundle.getString("troop_uin");
    localTroopInfoData.troopCode = paramBundle.getString("troop_code");
    try
    {
      long l = Long.parseLong(localTroopInfoData.troopUin);
      if (l > 0L)
      {
        localTroopInfoData.pa = paramBundle.getInt("troop_info_from");
        localTroopInfoData.nStatOption = paramBundle.getInt("troop_info_from_ex");
        localTroopInfoData.remark = paramBundle.getString("param_return_addr");
        localTroopInfoData.isMember = paramBundle.getBoolean("troop_info_is_member");
        localTroopInfoData.troopface = paramBundle.getShort("troop_info_faceid");
        localTroopInfoData.troopName = paramBundle.getString("troop_info_name");
        localTroopInfoData.newTroopName = localTroopInfoData.troopName;
        localTroopInfoData.troopowneruin = paramBundle.getString("troop_info_owner");
        localTroopInfoData.dwGroupClassExt = paramBundle.getLong("troop_info_classext");
        localTroopInfoData.troopLocation = paramBundle.getString("troop_info_loca");
        localTroopInfoData.mRichFingerMemo = paramBundle.getString("troop_info_fingermemo");
        if (!TextUtils.isEmpty(localTroopInfoData.mRichFingerMemo))
        {
          localTroopInfoData.mRichFingerMemo = HttpUtil.removeHtmlTags(localTroopInfoData.mRichFingerMemo);
          localTroopInfoData.mRichFingerMemo = HttpUtil.unEscape(localTroopInfoData.mRichFingerMemo);
        }
        localTroopInfoData.cGroupOption = ((short)paramBundle.getByte("troop_info_opt"));
        localTroopInfoData.mStrJoinQuestion = ((ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopQuestionFromSP(paramContext, localTroopInfoData.troopUin);
        localTroopInfoData.nTroopGrade = paramBundle.getInt("TROOP_INFO_TROOP_GRADE");
        localTroopInfoData.mStrJoinAnswer = ((ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopAnswerFromSP(paramContext, localTroopInfoData.troopUin);
        localTroopInfoData.dwGroupFlagExt = paramBundle.getLong("TROOP_INFO_FLAG_EXT");
        localTroopInfoData.dwAuthGroupType = paramBundle.getLong("TROOP_INFO_AUTH_TYPE");
        localTroopInfoData.troopTags = TroopInfo.getTags(paramBundle.getString("TROOP_INFO_TAGS_EXT"));
      }
      return localTroopInfoData;
    }
    catch (NumberFormatException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return localTroopInfoData;
  }
  
  public boolean isEmptyRedPointSP(String paramString)
  {
    String str = SharePreferenceUtils.a(MobileQQ.getContext(), paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtilsApiImpl", 2, String.format("isEmptyRedPointSP [%s, %s]", new Object[] { paramString, str }));
    }
    return TextUtils.isEmpty(str);
  }
  
  public boolean isShowKingTeamRedPoint(boolean paramBoolean, String paramString)
  {
    return (paramBoolean) && (isEmptyRedPointSP(paramString));
  }
  
  public boolean isShowRedPoint(boolean paramBoolean, String paramString)
  {
    boolean bool3 = false;
    boolean bool1;
    if (paramBoolean) {
      bool1 = isEmptyRedPointSP(paramString);
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopUtilsApiImpl", 2, String.format("isShowRedPoint [%s, %s, %s]", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) }));
    }
    boolean bool2 = bool3;
    if (paramBoolean)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean isTroopAdmin(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString1);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.isTroopAdmin(paramString2);
  }
  
  public boolean isTroopEditInfoRedExist(AppRuntime paramAppRuntime, String paramString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    if ((paramAppRuntime != null) && (paramString != null) && (paramArrayOfInt != null) && (paramArrayOfBoolean != null) && (paramArrayOfInt.length == paramArrayOfBoolean.length))
    {
      MobileQQ localMobileQQ = paramAppRuntime.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_troop_info_edit_red_show_");
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      paramAppRuntime = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        boolean bool;
        if (paramArrayOfBoolean[i] != 0)
        {
          paramString = new StringBuilder();
          paramString.append("red_tag_");
          paramString.append(paramArrayOfInt[i]);
          bool = paramAppRuntime.getBoolean(paramString.toString(), true);
        }
        else
        {
          bool = false;
        }
        if (bool) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isTroopMark(AppRuntime paramAppRuntime, Message paramMessage)
  {
    return isTroopMark(paramAppRuntime, paramMessage.frienduin, paramMessage.istroop);
  }
  
  public boolean isTroopMark(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = getTroopMask(paramAppRuntime, paramString);
      if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isTroopTagNeedRedDot(long paramLong)
  {
    return (paramLong != 10009L) && (paramLong != 10010L) && (paramLong != 10011L) && (paramLong != 32L);
  }
  
  public boolean isUpdateBeforeSomeVersion(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      Object localObject = paramContext.getSharedPreferences("UserGuide", 0);
      paramContext = ((SharedPreferences)localObject).getString("qq_version_pre", null);
      localObject = ((SharedPreferences)localObject).getString("qq_version_full_pre", null);
      if (TextUtils.isEmpty(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopUtilsApiImpl", 2, String.format("isUpdateBeforeSomeVersion pre[%s, %s]", new Object[] { paramContext, localObject }));
        }
        return false;
      }
      if (TextUtils.equals("5295", paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopUtilsApiImpl", 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", new Object[] { "5295", paramContext }));
        }
        return false;
      }
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = "8.0.0";
      }
      localObject = AppSetting.a();
      if (TextUtils.equals(paramContext, (CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopUtilsApiImpl", 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", new Object[] { localObject, paramContext }));
        }
        return false;
      }
      long l1 = convertQQFullVersion2Long(paramString);
      long l2 = convertQQFullVersion2Long(paramContext);
      boolean bool;
      if (Math.abs(l2) < Math.abs(l1)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopUtilsApiImpl", 2, String.format("isUpdateBeforeSomeVersion some: %s, pre: %s, ret: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) }));
      }
      return bool;
    }
    return false;
  }
  
  public void joinGroupOneStep(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    if ((paramAppRuntime != null) && (paramContext != null))
    {
      if (paramIntent == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi");
      String str = paramAppRuntime.getCurrentAccountUin();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("o");
      if (str.length() < 10)
      {
        int i = 0;
        while (i < 10 - str.length())
        {
          ((StringBuilder)localObject1).append("0");
          i += 1;
        }
        ((StringBuilder)localObject1).append(str);
      }
      else
      {
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(str);
      }
      Object localObject2 = (TicketManager)paramAppRuntime.getManager(2);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("uin=");
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append("; skey=");
      ((StringBuilder)localObject3).append(((TicketManager)localObject2).getSkey(str));
      localBundle.putString("Cookie", ((StringBuilder)localObject3).toString());
      localBundle.putString("Host", "info.gamecenter.qq.com");
      localObject3 = paramIntent.getStringExtra("appid");
      boolean bool = "true".equals(paramIntent.getStringExtra("is_from_game"));
      str = "";
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject3)))
      {
        ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(paramAppRuntime, paramContext, (String)localObject3, paramCallback, 0, null);
        str = paramIntent.getStringExtra("guild_id");
        paramAppRuntime = paramIntent.getStringExtra("zone_id");
        localObject2 = paramIntent.getStringExtra("role_id");
        localObject1 = paramIntent.getStringExtra("gc");
        paramIntent = (Intent)localObject2;
      }
      else
      {
        localObject2 = "";
        paramAppRuntime = (AppRuntime)localObject2;
        localObject1 = paramAppRuntime;
        paramIntent = paramAppRuntime;
        paramAppRuntime = (AppRuntime)localObject2;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("appid", (String)localObject3);
      ((Bundle)localObject2).putString("guild_id", str);
      ((Bundle)localObject2).putString("zone_id", paramAppRuntime);
      ((Bundle)localObject2).putString("gc", (String)localObject1);
      ((Bundle)localObject2).putString("platid", "2");
      ((Bundle)localObject2).putString("roleid", paramIntent);
      paramAppRuntime = new Bundle();
      paramAppRuntime.putString("module", "gc_bind_group_svr");
      paramAppRuntime.putString("method", "join_group");
      paramAppRuntime = constructParams((Bundle)localObject2, paramAppRuntime);
      localBundle.putString("param", paramAppRuntime);
      paramIntent = new StringBuilder();
      paramIntent.append(paramAppRuntime);
      paramIntent.append("ea779693bfa42c986ad85cda9bdfce45");
      localBundle.putString("signature", encrypt(paramIntent.toString()).toUpperCase());
      paramAppRuntime = new HashMap();
      paramAppRuntime.put("BUNDLE", localBundle);
      paramAppRuntime.put("CONTEXT", paramContext);
      new HttpWebCgiAsyncTask2(localStringBuilder.toString(), "GET", paramCallback, 1, null).a(paramAppRuntime);
    }
  }
  
  public void notifyUser(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    new QQToastNotifier(paramContext).a(paramInt2, paramInt1, 0, paramInt3);
  }
  
  public void preloadWebProcess(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (IWebProcessManagerService)paramAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
    if (paramAppRuntime == null) {
      return;
    }
    if (paramAppRuntime.isNeedPreloadWebProcess())
    {
      paramAppRuntime.startWebProcess(-1, null);
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtilsApiImpl", 2, "start preloadWebProcess");
      }
    }
  }
  
  public int readPictureDegree(String paramString)
  {
    int i = JpegExifReader.readOrientation(paramString);
    if (i != 3)
    {
      if (i != 6)
      {
        if (i != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  public String replaceSpecialTag(String paramString, long paramLong, int paramInt, TroopInfoData paramTroopInfoData, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    boolean bool = paramTroopInfoData.bOwner;
    String str2 = "1";
    String str1;
    if (bool) {
      str1 = "0";
    } else if (paramTroopInfoData.bAdmin) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    paramAppRuntime = paramString.replace("$GCODE$", paramTroopInfoData.troopUin).replace("$CLIENTVER$", "android8.7.0").replace("$UIN$", paramAppRuntime.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str1);
    if (paramBoolean) {
      paramString = str2;
    } else {
      paramString = "2";
    }
    paramAppRuntime = paramAppRuntime.replace("$ENTERSOURCE$", paramString).replace("$GUIN$", paramTroopInfoData.troopUin).replace("$UNREADNUM$", String.valueOf(paramInt));
    paramString = paramAppRuntime;
    if (!TextUtils.isEmpty(paramTroopInfoData.newTroopName)) {
      paramString = paramAppRuntime.replace("$GNAME$", paramTroopInfoData.newTroopName);
    }
    return paramString;
  }
  
  public void reportQunMiniApp(oidb_0xe83.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    if (paramAppInfo == null) {
      return;
    }
    Object localObject = new SimpleMiniAppConfig.SimpleMiniAppInfo();
    ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject).appId = String.valueOf(paramAppInfo.appid.get());
    ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject).name = paramAppInfo.name.get();
    paramAppInfo = new SimpleMiniAppConfig((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject);
    paramAppInfo.launchParam.scene = 2010;
    paramAppInfo.config.via = "2010_3";
    localObject = paramAppInfo.launchParam;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("groupid=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&category_tag=");
    ((SimpleMiniAppConfig.SimpleLaunchParam)localObject).reportData = localStringBuilder.toString();
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async(paramAppInfo, "page_view", paramString1, null, null);
  }
  
  public void requestTroopPrivilege(Context paramContext, AppInterface paramAppInterface, String paramString, structmsg.StructMsg paramStructMsg, TroopNotificationUtils.TroopPrivilegeCallback paramTroopPrivilegeCallback)
  {
    if ((paramAppInterface != null) && (paramTroopPrivilegeCallback != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      TroopNotificationUtils.a(paramString, paramStructMsg);
      Object localObject2 = new oidb_0x88d.GroupInfo();
      ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
      Object localObject1 = new oidb_0x88d.ReqGroupInfo();
      ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
      ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
      localObject2 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(paramAppInterface.getAppid());
      ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(14);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
      ProtoUtils.a(paramAppInterface, new TroopUtilsApiImpl.1(this, paramString, paramContext, paramStructMsg, paramTroopPrivilegeCallback), ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray(), "OidbSvc.0x88d_0");
    }
  }
  
  public String saveMemberUinStringToDB(AppRuntime paramAppRuntime, boolean paramBoolean, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    if (paramTroopInfo != null)
    {
      paramArrayList = TroopInfo.convertMemberUinListToString(paramArrayList, 5);
      if (!TextUtils.equals(paramTroopInfo.memberListToShow, paramArrayList))
      {
        updateTroopInfoToDB(paramTroopInfo, paramAppRuntime, paramBoolean);
        return paramArrayList;
      }
    }
    return null;
  }
  
  public void setExposureSource(int paramInt)
  {
    this.mExposureSource = paramInt;
  }
  
  public void setRedPointSP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!isEmptyRedPointSP(paramString)) {
      return;
    }
    SharePreferenceUtils.a(MobileQQ.getContext(), paramString, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtilsApiImpl", 2, String.format("setRedPointSP [%s, %s]", new Object[] { paramString, paramString }));
    }
  }
  
  public void setSpecialCareRingRoamingSetting(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    ((IRoamSettingService)paramAppRuntime.getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue("message.ring.care", Integer.valueOf(paramInt));
  }
  
  public void setTroopGeneralSettingRing(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTroopGeneralSettingRing :");
      localStringBuilder.append(paramInt);
      QLog.d("SoundSetting", 2, localStringBuilder.toString());
    }
    if (paramAppRuntime == null) {
      return;
    }
    ((IRoamSettingService)paramAppRuntime.getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue("message.group.ring", Integer.valueOf(paramInt));
  }
  
  public void setTroopGeneralSettingVibrate(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTroopGeneralSettingVibrate :");
      localStringBuilder.append(paramInt);
      QLog.d("SoundSetting", 2, localStringBuilder.toString());
    }
    if (paramAppRuntime == null) {
      return;
    }
    ((IRoamSettingService)paramAppRuntime.getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue("message.group.vibrate", Integer.valueOf(paramInt));
  }
  
  public void setTroopInfoEditRedShow(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTroopInfoEditRedShow ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("TroopUtilsApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (paramAppRuntime != null)
    {
      localObject = paramAppRuntime.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_troop_info_edit_red_show_");
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      paramAppRuntime = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      paramString = new StringBuilder();
      paramString.append("red_tag_");
      paramString.append(paramInt);
      paramAppRuntime.putBoolean(paramString.toString(), paramBoolean).commit();
    }
  }
  
  public long stringToLong(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      label10:
      break label10;
    }
    return 0L;
  }
  
  public JSONArray toJSONArray(Object paramObject)
  {
    Object localObject = new JSONArray();
    if (paramObject.getClass().isArray())
    {
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        ((JSONArray)localObject).put(wrap(Array.get(paramObject, i)));
        i += 1;
      }
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Not a primitive array: ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new JSONException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void updateRedPoint(boolean paramBoolean, TextView paramTextView)
  {
    if (paramBoolean)
    {
      paramTextView.setVisibility(0);
      paramTextView.setBackgroundResource(0);
      paramTextView.setCompoundDrawablePadding(Utils.a(10.0F, MobileQQ.getContext().getResources()));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841440, 0);
      return;
    }
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void updateRedPoint(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, TextView paramTextView)
  {
    if ((!isShowRedPoint(paramBoolean1, paramString)) && (!paramBoolean2) && (!paramBoolean3)) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isShowRedPoint:");
      paramString.append(paramBoolean1);
      QLog.d("TroopUtilsApiImpl", 2, paramString.toString());
    }
    updateRedPoint(paramBoolean1, paramTextView);
  }
  
  public void updateTroopInfoToDB(TroopInfo paramTroopInfo, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((paramTroopInfo != null) && (paramBoolean)) {
      ThreadManager.post(new TroopUtilsApiImpl.4(this, paramAppRuntime, paramTroopInfo), 5, null, false);
    }
  }
  
  public Object wrap(Object paramObject)
  {
    if (paramObject == null) {
      return JSONObject.NULL;
    }
    Object localObject = paramObject;
    if (!(paramObject instanceof JSONArray))
    {
      if ((paramObject instanceof JSONObject)) {
        return paramObject;
      }
      if (paramObject.equals(JSONObject.NULL)) {
        return paramObject;
      }
    }
    try
    {
      if ((paramObject instanceof Collection)) {
        return new JSONArray((Collection)paramObject);
      }
      if (paramObject.getClass().isArray()) {
        return toJSONArray(paramObject);
      }
      if ((paramObject instanceof Map)) {
        return new JSONObject((Map)paramObject);
      }
      localObject = paramObject;
      if (!(paramObject instanceof Boolean))
      {
        localObject = paramObject;
        if (!(paramObject instanceof Byte))
        {
          localObject = paramObject;
          if (!(paramObject instanceof Character))
          {
            localObject = paramObject;
            if (!(paramObject instanceof Double))
            {
              localObject = paramObject;
              if (!(paramObject instanceof Float))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Integer))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Long))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Short))
                    {
                      if ((paramObject instanceof String)) {
                        return paramObject;
                      }
                      if (!paramObject.getClass().getPackage().getName().startsWith("java.")) {
                        break label199;
                      }
                      localObject = paramObject.toString();
                    }
                  }
                }
              }
            }
          }
        }
      }
      return localObject;
    }
    catch (Exception paramObject)
    {
      label199:
      break label199;
    }
    localObject = null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.TroopUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */