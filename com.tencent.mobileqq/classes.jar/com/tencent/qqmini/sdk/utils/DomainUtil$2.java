package com.tencent.qqmini.sdk.utils;

import android.widget.Toast;
import berp;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public final class DomainUtil$2
  implements Runnable
{
  public DomainUtil$2(int paramInt, berp paramberp) {}
  
  public void run()
  {
    Toast.makeText(MiniAppEnv.g().getContext(), bfgm.a()[this.jdField_a_of_type_Int] + "域名不合法，请配置：" + this.jdField_a_of_type_Berp, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.DomainUtil.2
 * JD-Core Version:    0.7.0.1
 */