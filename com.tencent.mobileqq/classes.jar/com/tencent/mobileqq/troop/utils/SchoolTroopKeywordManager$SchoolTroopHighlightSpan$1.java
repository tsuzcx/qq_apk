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
    if (!SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_a_of_type_Boolean)
    {
      localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).getCurrentAccountUin();
      localObject = ((TroopManager)SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER)).b(SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_a_of_type_JavaLangString, (String)localObject);
      if (localObject != null) {
        if (((TroopMemberInfo)localObject).level == 332)
        {
          localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0);
          ((SchoolTroopKeywordManager.KeywordResult)localObject).jdField_a_of_type_Int |= 0x4;
        }
        else if (((TroopMemberInfo)localObject).level == 333)
        {
          localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0);
          ((SchoolTroopKeywordManager.KeywordResult)localObject).jdField_a_of_type_Int |= 0x8;
        }
      }
      SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_a_of_type_Boolean = true;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.c;
    String str3 = this.d;
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    String str4 = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_a_of_type_JavaLangString;
    String str5 = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_b_of_type_Int);
    localStringBuilder.append("");
    ReportController.b(null, "dc00899", (String)localObject, str1, str2, str3, i, j, str4, str5, localStringBuilder.toString(), SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.this$0).jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1
 * JD-Core Version:    0.7.0.1
 */