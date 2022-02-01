package com.tencent.mobileqq.writetogether.data;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.easysync2.Changeset;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CursorManager
{
  private CursorManager.OnMyCursorIndexChangeListener jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager$OnMyCursorIndexChangeListener;
  private UserEditInfo jdField_a_of_type_ComTencentMobileqqWritetogetherDataUserEditInfo;
  private List<UserEditInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public CursorManager(UserEditInfo paramUserEditInfo, List<UserEditInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataUserEditInfo = paramUserEditInfo;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  @NonNull
  private List<UserEditInfo> a(int paramInt, List<UserEditInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      UserEditInfo localUserEditInfo = (UserEditInfo)paramList.get(i);
      if (localUserEditInfo != null)
      {
        if (paramInt != localUserEditInfo.jdField_c_of_type_Int) {
          break label70;
        }
        localUserEditInfo.jdField_a_of_type_Boolean = true;
        localArrayList.add(localUserEditInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label70:
        if (localUserEditInfo.jdField_c_of_type_Boolean) {
          localUserEditInfo.jdField_a_of_type_Boolean = false;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(UserEditInfo paramUserEditInfo)
  {
    if (!paramUserEditInfo.jdField_c_of_type_Boolean)
    {
      paramUserEditInfo.jdField_a_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CursorManager.1(this, paramUserEditInfo), 2000L);
    }
  }
  
  private void a(List<UserEditInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      int i = 0;
      while (i < paramList.size())
      {
        QLog.d("CursorManager", 2, "[updateMyEditInfo] info: " + ((UserEditInfo)paramList.get(i)).toString());
        i += 1;
      }
    }
  }
  
  private void a(List<UserEditInfo> paramList1, List<UserEditInfo> paramList2, int paramInt)
  {
    String str = "等" + paramInt + "人";
    int i = 0;
    UserEditInfo localUserEditInfo;
    while (i < paramInt)
    {
      localUserEditInfo = (UserEditInfo)paramList2.get(i);
      if (localUserEditInfo != null) {
        localUserEditInfo.jdField_a_of_type_Boolean = false;
      }
      i += 1;
    }
    paramList2 = (UserEditInfo)paramList2.get(paramInt - 1);
    if (paramList2 != null)
    {
      localUserEditInfo = new UserEditInfo(paramList2);
      localUserEditInfo.jdField_b_of_type_Boolean = true;
      localUserEditInfo.jdField_a_of_type_Boolean = true;
      paramList2.jdField_b_of_type_JavaLangString += str;
      paramList1.add(localUserEditInfo);
    }
  }
  
  private void b(UserEditInfo paramUserEditInfo)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramUserEditInfo);
    if (i != -1) {
      Collections.swap(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList.size() - 1, i);
    }
  }
  
  private void b(List<UserEditInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      UserEditInfo localUserEditInfo = (UserEditInfo)paramList.get(i);
      if ((localUserEditInfo != null) && (localUserEditInfo.jdField_b_of_type_Boolean)) {
        localArrayList.add(localUserEditInfo);
      }
      i += 1;
    }
    paramList.removeAll(localArrayList);
  }
  
  public UserEditInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataUserEditInfo;
  }
  
  protected UserEditInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new UserEditInfo();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    int i = 0;
    label32:
    if (i < localArrayList.size())
    {
      localObject = (UserEditInfo)localArrayList.get(i);
      if ((localObject == null) || (!paramString.equals(((UserEditInfo)localObject).jdField_a_of_type_JavaLangString))) {}
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localObject = paramString;
      if (paramString != null) {
        break;
      }
      return new UserEditInfo();
      i += 1;
      break label32;
    }
  }
  
  public Pair<Integer, Integer> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataUserEditInfo.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataUserEditInfo.d));
  }
  
  public List<UserEditInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataUserEditInfo.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataUserEditInfo.d = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2);
    List localList1 = a();
    b(localList1);
    List localList2 = a(paramInt1, localList1);
    a(localList1);
    int i = localList2.size();
    if (i > 1) {
      a(localList1, localList2, i);
    }
    a(localList1);
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager$OnMyCursorIndexChangeListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager$OnMyCursorIndexChangeListener.c();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager$OnMyCursorIndexChangeListener.a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(CursorManager.OnMyCursorIndexChangeListener paramOnMyCursorIndexChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager$OnMyCursorIndexChangeListener = paramOnMyCursorIndexChangeListener;
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CursorManager", 2, "[removeEditInfo] editInfo not exists");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    a(a().jdField_c_of_type_Int, a().d, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    UserEditInfo localUserEditInfo = a(paramString);
    if (TextUtils.isEmpty(localUserEditInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("CursorManager", 2, "[updateUserCursorSelection] uin: " + paramString + " not in EditInfo");
      }
      return;
    }
    a(localUserEditInfo);
    localUserEditInfo.jdField_c_of_type_Int = paramInt1;
    localUserEditInfo.d = paramInt2;
    localUserEditInfo.jdField_a_of_type_Float = -1.0F;
    b(localUserEditInfo);
    if (QLog.isColorLevel()) {
      QLog.d("CursorManager", 2, "[updateUserCursorSelection] update cursor uin: " + paramString + ", start: " + paramInt1 + ", end: " + paramInt2);
    }
    a(a().jdField_c_of_type_Int, a().d, false);
  }
  
  public void a(String paramString, UserEditInfo paramUserEditInfo)
  {
    if (!TextUtils.isEmpty(a(paramString).jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CursorManager", 2, "[addUserEditInfo] editInfo exists");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramUserEditInfo);
  }
  
  public void a(String paramString1, String paramString2)
  {
    List localList = a();
    int i = 0;
    int j;
    int k;
    if (i < localList.size())
    {
      UserEditInfo localUserEditInfo = (UserEditInfo)localList.get(i);
      j = localUserEditInfo.jdField_c_of_type_Int;
      k = localUserEditInfo.d;
      Object localObject = null;
      for (;;)
      {
        try
        {
          if (paramString1.equals(localUserEditInfo.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          bool = true;
          int[] arrayOfInt = Changeset.a(paramString2, j, k, bool);
          localObject = arrayOfInt;
        }
        catch (Throwable localThrowable)
        {
          boolean bool;
          QLog.e("CursorManager", 1, "[updateOtherSelectionByPushChangeset] cs: " + paramString2 + ", oldStart: " + j + ", oldEnd, " + k);
          continue;
        }
        if ((localObject != null) && (localObject.length == 2))
        {
          localUserEditInfo.jdField_c_of_type_Int = localObject[0];
          localUserEditInfo.d = localObject[1];
        }
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(String paramString)
  {
    paramString = Changeset.a(paramString, a().jdField_c_of_type_Int, a().d, true);
    int i = paramString[0];
    int j = paramString[1];
    a(i, j, true);
    if (QLog.isColorLevel()) {
      QLog.d("CursorManager", 2, "[updateMySelectionByPushChangeset] after range follow, curStart: " + i + ", curEnd: " + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.CursorManager
 * JD-Core Version:    0.7.0.1
 */