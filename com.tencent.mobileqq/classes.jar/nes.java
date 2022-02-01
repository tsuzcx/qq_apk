import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

public class nes
  extends new<nek>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = nes.class.getName();
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView;
  private TextView c;
  private TextView d;
  
  public nes(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363229));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363223));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363222);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363224));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363220));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout = ((OverlappingImgLayout)paramView.findViewById(2131363219));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363221));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363227));
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363226));
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.c = ((TextView)paramView.findViewById(2131363228));
    this.d = ((TextView)paramView.findViewById(2131363230));
    paramView.setOnTouchListener(this);
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setOnTouchListener(this);
    a(this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView);
    a(paramView);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(nfa paramnfa, nek paramnek, int paramInt)
  {
    super.a(paramnfa, paramnek, paramInt);
    if (paramnek == null) {
      return;
    }
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramnek.c());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramnek.e());
    float f = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    paramInt = paramnek.e();
    int i = paramnek.f();
    paramnfa = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt | 0xFF000000, i | 0xFF000000 });
    paramnfa.setCornerRadius(f);
    paramnfa.setGradientType(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramnfa);
    this.d.setVisibility(0);
    if (!TextUtils.isEmpty(paramnek.h())) {
      this.d.setText(paramnek.h());
    }
    while (paramnek.a())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
      if (paramnek.c())
      {
        this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setClickable(true);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mReserveImageView isClickable:" + this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.isClickable());
      }
      if (paramnek.b())
      {
        this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramnek.g());
        this.c.setVisibility(8);
        return;
        this.d.setText(paramnek.b());
      }
      else
      {
        this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramnek.f());
        this.c.setVisibility(0);
        this.c.setText(String.format(this.itemView.getContext().getString(2131690377), new Object[] { Integer.valueOf(paramnek.d()) }));
        return;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ApngImage url:" + paramnek.d());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramnek.d());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return false;
      paramView.setAlpha(0.5F);
      continue;
      paramView.setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nes
 * JD-Core Version:    0.7.0.1
 */