import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class rxc
  implements Runnable
{
  public rxc(BaseChatPie paramBaseChatPie, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 9;
    int m = 0;
    int j = BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, this.b + "is hotword, totalnum = " + j);
    }
    if (j == 0) {
      return;
    }
    Object localObject3 = BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(this.jdField_a_of_type_JavaLangString);
    Object localObject2 = BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    if (j > 9) {}
    for (;;)
    {
      long l = BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(this.jdField_a_of_type_JavaLangString);
      boolean bool;
      if (BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a()) {
        if (System.currentTimeMillis() - l > 86400000L) {
          bool = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "afterTextChanged isNeedReq = " + bool);
        }
        if (bool)
        {
          ((List)localObject1).clear();
          localObject2 = new ArrayList();
          j = i;
          int k = m;
          if (localObject3 != null)
          {
            ((List)localObject2).add(((Emoticon)localObject3).eId);
            ((List)localObject1).add(localObject3);
            j = i - 1;
            k = m;
          }
          for (;;)
          {
            if (k < j)
            {
              localObject3 = new Emoticon();
              ((Emoticon)localObject3).epId = "NONE";
              ((Emoticon)localObject3).eId = ("_" + k);
              ((List)localObject1).add(localObject3);
              k += 1;
              continue;
              if (((List)localObject1).size() >= i) {
                break label401;
              }
              bool = true;
              break;
            }
          }
          localObject3 = BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).c(this.jdField_a_of_type_JavaLangString);
          ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(this.b, (List)localObject2, (List)localObject3);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler.post(new rxd(this, (List)localObject1));
        return;
        label401:
        bool = false;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxc
 * JD-Core Version:    0.7.0.1
 */