import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rzr
  extends BaseAdapter
{
  private List<BaseAdapter> jdField_a_of_type_JavaUtilList = new ArrayList();
  private rzt jdField_a_of_type_Rzt;
  private rzu jdField_a_of_type_Rzu;
  
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
    paramBaseAdapter.registerDataSetObserver(new rzs(this));
  }
  
  public void a(rzt paramrzt)
  {
    this.jdField_a_of_type_Rzt = paramrzt;
  }
  
  public void a(rzu paramrzu)
  {
    this.jdField_a_of_type_Rzu = paramrzu;
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
    while (localIterator.hasNext())
    {
      Object localObject = (BaseAdapter)localIterator.next();
      int j = ((BaseAdapter)localObject).getCount();
      if (i < j)
      {
        localObject = ((BaseAdapter)localObject).getView(i, paramView, paramViewGroup);
        if (this.jdField_a_of_type_Rzu != null)
        {
          this.jdField_a_of_type_Rzu.a(paramInt, (View)localObject);
          return localObject;
        }
      }
      i -= j;
    }
    return null;
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
    if (this.jdField_a_of_type_Rzt != null) {
      this.jdField_a_of_type_Rzt.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rzr
 * JD-Core Version:    0.7.0.1
 */