package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import java.util.ArrayList;
import java.util.Iterator;

public class GuildBuilderUtils
{
  public static int a()
  {
    return 2131166185;
  }
  
  public static void a(ChatMessage paramChatMessage, CharSequence paramCharSequence, TextView paramTextView, Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramChatMessage != null) && (paramCharSequence != null) && (paramTextView != null))
    {
      if (paramContext == null) {
        return;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("guild_at_info_list");
      if (!TextUtils.isEmpty(paramChatMessage))
      {
        paramChatMessage = MessageForText.getTroopMemberInfoFromExtrJson(paramChatMessage);
        if ((paramChatMessage != null) && (paramChatMessage.size() > 0))
        {
          paramInt1 = paramContext.getResources().getColor(paramInt1);
          paramInt2 = paramContext.getResources().getColor(paramInt2);
          int i = AIOUtils.b(3.0F, paramContext.getResources());
          paramChatMessage = paramChatMessage.iterator();
          while (paramChatMessage.hasNext())
          {
            paramContext = (AtTroopMemberInfo)paramChatMessage.next();
            if ((paramContext.startPos >= 0) && (paramContext.startPos < paramCharSequence.length()) && (paramContext.startPos + paramContext.textLen > 0) && (paramContext.startPos + paramContext.textLen <= paramCharSequence.length())) {
              localSpannableStringBuilder.setSpan(new RadiusBackgroundSpan(paramInt1, paramInt2, i, paramTextView), paramContext.startPos, paramContext.startPos + paramContext.textLen, 33);
            }
          }
        }
      }
      paramTextView.setText(localSpannableStringBuilder);
    }
  }
  
  public static int b()
  {
    return 2131166184;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildBuilderUtils
 * JD-Core Version:    0.7.0.1
 */