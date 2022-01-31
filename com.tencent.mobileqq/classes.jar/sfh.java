import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.1;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.2;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.3;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.4;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.5;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class sfh
{
  public static int a;
  public static long a;
  private static QQHashMap<Integer, sfi> jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap;
  public static String a;
  public static ArrayList<String> a;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public static boolean a;
  public static int b;
  public static String b;
  public static boolean b;
  public static int c;
  public static String c;
  public static boolean c;
  public static int d;
  public static String d;
  public static boolean d;
  public static int e;
  public static String e;
  public static boolean e;
  public static String f;
  public static boolean f;
  public static String g;
  public static boolean g;
  public static String h;
  public static boolean h;
  public static String i;
  public static boolean i;
  public static boolean j;
  public static boolean k;
  public static boolean l;
  public static boolean m;
  public static boolean n;
  public static boolean o;
  public static boolean p;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    jdField_f_of_type_JavaLangString = "";
    jdField_a_of_type_Long = 3000L;
    jdField_a_of_type_Int = 10;
    k = true;
    jdField_g_of_type_JavaLangString = "";
    jdField_h_of_type_JavaLangString = "";
    jdField_i_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (paramQQAppInterface != null) {
      i1 = paramQQAppInterface.getInt("service_account_folder_config_version", 0);
    }
    QLog.d("PublicAccountConfigUtil", 1, "getServiceAccountFolderConfigVersionCode  version:" + i1);
    return i1;
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getResources().getDrawable(2130839736);
    case 1: 
      return paramContext.getResources().getDrawable(2130840076);
    }
    return paramContext.getResources().getDrawable(2130840081);
  }
  
  public static final String a()
  {
    if (b()) {
      return c();
    }
    return ajyc.a(2131716866);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    paramQQAppInterface = localObject;
    if (localSharedPreferences != null) {
      paramQQAppInterface = localSharedPreferences.getString("public_account_center_url_config_data", null);
    }
    return paramQQAppInterface;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 1);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    sfi localsfi = a(paramQQAppInterface, paramContext, paramInt);
    if (localsfi != null) {
      return localsfi.a();
    }
    return b(paramQQAppInterface, paramContext, paramInt);
  }
  
  public static sfi a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 3) {
      i1 = 2;
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(paramQQAppInterface, paramContext);
    }
    if (jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap == null) {
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new PublicAccountConfigUtil.1(2011, 0, 1000);
    }
    return (sfi)jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.get(Integer.valueOf(i1));
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (localSharedPreferences != null)
    {
      jdField_d_of_type_JavaLangString = localSharedPreferences.getString("service_account_folder_name", null);
      jdField_e_of_type_JavaLangString = localSharedPreferences.getString("service_account_folder_icon", null);
      jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("service_account_folder_delete", false);
      p = localSharedPreferences.getBoolean("service_folder_redclean_after_enter", false);
      jdField_b_of_type_Boolean = localSharedPreferences.getBoolean("service_account_folder_redspots", false);
      jdField_e_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload", false);
      jdField_f_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload_wifi", false);
      jdField_g_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload_4G", false);
      jdField_h_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload_3G", false);
      jdField_i_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload_2G", false);
      l = localSharedPreferences.getBoolean("public_account_bottom_bar", false);
      j = localSharedPreferences.getBoolean("kandian_feeds_image_preload", false);
      jdField_f_of_type_JavaLangString = localSharedPreferences.getString("kandian_feeds_fling_LToR_host", "");
      jdField_a_of_type_Long = localSharedPreferences.getLong("kandian_ad_background_showtime", 3000L);
      m = localSharedPreferences.getBoolean("readInJoy_ip_connect", false);
      jdField_b_of_type_Int = localSharedPreferences.getInt("readInJoy_ip_connect_full_report", 0);
      jdField_i_of_type_JavaLangString = localSharedPreferences.getString("readInJoy_ip_connect_report_tail", "");
      n = localSharedPreferences.getBoolean("readInJoy_loading_img", false);
      jdField_c_of_type_Boolean = localSharedPreferences.getBoolean("service_account_folder_redspots_delete", false);
      o = localSharedPreferences.getBoolean("big_data_share_channel", false);
      localSet = bbjo.a(localSharedPreferences, "big_data_share_channel_urls", null);
      if (localSet != null) {
        jdField_a_of_type_JavaUtilArrayList = new ArrayList(localSet);
      }
      jdField_c_of_type_Int = localSharedPreferences.getInt("album_predown_enable", 0);
      jdField_d_of_type_Int = localSharedPreferences.getInt("album_predown_photo_rule", 0);
      jdField_e_of_type_Int = localSharedPreferences.getInt("album_predown_slide_photocounts", 0);
      k = localSharedPreferences.getBoolean("ad_preload_tool_process", true);
      jdField_g_of_type_JavaLangString = localSharedPreferences.getString("key_read_in_joy_preload_tool_config", "");
      jdField_h_of_type_JavaLangString = localSharedPreferences.getString("key_read_in_joy_release_service_config", "");
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "getServiceAccountFolderConfigData success, uin:" + str + ", delete:" + jdField_a_of_type_Boolean + ", clean:" + p + ", redspot:" + jdField_b_of_type_Boolean);
      }
    }
    while (!QLog.isColorLevel())
    {
      Set localSet;
      return;
    }
    QLog.d("PublicAccountConfigUtil", 2, "getServiceAccountFolderConfigData failed, uin:" + str);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("public_account_center_url_config_version", paramInt);
      paramQQAppInterface.commit();
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap == null) {
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new PublicAccountConfigUtil.2(2011, 0, 1000);
    }
    if (!a(paramQQAppInterface, paramContext, bbjn.e(paramContext)))
    {
      localObject = new sfi(paramQQAppInterface, paramContext, 1, 2131696729, 2130840076);
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(1), localObject);
    }
    Object localObject = bbjn.h(paramContext);
    String str = bbjn.i(paramContext);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)))
    {
      paramQQAppInterface = new sfi(paramQQAppInterface, paramContext, 2, 2131695579, 2130840081);
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(2), paramQQAppInterface);
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
      paramQQAppInterface = new sfi(paramQQAppInterface, paramContext, 2, (String)localObject, str);
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(2), paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (a(str1))
        {
          jdField_a_of_type_JavaLangString = str1;
          if (!a(str2)) {
            break label159;
          }
          jdField_b_of_type_JavaLangString = str2;
          if (!paramString.has("readinjoy_search_url")) {
            break label167;
          }
          str1 = paramString.getString("readinjoy_search_url");
          if (a(str1)) {
            jdField_c_of_type_JavaLangString = str1;
          }
          if (!paramString.has("image_collection_comment")) {
            break;
          }
          jdField_d_of_type_Boolean = paramString.getBoolean("image_collection_comment");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "loadPublicAccountCenterUrlConfig error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
        jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
        jdField_d_of_type_Boolean = false;
        return;
      }
      jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      continue;
      label159:
      jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      continue;
      label167:
      a(paramQQAppInterface, 0);
    }
    a(paramQQAppInterface, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str7 = null;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("tim_url")) {
        localJSONObject.getString("tim_url");
      }
      if (!localJSONObject.has("tim_url_card")) {
        break label576;
      }
      paramQQAppInterface = localJSONObject.getString("tim_url_card");
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        paramQQAppInterface.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("PublicAccountConfigUtil", 2, "update public account qq mail config error.", paramQQAppInterface);
          continue;
          str6 = null;
          continue;
          str5 = null;
          continue;
          str4 = null;
          continue;
          str3 = null;
          continue;
          str2 = null;
          continue;
          str1 = null;
          continue;
          paramString = null;
          continue;
          paramQQAppInterface = null;
        }
      }
    }
    if (localJSONObject.has("tim_wording"))
    {
      paramString = localJSONObject.getString("tim_wording");
      if (localJSONObject.has("tim_url_icon"))
      {
        str1 = localJSONObject.getString("tim_url_icon");
        if (localJSONObject.has("tim_url_icon_725"))
        {
          str2 = localJSONObject.getString("tim_url_icon_725");
          if (localJSONObject.has("qim_url_card"))
          {
            str3 = localJSONObject.getString("qim_url_card");
            if (localJSONObject.has("qim_wording"))
            {
              str4 = localJSONObject.getString("qim_wording");
              if (localJSONObject.has("qim_url_icon"))
              {
                str5 = localJSONObject.getString("qim_url_icon");
                if (localJSONObject.has("qim_url_icon_720"))
                {
                  str6 = localJSONObject.getString("qim_url_icon_720");
                  if (localJSONObject.has("qim_url_icon_story")) {
                    str7 = localJSONObject.getString("qim_url_icon_story");
                  }
                  if (a(paramQQAppInterface)) {
                    localEditor.putString("profile_card_tim_online_url", paramQQAppInterface);
                  }
                  if (a(str1)) {
                    localEditor.putString("profile_card_tim_online_icon_url", str1);
                  }
                  if (a(str2)) {
                    localEditor.putString("profile_card_tim_online_icon_725_url", str2);
                  }
                  if (!TextUtils.isEmpty(paramString)) {
                    localEditor.putString("profile_card_tim_online_wording", paramString);
                  }
                  if (a(str3)) {
                    localEditor.putString("profile_card_qim_online_url", str3);
                  }
                  if (a(str5)) {
                    localEditor.putString("profile_card_qim_online_icon_url", str5);
                  }
                  if (a(str6)) {
                    localEditor.putString("profile_card_qim_online_icon_url_720", str6);
                  }
                  if (a(str7)) {
                    localEditor.putString("key_story_qim_online_icon_url", str7);
                  }
                  if (!TextUtils.isEmpty(str4)) {
                    localEditor.putString("profile_card_qim_online_wording", str4);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountConfigUtil", 2, "updatePublicAccountQQMailConfigData url_card_tim_online:" + paramQQAppInterface + "; url_card_qim_online:" + str3);
                  }
                  localEditor.putInt("public_account_qq_mail_config_version", paramInt);
                  localEditor.commit();
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "resetPublicAccountConfig uin:" + paramString);
    }
    jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_f_of_type_Boolean = false;
    jdField_g_of_type_Boolean = false;
    jdField_h_of_type_Boolean = false;
    jdField_i_of_type_Boolean = false;
    j = false;
    jdField_f_of_type_JavaLangString = "";
    jdField_a_of_type_Long = 3000L;
    k = true;
    m = false;
    jdField_b_of_type_Int = 0;
    jdField_i_of_type_JavaLangString = "";
    n = false;
    o = false;
    jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_e_of_type_Int = 0;
    jdField_g_of_type_JavaLangString = "";
    jdField_h_of_type_JavaLangString = "";
  }
  
  public static void a(ArrayList<sfi> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      if (jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap == null) {
        jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new PublicAccountConfigUtil.5(2011, 0, 1000);
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        sfi localsfi = (sfi)paramArrayList.next();
        jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(localsfi.jdField_a_of_type_Int), localsfi);
      }
    }
  }
  
  public static boolean a()
  {
    return p;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "parseConfigXml xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getElementsByTagName("public-account-folder");
        int i2 = paramString.getLength();
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject = (Element)paramString.item(i1);
          int i3 = Integer.parseInt(((Element)localObject).getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
          localObject = new sfi(paramQQAppInterface, paramContext, i3, ((Element)localObject).getElementsByTagName("name").item(0).getFirstChild().getNodeValue(), ((Element)localObject).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue());
          if (jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap == null) {
            jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new PublicAccountConfigUtil.3(2011, 0, 1000);
          }
          jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(i3), localObject);
          i1 += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml xml is empty");
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeRecommendConfig xml: " + paramString);
    }
    label3077:
    for (;;)
    {
      int i1;
      boolean bool;
      try
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        Object localObject1 = paramString.getElementsByTagName("recommendFullVersion");
        int i2;
        Object localObject2;
        int i3;
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = scu.b(paramQQAppInterface);
          if (i1 <= i2) {
            continue;
          }
          localObject1 = (Element)paramString.getElementsByTagName("recommendFullScreen").item(0);
          localObject2 = (Element)paramString.getElementsByTagName("recommendURL").item(0);
          i3 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = ((Element)localObject2).getFirstChild().getNodeValue();
          if (i3 != 1) {
            break label3065;
          }
          bool = true;
          scu.a(paramQQAppInterface, bool, (String)localObject1);
          scu.b(paramQQAppInterface, i1);
          if (i3 == 1)
          {
            localObject2 = (WebProcessManager)paramQQAppInterface.getManager(13);
            if (localObject2 != null) {
              ((WebProcessManager)localObject2).a(66);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("SubscriptRecommendConfig update fullrecommend config. version : ").append(i1).append(" switch : ");
            if (i3 != 1) {
              break label3071;
            }
            bool = true;
            QLog.d("PublicAccountConfigUtil", 2, bool + " url : " + (String)localObject1 + " oldVersion : " + i2);
          }
        }
        localObject1 = paramString.getElementsByTagName("recommendBottomVersion");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = scu.c(paramQQAppInterface);
          if (i1 <= i2) {
            break label2957;
          }
          i3 = Integer.valueOf(((Element)paramString.getElementsByTagName("recommendBottom").item(0)).getFirstChild().getNodeValue()).intValue();
          if (i3 != 1) {
            break label2951;
          }
          bool = true;
          scu.a(paramQQAppInterface, bool);
          scu.c(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update innerrecommend config. preversion -> version " + i2 + "->" + i1 + " switch : " + i3);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("kandian_read_data").item(0);
        if (localObject1 != null)
        {
          i1 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i1 != 1) {
            break label3077;
          }
          bool = true;
          bbjn.b((Context)localObject1, bool);
        }
        localObject1 = paramString.getElementsByTagName("channel_version");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = bhvh.b(paramQQAppInterface);
          if (i1 <= i2) {
            break label2992;
          }
          localObject2 = (Element)paramString.getElementsByTagName("channel_id").item(0);
          Element localElement = (Element)paramString.getElementsByTagName("channel_name").item(0);
          localObject1 = (Element)paramString.getElementsByTagName("channel_type").item(0);
          i3 = Integer.valueOf(((Element)localObject2).getFirstChild().getNodeValue()).intValue();
          localObject2 = String.valueOf(localElement.getFirstChild().getNodeValue());
          int i4 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          bhvh.a(paramQQAppInterface, i3, (String)localObject2, i4);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "update channelInfo config. preversion -> version " + i2 + "->" + i1 + " channelID : " + i3 + " channelName: " + (String)localObject2 + " channelType: " + i4);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("video_sound").item(0);
        if (localObject1 != null)
        {
          i1 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i1 != 0) {
            break label3027;
          }
          bool = true;
          bbjn.c((Context)localObject1, bool);
          localObject1 = qvn.a();
          if (i1 != 0) {
            break label3033;
          }
          bool = true;
          ((qvn)localObject1).a(bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get video sound config " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_support_enable");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (i1 <= 0) {
            break label3039;
          }
          bool = true;
          bhvh.b(paramQQAppInterface, bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "updateSupportMultiVideoSwitch， supportEnable = " + i1);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("rn_switch").item(0);
        if (localObject1 != null)
        {
          i1 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i1 == 1) {
            break label3045;
          }
          bool = true;
          bbjn.a((Context)localObject1, bool, paramQQAppInterface.c());
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get interesrLableRn config " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_struct_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3051;
          }
          bool = true;
          bhvh.d(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("video_social_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3057;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "parse kandian video social switch = " + bool);
          }
          bhvh.h(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("videochannel_video_autoplay");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video channel auto play switch default value = " + i1);
          }
          bhvh.b(paramQQAppInterface, i1);
        }
        localObject1 = paramString.getElementsByTagName("video_jump_to");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video jump default value = " + i1);
          }
          bhvh.d(paramQQAppInterface, i1);
        }
        localObject1 = paramString.getElementsByTagName("defaultBitRate");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          localObject1 = (Element)((NodeList)localObject1).item(0);
          bhvh.w(paramQQAppInterface, ((Element)localObject1).getFirstChild().getNodeValue());
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "defaultBitRate value = " + ((Element)localObject1).getFirstChild().getNodeValue());
          }
        }
        localObject1 = paramString.getElementsByTagName("CUKingCard_Dlg");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.e(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "CUKingCardDlg value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_channel_style");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.m(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_channel_style value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_strategyid");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.n(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_strategyid value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_duration_limit");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.o(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_duration_limit value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_duration_percent");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          float f1 = Float.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).floatValue();
          bhvh.a(paramQQAppInterface, f1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_duration_percent value = " + f1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_operator");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.p(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_operator value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("web_viola_render_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.q(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "web_viola_render_switch value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("web_viola_render_mode");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.r(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "web_viola_render_mode value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("videochannel_video_autoplay_18mo");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video flow video channel auto play switch default value = " + i1);
          }
          bhvh.c(paramQQAppInterface, i1);
        }
        localObject1 = paramString.getElementsByTagName("click_videocard_jump_comment");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video channel feeds click switch default value = " + i1);
          }
          bhvh.a(paramQQAppInterface, i1);
        }
        localObject1 = paramString.getElementsByTagName("viola_dynamic_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.s(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic default value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("viola_dynamic_weishi_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.t(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic weishi default value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("viola_discover_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          bhvh.u(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic discover default value = " + i1);
          }
        }
        paramString = paramString.getElementsByTagName("viola_message_box_switch");
        if ((paramString == null) || (paramString.getLength() <= 0)) {
          break label3063;
        }
        i1 = Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue();
        bhvh.v(paramQQAppInterface, i1);
        if (!QLog.isColorLevel()) {
          break label3063;
        }
        QLog.d("PublicAccountConfigUtil", 2, "viola dynamic message box default value = " + i1);
        break label3063;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig same version ! " + i1);
        continue;
        bool = false;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "update subscript recommend config error." + paramQQAppInterface);
        }
        return false;
      }
      label2951:
      continue;
      label2957:
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update fail same version " + i1);
        continue;
        label2992:
        if (QLog.isColorLevel())
        {
          QLog.d("PublicAccountConfigUtil", 2, "update channelInfo fail same version " + i1);
          continue;
          label3027:
          bool = false;
          continue;
          label3033:
          bool = false;
          continue;
          label3039:
          bool = false;
          continue;
          label3045:
          bool = false;
          continue;
          label3051:
          bool = false;
          continue;
          label3057:
          bool = false;
          continue;
          label3063:
          return true;
          label3065:
          bool = false;
          continue;
          label3071:
          bool = false;
          continue;
          bool = false;
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
      return false;
    }
    return true;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i1 = paramQQAppInterface.getInt("public_account_center_url_config_version", 0);
    }
    return i1;
  }
  
  public static final String b()
  {
    if (b()) {
      return c();
    }
    return ajyc.a(2131716866);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 2);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return paramContext.getString(2131696729);
    }
    return paramContext.getString(2131695579);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountConfigUtil.4(paramQQAppInterface));
  }
  
  public static boolean b()
  {
    return "1".equals((String)xfr.a().a("subscribe_entrance_enable", "0"));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i1;
    do
    {
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "update readinjoy folder xml: " + paramString);
        }
        try
        {
          paramString = paramString.trim();
          paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          Object localObject = paramString.getElementsByTagName("id");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            i1 = Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue();
            if (i1 > bbjn.y(paramQQAppInterface.getApp()))
            {
              localObject = (Element)paramString.getElementsByTagName("name").item(0);
              paramString = (Element)paramString.getElementsByTagName("icon").item(0);
              localObject = ((Element)localObject).getFirstChild().getNodeValue();
              paramString = paramString.getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString))) {
                bbjn.a(paramQQAppInterface.getApp(), (String)localObject, paramString);
              }
              bbjn.p(paramQQAppInterface.getApp(), i1);
              return false;
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return false;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountConfigUtil", 2, "readinjoy folder config same id ! " + i1);
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!TextUtils.isEmpty(str)) && (paramString.indexOf(str) != -1) && (paramString.endsWith(str))) {
        return true;
      }
    }
    return false;
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i1 = paramQQAppInterface.getInt("public_account_qq_mail_config_version", 0);
    }
    return i1;
  }
  
  private static final String c()
  {
    return (String)xfr.a().a("subscribe_account_title", xfr.jdField_c_of_type_JavaLangString);
  }
  
  public static String c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 3);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {}
    try
    {
      paramQQAppInterface = new JSONObject();
      paramQQAppInterface.put("pacenter_url", jdField_a_of_type_JavaLangString);
      paramQQAppInterface.put("pacategory_url", jdField_b_of_type_JavaLangString);
      paramQQAppInterface.put("readinjoy_search_url", jdField_c_of_type_JavaLangString);
      paramQQAppInterface.put("image_collection_comment", jdField_d_of_type_Boolean);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("public_account_center_url_config_data", paramQQAppInterface.toString());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updatePublicAccountCenterUrlConfigData error", paramQQAppInterface);
      }
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static boolean c()
  {
    String str1 = (String)xfr.a().a("subscribe_entrance_enable", "0");
    String str2 = (String)xfr.a().a("newfollowlist", "1");
    return ("1".equals(str1)) || ("1".equals(str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sfh
 * JD-Core Version:    0.7.0.1
 */