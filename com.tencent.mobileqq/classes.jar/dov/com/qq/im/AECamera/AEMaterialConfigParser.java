package dov.com.qq.im.AECamera;

import android.text.TextUtils;
import bgxt;
import bgxx;
import bgya;
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
  
  public static ArrayList<bgxt> a(String paramString)
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
      bgxt localbgxt;
      label163:
      Object localObject3;
      bgya localbgya;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MetaCategory)((Iterator)localObject1).next();
        localbgxt = new bgxt();
        localbgxt.jdField_b_of_type_JavaLangString = ((MetaCategory)localObject2).name;
        localbgxt.a = new ArrayList();
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MetaMaterial)((Iterator)localObject2).next();
          if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (bgxx.a())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))) {
            if ((paramString.containsKey(((MetaMaterial)localObject3).id)) && (paramString.get(((MetaMaterial)localObject3).id) != null))
            {
              localObject3 = (bgya)paramString.get(((MetaMaterial)localObject3).id);
              localbgxt.a.add(localObject3);
            }
            else
            {
              localbgya = new bgya();
              localbgya.jdField_b_of_type_JavaLangString = ((MetaMaterial)localObject3).thumbUrl;
            }
          }
        }
      }
      try
      {
        localbgya.jdField_b_of_type_Int = Integer.parseInt((String)((MetaMaterial)localObject3).additionalFields.get("kind"));
        try
        {
          label348:
          localbgya.jdField_c_of_type_Int = Integer.parseInt((String)((MetaMaterial)localObject3).additionalFields.get("displayType"));
          try
          {
            label371:
            localbgya.f = ((String)((MetaMaterial)localObject3).additionalFields.get("qq_camera_top_title"));
            try
            {
              label391:
              localbgya.g = ((String)((MetaMaterial)localObject3).additionalFields.get("qq_camera_scheme"));
              try
              {
                label411:
                localbgya.i = ((String)((MetaMaterial)localObject3).additionalFields.get("playshow_cover_img"));
                try
                {
                  label431:
                  localbgya.j = ((String)((MetaMaterial)localObject3).additionalFields.get("playshow_display_text"));
                  label451:
                  localbgya.a = ((MetaMaterial)localObject3).id;
                  localbgya.d = ((MetaMaterial)localObject3).packageMd5;
                  localbgya.e = ((MetaMaterial)localObject3).id;
                  localbgya.jdField_c_of_type_JavaLangString = ((MetaMaterial)localObject3).packageUrl;
                  localbgxt.a.add(localbgya);
                  paramString.put(((MetaMaterial)localObject3).id, localbgya);
                  break label163;
                  localArrayList.add(localbgxt);
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
 * Qualified Name:     dov.com.qq.im.AECamera.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */