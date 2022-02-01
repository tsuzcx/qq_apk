package com.tencent.mobileqq.graytip;

import android.content.Context;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import aubw;
import aubx;
import aubz;
import aucf;
import aucg;
import bczs;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips.HighlightItem;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import localpb.uniteGrayTip.UniteGrayTip.BusinessData;
import localpb.uniteGrayTip.UniteGrayTip.HightlightParam;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;

public class MessageForUniteGrayTip
  extends ChatMessage
{
  public static final String KEY_BYTES_CONTENT = "bytes_content";
  public static final String KEY_UINT64_BUSI_ID = "uint64_busi_id";
  public static final String KEY_UINT64_BUSI_TYPE = "uint64_busi_type";
  public static final String KEY_UINT64_TEMPL_ID = "uint64_templ_id";
  private static final String TAG = "MessageForUniteGrayTip";
  public String appGuideTipsOpKey;
  public String caidanAnimUrl;
  public String caidanAnimUrlMd5;
  public aubz callback;
  public String contentDescription;
  public boolean dkTipHasReport;
  public boolean docTipHasReport;
  public String editMsgData;
  public int editState;
  public long editTime;
  @notColumn
  public aubx entity;
  public String extUin;
  public int hasRead;
  public String masterUin;
  public int subType;
  public String taskId;
  public aucf tipParam;
  public boolean troopMemberLevelTipHasReport;
  
  private void encode()
  {
    int j = 1;
    if (this.tipParam == null)
    {
      QLog.e(aucg.jdField_a_of_type_JavaLangString, 1, "MessageForUniteGrayTip, encode failed, tipParam == null");
      return;
    }
    UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
    localUniteGrayTipMsg.graytip_id.set(this.tipParam.jdField_b_of_type_Int);
    localUniteGrayTipMsg.graytip_level.set(this.tipParam.jdField_d_of_type_Int);
    if ((this.tipParam.jdField_b_of_type_ArrayOfInt != null) && (this.tipParam.jdField_b_of_type_ArrayOfInt.length > 0))
    {
      localObject = this.tipParam.jdField_b_of_type_ArrayOfInt;
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        localUniteGrayTipMsg.graytip_mutex_id.add(Integer.valueOf(m));
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(this.tipParam.jdField_d_of_type_JavaLangString)) {
      localUniteGrayTipMsg.graytip_key.set(this.tipParam.jdField_d_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.tipParam.jdField_c_of_type_JavaLangString)) {
      localUniteGrayTipMsg.content.set(this.tipParam.jdField_c_of_type_JavaLangString);
    }
    if ((this.tipParam.jdField_a_of_type_JavaUtilArrayList != null) && (!this.tipParam.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject = ((ArrayList)this.tipParam.jdField_a_of_type_JavaUtilArrayList.clone()).iterator();
      if (((Iterator)localObject).hasNext())
      {
        MessageForGrayTips.HighlightItem localHighlightItem = (MessageForGrayTips.HighlightItem)((Iterator)localObject).next();
        UniteGrayTip.HightlightParam localHightlightParam = new UniteGrayTip.HightlightParam();
        localHightlightParam.start.set(localHighlightItem.start);
        localHightlightParam.end.set(localHighlightItem.end);
        localHightlightParam.uin.set(localHighlightItem.uin);
        PBUInt32Field localPBUInt32Field = localHightlightParam.needUpdateNick;
        if (localHighlightItem.needUpdateNick) {}
        for (i = 1;; i = 0)
        {
          localPBUInt32Field.set(i);
          localHightlightParam.actionType.set(localHighlightItem.actionType);
          localHightlightParam.textColor.set(localHighlightItem.textColor);
          if (!TextUtils.isEmpty(localHighlightItem.icon)) {
            localHightlightParam.icon.set(localHighlightItem.icon);
          }
          if (!TextUtils.isEmpty(localHighlightItem.iconAlt)) {
            localHightlightParam.iconAlt.set(localHighlightItem.iconAlt);
          }
          if (!TextUtils.isEmpty(localHighlightItem.mMsgActionData)) {
            localHightlightParam.mMsgActionData.set(localHighlightItem.mMsgActionData);
          }
          if (!TextUtils.isEmpty(localHighlightItem.mMsg_A_ActionData)) {
            localHightlightParam.mMsg_A_ActionData.set(localHighlightItem.mMsg_A_ActionData);
          }
          localUniteGrayTipMsg.hightlight_item.add(localHightlightParam);
          break;
        }
      }
    }
    Object localObject = localUniteGrayTipMsg.isLocalTroopMsg;
    if (this.tipParam.f) {}
    for (int i = j;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new UniteGrayTip.BusinessData();
      ((UniteGrayTip.BusinessData)localObject).haveRead.set(this.hasRead);
      ((UniteGrayTip.BusinessData)localObject).subType.set(this.subType);
      if (!TextUtils.isEmpty(this.masterUin)) {
        ((UniteGrayTip.BusinessData)localObject).masterUin.set(this.masterUin);
      }
      if (!TextUtils.isEmpty(this.extUin)) {
        ((UniteGrayTip.BusinessData)localObject).extUin.set(this.extUin);
      }
      if (!TextUtils.isEmpty(this.taskId)) {
        ((UniteGrayTip.BusinessData)localObject).taskId.set(this.taskId);
      }
      ((UniteGrayTip.BusinessData)localObject).editState.set(this.editState);
      ((UniteGrayTip.BusinessData)localObject).editTime.set(this.editTime);
      if (!TextUtils.isEmpty(this.editMsgData)) {
        ((UniteGrayTip.BusinessData)localObject).editMsgData.set(this.editMsgData);
      }
      if (!TextUtils.isEmpty(this.caidanAnimUrl)) {
        ((UniteGrayTip.BusinessData)localObject).caidanAnimUrl.set(this.caidanAnimUrl);
      }
      if (!TextUtils.isEmpty(this.caidanAnimUrlMd5)) {
        ((UniteGrayTip.BusinessData)localObject).caidanAnimUrlMd5.set(this.caidanAnimUrlMd5);
      }
      localUniteGrayTipMsg.business_data.set((MessageMicro)localObject);
      this.msgData = localUniteGrayTipMsg.toByteArray();
      return;
    }
  }
  
  private MessageForGrayTips.HighlightItem findHighlightItem(int paramInt, List<MessageForGrayTips.HighlightItem> paramList)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      MessageForGrayTips.HighlightItem localHighlightItem = (MessageForGrayTips.HighlightItem)paramList.get(i);
      if ((paramInt >= localHighlightItem.start) && (paramInt < localHighlightItem.end)) {
        return localHighlightItem;
      }
      i += 1;
    }
    return null;
  }
  
  @NonNull
  private String getSummaryForUniteGrayTip(String paramString)
  {
    Object localObject = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      MessageForGrayTips.HighlightItem localHighlightItem = findHighlightItem(i, this.tipParam.jdField_a_of_type_JavaUtilArrayList);
      if ((localHighlightItem != null) && (!TextUtils.isEmpty(localHighlightItem.icon)))
      {
        String str = paramString.substring(localHighlightItem.start, localHighlightItem.end);
        if (!TextUtils.isEmpty(localHighlightItem.iconAlt)) {
          ((StringBuilder)localObject).append(str);
        }
        i += localHighlightItem.end - localHighlightItem.start - 1;
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append(c);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("MessageForUniteGrayTip", 2, "getSummaryMsg() msg=[" + paramString + "],summary=[" + (String)localObject + "]");
    }
    return localObject;
  }
  
  public void doParse()
  {
    if (this.msgData == null)
    {
      QLog.e(aucg.jdField_a_of_type_JavaLangString, 1, "doParse failed for msgData == null");
      return;
    }
    UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
    label740:
    label746:
    for (;;)
    {
      int k;
      String str2;
      String str1;
      int m;
      Object localObject2;
      try
      {
        localUniteGrayTipMsg.mergeFrom(this.msgData);
        int j = localUniteGrayTipMsg.graytip_id.get();
        k = localUniteGrayTipMsg.graytip_level.get();
        str2 = localUniteGrayTipMsg.graytip_key.get();
        str1 = localUniteGrayTipMsg.content.get();
        m = localUniteGrayTipMsg.isLocalTroopMsg.get();
        if ((!localUniteGrayTipMsg.graytip_mutex_id.has()) || (localUniteGrayTipMsg.graytip_mutex_id.size() <= 0)) {
          break label740;
        }
        localObject2 = (ArrayList)localUniteGrayTipMsg.graytip_mutex_id.get();
        int[] arrayOfInt = new int[((ArrayList)localObject2).size()];
        int i = 0;
        if (i >= ((ArrayList)localObject2).size() - 1) {
          break label746;
        }
        arrayOfInt[i] = ((Integer)((ArrayList)localObject2).get(i)).intValue();
        i += 1;
        continue;
        Iterator localIterator = null;
        localObject2 = localIterator;
        if (localUniteGrayTipMsg.hightlight_item.has())
        {
          localObject2 = localIterator;
          if (localUniteGrayTipMsg.hightlight_item.size() > 0)
          {
            localObject2 = new ArrayList();
            localIterator = ((ArrayList)localUniteGrayTipMsg.hightlight_item.get()).iterator();
            if (localIterator.hasNext())
            {
              UniteGrayTip.HightlightParam localHightlightParam = (UniteGrayTip.HightlightParam)localIterator.next();
              i = localHightlightParam.start.get();
              int n = localHightlightParam.end.get();
              long l = localHightlightParam.uin.get();
              int i1 = localHightlightParam.needUpdateNick.get();
              int i2 = localHightlightParam.actionType.get();
              String str3 = localHightlightParam.icon.get();
              String str4 = localHightlightParam.iconAlt.get();
              int i3 = localHightlightParam.textColor.get();
              ((ArrayList)localObject2).add(new MessageForGrayTips.HighlightItem(i, n, l, i1, i2, localHightlightParam.mMsgActionData.get(), localHightlightParam.mMsg_A_ActionData.get(), str3, str4, i3));
              continue;
            }
          }
        }
        this.tipParam = new aucf(this.frienduin, this.senderuin, str1, this.istroop, this.msgtype, j, this.time);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e(aucg.jdField_a_of_type_JavaLangString, 1, "MessageForUniteGrayTip, doParese failed, " + localException.getMessage());
        return;
      }
      this.tipParam.jdField_d_of_type_JavaLangString = str2;
      this.tipParam.jdField_d_of_type_Int = k;
      this.tipParam.jdField_b_of_type_ArrayOfInt = localException;
      this.tipParam.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
      Object localObject1 = this.tipParam;
      if (m == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((aucf)localObject1).f = bool;
        this.msg = str1;
        localObject1 = (UniteGrayTip.BusinessData)localUniteGrayTipMsg.business_data.get();
        if (localObject1 == null) {
          break;
        }
        this.hasRead = ((UniteGrayTip.BusinessData)localObject1).haveRead.get();
        this.subType = ((UniteGrayTip.BusinessData)localObject1).subType.get();
        if (((UniteGrayTip.BusinessData)localObject1).masterUin.has()) {
          this.masterUin = ((UniteGrayTip.BusinessData)localObject1).masterUin.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).extUin.has()) {
          this.extUin = ((UniteGrayTip.BusinessData)localObject1).extUin.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).taskId.has()) {
          this.taskId = ((UniteGrayTip.BusinessData)localObject1).taskId.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).editState.has()) {
          this.editState = ((UniteGrayTip.BusinessData)localObject1).editState.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).editTime.has()) {
          this.editTime = ((UniteGrayTip.BusinessData)localObject1).editTime.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).editMsgData.has()) {
          this.editMsgData = ((UniteGrayTip.BusinessData)localObject1).editMsgData.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).caidanAnimUrl.has()) {
          this.caidanAnimUrl = ((UniteGrayTip.BusinessData)localObject1).caidanAnimUrl.get();
        }
        if (!((UniteGrayTip.BusinessData)localObject1).caidanAnimUrlMd5.has()) {
          break;
        }
        this.caidanAnimUrlMd5 = ((UniteGrayTip.BusinessData)localObject1).caidanAnimUrlMd5.get();
        return;
      }
      localObject1 = null;
    }
  }
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, Drawable.Callback paramCallback)
  {
    Object localObject2;
    if ((this.tipParam == null) || (this.tipParam.jdField_a_of_type_JavaUtilArrayList == null) || (this.tipParam.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject2 = new SpannableStringBuilder(this.msg);
      return localObject2;
    }
    Collections.sort(this.tipParam.jdField_a_of_type_JavaUtilArrayList, new aubw(this));
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("revoke msg GrayTips -> msg=").append(this.msg);
    Object localObject3 = "";
    Object localObject1 = this.msg;
    int n = 0;
    int m = 0;
    if (this.contentDescription == null) {
      localObject2 = new StringBuilder();
    }
    for (int k = 1;; k = 0)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
      Iterator localIterator = this.tipParam.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        Object localObject4 = (MessageForGrayTips.HighlightItem)localIterator.next();
        int j = ((MessageForGrayTips.HighlightItem)localObject4).start - n;
        int i1 = ((MessageForGrayTips.HighlightItem)localObject4).end - n;
        int i;
        label210:
        label227:
        String str2;
        String str3;
        if (j > ((String)localObject1).length())
        {
          i = ((String)localObject1).length();
          if (i1 <= ((String)localObject1).length()) {
            break label504;
          }
          j = ((String)localObject1).length();
          localStringBuilder.append(" ;item.start=").append(((MessageForGrayTips.HighlightItem)localObject4).start).append(",end=").append(((MessageForGrayTips.HighlightItem)localObject4).end);
          localStringBuilder.append("|index1=").append(i).append(",index2=").append(j).append("|lastEnd=").append(n);
          String str1 = ((String)localObject1).substring(0, i);
          str2 = (String)localObject3 + str1;
          str3 = ((String)localObject1).substring(i, j);
          if (k != 0)
          {
            ((StringBuilder)localObject2).append(str1);
            if (TextUtils.isEmpty(((MessageForGrayTips.HighlightItem)localObject4).icon)) {
              ((StringBuilder)localObject2).append(str3);
            }
          }
          localObject3 = ((String)localObject1).substring(j, ((String)localObject1).length());
          n = ((MessageForGrayTips.HighlightItem)localObject4).end;
          ((MessageForGrayTips.HighlightItem)localObject4).start = str2.length();
          if (!((MessageForGrayTips.HighlightItem)localObject4).needUpdateNick) {
            break label519;
          }
          localObject1 = str2 + localTroopManager.a(this.frienduin, new StringBuilder().append("").append(((MessageForGrayTips.HighlightItem)localObject4).uin).toString());
          m = 1;
        }
        for (;;)
        {
          ((MessageForGrayTips.HighlightItem)localObject4).end = ((String)localObject1).length();
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          break;
          i = j;
          if (j >= 0) {
            break label210;
          }
          i = 0;
          break label210;
          label504:
          j = i1;
          if (i1 >= 0) {
            break label227;
          }
          j = 0;
          break label227;
          label519:
          localObject1 = str2 + str3;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GrayTips", 2, localStringBuilder.toString());
      }
      if (k != 0)
      {
        ((StringBuilder)localObject2).append((String)localObject1);
        this.contentDescription = ((StringBuilder)localObject2).toString();
        QLog.i("content", 1, this.contentDescription);
      }
      localObject1 = (String)localObject3 + (String)localObject1;
      if (m != 0)
      {
        this.msg = ((String)localObject1);
        this.tipParam.jdField_c_of_type_JavaLangString = ((String)localObject1);
      }
      if (this.tipParam.jdField_b_of_type_Int == 2)
      {
        localObject1 = new SpannableStringBuilder(new QQText((CharSequence)localObject1, 3));
        label667:
        localObject3 = this.tipParam.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (MessageForGrayTips.HighlightItem)((Iterator)localObject3).next();
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((MessageForGrayTips.HighlightItem)localObject2).icon))
          {
            ((SpannableStringBuilder)localObject1).setSpan(new MessageForGrayTips.HightlightClickableSpan(paramQQAppInterface, ((MessageForGrayTips.HighlightItem)localObject2).textColor, paramContext, (MessageForGrayTips.HighlightItem)localObject2, this), ((MessageForGrayTips.HighlightItem)localObject2).start, ((MessageForGrayTips.HighlightItem)localObject2).end, 33);
            continue;
            localObject1 = new SpannableStringBuilder(new bczs((CharSequence)localObject1, 16));
            break label667;
          }
          MessageForGrayTips.decodeImageSpan(paramContext, (SpannableStringBuilder)localObject1, (MessageForGrayTips.HighlightItem)localObject2, paramBoolean, paramCallback, this);
          if (((MessageForGrayTips.HighlightItem)localObject2).actionType == 1) {
            ((SpannableStringBuilder)localObject1).setSpan(new MessageForGrayTips.HightlightClickableSpan(paramQQAppInterface, ((MessageForGrayTips.HighlightItem)localObject2).textColor, paramContext, (MessageForGrayTips.HighlightItem)localObject2, this), ((MessageForGrayTips.HighlightItem)localObject2).start, ((MessageForGrayTips.HighlightItem)localObject2).end, 33);
          }
        }
      }
      localObject2 = null;
    }
  }
  
  public String getSummaryMsg()
  {
    String str = this.msg;
    if ((this.tipParam != null) && (this.tipParam.jdField_b_of_type_Int == 655397) && (str != null)) {
      return getSummaryForUniteGrayTip(str);
    }
    return super.getSummaryMsg();
  }
  
  public void initGrayTipMsg(QQAppInterface paramQQAppInterface, aucf paramaucf)
  {
    if ((paramaucf == null) || (!paramaucf.a()))
    {
      if (QLog.isColorLevel()) {
        if (paramaucf != null) {
          break label53;
        }
      }
      label53:
      for (paramQQAppInterface = "null tipParam";; paramQQAppInterface = "msgtype: " + paramaucf.jdField_c_of_type_Int + " id: " + paramaucf.jdField_b_of_type_Int)
      {
        QLog.e(aucg.jdField_a_of_type_JavaLangString, 2, "revoke msg createGrayTipMsg failed, error: " + paramQQAppInterface);
        return;
      }
    }
    init(paramQQAppInterface.getCurrentAccountUin(), paramaucf.jdField_a_of_type_JavaLangString, paramaucf.jdField_b_of_type_JavaLangString, paramaucf.jdField_c_of_type_JavaLangString, paramaucf.jdField_a_of_type_Long, paramaucf.jdField_c_of_type_Int, paramaucf.jdField_a_of_type_Int, paramaucf.jdField_a_of_type_Long);
    this.mIsParsed = true;
    this.isread = true;
    this.tipParam = paramaucf;
    this.msgData = null;
  }
  
  public boolean needShowTimeStamp()
  {
    if ((this.tipParam != null) && (this.tipParam.jdField_b_of_type_Int == 656395)) {}
    while ((this.tipParam != null) && (this.tipParam.jdField_b_of_type_Int == 656396)) {
      return false;
    }
    return super.needShowTimeStamp();
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    try
    {
      encode();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(aucg.jdField_a_of_type_JavaLangString, 1, "MessageForUniteGrayTip, prewrite failed, " + localException.getMessage());
    }
  }
  
  public void updateUniteGrayTipMsg(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aucg.jdField_a_of_type_JavaLangString, 2, "updateUniteGrayTipMsg");
    }
    this.msg = paramString;
    if (this.tipParam != null)
    {
      this.tipParam.jdField_c_of_type_JavaLangString = paramString;
      prewrite();
      paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
    }
  }
  
  public void updateUniteGrayTipMsgData(QQAppInterface paramQQAppInterface)
  {
    prewrite();
    paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.MessageForUniteGrayTip
 * JD-Core Version:    0.7.0.1
 */