package com.tencent.mobileqq.ecshop.conf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EcshopConfProcessor
  extends IQConfigProcessor<EcshopConfBean>
{
  @Nullable
  public static EcshopConfBean a()
  {
    return (EcshopConfBean)QConfigManager.a().a(593);
  }
  
  public static EcshopConfBean a(String paramString)
  {
    EcshopConfBean localEcshopConfBean = new EcshopConfBean();
    if (!StringUtil.a(paramString)) {}
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        localEcshopConfBean.jdField_b_of_type_Int = localJSONObject1.optInt("jump_tab_id", 2);
        localEcshopConfBean.jdField_c_of_type_Int = localJSONObject1.optInt("tab_switch");
        localEcshopConfBean.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tab_background", "#FFFFFF");
        localEcshopConfBean.jdField_d_of_type_Int = localJSONObject1.optInt("is_preload");
        localEcshopConfBean.jdField_a_of_type_Int = localJSONObject1.optInt("ark_report_switch", 1);
        localEcshopConfBean.jdField_e_of_type_Int = localJSONObject1.optInt("maxMsgShow", 2);
        localEcshopConfBean.jdField_e_of_type_JavaLangString = localJSONObject1.optString("hippyErrorUrl");
        localEcshopConfBean.jdField_a_of_type_JavaLangString = localJSONObject1.optString("btn_txt");
        localEcshopConfBean.jdField_c_of_type_JavaLangString = localJSONObject1.optString("minus_view_titie_url", "https://i.gtimg.cn/channel/imglib/202005/upload_0130d1d150ac825d9804c01c17955272.png");
        localEcshopConfBean.jdField_d_of_type_JavaLangString = localJSONObject1.optString("recommend_title_url", "https://i.gtimg.cn/channel/imglib/202005/upload_d10f6014892e80a6195c5a965a6b8ac0.png");
        paramString = localJSONObject1.optJSONArray("tabs");
        Object localObject1;
        JSONObject localJSONObject2;
        Object localObject2;
        if ((paramString != null) && (paramString.length() > 0))
        {
          localObject1 = new ArrayList(paramString.length());
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject2 = paramString.optJSONObject(i);
            localObject2 = new EcshopConfBean.TabConfBean();
            ((EcshopConfBean.TabConfBean)localObject2).jdField_a_of_type_Int = localJSONObject2.optInt("tabid");
            ((EcshopConfBean.TabConfBean)localObject2).jdField_c_of_type_JavaLangString = localJSONObject2.optString("icon_normal");
            ((EcshopConfBean.TabConfBean)localObject2).jdField_d_of_type_JavaLangString = localJSONObject2.optString("icon_selected");
            ((EcshopConfBean.TabConfBean)localObject2).jdField_e_of_type_JavaLangString = localJSONObject2.optString("textcolor_normal", "#CCCCCC");
            ((EcshopConfBean.TabConfBean)localObject2).f = localJSONObject2.optString("textcolor_selected", "#000000");
            ((EcshopConfBean.TabConfBean)localObject2).jdField_b_of_type_JavaLangString = localJSONObject2.optString("jump_url", "https://h5.qianbao.qq.com/qqshop/index?_wwv=128&_wv=7");
            ((EcshopConfBean.TabConfBean)localObject2).jdField_a_of_type_JavaLangString = localJSONObject2.optString("name");
            ((EcshopConfBean.TabConfBean)localObject2).jdField_b_of_type_Int = localJSONObject2.optInt("page_type", 0);
            ((EcshopConfBean.TabConfBean)localObject2).g = localJSONObject2.optString("min_app_version", "8.3.3");
            if (((ArrayList)localObject1).contains(localObject2)) {
              break label819;
            }
            ((ArrayList)localObject1).add(localObject2);
            break label819;
          }
          localEcshopConfBean.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        }
        paramString = localJSONObject1.optJSONArray("menus");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localObject1 = new ArrayList(paramString.length());
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject2 = paramString.optJSONObject(i);
            localObject2 = new EcshopConfBean.MenuConfBean();
            ((EcshopConfBean.MenuConfBean)localObject2).jdField_a_of_type_Int = localJSONObject2.optInt("tabid");
            ((EcshopConfBean.MenuConfBean)localObject2).jdField_c_of_type_JavaLangString = localJSONObject2.optString("icon_normal");
            ((EcshopConfBean.MenuConfBean)localObject2).jdField_d_of_type_JavaLangString = localJSONObject2.optString("icon_selected");
            ((EcshopConfBean.MenuConfBean)localObject2).jdField_e_of_type_JavaLangString = localJSONObject2.optString("textcolor_normal", "#CCCCCC");
            ((EcshopConfBean.MenuConfBean)localObject2).f = localJSONObject2.optString("textcolor_selected", "#000000");
            ((EcshopConfBean.MenuConfBean)localObject2).jdField_b_of_type_JavaLangString = localJSONObject2.optString("jump_url", "https://h5.qianbao.qq.com/qqshop/index?_wwv=128&_wv=7");
            ((EcshopConfBean.MenuConfBean)localObject2).jdField_a_of_type_JavaLangString = localJSONObject2.optString("name");
            ((EcshopConfBean.MenuConfBean)localObject2).jdField_b_of_type_Int = localJSONObject2.optInt("page_type", 0);
            ((EcshopConfBean.MenuConfBean)localObject2).g = localJSONObject2.optString("min_app_version", "8.3.3");
            if (((ArrayList)localObject1).contains(localObject2)) {
              break label826;
            }
            ((ArrayList)localObject1).add(localObject2);
            break label826;
          }
          localEcshopConfBean.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        }
        localJSONObject1 = localJSONObject1.optJSONObject("promotion");
        if (localJSONObject1 != null)
        {
          paramString = localEcshopConfBean.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$PromotionConfBean;
          paramString.jdField_a_of_type_JavaLangString = localJSONObject1.optString("begin_time");
          paramString.jdField_b_of_type_JavaLangString = localJSONObject1.optString("end_time");
          paramString.jdField_c_of_type_JavaLangString = localJSONObject1.optString("rain_url");
          paramString.jdField_d_of_type_JavaLangString = localJSONObject1.optString("rain_icon_url");
          paramString.jdField_a_of_type_Int = localJSONObject1.optInt("is_preload");
          localObject1 = localJSONObject1.optJSONObject("warm_up");
          if (localObject1 != null)
          {
            paramString.jdField_a_of_type_JavaUtilMap.put("bottom_bg_url", ((JSONObject)localObject1).optString("bottom_bg_url"));
            paramString.jdField_a_of_type_JavaUtilMap.put("bottom_ani_url", ((JSONObject)localObject1).optString("bottom_ani_url"));
            paramString.jdField_a_of_type_JavaUtilMap.put("discount_bg_url", ((JSONObject)localObject1).optString("discount_bg_url"));
            paramString.jdField_a_of_type_JavaUtilMap.put("detail_bg_url", ((JSONObject)localObject1).optString("detail_bg_url"));
            paramString.jdField_a_of_type_JavaUtilMap.put("detail_logo_url", ((JSONObject)localObject1).optString("detail_logo_url"));
          }
          localJSONObject1 = localJSONObject1.optJSONObject("high_tide");
          if (localJSONObject1 != null)
          {
            paramString.jdField_b_of_type_JavaUtilMap.put("top_bg_url", localJSONObject1.optString("top_bg_url"));
            paramString.jdField_b_of_type_JavaUtilMap.put("bottom_bg_url", localJSONObject1.optString("bottom_bg_url"));
            paramString.jdField_b_of_type_JavaUtilMap.put("bottom_ani_url", localJSONObject1.optString("bottom_ani_url"));
            paramString.jdField_b_of_type_JavaUtilMap.put("discount_bg_url", localJSONObject1.optString("discount_bg_url"));
            paramString.jdField_b_of_type_JavaUtilMap.put("detail_bg_url", localJSONObject1.optString("detail_bg_url"));
            return localEcshopConfBean;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return localEcshopConfBean;
      label819:
      i += 1;
      continue;
      label826:
      i += 1;
    }
  }
  
  @NonNull
  public EcshopConfBean a(int paramInt)
  {
    return new EcshopConfBean();
  }
  
  @Nullable
  public EcshopConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0)) {
      return a(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
    }
    return new EcshopConfBean();
  }
  
  public void a(EcshopConfBean paramEcshopConfBean) {}
  
  public Class<EcshopConfBean> clazz()
  {
    return EcshopConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 593;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor
 * JD-Core Version:    0.7.0.1
 */