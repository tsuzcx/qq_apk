package com.tencent.mobileqq.robotchat;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class RobotChatTipLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView a;
  private ImageView b;
  private WeakReference<RobotChatTipLayout.RobotChatTipLayoutListener> c;
  
  public RobotChatTipLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a = null;
    this.c = null;
  }
  
  public void a(RobotChatTipLayout.RobotChatTipLayoutListener paramRobotChatTipLayoutListener)
  {
    this.c = new WeakReference(paramRobotChatTipLayoutListener);
    LayoutInflater.from(getContext()).inflate(2131627890, this);
    setClickable(true);
    this.a = ((TextView)findViewById(2131448801));
    this.b = ((ImageView)findViewById(2131436318));
    paramRobotChatTipLayoutListener = this.b;
    if (paramRobotChatTipLayoutListener != null) {
      paramRobotChatTipLayoutListener.setOnClickListener(this);
    }
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (!ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId))
    {
      setBackgroundColor(-1);
    }
    else
    {
      setBackgroundColor(-5066062);
      findViewById(2131436349).setBackgroundColor(-10197916);
    }
    setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (RobotChatTipLayout.RobotChatTipLayoutListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((RobotChatTipLayout.RobotChatTipLayoutListener)localObject).a(this);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setRobotName(String paramString)
  {
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = getResources().getString(2131915850);
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    String str = null;
    paramString = str;
    if (localObject2 != null)
    {
      paramString = str;
      if ((localObject2 instanceof QQAppInterface))
      {
        paramString = ((ITroopRobotService)((QQAppInterface)localObject2).getRuntimeService(ITroopRobotService.class, "all")).getRobotWarning();
        if (!TextUtils.isEmpty(paramString)) {
          try
          {
            paramString = paramString.replace("[name]", "%1$s");
          }
          catch (Exception paramString)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("setRobotName exception: ");
            ((StringBuilder)localObject2).append(paramString);
            QLog.e("RobotChatTipLayout", 2, ((StringBuilder)localObject2).toString());
            paramString = str;
          }
        }
      }
    }
    str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getResources().getString(2131915848);
    }
    paramString = String.format(str, new Object[] { localObject1 });
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i = paramString.indexOf((String)localObject1, 4);
      if (i < 0) {
        return;
      }
      paramString = new SpannableString(paramString);
      paramString.setSpan(new ForegroundColorSpan(-11692801), i, ((String)localObject1).length() + i, 33);
      localObject1 = this.a;
      if (localObject1 != null) {
        ((TextView)localObject1).setText(paramString);
      }
      setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatTipLayout
 * JD-Core Version:    0.7.0.1
 */