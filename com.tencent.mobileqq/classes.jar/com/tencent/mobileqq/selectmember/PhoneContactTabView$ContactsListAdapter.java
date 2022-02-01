package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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

class PhoneContactTabView$ContactsListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PhoneContactTabView.ContactsListAdapter.1(this);
  private LinkedHashMap<String, List<PhoneContact>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public PhoneContactTabView$ContactsListAdapter(PhoneContactTabView paramPhoneContactTabView, Context paramContext, AppInterface paramAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramAppInterface, paramXListView, paramBoolean);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView.jdField_a_of_type_JavaUtilList.iterator();
    char c2;
    int j;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c2 = 'A';
      String str = "#";
      j = 0;
      if (!bool) {
        break;
      }
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if (TextUtils.isEmpty(localPhoneContact.pinyinFirst)) {
        localObject1 = "#";
      } else {
        localObject1 = localPhoneContact.pinyinFirst.substring(0, 1);
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
    Object localObject2 = (List)((LinkedHashMap)localObject1).get("@");
    char c1 = c2;
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(PhoneContactTabView.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView), localObject2);
    }
    for (c1 = c2; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c1)) != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c1), ((LinkedHashMap)localObject1).get(String.valueOf(c1)));
      }
    }
    if (((LinkedHashMap)localObject1).get("#") != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject1).get("#"));
    }
    ((LinkedHashMap)localObject1).clear();
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
      localView = SelectActivityViewHolder.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView.jdField_a_of_type_AndroidViewLayoutInflater, 2131558930);
    }
    paramView = (SelectActivityViewHolder)localView.getTag();
    Object localObject;
    if (i < 0)
    {
      i = -(i + 1) - 1;
      localObject = (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      SelectActivityViewHolder.a(this, paramView, (PhoneContact)localObject);
      paramView.d.setText(((PhoneContact)localObject).name);
      paramView.b.setText(((PhoneContact)localObject).mobileNo);
      paramView.b.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(paramView.jdField_a_of_type_JavaLangString)) {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      if ((AppSetting.d) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        StringBuilder localStringBuilder;
        if (paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((PhoneContact)localObject).name);
          localStringBuilder.append(HardCodeUtil.a(2131707997));
          localView.setContentDescription(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((PhoneContact)localObject).name);
          localStringBuilder.append(HardCodeUtil.a(2131707995));
          localView.setContentDescription(localStringBuilder.toString());
        }
      }
      paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramView.c.setVisibility(0);
      localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      paramView.c.setText((CharSequence)localObject);
      paramView.c.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131691806), new Object[] { ((String)localObject).toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView.ContactsListAdapter
 * JD-Core Version:    0.7.0.1
 */