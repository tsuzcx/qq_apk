package com.tencent.rmonitor.property;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.common.util.AsyncSPEditor;

class PropertyMng$UserIdSetter
  implements IStringPropertySetter
{
  public boolean a(String paramString)
  {
    if ((BaseInfo.sharePreference != null) && ("10000".equals(BaseInfo.userMeta.uin)))
    {
      BaseInfo.userMeta.uin = BaseInfo.sharePreference.getString("config_uin", "10000");
      if (TextUtils.isEmpty(BaseInfo.userMeta.uin)) {
        BaseInfo.userMeta.uin = "10000";
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, BaseInfo.userMeta.uin)))
    {
      BaseInfo.userMeta.uin = paramString;
      BaseInfo.editor.a("config_uin", paramString).b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.UserIdSetter
 * JD-Core Version:    0.7.0.1
 */