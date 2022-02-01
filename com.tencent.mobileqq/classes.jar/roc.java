import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class roc
  extends BaseAdapter
{
  public roc(EditVideoFragment paramEditVideoFragment) {}
  
  public ColumnInfo a(int paramInt)
  {
    return (ColumnInfo)EditVideoFragment.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return EditVideoFragment.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    rod localrod;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getActivity()).inflate(2131560156, paramViewGroup, false);
      localrod = new rod(this.a.getActivity(), (ViewGroup)localView);
      localView.setTag(localrod);
    }
    for (;;)
    {
      if (EditVideoFragment.a(this.a) != null) {
        localrod.a(a(paramInt), EditVideoFragment.a(this.a).columnID);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localrod = (rod)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roc
 * JD-Core Version:    0.7.0.1
 */