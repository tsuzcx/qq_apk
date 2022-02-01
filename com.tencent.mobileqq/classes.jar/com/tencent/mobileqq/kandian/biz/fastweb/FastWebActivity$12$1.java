package com.tencent.mobileqq.kandian.biz.fastweb;

import android.database.DataSetObserver;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$12$1
  extends DataSetObserver
{
  FastWebActivity$12$1(FastWebActivity.12 param12) {}
  
  public void onChanged()
  {
    QLog.d("FastWebActivity", 2, "DataSetObserver ");
    FastWebActivity.a(this.a.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.12.1
 * JD-Core Version:    0.7.0.1
 */