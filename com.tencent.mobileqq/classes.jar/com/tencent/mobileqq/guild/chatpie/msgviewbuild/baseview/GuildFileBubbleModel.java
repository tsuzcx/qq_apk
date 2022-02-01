package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel;
import com.tencent.mobileqq.filemanager.core.HttpThumbDownloader;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.AIOImgInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.guild.file.IGuildDownloadReqCallback;
import com.tencent.mobileqq.guild.file.UFTGuildDownloadRsp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GuildFileBubbleModel
  extends QFileBubbleModel
  implements IGuildDownloadReqCallback
{
  private static int g;
  private FileManagerEntity a;
  private MessageForFile f;
  
  public GuildFileBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private void y()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if (localFileManagerEntity == null)
    {
      QLog.e("GuildFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((FileUtil.b(localFileManagerEntity.getFilePath())) && (FileManagerUtil.f(localFileManagerEntity)))
    {
      ThreadManager.executeOnSubThread(new GuildFileBubbleModel.3(this, localFileManagerEntity));
      return;
    }
    this.b.getFileManagerEngine().a(localFileManagerEntity);
  }
  
  private void z()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if (localFileManagerEntity == null)
    {
      QLog.e("GuildFileBubbleModel", 1, "fetchGuildImageFileThumb. can not find a FileManagerEntity");
      return;
    }
    if (FileUtil.b(localFileManagerEntity.getFilePath()))
    {
      ThreadManager.executeOnSubThread(new GuildFileBubbleModel.4(this, localFileManagerEntity));
      return;
    }
    if (FilePicURLDrawlableHelper.i(localFileManagerEntity))
    {
      this.b.getFileManagerEngine().b(localFileManagerEntity, 7);
      return;
    }
    this.b.getFileManagerEngine().b(localFileManagerEntity, 5);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, View paramView) {}
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForFile))
    {
      QLog.e("GuildFileBubbleModel", 1, "setBubbleModelData. is not a MessageForFile");
      return;
    }
    this.f = ((MessageForFile)paramChatMessage);
    this.a = FileManagerUtil.a(this.b, this.f);
    paramChatMessage = this.a;
    if (paramChatMessage == null)
    {
      QLog.e("GuildFileBubbleModel", 1, "setBubbleModelData. can not find a FileManagerEntity");
      return;
    }
    FileManagerUtil.e(paramChatMessage);
  }
  
  public void a(boolean paramBoolean, UFTGuildDownloadRsp paramUFTGuildDownloadRsp)
  {
    if ((!paramBoolean) || (paramUFTGuildDownloadRsp == null) || (this.a == null) || (TextUtils.isEmpty(paramUFTGuildDownloadRsp.d()))) {
      QLog.i("GuildFileBubbleModel", 1, "get preview url failed");
    }
    String str = h();
    new HttpThumbDownloader(this.b).a(this.a.nSessionId, str, paramUFTGuildDownloadRsp.d(), new GuildFileBubbleModel.5(this));
  }
  
  public boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.a;
    return (localFileManagerEntity != null) && (localFileManagerEntity.isSend());
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 * 1000L <= System.currentTimeMillis();
  }
  
  public QFileBubblePauseHandler b()
  {
    return null;
  }
  
  public List<Integer> b(int paramInt)
  {
    return null;
  }
  
  public QFileBubbleDownloadHandler c()
  {
    return null;
  }
  
  public List<Integer> c(int paramInt)
  {
    return null;
  }
  
  public int d()
  {
    FileManagerEntity localFileManagerEntity = this.a;
    if (localFileManagerEntity == null) {
      return 0;
    }
    return FilePicURLDrawlableHelper.h(localFileManagerEntity).a;
  }
  
  public int e()
  {
    FileManagerEntity localFileManagerEntity = this.a;
    if (localFileManagerEntity == null) {
      return 0;
    }
    return FilePicURLDrawlableHelper.h(localFileManagerEntity).b;
  }
  
  public String f()
  {
    FileManagerEntity localFileManagerEntity = this.a;
    if (localFileManagerEntity == null) {
      return "";
    }
    return localFileManagerEntity.fileName;
  }
  
  public long g()
  {
    FileManagerEntity localFileManagerEntity = this.a;
    if (localFileManagerEntity == null) {
      return 0L;
    }
    return localFileManagerEntity.fileSize;
  }
  
  public String h()
  {
    if (this.f == null) {
      return "";
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if (localFileManagerEntity == null) {
      return "";
    }
    Object localObject = localFileManagerEntity.strMiddleThumPath;
    int i = FileManagerUtil.c(localFileManagerEntity.fileName);
    if (i == 0)
    {
      String str = localFileManagerEntity.strMiddleThumPath;
      localObject = str;
      if (!FileUtil.b(str))
      {
        localObject = str;
        if (FileUtil.b(localFileManagerEntity.strLargeThumPath))
        {
          if (FilePicURLDrawlableHelper.i(localFileManagerEntity))
          {
            ThreadManagerV2.executeOnSubThread(new GuildFileBubbleModel.1(this, localFileManagerEntity));
            return str;
          }
          return localFileManagerEntity.strLargeThumPath;
        }
      }
    }
    else if (i == 2)
    {
      localObject = localFileManagerEntity.strLargeThumPath;
    }
    return localObject;
  }
  
  public int i()
  {
    FileManagerEntity localFileManagerEntity = this.a;
    int i = 0;
    if (localFileManagerEntity == null) {
      return 0;
    }
    if (a(localFileManagerEntity.lastTime, this.a.srvTime)) {
      i = 6;
    }
    return i;
  }
  
  public int j()
  {
    return 0;
  }
  
  public int k()
  {
    return 0;
  }
  
  public void l()
  {
    if (this.f != null)
    {
      if (this.a == null) {
        return;
      }
      if (!this.e) {
        return;
      }
      w();
      int i = FileManagerUtil.c(this.a.fileName);
      if (i == 2)
      {
        y();
        return;
      }
      if (i == 0) {
        z();
      }
    }
  }
  
  public void m() {}
  
  public boolean n()
  {
    return false;
  }
  
  public void o() {}
  
  public long p()
  {
    FileManagerEntity localFileManagerEntity = this.a;
    if (localFileManagerEntity == null) {
      return 0L;
    }
    if (localFileManagerEntity.getCloudType() == 0) {
      return 0L;
    }
    if (this.a.status == 16) {
      return -1L;
    }
    if (FileUtils.fileExistsAndNotEmpty(this.a.getFilePath())) {
      return 0L;
    }
    long l = this.a.srvTime;
    return this.a.lastTime - this.a.srvTime;
  }
  
  public int q()
  {
    FileManagerEntity localFileManagerEntity = this.a;
    if (localFileManagerEntity == null) {
      return 0;
    }
    if (QFileUtils.a(localFileManagerEntity.imgWidth, this.a.imgHeight, this.a.fileSize)) {
      return 1;
    }
    if (this.a.thumbInvalidCode == 1) {
      return 1;
    }
    if (this.a.thumbInvalidCode == 2) {
      return 2;
    }
    return super.q();
  }
  
  public String r()
  {
    return "";
  }
  
  protected void w()
  {
    this.e = false;
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GuildFileBubbleModel.2(this), 5000L);
  }
  
  public GuildFileNormalBubblePauseHandler x()
  {
    return new GuildFileNormalBubblePauseHandler(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */