package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.text.TextUtils;
import anvn;
import asfi;
import asfk;
import ashe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessengerService$IncomingHandler$14
  implements Runnable
{
  public MessengerService$IncomingHandler$14(ashe paramashe, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = (asfk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    Object localObject3 = ((asfk)localObject2).a();
    HashSet localHashSet;
    int i;
    if (localObject3 != null) {
      for (;;)
      {
        try
        {
          JSONArray localJSONArray = new JSONArray();
          localHashSet = new HashSet();
          localObject3 = ((List)localObject3).iterator();
          i = 0;
        }
        catch (JSONException localJSONException)
        {
          int j;
          this.jdField_a_of_type_AndroidOsBundle.putInt("result", 1);
          localObject2 = localJSONException.getMessage();
          if (localObject2 == null) {
            continue;
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("message", (String)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.emoji.web.MessengerService", 2, localJSONException.getMessage());
          return;
          i = j;
          if (TextUtils.isEmpty(((CustomEmotionData)localObject4).md5)) {
            continue;
          }
          i = j;
          if (((CustomEmotionData)localObject4).md5.length() <= 8) {
            continue;
          }
          Object localObject4 = ((CustomEmotionData)localObject4).md5.substring(0, 8).toLowerCase();
          localHashSet.add("qto_" + (String)localObject4);
          i = j;
          continue;
        }
        catch (Exception localException1)
        {
          this.jdField_a_of_type_AndroidOsBundle.putInt("result", 1);
          localObject1 = localException1.getMessage();
          if (localObject1 == null) {
            continue;
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("message", (String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.emoji.web.MessengerService", 2, (String)localObject1);
          return;
        }
        if (!((Iterator)localObject3).hasNext()) {
          break label440;
        }
        localObject4 = (CustomEmotionData)((Iterator)localObject3).next();
        if (!"needDel".equals(((CustomEmotionData)localObject4).RomaingType))
        {
          j = i + 1;
          if ((!((CustomEmotionData)localObject4).isMarkFace) && (TextUtils.isEmpty(((CustomEmotionData)localObject4).md5)) && (!TextUtils.isEmpty(((CustomEmotionData)localObject4).emoPath)))
          {
            ((CustomEmotionData)localObject4).md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(((CustomEmotionData)localObject4).emoPath));
            ((asfk)localObject2).b((CustomEmotionBase)localObject4);
          }
          if ((TextUtils.isEmpty(((CustomEmotionData)localObject4).url)) || (!((CustomEmotionData)localObject4).url.contains("qto_"))) {
            continue;
          }
          localObject4 = anvn.a(((CustomEmotionData)localObject4).url);
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            i = j;
            if (((String)localObject4).length() > "qto_".length() + 8)
            {
              localHashSet.add(((String)localObject4).substring(0, "qto_".length() + 8));
              i = j;
            }
          }
        }
      }
    }
    label440:
    do
    {
      Object localObject1;
      localHashSet.addAll(anvn.a);
      localObject2 = localHashSet.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((JSONArray)localObject1).put((String)((Iterator)localObject2).next());
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("remainNum", asfi.a - i);
      ((JSONObject)localObject2).put("uid", localObject1);
      this.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
      this.jdField_a_of_type_AndroidOsBundle.putString("data", ((JSONObject)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("remainNum", asfi.a);
        ((JSONObject)localObject1).put("uid", new JSONArray());
        this.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
        this.jdField_a_of_type_AndroidOsBundle.putString("data", ((JSONObject)localObject1).toString());
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      catch (Exception localException2) {}
    } while (!QLog.isColorLevel());
    QLog.i("Q.emoji.web.MessengerService", 2, localException2.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.14
 * JD-Core Version:    0.7.0.1
 */