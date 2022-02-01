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
  private final VipGeneralAdvPopWindow b;
  
  public VipGeneralGdtShowView$OnPopWindowItemClickListener(VipGeneralGdtShowView paramVipGeneralGdtShowView, VipGeneralAdvPopWindow paramVipGeneralAdvPopWindow)
  {
    this.b = paramVipGeneralAdvPopWindow;
  }
  
  private void a()
  {
    if (VipGeneralGdtShowView.b(this.a) != null)
    {
      Object localObject;
      if (!TextUtils.isEmpty(VipGeneralGdtShowView.b(this.a).negativeFeedbackUrl))
      {
        localObject = VipGeneralGdtShowView.b(this.a).negativeFeedbackUrl.replace("__ACT_TYPE__", "2001");
        this.a.a((String)localObject);
      }
      if (VipGeneralGdtShowView.e(this.a) != null)
      {
        localObject = this.a;
        ((VipGeneralGdtShowView)localObject).a(3, VipGeneralGdtShowView.b((VipGeneralGdtShowView)localObject).recCookie, VipGeneralGdtShowView.c(this.a) + 1);
      }
    }
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
  
  private void a(VipGeneralAdvPopWindow.MenuData paramMenuData)
  {
    if ((!TextUtils.isEmpty(paramMenuData.d)) && (VipGeneralGdtShowView.a(this.a) != null))
    {
      Intent localIntent = new Intent(VipGeneralGdtShowView.a(this.a), QQBrowserActivity.class);
      localIntent.putExtra("url", paramMenuData.d);
      VipGeneralGdtShowView.a(this.a).startActivity(localIntent);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((VipGeneralAdvPopWindow)localObject).dismiss();
      if ((this.b.b != null) && (paramInt < this.b.b.size()))
      {
        localObject = (VipGeneralAdvPopWindow.MenuData)this.b.b.get(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView.OnPopWindowItemClickListener
 * JD-Core Version:    0.7.0.1
 */