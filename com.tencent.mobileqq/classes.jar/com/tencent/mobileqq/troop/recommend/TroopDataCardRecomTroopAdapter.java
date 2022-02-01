package com.tencent.mobileqq.troop.recommend;

import android.content.Context;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

public class TroopDataCardRecomTroopAdapter
  extends RecommendTroopAdapter
{
  public TroopDataCardRecomTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramBoolean);
  }
  
  public int a()
  {
    return 10100;
  }
  
  public void a(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = paramRecommendTroopItem.uin;
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {}
    for (paramRecommendTroopItem = "1";; paramRecommendTroopItem = "2")
    {
      ReportController.b(null, "dc00899", "Grp_recom", "", "set_page", "clk_grp", 0, 0, str1, str2, paramRecommendTroopItem, "");
      return;
    }
  }
  
  public int b()
  {
    return 39;
  }
  
  public void b(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = String.valueOf(paramRecommendTroopItem.uin);
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {}
    for (paramRecommendTroopItem = "1";; paramRecommendTroopItem = "2")
    {
      ReportController.b(null, "dc00899", "Grp_recom", "", "set_page", "clk_add", 0, 0, str1, str2, paramRecommendTroopItem, "");
      return;
    }
  }
  
  public int c()
  {
    return 10101;
  }
  
  public void c(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = paramRecommendTroopItem.uin;
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {}
    for (paramRecommendTroopItem = "1";; paramRecommendTroopItem = "2")
    {
      ReportController.b(null, "dc00899", "Grp_recom", "", "set_page", "exp_grp", 0, 0, str1, str2, paramRecommendTroopItem, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.TroopDataCardRecomTroopAdapter
 * JD-Core Version:    0.7.0.1
 */