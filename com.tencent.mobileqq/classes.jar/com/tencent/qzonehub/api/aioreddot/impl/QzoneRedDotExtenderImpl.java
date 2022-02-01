package com.tencent.qzonehub.api.aioreddot.impl;

import android.content.Context;
import com.tencent.qzonehub.api.aioreddot.IQzoneRedDotExtender;
import cooperation.qzone.aioreddot.QzoneRedDotExtender;

public class QzoneRedDotExtenderImpl
  implements IQzoneRedDotExtender
{
  public Object getQzoneRedDotExtender(Context paramContext)
  {
    return new QzoneRedDotExtender(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.aioreddot.impl.QzoneRedDotExtenderImpl
 * JD-Core Version:    0.7.0.1
 */