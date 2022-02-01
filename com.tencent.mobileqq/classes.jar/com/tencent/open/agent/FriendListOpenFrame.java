package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

public class FriendListOpenFrame
  extends OpenFrame
  implements View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, ImageLoader.ImageLoadListener, AdapterView.OnItemClickListener
{
  protected PinnedDividerListView a;
  protected FriendListOpenFrame.FriendListAdapter b;
  protected IndexView c;
  protected EditText d;
  protected RelativeLayout e;
  protected int f;
  protected String g;
  protected Handler h = new FriendListOpenFrame.1(this);
  
  public FriendListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    super.setContentView(2131629255);
    this.a = ((PinnedDividerListView)super.findViewById(2131430527));
    this.c = ((IndexView)super.findViewById(2131435678));
    this.c.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.c.setOnIndexChangedListener(this);
    this.a.setSelector(2131168376);
    this.a.setOnItemClickListener(this);
    this.a.setOnLayoutListener(this);
    this.e = ((RelativeLayout)this.j.getLayoutInflater().inflate(2131629215, this.a, false));
    this.d = ((EditText)this.e.findViewById(2131432634));
    this.d.setOnTouchListener(this);
    ((Button)this.e.findViewById(2131429816)).setVisibility(8);
    this.a.addHeaderView(this.e);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.a.getFirstVisiblePosition() > 0) || ((this.a.getFirstVisiblePosition() == 0) && (this.a.getChildCount() < this.b.getCount() + this.a.getHeaderViewsCount()))) && (!this.j.E))
    {
      this.c.setVisibility(0);
      this.h.sendEmptyMessage(1);
      return;
    }
    this.c.setVisibility(4);
    this.h.sendEmptyMessage(2);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("-->onImageLoaded() url = ");
    paramString2.append(paramString1);
    LogUtility.c("FriendListOpenFrame", paramString2.toString());
    paramString2 = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString1);
    paramString2.obj = paramBitmap;
    paramString2.what = 3;
    paramString2.setData(localBundle);
    this.h.sendMessage(paramString2);
  }
  
  public void b(Bundle paramBundle)
  {
    LogUtility.c("FriendListOpenFrame", "-->onStart()");
    super.b(paramBundle);
    this.a.setSelection(0);
    this.f = paramBundle.getInt("group_index");
    this.g = paramBundle.getString("group_name");
    this.j.a(true, false, this.j.getString(2131916220), this.g);
    paramBundle = this.b;
    if (paramBundle == null)
    {
      this.b = new FriendListOpenFrame.FriendListAdapter(this);
      this.a.setAdapter(this.b);
      return;
    }
    paramBundle.c();
  }
  
  public void g()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.a.setSelection(0);
      return;
    }
    int i = this.b.a(paramString);
    if (i != -1)
    {
      paramString = this.a;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FriendListOpenFrame.ViewHolder)paramView.getTag();
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      paramInt -= this.a.getHeaderViewsCount();
      if (paramInt < 0) {
        return;
      }
      paramView = (Friend)this.b.getItem(paramInt);
      if (paramView != null)
      {
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
 * Qualified Name:     com.tencent.open.agent.FriendListOpenFrame
 * JD-Core Version:    0.7.0.1
 */