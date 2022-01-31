import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class oya
{
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private rap jdField_a_of_type_Rap;
  
  public abstract int a();
  
  public final Activity a()
  {
    return this.jdField_a_of_type_Rap.a();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public AnimationSet a()
  {
    return this.jdField_a_of_type_Rap.a();
  }
  
  public final baxk a()
  {
    return this.jdField_a_of_type_Rap.a();
  }
  
  public ReadInJoyBaseListViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public AbsListView a()
  {
    if (this.jdField_a_of_type_Rap != null) {
      return this.jdField_a_of_type_Rap.a();
    }
    return null;
  }
  
  public Boolean a()
  {
    return null;
  }
  
  public Integer a(int paramInt)
  {
    return Integer.valueOf(this.jdField_a_of_type_Rap.getItemViewType(paramInt));
  }
  
  public final Object a(int paramInt)
  {
    return this.jdField_a_of_type_Rap.getItem(paramInt);
  }
  
  public final rap a()
  {
    return this.jdField_a_of_type_Rap;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void a(View paramView, ListView paramListView) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public final void a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = paramReadInJoyBaseListViewGroup;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void a(List<BaseArticleInfo> paramList) {}
  
  public void a(Map<Integer, qar> paramMap) {}
  
  public void a(Map<Long, qar> paramMap, boolean paramBoolean) {}
  
  public void a(Set<Long> paramSet, Map<Long, qar> paramMap) {}
  
  public final void a(rap paramrap)
  {
    this.jdField_a_of_type_Rap = paramrap;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Rap.c;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Rap.a();
  }
  
  public void b() {}
  
  public void b(View paramView, ListView paramListView) {}
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public int c()
  {
    return this.jdField_a_of_type_Rap.b();
  }
  
  public void c() {}
  
  public final int d()
  {
    return this.jdField_a_of_type_Rap.getCount();
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oya
 * JD-Core Version:    0.7.0.1
 */