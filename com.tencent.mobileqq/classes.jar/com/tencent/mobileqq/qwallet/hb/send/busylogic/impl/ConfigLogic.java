package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.util.SparseArray;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.hb.send.impl.WordChainHbFragment.WordChainTypeLabel;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigLogic
{
  private SparseArray<PanelData> a = new SparseArray();
  
  public ConfigLogic()
  {
    Object localObject = QWalletTools.a();
    if (localObject != null)
    {
      localObject = (IQWalletConfigService)((BaseQQAppInterface)localObject).getRuntimeService(IQWalletConfigService.class, "");
      int i = 0;
      JSONArray localJSONArray = ((IQWalletConfigService)localObject).getArray("redPackPanel", new String[] { "panelRedPkgList" });
      if (localJSONArray == null)
      {
        QLog.i("ConfigLogic", 2, "no pkg list...");
        return;
      }
      localObject = null;
      while (i < localJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          localObject = localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        if (localObject != null)
        {
          PanelData localPanelData = new PanelData();
          localPanelData.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
          localPanelData.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
          localPanelData.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", "");
          localPanelData.c = ((JSONObject)localObject).optString("icon_pic", "");
          localPanelData.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("panelData = ");
            localStringBuilder.append(localPanelData);
            QLog.i("ConfigLogic", 2, localStringBuilder.toString());
          }
          this.a.put(localPanelData.jdField_a_of_type_Int, localPanelData);
        }
        i += 1;
      }
    }
  }
  
  public PanelData a(int paramInt1, int paramInt2)
  {
    paramInt2 = HbBusiUtils.a(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channel: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", type = ");
    localStringBuilder.append(paramInt2);
    QLog.i("ConfigLogic", 2, localStringBuilder.toString());
    return (PanelData)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    if ((localObject != null) && (((PanelData)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((PanelData)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channel: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", hint array: ");
      localStringBuilder.append(localObject);
      QLog.i("ConfigLogic", 2, localStringBuilder.toString());
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        return ((JSONArray)localObject).optString(0, paramString);
      }
    }
    return paramString;
  }
  
  public ArrayList<WordChainHbFragment.WordChainTypeLabel> a(int paramInt, HbInfo.BundleInfo paramBundleInfo)
  {
    int i = 2;
    if (paramBundleInfo != null) {
      i = QwUtils.a(paramBundleInfo.bus_type, 2);
    }
    paramBundleInfo = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((PanelData)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((PanelData)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = new WordChainHbFragment.WordChainTypeLabel();
          localWordChainTypeLabel.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localWordChainTypeLabel.jdField_a_of_type_Int = localJSONObject.optInt("sub_channel");
          localWordChainTypeLabel.jdField_b_of_type_Int = localJSONObject.optInt("max_length", 0);
          localWordChainTypeLabel.jdField_b_of_type_JavaLangString = localJSONObject.optString("hint");
          paramBundleInfo.add(localWordChainTypeLabel);
          paramInt += 1;
        }
      }
    }
    return paramBundleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.ConfigLogic
 * JD-Core Version:    0.7.0.1
 */