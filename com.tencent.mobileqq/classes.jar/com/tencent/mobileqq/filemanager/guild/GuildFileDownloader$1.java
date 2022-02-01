package com.tencent.mobileqq.filemanager.guild;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.guild.file.IGuildDownloadReqCallback;
import com.tencent.mobileqq.guild.file.UFTGuildDownloadRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.Addr;

class GuildFileDownloader$1
  implements IGuildDownloadReqCallback
{
  GuildFileDownloader$1(GuildFileDownloader paramGuildFileDownloader, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  public void a(boolean paramBoolean, UFTGuildDownloadRsp paramUFTGuildDownloadRsp)
  {
    long l4 = paramUFTGuildDownloadRsp.c;
    Object localObject1;
    String str;
    long l1;
    long l2;
    Object localObject2;
    long l3;
    if ((paramUFTGuildDownloadRsp.b() != null) && (paramUFTGuildDownloadRsp.b().size() > 0))
    {
      localObject1 = (oidb_0xfc2.Addr)paramUFTGuildDownloadRsp.b().get(0);
      str = ((oidb_0xfc2.Addr)localObject1).str_ip.get();
      l1 = ((oidb_0xfc2.Addr)localObject1).uint32_http_port.get();
      l2 = ((oidb_0xfc2.Addr)localObject1).uint32_https_port.get();
      localObject2 = paramUFTGuildDownloadRsp.b();
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(((oidb_0xfc2.Addr)((Iterator)localObject2).next()).str_ip.get());
      }
      Object localObject3 = paramUFTGuildDownloadRsp.c();
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((List)localObject2).add(((oidb_0xfc2.Addr)((Iterator)localObject3).next()).str_ip.get());
      }
      l3 = l1;
    }
    else
    {
      str = "";
      localObject1 = null;
      localObject2 = localObject1;
      l1 = 0L;
      l3 = l1;
      l2 = l1;
    }
    this.b.a(paramBoolean, l4, paramUFTGuildDownloadRsp.d, paramUFTGuildDownloadRsp.m, paramUFTGuildDownloadRsp.g, false, str, (short)(int)l3, paramUFTGuildDownloadRsp.l, (List)localObject1, GuildFileDownloader.a(this.b).fileName, paramUFTGuildDownloadRsp.k, (short)(int)l2, paramUFTGuildDownloadRsp.k, (List)localObject2, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */