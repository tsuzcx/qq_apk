package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import blux;
import bluy;
import blvb;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
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
  
  public static VideoMaterial a(String paramString)
  {
    return VideoSDKMaterialParser.parseVideoMaterial(paramString, "params");
  }
  
  public static ArrayList<blux> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Object localObject1 = new Gson();
    try
    {
      localObject1 = (GetCategoryMaterialRsp)((Gson)localObject1).fromJson(paramString, GetCategoryMaterialRsp.class);
      if ((localObject1 == null) || (((GetCategoryMaterialRsp)localObject1).Categories == null)) {
        return localArrayList;
      }
    }
    catch (Exception paramString)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "###  parseMaterialListFromConfig exception = " + paramString.getMessage());
      throw new AEMaterialConfigParser.AEMaterialConfigParseException("parseMaterialListFromConfig error");
    }
    paramString = new HashMap();
    localObject1 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
    for (;;)
    {
      blux localblux;
      Object localObject3;
      blvb localblvb;
      Map localMap;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MetaCategory)((Iterator)localObject1).next();
        localblux = new blux();
        localblux.b = ((MetaCategory)localObject2).name;
        localblux.a = new ArrayList();
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MetaMaterial)((Iterator)localObject2).next();
            if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (bluy.b())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))) {
              if ((paramString.containsKey(((MetaMaterial)localObject3).id)) && (paramString.get(((MetaMaterial)localObject3).id) != null))
              {
                localObject3 = (blvb)paramString.get(((MetaMaterial)localObject3).id);
                localblux.a.add(localObject3);
              }
              else
              {
                localblvb = new blvb();
                localblvb.jdField_c_of_type_JavaLangString = ((MetaMaterial)localObject3).thumbUrl;
                localMap = ((MetaMaterial)localObject3).additionalFields;
                if (localMap == null) {
                  break;
                }
              }
            }
          }
        }
      }
      try
      {
        localblvb.jdField_c_of_type_Int = Integer.parseInt((String)localMap.get("kind"));
        try
        {
          for (;;)
          {
            label357:
            localblvb.jdField_d_of_type_Int = Integer.parseInt((String)localMap.get("displayType"));
            label377:
            localblvb.g = ((String)localMap.get("qq_camera_top_title"));
            localblvb.h = ((String)localMap.get("qq_camera_scheme"));
            localblvb.l = ((String)localMap.get("playshow_cover_img"));
            localblvb.m = ((String)localMap.get("playshow_display_text"));
            localblvb.i = ((String)localMap.get("takeSameName"));
            try
            {
              if (!TextUtils.isEmpty((String)localMap.get("showCircleTakeSame"))) {}
              for (localblvb.jdField_f_of_type_Int = Integer.valueOf((String)localMap.get("showCircleTakeSame")).intValue();; localblvb.jdField_f_of_type_Int = 0)
              {
                label503:
                localblvb.j = ((String)localMap.get("showEntry"));
                localblvb.jdField_a_of_type_JavaLangString = ((MetaMaterial)localObject3).id;
                a(localblvb, (MetaMaterial)localObject3);
                localblvb.jdField_f_of_type_JavaLangString = ((MetaMaterial)localObject3).id;
                localblux.a.add(localblvb);
                paramString.put(((MetaMaterial)localObject3).id, localblvb);
                break;
              }
            }
            catch (Throwable localThrowable1)
            {
              break label503;
            }
          }
          localArrayList.add(localblux);
          continue;
          return localArrayList;
        }
        catch (Throwable localThrowable2)
        {
          break label377;
        }
      }
      catch (Throwable localThrowable3)
      {
        break label357;
      }
    }
  }
  
  private static void a(blvb paramblvb, MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial.additionalPackage == null)
    {
      paramblvb.jdField_d_of_type_JavaLangString = paramMetaMaterial.packageUrl;
      paramblvb.e = paramMetaMaterial.packageMd5;
    }
    for (;;)
    {
      if ((paramMetaMaterial.packageUrl != null) && (!paramMetaMaterial.packageUrl.equals(paramblvb.jdField_d_of_type_JavaLangString))) {
        paramblvb.jdField_d_of_type_Boolean = true;
      }
      return;
      if ((TextUtils.isEmpty(paramMetaMaterial.additionalPackage.superLowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.lowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.midPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.highPackageUrl)))
      {
        paramblvb.jdField_d_of_type_JavaLangString = paramMetaMaterial.packageUrl;
        paramblvb.e = paramMetaMaterial.packageMd5;
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
          paramblvb.jdField_d_of_type_JavaLangString = arrayOfString1[j];
          paramblvb.e = arrayOfString2[j];
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
          paramblvb.jdField_d_of_type_JavaLangString = arrayOfString1[i];
          paramblvb.e = arrayOfString2[i];
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */