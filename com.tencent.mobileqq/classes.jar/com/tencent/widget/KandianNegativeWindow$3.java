package com.tencent.widget;

import com.tencent.qphone.base.util.QLog;

class KandianNegativeWindow$3
  implements Runnable
{
  KandianNegativeWindow$3(KandianNegativeWindow paramKandianNegativeWindow, StringBuilder paramStringBuilder, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder1 = this.a;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("x:");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = this.a;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("  y:");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = this.a;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("  mTriangleHeight:");
    localStringBuilder2.append(this.this$0.z);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = this.a;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("  mScreenWidth:");
    localStringBuilder2.append(this.this$0.A);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = this.a;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("  mTriangleHeight:");
    localStringBuilder2.append(this.this$0.B);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = this.a;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("  mWindowWidth:");
    localStringBuilder2.append(this.this$0.C);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = this.a;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("  mChildrenItemHeight:");
    localStringBuilder2.append(this.this$0.E);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = this.a;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("  isNormal:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("calculatePosition,");
    localStringBuilder1.append(this.a.toString());
    QLog.d("KandianNegativeWindow", 1, localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindow.3
 * JD-Core Version:    0.7.0.1
 */