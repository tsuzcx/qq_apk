package com.tencent.mobileqq.extendfriend.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.expand.flutter.ExpandFlutterContainerFragment;
import com.tencent.biz.expand.flutter.ExpandFlutterContainerFragment.Companion;
import com.tencent.biz.expand.ui.ExpandPluginLauncher;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.item.LimitChatTopicItemBuilder.Label;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.bean.LabelInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo.LabelInfo;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtendFriendLabelUtils
{
  private static long a = 0L;
  
  public static LabelInfo a(StrangerInfo paramStrangerInfo, Context paramContext)
  {
    if (paramStrangerInfo == null) {}
    while ((paramStrangerInfo.mGender != 1) && (paramStrangerInfo.mGender != 2) && (paramStrangerInfo.mAge == -1)) {
      return null;
    }
    LabelInfo localLabelInfo = new LabelInfo();
    int i;
    String str;
    if (paramStrangerInfo.mGender == 2)
    {
      i = 0;
      localLabelInfo.jdField_a_of_type_Int = i;
      if (paramStrangerInfo.mAge != -1) {
        break label154;
      }
      str = "";
      label66:
      localLabelInfo.jdField_a_of_type_JavaLangString = str;
      if ((paramStrangerInfo.mGender == 1) || (paramStrangerInfo.mGender == 2))
      {
        if (paramStrangerInfo.mGender != 2) {
          break label165;
        }
        paramContext = paramContext.getResources().getDrawable(2130845247);
        label106:
        localLabelInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
        if (paramStrangerInfo.mGender != 2) {
          break label178;
        }
        paramContext = "#FF80BF";
        label123:
        localLabelInfo.b = paramContext;
        if (paramStrangerInfo.mGender != 2) {
          break label184;
        }
      }
    }
    label154:
    label165:
    label178:
    label184:
    for (paramStrangerInfo = "#33FF80BF";; paramStrangerInfo = "#3300CAFC")
    {
      localLabelInfo.c = paramStrangerInfo;
      return localLabelInfo;
      i = 1;
      break;
      str = String.valueOf(paramStrangerInfo.mAge);
      break label66;
      paramContext = paramContext.getResources().getDrawable(2130845248);
      break label106;
      paramContext = "#02B2DD";
      break label123;
    }
  }
  
  public static List<LimitChatTopicItemBuilder.Label> a(Context paramContext, JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
        paramContext = paramContext.getResources().getStringArray(2130968659);
        int k = paramJSONArray.length();
        i = 0;
        if (i < k)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            LimitChatTopicItemBuilder.Label localLabel = new LimitChatTopicItemBuilder.Label();
            localLabel.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagName");
            int j;
            if (TextUtils.isEmpty(localLabel.jdField_a_of_type_JavaLangCharSequence))
            {
              j = 0;
              localLabel.b = Color.parseColor(arrayOfString[(j % arrayOfString.length)]);
              localLabel.jdField_a_of_type_Int = Color.parseColor(paramContext[(j % paramContext.length)]);
              localArrayList.add(localLabel);
            }
            else
            {
              j = localLabel.jdField_a_of_type_JavaLangCharSequence.charAt(0);
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (JSONException paramContext) {}
      i += 1;
    }
  }
  
  public static List<LabelInfo> a(StrangerInfo paramStrangerInfo, Context paramContext)
  {
    if (paramStrangerInfo == null) {
      return null;
    }
    if ((paramStrangerInfo.mLabelInfos == null) || (paramStrangerInfo.mLabelInfos.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
    paramContext = paramContext.getResources().getStringArray(2130968659);
    int i = 0;
    while (i < paramStrangerInfo.mLabelInfos.size())
    {
      LabelInfo localLabelInfo = new LabelInfo();
      localLabelInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      localLabelInfo.jdField_a_of_type_Int = 3;
      localLabelInfo.jdField_a_of_type_JavaLangString = ((StrangerInfo.LabelInfo)paramStrangerInfo.mLabelInfos.get(i)).jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(localLabelInfo.jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        if (TextUtils.isEmpty(localLabelInfo.jdField_a_of_type_JavaLangString)) {}
        for (int j = 0;; j = localLabelInfo.jdField_a_of_type_JavaLangString.charAt(0))
        {
          localLabelInfo.b = arrayOfString[(j % arrayOfString.length)];
          localLabelInfo.c = paramContext[(j % paramContext.length)];
          localArrayList.add(localLabelInfo);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    if (((ExtendFriendManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f()) {
      b(paramActivity, paramAppInterface, 6, "");
    }
    for (;;)
    {
      paramActivity.overridePendingTransition(2130771999, 2130771992);
      ExpandReportUtils.b("5");
      return;
      paramAppInterface = new Intent();
      paramAppInterface.putExtra("ExtendFriendLimitChatFromeType", paramInt);
      PublicFragmentActivity.a(paramActivity, paramAppInterface, ExtendFriendLimitChatMatchFragment.class);
      ExpandReportUtils.a("5");
    }
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    a(paramContext, paramAppInterface, paramInt, "");
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    QLog.i("expand.ExtendFriendLabelUtils", 4, "jump2AB850Expand go to a page with field <expandVersion>");
    localExtendFriendManager.b();
    if (localExtendFriendManager.f())
    {
      b(paramContext, paramAppInterface, paramInt, paramString);
      return;
    }
    ExtendFriendPublicFragmentActivity.a(paramContext, paramInt);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (System.currentTimeMillis() - a < 1000L)
    {
      QLog.i("expand.ExtendFriendLabelUtils", 4, "jump2Expand wait a while");
      return;
    }
    a = System.currentTimeMillis();
    a(paramAppInterface);
    HashMap localHashMap = new HashMap();
    localHashMap.put("hostId", "8531243");
    localHashMap.put("uid", paramAppInterface.getCurrentAccountUin());
    localHashMap.put("isPresent", Integer.valueOf(1));
    localHashMap.put("from", ExtendFriendPublicFragmentActivity.a(paramInt));
    localHashMap.put("startTime", System.currentTimeMillis() + "");
    Object localObject;
    if (QLog.isDebugVersion())
    {
      localObject = "0";
      localHashMap.put("isRelease", localObject);
      if (!QLog.isDebugVersion()) {
        break label623;
      }
      localObject = "0";
      label154:
      localHashMap.put("serverEnv", localObject);
      localHashMap.put("statusBarHeight", Integer.valueOf(ViewUtils.c(ImmersiveUtils.getStatusBarHeight(paramContext))));
      localHashMap.put("screenWidth", Integer.valueOf(ViewUtils.c(BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels)));
      localHashMap.put("screenHeight", Integer.valueOf(ViewUtils.c(BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels)));
      localObject = (ExtendFriendManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (((ExtendFriendManager)localObject).a() != null)
      {
        localHashMap.put("centerBannerList", ((ExtendFriendManager)localObject).a().jdField_a_of_type_JavaLangString);
        QLog.d("expand.ExtendFriendLabelUtils", 4, "jump2FlutterExpandByWidgetName " + localHashMap.get("centerBannerList"));
        if (TextUtils.isEmpty(((ExtendFriendManager)localObject).a().b)) {
          break label631;
        }
        localHashMap.put("testId", ((ExtendFriendManager)localObject).a().b);
      }
      label342:
      if (!((ExtendFriendManager)localObject).o()) {
        break label669;
      }
      paramAppInterface = "1";
      label354:
      localHashMap.put("isHasPersonalLabels", paramAppInterface);
      boolean bool1 = ((ExtendFriendManager)localObject).n();
      boolean bool2 = ((ExtendFriendManager)localObject).q();
      if ((bool1 == bool2) && (QLog.isColorLevel())) {
        QLog.w("expand.ExtendFriendLabelUtils", 2, "usedNewMatch and firstPromptExtendFriendNewUser flag is the same");
      }
      if ((bool1) || (!bool2)) {
        break label676;
      }
      localHashMap.put("isUsedNewExpand", "0");
      ((ExtendFriendManager)localObject).e(false);
      label428:
      localHashMap.put("userCategory", ((ExtendFriendManager)localObject).i() + "");
      if (!((ExtendFriendManager)localObject).a().f()) {
        break label691;
      }
      paramAppInterface = "1";
      label475:
      localHashMap.put("isHasNewUserMoment", paramAppInterface);
      localHashMap.put("isHasUpgradeIntroduce", ((ExtendFriendManager)localObject).a().a() + "");
      localHashMap.put("dartNativeSoPath", QFlutterInstaller.a("libdart_native.so"));
      if (paramInt != 2) {
        break label698;
      }
    }
    label669:
    label676:
    label691:
    label698:
    for (paramAppInterface = ((ExtendFriendManager)localObject).j();; paramAppInterface = "")
    {
      localHashMap.put("wavesId", paramAppInterface);
      localHashMap.put("jump", paramString3);
      if (QLog.isColorLevel()) {
        QLog.d("expand.ExtendFriendLabelUtils", 2, String.format("jump2FlutterExpandByWidgetName params=%s", new Object[] { localHashMap.toString() }));
      }
      paramAppInterface = new byte[1];
      ExpandFlutterContainerFragment.a.a(paramContext, paramString1, paramString2, localHashMap, paramAppInterface);
      return;
      localObject = "1";
      break;
      label623:
      localObject = "1";
      break label154;
      label631:
      localHashMap.put("testId", ((ExtendFriendManager)localObject).a().d + "");
      break label342;
      paramAppInterface = "0";
      break label354;
      localHashMap.put("isUsedNewExpand", "1");
      break label428;
      paramAppInterface = "0";
      break label475;
    }
  }
  
  private static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ExtendFriendLabelUtils.2(paramAppInterface));
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ExtendFriendLabelUtils.1(paramAppInterface), paramLong);
  }
  
  public static LabelInfo b(StrangerInfo paramStrangerInfo, Context paramContext)
  {
    if (paramStrangerInfo == null) {
      return null;
    }
    LabelInfo localLabelInfo = new LabelInfo();
    localLabelInfo.jdField_a_of_type_Int = 2;
    localLabelInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramStrangerInfo.mPopularity);
    localLabelInfo.b = "#8173FF";
    localLabelInfo.c = "#338173FF";
    localLabelInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845249);
    return localLabelInfo;
  }
  
  public static void b(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localExtendFriendManager.g())
    {
      a(paramAppInterface);
      paramAppInterface = new HashMap();
      paramAppInterface.put("sourceType", Integer.valueOf(paramInt));
      ExpandPluginLauncher.a().a(paramContext, paramAppInterface, paramString);
      return;
    }
    localExtendFriendManager.b();
    a(paramContext, paramAppInterface, "qqExpandWidget", "QQExpandWidget", paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils
 * JD-Core Version:    0.7.0.1
 */