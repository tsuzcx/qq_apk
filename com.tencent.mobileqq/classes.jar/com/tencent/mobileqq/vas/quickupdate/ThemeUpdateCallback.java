package com.tencent.mobileqq.vas.quickupdate;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class ThemeUpdateCallback
  extends BaseUpdateCallback
{
  public static final long BID_THEME = 3L;
  public static final String SCID_THEME_PREFIX = "theme.";
  public static String SCID_THEME_ZIP_PREFIX = "theme.";
  public static final String TAG = "ThemeUpdateCallback";
  public static ThemeUpdateCallback sInstance = new ThemeUpdateCallback();
  
  private boolean checkNewVersionValid(String paramString)
  {
    if ((paramString.startsWith("theme.android")) || (paramString.endsWith(".cfg")))
    {
      QLog.e("ThemeUpdateCallback", 1, "VasUpdate getItemInfo checkNewVersionValid filter scid = " + paramString);
      return true;
    }
    return false;
  }
  
  private void onThemeComplete(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).onThemeComplete(paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if (!ThemeUtil.a(paramString))
    {
      Object localObject = ThemeUtil.b(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ThemeLocator().a((String)localObject);
        if (paramString.startsWith(SCID_THEME_ZIP_PREFIX)) {}
        for (paramString = ((ThemeLocator)localObject).a(MobileQQ.getContext(), paramString, "").c();; paramString = ((ThemeLocator)localObject).b(MobileQQ.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeUpdateCallback", 2, "deleteFiles: " + paramString);
          }
          return new File(paramString).delete();
        }
      }
    }
    else
    {
      QLog.e("ThemeUpdateCallback", 1, "deleteFiles ignore ios theme:" + paramString);
    }
    return false;
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (!ThemeUtil.a(paramString1))
    {
      onThemeComplete(paramString1, paramString2, paramString3, paramInt1, paramInt2);
      return;
    }
    QLog.e("ThemeUpdateCallback", 1, "onCompleted ignore ios theme:" + paramString1);
  }
  
  public void doOnProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (!ThemeUtil.a(paramString1)) {
      ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).onThemeProgress(paramString1, paramLong2, paramLong3);
    }
  }
  
  public long getBID()
  {
    return 3L;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    ThemeLocator localThemeLocator = null;
    if ("theme_mapping_config_android".equals(paramString))
    {
      localObject = new TagItemInfo();
      ((TagItemInfo)localObject).jdField_a_of_type_Boolean = false;
      ((TagItemInfo)localObject).b = false;
      ((TagItemInfo)localObject).jdField_a_of_type_JavaLangString = getSavePath(MobileQQ.getContext(), paramString);
    }
    String str;
    do
    {
      do
      {
        return localObject;
        localObject = localThemeLocator;
      } while (checkNewVersionValid(paramString));
      if (ThemeUtil.a(paramString)) {
        break;
      }
      str = ThemeUtil.b(paramString);
      localObject = localThemeLocator;
    } while (TextUtils.isEmpty(str));
    Object localObject = new TagItemInfo();
    localThemeLocator = new ThemeLocator().a(str);
    if (paramString.startsWith(SCID_THEME_ZIP_PREFIX))
    {
      ((TagItemInfo)localObject).jdField_a_of_type_Boolean = false;
      ((TagItemInfo)localObject).b = false;
      ((TagItemInfo)localObject).jdField_a_of_type_JavaLangString = localThemeLocator.a(MobileQQ.getContext(), paramString, "").c();
      return localObject;
    }
    ((TagItemInfo)localObject).jdField_a_of_type_Boolean = true;
    ((TagItemInfo)localObject).b = false;
    ((TagItemInfo)localObject).jdField_a_of_type_JavaLangString = localThemeLocator.b(MobileQQ.getContext());
    return localObject;
    QLog.e("ThemeUpdateCallback", 1, "getItemInfo ignore ios theme:" + paramString);
    return null;
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    if (!ThemeUtil.a(paramString))
    {
      Object localObject = ThemeUtil.b(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ThemeLocator().a((String)localObject);
        if (paramString.startsWith(SCID_THEME_ZIP_PREFIX)) {}
        for (paramString = ((ThemeLocator)localObject).a(MobileQQ.getContext(), paramString, "").c();; paramString = ((ThemeLocator)localObject).b(MobileQQ.getContext())) {
          return new File(paramString).exists();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback
 * JD-Core Version:    0.7.0.1
 */