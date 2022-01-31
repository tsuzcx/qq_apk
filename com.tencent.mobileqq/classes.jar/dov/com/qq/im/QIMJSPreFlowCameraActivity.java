package dov.com.qq.im;

import ajli;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bkjr;
import blmf;
import blnl;
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
      ((blnl)blmf.a(5)).f();
      int i = localIntent.getIntExtra("firsttab", 0);
      int j = localIntent.getIntExtra("secondtab", 0);
      String str = localIntent.getStringExtra("itemid");
      int k = localIntent.getIntExtra("type", 0);
      int m = localIntent.getIntExtra("direction", 1);
      int n = localIntent.getIntExtra("WebSceneType", ajli.d);
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      bkjr.a(this, 4, 10007, 7, -1, i, j, paramBundle, 0, true, k, m, n, localIntent.getExtras());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMJSPreFlowCameraActivity
 * JD-Core Version:    0.7.0.1
 */