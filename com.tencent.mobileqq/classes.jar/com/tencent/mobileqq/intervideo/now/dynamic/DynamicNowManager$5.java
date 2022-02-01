package com.tencent.mobileqq.intervideo.now.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.dynamic.strategy.IEnterRoomStrategy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DynamicNowManager$5
  extends DefaultLiveTicketObserver
{
  DynamicNowManager$5(DynamicNowManager paramDynamicNowManager, long paramLong, Bundle paramBundle, String paramString, WeakReference paramWeakReference) {}
  
  public void a(int paramInt)
  {
    QLog.i("DynamicNowManager", 1, "doraemonAPIManager call login onPermission code = " + paramInt + ", timeconsume = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131703607), 0).a();
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("fromid");
    HashMap localHashMap;
    if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(str2))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(this.jdField_a_of_type_AndroidOsBundle));
      localHashMap.put("zt_int3", String.valueOf(paramInt));
      if (!DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager)) {
        break label328;
      }
      str1 = "1";
      localHashMap.put("zt_int4", str1);
      localHashMap.put("zt_int5", this.jdField_a_of_type_JavaLangString);
      localHashMap.put("act_type", "doraemon_permission");
      if (!TextUtils.isEmpty(str2)) {
        break label334;
      }
      str1 = "";
      label193:
      localHashMap.put("fromid", str1);
      if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager) == null) {
        break label339;
      }
    }
    label328:
    label334:
    label339:
    for (String str1 = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).getCurrentAccountUin();; str1 = "")
    {
      localHashMap.put("userid", str1);
      localHashMap.put("timelong", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a("00000MEVUX3CBYO1", "doraemon_permission#room_page#room", true, -1L, -1L, localHashMap, true, true);
      if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFinishContainerAct")) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      }
      return;
      str1 = "0";
      break;
      str1 = str2;
      break label193;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onFailure code = " + paramInt);
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131703606), 0).a();
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("fromid");
    HashMap localHashMap;
    if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(str2))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(this.jdField_a_of_type_AndroidOsBundle));
      localHashMap.put("zt_int3", String.valueOf(paramInt));
      String str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      localHashMap.put("zt_str3", str1);
      if (!DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager)) {
        break label335;
      }
      paramString = "1";
      localHashMap.put("zt_int4", paramString);
      localHashMap.put("zt_int5", this.jdField_a_of_type_JavaLangString);
      localHashMap.put("act_type", "doraemon_fail");
      if (!TextUtils.isEmpty(str2)) {
        break label341;
      }
      paramString = "";
      label200:
      localHashMap.put("fromid", paramString);
      if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager) == null) {
        break label347;
      }
    }
    label335:
    label341:
    label347:
    for (paramString = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).getCurrentAccountUin();; paramString = "")
    {
      localHashMap.put("userid", paramString);
      localHashMap.put("timelong", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a("00000MEVUX3CBYO1", "doraemon_fail#room_page#room", true, -1L, -1L, localHashMap, true, true);
      if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFinishContainerAct")) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      }
      return;
      paramString = "0";
      break;
      paramString = str2;
      break label200;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager, this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("XProxy|NowProxy", 1, paramJSONObject, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.5
 * JD-Core Version:    0.7.0.1
 */