package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.XListView;

public class GroupListOpenFrame
  extends OpenFrame
{
  protected XListView a;
  protected RecommendListManager b;
  protected TextView c;
  protected TextView d;
  protected EditText e;
  protected GroupListOpenFrame.GroupListAdapter f;
  
  public GroupListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.b.b();
    LogUtility.c("GroupListOpenFrame", "-->onResume()");
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    LogUtility.c("GroupListOpenFrame", "-->onCreate()");
    super.setContentView(2131629275);
    this.f = new GroupListOpenFrame.GroupListAdapter(this);
    this.a = ((XListView)super.findViewById(2131450345));
    paramBundle = (LinearLayout)super.getActivity().getLayoutInflater().inflate(2131625704, null);
    paramBundle.findViewById(2131429816).setVisibility(8);
    this.c = ((TextView)paramBundle.findViewById(2131447247));
    this.d = ((TextView)paramBundle.findViewById(2131447248));
    this.b = ((RecommendListManager)paramBundle.findViewById(2131446140));
    this.b.setActivity(this.j);
    this.b.a();
    this.a.setSelector(2131168376);
    this.a.addHeaderView(paramBundle);
    this.a.setAdapter(this.f);
    this.e = ((EditText)paramBundle.findViewById(2131432634));
    this.e.setOnTouchListener(new GroupListOpenFrame.1(this));
  }
  
  public void a(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    LogUtility.c("GroupListOpenFrame", "-->onStart()");
    this.j.a(false, true, "", this.j.getString(2131887896));
  }
  
  public void g()
  {
    if (this.i.b() == 0)
    {
      this.c.setVisibility(8);
      this.b.setVisibility(8);
    }
    else
    {
      this.c.setVisibility(0);
      this.b.setVisibility(0);
      this.b.b();
    }
    this.f.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame
 * JD-Core Version:    0.7.0.1
 */