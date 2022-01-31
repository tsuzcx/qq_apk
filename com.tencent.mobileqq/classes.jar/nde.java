import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.biz.qqstory.model.TroopNickNameManager.TroopNickNameUpdateEvent;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.TroopManager;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;

public class nde
  implements Runnable
{
  public nde(TroopNickNameManager paramTroopNickNameManager, String paramString, QQUserUIItem paramQQUserUIItem, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelTroopNickNameManager.a.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq) != null)
    {
      localTroopNickNameUpdateEvent = new TroopNickNameManager.TroopNickNameUpdateEvent();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq);
      localTroopNickNameUpdateEvent.jdField_a_of_type_JavaUtilList = localArrayList;
      localTroopNickNameUpdateEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      Dispatchers.get().dispatch(localTroopNickNameUpdateEvent);
    }
    while (this.jdField_a_of_type_Boolean)
    {
      TroopNickNameManager.TroopNickNameUpdateEvent localTroopNickNameUpdateEvent;
      ArrayList localArrayList;
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelTroopNickNameManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nde
 * JD-Core Version:    0.7.0.1
 */