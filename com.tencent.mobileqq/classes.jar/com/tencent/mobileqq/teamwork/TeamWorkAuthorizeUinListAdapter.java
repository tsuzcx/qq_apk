package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.widget.XBaseAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamWorkAuthorizeUinListAdapter
  extends XBaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List jdField_a_of_type_JavaUtilList;
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public TeamWorkAuthorizeUinListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public String a(String paramString)
  {
    Object localObject = (TeamWorkAuthorizeUinListAdapter.ItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null) {
      return paramString;
    }
    localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).jdField_a_of_type_JavaLangString, ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).b, ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).jdField_a_of_type_Int);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((TeamWorkAuthorizeUinListAdapter.ItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = ((String)localObject);
    }
    return ((TeamWorkAuthorizeUinListAdapter.ItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(TeamWorkAuthorizeUinListAdapter.ItemData paramItemData)
  {
    if (paramItemData == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramItemData);
    this.jdField_a_of_type_JavaUtilMap.put(paramItemData.jdField_a_of_type_JavaLangString, paramItemData);
  }
  
  public void a(String paramString)
  {
    TeamWorkAuthorizeUinListAdapter.ItemData localItemData = (TeamWorkAuthorizeUinListAdapter.ItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localItemData == null) {
      return;
    }
    localItemData.c = a(paramString);
    notifyDataSetChanged();
  }
  
  public void b(String paramString)
  {
    paramString = (TeamWorkAuthorizeUinListAdapter.ItemData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label110:
    TeamWorkAuthorizeUinListAdapter.ItemData localItemData;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971585, null);
      paramViewGroup = new TeamWorkAuthorizeUinListAdapter.Holder(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131375034));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362725));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131363185));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366791));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Int != 2) {
        break label230;
      }
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localItemData = (TeamWorkAuthorizeUinListAdapter.ItemData)getItem(paramInt);
      String str = String.valueOf(localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get());
      FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localFaceDrawable);
      str = a(str);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramInt = localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.get();
      if (paramInt != 1) {
        break label249;
      }
      paramViewGroup.b.setText(2131439136);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo;
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (TeamWorkAuthorizeUinListAdapter.Holder)paramView.getTag();
      break;
      label230:
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label110;
      label249:
      if (paramInt == 2) {
        paramViewGroup.b.setText(2131439137);
      } else {
        paramViewGroup.b.setText("状态错了，需要检查！");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter
 * JD-Core Version:    0.7.0.1
 */