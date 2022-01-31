package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import bkzx;
import bkzy;
import blab;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
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
  private static final String a = AEMaterialConfigParser.class.getSimpleName();
  
  public static VideoMaterial a(String paramString)
  {
    return VideoSDKMaterialParser.parseVideoMaterial(paramString, "params");
  }
  
  public static ArrayList<bkzx> a(String paramString)
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
      QLog.d(a, 4, "###  parseMaterialListFromConfig exception = " + paramString.getMessage());
      throw new AEMaterialConfigParser.AEMaterialConfigParseException("parseMaterialListFromConfig error");
    }
    paramString = new HashMap();
    localObject1 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
    for (;;)
    {
      bkzx localbkzx;
      label163:
      Object localObject3;
      blab localblab;
      Map localMap;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MetaCategory)((Iterator)localObject1).next();
        localbkzx = new bkzx();
        localbkzx.b = ((MetaCategory)localObject2).name;
        localbkzx.a = new ArrayList();
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MetaMaterial)((Iterator)localObject2).next();
            if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (bkzy.a())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))) {
              if ((paramString.containsKey(((MetaMaterial)localObject3).id)) && (paramString.get(((MetaMaterial)localObject3).id) != null))
              {
                localObject3 = (blab)paramString.get(((MetaMaterial)localObject3).id);
                localbkzx.a.add(localObject3);
              }
              else
              {
                localblab = new blab();
                localblab.jdField_c_of_type_JavaLangString = ((MetaMaterial)localObject3).thumbUrl;
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
        localblab.jdField_c_of_type_Int = Integer.parseInt((String)localMap.get("kind"));
        try
        {
          label357:
          localblab.jdField_d_of_type_Int = Integer.parseInt((String)localMap.get("displayType"));
          label377:
          localblab.g = ((String)localMap.get("qq_camera_top_title"));
          localblab.h = ((String)localMap.get("qq_camera_scheme"));
          localblab.k = ((String)localMap.get("playshow_cover_img"));
          localblab.l = ((String)localMap.get("playshow_display_text"));
          localblab.i = ((String)localMap.get("takeSameName"));
          localblab.a = ((MetaMaterial)localObject3).id;
          localblab.e = ((MetaMaterial)localObject3).packageMd5;
          localblab.f = ((MetaMaterial)localObject3).id;
          localblab.jdField_d_of_type_JavaLangString = ((MetaMaterial)localObject3).packageUrl;
          localbkzx.a.add(localblab);
          paramString.put(((MetaMaterial)localObject3).id, localblab);
          break label163;
          localArrayList.add(localbkzx);
          continue;
          return localArrayList;
        }
        catch (Throwable localThrowable1)
        {
          break label377;
        }
      }
      catch (Throwable localThrowable2)
      {
        break label357;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */