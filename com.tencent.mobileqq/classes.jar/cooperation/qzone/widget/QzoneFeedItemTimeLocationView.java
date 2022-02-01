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
  private static final String TAG = "QzoneFeedItemTimeLocationView";
  TextView feedCreateTimeTv;
  TextView feedLocationTv;
  private Context mContext;
  public String timeStr;
  
  public QzoneFeedItemTimeLocationView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public QzoneFeedItemTimeLocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public QzoneFeedItemTimeLocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(this.mContext).inflate(2131558891, this);
    this.feedLocationTv = ((TextView)findViewById(2131366621));
    this.feedCreateTimeTv = ((TextView)findViewById(2131366691));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = 0;
      if (this.feedCreateTimeTv != null) {
        paramInt1 = this.feedCreateTimeTv.getWidth();
      }
      paramInt2 = getWidth();
      paramInt3 = paramInt2 - (int)(this.mContext.getResources().getDimension(2131296403) + 0.5D) - (int)(this.mContext.getResources().getDimension(2131296404) + 0.5D) - (int)(this.mContext.getResources().getDimension(2131296402) + 0.5D) - paramInt1 - 1;
      this.feedLocationTv.setMaxWidth(paramInt3);
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
    this.timeStr = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneFeedItemTimeLocationView
 * JD-Core Version:    0.7.0.1
 */