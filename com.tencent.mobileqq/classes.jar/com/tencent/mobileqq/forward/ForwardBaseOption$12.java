package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.Iterator;
import java.util.List;

class ForwardBaseOption$12
  implements ForwardNewVersionDialog.ForwardWriteTogetherListener
{
  ForwardBaseOption$12(ForwardBaseOption paramForwardBaseOption) {}
  
  public boolean a(View paramView)
  {
    paramView = this.a.t.getBooleanArray("forward_is_write_together");
    for (;;)
    {
      int i;
      try
      {
        Object localObject = this.a.t.getParcelableArrayList("forward_multi_target");
        String str = this.a.t.getString("forward_source_uin");
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
            if ((localResultRecord.getUinType() != 1) || (!str.equals(localResultRecord.uin))) {
              continue;
            }
            i = 0;
            if (i >= paramView.length) {
              continue;
            }
            if (paramView[i] == 0) {
              break label200;
            }
            return true;
          }
        }
        else
        {
          localObject = this.a.t.getString("uin");
          if ((this.a.t.getInt("uintype") == 1) && (((String)localObject).equals(str)))
          {
            i = 0;
            if (i < paramView.length)
            {
              int j = paramView[i];
              if (j != 0) {
                return true;
              }
              i += 1;
              continue;
            }
          }
        }
        return false;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      label200:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.12
 * JD-Core Version:    0.7.0.1
 */