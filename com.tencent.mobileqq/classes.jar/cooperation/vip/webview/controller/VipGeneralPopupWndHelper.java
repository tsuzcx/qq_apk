package cooperation.vip.webview.controller;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.vip.widget.VipGeneralAdvPopWindow;

public class VipGeneralPopupWndHelper
{
  public static void a(Activity paramActivity, View paramView, VipGeneralPopupWndHelper.ClickedPoint paramClickedPoint, VipGeneralAdvPopWindow paramVipGeneralAdvPopWindow)
  {
    if ((paramActivity != null) && (paramView != null) && (paramClickedPoint != null))
    {
      if (paramVipGeneralAdvPopWindow == null) {
        return;
      }
      if (paramVipGeneralAdvPopWindow.isShowing()) {
        return;
      }
      paramActivity = new int[2];
      paramView.getLocationOnScreen(paramActivity);
      int i = paramActivity[0] + paramClickedPoint.a() + paramClickedPoint.c() / 2;
      int j = paramActivity[1] + paramClickedPoint.b() + paramClickedPoint.d() / 2;
      int k = ViewUtils.getScreenHeight();
      int m = paramVipGeneralAdvPopWindow.h();
      int n = paramClickedPoint.c() / 4;
      int i1 = paramClickedPoint.c() / 4;
      int i2 = paramVipGeneralAdvPopWindow.i();
      if (k - j - n >= m)
      {
        if (paramVipGeneralAdvPopWindow.a(i, j + paramClickedPoint.c() / 4)) {
          paramVipGeneralAdvPopWindow.c();
        }
      }
      else if ((j - i1 - i2 >= m) && (paramVipGeneralAdvPopWindow.a(i, j - m - paramClickedPoint.c() / 4))) {
        paramVipGeneralAdvPopWindow.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.webview.controller.VipGeneralPopupWndHelper
 * JD-Core Version:    0.7.0.1
 */