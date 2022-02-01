package com.tencent.tkd.comment.publisher.qq;

import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLogBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQSharedPreferenceBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;

public class QQPublishCommentManager
{
  private static final QQPublishCommentManager INSTANCE = new QQPublishCommentManager();
  private QQLifecycleBridge lifecycleBridge;
  private QQLogBridge logBridge;
  private QQPublishCommentBridge publisherBridge;
  private QQReportBridge reportBridge;
  private QQSharedPreferenceBridge spBridge;
  private QQUrlImageBridge urlImageBridge;
  private QQViewBridge viewBridge;
  
  public static QQPublishCommentManager getInstance()
  {
    return INSTANCE;
  }
  
  public QQLifecycleBridge getLifecycleBridge()
  {
    return this.lifecycleBridge;
  }
  
  public QQLogBridge getLogBridge()
  {
    return this.logBridge;
  }
  
  public QQPublishCommentBridge getPublisherBridge()
  {
    return this.publisherBridge;
  }
  
  public QQReportBridge getReportBridge()
  {
    return this.reportBridge;
  }
  
  public QQSharedPreferenceBridge getSpBridge()
  {
    return this.spBridge;
  }
  
  public QQUrlImageBridge getUrlImageBridge()
  {
    return this.urlImageBridge;
  }
  
  public QQViewBridge getViewBridge()
  {
    return this.viewBridge;
  }
  
  public boolean isBridgeNotAvailable()
  {
    return (this.publisherBridge == null) || (this.reportBridge == null) || (this.spBridge == null) || (this.viewBridge == null) || (this.logBridge == null) || (this.lifecycleBridge == null) || (this.urlImageBridge == null);
  }
  
  public void reset()
  {
    this.publisherBridge = null;
    this.reportBridge = null;
    this.spBridge = null;
    this.viewBridge = null;
    this.logBridge = null;
    this.lifecycleBridge = null;
    this.urlImageBridge = null;
  }
  
  public void setLifecycleBridge(QQLifecycleBridge paramQQLifecycleBridge)
  {
    this.lifecycleBridge = paramQQLifecycleBridge;
  }
  
  public void setLogBridge(QQLogBridge paramQQLogBridge)
  {
    this.logBridge = paramQQLogBridge;
  }
  
  public void setPublisherBridge(QQPublishCommentBridge paramQQPublishCommentBridge)
  {
    this.publisherBridge = paramQQPublishCommentBridge;
  }
  
  public void setReportBridge(QQReportBridge paramQQReportBridge)
  {
    this.reportBridge = paramQQReportBridge;
  }
  
  public void setSpBridge(QQSharedPreferenceBridge paramQQSharedPreferenceBridge)
  {
    this.spBridge = paramQQSharedPreferenceBridge;
  }
  
  public void setUrlImageBridge(QQUrlImageBridge paramQQUrlImageBridge)
  {
    this.urlImageBridge = paramQQUrlImageBridge;
  }
  
  public void setViewBridge(QQViewBridge paramQQViewBridge)
  {
    this.viewBridge = paramQQViewBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager
 * JD-Core Version:    0.7.0.1
 */