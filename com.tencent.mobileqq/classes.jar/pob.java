import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class pob
{
  private SparseArray<qcu> jdField_a_of_type_AndroidUtilSparseArray;
  public AbsListView.OnScrollListener a;
  private Set<ppj> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public pob()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new poc(this);
    this.jdField_a_of_type_JavaUtilSet.add(new psa());
  }
  
  private Object a(qdb paramqdb)
  {
    if (paramqdb == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    qcu localqcu;
    if (j < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      localqcu = (qcu)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(j);
      paramqdb.a(localqcu);
      if (paramqdb.a == null) {
        break label179;
      }
      if (localObject == null)
      {
        localObject = paramqdb.a;
        i = localqcu.a();
        paramqdb.a = null;
      }
    }
    label179:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("InvokeHandler", 2, new Object[] { "execute with return value handler job , id :%d, jobName :%s, cost :%ld ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(j)), paramqdb.a(), Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + localqcu.a());
      return localObject;
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      ppj localppj = (ppj)localIterator.next();
      if (localppj.a(paramBaseArticleInfo)) {
        localppj.a(paramBaseArticleInfo, paramInt);
      }
    }
  }
  
  private void a(qdb paramqdb)
  {
    if (paramqdb == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramqdb.a((qcu)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("InvokeHandler", 2, new Object[] { "execute handler job , id :%d, jobName :%s, cost :%ld", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)), paramqdb.a(), Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
  
  public SparseArray<qcu> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public Boolean a()
  {
    return (Boolean)a(new pos(this, "onBackPressed"));
  }
  
  public qcu a()
  {
    return a(2);
  }
  
  public qcu a(int paramInt)
  {
    return (qcu)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public qdc a()
  {
    return (qdc)a(0);
  }
  
  public void a()
  {
    a(new ppd(this, "onDestroy"));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(new pod(this, "onActivityResult", paramInt1, paramInt2, paramIntent));
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    a(new poo(this, "onChannelArticleLoaded", paramInt, paramList));
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, String paramString, int paramInt)
  {
    a(new pok(this, "onImageClick", paramContext, paramArticleInfo, paramString, paramInt));
  }
  
  public void a(SparseArray<qcu> paramSparseArray, szd paramszd)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i = 0;
    while (i < paramSparseArray.size())
    {
      ((qcu)paramSparseArray.valueAt(i)).a(paramszd);
      i += 1;
    }
  }
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    a(new pou(this, "onPostGetAdapterView", paramView1, paramView2, paramBaseArticleInfo, paramInt));
    a(paramBaseArticleInfo, paramInt);
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(new poj(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
  }
  
  public void a(View paramView, ListView paramListView)
  {
    a(new pox(this, "onListViewGroupInited", paramView, paramListView));
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(new pom(this, "onListViewGroupInit", paramView, paramListView, paramLong));
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    a(new pow(this, "OnDataChangedDrawCompletion", paramReadInJoyBaseListView));
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    a(new poi(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
  }
  
  public void a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = qda.a(paramReadInJoyBaseListViewGroup);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    a(new poy(this, "onScrollStateChanged", paramAbsListView, paramInt));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(new poz(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(new poq(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    a(new pot(this, "onSetData", paramList));
  }
  
  public void a(Map<Integer, rot> paramMap)
  {
    a(new ppa(this, "attachToViewGroup#1", paramMap));
  }
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean)
  {
    a(new ppc(this, "detachFromViewGroup", paramMap, paramBoolean));
  }
  
  public void a(Set<Long> paramSet, Map<Long, rot> paramMap)
  {
    a(new ppb(this, "attachToViewGroup#2", paramSet, paramMap));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a(new pon(this, "onBackToTop", paramBoolean, paramInt));
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    a(new poh(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public void b()
  {
    a(new poe(this, "onResume"));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    a(new pop(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public void c()
  {
    a(new pof(this, "onPause"));
  }
  
  public void d()
  {
    a(new pog(this, "onStart"));
  }
  
  public void e()
  {
    a(new pol(this, "onEndRefresh"));
  }
  
  public void f()
  {
    a(new por(this, "onListViewDrawFinished"));
  }
  
  public void g()
  {
    a(new pov(this, "onNotifyDataSetChange"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pob
 * JD-Core Version:    0.7.0.1
 */