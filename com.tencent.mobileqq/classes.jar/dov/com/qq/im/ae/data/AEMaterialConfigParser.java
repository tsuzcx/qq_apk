package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import bnpb;
import bnpc;
import bnpf;
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
  
  public static MetaMaterial a(MetaMaterial paramMetaMaterial)
  {
    boolean bool;
    for (;;)
    {
      String[] arrayOfString1;
      String[] arrayOfString2;
      int i;
      try
      {
        bool = a(paramMetaMaterial.additionalPackage);
        if (bool) {
          return paramMetaMaterial;
        }
        arrayOfString1 = new String[5];
        arrayOfString1[0] = paramMetaMaterial.additionalPackage.superLowPackageUrl;
        arrayOfString1[1] = paramMetaMaterial.additionalPackage.lowPackageUrl;
        arrayOfString1[2] = paramMetaMaterial.additionalPackage.midPackageUrl;
        arrayOfString1[3] = paramMetaMaterial.additionalPackage.highPackageUrl;
        arrayOfString1[4] = paramMetaMaterial.packageUrl;
        arrayOfString2 = new String[5];
        arrayOfString2[0] = paramMetaMaterial.additionalPackage.superLowPackageMd5;
        arrayOfString2[1] = paramMetaMaterial.additionalPackage.lowPackageMd5;
        arrayOfString2[2] = paramMetaMaterial.additionalPackage.midPackageMd5;
        arrayOfString2[3] = paramMetaMaterial.additionalPackage.highPackageMd5;
        arrayOfString2[4] = paramMetaMaterial.packageMd5;
        int j = jdField_a_of_type_Int - 1;
        i = j;
        if (!TextUtils.isEmpty(arrayOfString1[j]))
        {
          paramMetaMaterial.packageUrl = arrayOfString1[j];
          paramMetaMaterial.packageMd5 = arrayOfString2[j];
          continue;
          i += 1;
        }
      }
      finally {}
      if (i < 5)
      {
        if (TextUtils.isEmpty(arrayOfString1[i])) {
          break;
        }
        paramMetaMaterial.packageUrl = arrayOfString1[i];
        paramMetaMaterial.packageMd5 = arrayOfString2[i];
      }
    }
  }
  
  public static VideoMaterial a(String paramString)
  {
    return VideoSDKMaterialParser.parseVideoMaterial(paramString, "params");
  }
  
  public static ArrayList<bnpb> a(String paramString)
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
      bnpb localbnpb;
      Object localObject3;
      bnpf localbnpf;
      Map localMap;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MetaCategory)((Iterator)localObject1).next();
        localbnpb = new bnpb();
        localbnpb.b = ((MetaCategory)localObject2).name;
        localbnpb.a = new ArrayList();
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MetaMaterial)((Iterator)localObject2).next();
            if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (bnpc.a())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))) {
              if ((paramString.containsKey(((MetaMaterial)localObject3).id)) && (paramString.get(((MetaMaterial)localObject3).id) != null))
              {
                localObject3 = (bnpf)paramString.get(((MetaMaterial)localObject3).id);
                localbnpb.a.add(localObject3);
              }
              else
              {
                localbnpf = new bnpf();
                localbnpf.jdField_c_of_type_JavaLangString = ((MetaMaterial)localObject3).thumbUrl;
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
        localbnpf.jdField_c_of_type_Int = Integer.parseInt((String)localMap.get("kind"));
        try
        {
          for (;;)
          {
            label357:
            localbnpf.jdField_d_of_type_Int = Integer.parseInt((String)localMap.get("displayType"));
            label377:
            localbnpf.g = ((String)localMap.get("qq_camera_top_title"));
            localbnpf.h = ((String)localMap.get("qq_camera_scheme"));
            localbnpf.l = ((String)localMap.get("playshow_cover_img"));
            localbnpf.m = ((String)localMap.get("playshow_display_text"));
            localbnpf.i = ((String)localMap.get("takeSameName"));
            try
            {
              if (!TextUtils.isEmpty((String)localMap.get("showCircleTakeSame"))) {}
              for (localbnpf.jdField_f_of_type_Int = Integer.valueOf((String)localMap.get("showCircleTakeSame")).intValue();; localbnpf.jdField_f_of_type_Int = 0)
              {
                label509:
                localbnpf.j = ((String)localMap.get("showEntry"));
                localbnpf.jdField_a_of_type_JavaLangString = ((MetaMaterial)localObject3).id;
                a(localbnpf, (MetaMaterial)localObject3);
                localbnpf.jdField_f_of_type_JavaLangString = ((MetaMaterial)localObject3).id;
                localbnpb.a.add(localbnpf);
                paramString.put(((MetaMaterial)localObject3).id, localbnpf);
                break;
              }
            }
            catch (Throwable localThrowable1)
            {
              break label509;
            }
          }
          localArrayList.add(localbnpb);
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
  
  private static void a(bnpf parambnpf, MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial.additionalPackage == null)
    {
      parambnpf.jdField_d_of_type_JavaLangString = paramMetaMaterial.packageUrl;
      parambnpf.e = paramMetaMaterial.packageMd5;
    }
    for (;;)
    {
      if ((paramMetaMaterial.packageUrl != null) && (!paramMetaMaterial.packageUrl.equals(parambnpf.jdField_d_of_type_JavaLangString))) {
        parambnpf.jdField_d_of_type_Boolean = true;
      }
      return;
      if ((TextUtils.isEmpty(paramMetaMaterial.additionalPackage.superLowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.lowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.midPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.highPackageUrl)))
      {
        parambnpf.jdField_d_of_type_JavaLangString = paramMetaMaterial.packageUrl;
        parambnpf.e = paramMetaMaterial.packageMd5;
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
          parambnpf.jdField_d_of_type_JavaLangString = arrayOfString1[j];
          parambnpf.e = arrayOfString2[j];
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
          parambnpf.jdField_d_of_type_JavaLangString = arrayOfString1[i];
          parambnpf.e = arrayOfString2[i];
        }
      }
    }
  }
  
  private static boolean a(MetaAdditionalPackage paramMetaAdditionalPackage)
  {
    return (paramMetaAdditionalPackage == null) || ((TextUtils.isEmpty(paramMetaAdditionalPackage.superLowPackageUrl)) && (TextUtils.isEmpty(paramMetaAdditionalPackage.lowPackageUrl)) && (TextUtils.isEmpty(paramMetaAdditionalPackage.midPackageUrl)) && (TextUtils.isEmpty(paramMetaAdditionalPackage.highPackageUrl)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */