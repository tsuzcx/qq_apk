import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;

public class nsm
  extends BaseAdapter
{
  public nsm(nsl paramnsl) {}
  
  public nyl a(int paramInt)
  {
    return (nyl)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    Object localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources();
    int i = afur.a(200.0F, (Resources)localObject1);
    int j = afur.a(140.0F, (Resources)localObject1);
    int k = afur.a(12.0F, (Resources)localObject1);
    Object localObject2;
    if (paramView == null)
    {
      paramView = new nsn(this);
      localObject1 = new BubbleViewLayout(this.a.jdField_a_of_type_AndroidContentContext);
      ((BubbleViewLayout)localObject1).setRadius(6.0F);
      ((BubbleViewLayout)localObject1).a(false);
      ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(j, i));
      localObject2 = new URLImageView(this.a.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((URLImageView)localObject2).setImageDrawable(new ColorDrawable(Color.parseColor("#33000000")));
      ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ViewGroup)localObject1).addView((View)localObject2);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject2);
      localObject2 = new TextView(this.a.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.setMargins(k, 0, k, k);
      ((TextView)localObject2).setLayoutParams(localLayoutParams);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((ViewGroup)localObject1).addView((View)localObject2);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      ((View)localObject1).setTag(paramView);
    }
    for (;;)
    {
      localObject2 = a(paramInt);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(((nyl)localObject2).e, null, null, true));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((nyl)localObject2).a);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (nsn)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsm
 * JD-Core Version:    0.7.0.1
 */