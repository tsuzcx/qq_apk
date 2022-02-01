package com.tencent.mobileqq.guild.audio.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragListener;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildTitleRedPoint
  implements DragFrameLayout.OnDragListener, DragFrameLayout.OnDragModeChangedListener
{
  private BaseQQAppInterface a;
  private Activity b;
  private String c;
  private String d;
  
  public void a(float paramFloat1, float paramFloat2, int paramInt, View paramView)
  {
    paramFloat2 = (int)(this.b.getResources().getDisplayMetrics().density * 48.0F);
    if (paramFloat1 < paramFloat2) {}
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildTitleRedPoint", 2, "redPoint onChange");
      }
      Object localObject = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getChannelList(this.c);
      paramDragFrameLayout = new ArrayList();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localIGProChannelInfo.getChannelUin())) && (!this.d.equals(localIGProChannelInfo.getChannelUin()))) {
            paramDragFrameLayout.add(localIGProChannelInfo.getChannelUin());
          }
        }
      }
      ((IGuildMsgReadedService)this.a.getRuntimeService(IGuildMsgReadedService.class, "")).setChannelMsgReaded(this.c, paramDragFrameLayout, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.GuildTitleRedPoint
 * JD-Core Version:    0.7.0.1
 */