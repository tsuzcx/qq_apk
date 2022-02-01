package com.tencent.mobileqq.shortvideo.hwcodec;

import android.os.AsyncTask;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.utils.FileUtils;

class SVHwEncoder$HwEncode$HwThumbGenTask
  extends AsyncTask<Void, Void, Integer>
{
  SVHwEncoder$HwEncode$HwThumbGenTask(SVHwEncoder.HwEncode paramHwEncode) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(SVHwEncoder.HwEncode.e(this.a));
    paramVarArgs.append("shortvideo_thumb.jpg");
    paramVarArgs = paramVarArgs.toString();
    int j = this.a.a.a(SVHwEncoder.HwEncode.f(this.a), SVHwEncoder.n(this.a.this$0), SVHwEncoder.o(this.a.this$0), SVHwEncoder.p(this.a.this$0), SVHwEncoder.q(this.a.this$0), paramVarArgs);
    int i = j;
    if (j == 0)
    {
      String str = SVUtils.a(this.a.a.a, "jpg");
      if (FileUtils.rename(paramVarArgs, str))
      {
        this.a.a.b = str;
        i = j;
      }
      else
      {
        i = j;
        if (!FileUtils.fileExistsAndNotEmpty(str))
        {
          SVHwEncoder localSVHwEncoder = this.a.this$0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("rename failure, mThumbFilePath = ");
          localStringBuilder.append(paramVarArgs);
          localStringBuilder.append(",thumbPath=");
          localStringBuilder.append(str);
          localSVHwEncoder.a("doInBackground()", localStringBuilder.toString());
          i = -3;
        }
      }
    }
    this.a.a.d = (System.currentTimeMillis() - l);
    this.a.a.c = i;
    SVHwEncoder.HwEncode.a(this.a, true);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode.HwThumbGenTask
 * JD-Core Version:    0.7.0.1
 */