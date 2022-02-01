import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.seat.AddMemberItemView;
import com.tencent.avgame.gameroom.seat.EmptyMemberItemView;
import com.tencent.avgame.gameroom.seat.MemberItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class nbh
  extends BaseAdapter
  implements View.OnClickListener
{
  protected Context a;
  protected LayoutInflater a;
  protected ArrayList<nbe> a;
  protected mwp a;
  protected nbb a;
  protected nbi a;
  protected boolean a;
  
  public nbh(Context paramContext, nbb paramnbb)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Nbb = paramnbb;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Mwp = ((mwp)mxl.a().a().a(2));
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if ((paramView instanceof AddMemberItemView)) {}
    }
    else
    {
      paramViewGroup = (AddMemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558736, null);
      paramViewGroup.setOnClickListener(this);
      paramViewGroup.a();
    }
    return paramViewGroup;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          return paramView;
        }
        nbe localnbe = (nbe)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if ((paramView == null) || (!(paramView instanceof MemberItemView)))
        {
          paramView = (MemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558738, null);
          paramView.a();
          paramView.setOnClickListener(this);
          localView = paramView;
          paramViewGroup = paramView;
          paramViewGroup.a(this.jdField_a_of_type_Mwp, localnbe, this.jdField_a_of_type_Nbb);
          return localView;
        }
      }
      finally {}
      paramViewGroup = (MemberItemView)paramView;
      View localView = paramView;
    }
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(paramView instanceof EmptyMemberItemView))
    {
      paramView = (EmptyMemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558737, null);
      paramView.a();
      return paramView;
    }
    return paramView;
  }
  
  public void a(List<nbe> paramList, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      }
      return;
    }
  }
  
  public void a(nbi paramnbi)
  {
    this.jdField_a_of_type_Nbi = paramnbi;
  }
  
  public int getCount()
  {
    return 8;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramInt >= 0) {}
    try
    {
      Object localObject1;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        return localObject1;
      }
      if ((this.jdField_a_of_type_Boolean) && (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localObject1 = new Object();
        return localObject1;
      }
    }
    finally {}
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return 1;
      }
      if ((paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()) && (this.jdField_a_of_type_Boolean)) {
        return 0;
      }
    }
    finally {}
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    if (i == 1) {
      localView = b(paramInt, paramView, paramViewGroup);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (i == 0) {
        localView = a(paramInt, paramView, paramViewGroup);
      } else {
        localView = c(paramInt, paramView, paramViewGroup);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof MemberItemView))
    {
      MemberItemView localMemberItemView = (MemberItemView)paramView;
      if (this.jdField_a_of_type_Nbi != null) {
        this.jdField_a_of_type_Nbi.a(localMemberItemView.a);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((paramView instanceof AddMemberItemView)) && (this.jdField_a_of_type_Nbi != null)) {
        this.jdField_a_of_type_Nbi.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbh
 * JD-Core Version:    0.7.0.1
 */