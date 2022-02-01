package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MessageForQQWalletTips$1
  implements Runnable
{
  MessageForQQWalletTips$1(MessageForQQWalletTips paramMessageForQQWalletTips, WeakReference paramWeakReference, List paramList, String paramString) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      localObject3 = ((TroopManager)localObject2).b(this.jdField_a_of_type_JavaLangString, (String)localObject3);
      if (localObject3 != null) {
        localLinkedList.add(localObject3);
      }
    }
    if (localLinkedList.size() >= this.jdField_a_of_type_JavaUtilList.size())
    {
      this.this$0.updateMsg((QQAppInterface)localObject1);
      return;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      int j = 1;
      localIterator = localLinkedList.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject3 = (TroopMemberInfo)localIterator.next();
      } while ((localObject3 == null) || (!TextUtils.equals(((TroopMemberInfo)localObject3).memberuin, (CharSequence)localObject2)));
      int i = 0;
      if (i != 0) {
        ThreadManager.executeOnNetWorkThread(new MessageForQQWalletTips.1.1(this, (String)localObject2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips.1
 * JD-Core Version:    0.7.0.1
 */