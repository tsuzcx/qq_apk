package com.tencent.shadow.core.runtime;

import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

public class ShadowPackageItemInfo
{
  public static XmlResourceParser loadXmlMetaData(ClassLoader paramClassLoader, PackageItemInfo paramPackageItemInfo, PackageManager paramPackageManager, String paramString)
  {
    paramClassLoader = PluginPartInfoManager.getPluginInfo(paramClassLoader).application.getResources();
    if (paramPackageItemInfo.metaData != null)
    {
      int i = paramPackageItemInfo.metaData.getInt(paramString);
      if (i != 0) {
        return paramClassLoader.getXml(i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.ShadowPackageItemInfo
 * JD-Core Version:    0.7.0.1
 */