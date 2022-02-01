package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
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
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class FriendListInnerFrame$FriendListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  private LinkedHashMap<String, List<Friends>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public FriendListInnerFrame$FriendListAdapter(FriendListInnerFrame paramFriendListInnerFrame)
  {
    super(paramFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, paramFriendListInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, paramFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    b();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame.jdField_a_of_type_JavaUtilList.iterator();
    char c;
    int j;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c = 'A';
      j = 0;
      String str = "#";
      if (!bool) {
        break;
      }
      Friends localFriends = (Friends)localIterator.next();
      if ((localFriends.mCompareSpell != null) && (localFriends.mCompareSpell.length() != 0)) {
        localObject1 = localFriends.mCompareSpell.substring(0, 1);
      } else {
        localObject1 = "#";
      }
      i = ((String)localObject1).charAt(0);
      if ((65 > i) || (i > 90))
      {
        localObject2 = str;
        if (97 <= i)
        {
          localObject2 = str;
          if (i > 122) {}
        }
      }
      else
      {
        localObject2 = ((String)localObject1).toUpperCase();
      }
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2) == null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject2, new ArrayList());
      }
      ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2)).add(localFriends);
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    while (c <= 'Z')
    {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), ((LinkedHashMap)localObject1).get(String.valueOf(c)));
      }
      c = (char)(c + '\001');
    }
    if (((LinkedHashMap)localObject1).get("#") != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject1).get("#"));
    }
    ((LinkedHashMap)localObject1).clear();
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    Object localObject2 = this.jdField_a_of_type_ArrayOfInt;
    if (localObject2.length == 0) {
      return;
    }
    localObject2[0] = 0;
    int i = 1;
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      if (i >= localObject2.length) {
        break;
      }
      localObject2[i] += localObject2[(i - 1)] + ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + 1;
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
  }
  
  public int a()
  {
    return 2131559309;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (i >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[i].equals(paramString)) {
          break label42;
        }
        i += 1;
      }
      i = -1;
      label42:
      if (i >= 0) {
        return this.jdField_a_of_type_ArrayOfInt[i];
      }
    }
    return -1;
  }
  
  public void a()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    if (localObject.length == 0) {
      return 0;
    }
    int i = localObject[(localObject.length - 1)];
    localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    paramInt = paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1;
    if ((paramInt >= 0) && (paramInt < localList.size())) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562820, paramViewGroup, false);
      paramView = new FriendListInnerFrame.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame, null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376702));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379732));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364613));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368343));
      paramView.d = ((TextView)localView.findViewById(2131371697));
    }
    Object localObject = (FriendListInnerFrame.ViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramView = (Friends)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(paramView.uin)) {
        ((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        ((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      ((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((FriendListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      ((FriendListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramView.uin));
      ((FriendListInnerFrame.ViewHolder)localObject).d.setText(paramView.getFriendNick());
      ((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_JavaLangString = paramView.uin;
      if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault != null) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault.contains(paramView.uin))) {
        ((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      } else {
        ((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      }
      if ((AppSetting.d) && (((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
        if (((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramView.getFriendNick());
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131704973));
          localView.setContentDescription(((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramView.getFriendNick());
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131704976));
          localView.setContentDescription(((StringBuilder)localObject).toString());
        }
      }
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame);
    }
    else
    {
      ((FriendListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      ((FriendListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      ((FriendListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setText(paramView);
      ((FriendListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131691806), new Object[] { paramView.toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendListInnerFrame.FriendListAdapter
 * JD-Core Version:    0.7.0.1
 */