package com.tencent.timi.game.component.chat.input;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.util.EmotionCodecUtils;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUser;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TimiBaseInputView$init$5
  implements View.OnClickListener
{
  TimiBaseInputView$init$5(TimiBaseInputView paramTimiBaseInputView) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
    ((TimiBaseInputView)localObject1).a(paramView);
    localObject1 = this.a.getInputEditText();
    if (localObject1 != null)
    {
      localObject1 = ((EditText)localObject1).getEditableText();
      if (localObject1 != null)
      {
        localObject1 = localObject1.toString();
        if (localObject1 != null)
        {
          int i = this.a.getContentLimit();
          if (i == -1) {
            localObject1 = EmotionCodecUtils.b((String)localObject1);
          } else {
            localObject1 = EmotionCodecUtils.a((String)localObject1, i);
          }
          Object localObject3;
          if ((((Collection)this.a.getAtPosUserNameList()).isEmpty() ^ true))
          {
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "text");
            localObject3 = (CharSequence)localObject1;
            if (StringsKt.contains$default((CharSequence)localObject3, (CharSequence)"@", false, 2, null))
            {
              localObject2 = (List)new ArrayList();
              Iterator localIterator = ((Iterable)this.a.getAtPosUserNameList()).iterator();
              while (localIterator.hasNext())
              {
                String str = (String)((Pair)localIterator.next()).getSecond();
                Object localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("send showName= ");
                ((StringBuilder)localObject4).append(str);
                Logger.a("TimiInputView", ((StringBuilder)localObject4).toString());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append('@');
                ((StringBuilder)localObject4).append(str);
                if (StringsKt.contains$default((CharSequence)localObject3, (CharSequence)((StringBuilder)localObject4).toString(), false, 2, null))
                {
                  localObject4 = new MessageOuterClass.AtUser();
                  ((MessageOuterClass.AtUser)localObject4).user_id.set((MessageMicro)this.a.getUserNameQQUserInfoMapIdMap().get(str));
                  ((MessageOuterClass.AtUser)localObject4).nick_name.set(str);
                  ((MessageOuterClass.AtUser)localObject4).head_url.set((String)TimiBaseInputView.a(this.a).get(str));
                  ((List)localObject2).add(localObject4);
                }
              }
              localObject3 = new MessageOuterClass.AtUserMsg();
              ((MessageOuterClass.AtUserMsg)localObject3).user_list.set((List)localObject2);
              ((MessageOuterClass.AtUserMsg)localObject3).text.set((String)localObject1);
              localObject2 = new MessageOuterClass.MsgContent();
              ((MessageOuterClass.MsgContent)localObject2).at_user_msg.set((MessageMicro)localObject3);
              localObject3 = ((Iterable)TimiBaseInputView.b(this.a)).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((TimiBaseInputView.StateChangedListener)((Iterator)localObject3).next()).a((String)localObject1, (MessageOuterClass.MsgContent)localObject2, this.a);
              }
            }
          }
          Object localObject2 = ((Iterable)TimiBaseInputView.b(this.a)).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (TimiBaseInputView.StateChangedListener)((Iterator)localObject2).next();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "text");
            ((TimiBaseInputView.StateChangedListener)localObject3).a((String)localObject1, this.a);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.init.5
 * JD-Core Version:    0.7.0.1
 */