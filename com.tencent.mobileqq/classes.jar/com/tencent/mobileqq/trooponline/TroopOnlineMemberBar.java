package com.tencent.mobileqq.trooponline;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.OnOverScrollRightListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.data.TroopOnlineMemberItem;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopOnlineMemberBar
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, StoryHomeHorizontalListView.OnOverScrollRightListener
{
  public static final int a;
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new TroopOnlineMemberBar.2(this);
  protected ValueAnimator a;
  protected Context a;
  Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  protected RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  protected StoryHomeHorizontalListView a;
  protected QQAppInterface a;
  protected TroopAioTips a;
  protected ITroopOnlineMemberService a;
  protected TroopOnlineMemberListAdapter a;
  protected String a;
  protected boolean a;
  public int b;
  private ValueAnimator.AnimatorUpdateListener b;
  protected ValueAnimator b;
  protected RelativeLayout b;
  private int c = 1;
  
  static
  {
    jdField_a_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 111.0F);
  }
  
  public TroopOnlineMemberBar(QQAppInterface paramQQAppInterface, Context paramContext, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, TroopAioTips paramTroopAioTips)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new TroopOnlineMemberBar.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout2;
    this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiITroopOnlineMemberService = ((ITroopOnlineMemberService)paramQQAppInterface.getRuntimeService(ITroopOnlineMemberService.class, ""));
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
    if ((localObject != null) && (((Animatable)localObject).isRunning())) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void N_()
  {
    int j;
    int i;
    if (this.jdField_b_of_type_Int == 2)
    {
      j = 22;
      i = 8;
    }
    else
    {
      j = 17;
      i = 1;
    }
    if (this.jdField_b_of_type_Int == 3) {
      i = 5;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("param_from", j);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715471));
    localIntent.putExtra("sort_type", i);
    RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/troop/memberlist/TroopMemberList");
    if (this.jdField_b_of_type_Int == 2)
    {
      TroopReportor.a("Grp_idol", "Grp_renshu", "right", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("enter_mberList").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
  }
  
  public void O_() {}
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView == null) {
      return this.c;
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168), -jdField_a_of_type_Int + this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168) });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.b.clear();
    return this.c;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1;
    while (i >= 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i);
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject == localViewGroup) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localViewGroup);
      }
      i -= 1;
    }
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null) {
      ((ValueAnimator)localObject).removeUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    }
    localObject = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if (localObject != null) {
      ((ValueAnimator)localObject).removeUpdateListener(this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560608, null));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379333));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnItemLongClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setBackgroundColor(-16445151);
      } else {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setBackgroundColor(-436207617);
      }
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter = new TroopOnlineMemberListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDataCount(2147483647);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject);
    }
    e();
    Object localObject = ((ITroopOnlineMemberService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopOnlineMemberService.class, "")).getDetailMemberListFromCache(this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.a((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.notifyDataSetChanged();
      this.c = 0;
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362431));
      }
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.notifyDataSetChanged();
      ThreadManager.getUIHandler().postDelayed(new TroopOnlineMemberBar.1(this), 500L);
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberBar", 2, "show(), itemList == null || itemList.empty");
      }
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { -jdField_a_of_type_Int + this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168), this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(0);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    if (localObject != null) {
      ((TroopAioTips)localObject).a(true);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Int == 2)
    {
      TroopReportor.a("Grp_idol", "Grp_renshu", "exp", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiITroopOnlineMemberService.getRequestListServiceType(this.jdField_a_of_type_JavaLangString);
    if (i == 3)
    {
      this.jdField_b_of_type_Int = 2;
      return;
    }
    if (i == 5)
    {
      this.jdField_b_of_type_Int = 3;
      return;
    }
    this.jdField_b_of_type_Int = 1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    ValueAnimator localValueAnimator;
    if (this.jdField_a_of_type_Boolean)
    {
      localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {}
    }
    else
    {
      if (this.jdField_a_of_type_Boolean) {
        break label48;
      }
      localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
      if ((localValueAnimator == null) || (!localValueAnimator.isRunning())) {
        break label48;
      }
    }
    return true;
    label48:
    return false;
  }
  
  public void d()
  {
    if (a())
    {
      List localList = ((ITroopOnlineMemberService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopOnlineMemberService.class, "")).getDetailMemberListFromCache(this.jdField_a_of_type_JavaLangString);
      if (localList != null)
      {
        this.c = 0;
        e();
        this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.a(localList);
        this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TroopOnlineMemberItem localTroopOnlineMemberItem = ((TroopOnlineMemberListAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopOnlinememberDataTroopOnlineMemberItem;
    if (localTroopOnlineMemberItem != null)
    {
      if (localTroopOnlineMemberItem.jdField_a_of_type_Int == 2) {
        TroopReportor.a("Grp_idol", "Grp_renshu", "clk", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
      } else {
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("clk_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localTroopOnlineMemberItem.b }).a();
      }
      if (!((ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, Long.valueOf(localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString).longValue())) {
        TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString, 0, -1);
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (TroopOnlineMemberListAdapter.ViewHolder)paramView.getTag();
    paramView = paramAdapterView.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberDataTroopOnlineMemberItem;
    TroopChatPie localTroopChatPie = (TroopChatPie)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
    if (localTroopChatPie != null) {
      localTroopChatPie.a(paramView.jdField_a_of_type_JavaLangString, paramAdapterView.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), false, 1);
    }
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("press_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, paramView.b }).a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar
 * JD-Core Version:    0.7.0.1
 */