package dov.com.qq.im;

import ahua;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bihe;
import bjae;
import bjbk;
import com.tencent.mobileqq.app.BaseActivity;

public class QIMJSPreFlowCameraActivity
  extends BaseActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Intent localIntent = getIntent();
    paramBundle = localIntent.getStringExtra("videoId");
    if (!TextUtils.isEmpty(paramBundle)) {}
    for (;;)
    {
      try
      {
        Integer.valueOf(paramBundle).intValue();
        super.finish();
        return true;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      ((bjbk)bjae.a(5)).f();
      int i = localIntent.getIntExtra("firsttab", 0);
      int j = localIntent.getIntExtra("secondtab", 0);
      String str = localIntent.getStringExtra("itemid");
      int k = localIntent.getIntExtra("type", 0);
      int m = localIntent.getIntExtra("direction", 1);
      int n = localIntent.getIntExtra("WebSceneType", ahua.d);
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      bihe.a(this, 4, 10007, 7, -1, i, j, paramBundle, 0, true, k, m, n, localIntent.getExtras());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMJSPreFlowCameraActivity
 * JD-Core Version:    0.7.0.1
 */