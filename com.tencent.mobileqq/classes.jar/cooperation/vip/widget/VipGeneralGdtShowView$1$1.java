package cooperation.vip.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;

class VipGeneralGdtShowView$1$1
  implements AdapterView.OnItemClickListener
{
  VipGeneralGdtShowView$1$1(VipGeneralGdtShowView.1 param1, VipGeneralAdvPopWindow paramVipGeneralAdvPopWindow) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow != null)
    {
      this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.dismiss();
      if ((this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a != null) && (paramInt < this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a.size()))
      {
        localObject = (VipGeneralAdvPopWindow.MenuData)this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a.get(paramInt);
        if (((VipGeneralAdvPopWindow.MenuData)localObject).a != 1) {
          break label148;
        }
        if ((!TextUtils.isEmpty(((VipGeneralAdvPopWindow.MenuData)localObject).c)) && (VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a) != null))
        {
          Intent localIntent = new Intent(VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a), QQBrowserActivity.class);
          localIntent.putExtra("url", ((VipGeneralAdvPopWindow.MenuData)localObject).c);
          VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a).startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label148:
      if (((VipGeneralAdvPopWindow.MenuData)localObject).a == 2)
      {
        if (VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a) != null)
        {
          if (!TextUtils.isEmpty(VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a).f))
          {
            localObject = VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a).f.replace("__ACT_TYPE__", "2001");
            this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a.a((String)localObject);
          }
          if (VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a) != null) {
            this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a.a(3, VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a).a, VipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a) + 1);
          }
        }
        if (this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a.a != null) {
          this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$1.a.a.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView.1.1
 * JD-Core Version:    0.7.0.1
 */