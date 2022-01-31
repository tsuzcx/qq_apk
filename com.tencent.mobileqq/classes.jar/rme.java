import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.adapter.AssociatedAccountListAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class rme
  extends FriendListObserver
{
  public rme(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    boolean bool = false;
    paramBoolean = bool;
    Iterator localIterator;
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramBoolean = bool;
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        paramBoolean = false;
        label55:
        if (localIterator.hasNext())
        {
          if (!TextUtils.equals(paramString, ((SubAccountInfo)localIterator.next()).subuin)) {
            break label224;
          }
          paramBoolean = true;
        }
      }
    }
    label129:
    label221:
    label224:
    for (;;)
    {
      break label55;
      bool = paramBoolean;
      if (this.a.b != null)
      {
        bool = paramBoolean;
        if (this.a.b.size() > 0)
        {
          localIterator = this.a.b.iterator();
          if (localIterator.hasNext())
          {
            if (!TextUtils.equals(paramString, ((SimpleAccount)localIterator.next()).getUin())) {
              break label221;
            }
            paramBoolean = true;
          }
        }
      }
      for (;;)
      {
        break label129;
        bool = paramBoolean;
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "onUpdateCustomHead uin = " + paramString + " needUpdate=" + bool);
        }
        if (!bool) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter.notifyDataSetInvalidated();
        return;
      }
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onUpdateFriendInfo  uin = " + paramString + " isSuccess = " + paramBoolean);
    }
    Iterator localIterator = this.a.c.iterator();
    paramBoolean = false;
    label66:
    Object localObject3;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject3 = (AssociatedAccountListItemData)localIterator.next();
      if ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_Int == 2) && (((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject != null) && ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)))
      {
        bool = paramBoolean;
        if (paramString.equals(((SubAccountInfo)((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject).subuin))
        {
          localObject2 = ContactUtils.c(this.a.app, paramString, true);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = paramString;
          }
          bool = paramBoolean;
          if (!((String)localObject1).equals(((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangString))
          {
            ((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
            bool = true;
          }
        }
      }
    }
    for (paramBoolean = bool;; paramBoolean = bool)
    {
      break label66;
      bool = paramBoolean;
      if (((AssociatedAccountListItemData)localObject3).jdField_a_of_type_Int == 5)
      {
        bool = paramBoolean;
        if (((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject != null)
        {
          bool = paramBoolean;
          if ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject instanceof ArrayList))
          {
            localObject1 = ((ArrayList)((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject).iterator();
            for (;;)
            {
              bool = paramBoolean;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (AssociatedAccountListItemData)((Iterator)localObject1).next();
              localObject3 = (SimpleAccount)((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject;
              if (paramString.equals(((SimpleAccount)localObject3).getUin()))
              {
                localObject3 = SubAccountControll.a(this.a.app, (SimpleAccount)localObject3);
                if (!((String)localObject3).equals(((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangString))
                {
                  ((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
                  paramBoolean = true;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("AssociatedAccountActivity", 2, "onUpdateFriendInfo needUpdate = " + paramBoolean);
            }
            if (!paramBoolean) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter.notifyDataSetInvalidated();
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rme
 * JD-Core Version:    0.7.0.1
 */