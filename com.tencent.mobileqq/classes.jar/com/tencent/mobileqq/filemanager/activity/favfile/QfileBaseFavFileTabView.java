package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class QfileBaseFavFileTabView
  extends QfileBaseTabView
{
  static String a = "QfileBaseFavFileTabView<FileAssistant>";
  static String b = "FavFileS ";
  protected LinkedHashMap<String, List<FavFileInfo>> c = new LinkedHashMap();
  protected QfilePinnedHeaderExpandableListView d;
  protected QfileBaseExpandableListAdapter e;
  protected NoFileRelativeLayout f;
  protected LayoutInflater g;
  protected QfileFavFileRecordProvider h;
  protected int i = 0;
  protected QfileBaseFavFileTabView.GetMoreRequest j = new QfileBaseFavFileTabView.GetMoreRequest();
  protected QfileFavFileRecordProvider.EventObserver k = new QfileBaseFavFileTabView.1(this);
  protected volatile boolean l = false;
  protected volatile boolean m = false;
  protected QfileBaseFavFileTabView.ITabBarViewProxy n;
  
  public QfileBaseFavFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext);
    this.h = paramQfileFavFileRecordProvider;
    this.h.addObserver(this.k);
    this.n = paramITabBarViewProxy;
  }
  
  private void s()
  {
    this.d = ((QfilePinnedHeaderExpandableListView)findViewById(2131433125));
    this.f = new NoFileRelativeLayout(getActivity());
    this.d.addHeaderView(this.f);
    p();
    this.f.setText(2131889274);
    this.e = getQfileFavFileBaseExpandableListAdapter();
    this.e.a(this.d);
    this.d.setAdapter(this.e);
    this.d.setFocusable(false);
    this.d.setSelector(2131168376);
    this.d.setTranscriptMode(0);
    int i1 = 0;
    while (i1 < this.e.getGroupCount())
    {
      this.d.expandGroup(i1);
      i1 += 1;
    }
    this.d.smoothScrollToPosition(0);
    this.d.setStackFromBottom(false);
    this.d.setTranscriptMode(0);
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(new QfileBaseFavFileTabView.3(this));
  }
  
  protected abstract String a(FavFileInfo paramFavFileInfo);
  
  public void a()
  {
    setContentView(2131627054);
    this.g = LayoutInflater.from(getActivity());
    s();
    o();
    new Handler(Looper.getMainLooper()).post(new QfileBaseFavFileTabView.2(this));
  }
  
  void a(int paramInt)
  {
    if (this.j.a) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("startGetMoreFileRecord. targertCount:");
    localStringBuilder.append(paramInt);
    QLog.i(str, 1, localStringBuilder.toString());
    e();
    this.j.a(this.i, paramInt);
    this.h.b();
  }
  
  protected void a(Bundle paramBundle)
  {
    if (getVisibility() != 0) {
      return;
    }
    i();
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.m = true;
    this.n.setRefreshedFavList(true);
    if (getVisibility() != 0) {
      return;
    }
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b);
    ((StringBuilder)localObject2).append("onFileRecordsRefreshed suc:");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(". recordType:");
    ((StringBuilder)localObject2).append(getFileRecordType());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = getSourceData();
    int i1 = this.i;
    int i3 = ((List)localObject1).size();
    int i2 = 0;
    StringBuilder localStringBuilder;
    if (i1 != i3)
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append("onFileRecordsRefreshed. updateTabView");
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
      if (this.i == 0) {
        i1 = 0;
      } else {
        i1 = -1;
      }
      c(i1);
    }
    if (paramBundle != null) {
      paramBundle = paramBundle.getString("delete_favids");
    } else {
      paramBundle = "";
    }
    localObject2 = new ArrayList();
    if (!TextUtils.isEmpty(paramBundle))
    {
      try
      {
        paramBundle = paramBundle.split(",");
        i3 = paramBundle.length;
        i1 = i2;
        while (i1 < i3)
        {
          localStringBuilder = paramBundle[i1];
          if (!TextUtils.isEmpty(localStringBuilder)) {
            ((ArrayList)localObject2).add(Long.valueOf(Long.valueOf(localStringBuilder).longValue()));
          }
          i1 += 1;
        }
        if (((ArrayList)localObject2).size() <= 0) {
          break label328;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    else
    {
      paramBundle = ((ArrayList)localObject2).iterator();
      while (paramBundle.hasNext()) {
        FMDataCache.b(((Long)paramBundle.next()).longValue());
      }
      C();
    }
    label328:
    if ((((List)localObject1).size() < getOnceShowCount()) && (!q())) {
      a(getOnceShowCount() - ((List)localObject1).size());
    }
  }
  
  public void b()
  {
    super.b();
    m();
    this.c.clear();
    this.h.deleteObserver(this.k);
    this.h = null;
    g();
    this.l = true;
  }
  
  protected void b(int paramInt)
  {
    if (!this.j.a) {
      return;
    }
    int i2 = 0;
    int i1 = 0;
    if (paramInt != 0)
    {
      g();
      if (getVisibility() == 0)
      {
        localObject1 = getSourceData();
        if (this.i != ((List)localObject1).size())
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(b);
          ((StringBuilder)localObject2).append("onGettedFileRecords err. updateTabView");
          QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          if (this.i == 0) {
            paramInt = i1;
          } else {
            paramInt = -1;
          }
          c(paramInt);
        }
      }
      return;
    }
    Object localObject1 = getSourceData();
    Object localObject2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("onGettedFileRecords. gettedSize:");
    localStringBuilder.append(((List)localObject1).size());
    localStringBuilder.append(" isEnd:");
    localStringBuilder.append(q());
    localStringBuilder.append(" curShowSize:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(this.j.c());
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    if ((!q()) && (((List)localObject1).size() - this.j.b < this.j.c))
    {
      if (this.j.b())
      {
        localObject2 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b);
        localStringBuilder.append("onGettedFileRecords. continue get.");
        localStringBuilder.append(this.j.c());
        QLog.i((String)localObject2, 1, localStringBuilder.toString());
        this.h.b();
        this.j.a(((List)localObject1).size());
      }
      else
      {
        g();
      }
    }
    else {
      g();
    }
    if ((getVisibility() == 0) && (((this.i == 0) && (q())) || (this.i != ((List)localObject1).size())))
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(b);
      ((StringBuilder)localObject2).append("onGettedFileRecords. updateTabView");
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if (this.i == 0) {
        paramInt = i2;
      } else {
        paramInt = -1;
      }
      c(paramInt);
    }
  }
  
  protected void c(int paramInt)
  {
    this.c.clear();
    List localList = getSourceData();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FavFileInfo localFavFileInfo = (FavFileInfo)localIterator.next();
      String str = a(localFavFileInfo);
      if (!this.c.containsKey(str)) {
        this.c.put(str, new ArrayList());
      }
      ((List)this.c.get(str)).add(localFavFileInfo);
    }
    this.i = localList.size();
    i();
    if (paramInt >= 0) {
      setSelect(paramInt);
    }
  }
  
  public void ci_()
  {
    List localList = getSourceData();
    if ((localList != null) && (localList.size() > 0))
    {
      this.c.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FavFileInfo localFavFileInfo = (FavFileInfo)localIterator.next();
        String str = a(localFavFileInfo);
        if (!this.c.containsKey(str)) {
          this.c.put(str, new ArrayList());
        }
        ((List)this.c.get(str)).add(localFavFileInfo);
      }
      this.i = localList.size();
      i();
      return;
    }
    this.c.clear();
    i();
  }
  
  protected void e() {}
  
  protected void f() {}
  
  protected void g()
  {
    this.j.a();
    f();
  }
  
  protected abstract int getFileRecordType();
  
  public int getFootHeight()
  {
    return 0;
  }
  
  public ListView getListView()
  {
    return this.d;
  }
  
  protected void getMoreFileRecord()
  {
    a(getOnceShowCount());
  }
  
  protected abstract int getOnceShowCount();
  
  protected abstract QfileBaseExpandableListAdapter getQfileFavFileBaseExpandableListAdapter();
  
  protected List<FavFileInfo> getSourceData()
  {
    return this.h.a(getFileRecordType());
  }
  
  protected boolean h()
  {
    return this.j.a;
  }
  
  public void i()
  {
    a(new QfileBaseFavFileTabView.4(this));
  }
  
  public void j()
  {
    if (this.l) {
      return;
    }
    this.C.b(this.C.D());
    setEditbarButton(false, true, false, true, true);
  }
  
  protected void k()
  {
    if (this.l) {
      return;
    }
    this.c.clear();
    List localList = getSourceData();
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FavFileInfo)((Iterator)localObject1).next();
      String str = a((FavFileInfo)localObject2);
      if (!this.c.containsKey(str)) {
        this.c.put(str, new ArrayList());
      }
      ((List)this.c.get(str)).add(localObject2);
    }
    this.i = localList.size();
    i();
    setSelect(0);
    localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b);
    ((StringBuilder)localObject2).append("-> initGetRecentFileRecords. curSize:");
    ((StringBuilder)localObject2).append(localList.size());
    ((StringBuilder)localObject2).append(" OnceShowSize:");
    ((StringBuilder)localObject2).append(getOnceShowCount());
    ((StringBuilder)localObject2).append(" isEnd:");
    ((StringBuilder)localObject2).append(q());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (!this.n.a())
    {
      this.h.a(null);
      return;
    }
    this.m = true;
  }
  
  public void m()
  {
    super.m();
  }
  
  public void n()
  {
    if (this.l) {
      return;
    }
    this.C.b(this.C.D());
    List localList = getSourceData();
    if (this.i != localList.size())
    {
      int i1;
      if (this.i == 0) {
        i1 = 0;
      } else {
        i1 = -1;
      }
      c(i1);
    }
    if ((this.m) && (localList.size() < getOnceShowCount()) && (!q())) {
      a(getOnceShowCount() - localList.size());
    }
  }
  
  protected void o()
  {
    this.d.setWhetherImageTab(false);
  }
  
  protected void p()
  {
    int i1 = this.C.getWindow().getDecorView().getHeight() / 2;
    this.f.setLayoutParams(this.d.getWidth(), i1);
  }
  
  public boolean q()
  {
    return this.h.a();
  }
  
  protected void r()
  {
    LinkedHashMap localLinkedHashMap = this.c;
    if ((localLinkedHashMap != null) && (localLinkedHashMap.size() != 0))
    {
      this.f.setGone();
    }
    else if (q())
    {
      this.f.setText(2131889282);
      this.f.setVisible(true);
    }
    else
    {
      this.f.setText(2131889274);
      this.f.setVisible(true);
    }
    this.e.notifyDataSetChanged();
  }
  
  public void setSelect(int paramInt)
  {
    if (this.e.getGroupCount() <= paramInt)
    {
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSelect[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("] faild,becouse GroupCount[");
        localStringBuilder.append(this.e.getGroupCount());
        localStringBuilder.append("]");
        QLog.e(str, 1, localStringBuilder.toString());
      }
      return;
    }
    a(new QfileBaseFavFileTabView.5(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
 * JD-Core Version:    0.7.0.1
 */