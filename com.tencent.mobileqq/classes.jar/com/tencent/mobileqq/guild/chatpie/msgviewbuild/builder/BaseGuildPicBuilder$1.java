package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BaseGuildPicBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  BaseGuildPicBuilder$1(BaseGuildPicBuilder paramBaseGuildPicBuilder, MessageForPic paramMessageForPic, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i = 1;
    if (paramInt == 0)
    {
      paramView = ((ITransFileController)this.c.g.getRuntimeService(ITransFileController.class)).findProcessor(this.a.frienduin, this.a.uniseq);
      if ((paramView != null) && ((paramView instanceof BaseTransProcessor)))
      {
        paramView = (BaseTransProcessor)paramView;
        if ((paramView.isRawPic()) && (paramView.isPause()))
        {
          ((ITransFileController)this.c.g.getRuntimeService(ITransFileController.class)).getBusHelper().resumeRawSend(this.a.frienduin, String.valueOf(this.a.uniseq));
          paramInt = i;
          break label122;
        }
      }
      paramInt = 0;
      label122:
      if (paramInt == 0) {
        this.c.a(this.a);
      }
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildPicBuilder.1
 * JD-Core Version:    0.7.0.1
 */