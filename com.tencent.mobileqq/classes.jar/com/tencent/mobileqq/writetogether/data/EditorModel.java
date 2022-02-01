package com.tencent.mobileqq.writetogether.data;

import android.text.TextUtils;
import com.tencent.mobileqq.easysync2.AText;
import com.tencent.mobileqq.easysync2.AttribPool;
import com.tencent.mobileqq.easysync2.Changeset;
import com.tencent.mobileqq.writetogether.client.IEditorController;
import com.tencent.mobileqq.writetogether.client.IPartChangeListener;
import com.tencent.mobileqq.writetogether.client.UserStateController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EditorModel
  implements IEditorModel
{
  private AText a;
  private AttribPool b;
  private CursorManager c;
  private IEditorController d;
  private IPartChangeListener e;
  private UserStateController f;
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private List<String> k = new ArrayList();
  private Map<String, Long> l = new TreeMap();
  private List<String> m = new ArrayList();
  private Map<String, String> n = new TreeMap();
  private DocMetaData o;
  private int p = 10000;
  private long q;
  private String r;
  private int s;
  
  public EditorModel(AText paramAText, AttribPool paramAttribPool, String paramString1, String paramString2)
  {
    this.a = paramAText;
    this.b = paramAttribPool;
    this.h = paramString1;
  }
  
  private void a(String paramString1, String paramString2)
  {
    boolean bool = this.h.equals(paramString1);
    if (!bool)
    {
      this.k.remove(paramString1);
      this.k.add(paramString1);
      this.m.remove(paramString1);
      this.m.add(paramString1);
      long l1 = p();
      this.l.put(paramString1, Long.valueOf(l1));
      b(this.k);
      b(this.m);
      localObject = this.e;
      if (localObject != null) {
        ((IPartChangeListener)localObject).a(this.g, this.k, true);
      }
    }
    this.r = paramString1;
    this.q = p();
    Object localObject = this.f;
    if (localObject != null)
    {
      if (!bool) {
        ((UserStateController)localObject).a();
      }
      this.f.a(this.p, this.a.a.length());
    }
    if (!bool) {
      this.c.c(paramString2);
    }
    this.c.a(paramString1, paramString2);
  }
  
  private void b(List<String> paramList)
  {
    Collections.sort(paramList, new EditorModel.1(this));
  }
  
  private void o()
  {
    if (this.e != null)
    {
      boolean bool;
      if (this.k.size() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      List localList;
      if (bool) {
        localList = this.k;
      } else {
        localList = this.m;
      }
      b(localList);
      IPartChangeListener localIPartChangeListener = this.e;
      String str = this.g;
      if (bool) {
        localList = this.k;
      } else {
        localList = this.m;
      }
      localIPartChangeListener.a(str, localList, bool);
    }
  }
  
  private long p()
  {
    return System.currentTimeMillis();
  }
  
  public List<UserEditInfo> a()
  {
    return this.c.a();
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    CursorManager localCursorManager = this.c;
    if (localCursorManager != null) {
      localCursorManager.a(paramInt1, paramInt2, false);
    }
  }
  
  public void a(long paramLong)
  {
    this.q = paramLong;
  }
  
  public void a(AText paramAText)
  {
    AText localAText = paramAText;
    if (paramAText == null) {
      localAText = new AText("", "");
    }
    this.a = localAText;
  }
  
  public void a(AttribPool paramAttribPool)
  {
    AttribPool localAttribPool = paramAttribPool;
    if (paramAttribPool == null) {
      localAttribPool = new AttribPool();
    }
    this.b = localAttribPool;
  }
  
  public void a(IEditorController paramIEditorController)
  {
    this.d = paramIEditorController;
  }
  
  public void a(IPartChangeListener paramIPartChangeListener)
  {
    this.e = paramIPartChangeListener;
  }
  
  public void a(UserStateController paramUserStateController)
  {
    this.f = paramUserStateController;
  }
  
  public void a(CursorManager paramCursorManager)
  {
    this.c = paramCursorManager;
  }
  
  public void a(DocMetaData paramDocMetaData)
  {
    this.o = paramDocMetaData;
    this.g = paramDocMetaData.a;
    this.q = paramDocMetaData.b;
    if ((this.q <= 0L) && (QLog.isColorLevel())) {
      QLog.e("EditorModel", 2, "metaData.mTime lt 0");
    }
    paramDocMetaData = this.f;
    if (paramDocMetaData != null) {
      paramDocMetaData.a();
    }
  }
  
  public void a(String paramString)
  {
    this.k.remove(paramString);
    o();
    this.c.b(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.c.a(paramString, paramInt1, paramInt2);
    if (!paramString.equals(this.h))
    {
      this.k.remove(paramString);
      this.k.add(paramString);
      long l1 = p();
      this.l.put(paramString, Long.valueOf(l1));
      o();
    }
  }
  
  public void a(String paramString, long paramLong, UserEditInfo paramUserEditInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      o();
      if (!paramUserEditInfo.a.equals(this.h)) {
        this.c.a(paramString, paramUserEditInfo);
      }
      return;
    }
    paramUserEditInfo = new StringBuilder();
    paramUserEditInfo.append("[addParticipant error] author: ");
    paramUserEditInfo.append(paramString);
    paramUserEditInfo.append(", aliveTimeSec: ");
    paramUserEditInfo.append(paramLong);
    QLog.e("EditorModel", 1, paramUserEditInfo.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.j = paramString1;
    this.h = paramString2;
    this.i = paramString3;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[new changeset] - notifyView: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", cs: ");
      localStringBuilder.append(paramString1);
      QLog.d("EditorModel", 2, localStringBuilder.toString());
    }
    this.a = Changeset.a(paramString1, this.a, this.b);
    if (paramBoolean) {
      this.d.a(this.a.a);
    }
    a(paramString2, paramString1);
  }
  
  public void a(List<EditUserHistory> paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditorModel", 2, "histories is null");
      }
      return;
    }
    if ((paramList.size() == 0) && (QLog.isColorLevel())) {
      QLog.d("EditorModel", 2, "histories size is 0");
    }
    this.m = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EditUserHistory localEditUserHistory = (EditUserHistory)paramList.next();
      if (localEditUserHistory != null)
      {
        String str = localEditUserHistory.a;
        long l1 = localEditUserHistory.b * 1000L;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[setEditUserHistory] uin: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", editTime: ");
          ((StringBuilder)localObject).append(l1);
          QLog.d("EditorModel", 2, ((StringBuilder)localObject).toString());
        }
        this.m.add(str);
        this.l.put(str, Long.valueOf(l1));
        Object localObject = this.n;
        if (localObject != null) {
          ((Map)localObject).put(str, localEditUserHistory.c);
        }
      }
    }
    b(this.m);
    if (this.m.size() != 0)
    {
      this.r = ((String)this.m.get(0));
      paramList = (Long)this.l.get(this.r);
      if (paramList != null) {
        this.q = paramList.longValue();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }
  
  public Pair<Integer, Integer> b()
  {
    return this.c.c();
  }
  
  public String b(String paramString)
  {
    Map localMap = this.n;
    if (localMap != null) {
      return (String)localMap.get(paramString);
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public AText c()
  {
    return this.a;
  }
  
  public void c(String paramString)
  {
    this.r = paramString;
  }
  
  public AttribPool d()
  {
    return this.b;
  }
  
  public CreateDocParam e()
  {
    CreateDocParam localCreateDocParam = new CreateDocParam();
    localCreateDocParam.e = this.a.a;
    localCreateDocParam.f = this.a.b;
    localCreateDocParam.d = this.b.b();
    return localCreateDocParam;
  }
  
  public void f()
  {
    IPartChangeListener localIPartChangeListener = this.e;
    if (localIPartChangeListener != null) {
      localIPartChangeListener.a(this.g, this.m, false);
    }
  }
  
  public DocMetaData g()
  {
    return this.o;
  }
  
  public int h()
  {
    return this.p;
  }
  
  public long i()
  {
    return this.q;
  }
  
  public String j()
  {
    return this.r;
  }
  
  public String k()
  {
    return this.h;
  }
  
  public String l()
  {
    return this.i;
  }
  
  public String m()
  {
    return this.j;
  }
  
  public int n()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.EditorModel
 * JD-Core Version:    0.7.0.1
 */