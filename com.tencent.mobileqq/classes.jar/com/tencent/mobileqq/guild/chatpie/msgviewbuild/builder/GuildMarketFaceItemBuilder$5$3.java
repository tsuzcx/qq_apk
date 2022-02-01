package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.qphone.base.util.QLog;

class GuildMarketFaceItemBuilder$5$3
  implements Runnable
{
  GuildMarketFaceItemBuilder$5$3(GuildMarketFaceItemBuilder.5 param5, GuildMarketFaceItemBuilder.Holder paramHolder, Emoticon paramEmoticon) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((GuildMarketFaceItemBuilder.Holder)localObject).i != null)) {
      if ((this.c.a.s) && (this.c.a.r.isDPCSupportH5Magic()))
      {
        this.a.i.setVisibility(0);
        this.a.i.setImageResource(2130837998);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("magicFaceIcon visible,h5source download sucess and doesnot needplay epId = ");
          ((StringBuilder)localObject).append(this.b.epId);
          QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.a.i.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.5.3
 * JD-Core Version:    0.7.0.1
 */