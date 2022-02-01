package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ForwardSdkShareProcessor$RichStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  boolean isDidRich = false;
  AtomicBoolean needRich = new AtomicBoolean(false);
  AtomicInteger retryCount = new AtomicInteger(0);
  
  ForwardSdkShareProcessor$RichStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "RichStep";
    reset();
  }
  
  private void reportAfter(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "13");
    ((Bundle)localObject).putString("intext_3", "0");
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (paramInt1 != 0) {}
    for (int i = 1;; i = 0)
    {
      ((Bundle)localObject).putString("intext_1", i);
      ((Bundle)localObject).putString("stringext_2", "" + paramInt1);
      ((Bundle)localObject).putString("stringext_3", "1");
      ((Bundle)localObject).putString("intext_5", "" + paramLong);
      ((Bundle)localObject).putString("intext_2", "" + paramInt2);
      ((Bundle)localObject).putString("intext_4", "" + paramInt3);
      if (paramInt1 != 0) {
        ((Bundle)localObject).putString("stringext_1", this.this$0.mTargetUrl);
      }
      ReportCenter.a().a((Bundle)localObject, "", this.this$0.app.getCurrentAccountUin(), false, this.this$0.isSdkShare());
      if (QLog.isColorLevel())
      {
        localObject = "RichStep|run|ret=" + paramInt1 + ",lack=" + ForwardSdkShareProcessor.access$000(this.this$0) + ",cost=" + paramLong;
        if ((paramInt1 == 0) && (paramLong <= 3000L)) {
          break;
        }
        QLog.e("BaseTransProcessor", 2, (String)localObject);
      }
      return;
    }
    QLog.d("BaseTransProcessor", 2, (String)localObject);
  }
  
  private void reportBefore()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "53");
    localBundle.putString("intext_4", "1");
    localBundle.putString("intext_3", "0");
    localBundle.putString("intext_2", "" + ForwardSdkShareProcessor.access$000(this.this$0));
    localBundle.putString("stringext_1", this.this$0.mTargetUrl);
    ReportCenter.a().a(localBundle, "", this.this$0.app.getCurrentAccountUin(), false, this.this$0.isSdkShare());
  }
  
  /* Error */
  int doRich()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 164	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:reportBefore	()V
    //   4: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   7: lstore 6
    //   9: iconst_m1
    //   10: istore_2
    //   11: aload_0
    //   12: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   15: invokestatic 142	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:access$000	(Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;)I
    //   18: istore 5
    //   20: iload_2
    //   21: istore_1
    //   22: aload_0
    //   23: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   26: getfield 174	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mAppContext	Landroid/content/Context;
    //   29: aload_0
    //   30: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   33: getfield 107	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mTargetUrl	Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   40: getfield 117	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   46: invokestatic 179	com/tencent/open/base/ShareProcessorUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;
    //   49: astore 11
    //   51: iload_2
    //   52: istore_1
    //   53: aload 11
    //   55: iconst_0
    //   56: aaload
    //   57: checkcast 181	java/lang/Integer
    //   60: invokevirtual 184	java/lang/Integer:intValue	()I
    //   63: istore_2
    //   64: iload_2
    //   65: ifne +597 -> 662
    //   68: iload_2
    //   69: istore_1
    //   70: aload 11
    //   72: iconst_1
    //   73: aaload
    //   74: checkcast 186	java/lang/String
    //   77: astore 9
    //   79: iload_2
    //   80: istore_1
    //   81: aload 11
    //   83: iconst_2
    //   84: aaload
    //   85: checkcast 186	java/lang/String
    //   88: astore 10
    //   90: iload_2
    //   91: istore_1
    //   92: aload 11
    //   94: iconst_3
    //   95: aaload
    //   96: checkcast 186	java/lang/String
    //   99: astore 11
    //   101: iload_2
    //   102: istore_1
    //   103: aload 9
    //   105: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: istore 8
    //   110: iload 8
    //   112: ifne +544 -> 656
    //   115: aload_0
    //   116: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   119: getfield 195	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareTitle	Ljava/lang/String;
    //   122: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +30 -> 155
    //   128: aload_0
    //   129: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   132: aload_0
    //   133: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   136: invokestatic 142	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:access$000	(Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;)I
    //   139: bipush 251
    //   141: iand
    //   142: invokestatic 199	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:access$002	(Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;I)I
    //   145: pop
    //   146: aload_0
    //   147: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   150: aload 9
    //   152: putfield 195	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareTitle	Ljava/lang/String;
    //   155: iconst_4
    //   156: istore 4
    //   158: iload 4
    //   160: istore_3
    //   161: iload 4
    //   163: istore_1
    //   164: aload 10
    //   166: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +64 -> 233
    //   172: iload 4
    //   174: iconst_2
    //   175: ior
    //   176: istore 4
    //   178: iload 4
    //   180: istore_3
    //   181: iload 4
    //   183: istore_1
    //   184: aload_0
    //   185: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   188: getfield 202	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareSummary	Ljava/lang/String;
    //   191: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifeq +39 -> 233
    //   197: iload 4
    //   199: istore_1
    //   200: aload_0
    //   201: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   204: aload_0
    //   205: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   208: invokestatic 142	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:access$000	(Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;)I
    //   211: bipush 253
    //   213: iand
    //   214: invokestatic 199	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:access$002	(Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;I)I
    //   217: pop
    //   218: iload 4
    //   220: istore_1
    //   221: aload_0
    //   222: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   225: aload 10
    //   227: putfield 202	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareSummary	Ljava/lang/String;
    //   230: iload 4
    //   232: istore_3
    //   233: iload_3
    //   234: istore 4
    //   236: iload_3
    //   237: istore_1
    //   238: aload 11
    //   240: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +77 -> 320
    //   246: iload_3
    //   247: iconst_1
    //   248: ior
    //   249: istore_3
    //   250: iload_3
    //   251: istore 4
    //   253: iload_3
    //   254: istore_1
    //   255: aload_0
    //   256: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   259: getfield 205	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mRemoteImgUrl	Ljava/lang/String;
    //   262: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifeq +55 -> 320
    //   268: iload_3
    //   269: istore 4
    //   271: iload_3
    //   272: istore_1
    //   273: aload_0
    //   274: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   277: getfield 208	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mLocalImgUrl	Ljava/lang/String;
    //   280: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   283: ifeq +37 -> 320
    //   286: iload_3
    //   287: istore_1
    //   288: aload_0
    //   289: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   292: aload_0
    //   293: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   296: invokestatic 142	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:access$000	(Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;)I
    //   299: bipush 254
    //   301: iand
    //   302: invokestatic 199	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:access$002	(Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;I)I
    //   305: pop
    //   306: iload_3
    //   307: istore_1
    //   308: aload_0
    //   309: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   312: aload 11
    //   314: putfield 205	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mRemoteImgUrl	Ljava/lang/String;
    //   317: iload_3
    //   318: istore 4
    //   320: iload 4
    //   322: istore_1
    //   323: aload_0
    //   324: getfield 25	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:needRich	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   327: iconst_0
    //   328: invokevirtual 211	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   331: iload 4
    //   333: istore_1
    //   334: aload_0
    //   335: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   338: getfield 117	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   341: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   344: aload_0
    //   345: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   348: getfield 219	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   351: getfield 224	com/tencent/mobileqq/transfile/TransferRequest:mPeerUin	Ljava/lang/String;
    //   354: aload_0
    //   355: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   358: getfield 219	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   361: getfield 228	com/tencent/mobileqq/transfile/TransferRequest:mUinType	I
    //   364: aload_0
    //   365: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   368: getfield 219	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   371: getfield 232	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   374: invokevirtual 238	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   377: astore 9
    //   379: iload 4
    //   381: istore_1
    //   382: aload 9
    //   384: instanceof 240
    //   387: ifeq +185 -> 572
    //   390: iload 4
    //   392: istore_1
    //   393: aload 9
    //   395: checkcast 240	com/tencent/mobileqq/data/MessageForStructing
    //   398: getfield 244	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   401: instanceof 246
    //   404: ifeq +168 -> 572
    //   407: iload 4
    //   409: istore_1
    //   410: aload 9
    //   412: checkcast 240	com/tencent/mobileqq/data/MessageForStructing
    //   415: getfield 244	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   418: checkcast 246	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   421: astore 9
    //   423: iload 4
    //   425: istore_1
    //   426: aload_0
    //   427: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   430: getfield 195	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareTitle	Ljava/lang/String;
    //   433: ifnull +18 -> 451
    //   436: iload 4
    //   438: istore_1
    //   439: aload_0
    //   440: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   443: getfield 195	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareTitle	Ljava/lang/String;
    //   446: iconst_0
    //   447: invokestatic 251	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   450: pop
    //   451: iload 4
    //   453: istore_1
    //   454: aload_0
    //   455: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   458: getfield 202	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareSummary	Ljava/lang/String;
    //   461: ifnull +18 -> 479
    //   464: iload 4
    //   466: istore_1
    //   467: aload_0
    //   468: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   471: getfield 202	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareSummary	Ljava/lang/String;
    //   474: iconst_0
    //   475: invokestatic 251	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   478: pop
    //   479: iload 4
    //   481: istore_1
    //   482: aload 9
    //   484: aload_0
    //   485: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   488: getfield 195	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareTitle	Ljava/lang/String;
    //   491: aload_0
    //   492: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   495: getfield 202	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mShareSummary	Ljava/lang/String;
    //   498: aload_0
    //   499: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   502: getfield 205	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mRemoteImgUrl	Ljava/lang/String;
    //   505: invokevirtual 255	com/tencent/mobileqq/structmsg/AbsShareMsg:updateTitleSummaryAndCover	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   508: iload 4
    //   510: istore_1
    //   511: aload_0
    //   512: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   515: getfield 117	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   518: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   521: aload_0
    //   522: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   525: getfield 219	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   528: getfield 224	com/tencent/mobileqq/transfile/TransferRequest:mPeerUin	Ljava/lang/String;
    //   531: aload_0
    //   532: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   535: getfield 219	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   538: getfield 228	com/tencent/mobileqq/transfile/TransferRequest:mUinType	I
    //   541: aload_0
    //   542: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   545: getfield 219	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   548: getfield 232	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   551: aload 9
    //   553: invokevirtual 259	com/tencent/mobileqq/structmsg/AbsShareMsg:getBytes	()[B
    //   556: invokevirtual 262	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJ[B)V
    //   559: iload 4
    //   561: istore_1
    //   562: aload_0
    //   563: getfield 16	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:this$0	Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor;
    //   566: sipush 1002
    //   569: invokevirtual 265	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor:sendMessageToUpdate	(I)V
    //   572: iload 4
    //   574: istore_1
    //   575: iload_1
    //   576: istore_3
    //   577: iload_2
    //   578: istore 4
    //   580: aload_0
    //   581: iload 4
    //   583: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   586: lload 6
    //   588: lsub
    //   589: iload 5
    //   591: iload_3
    //   592: invokespecial 267	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$RichStep:reportAfter	(IJII)V
    //   595: iload 4
    //   597: ireturn
    //   598: astore 9
    //   600: iconst_0
    //   601: istore_2
    //   602: iload_1
    //   603: istore 4
    //   605: iload_2
    //   606: istore_3
    //   607: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq -30 -> 580
    //   613: ldc_w 269
    //   616: iconst_4
    //   617: aload 9
    //   619: iconst_0
    //   620: anewarray 271	java/lang/Object
    //   623: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   626: iload_1
    //   627: istore 4
    //   629: iload_2
    //   630: istore_3
    //   631: goto -51 -> 580
    //   634: astore 9
    //   636: iconst_4
    //   637: istore_3
    //   638: iload_2
    //   639: istore_1
    //   640: iload_3
    //   641: istore_2
    //   642: goto -40 -> 602
    //   645: astore 9
    //   647: iload_1
    //   648: istore_3
    //   649: iload_2
    //   650: istore_1
    //   651: iload_3
    //   652: istore_2
    //   653: goto -51 -> 602
    //   656: iconst_0
    //   657: istore 4
    //   659: goto -501 -> 158
    //   662: iconst_0
    //   663: istore_1
    //   664: goto -89 -> 575
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	this	RichStep
    //   21	643	1	i	int
    //   10	643	2	j	int
    //   160	492	3	k	int
    //   156	502	4	m	int
    //   18	572	5	n	int
    //   7	580	6	l	long
    //   108	3	8	bool	boolean
    //   77	475	9	localObject1	Object
    //   598	20	9	localException1	java.lang.Exception
    //   634	1	9	localException2	java.lang.Exception
    //   645	1	9	localException3	java.lang.Exception
    //   88	138	10	str	String
    //   49	264	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	51	598	java/lang/Exception
    //   53	64	598	java/lang/Exception
    //   70	79	598	java/lang/Exception
    //   81	90	598	java/lang/Exception
    //   92	101	598	java/lang/Exception
    //   103	110	598	java/lang/Exception
    //   115	155	634	java/lang/Exception
    //   164	172	645	java/lang/Exception
    //   184	197	645	java/lang/Exception
    //   200	218	645	java/lang/Exception
    //   221	230	645	java/lang/Exception
    //   238	246	645	java/lang/Exception
    //   255	268	645	java/lang/Exception
    //   273	286	645	java/lang/Exception
    //   288	306	645	java/lang/Exception
    //   308	317	645	java/lang/Exception
    //   323	331	645	java/lang/Exception
    //   334	379	645	java/lang/Exception
    //   382	390	645	java/lang/Exception
    //   393	407	645	java/lang/Exception
    //   410	423	645	java/lang/Exception
    //   426	436	645	java/lang/Exception
    //   439	451	645	java/lang/Exception
    //   454	464	645	java/lang/Exception
    //   467	479	645	java/lang/Exception
    //   482	508	645	java/lang/Exception
    //   511	559	645	java/lang/Exception
    //   562	572	645	java/lang/Exception
  }
  
  protected boolean isFinished()
  {
    return (!this.needRich.get()) || (this.retryCount.get() >= 2);
  }
  
  protected void process()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|process|neeRich=" + this.needRich + ",lack=" + ForwardSdkShareProcessor.access$000(this.this$0));
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    if (this.needRich.get())
    {
      this.retryCount.set(0);
      ThreadManager.excute(new ForwardSdkShareProcessor.RichStep.1(this), 128, null, true);
      return;
    }
    doNextStep();
  }
  
  void reset()
  {
    this.retryCount.set(0);
    this.needRich.set(false);
    if ((TextUtils.isEmpty(this.this$0.mRemoteImgUrl)) && (TextUtils.isEmpty(this.this$0.mLocalImgUrl))) {
      ForwardSdkShareProcessor.access$002(this.this$0, ForwardSdkShareProcessor.access$000(this.this$0) | 0x1);
    }
    if (TextUtils.isEmpty(this.this$0.mShareSummary)) {
      ForwardSdkShareProcessor.access$002(this.this$0, ForwardSdkShareProcessor.access$000(this.this$0) | 0x2);
    }
    if (TextUtils.isEmpty(this.this$0.mShareTitle)) {
      ForwardSdkShareProcessor.access$002(this.this$0, ForwardSdkShareProcessor.access$000(this.this$0) | 0x4);
    }
    if (ForwardSdkShareProcessor.access$000(this.this$0) > 0) {
      this.needRich.set(true);
    }
    if (this.this$0.isSdkShare()) {
      this.needRich.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep
 * JD-Core Version:    0.7.0.1
 */