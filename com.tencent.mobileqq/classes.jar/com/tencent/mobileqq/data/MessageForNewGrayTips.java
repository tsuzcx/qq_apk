package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import java.util.ArrayList;
import java.util.Iterator;

public class MessageForNewGrayTips
  extends ChatMessage
{
  public ArrayList<GrayTipsSpan> spans;
  
  public void buildTextView(QQAppInterface paramQQAppInterface, TextView paramTextView)
  {
    if (TextUtils.isEmpty(this.msg)) {
      return;
    }
    paramQQAppInterface = new SpannableString(this.msg);
    Object localObject = this.spans;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = this.spans.iterator();
      while (((Iterator)localObject).hasNext())
      {
        GrayTipsSpan localGrayTipsSpan = (GrayTipsSpan)((Iterator)localObject).next();
        try
        {
          paramQQAppInterface.setSpan(new DatingCommentTextView.TouchableSpan(new MessageForNewGrayTips.1(this, localGrayTipsSpan), -12541697), localGrayTipsSpan.begin, localGrayTipsSpan.end, 33);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    paramTextView.setText(paramQQAppInterface);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public void click(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), paramString);
    if (localObject != null)
    {
      ((JumpAction)localObject).a();
    }
    else
    {
      localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramString));
      paramView.getContext().startActivity((Intent)localObject);
    }
    if ((this.msgtype == -2037) && ((paramView.getContext() instanceof BaseActivity))) {
      ReportController.b(((BaseActivity)paramView.getContext()).app, "CliOper", "", "", "0X80060B7", "0X80060B7", 0, 0, "", "", "", "");
    }
  }
  
  protected void doParse()
  {
    Object localObject;
    try
    {
      GrayTipsInfo localGrayTipsInfo = (GrayTipsInfo)MessagePkgUtils.a(this.msgData);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject != null)
    {
      this.msg = localObject.text;
      this.spans = localObject.spans;
    }
  }
  
  protected void prewrite()
  {
    if (this.msg != null)
    {
      GrayTipsInfo localGrayTipsInfo = new GrayTipsInfo();
      localGrayTipsInfo.text = this.msg;
      localGrayTipsInfo.spans = this.spans;
      try
      {
        this.msgData = MessagePkgUtils.a(localGrayTipsInfo);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void updateMsgData()
  {
    prewrite();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNewGrayTips
 * JD-Core Version:    0.7.0.1
 */