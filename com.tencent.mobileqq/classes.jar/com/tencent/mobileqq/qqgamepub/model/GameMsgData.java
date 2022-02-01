package com.tencent.mobileqq.qqgamepub.model;

import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class GameMsgData
{
  byte[] a = new byte[0];
  private List<IHeaderView> b = new ArrayList();
  private List<QQGameMsgInfo> c = new ArrayList();
  
  public QQGameMsgInfo a(int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (paramInt < localList.size())) {
      return (QQGameMsgInfo)this.c.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, IHeaderView paramIHeaderView)
  {
    if (paramIHeaderView != null) {
      synchronized (this.a)
      {
        this.b.add(paramInt, paramIHeaderView);
        return;
      }
    }
  }
  
  public void a(List<QQGameMsgInfo> paramList)
  {
    this.c.clear();
    this.c.addAll(paramList);
  }
  
  public boolean a()
  {
    List localList = this.c;
    return (localList == null) || (localList.size() == 0);
  }
  
  public boolean a(IHeaderView paramIHeaderView)
  {
    return paramIHeaderView instanceof MoreMsgHeaderView;
  }
  
  public int b()
  {
    return this.c.size();
  }
  
  public IHeaderView b(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return (IHeaderView)this.b.get(paramInt);
    }
    return null;
  }
  
  public void b(List<IHeaderView> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public int c()
  {
    return this.b.size();
  }
  
  public boolean c(int paramInt)
  {
    return paramInt < this.b.size() - 1;
  }
  
  public List<QQGameMsgInfo> d()
  {
    return this.c;
  }
  
  public boolean d(int paramInt)
  {
    return paramInt == this.b.size() - 1;
  }
  
  public List<IHeaderView> e()
  {
    return this.b;
  }
  
  public boolean e(int paramInt)
  {
    return paramInt < this.b.size();
  }
  
  public void f()
  {
    if (this.b != null)
    {
      int i = 0;
      while (i < this.b.size())
      {
        if ((this.b.get(i) instanceof GameArkView))
        {
          ((GameArkView)this.b.get(i)).e();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("header destroy i=");
            localStringBuilder.append(i);
            QLog.d("GameMsgDataModel", 2, localStringBuilder.toString());
          }
        }
        i += 1;
      }
      this.b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.model.GameMsgData
 * JD-Core Version:    0.7.0.1
 */