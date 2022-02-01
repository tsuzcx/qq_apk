package com.tencent.rmonitor.property;

import android.text.TextUtils;
import com.tencent.rmonitor.common.util.AppVersionHelper;

class PropertyMng$AppVersionSetter
  implements IStringPropertySetter
{
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      AppVersionHelper.a.a(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.AppVersionSetter
 * JD-Core Version:    0.7.0.1
 */