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

public class qtk
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List<oqq> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<Integer> b = new ArrayList();
  
  public qtk(Context paramContext, HorizontalListView paramHorizontalListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new qtl(this, paramContext));
  }
  
  private void a(oqq paramoqq)
  {
    if (!this.b.contains(Integer.valueOf(paramoqq.jdField_a_of_type_Int)))
    {
      ndn.a(null, "", "0X800992A", "0X800992A", 0, 0, "", "", "", "", false);
      this.b.add(Integer.valueOf(paramoqq.jdField_a_of_type_Int));
    }
  }
  
  private void a(oqq paramoqq, View paramView)
  {
    qtm localqtm = (qtm)paramView.getTag();
    Object localObject = paramView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    qtm.a(localqtm).setText(paramoqq.jdField_a_of_type_JavaLangString);
    qtm.b(localqtm).setText(bgmq.a(paramoqq.jdField_c_of_type_Int));
    paramView = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramView.mFailedDrawable = ((Drawable)localObject);
    paramView.mLoadingDrawable = ((Drawable)localObject);
    paramView = URLDrawable.getDrawable(paramoqq.jdField_c_of_type_JavaLangString, paramView);
    qtm.a(localqtm).setImageDrawable(paramView);
    a(paramoqq);
  }
  
  public void a(List<oqq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = BaseApplicationImpl.getApplication().getResources();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 2))
    {
      this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - aciy.a(11.0F, paramList) - aciy.a(24, paramList)) * 0.5F));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() == 3)
      {
        this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - aciy.a(15.0F, paramList) - aciy.a(24, paramList)) / 3.0F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      }
      else
      {
        this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - aciy.a(15.0F, paramList) - aciy.a(12, paramList)) / 2.5F));
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
        paramView = paramView.inflate(2131494449, paramViewGroup, false);
        paramViewGroup = new qtm(this, null);
        qtm.a(paramViewGroup, (ImageView)paramView.findViewById(2131298182));
        qtm.a(paramViewGroup, (TextView)paramView.findViewById(2131298183));
        qtm.b(paramViewGroup, (TextView)paramView.findViewById(2131298173));
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      paramViewGroup = (oqq)getItem(paramInt);
      if (paramViewGroup != null) {
        a(paramViewGroup, paramView);
      }
      return paramView;
      paramView = paramView.inflate(2131495602, paramViewGroup, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtk
 * JD-Core Version:    0.7.0.1
 */