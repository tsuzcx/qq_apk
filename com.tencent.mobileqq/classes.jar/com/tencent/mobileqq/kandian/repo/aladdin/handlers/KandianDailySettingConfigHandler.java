package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.daily.ReadInJoyDailySettingModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class KandianDailySettingConfigHandler
  extends SimpleConfigHandler
{
  ReadInJoyDailySettingModel a(String paramString, List<ReadInJoyDailySettingModel> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ReadInJoyDailySettingModel localReadInJoyDailySettingModel = (ReadInJoyDailySettingModel)paramList.next();
      if (localReadInJoyDailySettingModel.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localReadInJoyDailySettingModel;
      }
    }
    return null;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onReceiveConfig] ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("KandianDailySettingConfigHandler", 2, ((StringBuilder)localObject1).toString());
    Map localMap = AladdinParseUtils.a(paramString);
    Object localObject3 = localMap.keySet();
    String str = ReadInJoyMMapKvStorage.getInstance().getValeForKey("KANDIAN_DAILY_SETTING_CONFIG");
    localObject1 = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    paramString = (String)localObject1;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        paramString = new JSONArray(str);
        try
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("old data: ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("KandianDailySettingConfigHandler", 2, ((StringBuilder)localObject1).toString());
          paramInt1 = 0;
          while (paramInt1 < paramString.length())
          {
            localArrayList.add(ReadInJoyDailySettingModel.a(paramString.optJSONObject(paramInt1)));
            paramInt1 += 1;
          }
        }
        catch (JSONException localJSONException1) {}
        ((JSONException)localObject2).printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        paramString = localJSONException1;
        localObject2 = localJSONException2;
      }
    }
    Iterator localIterator = ((Set)localObject3).iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      localObject2 = (String)localMap.get(localObject3);
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("[onReceiveConfig] key=");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(", value=");
      ((StringBuilder)localObject4).append((String)localObject2);
      QLog.d("KandianDailySettingConfigHandler", 2, ((StringBuilder)localObject4).toString());
      localObject4 = ((String)localObject2).split("\\|");
      if (localObject4.length == 3)
      {
        localObject2 = a((String)localObject3, localArrayList);
        if (localObject2 == null)
        {
          localObject2 = new ReadInJoyDailySettingModel();
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = 1;
        }
        ((ReadInJoyDailySettingModel)localObject2).jdField_b_of_type_JavaLangString = localObject4[0];
        ((ReadInJoyDailySettingModel)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
        localObject3 = localObject4[1].split(",");
        localObject4 = localObject4[2].split(",");
        ((ReadInJoyDailySettingModel)localObject2).jdField_b_of_type_JavaUtilList = new ArrayList();
        ((ReadInJoyDailySettingModel)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
        ((ReadInJoyDailySettingModel)localObject2).jdField_b_of_type_JavaUtilList.add("");
        ((ReadInJoyDailySettingModel)localObject2).jdField_a_of_type_JavaUtilList.add("");
        paramInt2 = 0;
        while (paramInt2 < localObject3.length)
        {
          ((ReadInJoyDailySettingModel)localObject2).jdField_a_of_type_JavaUtilList.add(localObject3[paramInt2]);
          paramInt2 += 1;
        }
        paramInt2 = 0;
        while (paramInt2 < localObject4.length)
        {
          ((ReadInJoyDailySettingModel)localObject2).jdField_b_of_type_JavaUtilList.add(localObject4[paramInt2]);
          paramInt2 += 1;
        }
        if (paramInt1 == 0) {
          paramString.put(((ReadInJoyDailySettingModel)localObject2).a());
        }
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("new data: ");
    ((StringBuilder)localObject2).append(paramString.toString());
    QLog.d("KandianDailySettingConfigHandler", 2, ((StringBuilder)localObject2).toString());
    ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", paramString.toString());
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    QLog.d("KandianDailySettingConfigHandler", 2, "[onWipeConfig]");
    ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.KandianDailySettingConfigHandler
 * JD-Core Version:    0.7.0.1
 */