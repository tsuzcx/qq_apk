import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class oqr
{
  private static volatile oqr jdField_a_of_type_Oqr;
  public static boolean a;
  public int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences("ReadInJoySuperMaskAd", 0);
  public AdvertisementInfo a;
  private WeakReference<ListView> jdField_a_of_type_JavaLangRefWeakReference;
  oqs jdField_a_of_type_Oqs = null;
  public osa a;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  
  private static long a(long paramLong)
  {
    return (TimeZone.getTimeZone("GMT+8").getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  public static oqr a()
  {
    if (jdField_a_of_type_Oqr == null) {}
    try
    {
      if (jdField_a_of_type_Oqr == null) {
        jdField_a_of_type_Oqr = new oqr();
      }
      return jdField_a_of_type_Oqr;
    }
    finally {}
  }
  
  private void a(long paramLong, int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = str + "_" + paramLong + "_" + paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    oqh.a("ReadInJoySuperMaskAd", "setAdInfoExposure: aid = " + paramLong + " adSource = " + paramInt);
    localEditor.putBoolean(str, true);
    localEditor.apply();
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt)
  {
    if (oqj.l(paramAdvertisementInfo)) {}
    try
    {
      if (paramAdvertisementInfo.mAdvertisementExtInfo.n == 3) {
        paramJSONObject2.put("is_transparent", "1");
      }
      while (paramInt == nxw.jdField_a_of_type_Int)
      {
        nxw.a(null, "0X8009819", "0X8009819", 0, 0, "", "", "", b());
        if (paramAdvertisementInfo.mAdvertisementExtInfo.n != 1) {
          paramJSONObject2.put("volumn", paramAdvertisementInfo.mAdvertisementExtInfo.f);
        }
        if (paramJSONObject1 == null) {
          break label158;
        }
        paramJSONObject1.put("click_info_report", String.valueOf(paramJSONObject2));
        return;
        if (paramAdvertisementInfo.mAdvertisementExtInfo.n == 2) {
          paramJSONObject2.put("is_transparent", "");
        }
      }
      if (paramInt == nxw.jdField_b_of_type_Int)
      {
        if (paramJSONObject1 != null) {
          paramJSONObject1.put("exposure_info_report", String.valueOf(paramJSONObject2));
        }
        nxw.a(null, "0X8008C80", "0X8008C80", 0, 0, "", "", "", b());
      }
      label158:
      return;
    }
    catch (Exception paramAdvertisementInfo) {}
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 0);
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = str + "_" + paramLong + "_" + paramInt;
    boolean bool2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(str, false);
    if (!b()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      oqh.a("ReadInJoySuperMaskAd", "getAdInfoExposure: aid = " + paramLong + " adSource = " + paramInt + " hasExposure = " + bool2 + " inOneDay = " + bool1);
      if ((!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static String b()
  {
    try
    {
      String str = pha.a().a("ad_mengceng", String.valueOf(1)).a();
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public static boolean e()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(206);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("ad_mengceng", 0);
      QLog.d("ReadInJoySuperMaskAd", 1, new Object[] { "should show super mask, value = ", Integer.valueOf(i) });
      return i == 1;
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    long l1;
    if (this.jdField_b_of_type_Int < 0) {
      l1 = NetConnInfoCenter.getServerTimeMillis();
    }
    String str;
    long l2;
    do
    {
      return l1;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(a(this.jdField_b_of_type_Int), -1L);
      l1 = l2;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoySuperMaskAd", 2, "current uni last show time : " + str + " at time: " + l2);
    return l2;
  }
  
  public MaterialData a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo == null)) {
      return null;
    }
    Iterator localIterator = oon.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2).iterator();
    while (localIterator.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)localIterator.next();
      if ((localMaterialData.adid.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid))) && (localMaterialData.ad_source.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j)))) {
        return localMaterialData;
      }
    }
    return null;
  }
  
  public ListView a()
  {
    return (ListView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo == null) || (!d())) {
      return "";
    }
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = oon.a((QQAppInterface)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
    Object localObject2 = new File(str, "manifest.json");
    if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile()) || (!((File)localObject2).canRead()))
    {
      oon.a((QQAppInterface)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
      return "";
    }
    Object localObject3 = new StringBuffer();
    fd.a((StringBuffer)localObject3, ((File)localObject2).getPath());
    localObject2 = ((StringBuffer)localObject3).toString();
    try
    {
      localObject3 = new JSONObject((String)localObject2);
      localObject2 = ((JSONObject)localObject3).getString("animFileName");
      this.jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("superMaskType", 1);
      if (localObject2 != null)
      {
        localObject3 = new File(str, (String)localObject2);
        if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile()) || (!((File)localObject3).canRead()))
        {
          oon.a((QQAppInterface)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
          return "";
        }
        localObject1 = str + (String)localObject2;
        return localObject1;
      }
    }
    catch (JSONException localJSONException)
    {
      return "";
    }
    return "";
  }
  
  public String a(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return str + "_" + paramInt + "_" + "RIJSuperMaskLastShowMaskTimeKey";
  }
  
  public ArrayList a()
  {
    Object localObject = oon.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2);
    ArrayList localArrayList = new ArrayList();
    localObject = ((CopyOnWriteArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MaterialData localMaterialData = (MaterialData)((Iterator)localObject).next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("adId", localMaterialData.adid);
      localHashMap.put("adSource", localMaterialData.ad_source);
      localHashMap.put("adMaterial", localMaterialData.ad_material);
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int < 0) {}
    String str;
    long l;
    do
    {
      return;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      l = NetConnInfoCenter.getServerTimeMillis();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putLong(a(this.jdField_b_of_type_Int), l);
      localEditor.apply();
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoySuperMaskAd", 2, "current uni won't show today : " + str + " at time: " + l);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Oqs != null) {
      this.jdField_a_of_type_Oqs.a(paramInt, paramBoolean);
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (!oqj.l(paramAdvertisementInfo))
    {
      oqh.a("ReadInJoySuperMaskAd", "isNotSuperMaskAdType");
      return;
    }
    if (!b())
    {
      oqh.a("ReadInJoySuperMaskAd", "notShowLargeThanOneDay");
      return;
    }
    if (!e())
    {
      oqh.a("ReadInJoySuperMaskAd", "notGetShowConfigFromAladdin");
      return;
    }
    if (this.jdField_c_of_type_Int == 4)
    {
      this.jdField_c_of_type_Int = 0;
      return;
    }
    b(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((oqj.l(paramAdvertisementInfo)) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (paramInt == nxw.jdField_b_of_type_Int)) {
      a(paramAdvertisementInfo.mAdAid, paramAdvertisementInfo.mAdvertisementExtInfo.j);
    }
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramListView);
  }
  
  public void a(oqs paramoqs)
  {
    this.jdField_a_of_type_Oqs = paramoqs;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Osa != null) && (this.jdField_a_of_type_Osa.a())) {
      this.jdField_a_of_type_Osa.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((oqj.l(paramAdvertisementInfo)) && (paramAdvertisementInfo.mAdvertisementExtInfo != null)) {
      return a(paramAdvertisementInfo.mAdAid, paramAdvertisementInfo.mAdvertisementExtInfo.j);
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null)) {
      if (!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        break label120;
      }
    }
    label120:
    for (int i = nxw.N;; i = nxw.ap)
    {
      oqh.a("ReadInJoySuperMaskAd", "Exposure for outer mask, origin = " + i + " adInfo = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid);
      nxw.a(new omp().a(BaseApplication.getContext()).a(nxw.jdField_b_of_type_Int).b(i).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(new JSONObject()).a());
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if ((paramInt == 4) && (this.jdField_a_of_type_Osa != null) && (this.jdField_a_of_type_Osa.a())) {
      this.jdField_a_of_type_Osa.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "setShouldAskSuperMask = " + paramBoolean);
    }
    if ((b()) && (e()))
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if (pha.y()) {
      QLog.d("ReadInJoySuperMaskAd", 1, "should not show super mask, isFloatWindowShowing = true");
    }
    for (;;)
    {
      return false;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = a();
      if ((l1 - l2 < 86400000L) && (a(l1) == a(l2))) {}
      for (int i = 1; (i == 0) || (l2 == -1L) || (f()); i = 0) {
        return true;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Osa != null) {
      this.jdField_a_of_type_Osa = null;
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null))
    {
      if (paramInt == 1)
      {
        jdField_a_of_type_Boolean = true;
        oat.a(null, "", "0X8009819", "0X8009819", 0, 0, "", "", "", b(), false);
      }
    }
    else {
      return;
    }
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      if ((paramInt == nxw.jdField_a_of_type_Int) || (paramInt == nxw.C))
      {
        localJSONObject2.put("volumn", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.f);
        if (this.jdField_a_of_type_Int != 1)
        {
          if (this.jdField_a_of_type_Int != 3) {
            break label238;
          }
          String str1 = "1";
          label117:
          localJSONObject2.put("is_transparent", str1);
        }
        localJSONObject1.put("click_info_report", String.valueOf(localJSONObject2));
        nxw.a(new omp().a(BaseApplication.getContext()).a(paramInt).b(nxw.ap).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(localJSONObject1).a());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoySuperMaskAd", 1, new Object[] { "JSONException", localJSONException.toString() });
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.f.equals("1")) {}
    for (String str2 = "0";; str2 = "1")
    {
      localJSONObject2.put("volumn", str2);
      break;
      label238:
      str2 = "";
      break label117;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return (this.jdField_b_of_type_Int == 0) || (pil.c(this.jdField_b_of_type_Int));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Oqs != null) {
      this.jdField_a_of_type_Oqs = null;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Oqs != null) {
      this.jdField_a_of_type_Oqs.a(paramInt);
    }
  }
  
  public boolean d()
  {
    Iterator localIterator = oon.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2).iterator();
    while (localIterator.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)localIterator.next();
      if ((localMaterialData.ad_source.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j))) && (localMaterialData.adid.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid))) && (localMaterialData.res_version == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.r)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean f()
  {
    return bgsg.aA(BaseApplicationImpl.getApplication(), BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqr
 * JD-Core Version:    0.7.0.1
 */