package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import com.tencent.open.base.LogUtility;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class RecommendListManager
  extends LinearLayout
  implements View.OnClickListener, ViewStub.OnInflateListener, ImageLoader.ImageLoadListener
{
  protected FriendDataManager a = FriendDataManager.a();
  protected FriendChooser b;
  protected HashMap<String, View> c = new HashMap();
  protected Handler d;
  
  public RecommendListManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.d = new Handler();
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      ViewStub localViewStub = (ViewStub)super.getChildAt(i);
      localViewStub.setOnInflateListener(this);
      localViewStub.setOnClickListener(this);
      i += 1;
    }
    LogUtility.c("RecommendListManager", "-->onCreate()");
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.d.post(new RecommendListManager.1(this, paramString1, paramBitmap));
  }
  
  public void b()
  {
    int j = this.a.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->notifyDataSetChanged() count = ");
    ((StringBuilder)localObject).append(j);
    LogUtility.c("RecommendListManager", ((StringBuilder)localObject).toString());
    int i = j;
    if (j > 5) {
      i = 5;
    }
    j = 0;
    while (j < i)
    {
      localObject = super.getChildAt(j);
      if ((localObject instanceof ViewStub))
      {
        ((View)localObject).setVisibility(0);
      }
      else
      {
        localObject = (CheckBox)((View)localObject).findViewById(2131430688);
        Friend localFriend = this.a.a(j);
        if (this.a.b(localFriend.a)) {
          ((CheckBox)localObject).setChecked(true);
        } else {
          ((CheckBox)localObject).setChecked(false);
        }
      }
      j += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131444451) {
      i = 0;
    } else if (i == 2131444452) {
      i = 1;
    } else if (i == 2131444453) {
      i = 2;
    } else if (i == 2131444454) {
      i = 3;
    } else if (i == 2131444455) {
      i = 4;
    } else {
      i = -1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->onClick() position = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" v.getId() = ");
    ((StringBuilder)localObject).append(paramView.getId());
    LogUtility.c("RecommendListManager", ((StringBuilder)localObject).toString());
    if ((i != -1) && (i < this.a.b()))
    {
      localObject = (CheckBox)paramView.findViewById(2131430688);
      Friend localFriend = this.a.a(i);
      this.b.a(localFriend);
      if (this.a.b(localFriend.a)) {
        ((CheckBox)localObject).setChecked(true);
      } else {
        ((CheckBox)localObject).setChecked(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    int i = paramView.getId();
    if (i == 2131444451) {
      i = 0;
    } else if (i == 2131444452) {
      i = 1;
    } else if (i == 2131444453) {
      i = 2;
    } else if (i == 2131444454) {
      i = 3;
    } else if (i == 2131444455) {
      i = 4;
    } else {
      i = -1;
    }
    paramViewStub = new StringBuilder();
    paramViewStub.append("-->onInflate() position = ");
    paramViewStub.append(i);
    LogUtility.c("RecommendListManager", paramViewStub.toString());
    paramView.setOnClickListener(this);
    paramViewStub = this.a.a(i);
    if ((paramViewStub.d == null) || ("".equals(paramViewStub.d))) {
      paramViewStub.d = QZonePortraitData.a(this.b.i(), paramViewStub.a);
    }
    this.c.put(paramViewStub.d, paramView);
    Object localObject = (CheckBox)paramView.findViewById(2131430688);
    ImageView localImageView = (ImageView)paramView.findViewById(2131435219);
    paramView = (TextView)paramView.findViewById(2131439121);
    if (this.a.b(paramViewStub.a)) {
      ((CheckBox)localObject).setChecked(true);
    } else {
      ((CheckBox)localObject).setChecked(false);
    }
    localObject = ImageLoader.a().a(paramViewStub.d);
    if (localObject == null)
    {
      localImageView.setImageResource(2130841060);
      ImageLoader.a().a(paramViewStub.d, this);
    }
    else
    {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    if ((paramViewStub.c != null) && (!"".equals(paramViewStub.c)))
    {
      paramView.setText(paramViewStub.c);
      return;
    }
    paramView.setText(paramViewStub.b);
  }
  
  public void setActivity(FriendChooser paramFriendChooser)
  {
    this.b = paramFriendChooser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.RecommendListManager
 * JD-Core Version:    0.7.0.1
 */