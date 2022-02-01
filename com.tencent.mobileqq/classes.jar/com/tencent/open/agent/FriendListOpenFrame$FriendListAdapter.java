package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import com.tencent.open.base.LogUtility;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class FriendListOpenFrame$FriendListAdapter
  extends PinnedDividerListView.DividerAdapter
{
  protected LinkedHashMap<String, List<Friend>> a;
  protected int[] a;
  protected String[] a;
  
  public FriendListOpenFrame$FriendListAdapter(FriendListOpenFrame paramFriendListOpenFrame)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    a();
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
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_Int);
    LogUtility.c("FriendListOpenFrame", "-->start constructHashStruct()");
    Iterator localIterator = ((List)localObject1).iterator();
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
      Friend localFriend = (Friend)localIterator.next();
      if ((localFriend.f != null) && (localFriend.f.length() != 0)) {
        localObject1 = localFriend.f.substring(0, 1);
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
      ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2)).add(localFriend);
    }
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
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
    LogUtility.c("FriendListOpenFrame", "-->end constructHashStruct()");
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if (paramInt >= 0)
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (paramInt >= arrayOfString.length) {
        return;
      }
      ((TextView)paramView).setText(arrayOfString[paramInt]);
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public void b()
  {
    a();
    super.notifyDataSetChanged();
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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562820, paramViewGroup, false);
      paramView = new FriendListOpenFrame.ViewHolder();
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376702));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379732));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364613));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368343));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371697));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (FriendListOpenFrame.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    if (i < 0)
    {
      i = -(i + 1) - 1;
      localObject = (Friend)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      if (this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(((Friend)localObject).a)) {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      if (this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(((Friend)localObject).a)) {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      if ((((Friend)localObject).d == null) || ("".equals(((Friend)localObject).d))) {
        ((Friend)localObject).d = QZonePortraitData.a(this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), ((Friend)localObject).a);
      }
      paramView.jdField_b_of_type_JavaLangString = ((Friend)localObject).d;
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      Bitmap localBitmap = ImageLoader.a().a(((Friend)localObject).d);
      if (localBitmap == null)
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840321);
        ImageLoader.a().a(((Friend)localObject).d, this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
      if ((((Friend)localObject).c != null) && (!"".equals(((Friend)localObject).c))) {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((Friend)localObject).c);
      } else {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((Friend)localObject).jdField_b_of_type_JavaLangString);
      }
    }
    else
    {
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.FriendListOpenFrame.FriendListAdapter
 * JD-Core Version:    0.7.0.1
 */