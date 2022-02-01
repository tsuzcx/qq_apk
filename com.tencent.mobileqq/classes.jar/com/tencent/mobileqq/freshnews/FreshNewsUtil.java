package com.tencent.mobileqq.freshnews;

import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class FreshNewsUtil
{
  public static String a(appoint_define.RichText paramRichText)
  {
    if (paramRichText == null) {
      return "";
    }
    if (paramRichText.rpt_msg_elems.has()) {
      paramRichText = paramRichText.rpt_msg_elems.get();
    } else {
      paramRichText = null;
    }
    if (paramRichText != null)
    {
      if (paramRichText.isEmpty()) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramRichText.iterator();
      while (localIterator.hasNext())
      {
        appoint_define.Elem localElem = (appoint_define.Elem)localIterator.next();
        if (localElem != null)
        {
          if (localElem.str_content.has()) {
            paramRichText = localElem.str_content.get();
          } else {
            paramRichText = "";
          }
          localStringBuilder.append(paramRichText);
          if (localElem.msg_face_info.has()) {
            paramRichText = (appoint_define.Face)localElem.msg_face_info.get();
          } else {
            paramRichText = null;
          }
          if (paramRichText != null)
          {
            int i;
            if (paramRichText.uint32_index.has()) {
              i = paramRichText.uint32_index.get();
            } else {
              i = -1;
            }
            if (i >= 0)
            {
              localStringBuilder.append('\024');
              localStringBuilder.append((char)QQSysFaceUtil.convertToLocal(i));
            }
          }
        }
      }
      if (QLog.isDevelopLevel())
      {
        paramRichText = new StringBuilder();
        paramRichText.append("getStringFromRichText, result=");
        paramRichText.append(localStringBuilder.toString());
        QLog.d("FreshNewsUtil", 4, paramRichText.toString());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.FreshNewsUtil
 * JD-Core Version:    0.7.0.1
 */