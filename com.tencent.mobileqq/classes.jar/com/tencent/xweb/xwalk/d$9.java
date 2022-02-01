package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.v;
import org.xwalk.core.XWalkEnvironment;

class d$9
  implements View.OnClickListener
{
  d$9(d paramd, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    v.a().j(v.a().m() ^ true);
    Object localObject1 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('/') + 1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("(当前为");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    String str = ((StringBuilder)localObject2).toString();
    Button localButton = this.a;
    if (v.a().m())
    {
      localObject1 = new StringBuilder();
      localObject2 = "使用正式版config";
    }
    else
    {
      localObject1 = new StringBuilder();
      localObject2 = "使用测试config";
    }
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(str);
    localButton.setText(((StringBuilder)localObject1).toString());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.9
 * JD-Core Version:    0.7.0.1
 */