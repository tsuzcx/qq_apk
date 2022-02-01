package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.UUID;

public class TroopFileSearchResultModel
  extends ISearchResultModel
{
  private QQAppInterface a;
  private Context b;
  private String c;
  private TroopFileSearchItemData d;
  private CharSequence e;
  private CharSequence f;
  
  public TroopFileSearchResultModel(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TroopFileSearchItemData paramTroopFileSearchItemData)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.d = paramTroopFileSearchItemData;
    this.c = paramString;
    m();
  }
  
  private CharSequence a(TroopFileInfo paramTroopFileInfo)
  {
    ArrayList localArrayList = this.d.e;
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (this.d.e.size() > 0)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramTroopFileInfo.d))
        {
          localObject1 = localObject2;
          if (paramTroopFileInfo.d.toLowerCase().contains("".toLowerCase())) {
            localObject1 = (String)this.d.e.get(0);
          }
        }
      }
    }
    localObject2 = paramTroopFileInfo.d;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = SearchUtils.a(paramTroopFileInfo.d, (String)localObject1);
    }
    return localObject2;
  }
  
  private void m()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
    String str2 = "";
    long l1 = ((TroopFileSearchItemData)localObject1).a;
    long l2 = this.d.c;
    long l3 = this.d.f;
    TroopFileInfo localTroopFileInfo = this.d.i;
    localObject1 = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).g(String.valueOf(l1), String.valueOf(l2));
    int i;
    if ((localObject1 != null) && (ContactUtils.a(((TroopMemberInfo)localObject1).troopnick, String.valueOf(l3)))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      str1 = ((TroopMemberInfo)localObject1).troopnick;
    } else {
      str1 = null;
    }
    Object localObject2;
    if (this.d.f > 0L)
    {
      localObject3 = String.valueOf(this.d.f);
      TroopFileSearchManager localTroopFileSearchManager = TroopFileSearchManager.a();
      localObject1 = localTroopFileSearchManager.a((String)localObject3);
      if (localObject1 != null)
      {
        i = TroopFileSearchManager.a(this.c, str1, this.d.g, ((ContactSearchableFriend)localObject1).c, ((ContactSearchableFriend)localObject1).d, this.d.h, ((ContactSearchableFriend)localObject1).a, ((ContactSearchableFriend)localObject1).b);
        str1 = TroopFileSearchManager.a(str1, this.d.g, this.d.h, i);
      }
      else
      {
        i = TroopFileSearchManager.a(this.c, str1, this.d.g, null, null, this.d.h, null, null);
        str1 = TroopFileSearchManager.a(str1, this.d.g, this.d.h, i);
      }
      if (TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(this.d.g))
        {
          localObject1 = this.d.h;
          localObject2 = str2;
        }
        else
        {
          localObject1 = this.d.g;
          localObject2 = str2;
        }
      }
      else if ((i != 1) && (i != 4) && (i != 7))
      {
        if ((i != 5) && (i != 6) && (i != 2))
        {
          localObject1 = str1;
          localObject2 = str2;
          if (i != 3) {}
        }
        else
        {
          localObject2 = localTroopFileSearchManager.a(this.c, (String)localObject3);
          localObject1 = str1;
        }
      }
      else
      {
        localObject2 = this.c;
        localObject1 = str1;
      }
    }
    else
    {
      if (i == 0) {
        str1 = this.d.d;
      }
      localObject1 = str1;
      localObject2 = str2;
      if (this.d.e != null)
      {
        localObject1 = str1;
        localObject2 = str2;
        if (this.d.e.size() > 0)
        {
          localObject3 = (String)this.d.e.get(0);
          localObject1 = str1;
          localObject2 = str2;
          if (!TextUtils.isEmpty(str1))
          {
            localObject1 = str1;
            localObject2 = str2;
            if (str1.toLowerCase().contains(((String)localObject3).toLowerCase()))
            {
              localObject2 = localObject3;
              localObject1 = str1;
            }
          }
        }
      }
    }
    String str1 = localTroopFileInfo.a();
    str2 = localTroopFileInfo.E;
    Object localObject3 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject3).append(str2).append("  ");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((SpannableStringBuilder)localObject3).append(SearchUtils.a((String)localObject1, (String)localObject2)).append("  ");
    } else {
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1).append("  ");
    }
    ((SpannableStringBuilder)localObject3).append(str1);
    this.f = ((CharSequence)localObject3);
    this.e = a(localTroopFileInfo);
  }
  
  public CharSequence a()
  {
    return this.f;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(View paramView)
  {
    Object localObject = TroopFileTransferManager.a(this.a, this.d.a);
    TroopFileInfo localTroopFileInfo = this.d.i;
    TroopFileStatusInfo localTroopFileStatusInfo = ((TroopFileTransferManager)localObject).a(localTroopFileInfo.c);
    localObject = localTroopFileStatusInfo;
    if (localTroopFileStatusInfo == null)
    {
      localObject = TroopFileUtils.a(this.a, this.d.a, localTroopFileInfo.b.toString(), localTroopFileInfo.c, localTroopFileInfo.d, localTroopFileInfo.e, localTroopFileInfo.f);
      ((TroopFileStatusInfo)localObject).m = localTroopFileInfo.x;
      ((TroopFileStatusInfo)localObject).n = localTroopFileInfo.y;
      ((TroopFileStatusInfo)localObject).l = localTroopFileInfo.w;
    }
    if ((localObject != null) && (((TroopFileStatusInfo)localObject).i == 0L)) {
      ((TroopFileStatusInfo)localObject).i = localTroopFileInfo.e;
    }
    int i = FileManagerUtil.c(((TroopFileStatusInfo)localObject).t);
    if ((i != 0) && (i != 2))
    {
      QFileUtils.a(this.a, this.b, null, (TroopFileStatusInfo)localObject, localTroopFileInfo.n, localTroopFileInfo.j, 4, false);
      return;
    }
    paramView = QFileUtils.a(paramView.findViewById(2131433103), localTroopFileInfo.d);
    QFileUtils.a(this.a, this.b, null, null, this.d.a, (TroopFileStatusInfo)localObject, localTroopFileInfo.n, localTroopFileInfo.j, 2, 4, paramView, false, false);
  }
  
  public int b()
  {
    return 0;
  }
  
  public String c()
  {
    return null;
  }
  
  public int ck_()
  {
    return 0;
  }
  
  public int cl_()
  {
    return 0;
  }
  
  public CharSequence d()
  {
    return this.e;
  }
  
  public CharSequence e()
  {
    return null;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public String i()
  {
    Object localObject1 = TroopFileTransferManager.a(this.a, this.d.a);
    Object localObject2 = this.d.i;
    TroopFileStatusInfo localTroopFileStatusInfo = ((TroopFileTransferManager)localObject1).a(((TroopFileInfo)localObject2).c);
    if (localTroopFileStatusInfo != null)
    {
      localObject1 = localTroopFileStatusInfo.l;
    }
    else
    {
      ((TroopFileTransferManager)localObject1).a(((TroopFileInfo)localObject2).b, 128);
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject1)) {
      localObject2 = this.d.i.w;
    }
    return localObject2;
  }
  
  public String j()
  {
    if (this.d.i != null) {
      return this.d.i.d;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchResultModel
 * JD-Core Version:    0.7.0.1
 */