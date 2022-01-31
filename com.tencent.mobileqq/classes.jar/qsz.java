import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import java.util.ArrayList;

public class qsz
  extends BaseAdapter
{
  public qsz(EditVideoFragment paramEditVideoFragment) {}
  
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
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.a.getActivity()).inflate(2131560010, paramViewGroup, false);
      paramView = new qta(this.a.getActivity(), (ViewGroup)paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      if (EditVideoFragment.a(this.a) != null) {
        paramView.a(a(paramInt), EditVideoFragment.a(this.a).columnID);
      }
      return paramViewGroup;
      qta localqta = (qta)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localqta;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsz
 * JD-Core Version:    0.7.0.1
 */