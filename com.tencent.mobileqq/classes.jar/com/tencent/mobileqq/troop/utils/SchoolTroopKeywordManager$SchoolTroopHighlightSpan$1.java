package com.tencent.mobileqq.troop.utils;

import bdla;
import bghy;
import bghz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;

public class SchoolTroopKeywordManager$SchoolTroopHighlightSpan$1
  implements Runnable
{
  public SchoolTroopKeywordManager$SchoolTroopHighlightSpan$1(bghz parambghz, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject;
    if (!bghz.a(this.this$0).jdField_a_of_type_Boolean)
    {
      localObject = bghz.a(this.this$0).getCurrentAccountUin();
      localObject = ((TroopManager)bghz.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER)).b(bghz.a(this.this$0).jdField_a_of_type_JavaLangString, (String)localObject);
      if (localObject != null)
      {
        if (((TroopMemberInfo)localObject).level != 332) {
          break label187;
        }
        localObject = bghz.a(this.this$0);
        ((bghy)localObject).jdField_a_of_type_Int |= 0x4;
      }
    }
    for (;;)
    {
      bghz.a(this.this$0).jdField_a_of_type_Boolean = true;
      bdla.b(null, "dc00899", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, bghz.a(this.this$0).jdField_a_of_type_JavaLangString, bghz.a(this.this$0).a(), bghz.a(this.this$0).jdField_b_of_type_Int + "", bghz.a(this.this$0).jdField_b_of_type_JavaLangString);
      return;
      label187:
      if (((TroopMemberInfo)localObject).level == 333)
      {
        localObject = bghz.a(this.this$0);
        ((bghy)localObject).jdField_a_of_type_Int |= 0x8;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1
 * JD-Core Version:    0.7.0.1
 */