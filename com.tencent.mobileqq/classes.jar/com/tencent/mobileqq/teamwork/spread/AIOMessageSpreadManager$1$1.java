package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class AIOMessageSpreadManager$1$1
  implements BaseTimAIOTipsProcessor.ListResult
{
  AIOMessageSpreadManager$1$1(AIOMessageSpreadManager.1 param1, String paramString) {}
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      float f1 = (float)TencentDocTipsConfigProcessor.a().e();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        float f2 = AIOMessageSpreadManager.a(this.b.this$0, this.a, str);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file[");
          localStringBuilder.append(this.a);
          localStringBuilder.append("] and [");
          localStringBuilder.append(str);
          localStringBuilder.append("], precentage[");
          localStringBuilder.append(f2);
          localStringBuilder.append("]");
          QLog.i("AIOMessageSpreadManager", 1, localStringBuilder.toString());
        }
        if (f2 - f1 > 0.0F)
        {
          str = TencentDocTipsConfigProcessor.a().f();
          paramList = TencentDocTipsConfigProcessor.a().g();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("。");
          localStringBuilder.append(paramList);
          str = localStringBuilder.toString();
          AIOMessageSpreadManager.a(this.b.this$0, this.b.a, str, paramList, "precent", null);
        }
      }
      return;
    }
    if (QLog.isDebugVersion())
    {
      if (paramList == null) {
        paramList = "lst is null";
      } else {
        paramList = "lst.size() = 0";
      }
      QLog.i("AIOMessageSpreadManager", 1, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1.1
 * JD-Core Version:    0.7.0.1
 */