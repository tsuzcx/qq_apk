package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.easysync2.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Iterator;

public class ChangesetTracker
  implements IChangesetTracker
{
  protected AttribPool a;
  protected AText b = Changeset.b("\n", null);
  protected String c;
  protected String d = Changeset.b(1);
  private boolean e = false;
  private boolean f = false;
  private EditorCallback g;
  private UserChangeCallback h;
  
  public ChangesetTracker(AttribPool paramAttribPool, EditorCallback paramEditorCallback)
  {
    this.a = paramAttribPool;
    this.g = paramEditorCallback;
  }
  
  @NonNull
  private String a(String paramString, Changeset paramChangeset)
  {
    paramChangeset = Changeset.d(paramChangeset.e);
    MergingOpAssembler localMergingOpAssembler = new MergingOpAssembler();
    while (paramChangeset.hasNext())
    {
      Operation localOperation = (Operation)paramChangeset.next();
      if (localOperation.a == '+')
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = localOperation.d.split("\\*");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!Utils.a(str))
          {
            Pair localPair = this.a.a(Integer.parseInt(str, Changeset.a));
            if (localPair != null) {
              if ("author".equals(localPair.first))
              {
                localStringBuilder.append('*');
                localStringBuilder.append(paramString);
              }
              else
              {
                localStringBuilder.append('*');
                localStringBuilder.append(str);
              }
            }
          }
          i += 1;
        }
        localOperation.d = localStringBuilder.toString();
      }
      localMergingOpAssembler.a(localOperation);
    }
    localMergingOpAssembler.b();
    return localMergingOpAssembler.toString();
  }
  
  private String c(String paramString)
  {
    Object localObject1 = "";
    int i = 0;
    while (i < this.a.a.size())
    {
      int j = this.a.a.keyAt(i);
      Pair localPair = (Pair)this.a.a.get(j);
      Object localObject2 = localObject1;
      if (((String)localPair.first).equals("author"))
      {
        localObject2 = localObject1;
        if (((String)localPair.second).equals(paramString)) {
          localObject2 = Integer.toString(j, Changeset.a);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void a()
  {
    if (!Utils.a(this.c))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WriteTogether applying committed changeset: ");
        localStringBuilder.append(this.c);
        QLog.i("ChangesetTracker", 2, localStringBuilder.toString());
      }
      this.b = Changeset.a(this.c, this.b, this.a);
      this.c = null;
      return;
    }
    throw new IllegalStateException("applySubmittedChangesToBase: no submitted changes to apply");
  }
  
  public void a(AText paramAText, String paramString)
  {
    this.e = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WriteTogether|setBaseAttributedText: ");
      ((StringBuilder)localObject).append(paramAText.a);
      QLog.i("ChangesetTracker", 2, ((StringBuilder)localObject).toString());
    }
    this.b = Changeset.a(paramAText);
    if (!Utils.a(paramString))
    {
      paramString = AttribPool.a(paramString);
      localObject = this.b;
      ((AText)localObject).b = Changeset.a(((AText)localObject).b, paramString, this.a);
    }
    this.c = null;
    this.d = Changeset.b(paramAText.a.length());
    this.f = true;
    try
    {
      this.g.a(paramAText);
      return;
    }
    finally
    {
      this.f = false;
    }
  }
  
  public void a(UserChangeCallback paramUserChangeCallback)
  {
    this.h = paramUserChangeCallback;
  }
  
  public void a(String paramString)
  {
    if (!this.e) {
      return;
    }
    if (this.f) {
      return;
    }
    if (Changeset.h(paramString)) {
      return;
    }
    this.d = Changeset.b(this.d, paramString, this.a);
    paramString = this.h;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void a(String paramString1, String paramString2, AttribPool paramAttribPool)
  {
    if (!this.e) {
      return;
    }
    String str = paramString1;
    if (paramAttribPool != null) {
      str = Changeset.a(paramString1, paramAttribPool, this.a);
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("WriteTogether|applyChangesToBase: ");
      paramString1.append(this.b.a);
      QLog.i("ChangesetTracker", 2, paramString1.toString());
    }
    this.b = Changeset.a(str, this.b, this.a);
    paramString1 = str;
    if (!Utils.a(this.c))
    {
      paramString1 = this.c;
      this.c = Changeset.b(str, paramString1, false, this.a);
      paramString1 = Changeset.b(paramString1, str, true, this.a);
    }
    paramAttribPool = this.d;
    this.d = Changeset.b(paramString1, paramAttribPool, true, this.a);
    paramString1 = Changeset.b(paramAttribPool, paramString1, false, this.a);
    this.f = true;
    try
    {
      this.g.a(paramString1, true, paramString2);
      return;
    }
    finally
    {
      this.f = false;
    }
  }
  
  public UserChangeData b(String paramString)
  {
    boolean bool = Utils.a(this.c);
    AttribPool localAttribPool = null;
    if (!bool)
    {
      paramString = Changeset.b(this.c, this.d, this.a);
    }
    else
    {
      if (this.a.a != null)
      {
        str = c(paramString);
        paramString = Changeset.e(this.d);
        str = a(str, paramString);
        this.d = Changeset.a(paramString.c, paramString.d, str, paramString.f);
        Changeset.a(this.d);
      }
      if (Changeset.h(this.d)) {
        paramString = null;
      } else {
        paramString = this.d;
      }
    }
    if (!Utils.a(paramString))
    {
      this.c = paramString;
      this.d = Changeset.b(Changeset.c(paramString));
    }
    else
    {
      paramString = null;
    }
    String str = paramString;
    if (!Utils.a(paramString))
    {
      paramString = Changeset.a(paramString, this.a);
      localAttribPool = paramString.b;
      str = paramString.a;
    }
    return new UserChangeData(str, localAttribPool);
  }
  
  public boolean b()
  {
    return (!Utils.a(this.c)) || (!Changeset.h(this.d));
  }
  
  public boolean c()
  {
    return Utils.a(this.c) ^ true;
  }
  
  public AttribPool d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.ChangesetTracker
 * JD-Core Version:    0.7.0.1
 */