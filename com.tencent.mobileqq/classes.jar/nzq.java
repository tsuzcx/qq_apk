import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.AdMaterialResManager.2;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.AdMaterialResManager.3;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class nzq
  extends pyz
{
  private String jdField_a_of_type_JavaLangString = "adMaterial";
  private List<MaterialData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private nzp jdField_a_of_type_Nzp = new nzr(this);
  private ArrayList<MaterialData> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, MaterialData> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public nzq(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private Long a(MaterialData paramMaterialData)
  {
    paramMaterialData = this.jdField_a_of_type_Aukn.a(MaterialData.class, MaterialData.class.getSimpleName(), true, "id=?", new String[] { String.valueOf(paramMaterialData.id) }, null, null, null, null);
    if ((paramMaterialData != null) && (paramMaterialData.size() == 1)) {
      return Long.valueOf(((MaterialData)paramMaterialData.get(0)).getId());
    }
    return Long.valueOf(-1L);
  }
  
  private List<MaterialData> a()
  {
    return this.jdField_a_of_type_Aukn.a(MaterialData.class);
  }
  
  private List<MaterialData> a(int paramInt)
  {
    long l = NetConnInfoCenter.getServerTime();
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if (paramInt == -1) {
      return this.jdField_a_of_type_Aukn.a(MaterialData.class, MaterialData.class.getSimpleName(), true, "uin=? and end_time>? and isReady=?", new String[] { str, String.valueOf(l), String.valueOf(1) }, null, null, null, null);
    }
    return this.jdField_a_of_type_Aukn.a(MaterialData.class, MaterialData.class.getSimpleName(), true, "uin=? and end_time>? and isReady=? and ad_type=?", new String[] { str, String.valueOf(l), String.valueOf(1), String.valueOf(paramInt) }, null, null, null, null);
  }
  
  private ConcurrentHashMap<String, MaterialData> a()
  {
    Object localObject2 = new ArrayList();
    try
    {
      localObject1 = a(-1);
      if (localObject1 == null) {
        break label109;
      }
      localObject2 = new ConcurrentHashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        MaterialData localMaterialData = (MaterialData)((Iterator)localObject1).next();
        ((ConcurrentHashMap)localObject2).put(localMaterialData.id, localMaterialData);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("AdMaterialResManager", 2, "getMaterialDataList query  failed " + QLog.getStackTraceString(localException));
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
    label109:
    return new ConcurrentHashMap();
  }
  
  public static nzq a(QQAppInterface paramQQAppInterface)
  {
    return (nzq)paramQQAppInterface.getManager(337);
  }
  
  private void a(MaterialData paramMaterialData)
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMaterialData.id);
      }
      bbdj.a(paramMaterialData.res_path, false);
      this.jdField_a_of_type_Aukn.a(MaterialData.class.getSimpleName(), "id=? ", new String[] { String.valueOf(paramMaterialData.id) });
      return;
    }
    catch (Exception paramMaterialData)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AdMaterialResManager", 2, "clearExpireData failed " + QLog.getStackTraceString(paramMaterialData));
    }
  }
  
  public static void a(MaterialData paramMaterialData, boolean paramBoolean, String paramString)
  {
    a(paramMaterialData, paramBoolean, paramString, null, "resource_download_key");
  }
  
  public static void a(MaterialData paramMaterialData, boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramMaterialData, paramBoolean, paramString1, paramString2, "resource_fetch_key");
  }
  
  private static void a(MaterialData paramMaterialData, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("result", i);
        localJSONObject.put("reason", paramString1);
        localJSONObject.put("os", "Android");
        if ((!paramString3.equals("resource_fetch_key")) && (paramMaterialData != null))
        {
          localJSONObject.put("adId", paramMaterialData.adid);
          localJSONObject.put("adSource", paramMaterialData.ad_source);
          localJSONObject.put("resUrl", paramMaterialData.url);
          localJSONObject.put("resMD5", paramMaterialData.res_md5);
          localJSONObject.put("version", paramMaterialData.res_version);
          localJSONObject.put("type", paramMaterialData.ad_type);
          localJSONObject.put("startTime", paramMaterialData.start_time);
          localJSONObject.put("endTime", paramMaterialData.end_time);
          localJSONObject.put("delivery_effect", paramMaterialData.delivery_effect);
        }
        if (paramString2 != null) {
          localJSONObject.put("content", paramString2);
        }
        axpw.a(localQQAppInterface, "sendtdbank|b_pcg_ffc_game_dev_qq_kandian_commercial|ad_resource_statistics_report", paramString3 + "|" + localJSONObject.toString(), true);
        return;
      }
      catch (Exception paramMaterialData)
      {
        return;
      }
      i = 0;
    }
  }
  
  private void a(String paramString)
  {
    ThreadManagerV2.excute(new AdMaterialResManager.3(this, paramString), 64, null, true);
  }
  
  private void a(ArrayList<MaterialData> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      b(paramArrayList);
      a(paramArrayList);
      this.jdField_a_of_type_JavaUtilList = b();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label86;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "ad_material need download num =  " + this.jdField_a_of_type_JavaUtilList.size());
      }
      a(this.jdField_a_of_type_JavaUtilList);
    }
    label86:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("AdMaterialResManager", 2, "ad_material are already downloaded ");
  }
  
  private boolean a(ArrayList<MaterialData> paramArrayList)
  {
    for (;;)
    {
      MaterialData localMaterialData;
      try
      {
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        localMaterialData = (MaterialData)paramArrayList.next();
        long l = a(localMaterialData).longValue();
        if (l != -1L)
        {
          localMaterialData.setId(l);
          localMaterialData.setStatus(1001);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AdMaterialResManager", 4, "[insert new] already had set data adid = " + localMaterialData.adid);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label170;
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "[insert new]  failed " + QLog.getStackTraceString(paramArrayList));
        }
        return false;
      }
      QLog.d("AdMaterialResManager", 4, "[insert new] data adid =  " + localMaterialData.adid);
      label170:
      this.jdField_a_of_type_Aukn.b(localMaterialData);
    }
    return true;
  }
  
  private List<MaterialData> b()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      localObject = this.jdField_a_of_type_Aukn.a(MaterialData.class, MaterialData.class.getSimpleName(), true, "uin=? and end_time>? and isReady=?", new String[] { localObject, String.valueOf(l), String.valueOf(0) }, null, null, null, null);
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "getMaterialDataList query  failed " + QLog.getStackTraceString(localException));
      }
    }
    return localArrayList;
  }
  
  private void b(MaterialData paramMaterialData)
  {
    paramMaterialData.res_path = "";
    paramMaterialData.isReady = false;
    this.jdField_a_of_type_Aukn.a(paramMaterialData);
  }
  
  public static void b(MaterialData paramMaterialData, boolean paramBoolean, String paramString)
  {
    a(paramMaterialData, paramBoolean, paramString, null, "resource_use_key");
  }
  
  private void b(ArrayList<MaterialData> paramArrayList)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    Object localObject = a();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    Iterator localIterator1 = ((List)localObject).iterator();
    if (localIterator1.hasNext())
    {
      localObject = (MaterialData)localIterator1.next();
      Iterator localIterator2 = paramArrayList.iterator();
      label72:
      if (localIterator2.hasNext())
      {
        MaterialData localMaterialData = (MaterialData)localIterator2.next();
        if ((!((MaterialData)localObject).id.equals(localMaterialData.id)) || ((((MaterialData)localObject).res_md5.equals(localMaterialData.res_md5)) && (((MaterialData)localObject).res_version == localMaterialData.res_version))) {
          break label233;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "not the same res_version or md5 update material data ,id =  " + ((MaterialData)localObject).id);
        }
        long l = ((MaterialData)localObject).getId();
        localObject = ((MaterialData)localObject).res_path;
        localMaterialData.setId(l);
        localMaterialData.setStatus(1001);
        localMaterialData.res_path = ((String)localObject);
        localArrayList.add(localMaterialData);
        localObject = localMaterialData;
      }
    }
    label233:
    for (;;)
    {
      break label72;
      break;
      b(localArrayList);
      return;
    }
  }
  
  private void b(List<MaterialData> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() != 0)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MaterialData localMaterialData = (MaterialData)paramList.next();
            bbdj.a(localMaterialData.res_path, false);
            localMaterialData.res_path = "";
            if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
              this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localMaterialData.id, localMaterialData);
            }
            if ((!this.jdField_a_of_type_Aukn.a(localMaterialData)) && (QLog.isColorLevel())) {
              QLog.d("AdMaterialResManager", 2, "updateDataByList failed data id =  " + localMaterialData.id);
            }
          }
        }
        return;
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "updateDataByList failed " + QLog.getStackTraceString(paramList));
        }
      }
    }
  }
  
  private List<MaterialData> c()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      List localList = this.jdField_a_of_type_Aukn.a(MaterialData.class, MaterialData.class.getSimpleName(), true, "uin=? and end_time<?", new String[] { this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), String.valueOf(l) }, null, null, null, null);
      return localList;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "getMaterialDataList query  failed " + QLog.getStackTraceString(localException));
      }
    }
    return localArrayList;
  }
  
  private void c()
  {
    Object localObject = c();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((MaterialData)((Iterator)localObject).next());
      }
    }
  }
  
  private void c(MaterialData paramMaterialData)
  {
    a(this.jdField_a_of_type_JavaLangString, paramMaterialData, 1);
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1) != null))
    {
      paramString1 = (MaterialData)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString1 != null)
      {
        if (bbdj.a(paramString1.res_path)) {
          return paramString1.res_path;
        }
        b(paramString1);
      }
    }
    return "";
  }
  
  public ArrayList<MaterialData> a(int paramInt)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((MaterialData)localEntry.getValue()).ad_type == paramInt) {
        if (bbdj.a(((MaterialData)localEntry.getValue()).res_path)) {
          this.jdField_b_of_type_JavaUtilArrayList.add(localEntry.getValue());
        } else {
          b((MaterialData)localEntry.getValue());
        }
      }
    }
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_Nzp != null))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Nzp);
      ThreadManagerV2.excute(new AdMaterialResManager.2(this), 32, null, true);
    }
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.isReady = true;
    paramBaseResData.business = paramString;
    if ((paramBaseResData instanceof MaterialData))
    {
      ((MaterialData)paramBaseResData).res_path = b(paramString, paramBaseResData.id);
      if (bbdj.a(((MaterialData)paramBaseResData).res_path)) {
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "download finish update db material res_path file not exist  id = " + paramBaseResData.id);
      }
      a((MaterialData)paramBaseResData, false, "res_path file not exist");
    }
    label93:
    do
    {
      do
      {
        return;
        a((MaterialData)paramBaseResData, true, "no error");
        paramBaseResData.setStatus(1001);
        if (!this.jdField_a_of_type_Aukn.a(paramBaseResData)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "download finish update db material id = " + paramBaseResData.id);
        }
      } while (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramBaseResData.id, (MaterialData)paramBaseResData);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("AdMaterialResManager", 2, "download finish update db material failed  id = " + paramBaseResData.id);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1) != null))
    {
      paramString2 = (MaterialData)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      bbdj.a(paramString2.res_path, false);
      b(paramString2);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "deleteDirById success id = " + paramString1);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("AdMaterialResManager", 2, "deleteDirById failed id = " + paramString1);
  }
  
  public void a(List<MaterialData> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((MaterialData)paramList.next());
      }
    }
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void b(String paramString, BaseResData paramBaseResData) {}
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Nzp != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Nzp);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzq
 * JD-Core Version:    0.7.0.1
 */