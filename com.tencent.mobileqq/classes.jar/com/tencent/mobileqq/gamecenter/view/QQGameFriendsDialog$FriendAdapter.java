package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class QQGameFriendsDialog$FriendAdapter
  extends BaseAdapter
{
  public Context a;
  public List<FeedsItemData.FriendInfo> a;
  
  public void a(List<FeedsItemData.FriendInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (FeedsItemData.FriendInfo)QQGameFriendsDialog.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameFriendsDialog).get(paramInt);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    CornerImageView localCornerImageView = new CornerImageView(this.jdField_a_of_type_AndroidContentContext);
    localCornerImageView.setId(2131367710);
    Object localObject3 = ((FeedsItemData.FriendInfo)localObject2).uin;
    localCornerImageView.setRadius(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) / 2);
    Object localObject1 = QQGameFriendsDialog.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameFriendsDialog).getBitmapFromCache(1, (String)localObject3);
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = ImageUtil.c();
      QQGameFriendsDialog.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameFriendsDialog).requestDecodeFace((String)localObject3, 1, false);
    }
    localCornerImageView.setImageBitmap(paramView);
    paramView = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramView.addRule(9);
    paramView.setMargins(AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, localCornerImageView.getId());
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Object localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject4).setText(((FeedsItemData.FriendInfo)localObject2).name);
    ((TextView)localObject4).setTextSize(16.0F);
    ((TextView)localObject4).setTextColor(-16777216);
    ((TextView)localObject4).setMaxLines(1);
    ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject4).setId(2131372115);
    ((TextView)localObject4).setMaxWidth(AIOUtils.a(110.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout)localObject1).addView((View)localObject4);
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-2145246686);
    if (((FeedsItemData.FriendInfo)localObject2).loginTime < 0L)
    {
      localTextView.setVisibility(4);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, ((TextView)localObject4).getId());
      localLayoutParams.addRule(8, ((TextView)localObject4).getId());
      localLayoutParams.leftMargin = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.bottomMargin = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject1).addView(localTextView, localLayoutParams);
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setTextSize(10.0F);
      localTextView.setTextColor(-6579301);
      if ((!TextUtils.isEmpty(((FeedsItemData.FriendInfo)localObject2).partition)) || (!TextUtils.isEmpty(((FeedsItemData.FriendInfo)localObject2).roleName))) {
        break label856;
      }
      localTextView.setText(HardCodeUtil.a(2131710268));
    }
    for (;;)
    {
      localTextView.setBackgroundColor(1270796256);
      localTextView.setPadding(AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((TextView)localObject4).getId());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject1).addView(localTextView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setText(HardCodeUtil.a(2131710269));
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(16.0F);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setBackgroundDrawable(QQGameConstant.a(new ColorDrawable(-16776961), new ColorDrawable(-16776961), "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png"));
      localObject4 = new RelativeLayout.LayoutParams(AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject4).addRule(11);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15);
      ((RelativeLayout.LayoutParams)localObject4).rightMargin = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localRelativeLayout.addView(localCornerImageView, paramView);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      EventCollector.getInstance().onListGetView(paramInt, localRelativeLayout, paramViewGroup, getItemId(paramInt));
      return localRelativeLayout;
      localTextView.setText(QQGameFriendsDialog.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameFriendsDialog, ((FeedsItemData.FriendInfo)localObject2).loginTime));
      break;
      label856:
      localTextView.setText(((FeedsItemData.FriendInfo)localObject2).partition + " " + ((FeedsItemData.FriendInfo)localObject2).roleName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameFriendsDialog.FriendAdapter
 * JD-Core Version:    0.7.0.1
 */