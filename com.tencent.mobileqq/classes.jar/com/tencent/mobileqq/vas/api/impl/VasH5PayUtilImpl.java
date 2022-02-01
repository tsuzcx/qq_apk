package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;

public class VasH5PayUtilImpl
  implements IVasH5PayUtil
{
  public void openH5Page(String paramString1, String paramString2, Context paramContext)
  {
    QVipUtils.a(paramString1, paramString2, paramContext);
  }
  
  public void openH5PayByURL(Context paramContext, String paramString)
  {
    VasH5PayUtil.a(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasH5PayUtilImpl
 * JD-Core Version:    0.7.0.1
 */