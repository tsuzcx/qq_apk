import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class pti
  extends BaseAdapter
{
  List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  List<rxv> b = new ArrayList();
  
  public pti(NativeGridImageView paramNativeGridImageView) {}
  
  public List<URL> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(ptj paramptj)
  {
    this.b = paramptj.a();
    this.jdField_a_of_type_JavaUtilList = paramptj.b();
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
      ((SquareCornerTextImageView)paramView).a((rxv)this.b.get(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pti
 * JD-Core Version:    0.7.0.1
 */