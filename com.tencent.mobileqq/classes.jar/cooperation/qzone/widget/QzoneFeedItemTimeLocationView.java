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
    LayoutInflater.from(this.mContext).inflate(2131558830, this);
    this.feedLocationTv = ((TextView)findViewById(2131366662));
    this.feedCreateTimeTv = ((TextView)findViewById(2131366732));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = 0;
      Object localObject = this.feedCreateTimeTv;
      if (localObject != null) {
        paramInt1 = ((TextView)localObject).getWidth();
      }
      paramInt2 = getWidth();
      double d = this.mContext.getResources().getDimension(2131296398);
      Double.isNaN(d);
      paramInt3 = (int)(d + 0.5D);
      d = this.mContext.getResources().getDimension(2131296399);
      Double.isNaN(d);
      paramInt4 = (int)(d + 0.5D);
      d = this.mContext.getResources().getDimension(2131296397);
      Double.isNaN(d);
      paramInt3 = paramInt2 - paramInt3 - paramInt4 - (int)(d + 0.5D) - paramInt1 - 1;
      this.feedLocationTv.setMaxWidth(paramInt3);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onLayout change:timeWidth:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(",feedLocationTvWidth(max):");
        ((StringBuilder)localObject).append(paramInt3);
        ((StringBuilder)localObject).append(",feedLocationLayoutWidth:");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("QzoneFeedItemTimeLocationView", 2, ((StringBuilder)localObject).toString());
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