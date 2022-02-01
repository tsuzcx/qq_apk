package com.tencent.util;

import android.os.Bundle;

public class QQCustomArkDialogUtil
{
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("appName", paramString1);
    localBundle.putString("appMinVersion", paramString3);
    localBundle.putString("appView", paramString2);
    localBundle.putString("metaData", paramString4);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.QQCustomArkDialogUtil
 * JD-Core Version:    0.7.0.1
 */