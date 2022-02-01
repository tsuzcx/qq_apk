package com.tencent.mobileqq.dating;

import android.util.Pair;
import aquj;
import aqvf;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;
import mqq.os.MqqHandler;

public class StrangerHdHeadUrlFetcher$1
  implements Runnable
{
  public StrangerHdHeadUrlFetcher$1(aqvf paramaqvf, String paramString1, int paramInt, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQHeadSetting(32, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (localObject1 != null) {}
    for (boolean bool = ((Boolean)((Pair)localObject1).first).booleanValue();; bool = false)
    {
      if ((bool) && (this.jdField_a_of_type_Boolean))
      {
        localObject1 = (FriendListHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1);
        if (localObject1 != null)
        {
          this.this$0.jdField_a_of_type_Long = System.currentTimeMillis();
          synchronized (aqvf.a(this.this$0))
          {
            if (!this.this$0.jdField_a_of_type_Boolean)
            {
              this.this$0.jdField_a_of_type_Boolean = true;
              this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(aqvf.a(this.this$0), true);
            }
          }
        }
      }
      else
      {
        synchronized (this.this$0.jdField_a_of_type_JavaUtilSet)
        {
          this.this$0.jdField_a_of_type_JavaUtilSet.add(this.b);
          ((FriendListHandler)localObject1).getStrangerHead(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (byte)1, (byte)2);
          if (!this.this$0.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
            this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 60000L);
          }
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
      aquj.a("StrangerHdHeadUrlFetcher", new Object[] { "flh is null" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher.1
 * JD-Core Version:    0.7.0.1
 */