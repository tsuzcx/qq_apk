package dov.com.tencent.mobileqq.shortvideo.util.videoconverter;

import ajed;
import android.os.Bundle;
import atmp;
import atmr;
import baig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShortVideoTravellerManager
  implements Manager
{
  public static final String a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  private atmp jdField_a_of_type_Atmp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject;
  WeakReference<MessengerService> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<ShortVideoTravellerManager.TravellerVideoItem> jdField_a_of_type_JavaUtilArrayList;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aT + "/tencent/qim/travellervideos/";
  }
  
  private void a(List<ShortVideoTravellerManager.TravellerVideoItem> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoTravellerManager", 2, "saveVideoListToDB al not correct");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Atmp.a(ShortVideoTravellerManager.TravellerVideoItem.class);
      atmr localatmr = this.jdField_a_of_type_Atmp.a();
      try
      {
        localatmr.a();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ShortVideoTravellerManager.TravellerVideoItem localTravellerVideoItem = (ShortVideoTravellerManager.TravellerVideoItem)paramList.next();
          this.jdField_a_of_type_Atmp.b(localTravellerVideoItem);
        }
      }
      finally
      {
        localatmr.b();
      }
      localatmr.b();
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoTravellerManager", 2, "saveVideoListToDB");
  }
  
  public void a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoTravellerManager", 2, "parseTravellerConfig mJsonList is null");
        }
        return;
      }
    }
    try
    {
      localObject2 = new JSONObject(paramString);
      if ((localObject2 == null) || (!((JSONObject)localObject2).has("videos"))) {
        break label208;
      }
      localObject2 = ((JSONObject)localObject2).getJSONArray("videos");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoTravellerManager", 2, "parseTravellerConfig array not correct");
        }
        return;
        paramString = finally;
        throw paramString;
      }
      baig.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      i = ((JSONArray)localObject2).length();
      paramInt = 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Object localObject2;
        int i;
        label208:
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoTravellerManager", 2, "parseTravellerConfig is wrong");
        }
        paramString.printStackTrace();
        continue;
        paramInt += 1;
      }
    }
    if (paramInt < i)
    {
      paramString = new ShortVideoTravellerManager.TravellerVideoItem(((JSONArray)localObject2).getJSONObject(paramInt));
      if ((paramString.video_id != -1) && (!paramString.url.equals(""))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      }
    }
    else
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
  }
  
  void a(ArrayList<ShortVideoTravellerManager.TravellerVideoItem> paramArrayList, Bundle paramBundle)
  {
    MessengerService localMessengerService = (MessengerService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localMessengerService != null) && (paramBundle != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("getDemoVideoList", paramArrayList);
      paramBundle.putBundle("response", localBundle);
      localMessengerService.a(paramBundle);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.videoconverter.ShortVideoTravellerManager
 * JD-Core Version:    0.7.0.1
 */