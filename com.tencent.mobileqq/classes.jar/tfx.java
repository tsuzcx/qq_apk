import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tfx
  extends BaseAdapter
{
  private List<BaseAdapter> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tfz jdField_a_of_type_Tfz;
  private tga jdField_a_of_type_Tga;
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public List<BaseAdapter> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramBaseAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBaseAdapter);
    paramBaseAdapter.registerDataSetObserver(new tfy(this));
  }
  
  public void a(tfz paramtfz)
  {
    this.jdField_a_of_type_Tfz = paramtfz;
  }
  
  public void a(tga paramtga)
  {
    this.jdField_a_of_type_Tga = paramtga;
  }
  
  public int getCount()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((BaseAdapter)localIterator.next()).getCount() + i) {}
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      int i = localBaseAdapter.getCount();
      if (paramInt < i) {
        return localBaseAdapter.getItem(paramInt);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      int i = localBaseAdapter.getCount();
      if (paramInt < i) {
        return localBaseAdapter.getItemId(paramInt);
      }
      paramInt -= i;
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    BaseAdapter localBaseAdapter;
    if (localIterator.hasNext())
    {
      localBaseAdapter = (BaseAdapter)localIterator.next();
      j = localBaseAdapter.getCount();
      if (i >= j) {}
    }
    for (i = localBaseAdapter.getItemViewType(i);; i = -1)
    {
      return i + paramInt;
      i -= j;
      paramInt = localBaseAdapter.getViewTypeCount() + paramInt;
      break;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = paramInt;
    Object localObject;
    int j;
    if (localIterator.hasNext())
    {
      localObject = (BaseAdapter)localIterator.next();
      j = ((BaseAdapter)localObject).getCount();
      if (i < j)
      {
        localObject = ((BaseAdapter)localObject).getView(i, paramView, paramViewGroup);
        if (this.jdField_a_of_type_Tga != null) {
          this.jdField_a_of_type_Tga.a(paramInt, (View)localObject);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(i, paramView, paramViewGroup, getItemId(i));
      return localObject;
      i -= j;
      break;
      localObject = null;
    }
  }
  
  public int getViewTypeCount()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((BaseAdapter)localIterator.next()).getViewTypeCount() + i) {}
    return Math.max(i, 1);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (this.jdField_a_of_type_Tfz != null) {
      this.jdField_a_of_type_Tfz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tfx
 * JD-Core Version:    0.7.0.1
 */