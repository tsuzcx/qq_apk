package cooperation.vip.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class VipGeneralGdtShowView$OnPopWindowItemClickListener
  implements AdapterView.OnItemClickListener
{
  private final VipGeneralAdvPopWindow jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow;
  
  public VipGeneralGdtShowView$OnPopWindowItemClickListener(VipGeneralGdtShowView paramVipGeneralGdtShowView, VipGeneralAdvPopWindow paramVipGeneralAdvPopWindow)
  {
    this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow = paramVipGeneralAdvPopWindow;
  }
  
  private void a()
  {
    if (VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView) != null)
    {
      Object localObject;
      if (!TextUtils.isEmpty(VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView).negativeFeedbackUrl))
      {
        localObject = VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView).negativeFeedbackUrl.replace("__ACT_TYPE__", "2001");
        this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView.a((String)localObject);
      }
      if (VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView) != null)
      {
        localObject = this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView;
        ((VipGeneralGdtShowView)localObject).a(3, VipGeneralGdtShowView.a((VipGeneralGdtShowView)localObject).recCookie, VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView) + 1);
      }
    }
    if (this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView.a != null) {
      this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView.a.a();
    }
  }
  
  private void a(VipGeneralAdvPopWindow.MenuData paramMenuData)
  {
    if ((!TextUtils.isEmpty(paramMenuData.c)) && (VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView) != null))
    {
      Intent localIntent = new Intent(VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView), QQBrowserActivity.class);
      localIntent.putExtra("url", paramMenuData.c);
      VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView).startActivity(localIntent);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow;
    if (localObject != null)
    {
      ((VipGeneralAdvPopWindow)localObject).dismiss();
      if ((this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a != null) && (paramInt < this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a.size()))
      {
        localObject = (VipGeneralAdvPopWindow.MenuData)this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a.get(paramInt);
        if (((VipGeneralAdvPopWindow.MenuData)localObject).a == 1) {
          a((VipGeneralAdvPopWindow.MenuData)localObject);
        } else if (((VipGeneralAdvPopWindow.MenuData)localObject).a == 2) {
          a();
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView.OnPopWindowItemClickListener
 * JD-Core Version:    0.7.0.1
 */