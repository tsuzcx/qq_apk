import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.util.ArrayList;
import java.util.List;

public class oje
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<qno> jdField_a_of_type_JavaUtilArrayList;
  
  public void a(List<qno> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      qno localqno = new qno();
      this.jdField_a_of_type_JavaUtilArrayList.add(localqno);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramList = new qno();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(aekt.a(2.0F, (Resources)localObject1), aekt.a(100.0F, (Resources)localObject1)));
      }
    }
    ojg localojg;
    do
    {
      return paramViewGroup;
      if (paramView != null) {
        break;
      }
      localojg = new ojg(null);
      paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(aekt.a(100.0F, (Resources)localObject1), aekt.a(100.0F, (Resources)localObject1)));
      paramViewGroup = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.setRadius(5.0F);
      paramViewGroup.d(false);
      localojg.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewGroup;
      paramView.addView(paramViewGroup);
      paramViewGroup = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      paramViewGroup.setRadius(5.0F);
      paramViewGroup.d(false);
      paramViewGroup.setBackgroundColor(1711276032);
      localojg.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewGroup;
      paramView.addView(paramViewGroup);
      paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(aekt.a(9.0F, (Resources)localObject1), aekt.a(6.0F, (Resources)localObject1), aekt.a(9.0F, (Resources)localObject1), 0);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramViewGroup.setTextColor(-1);
      paramViewGroup.setTextSize(14.0F);
      paramViewGroup.setMaxLines(2);
      paramViewGroup.setEllipsize(TextUtils.TruncateAt.END);
      paramViewGroup.getPaint().setFakeBoldText(true);
      localojg.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
      paramView.addView(paramViewGroup);
      paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(aekt.a(8.0F, (Resources)localObject1), 0, 0, aekt.a(8.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramViewGroup.setPadding(aekt.a(5.0F, (Resources)localObject1), 0, aekt.a(5.0F, (Resources)localObject1), 0);
      paramViewGroup.setTextColor(-7745469);
      paramViewGroup.setTextSize(11.0F);
      paramViewGroup.setBackgroundResource(2130842632);
      localojg.jdField_b_of_type_AndroidWidgetTextView = paramViewGroup;
      paramView.addView(paramViewGroup);
      paramView.setTag(localojg);
      localObject1 = (qno)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup = paramView;
    } while (localObject1 == null);
    paramViewGroup = new ColorDrawable(-1);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramViewGroup;
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramViewGroup;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    if (!TextUtils.isEmpty(((qno)localObject1).d))
    {
      paramViewGroup = URLDrawable.getDrawable(((qno)localObject1).d, (URLDrawable.URLDrawableOptions)localObject2);
      if (paramViewGroup.getStatus() == 2) {
        paramViewGroup.restartDownload();
      }
      localojg.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = new StringBuilder();
      if (!TextUtils.isEmpty(((qno)localObject1).c)) {
        paramViewGroup.append(((qno)localObject1).c);
      }
      if (!TextUtils.isEmpty(((qno)localObject1).a)) {
        paramViewGroup.append(((qno)localObject1).a);
      }
      localojg.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.toString());
      if (((qno)localObject1).b > 0) {
        break label642;
      }
      localojg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return paramView;
      localojg = (ojg)paramView.getTag();
      break;
      localojg.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewGroup);
    }
    label642:
    if (((qno)localObject1).b < 1000)
    {
      localojg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localojg.jdField_b_of_type_AndroidWidgetTextView.setText("+" + ((qno)localObject1).b);
      return paramView;
    }
    localojg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localojg.jdField_b_of_type_AndroidWidgetTextView.setText("+999");
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oje
 * JD-Core Version:    0.7.0.1
 */