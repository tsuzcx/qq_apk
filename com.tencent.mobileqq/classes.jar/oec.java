import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import java.util.ArrayList;

public class oec
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<MultiBiuSameContent> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public oec(Context paramContext, ArrayList<MultiBiuSameContent> paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramArrayList;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (paramView = new oed(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuReadInjoyFriendsBiuComponentFragment, this.jdField_a_of_type_AndroidContentContext);; paramView = (oed)paramView.getTag())
    {
      paramView.a((MultiBiuSameContent)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramInt);
      return paramView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oec
 * JD-Core Version:    0.7.0.1
 */