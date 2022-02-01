package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryTask.Query;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

class GuildMarketFaceItemBuilder$1
  implements QueryTask.Query<MarkFaceMessage, Void>
{
  GuildMarketFaceItemBuilder$1(GuildMarketFaceItemBuilder paramGuildMarketFaceItemBuilder, GuildMarketFaceItemBuilder.Holder paramHolder) {}
  
  public Void a(MarkFaceMessage paramMarkFaceMessage)
  {
    paramMarkFaceMessage = (IPicEmoticonInfo)((IEmoticonManagerService)this.b.g.getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(paramMarkFaceMessage);
    this.a.a = paramMarkFaceMessage;
    if ((paramMarkFaceMessage != null) && (paramMarkFaceMessage.getEmoticon() != null)) {
      this.a.b = ((IEmoticonManagerService)this.b.g.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramMarkFaceMessage.getEmoticon().epId);
    }
    MagicfaceViewController.b();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */