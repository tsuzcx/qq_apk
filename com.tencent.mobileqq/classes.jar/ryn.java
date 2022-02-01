import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ryn
  extends BaseAdapter
{
  public ryn(EditVideoFragment paramEditVideoFragment) {}
  
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
    ryo localryo;
    ColumnInfo localColumnInfo;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getActivity()).inflate(2131560221, paramViewGroup, false);
      localryo = new ryo(this.a.getActivity(), (ViewGroup)localView);
      localView.setTag(localryo);
      localColumnInfo = a(paramInt);
      if (EditVideoFragment.a(this.a) == null) {
        break label121;
      }
    }
    label121:
    for (int i = EditVideoFragment.a(this.a).columnID;; i = 0)
    {
      localryo.a(localColumnInfo, i);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localryo = (ryo)paramView.getTag();
      localView = paramView;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryn
 * JD-Core Version:    0.7.0.1
 */