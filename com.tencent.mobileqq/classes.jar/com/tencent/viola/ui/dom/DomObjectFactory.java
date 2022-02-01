package com.tencent.viola.ui.dom;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.viola.core.ViolaDomObjectManager;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.reflect.Constructor;

public class DomObjectFactory
{
  public static String TAG = "DomObjectFactory";
  
  @Nullable
  public static DomObject newInstance(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = ViolaDomObjectManager.getDomObjClz(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      if (DomObject.class.isAssignableFrom((Class)localObject))
      {
        localObject = (DomObject)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DomObjectFactory Exception type:[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] message:");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e(str, localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectFactory
 * JD-Core Version:    0.7.0.1
 */