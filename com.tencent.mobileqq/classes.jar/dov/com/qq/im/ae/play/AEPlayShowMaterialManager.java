package dov.com.qq.im.ae.play;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import bczq;
import bczs;
import bmwk;
import bmwr;
import bnjo;
import bnka;
import bnkb;
import bnke;
import bnrh;
import bogd;
import bohd;
import bpqs;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
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
  extends bohd
{
  public static final int EVENT_MATERIAL_LIST_UPDATED = 1;
  private static final String TAG = "AEPlayShowMaterialManager";
  private bnkb mMaterialManager;
  private bczq mObservable = new bczq();
  private List<bnka> mPsCategoryList = new LinkedList();
  private final Object mPsCategoryListLock = new Object();
  private String preLoadUrl;
  
  private Map<String, bnke> buildMaterialDataMap(@Nullable List<bnka> paramList)
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
      Object localObject = (bnka)paramList.next();
      if ((localObject != null) && (((bnka)localObject).jdField_a_of_type_JavaUtilList != null) && (((bnka)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = new LinkedList(((bnka)localObject).jdField_a_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bnke localbnke = (bnke)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localbnke.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbnke.jdField_e_of_type_JavaLangString))) {
            localHashMap.put(localbnke.jdField_a_of_type_JavaLangString, localbnke);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void deleteMaterialZipAndDir(@NonNull bnke parambnke)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + parambnke.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(bmwk.d, parambnke.jdField_a_of_type_JavaLangString);
    parambnke = new File(bmwk.jdField_e_of_type_JavaLangString, parambnke.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      FileUtils.deleteFile(localFile.getPath());
    }
    if (parambnke.exists()) {
      FileUtils.deleteDirectory(parambnke.getPath());
    }
  }
  
  private void diffTwoListAndDeleteOutdatedMaterial(@NonNull List<bnka> paramList1, @NonNull List<bnka> paramList2)
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
        paramList2 = (bnke)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (bnke)localMap.get(str);
          if ((paramList1 == null) || ((paramList1.g != 4) && (paramList1.g != 5) && (paramList1.g != 6) && (paramList1.g != 7)) || (paramList1.jdField_e_of_type_JavaLangString.equals(paramList2.jdField_e_of_type_JavaLangString))) {
            break label211;
          }
        }
      }
      for (paramList1 = paramList2;; paramList1 = null)
      {
        if ((paramList1 == null) || ((paramList1.g != 4) && (paramList1.g != 5) && (paramList1.g != 6) && (paramList1.g != 7))) {
          break label214;
        }
        deleteMaterialZipAndDir(paramList1);
        break;
        return;
      }
    }
  }
  
  private bnkb getAEMaterialManager()
  {
    if (this.mMaterialManager == null) {
      this.mMaterialManager = ((bnkb)bogd.a(18));
    }
    return this.mMaterialManager;
  }
  
  private List<bnka> getFilteredPsCategoryList(List<bnka> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return reAssemblePsCategory(paramList, buildMaterialDataMap(new LinkedList(getAEMaterialManager().b())));
  }
  
  private boolean isNotOrdinaryMaterialUsable(@NonNull bnke parambnke)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + parambnke.jdField_a_of_type_JavaLangString);
    }
    switch (parambnke.g)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    getAEMaterialManager();
    return bnkb.a(parambnke);
  }
  
  private void notifyMaterialListUpdated()
  {
    bnrh.b("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  private List<bnka> parsePsCategoryListFromConfig(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, bnjo.a);
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
              paramString = (bnke)localHashMap.get(localPSMetaMaterial.id);
              if ((paramString.g != 4) && (paramString.g != 5) && (paramString.g != 6) && (paramString.g != 7)) {
                break label479;
              }
              if ((TextUtils.isEmpty(paramString.d)) || (TextUtils.isEmpty(paramString.jdField_e_of_type_JavaLangString))) {
                continue;
              }
            }
            do
            {
              do
              {
                localHashMap.put(localPSMetaMaterial.id, paramString);
                localLinkedList2.add(paramString);
                break;
                paramString = new bnke();
                paramString.jdField_a_of_type_JavaLangString = localPSMetaMaterial.id;
                paramString.f = localPSMetaMaterial.id;
                paramString.d = localPSMetaMaterial.packageUrl;
                paramString.jdField_e_of_type_JavaLangString = localPSMetaMaterial.packageMd5;
                paramString.g = localPSMetaMaterial.type;
                paramString.l = localPSMetaMaterial.thumbUrl;
                paramString.k = localPSMetaCategory.id;
                paramString.m = localPSMetaMaterial.name;
                Map localMap = localPSMetaMaterial.additionalFields;
                if (localMap != null)
                {
                  paramString.n = ((String)localMap.get("web_url"));
                  paramString.o = ((String)localMap.get("mini_app_id"));
                  paramString.i = ((String)localMap.get("takeSameName"));
                }
                break label253;
                if (paramString.g != 2) {
                  break label500;
                }
              } while (!TextUtils.isEmpty(paramString.n));
              break;
            } while ((paramString.g != 3) || (TextUtils.isEmpty(paramString.o)));
          }
        }
      } while (localLinkedList2.size() <= 0);
      label479:
      label500:
      paramString = new bnka();
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
  
  private List<bnka> reAssemblePsCategory(@NonNull List<bnka> paramList, @NonNull Map<String, bnke> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.preLoadUrl = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      bnka localbnka = (bnka)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localbnka.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bnke)localbnka.jdField_a_of_type_JavaUtilList.get(j);
        if (((bnke)localObject).g != 0)
        {
          ((bnke)localObject).jdField_e_of_type_Boolean = isNotOrdinaryMaterialUsable((bnke)localObject);
          localLinkedList2.add(localObject);
          if (((bnke)localObject).g == 2) {
            this.preLoadUrl = ((bnke)localObject).n;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((bnke)localObject).jdField_a_of_type_JavaLangString))
          {
            bnke localbnke = (bnke)paramMap.get(((bnke)localObject).jdField_a_of_type_JavaLangString);
            localbnke.l = ((bnke)localObject).l;
            localbnke.k = localbnka.jdField_a_of_type_JavaLangString;
            localbnke.m = ((bnke)localObject).m;
            if ((TextUtils.isEmpty(localbnke.i)) && (!TextUtils.isEmpty(((bnke)localObject).i))) {
              localbnke.i = ((bnke)localObject).i;
            }
            localLinkedList2.add(localbnke);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new bnka();
        ((bnka)localObject).jdField_b_of_type_JavaLangString = localbnka.jdField_b_of_type_JavaLangString;
        ((bnka)localObject).jdField_b_of_type_Int = localbnka.jdField_b_of_type_Int;
        ((bnka)localObject).jdField_a_of_type_JavaLangString = localbnka.jdField_a_of_type_JavaLangString;
        ((bnka)localObject).jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private void updatePsCategoryListAsync()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListAsync");
    }
    ThreadManager.excute(new AEPlayShowMaterialManager.1(this), 64, null, true);
  }
  
  private List<bnka> updatePsCategoryListInternal()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(bmwr.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(bmwr.jdField_b_of_type_JavaLangString);
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
      return getFilteredPsCategoryList(parsePsCategoryListFromConfig(bpqs.a(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = getFilteredPsCategoryList(parsePsCategoryListFromConfig(bpqs.a(localFile2)));
      FileUtils.moveFile(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = parsePsCategoryListFromConfig(bpqs.a(localFile1));
    List localList2 = parsePsCategoryListFromConfig(bpqs.a(localFile2));
    diffTwoListAndDeleteOutdatedMaterial(localList1, localList2);
    localList1 = getFilteredPsCategoryList(localList2);
    FileUtils.deleteFile(localFile1.getPath());
    FileUtils.moveFile(localFile2.getPath(), localFile1.getPath());
    return localList1;
  }
  
  public void addObserver(bczs parambczs, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + parambczs + ", eventId=" + paramInt);
    }
    this.mObservable.a(parambczs, new int[] { paramInt });
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
  
  public List<bnka> getPsCategoryList()
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
  
  public void removeObserver(bczs parambczs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + parambczs);
    }
    this.mObservable.a(parambczs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager
 * JD-Core Version:    0.7.0.1
 */