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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doraemonAPIManager call login onPermission code = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", timeconsume = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    QLog.i("DynamicNowManager", 1, ((StringBuilder)localObject).toString());
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131703738), 0).a();
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("fromid");
    if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(str1))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(this.jdField_a_of_type_AndroidOsBundle));
      localHashMap.put("zt_int3", String.valueOf(paramInt));
      if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager)) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("zt_int4", localObject);
      localHashMap.put("zt_int5", this.jdField_a_of_type_JavaLangString);
      localHashMap.put("act_type", "doraemon_permission");
      boolean bool = TextUtils.isEmpty(str1);
      String str2 = "";
      localObject = str1;
      if (bool) {
        localObject = "";
      }
      localHashMap.put("fromid", localObject);
      localObject = str2;
      if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager) != null) {
        localObject = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).getCurrentAccountUin();
      }
      localHashMap.put("userid", localObject);
      localHashMap.put("timelong", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a("00000MEVUX3CBYO1", "doraemon_permission#room_page#room", true, -1L, -1L, localHashMap, true, true);
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFinishContainerAct"))
    {
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doraemonAPIManager call login onFailure code = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("XProxy|NowProxy", 1, ((StringBuilder)localObject).toString());
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131703737), 0).a();
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("fromid");
    if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(str))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(this.jdField_a_of_type_AndroidOsBundle));
      localHashMap.put("zt_int3", String.valueOf(paramInt));
      localObject = "";
      if (paramString == null) {
        paramString = "";
      }
      localHashMap.put("zt_str3", paramString);
      if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager)) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      localHashMap.put("zt_int4", paramString);
      localHashMap.put("zt_int5", this.jdField_a_of_type_JavaLangString);
      localHashMap.put("act_type", "doraemon_fail");
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = "";
      }
      localHashMap.put("fromid", paramString);
      paramString = (String)localObject;
      if (DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager) != null) {
        paramString = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).getCurrentAccountUin();
      }
      localHashMap.put("userid", paramString);
      localHashMap.put("timelong", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a("00000MEVUX3CBYO1", "doraemon_fail#room_page#room", true, -1L, -1L, localHashMap, true, true);
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFinishContainerAct"))
    {
      paramString = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((paramString != null) && (paramString.get() != null)) {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.5
 * JD-Core Version:    0.7.0.1
 */