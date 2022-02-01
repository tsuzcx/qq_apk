package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocConvertConfigBean
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "https://eim.connect.qq.com/guide/install.html?install=1";
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString = "";
  private boolean jdField_h_of_type_Boolean;
  
  public static TencentDocConvertConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TencentDocConvertConfigBean localTencentDocConvertConfigBean;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      localTencentDocConvertConfigBean = new TencentDocConvertConfigBean();
    }
    for (;;)
    {
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfQConfItem.has("TIMDocs"))
        {
          paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("TIMDocs");
          if (paramArrayOfQConfItem.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("autoImportToSharedDocSwitch") != 1) {
              break label591;
            }
            bool = true;
            localTencentDocConvertConfigBean.jdField_a_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label596;
            }
            bool = true;
            localTencentDocConvertConfigBean.jdField_b_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("openFileInTimSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("openFileInTimSwitch") != 1) {
              break label601;
            }
            bool = true;
            localTencentDocConvertConfigBean.jdField_c_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("aioSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("aioSwitch") != 1) {
              break label606;
            }
            bool = true;
            localTencentDocConvertConfigBean.jdField_d_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("fileViewerMenuSwitch") != 1) {
              break label611;
            }
            bool = true;
            localTencentDocConvertConfigBean.jdField_e_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("openFileInTimEntry")) {
            localTencentDocConvertConfigBean.jdField_a_of_type_Int = paramArrayOfQConfItem.getInt("openFileInTimEntry");
          }
          if (paramArrayOfQConfItem.has("androidURL")) {
            localTencentDocConvertConfigBean.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.getString("androidURL");
          }
          if (paramArrayOfQConfItem.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfQConfItem.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label616;
            }
            bool = true;
            localTencentDocConvertConfigBean.jdField_f_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("timVersion")) {
            localTencentDocConvertConfigBean.jdField_b_of_type_Int = paramArrayOfQConfItem.getInt("timVersion");
          }
          if (paramArrayOfQConfItem.has("saveTipLine0")) {
            localTencentDocConvertConfigBean.jdField_b_of_type_JavaLangString = paramArrayOfQConfItem.getString("saveTipLine0");
          }
          if (paramArrayOfQConfItem.has("saveTipLine1")) {
            localTencentDocConvertConfigBean.jdField_c_of_type_JavaLangString = paramArrayOfQConfItem.getString("saveTipLine1");
          }
          if (paramArrayOfQConfItem.has("saveAndCloseTipLine0")) {
            localTencentDocConvertConfigBean.jdField_d_of_type_JavaLangString = paramArrayOfQConfItem.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfQConfItem.has("saveAndCloseTipLine1")) {
            localTencentDocConvertConfigBean.jdField_e_of_type_JavaLangString = paramArrayOfQConfItem.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfQConfItem.has("saveTipCount")) {
            localTencentDocConvertConfigBean.jdField_c_of_type_Int = paramArrayOfQConfItem.getInt("saveTipCount");
          }
          if (paramArrayOfQConfItem.has("contentEditedTipLine0")) {
            localTencentDocConvertConfigBean.jdField_f_of_type_JavaLangString = paramArrayOfQConfItem.getString("contentEditedTipLine0");
          }
          if (paramArrayOfQConfItem.has("contentEditedTipLine1")) {
            localTencentDocConvertConfigBean.jdField_g_of_type_JavaLangString = paramArrayOfQConfItem.getString("contentEditedTipLine1");
          }
          if (paramArrayOfQConfItem.has("contentEditedTipCount")) {
            localTencentDocConvertConfigBean.jdField_d_of_type_Int = paramArrayOfQConfItem.getInt("contentEditedTipCount");
          }
          if (paramArrayOfQConfItem.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("docListEntryInFileSwitch") != 1) {
              break label621;
            }
            bool = true;
            localTencentDocConvertConfigBean.jdField_g_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("hideDocAuthoritySettingEntry"))
          {
            if (paramArrayOfQConfItem.getInt("hideDocAuthoritySettingEntry") != 1) {
              break label626;
            }
            bool = true;
            localTencentDocConvertConfigBean.jdField_h_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("docListUrl")) {
            localTencentDocConvertConfigBean.jdField_h_of_type_JavaLangString = paramArrayOfQConfItem.getString("docListUrl");
          }
          if (paramArrayOfQConfItem.has("editSupport"))
          {
            paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfQConfItem.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localTencentDocConvertConfigBean.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfQConfItem.getLong(str)));
              continue;
            }
          }
        }
        return localTencentDocConvertConfigBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
      }
      return null;
      label591:
      boolean bool = false;
      continue;
      label596:
      bool = false;
      continue;
      label601:
      bool = false;
      continue;
      label606:
      bool = false;
      continue;
      label611:
      bool = false;
      continue;
      label616:
      bool = false;
      continue;
      label621:
      bool = false;
      continue;
      label626:
      bool = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Map<String, Long> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public String e()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public String f()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public String g()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public String h()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean
 * JD-Core Version:    0.7.0.1
 */