package dov.com.qq.im.ae.play;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import dov.com.qq.im.ae.AEPath.PLAY;
import dov.com.qq.im.ae.config.CameraDataServiceHandler;
import dov.com.qq.im.ae.data.AEMaterialCategory;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.params.ParamsUtil;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.control.QIMAsyncManager;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class AEPlayShowMaterialManager
  extends QIMAsyncManager
{
  public static final int EVENT_MATERIAL_LIST_UPDATED = 1;
  private static final String TAG = "AEPlayShowMaterialManager";
  private AEMaterialManager mMaterialManager;
  private Observable mObservable = new Observable();
  private List<AEMaterialCategory> mPsCategoryList = new LinkedList();
  private final Object mPsCategoryListLock = new Object();
  private String preLoadUrl;
  
  private Map<String, AEMaterialMetaData> buildMaterialDataMap(@Nullable List<AEMaterialCategory> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "buildMaterialDataMap");
    }
    if (paramList == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap();
    paramList = new LinkedList(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (AEMaterialCategory)paramList.next();
      if ((localObject != null) && (((AEMaterialCategory)localObject).jdField_a_of_type_JavaUtilList != null) && (((AEMaterialCategory)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = new LinkedList(((AEMaterialCategory)localObject).jdField_a_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject).hasNext())
        {
          AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localAEMaterialMetaData.jdField_e_of_type_JavaLangString))) {
            localHashMap.put(localAEMaterialMetaData.jdField_a_of_type_JavaLangString, localAEMaterialMetaData);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void deleteMaterialZipAndDir(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(AEPath.CAMERA.FILES.h, paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    paramAEMaterialMetaData = new File(AEPath.CAMERA.FILES.i, paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      FileUtils.e(localFile.getPath());
    }
    if (paramAEMaterialMetaData.exists()) {
      FileUtils.a(paramAEMaterialMetaData.getPath());
    }
  }
  
  private void diffTwoListAndDeleteOutdatedMaterial(@NonNull List<AEMaterialCategory> paramList1, @NonNull List<AEMaterialCategory> paramList2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "diffTwoListAndDeleteOutdatedMaterial");
    }
    paramList1 = buildMaterialDataMap(paramList1);
    Map localMap = buildMaterialDataMap(paramList2);
    Iterator localIterator = paramList1.entrySet().iterator();
    label211:
    label214:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList1 = (Map.Entry)localIterator.next();
        String str = (String)paramList1.getKey();
        paramList2 = (AEMaterialMetaData)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (AEMaterialMetaData)localMap.get(str);
          if ((paramList1 == null) || ((paramList1.jdField_g_of_type_Int != 4) && (paramList1.jdField_g_of_type_Int != 5) && (paramList1.jdField_g_of_type_Int != 6) && (paramList1.jdField_g_of_type_Int != 7)) || (paramList1.jdField_e_of_type_JavaLangString.equals(paramList2.jdField_e_of_type_JavaLangString))) {
            break label211;
          }
        }
      }
      for (paramList1 = paramList2;; paramList1 = null)
      {
        if ((paramList1 == null) || ((paramList1.jdField_g_of_type_Int != 4) && (paramList1.jdField_g_of_type_Int != 5) && (paramList1.jdField_g_of_type_Int != 6) && (paramList1.jdField_g_of_type_Int != 7))) {
          break label214;
        }
        deleteMaterialZipAndDir(paramList1);
        break;
        return;
      }
    }
  }
  
  private AEMaterialManager getAEMaterialManager()
  {
    if (this.mMaterialManager == null) {
      this.mMaterialManager = ((AEMaterialManager)QIMManager.a(18));
    }
    return this.mMaterialManager;
  }
  
  private List<AEMaterialCategory> getFilteredPsCategoryList(List<AEMaterialCategory> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return reAssemblePsCategory(paramList, buildMaterialDataMap(new LinkedList(getAEMaterialManager().b())));
  }
  
  private boolean isNotOrdinaryMaterialUsable(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    }
    switch (paramAEMaterialMetaData.jdField_g_of_type_Int)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    getAEMaterialManager();
    return AEMaterialManager.a(paramAEMaterialMetaData);
  }
  
  private void notifyMaterialListUpdated()
  {
    AEQLog.b("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  private List<AEMaterialCategory> parsePsCategoryListFromConfig(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, CameraDataServiceHandler.a);
    if ((localGetPlayShowCatMatTreeRsp == null) || (localGetPlayShowCatMatTreeRsp.Categories == null) || (localGetPlayShowCatMatTreeRsp.Categories.size() == 0)) {
      return new LinkedList();
    }
    LinkedList localLinkedList1 = new LinkedList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < localGetPlayShowCatMatTreeRsp.Categories.size())
    {
      PSMetaCategory localPSMetaCategory = (PSMetaCategory)localGetPlayShowCatMatTreeRsp.Categories.get(i);
      if ((localPSMetaCategory == null) || (localPSMetaCategory.materials == null) || (localPSMetaCategory.materials.size() == 0)) {}
      LinkedList localLinkedList2;
      label253:
      do
      {
        i += 1;
        break;
        localLinkedList2 = new LinkedList();
        j = 0;
        if (j < localPSMetaCategory.materials.size())
        {
          PSMetaMaterial localPSMetaMaterial = (PSMetaMaterial)localPSMetaCategory.materials.get(j);
          if ((localPSMetaMaterial == null) || (TextUtils.isEmpty(localPSMetaMaterial.id)) || (TextUtils.isEmpty(localPSMetaMaterial.thumbUrl))) {}
          for (;;)
          {
            j += 1;
            break;
            if (localHashMap.containsKey(localPSMetaMaterial.id))
            {
              paramString = (AEMaterialMetaData)localHashMap.get(localPSMetaMaterial.id);
              if ((paramString.jdField_g_of_type_Int != 4) && (paramString.jdField_g_of_type_Int != 5) && (paramString.jdField_g_of_type_Int != 6) && (paramString.jdField_g_of_type_Int != 7)) {
                break label534;
              }
              if ((TextUtils.isEmpty(paramString.d)) || (TextUtils.isEmpty(paramString.jdField_e_of_type_JavaLangString))) {
                continue;
              }
            }
            for (;;)
            {
              if (!paramString.jdField_g_of_type_Boolean)
              {
                AEQLog.a("AEPlayShowMaterialManager", "can not show play material id:" + paramString.jdField_a_of_type_JavaLangString);
                break;
                paramString = new AEMaterialMetaData();
                paramString.jdField_a_of_type_JavaLangString = localPSMetaMaterial.id;
                paramString.f = localPSMetaMaterial.id;
                paramString.d = localPSMetaMaterial.packageUrl;
                paramString.jdField_e_of_type_JavaLangString = localPSMetaMaterial.packageMd5;
                paramString.jdField_g_of_type_Int = localPSMetaMaterial.type;
                paramString.o = localPSMetaMaterial.thumbUrl;
                paramString.n = localPSMetaCategory.id;
                paramString.p = localPSMetaMaterial.name;
                Map localMap = localPSMetaMaterial.additionalFields;
                if (localMap != null)
                {
                  paramString.q = ((String)localMap.get("web_url"));
                  paramString.r = ((String)localMap.get("mini_app_id"));
                  paramString.i = ((String)localMap.get("takeSameName"));
                  paramString.j = ((String)localMap.get("minimum_device_level"));
                  paramString.k = ((String)localMap.get("shield_devices"));
                }
                paramString.jdField_g_of_type_Boolean = shouldShowPlayMaterial(paramString);
                break label253;
                if (paramString.jdField_g_of_type_Int == 2)
                {
                  if (!TextUtils.isEmpty(paramString.q)) {
                    continue;
                  }
                  break;
                }
                if ((paramString.jdField_g_of_type_Int == 3) && (!TextUtils.isEmpty(paramString.r))) {
                  break;
                }
              }
            }
            localHashMap.put(localPSMetaMaterial.id, paramString);
            localLinkedList2.add(paramString);
          }
        }
      } while (localLinkedList2.size() <= 0);
      label534:
      paramString = new AEMaterialCategory();
      paramString.jdField_b_of_type_JavaLangString = localPSMetaCategory.name;
      paramString.jdField_a_of_type_JavaLangString = localPSMetaCategory.id;
      if (localPSMetaCategory.onlyFlag) {}
      for (int j = 1;; j = 2)
      {
        paramString.jdField_b_of_type_Int = j;
        paramString.jdField_a_of_type_Boolean = localPSMetaCategory.defaultFlag;
        paramString.jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(paramString);
        break;
      }
    }
    return localLinkedList1;
  }
  
  private List<AEMaterialCategory> reAssemblePsCategory(@NonNull List<AEMaterialCategory> paramList, @NonNull Map<String, AEMaterialMetaData> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.preLoadUrl = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localAEMaterialCategory.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (AEMaterialMetaData)localAEMaterialCategory.jdField_a_of_type_JavaUtilList.get(j);
        if (((AEMaterialMetaData)localObject).jdField_g_of_type_Int != 0)
        {
          ((AEMaterialMetaData)localObject).jdField_e_of_type_Boolean = isNotOrdinaryMaterialUsable((AEMaterialMetaData)localObject);
          localLinkedList2.add(localObject);
          if (((AEMaterialMetaData)localObject).jdField_g_of_type_Int == 2) {
            this.preLoadUrl = ((AEMaterialMetaData)localObject).q;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((AEMaterialMetaData)localObject).jdField_a_of_type_JavaLangString))
          {
            AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramMap.get(((AEMaterialMetaData)localObject).jdField_a_of_type_JavaLangString);
            localAEMaterialMetaData.o = ((AEMaterialMetaData)localObject).o;
            localAEMaterialMetaData.n = localAEMaterialCategory.jdField_a_of_type_JavaLangString;
            localAEMaterialMetaData.p = ((AEMaterialMetaData)localObject).p;
            if ((TextUtils.isEmpty(localAEMaterialMetaData.i)) && (!TextUtils.isEmpty(((AEMaterialMetaData)localObject).i))) {
              localAEMaterialMetaData.i = ((AEMaterialMetaData)localObject).i;
            }
            localLinkedList2.add(localAEMaterialMetaData);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new AEMaterialCategory();
        ((AEMaterialCategory)localObject).jdField_b_of_type_JavaLangString = localAEMaterialCategory.jdField_b_of_type_JavaLangString;
        ((AEMaterialCategory)localObject).jdField_b_of_type_Int = localAEMaterialCategory.jdField_b_of_type_Int;
        ((AEMaterialCategory)localObject).jdField_a_of_type_JavaLangString = localAEMaterialCategory.jdField_a_of_type_JavaLangString;
        ((AEMaterialCategory)localObject).jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private boolean shouldShowPlayMaterial(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      AEQLog.a("AEPlayShowMaterialManager", " info is null ");
    }
    String str;
    do
    {
      do
      {
        return true;
        if (ParamsUtil.a(paramAEMaterialMetaData.j) > ParamsUtil.a()) {
          return false;
        }
      } while (paramAEMaterialMetaData.k == null);
      str = ParamsUtil.b();
    } while (!paramAEMaterialMetaData.k.contains(str));
    return false;
  }
  
  private void updatePsCategoryListAsync()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListAsync");
    }
    ThreadManager.excute(new AEPlayShowMaterialManager.1(this), 64, null, true);
  }
  
  private List<AEMaterialCategory> updatePsCategoryListInternal()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(AEPath.PLAY.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(AEPath.PLAY.jdField_b_of_type_JavaLangString);
    if (!localFile2.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=null, thread=" + Thread.currentThread());
      }
      if (!localFile1.exists())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
        }
        return new LinkedList();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
      }
      return getFilteredPsCategoryList(parsePsCategoryListFromConfig(QIMPtvTemplateManager.a(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = getFilteredPsCategoryList(parsePsCategoryListFromConfig(QIMPtvTemplateManager.a(localFile2)));
      FileUtils.b(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = parsePsCategoryListFromConfig(QIMPtvTemplateManager.a(localFile1));
    List localList2 = parsePsCategoryListFromConfig(QIMPtvTemplateManager.a(localFile2));
    diffTwoListAndDeleteOutdatedMaterial(localList1, localList2);
    localList1 = getFilteredPsCategoryList(localList2);
    FileUtils.e(localFile1.getPath());
    FileUtils.b(localFile2.getPath(), localFile1.getPath());
    return localList1;
  }
  
  public void addObserver(Observer paramObserver, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + paramObserver + ", eventId=" + paramInt);
    }
    this.mObservable.a(paramObserver, new int[] { paramInt });
  }
  
  public void clearCategoryList()
  {
    synchronized (this.mPsCategoryListLock)
    {
      if (this.mPsCategoryList != null) {
        this.mPsCategoryList.clear();
      }
      return;
    }
  }
  
  @Nullable
  public String getPreLoadUrl()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPreLoadUrl, preLoadUrl=" + this.preLoadUrl);
    }
    return this.preLoadUrl;
  }
  
  public List<AEMaterialCategory> getPsCategoryList()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPsCategoryList");
    }
    return new LinkedList(this.mPsCategoryList);
  }
  
  public void initIndeed()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "initIndeed");
    }
    updatePsCategoryListAsync();
  }
  
  public void refresh()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "refresh");
    }
    updatePsCategoryListAsync();
  }
  
  public void removeObserver(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, eventId=" + paramInt);
    }
    this.mObservable.a(paramInt);
  }
  
  public void removeObserver(Observer paramObserver)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + paramObserver);
    }
    this.mObservable.a(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager
 * JD-Core Version:    0.7.0.1
 */