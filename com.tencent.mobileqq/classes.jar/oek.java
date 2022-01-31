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
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class oek
{
  private static volatile oek jdField_a_of_type_Oek;
  public static boolean b;
  public int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences("ReadInJoySuperMaskAd", 0);
  public AdvertisementInfo a;
  private WeakReference<ListView> jdField_a_of_type_JavaLangRefWeakReference;
  oel jdField_a_of_type_Oel = null;
  public ofh a;
  public boolean a;
  private int b;
  private boolean c;
  private boolean d;
  
  private oek()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private static long a(long paramLong)
  {
    return (TimeZone.getTimeZone("GMT+8").getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  public static oek a()
  {
    if (jdField_a_of_type_Oek == null) {}
    try
    {
      if (jdField_a_of_type_Oek == null) {
        jdField_a_of_type_Oek = new oek();
      }
      return jdField_a_of_type_Oek;
    }
    finally {}
  }
  
  public static String b()
  {
    try
    {
      String str = ors.a().a("ad_mengceng", String.valueOf(1)).a();
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public static boolean c()
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
  
  private boolean f()
  {
    if (ors.w()) {
      QLog.d("ReadInJoySuperMaskAd", 1, "should not show super mask, isFloatWindowShowing = true");
    }
    for (;;)
    {
      return false;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = a();
      if ((l1 - l2 < 86400000L) && (a(l1) == a(l2))) {}
      for (int i = 1; (i == 0) || (l2 == -1L) || (d()); i = 0) {
        return true;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str + "_" + "RIJSuperMaskLastShowMaskTimeKey", -1L);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "current uni last show time : " + str + " at time: " + l);
    }
    return l;
  }
  
  public MaterialData a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo == null)) {
      return null;
    }
    Iterator localIterator = ocx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2).iterator();
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo == null) || (!b())) {
      return "";
    }
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = ocx.a((QQAppInterface)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
    Object localObject2 = new File(str, "manifest.json");
    if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile()) || (!((File)localObject2).canRead()))
    {
      ocx.a((QQAppInterface)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
      return "";
    }
    Object localObject3 = new StringBuffer();
    ey.a((StringBuffer)localObject3, ((File)localObject2).getPath());
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
          ocx.a((QQAppInterface)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
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
  
  public ArrayList a()
  {
    Object localObject = ocx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2);
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
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
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong(str + "_" + "RIJSuperMaskLastShowMaskTimeKey", l);
    localEditor.apply();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "current uni won't show today : " + str + " at time: " + l);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if ((paramInt == 4) && (this.jdField_a_of_type_Ofh != null) && (this.jdField_a_of_type_Ofh.a())) {
      this.jdField_a_of_type_Ofh.a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Oel != null) {
      this.jdField_a_of_type_Oel.a(paramInt, paramBoolean);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = str + "_" + String.valueOf(paramLong) + "_" + String.valueOf(paramInt);
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putBoolean(str, true);
    localEditor.apply();
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((!oee.m(paramAdvertisementInfo)) || (!f()) || (!c())) {
      return;
    }
    if (this.jdField_b_of_type_Int == 4)
    {
      this.jdField_b_of_type_Int = 0;
      return;
    }
    a(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramListView);
  }
  
  public void a(oel paramoel)
  {
    this.jdField_a_of_type_Oel = paramoel;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ofh != null) && (this.jdField_a_of_type_Ofh.a())) {
      this.jdField_a_of_type_Ofh.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (d()) {
      return true;
    }
    return this.c;
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = str + "_" + String.valueOf(paramLong) + "_" + String.valueOf(paramInt);
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(str, false))
    {
      bool1 = bool2;
      if (!f()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null)) {
      noy.a(new obk().a(BaseApplication.getContext()).a(noy.jdField_b_of_type_Int).b(noy.an).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(new JSONObject()).a());
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null))
    {
      if (paramInt == 1)
      {
        jdField_b_of_type_Boolean = true;
        nrt.a(null, "", "0X8009819", "0X8009819", 0, 0, "", "", "", b(), false);
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
      if ((paramInt == noy.jdField_a_of_type_Int) || (paramInt == noy.B))
      {
        localJSONObject2.put("volumn", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.f);
        if (this.jdField_a_of_type_Int != 1)
        {
          if (this.jdField_a_of_type_Int != 3) {
            break label246;
          }
          String str1 = "1";
          label121:
          localJSONObject2.put("is_transparent", str1);
        }
        localJSONObject1.put("click_info_report", String.valueOf(localJSONObject2));
        noy.a(new obk().a(BaseApplication.getContext()).a(paramInt).b(noy.an).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(localJSONObject1).a());
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
      label246:
      str2 = "";
      break label121;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "setShouldAskSuperMask = " + paramBoolean);
    }
    if ((f()) && (c()))
    {
      this.c = paramBoolean;
      return;
    }
    this.c = false;
  }
  
  public boolean b()
  {
    Iterator localIterator = ocx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2).iterator();
    while (localIterator.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)localIterator.next();
      if ((localMaterialData.ad_source.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j))) && (localMaterialData.adid.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid))) && (localMaterialData.res_version == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.r)) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ofh != null) {
      this.jdField_a_of_type_Ofh = null;
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Oel != null) {
      this.jdField_a_of_type_Oel.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean d()
  {
    return bdne.aA(BaseApplicationImpl.getApplication(), BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 1;
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oek
 * JD-Core Version:    0.7.0.1
 */