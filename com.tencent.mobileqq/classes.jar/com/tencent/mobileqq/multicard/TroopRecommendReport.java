package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopRecommendReport
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "frd_recom", "grp_card_tab_exp", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, RecommendPerson paramRecommendPerson)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramRecommendPerson);
    a("grp_card_add", paramInt2, paramQQAppInterface, paramRecommendPerson.cardTypeID, paramRecommendPerson.uin, paramInt1, localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, List<RecommendPerson> paramList)
  {
    a("grp_card_exp", 0, paramQQAppInterface, paramInt1, "", paramInt2, paramList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, RecommendPerson paramRecommendPerson)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramRecommendPerson);
    a("grp_card_clk", 0, paramQQAppInterface, paramRecommendPerson.cardTypeID, paramRecommendPerson.uin, paramInt, localArrayList);
  }
  
  private static void a(String paramString1, int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2, String paramString2, int paramInt3, List<RecommendPerson> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder3 = new StringBuilder();
    StringBuilder localStringBuilder4 = new StringBuilder();
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    while (i < paramList.size())
    {
      if (paramList.get(i) != null)
      {
        if (i > 0)
        {
          localStringBuilder1.append(",");
          localStringBuilder2.append(",");
          localStringBuilder3.append(",");
          localStringBuilder4.append(",");
        }
        localStringBuilder1.append(((RecommendPerson)paramList.get(i)).uin);
        localStringBuilder2.append(((RecommendPerson)paramList.get(i)).recommendReason);
        localStringBuilder3.append(((RecommendPerson)paramList.get(i)).recommendALghrithm);
        localStringBuilder4.append(((RecommendPerson)paramList.get(i)).recommendRecall);
      }
      i += 1;
    }
    try
    {
      if ("grp_card_exp".equals(paramString1)) {
        localJSONObject.put("exp_uin", localStringBuilder1.toString());
      }
      localJSONObject.put("exp_reason", localStringBuilder2.toString());
      localJSONObject.put("algh_id", localStringBuilder3.toString());
      localJSONObject.put("recall_id", localStringBuilder4.toString());
    }
    catch (JSONException paramList)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("reportRecommend error: ");
        localStringBuilder1.append(paramList.getMessage());
        QLog.i("TroopMemberRecommend.Report", 2, localStringBuilder1.toString());
      }
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString2, "frd_recom", paramString1, paramInt2, paramInt1, String.valueOf(paramInt3), "", localJSONObject.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopRecommendReport
 * JD-Core Version:    0.7.0.1
 */