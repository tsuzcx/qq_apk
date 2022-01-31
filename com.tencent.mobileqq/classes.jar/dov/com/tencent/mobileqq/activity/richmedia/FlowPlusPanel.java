package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;

public class FlowPlusPanel
  extends FlowPanel
  implements PanelIconLinearLayout.PanelIconCallback
{
  int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  
  public FlowPlusPanel(FlowActivity paramFlowActivity)
  {
    super(paramFlowActivity);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    PanelIconLinearLayout localPanelIconLinearLayout = new PanelIconLinearLayout(paramViewGroup.getContext(), null);
    localPanelIconLinearLayout.setPanelIconListener(this);
    int i = (int)(40.0F * paramViewGroup.getResources().getDisplayMetrics().density + 0.5F);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131362825);
    paramViewGroup.addView(localPanelIconLinearLayout, (ViewGroup.LayoutParams)localObject);
    localPanelIconLinearLayout.setCustomHeight(i);
    paramViewGroup = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowActivity.getIntent().getExtras();
    if ((paramViewGroup != null) && (paramViewGroup.containsKey("selected_item")))
    {
      this.jdField_a_of_type_Int = paramViewGroup.getInt("selected_item");
      if (paramViewGroup.containsKey("selected_data"))
      {
        localObject = (ArrayList)paramViewGroup.getSerializable("selected_data");
        localPanelIconLinearLayout.a.clear();
        localPanelIconLinearLayout.a.addAll((Collection)localObject);
      }
      localPanelIconLinearLayout.a();
      localPanelIconLinearLayout.setSelected(this.jdField_a_of_type_Int);
      if (paramViewGroup.containsKey("flow_key_need_poke_red")) {
        localPanelIconLinearLayout.setShowRed(23, paramViewGroup.getBoolean("flow_key_need_poke_red"));
      }
      this.jdField_a_of_type_AndroidViewView = localPanelIconLinearLayout;
      return;
    }
    throw new RuntimeException("No pass args SELECTED_ITEM");
  }
  
  public void a(Object paramObject)
  {
    Intent localIntent = ((FlowActivity)a()).getIntent();
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int i = ((Integer)paramObject).intValue();
    QLog.d("XPanel", 2, " FlowPlusPanel  onPanelIconClick  i==" + i + "panelType===" + this.jdField_a_of_type_Int);
    localIntent.putExtra("click_item", i);
    ((FlowActivity)a()).setResult(1000, localIntent);
    ((FlowActivity)a()).finish();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.FlowPlusPanel
 * JD-Core Version:    0.7.0.1
 */