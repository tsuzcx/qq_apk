package com.tencent.mobileqq.kandian.biz.colornote.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.api.IMessageForStructingUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
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
        String str1 = "";
        long l3 = l2;
        Object localObject = str1;
        if (this.a != null)
        {
          l3 = l2;
          localObject = str1;
          if (((IMessageForStructingUtil)QRoute.api(IMessageForStructingUtil.class)).getStructingMsg(this.a) != null)
          {
            localObject = ((IMessageForStructingUtil)QRoute.api(IMessageForStructingUtil.class)).getArticleId(this.a);
            long l1 = l2;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if (localObject == null) {
                Intrinsics.throwNpe();
              }
              localObject = (CharSequence)localObject;
              localObject = ((Collection)new Regex("\\|").split((CharSequence)localObject, 0)).toArray(new String[0]);
              if (localObject != null)
              {
                localObject = (String[])localObject;
                if (localObject.length != 0) {
                  break label298;
                }
                i = 1;
                l1 = l2;
                if ((i ^ 0x1) != 0) {
                  l1 = Long.parseLong(localObject[0]);
                }
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
              }
            }
            String str2 = ((IMessageForStructingUtil)QRoute.api(IMessageForStructingUtil.class)).getReportEventFolderStatusValue(this.a);
            l3 = l1;
            localObject = str1;
            if (!TextUtils.isEmpty((CharSequence)str2))
            {
              localObject = str2;
              l3 = l1;
            }
          }
        }
        localJSONObject.put("inside_kd_tab_red_pnt_push_articleId", l3);
        localJSONObject.put("folder_status", localObject);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800952D", "0X800952D", 0, 0, localJSONObject.toString(), "", "", "", false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label298:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.colornote.api.impl.ColorNoteReportUtilImpl.reportInsideTabPushRedPnt.1
 * JD-Core Version:    0.7.0.1
 */