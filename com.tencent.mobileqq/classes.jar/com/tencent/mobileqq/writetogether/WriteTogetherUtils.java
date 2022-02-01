package com.tencent.mobileqq.writetogether;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.utils.EvilReportUtil.EvilReportParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.easysync2.AText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.writetogether.data.DocMetaData;
import com.tencent.mobileqq.writetogether.data.EditUserHistory;
import com.tencent.mobileqq.writetogether.data.OpenDocParam;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.Atext;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.EditUinInfo;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.RspGetDocContent;

public class WriteTogetherUtils
{
  public static EvilReportUtil.EvilReportParams a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new EvilReportUtil.EvilReportParams();
    paramString1.a = "android";
    paramString1.b = AppSetting.h();
    paramString1.c = "1";
    paramString1.e = "KQQ";
    paramString1.f = "2400002";
    paramString1.h = "25043";
    paramString1.g = "write_togethe";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_id:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|doc_id:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|base_version:");
    localStringBuilder.append(paramInt);
    paramString1.j = localStringBuilder.toString();
    paramString1.s = paramString2;
    paramString1.d = paramString4;
    return paramString1;
  }
  
  public static OpenDocParam a(oidb_cmd0xe89.RspGetDocContent paramRspGetDocContent)
  {
    OpenDocParam localOpenDocParam = new OpenDocParam();
    localOpenDocParam.f = paramRspGetDocContent.bytes_global_padid.get().toStringUtf8();
    localOpenDocParam.g = paramRspGetDocContent.uint32_doc_type.get();
    localOpenDocParam.h = paramRspGetDocContent.bytes_title.get().toStringUtf8();
    oidb_cmd0xe89.Atext localAtext = (oidb_cmd0xe89.Atext)paramRspGetDocContent.msg_atext.get(0);
    localOpenDocParam.d = localAtext.bytes_name.get().toStringUtf8();
    localOpenDocParam.e = localAtext.bytes_subid.get().toStringUtf8();
    localOpenDocParam.a = localAtext.bytes_text.get().toStringUtf8();
    localOpenDocParam.b = localAtext.bytes_attribs.get().toStringUtf8();
    localOpenDocParam.c = localAtext.bytes_apool.get().toStringUtf8();
    localOpenDocParam.i = paramRspGetDocContent.bytes_subid.get().toStringUtf8();
    localOpenDocParam.j = paramRspGetDocContent.uint32_baseRev.get();
    localOpenDocParam.k = paramRspGetDocContent.uint32_baseLen.get();
    localOpenDocParam.l = paramRspGetDocContent.bytes_meta.get().toStringUtf8();
    localOpenDocParam.m = paramRspGetDocContent.uint32_sheetPosLen.get();
    localOpenDocParam.n = paramRspGetDocContent.bytes_owner_appid.get().toStringUtf8();
    localOpenDocParam.o = paramRspGetDocContent.uint64_baseLen.get();
    localOpenDocParam.p = paramRspGetDocContent.uint64_sheetPosLen.get();
    localOpenDocParam.q = a(paramRspGetDocContent.rpt_edit_uin_list.get());
    localOpenDocParam.r = paramRspGetDocContent.uint64_owner_uin.get();
    int i;
    if (paramRspGetDocContent.uint32_max_len.has()) {
      i = paramRspGetDocContent.uint32_max_len.get();
    } else {
      i = 10000;
    }
    localOpenDocParam.s = i;
    if (localOpenDocParam.s <= 0) {
      localOpenDocParam.s = 10000;
    }
    return localOpenDocParam;
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return "";
    }
    return new QQText(paramCharSequence, 5).toPlainText(false);
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 7) {
        return paramString;
      }
      if (!paramString.startsWith("p."))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WriteTogetherUtils", 2, "userId is not start with p.");
        }
        return paramString;
      }
      str = paramString.substring(2);
    }
    return str;
  }
  
  public static String a(String paramString, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString, new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1) });
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString1, new Object[] { paramString2, Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1) });
  }
  
  private static List<EditUserHistory> a(List<oidb_cmd0xe89.EditUinInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0xe89.EditUinInfo localEditUinInfo = (oidb_cmd0xe89.EditUinInfo)paramList.next();
      localArrayList.add(new EditUserHistory(String.valueOf(localEditUinInfo.uint.get()), localEditUinInfo.last_edit_ts.get(), localEditUinInfo.nick_name.get().toStringUtf8()));
    }
    return localArrayList;
  }
  
  public static void a(int paramInt)
  {
    d().edit().putInt(WTConstants.c, paramInt).apply();
  }
  
  public static void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramActivity = DialogUtil.a(paramActivity, HardCodeUtil.a(2131918132), 2131918093, 2131918138, paramOnClickListener2, paramOnClickListener1);
    if ((paramActivity != null) && (!paramActivity.isShowing())) {
      paramActivity.show();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, WriteTogetherUtils.OnDialogConfirmButtonClickListener paramOnDialogConfirmButtonClickListener)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624611);
    paramContext.dismissMessage();
    ((RelativeLayout.LayoutParams)paramContext.getTitleTextView().getLayoutParams()).bottomMargin = ViewUtils.dip2px(26.0F);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setTitle(paramString1);
    paramContext.getTitleTextView().setSingleLine(false);
    paramContext.getTitleTextView().setMaxLines(2);
    paramContext.setNegativeButton(paramString2, new WriteTogetherUtils.2(paramContext, paramOnDialogConfirmButtonClickListener));
    if (paramContext.isShowing()) {
      paramContext.dismiss();
    }
    paramContext.show();
    paramContext = paramContext.getTitleTextView();
    paramContext.setClickable(true);
    paramContext.setFocusable(true);
    paramContext.setFocusableInTouchMode(true);
    AccessibilityUtil.a(paramContext, true);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, WriteTogetherUtils.OnDialogConfirmButtonClickListener paramOnDialogConfirmButtonClickListener)
  {
    Resources localResources = paramQBaseActivity.getResources();
    paramQBaseActivity = DialogUtil.a(paramQBaseActivity, localResources.getString(2131918153), localResources.getString(2131918141), localResources.getString(2131918145), new WriteTogetherUtils.1(paramOnDialogConfirmButtonClickListener));
    paramQBaseActivity.setCancelable(false);
    paramQBaseActivity.show();
  }
  
  public static boolean a()
  {
    return d().getBoolean(WTConstants.b, true);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static boolean a(AText paramAText)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAText != null)
    {
      if (TextUtils.isEmpty(paramAText.a)) {
        return false;
      }
      bool1 = bool2;
      if (paramAText.a.length() > b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    TroopInfoHandler localTroopInfoHandler = (TroopInfoHandler)((AppInterface)paramAppRuntime).getBusinessHandler(TroopInfoHandler.class.getName());
    boolean bool2 = false;
    localTroopInfoHandler.a(paramString, false);
    paramAppRuntime = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
    boolean bool1 = bool2;
    if (paramAppRuntime != null)
    {
      bool1 = bool2;
      if ((paramAppRuntime.dwGroupFlagExt3 & 0x40000000) == 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b()
  {
    int j = d().getInt(WTConstants.c, 0);
    int i = j;
    if (j == 0) {
      i = 10000;
    }
    return i;
  }
  
  public static int b(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    if (paramAppRuntime == null) {
      return 0;
    }
    return (int)paramAppRuntime.dwGroupClassExt;
  }
  
  public static DocMetaData b(String paramString)
  {
    DocMetaData localDocMetaData = new DocMetaData();
    try
    {
      paramString = new JSONObject(paramString);
      localDocMetaData.a = paramString.optString("creatorId");
      localDocMetaData.b = paramString.optLong("mtime");
      localDocMetaData.c = paramString.optString("padId");
      return localDocMetaData;
    }
    catch (Exception paramString)
    {
      QLog.e("WriteTogetherUtils", 4, "[parseMetaDataFromJson] parse json error", paramString);
    }
    return localDocMetaData;
  }
  
  public static String b(String paramString, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString, new Object[] { Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
  }
  
  public static String b(String paramString1, String paramString2, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString1, new Object[] { paramString2, Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8: 
      return 7;
    case 7: 
      return 5;
    case 6: 
      return 8;
    case 5: 
      return 4;
    case 4: 
      return 6;
    case 3: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  public static String c(String paramString, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return String.format(paramString, new Object[] { Integer.valueOf(localCalendar.get(11)), Integer.valueOf(localCalendar.get(12)) });
  }
  
  private static SharedPreferences d()
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(WTConstants.a);
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    return SharedPreferencesProxyManager.getInstance().getProxy(str, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.WriteTogetherUtils
 * JD-Core Version:    0.7.0.1
 */