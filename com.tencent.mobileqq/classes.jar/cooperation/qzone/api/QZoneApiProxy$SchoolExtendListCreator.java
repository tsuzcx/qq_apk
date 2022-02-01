package cooperation.qzone.api;

import adxq;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class QZoneApiProxy$SchoolExtendListCreator
  implements adxq
{
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView".equals(paramString)) {
      return null;
    }
    return QZoneApiProxy.createSchoolExtendList(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.api.QZoneApiProxy.SchoolExtendListCreator
 * JD-Core Version:    0.7.0.1
 */