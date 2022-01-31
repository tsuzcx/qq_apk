package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import bira;
import birb;
import bire;
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
  
  public static ArrayList<bira> a(String paramString)
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
      bira localbira;
      label163:
      Object localObject3;
      bire localbire;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MetaCategory)((Iterator)localObject1).next();
        localbira = new bira();
        localbira.b = ((MetaCategory)localObject2).name;
        localbira.a = new ArrayList();
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MetaMaterial)((Iterator)localObject2).next();
          if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (birb.a())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))) {
            if ((paramString.containsKey(((MetaMaterial)localObject3).id)) && (paramString.get(((MetaMaterial)localObject3).id) != null))
            {
              localObject3 = (bire)paramString.get(((MetaMaterial)localObject3).id);
              localbira.a.add(localObject3);
            }
            else
            {
              localbire = new bire();
              localbire.jdField_c_of_type_JavaLangString = ((MetaMaterial)localObject3).thumbUrl;
            }
          }
        }
      }
      try
      {
        localbire.jdField_c_of_type_Int = Integer.parseInt((String)((MetaMaterial)localObject3).additionalFields.get("kind"));
        try
        {
          label348:
          localbire.jdField_d_of_type_Int = Integer.parseInt((String)((MetaMaterial)localObject3).additionalFields.get("displayType"));
          try
          {
            label371:
            localbire.g = ((String)((MetaMaterial)localObject3).additionalFields.get("qq_camera_top_title"));
            try
            {
              label391:
              localbire.h = ((String)((MetaMaterial)localObject3).additionalFields.get("qq_camera_scheme"));
              try
              {
                label411:
                localbire.j = ((String)((MetaMaterial)localObject3).additionalFields.get("playshow_cover_img"));
                try
                {
                  label431:
                  localbire.k = ((String)((MetaMaterial)localObject3).additionalFields.get("playshow_display_text"));
                  label451:
                  localbire.a = ((MetaMaterial)localObject3).id;
                  localbire.e = ((MetaMaterial)localObject3).packageMd5;
                  localbire.f = ((MetaMaterial)localObject3).id;
                  localbire.jdField_d_of_type_JavaLangString = ((MetaMaterial)localObject3).packageUrl;
                  localbira.a.add(localbire);
                  paramString.put(((MetaMaterial)localObject3).id, localbire);
                  break label163;
                  localArrayList.add(localbira);
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