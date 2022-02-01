package com.tencent.qzonehub.api.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity.IViewCreator;

class QZoneApiProxyImpl$SchoolExtendListCreator
  implements PublicFragmentActivity.IViewCreator
{
  public View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView".equals(paramString)) {
      return null;
    }
    return QZoneApiProxyImpl.createSchoolExtendList(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneApiProxyImpl.SchoolExtendListCreator
 * JD-Core Version:    0.7.0.1
 */