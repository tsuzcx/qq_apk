package com.tencent.mobileqq.config.splashlogo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoMsgTailHelper;
import java.util.List;

class ConfigServlet$2
  implements ConfigServlet.IHandleConfigCallback
{
  ConfigServlet$2(ConfigServlet paramConfigServlet, QQAppInterface paramQQAppInterface) {}
  
  public int a()
  {
    return ShortVideoMsgTailHelper.a(this.a.getApp());
  }
  
  public void a(int paramInt)
  {
    ShortVideoMsgTailHelper.d(this.a.getApp(), paramInt);
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      ShortVideoMsgTailHelper.a(this.a.getApp(), paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.2
 * JD-Core Version:    0.7.0.1
 */