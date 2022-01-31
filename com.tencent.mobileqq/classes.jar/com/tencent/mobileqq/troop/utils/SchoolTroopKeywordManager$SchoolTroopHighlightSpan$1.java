package com.tencent.mobileqq.troop.utils;

import azmj;
import bchd;
import bche;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class SchoolTroopKeywordManager$SchoolTroopHighlightSpan$1
  implements Runnable
{
  public SchoolTroopKeywordManager$SchoolTroopHighlightSpan$1(bche parambche, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject;
    if (!bche.a(this.this$0).jdField_a_of_type_Boolean)
    {
      localObject = bche.a(this.this$0).getCurrentAccountUin();
      localObject = ((TroopManager)bche.a(this.this$0).getManager(52)).b(bche.a(this.this$0).jdField_a_of_type_JavaLangString, (String)localObject);
      if (localObject != null)
      {
        if (((TroopMemberInfo)localObject).level != 332) {
          break label186;
        }
        localObject = bche.a(this.this$0);
        ((bchd)localObject).jdField_a_of_type_Int |= 0x4;
      }
    }
    for (;;)
    {
      bche.a(this.this$0).jdField_a_of_type_Boolean = true;
      azmj.b(null, "dc00899", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, bche.a(this.this$0).jdField_a_of_type_JavaLangString, bche.a(this.this$0).a(), bche.a(this.this$0).jdField_b_of_type_Int + "", bche.a(this.this$0).jdField_b_of_type_JavaLangString);
      return;
      label186:
      if (((TroopMemberInfo)localObject).level == 333)
      {
        localObject = bche.a(this.this$0);
        ((bchd)localObject).jdField_a_of_type_Int |= 0x8;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1
 * JD-Core Version:    0.7.0.1
 */