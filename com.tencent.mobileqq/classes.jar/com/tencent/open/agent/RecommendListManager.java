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
import bddv;
import bddz;
import bdeb;
import bdec;
import bdht;
import com.tencent.open.agent.datamodel.Friend;
import java.util.HashMap;

public class RecommendListManager
  extends LinearLayout
  implements View.OnClickListener, ViewStub.OnInflateListener, bdeb
{
  protected Handler a;
  protected bddv a;
  protected FriendChooser a;
  protected HashMap<String, View> a;
  
  public RecommendListManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bddv = bddv.a();
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
    bdht.c("RecommendListManager", "-->onCreate()");
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RecommendListManager.1(this, paramString1, paramBitmap));
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_Bddv.a();
    bdht.c("RecommendListManager", "-->notifyDataSetChanged() count = " + j);
    int i = j;
    if (j > 5) {
      i = 5;
    }
    j = 0;
    if (j < i)
    {
      Object localObject = super.getChildAt(j);
      if ((localObject instanceof ViewStub)) {
        ((View)localObject).setVisibility(0);
      }
      for (;;)
      {
        j += 1;
        break;
        localObject = (CheckBox)((View)localObject).findViewById(2131364193);
        Friend localFriend = this.jdField_a_of_type_Bddv.a(j);
        if (this.jdField_a_of_type_Bddv.a(localFriend.a)) {
          ((CheckBox)localObject).setChecked(true);
        } else {
          ((CheckBox)localObject).setChecked(false);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      bdht.c("RecommendListManager", "-->onClick() position = " + i + " v.getId() = " + paramView.getId());
      if ((i != -1) && (i < this.jdField_a_of_type_Bddv.a()))
      {
        paramView = (CheckBox)paramView.findViewById(2131364193);
        Friend localFriend = this.jdField_a_of_type_Bddv.a(i);
        this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(localFriend);
        if (!this.jdField_a_of_type_Bddv.a(localFriend.a)) {
          break;
        }
        paramView.setChecked(true);
      }
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
    paramView.setChecked(false);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    int i = -1;
    Object localObject;
    ImageView localImageView;
    switch (paramView.getId())
    {
    default: 
      bdht.c("RecommendListManager", "-->onInflate() position = " + i);
      paramView.setOnClickListener(this);
      paramViewStub = this.jdField_a_of_type_Bddv.a(i);
      if ((paramViewStub.d == null) || ("".equals(paramViewStub.d))) {
        paramViewStub.d = bdec.a(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), paramViewStub.a);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramViewStub.d, paramView);
      localObject = (CheckBox)paramView.findViewById(2131364193);
      localImageView = (ImageView)paramView.findViewById(2131367679);
      paramView = (TextView)paramView.findViewById(2131370647);
      if (this.jdField_a_of_type_Bddv.a(paramViewStub.a))
      {
        ((CheckBox)localObject).setChecked(true);
        label180:
        localObject = bddz.a().a(paramViewStub.d);
        if (localObject != null) {
          break label277;
        }
        localImageView.setImageResource(2130839736);
        bddz.a().a(paramViewStub.d, this);
      }
      break;
    }
    for (;;)
    {
      if ((paramViewStub.c != null) && (!"".equals(paramViewStub.c))) {
        break label287;
      }
      paramView.setText(paramViewStub.b);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      ((CheckBox)localObject).setChecked(false);
      break label180;
      label277:
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    label287:
    paramView.setText(paramViewStub.c);
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