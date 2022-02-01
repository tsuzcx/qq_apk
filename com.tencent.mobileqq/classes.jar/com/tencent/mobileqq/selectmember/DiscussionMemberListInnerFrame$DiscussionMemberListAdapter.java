package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class DiscussionMemberListInnerFrame$DiscussionMemberListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  private LinkedHashMap<String, List<DiscussionMemberInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public DiscussionMemberListInnerFrame$DiscussionMemberListAdapter(DiscussionMemberListInnerFrame paramDiscussionMemberListInnerFrame)
  {
    super(paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    b();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    char c2;
    int j;
    Object localObject3;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c2 = 'A';
      j = 0;
      String str1 = "#";
      if (!bool) {
        break;
      }
      DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
      if ((localDiscussionMemberInfo != null) && ((localDiscussionMemberInfo == null) || (!CommonUtils.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, localDiscussionMemberInfo.memberUin)))) {
        if ((localDiscussionMemberInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mIsPutMySelfFirst) && (str2 != null) && (str2.equals(localDiscussionMemberInfo.memberUin)))
        {
          localObject1 = localDiscussionMemberInfo;
        }
        else
        {
          if ((localDiscussionMemberInfo.displayedNamePinyinFirst != null) && (localDiscussionMemberInfo.displayedNamePinyinFirst.length() != 0)) {
            localObject2 = localDiscussionMemberInfo.displayedNamePinyinFirst.substring(0, 1);
          } else {
            localObject2 = "#";
          }
          i = ((String)localObject2).charAt(0);
          if ((65 > i) || (i > 90))
          {
            localObject3 = str1;
            if (97 <= i)
            {
              localObject3 = str1;
              if (i > 122) {}
            }
          }
          else
          {
            localObject3 = ((String)localObject2).toUpperCase();
          }
          if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject3) == null) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject3, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject3)).add(localDiscussionMemberInfo);
        }
      }
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    char c1 = c2;
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mIsPutMySelfFirst)
    {
      c1 = c2;
      if (localObject1 != null)
      {
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject1);
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(HardCodeUtil.a(2131703521), localObject3);
      }
    }
    for (c1 = c2; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (((LinkedHashMap)localObject2).get(String.valueOf(c1)) != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c1), ((LinkedHashMap)localObject2).get(String.valueOf(c1)));
      }
    }
    if (((LinkedHashMap)localObject2).get("#") != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject2).get("#"));
    }
    ((LinkedHashMap)localObject2).clear();
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    localObject2 = this.jdField_a_of_type_ArrayOfInt;
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
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559309;
    }
    return 0;
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
    Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localIterator.next())).size();
    }
    return i;
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
    return (DiscussionMemberInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
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
      localView = this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562820, paramViewGroup, false);
      paramView = new DiscussionMemberListInnerFrame.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame, null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376702));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379732));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364613));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368343));
      paramView.d = ((TextView)localView.findViewById(2131371697));
    }
    Object localObject = (DiscussionMemberListInnerFrame.ViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramView = (DiscussionMemberInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(paramView.memberUin)) {
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramView.memberUin));
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).d.setText(CommonUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface));
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_JavaLangString = paramView.memberUin;
      if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault != null) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault.contains(paramView.memberUin))) {
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      } else {
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      }
      if ((AppSetting.d) && (((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
        if (((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(CommonUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface));
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131703527));
          localView.setContentDescription(((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(CommonUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface));
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131703510));
          localView.setContentDescription(((StringBuilder)localObject).toString());
        }
      }
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame);
    }
    else
    {
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setText(paramView);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131691806), new Object[] { paramView.toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.DiscussionMemberListInnerFrame.DiscussionMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */