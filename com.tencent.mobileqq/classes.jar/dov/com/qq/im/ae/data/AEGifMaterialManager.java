package dov.com.qq.im.ae.data;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import dov.com.qq.im.ae.AEPath.GIF;
import dov.com.qq.im.ae.config.CameraOperationHelper;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.params.ParamsUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class AEGifMaterialManager
{
  private static final AEGifMaterialManager jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager = new AEGifMaterialManager();
  private static final Type jdField_a_of_type_JavaLangReflectType = new AEGifMaterialManager.1().getType();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private List<AEGifCategoryWrapper> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, WeakReference<AEGifMaterialManager.DownloadCallback>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, MetaMaterial> b = new HashMap();
  
  public static AEGifMaterialManager a()
  {
    return jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager;
  }
  
  @Nullable
  private String a(@NonNull MetaCategory paramMetaCategory, @NonNull String paramString)
  {
    if (paramMetaCategory.dynamicFields == null) {
      return null;
    }
    return (String)paramMetaCategory.dynamicFields.get(paramString);
  }
  
  @WorkerThread
  private List<AEGifCategoryWrapper> a()
  {
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync]");
    File localFile1 = new File(AEPath.GIF.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(AEPath.GIF.b);
    if (!localFile2.exists())
    {
      AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile not exists");
      if (!localFile1.exists())
      {
        AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
        AECameraPrefsUtil.a().a("CameraModuleSvc.GetCompressedCategoryMaterialV2MqEmoCamera", 4);
        return new LinkedList();
      }
      AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
      return a(a(FileUtils.a(localFile1)));
    }
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile exists");
    if (!localFile1.exists())
    {
      AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
      localList1 = a(FileUtils.a(localFile2));
      a(localList1);
      FileUtils.b(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
    List localList1 = a(FileUtils.a(localFile1));
    List localList2 = a(FileUtils.a(localFile2));
    a(localList1, localList2);
    a(localList2);
    FileUtils.e(localFile1.getPath());
    FileUtils.b(localFile2.getPath(), localFile1.getPath());
    return localList2;
  }
  
  @NonNull
  private List<AEGifCategoryWrapper> a(@Nullable String paramString)
  {
    AEQLog.a("AEGifMaterialManager", "[parseGifCategoryFromJson]");
    if (TextUtils.isEmpty(paramString))
    {
      AEQLog.d("AEGifMaterialManager", "[parseGifCategoryFromJson] jsonString is empty");
      return new LinkedList();
    }
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)GsonUtils.json2Obj(paramString, jdField_a_of_type_JavaLangReflectType);
    if ((localGetCategoryMaterialRsp == null) || (CollectionUtils.isEmpty(localGetCategoryMaterialRsp.Categories)))
    {
      AEQLog.d("AEGifMaterialManager", "[parseGifCategoryFromJson] parsed response is empty");
      return new LinkedList();
    }
    LinkedList localLinkedList1 = new LinkedList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < localGetCategoryMaterialRsp.Categories.size())
    {
      MetaCategory localMetaCategory = (MetaCategory)localGetCategoryMaterialRsp.Categories.get(i);
      if ((localMetaCategory == null) || (CollectionUtils.isEmpty(localMetaCategory.materials))) {}
      for (;;)
      {
        i += 1;
        break;
        LinkedList localLinkedList2 = new LinkedList();
        int j = 0;
        if (j < localMetaCategory.materials.size())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)localMetaCategory.materials.get(j);
          if ((localMetaMaterial == null) || (TextUtils.isEmpty(localMetaMaterial.id))) {}
          label379:
          for (;;)
          {
            j += 1;
            break;
            Map localMap = localMetaMaterial.additionalFields;
            if (localHashMap.get(localMetaMaterial.id) == null)
            {
              paramString = new AEMaterialWrapper();
              paramString.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
              paramString.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localMetaMaterial;
              if (localMap != null)
              {
                paramString.b = ((String)localMap.get("minimum_device_level"));
                paramString.c = ((String)localMap.get("shield_devices"));
              }
              paramString.jdField_a_of_type_Boolean = a(paramString);
              if (paramString.jdField_a_of_type_Boolean) {
                localHashMap.put(localMetaMaterial.id, paramString);
              }
            }
            for (;;)
            {
              if (!paramString.jdField_a_of_type_Boolean) {
                break label379;
              }
              localLinkedList2.add(paramString);
              break;
              AEQLog.a("AEGifMaterialManager", "can not add gif material id: " + paramString.jdField_a_of_type_JavaLangString);
              continue;
              paramString = (AEMaterialWrapper)localHashMap.get(localMetaMaterial.id);
            }
          }
        }
        if (CollectionUtils.isEmpty(localLinkedList2))
        {
          AEQLog.d("AEGifMaterialManager", "[parseGifCategoryFromJson] materialWrapperList is empty, categoryId=" + localMetaCategory.id);
        }
        else
        {
          paramString = new AEGifCategoryWrapper();
          paramString.categoryId = localMetaCategory.id;
          paramString.categoryName = localMetaCategory.name;
          paramString.materialWrapperList = localLinkedList2;
          paramString.showCategory = a(localMetaCategory);
          paramString.fontId = a(localMetaCategory, "font_id");
          localLinkedList1.add(paramString);
        }
      }
    }
    return localLinkedList1;
  }
  
  private List<AEGifCategoryWrapper> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    AEQLog.a("AEGifMaterialManager", "[updateMaterialStatus]");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEGifCategoryWrapper)localIterator.next();
      if ((localObject != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)))
      {
        localObject = ((AEGifCategoryWrapper)localObject).materialWrapperList.iterator();
        label63:
        AEMaterialWrapper localAEMaterialWrapper;
        while (((Iterator)localObject).hasNext())
        {
          localAEMaterialWrapper = (AEMaterialWrapper)((Iterator)localObject).next();
          if ((localAEMaterialWrapper != null) && (!TextUtils.isEmpty(localAEMaterialWrapper.jdField_a_of_type_JavaLangString)) && (localAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)) {
            if (!a(localAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial)) {
              break label132;
            }
          }
        }
        label132:
        for (int i = 2;; i = 0)
        {
          localAEMaterialWrapper.jdField_a_of_type_Int = i;
          break label63;
          break;
        }
      }
    }
    return paramList;
  }
  
  private Map<String, MetaMaterial> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    AEQLog.a("AEGifMaterialManager", "[buildMaterialMap]");
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (AEGifCategoryWrapper)paramList.next();
      if ((localObject != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)))
      {
        localObject = ((AEGifCategoryWrapper)localObject).materialWrapperList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AEMaterialWrapper localAEMaterialWrapper = (AEMaterialWrapper)((Iterator)localObject).next();
          if ((localAEMaterialWrapper != null) && (!TextUtils.isEmpty(localAEMaterialWrapper.jdField_a_of_type_JavaLangString)) && (localAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)) {
            localHashMap.put(localAEMaterialWrapper.jdField_a_of_type_JavaLangString, localAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    AEQLog.a("AEGifMaterialManager", "[deleteMaterialZipAndDir], metaMaterial.id=" + paramMetaMaterial.id);
    File localFile = new File(AEPath.CAMERA.FILES.h, paramMetaMaterial.id);
    paramMetaMaterial = new File(AEPath.CAMERA.FILES.i, paramMetaMaterial.id);
    if (localFile.exists()) {
      FileUtils.e(localFile.getPath());
    }
    if (paramMetaMaterial.exists()) {
      FileUtils.a(paramMetaMaterial.getPath());
    }
  }
  
  private void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (AEGifMaterialManager.DownloadCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((AEGifMaterialManager.DownloadCallback)localObject).a(paramMetaMaterial, paramInt);
        }
      }
    }
  }
  
  private void a(@NonNull List<AEGifCategoryWrapper> paramList1, @NonNull List<AEGifCategoryWrapper> paramList2)
  {
    AEQLog.a("AEGifMaterialManager", "[diffTwoListAndDeleteOutdatedMaterial]");
    paramList1 = a(paramList1);
    paramList2 = a(paramList2);
    Iterator localIterator = paramList1.entrySet().iterator();
    label169:
    label172:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList1 = (Map.Entry)localIterator.next();
        Object localObject = (String)paramList1.getKey();
        paramList1 = (MetaMaterial)paramList1.getValue();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (paramList1 == null)) {
          continue;
        }
        if (!paramList2.containsKey(localObject)) {
          break label169;
        }
        localObject = (MetaMaterial)paramList2.get(localObject);
        if ((localObject == null) || (paramList1.packageMd5.equals(((MetaMaterial)localObject).packageMd5))) {
          break label169;
        }
      }
      for (;;)
      {
        if (paramList1 == null) {
          break label172;
        }
        AEQLog.a("AEGifMaterialManager", "[diffTwoListAndDeleteOutdatedMaterial] find outdated material id=" + paramList1.id);
        a(paramList1);
        break;
        return;
        paramList1 = null;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AEQLog.a("AEGifMaterialManager", "[notifyGifCategoryListUpdated], validData=" + paramBoolean);
    CameraOperationHelper.c().postValue(Boolean.valueOf(paramBoolean));
  }
  
  private boolean a(@NonNull MetaCategory paramMetaCategory)
  {
    paramMetaCategory = a(paramMetaCategory, "show_list");
    return (!TextUtils.isEmpty(paramMetaCategory)) && ("true".equals(paramMetaCategory));
  }
  
  private boolean a(@Nullable MetaMaterial paramMetaMaterial)
  {
    if ((paramMetaMaterial == null) || (TextUtils.isEmpty(paramMetaMaterial.id))) {
      AEQLog.d("AEGifMaterialManager", "[materialExists] metaMaterial is invalid");
    }
    File localFile2;
    do
    {
      File localFile1;
      do
      {
        return false;
        localFile1 = new File(AEPath.CAMERA.FILES.h, paramMetaMaterial.id);
      } while (!localFile1.exists());
      File localFile3 = new File(AEPath.CAMERA.FILES.i, paramMetaMaterial.id);
      paramMetaMaterial = new File(localFile3, "params.json");
      localFile2 = new File(localFile3, "params.dat");
      if ((paramMetaMaterial.exists()) || (localFile2.exists())) {
        break;
      }
      try
      {
        ZipUtils.unZipFile(localFile1, localFile3.getPath());
        return true;
      }
      catch (Exception localException)
      {
        AEQLog.a("AEGifMaterialManager", "[materialExists] unZipFile raised exception", localException);
      }
    } while ((!paramMetaMaterial.exists()) && (!localFile2.exists()));
    return true;
    return true;
  }
  
  private boolean a(AEMaterialWrapper paramAEMaterialWrapper)
  {
    if (paramAEMaterialWrapper == null) {}
    String str;
    do
    {
      do
      {
        return true;
        if (ParamsUtil.a(paramAEMaterialWrapper.b) > ParamsUtil.a()) {
          return false;
        }
      } while (paramAEMaterialWrapper.c == null);
      str = ParamsUtil.b();
    } while (!paramAEMaterialWrapper.c.contains(str));
    return false;
  }
  
  private void b(MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (AEGifMaterialManager.DownloadCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((AEGifMaterialManager.DownloadCallback)localObject).a(paramMetaMaterial);
        }
      }
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(MetaMaterial paramMetaMaterial)
  {
    return new File(AEPath.CAMERA.FILES.i, paramMetaMaterial.id).getAbsolutePath();
  }
  
  @NonNull
  public List<AEGifCategoryWrapper> a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new LinkedList(this.jdField_a_of_type_JavaUtilList);
    }
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 2) {}
    for (int i = 1;; i = 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AEGifCategoryWrapper localAEGifCategoryWrapper = (AEGifCategoryWrapper)localIterator.next();
        if ((localAEGifCategoryWrapper != null) && (localAEGifCategoryWrapper.showCategory == i)) {
          localLinkedList.add(localAEGifCategoryWrapper);
        }
      }
    }
    return localLinkedList;
  }
  
  public void a()
  {
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListAsync]");
    ThreadManager.excute(new AEGifMaterialManager.2(this), 64, null, true);
  }
  
  public void a(AppInterface paramAppInterface, MetaMaterial paramMetaMaterial, AEGifMaterialManager.DownloadCallback paramDownloadCallback)
  {
    if ((paramMetaMaterial == null) || (TextUtils.isEmpty(paramMetaMaterial.id)))
    {
      if (paramDownloadCallback != null) {
        paramDownloadCallback.b(paramMetaMaterial);
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramMetaMaterial.id, new WeakReference(paramDownloadCallback));
    ThreadManager.getFileThreadHandler().post(new AEGifMaterialManager.3(this, paramMetaMaterial, paramAppInterface));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEGifMaterialManager
 * JD-Core Version:    0.7.0.1
 */