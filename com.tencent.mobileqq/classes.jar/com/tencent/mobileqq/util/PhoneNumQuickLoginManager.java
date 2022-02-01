package com.tencent.mobileqq.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.beacon.event.UserAction;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.TouchControllerFrameLayout;
import com.tencent.mobileqq.app.GatewayLoginNewDevHelper;
import com.tencent.mobileqq.app.identity.LocalPhoneModule;
import com.tencent.mobileqq.app.identity.LocalPhoneModule.MaskPhoneCallback;
import com.tencent.mobileqq.fragment.LoginAccountFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.util;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneLogin;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspBodySelfPhone;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneLogin;
import tencent.im.login.GatewayVerify.RspCmd18;
import tencent.im.login.GatewayVerify.RspPhoneSmsExtendLogin;
import tencent.im.login.GatewayVerify.UinInfo;

public class PhoneNumQuickLoginManager
{
  public static DownloadParams.DecodeHandler a;
  private static LocalPhoneModule a;
  
  static
  {
    jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new PhoneNumQuickLoginManager.18();
  }
  
  private static Dialog a(Context paramContext, int paramInt)
  {
    Dialog localDialog = CustomDialogFactory.a(paramContext, 2131755235);
    TouchControllerFrameLayout localTouchControllerFrameLayout = (TouchControllerFrameLayout)LayoutInflater.from(localDialog.getContext()).inflate(2131561314, null);
    localTouchControllerFrameLayout.setOnClickListener(new PhoneNumQuickLoginManager.2(paramContext, localDialog));
    LayoutInflater.from(localDialog.getContext()).inflate(paramInt, localTouchControllerFrameLayout, true);
    localTouchControllerFrameLayout.getChildAt(0).setOnClickListener(new PhoneNumQuickLoginManager.3());
    localTouchControllerFrameLayout.setHeadView(localTouchControllerFrameLayout.findViewById(2131372928));
    localTouchControllerFrameLayout.setCustomTouchListener(new PhoneNumQuickLoginManager.4(localDialog));
    localTouchControllerFrameLayout.findViewById(2131372935).setOnClickListener(new PhoneNumQuickLoginManager.5(paramContext, localDialog));
    paramContext = localTouchControllerFrameLayout.findViewById(2131370701);
    paramContext.getViewTreeObserver().addOnGlobalLayoutListener(new PhoneNumQuickLoginManager.6(paramContext, localTouchControllerFrameLayout, localDialog));
    localDialog.setContentView(localTouchControllerFrameLayout);
    return localDialog;
  }
  
  private static CharSequence a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24) {}
    SpannableStringBuilder localSpannableStringBuilder;
    URLSpan[] arrayOfURLSpan;
    int k;
    int m;
    int n;
    for (paramString = Html.fromHtml(paramString, 0);; paramString = Html.fromHtml(paramString))
    {
      localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, paramString.length(), URLSpan.class);
      j = arrayOfURLSpan.length;
      i = 0;
      while (i < j)
      {
        URLSpan localURLSpan = arrayOfURLSpan[i];
        k = localSpannableStringBuilder.getSpanStart(localURLSpan);
        m = localSpannableStringBuilder.getSpanEnd(localURLSpan);
        n = localSpannableStringBuilder.getSpanFlags(localURLSpan);
        PhoneNumQuickLoginManager.17 local17 = new PhoneNumQuickLoginManager.17(localURLSpan.getURL());
        localSpannableStringBuilder.removeSpan(localURLSpan);
        localSpannableStringBuilder.setSpan(local17, k, m, n);
        i += 1;
      }
    }
    paramString = (ForegroundColorSpan[])localSpannableStringBuilder.getSpans(0, paramString.length(), ForegroundColorSpan.class);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfURLSpan = paramString[i];
      k = localSpannableStringBuilder.getSpanStart(arrayOfURLSpan);
      m = localSpannableStringBuilder.getSpanEnd(arrayOfURLSpan);
      n = localSpannableStringBuilder.getSpanFlags(arrayOfURLSpan);
      localSpannableStringBuilder.removeSpan(arrayOfURLSpan);
      localSpannableStringBuilder.setSpan(arrayOfURLSpan, k, m, n);
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime);
    return jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule.a();
  }
  
  public static List<PhoneNumQuickLoginManager.AccountInfo> a(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(Integer.valueOf(1347));
    if (paramWUserSigInfo == null)
    {
      QLog.e("PhoneNumQuickLoginManager", 1, "getUinInfo: 0x543 tlv is null");
      return null;
    }
    paramWUserSigInfo = paramWUserSigInfo.get_data();
    Object localObject = new GatewayVerify.RspBody();
    ((GatewayVerify.RspBody)localObject).mergeFrom(paramWUserSigInfo);
    if (paramInt == 1) {}
    for (paramWUserSigInfo = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_phone_login.rpt_bind_uin_info.get();; paramWUserSigInfo = ((GatewayVerify.RspBody)localObject).msg_rsp_cmd_18.msg_rsp_phone_sms_extend_login.rpt_bind_uin_info.get())
    {
      localObject = new ArrayList();
      paramWUserSigInfo = paramWUserSigInfo.iterator();
      while (paramWUserSigInfo.hasNext())
      {
        GatewayVerify.UinInfo localUinInfo = (GatewayVerify.UinInfo)paramWUserSigInfo.next();
        String str1 = localUinInfo.str_mask_uin.get();
        byte[] arrayOfByte = localUinInfo.bytes_encrypt_uin.get().toByteArray();
        String str2 = localUinInfo.str_image_url.get();
        ((List)localObject).add(new PhoneNumQuickLoginManager.AccountInfo(localUinInfo.str_nick.get(), str1, arrayOfByte, str2));
      }
      if (paramInt != 2) {
        break;
      }
    }
    QLog.e("PhoneNumQuickLoginManager", 1, "getUinInfo: scene type is error!");
    return null;
    return localObject;
  }
  
  private static AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static void a(int paramInt)
  {
    a("0X800B8CA", paramInt, "");
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, PhoneNumQuickLoginManager.AccountInfo paramAccountInfo, Bundle paramBundle, byte[] paramArrayOfByte, int paramInt)
  {
    LoginAccountFragment.a(paramActivity, paramString1, paramString2, paramAccountInfo, paramBundle, paramArrayOfByte, paramInt);
  }
  
  private static void a(Dialog paramDialog)
  {
    paramDialog.show();
    ((LinearLayout)paramDialog.findViewById(2131370701)).startAnimation(AnimationUtils.loadAnimation(paramDialog.getContext(), 2130771999));
  }
  
  private static void a(Dialog paramDialog, View.OnClickListener paramOnClickListener, Map<String, Object> paramMap)
  {
    Object localObject = (String)paramMap.get("key_phone_num");
    String str3 = (String)paramMap.get("key_self_btn_text");
    String str2 = (String)paramMap.get("key_other_btn_text");
    String str1 = (String)paramMap.get("key_user_agreement");
    Boolean localBoolean = (Boolean)paramMap.get("key_from_user_click");
    View localView = paramDialog.findViewById(2131363667);
    ((TextView)localView.findViewById(2131372939)).setText((CharSequence)localObject);
    localObject = (Button)localView.findViewById(2131372938);
    ((Button)localObject).setText(str3);
    ((Button)localObject).setOnClickListener(new PhoneNumQuickLoginManager.7(paramOnClickListener, paramDialog));
    paramOnClickListener = (Button)localView.findViewById(2131372937);
    paramOnClickListener.setText(str2);
    paramOnClickListener.setOnClickListener(new PhoneNumQuickLoginManager.8(paramDialog, paramMap));
    paramDialog.setOnDismissListener(new PhoneNumQuickLoginManager.9(localBoolean));
    if (TextUtils.isEmpty(str1)) {
      QLog.d("PhoneNumQuickLoginManager", 1, "setQuickLoginView agreement is null");
    }
    do
    {
      return;
      paramOnClickListener = (TextView)localView.findViewById(2131372936);
      paramOnClickListener.setMovementMethod(LinkMovementMethod.getInstance());
      paramDialog = str1;
      if (str1.contains("\\n"))
      {
        paramDialog = str1.split("\\\\n");
        int i = 0;
        while (i < paramDialog.length - 1)
        {
          paramOnClickListener.append(paramDialog[i]);
          paramOnClickListener.append("\n");
          i += 1;
        }
        paramDialog = paramDialog[(paramDialog.length - 1)];
      }
      paramDialog = a(paramDialog);
    } while (paramDialog == null);
    paramOnClickListener.append(paramDialog);
  }
  
  private static void a(Dialog paramDialog, Map<String, Object> paramMap)
  {
    Object localObject = (String)paramMap.get("key_dialog_title");
    String str = (String)paramMap.get("key_dialog_msg");
    paramMap = (String)paramMap.get("key_dialog_ok_btn_text");
    View localView = paramDialog.findViewById(2131363667);
    ((TextView)localView.findViewById(2131363861)).setText((CharSequence)localObject);
    ((TextView)localView.findViewById(2131363859)).setText(str);
    localObject = (Button)localView.findViewById(2131363860);
    ((Button)localObject).setText(paramMap);
    ((Button)localObject).setOnClickListener(new PhoneNumQuickLoginManager.15(paramDialog));
  }
  
  private static void a(Dialog paramDialog, Map<String, Object> paramMap, PhoneNumQuickLoginManager.OnUinClickListener paramOnUinClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Object localObject = (String)paramMap.get("key_dialog_title");
    String str = (String)paramMap.get("key_dialog_msg");
    List localList = Collections.unmodifiableList((List)paramMap.get("key_unbind_account_list"));
    View localView = paramDialog.findViewById(2131363667);
    ((TextView)localView.findViewById(2131363671)).setText((CharSequence)localObject);
    ((TextView)localView.findViewById(2131363669)).setText(str);
    localObject = (ListView)localView.findViewById(2131363670);
    ((ListView)localObject).setAdapter(new PhoneNumQuickLoginManager.BindPhoneNumAdapter(localList, null));
    ((ListView)localObject).setOnItemClickListener(new PhoneNumQuickLoginManager.16(paramOnUinClickListener, localList, paramDialog, paramMap));
    paramDialog.setOnDismissListener(paramOnDismissListener);
    if (localList.size() > 7)
    {
      paramMap = (LinearLayout.LayoutParams)((ListView)localObject).getLayoutParams();
      paramMap.height = Utils.a(540.0F, paramDialog.getContext().getResources());
      int j = paramDialog.getContext().getResources().getDisplayMetrics().heightPixels * 7 / 10;
      int i = j;
      if (paramMap.height < j) {
        i = paramMap.height;
      }
      paramMap.height = i;
      ((ListView)localObject).setLayoutParams(paramMap);
    }
  }
  
  public static void a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_dialog_msg", paramContext.getString(2131699082));
    localHashMap.put("key_dialog_ok_btn_text", paramContext.getString(2131699081));
    localHashMap.put("key_dialog_no_btn_text", paramContext.getString(2131706373));
    b(paramContext, localHashMap);
  }
  
  public static void a(Context paramContext, View.OnClickListener paramOnClickListener, Map<String, Object> paramMap)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, new Object[] { "showQuickLoginDialog context=", paramContext, ", params=", paramMap });
    if ((paramContext == null) || (paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    paramContext = a(paramContext, 2131561435);
    a(paramContext, paramOnClickListener, paramMap);
    a(paramContext);
  }
  
  public static void a(Context paramContext, Map<String, Object> paramMap)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "setQuickLoginView other btn click");
    Intent localIntent = new Intent(paramContext, LoginPhoneNumActivity.class);
    localIntent.putExtra("entrance", LoginView.class.getName());
    localIntent.putExtra("title", paramContext.getResources().getString(2131693891));
    paramMap = paramMap.get("login_from_account_change");
    if (((paramMap instanceof Boolean)) && (((Boolean)paramMap).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("login_from_account_change", bool);
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  private static void a(Context paramContext, Map<String, Object> paramMap, PhoneNumQuickLoginManager.OnUinClickListener paramOnUinClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, new Object[] { "showSelectAccountDialog context=", paramContext, ", params=", paramMap });
    if ((paramContext == null) || (paramMap == null) || (paramMap.isEmpty()))
    {
      QLog.e("PhoneNumQuickLoginManager", 1, "showSelectAccountDialog param invalid");
      return;
    }
    paramContext = a(paramContext, 2131561316);
    a(paramContext, paramMap, paramOnUinClickListener, paramOnDismissListener);
    a(paramContext);
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime, String paramString, Map<String, Object> paramMap, WtloginObserver paramWtloginObserver)
  {
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null)
    {
      QLog.e("PhoneNumQuickLoginManager", 1, "getPhoneNumSuccess, manager is null");
      a(paramContext, paramMap);
      return;
    }
    QLog.d("PhoneNumQuickLoginManager", 1, "loginByPhoneToken get phoneToken success");
    if (QLog.isColorLevel()) {
      QLog.d("PhoneNumQuickLoginManager", 1, new Object[] { "phoneToken : ", paramString });
    }
    paramContext = new GatewayVerify.ReqBody();
    paramContext.msg_req_self_phone.msg_req_phone_login.bytes_phone_token.set(ByteStringMicro.copyFromUtf8(paramString));
    paramContext.msg_req_self_phone.msg_req_phone_login.bool_support_auxinfo_check.set(true);
    paramContext.msg_req_self_phone.msg_req_phone_login.setHasFlag(true);
    paramContext.msg_req_self_phone.setHasFlag(true);
    paramContext.setHasFlag(true);
    paramContext = paramContext.toByteArray();
    GatewayLoginNewDevHelper.a(paramContext);
    paramAppRuntime.quickLoginByGateway(paramContext, paramWtloginObserver);
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime, Map<String, Object> paramMap, WtloginObserver paramWtloginObserver)
  {
    a(paramAppRuntime);
    jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule.a(new PhoneNumQuickLoginManager.1(paramContext, paramAppRuntime, paramMap, paramWtloginObserver));
  }
  
  public static void a(String paramString)
  {
    a("0X800B8CF", 0, paramString);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2)
  {
    ReportController.a(a(), "dc00898", "", "", paramString1, paramString1, paramInt, 0, paramString2, "", "", "");
  }
  
  private static void a(AppRuntime paramAppRuntime)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule == null)
        {
          paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
          if (paramAppRuntime != null)
          {
            paramAppRuntime = util.buf_to_string(paramAppRuntime.getGUID());
            jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule = new LocalPhoneModule(1600001558, "-WGQH1006", UserAction.getQIMEI(), paramAppRuntime);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      paramAppRuntime = "";
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, LocalPhoneModule.MaskPhoneCallback paramMaskPhoneCallback)
  {
    a(paramAppRuntime);
    jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule.a(paramMaskPhoneCallback);
  }
  
  public static void a(WUserSigInfo paramWUserSigInfo, Context paramContext, Map<String, Object> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = paramWUserSigInfo.loginResultTLVMap;
        localObject2 = (tlv_t)((HashMap)localObject1).get(Integer.valueOf(1347));
        localObject1 = (tlv_t)((HashMap)localObject1).get(Integer.valueOf(260));
        if ((localObject2 == null) || (localObject1 == null))
        {
          if (localObject1 != null) {
            break label246;
          }
          paramBoolean = true;
          QLog.e("PhoneNumQuickLoginManager", 1, new Object[] { "0x543 or 0x104 tlv is null ", Boolean.valueOf(paramBoolean) });
          a(paramContext, paramMap);
          return;
        }
        paramWUserSigInfo = a(paramWUserSigInfo, 1);
        if ((paramWUserSigInfo == null) || (paramWUserSigInfo.isEmpty()))
        {
          QLog.e("PhoneNumQuickLoginManager", 1, "uinInfoList is null or empty");
          a(paramContext, paramMap);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramWUserSigInfo)
      {
        QLog.e("PhoneNumQuickLoginManager", 1, "0x543 tlv illegal, merge error : InvalidProtocolBufferMicroException ", paramWUserSigInfo);
        a(paramContext, paramMap);
        return;
      }
      a("0X800B8D1", 0, String.valueOf(paramWUserSigInfo.size()));
      Object localObject2 = new HashMap();
      ((Map)localObject2).put("key_dialog_title", paramContext.getString(2131699075));
      ((Map)localObject2).put("key_dialog_msg", paramContext.getString(2131699074));
      ((Map)localObject2).put("key_unbind_account_list", paramWUserSigInfo);
      ((Map)localObject2).put("login_tvl_value", ((tlv_t)localObject1).get_data());
      a(paramContext, (Map)localObject2, new PhoneNumQuickLoginManager.10(paramBoolean), new PhoneNumQuickLoginManager.11());
      return;
      label246:
      paramBoolean = false;
    }
  }
  
  public static boolean a(WUserSigInfo paramWUserSigInfo, Context paramContext, PhoneNumQuickLoginManager.OnUinClickListener paramOnUinClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Object localObject1 = paramWUserSigInfo.loginResultTLVMap;
    Object localObject2 = (tlv_t)((HashMap)localObject1).get(Integer.valueOf(1347));
    localObject1 = (tlv_t)((HashMap)localObject1).get(Integer.valueOf(260));
    if ((localObject2 == null) || (localObject1 == null))
    {
      if (localObject1 == null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("PhoneNumQuickLoginManager", 1, new Object[] { "onSmsLoginSelectAccount: 0x543 or 0x104 tlv is null ", Boolean.valueOf(bool) });
        return false;
      }
    }
    try
    {
      paramWUserSigInfo = a(paramWUserSigInfo, 2);
      if ((paramWUserSigInfo == null) || (paramWUserSigInfo.isEmpty()))
      {
        QLog.e("PhoneNumQuickLoginManager", 1, "onSmsLoginSelectAccount: uinInfoList is null or empty");
        return false;
      }
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.e("PhoneNumQuickLoginManager", 1, "onSmsLoginSelectAccount: 0x543 tlv illegal, merge error : InvalidProtocolBufferMicroException ", paramWUserSigInfo);
      return false;
    }
    a("0X800B937", 0, String.valueOf(paramWUserSigInfo.size()));
    localObject2 = new HashMap();
    ((Map)localObject2).put("key_dialog_title", paramContext.getString(2131699075));
    ((Map)localObject2).put("key_dialog_msg", paramContext.getString(2131699074));
    ((Map)localObject2).put("key_unbind_account_list", paramWUserSigInfo);
    ((Map)localObject2).put("login_tvl_value", ((tlv_t)localObject1).get_data());
    a(paramContext, (Map)localObject2, paramOnUinClickListener, paramOnDismissListener);
    return true;
  }
  
  public static void b(int paramInt)
  {
    a("0X800B8CB", paramInt, "");
  }
  
  private static void b(Context paramContext, Dialog paramDialog)
  {
    Object localObject = paramDialog.findViewById(2131363667);
    ((View)localObject).setOnClickListener(null);
    localObject = (LinearLayout)((View)localObject).findViewById(2131370701);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772003);
    paramContext.setAnimationListener(new PhoneNumQuickLoginManager.12(paramDialog));
    ((LinearLayout)localObject).startAnimation(paramContext);
  }
  
  public static void b(Context paramContext, Map<String, Object> paramMap)
  {
    String str1 = (String)paramMap.get("key_dialog_msg");
    String str2 = (String)paramMap.get("key_dialog_ok_btn_text");
    String str3 = (String)paramMap.get("key_dialog_no_btn_text");
    String str4 = (String)paramMap.get("key_phone_num");
    paramMap = (String)paramMap.get("key_token");
    QLog.d("PhoneNumQuickLoginManager", 1, new Object[] { "showUnbindPhoneNumDialog dialogMsg=", str1, ", okBtnText=", str2, ", noBtnText=", str3, ", phoneNum=", str4, ", token is empty=", Boolean.valueOf(TextUtils.isEmpty(paramMap)) });
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
    localQQCustomDialog.setMessage(str1);
    localQQCustomDialog.getMessageTextView().setGravity(1);
    localQQCustomDialog.setPositiveButton(str2, new PhoneNumQuickLoginManager.13(paramContext, str4, paramMap));
    localQQCustomDialog.setNegativeButton(str3, new PhoneNumQuickLoginManager.14());
    localQQCustomDialog.show();
  }
  
  public static void b(String paramString)
  {
    a(paramString, 0, "");
  }
  
  public static void c(int paramInt)
  {
    a("0X800B8CC", paramInt, "");
  }
  
  public static void c(Context paramContext, Map<String, Object> paramMap)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, new Object[] { "showBoundPhoneNumDialog context=", paramContext, ", params=", paramMap });
    if ((paramContext == null) || (paramMap == null) || (paramMap.isEmpty()))
    {
      QLog.d("PhoneNumQuickLoginManager", 1, "showBoundPhoneNumDialog param invalid");
      return;
    }
    paramContext = a(paramContext, 2131561318);
    a(paramContext, paramMap);
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager
 * JD-Core Version:    0.7.0.1
 */