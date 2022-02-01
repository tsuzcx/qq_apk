package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Set;

class GuildMarketFaceItemBuilder$17$1
  implements Runnable
{
  GuildMarketFaceItemBuilder$17$1(GuildMarketFaceItemBuilder.17 param17, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.b.this$0.t.isEmpty())
    {
      this.b.this$0.t.remove(Long.valueOf(this.b.b.uniseq));
      GuildMarketFaceItemBuilder.a(this.b.this$0, this.b.a, this.b.b.uniseq);
      if (!this.a) {
        QQToast.makeText(this.b.this$0.o, 1, 2131886505, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.17.1
 * JD-Core Version:    0.7.0.1
 */