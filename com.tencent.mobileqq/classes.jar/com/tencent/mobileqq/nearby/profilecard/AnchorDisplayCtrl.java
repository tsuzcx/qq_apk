package com.tencent.mobileqq.nearby.profilecard;

import afgt;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NowConfig;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NowFollowAnchor;

public class AnchorDisplayCtrl
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AnchorDisplayAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAnchorDisplayAdapter;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370811);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131370812));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAnchorDisplayAdapter = new AnchorDisplayAdapter(paramBoolean, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAnchorDisplayAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
  }
  
  public void a(cmd0xac5.NearbyNowData paramNearbyNowData)
  {
    if (paramNearbyNowData != null)
    {
      this.jdField_a_of_type_JavaLangString = paramNearbyNowData.bytes_more_anchor_url.get().toStringUtf8();
      List localList = paramNearbyNowData.rpt_msg_now_follow_anchor.get();
      String str = paramNearbyNowData.msg_now_config.bytes_live_boardcast_gif_url.get().toStringUtf8();
      if (localList.size() > 0)
      {
        ReportTask localReportTask = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card").d("exp_live");
        if (this.jdField_a_of_type_Boolean)
        {
          paramNearbyNowData = "1";
          localReportTask.a(new String[] { paramNearbyNowData }).a();
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
          label125:
          paramNearbyNowData = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAnchorDisplayAdapter;
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label233;
          }
        }
      }
      label233:
      for (boolean bool = true;; bool = false)
      {
        paramNearbyNowData.a(localList, bool, str);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardAnchorDisplayAdapter.notifyDataSetChanged();
        if (QLog.isColorLevel()) {
          QLog.i("AnchorDisplayCtrl", 2, "updateData, url =" + this.jdField_a_of_type_JavaLangString + ", nowFollowAnchors.size=" + localList.size());
        }
        return;
        paramNearbyNowData = "2";
        break;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        break label125;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
    QLog.i("AnchorDisplayCtrl", 1, "nearbyNowData == null");
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = (afgt)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((afgt)localObject).jdField_a_of_type_TencentImOidbCmd0xac5Cmd0xac5$NowFollowAnchor;
      paramAdapterView = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
    }
    switch (((afgt)localObject).jdField_a_of_type_Int)
    {
    default: 
      QLog.i("AnchorDisplayCtrl", 1, "unknowed jumpType = " + ((afgt)localObject).jdField_a_of_type_Int);
      return;
    case 1: 
      if (paramView != null)
      {
        paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.bytes_live_url.get().toStringUtf8());
        if (paramView != null) {
          paramView.b();
        }
      }
      paramAdapterView.d.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), Integer.valueOf(1));
      paramView = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card").d("clk_live");
      if (this.jdField_a_of_type_Boolean) {}
      for (paramAdapterView = "1";; paramAdapterView = "2")
      {
        paramView.a(new String[] { paramAdapterView, "1" }).a();
        return;
      }
    case 2: 
      if (paramView != null) {
        if (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(String.valueOf(paramView.uint64_uin.get()))) {
          break label560;
        }
      }
      break;
    }
    label553:
    label560:
    for (paramInt = 40;; paramInt = 41)
    {
      localObject = new ProfileActivity.AllInOne(String.valueOf(paramView.uint64_uin.get()), paramInt);
      ((ProfileActivity.AllInOne)localObject).h = 116;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(paramView.uint64_uin.get())))
      {
        localIntent.putExtra("param_mode", 2);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        paramAdapterView.d.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), Integer.valueOf(1));
        paramView = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card").d("clk_live");
        if (!this.jdField_a_of_type_Boolean) {
          break label443;
        }
      }
      label443:
      for (paramAdapterView = "1";; paramAdapterView = "2")
      {
        paramView.a(new String[] { paramAdapterView, "2" }).a();
        return;
        localIntent.putExtra("param_mode", 3);
        break;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramAdapterView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramAdapterView.putExtra("url", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramAdapterView);
        paramView = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card");
        if (!this.jdField_a_of_type_Boolean) {
          break label553;
        }
      }
      for (paramAdapterView = "clk_more_mylive";; paramAdapterView = "clk_more_live")
      {
        paramView.d(paramAdapterView).a();
        return;
        QLog.i("AnchorDisplayCtrl", 1, "mMoreAnchorUrl is empty");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.AnchorDisplayCtrl
 * JD-Core Version:    0.7.0.1
 */