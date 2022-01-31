import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;

public class ngz
  extends BaseAdapter
{
  public ngz(ngy paramngy) {}
  
  public nms a(int paramInt)
  {
    return (nms)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.a.jdField_a_of_type_AndroidContentContext.getResources();
    int i = actj.a(200.0F, paramViewGroup);
    int j = actj.a(140.0F, paramViewGroup);
    int k = actj.a(12.0F, paramViewGroup);
    Object localObject;
    if (paramView == null)
    {
      paramView = new nha(this);
      paramViewGroup = new BubbleViewLayout(this.a.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setRadius(6.0F);
      paramViewGroup.a(false);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(j, i));
      localObject = new URLImageView(this.a.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((URLImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#33000000")));
      ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ViewGroup)paramViewGroup).addView((View)localObject);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      localObject = new TextView(this.a.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.setMargins(k, 0, k, k);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(2, 16.0F);
      ((TextView)localObject).setMaxLines(2);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((ViewGroup)paramViewGroup).addView((View)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      localObject = a(paramInt);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(((nms)localObject).e, null, null, true));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((nms)localObject).a);
      return paramViewGroup;
      localObject = (nha)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngz
 * JD-Core Version:    0.7.0.1
 */