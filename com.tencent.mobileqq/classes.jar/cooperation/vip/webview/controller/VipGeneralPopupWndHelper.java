package cooperation.vip.webview.controller;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.vip.widget.VipGeneralAdvPopWindow;

public class VipGeneralPopupWndHelper
{
  public static void a(Activity paramActivity, View paramView, VipGeneralPopupWndHelper.ClickedPoint paramClickedPoint, VipGeneralAdvPopWindow paramVipGeneralAdvPopWindow)
  {
    if ((paramActivity == null) || (paramView == null) || (paramClickedPoint == null) || (paramVipGeneralAdvPopWindow == null)) {}
    int i;
    int j;
    int m;
    int i1;
    int i2;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramVipGeneralAdvPopWindow.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + paramClickedPoint.a() + paramClickedPoint.c() / 2;
        j = paramActivity[1] + paramClickedPoint.b() + paramClickedPoint.d() / 2;
        int k = ViewUtils.b();
        m = paramVipGeneralAdvPopWindow.a();
        int n = paramClickedPoint.c() / 4;
        i1 = paramClickedPoint.c() / 4;
        i2 = paramVipGeneralAdvPopWindow.b();
        if (k - j - n < m) {
          break;
        }
      } while (!paramVipGeneralAdvPopWindow.a(i, j + paramClickedPoint.c() / 4));
      paramVipGeneralAdvPopWindow.b();
      return;
    } while ((j - i1 - i2 < m) || (!paramVipGeneralAdvPopWindow.a(i, j - m - paramClickedPoint.c() / 4)));
    paramVipGeneralAdvPopWindow.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.webview.controller.VipGeneralPopupWndHelper
 * JD-Core Version:    0.7.0.1
 */