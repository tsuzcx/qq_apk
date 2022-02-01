package com.tencent.mobileqq.intervideo.impl;

import android.content.Context;
import com.tencent.mobileqq.intervideo.CdnPmUpdater;
import com.tencent.mobileqq.intervideo.ICdnPmUpdater;
import com.tencent.mobileqq.intervideo.ICdnPmUpdaterFactory;

public class CdnPmUpdaterFactoryImpl
  implements ICdnPmUpdaterFactory
{
  public ICdnPmUpdater createCdnPmUpdater(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return new CdnPmUpdater(paramContext, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.impl.CdnPmUpdaterFactoryImpl
 * JD-Core Version:    0.7.0.1
 */