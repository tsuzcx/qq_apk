package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class DeviceFriendListOpenFrame
  extends OpenFrame
  implements View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, ImageLoader.ImageLoadListener, AdapterView.OnItemClickListener
{
  protected static final String a = "com.tencent.open.agent.DeviceFriendListOpenFrame";
  protected PinnedDividerListView b;
  protected DeviceFriendListOpenFrame.FriendListAdapter c;
  protected IndexView d;
  protected EditText e;
  protected RelativeLayout f;
  protected Handler g = new DeviceFriendListOpenFrame.1(this);
  
  public DeviceFriendListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    super.setContentView(2131629255);
    f();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.b.getFirstVisiblePosition() > 0) || ((this.b.getFirstVisiblePosition() == 0) && (this.b.getChildCount() < this.c.getCount() + this.b.getHeaderViewsCount()))) && (!this.j.E))
    {
      this.d.setVisibility(0);
      this.g.sendEmptyMessage(1);
      return;
    }
    this.d.setVisibility(4);
    this.g.sendEmptyMessage(2);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    paramString2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->onImageLoaded() url = ");
    localStringBuilder.append(paramString1);
    LogUtility.c(paramString2, localStringBuilder.toString());
    this.g.post(new DeviceFriendListOpenFrame.2(this, paramString1, paramBitmap));
  }
  
  public void b(Bundle paramBundle)
  {
    LogUtility.c(a, "-->onStart()");
    super.b(paramBundle);
    this.b.setSelection(0);
    this.j.a(true, true, this.j.getString(2131887931), this.j.getString(2131888725), this.j.getString(2131887626));
    if (this.c == null)
    {
      this.c = new DeviceFriendListOpenFrame.FriendListAdapter(this);
      this.b.setAdapter(this.c);
    }
    this.c.c();
  }
  
  protected void f()
  {
    this.b = ((PinnedDividerListView)super.findViewById(2131430527));
    this.d = ((IndexView)super.findViewById(2131435678));
    this.d.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.d.setOnIndexChangedListener(this);
    this.b.setSelector(2131168376);
    this.b.setOnItemClickListener(this);
    this.b.setOnLayoutListener(this);
    this.f = ((RelativeLayout)this.j.getLayoutInflater().inflate(2131629215, this.b, false));
    this.e = ((EditText)this.f.findViewById(2131432634));
    this.e.setOnTouchListener(this);
    ((Button)this.f.findViewById(2131429816)).setVisibility(8);
    this.b.addHeaderView(this.f);
  }
  
  public void g()
  {
    this.c.c();
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.b.setSelection(0);
      return;
    }
    int i = this.c.a(paramString);
    if (i != -1)
    {
      paramString = this.b;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (DeviceFriendListOpenFrame.ViewHolder)paramView.getTag();
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      paramInt -= this.b.getHeaderViewsCount();
      if (paramInt < 0) {
        return;
      }
      paramView = (Friend)this.c.getItem(paramInt);
      if (paramView != null)
      {
        if ((this.j.z != null) && (this.j.z.contains(paramView.a))) {
          return;
        }
        this.j.a(paramView);
        if (this.i.b(paramView.a))
        {
          paramAdapterView.a.setChecked(true);
          return;
        }
        paramAdapterView.a.setChecked(false);
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.j.d();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame
 * JD-Core Version:    0.7.0.1
 */