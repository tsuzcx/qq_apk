package cooperation.vip.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData.DropData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
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
    Object localObject1;
    if ((paramView != null) && (paramView.getId() == 2131367617))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      localObject1 = new VipGeneralAdvPopWindow((Activity)VipGeneralGdtShowView.a(this.a));
      Object localObject2 = new VipGeneralAdvPopWindow.MenuData();
      VipGeneralAdvPopWindow.MenuData localMenuData = new VipGeneralAdvPopWindow.MenuData();
      List localList = VipGeneralGdtShowView.a(this.a).dropList;
      int i = 0;
      if ((localList != null) && (VipGeneralGdtShowView.a(this.a).dropList.size() != 0)) {}
      while (i < VipGeneralGdtShowView.a(this.a).dropList.size())
      {
        localObject2 = new VipGeneralAdvPopWindow.MenuData();
        ((VipGeneralAdvPopWindow.MenuData)localObject2).jdField_a_of_type_Int = ((AlumBasicData.DropData)VipGeneralGdtShowView.a(this.a).dropList.get(i)).actionType;
        ((VipGeneralAdvPopWindow.MenuData)localObject2).b = ((AlumBasicData.DropData)VipGeneralGdtShowView.a(this.a).dropList.get(i)).logoUrl;
        ((VipGeneralAdvPopWindow.MenuData)localObject2).c = ((AlumBasicData.DropData)VipGeneralGdtShowView.a(this.a).dropList.get(i)).jumpUrl;
        ((VipGeneralAdvPopWindow.MenuData)localObject2).jdField_a_of_type_JavaLangString = ((AlumBasicData.DropData)VipGeneralGdtShowView.a(this.a).dropList.get(i)).content;
        ((VipGeneralAdvPopWindow)localObject1).a((VipGeneralAdvPopWindow.MenuData)localObject2);
        i += 1;
        continue;
        ((VipGeneralAdvPopWindow.MenuData)localObject2).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((VipGeneralAdvPopWindow.MenuData)localObject2).jdField_a_of_type_Int = 0;
        ((VipGeneralAdvPopWindow.MenuData)localObject2).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716241);
        localMenuData.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localMenuData.jdField_a_of_type_Int = 1;
        localMenuData.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716242);
        localMenuData.c = "https://www.qq.com";
        ((VipGeneralAdvPopWindow)localObject1).a((VipGeneralAdvPopWindow.MenuData)localObject2);
        ((VipGeneralAdvPopWindow)localObject1).a(localMenuData);
      }
      ((VipGeneralAdvPopWindow)localObject1).e();
      ((VipGeneralAdvPopWindow)localObject1).a(new VipGeneralGdtShowView.OnPopWindowItemClickListener(this.a, (VipGeneralAdvPopWindow)localObject1));
      localObject2 = new VipGeneralPopupWndHelper.ClickedPoint(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      VipGeneralPopupWndHelper.a((Activity)VipGeneralGdtShowView.a(this.a), paramView, (VipGeneralPopupWndHelper.ClickedPoint)localObject2, (VipGeneralAdvPopWindow)localObject1);
    }
    else if (VipGeneralGdtShowView.a(this.a) != null)
    {
      localObject1 = this.a;
      ((VipGeneralGdtShowView)localObject1).a(2, VipGeneralGdtShowView.a((VipGeneralGdtShowView)localObject1).recCookie, VipGeneralGdtShowView.a(this.a) + 1);
      localObject1 = this.a;
      ((VipGeneralGdtShowView)localObject1).a(new WeakReference((Activity)VipGeneralGdtShowView.a((VipGeneralGdtShowView)localObject1)), VipGeneralGdtShowView.b(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView.1
 * JD-Core Version:    0.7.0.1
 */