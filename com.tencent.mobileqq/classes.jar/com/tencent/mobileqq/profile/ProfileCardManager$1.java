package com.tencent.mobileqq.profile;

import android.os.Handler;
import android.text.TextUtils;
import awqu;
import awqv;
import bdhb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileCardManager$1
  implements Runnable
{
  public ProfileCardManager$1(awqu paramawqu, File paramFile, int paramInt) {}
  
  public void run()
  {
    Object localObject = bdhb.a(this.jdField_a_of_type_JavaIoFile, -1);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = new JSONObject((String)localObject).optJSONArray("baseInfo");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        JSONObject localJSONObject1 = ((JSONArray)localObject).getJSONObject(0);
        localObject = new awqv(this.this$0, this.jdField_a_of_type_Int);
        ((awqv)localObject).jdField_a_of_type_JavaLangString = localJSONObject1.optString("name");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("previewImage");
        if (localJSONObject2 != null) {
          ((awqv)localObject).b = (awqu.jdField_a_of_type_JavaLangString + localJSONObject2.optString("src"));
        }
        localJSONObject2 = localJSONObject1.optJSONObject("coverImg");
        if (localJSONObject2 != null) {
          ((awqv)localObject).c = (awqu.jdField_a_of_type_JavaLangString + localJSONObject2.optString("src"));
        }
        localJSONObject1 = localJSONObject1.optJSONObject("detailImage");
        if (localJSONObject1 != null) {
          ((awqv)localObject).d = (awqu.jdField_a_of_type_JavaLangString + localJSONObject1.optString("src"));
        }
        ((awqv)localObject).jdField_a_of_type_Boolean = true;
        awqu.a(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
        if (this.this$0.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.this$0.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
          this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 100L);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileCardManager", 2, "getDefaultCardItem: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardManager.1
 * JD-Core Version:    0.7.0.1
 */