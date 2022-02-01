package cooperation.qwallet.plugin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class QwAdapter<V>
  extends BaseAdapter
{
  protected LayoutInflater layoutInflater;
  protected List<V> list;
  private QwAdapter.IViewHolder mCloneObj = null;
  private QwAdapter.IViewHolder mHolder;
  protected int resource;
  
  public QwAdapter(Context paramContext, List<V> paramList, int paramInt, QwAdapter.IViewHolder paramIViewHolder)
  {
    this.resource = paramInt;
    this.list = paramList;
    this.mCloneObj = paramIViewHolder;
    this.layoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    return this.list.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public List<V> getList()
  {
    return this.list;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.layoutInflater.inflate(this.resource, paramViewGroup, false);
      try
      {
        if (this.mCloneObj != null) {
          this.mHolder = this.mCloneObj.clone();
        }
        this.mHolder.initView(paramInt, paramView);
        paramView.setTag(this.mHolder);
      }
      catch (CloneNotSupportedException paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
    }
    else
    {
      this.mHolder = ((QwAdapter.IViewHolder)paramView.getTag());
    }
    paramViewGroup = this.list.get(paramInt);
    this.mHolder.setItemView(paramInt, paramView, paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.QwAdapter
 * JD-Core Version:    0.7.0.1
 */