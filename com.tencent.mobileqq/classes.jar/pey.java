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
import java.util.List;
import java.util.Map;
import java.util.Set;

public class pey
{
  private SparseArray<prx> a;
  public AbsListView.OnScrollListener a;
  
  public pey()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new pez(this);
  }
  
  private Object a(pse parampse)
  {
    if (parampse == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    prx localprx;
    if (j < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      localprx = (prx)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(j);
      parampse.a(localprx);
      if (parampse.a == null) {
        break label179;
      }
      if (localObject == null)
      {
        localObject = parampse.a;
        i = localprx.a();
        parampse.a = null;
      }
    }
    label179:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("InvokeHandler", 2, new Object[] { "execute with return value handler job , id :%d, jobName :%s, cost :%ld ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(j)), parampse.a(), Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + localprx.a());
      return localObject;
    }
  }
  
  private void a(pse parampse)
  {
    if (parampse == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampse.a((prx)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("InvokeHandler", 2, new Object[] { "execute handler job , id :%d, jobName :%s, cost :%ld", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)), parampse.a(), Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
  
  public SparseArray<prx> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public Boolean a()
  {
    return (Boolean)a(new pfp(this, "onBackPressed"));
  }
  
  public prx a()
  {
    return a(2);
  }
  
  public prx a(int paramInt)
  {
    return (prx)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public psf a()
  {
    return (psf)a(0);
  }
  
  public void a()
  {
    a(new pga(this, "onDestroy"));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(new pfa(this, "onActivityResult", paramInt1, paramInt2, paramIntent));
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    a(new pfl(this, "onChannelArticleLoaded", paramInt, paramList));
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, String paramString, int paramInt)
  {
    a(new pfh(this, "onImageClick", paramContext, paramArticleInfo, paramString, paramInt));
  }
  
  public void a(SparseArray<prx> paramSparseArray, slt paramslt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i = 0;
    while (i < paramSparseArray.size())
    {
      ((prx)paramSparseArray.valueAt(i)).a(paramslt);
      i += 1;
    }
  }
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    a(new pfr(this, "onPostGetAdapterView", paramView1, paramView2, paramBaseArticleInfo, paramInt));
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(new pfg(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
  }
  
  public void a(View paramView, ListView paramListView)
  {
    a(new pfu(this, "onListViewGroupInited", paramView, paramListView));
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(new pfj(this, "onListViewGroupInit", paramView, paramListView, paramLong));
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    a(new pft(this, "OnDataChangedDrawCompletion", paramReadInJoyBaseListView));
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    a(new pff(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
  }
  
  public void a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = psd.a(paramReadInJoyBaseListViewGroup);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    a(new pfv(this, "onScrollStateChanged", paramAbsListView, paramInt));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(new pfw(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(new pfn(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    a(new pfq(this, "onSetData", paramList));
  }
  
  public void a(Map<Integer, rcn> paramMap)
  {
    a(new pfx(this, "attachToViewGroup#1", paramMap));
  }
  
  public void a(Map<Long, rcn> paramMap, boolean paramBoolean)
  {
    a(new pfz(this, "detachFromViewGroup", paramMap, paramBoolean));
  }
  
  public void a(Set<Long> paramSet, Map<Long, rcn> paramMap)
  {
    a(new pfy(this, "attachToViewGroup#2", paramSet, paramMap));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a(new pfk(this, "onBackToTop", paramBoolean, paramInt));
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    a(new pfe(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public void b()
  {
    a(new pfb(this, "onResume"));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    a(new pfm(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public void c()
  {
    a(new pfc(this, "onPause"));
  }
  
  public void d()
  {
    a(new pfd(this, "onStart"));
  }
  
  public void e()
  {
    a(new pfi(this, "onEndRefresh"));
  }
  
  public void f()
  {
    a(new pfo(this, "onListViewDrawFinished"));
  }
  
  public void g()
  {
    a(new pfs(this, "onNotifyDataSetChange"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pey
 * JD-Core Version:    0.7.0.1
 */