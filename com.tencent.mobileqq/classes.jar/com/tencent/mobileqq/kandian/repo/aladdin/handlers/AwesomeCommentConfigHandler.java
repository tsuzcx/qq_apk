package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AwesomeCommentConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("AwesomeCommentConfigHandler", 2, ((StringBuilder)localObject).toString());
    localObject = AladdinParseUtils.a(paramString);
    Iterator localIterator = ((Map)localObject).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)((Map)localObject).get(str1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveConfig] key=");
      localStringBuilder.append(str1);
      localStringBuilder.append(", value=");
      localStringBuilder.append(str2);
      QLog.d("AwesomeCommentConfigHandler", 2, localStringBuilder.toString());
      if (TextUtils.equals(str1, "awesome_comment_plan"))
      {
        if (TextUtils.equals(str2, "1")) {
          paramInt2 = 1;
        } else if (TextUtils.equals(str2, "2")) {
          paramInt2 = 2;
        } else {
          paramInt2 = 0;
        }
        RIJSPUtils.a(AwesomeCommentInfo.k, Integer.valueOf(paramInt2));
      }
      else if (TextUtils.equals(str1, "awesome_comment_line_number"))
      {
        try
        {
          RIJSPUtils.a(AwesomeCommentInfo.l, Integer.valueOf(str2));
          Aladdin.getConfig(paramInt1).update(paramString);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
          QLog.e("AwesomeCommentConfigHandler", 2, localNumberFormatException.getLocalizedMessage());
        }
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.AwesomeCommentConfigHandler
 * JD-Core Version:    0.7.0.1
 */