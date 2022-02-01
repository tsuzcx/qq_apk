package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MsgOnClickListener;

public class MsgTitleView
  extends FrameLayout
{
  private MQMsg mData;
  private TextView mText;
  private MsgOnClickListener msgOnClickListener;
  
  public MsgTitleView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2080636939, this);
    this.mText = ((TextView)findViewById(2080571516));
    setOnClickListener(new MsgTitleView.1(this));
  }
  
  public void setData(MQMsg paramMQMsg, boolean paramBoolean)
  {
    this.mData = paramMQMsg;
    if (!TextUtils.isEmpty(paramMQMsg.title))
    {
      this.mText.setText(paramMQMsg.title);
      paramMQMsg = this.mText;
      int i;
      if (paramBoolean) {
        i = -198683;
      } else {
        i = -16578534;
      }
      paramMQMsg.setTextColor(i);
    }
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgTitleView
 * JD-Core Version:    0.7.0.1
 */