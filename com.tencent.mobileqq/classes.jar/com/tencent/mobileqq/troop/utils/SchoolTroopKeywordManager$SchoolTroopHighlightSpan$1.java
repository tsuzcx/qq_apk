package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;

class SchoolTroopKeywordManager$SchoolTroopHighlightSpan$1
  implements Runnable
{
  SchoolTroopKeywordManager$SchoolTroopHighlightSpan$1(SchoolTroopKeywordManager.SchoolTroopHighlightSpan paramSchoolTroopHighlightSpan, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject;
    if (!SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_a_of_type_Boolean)
    {
      localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).getCurrentAccountUin();
      localObject = ((TroopManager)SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER)).b(SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_a_of_type_JavaLangString, (String)localObject);
      if (localObject != null)
      {
        if (((TroopMemberInfo)localObject).level != 332) {
          break label187;
        }
        localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0);
        ((SchoolTroopKeywordManager.KeywordResult)localObject).jdField_a_of_type_Int |= 0x4;
      }
    }
    for (;;)
    {
      SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_a_of_type_Boolean = true;
      ReportController.b(null, "dc00899", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_a_of_type_JavaLangString, SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).a(), SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_b_of_type_Int + "", SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_b_of_type_JavaLangString);
      return;
      label187:
      if (((TroopMemberInfo)localObject).level == 333)
      {
        localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0);
        ((SchoolTroopKeywordManager.KeywordResult)localObject).jdField_a_of_type_Int |= 0x8;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1
 * JD-Core Version:    0.7.0.1
 */