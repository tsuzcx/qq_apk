package com.tencent.mobileqq.teamwork.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.ItemData;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class TeamWorkAuthorizeSettingFragment$2
  extends TeamWorkObserver
{
  TeamWorkAuthorizeSettingFragment$2(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      FMToastUtil.a(HardCodeUtil.a(2131714679));
    }
    while ((this.a.jdField_a_of_type_Int != paramInt) && (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if ((0 == 0) && (QLog.isDevelopLevel())) {
      QLog.i("TeamWorkAuthorizeSettingFragment", 1, "padInfo is null, maybe is newpad");
    }
    this.a.jdField_a_of_type_JavaUtilList.clear();
    if (0 != 0) {
      throw new NullPointerException();
    }
    for (;;)
    {
      TeamWorkAuthorizeSettingFragment.a(this.a, this.a.b);
      TeamWorkAuthorizeSettingFragment.a(this.a);
      TeamWorkAuthorizeSettingFragment.a(this.a, true);
      return;
      this.a.b = 2;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      FMToastUtil.a(HardCodeUtil.a(2131714667));
    }
    while (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.jdField_a_of_type_JavaUtilList.clear();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (TimDocSSOMsg.UinRightInfo)paramString.next();
      TeamWorkAuthorizeUinListAdapter.ItemData localItemData = new TeamWorkAuthorizeUinListAdapter.ItemData();
      localItemData.jdField_a_of_type_JavaLangString = String.valueOf(paramList.uint64_uin.get());
      localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = paramList;
      this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.a(localItemData);
    }
    this.a.b = paramInt;
    TeamWorkAuthorizeSettingFragment.a(this.a, this.a.b);
    TeamWorkAuthorizeSettingFragment.a(this.a);
    TeamWorkAuthorizeSettingFragment.a(this.a, true);
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    TeamWorkAuthorizeSettingFragment.a(this.a, true);
    this.a.getRightTextView().setEnabled(true);
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      FMToastUtil.a(HardCodeUtil.a(2131714622));
    }
    Intent localIntent;
    do
    {
      return;
      FMToastUtil.b(HardCodeUtil.a(2131714624));
      this.a.stopTitleProgress();
      localIntent = new Intent();
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("type", paramInt);
    } while (!this.a.isAdded());
    this.a.getActivity().setResult(1122, localIntent);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */