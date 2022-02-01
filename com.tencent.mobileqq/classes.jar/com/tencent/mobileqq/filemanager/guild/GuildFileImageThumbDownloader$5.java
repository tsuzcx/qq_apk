package com.tencent.mobileqq.filemanager.guild;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.guild.file.IGuildPreviewThumbReqCallback;
import com.tencent.mobileqq.guild.file.UFTGuildPreviewThumbRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.Addr;

class GuildFileImageThumbDownloader$5
  implements IGuildPreviewThumbReqCallback
{
  GuildFileImageThumbDownloader$5(GuildFileImageThumbDownloader paramGuildFileImageThumbDownloader, long paramLong) {}
  
  public void a(boolean paramBoolean, UFTGuildPreviewThumbRsp paramUFTGuildPreviewThumbRsp)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPreviewThumbReqCallback isSucc = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = GuildFileImageThumbDownloader.a(this.b, this.a, false);
    if ((paramBoolean) && (paramUFTGuildPreviewThumbRsp != null))
    {
      if ((localObject1 != null) && (((GuildFileImageThumbDownloader.PicSession)localObject1).b != null) && (!TextUtils.isEmpty(((GuildFileImageThumbDownloader.PicSession)localObject1).b.Uuid)))
      {
        Object localObject2 = paramUFTGuildPreviewThumbRsp.a();
        if (((List)localObject2).isEmpty()) {
          return;
        }
        ((GuildFileImageThumbDownloader.PicSession)localObject1).d = paramUFTGuildPreviewThumbRsp;
        Object localObject3 = (oidb_0xfc2.Addr)((List)localObject2).get(0);
        localObject2 = ((oidb_0xfc2.Addr)localObject3).str_ip.get();
        int i = ((oidb_0xfc2.Addr)localObject3).uint32_http_port.get();
        localObject3 = paramUFTGuildPreviewThumbRsp.c();
        int j = GuildFileImageThumbDownloader.a(this.b, ((GuildFileImageThumbDownloader.PicSession)localObject1).c);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("&fname=");
        localStringBuilder.append(((GuildFileImageThumbDownloader.PicSession)localObject1).b.Uuid);
        localStringBuilder.append("&isthumb=1&size=");
        localStringBuilder.append(j);
        localStringBuilder.append("*");
        localStringBuilder.append(j);
        localObject1 = localStringBuilder.toString();
        GuildFileImageThumbDownloader.a(this.b, this.a, paramBoolean, (String)localObject2, i, (String)localObject1, null, paramUFTGuildPreviewThumbRsp.d(), false, null, (short)0, null, null);
        if (QLog.isColorLevel())
        {
          paramUFTGuildPreviewThumbRsp = new StringBuilder();
          paramUFTGuildPreviewThumbRsp.append("onPreviewThumbReqCallback call onGetDownloadUrlResult isSucc = ");
          paramUFTGuildPreviewThumbRsp.append(paramBoolean);
          paramUFTGuildPreviewThumbRsp.append("taskId = ");
          paramUFTGuildPreviewThumbRsp.append(this.a);
          QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, paramUFTGuildPreviewThumbRsp.toString());
        }
        return;
      }
      GuildFileImageThumbDownloader.b(this.b, this.a);
      GuildFileImageThumbDownloader.b(this.b, this.a, false, null, 0, null, null, null, false, null, (short)0, null);
      return;
    }
    if (localObject1 != null) {
      GuildFileImageThumbDownloader.a(this.b).getFileManagerNotifyCenter().a(false, 54, new Object[] { ((GuildFileImageThumbDownloader.PicSession)localObject1).b });
    }
    GuildFileImageThumbDownloader.a(this.b, this.a);
    GuildFileImageThumbDownloader.a(this.b, this.a, false, null, 0, null, null, null, false, null, (short)0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFileImageThumbDownloader.5
 * JD-Core Version:    0.7.0.1
 */