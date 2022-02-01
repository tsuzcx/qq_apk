package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TroopFeedViewFactory
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  protected Context a;
  protected Drawable a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected TroopFeedsDataManager a;
  protected TroopFeedsCenterLogic a;
  protected HashMap<Integer, TroopFeedViewFactory.ViewProvider> a;
  protected Drawable b = null;
  protected Drawable c = null;
  
  public TroopFeedViewFactory(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopFeedsDataManager paramTroopFeedsDataManager, TroopFeedsCenterLogic paramTroopFeedsCenterLogic)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = paramTroopFeedsDataManager;
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = paramTroopFeedsCenterLogic;
  }
  
  protected int a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 5) && (paramInt != 10) && (paramInt != 12) && (paramInt != 18) && (paramInt != 19) && (paramInt != 131)) {}
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
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return new TroopFeedViewFactory.NormalViewProvider(this);
      }
      return new TroopFeedViewFactory.VoteViewProvider(this);
    }
    return new TroopFeedViewFactory.NormalViewProvider(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(2));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof TroopFeedViewFactory.ADViewProvider.ViewHolder))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b(true);
    }
    else if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((localTroopInfo != null) && (str != null))
      {
        if (str.equals(localTroopInfo.troopowneruin))
        {
          i = 0;
          break label152;
        }
        if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(str)))
        {
          i = 1;
          break label152;
        }
      }
      int i = 2;
      label152:
      ((Intent)localObject).putExtra("url", String.format("https://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Integer.valueOf(i) }));
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      localObject = paramView.getTag();
      if ((localObject instanceof TroopFeedViewFactory.ViewHolder))
      {
        localObject = ((TroopFeedViewFactory.ViewHolder)localObject).a;
        if ((localObject != null) && (((TroopFeedItem)localObject).isStoryType())) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_story_pgc", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory
 * JD-Core Version:    0.7.0.1
 */