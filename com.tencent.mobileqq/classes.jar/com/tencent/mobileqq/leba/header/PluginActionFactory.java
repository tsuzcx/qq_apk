package com.tencent.mobileqq.leba.header;

import android.content.Context;
import com.tencent.mobileqq.leba.model.pluginactions.AppoloGamePluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.BuluoPluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.CampusCirclePluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.GamePluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.JDPluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.NearByPluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.PluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.QQReadPluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.QzonePluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.ReadInJoyPluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.StoryPluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.WholePeoplePluginAction;

public class PluginActionFactory
{
  public static PluginAction a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return new PluginAction(paramContext);
    case 19: 
      return new AppoloGamePluginAction(paramContext);
    case 489: 
      return new GamePluginAction(paramContext);
    case 3053: 
      return new JDPluginAction(paramContext);
    case 10000: 
      return new QzonePluginAction(paramContext);
    case 4086: 
      return new CampusCirclePluginAction(paramContext);
    case 6005: 
      return new StoryPluginAction(paramContext);
    case 769: 
      return new QQReadPluginAction(paramContext);
    case 826: 
      return new BuluoPluginAction(paramContext);
    case 770: 
      return new WholePeoplePluginAction(paramContext);
    case 10001: 
      return new NearByPluginAction(paramContext);
    }
    return new ReadInJoyPluginAction(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.PluginActionFactory
 * JD-Core Version:    0.7.0.1
 */