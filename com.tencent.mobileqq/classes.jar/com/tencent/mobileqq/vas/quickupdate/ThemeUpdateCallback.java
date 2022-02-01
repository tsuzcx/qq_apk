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
    if ((!paramString.startsWith("theme.android")) && (!paramString.endsWith(".cfg"))) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasUpdate getItemInfo checkNewVersionValid filter scid = ");
    localStringBuilder.append(paramString);
    QLog.e("ThemeUpdateCallback", 1, localStringBuilder.toString());
    return true;
  }
  
  private void onThemeComplete(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).onThemeComplete(paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    Object localObject;
    if (!ThemeUtil.isIOSTheme(paramString))
    {
      localObject = ThemeUtil.getIDFromSCID(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ThemeLocator().a((String)localObject);
        if (paramString.startsWith(SCID_THEME_ZIP_PREFIX)) {
          paramString = ((ThemeLocator)localObject).a(MobileQQ.getContext(), paramString, "").c();
        } else {
          paramString = ((ThemeLocator)localObject).b(MobileQQ.getContext());
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteFiles: ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("ThemeUpdateCallback", 2, ((StringBuilder)localObject).toString());
        }
        return new File(paramString).delete();
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteFiles ignore ios theme:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("ThemeUpdateCallback", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (!ThemeUtil.isIOSTheme(paramString1))
    {
      onThemeComplete(paramString1, paramString2, paramString3, paramInt1, paramInt2);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("onCompleted ignore ios theme:");
    paramString2.append(paramString1);
    QLog.e("ThemeUpdateCallback", 1, paramString2.toString());
  }
  
  public void doOnProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (!ThemeUtil.isIOSTheme(paramString1)) {
      ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).onThemeProgress(paramString1, paramLong2, paramLong3);
    }
  }
  
  public long getBID()
  {
    return 3L;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    Object localObject1;
    if ("theme_mapping_config_android".equals(paramString))
    {
      localObject1 = new TagItemInfo();
      ((TagItemInfo)localObject1).jdField_a_of_type_Boolean = false;
      ((TagItemInfo)localObject1).b = false;
      ((TagItemInfo)localObject1).jdField_a_of_type_JavaLangString = getSavePath(MobileQQ.getContext(), paramString);
      return localObject1;
    }
    if (checkNewVersionValid(paramString)) {
      return null;
    }
    if (!ThemeUtil.isIOSTheme(paramString))
    {
      Object localObject2 = ThemeUtil.getIDFromSCID(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new TagItemInfo();
        localObject2 = new ThemeLocator().a((String)localObject2);
        if (paramString.startsWith(SCID_THEME_ZIP_PREFIX))
        {
          ((TagItemInfo)localObject1).jdField_a_of_type_Boolean = false;
          ((TagItemInfo)localObject1).b = false;
          ((TagItemInfo)localObject1).jdField_a_of_type_JavaLangString = ((ThemeLocator)localObject2).a(MobileQQ.getContext(), paramString, "").c();
          return localObject1;
        }
        ((TagItemInfo)localObject1).jdField_a_of_type_Boolean = true;
        ((TagItemInfo)localObject1).b = false;
        ((TagItemInfo)localObject1).jdField_a_of_type_JavaLangString = ((ThemeLocator)localObject2).b(MobileQQ.getContext());
        return localObject1;
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getItemInfo ignore ios theme:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("ThemeUpdateCallback", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    if (!ThemeUtil.isIOSTheme(paramString))
    {
      Object localObject = ThemeUtil.getIDFromSCID(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ThemeLocator().a((String)localObject);
        if (paramString.startsWith(SCID_THEME_ZIP_PREFIX)) {
          paramString = ((ThemeLocator)localObject).a(MobileQQ.getContext(), paramString, "").c();
        } else {
          paramString = ((ThemeLocator)localObject).b(MobileQQ.getContext());
        }
        return new File(paramString).exists();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback
 * JD-Core Version:    0.7.0.1
 */