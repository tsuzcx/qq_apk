package com.tencent.mobileqq.guild.mainframe.helper;

import android.content.Context;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class ChannelListViewHelper
{
  public static int a(Context paramContext)
  {
    int i = DisplayUtil.a(paramContext).a - DisplayUtil.a(paramContext, 72.0F) - DisplayUtil.a(paramContext, 0.0F);
    int j = (int)(i * 0.5F);
    QLog.d("ChannelListAnimateHelper", 4, new Object[] { "getFitCoverHeight, w: ", Integer.valueOf(i), " h: ", Integer.valueOf(j) });
    return j;
  }
  
  public static ChannelListViewHelper.IAutoCollapseHandler a()
  {
    return new ChannelListViewHelper.AutoCollapseHandler(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper
 * JD-Core Version:    0.7.0.1
 */