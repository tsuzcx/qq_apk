import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.List;

public class pvk
  extends BaseAdapter
{
  String jdField_a_of_type_JavaLangString;
  List<URL> jdField_a_of_type_JavaUtilList;
  String jdField_b_of_type_JavaLangString;
  List<rib> jdField_b_of_type_JavaUtilList;
  
  public pvk(ComponentContentGridImage paramComponentContentGridImage, pvl parampvl)
  {
    a(parampvl);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<URL> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(pvl parampvl)
  {
    this.jdField_b_of_type_JavaUtilList = parampvl.a();
    this.jdField_a_of_type_JavaUtilList = parampvl.b();
    this.jdField_a_of_type_JavaLangString = parampvl.a();
    this.jdField_b_of_type_JavaLangString = parampvl.b();
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
    paramViewGroup = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramView = new SquareCornerTextImageView(paramViewGroup);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }
    for (;;)
    {
      ((SquareCornerTextImageView)paramView).a((rib)this.jdField_b_of_type_JavaUtilList.get(paramInt));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage.a(paramView);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvk
 * JD-Core Version:    0.7.0.1
 */