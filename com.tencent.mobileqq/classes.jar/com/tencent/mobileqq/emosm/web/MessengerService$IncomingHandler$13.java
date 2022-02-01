package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MessengerService$IncomingHandler$13
  implements Runnable
{
  MessengerService$IncomingHandler$13(MessengerService.IncomingHandler paramIncomingHandler, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1 = (IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    Object localObject2 = ((IFavroamingDBManagerService)localObject1).getEmoticonDataList();
    if (localObject2 != null) {}
    label633:
    label634:
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        HashSet localHashSet = new HashSet();
        localObject2 = ((List)localObject2).iterator();
        int i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (CustomEmotionData)((Iterator)localObject2).next();
          if ("needDel".equals(((CustomEmotionData)localObject3).RomaingType)) {
            continue;
          }
          i += 1;
          if ((!((CustomEmotionData)localObject3).isMarkFace) && (TextUtils.isEmpty(((CustomEmotionData)localObject3).md5)) && (!TextUtils.isEmpty(((CustomEmotionData)localObject3).emoPath)))
          {
            ((CustomEmotionData)localObject3).md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(((CustomEmotionData)localObject3).emoPath));
            ((IFavroamingDBManagerService)localObject1).updateCustomEmotion((CustomEmotionData)localObject3);
          }
          boolean bool = TextUtils.isEmpty(((CustomEmotionData)localObject3).url);
          if ((!bool) && (((CustomEmotionData)localObject3).url.contains("qto_")))
          {
            localObject3 = FunnyPicHelperConstant.a(((CustomEmotionData)localObject3).url);
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (((String)localObject3).length() <= 12)) {
              break label634;
            }
            localHashSet.add(((String)localObject3).substring(0, 12));
            break label634;
          }
          if ((TextUtils.isEmpty(((CustomEmotionData)localObject3).md5)) || (((CustomEmotionData)localObject3).md5.length() <= 8)) {
            break label634;
          }
          localObject3 = ((CustomEmotionData)localObject3).md5.substring(0, 8).toLowerCase();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("qto_");
          localStringBuilder.append((String)localObject3);
          localHashSet.add(localStringBuilder.toString());
          break label634;
        }
        localHashSet.addAll(FunnyPicHelperConstant.a);
        localObject1 = localHashSet.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localJSONArray.put((String)((Iterator)localObject1).next());
          continue;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("remainNum", FavEmoConstant.a - i);
        ((JSONObject)localObject1).put("uid", localJSONArray);
        this.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
        this.jdField_a_of_type_AndroidOsBundle.putString("data", ((JSONObject)localObject1).toString());
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      catch (Exception localException1)
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("result", 1);
        String str = localException1.getMessage();
        if (str != null) {
          this.jdField_a_of_type_AndroidOsBundle.putString("message", str);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        if (!QLog.isColorLevel()) {
          break label633;
        }
        QLog.i("Q.emoji.web.MessengerService", 2, str);
        return;
      }
      catch (JSONException localJSONException)
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("result", 1);
        localObject1 = localJSONException.getMessage();
        if (localObject1 != null) {
          this.jdField_a_of_type_AndroidOsBundle.putString("message", (String)localObject1);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        if (!QLog.isColorLevel()) {
          break label633;
        }
      }
      QLog.i("Q.emoji.web.MessengerService", 2, localJSONException.getMessage());
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("remainNum", FavEmoConstant.a);
        localJSONObject.put("uid", new JSONArray());
        this.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
        this.jdField_a_of_type_AndroidOsBundle.putString("data", localJSONObject.toString());
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.MessengerService", 2, localException2.getMessage());
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.13
 * JD-Core Version:    0.7.0.1
 */