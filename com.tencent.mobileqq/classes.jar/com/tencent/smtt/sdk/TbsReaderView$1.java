package com.tencent.smtt.sdk;

import android.os.Bundle;
import com.tencent.smtt.sdk.stat.MttLoader;

class TbsReaderView$1
  implements TbsReaderView.ReaderCallback
{
  TbsReaderView$1(TbsReaderView paramTbsReaderView) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    int i = 0;
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      if ((this.this$0.mCallBack != null) && (i == 0)) {
        this.this$0.mCallBack.onCallBackAction(paramInteger, paramObject1, paramObject2);
      }
      return;
      Object localObject1;
      if (!MttLoader.isBrowserInstalledEx(this.this$0.mContext))
      {
        paramInteger = Integer.valueOf(5011);
        localObject1 = TbsReaderView.getResString(this.this$0.mContext, 5023);
        paramObject1 = new Bundle();
        paramObject1.putString("tip", (String)localObject1);
        paramObject1.putString("statistics", "AHNG812");
        paramObject1.putInt("channel_id", 10834);
        this.this$0.userStatistics("AHNG811");
      }
      else
      {
        localObject1 = "";
        if (paramObject1 != null)
        {
          localObject2 = (Bundle)paramObject1;
          localObject1 = ((Bundle)localObject2).getString("docpath");
        }
        QbSdk.startQBForDoc(this.this$0.mContext, (String)localObject1, 4, 0, "pdf", (Bundle)localObject2);
        this.this$0.userStatistics("AHNG813");
        i = 1;
        continue;
        if (!MttLoader.isBrowserInstalledEx(this.this$0.mContext))
        {
          paramInteger = Integer.valueOf(5011);
          localObject1 = TbsReaderView.getResString(this.this$0.mContext, 5021);
          paramObject1 = new Bundle();
          paramObject1.putString("tip", (String)localObject1);
          paramObject1.putString("statistics", "AHNG808");
          paramObject1.putInt("channel_id", 10833);
          this.this$0.userStatistics("AHNG807");
        }
        else
        {
          localObject1 = "";
          localObject2 = localObject3;
          if (paramObject1 != null)
          {
            localObject2 = (Bundle)paramObject1;
            localObject1 = ((Bundle)localObject2).getString("docpath");
          }
          QbSdk.startQBForDoc(this.this$0.mContext, (String)localObject1, 4, 0, "", (Bundle)localObject2);
          this.this$0.userStatistics("AHNG809");
          i = 1;
          continue;
          if (!MttLoader.isBrowserInstalledEx(this.this$0.mContext))
          {
            paramInteger = Integer.valueOf(5011);
            localObject1 = TbsReaderView.getResString(this.this$0.mContext, 5022);
            paramObject1 = new Bundle();
            paramObject1.putString("tip", (String)localObject1);
            paramObject1.putString("statistics", "AHNG816");
            paramObject1.putInt("channel_id", 10835);
            this.this$0.userStatistics("AHNG815");
          }
          else
          {
            localObject1 = "";
            localObject2 = localObject4;
            if (paramObject1 != null)
            {
              localObject2 = (Bundle)paramObject1;
              localObject1 = ((Bundle)localObject2).getString("docpath");
            }
            QbSdk.startQBForDoc(this.this$0.mContext, (String)localObject1, 4, 0, "txt", (Bundle)localObject2);
            i = 1;
            continue;
            if (!MttLoader.isBrowserInstalledEx(this.this$0.mContext))
            {
              paramInteger = Integer.valueOf(5011);
              localObject1 = TbsReaderView.getResString(this.this$0.mContext, 5029);
              paramObject1 = new Bundle();
              paramObject1.putString("tip", (String)localObject1);
              paramObject1.putString("statistics", "AHNG828");
              paramObject1.putInt("channel_id", 10965);
              this.this$0.userStatistics("AHNG827");
            }
            else
            {
              localObject1 = "";
              localObject2 = localObject5;
              if (paramObject1 != null)
              {
                localObject2 = (Bundle)paramObject1;
                localObject1 = ((Bundle)localObject2).getString("docpath");
              }
              QbSdk.startQBForDoc(this.this$0.mContext, (String)localObject1, 4, 0, "doc", (Bundle)localObject2);
              this.this$0.userStatistics("AHNG829");
              i = 1;
              continue;
              if (paramObject1 != null)
              {
                localObject1 = (Bundle)paramObject1;
                TbsReaderView.gReaderPackName = ((Bundle)localObject1).getString("name");
                TbsReaderView.gReaderPackVersion = ((Bundle)localObject1).getString("version");
              }
              i = 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderView.1
 * JD-Core Version:    0.7.0.1
 */