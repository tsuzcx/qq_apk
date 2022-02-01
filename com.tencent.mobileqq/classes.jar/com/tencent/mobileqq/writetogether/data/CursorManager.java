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
    while (i < paramList.size())
    {
      UserEditInfo localUserEditInfo = (UserEditInfo)paramList.get(i);
      if (localUserEditInfo != null) {
        if (paramInt == localUserEditInfo.jdField_c_of_type_Int)
        {
          localUserEditInfo.jdField_a_of_type_Boolean = true;
          localArrayList.add(localUserEditInfo);
        }
        else if (localUserEditInfo.jdField_c_of_type_Boolean)
        {
          localUserEditInfo.jdField_a_of_type_Boolean = false;
        }
      }
      i += 1;
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[updateMyEditInfo] info: ");
        localStringBuilder.append(((UserEditInfo)paramList.get(i)).toString());
        QLog.d("CursorManager", 2, localStringBuilder.toString());
        i += 1;
      }
    }
  }
  
  private void a(List<UserEditInfo> paramList1, List<UserEditInfo> paramList2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("等");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("人");
    localObject = ((StringBuilder)localObject).toString();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramList2.jdField_b_of_type_JavaLangString);
      localStringBuilder.append((String)localObject);
      localUserEditInfo.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      paramList1.add(localUserEditInfo);
    }
  }
  
  private void b(UserEditInfo paramUserEditInfo)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramUserEditInfo);
    if (i != -1)
    {
      paramUserEditInfo = this.jdField_a_of_type_JavaUtilList;
      Collections.swap(paramUserEditInfo, paramUserEditInfo.size() - 1, i);
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
    if (TextUtils.isEmpty(paramString)) {
      return new UserEditInfo();
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= localArrayList.size()) {
        break;
      }
      localObject1 = (UserEditInfo)localArrayList.get(i);
      if ((localObject1 != null) && (paramString.equals(((UserEditInfo)localObject1).jdField_a_of_type_JavaLangString))) {
        break;
      }
      i += 1;
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new UserEditInfo();
    }
    return paramString;
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
    UserEditInfo localUserEditInfo = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataUserEditInfo;
    localUserEditInfo.jdField_c_of_type_Int = paramInt1;
    localUserEditInfo.d = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2);
    Object localObject = a();
    b((List)localObject);
    List localList = a(paramInt1, (List)localObject);
    a((List)localObject);
    int i = localList.size();
    if (i > 1) {
      a((List)localObject, localList, i);
    }
    a((List)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager$OnMyCursorIndexChangeListener;
    if (localObject != null)
    {
      ((CursorManager.OnMyCursorIndexChangeListener)localObject).c();
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
    Object localObject = a(paramString);
    if (TextUtils.isEmpty(((UserEditInfo)localObject).jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[updateUserCursorSelection] uin: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" not in EditInfo");
        QLog.e("CursorManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    a((UserEditInfo)localObject);
    ((UserEditInfo)localObject).jdField_c_of_type_Int = paramInt1;
    ((UserEditInfo)localObject).d = paramInt2;
    ((UserEditInfo)localObject).jdField_a_of_type_Float = -1.0F;
    b((UserEditInfo)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[updateUserCursorSelection] update cursor uin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", start: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", end: ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("CursorManager", 2, ((StringBuilder)localObject).toString());
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
    while (i < localList.size())
    {
      UserEditInfo localUserEditInfo = (UserEditInfo)localList.get(i);
      int j = localUserEditInfo.jdField_c_of_type_Int;
      int k = localUserEditInfo.d;
      Object localObject1 = null;
      try
      {
        if (paramString1.equals(localUserEditInfo.jdField_a_of_type_JavaLangString)) {
          break label196;
        }
        bool = true;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          continue;
          boolean bool = false;
        }
      }
      localObject2 = Changeset.a(paramString2, j, k, bool);
      localObject1 = localObject2;
      break label153;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[updateOtherSelectionByPushChangeset] cs: ");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(", oldStart: ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(", oldEnd, ");
      ((StringBuilder)localObject2).append(k);
      QLog.e("CursorManager", 1, ((StringBuilder)localObject2).toString());
      label153:
      if ((localObject1 != null) && (localObject1.length == 2))
      {
        localUserEditInfo.jdField_c_of_type_Int = localObject1[0];
        localUserEditInfo.d = localObject1[1];
      }
      i += 1;
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
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[updateMySelectionByPushChangeset] after range follow, curStart: ");
      paramString.append(i);
      paramString.append(", curEnd: ");
      paramString.append(j);
      QLog.d("CursorManager", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.CursorManager
 * JD-Core Version:    0.7.0.1
 */