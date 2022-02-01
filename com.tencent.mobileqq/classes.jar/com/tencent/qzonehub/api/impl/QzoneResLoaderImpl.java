package com.tencent.qzonehub.api.impl;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneResLoader;
import mqq.app.MobileQQ;

public class QzoneResLoaderImpl
  implements IQzoneResLoader
{
  public String getString(String paramString)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication == null) {
      return "";
    }
    return localBaseApplication.getString(getStringId(paramString));
  }
  
  public int getStringId(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return -1;
            }
            return 2131711697;
          }
          return 2131711700;
        }
        return 2131706449;
      }
      return 2131706448;
    }
    return 2131689923;
  }
  
  public int getStringId(String paramString)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication == null) {
      return -1;
    }
    return localBaseApplication.getResources().getIdentifier(paramString, "string", localBaseApplication.getPackageName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneResLoaderImpl
 * JD-Core Version:    0.7.0.1
 */