package com.tencent.open.filedownload.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.filedownload.TaskInfo;

public class WhiteListDownloadButton
  extends ApkFileDownloadButton
{
  public WhiteListDownloadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WhiteListDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WhiteListDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (("900".equals(paramString)) || ("400".equals(paramString))))
    {
      localQQAppInterface = ((BaseActivity)getContext()).app;
      if (this.a.h != null) {
        break label70;
      }
    }
    label70:
    for (paramString = "";; paramString = this.a.h)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC6", "0X8009AC6", 0, 0, "", "", paramString, "");
      return;
    }
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return HardCodeUtil.a(2131716785);
    }
    return HardCodeUtil.a(2131716786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.WhiteListDownloadButton
 * JD-Core Version:    0.7.0.1
 */