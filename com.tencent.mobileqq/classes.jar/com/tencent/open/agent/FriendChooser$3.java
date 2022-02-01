package com.tencent.open.agent;

import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

class FriendChooser$3
  implements AdapterView.OnItemClickListener
{
  FriendChooser$3(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramAdapterView != null)
    {
      if (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a)) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() >= this.a.jdField_a_of_type_Int)
      {
        this.a.h();
        return;
      }
      paramView = (OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
      this.a.b.add(paramAdapterView);
      this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a);
      this.a.e();
      paramView.g();
      this.a.b(false);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.3
 * JD-Core Version:    0.7.0.1
 */