import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class rgi
  extends BaseAdapter
{
  String jdField_a_of_type_JavaLangString;
  List<URL> jdField_a_of_type_JavaUtilList;
  String jdField_b_of_type_JavaLangString;
  List<teh> jdField_b_of_type_JavaUtilList;
  
  public rgi(ComponentContentGridImage paramComponentContentGridImage, rgj paramrgj)
  {
    a(paramrgj);
  }
  
  private int a()
  {
    int i = AIOUtils.dp2px(82.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage.getResources());
    int j = getCount();
    if ((j == 2) || (j == 4)) {
      i = AIOUtils.dp2px(116.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage.getResources());
    }
    return i;
  }
  
  private <T> List<T> a(List<T> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    int i = Math.min(paramList.size(), paramInt);
    paramInt = 0;
    while (paramInt < i)
    {
      localArrayList.add(paramList.get(paramInt));
      paramInt += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_b_of_type_JavaUtilList = a(this.jdField_b_of_type_JavaUtilList, 3);
  }
  
  private int b()
  {
    int i = AIOUtils.dp2px(116.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage.getResources());
    int j = getCount();
    if ((j == 2) || (j == 4)) {
      i = AIOUtils.dp2px(175.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage.getResources());
    }
    return i;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<URL> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(rgj paramrgj)
  {
    this.jdField_b_of_type_JavaUtilList = paramrgj.a();
    this.jdField_a_of_type_JavaUtilList = paramrgj.b();
    this.jdField_a_of_type_JavaLangString = paramrgj.a();
    this.jdField_b_of_type_JavaLangString = paramrgj.b();
    a();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Context localContext = paramViewGroup.getContext();
    if (paramView == null) {
      paramView = new SquareCornerTextImageView(localContext);
    }
    for (;;)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, a()));
      ((SquareCornerTextImageView)paramView).a((teh)this.jdField_b_of_type_JavaUtilList.get(paramInt), ((URL)this.jdField_a_of_type_JavaUtilList.get(paramInt)).toString(), b(), a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage.a(paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgi
 * JD-Core Version:    0.7.0.1
 */