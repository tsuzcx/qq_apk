package com.tencent.mobileqq.troop.widget;

import ajfc;
import ajfd;
import ajff;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TroopFeedViewFactory
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  public Drawable a;
  public SessionInfo a;
  public QQAppInterface a;
  public TroopFeedsDataManager a;
  protected TroopFeedsCenterLogic a;
  protected HashMap a;
  public Drawable b;
  public Drawable c;
  
  public TroopFeedViewFactory(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopFeedsDataManager paramTroopFeedsDataManager, TroopFeedsCenterLogic paramTroopFeedsCenterLogic)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = paramTroopFeedsDataManager;
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = paramTroopFeedsCenterLogic;
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    }
    return 0;
  }
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2)) != null) {
      return null;
    }
    int i = a(paramTroopFeedItem.type);
    TroopFeedViewFactory.ViewProvider localViewProvider2 = (TroopFeedViewFactory.ViewProvider)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    TroopFeedViewFactory.ViewProvider localViewProvider1 = localViewProvider2;
    if (localViewProvider2 == null)
    {
      localViewProvider1 = a(i);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localViewProvider1);
    }
    if (localViewProvider1 != null) {
      return localViewProvider1.a(paramTroopFeedItem, paramInt, paramBoolean);
    }
    return null;
  }
  
  protected TroopFeedViewFactory.ViewProvider a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new ajfd(this);
    case 0: 
      return new ajfd(this);
    }
    return new ajff(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(2));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ajfc))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b(true);
      break label18;
    }
    label18:
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i;
    if ((localTroopInfo != null) && (str != null)) {
      if (str.equals(localTroopInfo.troopowneruin)) {
        i = 0;
      }
    }
    for (;;)
    {
      localIntent.putExtra("url", String.format("http://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Integer.valueOf(i) }));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      paramView = paramView.getTag();
      if (!(paramView instanceof TroopFeedViewFactory.ViewHolder)) {
        break;
      }
      paramView = ((TroopFeedViewFactory.ViewHolder)paramView).a;
      if ((paramView == null) || (!paramView.isStoryType())) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_story_pgc", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      return;
      if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(str))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory
 * JD-Core Version:    0.7.0.1
 */