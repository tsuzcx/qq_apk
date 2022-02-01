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
  protected Handler a;
  protected FriendChooser a;
  protected FriendDataManager a;
  protected HashMap<String, View> a;
  
  public RecommendListManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager = FriendDataManager.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
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
    this.jdField_a_of_type_AndroidOsHandler.post(new RecommendListManager.1(this, paramString1, paramBitmap));
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a();
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
        localObject = (CheckBox)((View)localObject).findViewById(2131364613);
        Friend localFriend = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(j);
        if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(localFriend.a)) {
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
    if (i == 2131376243) {
      i = 0;
    } else if (i == 2131376244) {
      i = 1;
    } else if (i == 2131376245) {
      i = 2;
    } else if (i == 2131376246) {
      i = 3;
    } else if (i == 2131376247) {
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
    if ((i != -1) && (i < this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a()))
    {
      localObject = (CheckBox)paramView.findViewById(2131364613);
      Friend localFriend = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(i);
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(localFriend);
      if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(localFriend.a)) {
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
    if (i == 2131376243) {
      i = 0;
    } else if (i == 2131376244) {
      i = 1;
    } else if (i == 2131376245) {
      i = 2;
    } else if (i == 2131376246) {
      i = 3;
    } else if (i == 2131376247) {
      i = 4;
    } else {
      i = -1;
    }
    paramViewStub = new StringBuilder();
    paramViewStub.append("-->onInflate() position = ");
    paramViewStub.append(i);
    LogUtility.c("RecommendListManager", paramViewStub.toString());
    paramView.setOnClickListener(this);
    paramViewStub = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(i);
    if ((paramViewStub.d == null) || ("".equals(paramViewStub.d))) {
      paramViewStub.d = QZonePortraitData.a(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), paramViewStub.a);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramViewStub.d, paramView);
    Object localObject = (CheckBox)paramView.findViewById(2131364613);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368343);
    paramView = (TextView)paramView.findViewById(2131371697);
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramViewStub.a)) {
      ((CheckBox)localObject).setChecked(true);
    } else {
      ((CheckBox)localObject).setChecked(false);
    }
    localObject = ImageLoader.a().a(paramViewStub.d);
    if (localObject == null)
    {
      localImageView.setImageResource(2130840321);
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
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser = paramFriendChooser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.RecommendListManager
 * JD-Core Version:    0.7.0.1
 */