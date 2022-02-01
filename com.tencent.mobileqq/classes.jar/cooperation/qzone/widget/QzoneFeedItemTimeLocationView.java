package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class QzoneFeedItemTimeLocationView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String a;
  TextView b;
  
  public QzoneFeedItemTimeLocationView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public QzoneFeedItemTimeLocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public QzoneFeedItemTimeLocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558857, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366485));
    this.b = ((TextView)findViewById(2131366555));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = 0;
      if (this.b != null) {
        paramInt1 = this.b.getWidth();
      }
      paramInt2 = getWidth();
      paramInt3 = paramInt2 - (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296350) + 0.5D) - (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296351) + 0.5D) - (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296349) + 0.5D) - paramInt1 - 1;
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("QzoneFeedItemTimeLocationView", 2, "onLayout change:timeWidth:" + paramInt1 + ",feedLocationTvWidth(max):" + paramInt3 + ",feedLocationLayoutWidth:" + paramInt2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemTimeLocationView", 2, "onLayout");
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setTime(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneFeedItemTimeLocationView
 * JD-Core Version:    0.7.0.1
 */