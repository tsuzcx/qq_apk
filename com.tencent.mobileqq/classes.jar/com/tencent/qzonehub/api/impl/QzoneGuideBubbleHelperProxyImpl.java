package com.tencent.qzonehub.api.impl;

import android.view.View;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.qzonehub.api.IQzoneGuideBubbleHelperProxy;

public class QzoneGuideBubbleHelperProxyImpl
  implements IQzoneGuideBubbleHelperProxy
{
  public void setX(View paramView, float paramFloat)
  {
    ViewHelper.g(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneGuideBubbleHelperProxyImpl
 * JD-Core Version:    0.7.0.1
 */