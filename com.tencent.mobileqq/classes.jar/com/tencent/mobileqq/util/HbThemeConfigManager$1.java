package com.tencent.mobileqq.util;

import aklv;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bghb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class HbThemeConfigManager$1
  implements Runnable
{
  public HbThemeConfigManager$1(bghb parambghb, Context paramContext, JSONObject paramJSONObject, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qb_tenpay_share_face", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("hb_face", bghb.a(this.this$0, this.jdField_a_of_type_OrgJsonJSONObject).toString());
    ((SharedPreferences.Editor)localObject).commit();
    localObject = bghb.a(this.this$0).optString("hb_face_imgurl");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HbThemeConfigManager", 2, "start downloading img...");
    }
    HashSet localHashSet = new HashSet(2);
    localHashSet.add(localObject);
    aklv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.HbThemeConfigManager.1
 * JD-Core Version:    0.7.0.1
 */