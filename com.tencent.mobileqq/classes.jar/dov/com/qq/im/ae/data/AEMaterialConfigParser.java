package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import bnka;
import bnkb;
import bnke;
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
  
  public static ArrayList<bnka> a(String paramString)
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
      bnka localbnka;
      Object localObject3;
      bnke localbnke;
      Map localMap;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MetaCategory)((Iterator)localObject1).next();
        localbnka = new bnka();
        localbnka.b = ((MetaCategory)localObject2).name;
        localbnka.a = new ArrayList();
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MetaMaterial)((Iterator)localObject2).next();
            if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (bnkb.b())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))) {
              if ((paramString.containsKey(((MetaMaterial)localObject3).id)) && (paramString.get(((MetaMaterial)localObject3).id) != null))
              {
                localObject3 = (bnke)paramString.get(((MetaMaterial)localObject3).id);
                localbnka.a.add(localObject3);
              }
              else
              {
                localbnke = new bnke();
                localbnke.jdField_c_of_type_JavaLangString = ((MetaMaterial)localObject3).thumbUrl;
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
        localbnke.jdField_c_of_type_Int = Integer.parseInt((String)localMap.get("kind"));
        try
        {
          for (;;)
          {
            label357:
            localbnke.jdField_d_of_type_Int = Integer.parseInt((String)localMap.get("displayType"));
            label377:
            localbnke.g = ((String)localMap.get("qq_camera_top_title"));
            localbnke.h = ((String)localMap.get("qq_camera_scheme"));
            localbnke.l = ((String)localMap.get("playshow_cover_img"));
            localbnke.m = ((String)localMap.get("playshow_display_text"));
            localbnke.i = ((String)localMap.get("takeSameName"));
            try
            {
              if (!TextUtils.isEmpty((String)localMap.get("showCircleTakeSame"))) {}
              for (localbnke.jdField_f_of_type_Int = Integer.valueOf((String)localMap.get("showCircleTakeSame")).intValue();; localbnke.jdField_f_of_type_Int = 0)
              {
                label503:
                localbnke.j = ((String)localMap.get("showEntry"));
                localbnke.jdField_a_of_type_JavaLangString = ((MetaMaterial)localObject3).id;
                a(localbnke, (MetaMaterial)localObject3);
                localbnke.jdField_f_of_type_JavaLangString = ((MetaMaterial)localObject3).id;
                localbnka.a.add(localbnke);
                paramString.put(((MetaMaterial)localObject3).id, localbnke);
                break;
              }
            }
            catch (Throwable localThrowable1)
            {
              break label503;
            }
          }
          localArrayList.add(localbnka);
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
  
  private static void a(bnke parambnke, MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial.additionalPackage == null)
    {
      parambnke.jdField_d_of_type_JavaLangString = paramMetaMaterial.packageUrl;
      parambnke.e = paramMetaMaterial.packageMd5;
    }
    for (;;)
    {
      if ((paramMetaMaterial.packageUrl != null) && (!paramMetaMaterial.packageUrl.equals(parambnke.jdField_d_of_type_JavaLangString))) {
        parambnke.jdField_d_of_type_Boolean = true;
      }
      return;
      if ((TextUtils.isEmpty(paramMetaMaterial.additionalPackage.superLowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.lowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.midPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.highPackageUrl)))
      {
        parambnke.jdField_d_of_type_JavaLangString = paramMetaMaterial.packageUrl;
        parambnke.e = paramMetaMaterial.packageMd5;
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
          parambnke.jdField_d_of_type_JavaLangString = arrayOfString1[j];
          parambnke.e = arrayOfString2[j];
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
          parambnke.jdField_d_of_type_JavaLangString = arrayOfString1[i];
          parambnke.e = arrayOfString2[i];
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */