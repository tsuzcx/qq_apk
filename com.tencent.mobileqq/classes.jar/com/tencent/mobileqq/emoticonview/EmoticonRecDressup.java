package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
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
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("emosm_sp_is_recommend", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localSharedPreferences.getString(localStringBuilder.toString(), null);
    if (paramString != null) {
      try
      {
        paramString = new EmoticonRecDressup().init(new JSONObject(paramString));
        return paramString;
      }
      catch (JSONException paramString)
      {
        QLog.e("EmoticonRecDressup", 1, "getEmotionRecommend failed", paramString);
      }
    }
    if (!paramBoolean) {
      return null;
    }
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
    RECOMMEND_EXPIRED_TIME = paramLong * 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmotionPanelViewPagerAdapter.RECOMMEND_EXPIRED_TIME update to ");
    localStringBuilder.append(RECOMMEND_EXPIRED_TIME);
    QLog.i("EmoticonRecDressup", 1, localStringBuilder.toString());
  }
  
  public void saveEmotionRecommend(int paramInt)
  {
    Object localObject = MobileQQ.getContext().getSharedPreferences("emosm_sp_is_recommend", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    long l1 = ((SharedPreferences)localObject).getLong("createTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 2592000000L)
    {
      localEditor.clear();
      localEditor.putLong("createTime", l2);
    }
    this.lastLookupTime = l2;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    localEditor.putString(((StringBuilder)localObject).toString(), toString());
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
    }
    catch (JSONException localJSONException)
    {
      QLog.e("EmoticonRecDressup", 1, "toString failed", localJSONException);
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonRecDressup
 * JD-Core Version:    0.7.0.1
 */