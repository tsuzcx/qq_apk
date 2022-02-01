package com.tencent.mobileqq.filemanager.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
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
  
  private void A()
  {
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord == null) {
      return;
    }
    String str1 = localDataLineMsgRecord.path;
    if (FileUtils.fileExistsAndNotEmpty(str1))
    {
      long l = FileUtils.getFileSizes(str1);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131904132));
      localStringBuilder.append(str2);
      localStringBuilder.append(HardCodeUtil.a(2131904130));
      localStringBuilder.append(FileUtil.a(l));
      localStringBuilder.append("。");
      localIntent.putExtra("forward_text", localStringBuilder.toString());
      localIntent.putExtra("forward_type", 0);
      localIntent.putExtra("forward_filepath", str1);
      localIntent.putExtra("fileinfo", localForwardFileInfo);
      localIntent.putExtra("not_forward", true);
      localIntent.putExtra("forward _key_nojump", true);
      localIntent.putExtra("k_favorites", false);
      if (!TextUtils.isEmpty(localDataLineMsgRecord.thumbPath)) {
        localIntent.putExtra("forward_thumb", localDataLineMsgRecord.path);
      }
      ForwardBaseOption.a((Activity)this.c, localIntent, 21);
    }
  }
  
  private void B()
  {
    a(true, null);
  }
  
  private void C()
  {
    Object localObject2 = G();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = FileManagerUtil.a((DataLineMsgRecord)localObject2);
    int j = FileManagerUtil.c(((DataLineMsgRecord)localObject2).filename);
    int i = j;
    if (j == -1)
    {
      i = j;
      if (((DataLineMsgRecord)localObject2).msgtype == -2000) {
        i = 0;
      }
    }
    localObject2 = new DatalineFileBrowserParams(this.b, this.c, (FileManagerEntity)localObject1);
    if (i == 0)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
      ((DatalineFileBrowserParams)localObject2).a(localArrayList);
    }
    localObject1 = new FileBrowserCreator(this.c, (IFileBrowserParams)localObject2);
    ((FileBrowserCreator)localObject1).a(11);
    ((FileBrowserCreator)localObject1).a();
  }
  
  private void D()
  {
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord == null)
    {
      QLog.e("DatalineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a DataLineMsgRecord");
      return;
    }
    if (FileUtil.b(localDataLineMsgRecord.path)) {
      ThreadManager.executeOnSubThread(new DatalineFileBubbleModel.3(this, localDataLineMsgRecord));
    }
  }
  
  private void E()
  {
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord == null)
    {
      QLog.e("DatalineFileBubbleModel", 1, "fetchImageFileThumb. can not find a DataLineMsgRecord");
      return;
    }
    if (FileUtil.b(localDataLineMsgRecord.path)) {
      ThreadManager.executeOnSubThread(new DatalineFileBubbleModel.4(this, localDataLineMsgRecord));
    }
  }
  
  private boolean F()
  {
    return this.a != null;
  }
  
  private DataLineMsgRecord G()
  {
    if (!F()) {
      return null;
    }
    int i = this.a.deviceType;
    long l = this.a.associatedId;
    DataLineMsgRecord localDataLineMsgRecord = this.b.getMessageFacade().d(i).a(l);
    if (localDataLineMsgRecord == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSourceDatalineFile：do not find sessionId[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("DatalineFileBubbleModel", 1, localStringBuilder.toString());
    }
    return localDataLineMsgRecord;
  }
  
  private void a(View paramView)
  {
    a(false, AnimationUtils.a(paramView));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.nWeiyunSessionId != 0L) {
      localObject = this.b.getFileManagerDataCenter().a(paramDataLineMsgRecord.nWeiyunSessionId);
    } else {
      localObject = null;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileManagerUtil.j(paramDataLineMsgRecord.filename));
      ((StringBuilder)localObject).append(BaseApplication.getContext().getResources().getString(2131889759));
      FMToastUtil.b(((StringBuilder)localObject).toString());
      paramDataLineMsgRecord.nWeiyunSessionId = this.b.getFileManagerEngine().a(paramDataLineMsgRecord.path, null, this.b.getAccount(), 0, false).nSessionId;
      this.b.getMessageFacade().d(i).f(paramDataLineMsgRecord.msgId);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileManagerUtil.j(paramDataLineMsgRecord.filename));
    ((StringBuilder)localObject).append(BaseApplication.getContext().getResources().getString(2131889759));
    FMToastUtil.b(((StringBuilder)localObject).toString());
    this.b.getFileManagerEngine().b(paramDataLineMsgRecord.nWeiyunSessionId);
  }
  
  private void a(boolean paramBoolean, Rect paramRect)
  {
    Object localObject = G();
    if (localObject == null) {
      return;
    }
    localObject = FileManagerUtil.a((DataLineMsgRecord)localObject);
    localObject = new DatalineFileBrowserParams(this.b, this.c, (FileManagerEntity)localObject);
    ((DatalineFileBrowserParams)localObject).a(this.d);
    ((DatalineFileBrowserParams)localObject).a(this.a);
    ((DatalineFileBrowserParams)localObject).a(paramBoolean);
    ((DatalineFileBrowserParams)localObject).b(false);
    localObject = new FileBrowserCreator(this.c, (IFileBrowserParams)localObject);
    ((FileBrowserCreator)localObject).a(1);
    ((FileBrowserCreator)localObject).a(paramRect);
    ((FileBrowserCreator)localObject).a(true);
    ((FileBrowserCreator)localObject).a();
  }
  
  private void b(View paramView)
  {
    if ((this.a.isMultiMsg) && (!FileManagerUtil.a(this.a, this.b, this.c))) {
      return;
    }
    if (G() == null) {
      return;
    }
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.c, paramView, this.a, this.d, false, false);
  }
  
  private void x()
  {
    ChatActivityFacade.b(this.c, this.b, this.a);
  }
  
  private void y()
  {
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord == null) {
      return;
    }
    String str = localDataLineMsgRecord.path;
    if (str.isEmpty())
    {
      QfavBuilder.a(null, localDataLineMsgRecord.msg).a(this.b).a((Activity)this.c, this.b.getAccount());
      QfavReport.a(this.b, 64, 1);
      return;
    }
    new QfavBuilder(3).a(this.b, this.c, str);
  }
  
  private void z()
  {
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord == null) {
      return;
    }
    if ((FileManagerUtil.b()) && (localDataLineMsgRecord.filesize > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      if (FreeWifiHelper.a((Activity)this.c, 5, new DatalineFileBubbleModel.1(this))) {
        FMDialogUtil.a(this.c, 2131889584, 2131889587, new DatalineFileBubbleModel.2(this));
      }
    }
    else {
      a(localDataLineMsgRecord);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131445242: 
      z();
      return;
    case 2131439081: 
      B();
      return;
    case 2131433636: 
      A();
      return;
    case 2131432813: 
      y();
      return;
    }
    x();
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramInt == 1)
    {
      C();
      return;
    }
    if (paramInt == 2)
    {
      b(paramView);
      return;
    }
    if (paramInt == 3)
    {
      DataLineMsgRecord localDataLineMsgRecord = G();
      if ((localDataLineMsgRecord != null) && (QFileAssistantUtils.a(localDataLineMsgRecord.frienduin)))
      {
        QLog.i("DatalineFileBubbleModel", 1, "entity is fileAssistant Type, return!");
        return;
      }
      a(paramView);
      return;
    }
    C();
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForDLFile))
    {
      QLog.e("DatalineFileBubbleModel", 1, "setBubbleModelData. is not a MessageForFile");
      return;
    }
    this.a = ((MessageForDLFile)paramChatMessage);
  }
  
  public boolean a()
  {
    return F();
  }
  
  public QFileBubblePauseHandler b()
  {
    return new DatalineFileBubblePauseHandler(this.b, this.c);
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord == null) {
      return localArrayList;
    }
    if (paramInt == 3) {
      localArrayList.add(Integer.valueOf(13));
    }
    if (FileUtil.b(localDataLineMsgRecord.path))
    {
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(19));
      localArrayList.add(Integer.valueOf(22));
    }
    localArrayList.add(Integer.valueOf(20));
    localArrayList.add(Integer.valueOf(16));
    localArrayList.add(Integer.valueOf(17));
    return localArrayList;
  }
  
  public QFileBubbleDownloadHandler c()
  {
    return new DatalineFileBubbleDownloadHandler(this.b, this.c);
  }
  
  public List<Integer> c(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord == null) {
      return localArrayList;
    }
    if (FileUtil.b(localDataLineMsgRecord.path))
    {
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(19));
      localArrayList.add(Integer.valueOf(22));
    }
    localArrayList.add(Integer.valueOf(20));
    return localArrayList;
  }
  
  public int d()
  {
    return 0;
  }
  
  public int e()
  {
    return 0;
  }
  
  public String f()
  {
    if (!F()) {
      return "";
    }
    return this.a.fileName;
  }
  
  public long g()
  {
    if (!F()) {
      return 0L;
    }
    return this.a.fileSize;
  }
  
  public String h()
  {
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord != null)
    {
      String str = localDataLineMsgRecord.thumbPath;
      if (FileUtil.b(str)) {
        return str;
      }
      int i = FileManagerUtil.c(localDataLineMsgRecord.filename);
      if (i == 2) {
        localDataLineMsgRecord.thumbPath = FileManagerUtil.q(localDataLineMsgRecord.path);
      } else if (i == 0) {
        localDataLineMsgRecord.thumbPath = FilePicURLDrawlableHelper.a(localDataLineMsgRecord.path);
      }
      return localDataLineMsgRecord.thumbPath;
    }
    return "";
  }
  
  public int i()
  {
    DataLineMsgRecord localDataLineMsgRecord = G();
    int j = 0;
    if (localDataLineMsgRecord == null) {
      return 0;
    }
    if (localDataLineMsgRecord.fileMsgStatus == 2L) {
      return 4;
    }
    if (localDataLineMsgRecord.fileMsgStatus == 1L) {
      return 0;
    }
    if (localDataLineMsgRecord.bIsTransfering) {
      return 3;
    }
    int i = j;
    if (localDataLineMsgRecord.progress == 1.0F)
    {
      i = j;
      if (localDataLineMsgRecord.issuc)
      {
        i = j;
        if (FileUtils.fileExistsAndNotEmpty(localDataLineMsgRecord.path)) {
          i = 5;
        }
      }
    }
    return i;
  }
  
  public int j()
  {
    DataLineMsgRecord localDataLineMsgRecord = G();
    if (localDataLineMsgRecord == null) {
      return -1;
    }
    int j = 0;
    if (localDataLineMsgRecord.fileMsgStatus == 2L) {}
    while (localDataLineMsgRecord.bIsTransfering) {
      return 4;
    }
    int i = j;
    if (localDataLineMsgRecord.progress == 1.0F)
    {
      i = j;
      if (localDataLineMsgRecord.issuc)
      {
        i = j;
        if (FileUtil.b(localDataLineMsgRecord.path)) {
          i = 5;
        }
      }
    }
    return i;
  }
  
  public int k()
  {
    Object localObject = G();
    if (localObject == null) {
      return 0;
    }
    int i = (int)(((DataLineMsgRecord)localObject).progress * 100.0F);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("watertest: progress[");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("]");
    QLog.i("DatalineFileBubbleModel", 1, ((StringBuilder)localObject).toString());
    return i;
  }
  
  public void l()
  {
    if (this.e)
    {
      w();
      if (QLog.isColorLevel()) {
        QLog.i("DatalineFileBubbleModel", 1, "fetchFileThumb.");
      }
      DataLineMsgRecord localDataLineMsgRecord = G();
      if (localDataLineMsgRecord == null) {
        return;
      }
      int i = FileManagerUtil.c(localDataLineMsgRecord.filename);
      if (i == 2)
      {
        D();
        return;
      }
      if (i == 0) {
        E();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.DatalineFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */