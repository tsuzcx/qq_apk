package com.tencent.mobileqq.filemanager.fileassistant.aio;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;

public class DatalineMultiForwardHelper
  extends MultiForwardHelper
{
  private QQAppInterface b;
  private Context c;
  private Activity d;
  private BaseChatPie e;
  private SessionInfo f;
  
  public DatalineMultiForwardHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    this.b = paramBaseChatPie.d;
    this.c = paramBaseChatPie.e;
    this.d = paramBaseChatPie.f;
    this.e = paramBaseChatPie;
    this.f = paramBaseChatPie.ah;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      QQAppInterface localQQAppInterface = this.b;
      Context localContext = this.c;
      Activity localActivity = this.d;
      BaseChatPie localBaseChatPie = this.e;
      this.a = new DatalineAIOShareActionSheet(localQQAppInterface, localContext, localActivity, localBaseChatPie, localBaseChatPie.j());
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.aio.DatalineMultiForwardHelper
 * JD-Core Version:    0.7.0.1
 */