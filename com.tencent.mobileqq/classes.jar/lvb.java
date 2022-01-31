import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.Model;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.PicInfo;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class lvb
  extends BaseAdapter
{
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  String jdField_b_of_type_JavaLangString;
  List jdField_b_of_type_JavaUtilList;
  
  public lvb()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public lvb(ComponentContentGridImage.Model paramModel)
  {
    a(paramModel);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(ComponentContentGridImage.Model paramModel)
  {
    this.jdField_b_of_type_JavaUtilList = paramModel.a();
    this.jdField_a_of_type_JavaUtilList = paramModel.b();
    this.jdField_a_of_type_JavaLangString = paramModel.a();
    this.jdField_b_of_type_JavaLangString = paramModel.b();
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
      ((SquareCornerTextImageView)paramView).a((SquareCornerTextImageView.PicInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvb
 * JD-Core Version:    0.7.0.1
 */