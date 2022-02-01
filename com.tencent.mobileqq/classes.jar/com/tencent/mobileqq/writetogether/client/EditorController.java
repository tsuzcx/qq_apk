package com.tencent.mobileqq.writetogether.client;

import android.text.TextUtils;
import com.tencent.biz.subscribe.utils.EvilReportUtil;
import com.tencent.biz.subscribe.utils.EvilReportUtil.EvilReportParams;
import com.tencent.mobileqq.easysync2.AText;
import com.tencent.mobileqq.easysync2.AttribPool;
import com.tencent.mobileqq.easysync2.EditorCallback;
import com.tencent.mobileqq.easysync2.IChangesetTracker;
import com.tencent.mobileqq.writetogether.IWriteTogetherObserver;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.data.CursorManager.OnMyCursorIndexChangeListener;
import com.tencent.mobileqq.writetogether.data.DocMetaData;
import com.tencent.mobileqq.writetogether.data.IEditorModel;
import com.tencent.mobileqq.writetogether.data.InsertDeleteWatcher;
import com.tencent.mobileqq.writetogether.data.InsertDeleteWatcher.OnTextInsertDelete;
import com.tencent.mobileqq.writetogether.data.UserEditInfo;
import com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageRspMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageRspMsg.Body;
import com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageRspMsg.Notice;
import com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageRspMsg.NoticeWrapper;
import com.tencent.mobileqq.writetogether.websocket.msg.Type;
import com.tencent.mobileqq.writetogetherui.IEditorView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EditorController
  implements EditorCallback, IWriteTogetherObserver, IEditorController, CursorManager.OnMyCursorIndexChangeListener, InsertDeleteWatcher.OnTextInsertDelete
{
  private AppRuntime a;
  private IEditorView b;
  private IEditorModel c;
  private InsertDeleteWatcher d;
  private IQQWriteTogetherService e;
  private EditorController.OnEditorTextChangeListener f;
  private IChangesetTracker g;
  private String h;
  private boolean i;
  private boolean j = false;
  private int k;
  
  public EditorController(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    this.h = this.a.getAccount();
    this.e = ((IQQWriteTogetherService)paramAppRuntime.getRuntimeService(IQQWriteTogetherService.class, ""));
    this.e.addObservers(this);
  }
  
  private void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    c(paramString1, paramBoolean, paramString2);
  }
  
  private void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramString1 != null) {
      this.c.a(paramString1, WriteTogetherUtils.a(paramString2), true);
    }
  }
  
  private boolean h()
  {
    return WriteTogetherUtils.b(this.k);
  }
  
  public List<UserEditInfo> a()
  {
    IEditorModel localIEditorModel = this.c;
    if (localIEditorModel == null) {
      return null;
    }
    return localIEditorModel.a();
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    IEditorView localIEditorView = this.b;
    if (localIEditorView != null) {
      localIEditorView.setMySelection(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((IEditorModel)localObject).a(paramInt3, paramInt4);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onEditorSelectionChanged] lastStart: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", lastEnd: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", start: ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(", end: ");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(", changedByUserTouch: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", mInPushChangesetProgress: ");
      ((StringBuilder)localObject).append(this.i);
      QLog.d("EditorController", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (!this.i)) {
      d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onTextInsert]start: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", insCnt: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", text: ");
      localStringBuilder.append(paramString1);
      QLog.d("EditorController", 2, localStringBuilder.toString());
    }
    paramString1 = OtHelper.a(paramInt1, paramInt2, paramString1, paramString2, paramString3, this.h, this.g);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("[onTextInsert] cs: ");
      paramString2.append(paramString1);
      QLog.d("EditorController", 2, paramString2.toString());
    }
    this.g.a(paramString1);
    this.c.a(paramString1, this.a.getAccount(), false);
    paramString1 = this.f;
    if (paramString1 != null) {
      paramString1.a(paramString3);
    }
    this.j = true;
  }
  
  public void a(AText paramAText)
  {
    if (paramAText != null)
    {
      this.c.a(paramAText);
      b(paramAText.a);
    }
  }
  
  public void a(IChangesetTracker paramIChangesetTracker)
  {
    this.g = paramIChangesetTracker;
  }
  
  public void a(EditorController.OnEditorTextChangeListener paramOnEditorTextChangeListener)
  {
    this.f = paramOnEditorTextChangeListener;
  }
  
  public void a(IEditorModel paramIEditorModel)
  {
    this.c = paramIEditorModel;
  }
  
  public void a(Type paramType, boolean paramBoolean, Object paramObject)
  {
    if ((paramType == Type.CURSOR_MESSAGE) && ((paramObject instanceof CursorMessageRspMsg)))
    {
      paramType = (CursorMessageRspMsg)paramObject;
      if (paramType.body != null)
      {
        paramType = ((CursorMessageRspMsg.Body)paramType.body).notice;
        if (paramType != null)
        {
          paramObject = paramType.notice;
          if (paramObject != null)
          {
            int m = paramObject.gcp;
            paramType = paramObject.userId;
            paramObject = paramObject.uuId;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[onUpdate] cursor index: ");
              localStringBuilder.append(m);
              localStringBuilder.append(", uerId: ");
              localStringBuilder.append(paramType);
              localStringBuilder.append(", uuId: ");
              localStringBuilder.append(paramObject);
              QLog.d("EditorController", 2, localStringBuilder.toString());
            }
            this.c.a(paramType, m, m);
          }
        }
      }
    }
  }
  
  public void a(IEditorView paramIEditorView)
  {
    this.b = paramIEditorView;
    this.d = new InsertDeleteWatcher();
    this.d.a(this);
    this.b.a(this.d);
  }
  
  public void a(String paramString)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((IEditorView)localObject).b(this.d);
      localObject = this.c.b();
      this.b.a(paramString);
      this.c.a(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      this.b.a(this.d);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = paramString.substring(paramInt1, paramInt2);
    String str1 = this.c.g().c;
    String str2 = this.c.m();
    paramInt1 = this.c.n();
    Object localObject = WriteTogetherUtils.a(paramString, str2, str1, paramInt1, this.c.g().a);
    EvilReportUtil.a(MobileQQ.sMobileQQ, (EvilReportUtil.EvilReportParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onReportDocument] report text: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", report group: ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(", padId: ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(", curRev: ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("EditorController", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new AText(paramString1, paramString2);
    paramString2 = AttribPool.a(paramString3);
    this.c.a(paramString1);
    this.c.a(paramString2);
    this.g.a(paramString1, paramString2.b());
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.i = true;
    b(paramString1, paramBoolean, paramString2);
    this.i = false;
  }
  
  public void a(boolean paramBoolean)
  {
    IEditorView localIEditorView = this.b;
    if (localIEditorView != null) {
      localIEditorView.setEditorEnabled(paramBoolean);
    }
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onTextDelete] start: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", delCnt: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", text: ");
      localStringBuilder.append(paramString1);
      QLog.d("EditorController", 2, localStringBuilder.toString());
    }
    paramString1 = OtHelper.a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("[onTextDelete] cs: ");
      paramString2.append(paramString1);
      QLog.d("EditorController", 2, paramString2.toString());
    }
    this.g.a(paramString1);
    this.c.a(paramString1, this.a.getAccount(), false);
    paramString1 = this.f;
    if (paramString1 != null) {
      paramString1.a(paramString3);
    }
    this.j = true;
  }
  
  public void b(String paramString)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((IEditorView)localObject).b(this.d);
      localObject = this.c.b();
      this.b.b(paramString);
      this.c.a(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      this.b.a(this.d);
    }
  }
  
  public boolean b()
  {
    return WriteTogetherUtils.b(this.k) ^ true;
  }
  
  public boolean c()
  {
    AText localAText = this.c.c();
    return (localAText != null) && (!TextUtils.isEmpty(localAText.a)) && (h());
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 9
    //   9: iconst_m1
    //   10: istore_2
    //   11: aload_0
    //   12: getfield 72	com/tencent/mobileqq/writetogether/client/EditorController:c	Lcom/tencent/mobileqq/writetogether/data/IEditorModel;
    //   15: invokeinterface 270 1 0
    //   20: getfield 274	com/tencent/mobileqq/writetogether/data/DocMetaData:c	Ljava/lang/String;
    //   23: astore 8
    //   25: aload_0
    //   26: getfield 72	com/tencent/mobileqq/writetogether/client/EditorController:c	Lcom/tencent/mobileqq/writetogether/data/IEditorModel;
    //   29: invokeinterface 351 1 0
    //   34: astore 6
    //   36: aload 9
    //   38: astore 7
    //   40: iload_2
    //   41: istore_1
    //   42: aload_0
    //   43: getfield 72	com/tencent/mobileqq/writetogether/client/EditorController:c	Lcom/tencent/mobileqq/writetogether/data/IEditorModel;
    //   46: invokeinterface 354 1 0
    //   51: astore 10
    //   53: aload 10
    //   55: astore 7
    //   57: iload_2
    //   58: istore_1
    //   59: aload_0
    //   60: getfield 72	com/tencent/mobileqq/writetogether/client/EditorController:c	Lcom/tencent/mobileqq/writetogether/data/IEditorModel;
    //   63: invokeinterface 246 1 0
    //   68: getfield 252	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   71: checkcast 254	java/lang/Integer
    //   74: invokevirtual 258	java/lang/Integer:intValue	()I
    //   77: istore_3
    //   78: aload 10
    //   80: astore 7
    //   82: iload_3
    //   83: istore_1
    //   84: iload 5
    //   86: istore 4
    //   88: aload 10
    //   90: astore 12
    //   92: iload_3
    //   93: istore_2
    //   94: aload 8
    //   96: astore 11
    //   98: aload 6
    //   100: astore 9
    //   102: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +196 -> 301
    //   108: aload 10
    //   110: astore 7
    //   112: iload_3
    //   113: istore_1
    //   114: new 112	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   121: astore 9
    //   123: aload 10
    //   125: astore 7
    //   127: iload_3
    //   128: istore_1
    //   129: aload 9
    //   131: ldc_w 356
    //   134: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 10
    //   140: astore 7
    //   142: iload_3
    //   143: istore_1
    //   144: aload 9
    //   146: aload 8
    //   148: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 10
    //   154: astore 7
    //   156: iload_3
    //   157: istore_1
    //   158: aload 9
    //   160: ldc_w 358
    //   163: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 10
    //   169: astore 7
    //   171: iload_3
    //   172: istore_1
    //   173: aload 9
    //   175: aload 6
    //   177: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 10
    //   183: astore 7
    //   185: iload_3
    //   186: istore_1
    //   187: aload 9
    //   189: ldc_w 360
    //   192: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 10
    //   198: astore 7
    //   200: iload_3
    //   201: istore_1
    //   202: aload 9
    //   204: iload_3
    //   205: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 10
    //   211: astore 7
    //   213: iload_3
    //   214: istore_1
    //   215: ldc 139
    //   217: iconst_2
    //   218: aload 9
    //   220: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iload 5
    //   228: istore 4
    //   230: aload 10
    //   232: astore 12
    //   234: iload_3
    //   235: istore_2
    //   236: aload 8
    //   238: astore 11
    //   240: aload 6
    //   242: astore 9
    //   244: goto +57 -> 301
    //   247: astore 9
    //   249: goto +24 -> 273
    //   252: astore 9
    //   254: aconst_null
    //   255: astore 6
    //   257: iload_2
    //   258: istore_1
    //   259: goto +14 -> 273
    //   262: astore 9
    //   264: aconst_null
    //   265: astore 8
    //   267: aload 8
    //   269: astore 6
    //   271: iload_2
    //   272: istore_1
    //   273: ldc 139
    //   275: iconst_1
    //   276: ldc_w 362
    //   279: aload 9
    //   281: invokestatic 365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: iconst_0
    //   285: istore 4
    //   287: aload 6
    //   289: astore 9
    //   291: aload 8
    //   293: astore 11
    //   295: iload_1
    //   296: istore_2
    //   297: aload 7
    //   299: astore 12
    //   301: iload 4
    //   303: ifeq +26 -> 329
    //   306: aload_0
    //   307: getfield 62	com/tencent/mobileqq/writetogether/client/EditorController:e	Lcom/tencent/mobileqq/writetogether/api/IQQWriteTogetherService;
    //   310: new 367	com/tencent/mobileqq/writetogether/websocket/msg/CursorMessageReqMsg
    //   313: dup
    //   314: aload 11
    //   316: aload 9
    //   318: aload 12
    //   320: iload_2
    //   321: invokespecial 370	com/tencent/mobileqq/writetogether/websocket/msg/CursorMessageReqMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   324: invokeinterface 374 2 0
    //   329: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	EditorController
    //   41	255	1	m	int
    //   10	311	2	n	int
    //   77	158	3	i1	int
    //   86	216	4	i2	int
    //   1	226	5	i3	int
    //   34	254	6	str1	String
    //   4	294	7	localObject1	Object
    //   23	269	8	str2	String
    //   7	236	9	localObject2	Object
    //   247	1	9	localException1	java.lang.Exception
    //   252	1	9	localException2	java.lang.Exception
    //   262	18	9	localException3	java.lang.Exception
    //   289	28	9	localObject3	Object
    //   51	180	10	str3	String
    //   96	219	11	str4	String
    //   90	229	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   42	53	247	java/lang/Exception
    //   59	78	247	java/lang/Exception
    //   102	108	247	java/lang/Exception
    //   114	123	247	java/lang/Exception
    //   129	138	247	java/lang/Exception
    //   144	152	247	java/lang/Exception
    //   158	167	247	java/lang/Exception
    //   173	181	247	java/lang/Exception
    //   187	196	247	java/lang/Exception
    //   202	209	247	java/lang/Exception
    //   215	226	247	java/lang/Exception
    //   25	36	252	java/lang/Exception
    //   11	25	262	java/lang/Exception
  }
  
  public void e()
  {
    ((IQQWriteTogetherService)this.a.getRuntimeService(IQQWriteTogetherService.class, "")).removeObserver(this);
  }
  
  public void f()
  {
    IEditorView localIEditorView = this.b;
    if (localIEditorView != null) {
      localIEditorView.a();
    }
  }
  
  public boolean g()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.EditorController
 * JD-Core Version:    0.7.0.1
 */