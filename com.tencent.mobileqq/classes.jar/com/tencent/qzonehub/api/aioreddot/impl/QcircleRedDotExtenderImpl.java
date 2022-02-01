package com.tencent.qzonehub.api.aioreddot.impl;

import android.content.Context;
import com.tencent.qzonehub.api.aioreddot.IQcircleRedDotExtender;
import cooperation.qzone.aioreddot.QcircleRedDotExtender;

public class QcircleRedDotExtenderImpl
  implements IQcircleRedDotExtender
{
  public Object getQcircleRedDotExtender(Context paramContext)
  {
    return new QcircleRedDotExtender(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.aioreddot.impl.QcircleRedDotExtenderImpl
 * JD-Core Version:    0.7.0.1
 */