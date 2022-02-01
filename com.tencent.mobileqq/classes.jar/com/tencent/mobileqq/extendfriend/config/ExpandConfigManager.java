package com.tencent.mobileqq.extendfriend.config;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler;
import com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import expand.network.ExtendFriendABTestConfig.GetTabTestInfoReq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusReq;

public class ExpandConfigManager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendConfig jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public ExpandConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ExtendFriendConfig a(String paramString)
  {
    int j = 0;
    Object localObject = ExpandSharePreUtils.a(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ExtendFriendConfig localExtendFriendConfig = new ExtendFriendConfig();
    try
    {
      paramString = new JSONObject(paramString);
      localExtendFriendConfig.jdField_a_of_type_Int = paramString.optInt("expandVersion");
      localExtendFriendConfig.jdField_b_of_type_Int = paramString.optInt("androidExpandPlugin", 0);
      localExtendFriendConfig.jdField_a_of_type_JavaLangString = paramString.optString("centerBannerList");
      localExtendFriendConfig.jdField_c_of_type_Int = paramString.optInt("tabIndex");
      localExtendFriendConfig.jdField_d_of_type_Int = paramString.optInt("testId");
      localExtendFriendConfig.jdField_b_of_type_JavaLangString = paramString.optString("testStrId");
      localExtendFriendConfig.jdField_e_of_type_Int = paramString.optInt("saveEmptyAIONode", 1);
      localExtendFriendConfig.jdField_f_of_type_Int = paramString.optInt("newUserMoment");
      localExtendFriendConfig.jdField_g_of_type_Int = paramString.optInt("upgradeIntroduce");
      QLog.d("expand.config.ExpandConfigManager", 1, "parseConfig expandVersion:" + localExtendFriendConfig.jdField_a_of_type_Int + ", tabIndex = " + localExtendFriendConfig.jdField_c_of_type_Int + ", testStrId=" + localExtendFriendConfig.jdField_b_of_type_JavaLangString + " config taskId=" + (String)localObject + ", saveEmptyAIONode = " + localExtendFriendConfig.jdField_e_of_type_Int + ", newUserMoment = " + localExtendFriendConfig.jdField_f_of_type_Int + ", upgradeIntroduce = " + localExtendFriendConfig.jdField_g_of_type_Int);
      localExtendFriendConfig.jdField_c_of_type_JavaLangString = paramString.optString("contactEntranceTitle");
      localExtendFriendConfig.jdField_d_of_type_JavaLangString = paramString.optString("contactEntranceLine1");
      localExtendFriendConfig.jdField_e_of_type_JavaLangString = paramString.optString("contactEntranceLine2");
      localExtendFriendConfig.jdField_f_of_type_JavaLangString = paramString.optString("addEntranceTitle");
      localExtendFriendConfig.jdField_g_of_type_JavaLangString = paramString.optString("addEntranceLine1");
      localExtendFriendConfig.jdField_h_of_type_Int = paramString.optInt("maxPlayers");
      localExtendFriendConfig.jdField_i_of_type_Int = paramString.optInt("minPlayers");
      localExtendFriendConfig.jdField_j_of_type_Int = paramString.optInt("voiceMaxLength");
      localExtendFriendConfig.jdField_k_of_type_Int = paramString.optInt("maxSlipTimes");
      localExtendFriendConfig.jdField_l_of_type_Int = paramString.optInt("redisplayInterval");
      localExtendFriendConfig.jdField_h_of_type_JavaLangString = paramString.optString("defaultDecleration");
      localExtendFriendConfig.jdField_m_of_type_Int = paramString.optInt("declerationMinLen");
      localExtendFriendConfig.jdField_n_of_type_Int = paramString.optInt("isExpandEntranceOnTop");
      localExtendFriendConfig.jdField_i_of_type_JavaLangString = paramString.optString("resourceURL");
      localExtendFriendConfig.jdField_j_of_type_JavaLangString = paramString.optString("resourceMD5");
      localExtendFriendConfig.jdField_p_of_type_JavaLangString = paramString.optString("flutterResAndroidURL_v2");
      localExtendFriendConfig.jdField_q_of_type_JavaLangString = paramString.optString("flutterResAndroidMD5_v2");
      localExtendFriendConfig.jdField_o_of_type_Int = paramString.optInt("isShowGroup");
      localExtendFriendConfig.jdField_l_of_type_JavaLangString = paramString.optString("ExpandExamImg");
      localExtendFriendConfig.t = paramString.optInt("exposureTimeLimit", 2);
      localExtendFriendConfig.jdField_a_of_type_Boolean = paramString.optBoolean("showVipIcon", false);
      localExtendFriendConfig.u = paramString.optInt("GrayTipsMsgCount", 50);
      localExtendFriendConfig.jdField_m_of_type_JavaLangString = paramString.optString("GrayTipsMsg");
      localExtendFriendConfig.jdField_n_of_type_JavaLangString = paramString.optString("GrayTipsMsgLight");
      localExtendFriendConfig.v = paramString.optInt("IceBreakSwitch", 1);
      localExtendFriendConfig.jdField_o_of_type_JavaLangString = paramString.optString("BeatWarning");
      localExtendFriendConfig.x = paramString.optInt("sendPicAndVoiceMessageLimitCount", 2);
      if (QLog.isColorLevel()) {
        QLog.d("expand.config.ExpandConfigManager", 2, "parseConfig config.exposureTimeLimit:" + localExtendFriendConfig.t + ", config.sendPicAndVoiceMessageLimitCount = " + localExtendFriendConfig.x);
      }
      localExtendFriendConfig.jdField_a_of_type_JavaUtilList.clear();
      localObject = paramString.optJSONArray("defaultTags");
      int i;
      if (localObject != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localExtendFriendConfig.jdField_a_of_type_JavaUtilList.add(((JSONArray)localObject).optString(i));
          i += 1;
        }
      }
      localExtendFriendConfig.jdField_b_of_type_JavaUtilList.clear();
      localObject = paramString.optJSONArray("searchTags");
      if (localObject != null)
      {
        i = j;
        while (i < ((JSONArray)localObject).length())
        {
          localExtendFriendConfig.jdField_b_of_type_JavaUtilList.add(((JSONArray)localObject).optString(i));
          i += 1;
        }
      }
      localExtendFriendConfig.jdField_k_of_type_JavaLangString = paramString.optString("searchHint");
      localObject = a(paramString.optJSONArray("ExpandMatchRes"));
      ((Map)localObject).putAll((Map)localObject);
      localExtendFriendConfig.jdField_p_of_type_Int = paramString.optInt("ExpandMatchSwitch");
      localExtendFriendConfig.jdField_q_of_type_Int = paramString.optInt("isNuanSSFirst");
      localExtendFriendConfig.r = paramString.optInt("isVoiceMatchOpen");
      localExtendFriendConfig.s = paramString.optInt("isSignalOpen");
      localExtendFriendConfig.w = paramString.optInt("coldPalaceGrayTipPosition", localExtendFriendConfig.w);
      if (QLog.isColorLevel()) {
        QLog.d("expand.config.ExpandConfigManager", 2, new Object[] { "parseConfig() ", Integer.valueOf(localExtendFriendConfig.jdField_a_of_type_Int), "-", Integer.valueOf(localExtendFriendConfig.jdField_b_of_type_Int), "-", localExtendFriendConfig.jdField_p_of_type_JavaLangString, "-", localExtendFriendConfig.jdField_q_of_type_JavaLangString });
      }
      return localExtendFriendConfig;
    }
    catch (JSONException paramString)
    {
      QLog.e("expand.config.ExpandConfigManager", 2, "parseConfig fail.", paramString);
    }
    return null;
  }
  
  private Map<String, ExpandConfigManager.LimitChatRes> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      ExpandConfigManager.LimitChatRes localLimitChatRes;
      if (localJSONObject != null)
      {
        localLimitChatRes = new ExpandConfigManager.LimitChatRes(this);
        localLimitChatRes.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
        if (!"aioVideo".equals(localLimitChatRes.jdField_a_of_type_JavaLangString)) {
          break label164;
        }
        localLimitChatRes.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURLAndroid");
        localLimitChatRes.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5Android");
        if (QLog.isColorLevel()) {
          QLog.d("expand.config.ExpandConfigManager", 2, String.format("aiovideo use android url:%s", new Object[] { localLimitChatRes.jdField_b_of_type_JavaLangString }));
        }
      }
      for (;;)
      {
        if (localLimitChatRes.a()) {
          localHashMap.put(localLimitChatRes.jdField_a_of_type_JavaLangString, localLimitChatRes);
        }
        i += 1;
        break;
        label164:
        localLimitChatRes.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURL");
        localLimitChatRes.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5");
      }
    }
    return localHashMap;
  }
  
  public int a()
  {
    int j = 0;
    int i = j;
    if (a())
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_g_of_type_Int;
      }
    }
    return i;
  }
  
  public ExtendFriendConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 413	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokevirtual 415	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:b	()V
    //   12: aload_0
    //   13: getfield 23	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: getfield 23	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 424	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   26: ldc_w 426
    //   29: invokestatic 431	com/tencent/mobileqq/utils/ConfigUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 437	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +108 -> 145
    //   40: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +29 -> 72
    //   46: ldc 111
    //   48: iconst_2
    //   49: new 113	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 439
    //   59: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: aload_1
    //   74: invokespecial 441	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/extendfriend/config/ExtendFriendConfig;
    //   77: astore_2
    //   78: aload_0
    //   79: getfield 17	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   82: astore_1
    //   83: aload_1
    //   84: monitorenter
    //   85: aload_0
    //   86: getfield 413	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_Boolean	Z
    //   89: ifne +13 -> 102
    //   92: aload_0
    //   93: aload_2
    //   94: putfield 409	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig	Lcom/tencent/mobileqq/extendfriend/config/ExtendFriendConfig;
    //   97: aload_0
    //   98: iconst_1
    //   99: putfield 413	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_Boolean	Z
    //   102: aload_1
    //   103: monitorexit
    //   104: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -100 -> 7
    //   110: ldc_w 443
    //   113: iconst_2
    //   114: ldc_w 445
    //   117: invokestatic 447	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: return
    //   121: astore_1
    //   122: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq -118 -> 7
    //   128: ldc 111
    //   130: iconst_2
    //   131: aload_1
    //   132: invokevirtual 450	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: aload_1
    //   136: invokestatic 452	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: return
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: aload_0
    //   146: getfield 17	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   149: astore_1
    //   150: aload_1
    //   151: monitorenter
    //   152: aload_0
    //   153: getfield 413	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_Boolean	Z
    //   156: ifne +8 -> 164
    //   159: aload_0
    //   160: iconst_1
    //   161: putfield 413	com/tencent/mobileqq/extendfriend/config/ExpandConfigManager:jdField_a_of_type_Boolean	Z
    //   164: aload_1
    //   165: monitorexit
    //   166: ldc 111
    //   168: iconst_2
    //   169: ldc_w 454
    //   172: invokestatic 456	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: goto -71 -> 104
    //   178: astore_2
    //   179: aload_1
    //   180: monitorexit
    //   181: aload_2
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	ExpandConfigManager
    //   121	21	1	localException	java.lang.Exception
    //   77	17	2	localExtendFriendConfig	ExtendFriendConfig
    //   140	4	2	localObject3	Object
    //   178	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	33	121	java/lang/Exception
    //   85	102	140	finally
    //   102	104	140	finally
    //   141	143	140	finally
    //   152	164	178	finally
    //   164	166	178	finally
    //   179	181	178	finally
  }
  
  public void a(ExpandConfigManager.IConfigCallback paramIConfigCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.config.ExpandConfigManager", 2, "getABTestConfig ");
    }
    ExtendFriendABTestConfig.GetTabTestInfoReq localGetTabTestInfoReq = new ExtendFriendABTestConfig.GetTabTestInfoReq();
    localGetTabTestInfoReq.version.set("1");
    ExpandCmdHandler localExpandCmdHandler = ExpandCmdHandler.a();
    if (localExpandCmdHandler == null)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, "getABTestConfig cmdHandler is null!");
      return;
    }
    localExpandCmdHandler.a("QQExpand.Tab.GetGrayPolicyInfo", localGetTabTestInfoReq.toByteArray(), 1, new ExpandConfigManager.3(this, paramIConfigCallback));
  }
  
  public void a(String arg1)
  {
    ExtendFriendConfig localExtendFriendConfig = a(???);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig = localExtendFriendConfig;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ExtendFriendConfig b()
  {
    if (!a()) {
      a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.config.ExpandConfigManager", 2, "getUserCategory ");
    }
    ExtendFriendUserCategory.GetUserStatusReq localGetUserStatusReq = new ExtendFriendUserCategory.GetUserStatusReq();
    localGetUserStatusReq.ReqUserCategory.set(true);
    localGetUserStatusReq.ReqUsedNewMatchFlag.set(true);
    localGetUserStatusReq.ReqHasPersonalLabelsFlag.set(true);
    localGetUserStatusReq.ReqForbiddenInfo.set(false);
    ExpandCmdHandler localExpandCmdHandler = ExpandCmdHandler.a();
    if (localExpandCmdHandler == null)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, "getUserCategory cmdHandler is null!");
      return;
    }
    localExpandCmdHandler.a("QQExpand.UserInfo.GetUserStatus", localGetUserStatusReq.toByteArray(), new ExpandConfigManager.1(this));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_p_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_q_of_type_JavaLangString));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.config.ExpandConfigManager", 2, "getForbiddenInfo ");
    }
    ExtendFriendUserCategory.GetUserStatusReq localGetUserStatusReq = new ExtendFriendUserCategory.GetUserStatusReq();
    localGetUserStatusReq.ReqForbiddenInfo.set(true);
    ExpandCmdHandler localExpandCmdHandler = ExpandCmdHandler.a();
    if (localExpandCmdHandler == null)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, "getForbiddenInfo cmdHandler is null!");
      return;
    }
    localExpandCmdHandler.a("QQExpand.UserInfo.GetUserStatus", localGetUserStatusReq.toByteArray(), new ExpandConfigManager.2(this));
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_b_of_type_Int == 1);
  }
  
  public boolean d()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (a())
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_a_of_type_Int != 1) {
          break label37;
        }
      }
    }
    label37:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_e_of_type_Int == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean f()
  {
    return (!a()) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExtendFriendConfig.jdField_f_of_type_Int == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.config.ExpandConfigManager
 * JD-Core Version:    0.7.0.1
 */