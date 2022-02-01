package com.tencent.mobileqq.comment.danmaku;

import com.tencent.common.danmaku.inject.VideoDanmakuConfig.ILogger;
import com.tencent.qphone.base.util.QLog;

final class CommentDanmakuManager$1
  implements VideoDanmakuConfig.ILogger
{
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(CommentDanmakuManager.i(), 2, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e(CommentDanmakuManager.i(), 2, paramString2, paramThrowable);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(CommentDanmakuManager.i(), 2, paramString2);
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(CommentDanmakuManager.i(), 2, paramString2);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(CommentDanmakuManager.i(), 2, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(CommentDanmakuManager.i(), 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */