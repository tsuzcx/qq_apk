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
import com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageReqMsg;
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
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
  }
  
  public void a()
  {
    String str2 = null;
    String str4 = null;
    j = -1;
    for (;;)
    {
      try
      {
        String str3 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().b;
        int k;
        QLog.e("EditorController", 1, "[sendCursorMessage] current data invalid: ", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.b();
          i = j;
          str4 = str2;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject;
            String str1 = null;
            int i = j;
          }
        }
        try
        {
          str2 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.c();
          i = j;
          str4 = str2;
          j = ((Integer)this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().first).intValue();
          i = j;
          str4 = str2;
          if (QLog.isColorLevel())
          {
            i = j;
            str4 = str2;
            QLog.d("EditorController", 2, "[sendCursorMessage] padId: " + str3 + ", uin: " + str1 + ", index: " + j);
          }
          k = 1;
          i = j;
          j = k;
          if (j != 0) {
            this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.sendData(new CursorMessageReqMsg(str3, str1, str2, i));
          }
          return;
        }
        catch (Exception localException3)
        {
          break label182;
        }
        localException1 = localException1;
        str1 = null;
        str3 = null;
        i = j;
      }
      label182:
      j = 0;
      localObject = str4;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.setMySelection(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramInt3, paramInt4);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onEditorSelectionChanged] lastStart: " + paramInt1 + ", lastEnd: " + paramInt2 + ", start: " + paramInt3 + ", end: " + paramInt4 + ", changedByUserTouch: " + paramBoolean + ", mInPushChangesetProgress: " + this.jdField_a_of_type_Boolean);
    }
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextInsert]start: " + paramInt1 + ", insCnt: " + paramInt2 + ", text: " + paramString1);
    }
    paramString1 = OtHelper.a(paramInt1, paramInt2, paramString1, paramString2, paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextInsert] cs: " + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString1, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController$OnEditorTextChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController$OnEditorTextChangeListener.a(paramString3);
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
            if (QLog.isColorLevel()) {
              QLog.d("EditorController", 2, "[onUpdate] cursor index: " + i + ", uerId: " + paramType + ", uuId: " + paramObject);
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
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.b(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher);
      Pair localPair = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = paramString.substring(paramInt1, paramInt2);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().b;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.d();
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.b();
    EvilReportUtil.EvilReportParams localEvilReportParams = WriteTogetherUtils.a(paramString, str2, str1, paramInt1, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().jdField_a_of_type_JavaLangString);
    EvilReportUtil.a(MobileQQ.sMobileQQ, localEvilReportParams);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onReportDocument] report text: " + paramString + ", report group: " + str2 + ", padId: " + str1 + ", curRev: " + paramInt1);
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
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.setEditorEnabled(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return !WriteTogetherUtils.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    ((IQQWriteTogetherService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IQQWriteTogetherService.class, "")).removeObserver(this);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextDelete] start: " + paramInt1 + ", delCnt: " + paramInt2 + ", text: " + paramString1);
    }
    paramString1 = OtHelper.a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextDelete] cs: " + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString1, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController$OnEditorTextChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController$OnEditorTextChangeListener.a(paramString3);
    }
    this.b = true;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.b(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataInsertDeleteWatcher);
      Pair localPair = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.b(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
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
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiIEditorView.a();
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.EditorController
 * JD-Core Version:    0.7.0.1
 */