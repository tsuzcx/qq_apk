package cooperation.qzone.aioreddot;

import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbilityImpl;

class QzoneRedDotExtender$1
  extends BaseChatItemLayoutViewBasicAbilityImpl
{
  QzoneRedDotExtender$1(QzoneRedDotExtender paramQzoneRedDotExtender, View paramView)
  {
    super(paramView);
  }
  
  public void setData(Object... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs instanceof String))
      {
        paramVarArgs = (String)paramVarArgs;
        QzoneRedDotExtender.access$000(this.this$0).setBackgroundURL(paramVarArgs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.aioreddot.QzoneRedDotExtender.1
 * JD-Core Version:    0.7.0.1
 */