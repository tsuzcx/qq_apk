import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;
import java.util.List;

public class swc
  extends son<ssm>
{
  protected ImageView a;
  protected TextView a;
  protected RotateCircleImageView a;
  protected ImageView b;
  protected TextView b;
  protected ImageView c = (ImageView)a(2131309237);
  
  public swc(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView = ((RotateCircleImageView)a(2131298655));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131301774));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131310958));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131311534));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131309238));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderStyle(RotateCircleImageView.BorderStyle.STILL);
    int[] arrayOfInt = new int[paramInt1];
    int i = 0;
    if (i < paramInt1)
    {
      if (i < paramInt1 - paramInt2) {
        arrayOfInt[i] = Color.parseColor("#DEDFE0");
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt[i] = Color.parseColor("#19D7FD");
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderColors(arrayOfInt);
  }
  
  public void a(ssm paramssm)
  {
    if ((paramssm.a != null) && (!paramssm.a.isEmpty())) {
      a(paramssm.a.size(), paramssm.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swc
 * JD-Core Version:    0.7.0.1
 */