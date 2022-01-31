import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.filter.FilterData.FilterPageItem;
import com.tencent.biz.qqstory.takevideo.filter.TimeFilterData;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ope
  extends FilterData.FilterPageItem
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372056);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372057);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372058);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372059);
  
  private ope(TimeFilterData paramTimeFilterData, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2130970872, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130843682);
      return;
    case '1': 
      paramImageView.setImageResource(2130843683);
      return;
    case '2': 
      paramImageView.setImageResource(2130843684);
      return;
    case '3': 
      paramImageView.setImageResource(2130843685);
      return;
    case '4': 
      paramImageView.setImageResource(2130843686);
      return;
    case '5': 
      paramImageView.setImageResource(2130843687);
      return;
    case '6': 
      paramImageView.setImageResource(2130843688);
      return;
    case '7': 
      paramImageView.setImageResource(2130843689);
      return;
    case '8': 
      paramImageView.setImageResource(2130843690);
      return;
    }
    paramImageView.setImageResource(2130843691);
  }
  
  public void a(TimeFilterData paramTimeFilterData, int paramInt)
  {
    super.a(paramTimeFilterData, paramInt);
    paramTimeFilterData = new SimpleDateFormat("HH:mm");
    ((TimeFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).c = paramTimeFilterData.format(new Date());
    SLog.b("TimeFilterData", "TimeFilterData time:" + ((TimeFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((TimeFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).c.charAt(0));
    a(this.b, ((TimeFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).c.charAt(1));
    a(this.c, ((TimeFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).c.charAt(3));
    a(this.d, ((TimeFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).c.charAt(4));
    int i = UIUtils.b(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterTimeFilterData.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterTimeFilterData.a.jdField_a_of_type_Int == 10)) || ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterTimeFilterData.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterTimeFilterData.a.jdField_a_of_type_Int == 12)))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterTimeFilterData.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterTimeFilterData.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() > DeviceInfoUtil.l() / DeviceInfoUtil.m())
      {
        paramInt = (int)(DeviceInfoUtil.l() * this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterTimeFilterData.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterTimeFilterData.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if (paramInt > i / 3 * 2 + DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
        this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt - i, 0, 0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ope
 * JD-Core Version:    0.7.0.1
 */