package cooperation.qqcircle.chat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Set;
import mqq.app.AppRuntime;

public class QCircleSharePreferenceUtil
{
  private static final String SP_FILE_NAME = "sp_qqcircle";
  
  public static SharedPreferences getQCircleSp(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    for (String str = "sp_qqcircle" + "_" + str;; str = "sp_qqcircle")
    {
      int j = 0;
      int i = j;
      if (paramBoolean2)
      {
        i = j;
        if (Build.VERSION.SDK_INT >= 11) {
          i = 4;
        }
      }
      return BaseApplicationImpl.getApplication().getSharedPreferences(str, i);
    }
  }
  
  public static Object getQCircleSpValue(String paramString, Object paramObject)
  {
    return getQCircleSpValue(paramString, paramObject, true, true);
  }
  
  public static Object getQCircleSpValue(String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences localSharedPreferences = getQCircleSp(paramBoolean1, paramBoolean2);
    if (localSharedPreferences != null)
    {
      if ((paramObject instanceof Integer)) {
        return Integer.valueOf(localSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
      }
      if ((paramObject instanceof String)) {
        return localSharedPreferences.getString(paramString, (String)paramObject);
      }
      if ((paramObject instanceof Boolean)) {
        return Boolean.valueOf(localSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
      }
      if ((paramObject instanceof Float)) {
        return Float.valueOf(localSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue()));
      }
      if ((paramObject instanceof Long)) {
        return Long.valueOf(localSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
      }
      if ((paramObject instanceof Set)) {
        return localSharedPreferences.getStringSet(paramString, (Set)paramObject);
      }
    }
    return null;
  }
  
  public static boolean updateQCircleSpValue(String paramString, Object paramObject)
  {
    Object localObject = getQCircleSp(true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if ((paramObject instanceof Integer)) {
        ((SharedPreferences.Editor)localObject).putInt(paramString, ((Integer)paramObject).intValue());
      }
      for (;;)
      {
        return ((SharedPreferences.Editor)localObject).commit();
        if ((paramObject instanceof String)) {
          ((SharedPreferences.Editor)localObject).putString(paramString, (String)paramObject);
        } else if ((paramObject instanceof Boolean)) {
          ((SharedPreferences.Editor)localObject).putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        } else if ((paramObject instanceof Float)) {
          ((SharedPreferences.Editor)localObject).putFloat(paramString, ((Float)paramObject).floatValue());
        } else if ((paramObject instanceof Long)) {
          ((SharedPreferences.Editor)localObject).putLong(paramString, ((Long)paramObject).longValue());
        } else if ((paramObject instanceof Set)) {
          ((SharedPreferences.Editor)localObject).putStringSet(paramString, (Set)paramObject);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.chat.QCircleSharePreferenceUtil
 * JD-Core Version:    0.7.0.1
 */