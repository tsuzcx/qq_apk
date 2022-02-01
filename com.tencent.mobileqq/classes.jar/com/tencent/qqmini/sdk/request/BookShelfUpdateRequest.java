package com.tencent.qqmini.sdk.request;

import NS_MINI_BOOK_SHELF.MiniBookShelf.StUpdateBookShelfReadTimeReq;
import com.tencent.mobileqq.pb.PBStringField;

public class BookShelfUpdateRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime";
  public static final String KEY_RESULT_DATA = "key_result_data";
  public static final String TAG = "BookShelfUpdateRequest";
  private MiniBookShelf.StUpdateBookShelfReadTimeReq req = new MiniBookShelf.StUpdateBookShelfReadTimeReq();
  
  public BookShelfUpdateRequest(String paramString1, String paramString2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.category.set(paramString2);
    this.req.contentId.set(paramString3);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "UpdateBookShelfReadTime";
  }
  
  public String getCmdString()
  {
    return "LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime";
  }
  
  protected String getModule()
  {
    return "mini_book_shelf";
  }
  
  /* Error */
  public org.json.JSONObject getResponse(byte[] paramArrayOfByte, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_1
    //   6: aload_1
    //   7: areturn
    //   8: new 64	NS_MINI_BOOK_SHELF/MiniBookShelf$StUpdateBookShelfReadTimeRsp
    //   11: dup
    //   12: invokespecial 65	NS_MINI_BOOK_SHELF/MiniBookShelf$StUpdateBookShelfReadTimeRsp:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual 69	NS_MINI_BOOK_SHELF/MiniBookShelf$StUpdateBookShelfReadTimeRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: pop
    //   22: aload_3
    //   23: getfield 73	NS_MINI_BOOK_SHELF/MiniBookShelf$StUpdateBookShelfReadTimeRsp:updateInfo	LNS_MINI_BOOK_SHELF/MiniBookShelf$Information;
    //   26: invokevirtual 79	NS_MINI_BOOK_SHELF/MiniBookShelf$Information:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   29: checkcast 75	NS_MINI_BOOK_SHELF/MiniBookShelf$Information
    //   32: astore_3
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: ifnull -30 -> 6
    //   39: new 81	org/json/JSONObject
    //   42: dup
    //   43: invokespecial 82	org/json/JSONObject:<init>	()V
    //   46: astore_1
    //   47: aload_1
    //   48: ldc 84
    //   50: aload_3
    //   51: getfield 85	NS_MINI_BOOK_SHELF/MiniBookShelf$Information:contentId	Lcom/tencent/mobileqq/pb/PBStringField;
    //   54: invokevirtual 87	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   57: invokevirtual 91	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload_1
    //   62: ldc 93
    //   64: aload_3
    //   65: getfield 96	NS_MINI_BOOK_SHELF/MiniBookShelf$Information:status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   68: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   71: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: invokevirtual 91	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   77: pop
    //   78: aload_1
    //   79: ldc 109
    //   81: aload_3
    //   82: getfield 111	NS_MINI_BOOK_SHELF/MiniBookShelf$Information:msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   85: invokevirtual 87	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   88: invokevirtual 91	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload_1
    //   93: ldc 113
    //   95: aload_3
    //   96: getfield 117	NS_MINI_BOOK_SHELF/MiniBookShelf$Information:existStatus	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   99: invokevirtual 120	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   102: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: invokevirtual 91	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   108: pop
    //   109: aload_2
    //   110: ldc 11
    //   112: aload_1
    //   113: invokevirtual 91	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   116: pop
    //   117: aload_2
    //   118: areturn
    //   119: astore_1
    //   120: ldc 14
    //   122: new 122	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   129: ldc 125
    //   131: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 141	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_3
    //   147: ldc 14
    //   149: ldc 143
    //   151: aload_3
    //   152: invokestatic 147	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -46 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	BookShelfUpdateRequest
    //   0	158	1	paramArrayOfByte	byte[]
    //   0	158	2	paramJSONObject	org.json.JSONObject
    //   15	81	3	localObject	java.lang.Object
    //   146	6	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   8	33	119	java/lang/Exception
    //   39	47	119	java/lang/Exception
    //   47	109	119	java/lang/Exception
    //   109	117	119	java/lang/Exception
    //   147	155	119	java/lang/Exception
    //   47	109	146	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.BookShelfUpdateRequest
 * JD-Core Version:    0.7.0.1
 */