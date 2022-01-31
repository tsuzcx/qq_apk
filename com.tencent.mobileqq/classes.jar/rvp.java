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
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class rvp
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List<pha> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<Integer> b = new ArrayList();
  
  public rvp(Context paramContext, HorizontalListView paramHorizontalListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new rvq(this, paramContext));
  }
  
  private void a(pha parampha)
  {
    if (!this.b.contains(Integer.valueOf(parampha.jdField_a_of_type_Int)))
    {
      nrt.a(null, "", "0X800992A", "0X800992A", 0, 0, "", "", "", "", false);
      this.b.add(Integer.valueOf(parampha.jdField_a_of_type_Int));
    }
  }
  
  private void a(pha parampha, View paramView)
  {
    rvr localrvr = (rvr)paramView.getTag();
    Object localObject = paramView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    rvr.a(localrvr).setText(parampha.jdField_a_of_type_JavaLangString);
    rvr.b(localrvr).setText(bkbq.a(parampha.jdField_c_of_type_Int));
    paramView = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramView.mFailedDrawable = ((Drawable)localObject);
    paramView.mLoadingDrawable = ((Drawable)localObject);
    paramView = URLDrawable.getDrawable(parampha.jdField_c_of_type_JavaLangString, paramView);
    rvr.a(localrvr).setImageDrawable(paramView);
    a(parampha);
  }
  
  public void a(List<pha> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = BaseApplicationImpl.getApplication().getResources();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 2))
    {
      this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - aepi.a(11.0F, paramList) - aepi.a(24, paramList)) * 0.5F));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() == 3)
      {
        this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - aepi.a(15.0F, paramList) - aepi.a(24, paramList)) / 3.0F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      }
      else
      {
        this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - aepi.a(15.0F, paramList) - aepi.a(12, paramList)) / 2.5F));
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = paramView.inflate(2131560114, paramViewGroup, false);
        paramViewGroup = new rvr(this, null);
        rvr.a(paramViewGroup, (ImageView)paramView.findViewById(2131363794));
        rvr.a(paramViewGroup, (TextView)paramView.findViewById(2131363795));
        rvr.b(paramViewGroup, (TextView)paramView.findViewById(2131363785));
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      paramViewGroup = (pha)getItem(paramInt);
      if (paramViewGroup != null) {
        a(paramViewGroup, paramView);
      }
      return paramView;
      paramView = paramView.inflate(2131561400, paramViewGroup, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rvp
 * JD-Core Version:    0.7.0.1
 */