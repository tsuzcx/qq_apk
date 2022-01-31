import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.PicInfo;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class lsu
  extends BaseAdapter
{
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  List b = new ArrayList();
  
  public lsu(NativeGridImageView paramNativeGridImageView) {}
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(lsv paramlsv)
  {
    this.b = paramlsv.a();
    this.jdField_a_of_type_JavaUtilList = paramlsv.b();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
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
      ((SquareCornerTextImageView)paramView).a((SquareCornerTextImageView.PicInfo)this.b.get(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsu
 * JD-Core Version:    0.7.0.1
 */