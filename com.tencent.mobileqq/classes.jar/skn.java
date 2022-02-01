import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class skn
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List<pqu> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<Integer> b = new ArrayList();
  
  public skn(Context paramContext, HorizontalListView paramHorizontalListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new sko(this, paramContext));
  }
  
  private void a(pqu parampqu)
  {
    if (!this.b.contains(Integer.valueOf(parampqu.jdField_a_of_type_Int)))
    {
      ocd.a(null, "", "0X800992A", "0X800992A", 0, 0, "", "", "", "", false);
      this.b.add(Integer.valueOf(parampqu.jdField_a_of_type_Int));
    }
  }
  
  private void a(pqu parampqu, View paramView)
  {
    skp localskp = (skp)paramView.getTag();
    Object localObject = paramView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    skp.a(localskp).setText(parampqu.jdField_a_of_type_JavaLangString);
    skp.b(localskp).setText(bnrf.a(parampqu.jdField_c_of_type_Int));
    paramView = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramView.mFailedDrawable = ((Drawable)localObject);
    paramView.mLoadingDrawable = ((Drawable)localObject);
    paramView = URLDrawable.getDrawable(parampqu.jdField_c_of_type_JavaLangString, paramView);
    skp.a(localskp).setImageDrawable(paramView);
    a(parampqu);
  }
  
  public void a(List<pqu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = BaseApplicationImpl.getApplication().getResources();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 2))
    {
      this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - agej.a(11.0F, paramList) - agej.a(24, paramList)) * 0.5F));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() == 3)
      {
        this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - agej.a(15.0F, paramList) - agej.a(24, paramList)) / 3.0F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      }
      else
      {
        this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - agej.a(15.0F, paramList) - agej.a(12, paramList)) / 2.5F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(1);
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = paramView.inflate(2131560269, paramViewGroup, false);
        localObject = new skp(this, null);
        skp.a((skp)localObject, (ImageView)paramView.findViewById(2131364026));
        skp.a((skp)localObject, (TextView)paramView.findViewById(2131364027));
        skp.b((skp)localObject, (TextView)paramView.findViewById(2131364017));
        paramView.setTag(localObject);
      }
    }
    for (;;)
    {
      localObject = (pqu)getItem(paramInt);
      if (localObject != null) {
        a((pqu)localObject, paramView);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = paramView.inflate(2131561677, paramViewGroup, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skn
 * JD-Core Version:    0.7.0.1
 */