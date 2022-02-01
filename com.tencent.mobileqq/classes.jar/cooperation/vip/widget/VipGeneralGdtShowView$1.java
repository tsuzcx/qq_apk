package cooperation.vip.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import cooperation.vip.jsoninflate.model.AlumBasicData.DropData;
import cooperation.vip.webview.controller.VipGeneralPopupWndHelper;
import cooperation.vip.webview.controller.VipGeneralPopupWndHelper.ClickedPoint;
import java.lang.ref.WeakReference;
import java.util.List;

class VipGeneralGdtShowView$1
  implements View.OnClickListener
{
  VipGeneralGdtShowView$1(VipGeneralGdtShowView paramVipGeneralGdtShowView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131367850))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      VipGeneralAdvPopWindow localVipGeneralAdvPopWindow = new VipGeneralAdvPopWindow((Activity)VipGeneralGdtShowView.a(this.a));
      Object localObject = new VipGeneralAdvPopWindow.MenuData();
      VipGeneralAdvPopWindow.MenuData localMenuData = new VipGeneralAdvPopWindow.MenuData();
      int i;
      if ((VipGeneralGdtShowView.a(this.a).jdField_a_of_type_JavaUtilList != null) && (VipGeneralGdtShowView.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < VipGeneralGdtShowView.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new VipGeneralAdvPopWindow.MenuData();
        ((VipGeneralAdvPopWindow.MenuData)localObject).jdField_a_of_type_Int = ((AlumBasicData.DropData)VipGeneralGdtShowView.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((VipGeneralAdvPopWindow.MenuData)localObject).b = ((AlumBasicData.DropData)VipGeneralGdtShowView.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((VipGeneralAdvPopWindow.MenuData)localObject).c = ((AlumBasicData.DropData)VipGeneralGdtShowView.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((VipGeneralAdvPopWindow.MenuData)localObject).jdField_a_of_type_JavaLangString = ((AlumBasicData.DropData)VipGeneralGdtShowView.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localVipGeneralAdvPopWindow.a((VipGeneralAdvPopWindow.MenuData)localObject);
        i += 1;
        continue;
        ((VipGeneralAdvPopWindow.MenuData)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((VipGeneralAdvPopWindow.MenuData)localObject).jdField_a_of_type_Int = 0;
        ((VipGeneralAdvPopWindow.MenuData)localObject).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716584);
        localMenuData.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localMenuData.jdField_a_of_type_Int = 1;
        localMenuData.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716585);
        localMenuData.c = "https://www.qq.com";
        localVipGeneralAdvPopWindow.a((VipGeneralAdvPopWindow.MenuData)localObject);
        localVipGeneralAdvPopWindow.a(localMenuData);
      }
      localVipGeneralAdvPopWindow.e();
      localVipGeneralAdvPopWindow.a(new VipGeneralGdtShowView.1.1(this, localVipGeneralAdvPopWindow));
      localObject = new VipGeneralPopupWndHelper.ClickedPoint(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      VipGeneralPopupWndHelper.a((Activity)VipGeneralGdtShowView.a(this.a), paramView, (VipGeneralPopupWndHelper.ClickedPoint)localObject, localVipGeneralAdvPopWindow);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (VipGeneralGdtShowView.a(this.a) != null)
      {
        this.a.a(2, VipGeneralGdtShowView.a(this.a).jdField_a_of_type_JavaLangString, VipGeneralGdtShowView.a(this.a) + 1);
        this.a.a(new WeakReference((Activity)VipGeneralGdtShowView.a(this.a)), VipGeneralGdtShowView.b(this.a), this.a.a(VipGeneralGdtShowView.c(this.a)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView.1
 * JD-Core Version:    0.7.0.1
 */