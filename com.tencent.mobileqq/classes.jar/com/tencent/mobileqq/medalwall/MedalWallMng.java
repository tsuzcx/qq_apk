package com.tencent.mobileqq.medalwall;

import SummaryCard.TMedalWallInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;
import org.json.JSONObject;

public class MedalWallMng
  implements Handler.Callback, Manager
{
  public static int a;
  protected static final String a;
  public static int b;
  protected static final String b;
  public static int c;
  public static int d;
  public static int e;
  public static int f = 6;
  public static int g = 7;
  protected final SparseArray a;
  protected QQAppInterface a;
  protected final WeakReferenceHandler a;
  protected final ArrayList a;
  protected boolean a;
  private boolean b;
  private String c;
  private String d;
  private String e;
  protected int h;
  protected int i;
  private int j = -2147483648;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "tencent/MobileQQ/medal/";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    jdField_e_of_type_Int = 5;
  }
  
  public MedalWallMng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.h = 0;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.startsWith("http://")) {
      return paramString;
    }
    return "http://" + paramString;
  }
  
  public static JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject("{\"v\":\"4.12.3\",\"fr\":50,\"ip\":0,\"op\":35,\"w\":96,\"h\":96,\"nm\":\"xunzhang\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"star\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":2,\"s\":[0],\"e\":[100]},{\"t\":18}],\"ix\":11},\"r\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":18,\"s\":[-60],\"e\":[0]},{\"t\":32}],\"ix\":10},\"p\":{\"a\":0,\"k\":[48.011,46.251,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[278.612,-211.249,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.586,0.586,0.586],\"y\":[0.781,0.781,-13.254]},\"o\":{\"x\":[0.242,0.242,0.242],\"y\":[0.177,0.177,5.117]},\"n\":[\"0p586_0p781_0p242_0p177\",\"0p586_0p781_0p242_0p177\",\"0p586_-13p254_0p242_5p117\"],\"t\":14,\"s\":[0,0,100],\"e\":[58.002,58.002,100]},{\"i\":{\"x\":[0.704,0.704,0.704],\"y\":[1,1,1]},\"o\":{\"x\":[0.279,0.279,0.279],\"y\":[0.208,0.208,33.595]},\"n\":[\"0p704_1_0p279_0p208\",\"0p704_1_0p279_0p208\",\"0p704_1_0p279_33p595\"],\"t\":18,\"s\":[58.002,58.002,100],\"e\":[202,202,100]},{\"t\":32}],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ty\":\"sr\",\"sy\":1,\"d\":1,\"pt\":{\"a\":0,\"k\":5,\"ix\":3},\"p\":{\"a\":0,\"k\":[0,0],\"ix\":4},\"r\":{\"a\":0,\"k\":0,\"ix\":5},\"ir\":{\"a\":0,\"k\":5.37,\"ix\":6},\"is\":{\"a\":0,\"k\":0,\"ix\":8},\"or\":{\"a\":0,\"k\":10.74,\"ix\":7},\"os\":{\"a\":0,\"k\":0,\"ix\":9},\"ix\":1,\"nm\":\"多边星形路径 1\",\"mn\":\"ADBE Vector Shape - Star\",\"hd\":false},{\"ty\":\"rd\",\"nm\":\"圆角 1\",\"r\":{\"a\":0,\"k\":1.5,\"ix\":1},\"ix\":2,\"mn\":\"ADBE Vector Filter - RC\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.701960784314,0.003921568627,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[278.612,-210.348],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"多边星形 1\",\"np\":4,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":500,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":2,\"ty\":4,\"nm\":\"farme\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":6,\"s\":[-90],\"e\":[0]},{\"t\":32}],\"ix\":10},\"p\":{\"a\":0,\"k\":[48,48,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[30,30,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.63,0.63,0.695],\"y\":[1,1,1]},\"o\":{\"x\":[0.191,0.191,0.172],\"y\":[0.165,0.165,0.074]},\"n\":[\"0p63_1_0p191_0p165\",\"0p63_1_0p191_0p165\",\"0p695_1_0p172_0p074\"],\"t\":0,\"s\":[0,0,100],\"e\":[202,202,100]},{\"t\":32}],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[1.909,1.093],[0,0],[1.902,-1.106],[0,0],[-0.008,-2.199],[0,0],[-1.908,-1.094],[0,0],[-1.901,1.107],[0,0],[0.007,2.2]],\"o\":[[-0.008,-2.2],[0,0],[-1.909,-1.093],[0,0],[-1.902,1.106],[0,0],[0.007,2.2],[0,0],[1.909,1.093],[0,0],[1.901,-1.107],[0,0]],\"v\":[[24.43,-10.21],[20.945,-16.197],[3.373,-26.262],[-3.555,-26.238],[-21.056,-16.051],[-24.499,-10.04],[-24.429,10.21],[-20.945,16.198],[-3.373,26.262],[3.555,26.238],[21.057,16.053],[24.5,10.04]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.701960802078,0.003921568859,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[46],\"e\":[22]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":9,\"s\":[22],\"e\":[9.625]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":18,\"s\":[9.625],\"e\":[5]},{\"t\":32}],\"ix\":5},\"lc\":2,\"lj\":2,\"nm\":\"描边 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[30.114,29.635],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[73.057,73.057],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 3\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":500,\"st\":0,\"bm\":0}]}");
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static void a(MedalInfo paramMedalInfo, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalInfo[");
    paramStringBuilder.append("iId: ").append(paramMedalInfo.iId).append(",");
    paramStringBuilder.append("iType: ").append(paramMedalInfo.iType).append(",");
    paramStringBuilder.append("iLevel: ").append(paramMedalInfo.iLevel).append(",");
    paramStringBuilder.append("iLevelCount: ").append(paramMedalInfo.iLevelCount).append(",");
    paramStringBuilder.append("lEndTime: ").append(paramMedalInfo.lEndTime).append(",");
    paramStringBuilder.append("iUnreadLevel1: ").append(paramMedalInfo.iUnreadLevel1).append(",");
    paramStringBuilder.append("iUnreadLevel2: ").append(paramMedalInfo.iUnreadLevel2).append(",");
    paramStringBuilder.append("iUnreadLevel3: ").append(paramMedalInfo.iUnreadLevel3).append(",");
    paramStringBuilder.append("iNoProgress: ").append(paramMedalInfo.iNoProgress).append(",");
    paramStringBuilder.append("strName: ").append(paramMedalInfo.strName);
    paramStringBuilder.append("] ");
  }
  
  public static void a(MedalID paramMedalID, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalID[");
    paramStringBuilder.append("id: ").append(paramMedalID.jdField_a_of_type_Int).append(",");
    paramStringBuilder.append("level: ").append(paramMedalID.jdField_b_of_type_Int);
    paramStringBuilder.append("] ");
  }
  
  private void a(MedalWallMng.NeedGuideMedal paramNeedGuideMedal)
  {
    if ((paramNeedGuideMedal == null) || (paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo == null)) {}
    while (!FileUtils.b(paramNeedGuideMedal.jdField_b_of_type_JavaLangString)) {
      return;
    }
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int k = localResources.getDimensionPixelSize(2131559459);
    localURLDrawableOptions.mRequestWidth = k;
    localURLDrawableOptions.mRequestHeight = k;
    URLDrawable.getDrawable(new File(paramNeedGuideMedal.jdField_b_of_type_JavaLangString), localURLDrawableOptions).startDownload(true);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCheckResFlag value: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4);
    if (((SharedPreferences)localObject).getInt("MEDAL_CHECK_RES_STATE", 0) != paramInt) {
      ((SharedPreferences)localObject).edit().putInt("MEDAL_CHECK_RES_STATE", paramInt).apply();
    }
  }
  
  private boolean b()
  {
    boolean bool;
    if (SharedPreUtils.al(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != 1)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    while ((((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).medalSwitchDisable) || (Utils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      return true;
      bool = false;
      break;
    }
    return false;
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        if (!QLog.isColorLevel()) {
          break label224;
        }
        StringBuilder localStringBuilder = new StringBuilder(200);
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(MedalInfo.class);
        if ((localObject4 != null) && (((List)localObject4).size() > 0)) {
          synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.clear();
            localObject4 = ((List)localObject4).iterator();
            if (((Iterator)localObject4).hasNext())
            {
              MedalInfo localMedalInfo = (MedalInfo)((Iterator)localObject4).next();
              if (localMedalInfo == null) {
                continue;
              }
              this.jdField_a_of_type_AndroidUtilSparseArray.put(localMedalInfo.iId, localMedalInfo);
              if ((!QLog.isColorLevel()) || (localStringBuilder == null)) {
                continue;
              }
              a(localMedalInfo, localStringBuilder);
              localStringBuilder.append("\r\n");
            }
          }
        }
      }
      finally {}
      this.jdField_a_of_type_Boolean = true;
      if ((QLog.isColorLevel()) && (localObject2 != null))
      {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "init size: %d \r\n{%s}", new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.size()), localObject2.toString() }));
        continue;
        label224:
        Object localObject3 = null;
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckMedalRes checkedCount: %d", new Object[] { Integer.valueOf(this.h) }));
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.h <= 0) {
        break label191;
      }
      k = this.h - 1;
      break label179;
      if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        MedalWallMng.NeedGuideMedal localNeedGuideMedal1 = (MedalWallMng.NeedGuideMedal)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if ((localNeedGuideMedal1 == null) || (localNeedGuideMedal1.jdField_a_of_type_Boolean))
        {
          this.h = (k + 1);
        }
        else if (localNeedGuideMedal1.a())
        {
          this.h = (k + 1);
          a(localNeedGuideMedal1);
        }
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        ThreadManager.post(new MedalWallMng.DownloadResTask(this, localNeedGuideMedal2), 5, null, false);
        return;
      }
      if (this.i > 0)
      {
        b(2);
        return;
      }
      b(1);
      return;
    }
    for (;;)
    {
      label179:
      Object localObject = null;
      break;
      k += 1;
      break;
      label191:
      k = 0;
    }
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "doCheckForLogin");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    Object localObject = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    boolean bool;
    int k;
    if (((LocalRedTouchManager)localObject).a(((LocalRedTouchManager)localObject).a(10015), false))
    {
      bool = true;
      if (!bool) {
        break label169;
      }
      localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
      k = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4).getInt("MEDAL_CHECK_RES_STATE", 0);
      if (k != 2) {
        break label162;
      }
      b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckForLogin hasRP: %s, flag: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(k) }));
      }
      return;
      bool = false;
      break;
      label162:
      c();
      continue;
      label169:
      b(0);
      k = 0;
    }
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    this.jdField_c_of_type_JavaLangString = localSharedPreferences.getString("hostUrl", "");
    this.jdField_d_of_type_JavaLangString = localSharedPreferences.getString("guestUrl", "");
    this.jdField_e_of_type_JavaLangString = localSharedPreferences.getString("shareUrl", "");
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,local hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString }));
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    }
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    }
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = "https://ti.qq.com/qqmedal2/share.html?_wv=16777217&_wwv=4&_bid=2450";
    }
  }
  
  public Card a(TMedalWallInfo paramTMedalWallInfo, boolean paramBoolean)
  {
    int m = 0;
    int k = 0;
    Object localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
    int i3 = 0;
    for (;;)
    {
      Object localObject2;
      int i2;
      int i1;
      try
      {
        if (i3 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
        {
          localObject2 = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i3);
          if (localObject2 == null) {
            break label529;
          }
          if (((MedalInfo)localObject2).iLevel == 255)
          {
            i2 = k;
            i1 = m;
            if (((MedalInfo)localObject2).iUnreadLevel1 != 1) {
              break label522;
            }
            m += 1;
            break label529;
          }
          i2 = k;
          i1 = m;
          if (((MedalInfo)localObject2).iLevelCount <= 1) {
            break label522;
          }
          int n = m;
          if (((MedalInfo)localObject2).iLevel >= 1)
          {
            n = m;
            if (((MedalInfo)localObject2).iUnreadLevel1 == 1) {
              n = m + 1;
            }
          }
          m = k;
          if (((MedalInfo)localObject2).iLevel >= 2)
          {
            m = k;
            if (((MedalInfo)localObject2).iUnreadLevel2 == 1) {
              m = k + 1;
            }
          }
          i2 = m;
          i1 = n;
          if (((MedalInfo)localObject2).iLevel < 3) {
            break label522;
          }
          i2 = m;
          i1 = n;
          if (((MedalInfo)localObject2).iUnreadLevel3 != 1) {
            break label522;
          }
          k = m + 1;
          m = n;
          break label529;
        }
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject2 = ((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramTMedalWallInfo != null)
        {
          ((Card)localObject2).iMedalCount = paramTMedalWallInfo.iMedalCount;
          if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo needCheck: %s, compute[iNewCount: %d, iUpgradeCount: %d] server[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(paramTMedalWallInfo.iNewCount), Integer.valueOf(paramTMedalWallInfo.iUpgradeCount), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
          }
          if ((paramBoolean) && ((paramTMedalWallInfo.iNewCount > m) || (paramTMedalWallInfo.iUpgradeCount > k)))
          {
            paramTMedalWallInfo.iNewCount = Math.min(paramTMedalWallInfo.iNewCount, m);
            paramTMedalWallInfo.iUpgradeCount = Math.min(paramTMedalWallInfo.iUpgradeCount, k);
          }
          ((Card)localObject2).iNewCount = paramTMedalWallInfo.iNewCount;
          ((Card)localObject2).iUpgradeCount = paramTMedalWallInfo.iUpgradeCount;
          ((FriendsManager)localObject1).a((Card)localObject2);
          return localObject2;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo compute[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
      }
      ((Card)localObject2).iNewCount = Math.min(((Card)localObject2).iNewCount, m);
      ((Card)localObject2).iUpgradeCount = Math.min(((Card)localObject2).iUpgradeCount, k);
      continue;
      label522:
      k = i2;
      m = i1;
      label529:
      i3 += 1;
    }
  }
  
  public MedalInfo a(int paramInt)
  {
    d();
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      MedalInfo localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localMedalInfo;
      if (localMedalInfo == null)
      {
        ??? = new MedalInfo();
        ((MedalInfo)???).iId = paramInt;
        ((MedalInfo)???).iLevel = 0;
        ((MedalInfo)???).iUnreadLevel1 = 0;
        ((MedalInfo)???).iUnreadLevel2 = 0;
        ((MedalInfo)???).iUnreadLevel3 = 0;
      }
      return ???;
    }
  }
  
  public String a()
  {
    if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null)) {
      g();
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public String a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null)) {
      g();
    }
    StringBuilder localStringBuilder;
    if (!paramBoolean)
    {
      localStringBuilder = new StringBuilder(this.jdField_d_of_type_JavaLangString);
      localStringBuilder.append("&tuin=").append(NearbyURLSafeUtil.a(paramString));
    }
    for (paramString = localStringBuilder;; paramString = new StringBuilder(this.jdField_c_of_type_JavaLangString))
    {
      paramString.append("&from=").append(paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "getMedalWallUrl url: %s", new Object[] { paramString }));
      }
      return paramString.toString();
    }
  }
  
  public ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    Object localObject;
    try
    {
      paramString = paramString.replaceAll("new_medals=", "").replaceAll("update_medals=", "").replaceAll("&", ",").split(",");
      k = 0;
      if (k >= paramString.length) {
        break label137;
      }
      if ((paramString[k] == null) || (paramString[k].isEmpty())) {
        break label339;
      }
      localObject = paramString[k].split("_");
      if (localObject.length != 3) {
        break label339;
      }
      localArrayList.add(new MedalID(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1])));
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "summarycard", paramString);
      }
    }
    label134:
    return localArrayList;
    label137:
    int m = localArrayList.size() - 1;
    label145:
    if (m >= 0)
    {
      paramString = (MedalID)localArrayList.get(m);
      localObject = a(paramString.jdField_a_of_type_Int);
      switch (paramString.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (k != 0)
      {
        localArrayList.remove(m);
        if (QLog.isColorLevel())
        {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "parsePromptParams local read [id: %d , level: %d]", new Object[] { Integer.valueOf(paramString.jdField_a_of_type_Int), Integer.valueOf(paramString.jdField_b_of_type_Int) }));
          break label351;
          if (((MedalInfo)localObject).iUnreadLevel1 != 2) {
            break label358;
          }
          k = 1;
          continue;
          if (((MedalInfo)localObject).iUnreadLevel2 != 2) {
            break label363;
          }
          k = 1;
          continue;
          if (((MedalInfo)localObject).iUnreadLevel3 != 2) {
            break label368;
          }
          k = 1;
          continue;
          k = ((MedalInfo)localObject).iUnreadLevel1;
          if (k == 2)
          {
            k = 1;
            continue;
          }
          k = 0;
          continue;
          label339:
          k += 1;
          break;
          k = 0;
          continue;
        }
      }
      label351:
      m -= 1;
      break label145;
      break label134;
      label358:
      k = 0;
      continue;
      label363:
      k = 0;
      continue;
      label368:
      k = 0;
    }
  }
  
  public void a()
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkForLogin medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!b()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "checkForLogin medal is off!");
    return;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(3, 1000L);
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetMedalStrongReminderConfig value: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  /* Error */
  public void a(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 82	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 366	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 372	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 7
    //   15: new 91	java/util/ArrayList
    //   18: dup
    //   19: iconst_5
    //   20: invokespecial 610	java/util/ArrayList:<init>	(I)V
    //   23: astore 6
    //   25: iload_1
    //   26: iconst_2
    //   27: if_icmpne +310 -> 337
    //   30: aload_0
    //   31: getfield 89	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   34: astore 8
    //   36: aload 8
    //   38: monitorenter
    //   39: iconst_0
    //   40: istore_3
    //   41: iload_3
    //   42: aload_0
    //   43: getfield 89	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   46: invokevirtual 410	android/util/SparseArray:size	()I
    //   49: if_icmpge +266 -> 315
    //   52: aload_0
    //   53: getfield 89	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   56: iload_3
    //   57: invokevirtual 503	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   60: checkcast 144	com/tencent/mobileqq/data/MedalInfo
    //   63: astore 9
    //   65: aload 9
    //   67: aload 6
    //   69: invokevirtual 614	com/tencent/mobileqq/data/MedalInfo:putReportInfo	(Ljava/util/ArrayList;)V
    //   72: aload 9
    //   74: invokevirtual 617	com/tencent/mobileqq/data/MedalInfo:setRead	()V
    //   77: aload 9
    //   79: invokevirtual 620	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   82: sipush 1000
    //   85: if_icmpne +13 -> 98
    //   88: aload 7
    //   90: aload 9
    //   92: invokevirtual 623	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   95: goto +470 -> 565
    //   98: aload 9
    //   100: invokevirtual 620	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   103: sipush 1001
    //   106: if_icmpeq +14 -> 120
    //   109: aload 9
    //   111: invokevirtual 620	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   114: sipush 1002
    //   117: if_icmpne +448 -> 565
    //   120: aload 7
    //   122: aload 9
    //   124: invokevirtual 626	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   127: pop
    //   128: goto +437 -> 565
    //   131: astore_2
    //   132: aload 8
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: iconst_0
    //   139: istore_3
    //   140: aload_2
    //   141: invokevirtual 627	java/lang/Throwable:printStackTrace	()V
    //   144: iload_1
    //   145: ifne +321 -> 466
    //   148: aload_0
    //   149: aconst_null
    //   150: iconst_1
    //   151: invokevirtual 629	com/tencent/mobileqq/medalwall/MedalWallMng:a	(LSummaryCard/TMedalWallInfo;Z)Lcom/tencent/mobileqq/data/Card;
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 82	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   159: sipush 159
    //   162: invokevirtual 346	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   165: checkcast 445	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager
    //   168: astore 7
    //   170: iload_1
    //   171: iconst_1
    //   172: if_icmpeq +8 -> 180
    //   175: iload_1
    //   176: iconst_2
    //   177: if_icmpne +336 -> 513
    //   180: aload 7
    //   182: sipush 10015
    //   185: invokevirtual 631	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(I)V
    //   188: aload 7
    //   190: sipush 10016
    //   193: invokevirtual 631	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(I)V
    //   196: aload 6
    //   198: invokevirtual 632	java/util/ArrayList:isEmpty	()Z
    //   201: ifne +19 -> 220
    //   204: aload_0
    //   205: getfield 82	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   208: iconst_2
    //   209: invokevirtual 635	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   212: checkcast 637	com/tencent/mobileqq/app/CardHandler
    //   215: aload 6
    //   217: invokevirtual 639	com/tencent/mobileqq/app/CardHandler:b	(Ljava/util/ArrayList;)V
    //   220: aload_2
    //   221: ifnull +17 -> 238
    //   224: aload_2
    //   225: getfield 518	com/tencent/mobileqq/data/Card:iNewCount	I
    //   228: ifne +15 -> 243
    //   231: aload_2
    //   232: getfield 519	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   235: ifne +8 -> 243
    //   238: aload_0
    //   239: iconst_0
    //   240: invokespecial 435	com/tencent/mobileqq/medalwall/MedalWallMng:b	(I)V
    //   243: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +68 -> 314
    //   249: invokestatic 279	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   252: astore 6
    //   254: aload_2
    //   255: ifnonnull +287 -> 542
    //   258: iconst_0
    //   259: istore 4
    //   261: aload_2
    //   262: ifnonnull +289 -> 551
    //   265: ldc_w 273
    //   268: iconst_2
    //   269: aload 6
    //   271: ldc_w 641
    //   274: iconst_4
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: iload_1
    //   281: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   284: aastore
    //   285: dup
    //   286: iconst_1
    //   287: iload_3
    //   288: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: aastore
    //   292: dup
    //   293: iconst_2
    //   294: iload 4
    //   296: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: aastore
    //   300: dup
    //   301: iconst_3
    //   302: iload 5
    //   304: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: aastore
    //   308: invokestatic 291	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   311: invokestatic 294	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: return
    //   315: aload 8
    //   317: monitorexit
    //   318: aload_0
    //   319: getfield 94	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   322: astore 8
    //   324: aload 8
    //   326: monitorenter
    //   327: aload_0
    //   328: getfield 94	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   331: invokevirtual 642	java/util/ArrayList:clear	()V
    //   334: aload 8
    //   336: monitorexit
    //   337: aload_2
    //   338: instanceof 217
    //   341: ifeq +219 -> 560
    //   344: aload_2
    //   345: checkcast 217	com/tencent/mobileqq/medalwall/MedalWallMng$NeedGuideMedal
    //   348: astore_2
    //   349: aload_2
    //   350: getfield 220	com/tencent/mobileqq/medalwall/MedalWallMng$NeedGuideMedal:jdField_a_of_type_ComTencentMobileqqDataMedalInfo	Lcom/tencent/mobileqq/data/MedalInfo;
    //   353: getfield 147	com/tencent/mobileqq/data/MedalInfo:iId	I
    //   356: istore_3
    //   357: aload_2
    //   358: getfield 220	com/tencent/mobileqq/medalwall/MedalWallMng$NeedGuideMedal:jdField_a_of_type_ComTencentMobileqqDataMedalInfo	Lcom/tencent/mobileqq/data/MedalInfo;
    //   361: astore 8
    //   363: aload 8
    //   365: aload 6
    //   367: invokevirtual 614	com/tencent/mobileqq/data/MedalInfo:putReportInfo	(Ljava/util/ArrayList;)V
    //   370: aload 8
    //   372: invokevirtual 617	com/tencent/mobileqq/data/MedalInfo:setRead	()V
    //   375: aload 8
    //   377: invokevirtual 620	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   380: sipush 1000
    //   383: if_icmpne +40 -> 423
    //   386: aload 7
    //   388: aload 8
    //   390: invokevirtual 623	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   393: aload_0
    //   394: getfield 94	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   397: astore 7
    //   399: aload 7
    //   401: monitorenter
    //   402: aload_0
    //   403: getfield 94	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   406: aload_2
    //   407: invokevirtual 644	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   410: pop
    //   411: aload 7
    //   413: monitorexit
    //   414: goto -270 -> 144
    //   417: astore_2
    //   418: aload 8
    //   420: monitorexit
    //   421: aload_2
    //   422: athrow
    //   423: aload 8
    //   425: invokevirtual 620	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   428: sipush 1001
    //   431: if_icmpeq +14 -> 445
    //   434: aload 8
    //   436: invokevirtual 620	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   439: sipush 1002
    //   442: if_icmpne -49 -> 393
    //   445: aload 7
    //   447: aload 8
    //   449: invokevirtual 626	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   452: pop
    //   453: goto -60 -> 393
    //   456: astore_2
    //   457: goto -317 -> 140
    //   460: astore_2
    //   461: aload 7
    //   463: monitorexit
    //   464: aload_2
    //   465: athrow
    //   466: aload_0
    //   467: getfield 82	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   470: bipush 50
    //   472: invokevirtual 346	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   475: checkcast 348	com/tencent/mobileqq/app/FriendsManager
    //   478: astore 7
    //   480: aload 7
    //   482: aload_0
    //   483: getfield 82	com/tencent/mobileqq/medalwall/MedalWallMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   486: invokevirtual 334	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   489: invokevirtual 351	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   492: astore_2
    //   493: aload_2
    //   494: iconst_0
    //   495: putfield 519	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   498: aload_2
    //   499: iconst_0
    //   500: putfield 518	com/tencent/mobileqq/data/Card:iNewCount	I
    //   503: aload 7
    //   505: aload_2
    //   506: invokevirtual 530	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   509: pop
    //   510: goto -355 -> 155
    //   513: aload_2
    //   514: ifnull +17 -> 531
    //   517: aload_2
    //   518: getfield 518	com/tencent/mobileqq/data/Card:iNewCount	I
    //   521: ifne -325 -> 196
    //   524: aload_2
    //   525: getfield 519	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   528: ifne -332 -> 196
    //   531: aload 7
    //   533: sipush 10015
    //   536: invokevirtual 631	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(I)V
    //   539: goto -343 -> 196
    //   542: aload_2
    //   543: getfield 518	com/tencent/mobileqq/data/Card:iNewCount	I
    //   546: istore 4
    //   548: goto -287 -> 261
    //   551: aload_2
    //   552: getfield 519	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   555: istore 5
    //   557: goto -292 -> 265
    //   560: iconst_0
    //   561: istore_3
    //   562: goto -148 -> 414
    //   565: iload_3
    //   566: iconst_1
    //   567: iadd
    //   568: istore_3
    //   569: goto -528 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	MedalWallMng
    //   0	572	1	paramInt	int
    //   0	572	2	paramObject	Object
    //   40	529	3	k	int
    //   259	288	4	m	int
    //   1	555	5	n	int
    //   23	343	6	localObject1	Object
    //   34	414	8	localObject3	Object
    //   63	60	9	localMedalInfo	MedalInfo
    // Exception table:
    //   from	to	target	type
    //   41	95	131	finally
    //   98	120	131	finally
    //   120	128	131	finally
    //   132	135	131	finally
    //   315	318	131	finally
    //   30	39	137	java/lang/Throwable
    //   135	137	137	java/lang/Throwable
    //   318	327	137	java/lang/Throwable
    //   337	357	137	java/lang/Throwable
    //   421	423	137	java/lang/Throwable
    //   327	337	417	finally
    //   418	421	417	finally
    //   357	393	456	java/lang/Throwable
    //   393	402	456	java/lang/Throwable
    //   423	445	456	java/lang/Throwable
    //   445	453	456	java/lang/Throwable
    //   464	466	456	java/lang/Throwable
    //   402	414	460	finally
    //   461	464	460	finally
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { paramString1, paramString2, paramString3 }));
    }
    if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null)) {
      g();
    }
    if ((Utils.a(paramString1, this.jdField_c_of_type_JavaLangString)) && (Utils.a(paramString2, this.jdField_d_of_type_JavaLangString)) && (Utils.a(paramString3, this.jdField_e_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 4, "onGetConfig, no change return.");
      }
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putString("hostUrl", paramString1);
    localEditor.putString("guestUrl", paramString2);
    localEditor.putString("shareUrl", paramString3);
    localEditor.commit();
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString3;
    if (paramInt != 1) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, "insertFriendMedalNewsMsg " + paramString2);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, new int[] { -2062 });
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, new int[] { -2060 });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForPLNews)))
          {
            MessageForPLNews localMessageForPLNews = (MessageForPLNews)localMessageRecord;
            if (localMessageForPLNews.ts > paramLong) {
              if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, "insertFriendMedalNewsMsg find newer plNews:" + localMessageForPLNews.ts + " " + paramLong);
              }
            }
          }
        }
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      break;
      localObject = MessageRecordFactory.a(-2062);
      paramLong = MessageCache.a();
      ((MessageRecord)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramString2, paramString1, paramLong, -2062, 0, paramLong);
      ((MessageRecord)localObject).isread = true;
    } while (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
  }
  
  public void a(boolean paramBoolean, TMedalWallInfo paramTMedalWallInfo, SparseArray paramSparseArray)
  {
    d();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(200);
      ((StringBuilder)???).append("onGetSelfNewObtainedMedaInfo isSuc:").append(paramBoolean);
      if (paramTMedalWallInfo != null) {
        ((StringBuilder)???).append(", iMedalCount:").append(paramTMedalWallInfo.iMedalCount).append(", iNewCount:").append(paramTMedalWallInfo.iNewCount).append(", iUpgradeCount:").append(paramTMedalWallInfo.iUpgradeCount);
      }
      if (paramSparseArray != null)
      {
        ((StringBuilder)???).append(", medalInfoArrayList: ").append(paramSparseArray.size());
        k = 0;
        if (k < paramSparseArray.size())
        {
          localObject2 = (MedalInfo)paramSparseArray.valueAt(k);
          if (localObject2 == null) {}
          for (;;)
          {
            k += 1;
            break;
            ((StringBuilder)???).append("\r\n info [id: ").append(((MedalInfo)localObject2).iId).append(", iLevel: ").append(((MedalInfo)localObject2).iLevel).append(", name: ").append(((MedalInfo)localObject2).strName).append(", res: ").append(((MedalInfo)localObject2).strResJson).append("]");
          }
        }
      }
      QLog.i("MedalWallMng", 2, ((StringBuilder)???).toString());
    }
    if (!paramBoolean)
    {
      b(2);
      c();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject3 = this.jdField_a_of_type_AndroidUtilSparseArray;
    int k = 0;
    for (;;)
    {
      MedalInfo localMedalInfo;
      try
      {
        if (k >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
          break label448;
        }
        localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
        if (localMedalInfo == null) {
          break label593;
        }
        if (paramSparseArray != null)
        {
          ??? = (MedalInfo)paramSparseArray.get(localMedalInfo.iId);
          if ((??? != null) || (!localMedalInfo.isUnread())) {
            break label593;
          }
          localMedalInfo.setRead();
          if (localMedalInfo.getStatus() != 1000) {
            break label415;
          }
          ((EntityManager)localObject2).b(localMedalInfo);
          if (!QLog.isColorLevel()) {
            break label593;
          }
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetSelfNewObtainedMedaInfo just local is unread [id: %d, level: %d, name: %s]", new Object[] { Integer.valueOf(localMedalInfo.iId), Integer.valueOf(localMedalInfo.iLevel), localMedalInfo.strName }));
        }
      }
      finally {}
      ??? = null;
      continue;
      label415:
      if ((localMedalInfo.getStatus() == 1001) || (localMedalInfo.getStatus() == 1002))
      {
        ((EntityManager)localObject2).a(localMedalInfo);
        continue;
        label448:
        k = 0;
        while ((paramSparseArray != null) && (k < paramSparseArray.size()))
        {
          localObject3 = (MedalInfo)paramSparseArray.valueAt(k);
          if (localObject3 == null)
          {
            k += 1;
          }
          else
          {
            if (((MedalInfo)localObject3).getStatus() == 1000) {
              ((EntityManager)localObject2).b((Entity)localObject3);
            }
            for (;;)
            {
              synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
              {
                this.jdField_a_of_type_AndroidUtilSparseArray.put(((MedalInfo)localObject3).iId, localObject3);
              }
              if ((((MedalInfo)localObject3).getStatus() == 1001) || (((MedalInfo)localObject3).getStatus() == 1002)) {
                ((EntityManager)localObject2).a((Entity)localObject3);
              }
            }
          }
        }
        a(paramTMedalWallInfo, true);
        b(0);
        break;
        label593:
        k += 1;
      }
    }
  }
  
  public boolean a()
  {
    if (this.j == -2147483648)
    {
      this.j = SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 3);
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "isMedalStrongReminderOff value: %s", new Object[] { Integer.valueOf(this.j) }));
      }
    }
    return this.j == 1;
  }
  
  public boolean a(BaseActivity paramBaseActivity, View paramView, int paramInt, Object paramObject)
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkShowMedalGuide medal strong reminder is off!");
      }
    }
    for (;;)
    {
      return false;
      if (this.jdField_b_of_type_Boolean)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkShowMedalGuide isMedalConfigOff: %s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
        return false;
      }
      Object localObject1 = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      if (((LocalRedTouchManager)localObject1).a(((LocalRedTouchManager)localObject1).a(10015), false)) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label134;
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no red point");
        return false;
      }
      label134:
      Object localObject3 = null;
      localObject1 = null;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = localObject1;
          MedalWallMng.NeedGuideMedal localNeedGuideMedal = (MedalWallMng.NeedGuideMedal)localIterator.next();
          if (localNeedGuideMedal != null)
          {
            localObject3 = localObject1;
            if (localNeedGuideMedal.jdField_b_of_type_Boolean) {
              break label645;
            }
            localObject3 = localObject1;
            if (!localNeedGuideMedal.jdField_a_of_type_Boolean) {
              break label645;
            }
            localObject3 = localObject1;
            if (TextUtils.isEmpty(localNeedGuideMedal.jdField_a_of_type_JavaLangString)) {
              break label645;
            }
            localObject3 = localObject1;
            if (TextUtils.isEmpty(localNeedGuideMedal.jdField_b_of_type_JavaLangString)) {
              break label645;
            }
            localObject3 = localObject1;
            if (localNeedGuideMedal.jdField_a_of_type_Int == 2) {
              break label645;
            }
            localObject3 = localObject1;
            if (localNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo == null) {
              break label645;
            }
            localObject3 = localNeedGuideMedal;
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              boolean bool = localNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.isNewer(((MedalWallMng.NeedGuideMedal)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo);
              if (!bool) {
                break label645;
              }
              localObject3 = localNeedGuideMedal;
            }
            localObject1 = localObject3;
          }
        }
        if ((localObject1 != null) && (((MedalWallMng.NeedGuideMedal)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null))
        {
          ((MedalWallMng.NeedGuideMedal)localObject1).jdField_b_of_type_Boolean = true;
          localObject3 = ((MedalWallMng.NeedGuideMedal)localObject1).jdField_a_of_type_ComTencentMobileqqDataMedalInfo;
          if ((paramObject instanceof Card))
          {
            paramObject = (Card)paramObject;
            if (((MedalInfo)localObject3).iLevel == 255)
            {
              if (((MedalInfo)localObject3).iUnreadLevel1 != 1) {
                break label636;
              }
              k = 0;
              n = 1;
              label374:
              paramObject.iNewCount -= n;
              paramObject.iUpgradeCount -= k;
            }
          }
          else
          {
            paramObject = Message.obtain();
            paramObject.what = 4;
            paramObject.obj = localObject1;
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramObject);
            MedalGuideView.a((MedalWallMng.NeedGuideMedal)localObject1, paramBaseActivity, paramView, paramInt);
            if (QLog.isDevelopLevel()) {
              QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "checkShowMedalGuide [%d, %d,  %s]", new Object[] { Integer.valueOf(((MedalInfo)localObject3).iId), Integer.valueOf(((MedalInfo)localObject3).iLevel), ((MedalInfo)localObject3).strName }));
            }
            return true;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          Object localObject2 = localObject3;
          continue;
          if (((MedalInfo)localObject3).iLevelCount > 1)
          {
            if ((((MedalInfo)localObject3).iLevel >= 1) && (((MedalInfo)localObject3).iUnreadLevel1 == 1)) {}
            for (int m = 1;; m = 0)
            {
              if ((((MedalInfo)localObject3).iLevel >= 2) && (((MedalInfo)localObject3).iUnreadLevel2 == 1)) {}
              for (int i1 = 1;; i1 = 0)
              {
                n = m;
                k = i1;
                if (((MedalInfo)localObject3).iLevel < 3) {
                  break label374;
                }
                n = m;
                k = i1;
                if (((MedalInfo)localObject3).iUnreadLevel3 != 1) {
                  break label374;
                }
                k = i1 + 1;
                n = m;
                break label374;
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.i("MedalWallMng", 4, "checkShowMedalGuide no medal to show");
                return false;
              }
            }
          }
          label636:
          k = 0;
          int n = 0;
          continue;
          label645:
          localObject3 = localObject2;
        }
      }
    }
  }
  
  public void b()
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "onGetSelfObtainNewMedalNotice medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!b()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "onGetSelfObtainNewMedalNotice medal is off!");
    return;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).u();
  }
  
  protected void c()
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkMedalWall medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!b()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "checkMedalWall medal is off!");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalWall mIsInit: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.h = 0;
    this.i = 0;
    d();
    ArrayList localArrayList = new ArrayList();
    ??? = this.jdField_a_of_type_AndroidUtilSparseArray;
    int k = 0;
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
          {
            MedalInfo localMedalInfo = (MedalInfo)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
            if ((localMedalInfo == null) || (!localMedalInfo.isUnread())) {
              break label258;
            }
            MedalWallMng.NeedGuideMedal localNeedGuideMedal = new MedalWallMng.NeedGuideMedal();
            localNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo = localMedalInfo;
            localArrayList.add(localNeedGuideMedal);
          }
        }
        finally {}
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localCollection);
          if (this.h >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
          return;
        }
      }
      label258:
      k += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        e();
        return true;
        MedalWallMng.NeedGuideMedal localNeedGuideMedal = (MedalWallMng.NeedGuideMedal)paramMessage.obj;
        if (localNeedGuideMedal != null)
        {
          if (localNeedGuideMedal.jdField_a_of_type_Int == 2) {
            this.i += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "MSG_DOWNLOAD_RES_RESULT failCount: %d, cost: %d, failCode: %d, url: %s", new Object[] { Integer.valueOf(this.i), Integer.valueOf(paramMessage.arg1), Integer.valueOf(localNeedGuideMedal.jdField_b_of_type_Int), localNeedGuideMedal.jdField_a_of_type_JavaLangString }));
          }
        }
      } while (this.h >= this.jdField_a_of_type_JavaUtilArrayList.size());
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
      return true;
      f();
      return true;
    } while (!(paramMessage.obj instanceof MedalWallMng.NeedGuideMedal));
    a(0, (MedalWallMng.NeedGuideMedal)paramMessage.obj);
    return true;
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng
 * JD-Core Version:    0.7.0.1
 */