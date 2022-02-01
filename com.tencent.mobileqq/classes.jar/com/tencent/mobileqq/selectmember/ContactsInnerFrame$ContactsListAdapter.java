package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadHolder.ViewHolder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class ContactsInnerFrame$ContactsListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  private LinkedHashMap<String, List<PhoneContact>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public ContactsInnerFrame$ContactsListAdapter(ContactsInnerFrame paramContactsInnerFrame, Context paramContext, AppInterface paramAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramAppInterface, paramXListView, paramBoolean);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame.jdField_a_of_type_JavaUtilList.iterator();
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
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if ((localPhoneContact.pinyinFirst != null) && (localPhoneContact.pinyinFirst.length() != 0)) {
        localObject1 = localPhoneContact.pinyinFirst.substring(0, 1);
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
      ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2)).add(localPhoneContact);
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
  
  protected boolean a(FacePreloadHolder.ViewHolder paramViewHolder)
  {
    boolean bool2 = super.a(paramViewHolder);
    boolean bool1 = bool2;
    if ((paramViewHolder instanceof SelectActivityViewHolder))
    {
      paramViewHolder = (SelectActivityViewHolder)paramViewHolder;
      if ((bool2) && (!paramViewHolder.jdField_a_of_type_Boolean)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
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
    return (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = SelectActivityViewHolder.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater, 2131562820);
    }
    SelectActivityViewHolder localSelectActivityViewHolder = (SelectActivityViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      i = paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1;
      PhoneContact localPhoneContact2 = (PhoneContact)localList.get(i);
      SelectActivityViewHolder.a(this, localSelectActivityViewHolder, localPhoneContact2);
      int j = i - 1;
      PhoneContact localPhoneContact1 = null;
      if (j < 0) {
        paramView = null;
      } else {
        paramView = (PhoneContact)localList.get(j);
      }
      i += 1;
      if (i <= localList.size() - 1) {
        localPhoneContact1 = (PhoneContact)localList.get(i);
      }
      if (((paramView != null) && (paramView.contactID == localPhoneContact2.contactID)) || ((localPhoneContact1 != null) && (localPhoneContact1.contactID == localPhoneContact2.contactID)))
      {
        localSelectActivityViewHolder.b.setVisibility(0);
        localSelectActivityViewHolder.b.setText(localPhoneContact2.mobileNo);
      }
      else
      {
        localSelectActivityViewHolder.b.setVisibility(8);
      }
      localSelectActivityViewHolder.d.setText(localPhoneContact2.name);
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString)) {
        localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault != null) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault.contains(localPhoneContact2.uin))) {
        localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      } else {
        localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      }
      if ((AppSetting.d) && (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
        if (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
        {
          paramView = new StringBuilder();
          paramView.append(localPhoneContact2.name);
          paramView.append(HardCodeUtil.a(2131702729));
          localView.setContentDescription(paramView.toString());
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append(localPhoneContact2.name);
          paramView.append(HardCodeUtil.a(2131702700));
          localView.setContentDescription(paramView.toString());
        }
      }
      localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = localPhoneContact2;
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame);
    }
    else
    {
      localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localSelectActivityViewHolder.c.setVisibility(0);
      paramView = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      localSelectActivityViewHolder.c.setText(paramView);
      localSelectActivityViewHolder.c.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131691806), new Object[] { paramView.toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ContactsInnerFrame.ContactsListAdapter
 * JD-Core Version:    0.7.0.1
 */