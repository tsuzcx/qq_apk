package com.tencent.mobileqq.shortvideo.filter;

import java.util.Comparator;

class QQFilterRenderManager$ChainBuilder$1
  implements Comparator<QQFilterRenderManager.ChainBuilder.Entry>
{
  QQFilterRenderManager$ChainBuilder$1(QQFilterRenderManager.ChainBuilder paramChainBuilder) {}
  
  public int compare(QQFilterRenderManager.ChainBuilder.Entry paramEntry1, QQFilterRenderManager.ChainBuilder.Entry paramEntry2)
  {
    return Integer.compare(paramEntry1.type, paramEntry2.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder.1
 * JD-Core Version:    0.7.0.1
 */