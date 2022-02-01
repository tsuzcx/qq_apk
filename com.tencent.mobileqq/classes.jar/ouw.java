import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ouw
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<MultiBiuSameContent> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ouw(Context paramContext, ArrayList<MultiBiuSameContent> paramArrayList)
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
    for (Object localObject = new oux(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuReadInjoyFriendsBiuComponentFragment, this.jdField_a_of_type_AndroidContentContext);; localObject = (oux)paramView.getTag())
    {
      ((oux)localObject).a((MultiBiuSameContent)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramInt);
      localObject = ((oux)localObject).a();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ouw
 * JD-Core Version:    0.7.0.1
 */