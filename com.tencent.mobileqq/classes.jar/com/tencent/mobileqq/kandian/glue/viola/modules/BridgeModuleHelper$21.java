package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class BridgeModuleHelper$21
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
  private List<ReadInJoyUserInfo> b = new ArrayList();
  
  BridgeModuleHelper$21(List paramList, String paramString, BridgeModule paramBridgeModule) {}
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Int -= 1;
    if (this.jdField_a_of_type_Int == 0) {
      b(paramString);
    }
  }
  
  private void b(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)localIterator.next();
        String str = ReadInJoyUserInfoModule.a(localReadInJoyUserInfo);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("headUrl", str).put("nickName", localReadInJoyUserInfo.nick).put("uin", localReadInJoyUserInfo.uin).put("vIconUrl", localReadInJoyUserInfo.smallIconUrl).put("authorizeDesc", localReadInJoyUserInfo.authorizeDesc);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("list", localJSONArray);
    }
    catch (Exception localException)
    {
      QLog.e("BridgeModuleHelper", 1, localException.getMessage());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeJS(paramString, localJSONObject1);
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    a(this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onLoadUserInfoFailed]: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", uin: ");
    localStringBuilder.append(paramString1);
    QLog.e("BridgeModuleHelper", 1, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    this.b.add(paramReadInJoyUserInfo);
    a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.21
 * JD-Core Version:    0.7.0.1
 */