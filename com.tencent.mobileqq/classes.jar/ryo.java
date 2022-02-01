import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.RoundImageView;

public class ryo
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private TextView b;
  
  ryo(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramViewGroup.findViewById(2131365287));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379093));
    this.b = ((TextView)paramViewGroup.findViewById(2131380858));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131379284));
  }
  
  void a(ColumnInfo paramColumnInfo, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843095);
    ((Drawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramColumnInfo.title);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131717906);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.b.setText(String.format((String)localObject, new Object[] { Integer.valueOf(paramColumnInfo.videoCount) }));
    }
    if (!TextUtils.isEmpty(paramColumnInfo.coverUrl))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable(paramColumnInfo.coverUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageDrawable((Drawable)localObject);
    }
    if (paramInt == paramColumnInfo.columnID)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131366016, Boolean.valueOf(true));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131366016, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryo
 * JD-Core Version:    0.7.0.1
 */