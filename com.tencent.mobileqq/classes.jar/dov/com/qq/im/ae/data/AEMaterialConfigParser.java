package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import biqj;
import biqk;
import biqn;
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
  
  public static ArrayList<biqj> a(String paramString)
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
      biqj localbiqj;
      label163:
      Object localObject3;
      biqn localbiqn;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MetaCategory)((Iterator)localObject1).next();
        localbiqj = new biqj();
        localbiqj.b = ((MetaCategory)localObject2).name;
        localbiqj.a = new ArrayList();
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MetaMaterial)((Iterator)localObject2).next();
          if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (biqk.a())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))) {
            if ((paramString.containsKey(((MetaMaterial)localObject3).id)) && (paramString.get(((MetaMaterial)localObject3).id) != null))
            {
              localObject3 = (biqn)paramString.get(((MetaMaterial)localObject3).id);
              localbiqj.a.add(localObject3);
            }
            else
            {
              localbiqn = new biqn();
              localbiqn.jdField_c_of_type_JavaLangString = ((MetaMaterial)localObject3).thumbUrl;
            }
          }
        }
      }
      try
      {
        localbiqn.jdField_c_of_type_Int = Integer.parseInt((String)((MetaMaterial)localObject3).additionalFields.get("kind"));
        try
        {
          label348:
          localbiqn.jdField_d_of_type_Int = Integer.parseInt((String)((MetaMaterial)localObject3).additionalFields.get("displayType"));
          try
          {
            label371:
            localbiqn.g = ((String)((MetaMaterial)localObject3).additionalFields.get("qq_camera_top_title"));
            try
            {
              label391:
              localbiqn.h = ((String)((MetaMaterial)localObject3).additionalFields.get("qq_camera_scheme"));
              try
              {
                label411:
                localbiqn.j = ((String)((MetaMaterial)localObject3).additionalFields.get("playshow_cover_img"));
                try
                {
                  label431:
                  localbiqn.k = ((String)((MetaMaterial)localObject3).additionalFields.get("playshow_display_text"));
                  label451:
                  localbiqn.a = ((MetaMaterial)localObject3).id;
                  localbiqn.e = ((MetaMaterial)localObject3).packageMd5;
                  localbiqn.f = ((MetaMaterial)localObject3).id;
                  localbiqn.jdField_d_of_type_JavaLangString = ((MetaMaterial)localObject3).packageUrl;
                  localbiqj.a.add(localbiqn);
                  paramString.put(((MetaMaterial)localObject3).id, localbiqn);
                  break label163;
                  localArrayList.add(localbiqj);
                  continue;
                  return localArrayList;
                }
                catch (Throwable localThrowable1)
                {
                  break label451;
                }
              }
              catch (Throwable localThrowable2)
              {
                break label431;
              }
            }
            catch (Throwable localThrowable3)
            {
              break label411;
            }
          }
          catch (Throwable localThrowable4)
          {
            break label391;
          }
        }
        catch (Throwable localThrowable5)
        {
          break label371;
        }
      }
      catch (Throwable localThrowable6)
      {
        break label348;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */