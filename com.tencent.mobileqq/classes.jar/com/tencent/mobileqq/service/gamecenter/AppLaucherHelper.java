package com.tencent.mobileqq.service.gamecenter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

public class AppLaucherHelper
{
  protected static long a = 0L;
  protected static boolean a = false;
  protected static String b = "";
  protected int a;
  protected Handler a;
  protected String a;
  protected HashMap<String, String> a;
  protected NewIntent a;
  protected Handler b;
  protected boolean b;
  
  public AppLaucherHelper()
  {
    this.jdField_a_of_type_MqqAppNewIntent = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static int a(String paramString)
  {
    if (paramString.contains("$OPID$")) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (paramString.contains("$AT$")) {
      i = j | 0x2;
    }
    int j = i;
    if (paramString.contains("$PT$")) {
      j = i | 0x4;
    }
    i = j;
    if (paramString.contains("$PF$")) {
      i = j | 0x40;
    }
    j = i;
    if (paramString.contains("$ESK$")) {
      j = i | 0x80;
    }
    return j;
  }
  
  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        int k = localObject.indexOf('=');
        if (k != -1) {
          try
          {
            localBundle.putString(localObject.substring(0, k), localObject.substring(k + 1));
          }
          catch (Exception localException)
          {
            QLog.d("AppLaucherHelper", 2, localException.getMessage(), localException);
          }
        }
        i += 1;
      }
    }
    return localBundle;
  }
  
  public static void a()
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  private void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    local4 = new AppLaucherHelper.4(this, System.currentTimeMillis(), paramString3, paramContext, paramInt);
    if (this.jdField_a_of_type_MqqAppNewIntent == null) {
      this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(paramContext, ProtoServlet.class);
    }
    localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
    }
    catch (Exception localException)
    {
      try
      {
        l1 = Long.parseLong(paramString1);
        localAuthorizeRequest.client_id.set(l1);
        paramString1 = localAuthorizeRequest.pf;
        String str = "";
        paramString1.set("");
        paramString1 = AppUtil.a(paramContext);
        localAuthorizeRequest.qqv.set(paramString1);
        localAuthorizeRequest.sdkp.set("a");
        paramString1 = Build.DISPLAY;
        localAuthorizeRequest.os.set(paramString1);
        localAuthorizeRequest.skey.set(paramString4);
        int i = a(paramString2);
        if (i != 0) {
          break label188;
        }
        AppUtil.a(paramContext, paramString3, a(this.jdField_a_of_type_JavaLangString), paramInt);
        jdField_a_of_type_Boolean = false;
        return;
        localAuthorizeRequest.flags.set(i);
        paramString1 = str;
        try
        {
          paramString4 = paramContext.getPackageManager().getPackageInfo(paramString3, 64).signatures;
          paramString1 = str;
          if (paramString4 != null)
          {
            paramString2 = str;
            paramString1 = str;
            try
            {
              MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
              paramString2 = str;
              paramString1 = str;
              localMessageDigest.update(paramString4[0].toByteArray());
              paramString2 = str;
              paramString1 = str;
              paramString4 = HexUtil.bytes2HexStr(localMessageDigest.digest());
              paramString2 = paramString4;
              paramString1 = paramString4;
              paramString4 = paramString4.toLowerCase();
              paramString2 = paramString4;
              paramString1 = paramString4;
              localMessageDigest.reset();
              paramString1 = paramString4;
            }
            catch (NoSuchAlgorithmException paramString4)
            {
              paramString1 = paramString2;
              paramString4.printStackTrace();
              paramString1 = paramString2;
            }
          }
        }
        catch (Exception paramString2)
        {
          break label320;
        }
        if (!TextUtils.isEmpty(paramString1)) {
          break label368;
        }
        if (!QLog.isColorLevel()) {
          break label347;
        }
        QLog.d(getClass().getSimpleName(), 2, "no sign");
        jdField_a_of_type_Boolean = false;
        AppUtil.a(paramContext, paramString3, a(this.jdField_a_of_type_JavaLangString), paramInt);
        return;
        localAuthorizeRequest.apk_sign.set(paramString1);
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
        try
        {
          this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localAuthorizeRequest.toByteArray());
          this.jdField_a_of_type_MqqAppNewIntent.setObserver(local4);
          paramAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 2000L);
          return;
        }
        catch (Exception paramAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d(getClass().getSimpleName(), 2, paramAppInterface.getMessage());
          }
          jdField_a_of_type_Boolean = false;
          return;
        }
        localException = localException;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          long l1 = l2;
        }
      }
    }
    l1 = 0L;
    localAuthorizeRequest.uin.set(l1);
  }
  
  public boolean a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp");
    }
    jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new AppLaucherHelper.3(this, Looper.getMainLooper(), paramContext, paramString3, paramInt, paramAppInterface, paramString1, paramString2);
    }
    if (paramString2.startsWith("?")) {
      this.jdField_a_of_type_JavaLangString = paramString2.substring(1);
    } else {
      this.jdField_a_of_type_JavaLangString = paramString2;
    }
    a(paramAppInterface, paramContext, paramString1, paramString2, paramString3, ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount()), paramInt);
    return true;
  }
  
  public boolean a(String paramString1, Context paramContext, String paramString2, AppInterface paramAppInterface, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin");
    }
    Long localLong;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!AuthorizeConfig.a().h(paramString2)) {
        return false;
      }
      jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_AndroidOsHandler == null) {
        this.jdField_b_of_type_AndroidOsHandler = new AppLaucherHelper.1(this);
      }
      localLong = Long.valueOf(0L);
    }
    try
    {
      paramString2 = Long.valueOf(paramString3);
    }
    catch (Exception paramString2)
    {
      label85:
      long l1;
      break label85;
    }
    paramString2 = localLong;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("parse appid error = ");
      paramString2.append(paramString3);
      QLog.d("appcenter", 2, paramString2.toString());
      paramString2 = localLong;
    }
    l1 = 1L;
    try
    {
      long l2 = Long.valueOf(paramString5).longValue();
      l1 = l2;
    }
    catch (Exception paramString3)
    {
      label148:
      break label148;
    }
    paramString3 = new WtloginHelper(paramAppInterface.getApplication().getApplicationContext());
    paramString5 = util.getPkgSigFromApkName(paramContext, paramString4);
    paramString3.GetA1WithA1(paramAppInterface.getAccount(), 16L, 16L, paramString4.getBytes(), 1L, paramString2.longValue(), l1, "5.2".getBytes(), paramString5, new WUserSigInfo(), new WFastLoginInfo());
    paramString3.SetListener(new AppLaucherHelper.2(this, paramString1, paramString3, paramInt, paramContext));
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10000L);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.gamecenter.AppLaucherHelper
 * JD-Core Version:    0.7.0.1
 */