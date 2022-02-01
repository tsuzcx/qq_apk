package com.tencent.mobileqq.kandian.biz.colornote.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ColorNoteReportUtilImpl$reportInsideTabPushRedPnt$1
  implements Runnable
{
  ColorNoteReportUtilImpl$reportInsideTabPushRedPnt$1(MessageRecord paramMessageRecord) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        long l2 = -1L;
        String str = "";
        long l3 = l2;
        Object localObject3 = str;
        if (this.a != null)
        {
          Object localObject1 = this.a;
          boolean bool = localObject1 instanceof MessageForStructing;
          Object localObject4 = null;
          if (!bool) {
            localObject1 = null;
          }
          localObject1 = (MessageForStructing)localObject1;
          if (localObject1 == null) {
            break label396;
          }
          localObject1 = ((MessageForStructing)localObject1).structingMsg;
          l3 = l2;
          localObject3 = str;
          if (localObject1 != null)
          {
            localObject3 = this.a;
            localObject1 = localObject3;
            if (!(localObject3 instanceof MessageForStructing)) {
              localObject1 = null;
            }
            localObject1 = (MessageForStructing)localObject1;
            if (localObject1 == null) {
              break label402;
            }
            localObject1 = ((MessageForStructing)localObject1).structingMsg;
            if (localObject1 == null) {
              break label402;
            }
            localObject1 = ((AbsStructMsg)localObject1).mArticleIds;
            long l1 = l2;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              localObject1 = (CharSequence)localObject1;
              localObject1 = ((Collection)new Regex("\\|").split((CharSequence)localObject1, 0)).toArray(new String[0]);
              if (localObject1 != null)
              {
                localObject1 = (String[])localObject1;
                if (localObject1.length != 0) {
                  break label408;
                }
                i = 1;
                l1 = l2;
                if ((i ^ 0x1) != 0) {
                  l1 = Long.parseLong(localObject1[0]);
                }
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
              }
            }
            localObject3 = this.a;
            localObject1 = localObject3;
            if (!(localObject3 instanceof MessageForStructing)) {
              localObject1 = null;
            }
            localObject3 = (MessageForStructing)localObject1;
            localObject1 = localObject4;
            if (localObject3 != null)
            {
              localObject3 = ((MessageForStructing)localObject3).structingMsg;
              localObject1 = localObject4;
              if (localObject3 != null) {
                localObject1 = ((AbsStructMsg)localObject3).reportEventFolderStatusValue;
              }
            }
            l3 = l1;
            localObject3 = str;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject3 = localObject1;
              l3 = l1;
            }
          }
        }
        localJSONObject.put("inside_kd_tab_red_pnt_push_articleId", l3);
        localJSONObject.put("folder_status", localObject3);
        PublicAccountReportUtils.a(null, "", "0X800952D", "0X800952D", 0, 0, localJSONObject.toString(), "", "", "", false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label396:
      Object localObject2 = null;
      continue;
      label402:
      localObject2 = null;
      continue;
      label408:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.colornote.api.impl.ColorNoteReportUtilImpl.reportInsideTabPushRedPnt.1
 * JD-Core Version:    0.7.0.1
 */