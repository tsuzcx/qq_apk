package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileManager.FileManagerStatus;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TroopFileShowAdapter
  extends BaseAdapter
  implements Handler.Callback, TroopFileObserver, TroopFileItem.OnItemSelectedListener, AbsListView.OnScrollListener
{
  public static String a = "TroopFileExpandableListAdapter<QFile>";
  public Handler b;
  public String c = "";
  public long d = 0L;
  public int e = 0;
  public int f = 0;
  private long g;
  private QQAppInterface h;
  private Context i;
  private int j = 0;
  private List<TroopFileInfo> k = new ArrayList();
  private Map<UUID, TroopFileItem> l = new HashMap();
  private TroopFileManager m;
  private TroopFileTransferManager n;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r;
  private boolean s;
  private ITroopFileViewBinder t;
  private List<TroopFileInfo> u = new ArrayList(20);
  private TroopFileItem.OnItemSelectedListener v = null;
  
  public TroopFileShowAdapter(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.g = paramLong;
    this.i = paramContext;
    this.c = paramString;
    this.j = paramInt;
    this.h = paramQQAppInterface;
    this.b = new Handler(this);
    this.n = TroopFileTransferManager.a(this.h, this.g);
    this.m = TroopFileManager.a(this.h, this.g);
    paramQQAppInterface = this.m;
    paramQQAppInterface.l = this.c;
    if (!paramQQAppInterface.a(this)) {
      this.m.registerObserver(this);
    }
  }
  
  private List<TroopFileInfo> a(List<TroopFileInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return paramList;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramList.next();
        if ((TextUtils.isEmpty(localTroopFileInfo.c)) || (!localTroopFileInfo.c.contains("online_doc_folder_"))) {
          localArrayList.add(localTroopFileInfo);
        }
      }
      return localArrayList;
    }
    return paramList;
  }
  
  public void a()
  {
    Object localObject = this.t;
    int i1 = 0;
    int i2;
    if (localObject != null)
    {
      i1 = ((ITroopFileViewBinder)localObject).a();
      i2 = this.t.b();
    }
    else
    {
      i2 = 0;
    }
    while (i1 <= i2 - 1)
    {
      if (i1 >= this.k.size()) {
        return;
      }
      localObject = (TroopFileInfo)this.k.get(i1);
      if (localObject != null)
      {
        localObject = (TroopFileItem)this.l.get(((TroopFileInfo)localObject).b);
        if (localObject != null)
        {
          ((TroopFileItem)localObject).b(this.g, this.h);
          ((TroopFileItem)localObject).a(this.g, this.h);
        }
      }
      i1 += 1;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(this.i);
    int i1 = 0;
    if ((bool) && (this.m.a(paramInt1, this.c, this.d))) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    Object localObject1 = this.m.h;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(this.d);
    localObject2 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((TroopFileManager.FileManagerStatus)localObject2).g;
    }
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (!bool)
      {
        b(0);
        a((List)localObject1, true, paramInt2, true);
      }
    }
    else
    {
      if (bool)
      {
        if (paramInt1 != 0) {
          paramInt1 = i1;
        } else {
          paramInt1 = 2;
        }
        b(paramInt1);
        return;
      }
      b(1);
      TroopFileUtils.b(this.h, this.g);
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo.p != 2)
    {
      if (paramTroopFileInfo.p == 3) {
        return;
      }
      int i2 = this.k.size();
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)this.m.f.get(paramTroopFileInfo.o);
      int i1 = 0;
      Object localObject;
      while (i1 < i2)
      {
        if ((this.k.get(i1) != null) && (((TroopFileInfo)this.k.get(i1)).c.equals(paramTroopFileInfo.c)))
        {
          localObject = this.m.h;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.c);
          localStringBuilder.append(this.d);
          localObject = (TroopFileManager.FileManagerStatus)((Map)localObject).get(localStringBuilder.toString());
          if (localObject != null)
          {
            if ((((TroopFileManager.FileManagerStatus)localObject).g == null) || (((TroopFileManager.FileManagerStatus)localObject).h == null)) {
              break;
            }
            ((TroopFileManager.FileManagerStatus)localObject).h.remove(((TroopFileInfo)this.k.get(i1)).c);
            if (i1 < ((TroopFileManager.FileManagerStatus)localObject).g.size())
            {
              paramTroopFileInfo = (TroopFileInfo)((TroopFileManager.FileManagerStatus)localObject).g.remove(i1);
              if ((paramTroopFileInfo != null) && (paramTroopFileInfo.p != 12) && (localTroopFileInfo != null)) {
                localTroopFileInfo.C -= 1;
              }
              if ((paramTroopFileInfo != null) && (paramTroopFileInfo.p != 12)) {
                ((TroopFileManager.FileManagerStatus)localObject).f = null;
              }
              this.r = false;
              a(((TroopFileManager.FileManagerStatus)localObject).g, ((TroopFileManager.FileManagerStatus)localObject).c, 0, false);
              break;
            }
            paramTroopFileInfo = a;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("<TroopFile> onDelete remove has err.index>size");
            ((StringBuilder)localObject).append(i1);
            QLog.e(paramTroopFileInfo, 1, ((StringBuilder)localObject).toString());
            break;
          }
        }
        i1 += 1;
      }
      if ((localTroopFileInfo != null) && ("/".equals(this.c)) && (this.d == 0L) && (localTroopFileInfo.B))
      {
        localTroopFileInfo.b((int)NetConnInfoCenter.getServerTime());
        paramTroopFileInfo = this.m.h;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localTroopFileInfo.o);
        ((StringBuilder)localObject).append(this.d);
        paramTroopFileInfo = (TroopFileManager.FileManagerStatus)paramTroopFileInfo.get(((StringBuilder)localObject).toString());
        if (paramTroopFileInfo != null)
        {
          if (paramTroopFileInfo.g != null)
          {
            paramTroopFileInfo.g.remove(localTroopFileInfo);
            paramTroopFileInfo.g.add(0, localTroopFileInfo);
          }
          paramTroopFileInfo.f = null;
          a(paramTroopFileInfo.g, paramTroopFileInfo.c, 0, false);
        }
      }
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString)
  {
    if (paramTroopFileInfo == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    int i2;
    int i1;
    if (this.c.equals("/"))
    {
      localObject1 = this.m.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(this.d);
      localObject1 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      if (localObject1 != null)
      {
        if (((TroopFileManager.FileManagerStatus)localObject1).g == null) {
          return;
        }
        localObject2 = (TroopFileInfo)this.m.f.get(paramString);
        if ((localObject2 != null) && (((TroopFileInfo)localObject2).B))
        {
          ((TroopFileInfo)localObject2).C += 1;
          ((TroopFileInfo)localObject2).b((int)NetConnInfoCenter.getServerTime());
          i2 = this.k.size();
          i1 = 0;
          while (i1 < i2)
          {
            if (localObject2 == this.k.get(i1))
            {
              ((TroopFileManager.FileManagerStatus)localObject1).g.remove(i1);
              break;
            }
            i1 += 1;
          }
          ((TroopFileManager.FileManagerStatus)localObject1).g.add(0, localObject2);
          ((TroopFileManager.FileManagerStatus)localObject1).f = null;
          a(((TroopFileManager.FileManagerStatus)localObject1).g, ((TroopFileManager.FileManagerStatus)localObject1).c, 0, false);
        }
      }
      else
      {
        return;
      }
    }
    if (this.c.equals(paramString))
    {
      localObject1 = this.m.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(this.d);
      paramString = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      if (paramString != null)
      {
        if (paramString.g == null) {
          return;
        }
        boolean bool = paramString.c;
        i2 = this.k.size();
        i1 = 0;
        while (i1 < i2)
        {
          if ((!((TroopFileInfo)this.k.get(i1)).B) && (paramTroopFileInfo.d() >= ((TroopFileInfo)this.k.get(i1)).d()))
          {
            paramString.g.add(i1, paramTroopFileInfo);
            paramString.h.put(paramTroopFileInfo.c, paramTroopFileInfo);
            a(paramString.g, paramString.c, 0, false);
            break;
          }
          if ((i1 == i2 - 1) && (bool))
          {
            paramString.g.add(paramTroopFileInfo);
            paramString.h.put(paramTroopFileInfo.c, paramTroopFileInfo);
            a(paramString.g, paramString.c, 0, false);
          }
          i1 += 1;
        }
        paramString.f = null;
      }
    }
  }
  
  public void a(ITroopFileViewBinder paramITroopFileViewBinder)
  {
    this.t = paramITroopFileViewBinder;
  }
  
  public void a(TroopFileItem.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.v = paramOnItemSelectedListener;
  }
  
  public void a(List<TroopFileInfo> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramList == null) {
      return;
    }
    this.l.clear();
    this.k.clear();
    this.k.addAll(a(paramList));
    if (paramList.size() == 0)
    {
      if ("/".equals(this.c))
      {
        b(3);
        return;
      }
      b(6);
      return;
    }
    this.r = false;
    notifyDataSetChanged();
    b(4);
    if ((paramBoolean1) && (this.m.a(this.c, this.d)))
    {
      paramList = this.t;
      if (paramList != null) {
        paramList.d(7);
      }
    }
  }
  
  public void a(List<TroopFileInfo> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if (this.c.equals(paramString))
    {
      if (this.d != paramLong) {
        return;
      }
      if (paramList == null)
      {
        paramList = this.t;
        if (paramList != null) {
          paramList.d(3);
        }
        FMToastUtil.a(2131895327);
        if (this.k.isEmpty()) {
          b(1);
        }
        return;
      }
      paramString = this.t;
      if (paramString != null) {
        paramString.d(4);
      }
      a(paramList, paramBoolean, 0, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if (!paramBoolean)
    {
      List localList = this.u;
      if (localList != null) {
        localList.clear();
      }
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, TroopFileInfo paramTroopFileInfo)
  {
    if (this.u == null) {
      return;
    }
    if (paramTroopFileInfo == null) {
      QLog.i(a, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean)
    {
      if (!this.u.contains(paramTroopFileInfo)) {
        this.u.add(paramTroopFileInfo);
      }
    }
    else {
      this.u.remove(paramTroopFileInfo);
    }
    TroopFileItem.OnItemSelectedListener localOnItemSelectedListener = this.v;
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.a(paramBoolean, paramTroopFileInfo);
    }
    notifyDataSetChanged();
  }
  
  public List<TroopFileInfo> b()
  {
    return this.u;
  }
  
  protected void b(int paramInt)
  {
    ITroopFileViewBinder localITroopFileViewBinder = this.t;
    if (localITroopFileViewBinder != null) {
      localITroopFileViewBinder.c(paramInt);
    }
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo == null) {
      return;
    }
    int i1 = paramTroopFileInfo.p;
    if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      if (i1 != 12)
      {
        if ((this.c.equals(paramTroopFileInfo.o)) || (this.d != 0L))
        {
          TroopFileItem localTroopFileItem = (TroopFileItem)this.l.get(paramTroopFileInfo.b);
          if (localTroopFileItem != null)
          {
            if (!localTroopFileItem.m.b.equals(paramTroopFileInfo.b)) {
              return;
            }
            localTroopFileItem.m = paramTroopFileInfo;
            localTroopFileItem.a(this.g, this.i, this.h, this.o);
          }
        }
        else
        {
          paramTroopFileInfo = (TroopFileInfo)this.m.f.get(paramTroopFileInfo.o);
          if (paramTroopFileInfo != null)
          {
            paramTroopFileInfo = (TroopFileItem)this.l.get(paramTroopFileInfo.b);
            if (paramTroopFileInfo == null) {
              return;
            }
            paramTroopFileInfo.a(this.g, this.i, this.h, this.o);
          }
        }
        return;
      }
      if (this.l.remove(paramTroopFileInfo.b) != null)
      {
        this.r = false;
        notifyDataSetChanged();
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((TroopFileManager)localObject).unregisterObserver(this);
    }
    localObject = this.u;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  public void c(TroopFileInfo paramTroopFileInfo) {}
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    if ((paramTroopFileInfo.A) && (paramTroopFileInfo.p == 6))
    {
      Object localObject1 = (TroopFileInfo)this.m.f.get(paramTroopFileInfo.o);
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if ((localObject1 != null) && (this.c.equals(((TroopFileInfo)localObject1).o)) && (((TroopFileInfo)localObject1).B))
      {
        localObject2 = this.m.h;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((TroopFileInfo)localObject1).o);
        ((StringBuilder)localObject3).append(this.d);
        localObject2 = (TroopFileManager.FileManagerStatus)((Map)localObject2).get(((StringBuilder)localObject3).toString());
        if (localObject2 != null)
        {
          if (((TroopFileManager.FileManagerStatus)localObject2).g == null) {
            return;
          }
          if (TextUtils.isEmpty(paramTroopFileInfo.c())) {
            if (paramTroopFileInfo.g == 0L)
            {
              localObject3 = this.h;
              localObject4 = ((QQAppInterface)localObject3).getCurrentAccountUin();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(this.g);
              localStringBuilder.append("");
              paramTroopFileInfo.n = ContactUtils.a((QQAppInterface)localObject3, (String)localObject4, localStringBuilder.toString(), 1, 0);
            }
            else
            {
              paramTroopFileInfo.c(this.h, this.g);
            }
          }
          ((TroopFileManager.FileManagerStatus)localObject2).g.remove(localObject1);
          ((TroopFileInfo)localObject1).b(paramTroopFileInfo.d());
          ((TroopFileInfo)localObject1).C += 1;
          ((TroopFileManager.FileManagerStatus)localObject2).g.add(0, localObject1);
          a(((TroopFileManager.FileManagerStatus)localObject2).g, ((TroopFileManager.FileManagerStatus)localObject2).c, 0, false);
          ((TroopFileManager.FileManagerStatus)localObject2).f = null;
        }
        else
        {
          return;
        }
      }
      if (this.c.equals(paramTroopFileInfo.o))
      {
        localObject1 = this.m.h;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramTroopFileInfo.o);
        ((StringBuilder)localObject2).append(this.d);
        localObject1 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
        if (localObject1 != null)
        {
          if (((TroopFileManager.FileManagerStatus)localObject1).g == null) {
            return;
          }
          boolean bool = ((TroopFileManager.FileManagerStatus)localObject1).c;
          int i2 = this.k.size();
          if (TextUtils.isEmpty(paramTroopFileInfo.c())) {
            if (paramTroopFileInfo.g == 0L)
            {
              localObject2 = this.h;
              localObject3 = ((QQAppInterface)localObject2).getCurrentAccountUin();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(this.g);
              ((StringBuilder)localObject4).append("");
              paramTroopFileInfo.n = ContactUtils.a((QQAppInterface)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString(), 1, 0);
            }
            else
            {
              paramTroopFileInfo.c(this.h, this.g);
            }
          }
          if (this.k.size() == 0)
          {
            ((TroopFileManager.FileManagerStatus)localObject1).g.add(paramTroopFileInfo);
            ((TroopFileManager.FileManagerStatus)localObject1).h.put(paramTroopFileInfo.c, paramTroopFileInfo);
          }
          int i1 = 0;
          while (i1 < i2)
          {
            if ((!((TroopFileInfo)this.k.get(i1)).B) && (paramTroopFileInfo.d() >= ((TroopFileInfo)this.k.get(i1)).d()))
            {
              ((TroopFileManager.FileManagerStatus)localObject1).g.add(i1, paramTroopFileInfo);
              ((TroopFileManager.FileManagerStatus)localObject1).h.put(paramTroopFileInfo.c, paramTroopFileInfo);
              notifyDataSetChanged();
              break;
            }
            if ((i1 == i2 - 1) && (bool))
            {
              ((TroopFileManager.FileManagerStatus)localObject1).g.add(paramTroopFileInfo);
              ((TroopFileManager.FileManagerStatus)localObject1).h.put(paramTroopFileInfo.c, paramTroopFileInfo);
            }
            i1 += 1;
          }
          ((TroopFileManager.FileManagerStatus)localObject1).f = null;
          a(((TroopFileManager.FileManagerStatus)localObject1).g, ((TroopFileManager.FileManagerStatus)localObject1).c, 0, false);
        }
        return;
      }
      this.r = false;
    }
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    if ((paramTroopFileInfo.B) && ("/".equals(this.c)) && (this.d == 0L))
    {
      paramTroopFileInfo.b = UUID.randomUUID();
      this.m.e.put(paramTroopFileInfo.b, paramTroopFileInfo);
      this.m.f.put(paramTroopFileInfo.c, paramTroopFileInfo);
      Object localObject = this.m.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.d);
      localObject = (TroopFileManager.FileManagerStatus)((Map)localObject).get(localStringBuilder.toString());
      if (localObject != null)
      {
        if ((((TroopFileManager.FileManagerStatus)localObject).g != null) && (((TroopFileManager.FileManagerStatus)localObject).h != null))
        {
          ((TroopFileManager.FileManagerStatus)localObject).g.add(0, paramTroopFileInfo);
          ((TroopFileManager.FileManagerStatus)localObject).h.put(paramTroopFileInfo.c, paramTroopFileInfo);
        }
        this.m.f.put(paramTroopFileInfo.c, paramTroopFileInfo);
        a(((TroopFileManager.FileManagerStatus)localObject).g, ((TroopFileManager.FileManagerStatus)localObject).c, 0, false);
        ((TroopFileManager.FileManagerStatus)localObject).f = null;
      }
    }
  }
  
  public boolean f(TroopFileInfo paramTroopFileInfo)
  {
    List localList = this.u;
    if ((localList != null) && (!localList.isEmpty())) {
      return this.u.contains(paramTroopFileInfo);
    }
    return false;
  }
  
  public int getCount()
  {
    return this.k.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.k.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = this.k.size();
    boolean bool = true;
    if (paramInt >= i1)
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getView: error. position[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("] fileListSize[");
      ((StringBuilder)localObject2).append(this.k.size());
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    TroopFileInfo localTroopFileInfo = (TroopFileInfo)this.k.get(paramInt);
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramView == null)
    {
      localObject2 = new TroopFileItem(this.h, this.i, this.g, 2131627089, this.j);
      ((TroopFileItem)localObject2).a(this);
      paramView = ((TroopFileItem)localObject2).l;
      if (paramView == null)
      {
        localObject2 = paramView;
        break label314;
      }
      paramView.setTag(localObject2);
      localObject1 = localObject2;
    }
    else
    {
      Object localObject3 = paramView.getTag();
      localObject1 = localObject2;
      if ((localObject3 instanceof TroopFileItem)) {
        localObject1 = (TroopFileItem)localObject3;
      }
    }
    this.l.put(localTroopFileInfo.b, localObject1);
    if (localObject1 != null)
    {
      ((TroopFileItem)localObject1).m = localTroopFileInfo;
      ((TroopFileItem)localObject1).a(this.s);
      ((TroopFileItem)localObject1).a(this.g, this.h);
      if ((!this.s) || (!f(localTroopFileInfo))) {
        bool = false;
      }
      ((TroopFileItem)localObject1).b(bool);
      ((TroopFileItem)localObject1).a(this.g, this.i, this.h, this.o);
    }
    localObject2 = paramView;
    localObject1 = paramView;
    label314:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    if (this.p)
    {
      this.o = false;
      a();
    }
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt3;
    this.e = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.p = true;
      QLog.e(a, 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      this.b.sendEmptyMessageDelayed(1, 1000L);
      if (this.e == this.f - 2)
      {
        paramAbsListView = this.m;
        if (paramAbsListView != null) {
          if (paramAbsListView.a(this.c, this.d))
          {
            paramAbsListView = this.t;
            if (paramAbsListView != null) {
              paramAbsListView.d(8);
            }
          }
          else
          {
            this.t.d(7);
            if (TroopFileUtils.a(this.h, this.i, this.g) != 0) {
              this.m.b(this.c, this.d);
            }
          }
        }
      }
    }
    else
    {
      this.p = false;
      this.o = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileShowAdapter
 * JD-Core Version:    0.7.0.1
 */