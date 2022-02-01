package com.tencent.mobileqq.qwallet.config.impl;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.config.IQWalletHtmlOfflineConfigService;
import java.io.File;

public class QWalletHtmlOfflineConfigServiceImpl
  implements IQWalletHtmlOfflineConfigService
{
  private static final String TAG = "QWalletHtmlOfflineConfigServiceImpl";
  
  public void setShengpiziTypeface(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    Typeface localTypeface = null;
    Object localObject2 = OfflineEnvHelper.b("4575");
    Object localObject1 = localTypeface;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("4575");
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append("/i.gtimg.cn/channel/ttf/HuaWenKaiTi.ttf");
      localObject2 = new File(((StringBuilder)localObject1).toString());
      localObject1 = localTypeface;
      if (((File)localObject2).exists())
      {
        localTypeface = Typeface.createFromFile((File)localObject2);
        localObject1 = localTypeface;
        if (localTypeface != null)
        {
          paramTextView.setTypeface(localTypeface);
          localObject1 = localTypeface;
        }
      }
    }
    if (localObject1 == null) {
      ThreadManagerV2.executeOnSubThread(new QWalletHtmlOfflineConfigServiceImpl.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletHtmlOfflineConfigServiceImpl
 * JD-Core Version:    0.7.0.1
 */