package com.tencent.mobileqq.qqlive.filter;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.filter.data.MetaMaterial;
import com.tencent.mobileqq.qqlive.filter.download.ResDownLoadListener;

class QQLiveAEResManager$4
  implements ResDownLoadListener
{
  QQLiveAEResManager$4(QQLiveAEResManager paramQQLiveAEResManager, MetaMaterial paramMetaMaterial, QQLiveAEResManager.QQLiveFilterLoadListener paramQQLiveFilterLoadListener) {}
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    String str = QQLiveAEResManager.a(this.c, this.a);
    this.b.a(TextUtils.isEmpty(str) ^ true, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.QQLiveAEResManager.4
 * JD-Core Version:    0.7.0.1
 */