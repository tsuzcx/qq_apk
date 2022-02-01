package com.tencent.mobileqq.guild.chatpie.quickAt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.troop.quickat.ui.GuildAtDialog.Listener;
import com.tencent.mobileqq.widget.QQToast;
import java.util.LinkedHashMap;

public class GuildAtListHelper
  implements GuildAtDialog.Listener
{
  GuildAtListAdapter a;
  boolean b;
  private Bitmap c;
  
  public GuildAtListHelper(GuildAtListAdapter paramGuildAtListAdapter)
  {
    this.a = paramGuildAtListAdapter;
    a();
  }
  
  public static IGProUserInfo b()
  {
    return new GuildAtListHelper.1();
  }
  
  void a()
  {
    this.c = QQAppInterface.getRoundFaceBitmap(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130843506));
  }
  
  public void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.b)
      {
        paramView.setText(2131892030);
        if (this.a.d != null) {
          this.a.d.b();
        }
      }
      else
      {
        paramView.setText(2131889474);
        this.a.d.b(this.a.e);
      }
      this.b ^= true;
    }
  }
  
  void a(ImageView paramImageView)
  {
    if (paramImageView != null) {
      paramImageView.setImageBitmap(this.c);
    }
  }
  
  boolean c()
  {
    return this.a.b.size() >= 20;
  }
  
  void d()
  {
    QQToast.makeText(BaseApplicationImpl.context, 0, HardCodeUtil.a(2131908835), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtListHelper
 * JD-Core Version:    0.7.0.1
 */