package com.tencent.mobileqq.selectmember;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TroopMemberListInnerFrame$TroopMemberListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public TroopMemberListInnerFrame$TroopMemberListAdapter(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
  {
    super(paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
  }
  
  public int a()
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559309;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      int i = 0;
      while (i < this.a.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (this.a.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {
          break label52;
        }
        i += 1;
      }
      i = -1;
      label52:
      if (i >= 0) {
        return this.a.jdField_a_of_type_ArrayOfInt[i];
      }
    }
    return -1;
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int b()
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((List)this.a.jdField_a_of_type_JavaUtilMap.get(localIterator.next())).size();
    }
    return i;
  }
  
  public int getCount()
  {
    int[] arrayOfInt = this.a.jdField_a_of_type_ArrayOfInt;
    int i = 0;
    if (arrayOfInt != null)
    {
      if (this.a.jdField_a_of_type_JavaUtilMap == null) {
        return 0;
      }
      if (this.a.jdField_a_of_type_ArrayOfInt.length == 0) {
        return 0;
      }
      i = this.a.jdField_a_of_type_ArrayOfInt[(this.a.jdField_a_of_type_ArrayOfInt.length - 1)] + ((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[(this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562820, paramViewGroup, false);
      paramView = new TroopMemberListInnerFrame.ViewHolder(this.a, null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376702));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379732));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364613));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368343));
      paramView.d = ((TextView)localView.findViewById(2131371697));
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131379859);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379793));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131379905));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379798));
    }
    else
    {
      localView = paramView;
    }
    TroopMemberListInnerFrame.ViewHolder localViewHolder = (TroopMemberListInnerFrame.ViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
      if (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(localTroopMemberInfo.memberuin)) {
        localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localTroopMemberInfo.memberuin));
      String str = CommonUtils.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin);
      if (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 21)
      {
        if ((TroopMemberListInnerFrame.a(this.a) != null) && (TroopMemberListInnerFrame.a(this.a).isTroopOwner(localTroopMemberInfo.memberuin)) && (this.a.jdField_c_of_type_AndroidWidgetTextView != null) && (this.a.jdField_c_of_type_AndroidWidgetTextView.getTag() != null))
        {
          paramView = new StringBuilder();
          paramView.append("[tag]");
          paramView.append(" ");
          paramView.append(str);
          paramView = new SpannableString(paramView.toString());
          paramView.setSpan(new ImageSpan(this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, (Bitmap)this.a.jdField_c_of_type_AndroidWidgetTextView.getTag()), 0, 5, 18);
        }
        else if ((this.a.jdField_b_of_type_AndroidWidgetTextView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView.getTag() != null))
        {
          paramView = new StringBuilder();
          paramView.append("[tag]");
          paramView.append(" ");
          paramView.append(str);
          paramView = new SpannableString(paramView.toString());
          paramView.setSpan(new ImageSpan(this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, (Bitmap)this.a.jdField_b_of_type_AndroidWidgetTextView.getTag()), 0, 5, 18);
        }
        else
        {
          paramView = null;
        }
        localViewHolder.d.setText(paramView);
      }
      else
      {
        localViewHolder.d.setText(CommonUtils.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin));
      }
      localViewHolder.jdField_a_of_type_JavaLangString = localTroopMemberInfo.memberuin;
      if (localViewHolder.jdField_b_of_type_AndroidViewView != null) {
        if (CommonUtils.b(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, localTroopMemberInfo.memberuin)) {
          localViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        } else {
          localViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault.contains(localTroopMemberInfo.memberuin))) {
        localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      } else {
        localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      }
      if ((AppSetting.d) && (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
        {
          paramView = new StringBuilder();
          paramView.append(str);
          paramView.append(HardCodeUtil.a(2131715326));
          localView.setContentDescription(paramView.toString());
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append(str);
          paramView.append(HardCodeUtil.a(2131715350));
          localView.setContentDescription(paramView.toString());
        }
      }
      else if ((this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 14) && (!localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        paramView = new StringBuilder();
        paramView.append(str);
        paramView.append(HardCodeUtil.a(2131715339));
        localView.setContentDescription(paramView.toString());
      }
      localView.setOnClickListener(this.a);
      if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity)) {
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).updateGameView(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, localTroopMemberInfo, localViewHolder.jdField_a_of_type_AndroidWidgetTextView, localViewHolder.jdField_a_of_type_AndroidWidgetImageView, localViewHolder.jdField_b_of_type_AndroidWidgetTextView);
      }
    }
    else
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView = String.valueOf(this.a.jdField_a_of_type_ArrayOfJavaLangString[i]);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramView);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131691806), new Object[] { paramView.toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.TroopMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */