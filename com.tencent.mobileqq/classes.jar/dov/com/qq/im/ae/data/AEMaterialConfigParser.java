package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.device.DeviceUtils;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.params.ParamsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AEMaterialConfigParser
{
  public static int a;
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AEMaterialConfigParser.class.getSimpleName();
    jdField_a_of_type_Int = 5;
  }
  
  public static ArrayList<AEMaterialCategory> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Object localObject = new Gson();
    try
    {
      paramString = (GetCategoryMaterialRsp)((Gson)localObject).fromJson(paramString, GetCategoryMaterialRsp.class);
      if ((paramString == null) || (paramString.Categories == null)) {
        return localArrayList;
      }
    }
    catch (Exception paramString)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "###  parseMaterialListFromConfig exception = " + paramString.getMessage());
      throw new AEMaterialConfigParser.AEMaterialConfigParseException("parseMaterialListFromConfig error");
    }
    localObject = new HashMap();
    Iterator localIterator1 = paramString.Categories.iterator();
    for (;;)
    {
      AEMaterialCategory localAEMaterialCategory;
      label175:
      MetaMaterial localMetaMaterial;
      AEMaterialMetaData localAEMaterialMetaData;
      Map localMap;
      if (localIterator1.hasNext())
      {
        paramString = (MetaCategory)localIterator1.next();
        localAEMaterialCategory = new AEMaterialCategory();
        localAEMaterialCategory.b = paramString.name;
        try
        {
          localAEMaterialCategory.jdField_a_of_type_Int = Integer.parseInt(paramString.id);
          localAEMaterialCategory.jdField_a_of_type_JavaUtilList = new ArrayList();
          Iterator localIterator2 = paramString.materials.iterator();
          for (;;)
          {
            if (!localIterator2.hasNext()) {
              break label755;
            }
            localMetaMaterial = (MetaMaterial)localIterator2.next();
            if (((!localMetaMaterial.id.contains("_3DFaceFila")) || (AEMaterialManager.b())) && ((!localMetaMaterial.id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
            {
              if ((!((Map)localObject).containsKey(localMetaMaterial.id)) || (((Map)localObject).get(localMetaMaterial.id) == null)) {
                break;
              }
              paramString = (AEMaterialMetaData)((Map)localObject).get(localMetaMaterial.id);
              localAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(paramString);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            AEQLog.d(jdField_a_of_type_JavaLangString, "categoryid is not integer " + paramString.id);
          }
          localAEMaterialMetaData = new AEMaterialMetaData();
          localAEMaterialMetaData.jdField_c_of_type_JavaLangString = localMetaMaterial.thumbUrl;
          localMap = localMetaMaterial.additionalFields;
          if (localMap == null) {}
        }
      }
      try
      {
        localAEMaterialMetaData.jdField_c_of_type_Int = Integer.parseInt((String)localMap.get("kind"));
        try
        {
          for (;;)
          {
            label401:
            localAEMaterialMetaData.jdField_d_of_type_Int = Integer.parseInt((String)localMap.get("displayType"));
            label421:
            localAEMaterialMetaData.jdField_g_of_type_JavaLangString = ((String)localMap.get("qq_camera_top_title"));
            localAEMaterialMetaData.h = ((String)localMap.get("qq_camera_scheme"));
            localAEMaterialMetaData.o = ((String)localMap.get("playshow_cover_img"));
            localAEMaterialMetaData.p = ((String)localMap.get("playshow_display_text"));
            localAEMaterialMetaData.i = ((String)localMap.get("takeSameName"));
            localAEMaterialMetaData.j = ((String)localMap.get("minimum_device_level"));
            localAEMaterialMetaData.k = ((String)localMap.get("shield_devices"));
            try
            {
              if (!TextUtils.isEmpty((String)localMap.get("showCircleTakeSame"))) {}
              for (localAEMaterialMetaData.jdField_f_of_type_Int = Integer.valueOf((String)localMap.get("showCircleTakeSame")).intValue();; localAEMaterialMetaData.jdField_f_of_type_Int = 0)
              {
                label581:
                localAEMaterialMetaData.m = ((String)localMap.get("showEntry"));
                paramString = null;
                if (localMap != null) {
                  paramString = (String)localMap.get("topic");
                }
                if (!TextUtils.isEmpty(paramString)) {
                  localAEMaterialMetaData.l = paramString;
                }
                localAEMaterialMetaData.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
                localAEMaterialMetaData.jdField_g_of_type_Boolean = a(localAEMaterialMetaData);
                if (localAEMaterialMetaData.jdField_g_of_type_Boolean) {
                  break label708;
                }
                QLog.d(jdField_a_of_type_JavaLangString, 4, "can not show material id :" + localAEMaterialMetaData.jdField_a_of_type_JavaLangString);
                break;
              }
            }
            catch (Throwable paramString)
            {
              break label581;
              label708:
              a(localAEMaterialMetaData, localMetaMaterial);
              localAEMaterialMetaData.jdField_f_of_type_JavaLangString = localMetaMaterial.id;
              localAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(localAEMaterialMetaData);
              ((Map)localObject).put(localMetaMaterial.id, localAEMaterialMetaData);
            }
          }
          break label175;
          label755:
          localArrayList.add(localAEMaterialCategory);
          continue;
          return localArrayList;
        }
        catch (Throwable paramString)
        {
          break label421;
        }
      }
      catch (Throwable paramString)
      {
        break label401;
      }
    }
  }
  
  private static void a(AEMaterialMetaData paramAEMaterialMetaData, MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial.additionalPackage == null)
    {
      paramAEMaterialMetaData.jdField_d_of_type_JavaLangString = paramMetaMaterial.packageUrl;
      paramAEMaterialMetaData.e = paramMetaMaterial.packageMd5;
    }
    for (;;)
    {
      if ((paramMetaMaterial.packageUrl != null) && (!paramMetaMaterial.packageUrl.equals(paramAEMaterialMetaData.jdField_d_of_type_JavaLangString)))
      {
        paramAEMaterialMetaData.jdField_d_of_type_Boolean = true;
        AEQLog.a(jdField_a_of_type_JavaLangString, "[parseDowngradeInfo][material_downgrade] 降级完成 : " + paramAEMaterialMetaData.jdField_d_of_type_JavaLangString);
      }
      return;
      if ((TextUtils.isEmpty(paramMetaMaterial.additionalPackage.superLowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.lowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.midPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.highPackageUrl)))
      {
        paramAEMaterialMetaData.jdField_d_of_type_JavaLangString = paramMetaMaterial.packageUrl;
        paramAEMaterialMetaData.e = paramMetaMaterial.packageMd5;
      }
      else
      {
        String[] arrayOfString1 = new String[5];
        arrayOfString1[0] = paramMetaMaterial.additionalPackage.superLowPackageUrl;
        arrayOfString1[1] = paramMetaMaterial.additionalPackage.lowPackageUrl;
        arrayOfString1[2] = paramMetaMaterial.additionalPackage.midPackageUrl;
        arrayOfString1[3] = paramMetaMaterial.additionalPackage.highPackageUrl;
        arrayOfString1[4] = paramMetaMaterial.packageUrl;
        String[] arrayOfString2 = new String[5];
        arrayOfString2[0] = paramMetaMaterial.additionalPackage.superLowPackageMd5;
        arrayOfString2[1] = paramMetaMaterial.additionalPackage.lowPackageMd5;
        arrayOfString2[2] = paramMetaMaterial.additionalPackage.midPackageMd5;
        arrayOfString2[3] = paramMetaMaterial.additionalPackage.highPackageMd5;
        arrayOfString2[4] = paramMetaMaterial.packageMd5;
        int j = jdField_a_of_type_Int - 1;
        int i = j;
        if (!TextUtils.isEmpty(arrayOfString1[j]))
        {
          paramAEMaterialMetaData.jdField_d_of_type_JavaLangString = arrayOfString1[j];
          paramAEMaterialMetaData.e = arrayOfString2[j];
        }
        else
        {
          do
          {
            i += 1;
            if (i >= 5) {
              break;
            }
          } while (TextUtils.isEmpty(arrayOfString1[i]));
          paramAEMaterialMetaData.jdField_d_of_type_JavaLangString = arrayOfString1[i];
          paramAEMaterialMetaData.e = arrayOfString2[i];
        }
      }
    }
  }
  
  private static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {}
    String str;
    do
    {
      do
      {
        return true;
        if (ParamsUtil.a(paramAEMaterialMetaData.j) > ParamsUtil.a())
        {
          AEQLog.a(jdField_a_of_type_JavaLangString, "can not show level :" + paramAEMaterialMetaData.j);
          return false;
        }
      } while (paramAEMaterialMetaData.k == null);
      str = ParamsUtil.b();
      AEQLog.a(jdField_a_of_type_JavaLangString, "can not show curModel :" + str);
    } while (!paramAEMaterialMetaData.k.contains(str));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */