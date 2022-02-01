package com.tencent.mobileqq.flutter.config;

import com.tencent.mobileqq.dpc.DPCObserver;

class QFlutterDPC$1
  implements DPCObserver
{
  QFlutterDPC$1(QFlutterDPC paramQFlutterDPC) {}
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.config.QFlutterDPC.1
 * JD-Core Version:    0.7.0.1
 */