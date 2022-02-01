package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GameMsgSendTimesRules
  extends GameMsgSayHelloRules
{
  public static final String c = HardCodeUtil.a(2131889899);
  private int k;
  
  public GameMsgSendTimesRules(int paramInt1, AppInterface paramAppInterface, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, List<ChatMessage> paramList)
  {
    super(paramInt1, paramAppInterface, paramString1, paramInt2, paramInt3, paramString2, paramString3, paramList);
  }
  
  public boolean a(List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      int i = paramList.size() - 1;
      int m;
      for (int j = 0; i >= 0; j = m)
      {
        Object localObject = (ChatMessage)paramList.get(i);
        if ((localObject == null) || (!(localObject instanceof MessageForUniteGrayTip))) {
          break;
        }
        localObject = (MessageForUniteGrayTip)localObject;
        m = j;
        if (localObject != null)
        {
          m = j;
          if (((MessageForUniteGrayTip)localObject).tipParam != null)
          {
            m = j;
            if (c.equals(((MessageForUniteGrayTip)localObject).tipParam.g)) {
              m = j + 1;
            }
          }
        }
        i -= 1;
      }
      if (j >= 3) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    if (this.b != 0) {
      return true;
    }
    if (!this.d) {
      return true;
    }
    return this.k < this.f;
  }
  
  public void c()
  {
    if (this.b != 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgRules.Stranger", 2, "sendTimes---[recordAction]");
    }
    this.k += 1;
  }
  
  protected void d()
  {
    if (this.b != 0)
    {
      this.d = false;
      return;
    }
    if ((this.a != null) && (this.a.size() != 0))
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        localObject = (ChatMessage)this.a.get(i);
        if ((localObject != null) && (!(localObject instanceof MessageForUniteGrayTip)))
        {
          if (!GameMsgUtil.a(((ChatMessage)localObject).time * 1000L)) {
            return;
          }
          if (((ChatMessage)localObject).issend != 1)
          {
            this.d = false;
            return;
          }
          this.k += 1;
          if (this.k > this.f)
          {
            this.d = false;
            return;
          }
        }
        i -= 1;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mCurSendMsgNum:");
      ((StringBuilder)localObject).append(this.k);
      QLog.i("GameMsgRules.Stranger", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgSendTimesRules
 * JD-Core Version:    0.7.0.1
 */