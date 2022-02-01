package dov.com.qq.im.ae.play;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import bbsv;
import bbsx;
import bljm;
import bljr;
import blul;
import blux;
import bluy;
import blvb;
import bmbx;
import bmql;
import bmrl;
import boba;
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
  extends bmrl
{
  public static final int EVENT_MATERIAL_LIST_UPDATED = 1;
  private static final String TAG = "AEPlayShowMaterialManager";
  private bluy mMaterialManager;
  private bbsv mObservable = new bbsv();
  private List<blux> mPsCategoryList = new LinkedList();
  private final Object mPsCategoryListLock = new Object();
  private String preLoadUrl;
  
  private Map<String, blvb> buildMaterialDataMap(@Nullable List<blux> paramList)
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
      Object localObject = (blux)paramList.next();
      if ((localObject != null) && (((blux)localObject).jdField_a_of_type_JavaUtilList != null) && (((blux)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = new LinkedList(((blux)localObject).jdField_a_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject).hasNext())
        {
          blvb localblvb = (blvb)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localblvb.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localblvb.jdField_e_of_type_JavaLangString))) {
            localHashMap.put(localblvb.jdField_a_of_type_JavaLangString, localblvb);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void deleteMaterialZipAndDir(@NonNull blvb paramblvb)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + paramblvb.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(bljm.d, paramblvb.jdField_a_of_type_JavaLangString);
    paramblvb = new File(bljm.jdField_e_of_type_JavaLangString, paramblvb.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      FileUtils.deleteFile(localFile.getPath());
    }
    if (paramblvb.exists()) {
      FileUtils.deleteDirectory(paramblvb.getPath());
    }
  }
  
  private void diffTwoListAndDeleteOutdatedMaterial(@NonNull List<blux> paramList1, @NonNull List<blux> paramList2)
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
        paramList2 = (blvb)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (blvb)localMap.get(str);
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
  
  private bluy getAEMaterialManager()
  {
    if (this.mMaterialManager == null) {
      this.mMaterialManager = ((bluy)bmql.a(18));
    }
    return this.mMaterialManager;
  }
  
  private List<blux> getFilteredPsCategoryList(List<blux> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return reAssemblePsCategory(paramList, buildMaterialDataMap(new LinkedList(getAEMaterialManager().b())));
  }
  
  private boolean isNotOrdinaryMaterialUsable(@NonNull blvb paramblvb)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + paramblvb.jdField_a_of_type_JavaLangString);
    }
    switch (paramblvb.g)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    getAEMaterialManager();
    return bluy.a(paramblvb);
  }
  
  private void notifyMaterialListUpdated()
  {
    bmbx.b("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  private List<blux> parsePsCategoryListFromConfig(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, blul.a);
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
              paramString = (blvb)localHashMap.get(localPSMetaMaterial.id);
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
                paramString = new blvb();
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
      paramString = new blux();
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
  
  private List<blux> reAssemblePsCategory(@NonNull List<blux> paramList, @NonNull Map<String, blvb> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.preLoadUrl = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      blux localblux = (blux)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localblux.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (blvb)localblux.jdField_a_of_type_JavaUtilList.get(j);
        if (((blvb)localObject).g != 0)
        {
          ((blvb)localObject).jdField_e_of_type_Boolean = isNotOrdinaryMaterialUsable((blvb)localObject);
          localLinkedList2.add(localObject);
          if (((blvb)localObject).g == 2) {
            this.preLoadUrl = ((blvb)localObject).n;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((blvb)localObject).jdField_a_of_type_JavaLangString))
          {
            blvb localblvb = (blvb)paramMap.get(((blvb)localObject).jdField_a_of_type_JavaLangString);
            localblvb.l = ((blvb)localObject).l;
            localblvb.k = localblux.jdField_a_of_type_JavaLangString;
            localblvb.m = ((blvb)localObject).m;
            if ((TextUtils.isEmpty(localblvb.i)) && (!TextUtils.isEmpty(((blvb)localObject).i))) {
              localblvb.i = ((blvb)localObject).i;
            }
            localLinkedList2.add(localblvb);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new blux();
        ((blux)localObject).jdField_b_of_type_JavaLangString = localblux.jdField_b_of_type_JavaLangString;
        ((blux)localObject).jdField_b_of_type_Int = localblux.jdField_b_of_type_Int;
        ((blux)localObject).jdField_a_of_type_JavaLangString = localblux.jdField_a_of_type_JavaLangString;
        ((blux)localObject).jdField_a_of_type_JavaUtilList = localLinkedList2;
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
  
  private List<blux> updatePsCategoryListInternal()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(bljr.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(bljr.jdField_b_of_type_JavaLangString);
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
      return getFilteredPsCategoryList(parsePsCategoryListFromConfig(boba.a(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = getFilteredPsCategoryList(parsePsCategoryListFromConfig(boba.a(localFile2)));
      FileUtils.moveFile(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = parsePsCategoryListFromConfig(boba.a(localFile1));
    List localList2 = parsePsCategoryListFromConfig(boba.a(localFile2));
    diffTwoListAndDeleteOutdatedMaterial(localList1, localList2);
    localList1 = getFilteredPsCategoryList(localList2);
    FileUtils.deleteFile(localFile1.getPath());
    FileUtils.moveFile(localFile2.getPath(), localFile1.getPath());
    return localList1;
  }
  
  public void addObserver(bbsx parambbsx, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + parambbsx + ", eventId=" + paramInt);
    }
    this.mObservable.a(parambbsx, new int[] { paramInt });
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
  
  public List<blux> getPsCategoryList()
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
  
  public void removeObserver(bbsx parambbsx)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + parambbsx);
    }
    this.mObservable.a(parambbsx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager
 * JD-Core Version:    0.7.0.1
 */