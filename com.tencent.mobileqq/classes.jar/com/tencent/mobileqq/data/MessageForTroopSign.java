package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class MessageForTroopSign
  extends MessageForStructing
{
  public static final String TAG = "MessageForTroopSign";
  public String dynamicSource;
  public String markDesc;
  public String markIconUrl;
  public int markType;
  public String markWord;
  public String msgAction;
  public String msgBrief;
  public String msgContent;
  public String msgCoverUrl;
  public String msgTitle;
  public int positonType;
  public String srcAction;
  public String srcIconUrl;
  public String srcName;
  
  public void doParse()
  {
    super.doParse();
    Object localObject1 = (StructMsgForGeneralShare)this.structingMsg;
    this.srcName = ((StructMsgForGeneralShare)localObject1).mSourceName;
    this.srcAction = ((StructMsgForGeneralShare)localObject1).mSourceUrl;
    this.srcIconUrl = ((StructMsgForGeneralShare)localObject1).mSourceIcon;
    this.msgBrief = ((StructMsgForGeneralShare)localObject1).mMsgBrief;
    this.msgAction = ((StructMsgForGeneralShare)localObject1).mMsgUrl;
    localObject1 = ((StructMsgForGeneralShare)localObject1).mStructMsgItemLists;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = (AbsStructMsgElement)((List)localObject1).get(0);
      if ((localObject1 instanceof StructMsgItemLayout2))
      {
        Object localObject2 = (StructMsgItemLayout2)localObject1;
        localObject1 = ((StructMsgItemLayout2)localObject2).a;
        Object localObject3;
        try
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("doParse, mCommonData=");
            ((StringBuilder)localObject3).append(((StructMsgItemLayout2)localObject2).i);
            QLog.d("MessageForTroopSign", 2, ((StringBuilder)localObject3).toString());
          }
          if (!TextUtils.isEmpty(((StructMsgItemLayout2)localObject2).i))
          {
            localObject2 = new JSONObject(((StructMsgItemLayout2)localObject2).i);
            this.markType = ((JSONObject)localObject2).getInt("markType");
            this.positonType = ((JSONObject)localObject2).getInt("positonType");
            this.markIconUrl = ((JSONObject)localObject2).getString("markIconUrl");
            this.markWord = ((JSONObject)localObject2).getString("markWord");
            this.markDesc = ((JSONObject)localObject2).getString("markDesc");
            this.dynamicSource = ((JSONObject)localObject2).optString("dynamicSource", null);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("doParse:");
            ((StringBuilder)localObject3).append(localException.toString());
            QLog.e("MessageForTroopSign", 2, ((StringBuilder)localObject3).toString());
          }
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject1).next();
          localObject3 = localAbsStructMsgElement.a;
          if ("vote".equals(localObject3))
          {
            if ((localAbsStructMsgElement instanceof StructMsgItemCover)) {
              this.msgCoverUrl = ((StructMsgItemCover)localAbsStructMsgElement).ac;
            }
          }
          else if ("summary".equals(localObject3))
          {
            if ((localAbsStructMsgElement instanceof StructMsgItemSummary)) {
              this.msgContent = ((StructMsgItemSummary)localAbsStructMsgElement).b();
            }
          }
          else if (("title".equals(localObject3)) && ((localAbsStructMsgElement instanceof StructMsgItemTitle))) {
            this.msgTitle = ((StructMsgItemTitle)localAbsStructMsgElement).b();
          }
        }
      }
    }
    this.msg = getSummaryMsg();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doParse:");
      ((StringBuilder)localObject1).append(toString());
      QLog.d("MessageForTroopSign", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public String getSummaryMsg()
  {
    if (TextUtils.isEmpty(this.msgBrief)) {
      this.msgBrief = HardCodeUtil.a(2131706637);
    }
    return this.msgBrief;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForSign{");
    localStringBuilder.append("msgCoverUrl=");
    localStringBuilder.append(this.msgCoverUrl);
    localStringBuilder.append(", msgAction=");
    localStringBuilder.append(this.msgAction);
    localStringBuilder.append(", msgTitle=");
    localStringBuilder.append(this.msgTitle);
    localStringBuilder.append(", msgContent=");
    localStringBuilder.append(this.msgContent);
    localStringBuilder.append(", srcName=");
    localStringBuilder.append(this.srcName);
    localStringBuilder.append(", srcAction=");
    localStringBuilder.append(this.srcAction);
    localStringBuilder.append(", srcIconUrl=");
    localStringBuilder.append(this.srcIconUrl);
    localStringBuilder.append(", msgBrief=");
    localStringBuilder.append(this.msgBrief);
    localStringBuilder.append(", markType=");
    localStringBuilder.append(this.markType);
    localStringBuilder.append(", positonType=");
    localStringBuilder.append(this.positonType);
    localStringBuilder.append(", markIconUrl=");
    localStringBuilder.append(this.markIconUrl);
    localStringBuilder.append(", markWord=");
    localStringBuilder.append(this.markWord);
    localStringBuilder.append(", markDesc=");
    localStringBuilder.append(this.markDesc);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopSign
 * JD-Core Version:    0.7.0.1
 */