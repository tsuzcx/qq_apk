package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;

public class AbstractImageDownloader$MessageObserverImpl
  extends MessageObserver
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  
  /* Error */
  protected void a(boolean paramBoolean, QQService.RespTmpChatPicDownload paramRespTmpChatPicDownload)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 18	com/tencent/mobileqq/transfile/AbstractImageDownloader$MessageObserverImpl:jdField_b_of_type_Boolean	Z
    //   7: iload_1
    //   8: ifeq +56 -> 64
    //   11: aload_2
    //   12: ifnull +35 -> 47
    //   15: aload_2
    //   16: getfield 23	QQService/RespTmpChatPicDownload:lReplyCode	I
    //   19: ifne +28 -> 47
    //   22: aload_2
    //   23: getfield 26	QQService/RespTmpChatPicDownload:strDownloadURL	Ljava/lang/String;
    //   26: ifnull +21 -> 47
    //   29: aload_2
    //   30: getfield 26	QQService/RespTmpChatPicDownload:strDownloadURL	Ljava/lang/String;
    //   33: invokevirtual 32	java/lang/String:length	()I
    //   36: ifle +11 -> 47
    //   39: aload_0
    //   40: aload_2
    //   41: getfield 26	QQService/RespTmpChatPicDownload:strDownloadURL	Ljava/lang/String;
    //   44: putfield 34	com/tencent/mobileqq/transfile/AbstractImageDownloader$MessageObserverImpl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 36	com/tencent/mobileqq/transfile/AbstractImageDownloader$MessageObserverImpl:jdField_a_of_type_Int	I
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 38	com/tencent/mobileqq/transfile/AbstractImageDownloader$MessageObserverImpl:jdField_a_of_type_Boolean	Z
    //   57: aload_0
    //   58: invokevirtual 43	java/lang/Object:notify	()V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: aload_0
    //   65: sipush 9006
    //   68: putfield 45	com/tencent/mobileqq/transfile/AbstractImageDownloader$MessageObserverImpl:jdField_b_of_type_Int	I
    //   71: goto -19 -> 52
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	MessageObserverImpl
    //   0	79	1	paramBoolean	boolean
    //   0	79	2	paramRespTmpChatPicDownload	QQService.RespTmpChatPicDownload
    // Exception table:
    //   from	to	target	type
    //   2	7	74	finally
    //   15	47	74	finally
    //   47	52	74	finally
    //   52	63	74	finally
    //   64	71	74	finally
    //   75	77	74	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbstractImageDownloader.MessageObserverImpl
 * JD-Core Version:    0.7.0.1
 */