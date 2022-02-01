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
  private int jdField_a_of_type_Int;
  private IChangesetTracker jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker;
  private IQQWriteTogetherService jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService;
  private EditorController.OnEditorTextChangeListener jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController$OnEditorTextChangeListener;
  private IEditorModel jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel;
  private InsertDeleteWatcher jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher;
  private IEditorView jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView;
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = false;
  
  public EditorController(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService = ((IQQWriteTogetherService)paramAppRuntime.getRuntimeService(IQQWriteTogetherService.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.addObservers(this);
  }
  
  private void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    c(paramString1, paramBoolean, paramString2);
  }
  
  private void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramString1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString1, WriteTogetherUtils.a(paramString2), true);
    }
  }
  
  private boolean d()
  {
    return WriteTogetherUtils.a(this.jdField_a_of_type_Int);
  }
  
  public List<UserEditInfo> a()
  {
    IEditorModel localIEditorModel = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel;
    if (localIEditorModel == null) {
      return null;
    }
    return localIEditorModel.a();
  }
  
  /* Error */
  public void a()
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
    //   12: getfield 64	com/tencent/mobileqq/writetogether/client/EditorController:jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel	Lcom/tencent/mobileqq/writetogether/data/IEditorModel;
    //   15: invokeinterface 91 1 0
    //   20: getfield 95	com/tencent/mobileqq/writetogether/data/DocMetaData:b	Ljava/lang/String;
    //   23: astore 8
    //   25: aload_0
    //   26: getfield 64	com/tencent/mobileqq/writetogether/client/EditorController:jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel	Lcom/tencent/mobileqq/writetogether/data/IEditorModel;
    //   29: invokeinterface 97 1 0
    //   34: astore 6
    //   36: aload 9
    //   38: astore 7
    //   40: iload_2
    //   41: istore_1
    //   42: aload_0
    //   43: getfield 64	com/tencent/mobileqq/writetogether/client/EditorController:jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel	Lcom/tencent/mobileqq/writetogether/data/IEditorModel;
    //   46: invokeinterface 99 1 0
    //   51: astore 10
    //   53: aload 10
    //   55: astore 7
    //   57: iload_2
    //   58: istore_1
    //   59: aload_0
    //   60: getfield 64	com/tencent/mobileqq/writetogether/client/EditorController:jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel	Lcom/tencent/mobileqq/writetogether/data/IEditorModel;
    //   63: invokeinterface 102 1 0
    //   68: getfield 108	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   71: checkcast 110	java/lang/Integer
    //   74: invokevirtual 114	java/lang/Integer:intValue	()I
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
    //   102: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +192 -> 297
    //   108: aload 10
    //   110: astore 7
    //   112: iload_3
    //   113: istore_1
    //   114: new 121	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   121: astore 9
    //   123: aload 10
    //   125: astore 7
    //   127: iload_3
    //   128: istore_1
    //   129: aload 9
    //   131: ldc 124
    //   133: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 10
    //   139: astore 7
    //   141: iload_3
    //   142: istore_1
    //   143: aload 9
    //   145: aload 8
    //   147: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 10
    //   153: astore 7
    //   155: iload_3
    //   156: istore_1
    //   157: aload 9
    //   159: ldc 130
    //   161: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 10
    //   167: astore 7
    //   169: iload_3
    //   170: istore_1
    //   171: aload 9
    //   173: aload 6
    //   175: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 10
    //   181: astore 7
    //   183: iload_3
    //   184: istore_1
    //   185: aload 9
    //   187: ldc 132
    //   189: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 10
    //   195: astore 7
    //   197: iload_3
    //   198: istore_1
    //   199: aload 9
    //   201: iload_3
    //   202: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 10
    //   208: astore 7
    //   210: iload_3
    //   211: istore_1
    //   212: ldc 137
    //   214: iconst_2
    //   215: aload 9
    //   217: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iload 5
    //   225: istore 4
    //   227: aload 10
    //   229: astore 12
    //   231: iload_3
    //   232: istore_2
    //   233: aload 8
    //   235: astore 11
    //   237: aload 6
    //   239: astore 9
    //   241: goto +56 -> 297
    //   244: astore 9
    //   246: goto +24 -> 270
    //   249: astore 9
    //   251: aconst_null
    //   252: astore 6
    //   254: iload_2
    //   255: istore_1
    //   256: goto +14 -> 270
    //   259: astore 9
    //   261: aconst_null
    //   262: astore 8
    //   264: aload 8
    //   266: astore 6
    //   268: iload_2
    //   269: istore_1
    //   270: ldc 137
    //   272: iconst_1
    //   273: ldc 145
    //   275: aload 9
    //   277: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: iconst_0
    //   281: istore 4
    //   283: aload 6
    //   285: astore 9
    //   287: aload 8
    //   289: astore 11
    //   291: iload_1
    //   292: istore_2
    //   293: aload 7
    //   295: astore 12
    //   297: iload 4
    //   299: ifeq +26 -> 325
    //   302: aload_0
    //   303: getfield 53	com/tencent/mobileqq/writetogether/client/EditorController:jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService	Lcom/tencent/mobileqq/writetogether/api/IQQWriteTogetherService;
    //   306: new 151	com/tencent/mobileqq/writetogether/websocket/msg/CursorMessageReqMsg
    //   309: dup
    //   310: aload 11
    //   312: aload 9
    //   314: aload 12
    //   316: iload_2
    //   317: invokespecial 154	com/tencent/mobileqq/writetogether/websocket/msg/CursorMessageReqMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   320: invokeinterface 158 2 0
    //   325: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	EditorController
    //   41	251	1	i	int
    //   10	307	2	j	int
    //   77	155	3	k	int
    //   86	212	4	m	int
    //   1	223	5	n	int
    //   34	250	6	str1	String
    //   4	290	7	localObject1	Object
    //   23	265	8	str2	String
    //   7	233	9	localObject2	Object
    //   244	1	9	localException1	java.lang.Exception
    //   249	1	9	localException2	java.lang.Exception
    //   259	17	9	localException3	java.lang.Exception
    //   285	28	9	localObject3	Object
    //   51	177	10	str3	String
    //   96	215	11	str4	String
    //   90	225	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   42	53	244	java/lang/Exception
    //   59	78	244	java/lang/Exception
    //   102	108	244	java/lang/Exception
    //   114	123	244	java/lang/Exception
    //   129	137	244	java/lang/Exception
    //   143	151	244	java/lang/Exception
    //   157	165	244	java/lang/Exception
    //   171	179	244	java/lang/Exception
    //   185	193	244	java/lang/Exception
    //   199	206	244	java/lang/Exception
    //   212	223	244	java/lang/Exception
    //   25	36	249	java/lang/Exception
    //   11	25	259	java/lang/Exception
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    IEditorView localIEditorView = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView;
    if (localIEditorView != null) {
      localIEditorView.setMySelection(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("EditorController", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      a();
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
    paramString1 = OtHelper.a(paramInt1, paramInt2, paramString1, paramString2, paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("[onTextInsert] cs: ");
      paramString2.append(paramString1);
      QLog.d("EditorController", 2, paramString2.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString1, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController$OnEditorTextChangeListener;
    if (paramString1 != null) {
      paramString1.a(paramString3);
    }
    this.b = true;
  }
  
  public void a(AText paramAText)
  {
    if (paramAText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramAText);
      b(paramAText.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(IChangesetTracker paramIChangesetTracker)
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker = paramIChangesetTracker;
  }
  
  public void a(EditorController.OnEditorTextChangeListener paramOnEditorTextChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController$OnEditorTextChangeListener = paramOnEditorTextChangeListener;
  }
  
  public void a(IEditorModel paramIEditorModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel = paramIEditorModel;
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
            int i = paramObject.gcp;
            paramType = paramObject.userId;
            paramObject = paramObject.uuId;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[onUpdate] cursor index: ");
              localStringBuilder.append(i);
              localStringBuilder.append(", uerId: ");
              localStringBuilder.append(paramType);
              localStringBuilder.append(", uuId: ");
              localStringBuilder.append(paramObject);
              QLog.d("EditorController", 2, localStringBuilder.toString());
            }
            this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramType, i, i);
          }
        }
      }
    }
  }
  
  public void a(IEditorView paramIEditorView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView = paramIEditorView;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher = new InsertDeleteWatcher();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher);
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView;
    if (localObject != null)
    {
      ((IEditorView)localObject).b(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = paramString.substring(paramInt1, paramInt2);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().b;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.d();
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.b();
    Object localObject = WriteTogetherUtils.a(paramString, str2, str1, paramInt1, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a(paramString1, paramString2.a());
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.jdField_a_of_type_Boolean = true;
    b(paramString1, paramBoolean, paramString2);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    IEditorView localIEditorView = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView;
    if (localIEditorView != null) {
      localIEditorView.setEditorEnabled(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return WriteTogetherUtils.a(this.jdField_a_of_type_Int) ^ true;
  }
  
  public void b()
  {
    ((IQQWriteTogetherService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IQQWriteTogetherService.class, "")).removeObserver(this);
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
    this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString1, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController$OnEditorTextChangeListener;
    if (paramString1 != null) {
      paramString1.a(paramString3);
    }
    this.b = true;
  }
  
  public void b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView;
    if (localObject != null)
    {
      ((IEditorView)localObject).b(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.b(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher);
    }
  }
  
  public boolean b()
  {
    AText localAText = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
    return (localAText != null) && (!TextUtils.isEmpty(localAText.jdField_a_of_type_JavaLangString)) && (d());
  }
  
  public void c()
  {
    IEditorView localIEditorView = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView;
    if (localIEditorView != null) {
      localIEditorView.a();
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.EditorController
 * JD-Core Version:    0.7.0.1
 */