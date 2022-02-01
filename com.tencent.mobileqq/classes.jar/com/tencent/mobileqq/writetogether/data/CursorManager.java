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
  private List<UserEditInfo> a = new ArrayList();
  private boolean b;
  private UserEditInfo c;
  private CursorManager.OnMyCursorIndexChangeListener d;
  
  public CursorManager(UserEditInfo paramUserEditInfo, List<UserEditInfo> paramList)
  {
    this.c = paramUserEditInfo;
    this.a = paramList;
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
        if (paramInt == localUserEditInfo.f)
        {
          localUserEditInfo.e = true;
          localArrayList.add(localUserEditInfo);
        }
        else if (localUserEditInfo.j)
        {
          localUserEditInfo.e = false;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(UserEditInfo paramUserEditInfo)
  {
    if (!paramUserEditInfo.j)
    {
      paramUserEditInfo.e = true;
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
        localUserEditInfo.e = false;
      }
      i += 1;
    }
    paramList2 = (UserEditInfo)paramList2.get(paramInt - 1);
    if (paramList2 != null)
    {
      localUserEditInfo = new UserEditInfo(paramList2);
      localUserEditInfo.h = true;
      localUserEditInfo.e = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramList2.b);
      localStringBuilder.append((String)localObject);
      localUserEditInfo.b = localStringBuilder.toString();
      paramList1.add(localUserEditInfo);
    }
  }
  
  private void b(UserEditInfo paramUserEditInfo)
  {
    int i = this.a.indexOf(paramUserEditInfo);
    if (i != -1)
    {
      paramUserEditInfo = this.a;
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
      if ((localUserEditInfo != null) && (localUserEditInfo.h)) {
        localArrayList.add(localUserEditInfo);
      }
      i += 1;
    }
    paramList.removeAll(localArrayList);
  }
  
  protected UserEditInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new UserEditInfo();
    }
    ArrayList localArrayList = new ArrayList(this.a);
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
      if ((localObject1 != null) && (paramString.equals(((UserEditInfo)localObject1).a))) {
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
  
  public List<UserEditInfo> a()
  {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    UserEditInfo localUserEditInfo = this.c;
    localUserEditInfo.f = paramInt1;
    localUserEditInfo.g = paramInt2;
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
    localObject = this.d;
    if (localObject != null)
    {
      ((CursorManager.OnMyCursorIndexChangeListener)localObject).f();
      if (paramBoolean) {
        this.d.a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(CursorManager.OnMyCursorIndexChangeListener paramOnMyCursorIndexChangeListener)
  {
    this.d = paramOnMyCursorIndexChangeListener;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramString);
    if (TextUtils.isEmpty(((UserEditInfo)localObject).a))
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
    ((UserEditInfo)localObject).f = paramInt1;
    ((UserEditInfo)localObject).g = paramInt2;
    ((UserEditInfo)localObject).i = -1.0F;
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
    a(b().f, b().g, false);
  }
  
  public void a(String paramString, UserEditInfo paramUserEditInfo)
  {
    if (!TextUtils.isEmpty(a(paramString).a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CursorManager", 2, "[addUserEditInfo] editInfo exists");
      }
      return;
    }
    this.a.add(paramUserEditInfo);
  }
  
  public void a(String paramString1, String paramString2)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      UserEditInfo localUserEditInfo = (UserEditInfo)localList.get(i);
      int j = localUserEditInfo.f;
      int k = localUserEditInfo.g;
      Object localObject1 = null;
      try
      {
        if (paramString1.equals(localUserEditInfo.a)) {
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
        localUserEditInfo.f = localObject1[0];
        localUserEditInfo.g = localObject1[1];
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public UserEditInfo b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CursorManager", 2, "[removeEditInfo] editInfo not exists");
      }
      return;
    }
    this.a.remove(paramString);
    a(b().f, b().g, false);
  }
  
  public Pair<Integer, Integer> c()
  {
    return new Pair(Integer.valueOf(this.c.f), Integer.valueOf(this.c.g));
  }
  
  public void c(String paramString)
  {
    paramString = Changeset.a(paramString, b().f, b().g, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.CursorManager
 * JD-Core Version:    0.7.0.1
 */