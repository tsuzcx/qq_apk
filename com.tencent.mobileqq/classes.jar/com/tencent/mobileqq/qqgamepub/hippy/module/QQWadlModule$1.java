package com.tencent.mobileqq.qqgamepub.hippy.module;

import com.tencent.qphone.base.util.QLog;

class QQWadlModule$1
  extends QQWadlModule.WadlListener
{
  QQWadlModule$1(QQWadlModule paramQQWadlModule)
  {
    super(null);
  }
  
  protected void a(String paramString, Object paramObject)
  {
    QQWadlModule.access$100(this.a, paramString, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQWadlModule", 2, new Object[] { "WadlListener.onCallback, eventName=", paramString, ", data=", paramObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.module.QQWadlModule.1
 * JD-Core Version:    0.7.0.1
 */