package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.RichMsg.FoldMsg;

public class MessageForFoldMsg
  extends MessageForText
{
  public boolean foldFlag;
  public boolean foldFlagTemp;
  public String redBagId;
  public String redBagIndex;
  
  protected void doParse()
  {
    doParse(false);
  }
  
  public void init(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    this.redBagId = paramString1;
    this.redBagIndex = paramString2;
    this.mPasswdRedBagSender = paramLong;
    this.foldFlag = paramBoolean1;
    if (paramBoolean2)
    {
      if (this.foldFlag) {
        this.msgtype = -2006;
      } else {
        this.msgtype = -1000;
      }
      saveExtInfoToExtStr("redbag_fold_msg", "true");
    }
  }
  
  public boolean isSupportFTS()
  {
    if (!this.foldFlag) {
      return super.isSupportFTS();
    }
    return false;
  }
  
  protected void postRead()
  {
    int i = this.istroop;
    boolean bool = true;
    if (i != 1)
    {
      super.postRead();
      return;
    }
    RichMsg.FoldMsg localFoldMsg = new RichMsg.FoldMsg();
    for (;;)
    {
      try
      {
        localFoldMsg.mergeFrom(this.msgData);
        if (localFoldMsg.fold_flags.get() == 1)
        {
          this.foldFlag = bool;
          this.redBagId = localFoldMsg.redbag_id.get().toStringUtf8();
          this.msg = localFoldMsg.msg_content.get().toStringUtf8();
          this.mPasswdRedBagSender = localFoldMsg.redbag_sender_uin.get();
          this.redBagIndex = localFoldMsg.redbag_index.get().toStringUtf8();
          init(this.foldFlag, this.redBagId, this.redBagIndex, this.mPasswdRedBagSender, false);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("msgFold", 2, "MessageForFoldMsg postRead error ", localException);
        }
        return;
      }
      bool = false;
    }
  }
  
  protected void prewrite()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFoldMsg
 * JD-Core Version:    0.7.0.1
 */