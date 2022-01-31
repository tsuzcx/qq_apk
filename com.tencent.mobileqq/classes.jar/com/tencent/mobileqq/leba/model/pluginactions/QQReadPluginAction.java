package com.tencent.mobileqq.leba.model.pluginactions;

import android.content.Context;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.utils.JumpAction;

public class QQReadPluginAction
  extends PluginAction
{
  public QQReadPluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    paramLebaGridItemInfo = a(paramLebaGridItemInfo);
    paramLebaGridItemInfo.a("ChannelID", "100020");
    paramLebaGridItemInfo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.QQReadPluginAction
 * JD-Core Version:    0.7.0.1
 */