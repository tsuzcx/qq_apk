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
    paramAdapterView = (Friend)this.a.A.get(paramInt);
    if (paramAdapterView != null)
    {
      if (this.a.C.b(paramAdapterView.a)) {
        return;
      }
      if (this.a.C.d() >= this.a.K)
      {
        this.a.j();
        return;
      }
      paramView = (OpenFrame)this.a.h.getCurrentView();
      this.a.B.add(paramAdapterView);
      this.a.C.c(paramAdapterView.a);
      this.a.f();
      paramView.g();
      this.a.b(false);
      this.a.p.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.3
 * JD-Core Version:    0.7.0.1
 */