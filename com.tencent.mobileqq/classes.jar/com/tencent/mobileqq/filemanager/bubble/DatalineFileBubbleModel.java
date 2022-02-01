package com.tencent.mobileqq.filemanager.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.filemanager.aioitem.DatalineFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.DatalineFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.open.DatalineFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqreader.QRLocalManager;
import java.util.ArrayList;
import java.util.List;

public class DatalineFileBubbleModel
  extends QFileBubbleModel
{
  private MessageForDLFile a;
  
  public DatalineFileBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private DataLineMsgRecord a()
  {
    Object localObject;
    if (!d()) {
      localObject = null;
    }
    long l;
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return localObject;
      int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.deviceType;
      l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.associatedId;
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(l);
      localObject = localDataLineMsgRecord;
    } while (localDataLineMsgRecord != null);
    QLog.i("DatalineFileBubbleModel", 1, "getSourceDatalineFile：do not find sessionId[" + l + "]");
    return localDataLineMsgRecord;
  }
  
  private void a(View paramView)
  {
    a(false, AnimationUtils.a(paramView));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.nWeiyunSessionId != 0L) {}
    for (FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramDataLineMsgRecord.nWeiyunSessionId);; localFileManagerEntity = null)
    {
      int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      if (localFileManagerEntity == null)
      {
        FMToastUtil.b(FileManagerUtil.d(paramDataLineMsgRecord.filename) + ReadInJoyUtils.a(2131692731));
        paramDataLineMsgRecord.nWeiyunSessionId = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramDataLineMsgRecord.path, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false).nSessionId;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(paramDataLineMsgRecord.msgId);
        return;
      }
      FMToastUtil.b(FileManagerUtil.d(paramDataLineMsgRecord.filename) + ReadInJoyUtils.a(2131692731));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramDataLineMsgRecord.nWeiyunSessionId);
      return;
    }
  }
  
  private void a(boolean paramBoolean, Rect paramRect)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = FileManagerUtil.a((DataLineMsgRecord)localObject);
    localObject = new DatalineFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject);
    ((DatalineFileBrowserParams)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((DatalineFileBrowserParams)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile);
    ((DatalineFileBrowserParams)localObject).a(paramBoolean);
    ((DatalineFileBrowserParams)localObject).b(false);
    localObject = new FileBrowserCreator(this.jdField_a_of_type_AndroidContentContext, (IFileBrowserParams)localObject);
    ((FileBrowserCreator)localObject).a(1);
    ((FileBrowserCreator)localObject).a(paramRect);
    ((FileBrowserCreator)localObject).a(true);
    ((FileBrowserCreator)localObject).a();
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    while (a() == null) {
      return;
    }
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, false);
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile != null;
  }
  
  private void f()
  {
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile);
  }
  
  private void g()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {
      return;
    }
    String str = localDataLineMsgRecord.path;
    if (str.isEmpty())
    {
      QfavBuilder.a(null, localDataLineMsgRecord.msg).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 64, 1);
      return;
    }
    new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str);
  }
  
  private void h()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {}
    do
    {
      return;
      if ((!FileManagerUtil.a()) || (localDataLineMsgRecord.filesize <= ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize())) {
        break;
      }
    } while (!FreeWifiHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, 5, new DatalineFileBubbleModel.1(this)));
    FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692609, 2131692612, new DatalineFileBubbleModel.2(this));
    return;
    a(localDataLineMsgRecord);
  }
  
  private void i()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {}
    String str1;
    do
    {
      return;
      str1 = localDataLineMsgRecord.path;
    } while (!FileUtils.b(str1));
    long l = FileUtils.a(str1);
    String str2 = FileManagerUtil.a(str1);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(10000);
    localForwardFileInfo.d(6);
    localForwardFileInfo.d(str2);
    localForwardFileInfo.d(l);
    if (!TextUtils.isEmpty(localDataLineMsgRecord.thumbPath)) {
      localForwardFileInfo.f(localDataLineMsgRecord.thumbPath);
    }
    localForwardFileInfo.a(str1);
    localForwardFileInfo.b(localDataLineMsgRecord.entityID);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_text", HardCodeUtil.a(2131706219) + str2 + HardCodeUtil.a(2131706217) + FileUtil.a(l) + "。");
    localIntent.putExtra("forward_type", 0);
    localIntent.putExtra("forward_filepath", str1);
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    localIntent.putExtra("not_forward", true);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("k_favorites", false);
    if (!TextUtils.isEmpty(localDataLineMsgRecord.thumbPath)) {
      localIntent.putExtra("forward_thumb", localDataLineMsgRecord.path);
    }
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  private void j()
  {
    a(true, null);
  }
  
  private void k()
  {
    Object localObject2 = a();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = FileManagerUtil.a((DataLineMsgRecord)localObject2);
    if (QRLocalManager.a().a((FileManagerEntity)localObject1))
    {
      QRLocalManager.a().a(this.jdField_a_of_type_AndroidContentContext, ((FileManagerEntity)localObject1).getFilePath(), true);
      return;
    }
    int j = FileManagerUtil.a(((DataLineMsgRecord)localObject2).filename);
    int i = j;
    if (j == -1)
    {
      i = j;
      if (((DataLineMsgRecord)localObject2).msgtype == -2000) {
        i = 0;
      }
    }
    localObject2 = new DatalineFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject1);
    if (i == 0)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
      ((DatalineFileBrowserParams)localObject2).a(localArrayList);
    }
    localObject1 = new FileBrowserCreator(this.jdField_a_of_type_AndroidContentContext, (IFileBrowserParams)localObject2);
    ((FileBrowserCreator)localObject1).a(11);
    ((FileBrowserCreator)localObject1).a();
  }
  
  private void l()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {
      QLog.e("DatalineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a DataLineMsgRecord");
    }
    while (!FileUtil.b(localDataLineMsgRecord.path)) {
      return;
    }
    ThreadManager.executeOnSubThread(new DatalineFileBubbleModel.3(this, localDataLineMsgRecord));
  }
  
  private void m()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {
      QLog.e("DatalineFileBubbleModel", 1, "fetchImageFileThumb. can not find a DataLineMsgRecord");
    }
    while (!FileUtil.b(localDataLineMsgRecord.path)) {
      return;
    }
    ThreadManager.executeOnSubThread(new DatalineFileBubbleModel.4(this, localDataLineMsgRecord));
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    if (!d()) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.fileSize;
  }
  
  public QFileBubbleDownloadHandler a()
  {
    return new DatalineFileBubbleDownloadHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public QFileBubblePauseHandler a()
  {
    return new DatalineFileBubblePauseHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public String a()
  {
    if (!d()) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.fileName;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {
      return localArrayList;
    }
    if (paramInt == 3) {
      localArrayList.add(Integer.valueOf(13));
    }
    if (FileUtil.b(localDataLineMsgRecord.path))
    {
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(18));
      localArrayList.add(Integer.valueOf(21));
    }
    localArrayList.add(Integer.valueOf(19));
    localArrayList.add(Integer.valueOf(16));
    localArrayList.add(Integer.valueOf(17));
    return localArrayList;
  }
  
  public void a()
  {
    DataLineMsgRecord localDataLineMsgRecord;
    if (this.b)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.i("DatalineFileBubbleModel", 1, "fetchFileThumb.");
      }
      localDataLineMsgRecord = a();
      if (localDataLineMsgRecord != null) {
        break label36;
      }
    }
    label36:
    int i;
    do
    {
      return;
      i = FileManagerUtil.a(localDataLineMsgRecord.filename);
      if (i == 2)
      {
        l();
        return;
      }
    } while (i != 0);
    m();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131367398: 
      i();
      return;
    case 2131366625: 
      g();
      return;
    case 2131377447: 
      h();
      return;
    case 2131365636: 
      f();
      return;
    }
    j();
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramInt == 1)
    {
      k();
      return;
    }
    if (paramInt == 2)
    {
      b(paramView);
      return;
    }
    if (paramInt == 3)
    {
      DataLineMsgRecord localDataLineMsgRecord = a();
      if ((localDataLineMsgRecord != null) && (QFileAssistantUtils.a(localDataLineMsgRecord.frienduin)))
      {
        QLog.i("DatalineFileBubbleModel", 1, "entity is fileAssistant Type, return!");
        return;
      }
      a(paramView);
      return;
    }
    k();
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForDLFile))
    {
      QLog.e("DatalineFileBubbleModel", 1, "setBubbleModelData. is not a MessageForFile");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile = ((MessageForDLFile)paramChatMessage);
  }
  
  public boolean a()
  {
    return d();
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord != null)
    {
      String str = localDataLineMsgRecord.thumbPath;
      if (FileUtil.b(str)) {
        return str;
      }
      int i = FileManagerUtil.a(localDataLineMsgRecord.filename);
      if (i == 2) {
        localDataLineMsgRecord.thumbPath = FileManagerUtil.f(localDataLineMsgRecord.path);
      }
      for (;;)
      {
        return localDataLineMsgRecord.thumbPath;
        if (i == 0) {
          localDataLineMsgRecord.thumbPath = FilePicURLDrawlableHelper.a(localDataLineMsgRecord.path);
        }
      }
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {
      return localArrayList;
    }
    if (FileUtil.b(localDataLineMsgRecord.path))
    {
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(18));
      localArrayList.add(Integer.valueOf(21));
    }
    localArrayList.add(Integer.valueOf(19));
    return localArrayList;
  }
  
  public int c()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return 0;
        if (localDataLineMsgRecord.fileMsgStatus == 2L) {
          return 4;
        }
      } while (localDataLineMsgRecord.fileMsgStatus == 1L);
      if (localDataLineMsgRecord.bIsTransfering) {
        return 3;
      }
    } while ((localDataLineMsgRecord.progress != 1.0F) || (!localDataLineMsgRecord.issuc) || (!FileUtils.b(localDataLineMsgRecord.path)));
    return 5;
  }
  
  public int d()
  {
    int j = 4;
    DataLineMsgRecord localDataLineMsgRecord = a();
    int i;
    if (localDataLineMsgRecord == null) {
      i = -1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (localDataLineMsgRecord.fileMsgStatus == 2L);
      i = j;
    } while (localDataLineMsgRecord.bIsTransfering);
    if ((localDataLineMsgRecord.progress == 1.0F) && (localDataLineMsgRecord.issuc) && (FileUtil.b(localDataLineMsgRecord.path))) {
      return 5;
    }
    return 0;
  }
  
  public int e()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {
      return 0;
    }
    int i = (int)(localDataLineMsgRecord.progress * 100.0F);
    QLog.i("DatalineFileBubbleModel", 1, "watertest: progress[" + i + "]");
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.DatalineFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */