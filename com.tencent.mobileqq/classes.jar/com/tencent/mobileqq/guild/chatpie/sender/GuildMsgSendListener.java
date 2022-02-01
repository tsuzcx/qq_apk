package com.tencent.mobileqq.guild.chatpie.sender;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.guild.api.IGuildTextUtil;
import com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuildMsgSendListener
  implements IMsgSendListener
{
  public boolean a(AIOContext paramAIOContext)
  {
    Editable localEditable = paramAIOContext.p().d().f().a();
    if (((IGuildTextUtil)QRoute.api(IGuildTextUtil.class)).filterTailSpace(localEditable).length() <= 0)
    {
      ((GuildInputBarHelper)paramAIOContext.a(145)).v();
      return true;
    }
    paramAIOContext = (PhotoListPanel)paramAIOContext.q().d(4);
    int i;
    if (paramAIOContext != null) {
      i = paramAIOContext.getSelectedPhotoCount();
    } else {
      i = 0;
    }
    int j;
    if (paramAIOContext != null) {
      j = paramAIOContext.getSelectedVideoCount();
    } else {
      j = 0;
    }
    if ((i + j > 0) && (paramAIOContext != null)) {
      return false;
    }
    paramAIOContext = Pattern.compile("[\\n ]+$").matcher(localEditable);
    if (paramAIOContext.find())
    {
      paramAIOContext = localEditable.subSequence(0, paramAIOContext.start());
      localEditable.replace(0, localEditable.length(), paramAIOContext);
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext)
  {
    ((GuildInputBarHelper)paramAIOContext.a(145)).t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.sender.GuildMsgSendListener
 * JD-Core Version:    0.7.0.1
 */