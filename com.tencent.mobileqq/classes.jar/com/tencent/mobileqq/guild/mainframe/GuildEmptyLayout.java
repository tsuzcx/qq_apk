package com.tencent.mobileqq.guild.mainframe;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@RequiresApi(api=21)
public class GuildEmptyLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public GuildEmptyLayout(@NonNull Context paramContext)
  {
    this(paramContext, null, 0, 0);
  }
  
  public GuildEmptyLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 0);
  }
  
  public GuildEmptyLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public GuildEmptyLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    try
    {
      LayoutInflater.from(paramContext).inflate(2131625051, this);
    }
    catch (Exception paramContext)
    {
      QLog.e("GuildEmptyLayout", 1, "Inflate Error!", paramContext);
    }
    findViewById(2131430116).setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a())
    {
      Intent localIntent = QQGuildUtil.g("https://wj.qq.com/edit.html?sid=8629040");
      getContext().startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildEmptyLayout
 * JD-Core Version:    0.7.0.1
 */