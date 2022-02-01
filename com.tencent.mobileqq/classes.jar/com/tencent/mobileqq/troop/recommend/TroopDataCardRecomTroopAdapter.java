package com.tencent.mobileqq.troop.recommend;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;

public class TroopDataCardRecomTroopAdapter
  extends RecommendTroopAdapter
{
  public TroopDataCardRecomTroopAdapter(Context paramContext, AppInterface paramAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramAppInterface, paramBoolean);
  }
  
  protected int a()
  {
    return 10100;
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = paramRecommendTroopItem.uin;
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {
      paramRecommendTroopItem = "1";
    } else {
      paramRecommendTroopItem = "2";
    }
    ReportController.b(null, "dc00899", "Grp_recom", "", "set_page", "clk_grp", 0, 0, str1, str2, paramRecommendTroopItem, "");
  }
  
  protected int b()
  {
    return 39;
  }
  
  protected void b(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = String.valueOf(paramRecommendTroopItem.uin);
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {
      paramRecommendTroopItem = "1";
    } else {
      paramRecommendTroopItem = "2";
    }
    ReportController.b(null, "dc00899", "Grp_recom", "", "set_page", "clk_add", 0, 0, str1, str2, paramRecommendTroopItem, "");
  }
  
  protected int c()
  {
    return 10101;
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = paramRecommendTroopItem.uin;
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {
      paramRecommendTroopItem = "1";
    } else {
      paramRecommendTroopItem = "2";
    }
    ReportController.b(null, "dc00899", "Grp_recom", "", "set_page", "exp_grp", 0, 0, str1, str2, paramRecommendTroopItem, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.TroopDataCardRecomTroopAdapter
 * JD-Core Version:    0.7.0.1
 */