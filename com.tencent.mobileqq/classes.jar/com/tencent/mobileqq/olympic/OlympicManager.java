package com.tencent.mobileqq.olympic;

import agdu;
import agdv;
import agdw;
import agdx;
import agdy;
import agdz;
import agea;
import ageb;
import agec;
import aged;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.data.OlympicPredownInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.oidb.olympic.torch_transfer.TorchLimitInfo;
import tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo;
import tencent.im.oidb.olympic.torch_transfer.TorcherRankInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;

public class OlympicManager
  implements SoundPool.OnLoadCompleteListener, Handler.Callback, Manager, BusinessObserver
{
  private static Comparator jdField_a_of_type_JavaUtilComparator = new agdv();
  static Map jdField_a_of_type_JavaUtilMap = new HashMap(8);
  public static boolean a;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private static ShuayishuaConfig jdField_c_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
  private int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private Handler jdField_a_of_type_AndroidOsHandler;
  SparseArrayCompat jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(1);
  public QQAppInterface a;
  private OlyimpicConfig jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig;
  public OlympicActConfig a;
  private OlympicDPC jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
  public OlympicListener a;
  private OlympicObserver jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver = new agec(this);
  private OlympicResources.DownloadListener jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources$DownloadListener = new agdw(this);
  private OlympicResources jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources;
  private ShuayishuaConfig jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
  private TorchInfo jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = null;
  public final byte[] a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 0, 0 };
  private final boolean[] jdField_a_of_type_ArrayOfBoolean = { 0, 0, 0 };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 2500L;
  private Handler jdField_b_of_type_AndroidOsHandler;
  SparseArrayCompat jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(100);
  private ShuayishuaConfig jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
  boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = 180000L;
  boolean jdField_c_of_type_Boolean = false;
  private byte[] jdField_c_of_type_ArrayOfByte = new byte[0];
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long = 180000L;
  boolean jdField_d_of_type_Boolean = false;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private byte[] jdField_e_of_type_ArrayOfByte;
  private int jdField_f_of_type_Int = (int)(Math.random() * 5.0D + 5.0D);
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_ArrayOfInt = new int[0];
    jdField_c_of_type_ComTencentMobileqqOlympicShuayishuaConfig = new ShuayishuaConfig();
  }
  
  public OlympicManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfByte = new byte[0];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources = new OlympicResources(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources$DownloadListener);
    paramQQAppInterface.registObserver(this);
    ThreadManager.post(new agdu(this), 5, null, false);
    if (QLog.isColorLevel()) {
      QLog.e("OlympicManager", 2, "OlympicManager constructor ,mDebugUseLocalTime = " + this.jdField_b_of_type_Boolean + ",mUiHandler = " + this.jdField_a_of_type_AndroidOsHandler);
    }
  }
  
  protected static OlyimpicConfig a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("OlympicManager", 2, "parseConfig OlyimpicConfig.xmlConfigContent=" + paramString);
      QLog.i("OlympicManager", 2, "parseConfig OlyimpicConfig.version=" + paramInt + ",diffTimes=" + paramArrayList);
    }
    Object localObject1 = Xml.newPullParser();
    OlyimpicConfig localOlyimpicConfig = new OlyimpicConfig();
    localOlyimpicConfig.version = paramInt;
    Object localObject2;
    do
    {
      for (;;)
      {
        try
        {
          ((XmlPullParser)localObject1).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
          paramInt = ((XmlPullParser)localObject1).getEventType();
          if (paramInt == 1) {
            break label1157;
          }
          if (paramInt != 2) {
            break label308;
          }
          localObject2 = ((XmlPullParser)localObject1).getName();
          if (!((String)localObject2).equalsIgnoreCase("Common")) {
            break label319;
          }
          paramInt = ((XmlPullParser)localObject1).next();
          if (paramInt == 1) {
            break label308;
          }
          localObject2 = ((XmlPullParser)localObject1).getName();
          if (paramInt != 2) {
            break;
          }
          if (((String)localObject2).equalsIgnoreCase("GrabReqInterval"))
          {
            localOlyimpicConfig.grabInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            paramInt = ((XmlPullParser)localObject1).next();
            continue;
          }
          if (((String)localObject2).equalsIgnoreCase("ReportActiveInterval"))
          {
            localOlyimpicConfig.reportActiveInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            continue;
          }
          if (!((String)localObject2).equalsIgnoreCase("ReportNormalInterval")) {
            continue;
          }
        }
        catch (Exception paramArrayList)
        {
          if (QLog.isColorLevel()) {
            QLog.e("OlympicManager", 2, paramString, paramArrayList);
          }
          return null;
        }
        localOlyimpicConfig.reportNormalInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
      }
    } while ((paramInt != 3) || (!"Common".equals(localObject2)));
    label308:
    label319:
    ArrayList localArrayList;
    label396:
    String str;
    for (;;)
    {
      paramInt = ((XmlPullParser)localObject1).next();
      break;
      if (((String)localObject2).equalsIgnoreCase("ConfigId"))
      {
        localOlyimpicConfig.id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
      }
      else if (((String)localObject2).equalsIgnoreCase("Activity"))
      {
        localObject2 = new ShuayishuaConfig();
        localArrayList = new ArrayList(2);
        ((ShuayishuaConfig)localObject2).grabWordingList = localArrayList;
        paramInt = ((XmlPullParser)localObject1).next();
        if (paramInt == 1) {
          break label550;
        }
        str = ((XmlPullParser)localObject1).getName();
        if ((paramInt != 3) || (!str.equalsIgnoreCase("Activity"))) {
          break label507;
        }
        if (((ShuayishuaConfig)localObject2).realEnd >= ((ShuayishuaConfig)localObject2).realBegin) {
          localOlyimpicConfig.shuayishuaConfigs.add(localObject2);
        } else if (QLog.isColorLevel()) {
          QLog.i("OlympicManager", 2, "parseConfig.begin=" + ((ShuayishuaConfig)localObject2).realBegin + ", end=" + ((ShuayishuaConfig)localObject2).realEnd);
        }
      }
    }
    label507:
    if (paramInt == 2)
    {
      if (!str.equalsIgnoreCase("Id")) {
        break label552;
      }
      ((ShuayishuaConfig)localObject2).id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
    }
    for (;;)
    {
      paramInt = ((XmlPullParser)localObject1).next();
      break label396;
      label550:
      break;
      label552:
      if (str.equalsIgnoreCase("Type"))
      {
        ((ShuayishuaConfig)localObject2).type = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
      }
      else if (str.equalsIgnoreCase("Begin"))
      {
        ((ShuayishuaConfig)localObject2).realBegin = OlympicUtil.a(((XmlPullParser)localObject1).nextText());
      }
      else if (str.equalsIgnoreCase("End"))
      {
        ((ShuayishuaConfig)localObject2).realEnd = OlympicUtil.a(((XmlPullParser)localObject1).nextText());
      }
      else if (str.equalsIgnoreCase("BackGroundImg"))
      {
        ((ShuayishuaConfig)localObject2).bgImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("BackGroundMd5"))
      {
        ((ShuayishuaConfig)localObject2).bgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TopWording"))
      {
        ((ShuayishuaConfig)localObject2).topWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TipWording"))
      {
        ((ShuayishuaConfig)localObject2).tipWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("LUIconImg"))
      {
        ((ShuayishuaConfig)localObject2).LUIconImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("LUIconMd5"))
      {
        ((ShuayishuaConfig)localObject2).LUIconImgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("ActTime"))
      {
        ((ShuayishuaConfig)localObject2).actTime = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("PendantImg"))
      {
        ((ShuayishuaConfig)localObject2).pendantImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("PendantMd5"))
      {
        ((ShuayishuaConfig)localObject2).pendantImgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("Timer"))
      {
        ((ShuayishuaConfig)localObject2).timer = (Integer.parseInt(((XmlPullParser)localObject1).nextText()) * 1000);
      }
      else if (str.equalsIgnoreCase("GrabBeginWording1"))
      {
        ((ShuayishuaConfig)localObject2).grabBeginWording1 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("GrabBeginWording2"))
      {
        ((ShuayishuaConfig)localObject2).grabBeginWording2 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TorchLogoImg"))
      {
        ((ShuayishuaConfig)localObject2).torchLogoImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TorchLogoMd5"))
      {
        ((ShuayishuaConfig)localObject2).torchLogoImgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("NoRPWording1"))
      {
        ((ShuayishuaConfig)localObject2).noRPWording1 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("NoRPWording2"))
      {
        ((ShuayishuaConfig)localObject2).noRPWording2 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TorchAnimUrl"))
      {
        ((ShuayishuaConfig)localObject2).torchAnimUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TorchAnimMd5"))
      {
        ((ShuayishuaConfig)localObject2).torchAnimMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("GrabWording"))
      {
        str = ((XmlPullParser)localObject1).nextText();
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
      }
    }
    label1157:
    int k = localOlyimpicConfig.shuayishuaConfigs.size();
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size();; i = 0)
    {
      long l;
      if ((i != 0) && (k > 0))
      {
        Collections.sort(localOlyimpicConfig.shuayishuaConfigs, jdField_a_of_type_JavaUtilComparator);
        localObject1 = (ShuayishuaConfig)localOlyimpicConfig.shuayishuaConfigs.get(0);
        if (((ShuayishuaConfig)localObject1).type == 2)
        {
          paramInt = ((Integer)paramArrayList.get(0 % i)).intValue() * 1000;
          if (QLog.isColorLevel()) {
            QLog.i("OlympicManager", 2, "parseConfig last.realBegin=" + ((ShuayishuaConfig)localObject1).realBegin + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject1).realBegin) + "),countHitConfig =" + 0 + ",diff = " + paramInt);
          }
          ((ShuayishuaConfig)localObject1).realBegin += paramInt;
          l = ((ShuayishuaConfig)localObject1).realEnd;
          ((ShuayishuaConfig)localObject1).uiEnd = l;
          ((ShuayishuaConfig)localObject1).uiBegin = l;
          paramInt = 1;
          break label1608;
        }
      }
      for (;;)
      {
        if (j < k)
        {
          localObject2 = (ShuayishuaConfig)localOlyimpicConfig.shuayishuaConfigs.get(j);
          if (((ShuayishuaConfig)localObject2).type == 2)
          {
            int m = ((Integer)paramArrayList.get(paramInt % i)).intValue() * 1000;
            if (QLog.isColorLevel()) {
              QLog.i("OlympicManager", 2, "parseConfig cur.realBegin=" + ((ShuayishuaConfig)localObject2).realBegin + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject2).realBegin) + "),countHitConfig =" + paramInt + ",diff = " + m);
            }
            ((ShuayishuaConfig)localObject2).realBegin += m;
            l = ((ShuayishuaConfig)localObject2).realEnd;
            ((ShuayishuaConfig)localObject2).uiEnd = l;
            ((ShuayishuaConfig)localObject2).uiBegin = l;
            if ((localObject1 == null) || (((ShuayishuaConfig)localObject1).type != 1)) {
              break label1614;
            }
            l = ((ShuayishuaConfig)localObject2).realBegin;
            ((ShuayishuaConfig)localObject1).realEnd = l;
            ((ShuayishuaConfig)localObject1).uiEnd = l;
            break label1614;
            ((ShuayishuaConfig)localObject1).uiBegin = ((ShuayishuaConfig)localObject1).realBegin;
            ((ShuayishuaConfig)localObject1).uiEnd = ((ShuayishuaConfig)localObject1).realEnd;
            paramInt = 0;
          }
          else
          {
            ((ShuayishuaConfig)localObject2).uiBegin = ((ShuayishuaConfig)localObject2).realBegin;
            ((ShuayishuaConfig)localObject2).uiEnd = ((ShuayishuaConfig)localObject2).realEnd;
            break label1618;
          }
        }
        else
        {
          Collections.sort(localOlyimpicConfig.shuayishuaConfigs, jdField_a_of_type_JavaUtilComparator);
          return localOlyimpicConfig;
        }
        label1608:
        int j = 1;
        continue;
        label1614:
        paramInt += 1;
        label1618:
        j += 1;
        localObject1 = localObject2;
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean) {}
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
    OlympicListener localOlympicListener = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener;
    if (localOlympicListener == null) {
      return;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = NetConnInfoCenter.getServerTimeMillis();
    }
    boolean bool1 = ARDeviceController.a().b();
    boolean bool2 = e();
    boolean bool3 = a("olympic_entrance_setting", true);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshUI,arEnable = ").append(bool1).append(",mActConfig: ");
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null) {
        break label227;
      }
      localObject = "null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(",mCurrentConfig: ");
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig != null) {
        break label235;
      }
    }
    label227:
    label235:
    for (localObject = "null";; localObject = "not null")
    {
      QLog.d("OlympicManager", 2, (String)localObject + ",currentTime = " + l + "(" + OlympicUtil.a(l) + "),closeEntrance = " + bool2 + ",mHasChechBreathOnRecovery = " + this.jdField_d_of_type_Boolean + ",olympicSettingFlag = " + bool3 + ",mTorchbearerFlag = " + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null) {}
      localOlympicListener.a();
      return;
      localObject = "not null";
      break;
    }
  }
  
  private void a(OlympicActConfig paramOlympicActConfig, boolean paramBoolean)
  {
    OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource ，forceDownload = " + paramBoolean });
    if (paramOlympicActConfig == null)
    {
      QLog.i("OlympicManager", 1, "tryDownloadActResource actconfig == null!");
      return;
    }
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      localObject1 = "dpc is null";
      QLog.i("OlympicManager", 1, "tryDownloadActResource dpc =" + (String)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC != null) && (!this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Boolean)) {
        break label222;
      }
      bool = true;
      label105:
      localObject1 = new HashMap();
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC != null) {
        break label228;
      }
    }
    label222:
    label228:
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Int)
    {
      ((HashMap)localObject1).put("dpc", String.valueOf(i));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "olympic_down_dpc", bool, 0L, 0L, (HashMap)localObject1, "", false);
      if (paramBoolean) {
        break label262;
      }
      if (d()) {
        break label239;
      }
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, can't auto pre download, return" });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_JavaLangString == null)
      {
        localObject1 = "dpc.string is null";
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_JavaLangString;
      break;
      bool = false;
      break label105;
    }
    label239:
    if (!c())
    {
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, isNetworkCanPredown is false, return" });
      return;
    }
    label262:
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1 = paramOlympicActConfig.getConfigString("HomePage", "End");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (OlympicUtil.a((String)localObject1) < l))
    {
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, time expired!" });
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = "";
    Object localObject3;
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo != null))
    {
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, cityPic & starPic, isSelfTorchbearer() && mTorchbearerInfo != null" });
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.size() > 0)
      {
        localObject3 = (TorchInfo.CityInfo)this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.get(0);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((TorchInfo.CityInfo)localObject3).city_pic_url, ((TorchInfo.CityInfo)localObject3).city_pic_md5, new String[] { "ActConfig", "CityImage", ((TorchInfo.CityInfo)localObject3).city_id + "_" + ((TorchInfo.CityInfo)localObject3).city_pic_id }, false, 2, true);
          localArrayList1.add(((TorchInfo.CityInfo)localObject3).city_pic_md5);
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((TorchInfo.CityInfo)localObject3).cons_pic_url, ((TorchInfo.CityInfo)localObject3).cons_pic_md5, new String[] { "ActConfig", "StarImage", ((TorchInfo.CityInfo)localObject3).city_id + "_" + ((TorchInfo.CityInfo)localObject3).city_pic_id }, false, 2, true);
          localArrayList1.add(((TorchInfo.CityInfo)localObject3).cons_pic_md5);
          localObject1 = localObject2;
          if (TextUtils.isEmpty("")) {
            localObject1 = ((TorchInfo.CityInfo)localObject3).city_pic_md5;
          }
        }
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.size() > 1)
      {
        localObject3 = (TorchInfo.CityInfo)this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.get(1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((TorchInfo.CityInfo)localObject3).city_pic_url, ((TorchInfo.CityInfo)localObject3).city_pic_md5, new String[] { "ActConfig", "City2Image", ((TorchInfo.CityInfo)localObject3).city_id + "_" + ((TorchInfo.CityInfo)localObject3).city_pic_id }, false, 2, true);
          localArrayList1.add(((TorchInfo.CityInfo)localObject3).city_pic_md5);
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((TorchInfo.CityInfo)localObject3).cons_pic_url, ((TorchInfo.CityInfo)localObject3).cons_pic_md5, new String[] { "ActConfig", "Star2Image", ((TorchInfo.CityInfo)localObject3).city_id + "_" + ((TorchInfo.CityInfo)localObject3).city_pic_id }, false, 2, true);
          localArrayList1.add(((TorchInfo.CityInfo)localObject3).cons_pic_md5);
          localObject2 = localObject1;
        }
      }
    }
    label831:
    Object localObject4;
    label921:
    label937:
    String str;
    label1184:
    label1228:
    do
    {
      localObject1 = paramOlympicActConfig.getHomePageBg("1");
      if (localObject1 != null) {
        break;
      }
      paramBoolean = true;
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, homePageBg==null?", Boolean.valueOf(paramBoolean) });
      if (localObject1 == null) {
        break label1943;
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((OlympicActConfig.HomePageBg)localObject1).url, ((OlympicActConfig.HomePageBg)localObject1).md5, new String[] { "ActConfig", "homePageBg", "01" }, false, 2, true);
      localArrayList1.add(((OlympicActConfig.HomePageBg)localObject1).md5);
      localObject3 = ((OlympicActConfig.HomePageBg)localObject1).md5;
      localObject1 = paramOlympicActConfig.getHomePageBg("2");
      if (localObject1 != null) {
        break label1452;
      }
      paramBoolean = true;
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, homePageBg2==null?", Boolean.valueOf(paramBoolean) });
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((OlympicActConfig.HomePageBg)localObject1).url, ((OlympicActConfig.HomePageBg)localObject1).md5, new String[] { "ActConfig", "homePageBg", "02" }, false, 2, true);
        localArrayList1.add(((OlympicActConfig.HomePageBg)localObject1).md5);
      }
      localObject1 = "";
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, actConfig.mTorchImageMap.size() = ", Integer.valueOf(paramOlympicActConfig.getTorchImageMap().size()) });
      localObject4 = paramOlympicActConfig.getTorchImageMap().keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        str = (String)((Iterator)localObject4).next();
        OlympicActConfig.TorchImage localTorchImage = (OlympicActConfig.TorchImage)paramOlympicActConfig.getTorchImageMap().get(str);
        if (localTorchImage == null) {
          break label1940;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(localTorchImage.url, localTorchImage.md5, new String[] { "ActConfig", "TorchImage", str }, false, 2, true);
        localArrayList1.add(localTorchImage.md5);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1940;
        }
        localObject1 = localTorchImage.md5;
      }
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, actConfig.getChosenCityImageList.size() = ", Integer.valueOf(paramOlympicActConfig.getChosenCityImageList().size()) });
      localObject3 = paramOlympicActConfig.getChosenCityImageList().iterator();
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (!((Iterator)localObject3).hasNext());
    localObject2 = (OlympicActConfig.CityImage)((Iterator)localObject3).next();
    if (localObject2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((OlympicActConfig.CityImage)localObject2).url, ((OlympicActConfig.CityImage)localObject2).md5, new String[] { "ActConfig", "CityImage", ((OlympicActConfig.CityImage)localObject2).companyId + "_" + ((OlympicActConfig.CityImage)localObject2).picId }, false, 2, true);
      localArrayList1.add(((OlympicActConfig.CityImage)localObject2).md5);
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((OlympicActConfig.CityImage)localObject2).starUrl, ((OlympicActConfig.CityImage)localObject2).starMd5, new String[] { "ActConfig", "StarImage", ((OlympicActConfig.CityImage)localObject2).companyId + "_" + ((OlympicActConfig.CityImage)localObject2).picId }, false, 2, true);
      localArrayList1.add(((OlympicActConfig.CityImage)localObject2).starMd5);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = ((OlympicActConfig.CityImage)localObject2).md5;
      }
    }
    for (;;)
    {
      break label1228;
      paramBoolean = false;
      break label831;
      label1452:
      paramBoolean = false;
      break label937;
      localObject4 = paramOlympicActConfig.getConfigString("TorchAnim", "FileUrl");
      str = paramOlympicActConfig.getConfigString("TorchAnim", "FileMd5");
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty(str)))
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a((String)localObject4, str, new String[] { "ActConfig", "TorchAnim" }, false, 2, true);
        localArrayList2.add(str);
        label1538:
        localObject4 = paramOlympicActConfig.getConfigString("MsgTabBG", "Img");
        str = paramOlympicActConfig.getConfigString("MsgTabBG", "Md5");
        if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(str))) {
          break label1892;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a((String)localObject4, str, new String[] { "ActConfig", "MsgTabBG" }, false, 2, true);
        localArrayList1.add(str);
        label1619:
        localObject4 = paramOlympicActConfig.getConfigString("TorchImageNoBg", "FileUrl");
        str = paramOlympicActConfig.getConfigString("TorchImageNoBg", "FileMd5");
        if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(str))) {
          break label1910;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a((String)localObject4, str, new String[] { "ActConfig", "TorchImageNoBg" }, false, 2, true);
        localArrayList1.add(str);
        label1700:
        localObject4 = paramOlympicActConfig.getConfigString("cityaward", "Img");
        paramOlympicActConfig = paramOlympicActConfig.getConfigString("cityaward", "Md5");
        if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(paramOlympicActConfig))) {
          break label1922;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a((String)localObject4, paramOlympicActConfig, null, false, 2, true);
        localArrayList1.add(paramOlympicActConfig);
      }
      for (;;)
      {
        if (OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_predown_act")) {
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new agdy(this, localArrayList1, localArrayList2), 60000L);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OlympicManager", 2, "firstTorchMD5:" + (String)localObject1 + ",firstCityMD5:" + (String)localObject2 + ",firstCityBgMD5:" + (String)localObject3 + ",takeAwardImgUrl " + (String)localObject4 + ",takeAwardImgMd5" + paramOlympicActConfig);
        return;
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, TorchAnim,  torchAnimUrl or torchAnimMd5 is empty" });
        break label1538;
        label1892:
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, MsgTabBG,  msgTabImgUrl or msgTabImgMD5 is empty" });
        break label1619;
        label1910:
        QLog.i("OlympicManager", 1, "tryDownloadActResource, TorchImageNoBg,  torchImageNoBgUrl or torchImageNoBgMD5 is empty");
        break label1700;
        label1922:
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, takeAwardImg,  takeAwardImgUrl or takeAwardImgUrl is empty" });
      }
      label1940:
      break label1184;
      label1943:
      localObject3 = "";
      break label921;
    }
  }
  
  private void a(String paramString, List paramList1, List paramList2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList1 == null) || (paramList2 == null)) {}
    boolean bool1;
    boolean bool3;
    boolean bool2;
    label188:
    do
    {
      return;
      bool1 = true;
      bool3 = true;
      for (;;)
      {
        try
        {
          paramList1 = paramList1.iterator();
          bool2 = bool1;
          if (paramList1.hasNext())
          {
            bool1 = OlympicResources.a((String)paramList1.next()) & bool1;
            if (!bool1) {
              bool2 = bool1;
            }
          }
          else
          {
            paramList1 = paramList2.iterator();
            bool1 = bool3;
            bool3 = bool1;
            if (paramList1.hasNext())
            {
              bool1 = OlympicResources.a((String)paramList1.next()) & bool1;
              if (bool1) {
                break label274;
              }
              bool3 = bool1;
            }
            bool1 = bool3 & bool2;
            paramList2 = new HashMap();
            if (!"olympic_predown_act".equals(paramString)) {
              break;
            }
            if (!bool2) {
              break label277;
            }
            paramList1 = "1";
            paramList2.put("act_pic", paramList1);
            if (!bool3) {
              break label384;
            }
            paramList1 = "1";
            paramList2.put("act_anim", paramList1);
            if (!bool1) {
              break label391;
            }
            paramList1 = "1";
            paramList2.put("act_all_resource", paramList1);
            StatisticCollector.a(BaseApplicationImpl.getContext()).a("", paramString, true, 0L, 0L, paramList2, "", false);
            OlympicUtil.a(BaseApplicationImpl.getContext(), paramString);
            return;
          }
        }
        catch (Throwable paramList1)
        {
          if (QLog.isColorLevel()) {
            paramList1.printStackTrace();
          }
          QLog.d("OlympicManager", 1, new Object[] { "reportPredown, reportKey=", paramString, ", t=", paramList1.getMessage() });
          return;
        }
        continue;
        continue;
        paramList1 = "0";
      }
    } while (!"olympic_predown_shua".equals(paramString));
    label274:
    label277:
    if (bool2)
    {
      paramList1 = "1";
      label303:
      paramList2.put("shua_pic", paramList1);
      if (!bool3) {
        break label405;
      }
    }
    label384:
    label391:
    label405:
    for (paramList1 = "1";; paramList1 = "0")
    {
      paramList2.put("shua_anim", paramList1);
      if (bool1) {}
      for (paramList1 = "1";; paramList1 = "0")
      {
        paramList2.put("shua_all_resource", paramList1);
        StatisticCollector.a(BaseApplicationImpl.getContext()).a("", paramString, true, 0L, 0L, paramList2, "", false);
        OlympicUtil.a(BaseApplicationImpl.getContext(), paramString);
        return;
      }
      paramList1 = "0";
      break;
      paramList1 = "0";
      break label188;
      paramList1 = "0";
      break label303;
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_g_of_type_Boolean = false;
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_code", -1);
      if (i == 28)
      {
        a(1);
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5).sendToTarget();
        this.jdField_e_of_type_Int += 1;
        long l = paramBundle.getLong("k_interval", -1L);
        if (l > 0L) {
          this.jdField_b_of_type_Long = l;
        }
        l = paramBundle.getLong("k_active_interval", -1L);
        if (l > 0L) {
          this.jdField_c_of_type_Long = l;
        }
        l = paramBundle.getLong("k_normal_interval", -1L);
        if (l > 0L) {
          this.jdField_d_of_type_Long = l;
        }
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "handleGrabTorch.isSuccess=" + paramBoolean + ",errCode=" + i + ",interval=" + l);
        }
      }
    }
    do
    {
      return;
      if (i == 0)
      {
        byte[] arrayOfByte = paramBundle.getByteArray("k_pack_id");
        int j = paramBundle.getInt("k_business", -1);
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "handleGrabTorch.pack_id=" + arrayOfByte + ",business=" + j);
        }
        this.jdField_d_of_type_ArrayOfByte = arrayOfByte;
        this.jdField_b_of_type_Int = j;
        this.jdField_f_of_type_Boolean = true;
        this.jdField_e_of_type_Int += 1;
        break;
      }
      this.jdField_d_of_type_Int += 1;
      break;
      this.jdField_d_of_type_Int += 1;
    } while (!QLog.isColorLevel());
    QLog.d("OlympicManager", 2, "handleGrabTorch.isSuccess=" + paramBoolean);
  }
  
  private void b(long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "handleCheckTime, mConfig is null!");
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    jdField_c_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realBegin = paramLong;
    Object localObject2 = ((OlyimpicConfig)localObject1).shuayishuaConfigs;
    int k = Collections.binarySearch((List)localObject2, jdField_c_of_type_ComTencentMobileqqOlympicShuayishuaConfig, jdField_a_of_type_JavaUtilComparator);
    int i;
    if (k >= 0) {
      i = k + 1;
    }
    while (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      int j = 0;
      for (;;)
      {
        if (j < ((ArrayList)localObject2).size())
        {
          ShuayishuaConfig localShuayishuaConfig = (ShuayishuaConfig)((ArrayList)localObject2).get(j);
          ((StringBuilder)localObject1).append(localShuayishuaConfig.realBegin + "(" + OlympicUtil.a(localShuayishuaConfig.realBegin) + ")").append("-").append(localShuayishuaConfig.uiEnd + "(" + OlympicUtil.a(localShuayishuaConfig.uiEnd) + ")").append(";");
          j += 1;
          continue;
          i = -k - 1;
          break;
        }
      }
      QLog.d("OlympicManager", 2, "handleCheckTime ,nextIndex = " + i + ",index = " + k + ";" + ((StringBuilder)localObject1).toString() + ",mTorchbearerFlag = " + this.jdField_a_of_type_Int + ",mHasSendLastCheckRequest = " + this.jdField_c_of_type_Boolean);
    }
    if ((i > 0) && (i <= ((ArrayList)localObject2).size()))
    {
      localObject1 = (ShuayishuaConfig)((ArrayList)localObject2).get(i - 1);
      if (((ShuayishuaConfig)localObject1).uiEnd < paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "handleCheckTime ,cConfig.uiEnd = " + ((ShuayishuaConfig)localObject1).uiEnd + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject1).uiEnd) + "),current = " + paramLong + "(" + OlympicUtil.a(paramLong) + ")");
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      if ((i < ((ArrayList)localObject2).size()) && (i >= 0)) {}
      label800:
      label1072:
      for (localObject2 = (ShuayishuaConfig)((ArrayList)localObject2).get(i);; localObject2 = null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig = ((ShuayishuaConfig)localObject1);
        this.jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig = ((ShuayishuaConfig)localObject2);
        long l2 = 9223372036854775807L;
        long l1;
        if (this.jdField_a_of_type_Int == 1)
        {
          l1 = l2;
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("HomePage", "End");
            l1 = l2;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              l1 = l2;
              if (!this.jdField_c_of_type_Boolean)
              {
                if (jdField_a_of_type_JavaUtilMap.containsKey(localObject1))
                {
                  l1 = ((Long)jdField_a_of_type_JavaUtilMap.get(localObject1)).longValue();
                  label560:
                  this.jdField_c_of_type_Boolean = true;
                  if (l1 < paramLong) {
                    break label690;
                  }
                }
                label690:
                for (paramLong = l1 - paramLong;; paramLong = 1000L)
                {
                  this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), paramLong);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("OlympicManager", 2, "handleCheckTime ,strTimeEnd=" + (String)localObject1 + ",end=" + l1 + ",delay = " + paramLong);
                  return;
                  l2 = OlympicUtil.a((String)localObject1);
                  l1 = l2;
                  if (l2 <= 0L) {
                    break label560;
                  }
                  jdField_a_of_type_JavaUtilMap.put(localObject1, Long.valueOf(l2));
                  l1 = l2;
                  break label560;
                }
              }
            }
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig == null) {
            break label1072;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.type != 1) {
            break label901;
          }
          if (paramLong > this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd - 300000L) {
            break label889;
          }
          l2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd - 300000L;
          label744:
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.i("OlympicManager", 2, "handleCheckTime.type=1,mCurrentConfig.realEnd=" + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd + ",current=" + paramLong);
            l1 = l2;
          }
        }
        if (l1 != 9223372036854775807L) {
          if (l1 < paramLong) {
            break label1151;
          }
        }
        label889:
        label1151:
        for (paramLong = l1 - paramLong;; paramLong = 60000L)
        {
          l1 = paramLong;
          if (paramLong > 60000L) {
            l1 = 60000L;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), l1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("OlympicManager", 2, "handleCheckTime ,delay=" + l1);
          return;
          l2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd;
          break label744;
          l1 = l2;
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.type != 2) {
            break label800;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin == this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd) {
            l2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd;
          }
          for (;;)
          {
            l1 = l2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("OlympicManager", 2, "handleCheckTime.type=2,mCurrentConfig.uiBegin=" + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin + ",mCurrentConfig.realEnd=" + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd + ",current=" + paramLong);
            l1 = l2;
            break;
            l1 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd;
            l2 = l1;
            if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.timer < l1) {
              l2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.timer;
            }
          }
          l1 = l2;
          if (this.jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig == null) {
            break label800;
          }
          l2 = this.jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realBegin;
          l1 = l2;
          if (!QLog.isColorLevel()) {
            break label800;
          }
          QLog.i("OlympicManager", 2, "handleCheckTime.mNextConfig.realBegin=" + this.jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realBegin + ",current=" + paramLong);
          l1 = l2;
          break label800;
          break;
        }
      }
      label901:
      continue;
      localObject1 = null;
    }
  }
  
  private void b(OlyimpicConfig paramOlyimpicConfig)
  {
    if (paramOlyimpicConfig == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return;
      if (!d())
      {
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownload, can't auto pre download, return" });
        return;
      }
      if (!c())
      {
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownload, isNetworkCanPredown is false, return" });
        return;
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramOlyimpicConfig = paramOlyimpicConfig.shuayishuaConfigs.iterator();
      while (paramOlyimpicConfig.hasNext())
      {
        ShuayishuaConfig localShuayishuaConfig = (ShuayishuaConfig)paramOlyimpicConfig.next();
        if ((localShuayishuaConfig.uiEnd > l) || (localShuayishuaConfig.realEnd > l))
        {
          if ((!TextUtils.isEmpty(localShuayishuaConfig.LUIconImg)) && (!TextUtils.isEmpty(localShuayishuaConfig.LUIconImgMd5)))
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(localShuayishuaConfig.LUIconImg, localShuayishuaConfig.LUIconImgMd5, new String[] { "shuayishua", String.valueOf(localShuayishuaConfig.id) }, false, 1, true);
            localArrayList1.add(localShuayishuaConfig.LUIconImgMd5);
          }
          if ((!TextUtils.isEmpty(localShuayishuaConfig.torchLogoImg)) && (!TextUtils.isEmpty(localShuayishuaConfig.torchLogoImgMd5)))
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(localShuayishuaConfig.torchLogoImg, localShuayishuaConfig.torchLogoImgMd5, new String[] { "shuayishua", String.valueOf(localShuayishuaConfig.id) }, false, 1, true);
            localArrayList1.add(localShuayishuaConfig.torchLogoImgMd5);
          }
          if ((!TextUtils.isEmpty(localShuayishuaConfig.torchAnimUrl)) && (!TextUtils.isEmpty(localShuayishuaConfig.torchAnimMd5)))
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(localShuayishuaConfig.torchAnimUrl, localShuayishuaConfig.torchAnimMd5, new String[] { "shuayishua_anim", String.valueOf(localShuayishuaConfig.id) }, false, 1, true);
            localArrayList2.add(localShuayishuaConfig.torchAnimMd5);
          }
        }
      }
    } while (!OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_predown_shua"));
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new agdx(this, localArrayList1, localArrayList2), 60000L);
  }
  
  private void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "handleConfig.isSuccess=" + paramBoolean + ",bundle=" + paramBundle);
    }
    int i;
    if ((paramBoolean) && (paramBundle != null))
    {
      i = paramBundle.getInt("k_code", -1);
      paramBundle = paramBundle.getParcelable("k_config");
      if (i != 3) {
        break label85;
      }
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, null).sendToTarget();
    }
    label85:
    do
    {
      return;
      if (i == 2)
      {
        b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig);
        return;
      }
    } while ((paramBundle == null) || (!(paramBundle instanceof OlyimpicConfig)));
    b((OlyimpicConfig)paramBundle);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramBundle).sendToTarget();
  }
  
  private void h()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = localSharedPreferences.getLong("OlympicBreatheTime", -1L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    long l3 = l2 - l2 % 86400000L;
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "checkBreatheOnTransferNumChange.lastBreatheTime=" + l1 + ",current=" + l2 + ",zeroTime=" + l3);
    }
    if (l1 < l3)
    {
      if (!localSharedPreferences.getBoolean("in_breath_procedure", false)) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "checkBreatheOnTransferNumChange inProcedure return");
      }
    }
    return;
    label126:
    localSharedPreferences.edit().putLong("OlympicBreatheTime", l2).commit();
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, 2, 0).sendToTarget();
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "checkBreatheOnTransferNumChange set inProcedure true");
    }
    localSharedPreferences.edit().putBoolean("in_breath_procedure", true).commit();
    localSharedPreferences.edit().putInt("breath_remind_type_value", 2).commit();
  }
  
  public int a()
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_ArrayOfByte)
      {
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        if (localSharedPreferences != null)
        {
          int j = localSharedPreferences.getInt("isTorchbearer", -1);
          if (this.jdField_a_of_type_Int == -1) {
            this.jdField_a_of_type_Int = j;
          }
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("OlympicManager", 2, "loadTorchbearerFlagFromLocal.flag=" + j + ",mTorchbearerFlag=" + this.jdField_a_of_type_Int);
            i = j;
          }
          return i;
        }
      }
      int i = -1;
    }
  }
  
  public OlympicPredownInfo a(String paramString)
  {
    Object localObject = null;
    String str;
    if (paramString == null) {
      str = "null";
    }
    try
    {
      OlympicUtil.b("OlympicManager", new Object[] { "getEntity, url=", str });
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        paramString = localObject;
      }
      for (;;)
      {
        return paramString;
        str = paramString;
        break;
        try
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OlympicPredownInfo.class, false, "url = ?", new String[] { paramString }, null, null, null, null);
          if ((paramString != null) && (paramString.size() > 0)) {
            paramString = (OlympicPredownInfo)paramString.get(0);
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              paramString.printStackTrace();
            }
            paramString = null;
          }
          paramString = null;
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public OlyimpicConfig a()
  {
    // Byte code:
    //   0: new 1119	java/io/File
    //   3: dup
    //   4: getstatic 1123	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   7: invokevirtual 1127	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   10: new 207	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1129
    //   20: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 136	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 1132	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   30: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 1135	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 1138	java/io/File:exists	()Z
    //   44: ifeq +351 -> 395
    //   47: new 1140	java/io/FileInputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 1143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_2
    //   56: new 1145	java/io/ObjectInputStream
    //   59: dup
    //   60: new 1147	java/io/BufferedInputStream
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 1150	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 1151	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore_1
    //   72: aload_2
    //   73: astore 4
    //   75: aload_1
    //   76: astore_3
    //   77: aload_1
    //   78: invokevirtual 1154	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   81: checkcast 257	com/tencent/mobileqq/olympic/OlyimpicConfig
    //   84: astore 5
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 1157	java/io/ObjectInputStream:close	()V
    //   94: aload 5
    //   96: astore_1
    //   97: aload_2
    //   98: ifnull +10 -> 108
    //   101: aload_2
    //   102: invokevirtual 1158	java/io/FileInputStream:close	()V
    //   105: aload 5
    //   107: astore_1
    //   108: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +29 -> 140
    //   114: ldc 205
    //   116: iconst_2
    //   117: new 207	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 1160
    //   127: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 242	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: getfield 953	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig	Lcom/tencent/mobileqq/olympic/OlyimpicConfig;
    //   144: ifnonnull +19 -> 163
    //   147: aload_1
    //   148: ifnull +15 -> 163
    //   151: aload_0
    //   152: getfield 149	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   155: iconst_4
    //   156: aload_1
    //   157: invokevirtual 1040	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   160: invokevirtual 908	android/os/Message:sendToTarget	()V
    //   163: aload_1
    //   164: areturn
    //   165: astore_1
    //   166: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq -75 -> 94
    //   172: ldc 205
    //   174: iconst_2
    //   175: ldc_w 623
    //   178: aload_1
    //   179: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: goto -88 -> 94
    //   185: astore_2
    //   186: aload 5
    //   188: astore_1
    //   189: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -84 -> 108
    //   195: ldc 205
    //   197: iconst_2
    //   198: ldc_w 623
    //   201: aload_2
    //   202: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload 5
    //   207: astore_1
    //   208: goto -100 -> 108
    //   211: astore 5
    //   213: aconst_null
    //   214: astore_2
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_2
    //   218: astore 4
    //   220: aload_1
    //   221: astore_3
    //   222: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +19 -> 244
    //   228: aload_2
    //   229: astore 4
    //   231: aload_1
    //   232: astore_3
    //   233: ldc 205
    //   235: iconst_2
    //   236: ldc_w 623
    //   239: aload 5
    //   241: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 1157	java/io/ObjectInputStream:close	()V
    //   252: aload_2
    //   253: ifnull +142 -> 395
    //   256: aload_2
    //   257: invokevirtual 1158	java/io/FileInputStream:close	()V
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -154 -> 108
    //   265: astore_1
    //   266: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -17 -> 252
    //   272: ldc 205
    //   274: iconst_2
    //   275: ldc_w 623
    //   278: aload_1
    //   279: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: goto -30 -> 252
    //   285: astore_1
    //   286: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc 205
    //   294: iconst_2
    //   295: ldc_w 623
    //   298: aload_1
    //   299: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: aconst_null
    //   303: astore_1
    //   304: goto -196 -> 108
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_2
    //   310: aconst_null
    //   311: astore_3
    //   312: aload_3
    //   313: ifnull +7 -> 320
    //   316: aload_3
    //   317: invokevirtual 1157	java/io/ObjectInputStream:close	()V
    //   320: aload_2
    //   321: ifnull +7 -> 328
    //   324: aload_2
    //   325: invokevirtual 1158	java/io/FileInputStream:close	()V
    //   328: aload_1
    //   329: athrow
    //   330: astore_3
    //   331: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq -14 -> 320
    //   337: ldc 205
    //   339: iconst_2
    //   340: ldc_w 623
    //   343: aload_3
    //   344: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   347: goto -27 -> 320
    //   350: astore_2
    //   351: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq -26 -> 328
    //   357: ldc 205
    //   359: iconst_2
    //   360: ldc_w 623
    //   363: aload_2
    //   364: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: goto -39 -> 328
    //   370: astore_1
    //   371: aconst_null
    //   372: astore_3
    //   373: goto -61 -> 312
    //   376: astore_1
    //   377: aload 4
    //   379: astore_2
    //   380: goto -68 -> 312
    //   383: astore 5
    //   385: aconst_null
    //   386: astore_1
    //   387: goto -170 -> 217
    //   390: astore 5
    //   392: goto -175 -> 217
    //   395: aconst_null
    //   396: astore_1
    //   397: goto -289 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	OlympicManager
    //   39	125	1	localObject1	Object
    //   165	14	1	localIOException1	java.io.IOException
    //   188	74	1	localObject2	Object
    //   265	14	1	localIOException2	java.io.IOException
    //   285	14	1	localIOException3	java.io.IOException
    //   303	1	1	localObject3	Object
    //   307	22	1	localObject4	Object
    //   370	1	1	localObject5	Object
    //   376	1	1	localObject6	Object
    //   386	11	1	localObject7	Object
    //   55	47	2	localFileInputStream	java.io.FileInputStream
    //   185	17	2	localIOException4	java.io.IOException
    //   214	111	2	localObject8	Object
    //   350	14	2	localIOException5	java.io.IOException
    //   379	1	2	localObject9	Object
    //   76	241	3	localObject10	Object
    //   330	14	3	localIOException6	java.io.IOException
    //   372	1	3	localObject11	Object
    //   73	305	4	localObject12	Object
    //   84	122	5	localOlyimpicConfig	OlyimpicConfig
    //   211	29	5	localThrowable1	Throwable
    //   383	1	5	localThrowable2	Throwable
    //   390	1	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   90	94	165	java/io/IOException
    //   101	105	185	java/io/IOException
    //   47	56	211	java/lang/Throwable
    //   248	252	265	java/io/IOException
    //   256	260	285	java/io/IOException
    //   47	56	307	finally
    //   316	320	330	java/io/IOException
    //   324	328	350	java/io/IOException
    //   56	72	370	finally
    //   77	86	376	finally
    //   222	228	376	finally
    //   233	244	376	finally
    //   56	72	383	java/lang/Throwable
    //   77	86	390	java/lang/Throwable
  }
  
  public OlympicActConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig;
  }
  
  /* Error */
  public TorchInfo a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 76	com/tencent/mobileqq/olympic/OlympicManager:jdField_c_of_type_ArrayOfByte	[B
    //   10: astore 7
    //   12: aload 7
    //   14: monitorenter
    //   15: new 1119	java/io/File
    //   18: dup
    //   19: getstatic 1123	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   22: invokevirtual 1127	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   25: new 207	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 1164
    //   35: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 136	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 1132	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   45: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 1135	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 1138	java/io/File:exists	()Z
    //   59: istore_1
    //   60: iload_1
    //   61: ifeq +381 -> 442
    //   64: new 1140	java/io/FileInputStream
    //   67: dup
    //   68: aload_2
    //   69: invokespecial 1143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: astore_3
    //   73: new 1145	java/io/ObjectInputStream
    //   76: dup
    //   77: new 1147	java/io/BufferedInputStream
    //   80: dup
    //   81: aload_3
    //   82: invokespecial 1150	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: invokespecial 1151	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 1154	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   93: checkcast 658	com/tencent/mobileqq/olympic/TorchInfo
    //   96: astore 4
    //   98: aload_0
    //   99: getfield 654	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo	Lcom/tencent/mobileqq/olympic/TorchInfo;
    //   102: ifnonnull +9 -> 111
    //   105: aload_0
    //   106: aload 4
    //   108: putfield 654	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo	Lcom/tencent/mobileqq/olympic/TorchInfo;
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 1157	java/io/ObjectInputStream:close	()V
    //   119: aload 4
    //   121: astore_2
    //   122: aload_3
    //   123: ifnull +10 -> 133
    //   126: aload_3
    //   127: invokevirtual 1158	java/io/FileInputStream:close	()V
    //   130: aload 4
    //   132: astore_2
    //   133: aload 7
    //   135: monitorexit
    //   136: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +29 -> 168
    //   142: ldc 205
    //   144: iconst_2
    //   145: new 207	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 1166
    //   155: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_2
    //   159: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 242	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_2
    //   169: areturn
    //   170: astore_2
    //   171: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -55 -> 119
    //   177: ldc 205
    //   179: iconst_2
    //   180: ldc_w 623
    //   183: aload_2
    //   184: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: goto -68 -> 119
    //   190: astore_2
    //   191: aload 7
    //   193: monitorexit
    //   194: aload_2
    //   195: athrow
    //   196: astore_3
    //   197: aload 4
    //   199: astore_2
    //   200: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq -70 -> 133
    //   206: ldc 205
    //   208: iconst_2
    //   209: ldc_w 623
    //   212: aload_3
    //   213: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload 4
    //   218: astore_2
    //   219: goto -86 -> 133
    //   222: astore 6
    //   224: aconst_null
    //   225: astore 4
    //   227: aconst_null
    //   228: astore_2
    //   229: aload 5
    //   231: astore_3
    //   232: aload 6
    //   234: astore 5
    //   236: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +14 -> 253
    //   242: ldc 205
    //   244: iconst_2
    //   245: ldc_w 623
    //   248: aload 5
    //   250: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 1157	java/io/ObjectInputStream:close	()V
    //   263: aload_3
    //   264: ifnull +175 -> 439
    //   267: aload_3
    //   268: invokevirtual 1158	java/io/FileInputStream:close	()V
    //   271: goto -138 -> 133
    //   274: astore 4
    //   276: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq -16 -> 263
    //   282: ldc 205
    //   284: iconst_2
    //   285: ldc_w 623
    //   288: aload 4
    //   290: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -30 -> 263
    //   296: astore_3
    //   297: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +13 -> 313
    //   303: ldc 205
    //   305: iconst_2
    //   306: ldc_w 623
    //   309: aload_3
    //   310: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: goto -180 -> 133
    //   316: astore_2
    //   317: aconst_null
    //   318: astore_3
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 1157	java/io/ObjectInputStream:close	()V
    //   329: aload_3
    //   330: ifnull +7 -> 337
    //   333: aload_3
    //   334: invokevirtual 1158	java/io/FileInputStream:close	()V
    //   337: aload_2
    //   338: athrow
    //   339: astore 4
    //   341: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq -15 -> 329
    //   347: ldc 205
    //   349: iconst_2
    //   350: ldc_w 623
    //   353: aload 4
    //   355: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: goto -29 -> 329
    //   361: astore_3
    //   362: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq -28 -> 337
    //   368: ldc 205
    //   370: iconst_2
    //   371: ldc_w 623
    //   374: aload_3
    //   375: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   378: goto -41 -> 337
    //   381: astore_2
    //   382: goto -63 -> 319
    //   385: astore 5
    //   387: aload_2
    //   388: astore 4
    //   390: aload 5
    //   392: astore_2
    //   393: goto -74 -> 319
    //   396: astore_2
    //   397: goto -78 -> 319
    //   400: astore 5
    //   402: aconst_null
    //   403: astore_2
    //   404: aconst_null
    //   405: astore 4
    //   407: goto -171 -> 236
    //   410: astore 5
    //   412: aconst_null
    //   413: astore 6
    //   415: aload_2
    //   416: astore 4
    //   418: aload 6
    //   420: astore_2
    //   421: goto -185 -> 236
    //   424: astore 5
    //   426: aload 4
    //   428: astore 6
    //   430: aload_2
    //   431: astore 4
    //   433: aload 6
    //   435: astore_2
    //   436: goto -200 -> 236
    //   439: goto -306 -> 133
    //   442: aconst_null
    //   443: astore_2
    //   444: goto -311 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	OlympicManager
    //   59	2	1	bool	boolean
    //   54	115	2	localObject1	Object
    //   170	14	2	localIOException1	java.io.IOException
    //   190	5	2	localObject2	Object
    //   199	30	2	localTorchInfo1	TorchInfo
    //   316	22	2	localObject3	Object
    //   381	7	2	localObject4	Object
    //   392	1	2	localObject5	Object
    //   396	1	2	localObject6	Object
    //   403	41	2	localObject7	Object
    //   72	55	3	localFileInputStream	java.io.FileInputStream
    //   196	17	3	localIOException2	java.io.IOException
    //   231	37	3	localObject8	Object
    //   296	14	3	localIOException3	java.io.IOException
    //   318	16	3	localObject9	Object
    //   361	14	3	localIOException4	java.io.IOException
    //   1	258	4	localTorchInfo2	TorchInfo
    //   274	51	4	localIOException5	java.io.IOException
    //   339	15	4	localIOException6	java.io.IOException
    //   388	44	4	localObject10	Object
    //   4	245	5	localObject11	Object
    //   385	6	5	localObject12	Object
    //   400	1	5	localThrowable1	Throwable
    //   410	1	5	localThrowable2	Throwable
    //   424	1	5	localThrowable3	Throwable
    //   222	11	6	localThrowable4	Throwable
    //   413	21	6	localObject13	Object
    //   10	182	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   115	119	170	java/io/IOException
    //   15	60	190	finally
    //   115	119	190	finally
    //   126	130	190	finally
    //   133	136	190	finally
    //   171	187	190	finally
    //   191	194	190	finally
    //   200	216	190	finally
    //   258	263	190	finally
    //   267	271	190	finally
    //   276	293	190	finally
    //   297	313	190	finally
    //   324	329	190	finally
    //   333	337	190	finally
    //   337	339	190	finally
    //   341	358	190	finally
    //   362	378	190	finally
    //   126	130	196	java/io/IOException
    //   64	73	222	java/lang/Throwable
    //   258	263	274	java/io/IOException
    //   267	271	296	java/io/IOException
    //   64	73	316	finally
    //   324	329	339	java/io/IOException
    //   333	337	361	java/io/IOException
    //   73	89	381	finally
    //   89	98	385	finally
    //   98	111	385	finally
    //   236	253	396	finally
    //   73	89	400	java/lang/Throwable
    //   89	98	410	java/lang/Throwable
    //   98	111	424	java/lang/Throwable
  }
  
  public TorchInfo a(torch_transfer.TorchbearerInfo paramTorchbearerInfo)
  {
    if ((paramTorchbearerInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo == null)) {
      return null;
    }
    Object localObject = new TorchInfo(paramTorchbearerInfo);
    TorchInfo localTorchInfo = this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.clone();
    localTorchInfo.transfer_num = ((TorchInfo)localObject).transfer_num;
    localTorchInfo.cur_city_id = ((TorchInfo)localObject).cur_city_id;
    localTorchInfo.reach_next_city_num = ((TorchInfo)localObject).reach_next_city_num;
    if (paramTorchbearerInfo.msg_limit_info.has())
    {
      localTorchInfo.transferOverLimit = ((TorchInfo)localObject).transferOverLimit;
      localTorchInfo.transferLimitTs = ((TorchInfo)localObject).transferLimitTs;
    }
    localTorchInfo.business_entry_seq = ((TorchInfo)localObject).business_entry_seq;
    localTorchInfo.business_entry_new = ((TorchInfo)localObject).business_entry_new;
    if (paramTorchbearerInfo.msg_torcher_rank_info.has())
    {
      if (((TorchInfo)localObject).ranking > localTorchInfo.ranking) {
        localTorchInfo.ranking = ((TorchInfo)localObject).ranking;
      }
      if ((localTorchInfo.isOnlyTorcher) && (!((TorchInfo)localObject).isOnlyTorcher)) {
        localTorchInfo.isOnlyTorcher = ((TorchInfo)localObject).isOnlyTorcher;
      }
    }
    paramTorchbearerInfo = ((TorchInfo)localObject).city_list.iterator();
    label346:
    for (;;)
    {
      if (paramTorchbearerInfo.hasNext())
      {
        localObject = (TorchInfo.CityInfo)paramTorchbearerInfo.next();
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (((TorchInfo.CityInfo)localIterator.next()).city_id != ((TorchInfo.CityInfo)localObject).city_id);
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label346;
        }
        localTorchInfo.city_list.add(localObject);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OlympicManager", 2, "add new city,id:" + ((TorchInfo.CityInfo)localObject).city_id);
        break;
        a(localTorchInfo);
        if ("handlePush0xb4, torchInfo=" + localTorchInfo == null) {}
        for (paramTorchbearerInfo = "null";; paramTorchbearerInfo = localTorchInfo.toString())
        {
          OlympicUtil.b("OlympicManager", new Object[] { paramTorchbearerInfo });
          return localTorchInfo;
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3).sendToTarget();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicManager", 2, "updateTorchbearerFlag.flag=" + paramInt + ",mTorchbearerFlag=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == paramInt) {}
    while ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 0) && (paramInt == 1)) {
      this.jdField_e_of_type_Boolean = true;
    }
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_g_of_type_Int = 0;
      }
      ThreadManager.post(new agdz(this, paramInt), 5, null, false);
      return;
    }
  }
  
  /* Error */
  public void a(OlympicPredownInfo paramOlympicPredownInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +33 -> 36
    //   6: ldc_w 558
    //   9: astore_2
    //   10: ldc 205
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc_w 1240
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_2
    //   25: aastore
    //   26: invokestatic 584	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_1
    //   30: ifnonnull +11 -> 41
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_1
    //   37: astore_2
    //   38: goto -28 -> 10
    //   41: aload_0
    //   42: getfield 179	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   45: invokevirtual 1243	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 1246	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   53: aload_0
    //   54: getfield 179	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: aload_1
    //   58: invokevirtual 1249	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   61: aload_2
    //   62: invokevirtual 1251	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   65: aload_2
    //   66: invokevirtual 1253	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   69: goto -36 -> 33
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 1114	java/lang/Exception:printStackTrace	()V
    //   88: aload_2
    //   89: invokevirtual 1253	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   92: goto -59 -> 33
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 1253	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	OlympicManager
    //   0	102	1	paramOlympicPredownInfo	OlympicPredownInfo
    //   9	88	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	29	72	finally
    //   41	49	72	finally
    //   65	69	72	finally
    //   88	92	72	finally
    //   96	102	72	finally
    //   49	65	77	java/lang/Exception
    //   49	65	95	finally
    //   78	88	95	finally
  }
  
  public void a(OlyimpicConfig paramOlyimpicConfig)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "saveConfigFile.config=" + paramOlyimpicConfig);
        }
        if (paramOlyimpicConfig != null) {
          continue;
        }
      }
      finally
      {
        try
        {
          ByteArrayOutputStream localByteArrayOutputStream;
          ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
          localObjectOutputStream.writeObject(paramOlyimpicConfig);
          localObjectOutputStream.close();
          localByteArrayOutputStream.close();
          FileUtils.a(new File(BaseApplicationImpl.sApplication.getFilesDir(), "olympic_shuayishua_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
        }
        catch (Throwable paramOlyimpicConfig)
        {
          paramOlyimpicConfig.printStackTrace();
        }
        paramOlyimpicConfig = finally;
      }
      return;
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
  }
  
  public void a(OlympicActConfig paramOlympicActConfig)
  {
    OlympicUtil.b("OlympicManager", new Object[] { "onGetActConfig" });
    if (paramOlympicActConfig == null)
    {
      OlympicUtil.b("OlympicManager", new Object[] { "onGetActConfig, config is null!" });
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig = paramOlympicActConfig;
      a();
      ThreadManager.post(new aged(this), 5, null, true);
      return;
    }
  }
  
  public void a(TorchInfo paramTorchInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "updateTorchInfo.info=" + paramTorchInfo + ",[mTorchbearerInfo] = " + this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo);
    }
    if (paramTorchInfo == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.transfer_num < paramTorchInfo.transfer_num)) {
      ThreadManager.post(new agea(this, paramTorchInfo), 5, null, false);
    }
    synchronized (this.jdField_c_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo = paramTorchInfo;
      ThreadManager.post(new ageb(this, paramTorchInfo), 5, null, false);
      return;
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (paramString == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      long l;
      try
      {
        OlympicUtil.b("OlympicManager", new Object[] { "updateEntity, url=", localObject1, ", dailyInc=", Integer.valueOf(paramInt) });
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool)
        {
          return;
          localObject1 = paramString;
          continue;
        }
        l = System.currentTimeMillis();
        localObject1 = a(paramString);
        if (localObject1 == null)
        {
          localObject1 = new OlympicPredownInfo();
          ((OlympicPredownInfo)localObject1).dailyRetryCount = 0;
          ((OlympicPredownInfo)localObject1).url = paramString;
          ((OlympicPredownInfo)localObject1).dailyStartTime = l;
          ((OlympicPredownInfo)localObject1).totalRetryCount = 0;
          a((OlympicPredownInfo)localObject1);
          continue;
        }
        if (paramBoolean) {
          break label230;
        }
      }
      finally {}
      if (((OlympicPredownInfo)localObject1).dailyStartTime >= 86400000L)
      {
        ((OlympicPredownInfo)localObject1).dailyRetryCount = paramInt;
        ((OlympicPredownInfo)localObject1).dailyStartTime = l;
        ((OlympicPredownInfo)localObject1).totalRetryCount += paramInt;
        label170:
        paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      }
      try
      {
        paramString.a();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
        paramString.c();
        paramString.b();
        continue;
        ((OlympicPredownInfo)localObject1).dailyRetryCount += paramInt;
        ((OlympicPredownInfo)localObject1).totalRetryCount += paramInt;
        break label170;
        label230:
        ((OlympicPredownInfo)localObject1).dailyRetryCount = 0;
        ((OlympicPredownInfo)localObject1).dailyStartTime = l;
        ((OlympicPredownInfo)localObject1).totalRetryCount = 0;
        break label170;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        paramString.b();
      }
      finally
      {
        paramString.b();
      }
    }
  }
  
  public void a(submsgtype0x78.MsgBody paramMsgBody)
  {
    boolean bool = paramMsgBody.uint32_version.has();
    int i = paramMsgBody.uint32_version.get();
    int j = b();
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "handlePush, " + bool + ", " + j + ", " + i);
    }
    if ((i != j) && (bool)) {
      OlympicServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean(paramString, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("OlympicManager", 2, "getOlympicSettingFlag " + paramString + " " + paramBoolean);
    }
    return paramBoolean;
  }
  
  public int b()
  {
    OlyimpicConfig localOlyimpicConfig2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig;
    OlyimpicConfig localOlyimpicConfig1 = localOlyimpicConfig2;
    if (localOlyimpicConfig2 == null) {
      localOlyimpicConfig1 = a();
    }
    if (localOlyimpicConfig1 == null) {
      return 0;
    }
    return localOlyimpicConfig1.version;
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "deleteConfigFile...");
      }
      File localFile = new File(BaseApplicationImpl.sApplication.getFilesDir(), "olympic_shuayishua_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if ((localFile.delete()) && (!localFile.delete()))
      {
        boolean bool = localFile.delete();
        if (!bool) {}
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
        {
          bool = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.save2File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          OlympicUtil.b("OlympicManager", new Object[] { "saveActConfigToLocal, result=", Boolean.valueOf(bool) });
          return bool;
        }
      }
      boolean bool = false;
      continue;
      bool = false;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    int j;
    label55:
    label102:
    label113:
    label119:
    do
    {
      long l;
      do
      {
        return bool1;
        paramString = a(paramString);
        l = System.currentTimeMillis();
        bool1 = bool2;
      } while (paramString == null);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
      {
        i = 3;
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC != null) {
          break label102;
        }
        j = 1000;
        if ((paramString.dailyRetryCount < i) || (paramString.totalRetryCount >= j)) {
          break label119;
        }
        if (l - paramString.dailyStartTime <= 86400000L) {
          break label113;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        return bool1;
        i = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Int;
        break;
        j = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Int;
        break label55;
      }
      bool1 = bool2;
    } while (paramString.totalRetryCount < j);
    return false;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 556	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 136	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokestatic 611	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: invokestatic 1375	com/tencent/mobileqq/olympic/OlympicActConfig:readFromFile	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +18 -> 44
    //   29: ldc 205
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: ldc_w 1377
    //   40: aastore
    //   41: invokestatic 584	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: getfield 88	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ArrayOfByte	[B
    //   48: astore_2
    //   49: aload_2
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 556	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   55: ifnonnull +44 -> 99
    //   58: aload_0
    //   59: aload_1
    //   60: putfield 556	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_0
    //   66: invokevirtual 1286	com/tencent/mobileqq/olympic/OlympicManager:a	()V
    //   69: goto -58 -> 11
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +13 -> 94
    //   84: ldc 205
    //   86: iconst_2
    //   87: ldc_w 1379
    //   90: aload_1
    //   91: invokestatic 1381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   94: aconst_null
    //   95: astore_1
    //   96: goto -71 -> 25
    //   99: aload_1
    //   100: ifnull -37 -> 63
    //   103: ldc 205
    //   105: iconst_2
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: ldc_w 1383
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_0
    //   118: getfield 556	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   121: getfield 1384	com/tencent/mobileqq/olympic/OlympicActConfig:version	I
    //   124: invokestatic 742	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokestatic 584	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_0
    //   132: getfield 556	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   135: getfield 1384	com/tencent/mobileqq/olympic/OlympicActConfig:version	I
    //   138: aload_1
    //   139: getfield 1384	com/tencent/mobileqq/olympic/OlympicActConfig:version	I
    //   142: if_icmpge -79 -> 63
    //   145: aload_0
    //   146: aload_1
    //   147: putfield 556	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   150: ldc 205
    //   152: iconst_2
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: ldc_w 1386
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload_1
    //   165: getfield 1384	com/tencent/mobileqq/olympic/OlympicActConfig:version	I
    //   168: invokestatic 742	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: aastore
    //   172: invokestatic 584	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: goto -112 -> 63
    //   178: astore_1
    //   179: aload_2
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	OlympicManager
    //   6	54	1	localOlympicActConfig	OlympicActConfig
    //   72	4	1	localObject1	Object
    //   77	14	1	localException	Exception
    //   95	70	1	localObject2	Object
    //   178	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	72	finally
    //   14	25	72	finally
    //   29	44	72	finally
    //   44	51	72	finally
    //   65	69	72	finally
    //   78	94	72	finally
    //   181	183	72	finally
    //   14	25	77	java/lang/Exception
    //   51	63	178	finally
    //   63	65	178	finally
    //   103	175	178	finally
    //   179	181	178	finally
  }
  
  public boolean c()
  {
    boolean bool = false;
    OlympicUtil.b("OlympicManager", new Object[] { "isNetworkCanPredown" });
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null) {}
    for (int i = 0; i == 1; i = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Int) {
      return true;
    }
    int j = NetworkUtil.a(BaseApplicationImpl.getContext());
    OlympicUtil.b("OlympicManager", new Object[] { "isNetworkCanPredown, type=", Integer.valueOf(j) });
    if (i == 0) {
      if ((j != 1) && (j != 4)) {}
    }
    for (bool = true;; bool = true) {
      do
      {
        return bool;
      } while ((j != 1) && (j != 4) && (j != 3));
    }
  }
  
  public void d()
  {
    boolean bool2 = true;
    int i;
    int j;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC = new OlympicDPC();
      i = (int)(DeviceInfoUtil.e() / 1024L / 1024L);
      j = ViewUtils.a();
      str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.olympic_act_config.name());
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_JavaLangString = str;
    }
    try
    {
      if (str.length() > 0)
      {
        String[] arrayOfString = str.split("\\|");
        if (arrayOfString.length >= 9)
        {
          if (i <= Integer.valueOf(arrayOfString[0]).intValue()) {}
          for (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;; this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true)
          {
            if (Integer.valueOf(arrayOfString[3]).intValue() == 1) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Boolean = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[4]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Int = Integer.valueOf(arrayOfString[5]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Int = Integer.valueOf(arrayOfString[6]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Int = Integer.valueOf(arrayOfString[7]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_e_of_type_Int = Integer.valueOf(arrayOfString[8]).intValue();
            bool1 = false;
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Boolean = bool1;
            if (bool1)
            {
              if (i > 512) {
                break label487;
              }
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Int = 0;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Int = 3;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Int = 1000;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Int = 1;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_e_of_type_Int = 1;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Int != 1) {
              break label523;
            }
            OlympicUtil.a(bool2);
            if (QLog.isColorLevel()) {
              QLog.d("OlympicManager", 2, "loadDPCConfig|featureValue:" + str + ",systemTotalMem:" + i + ",screenWidth:" + j + ",isUseDefault:" + bool1 + ",dpc:" + this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.toString());
            }
            return;
            if (j > Integer.valueOf(arrayOfString[1]).intValue()) {
              break;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "loadDPCConfig Exception:" + localException.toString());
        }
        boolean bool1 = true;
        continue;
        label523:
        if (j <= Integer.valueOf(localException[2]).intValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Boolean = true;
          continue;
          label487:
          if (j <= 480)
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;
          }
          else if (j <= 720)
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Boolean = true;
            continue;
            bool2 = false;
          }
        }
      }
    }
  }
  
  public boolean d()
  {
    OlympicUtil.b("OlympicManager", new Object[] { "isNetworkCanPredown" });
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null) {}
    for (int i = 1; i == 1; i = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_e_of_type_Int) {
      return true;
    }
    return false;
  }
  
  public void e()
  {
    OlympicUtil.b("OlympicManager", new Object[] { "clearActConfig" });
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig = null;
      a();
      return;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("MsgTabBG", "Wording");
      if ((str == null) || (!str.contains("alltaskoff"))) {
        break label75;
      }
    }
    label75:
    for (bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "isCloseOlympicEntrace result = " + bool1);
      }
      return bool1;
    }
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 556	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   6: ifnonnull +15 -> 21
    //   9: ldc 205
    //   11: iconst_1
    //   12: ldc_w 1467
    //   15: invokestatic 242	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 556	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   26: iconst_0
    //   27: invokespecial 1469	com/tencent/mobileqq/olympic/OlympicManager:a	(Lcom/tencent/mobileqq/olympic/OlympicActConfig;Z)V
    //   30: goto -12 -> 18
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	OlympicManager
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	33	finally
    //   21	30	33	finally
  }
  
  public void g()
  {
    if (OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_config_act"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act" });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig == null) {
        break label106;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.version));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "olympic_config_act", false, 0L, 0L, localHashMap, "", false);
    }
    for (;;)
    {
      OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_config_act");
      return;
      label106:
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "olympic_config_act", true, 0L, 0L, null, "", false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    long l = 0L;
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "handleMessage, MSG_UPDATE_CONFIG ,msg.obj = " + paramMessage.obj + ",mTorchbearerFlag = " + this.jdField_a_of_type_Int);
      }
      if (paramMessage.obj == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig = null;
        this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig = null;
        if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener.a();
        }
        this.jdField_b_of_type_Long = 2500L;
        this.jdField_c_of_type_Long = 180000L;
        this.jdField_d_of_type_Long = 180000L;
      }
      for (;;)
      {
        l = NetConnInfoCenter.getServerTimeMillis();
        b(l);
        a(l);
        break;
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig = ((OlyimpicConfig)paramMessage.obj);
        this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig.grabInterval;
        this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig.reportActiveInterval;
        this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig.reportNormalInterval;
        this.jdField_c_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener.a(this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo);
        continue;
        l = ((Long)paramMessage.obj).longValue();
        if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 0) && (l > 0L)) {
          this.jdField_b_of_type_AndroidOsHandler.post(new OlympicManager.ShuayishuaReport(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, l, false));
        }
        this.jdField_e_of_type_Int = 0;
        this.jdField_d_of_type_Int = 0;
        this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
        continue;
        this.jdField_b_of_type_AndroidOsHandler.post(new OlympicManager.ShuayishuaReport(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 2, 0, 0, 0L, false));
        this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 600000L);
        continue;
        this.jdField_g_of_type_Int = 0;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig != null)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig);
          continue;
          i = paramMessage.arg1;
          if (paramMessage.arg2 == 1) {}
          for (boolean bool = true;; bool = false)
          {
            if (QLog.isColorLevel()) {
              QLog.d("OlympicManager", 2, "MSG_BREATHE,type = " + i + ",isRecovery = " + bool);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener.a(true, bool, i);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("in_breath_procedure", false).commit();
          if (QLog.isColorLevel()) {
            QLog.d("OlympicManager", 2, "MSG_STOP_BREATHE");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener.a(false, false, -1);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.type == 2))
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new OlympicManager.ShuayishuaReport(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin, true));
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
    }
    if (this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 0)
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new OlympicManager.ShuayishuaReport(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 2, 0, 0, 0L, true));
      this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources$DownloadListener);
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((i >= 3) || (this.jdField_a_of_type_ArrayOfInt[i] == paramInt1)) {
      if (i != 3) {
        break label36;
      }
    }
    label36:
    while (paramInt2 != 0)
    {
      return;
      i += 1;
      break;
    }
    this.jdField_a_of_type_ArrayOfBoolean[i] = true;
    a(i, true);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "onReceive, " + paramInt + ", " + paramBoolean + ", " + paramBundle);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramBundle);
      return;
    }
    b(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicManager
 * JD-Core Version:    0.7.0.1
 */