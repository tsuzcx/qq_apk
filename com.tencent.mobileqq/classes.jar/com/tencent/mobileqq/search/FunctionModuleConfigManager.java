package com.tencent.mobileqq.search;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.config.SearchFunctionModuleBean;
import com.tencent.mobileqq.search.model.BusinessGroupWord.HotWordItem;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FunctionModuleConfigManager
  implements Manager
{
  private static ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  public static HashMap<String, List<BusinessGroupWord.HotWordItem>> a;
  public static HashMap<String, String> b;
  protected Handler a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public NetSearchTemplateBaseItem a;
  public ISearchResultModel a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    b = new HashMap();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(10));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(12));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(13));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(14));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(15));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(17));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(18));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(19));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(20));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(22));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(36));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(43));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(46));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(51));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(52));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(53));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(54));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(55));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(56));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(57));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(58));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(64));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(65));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(109));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(121));
  }
  
  public FunctionModuleConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static String a(List<Long> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append(((Long)paramList.next()).longValue());
      localStringBuilder.append("&");
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 110
    //   2: astore 4
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: ldc 110
    //   10: areturn
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore_2
    //   16: new 112	java/io/BufferedReader
    //   19: dup
    //   20: new 114	java/io/InputStreamReader
    //   23: dup
    //   24: new 116	java/io/ByteArrayInputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 119	java/io/ByteArrayInputStream:<init>	([B)V
    //   32: ldc 121
    //   34: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   37: invokespecial 127	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_3
    //   41: aload 4
    //   43: astore_1
    //   44: aload_3
    //   45: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +37 -> 87
    //   53: new 68	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   60: astore 4
    //   62: aload 4
    //   64: aload_1
    //   65: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 4
    //   71: aload_2
    //   72: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 4
    //   78: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_2
    //   82: aload_2
    //   83: astore_1
    //   84: goto -40 -> 44
    //   87: aload_3
    //   88: invokevirtual 133	java/io/BufferedReader:close	()V
    //   91: aload_1
    //   92: astore_2
    //   93: aload_3
    //   94: invokevirtual 133	java/io/BufferedReader:close	()V
    //   97: aload_1
    //   98: areturn
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   104: aload_2
    //   105: areturn
    //   106: astore_1
    //   107: aload_3
    //   108: astore_2
    //   109: goto +53 -> 162
    //   112: astore 5
    //   114: goto +15 -> 129
    //   117: astore_1
    //   118: goto +44 -> 162
    //   121: astore 5
    //   123: aload 6
    //   125: astore_3
    //   126: aload 4
    //   128: astore_1
    //   129: aload_3
    //   130: astore_2
    //   131: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +16 -> 150
    //   137: aload_3
    //   138: astore_2
    //   139: ldc 143
    //   141: iconst_2
    //   142: aload 5
    //   144: invokevirtual 144	java/io/IOException:toString	()Ljava/lang/String;
    //   147: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_3
    //   151: ifnull +9 -> 160
    //   154: aload_1
    //   155: astore_2
    //   156: aload_3
    //   157: invokevirtual 133	java/io/BufferedReader:close	()V
    //   160: aload_1
    //   161: areturn
    //   162: aload_2
    //   163: ifnull +15 -> 178
    //   166: aload_2
    //   167: invokevirtual 133	java/io/BufferedReader:close	()V
    //   170: goto +8 -> 178
    //   173: astore_2
    //   174: aload_2
    //   175: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   178: goto +5 -> 183
    //   181: aload_1
    //   182: athrow
    //   183: goto -2 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	FunctionModuleConfigManager
    //   0	186	1	paramArrayOfByte	byte[]
    //   15	152	2	localObject1	Object
    //   173	2	2	localIOException1	java.io.IOException
    //   40	117	3	localObject2	Object
    //   2	125	4	localObject3	Object
    //   112	1	5	localIOException2	java.io.IOException
    //   121	22	5	localIOException3	java.io.IOException
    //   12	112	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   93	97	99	java/io/IOException
    //   156	160	99	java/io/IOException
    //   44	49	106	finally
    //   53	82	106	finally
    //   87	91	106	finally
    //   44	49	112	java/io/IOException
    //   53	82	112	java/io/IOException
    //   87	91	112	java/io/IOException
    //   16	41	117	finally
    //   131	137	117	finally
    //   139	150	117	finally
    //   16	41	121	java/io/IOException
    //   166	170	173	java/io/IOException
  }
  
  public static String a(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfLong[i]);
      localStringBuilder.append("&");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp().getSharedPreferences("search_manager_configFunctionModuleConfigManager", 0);
  }
  
  private List<FunctionModuleConfigManager.FunctionItem> b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("search_manager_configFunctionModuleConfigManager", 2, "getFunctionItemList !!! no data,just use local data");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(1, "QQ会员", "https://pub.idqqimg.com/pc/misc/files/20170321/a89cb3ba283040058367d36b0a1f5aad.png", "https://h5.vip.qq.com/p/sonic/mc/vipcenterv5?_bid=193&_wvSb=1&asyncMode=3&_wwv=64&_nav_alpha=true&_wwv=4&pay_src=10&platform=1&type=20001&networkInfo=1&status=-1&number=0&path=100400"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(2, "QQ钱包", "https://pub.idqqimg.com/pc/misc/files/20170310/e3f2c05439d745c6b39505c757468bcc.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(3, HardCodeUtil.a(2131705081), "https://pub.idqqimg.com/pc/misc/files/20170321/f8b7922d137b4174a32408c2a874d439.png", "https://zb.vip.qq.com/sonic/index?_wv=16778243&asyncMode=3&_wwv=68&_nav_txtclr=ffffff&_nav_titleclr=ffffff&btest=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(4, HardCodeUtil.a(2131705066), "https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(5, HardCodeUtil.a(2131705065), "https://pub.idqqimg.com/pc/misc/files/20170310/a601d5f50db940ee9cf8d30e915671ce.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(6, HardCodeUtil.a(2131705083), "https://pub.idqqimg.com/pc/misc/files/20170310/2490d524bbf84417929137e35d93b0c2.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(7, "QQ达人", "https://pub.idqqimg.com/pc/misc/files/20170321/b38bddc6e6a24a1eb5253f6505fb349e.png", "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(8, HardCodeUtil.a(2131705069), "https://pub.idqqimg.com/pc/misc/files/20170310/5765374679c8415894d31ff020f5558a.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(9, "QQ空间", "https://pub.idqqimg.com/pc/misc/files/20170310/5aaef4e89ac540ff9d0e1a4c3f0aee65.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(10, HardCodeUtil.a(2131705068), "https://pub.idqqimg.com/pc/misc/files/20170310/c88ccef2e6d44e3f94357ac7cecd04b4.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(11, HardCodeUtil.a(2131705085), "https://pub.idqqimg.com/pc/misc/files/20170310/c83498c5dfd54489af3147b027c091b0.png", "https://cmshow.qq.com/apollo/html/intro.html?_wv=3&adtag=search"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(12, HardCodeUtil.a(2131705064), "https://pub.idqqimg.com/pc/misc/files/20170310/e8310f3460fa41b487b5922a0df671c5.png", "https://buluo.qq.com/mobile/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&plg_auth=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(13, HardCodeUtil.a(2131705080), "https://pub.idqqimg.com/pc/misc/files/20170310/ee1b6352ec7340bba07949a15b9adc19.png", "https://m.gamecenter.qq.com/directout/index?st=1489458002385&uin=3043939851&status=-1&number=0&path=489&plat=qq&gamecenter=1&_wv=1031&gc_version=2&ADTAG=neisou&_nav_bgclr=18b4ed&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=255&asyncMode=3&_wwv=64"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(14, QQStoryConstant.jdField_a_of_type_JavaLangString, "https://pub.idqqimg.com/pc/misc/files/20170310/6a09f5f91fff46e0ada71ff7b2a667f4.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(15, "QQ看点", "https://sqimg.qq.com/qq_product_operations/kan/images/QQkandian_symbol.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(16, HardCodeUtil.a(2131705092), "https://pub.idqqimg.com/pc/misc/files/20170310/43121a2425204707868e3e271a9969a7.png", "https://wq.jd.com/mcoss/wxmall/home?ptype=4&_wv=67113987&fetchCode=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(17, HardCodeUtil.a(2131705084), "https://pub.idqqimg.com/pc/misc/files/20170310/cd28b2e8ba7f4d9e98a2d244ced31789.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(18, HardCodeUtil.a(2131705079), "https://pub.idqqimg.com/pc/misc/files/20170310/6727610036b648c3bc3aaa4d0c047ec3.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(19, HardCodeUtil.a(2131705073), "https://pub.idqqimg.com/pc/misc/files/20170310/ee8e56925bb646f9b6ae831afcbb0aca.png", "https://y.qq.com/m/mqq/music/index.html?plg_auth=1&plg_dev=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(20, "NOW直播", "https://pub.idqqimg.com/pc/misc/files/20170321/fd790f79230e4776a33c608c9557ae0b.png", "https://now.qq.com/qq/hall.html?_bid=2374&_wv=16778245&from=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(21, HardCodeUtil.a(2131705086), "https://pub.idqqimg.com/pc/misc/files/20170321/5657f0d4fd6f49858d10bca7451d91a8.png", "https://imgcache.qq.com/zzapp/chwl/prev/html/shop.html?max_age=0&_wv=3"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(22, HardCodeUtil.a(2131705088), "https://pub.idqqimg.com/pc/misc/files/20170310/0291fa0854954779a9eeeb9d843f0157.png", "https://tcsh.qq.com/58/html/home.html?_wv=1027&plg_auth=1&plg_dev=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(23, HardCodeUtil.a(2131705070), "https://pub.idqqimg.com/pc/misc/files/20170310/3a4608e81a5e4158a07d92e4ae8a7b7a.png", "https://info.3g.qq.com/g/s?aid=index&g_ut=3&_wv=1&g_f=22580&plg_auth=1&plg_dev=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(24, HardCodeUtil.a(2131705091), "https://pub.idqqimg.com/pc/misc/files/20170310/35fa7f030fe44507a9732f6d034677e3.png", "https://yundong.qq.com/?_wv=2172899&asyncMode=1&crashFrom=40501"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(25, HardCodeUtil.a(2131705076), "https://pub.idqqimg.com/pc/misc/files/20170310/26cee3d3d78a4c7e8be121cce7ce1df5.png", "https://m.ke.qq.com/index.html?_bid=167&_wv=5121"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(26, HardCodeUtil.a(2131705078), "https://pub.idqqimg.com/pc/misc/files/20170321/30e65ca21a2a42529c90a83a46630ce1.png", "https://fudao.qq.com/rn2web/coursebreak.html?_wv=5123&_bid=2356&n_r=1&from=dongtai&plg_auth=1&plg_dev=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(27, HardCodeUtil.a(2131705074), "https://pub.idqqimg.com/pc/misc/files/20170310/f668a11f690c49bc82210b5773e9f27b.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(28, HardCodeUtil.a(2131694380), "https://pub.idqqimg.com/pc/misc/files/20170310/25b9983be4dd4092bf03f6cac00e0095.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(30, HardCodeUtil.a(2131705077), "https://pub.idqqimg.com/pc/misc/files/20170321/831513c842904cdda53780b36110478e.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(31, HardCodeUtil.a(2131705071), "https://pub.idqqimg.com/pc/misc/files/20170310/9f15b7bd262c42b28a285e3e12a49808.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(32, HardCodeUtil.a(2131705075), "https://pub.idqqimg.com/pc/misc/files/20170310/4fedf2b96f4d4acda93fe619d9cb925e.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(33, HardCodeUtil.a(2131705087), "https://pub.idqqimg.com/pc/misc/files/20170321/9cd89480b0284a27a8938318dbc897df.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(35, HardCodeUtil.a(2131719782), "https://pub.idqqimg.com/pc/misc/files/20170310/6f2aad7545014d13a230cb237390b567.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(36, HardCodeUtil.a(2131705089), "https://pub.idqqimg.com/pc/misc/files/20170310/43121a2425204707868e3e271a9969a7.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(37, HardCodeUtil.a(2131691101), "https://pub.idqqimg.com/pc/misc/files/20170310/5cba92c8405749bbb66d13cd2f42c7b5.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(38, HardCodeUtil.a(2131705072), "https://pub.idqqimg.com/pc/misc/files/20170322/3152361128324bfd97776b10c803f73c.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(39, "QQ红包", "https://pub.idqqimg.com/pc/misc/files/20170310/96d80f6c7cef4e3aa8d45237cc301295.png", "https://mqq.tenpay.com/mqq/hongbao/index.shtml?_wv=2098179&_wvNb=D12928&f=17&_vacf=qw&_wvNt=FFFFFF&_wvSb=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(40, "我的其他QQ帐号", "https://pub.idqqimg.com/pc/misc/files/20170510/e74d00a108ba43e8b7e324ad425dc85c.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(41, HardCodeUtil.a(2131705090), "https://pub.idqqimg.com/pc/misc/files/20170510/9a58b5bdda80403cb3a2923d8f96f519.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(43, HardCodeUtil.a(2131716346), "https://pub.idqqimg.com/pc/misc/files/20170510/445bcc0024c24add97831ec6e987d5a8.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(44, HardCodeUtil.a(2131705067), "https://pub.idqqimg.com/pc/misc/files/20170510/439579e680cc45789586480ff897aad2.png", ""));
    return localArrayList;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("search_manager_configFunctionModuleConfigManager", 0).getString("contentUrl", "");
  }
  
  public List<FunctionModuleConfigManager.FunctionItem> a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("search_manager_configFunctionModuleConfigManager", 0).getString("content", "");
    ArrayList localArrayList1 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder("parseServletConfigContent");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1).optJSONArray("functionList");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          int i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            int k = ((JSONObject)localObject2).optInt("fid");
            String str1 = ((JSONObject)localObject2).optString("name");
            String str2 = ((JSONObject)localObject2).optString("headUrl");
            String str3 = ((JSONObject)localObject2).optString("androidJumpUrl");
            localObject2 = ((JSONObject)localObject2).optJSONArray("tag");
            ArrayList localArrayList2 = new ArrayList();
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              j = 0;
              if (j < ((JSONArray)localObject2).length())
              {
                String str4 = ((JSONArray)localObject2).optString(j);
                if (TextUtils.isEmpty(str4)) {
                  break label309;
                }
                localArrayList2.add(str4);
                break label309;
              }
            }
            localArrayList1.add(new FunctionModuleConfigManager.FunctionItem(k, str1, str2, str3, localArrayList2));
            i += 1;
            continue;
            localStringBuilder.append(",configContent null");
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.i("search_manager_configFunctionModuleConfigManager", 1, "parseServletConfigContent", localJSONException);
        return null;
      }
      a(localStringBuilder);
      localStringBuilder.append(",items=");
      localStringBuilder.append(localJSONException.size());
      QLog.i("search_manager_configFunctionModuleConfigManager", 1, localStringBuilder.toString());
      return localJSONException;
      label309:
      j += 1;
    }
  }
  
  public List<ISearchResultModel> a(String paramString, int paramInt)
  {
    Object localObject2 = a();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((List)localObject2).size() != 0) {}
    }
    else
    {
      localObject1 = b();
    }
    Object localObject3 = localObject1;
    Object localObject1 = new ArrayList(localObject3.size() + 1);
    ArrayList localArrayList = new ArrayList(localObject3.size() + 1);
    localObject2 = new ArrayList();
    boolean bool2 = StudyModeManager.a();
    Object localObject6 = localObject3.iterator();
    boolean bool1;
    Object localObject5;
    for (;;)
    {
      localObject4 = this;
      bool1 = ((Iterator)localObject6).hasNext();
      localObject5 = "";
      if (!bool1) {
        break;
      }
      localObject5 = (FunctionModuleConfigManager.FunctionItem)((Iterator)localObject6).next();
      if ((((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int == 28) && (QFileAssistantUtils.a(((FunctionModuleConfigManager)localObject4).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        ((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaLangString = ((FunctionModuleConfigManager)localObject4).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698288);
      }
      int[] arrayOfInt = SearchUtils.a(paramString, ((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaLangString, true);
      if ((arrayOfInt != null) && (arrayOfInt.length >= 3)) {
        if ((arrayOfInt[0] > -1) && ((((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int != 15) || (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab())))
        {
          i = ((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int;
          if (((((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int != 111) || (((ITempMsgBoxManager)((FunctionModuleConfigManager)localObject4).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).msgBoxSwitch())) && ((!bool2) || (!jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int)))))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int);
            ((StringBuilder)localObject4).append("");
            localObject4 = new GroupBaseNetSearchModelItem(paramString, ((StringBuilder)localObject4).toString(), ((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaLangString, ((FunctionModuleConfigManager.FunctionItem)localObject5).b, ((FunctionModuleConfigManager.FunctionItem)localObject5).c, "", 268435456L, null, paramInt);
            ((GroupBaseNetSearchModelItem)localObject4).a(7);
            ((GroupBaseNetSearchModelItem)localObject4).a = arrayOfInt;
            if (((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaLangString.equals(paramString)) {
              localArrayList.add(0, localObject4);
            } else {
              localArrayList.add(localObject4);
            }
          }
        }
      }
    }
    Object localObject4 = localObject3.iterator();
    localObject3 = localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (FunctionModuleConfigManager.FunctionItem)((Iterator)localObject4).next();
      if (((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaUtilList != null) {
        if (((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaUtilList.size() != 0)
        {
          i = 0;
          bool1 = false;
          while (i < ((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaUtilList.size())
          {
            bool1 = paramString.contains((CharSequence)((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaUtilList.get(i));
            if (bool1) {
              break;
            }
            i += 1;
          }
          if ((bool1) && ((((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int != 15) || (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab())))
          {
            if ((((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int == 28) && (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
              ((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698288);
            }
            i = ((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int;
            if ((!bool2) || (!jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int))))
            {
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append(((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_Int);
              ((StringBuilder)localObject6).append(localObject3);
              ((List)localObject2).add(new GroupBaseNetSearchModelItem(paramString, ((StringBuilder)localObject6).toString(), ((FunctionModuleConfigManager.FunctionItem)localObject5).jdField_a_of_type_JavaLangString, ((FunctionModuleConfigManager.FunctionItem)localObject5).b, ((FunctionModuleConfigManager.FunctionItem)localObject5).c, "", 268435456L, null, paramInt));
            }
          }
        }
      }
    }
    Collections.sort(localArrayList, new FunctionModuleConfigManager.1(this));
    Collections.sort((List)localObject2, new FunctionModuleConfigManager.2(this));
    ((List)localObject1).addAll(localArrayList);
    ((List)localObject1).addAll((Collection)localObject2);
    int i = ((List)localObject1).size();
    paramInt = 0;
    while (paramInt < i)
    {
      SearchViewUtils.a((ISearchResultModel)((List)localObject1).get(paramInt), i, paramInt);
      paramInt += 1;
    }
    return localObject1;
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("search_manager_configFunctionModuleConfigManager", 0);
    localSharedPreferences.edit().putString("content", paramString);
    localSharedPreferences.edit().commit();
  }
  
  public void a(StringBuilder paramStringBuilder)
  {
    Object localObject = (SearchFunctionModuleBean)QConfigManager.a().a(190);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((SearchFunctionModuleBean)localObject).jdField_a_of_type_JavaLangString;
    }
    String str = a();
    paramStringBuilder.append(",netFunctionUrl=");
    paramStringBuilder.append((String)localObject);
    paramStringBuilder.append(",localContentUrl=");
    paramStringBuilder.append(str);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (((String)localObject).equals(str)) {
      return;
    }
    b((String)localObject);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("search_manager_configFunctionModuleConfigManager", 1, "getFunctionListFile fileUrl isEmpty");
      return;
    }
    if (paramString.equals(a()))
    {
      QLog.i("search_manager_configFunctionModuleConfigManager", 1, "getFunctionListFile equals");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFunctionListFile fileUrl = ");
    localStringBuilder.append(paramString);
    QLog.i("search_manager_configFunctionModuleConfigManager", 1, localStringBuilder.toString());
    ThreadManager.post(new FunctionModuleConfigManager.3(this, paramString), 8, null, false);
  }
  
  public void c(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("search_manager_configFunctionModuleConfigManager", 0);
    localSharedPreferences.edit().putString("contentUrl", paramString);
    localSharedPreferences.edit().commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.FunctionModuleConfigManager
 * JD-Core Version:    0.7.0.1
 */