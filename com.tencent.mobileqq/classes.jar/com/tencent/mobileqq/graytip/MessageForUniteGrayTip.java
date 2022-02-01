package com.tencent.mobileqq.graytip;

import android.content.Context;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageForGrayTips;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import localpb.uniteGrayTip.UniteGrayTip.BusinessData;
import localpb.uniteGrayTip.UniteGrayTip.HightlightParam;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;
import mqq.app.AppRuntime;

public class MessageForUniteGrayTip
  extends ChatMessage
{
  public static final String KEY_BYTES_CONTENT = "bytes_content";
  public static final String KEY_UINT64_BUSI_ID = "uint64_busi_id";
  public static final String KEY_UINT64_BUSI_TYPE = "uint64_busi_type";
  public static final String KEY_UINT64_TEMPL_ID = "uint64_templ_id";
  public static final String KEY_UINT64_TIPS_SEQ_ID = "uint64_tips_seq_id";
  public static final String TAG = "MessageForUniteGrayTip";
  public String appGuideTipsOpKey;
  public String caidanAnimUrl;
  public String caidanAnimUrlMd5;
  public UniteGrayTipCallBack callback;
  public String contentDescription;
  public boolean dkTipHasReport = false;
  public boolean docTipHasReport = false;
  public String editMsgData = null;
  public int editState = 0;
  public long editTime = 0L;
  @notColumn
  public UniteEntity entity;
  public String extUin;
  public int hasRead;
  public String masterUin;
  public int subType;
  public String taskId;
  public UniteGrayTipParam tipParam;
  public boolean troopLuckyCharacterTipsHasReport = false;
  public boolean troopMemberLevelTipHasReport = false;
  
  private void encode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private GrayTipsMessageConstants.HighlightItem findHighlightItem(int paramInt, List<GrayTipsMessageConstants.HighlightItem> paramList)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      GrayTipsMessageConstants.HighlightItem localHighlightItem = (GrayTipsMessageConstants.HighlightItem)paramList.get(i);
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
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.tipParam.b();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      GrayTipsMessageConstants.HighlightItem localHighlightItem = findHighlightItem(i, (List)localObject2);
      if ((localHighlightItem != null) && (!TextUtils.isEmpty(localHighlightItem.icon)))
      {
        String str = paramString.substring(localHighlightItem.start, localHighlightItem.end);
        if (!TextUtils.isEmpty(localHighlightItem.iconAlt)) {
          ((StringBuilder)localObject1).append(str);
        }
        i += localHighlightItem.end - localHighlightItem.start - 1;
      }
      else
      {
        ((StringBuilder)localObject1).append(c);
      }
      i += 1;
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getSummaryMsg() msg=[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("],summary=[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.d("MessageForUniteGrayTip", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  protected void doParse()
  {
    if (this.msgData == null)
    {
      QLog.e("MessageForUniteGrayTip", 1, "doParse failed for msgData == null");
      return;
    }
    UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
    for (;;)
    {
      try
      {
        localUniteGrayTipMsg.mergeFrom(this.msgData);
        int j = localUniteGrayTipMsg.graytip_id.get();
        int k = localUniteGrayTipMsg.graytip_level.get();
        String str2 = localUniteGrayTipMsg.graytip_key.get();
        String str1 = localUniteGrayTipMsg.content.get();
        int m = localUniteGrayTipMsg.isLocalTroopMsg.get();
        bool = localUniteGrayTipMsg.graytip_mutex_id.has();
        Object localObject4 = null;
        if ((!bool) || (localUniteGrayTipMsg.graytip_mutex_id.size() <= 0)) {
          break label778;
        }
        localObject3 = (ArrayList)localUniteGrayTipMsg.graytip_mutex_id.get();
        Object localObject1 = new int[((ArrayList)localObject3).size()];
        int i = 0;
        if (i >= ((ArrayList)localObject3).size() - 1) {
          break label775;
        }
        localObject1[i] = ((Integer)((ArrayList)localObject3).get(i)).intValue();
        i += 1;
        continue;
        localObject3 = localObject4;
        if (localUniteGrayTipMsg.hightlight_item.has())
        {
          localObject3 = localObject4;
          if (localUniteGrayTipMsg.hightlight_item.size() > 0)
          {
            localObject4 = new ArrayList();
            localObject5 = ((ArrayList)localUniteGrayTipMsg.hightlight_item.get()).iterator();
            localObject3 = localObject4;
            if (((Iterator)localObject5).hasNext())
            {
              localObject3 = (UniteGrayTip.HightlightParam)((Iterator)localObject5).next();
              i = ((UniteGrayTip.HightlightParam)localObject3).start.get();
              n = ((UniteGrayTip.HightlightParam)localObject3).end.get();
              l = ((UniteGrayTip.HightlightParam)localObject3).uin.get();
              int i1 = ((UniteGrayTip.HightlightParam)localObject3).needUpdateNick.get();
              int i2 = ((UniteGrayTip.HightlightParam)localObject3).actionType.get();
              String str3 = ((UniteGrayTip.HightlightParam)localObject3).icon.get();
              String str4 = ((UniteGrayTip.HightlightParam)localObject3).iconAlt.get();
              int i3 = ((UniteGrayTip.HightlightParam)localObject3).textColor.get();
              ((ArrayList)localObject4).add(new GrayTipsMessageConstants.HighlightItem(i, n, l, i1, i2, ((UniteGrayTip.HightlightParam)localObject3).mMsgActionData.get(), ((UniteGrayTip.HightlightParam)localObject3).mMsg_A_ActionData.get(), str3, str4, i3));
              continue;
            }
          }
        }
        localObject4 = this.frienduin;
        Object localObject5 = this.senderuin;
        i = this.istroop;
        int n = this.msgtype;
        long l = this.time;
        try
        {
          this.tipParam = new UniteGrayTipParam((String)localObject4, (String)localObject5, str1, i, n, j, l);
          this.tipParam.p = str2;
          this.tipParam.n = k;
          this.tipParam.o = ((int[])localObject1);
          this.tipParam.a((ArrayList)localObject3);
          localObject1 = this.tipParam;
          if (m != 1) {
            break label784;
          }
          bool = true;
          ((UniteGrayTipParam)localObject1).q = bool;
          this.msg = str1;
          localObject1 = (UniteGrayTip.BusinessData)localUniteGrayTipMsg.business_data.get();
          if (localObject1 == null) {
            break label774;
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
            break label774;
          }
          this.caidanAnimUrlMd5 = ((UniteGrayTip.BusinessData)localObject1).caidanAnimUrlMd5.get();
          return;
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2) {}
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("MessageForUniteGrayTip, doParese failed, ");
      ((StringBuilder)localObject3).append(localException2.getMessage());
      QLog.e("MessageForUniteGrayTip", 1, ((StringBuilder)localObject3).toString());
      label774:
      return;
      label775:
      continue;
      label778:
      Object localObject2 = null;
      continue;
      label784:
      boolean bool = false;
    }
  }
  
  public SpannableStringBuilder getHightlightMsgText(AppRuntime paramAppRuntime, Context paramContext, boolean paramBoolean, Drawable.Callback paramCallback)
  {
    Object localObject1 = this.tipParam;
    if ((localObject1 != null) && (((UniteGrayTipParam)localObject1).b() != null) && (!this.tipParam.b().isEmpty()))
    {
      localObject1 = this.tipParam.b();
      Collections.sort((List)localObject1, new MessageForUniteGrayTip.1(this));
      this.tipParam.a((ArrayList)localObject1);
      StringBuilder localStringBuilder2 = new StringBuilder(256);
      localStringBuilder2.append("revoke msg GrayTips -> msg=");
      localStringBuilder2.append(this.msg);
      String str2 = this.msg;
      StringBuilder localStringBuilder1 = null;
      int k;
      if (this.contentDescription == null)
      {
        localStringBuilder1 = new StringBuilder();
        k = 1;
      }
      else
      {
        k = 0;
      }
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      String str1 = "";
      localObject1 = "";
      int n = 0;
      int m = 0;
      while (localIterator.hasNext())
      {
        GrayTipsMessageConstants.HighlightItem localHighlightItem = (GrayTipsMessageConstants.HighlightItem)localIterator.next();
        int j = localHighlightItem.start - n;
        int i1 = localHighlightItem.end - n;
        int i;
        if (j > str2.length())
        {
          i = str2.length();
        }
        else
        {
          i = j;
          if (j < 0) {
            i = 0;
          }
        }
        if (i1 > str2.length())
        {
          j = str2.length();
        }
        else
        {
          j = i1;
          if (i1 < 0) {
            j = 0;
          }
        }
        localStringBuilder2.append(" ;item.start=");
        localStringBuilder2.append(localHighlightItem.start);
        localStringBuilder2.append(",end=");
        localStringBuilder2.append(localHighlightItem.end);
        localStringBuilder2.append("|index1=");
        localStringBuilder2.append(i);
        localStringBuilder2.append(",index2=");
        localStringBuilder2.append(j);
        localStringBuilder2.append("|lastEnd=");
        localStringBuilder2.append(n);
        Object localObject2 = str2.substring(0, i);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject3).toString();
        localObject3 = str2.substring(i, j);
        if (k != 0)
        {
          localStringBuilder1.append((String)localObject2);
          if (TextUtils.isEmpty(localHighlightItem.icon)) {
            localStringBuilder1.append((String)localObject3);
          }
        }
        str2 = str2.substring(j, str2.length());
        n = localHighlightItem.end;
        localHighlightItem.start = ((String)localObject1).length();
        if (localHighlightItem.needUpdateNick)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = (ITroopMemberNameService)paramAppRuntime.getRuntimeService(ITroopMemberNameService.class, str1);
          localObject3 = this.frienduin;
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(str1);
          localStringBuilder3.append(localHighlightItem.uin);
          ((StringBuilder)localObject2).append(((ITroopMemberNameService)localObject1).getTroopMemberName((String)localObject3, localStringBuilder3.toString()));
          localObject1 = ((StringBuilder)localObject2).toString();
          m = 1;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append((String)localObject3);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        localHighlightItem.end = ((String)localObject1).length();
      }
      if (QLog.isColorLevel()) {
        QLog.d("GrayTips", 2, localStringBuilder2.toString());
      }
      if (k != 0)
      {
        localStringBuilder1.append(str2);
        this.contentDescription = localStringBuilder1.toString();
        QLog.i("content", 1, this.contentDescription);
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localObject1);
      localStringBuilder1.append(str2);
      localObject1 = localStringBuilder1.toString();
      if (m != 0)
      {
        this.msg = ((String)localObject1);
        this.tipParam.g = ((String)localObject1);
      }
      return ((IMessageForGrayTips)paramAppRuntime.getRuntimeService(IMessageForGrayTips.class, str1)).getSpannableStringBuilder(this, paramContext, paramBoolean, paramCallback, (String)localObject1);
    }
    return new SpannableStringBuilder(this.msg);
  }
  
  public String getSummaryMsg()
  {
    String str = this.msg;
    UniteGrayTipParam localUniteGrayTipParam = this.tipParam;
    if ((localUniteGrayTipParam != null) && (localUniteGrayTipParam.i == 655397) && (str != null)) {
      return getSummaryForUniteGrayTip(str);
    }
    return super.getSummaryMsg();
  }
  
  public void initGrayTipMsg(AppRuntime paramAppRuntime, UniteGrayTipParam paramUniteGrayTipParam)
  {
    if ((paramUniteGrayTipParam != null) && (paramUniteGrayTipParam.a()))
    {
      init(paramAppRuntime.getAccount(), paramUniteGrayTipParam.e, paramUniteGrayTipParam.f, paramUniteGrayTipParam.g, paramUniteGrayTipParam.j, paramUniteGrayTipParam.k, paramUniteGrayTipParam.h, paramUniteGrayTipParam.j);
      this.mIsParsed = true;
      this.isread = true;
      this.tipParam = paramUniteGrayTipParam;
      this.msgData = null;
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramUniteGrayTipParam == null)
      {
        paramAppRuntime = "null tipParam";
      }
      else
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("msgtype: ");
        paramAppRuntime.append(paramUniteGrayTipParam.k);
        paramAppRuntime.append(" id: ");
        paramAppRuntime.append(paramUniteGrayTipParam.i);
        paramAppRuntime = paramAppRuntime.toString();
      }
      paramUniteGrayTipParam = new StringBuilder();
      paramUniteGrayTipParam.append("revoke msg createGrayTipMsg failed, error: ");
      paramUniteGrayTipParam.append(paramAppRuntime);
      QLog.e("MessageForUniteGrayTip", 2, paramUniteGrayTipParam.toString());
    }
  }
  
  public boolean needShowTimeStamp()
  {
    UniteGrayTipParam localUniteGrayTipParam = this.tipParam;
    if ((localUniteGrayTipParam != null) && (localUniteGrayTipParam.i == 656395)) {
      return false;
    }
    localUniteGrayTipParam = this.tipParam;
    if ((localUniteGrayTipParam != null) && (localUniteGrayTipParam.i == 656396)) {
      return false;
    }
    return super.needShowTimeStamp();
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    try
    {
      encode();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MessageForUniteGrayTip, prewrite failed, ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("MessageForUniteGrayTip", 1, localStringBuilder.toString());
    }
  }
  
  public void updateUniteGrayTipMsg(AppRuntime paramAppRuntime, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForUniteGrayTip", 2, "updateUniteGrayTipMsg");
    }
    this.msg = paramString;
    UniteGrayTipParam localUniteGrayTipParam = this.tipParam;
    if (localUniteGrayTipParam != null)
    {
      localUniteGrayTipParam.g = paramString;
      prewrite();
      ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
    }
  }
  
  public void updateUniteGrayTipMsgData(AppRuntime paramAppRuntime)
  {
    prewrite();
    ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.MessageForUniteGrayTip
 * JD-Core Version:    0.7.0.1
 */