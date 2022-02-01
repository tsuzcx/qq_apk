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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  List<TeamWorkAuthorizeUinListAdapter.ItemData> jdField_a_of_type_JavaUtilList;
  Map<String, TeamWorkAuthorizeUinListAdapter.ItemData> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public TeamWorkAuthorizeUinListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List<TeamWorkAuthorizeUinListAdapter.ItemData> paramList)
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
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562912, null);
      paramView = new TeamWorkAuthorizeUinListAdapter.Holder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368137));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371854));
      paramView.b = ((TextView)localView.findViewById(2131377850));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362989));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (TeamWorkAuthorizeUinListAdapter.Holder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      paramView.b.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      paramView.b.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    Object localObject = (TeamWorkAuthorizeUinListAdapter.ItemData)getItem(paramInt);
    String str = String.valueOf(((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get());
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
    paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localFaceDrawable);
    str = a(str);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    int i = ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.get();
    if (i == 1) {
      paramView.b.setText(2131719502);
    } else if (i == 2) {
      paramView.b.setText(2131719503);
    } else {
      paramView.b.setText(HardCodeUtil.a(2131714586));
    }
    paramView.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo;
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter
 * JD-Core Version:    0.7.0.1
 */