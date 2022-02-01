package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonRecDressup
{
  private static final String EMOSM_SP_RECOMMEND = "emosm_sp_is_recommend";
  private static final long RECOMMEND_CLEAR_TIME = 2592000000L;
  public static long RECOMMEND_EXPIRED_TIME = 86400000L;
  private static final String TAG = "EmoticonRecDressup";
  public int authorId;
  public boolean hasRecommendDressup;
  public long lastLookupTime;
  
  public static EmoticonRecDressup getEmotionRecommend(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    paramString = localBaseApplicationImpl.getSharedPreferences("emosm_sp_is_recommend", 4).getString(localBaseApplicationImpl.getRuntime().getAccount() + "_" + paramString, null);
    if (paramString != null) {}
    do
    {
      try
      {
        paramString = new EmoticonRecDressup().init(new JSONObject(paramString));
        return paramString;
      }
      catch (JSONException paramString)
      {
        QLog.e("EmoticonRecDressup", 1, "getEmotionRecommend failed", paramString);
      }
      paramString = localObject;
    } while (!paramBoolean);
    paramString = new EmoticonRecDressup();
    paramString.hasRecommendDressup = true;
    return paramString;
  }
  
  private EmoticonRecDressup init(JSONObject paramJSONObject)
  {
    this.lastLookupTime = paramJSONObject.optLong("0");
    this.hasRecommendDressup = paramJSONObject.optBoolean("1");
    this.authorId = paramJSONObject.optInt("2");
    return this;
  }
  
  public static void setRecommendClearTime(long paramLong)
  {
    RECOMMEND_EXPIRED_TIME = 1000L * paramLong;
    QLog.i("EmoticonRecDressup", 1, "EmotionPanelViewPagerAdapter.RECOMMEND_EXPIRED_TIME update to " + RECOMMEND_EXPIRED_TIME);
  }
  
  public void saveEmotionRecommend(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = localBaseApplicationImpl.getSharedPreferences("emosm_sp_is_recommend", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    long l1 = localSharedPreferences.getLong("createTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 2592000000L)
    {
      localEditor.clear();
      localEditor.putLong("createTime", l2);
    }
    this.lastLookupTime = l2;
    localEditor.putString(localBaseApplicationImpl.getRuntime().getAccount() + "_" + paramInt, toString());
    localEditor.commit();
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("0", this.lastLookupTime);
      localJSONObject.put("1", this.hasRecommendDressup);
      localJSONObject.put("2", this.authorId);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("EmoticonRecDressup", 1, "toString failed", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonRecDressup
 * JD-Core Version:    0.7.0.1
 */